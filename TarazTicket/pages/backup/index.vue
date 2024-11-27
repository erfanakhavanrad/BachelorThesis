<template>
  <under-construction />
</template>

<script>
import UnderConstruction from '~/components/general/UnderConstruction.vue'
export default {
  name: 'Backup',
  components: { UnderConstruction },
  data () {
    return {
      title: 'پشتیبان گیری',
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
