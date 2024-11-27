<template>
  <div id="t-container-error">
    <h1>
      <font-awesome-icon :icon="icon" size="lg" />
    </h1>
    <span><h4>{{ error.message }}</h4></span>
  </div>
</template>
<script>
export default {
  props: {
    error: {
      type: Object,
      default () {
        return {}
      }
    }
  },
  head () {
    return {
      title: this.error.message
    }
  },
  computed: {
    icon () {
      switch (this.error.statusCode) {
        case 403:
          return 'ban'
        case 404:
          return 'exclamation-triangle'

        default:
          return ''
      }
    }
  }
}
</script>
<style lang="scss" scoped>
#t-container-error {
  font-family: 'IRANSansX';
  font-size: larger;
  font-weight: bold;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  height: calc(100vh - 180px);
  h1 {
    color: gray;
  }
  span {
    padding-right: 1rem;
    color: hsl(0, 0%, 50%);
  }
}
</style>
