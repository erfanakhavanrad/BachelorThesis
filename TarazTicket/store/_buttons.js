const buttons = {
  namespaced: true,
  state: () => ({
    data: []
  }),
  mutations: {
    SET_DATA (state, data) {
      state.data = data
    }
  },
  getters: {
    GET_DATA: (state) => {
      return state.data
    },
    GET_MENUS: (state) => {
      return state.data.filter(button => button.fatherID === 0)
    },
    GET_SUB_MENUS: state => (buttonID) => {
      return state.data.filter(button => button.fatherID === buttonID)
    },
    GET_ACCESSIBILITY_BY_BUTTONID: state => (buttonID) => {
      const menu = state.data.find(button => button.buttonID === buttonID)
      return {
        canAdd: menu.canAdd,
        canDel: menu.canDel,
        canEdit: menu.canEdit,
        canPrint: menu.canPrint,
        canView: menu.canView
      }
    },
    GET_ACCESSIBILITY_BY_WEBADDRESS: state => (webAddress) => {
      const menu = state.data.find(button => button.webAddress === webAddress)
      if (menu === undefined) {
        return {
          canAdd: false,
          canDel: false,
          canEdit: false,
          canPrint: false,
          canView: false
        }
      }
      return {
        canAdd: menu.canAdd,
        canDel: menu.canDel,
        canEdit: menu.canEdit,
        canPrint: menu.canPrint,
        canView: menu.canView
      }
    }
  },
  actions: {
    clear ({ commit }) {
      commit('SET_DATA', [])
    },
    async retrieve ({ commit }, payload) {
      try {
        const params = {}
        params.userID = payload.perComID
        params.systemID = 46
        params.canView = true
        const responseButtons = await this.$taxios.get('pub/buttons', params)
        if (responseButtons.data === '') {
          this.$ttoast.createToast(
            'info',
            responseButtons.status,
            'No Content',
            'Not access to any of the systems',
            'این کاربر به هیچ سیستمی دسترسی ندارد'
          )
          return false
        }
        commit('SET_DATA', responseButtons.data)
        return true
      } catch (error) {
        return false
      }
    }
  }
}
export default buttons
