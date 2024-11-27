<template>
  <span
    :id="id"
    class="t-color"
    :style="`background-color: ${value}`"
  >&nbsp;</span>
</template>

<script>
export default {
  name: 'TColor',
  props: {
    id: {
      type: String,
      default: null
    },
    value: {
      type: String,
      default: null
    }
  },
  computed: {}
}
</script>
<style lang="scss" scoped>
.t-color {
  // border: 1px solid black;
  width: 10px;
  height: 10px;
  border-radius: 50%;
}
</style>
