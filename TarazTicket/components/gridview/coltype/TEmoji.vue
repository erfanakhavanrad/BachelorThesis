<template>
  <span id="t-container">
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
  name: 'TEmoji',
  props: {
    id: {
      type: String,
      default: null
    },
    value: {
      type: Boolean,
      default: false
    },
    statusID: {
      type: Number,
      default: null
    }
  },
  computed: {
    iconName () {
      switch (this.value) {
        case 'راضی':
          return 'smile'
        case 'عادی':
          return 'meh'

        case 'ناراضی':
          return 'angry'

        default:
          return ''
      }
    },
    className () {
      switch (this.value) {
        case 'راضی':
          return 't-emoji-satisfied'
        case 'عادی':
          return 't-emoji-normal'

        case 'ناراضی':
          return 't-emoji-dis-satisfied'

        default:
          return 't-emoji-default'
      }
    },
    title () {
      switch (this.value) {
        case 'راضی':
          return 'راضی'
        case 'عادی':
          return 'عادی'

        case 'ناراضی':
          return 'ناراضی'

        default:
          return 'نامشخص'
      }
    }
  }
}
</script>
<style lang="scss" scoped>
#t-container {
  display: flex;
  flex-direction: row;
  justify-content: center;
  font-size: large;

  .t-emoji-satisfied {
    color: green;
  }
  .t-emoji-normal {
    color: #f1d452;
  }
  .t-emoji-dis-satisfied {
    color: #cf1302;
  }
  .t-emoji-default {
    color: #001391;
  }
}
</style>
