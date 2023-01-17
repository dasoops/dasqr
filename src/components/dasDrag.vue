<template>
  <div class="dragg">
    <draggable
        v-model="list"
        class="list-group"
        @change="$emit('dataChange',list)"
        v-bind="{
          animation: 100,
          group: 'description',
          disabled: false,
          ghostClass: 'ghost',
          dragClass: 'drag'
        }"
        item-key="name"
        chosen-class="chosen"
        force-fallback="true"
        animation="300"
    >
      <template #item="{ element, index }">
        <div class="item-single">
          <el-row style="height: 100%">
            <el-col :span="4">
              {{ index }}.
            </el-col>
            <el-col :span="20" style="text-align: left">
              {{ element.name }}({{ element.description }})
            </el-col>
          </el-row>
        </div>
      </template>
    </draggable>
  </div>

</template>

<script>

import draggable from "vuedraggable";


export default {
  name: "dasDrag",
  display: "Transitions",
  order: 15,
  components: {
    draggable
  },
  props: {sortDataList: Array},
  data() {
    return {
      list: this.sortDataList,
      drag: true,
    };
  },
  methods: {
    sort() {
      this.list = this.list.sort((a, b) => a.order - b.order);
    }
  },
  computed: {
    dragOptions() {
      return {
        animation: 200,
        group: "description",
        disabled: true,
        ghostClass: "ghost",
        dragClass: "drag",
      };
    }
  }
};
</script>

<style lang="scss">
.list-group {
  color: white;

  .ghost {
    //color: greenyellow;
    color: rgba(173, 255, 47, 1);
    border: 1px solid greenyellow;
  }
  .drag {
    color: rgba(173, 255, 47, 0.2);
    border: 1px solid greenyellow;
  }

  .item-single {
    height: 40px;
    line-height: 40px;
    border: 1px solid white;
    font-size: 20px;
    border-radius: 3px;
    cursor: move;
  }
}

</style>