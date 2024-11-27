<template>
  <span>
    <template v-for="(item, index) in toArray">
      <span :key="'text' + id + index" class="t-text">{{ item.text }}</span>
      <b-badge
        :key="'badge' + id + index"
        class="t-badge-value"
        :variant="item.variant"
      >
        {{ item.value }}
      </b-badge>
    </template>
  </span>
</template>

<script>
export default {
  name: 'TChip',
  props: {
    id: {
      type: String,
      default: null
    },
    value: {
      type: Object,
      default () {
        return {}
      }
    },
    infos: {
      type: Array,
      default () {
        return []
      }
    }
  },
  computed: {
    toArray () {
      // مقدار ولیو را به آرایه تبدیل میکند
      const arr = []
      Object.keys(this.value).forEach((key) => {
        const info = this.infos.find(info => info.name === key)
        arr.push({
          name: key,
          text: info.text,
          variant: info.color,
          value: this.value[key]
        })
      })
      return arr
    }
  }
}
</script>
<style lang="scss" scoped>
.t-text {
  font-size: 85%;
}
.t-badge-value {
  margin-right: 5px;
  margin-left: 25px;
  text-shadow: none;
  font-weight: normal;
}
</style>
