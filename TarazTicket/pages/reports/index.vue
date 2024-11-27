<template>
  <b-card
    ref="card"
    header-tag="header"
    footer-tag="footer"
    header-class="card-welcom"
    body-class="t-card-body"
    class="t-card"
  >
    <template #header>
      <font-awesome-icon icon="chart-bar" size="lg" />
      <span class="mr-1">گزارشات </span>
    </template>
    <b-card-text class="text-card-info">
      <b-row>
        <b-col lg="4" sm="6" cols="12">
          <t-text-box-date
            id="fromDate"
            v-model="filterParams.fromDate"
            :rules="rules.fromDate"
            label="از تاریخ"
          />
        </b-col>
        <b-col lg="4" sm="6" cols="12">
          <t-text-box-date
            id="toDate"
            v-model="filterParams.toDate"
            :rules="rules.toDate"
            label="تا تاریخ"
          />
        </b-col>
        <!-- <b-col lg="4" sm="6" cols="12">
          <t-text-box-string
            id="userName"
            v-model="filterParams.userName"
            :rules="rules.userName"
            label="فرستنده تیکت"
          />
        </b-col> -->
      </b-row>
      <b-row>
        <b-col lg="3" sm="6" cols="12">
          <t-combo-box
            id="organizationID"
            v-model="filterParams.organizationID"
            :rules="rules.organizationID"
            label="سازمان مالک تیکت"
            resource-data="tkt/organizations"
            resource-meta="tkt/organizations/meta"
            main-field-name="organizationName"
          />
        </b-col>
        <b-col lg="3" sm="6" cols="12">
          <t-combo-box
            id="customerID"
            v-model="filterParams.customerID"
            :rules="rules.customerID"
            label="مشتری فرستنده تیکت"
            resource-data="tkt/customers"
            resource-meta="tkt/customers/meta"
            main-field-name="userName"
          />
        </b-col>
        <b-col lg="3" sm="6" cols="12">
          <t-combo-box
            v-if="isShowFromDepartmentID"
            id="departmentID"
            v-model="filterParams.departmentID"
            :rules="rules.departmentID"
            :filter-params="filterParamsDepartments"
            label="دپارتمان گیرنده تیکت"
            resource-data="tkt/departments"
            resource-meta="tkt/departments/meta"
            main-field-name="departmentName"
          />
        </b-col>
        <b-col lg="3" sm="6" cols="12">
          <t-combo-box
            id="staffID"
            v-model="filterParams.staffID"
            :rules="rules.staffID"
            label="کارمند گیرنده تیکت"
            resource-data="tkt/staff"
            resource-meta="tkt/staff/meta"
            main-field-name="userName"
          />
          <!-- :resource-data="resourceDataStaff" -->
        </b-col>
      </b-row>
      <b-button-group size="sm" class="button-search-reset">
        <div>
          <b-button title="تنظیمات اولیه" size="sm" @click="onSetting">
            <span>تنظیمات اولیه</span>
            <font-awesome-icon icon="sync-alt" size="sm" />
          </b-button>
        </div>
        <div>
          <b-button variant="primary" title="جستجو" size="sm" @click="onFilter">
            <span>مشاهده گزارش ها</span>
            <font-awesome-icon icon="check" size="sm" />
          </b-button>
        </div>
      </b-button-group>
      <hr>
      <p class="text-center text-counter-ticket">
        <!-- تعداد کل تیکت های پیدا شده : {{ frequencySum }} -->
        <!-- تعداد کل تیکت های پیدا شده : 0 -->
        <!-- {{ this.response.frequencySum }} -->
        <!-- khers -->
        <!-- {{ this.response.frequencySum}} -->
      </p>

      <b-row class="mt-5">
        <b-col lg="6" cols="12">
          <t-bar
            id="tbar_ticketfrequencyreport"
            ref="tbar_ticketfrequencyreport"
            height="400px"
            title="فراوانی تیکت ها"
            resource-data="tkt/ticketfrequencyreport/chart"
            :filter-params="filterParams"
            :y-axis="{
              title: 'فراوانی',
              fields: [{ name: 'Frequency', title: 'فراوانی' }]
            }"
            :x-axis="{
              title: 'تاریخ',
              fieldName: 'PersianStr'
            }"
            :show-data-labels="true"
            async
            @onChangedYValuesSum="onChangedYValuesSum"
          />
        </b-col>
        <b-col lg="6" cols="12">
          <t-bar
            id="tbar_ticketstatusreport"
            ref="tbar_ticketstatusreport"
            height="400px"
            title="وضعیت تیکت ها"
            resource-data="tkt/ticketstatusreport/chart"
            :filter-params="filterParams"
            :y-axis="{
              title: 'فراوانی',
              fields: [{ name: 'Frequency', title: 'فراوانی' }]
            }"
            :x-axis="{
              title: 'وضعیت',
              fieldName: 'MDesc'
            }"
            :show-data-labels="true"
            async
          />
        </b-col>
      </b-row>
      <b-row>
        <b-col lg="6" cols="12">
          <t-donut
            id="tdonut_ticketpriorityreport"
            ref="tdonut_ticketpriorityreport"
            title="درجه اهمیت"
            height="400px"
            resource-data="tkt/ticketpriorityreport/chart"
            :filter-params="filterParams"
            :y-axis="{
              title: 'فراوانی',
              fields: [{ name: 'Frequency', title: 'فراوانی' }]
            }"
            :x-axis="{
              title: 'وضعیت',
              fieldName: 'MDesc'
            }"
            async
          />
        </b-col>
        <b-col lg="6" cols="12">
          <t-donut
            id="tdonut_ticketsatisfactionreport"
            ref="tdonut_ticketsatisfactionreport"
            title="میزان رضایت"
            height="400px"
            resource-data="tkt/ticketsatisfactionreport/chart"
            :filter-params="filterParams"
            :y-axis="{
              title: 'فراوانی',
              fields: [{ name: 'Frequency', title: 'فراوانی' }]
            }"
            :x-axis="{
              title: 'وضعیت',
              fieldName: 'MDesc'
            }"
            async
          />
        </b-col>
      </b-row>
    </b-card-text>
  </b-card>
</template>

<script>
import { mapGetters } from 'vuex'
import TComboBox from '~/components/dataentry/TComboBox.vue'
import TTextBoxDate from '~/components/dataentry/TTextBoxDate.vue'
// import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'
import TBar from '~/components/chart/TBar.vue'
import TDonut from '~/components/chart/TDonut.vue'

export default {
  name: 'Dashboard',
  components: { TTextBoxDate, TComboBox, TBar, TDonut },
  data () {
    return {
      title: 'گزارشات',
      frequencySum: Response.frequencySum,
      filterParams: {
        fromDate: null,
        toDate: null
        // departmentID: null,
        // organizationID: null
      },
      rules: {
        fromDate: { required: true },
        toDate: { required: true },
        // userName: { required: false },
        organizationID: { required: false },
        customerID: { required: false },
        departmentID: { required: false },
        staffID: { required: false }
      }
    }
  },
  head () {
    return {
      title: this.title
    }
  },
  computed: {
    ...mapGetters({
      perComID: '_user/GET_PERCOMID',
      isCustomer: '_user/IS_CUSTOMER',
      departmentIDs: '_user/GET_DEPARTMENTIDS',
      isAdmin: '_user/IS_ADMIN'
    }),
    filterParamsDepartments () {
      return { filter: 'DepartmentID NOT IN (1,2)' }
    },
    isShowFromDepartmentID () {
      if (this.isCustomer) {
        // اگر مشتری است نباید کمبوی از دپارتمان را ببیند
        return false
      } else if (this.isAdmin) {
        return true
      } else if (this.departmentIDs.length === 1) {
        // اگر کارمند است ولی تنها در یک
        // دپارتمان حضور دارد هم نباید کمبوی
        // از دپارتمان را ببیند
        return false
      }
      // اگر هم کارمند است و هم در بیش از یک دپارتمان حضور دارد
      // میتواند کمبوی از دپارتمان را ببیند
      return true
    },
    resourceDataFromDepartment () {
      if (this.perComID == null) {
        return null
      } else {
        return `tkt/users/${this.perComID}/departments`
      }
    },
    resourceDataStaff () {
      if (this.filterParams.departmentID == null) {
        return null
      } else {
        return 'tkt/departments/' + this.filterParams.departmentID + '/users'
      }
    }
  },
  methods: {
    onFilter () {
      if (
        this.filterParams.toDate === null ||
        this.filterParams.fromDate === null
      ) {
        // console.log('bad')
        alert('فیلدهای تاریخ اجباری هستند')
      } else {
        this.$refs.tbar_ticketfrequencyreport.retrieveData()
        this.$refs.tbar_ticketstatusreport.retrieveData()
        this.$refs.tdonut_ticketpriorityreport.retrieveData()
        this.$refs.tdonut_ticketsatisfactionreport.retrieveData()
      }
    },
    onChangedYValuesSum (yValuesSum) {
      if (yValuesSum.length === 0) {
        this.frequencySum = 0
      } else {
        this.frequencySum = yValuesSum[0]['فراوانی']
      }
    },
    onSetting () {
      // this.filterParams.userName = null
      this.filterParams.organizationID = null
      this.filterParams.customerID = null
      this.filterParams.departmentID = null
      this.filterParams.staffID = null
      this.filterParams.fromDate = null
      this.filterParams.toDate = null
    }
  }
}
</script>
<style lang="scss" scoped>
$menuHeight: 80px; // ارتفاع منوی بالای صفحه
// #region card
$cardMargin: 1rem; // مارجین کارد
$cardHeaderHeight: auto; // ارتفاع هدر کارد
$cardBodyMargin: 1rem; // مارجین بادی کارد
// #endregion

// #region actionbar
$actionbarButtonWidth: 3rem; // عرض دکمه های اکشن بار
// #endregion

// #region gridview
$colIndexWidth: 3.5rem; // عرض ستون ایندکس
$headerHeight: 3rem; // ارتفاع هدر گرید
$headerTop: calc(
  $menuHeight + $cardHeaderHeight
); // فاصله از بالا برای هدر گرید
$rowHeight: 2.5rem; // ارتفاع سطر های گرید
$colControlWidth: 3rem; // عرض ستون حذف
// #endregion

// #region filter
$filterButtonWidth: 8rem; // عرض دکمه های پنل سرچ

.t-card {
  margin: $cardMargin;
  text-align: right;
  .t-card-header {
    // z-index: 2;
    // height: $cardHeaderHeight;
    // position: sticky;
    // top: $menuHeight;
    // background-color: var(--t-color-0-96);
    // display: flex;
    // flex-direction: row;
    // justify-content: space-between;
    // border: 1px solid var(--t-color-0-80);
    #t-button-group-pagination {
      direction: ltr;
      button {
        margin-left: 4px;
        margin-right: 4px;
        width: $actionbarButtonWidth;
      }
    }
    #t-title {
      align-self: center;
      font-weight: bold;
    }
    #t-button-group-actionbar {
      direction: ltr;
      button {
        margin-left: 4px;
        margin-right: 4px;
        width: $actionbarButtonWidth;
      }
    }
  }
  .t-card-body {
    padding: $cardBodyMargin;
    #t-card-filter {
      margin: $cardMargin;
      #t-card-text-filter {
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
      }
      .t-card-filter-footer {
        display: flex;
        flex-direction: row;
        direction: ltr;
        button {
          width: $filterButtonWidth;
        }
      }
    }
  }
}
.card-welcom {
  // background-color: #dcdcdc;
  background: #e1e3e4; /* fallback for old browsers */
  background: -webkit-linear-gradient(
    to bottom,
    #f4f7f8,
    #e1e3e4
  ); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(
    to bottom,
    #f4f7f8,
    #e1e3e4
  ); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
  font-size: 13px;
  font-weight: 600;
}
.text-card-info {
  font-size: 13px;
}
.button-search-reset {
  display: flex;
  flex-direction: row;
  direction: ltr;
  justify-content: flex-end;
}
.text-counter-ticket {
  font-size: 22px;
  font-weight: 500;
}
.text-title-chart {
  font-size: 13px;
  font-weight: 600;
}
</style>
