<template>
  <div id="div">
    <!-- v-if="generalCustomersMessage != null && generalCustomersMessage != ''" -->
    <b-alert show>
      {{ generalCustomersMessageAfterLogin }}
    </b-alert>
    <!-- <b-alert v-else show>
      خوش آمدید
    </b-alert> -->
    <!-- <div>
      <b-alert
        v-if="generalCustomersMessage != null && generalCustomersMessage != ''"
        show
      >
        {{ generalCustomersMessage }}
      </b-alert>
      <b-alert v-else show>
        خوش آمدید
      </b-alert>
    </div>
    <br>
    <div> -->
    <!-- فقط active ورش داشتم -->
    <!-- <TListView
        id="TktDefaultConversationAnswer"
        title="پاسخ های پیش فرض"
        resource-data="tkt/defaultconversationanswers"
        resource-meta="tkt/defaultconversationanswers/meta"
        has-col-active="false"
        :has-col-edit="false"
        :has-col-delete="true"
      /> -->
    <!-- </div> -->
    <!-- <br>
    <NuxtLink to="/tickets">
      Home page
    </NuxtLink> -->
  </div>
</template>

<script>
// import TListView from '~/components/listview/TListView.vue'
export default {
  name: 'Index',
  // components: { TListView },
  data () {
    return {
      generalCustomersMessageAfterLogin:
        'به سامانه تیکتینگ ترازسامانه خوش آمدید. درصورت نمایش داده نشدن منوی تیکت لطفا صفحه خود را Refresh کنید!با تشکر',
      retrieving: false,
      data: false,
      SystemTitle: null,
      title: 'صفحه اصلی'
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
    async retrieveData () {
      // واکشی دیتا( سطرها) از سرور
      const filterParams = {}
      filterParams.pageNumber = 1
      filterParams.recordCount = 1
      const response = await this.$taxios.get('tkt/settings/', filterParams)
      this.SystemTitle = response.data.systemTitle
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

<style lang="scss" scoped>
#div {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  height: calc(100vh - 180px);
  font-weight: bold;
}
</style>
