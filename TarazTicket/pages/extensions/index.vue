<template>
  <under-construction />
</template>

<script>
import UnderConstruction from '~/components/general/UnderConstruction.vue'
export default {
  name: 'Extensions',
  components: { UnderConstruction },
  data () {
    return {
      title: 'افزونه ها',
      filterParams: {}
    }
  },
  head () {
    return {
      title: this.title
    }
  },
  created () {},
  methods: {
    onClearFilter () {
      this.filterParams = {}
    }
  }
}
</script>
<style lang="scss" scoped></style>
