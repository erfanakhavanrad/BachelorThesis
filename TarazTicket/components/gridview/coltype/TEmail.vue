<template>
  <code :id="id" class="t-container-email">
    {{ value }}
  </code>
</template>

<script>
export default {
  name: 'TEmail',
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
.t-container-email {
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
  word-break: break-word;
  margin: 15px;
  font-size: 0.85rem;
  border-radius: 4px;
  color: gray;
}
</style>
