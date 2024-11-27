const applicationInfo = {
  namespaced: true,
  state: () => ({
    varsion: null
  }),
  mutations: {
    SET_VERSION (state, varsion) {
      state.varsion = varsion
    }
  },
  getters: {
    GET_VERSION (state) {
      return state.varsion
    }
  },
  actions: {
    clear ({ commit }) {
      commit('SET_VERSION', null)
    },
    async retrieve ({ commit }) {
      const response = await this.$taxios.get('applicationinfo/version')
      commit('SET_VERSION', response.data.apiVersion)
    }
  }
}
export default applicationInfo
