<template>
  <div v-if="resIsLaptop()">
    <t-grid-view
      id="TktCustomer"
      :title="title"
      resource-data="tkt/customers"
      resource-meta="tkt/customers/meta"
      main-field-name="userName"
      :filter-params="filterParams"
      :has-col-active="false"
      :has-col-delete="true"
      :has-col-edit="true"
      :has-col-reset-pass="true"
      @onClearFilter="onClearFilter"
    >
      <template #filterElemets>
        <t-text-box-string
          id="userName"
          v-model="filterParams.userName"
          label="نام"
        />

        <!-- <t-combo-box
          id="organizationID"
          v-model="filterParams.organizationID"
          label="سازمان"
          resource-data="tkt/organizations"
          resource-meta="tkt/organizations/meta"
          main-field-name="organizationName"
        /> -->

        <t-text-box-string
          id="organizationName"
          v-model="filterParams.organizationName"
          label="سازمان"
        />
        <t-text-box-email
          id="userLoginName"
          v-model="filterParams.userLoginName"
          label="ایمیل"
        />
        <t-text-box-string
          id="customerPhoneNumber"
          v-model="filterParams.customerPhoneNumber"
          :rules="{ min: 11, max: 11 }"
          label="تلفن ثابت"
        />
        <t-text-box-string
          id="userMobileNumber"
          v-model="filterParams.userMobileNumber"
          :rules="{ min: 11, max: 11 }"
          label="شماره موبایل"
        />
      </template>
    </t-grid-view>
  </div>
  <div v-else>
    <TListView
      id="TktCustomer"
      :title="title"
      resource-data="tkt/customers"
      resource-meta="tkt/customers/meta"
      main-field-name="userName"
      :filter-params="filterParams"
      :has-col-active="false"
      :has-delete="true"
      :has-edit="true"
      @onClearFilter="onClearFilter"
    >
      <template #resFilterElemets>
        <t-text-box-string
          id="userName"
          v-model="filterParams.userName"
          label="نام"
        />
        <!-- <t-combo-box
          id="organizationID"
          v-model="filterParams.organizationID"
          label="سازمان"
          resource-data="tkt/organizations"
          resource-meta="tkt/organizations/meta"
          main-field-name="organizationName"
        /> -->

        <t-text-box-string
          id="organizationName"
          v-model="filterParams.organizationName"
          label="سازمان"
        />
        <t-text-box-string
          id="customerPhoneNumber"
          v-model="filterParams.customerPhoneNumber"
          :rules="{ min: 11, max: 11 }"
          label="تلفن ثابت"
        />
        <t-text-box-string
          id="userMobileNumber"
          v-model="filterParams.userMobileNumber"
          :rules="{ min: 11, max: 11 }"
          label="شماره موبایل"
        />
      </template>
    </TListView>
  </div>
</template>

<script>
import common from '@/assets/common'
import TGridView from '@/components/gridview/TGridView.vue'
import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'
// import TComboBox from '~/components/dataentry/TComboBox.vue'
import TTextBoxEmail from '~/components/dataentry/TTextBoxEmail.vue'
import TListView from '~/components/listview/TListView.vue'

export default {
  name: 'Customer',
  components: {
    TGridView,
    TTextBoxString,
    // TComboBox,
    TTextBoxEmail,
    TListView
  },
  data () {
    // filterParams: { organizationID: 10000001 }
    return {
      title: 'پرسنل شرکت‌ها',
      filterParams: {}
    }
  },
  head () {
    return {
      title: this.title
    }
  },
  created () {
    this.filterParams = this.$route.params
  },
  methods: {
    onClearFilter () {
      this.filterParams = {}
    },
    resIsLaptop () {
      return common.isLargeScreen()
    }
  }
}
</script>
<style lang="scss" scoped></style>
