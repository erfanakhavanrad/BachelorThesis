<template>
  <b-overlay :show="isLoading">
    <b-card
      ref="card"
      header-tag="header"
      footer-tag="footer"
      header-class="card-welcom"
      body-class="t-card-body"
      class="t-card"
    >
      <template #header>
        <font-awesome-icon icon="edit" size="lg" />
        <span class="mr-1">ویرایش پروفایل </span>
      </template>
      <b-card-text class="text-card-info">
        <!-- start items -->
        <t-text-box-email
          id="userLoginName"
          v-model="dataEntryModel.userLoginName"
          label="ایمیل"
          disabled
        />
        <t-text-box-number
          id="userMobileNumber"
          v-model="dataEntryModel.userMobileNumber"
          :rules="{ min: 11, max: 11 }"
          label="شماره موبایل"
        />
        <t-text-box-number
          v-if="isCustomer === true"
          id="anyDeskID"
          v-model="dataEntryModel.anyDeskID"
          :rules="{ min: 9, max: 9 }"
          label="ای-دی انی دسک"
        />

        <t-text-area
          v-if="!isCustomer && !isAdmin"
          id="staffSignature"
          v-model="dataEntryModel.staffSignature"
          label="امضای کارمند"
        />

        <t-file
          v-if="true"
          id="userImage"
          v-model="dataEntryModel.userImage"
          label="انتخاب فایل"
        />
        <t-file-manager
          v-if="false"
          id="userImage"
          v-model="dataEntryModel.userImage"
          label="عکس پروفایل"
        />
        <div>
          <b-button variant="success" title="جستجو" size="sm" @click="onSave">
            <font-awesome-icon icon="check" size="sm" />
            <span>اعمال تغییرات</span>
          </b-button>
        </div>
      </b-card-text>
    </b-card>
  </b-overlay>
</template>

<script>
import { mapGetters } from 'vuex'
import TTextBoxNumber from '~/components/dataentry/TTextBoxNumber.vue'
import TFile from '~/components/dataentry/TFile.vue'
import TFileManager from '~/components/dataentry/TFileManager.vue'
import TTextBoxEmail from '~/components/dataentry/TTextBoxEmail.vue'
import TTextArea from '~/components/dataentry/TTextArea.vue'

export default {
  name: 'Profile',
  components: { TTextBoxNumber, TFile, TFileManager, TTextBoxEmail, TTextArea },
  data () {
    return {
      title: 'ویرایش پروفایل',
      isLoading: false,
      dataEntryModel: {}
    }
  },
  head () {
    return {
      title: this.title
    }
  },
  computed: {
    ...mapGetters({
      isCustomer: '_user/IS_CUSTOMER',
      isAdmin: '_user/IS_ADMIN'
    })
  },
  // computed: {
  //   ...mapGetters({
  //     serverID: '_user/GET_DEFAULT_SERVERID'
  //   }),
  //   mode () {
  //     if (JSON.stringify(this.dataEntryModel) === '{}') {
  //       return 'INSERT'
  //     }
  //     return 'UPDATE'
  //   }
  // },
  async created () {
    this.isLoading = true
    await this.retrieveRecord()
    this.isLoading = false
  },
  methods: {
    async retrieveRecord () {
      const filterParams = {}
      filterParams.srIDs = this.serverID
      const response = await this.$taxios.get(
        'tkt/profile/userID',
        filterParams
      )
      if (response.data !== '') {
        // 200
        this.dataEntryModel = response.data
      }
    },
    onSave () {
      this.onUpdate()
    },
    onUpdate () {
      this.isLoading = true
      const dataEntryModel = JSON.parse(JSON.stringify(this.dataEntryModel))
      this.$taxios
        .put('tkt/profile', null, dataEntryModel)
        .then((response) => {
          this.isLoading = false
          if (response.status === 200) {
            this.$ttoast.createToast(
              'info',
              200,
              'OK',
              'Record updated successfully',
              'رکورد با موفقیت آپدیت شد',
              3000
            )
          }
        })
        .catch(() => {
          this.isLoading = false
        })
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
</style>
