<template>
  <terminal
      class="terminal"
      name="terminal"
      title="terminal"
      :init-log=null
      :commandStore="[]"
      :enable-example-hint=false
      :context="context"
      @execCmd="onExecCmd"
      :warn-log-count-limit=-1
      :show-handler=false
      :drag-conf="{width: 700, height: 500, init:{ x: 230, y: 80}}"
  >
  </terminal>
  <terminal
      class="terminal"
      name="log"
      title="log"
      :init-log=log
      :commandStore="[]"
      :enable-example-hint=false
      :context="context"
      @execCmd="onExecCmd"
      :warn-log-count-limit=-1
      :show-handler=false
      :drag-conf="{width: 900, height: 850,zIndex:99, init:{ x: 950, y: 45}}"
  >
  </terminal>
</template>

<script lang="ts" setup>
import Terminal from 'vue-web-terminal'
import {getStore} from "@/conf/store";
import {ShellMessageVo} from "@/entity/vo/shellVo";
import {LogDto} from "@/entity/dto/shellDto";
import {onBeforeMount, onMounted, onUnmounted} from "vue";
import {getWsUrl} from "@/request/shellRequest";
import {getBaseUrl, getRawBaseUrl} from "@/conf/applicationConfiguration";

const context = localStorage.getItem('loginUserName') + '(' + localStorage.getItem('loginRegisterId') + ')';
const log = [{type: 'normal', message: "this terminal show logs"}];

let wsUrl = '';
// let wsUrl = 'ws://127.0.0.1:4901/ws/shell';
let webSocket: WebSocket | undefined;

async function initWsUrl() {
  wsUrl = await getWsUrl().then(vo => 'ws://' + getRawBaseUrl() + vo.data.wsUrl);
  reConnection();
}


onMounted(async () => {
  //调用方法
  await initWsUrl()
});

function reConnection() {
  webSocket = new WebSocket(wsUrl);
  webSocket.onerror = function (e) {
    Terminal.$api.pushMessage('terminal', {type: 'normal', content: 'connection error!'});
    reConnection();
  }
  webSocket.onclose = function () {
    Terminal.$api.pushMessage('terminal', {
      type: 'normal',
      content: 'server broken link, press enter to reConnection.'
    });
    reConnection();
  }
  webSocket.onmessage = function (res) {
    const messageVo: ShellMessageVo = JSON.parse(res.data);
    if (messageVo.type == 0) {
      const logDto: LogDto = JSON.parse(messageVo.msg);
      let level = logDto.level.toString();
      let color;
      switch (logDto.level) {
        case "INFO":
          color = 'white';
          level = "INFO "
          break;
        case "WARN":
          color = 'red';
          level = "WARN "
          break;
        case "DEBUG":
          color = 'grey';
          break;
        case "ERROR":
          color = 'red';
          break;
        case "TRACE":
          color = 'grey';
          break;
      }
      const msg = "<span style='color:" + color + "'> " + level + "    </span><span style='color: " + color + "'>" + logDto.msg + "</span>";
      Terminal.$api.pushMessage('log', {type: 'html', content: msg});
    } else {
      Terminal.$api.pushMessage('terminal', {type: 'html', content: messageVo.msg});
    }
  }
}


onUnmounted(() => {
  if (webSocket) {
    webSocket.close(3001, 'user leave');
  }
})

/**
 * 当用户输入自定义命令时调用
 *
 * @param key     命令行key，用于唯一标识
 * @param command 命令行
 * @param success 成功回调
 * @param failed  失败回调
 */
const onExecCmd = function (key: any, command: any, success: any, failed: any) {
  if (!webSocket) {
    return;
  }
  let isOpen = webSocket.readyState == webSocket.OPEN;
  if (!isOpen) {
    reConnection();
    success('reConnection');
    return;
  }
  webSocket.send(command);
  success();
}


</script>

<style lang="scss" scoped>

.terminal :deep {
  .t-ask-input, .t-window, .t-window div, .t-window p {
    text-align: left;
    font-family: "Consolas", "Microsoft YaHei", "Avenir", "Helvetica", "Arial", "sans-serif";

    white-space: pre-line;
  }
}

</style>