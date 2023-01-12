<template>
  <draggable
      v-model="myArray"
      group="people"
      @start="drag=true"
      @end="drag=false"
      item-key="id">
    <template #item="{element}">
      <div>{{element.name}}</div>
    </template>
  </draggable>


</template>

<script>
import {defineComponent, reactive} from "vue";

export default defineComponent({
  name: "pluginManagerView",
  setup(){
    const myArray = [1,2,3,4,5,6]
    let drag = true;

    const dataMap = reactive({
      myArray,
      drag
    })

    return {...dataMap};
  }
})
</script>

<style scoped>

</style>