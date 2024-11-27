<!-- eslint-disable vue/valid-v-slot -->
<template>
  <div v-if="resIsLaptop()">
    <t-grid-view
      id="TktTickets"
      :title="title"
      resource-data="tkt/tickets"
      resource-meta="tkt/tickets/meta"
      main-field-name="ticketTitle"
      :filter-params="filterParams"
      :has-col-index="false"
      :has-col-active="false"
      :has-col-delete="false"
      :has-col-edit="false"
      :has-col-refresh="true"
      @onClearFilter="onClearFilter"
    >
      <template #filterElemets>
        <t-text-box-string
          id="ticketTitle"
          v-model="filterParams.ticketTitle"
          label="عنوان"
        />

        <t-combo-box
          id="ticketCategoryID"
          v-model="filterParams.ticketCategoryID"
          label="دسته بندی"
          :filter-params="filterParamsCategories"
          resource-data="tkt/ticketcategories"
          resource-meta="tkt/ticketcategories/meta"
          main-field-name="ticketCategoryName"
        />

        <t-text-box-integer
          id="ticketNumber"
          v-model="filterParams.ticketNumber"
          label="شماره تیکت"
        />

        <t-combo-box
          v-if="isCustomer === false"
          id="fromDepartmentID"
          v-model="filterParams.fromDepartmentID"
          label="از دپارتمان"
          :filter-params="filterParamsDepartments"
          resource-data="tkt/departments"
          resource-meta="tkt/departments/meta"
          main-field-name="departmentName"
        />

        <!-- <t-combo-box
          v-if="isCustomer === false"
          id="fromOrganizationID"
          v-model="filterParams.fromOrganizationID"
          label="از شرکت"
          resource-data="tkt/organizations"
          resource-meta="tkt/organizations/meta"
          main-field-name="organizationName"
        /> -->

        <t-text-box-string
          id="fromOrganizationName"
          v-model="filterParams.fromOrganizationName"
          label="از شرکت"
        />

        <t-combo-box
          v-if="isCustomer === false"
          id="fromUserID"
          v-model="filterParams.fromUserID"
          label="از کاربر"
          resource-data="acc/percoms"
          resource-meta="acc/percoms/meta"
          main-field-name="perComName"
        />

        <t-combo-box
          v-if="isCustomer === false"
          id="toDepartmentID"
          v-model="filterParams.toDepartmentID"
          label="به دپارتمان"
          :filter-params="filterParamsDepartments"
          resource-data="tkt/departments"
          resource-meta="tkt/departments/meta"
          main-field-name="departmentName"
        />

        <!-- <t-combo-box
          v-if="isCustomer === false"
          id="toOrganizationID"
          v-model="filterParams.toOrganizationID"
          label="به شرکت"
          resource-data="tkt/organizations"
          resource-meta="tkt/organizations/meta"
          main-field-name="organizationName"
        /> -->

        <t-text-box-string
          id="toOrganizationName"
          v-model="filterParams.toOrganizationName"
          label="به شرکت"
        />

        <t-combo-box
          v-if="isCustomer === false"
          id="toUserID"
          v-model="filterParams.toUserID"
          label="به کاربر"
          resource-data="acc/percoms"
          resource-meta="acc/percoms/meta"
          main-field-name="perComName"
        />

        <t-combo-box
          id="statusID"
          v-model="filterParams.statusID"
          label="وضعیت"
          resource-data="tkt/statuses"
          resource-meta="tkt/statuses/meta"
          main-field-name="statusTitle"
        />
        <t-combo-box
          id="priorityID"
          v-model="filterParams.priorityID"
          label="اهمیت"
          resource-data="tkt/priorities"
          resource-meta="tkt/priorities/meta"
          main-field-name="priorityName"
        />
        <t-combo-box
          id="satisfactionID"
          v-model="filterParams.satisfactionID"
          label="رضایت"
          resource-data="tkt/satisfactions"
          resource-meta="tkt/satisfactions/meta"
          main-field-name="satisfactionName"
        />

        <t-text-box-date
          id="createDate"
          v-model="filterParams.createDate"
          label="تاریخ ایجاد"
        />

        <t-text-box-date
          id="modifyDate"
          v-model="filterParams.modifyDate"
          class="t-td-refresh"
          label="تاریخ به روز رسانی"
        />

        <t-combo-box
          v-if="false"
          id="isVisited"
          v-model="filterParams.isVisited"
          label="وضعیت دیده شدن تیکت"
          resource-data="tkt/tickets/visitstatus"
          resource-meta="tkt/tickets/visitstatus/meta"
          main-field-name="visitStatus"
        />
      </template>
    </t-grid-view>
  </div>
  <div v-else>
    <TListView
      id="TktTickets"
      :title="title"
      resource-data="tkt/tickets"
      resource-meta="tkt/tickets/meta"
      main-field-name="ticketTitle"
      :filter-params="filterParams"
      :has-col-index="false"
      :has-delete="false"
      :has-edit="false"
      @onClearFilter="onClearFilter"
    >
      <template #resFilterElemets>
        <t-text-box-string
          id="ticketTitle"
          v-model="filterParams.ticketTitle"
          label="عنوان"
        />

        <t-combo-box
          id="ticketCategoryID"
          v-model="filterParams.ticketCategoryID"
          label="دسته بندی"
          :filter-params="filterParamsCategories"
          resource-data="tkt/ticketcategories"
          resource-meta="tkt/ticketcategories/meta"
          main-field-name="ticketCategoryName"
        />

        <t-text-box-integer
          id="ticketNumber"
          v-model="filterParams.ticketNumber"
          label="شماره تیکت"
        />
      </template>
    </TListView>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import common from '@/assets/common'
import TGridView from '@/components/gridview/TGridView.vue'
import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'
import TTextBoxInteger from '~/components/dataentry/TTextBoxInteger.vue'
import TComboBox from '~/components/dataentry/TComboBox.vue'
import TTextBoxDate from '~/components/dataentry/TTextBoxDate.vue'
import TListView from '~/components/listview/TListView.vue'

export default {
  name: 'Tickets',
  components: {
    TGridView,
    TTextBoxString,
    TTextBoxInteger,
    TComboBox,
    TTextBoxDate,
    TListView
  },
  data () {
    return {
      title: 'لیست تیکت ها',
      filterParams: {}
    }
  },
  head () {
    return {
      title: this.title
    }
  },
  computed: {
    ...mapGetters({
      isCustomer: '_user/IS_CUSTOMER'
    }),
    filterParamsDepartments () {
      return { filter: 'DepartmentID NOT IN (1,2)' }
    },
    filterParamsCategories () {
      return { filter: "ticketCategoryName <> 'سایر'" }
    }
  },
  created () {
    this.filterParams = Object.assign({}, this.filterParams, this.$route.params)
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
