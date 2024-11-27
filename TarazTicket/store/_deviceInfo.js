const deviceInfo = {
  namespaced: true,
  state: () => ({
    width: null,
    height: null
  }),
  mutations: {
    SET_WIDTH (state, width) {
      state.width = width
    },
    SET_HEIGHT (state, height) {
      state.height = height
    }
  },
  getters: {
    GET_WIDTH (state) {
      return state.width
    },
    GET_HEIGHT (state) {
      return state.height
    },
    GET_DEVICE_TYPE (state) {
      if (state.width < 576) {
        return 'SMALL'
      }
      return 'LARGE'
    },
    GET_MENU_HEIGHT (state, getters) {
      if (getters.GET_DEVICE_TYPE === 'SMALL') {
        return 57
      }
      return 80
    }
  },
  actions: {
    setSize ({ commit }, { width, height }) {
      commit('SET_WIDTH', width)
      commit('SET_HEIGHT', height)
    }
  }
}
export default deviceInfo
