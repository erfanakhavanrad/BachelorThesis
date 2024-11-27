const user = {
  namespaced: true,
  state: () => ({
    data: {},
    yearIDs: [],
    serverIDs: []
  }),
  mutations: {
    SET_DATA (state, data) {
      state.data = data
    },
    SET_YEARIDS (state, yearIDs) {
      state.yearIDs = yearIDs
    },
    SET_SERVERIDS (state, serverIDs) {
      state.serverIDs = serverIDs
    }
  },
  getters: {
    GET_DATA (state) {
      return state.data
    },
    GET_PERCOMID (state) {
      return state.data.perComID
    },
    GET_DEFAULT_SERVERID (state) {
      return state.data.defaultServerID
    },
    GET_NAME_FAMILY (state) {
      return state.data.name + ' ' + state.data.family
    },
    GET_USER_IMAGE (state) {
      return state.data.userImage
    },
    GET_USER_IMAGE_BASE64 (state, getters) {
      // فرمت مناسب برای نمایش عکس در اچ تی ام ال
      if (getters.GET_USER_IMAGE == null) {
        return null
      }
      return `data:image/png;base64, ${getters.GET_USER_IMAGE}`
    },
    HAS_OWNERSHIP (state) {
      return state.data.hasOwnership
    },
    IS_ADMIN (state) {
      return state.data.isAdmin
    },
    IS_CUSTOMER (state) {
      return state.data.isCustomer
    },
    GET_ORGANIZATIONID (state) {
      return state.data.organizationID
    },
    GET_YEARIDS (state) {
      return state.yearIDs
    },
    GET_SERVERIDS (state) {
      return state.serverIDs
    },
    GET_DEPARTMENTIDS (state) {
      return state.data.departmentIDs
    },
    GET_DEPARTMENTNAMES (state) {
      return state.data.departmentNames
    }
  },
  actions: {
    clear ({ commit }) {
      commit('SET_DATA', {})
      commit('SET_YEARIDS', [])
      commit('SET_SERVERIDS', [])
    },
    async retrieve ({ commit }) {
      try {
        const responseUser = await this.$taxios.get('applicationinfo/default')

        // در سیستم تیکتینگ فیلد
        // isCustomer
        // مهم است بخاطر همین وب سرویس زیر را فراخوانی کرده تا
        // این فیلد را بدست آوریم و به آبجکت یوزر در استور اضافه کنیم
        const responseTktUser = await this.$taxios.get(
          'tkt/users/' + responseUser.data.perComID
        )

        // اضافه کردن
        // isCustomer  عکس   و
        // و isAdmin
        // organizationID برای وقتی مشتری لاگین می کند
        // به آبجکت

        const data = Object.assign({}, responseUser.data, {
          isAdmin: responseTktUser.data.isAdmin,
          isCustomer: responseTktUser.data.isCustomer,
          userImage: responseTktUser.data.userImage,
          organizationID: responseTktUser.data.organizationID,
          hasOwnership: responseTktUser.data.hasOwnership,
          departmentIDs: responseTktUser.data.departmentIDs
            .split(',')
            .map((el) => {
              const n = Number(el)
              return n === 0 ? n : n || el
            }),
          departmentNames: responseTktUser.data.departmentNames.split(',')
        })

        commit('SET_DATA', data)

        // باید سال پیش فرض و سرور پیش فرض کاربر در متغیر مربوطه قرار گیرد
        const yearIDs = []
        yearIDs.push(responseUser.data.activeYearID)
        commit('SET_YEARIDS', yearIDs)

        const serverIDs = []
        serverIDs.push(responseUser.data.defaultServerID)
        commit('SET_SERVERIDS', serverIDs)

        return true
      } catch (error) {
        return false
      }
    },
    changeYearIDs ({ commit }, { yearIDs }) {
      commit('SET_YEARIDS', yearIDs)
    },
    changeServerIDs ({ commit }, { serverIDs }) {
      commit('SET_SERVERIDS', serverIDs)
    }
  }
}
export default user
