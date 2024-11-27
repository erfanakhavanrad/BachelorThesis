<template>
  <ClientOnly>
    <b-overlay v-if="tktMenus.length == 0" show class="t-loading" />
    <div v-else :class="`${theme} t-container-page`">
      <!-- <div class="t-navbar-container" :style="navbarContainerStyle" :dir="$dir()"> -->

      <!-- <t-text-box-string
        id="departmentName"
        label="عنوان"
        :title="title"
        resource-data="tkt/tickets"
        resource-meta="tkt/tickets/meta"
        main-field-name="ticketTitle"
        :filter-params="filterParams"
      />
      <b-button variant="primary" title="جستجو" @click="onFilter">
        <span>جستجو</span>
        <font-awesome-icon icon="search" size="lg" />
      </b-button> -->
      <!-- khers -->
      <div class="t-navbar-container" :style="navbarContainerStyle">
        <b-navbar toggleable="sm" type="dark" variant="dark" class="t-navbar">
          <b-navbar-toggle target="nav-collapse" />
          <b-collapse id="nav-collapse" is-nav>
            <!-- <b-navbar-nav
            class="t-navbar-nav"
            :class="$dir() === 'ltr' ? 'mr-auto' : 'ml-auto'"
            :dir="$dir()"
          > -->
            <b-navbar-nav class="t-navbar-nav">
              <template v-for="tktMenu in tktMenus">
                <b-nav-item
                  v-if="tktMenu.isLeaf"
                  :key="tktMenu.buttonID"
                  link-classes="t-link-class"
                  :to="{ name: tktMenu.webAddress }"
                  @click="onCurrentPageRefresh"
                >
                  <div class="t-nav-item">
                    <font-awesome-icon
                      :icon="menuIcon(tktMenu.buttonDesc)"
                      size="lg"
                    />
                    {{ tktMenu.buttonDesc }}
                  </div>
                </b-nav-item>
                <b-nav-item-dropdown
                  v-else
                  :key="tktMenu.buttonID"
                  toggle-class="t-toggle-class"
                >
                  <template #button-content>
                    <div class="t-nav-item-dropdown">
                      <font-awesome-icon
                        :icon="menuIcon(tktMenu.buttonDesc)"
                        size="lg"
                      />
                      {{ tktMenu.buttonDesc }}
                    </div>
                  </template>
                  <template v-for="tktSubMenu in tktSubMenus(tktMenu.buttonID)">
                    <b-dropdown-item
                      :key="tktSubMenu.buttonID"
                      :to="{ name: tktSubMenu.webAddress }"
                      link-class="t-dropdown-item-link-class"
                    >
                      <div>
                        <font-awesome-icon
                          :icon="subMenuIcon(tktSubMenu.buttonDesc)"
                          size="sm"
                        />
                        <span>
                          {{ tktSubMenu.buttonDesc }}
                        </span>
                      </div>
                    </b-dropdown-item>
                  </template>
                </b-nav-item-dropdown>
              </template>
            </b-navbar-nav>
          </b-collapse>
          <b-navbar-brand @click="onClickNavbarBrand">
            <span id="nameFamily">{{ nameFamily }}</span>
            <b-avatar
              v-if="userImageBase64 == null"
              variant="info"
              icon="person-fill"
            />
            <b-avatar v-else>
              <img :src="userImageBase64">
            </b-avatar>
          </b-navbar-brand>
        </b-navbar>
      </div>
      <b-button
        v-if="isVisibleGotoBottom"
        id="gotobottom"
        variant="secondary"
        title="پایین صفحه"
        @click="$tscroll.onScrollToBottom"
      >
        <font-awesome-icon icon="angle-down" size="lg" />
      </b-button>
      <b-button
        v-if="isVisibleGotoTop"
        id="gototop"
        variant="secondary"
        title="بالای صفحه"
        @click="$tscroll.onScrollToTop"
      >
        <font-awesome-icon icon="angle-up" size="lg" />
      </b-button>

      <Nuxt />
      <b-modal
        v-model="infoVisibility"
        size="sm"
        centered
        hide-header
        hide-footer
        body-class="info-modal-body-class"
      >
        <template #default>
          <div id="info-container">
            <b-list-group class="t-list-group">
              <b-list-group-item
                class="t-list-group-item avatar"
                style="background-color: var(--t-color-0-0-75)"
              >
                <b-avatar
                  v-if="userImageBase64 == null"
                  variant="info"
                  icon="person-fill"
                  size="7rem"
                />
                <b-avatar v-else size="7rem">
                  <img :src="userImageBase64">
                </b-avatar>
              </b-list-group-item>
              <b-list-group-item class="t-list-group-item">
                <span>{{ nameFamily }}</span>
                <b-avatar icon="person" size="sm" variant="light" />
              </b-list-group-item>
              <b-list-group-item class="t-list-group-item">
                <span>مدیر</span>
                <b-avatar
                  :icon="isAdmin ? 'check-square' : 'square'"
                  size="sm"
                  variant="light"
                />
              </b-list-group-item>
              <b-list-group-item class="t-list-group-item">
                <span>مشتری</span>
                <b-avatar
                  :icon="isCustomer ? 'check-square' : 'square'"
                  size="sm"
                  variant="light"
                />
              </b-list-group-item>
              <b-list-group-item class="t-list-group-item">
                <span>Backend Version</span>
                <span>{{ backendVersion }}</span>
              </b-list-group-item>
              <b-list-group-item class="t-list-group-item">
                <span>Frontend Version</span>
                <span>{{ frontendVersion }}</span>
              </b-list-group-item>
              <b-list-group-item class="t-list-group-item">
                <span>Database</span>
                <span>{{ dbName }}</span>
              </b-list-group-item>
            </b-list-group>
          </div>
        </template>
      </b-modal>

      <!-- <br><br>
    <hr class="w-75 m-auto">
    <b-navbar type="white">
      <b-navbar-nav class="m-auto">
        <b-nav-item href="#" style="font-size: 12px">
          نرم افزار تراز تیکت (نسخه ۱.۰.۰)
        </b-nav-item>
      </b-navbar-nav>
    </b-navbar> -->
    </div>
  </ClientOnly>
</template>
<script>
import { mapGetters } from 'vuex'
import { version } from '@/package.json'
// import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'

export default {
  name: 'Default',
  components: {
    // TTextBoxString
  },

  data () {
    return {
      scrollY: 0,
      scrollHeight: 0,
      clientHeight: 0,
      infoVisibility: false,
      frontendVersion: version
    }
  },
  head () {
    return {
      title: 'در حال بارگذاری'
    }
  },
  computed: {
    ...mapGetters({
      theme: '_theme/GET_DATA',
      tktMenus: '_buttons/GET_MENUS',
      tktSubMenus: '_buttons/GET_SUB_MENUS',
      menuHeight: '_deviceInfo/GET_MENU_HEIGHT',
      nameFamily: '_user/GET_NAME_FAMILY',
      userImageBase64: '_user/GET_USER_IMAGE_BASE64',
      isAdmin: '_user/IS_ADMIN',
      isCustomer: '_user/IS_CUSTOMER',
      backendVersion: '_applicationInfo/GET_VERSION',
      dbName: '_db/GET_NAME'
    }),
    navbarContainerStyle () {
      return `height:${this.menuHeight}px;`
    },
    isVisibleGotoBottom () {
      if (this.scrollHeight === this.clientHeight + this.scrollY) {
        return false
      }
      return true
    },
    isVisibleGotoTop () {
      if (this.scrollY === 0) {
        return false
      }
      return true
    }
  },
  mounted () {
    addEventListener('scroll', this.handleScroll)
  },
  destroyed () {
    removeEventListener('scroll', this.handleScroll)
  },
  methods: {
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

      // filterParams.pageNumber = this.pageNumber
      // filterParams.recordCount = this.recordCount

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
    onFilter () {
      this.$router.push({
        // this.$router.push('/home');
        name: this.parentRoute
        // name: this.routes['/tickets'].name
        // name: this.routes[index].name,
        // params: this.routes[index].params
      })
    },
    getvalue () {
      // khers
      console.log('khers')
    },
    onCurrentPageRefresh () {
      // console.log('Salam')
    },
    onClickNavbarBrand () {
      this.infoVisibility = true
    },
    handleScroll (event) {
      this.scrollY = window.scrollY
      this.scrollHeight = document.body.scrollHeight
      this.clientHeight = document.body.clientHeight
    },
    menuIcon (buttonDesc) {
      switch (buttonDesc) {
        case 'داشبورد':
          return 'tachometer-alt'
        case 'سازمان':
          return 'building'
        case 'مشتریان':
          return 'users'
        case 'تیکت ها':
          return 'ticket-alt'
        case 'پایگاه دانش':
          return 'brain'
        case 'گزارشات':
          return 'chart-pie'
        case 'تنظیمات':
          return 'cogs'
        case 'خروج':
          return 'sign-out-alt'
        default:
          return 'exclamation'
      }
    },
    subMenuIcon (buttonDesc) {
      switch (buttonDesc) {
        case 'دپارتمان ها':
          return 'hotel'
        case 'کارمندان':
          return 'user-friends'
        case 'دسته بندی تیکت ها':
          return 'tags'
        case 'ارسال ایمیل گروهی':
          return 'mail-bulk'
        case 'مشتریان حقوقی':
          return 'industry'
        case 'پرسنل شرکت‌ها':
          return 'users'
        case 'دسته بندی های پایگاه دانش':
          return 'atom'
        case 'مدیریت مقالات پایگاه دانش':
          return 'newspaper'
        case 'مقالات پایگاه دانش':
          return 'file-alt'
        case 'پاسخ پیش فرض':
          return 'envelope-open-text'
        case 'تنظیمات عمومی':
          return 'cogs'
        case 'تنظیمات ایمیل':
          return 'envelope'
        case 'تنظیمات پیامک':
          return 'sms'
        case 'پشتیبان گیری':
          return 'database'
        case 'افزونه ها':
          return 'puzzle-piece'
        case 'ویرایش پروفایل':
          return 'address-card'
        case 'تغییر کلمه عبور':
          return 'key'
        case 'اطلاع رسانی دسکتاپ':
          return 'desktop'
        default:
          return 'exclamation'
      }
    }
  }
}
</script>
<style lang="scss" scoped>
.t-container-page {
  #gotobottom {
    z-index: 4;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    position: fixed;
    left: 0;
    top: 160px;
    margin: 20px;
    opacity: 0.5;
    &:hover {
      opacity: 1;
    }
  }
  #gototop {
    z-index: 4;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    position: fixed;
    left: 0;
    bottom: 0;
    margin: 20px;
    opacity: 0.5;
    &:hover {
      opacity: 1;
    }
  }
  .t-navbar-container {
    z-index: 4;
    position: sticky;
    top: 0;
    background-color: white;
    font-family: 'IRANSansX' !important;
    .t-navbar {
      position: sticky;
      right: 0;
      .t-navbar-nav {
        .t-nav-item {
          display: flex;
          flex-direction: column;
          align-items: center;
        }
        .t-nav-item-dropdown {
          display: flex;
          flex-direction: column;
          align-items: center;
        }
      }
      #nameFamily {
        font-weight: bold;
        font-size: 1rem;
      }
      img {
        object-fit: cover;
        width: 100%;
        height: 100%;
      }
    }
  }
  .t-link-class {
    display: flex;
    flex-direction: row;
    align-items: flex-end;
    justify-content: center;
    margin-right: 1em;
    margin-left: 1em;
  }
  :deep(.t-toggle-class) {
    display: flex;
    flex-direction: row;
    align-items: flex-end;
    justify-content: center;
    margin-right: 1em;
    margin-left: 1em;
    &:after {
      padding-bottom: 0.5em;
      margin-right: 0.2em;
    }
  }
  :deep(.t-dropdown-item-link-class) {
    text-align: right;
    font-size: 0.9em;
    padding-top: 0.5em;
    padding-bottom: 0.5em;
    span {
      padding-right: 0.5em;
    }
  }
}
:deep(.info-modal-body-class) {
  padding: 0;
  margin: 0;
  #info-container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    font-family: 'IRANSansX' !important;

    .t-list-group {
      padding: 5px;
      width: 100%;
      .t-list-group-item {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        align-items: center;
        span {
          font-size: 0.8rem;
        }
      }
      .avatar {
        display: flex;
        flex-direction: column;
        img {
          object-fit: cover;
          width: 100%;
          height: 100%;
        }
      }
    }
  }
}
</style>
