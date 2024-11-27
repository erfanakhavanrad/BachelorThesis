<template>
  <div v-if="resIsLaptop()">
    <t-grid-view
      id="TktOrganizations"
      :title="title"
      resource-data="tkt/organizations"
      resource-meta="tkt/organizations/meta"
      main-field-name="organizationName"
      :filter-params="filterParams"
      :has-col-active="false"
      :has-col-delete="true"
      :has-col-edit="true"
      :has-col-menu-access="true"
      @onClearFilter="onClearFilter"
    >
      <template #filterElemets>
        <t-text-box-string
          id="organizationName"
          v-model="filterParams.organizationName"
          label="عنوان"
        />

        <t-text-box-string
          id="organizationPhoneNumber"
          v-model="filterParams.organizationPhoneNumber"
          label="تلفن ثابت"
        />

        <t-jalali-calendar
          id="expirationDate"
          v-model="filterParams.expirationDate"
          label="اتمام دسترسی"
        />

        <t-combo-box
          id="priorityID"
          v-model="filterParams.priorityID"
          label="درجه اهمیت"
          resource-data="tkt/priorities"
          resource-meta="tkt/priorities/meta"
          main-field-name="priorityName"
        />
      </template>
    </t-grid-view>
  </div>
  <div v-else>
    <TListView
      id="TktOrganizations"
      :title="title"
      resource-data="tkt/organizations"
      resource-meta="tkt/organizations/meta"
      main-field-name="organizationName"
      :filter-params="filterParams"
      :has-col-index="true"
      :has-delete="true"
      :has-edit="true"
      @onClearFilter="onClearFilter"
    >
      <template #resFilterElemets>
        <t-text-box-string
          id="organizationName"
          v-model="filterParams.organizationName"
          label="عنوان"
        />
      </template>
    </TListView>
  </div>
</template>

<script>
import common from '@/assets/common'
import TGridView from '@/components/gridview/TGridView.vue'
import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'
import TComboBox from '~/components/dataentry/TComboBox.vue'
import TListView from '~/components/listview/TListView.vue'
import TJalaliCalendar from '~/components/dataentry/TJalaliCalendar.vue'

export default {
  name: 'Organizations',
  components: {
    TGridView,
    TTextBoxString,
    TComboBox,
    TListView,
    TJalaliCalendar
  },
  data () {
    return {
      title: 'مشتریان حقوقی',
      filterParams: { filter: 'OrganizationID NOT IN (10000000)' }
    }
  },
  head () {
    return {
      title: this.title
    }
  },
  created () {
    this.filterParams = Object.assign({}, this.filterParams, this.$route.params)
  },
  methods: {
    onClearFilter () {
      this.filterParams = { filter: 'OrganizationID NOT IN (10000000)' }
    },
    resIsLaptop () {
      return common.isLargeScreen()
    }
  }
}
</script>
<style lang="scss" scoped></style>
