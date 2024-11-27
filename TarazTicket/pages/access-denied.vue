<template>
  <div id="t-container-accessdenied">
    access-denied
  </div>
</template>

<script>
export default {
  name: 'AccessDenied',
  data () {
    return {}
  }
}
</script>

<style lang="scss" scoped>
#t-container-accessdenied {
  font-family: 'IRANSansX';
  font-size: larger;
  font-weight: bold;
  color: red;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  height: calc(100vh - 180px);
  span {
    padding-right: 1rem;
  }
}
</style>
