<template>
  <span v-if="resIsGridView" id="t-container">
    <font-awesome-icon
      :icon="iconName"
      size="lg"
      :class="className"
      :title="title"
    />
  </span>
  <span v-else>
    <font-awesome-icon
      :icon="iconName"
      size="lg"
      :class="className"
      :title="title"
    />
  </span>
</template>

<script>
export default {
  name: 'TIsVisited',
  props: {
    id: {
      type: String,
      default: null
    },
    value: {
      type: Boolean,
      default: false
    },
    resIsGridView: {
      type: Boolean,
      default: true
    }
  },
  computed: {
    iconName () {
      if (this.value) {
        return 'envelope-open'
      }
      return 'envelope'
    },
    className () {
      if (this.value) {
        return 't-icon-open'
      }
      return 't-icon-close'
    },
    title () {
      if (this.value) {
        return 'دیده شده'
      }
      return 'دیده نشده'
    }
  }
}
</script>
<style lang="scss" scoped>
#t-container {
  display: flex;
  flex-direction: row;
  justify-content: center;
  .t-icon-open {
    color: lightgray;
  }
  .t-icon-close {
    color: dimgray;
  }
}
</style>
