<!-- eslint-disable vue/require-v-for-key -->
<template>
  <!-- <b-overlay v-if="initializing" show no-wrap /> -->
  <div>
    <div>
      <b-navbar toggleable="lg2" type="dark" class="res-nav-bar">
        <b-button-group id="t-button-group-pagination" size="sm">
          <b-button
            :disabled="!nextPageEnable"
            variant="outline-light"
            title="صفحه بعد"
            class="res-pagination-next-button"
            @click="onNextPage"
          >
            &lsaquo;
          </b-button>
          <span id="page-number-span" title="شماره صفحه">{{ pageNumber }}</span>
          <b-button
            :disabled="!prevPageEnable"
            variant="outline-light"
            title="صفحه قبل"
            class="res-pagination-previous-button"
            @click="onPrevPage"
          >
            &rsaquo;
          </b-button>
        </b-button-group>
        <!-- این فقط برای brande -->
        <b-navbar-brand>
          {{ title }}
        </b-navbar-brand>
        <!-- baraye search -->
        <!-- <b-button variant="outline-light">
          <font-awesome-icon icon="search" size="sm" />
        </b-button> -->
        <!-- baraye drop down  -->
        <b-dropdown variant="outline-light" text="عملیات" left>
          <b-dropdown-item
            v-b-toggle.res-collapse-filter
            class="res-nav-bar-operations-buttons"
          >
            جستجو
            <font-awesome-icon icon="search" size="sm" />
          </b-dropdown-item>
          <b-dropdown-divider />
          <b-dropdown-item
            v-if="hasExcel"
            class="res-nav-bar-operations-buttons"
          >
            اکسل
            <font-awesome-icon icon="file-excel" size="sm" />
          </b-dropdown-item>
          <b-dropdown-item
            v-if="hasPrint"
            class="res-nav-bar-operations-buttons"
          >
            چاپ
            <font-awesome-icon icon="print" size="sm" />
          </b-dropdown-item>
          <b-dropdown-divider />
          <b-dropdown-item
            v-if="hasNew"
            class="res-nav-bar-operations-buttons"
            @click="onNew"
          >
            جدید
            <font-awesome-icon icon="file" size="sm" />
          </b-dropdown-item>
          <b-dropdown-item
            v-if="hasRefresh"
            class="res-nav-bar-operations-buttons"
            @click="onRefresh"
          >
            بروزرسانی
            <font-awesome-icon icon="sync" size="sm" />
          </b-dropdown-item>
        </b-dropdown>
        <b-collapse id="res-collapse-filter">
          <b-card
            class="res-toggle-filter shadow p-3 mb-5 bg-white rounded"
            footer-tag="footer"
          >
            <b-card-text id="t-card-text-filter">
              <slot name="resFilterElemets" />
            </b-card-text>
            <template #footer>
              <div class="res-toggle-filter-footer">
                <!-- TODO: bayad button search vardashte shavad -->
                <b-button
                  variant="primary"
                  title="جستجو"
                  class="res-toggle-filter-search-button"
                  @click="onFilter"
                >
                  <span>جستجو</span>
                  <font-awesome-icon icon="search" size="sm" />
                </b-button>
                <b-button-group size="sm" class="res-toggle-filter-buttons">
                  <b-button
                    variant="secondary"
                    title="تنظیمات اولیه"
                    class="res-toggle-filter-buttons"
                    @click="onClearFilter"
                  >
                    <span>تنظیمات اولیه</span>
                    <font-awesome-icon icon="sync-alt" size="sm" />
                  </b-button>
                  <b-button v-b-toggle.res-collapse-filter title="بستن">
                    <span>بستن</span>
                  </b-button>
                </b-button-group>
              </div>
            </template>
          </b-card>
        </b-collapse>
      </b-navbar>
    </div>
    <div>
      <!-- برای اون سر برگ اولیه -->
      <!-- <div class="heading h3">
      <p>{{ title }}</p>
    </div> -->
      <template v-for="(item, rowIndex) in data.data">
        <b-card :key="rowIndex" class="b-card" header-tag="header">
          <!-- داخل کارد هستیم من با flex رفتم با چیزای جور دیگه ای میشه یا نه -->
          <div class="meta">
            <div v-if="hasColIndex" class="number">
              {{ (pageNumber - 1) * recordCount + rowIndex + 1 }}
            </div>
          </div>
          <div id="flex-cont">
            <template v-for="(colVisible, colVisibleIndex) in colsResVisible">
              <div v-if="showIcon[colVisibleIndex]" class="title-data">
                <!-- write title per each data that is not in forbidden list -->
                <!-- title or icon of any data -->
                <!-- {{ colVisible.resIcon }} -->
                <font-awesome-icon :icon="colVisible.resIcon" size="md" />
              </div>
              <div
                v-if="colVisible.type === 'ROUTER'"
                class="router"
                :style="resStyle[colVisibleIndex]"
              >
                <t-router
                  :id="rowIndex.toString()"
                  v-model="item[colVisible.name]"
                  :key-name-field="colVisible.name"
                />
                <!-- {{ item[colVisible.name].value }} -->
              </div>
              <div v-else-if="colVisible.type === 'OBJECT'">
                {{ item[colVisible.name.value] }}
              </div>
              <div
                v-else-if="colVisible.type === 'ISVISITED'"
                class="is-visited-meta"
              >
                <t-is-visited-vue
                  v-model="item[colVisible.name]"
                  :res-is-grid-view="false"
                />
              </div>
              <div
                v-else-if="
                  colVisible.title === 'اهمیت' &&
                  item[colVisible.name] === 'پایین'
                "
                class="priority-low"
              >
                {{ '.' }}
              </div>
              <div
                v-else-if="
                  colVisible.title === 'اهمیت' &&
                  item[colVisible.name] === 'متوسط'
                "
                class="priority-medium"
              >
                {{ '.' }}
              </div>
              <div
                v-else-if="
                  colVisible.title === 'اهمیت' &&
                  item[colVisible.name] === 'بالا'
                "
                class="priority-high"
              >
                {{ '.' }}
              </div>
              <div
                v-else
                class="main-response"
                :style="resStyle[colVisibleIndex]"
              >
                {{ item[colVisible.name] }}
              </div>
            </template>
          </div>
          <template v-if="checkOperation" #header>
            <b-dropdown text="ویرایش" left size="sm">
              <div class="operation-buttons-header">
                <b-dropdown-item
                  v-if="hasEdit"
                  class="dropdown-item-operation"
                  @click="onEdit(item[pk])"
                >
                  ویرایش
                  <font-awesome-icon icon="edit" size="sm" />
                </b-dropdown-item>
                <b-dropdown-item
                  v-if="hasDelete"
                  class="dropdown-item-operation"
                  @click="onDelete(item[pk])"
                >
                  حذف
                  <font-awesome-icon icon="trash" size="sm" />
                </b-dropdown-item>
              </div>
            </b-dropdown>
          </template>
        </b-card>
      </template>
      <!-- برای حذف کردن -->
      <t-modal-yes-no
        ref="TModalYesNoDeleteRecord"
        title="حذف رکورد"
        variant="danger"
        size="sm"
      >
        <span style="height: 50px; text-align: right">
          آیا مایل به حذف رکورد مورد نظر هستید؟
        </span>
      </t-modal-yes-no>
    </div>
  </div>
</template>

<script>
import TIsVisitedVue from '../gridview/coltype/TIsVisited.vue'
import TRouter from '../gridview/coltype/TRouter.vue'
import TModalYesNo from '~/components/general/TModalYesNo.vue'
// import tAxios from '~/plugins/tAxios'
export default {
  name: 'TListView',
  components: {
    TModalYesNo,
    TRouter,
    TIsVisitedVue
  },
  props: {
    id: {
      type: String,
      default: null,
      required: true
    },
    title: {
      type: String,
      default: null,
      required: true
    },
    resourceData: {
      type: String,
      default: null,
      required: true
    },
    resourceMeta: {
      type: String,
      default: null,
      required: true
    },
    filterParams: {
      type: Object,
      default () {
        return {}
      },
      required: false
    },
    mainFieldName: {
      /**
       * ستون اصلی لیست
       * این ستون باید در قسمت فوقانی قرار بگیرد
       */
      type: String,
      default: null,
      required: true
    },
    // #endregion
    // #region col Setting
    hasDelete: {
      type: Boolean,
      default: false
    },
    hasEdit: {
      type: Boolean,
      default: false
    },
    // for some page that need index number
    hasColIndex: {
      type: Boolean,
      default: true
    },
    // for enable and Disable Excel Operation
    hasExcel: {
      type: Boolean,
      default: false
    },
    // for enable and Disable print Operation
    hasPrint: {
      type: Boolean,
      default: false
    },
    // for enable and Disable refresh Operation
    hasRefresh: {
      type: Boolean,
      default: false
    },
    // for enable and Disable new(create) Operation
    hasNew: {
      type: Boolean,
      default: true
    }
  },
  data () {
    return {
      loadingHeight: 0,
      initializing: true,
      retrieving: false,
      meta: null,
      data: [],
      pageNumber: 1,
      recordCount: 20,
      haveIcon: [],
      hiddenArrayTitles: []
    }
  },
  computed: {
    // #region cols
    colPK () {
      // ستون کلید اصلی
      return this.cols.find(col => col.isPK)
    },
    pk () {
      // نام کلید اصلی
      return this.colPK.name
    },
    cols () {
      // لیست ستون های از متا
      if (this.meta === null) {
        return []
      }
      return this.meta.cols
    },
    colsResVisible () {
      // تمامی ستون هایی که قابلیت نمایش دارند
      // eslint-disable-next-line no-unused-vars
      const a = this.cols.filter(col => col.resVisibility === true)
      return a
    },
    resStyle () {
      const styles = []
      this.colsResVisible.forEach((colVisible, index) => {
        if (colVisible.name === this.mainFieldName || colVisible.name === 'organizationName') {
          // style of main field
          styles.push({
            'text-align': 'center',
            'font-weight': 'bold',
            'font-family': 'IRANSansX',
            width: '100%',
            'font-size': 'larger',
            'flex-grow': '4',
            margin: '2%'
          })
        } else {
          styles.push({ 'text-align': 'center' })
        }
      })
      return styles
    },
    showIcon () {
      // this method creates array for show icon or nor
      for (const x in this.colsResVisible) {
        if (this.colsResVisible[x].resIcon === 'none') {
          // eslint-disable-next-line vue/no-side-effects-in-computed-properties
          this.haveIcon[x] = false
        } else {
          // eslint-disable-next-line vue/no-side-effects-in-computed-properties
          this.haveIcon[x] = true
        }
        for (const x in this.colsResVisible) {
          // eslint-disable-next-line vue/no-side-effects-in-computed-properties
          this.colsResVisible[x].resIcon = this.colsResVisible[
            x
          ].resIcon.replace(/_/g, '-')
        }
        console.log('a')
      }
      console.log('a')
      return this.haveIcon
    },
    // #endregion
    // #region pagination
    firstPageEnable () {
      return this.pageNumber !== 1
    },
    prevPageEnable () {
      return this.pageNumber !== 1
    },
    nextPageEnable () {
      return this.data.length !== 0
    },
    lastPageEnable () {
      return this.data.length !== 0
    },
    returnValue () {
      return this.json_data
    },
    returnFields () {
      return this.json_feilds
    },
    checkOperation () {
      if (this.hasEdit || this.hasDelete) {
        return true
      } else {
        return false
      }
    }
  },
  // eslint-disable-next-line require-await
  async created () {
    this.retrieveMeta()
    this.retrieveData()
  },
  methods: {
    async retrieveMeta () {
      this.initializing = true
      const response = await this.$taxios.get(this.resourceMeta)
      console.log('kol response meta:')
      console.log(response)
      console.log('faghat data meta')
      console.log(response.data)
      this.meta = response.data
      this.initializing = false
    },
    async retrieveData () {
      this.initializing = true
      const filterParams = JSON.parse(JSON.stringify(this.filterParams))
      Object.keys(filterParams).forEach((key, val) => {
        if (filterParams[key] === null || filterParams[key] === '') {
          delete filterParams[key]
        }
      })
      filterParams.pageNumber = this.pageNumber
      filterParams.recordCount = this.recordCount
      const responseData = await this.$taxios.get(
        this.resourceData,
        filterParams
      )
      this.data = responseData
      console.log('faghat data')
      console.log(this.data)
      console.log('dar mored router')
      console.log(this.$route)
      console.log('dar mored ')
      console.log(this.$route.fullPath)
      this.initializing = false
    },
    async onNextPage () {
      this.$tscroll.onScrollToTop()
      this.pageNumber++
      await this.retrieveData()
    },
    async onPrevPage () {
      this.$tscroll.onScrollToTop()
      this.pageNumber--
      await this.retrieveData()
    },
    async onRefresh () {
      await this.retrieveData()
    },
    async onFilter () {
      await this.retrieveData()
    },
    onClearFilter () {
      this.$emit('onClearFilter')
    },
    onEdit (pkValue) {
      this.$router.push({
        name: `${this.$route.name}-edit`,
        query: {
          id: pkValue
        }
      })
    },
    onDelete (pkValue) {
      this.retrieving = true
      this.$taxios
        .delete(this.resourceData, pkValue)
        .then(async (response) => {
          this.retrieving = false
          if (response.status === 204) {
            this.$ttoast.createToast(
              'danger',
              204,
              'No Content',
              'Record Deleted successfully',
              'رکورد با موفقیت حذف شد',
              3000
            )
            await this.retrieveData()
          }
        })
        .catch(() => {
          this.retrieving = false
        })
    },
    onNew () {
      this.$router.push({
        name: `${this.$route.name}-add`
      })
    }
  },

  onEdit (pk) {
    console.log(pk)
    this.$router.push({
      name: `${this.$route.name}-edit`,
      query: {
        id: pk
      }
    })
  },
  onClickDelete (pk) {
    this.$refs.TModalYesNoDeleteRecord.show(() => {
      this.onDelete(pk)
    })
  },
  async onDelete (pkValue) {
    pkValue = pkValue + 1
    this.retrieving = true
    await this.$taxios
      .delete(this.resourceData, pkValue)
      .then(async (response) => {
        this.retrieving = false
        if (response.status === 204) {
          this.$ttoast.createToast(
            'danger',
            204,
            'No Content',
            'Record Deleted successfully',
            'رکورد با موفقیت حذف شد',
            3000
          )
          await this.retrieveMeta()
        }
      })
      .catch(() => {
        this.retrieving = false
      })
    return null
  },

  getFileNameExcel () {
    return this.title + '.xls'
  },
  getVisibilityOfColumn (value) {
    if (value === true) {
      return true
    } else {
      return false
    }
  }
}
</script>

<style lang="scss" scoped>
$priority-width: 5%;
$priority-color-low: #28c76f;
$priority-color-medium: #ffe46b;
$priority-color-high: #ff8747;
$title-data-width: 10%;
$main-response-width: 80%;
$title-data-from-main-response-margin: 3%;
$nav-bar-margin: 2%;
$nav-bar-color: #009ed6a6;
$font-family: 'Calibri';
$bcard-padding: 1%;
.heading {
  margin: 5%;
  text-align: right;
  font-family: sans-serif;
  color: #009ed6;
}
.b-card {
  margin: 3%;
  padding: $bcard-padding;
}
#flex-cont {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  font-family: IRANSansX;
  justify-content: center;
  text-align: right;
  font-size: medium;
  // هم تراز سازی عناصر داخلی نسبت به محور وای(بالا پایین رفتن که من گفتم وسط وایسا)
  align-items: center;
  // هم تراز سازی عناصر داخلی نسبت به محور ایکس(چپ و راست رفتن که من گفتم برو راست وایسا)
  flex-contents: flex-start;

  .title-data {
    width: $title-data-width;
    border-left: solid;
    border-width: 1px;
    margin-left: $title-data-from-main-response-margin;
  }
  .is-visited-meta {
    text-align: right;
    width: 70%;
  }
  .router {
    width: 30%;
    text-align: left;

    // flex-grow: 3;
  }
  // TODO: yek priority bayad besazi
  .priority-low {
    background-color: $priority-color-low;
    color: $priority-color-low;
    width: $priority-width;
    justify-content: right;
    order: 10;
    height: 100%;
    position: absolute;
    left: 0px;
    top: 0px;
  }
  .priority-medium {
    background-color: $priority-color-medium;
    color: $priority-color-medium;
    width: $priority-width;
    justify-content: right;
    order: 10;
    height: 100%;
    position: absolute;
    left: 0px;
    top: 0px;
  }
  .priority-high {
    background-color: $priority-color-high;
    color: $priority-color-high;
    width: $priority-width;
    justify-content: right;
    order: 10;
    height: 100%;
    position: absolute;
    left: 0px;
    top: 0px;
  }
  .number {
    // flex-grow: 1;
    width: 10%;
    background-color: #d1dbe0;
    justify-content: flex-start;
    text-align: center;
  }
  .main-response {
    width: $main-response-width;
    flex-grow: 4;
    text-align: center;
    // background-color: aqua;
  }
}
.operation-buttons-header {
  .dropdown-item {
    text-align: right;
  }
  a {
    text-align: right;
  }
}
.dropdown-item-operation {
  text-align: right;
}
.res-nav-bar {
  display: flex;
  flex-wrap: nowrap;
  background-color: #009ed6a6;
  margin: $nav-bar-margin;

  .res-pagination-next-button {
    color: #ffffffff;
    margin-left: 12%;
  }
  .res-pagination-previous-button {
    color: #ffffffff;
    margin-right: 12%;
  }
  .res-toggle-filter {
    background-color: #009ed6a6;
    margin-top: 8%;
  }
  .res-nav-bar-operations-buttons {
    text-align: right;
  }
  .res-toggle-filter-footer {
    display: flex;
    flex-wrap: wrap;
    .res-toggle-filter-buttons {
      flex-grow: 1;
      margin-left: 1%;
      min-width: fit-content;
    }
    .res-toggle-filter-search-button {
      flex-grow: 5;
      min-width: fit-content;
      margin-bottom: 5%;
    }
  }
}
</style>
