const servers = {
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
    GET_DATA (state) {
      return state.data
    },
    GET_OPTIONS (state) {
      // ابن مورد برای استتوس بار است
      const options = []
      if (state.data != null) {
        state.data.forEach((server) => {
          options.push({ text: server.serverDesc, value: server.serverID })
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
        const responseServers = await this.$taxios.get('pub/servers')
        commit('SET_DATA', responseServers.data)
        return true
      } catch (error) {
        return false
      }
    }
  }
}
export default servers
