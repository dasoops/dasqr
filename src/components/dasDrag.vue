<template>
  <draggable
      v-model="list"
      item-key="name"
      chosen-class="chosen"
      force-fallback="true"
      animation="300"
  >
    <template #item="{ element, index }">
      <div class="item-single">{{ element.name }} {{ index }}</div>
    </template>
  </draggable>

</template>

<script>

import draggable from "vuedraggable";

const message = [
  "vue.draggable",
  "draggable",
  "component",
  "for",
  "vue.js 2.0",
  "based",
  "on",
  "Sortablejs"
];

export default {
  name: "dasDrag",
  display: "Transitions",
  order: 7,
  components: {
    draggable
  },
  data() {
    return {
      list: message.map((name, index) => {
        return {name, order: index + 1};
      }),
      drag: false
    };
  },
  methods: {
    sort() {
      this.list = this.list.sort((a, b) => aH.order - b.order);
    }
  },
  computed: {
    dragOptions() {
      return {
        animation: 200,
        group: "description",
        disabled: true,
        ghostClass: "ghost"
      };
    }
  }
};
</script>

<style>
/*.button {*/
/*  margin-top: 35px;*/
/*}*/

/*.flip-list-move {*/
/*  transition: transform 0.5s;*/
/*}*/

/*.no-move {*/
/*  transition: transform 0s;*/
/*}*/

/*.ghost {*/
/*  opacity: 0.5;*/
/*  background: #c8ebfb;*/
/*}*/

/*.list-group {*/
/*  min-height: 20px;*/
/*}*/

/*.list-group-item {*/
/*  cursor: move;*/
/*}*/

/*.list-group-item i {*/
/*  cursor: pointer;*/
/*}*/
</style>