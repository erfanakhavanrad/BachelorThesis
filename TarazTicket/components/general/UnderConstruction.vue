<template>
  <div class="t-container-under-construction">
    <font-awesome-icon icon="hard-hat" size="10x" />
    <span>در دست ساخت</span>
  </div>
</template>

<script>
export default {
  name: 'UnderConstruction'
}
</script>
<style lang="scss" scoped>
.t-container-under-construction {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  flex-basis: 100;
  flex-grow: 1;
}
</style>
