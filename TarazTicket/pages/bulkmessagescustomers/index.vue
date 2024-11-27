<template>
  <under-construction />
</template>

<script>
import UnderConstruction from '~/components/general/UnderConstruction.vue'
export default {
  name: 'Bulkmessagescustomers',
  components: { UnderConstruction },
  data () {
    return {
      title: 'ارسال ایمیل گروهی',
      filterParams: {},
      SystemTitle: null
    }
  },
  head () {
    return {
      title: this.retrieveTitle()
    }
  },
  async created () {
    await this.retrieveData()
  },
  methods: {
    onClearFilter () {
      this.filterParams = {}
    },
    async retrieveData () {
      // واکشی دیتا( سطرها) از سرور
      const filterParams = {}
      filterParams.pageNumber = 1
      filterParams.recordCount = 1
      const response = await this.$taxios.get('tkt/settings/', filterParams)
      this.SystemTitle = response.data[0].systemTitle
    },
    retrieveTitle () {
      if (this.SystemTitle != null) {
        return this.title + ' |' + this.SystemTitle
      } else {
        return this.title
      }
    }
  }
}
</script>
<style lang="scss" scoped></style>
