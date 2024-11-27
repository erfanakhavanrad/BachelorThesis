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
        <font-awesome-icon class="fa-rotate-270" icon="key" size="lg" />
        <span class="mr-1">تغییر کلمه عبور </span>
      </template>
      <b-card-text class="text-card-info">
        <t-text-box-string
          id="userLoginName"
          v-model="dataEntryModel.userLoginName"
          disabled
          label="نام کاربری"
        />
        <t-text-box-password
          id="password"
          v-model="dataEntryModel.password"
          :rules="rules.password"
          label="کلمه عبور فعلی"
        />
        <t-text-box-password
          id="newPassword"
          v-model="dataEntryModel.newPassword"
          :rules="rules.newPassword"
          label="کلمه عبور جدید"
        />

        <t-text-box-password
          id="newPassword_"
          v-model="dataEntryModel.newPassword_"
          :rules="rules.newPassword_"
          label="تکرار کلمه عبور جدید"
        />

        <div>
          <b-button
            variant="success"
            title="جستجو"
            size="sm"
            @click="changePassword"
          >
            <font-awesome-icon icon="check" size="sm" />
            <span>تغییر کلمه عبور</span>
          </b-button>
        </div>
      </b-card-text>
    </b-card>
  </b-overlay>
</template>

<script>
import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'
import TTextBoxPassword from '~/components/dataentry/TTextBoxPassword.vue'
export default {
  name: 'Changepassword',
  components: { TTextBoxString, TTextBoxPassword },
  data () {
    return {
      title: 'تغییر کلمه عبور',
      isLoading: false,
      dataEntryModel: {},
      show_user: {},
      password: null,
      newPassword: null,
      newPassword_: null,
      rules: {
        password: { required: true, min: 6, max: 30 },
        newPassword: { required: true, min: 6, max: 30 },
        newPassword_: { required: true, min: 6, max: 30 }
      }
    }
  },
  head () {
    return {
      title: this.title
    }
  },
  async created () {
    this.isLoading = true
    await this.retrieveRecord()
    this.isLoading = false
  },
  methods: {
    async retrieveRecord () {
      const filterParams = {}
      filterParams.srIDs = this.serverID
      const response = await this.$taxios.get('tkt/register', filterParams)
      if (response.data !== '') {
        // 200
        this.dataEntryModel = response.data
        this.dataEntryModel.userName = this.dataEntryModel.userLoginName
      }
    },
    changePassword () {
      this.onUpdate()
    },
    onUpdate () {
      this.isLoading = true
      const dataEntryModel = JSON.parse(JSON.stringify(this.dataEntryModel))
      this.$taxios
        .put(
          'tkt/changepassword/' + this.dataEntryModel.userID,
          null,
          dataEntryModel
        )
        .then((response) => {
          this.isLoading = false
          if (response.status === 200) {
            this.$ttoast.createToast(
              'info',
              200,
              'OK',
              'Record updated successfully',
              'پسورد با موفقیت تغییر کرد',
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
