<template>
  <b-card
    ref="card"
    header-tag="header"
    footer-tag="footer"
    header-class="card-welcom"
    body-class="t-card-body"
    class="t-card"
  >
    <b-overlay v-if="retrieving" id="t-loading-rows" show no-wrap />
    <template #header>
      <font-awesome-icon icon="chart-bar" size="lg" />
      <span class="mr-1">گزارشات </span>
    </template>
    <b-card-text class="text-card-info">
      <b-row>
        <b-col lg="4" sm="6" cols="12">
          <t-text-box-date id="" label="از تاریخ" />
        </b-col>
        <b-col lg="4" sm="6" cols="12">
          <t-text-box-date id="" label="تا تاریخ" />
        </b-col>
        <b-col lg="4" sm="6" cols="12">
          <t-text-box-string id="" label="فرستنده تیکت" />
        </b-col>
      </b-row>
      <b-row>
        <b-col lg="4" sm="6" cols="12">
          <t-combo-box
            id="organizationID"
            :rules="{ required: true }"
            label="سازمان مالک تیکت"
            resource-data="tkt/organizations"
            resource-meta="tkt/organizations/meta"
            main-field-name="organizationName"
          />
        </b-col>
        <b-col lg="4" sm="6" cols="12">
          <t-combo-box
            id="departmentID"
            :rules="{ required: true }"
            label="دپارتمان گیرنده تیکت"
            resource-data="tkt/departments"
            resource-meta="tkt/departments/meta"
            main-field-name="departmentName"
          />
        </b-col>
      </b-row>
      <b-button-group size="sm" class="button-search-reset">
        <div>
          <b-button title="تنظیمات اولیه" size="sm">
            <span>تنظیمات اولیه</span>
            <font-awesome-icon icon="sync-alt" size="sm" />
          </b-button>
        </div>
        <div>
          <b-button variant="primary" title="جستجو" size="sm">
            <span>مشاهده گزارش ها</span>
            <font-awesome-icon icon="check" size="sm" />
          </b-button>
        </div>
      </b-button-group>
      <hr>
      <p class="text-center text-counter-ticket">
        تعداد کل تیکت های پیدا شده : 686
      </p>

      <!-- start charts -->
      <b-row class="mt-5">
        <b-col lg="6" cols="12">
          <p class="text-center text-title-chart">
            گزارش فروش بر اساس کالا
          </p>
          <t-bar
            id="bar_5"
            ref="bar_5"
            height="1000px"
            resource-data="sale/salereportreviewl1/chart"
            :async="true"
            :y-axis="{
              title: 'مقدار/مبلغ',
              fields: [
                { name: 'SumQuantity', title: 'مقدار' },
                { name: 'SumPrice', title: 'مبلغ' }
              ]
            }"
            :x-axis="{
              title: 'کالا',
              fieldName: 'mDesc'
            }"
            :horizontal="true"
          />
        </b-col>
        <b-col lg="6" cols="12">
          <p class="text-center text-title-chart">
            گزارش حساب های دریافتنی/مقایسه ای
          </p>
          <t-bar
            id="bar_compare_4"
            ref="bar_compare_4"
            height="500px"
            resource-data="acc/accreportaccountcompare/chart"
            :async="true"
            :y-axis="{
              title: 'مبلغ',
              fields: [
                { name: 'RemainBed', title: 'بدهکار' },
                { name: 'RemainBes', title: 'بستانکار' },
                { name: 'ZRemainBed', title: 'بدهکار مقایسه ای' },
                { name: 'ZRemainBes', title: 'بستانکار مقابسه ای' }
              ]
            }"
            :x-axis="{
              title: 'حساب',
              fieldName: 'AccountDesc'
            }"
          />
        </b-col>
      </b-row>
      <b-row>
        <b-col lg="6" cols="12">
          <p class="text-center text-title-chart">
            گزارشات موجودی کالا به صورت منطقه ای / انبار
          </p>
          <TPie
            id="pie_8"
            ref="pie_8"
            height="500px"
            resource-data="inv/invreportreviewl1/chart"
            :async="true"
            :y-axis="{
              title: 'باقیمانده',
              fields: [{ name: 'Remain', title: 'باقیمانده' }]
            }"
            :x-axis="{
              title: 'انبار',
              fieldName: 'mDesc'
            }"
          />
        </b-col>
        <b-col lg="6" cols="12">
          <p class="text-center text-title-chart">
            گزارشات موجودی کالا به صورت منطقه ای / انبار
          </p>
          <TPie
            id="pie_8"
            ref="pie_8"
            height="500px"
            resource-data="inv/invreportreviewl1/chart"
            :async="true"
            :y-axis="{
              title: 'باقیمانده',
              fields: [{ name: 'Remain', title: 'باقیمانده' }]
            }"
            :x-axis="{
              title: 'انبار',
              fieldName: 'mDesc'
            }"
          />
        </b-col>
      </b-row>
    </b-card-text>
  </b-card>
</template>

<script>
import TComboBox from '~/components/dataentry/TComboBox.vue'
import TTextBoxDate from '~/components/dataentry/TTextBoxDate.vue'
import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'
import TBar from '@/components/chart/TBar.vue'
import TPie from '@/components/chart/TPie'

export default {
  name: 'Dashboard',
  components: { TTextBoxDate, TTextBoxString, TComboBox, TBar, TPie },
  data () {
    return {
      title: 'گزارشات'
    }
  },
  head () {
    return {
      title: this.title
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
  background-color: #dcdcdc;
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
