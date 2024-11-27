const theme = {
  namespaced: true,
  state: () => ({
    data: null
  }),
  mutations: {
    SET_DATA (state, data) {
      state.data = data
    }
  },
  getters: {
    GET_DATA: (state) => {
      return state.data
    }
  },
  actions: {
    clear ({ commit }) {
      commit('SET_DATA', 'theme-d-200')
    },
    apply ({ commit }, { theme }) {
      if (theme === null) {
        commit('SET_DATA', 'theme-d-200')
      } else {
        commit('SET_DATA', theme)
      }
    }
  }
}
export default theme
