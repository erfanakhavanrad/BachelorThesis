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
        <span id="page-number-span" title="شماره صفحه">{{ pageNumber }}</span>
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
      <div id="t-title">
        {{ title }}
      </div>
      <b-button-group id="t-button-group-actionbar" size="sm">
        <b-button variant="outline-secondary" title="چاپ">
          <!-- @click="onClickPrint"" -->
          <font-awesome-icon icon="print" size="lg" />
        </b-button>
        <b-button variant="outline-secondary" title="اکسل">
          <json-excel
            class="outline-secondary"
            :data="excelData"
            :fields="colVisibilityName"
            worksheet="My Worksheet"
            type="xls"
            :name="getFileNameExcel()"
          >
            <font-awesome-icon icon="file-excel" size="lg" />
          </json-excel>
        </b-button>
        <b-button
          v-b-toggle.t-collapse-filter
          variant="outline-secondary"
          title="جستجو"
        >
          <font-awesome-icon icon="search" size="lg" />
        </b-button>
        <b-button variant="outline-secondary" title="جدید" @click="onNew">
          <font-awesome-icon icon="file" size="lg" />
        </b-button>
        <b-button
          v-if="hasColRefresh"
          variant="outline-secondary"
          title="بروز رسانی لیست"
          @click="onRefresh"
        >
          <font-awesome-icon icon="sync" size="lg" />
        </b-button>
      </b-button-group>
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
    <div class="t-container-table">
      <table class="t-table">
        <thead :style="theadStyle">
          <tr>
            <th v-if="hasColIndex" class="t-th-index">
              <span>#</span>
            </th>
            <template v-for="(colVisible, colVisibleIndex) in colsVisible">
              <th :key="colVisibleIndex" :style="thStyle[colVisibleIndex]">
                <span v-if="colVisible.type === 'EMAIL'">
                  <font-awesome-icon icon="envelope" size="lg" />
                </span>
                <span v-else-if="colVisible.type === 'ISVISITED'">
                  <font-awesome-icon icon="eye" size="lg" />
                </span>
                <span v-else>{{ colVisible.title }}</span>
              </th>
            </template>
            <th v-if="hasColResetPass" class="t-th-reset-pass">
              <span>&nbsp;</span>
            </th>
            <th v-if="hasColDelete" class="t-th-delete">
              <span>&nbsp;</span>
            </th>
            <th v-if="hasColEdit" class="t-th-edit">
              <span>&nbsp;</span>
            </th>
            <th v-if="hasColActive" class="t-th-active">
              <span>&nbsp;</span>
            </th>
            <th v-if="hasColMenuAccess" class="t-th-menu-access">
              <span>&nbsp;</span>
            </th>
          </tr>
        </thead>
        <tbody>
          <template v-for="(row, rowIndex) in data">
            <tr :ref="'row' + rowIndex" :key="rowIndex">
              <td v-if="hasColIndex" class="t-td-index">
                <span>
                  {{ (pageNumber - 1) * recordCount + rowIndex + 1 }}</span>
              </td>
              <template v-for="(colVisible, colVisibleIndex) in colsVisible">
                <td :key="colVisibleIndex" :style="thStyle[colVisibleIndex]">
                  <t-chip
                    v-if="colVisible.type === 'OBJECT'"
                    :id="rowIndex.toString()"
                    v-model="row[colVisible.name]"
                    :infos="colVisible.infos"
                  />
                  <t-color
                    v-else-if="colVisible.type === 'COLOR'"
                    :id="rowIndex.toString()"
                    v-model="row[colVisible.name]"
                  />
                  <t-emoji
                    v-else-if="colVisible.type === 'EMOJI'"
                    :id="rowIndex.toString()"
                    v-model="row[colVisible.name]"
                  />
                  <t-p-color
                    v-else-if="colVisible.type === 'PCOLOR'"
                    :id="rowIndex.toString()"
                    v-model="row[colVisible.name]"
                  />
                  <t-check-box
                    v-else-if="colVisible.type === 'BOOLEAN'"
                    :id="rowIndex.toString()"
                    :value="
                      row[colVisible.name] == null
                        ? false
                        : row[colVisible.name]
                    "
                  />
                  <t-email
                    v-else-if="colVisible.type === 'EMAIL'"
                    :id="rowIndex.toString()"
                    v-model="row[colVisible.name]"
                  />
                  <t-link
                    v-else-if="colVisible.type === 'LINK'"
                    :id="rowIndex.toString()"
                    v-model="row[colVisible.name]"
                  />
                  <t-router
                    v-else-if="colVisible.type === 'ROUTER'"
                    :id="row[pk].toString()"
                    v-model="row[colVisible.name]"
                    :key-name-field="colVisible.name"
                  />
                  <t-is-visited
                    v-else-if="colVisible.type === 'ISVISITED'"
                    :id="rowIndex.toString()"
                    v-model="row[colVisible.name]"
                  />
                  <span v-else>{{ row[colVisible.name] }}</span>
                </td>
              </template>
              <td v-if="hasColResetPass" class="t-td-reset-pass">
                <span><b-button
                  size="sm"
                  title="ریست پسورد"
                  variant="outline-light"
                  @click="onClickResetPass(row[pk])"
                >
                  <font-awesome-icon
                    icon="key"
                    size="lg"
                    class="t-icon"
                  /> </b-button></span>
              </td>
              <td v-if="hasColDelete" class="t-td-delete">
                <span><b-button
                  size="sm"
                  title="حذف"
                  variant="outline-light"
                  @click="onClickDeleteRecord(row[pk])"
                >
                  <font-awesome-icon
                    icon="times"
                    size="lg"
                    class="t-icon"
                  /> </b-button></span>
              </td>
              <td v-if="hasColEdit" class="t-td-edit">
                <span><b-button
                  size="sm"
                  title="ویرایش"
                  variant="outline-light"
                  @click="onEdit(row[pk])"
                >
                  <font-awesome-icon
                    icon="edit"
                    size="lg"
                    class="t-icon"
                  /> </b-button></span>
              </td>
              <td v-if="hasColActive" class="t-td-active">
                <span><b-button
                  size="sm"
                  title="فعال"
                  variant="outline-light"
                  @click="onActive"
                >
                  <font-awesome-icon
                    icon="check-square"
                    size="lg"
                    class="t-icon"
                  /> </b-button></span>
              </td>
              <td v-if="hasColMenuAccess" class="t-td-menu-access">
                <span><b-button
                  size="sm"
                  title="دسترسی"
                  variant="outline-light"
                  @click="onClickMenuAccess(row[pk], row[mainFieldName])"
                >
                  <font-awesome-icon
                    icon="code-branch"
                    size="lg"
                    class="t-icon"
                  /> </b-button></span>
              </td>
            </tr>
          </template>
        </tbody>
      </table>
    </div>

    <template #footer>
      <em>&nbsp;</em>
    </template>
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
    <t-modal-yes-no
      ref="TModalYesNoResetPass"
      title="ریست پسورد"
      variant="warning"
      size="sm"
    >
      <span style="height: 50px; text-align: right">
        آیا پسورد این یوزر ریست شود؟
      </span>
    </t-modal-yes-no>
    <t-modal-menu-access
      ref="TModalMenuAccess"
      title="دسترسی به منو"
      variant="success"
      size="lg"
    />
  </b-card>
</template>

<script>
import { mapGetters } from 'vuex'
import JsonExcel from 'vue-json-excel'
import TCheckBox from './coltype/TCheckBox.vue'
import TChip from './coltype/TChip.vue'
import TColor from './coltype/TColor.vue'
import TEmoji from './coltype/TEmoji.vue'
import TEmail from './coltype/TEmail.vue'
import TLink from './coltype/TLink.vue'
import TRouter from './coltype/TRouter.vue'
import TIsVisited from './coltype/TIsVisited.vue'
import TPColor from './coltype/TPColor.vue'
import TModalYesNo from '~/components/general/TModalYesNo.vue'
import TModalMenuAccess from '~/components/general/TModalMenuAccess.vue'

export default {
  name: 'TGridView',
  components: {
    TModalYesNo,
    TModalMenuAccess,
    TChip,
    TColor,
    TEmoji,
    TLink,
    TRouter,
    TCheckBox,
    JsonExcel,
    TEmail,
    TIsVisited,
    TPColor
  },
  props: {
    // #region public
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
    hasColResetPass: {
      type: Boolean,
      default: false
    },
    hasColDelete: {
      type: Boolean,
      default: false
    },
    hasColEdit: {
      type: Boolean,
      default: false
    },
    hasColRefresh: {
      type: Boolean,
      default: false
    },
    hasColActive: {
      type: Boolean,
      default: false
    },
    hasColMenuAccess: {
      type: Boolean,
      default: false
    }
    // #endregion
  },
  data () {
    return {
      loadingHeight: 0,
      initializing: true,
      excelData: [],
      retrieving: false,
      meta: null,
      data: [],
      pageNumber: 1,
      json_meta: [
        [
          {
            key: 'charset',
            value: 'utf-8'
          }
        ]
      ],
      recordCount: 50,
      test: 'www.google.com'
    }
  },
  computed: {
    ...mapGetters({
      menuHeight: '_deviceInfo/GET_MENU_HEIGHT'
    }),
    // #region cols
    cols () {
      // لیست ستون های از متا
      if (this.meta === null) {
        return []
      }
      return this.meta.cols
    },
    colPK () {
      // ستون کلید اصلی
      return this.cols.find(col => col.isPK)
    },
    pk () {
      // نام کلید اصلی
      return this.colPK.name
    },
    colsVisible () {
      // تمامی ستون هایی که قابلیت نمایش دارند
      return this.cols.filter(col => col.visibility)
    },
    colVisibilityTitle () {
      this.retrieveDataForExcel()
      // title for persian that is array
      const colsVisibility = this.colsVisible
      // this for is not working and i dont have opinion for this error but
      // i think is not working because for col is iteself object and this is complicated
      // for (const col in colsVisibility) {
      //   console.log(col.title)
      const colsVisibilityTitles = []
      for (let i = 0; i < colsVisibility.length; i++) {
        // console.log(colsVisibility[i].name)
        // Link and RouterType doesnot show in excel
        colsVisibilityTitles.push(colsVisibility[i].title)
      }
      return colsVisibilityTitles
    },

    // name for keys in object
    colVisibilityName () {
      // colsVisbility contain all visible column that is array
      const colsVisibility = this.colsVisible
      // this for is not working and i dont have opinion for this error but
      // i think is not working because for col is iteself object and this is complicated
      // for (const col in colsVisibility) {
      //   console.log(col.title)
      // this loop get all name(filed of DB)
      const colsVisibilityNames = {}
      for (let i = 0; i < colsVisibility.length; i++) {
        // console.log(colsVisibility[i].name)

        colsVisibilityNames[i] = colsVisibility[i].name
      }
      // get Title(persian of Meta) and this is an array
      const colsVisibilityTitle = this.colVisibilityTitle
      const colsVisibilityNamesTitle = {}
      for (let i = 0; i < colsVisibilityTitle.length; i++) {
        // this is work but i hard code determine the value of key "isVisited" is true or false
        // i handle it by specify this is '' or not, TODO: this is must improve
        if (colsVisibilityTitle[i] === '') {
          colsVisibilityTitle[i] = 'بسته / باز'
        }
        // this is comment because since 14 auguest we discuss that LINK and ROUTER be exist in excel file
        // if (
        //   colsVisibility[i].type === 'LINK' ||
        //   colsVisibility[i].type === 'ROUTER'
        // ) {
        //   continue
        // }
        colsVisibilityNamesTitle[colsVisibilityTitle[i]] =
          colsVisibilityNames[i]
      }
      return colsVisibilityNamesTitle
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
    },
    // #endregion
    // #region pagination
    theadStyle () {
      // فاصله از بالا برای هدر گرید
      const cardHeaderHeight = '4rem'
      return `top:calc(${this.menuHeight}px + ${cardHeaderHeight})`
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
    },
    resourceData: {
      async handler (_resourceData) {
        // وقتی متا از سرور واکشی شد نوبت به واکشی دیتا است
        if (_resourceData !== null) {
          await this.retrieveData()
          // console.log('changed')
        } else {
          this.data = null
          // console.log('not changed and null')
        }
      }
    }
  },
  mounted () {
    setTimeout(() => {
      this.isVisitedTheme()
    }, 5)
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
      // baraye shallow copy
      try {
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

        try {
          const response = await this.$taxios.get(
            this.resourceData,
            filterParams
          )
          if (response.data.length > 0) {
            this.data = await response.data
            setTimeout(() => {
              this.isVisitedTheme()
            }, 5)
            this.$emit('dataIsRecived', this.data)
            this.excelData = JSON.parse(JSON.stringify(response.data))
          } else {
            this.data = []
          }
          this.retrieving = false
        } catch (error) {
          this.retrieving = false
        }
      } catch (error) {
        //
      }
      // prepare excel data regardless response.data
      // this.retrieving = false
    },
    retrieveDataForExcel () {
      // this.excelData = Object.assign({}, this.data)
      for (const record of this.excelData) {
        for (const key in record) {
          if (typeof record[key] === 'object' && record[key] !== null) {
            // console.log('Hello')
            record[key] = record[key].value
          }
          // console.log(record[key])
          // console.log(typeof record[key])
          // console.log('Hello')
        }
      }
    },
    //   filterParams.pageNumber = this.pageNumber
    //   filterParams.recordCount = this.recordCount

    //   // if (this.hasServerIDCol) {
    //   //   // اگر ستون سرور آی دی داریم محل های صدور را به سرور پاس میدهیم
    //   //   filterParams.srIDs = this.serverIDs.join(',')
    //   // }

    //   // if (this.hasYearIDCol) {
    //   //   // اگر ستون یر آی دی داریم سال های مالی را به سرور پاس میدهیم
    //   //   filterParams.yrIDs = this.yearIDs.join(',')
    //   // }
    //   const response = await this.$taxios.get(this.resourceData, filterParams)
    //   this.data = response.data
    //   this.retrieving = false
    // }
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
      // this.$tscroll.onScrollToTop()
      // this.pageNumber = 1
      // await this.retrieveData()
    },
    getFileNameExcel () {
      return this.title + '.xls'
    },
    // onExcel () {
    //   this.retrieving = true
    //   this.$taxios
    //     .excel(this.resourceData, this.filterParams, this.title)
    //     .then((response) => {
    //       this.retrieving = false
    //       if (response.status === 200) {
    //         this.$ttoast.createToast(
    //           'info',
    //           200,
    //           'OK',
    //           'Excel file has been created',
    //           'فایل اکسل ساخته شد',
    //           3000
    //         )
    //       }
    //     })
    //     .catch(() => {
    //       this.retrieving = true
    //     })
    // },
    // #endregion
    // #region gridview
    onClickResetPass (pkValue) {
      this.$refs.TModalYesNoResetPass.show(() => {
        this.onResetPass(pkValue)
      })
    },
    onResetPass (pkValue) {
      this.retrieving = true
      this.$taxios
        .put('tkt/users', pkValue + '/resetpass', { userID: pkValue })
        .then((response) => {
          this.retrieving = false
          if (response.status === 200) {
            this.$ttoast.createToast(
              'info',
              200,
              'OK',
              'Password has been reset',
              'پسورد ریست شد',
              3000
            )
          }
        })
        .catch(() => {
          this.retrieving = true
        })
    },
    onEdit (pkValue) {
      this.$router.push({
        name: `${this.$route.name}-edit`,
        query: {
          id: pkValue
        }
      })
    },

    onClickDeleteRecord (pkValue) {
      this.$refs.TModalYesNoDeleteRecord.show(() => {
        this.onDelete(pkValue)
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
    onActive () {
      alert('active')
    },
    onClickMenuAccess (userID, userName) {
      this.retrieving = true
      this.$refs.TModalMenuAccess.show(
        userID,
        userName,
        (menus) => {
          this.retrieving = false
        }, // ok
        () => {}, // cancel
        () => {}, // close
        () => {
          // hide
          this.retrieving = false
        }
      )
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
    },
    onNew () {
      this.$router.push({
        name: `${this.$route.name}-add`
      })
    },
    async onRefresh () {
      await this.retrieveData()
    },
    getTitles (value) {
      // console.log(value.title)
      return 1
    },
    onClickPrintTicket () {
      // console.log('khers')
      this.$tprint.create(this.title, () => {
        let html = this._Print_Title()
        html += this._Print_Conv(this.conversationFirst)
        this.conversationOther.forEach((conversation) => {
          html += this._Print_Conv(conversation)
        })
        return html
      })
    },
    // #endregion
    isVisitedTheme () {
      for (const rowIndex in this.data) {
        if (this.data[rowIndex].isVisited === false) {
          // console.log('aaaaaaaaaaaaaaaaa')
          console.log(this.$refs['row' + rowIndex][0].style)
          this.$refs['row' + rowIndex][0].bgColor = '#a2bedb'
          this.$refs['row' + rowIndex][0].style.fontWeight = '900'
        } else if (this.$tnumber.oddEvenNumber(rowIndex) === 'even') {
          this.$refs['row' + rowIndex][0].bgColor = '#e8f6fc'
          // this.$refs['row' + rowIndex][0].getPropertyValue('--t-color-30-90')
        }
      }
    }
  }
}
</script>

<style lang="scss" scoped>
// TODO
// برای لیست ویو حتما باید ۵۷ پیکسل شود
$menuHeight: 80px; // ارتفاع منوی بالای صفحه
// #region card
$cardMargin: 1rem; // مارجین کارد
$cardHeaderHeight: 4rem; // ارتفاع هدر کارد
$cardBodyMargin: 1rem; // مارجین بادی کارد
// #endregion

// #region actionbar
$actionbarButtonWidth: 2.5rem; // عرض دکمه های اکشن بار
// #endregion

// #region gridview
$colIndexWidth: 3.5rem; // عرض ستون ایندکس
$headerHeight: 2.5rem; // ارتفاع هدر گرید
$rowHeight: 2rem; // ارتفاع سطر های گرید
$colControlWidth: 3rem; // عرض ستون حذف
$headerFontSize: 0.8rem;
$rowFontSize: 0.75rem;
// #endregion

// #region filter
$filterButtonWidth: 8rem; // عرض دکمه های پنل سرچ
// #endregion

.t-card {
  margin: $cardMargin;
  .t-card-header {
    z-index: 2;
    height: $cardHeaderHeight;
    position: sticky;
    top: $menuHeight;
    // background-color: var(--t-color-0-96);
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    // border: 1px solid var(--t-color-0-80);
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

    #t-button-group-pagination {
      direction: ltr;
      button {
        margin-left: 4px;
        margin-right: 4px;
        width: $actionbarButtonWidth;
      }
      #page-number-span {
        margin-left: 4px;
        margin-right: 4px;
        width: $actionbarButtonWidth;
        border: 1px solid gray;
        text-align: center;
        padding: 5px;
        box-sizing: border-box;
        color: rgb(107, 107, 107);
        font-size: 16px;
        // border-radius: 4px;
      }
    }
    #t-title {
      align-self: center;
      // font-weight: bold;
    }
    #t-button-group-actionbar {
      direction: ltr;
      button {
        margin-left: 4px;
        margin-right: 4px;
        width: $actionbarButtonWidth;
      }
      @media screen and (max-width: 800px) {
        display: none;
      }
    }
    #res-nav-dropdown {
      display: none;
      @media screen and (max-width: 800px) {
        display: block;
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
    .t-container-table {
      .t-table {
        width: 100%;
        border-collapse: separate;
        border-spacing: 0;
        thead {
          // background-color: var(--t-color-0-96);
          background: #ada996; /* fallback for old browsers */
          background: -webkit-linear-gradient(
            to bottom,
            #eaeaea,
            #dbdbdb
          ); /* Chrome 10-25, Safari 5.1-6 */
          background: linear-gradient(
            to bottom,
            #eaeaea,
            #dbdbdb
          ); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

          position: sticky;
          th {
            height: $headerHeight;
            color: var(--t-color-20-15);
            // text-shadow: 1px 1px var(--t-color-20-85);
            // border: 1px solid var(--t-color-0-80);
            // border-right: none;
            span {
              display: flex;
              justify-content: flex-start;
              margin-right: 6px;
              align-items: center;
              height: 100%;
              font-size: $headerFontSize;
            }
            // &:last-child {
            //   span {
            //     border-left: 1px solid var(--t-color-70-25);
            //   }
            // }
          }
          .t-th-index {
            width: $colIndexWidth;
            // border-right: 1px solid var(--t-color-0-80);
          }
          .t-th-reset-pass {
            width: $colControlWidth;
            border-top: none;
            // border-left: 1px solid white;
            span {
              // background-color: white;
              background: #ada996; /* fallback for old browsers */
              background: -webkit-linear-gradient(
                to bottom,
                #eaeaea,
                #dbdbdb
              ); /* Chrome 10-25, Safari 5.1-6 */
              background: linear-gradient(
                to bottom,
                #eaeaea,
                #dbdbdb
              ); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            }
          }
          .t-th-delete {
            width: $colControlWidth;
            border-top: none;
            // border-left: 1px solid white;
            span {
              // background-color: white;
              background: #ada996; /* fallback for old browsers */
              background: -webkit-linear-gradient(
                to bottom,
                #eaeaea,
                #dbdbdb
              ); /* Chrome 10-25, Safari 5.1-6 */
              background: linear-gradient(
                to bottom,
                #eaeaea,
                #dbdbdb
              ); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            }
          }
          .t-th-edit {
            width: $colControlWidth;
            border-top: none;
            // border-left: 1px solid white;
            span {
              // background-color: white;
              background: #ada996; /* fallback for old browsers */
              background: -webkit-linear-gradient(
                to bottom,
                #eaeaea,
                #dbdbdb
              ); /* Chrome 10-25, Safari 5.1-6 */
              background: linear-gradient(
                to bottom,
                #eaeaea,
                #dbdbdb
              ); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            }
          }
          .t-th-active {
            width: $colControlWidth;
            border-top: none;
            // border-left: 1px solid white;
            span {
              // background-color: white;
              background: #ada996; /* fallback for old browsers */
              background: -webkit-linear-gradient(
                to bottom,
                #eaeaea,
                #dbdbdb
              ); /* Chrome 10-25, Safari 5.1-6 */
              background: linear-gradient(
                to bottom,
                #eaeaea,
                #dbdbdb
              ); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            }
          }
          .t-th-menu-access {
            width: $colControlWidth;
            border-top: none;
            // border-left: 1px solid white;
            span {
              // background-color: white;
              background: #ada996; /* fallback for old browsers */
              background: -webkit-linear-gradient(
                to bottom,
                #eaeaea,
                #dbdbdb
              ); /* Chrome 10-25, Safari 5.1-6 */
              background: linear-gradient(
                to bottom,
                #eaeaea,
                #dbdbdb
              ); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            }
          }
        }
        tbody {
          // border: 1px solid var(--t-color-0-85);
          // border-left: none;
          // border-bottom: none;
          tr {
            // &:nth-child(even) {
            //   // background-color: var(--t-color-20-96);
            //   background-color: var(--t-color-30-90);
            // }
            &:hover {
              // background-color: var(--t-color-50-100-80);
              background-color: var(--t-color-70-80);
            }
            td {
              height: $rowHeight;
              color: var(--t-color-20-15);
              // text-shadow: 1px 1px var(--t-color-20-85);
              border-bottom: 1px solid var(--t-color-0-85);
              // border-left: 1px solid var(--t-color-0-85);
              span {
                display: flex;
                justify-content: flex-start;
                text-align: right;
                word-break: break-word;
                margin: 5px;
                font-size: $rowFontSize;
              }

              // &:last-child {
              //   span {
              //     border-left: 1px solid var(--t-color-70-25);
              //   }
              // }
            }

            .t-td-index {
              width: $colIndexWidth;
              // border-right: 1px solid var(--t-color-0-80);
              span {
                justify-content: center;
              }
            }
            .t-td-reset-pass {
              width: $colControlWidth;
              span {
                justify-content: center;
              }
              .t-icon {
                color: burlywood;
              }
            }
            .t-td-delete {
              width: $colControlWidth;
              span {
                justify-content: center;
              }
              .t-icon {
                color: firebrick;
              }
            }
            .t-td-edit {
              width: $colControlWidth;
              span {
                justify-content: center;
              }
              .t-icon {
                color: cadetblue;
              }
            }
            .t-td-active {
              width: $colControlWidth;
              span {
                justify-content: center;
              }
              .t-icon {
                color: darkseagreen;
              }
            }
            .t-td-menu-access {
              width: $colControlWidth;
              span {
                justify-content: center;
              }
              .t-icon {
                color: red;
              }
            }
          }
        }
      }
    }
  }
}
</style>
