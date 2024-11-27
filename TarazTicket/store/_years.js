const _years = {
  namespaced: true, // salam126677
  state: () => ({
    data: null
  }),
  mutations: {
    SET_DATA (state, data) {
      state.data = data
    }
  },
  getters: {
    GET_DATA (state) {
      return state.data
    },
    GET_OPTIONS (state) {
      // ابن مورد برای استتوس بار است
      const options = []
      if (state.data != null) {
        state.data.forEach((year) => {
          options.push({ text: year.yearDesc, value: year.yearID })
        })
      }
      return options
    }
  },
  actions: {
    clear ({ commit }) {
      commit('SET_DATA', null)
    },
    async retrieve ({ commit }) {
      try {
        const responseYears = await this.$taxios.get('pub/years')
        commit('SET_DATA', responseYears.data)
        return true
      } catch (error) {
        return false
      }
    }
  }
}
export default _years
