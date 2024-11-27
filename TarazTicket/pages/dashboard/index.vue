<template>
  <b-card
    ref="card"
    header-tag="header"
    footer-tag="footer"
    header-class="t-card-header"
    body-class="t-card-body"
    class="t-card"
  >
    <b-overlay v-if="retrieving" id="t-loading-rows" show no-wrap />
    <b-row class="mt-3">
      <!-- start item one -->
      <b-col v-if="!isCustomer" lg="2" sm="6" cols="24">
        <!-- start card aamar -->
        <b-card header-class="t-card-box-header" body-class="t-card-box-body">
          <template #header>
            <font-awesome-icon icon="chart-bar" />
            <span>آمار و اطلاعات</span>
          </template>
          <b-card-text class="t-card-text">
            <strong>اطلاعات سازمان:</strong>
            <b-list-group>
              <b-list-group-item class="t-list-group-item">
                دپارتمان ها
                <h5>
                  <b-badge>
                    {{ analyzed.departments }}
                  </b-badge>
                </h5>
              </b-list-group-item>

              <b-list-group-item class="t-list-group-item">
                کارمندان
                <h5>
                  <b-badge class="btn-number-list-group">
                    {{ analyzed.staff }}
                  </b-badge>
                </h5>
              </b-list-group-item>
            </b-list-group>
            <br>
            <strong>مشتریان:</strong>
            <b-list-group>
              <b-list-group-item class="t-list-group-item">
                مشتریان حقوقی
                <h5>
                  <b-badge class="btn-number-list-group">
                    {{ analyzed.organizations }}
                  </b-badge>
                </h5>
              </b-list-group-item>

              <b-list-group-item class="t-list-group-item">
                مشتریان فعال
                <h5>
                  <b-badge class="btn-number-list-group">
                    {{ analyzed.customers }}
                  </b-badge>
                </h5>
              </b-list-group-item>
            </b-list-group>
            <br>
            <strong>تیکت های دپارتمان ها:</strong>
            <b-list-group>
              <b-list-group-item class="t-list-group-item">
                مجموع تیکت های دریافتی
                <h5>
                  <b-badge class="btn-number-list-group-ticket-sea">
                    {{ analyzed.receivedTicket }}
                  </b-badge>
                </h5>
              </b-list-group-item>

              <b-list-group-item class="t-list-group-item">
                تیکت های دیده نشده
                <h5>
                  <b-badge class="btn-number-list-group-ticket-sea">
                    {{ analyzed.notVisited }}
                  </b-badge>
                </h5>
              </b-list-group-item>
              <b-list-group-item class="t-list-group-item">
                تیکت های باز
                <h5>
                  <b-badge variant="warning">
                    {{ analyzed.openTicket }}
                  </b-badge>
                </h5>
              </b-list-group-item>
              <b-list-group-item class="t-list-group-item">
                تیکت های در حال بررسی
                <h5>
                  <b-badge variant="danger">
                    {{ analyzed.inProgressTicket }}
                  </b-badge>
                </h5>
              </b-list-group-item>
              <b-list-group-item class="t-list-group-item">
                پاسخ داده شده
                <h5>
                  <b-badge variant="info">
                    {{ analyzed.answeredTicket }}
                  </b-badge>
                </h5>
              </b-list-group-item>
              <b-list-group-item class="t-list-group-item">
                پاسخ ایجاد کننده تیکت
                <h5>
                  <b-badge variant="info">
                    {{ analyzed.answeredByFounderTicket }}
                  </b-badge>
                </h5>
              </b-list-group-item>
              <b-list-group-item class="t-list-group-item">
                تیکت های بسته شده
                <h5>
                  <b-badge variant="success">
                    {{ analyzed.closedTicket }}
                  </b-badge>
                </h5>
              </b-list-group-item>
            </b-list-group>
          </b-card-text>
        </b-card>
        <!-- </b-container> -->
      </b-col>

      <!-- start item two -->
      <b-col v-if="!isCustomer" lg="5" sm="6" cols="24">
        <b-card header-class="t-card-box-header" body-class="t-card-box-body">
          <template #header>
            <font-awesome-icon icon="chart-pie" />
            <span>
              تیکت های ارسالی (مدیر ارشد / دپارتمان ها) (۱۰ روز گذشته)</span>
          </template>
          <b-card-text class="text-card-info">
            <!-- start itme one -->
            <t-bar
              id="tbar_ticketnumber_staff"
              height="400px"
              title="فراوانی تیکت ها"
              resource-data="tkt/ticketfrequencyreport/forstaff/chart"
              :y-axis="{
                title: 'فراوانی',
                fields: [{ name: 'Frequency', title: 'فراوانی' }]
              }"
              :x-axis="{
                title: 'تاریخ',
                fieldName: 'PersianStr'
              }"
              :show-data-labels="true"
            />
            <hr>
            <t-bar
              id="tbar_ticketstatus_staff"
              height="400px"
              title="وضعیت تیکت"
              resource-data="tkt/ticketstatusreport/forstaff/chart"
              :y-axis="{
                title: 'فراوانی',
                fields: [{ name: 'Frequency', title: 'فراوانی' }]
              }"
              :x-axis="{
                title: 'وضعیت',
                fieldName: 'MDesc'
              }"
            />
            <hr>
            <t-donut
              id="tdonut_priority_staff"
              title="درجه اهمیت"
              height="400px"
              resource-data="tkt/ticketpriorityreport/forstaff/chart"
              :y-axis="{
                title: 'فراوانی',
                fields: [{ name: 'Frequency', title: 'فراوانی' }]
              }"
              :x-axis="{
                title: 'وضعیت',
                fieldName: 'MDesc'
              }"
            />
            <hr>
            <t-donut
              id="tdonut_satisfaction_staff"
              title="میزان رضایت"
              height="400px"
              resource-data="tkt/ticketsatisfactionreport/forstaff/chart"
              :y-axis="{
                title: 'فراوانی',
                fields: [{ name: 'Frequency', title: 'فراوانی' }]
              }"
              :x-axis="{
                title: 'وضعیت',
                fieldName: 'MDesc'
              }"
            />
          </b-card-text>
        </b-card>
      </b-col>

      <!-- start item three -->
      <b-col :lg="isCustomer ? '12' : '5'" sm="6" cols="24">
        <b-card header-class="t-card-box-header" body-class="t-card-box-body">
          <template #header>
            <font-awesome-icon icon="chart-pie" />
            <span>تیکت های ارسالی (مشتریان) (۱۰ روز گذشته)</span>
          </template>
          <b-card-text class="text-card-info">
            <!-- start itme one -->
            <t-bar
              id="tbar_ticketnumber_customer"
              height="400px"
              title="فراوانی تیکت ها"
              resource-data="tkt/ticketfrequencyreport/forcustomer/chart"
              :y-axis="{
                title: 'فراوانی',
                fields: [{ name: 'Frequency', title: 'فراوانی' }]
              }"
              :x-axis="{
                title: 'تاریخ',
                fieldName: 'PersianStr'
              }"
              :show-data-labels="true"
            />
            <hr>
            <t-bar
              id="tbar_ticketstatus_customer"
              height="400px"
              title="وضعیت تیکت"
              resource-data="tkt/ticketstatusreport/forcustomer/chart"
              :y-axis="{
                title: 'فراوانی',
                fields: [{ name: 'Frequency', title: 'فراوانی' }]
              }"
              :x-axis="{
                title: 'وضعیت',
                fieldName: 'MDesc'
              }"
            />
            <hr>
            <t-donut
              id="tdonut_priority_customer"
              title="درجه اهمیت"
              height="400px"
              resource-data="tkt/ticketpriorityreport/forcustomer/chart"
              :y-axis="{
                title: 'فراوانی',
                fields: [{ name: 'Frequency', title: 'فراوانی' }]
              }"
              :x-axis="{
                title: 'وضعیت',
                fieldName: 'MDesc'
              }"
            />
            <hr>
            <t-donut
              id="tdonut_satisfaction_customer"
              title="میزان رضایت"
              height="400px"
              resource-data="tkt/ticketsatisfactionreport/forcustomer/chart"
              :y-axis="{
                title: 'فراوانی',
                fields: [{ name: 'Frequency', title: 'فراوانی' }]
              }"
              :x-axis="{
                title: 'وضعیت',
                fieldName: 'MDesc'
              }"
            />
          </b-card-text>
        </b-card>
      </b-col>
    </b-row>
  </b-card>
</template>

<script>
// import TArea from '@/components/chart/TArea.vue'
import { mapGetters } from 'vuex'
import TBar from '@/components/chart/TBar.vue'
import TDonut from '@/components/chart/TDonut.vue'

export default {
  components: {
    // TArea,
    TBar,
    TDonut
  },
  data () {
    return {
      title: 'داشبورد',
      retrieving: false,
      analyzed: {}
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
    filterParamsـinvreportreviewl1_8 () {
      // گزارش موجودی کالا به تفکیک انبار
      const srIDs = 1
      const yearID = 10000020
      const fromDate = '1400/01/01'
      const toDate = '1400/12/12'
      const repType = 8
      return {
        srIDs,
        yearID,
        fromDate,
        toDate,
        repType
      }
    }
  },
  async created () {
    await this.retrieveData()
  },
  methods: {
    async retrieveData () {
      // واکشی دیتا( سطرها) از سرور
      this.retrieving = true
      const filterParams = {}
      filterParams.pageNumber = 1
      filterParams.recordCount = 1
      const response = await this.$taxios.get('tkt/analysis', filterParams)
      this.analyzed = response.data[0]
      this.retrieving = false
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
    z-index: 2;
    height: $cardHeaderHeight;
    position: sticky;
    top: $menuHeight;
    background-color: var(--t-color-0-96);
    display: flex;
    flex-direction: row;
    justify-content: space-between;
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
  .t-card-box-header {
    font-family: 'IRANSansX';
    background-color: #dcdcdc;
    font-size: 1rem;
  }
  .t-card-box-body {
    font-family: 'IRANSansX';
    font-size: 0.9rem;
    .t-list-group-item {
      display: flex;
      flex-direction: row;
      justify-content: space-between;
      align-items: center;
      h5 {
        font-family: tahoma;
      }
    }
  }
  .text-card-info {
    font-size: 13px;
  }
  .card-info {
    background-color: #dff0d8;
    display: flex;
  }

  .btn-number-list-group-ticket-sea {
    background-color: #999999;
  }
  .btn-tickets {
    height: 32px;
    font-size: 13px;
  }
  .btn-ticket-color {
    background-color: #265a88;
  }
}
</style>
