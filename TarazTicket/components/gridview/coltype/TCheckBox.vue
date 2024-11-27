<template>
  <span id="t-container">
    <input :id="id" disabled type="checkbox" :checked="value">
  </span>
</template>

<script>
export default {
  name: 'TCheckBox',
  props: {
    id: {
      type: String,
      default: null
    },
    value: {
      type: Boolean,
      default: false
    }
  },
  computed: {}
}
</script>
<style lang="scss" scoped>
#t-container {
  display: flex;
  flex-direction: row;
  justify-content: center;
}
</style>
