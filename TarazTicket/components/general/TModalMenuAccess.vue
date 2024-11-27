<template>
  <t-modal
    v-model="visibility"
    :title="`دسترسی به منو برای  ${userName}`"
    variant="secondary"
    size="lg"
    @ok="onOk"
    @cancel="onCancel"
    @close="onClose"
    @hide="onHide"
  >
    <div class="t-container-menus" :style="`height:${documentHeight * 0.8}px;`">
      <table class="t-table">
        <tr class="t-tr-header">
          <th>
            <span>نام منو</span>
          </th>
          <th><span>نمایش</span></th>
          <th><span>ایجاد</span></th>
          <th><span>ویرایش</span></th>
          <th><span>حذف</span></th>
          <th><span>چاپ</span></th>
        </tr>
        <tr
          v-for="menu in menusAll"
          :key="menu.buttonID"
          :class="
            menu.fatherID == 0 ? 't-tr-rows t-tr-row-parent' : 't-tr-rows'
          "
        >
          <td class="t-buttonDesc">
            <span :class="menu.fatherID == 0 ? 't-father' : 't-child'">{{
              menu.buttonDesc
            }}</span>
          </td>
          <td class="t-canView">
            <b-form-checkbox
              v-model="menu.canView"
              switch
              class="t-checkbox"
              size="sm"
              @change="onChangeCheckbox(menu, 'canView')"
            />
          </td>
          <td class="t-canAdd">
            <b-form-checkbox
              v-model="menu.canAdd"
              switch
              class="t-checkbox"
              size="sm"
              @change="onChangeCheckbox(menu, 'canAdd')"
            />
          </td>
          <td class="t-canEdit">
            <b-form-checkbox
              v-model="menu.canEdit"
              switch
              class="t-checkbox"
              size="sm"
              @change="onChangeCheckbox(menu, 'canEdit')"
            />
          </td>
          <td class="t-canDel">
            <b-form-checkbox
              v-model="menu.canDel"
              switch
              class="t-checkbox"
              size="sm"
              @change="onChangeCheckbox(menu, 'canDel')"
            />
          </td>
          <td class="t-canPrint">
            <b-form-checkbox
              v-model="menu.canPrint"
              switch
              class="t-checkbox"
              size="sm"
              @change="onChangeCheckbox(menu, 'canPrint')"
            />
          </td>
        </tr>
      </table>
    </div>
  </t-modal>
</template>

<script>
import { mapGetters } from 'vuex'
import TModal from '~/components/general/TModal.vue'

export default {
  name: 'TModalMenuAccess',
  components: {
    TModal
  },
  props: {
    id: {
      type: String,
      default: null
    }
  },

  data () {
    return {
      visibility: false,
      userID: null,
      userName: null,
      menusAccessible: [],
      menusAll: [],
      onOkCallback: undefined,
      onCancelCallback: undefined,
      onCloseCallback: undefined,
      onHideCallback: undefined
    }
  },
  computed: {
    ...mapGetters({
      documentHeight: '_deviceInfo/GET_HEIGHT'
    })
  },
  watch: {
    visibility: {
      async handler (_visibility) {
        if (_visibility) {
          await this.retrieveAccessibleMenus()
        }
      }
    }
    // menusAll: {
    //   handler (_menusAll) {
    //     _menusAll.forEach((menu) => {
    //     })
    //   },
    //   deep: true
    // }
  },
  async created () {
    await this.retrieveAllMenus()
  },
  methods: {
    show (
      userID,
      userName,
      onOkCallback,
      onCancelCallback,
      onCloseCallback,
      onHideCallback
    ) {
      this.userID = userID
      this.userName = userName
      this.visibility = true
      this.onOkCallback = onOkCallback
      this.onCancelCallback = onCancelCallback
      this.onCloseCallback = onCloseCallback
      this.onHideCallback = onHideCallback
    },
    async retrieveAllMenus () {
      const params = {}
      params.systemID = 46
      params.canView = false
      const response = await this.$taxios.get('pub/buttons', params)
      response.data.forEach((button) => {
        this.menusAll.push({
          buttonID: button.buttonID,
          buttonDesc: button.buttonDesc,
          canAdd: false,
          canDel: false,
          canEdit: false,
          canPrint: false,
          canView: false,
          fatherID: button.fatherID,
          isLeaf: button.isLeaf
        })
      })
    },
    async retrieveAccessibleMenus () {
      this.clearMenusAccess()
      const params = {}
      params.userID = this.userID
      params.systemID = 46
      const response = await this.$taxios.get('pub/userbuttonaccess', params)
      if (response.data !== '') {
        response.data.forEach((menuAccessible) => {
          const index = this.menusAll.findIndex(
            menuAll => menuAll.buttonID === menuAccessible.buttonID
          )
          this.menusAll[index].userID = this.userID
          this.menusAll[index].canAdd = menuAccessible.canAdd
          this.menusAll[index].canDel = menuAccessible.canDel
          this.menusAll[index].canEdit = menuAccessible.canEdit
          this.menusAll[index].canPrint = menuAccessible.canPrint
          this.menusAll[index].canView = menuAccessible.canView
        })
      }
    },
    clearMenusAccess () {
      // همه تیک ها را از چک باکس ها بر میدارد
      // یوزر آی دی این رکورد در
      // menusAll
      // قرار می گیرد
      this.menusAll.forEach((menu) => {
        menu.userID = this.userID
        menu.canAdd = false
        menu.canDel = false
        menu.canEdit = false
        menu.canPrint = false
        menu.canView = false
      })
    },
    onOk () {
      this.$taxios
        .post('pub/userbuttonaccess', this.menusAll)
        .then((response) => {
          if (response.status === 200) {
            if (this.onOkCallback !== undefined) {
              this.onOkCallback(this.menusAll)
            }
            this.$ttoast.createToast(
              'info',
              200,
              'OK',
              'User menu access updated!',
              'دسترسی های این کاربر آپدیت شد!',
              3000
            )
          }
        })
        .catch(() => {})
    },
    onCancel () {
      if (this.onCancelCallback !== undefined) {
        this.onCancelCallback()
      }
    },
    onClose () {
      if (this.onCloseCallback !== undefined) {
        this.onCloseCallback()
      }
    },
    onHide () {
      if (this.onHideCallback !== undefined) {
        this.onHideCallback()
      }
    },
    onChangeCheckbox (menu, fieldName) {
      if (menu.fatherID === 0) {
        // این منوی سطح یک است
        if (menu.isLeaf) {
          // این منویی است که متناظر به یک صفحه است و فرزند ندارد
        } else {
          // این منو فرزند دارد
          const _menus = this.menusAll.filter((_menu) => {
            return _menu.fatherID === menu.buttonID
          })
          _menus.forEach((child) => {
            child[fieldName] = menu[fieldName]
          })
        }
      } else if (menu[fieldName]) {
        // این منویی است که متناظر به یک صفحه است
        // باید پرنت این منو هم تیک بخورد
        const _menu = this.menusAll.find((_menu) => {
          return _menu.buttonID === menu.fatherID
        })
        _menu[fieldName] = true
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.t-container-menus {
  display: flex;
  width: 100%;
  overflow-y: auto;
  flex-direction: column;
  align-items: flex-start;
  margin: 10px;
  .t-table {
    width: 100%;
    font-family: 'IRANSansX' !important;
    font-size: smaller;
    .t-tr-header {
      height: 40px;
      position: sticky;
      top: 0;
      // background-color: gainsboro;
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
      z-index: 2;
    }
    .t-tr-rows {
      &:hover {
        background-color: hsl(200, 70%, 80%);
      }
    }
    .t-tr-row-parent {
      // background-color: #f4f4f4;
      background-color: hsl(200, 80%, 95%);
    }
    th {
      text-align: center;
      span {
        // border: 1px solid rgb(173, 172, 172);

        display: flex;
        justify-content: center;
        align-items: center;
        width: 100%;
        height: 40px;
      }
    }
    td {
      // border: 1px solid gainsboro;
      border-bottom: 2px solid gainsboro;
      &:hover {
        background-color: hsl(200, 90%, 70%);
      }
    }
    .t-buttonDesc {
      text-align: right;
      // border: 1px solid gainsboro;
      // border-right: 2px solid gainsboro;
      margin-right: 20px;
      .t-father {
        font-weight: bold;
        padding-right: 5px;
      }
      .t-child {
        padding-right: 25px;
      }
    }
    .t-canView {
      text-align: center;
      .t-checkbox {
        width: 100%;
        :deep(input) {
          width: 100%;
          ::before {
            text-align: center;
          }
        }
      }
    }
    .t-canAdd {
      text-align: center;
      .t-checkbox {
        width: 100%;
        :deep(input) {
          width: 100%;
          ::before {
            text-align: center;
          }
        }
      }
    }
    .t-canEdit {
      text-align: center;
      .t-checkbox {
        width: 100%;
        :deep(input) {
          width: 100%;
          ::before {
            text-align: center;
          }
        }
      }
    }
    .t-canDel {
      text-align: center;
      .t-checkbox {
        width: 100%;
        :deep(input) {
          width: 100%;
          ::before {
            text-align: center;
          }
        }
      }
    }
    .t-canPrint {
      text-align: center;
      .t-checkbox {
        width: 100%;
        :deep(input) {
          width: 100%;
          ::before {
            text-align: center;
          }
        }
      }
    }
  }
}
</style>
