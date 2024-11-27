<template>
  <b-overlay v-if="initializing" show no-wrap />
  <b-card
    v-else
    ref="card"
    header-tag="header"
    footer-tag="footer"
    header-class="t-card-header"
    body-class="t-card-body"
    class="t-card"
  >
    <template #header>
      <div class="container">
        <b-row cols="1" cols-sm="4" cols-md="6" cols-lg="3">
          <b-col id="t-title" class="text-center">
            {{ title }}
          </b-col>
          <b-col class="text-center mt-2">
            <b-button-group id="t-button-group-actionbar" size="sm">
              <b-button variant="outline-secondary" title="چاپ">
                <font-awesome-icon icon="print" size="lg" />
              </b-button>
              <b-button variant="outline-secondary" title="اکسل">
                <font-awesome-icon icon="file-excel" size="lg" />
              </b-button>
              <b-button
                v-b-toggle.t-collapse-filter
                variant="outline-secondary"
                title="جستجو"
              >
                <font-awesome-icon icon="search" size="lg" />
              </b-button>
              <b-button variant="outline-secondary" title="جدید">
                <font-awesome-icon icon="file" size="lg" />
              </b-button>
            </b-button-group>
          </b-col>
          <b-col class="text-center mt-2">
            <b-button-group id="t-button-group-pagination" size="sm">
              <b-button
                v-if="true"
                :disabled="!lastPageEnable"
                variant="outline-secondary"
                title="آخرین صفحه"
                @click="onLastPage"
              >
                &laquo;
              </b-button>
              <b-button
                :disabled="!nextPageEnable"
                variant="outline-secondary"
                title="صفحه بعد"
                @click="onNextPage"
              >
                &lsaquo;
              </b-button>
              <b-button
                :disabled="!prevPageEnable"
                variant="outline-secondary"
                title="صفحه قبل"
                @click="onPrevPage"
              >
                &rsaquo;
              </b-button>
              <b-button
                :disabled="!firstPageEnable"
                variant="outline-secondary"
                title="اولین صفحه"
                @click="onFirstPage"
              >
                &raquo;
              </b-button>
            </b-button-group>
          </b-col>
        </b-row>
      </div>
    </template>
    <b-overlay
      v-if="retrieving"
      id="t-loading-rows"
      show
      no-wrap
      :style="`height:${loadingHeight}px;`"
    />

    <b-collapse id="t-collapse-filter" @shown="onShowCollapseFilter">
      <b-card
        id="t-card-filter"
        footer-tag="footer"
        footer-class="t-card-filter-footer"
      >
        <b-card-text id="t-card-text-filter">
          <slot name="filterElemets" />
        </b-card-text>
        <template #footer>
          <b-button-group size="sm">
            <b-button
              variant="secondary"
              title="تنظیمات اولیه"
              @click="onClearFilter"
            >
              <span>تنظیمات اولیه</span>
              <font-awesome-icon icon="sync-alt" size="lg" />
            </b-button>
            <b-button variant="primary" title="جستجو" @click="onFilter">
              <span>جستجو</span>
              <font-awesome-icon icon="search" size="lg" />
            </b-button>
          </b-button-group>
        </template>
      </b-card>
    </b-collapse>

    <div>
      <b-card v-for="(row, rowIndex) in data" :key="rowIndex" class="mb-2">
        <div class="items-data">
          <div class="t-item-id">
            <span class="font-weight-bold">
              {{ (pageNumber - 1) * recordCount + rowIndex + 1 }}
            </span>
          </div>

          <div class="t-item-data">
            <div class="t-row">
              <div class="t-column-title mr-2">
                <span class="mt-2 font-weight-bold">عنوان:‌</span>
              </div>
              <div v-if="hasColIndex" class="t-column-desc mr-2 text-right">
                <span class="mt-2">{{ row.knowledgeBaseCategoryName }}</span>
              </div>
            </div>
            <div class="t-row">
              <div class="t-column-title mr-2">
                <span class="mt-2 font-weight-bold">serverID:‌</span>
              </div>
              <div v-if="hasColIndex" class="t-column-desc mr-2 text-right">
                <span class="mt-2">{{ row.serverID }}</span>
              </div>
            </div>
            <div class="t-row">
              <div class="t-column-title mr-2 text-left">
                <span class="mt-2 font-weight-bold">createDate:‌</span>
              </div>
              <div v-if="hasColIndex" class="t-column-desc mr-2 text-right">
                <span class="mt-2 item-data-date">
                  {{ row.createDate }}
                </span>
              </div>
            </div>
            <div class="t-row">
              <div class="t-column-title mr-2 text-left">
                <span class="mt-2 font-weight-bold">creatorID:‌</span>
              </div>
              <div v-if="hasColIndex" class="t-column-desc mr-2 text-right">
                <span class="mt-2">
                  {{ row.modifierID }}
                </span>
              </div>
            </div>
          </div>

          <!-- start icons delete / edit / check  -->
          <div class="t-item-icon">
            <div v-if="hasColDelete" class="t-td-delete">
              <b-button
                size="sm"
                title="حذف"
                variant="outline-light"
                @click="onDelete"
              >
                <font-awesome-icon
                  icon="times"
                  size="lg"
                  class="t-icon"
                />
              </b-button>
            </div>
            <div v-if="hasColEdit" class="t-td-edit">
              <b-button
                size="sm"
                title="ویرایش"
                variant="outline-light"
                @click="onEdit"
              >
                <font-awesome-icon icon="edit" size="lg" class="t-icon" />
              </b-button>
            </div>
            <div v-if="hasColActive" class="t-td-active">
              <b-button
                size="sm"
                title="فعال"
                variant="outline-light"
                @click="onActive"
              >
                <font-awesome-icon
                  v-if="hasColActive"
                  icon="check-square"
                  size="lg"
                  class="t-icon"
                />
              </b-button>
            </div>
          </div>
        </div>
      </b-card>
    </div>
  </b-card>
</template>

<script>
export default {
  name: 'TListView',
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
      required: true
    },
    mainFieldName: {
      /**
       * ستون اصلی گرید
       * عرض این ستون از متا خوانده نمیشود و شناور است
       */
      type: String,
      default: null,
      required: true
    },
    // #endregion
    // #region col Setting
    hasColIndex: {
      type: Boolean,
      default: true
    },
    hasColDelete: {
      type: Boolean,
      default: false
    },
    hasColEdit: {
      type: Boolean,
      default: false
    },
    hasColActive: {
      type: Boolean,
      default: false
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
      recordCount: 20
    }
  },
  computed: {
    // #region cols
    cols () {
      // لیست ستون های از متا
      if (this.meta === null) {
        return []
      }
      return this.meta.cols
    },
    colsVisible () {
      // تمامی ستون هایی که قابلیت نمایش دارند
      return this.cols.filter(col => col.visibility)
    },
    thStyle () {
      //
      const styles = []
      this.colsVisible.forEach((colVisible) => {
        if (colVisible.name === this.mainFieldName) {
          styles.push('')
        } else {
          styles.push(
            `width:${colVisible.width}px;max-width:${colVisible.width}px;`
          )
        }
      })
      return styles
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
    }
    // #endregion
  },
  watch: {
    initializing: {
      async handler (_initializing) {
        if (!_initializing) {
          // وقتی متا از سرور واکشی شد نوبت به واکشی دیتا است
          await this.retrieveData()
        }
      }
    },
    retrieving: {
      handler (_retrieving) {
        if (_retrieving) {
          this.$nextTick(() => {
            this.loadingHeight = this.$refs.card.getBoundingClientRect().height
          })
        }
      }
    }
  },
  async created () {
    // واکشی متا از سرور
    await this.retrieveMeta()
  },
  methods: {
    // #region call api
    async retrieveMeta () {
      // واکشی متا( اطلاعات مربوط به ستون ها) از سرور
      this.initializing = true
      const response = await this.$taxios.get(this.resourceMeta)
      this.meta = response.data
      this.initializing = false
    },
    async retrieveData () {
      // واکشی دیتا( سطرها) از سرور
      this.retrieving = true
      const filterParams = JSON.parse(JSON.stringify(this.filterParams))
      Object.keys(filterParams).forEach((key, val) => {
        if (filterParams[key] === null || filterParams[key] === '') {
          delete filterParams[key]
        }
      })
      // filterParams.filter = this.filter
      // filterParams.pageNumber = this.pgeNmbr
      // filterParams.recordCount = this.recordCount

      filterParams.pageNumber = this.pageNumber
      filterParams.recordCount = this.recordCount

      // if (this.hasServerIDCol) {
      //   // اگر ستون سرور آی دی داریم محل های صدور را به سرور پاس میدهیم
      //   filterParams.srIDs = this.serverIDs.join(',')
      // }

      // if (this.hasYearIDCol) {
      //   // اگر ستون یر آی دی داریم سال های مالی را به سرور پاس میدهیم
      //   filterParams.yrIDs = this.yearIDs.join(',')
      // }
      const response = await this.$taxios.get(this.resourceData, filterParams)
      this.data = response.data
      this.retrieving = false
    },
    // #endregion
    // #region actionbar
    async onFirstPage () {
      this.$tscroll.onScrollToTop()
      this.pageNumber = 1
      await this.retrieveData()
    },
    async onPrevPage () {
      this.$tscroll.onScrollToTop()
      this.pageNumber--
      await this.retrieveData()
    },
    async onNextPage () {
      this.$tscroll.onScrollToTop()
      this.pageNumber++
      await this.retrieveData()
    },
    onLastPage () {
      //
    },
    // #endregion
    // #region gridview
    onEdit () {
      alert('edit')
    },
    onDelete () {
      alert('delete')
    },
    onActive () {
      alert('active')
    },
    // #endregion
    // #region filter
    onShowCollapseFilter () {
      // اگر پنل سرچ نمایش داده شد صفحه با بالا اسکرول شود
      this.$tscroll.onScrollToTop()
    },
    onClearFilter () {
      this.$emit('onClearFilter')
    },
    async onFilter () {
      await this.retrieveData()
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
// #endregion

// #t-loading-rows {
//   //
// }
.t-card {
  margin: $cardMargin;
  .t-card-header {
    z-index: 2;
    height: $cardHeaderHeight;
    position: sticky;
    top: $menuHeight;
    background-color: var(--t-color-0-96);
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    border: 1px solid var(--t-color-0-80);
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
.t-td-edit {
  border: none;
  width: $colControlWidth;
  .t-icon {
    color: cadetblue;
  }
}

.t-td-delete {
  border: none;
  width: $colControlWidth;
  .t-icon {
    color: firebrick;
  }
}

.t-td-active {
  border: none;
  width: $colControlWidth;
  .t-icon {
    color: darkseagreen;
  }
}
//  new style
.items-data {
  display: flex;
  flex-direction: row;
  .t-item-data {
    display: flex;
    flex-direction: column;
    flex-grow: 1;
    flex: 9;
  }
  .t-item-icon {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-between;
    width: 3rem;
  }
  .t-row {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    width: 100%;
  }

.t-column-title {
    display: flex;
    flex-direction: column;
    flex-basis: 100%;
    flex: 0.06;
    color: var(--t-color-20-15);
  }

  .t-column-desc {
    display: flex;
    flex-direction: column;
    flex-basis: 100%;
    flex: 1;
  }

  .t-item-id {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-evenly;
    flex: 1;
    border: 1px solid var(--t-color-0-80);
  }
}
</style>
