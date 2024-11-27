const db = {
  namespaced: true,
  state: () => ({
    name: null
  }),
  mutations: {
    SET_NAME (state, name) {
      state.name = name
    }
  },
  getters: {
    GET_NAME (state) {
      return state.name
    }
  },
  actions: {
    clear ({ commit }) {
      commit('SET_NAME', null)
    },
    async retrieve ({ commit }) {
      const responseDB = await this.$taxios.get('pub/db')
      commit('SET_NAME', responseDB.data.dbName)
    }
  }
}
export default db
