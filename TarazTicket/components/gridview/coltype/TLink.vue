<template>
  <a :id="id" :href="href" class="t-container-link" target="_blank">
    {{ value }}
  </a>
  <!-- <NuxtLink
    to=""
    :href="value"
    class="t-container-link"
    target="_blank"
    rel="noopener"
    external
  >
    {{ value }}
  </NuxtLink> -->
</template>

<script>
export default {
  name: 'TLink',
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
  computed: {
    href () {
      if (this.value == null) {
        return ''
      }
      if (this.value.startsWith('http')) {
        return this.value
      }
      return 'http://' + this.value
    }
  }
}
</script>
<style lang="scss" scoped>
.t-container-link {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  word-break: break-word;
  margin: 15px;
  font-size: 0.85rem;
  border-radius: 4px;
  // color: gray;
}
</style>
