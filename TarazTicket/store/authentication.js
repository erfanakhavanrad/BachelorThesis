const authentication = {
  namespaced: true,
  state: () => ({
    protocol: 'http',
    ip: null,
    port: null,
    token: '',
    expireTime: null
  }),
  mutations: {
    SET_PROTOCOL (state, protocol) {
      state.protocol = protocol
    },
    SET_IP (state, ip) {
      state.ip = ip
    },
    SET_PORT (state, port) {
      state.port = port
    },
    SET_TOKEN (state, token) {
      state.token = token
    },
    SET_EXPIRETIME (state, expireTime) {
      state.expireTime = expireTime
    }
  },
  getters: {
    GET_PROTOCOL: (state) => {
      return state.protocol
    },
    GET_IP: (state) => {
      return state.ip
    },
    GET_PORT: (state) => {
      return state.port
    },
    GET_TOKEN: (state) => {
      return state.token
    },
    GET_EXPIRETIME: (state) => {
      return state.expireTime
    },
    GET_URL: (state) => {
      return (
        state.protocol +
        '//' +
        state.ip +
        ':' +
        state.port +
        '/' +
        process.env.PREFIX +
        '/'
      )
    }
  },
  actions: {
    clear ({ commit }) {
      commit('SET_TOKEN', '')
      commit('SET_EXPIRETIME', null)
    },
    async authenticate ({ commit, getters }, { username, password }) {
      try {
        const responseAuthenticate = await this.$axios.$post(
          getters.GET_URL + 'authenticate',
          {
            username,
            password
          }
        )

        const token = responseAuthenticate.token
        const expire = responseAuthenticate.expire
        commit('SET_TOKEN', token)
        const expireTime = new Date().getTime() + expire
        commit('SET_EXPIRETIME', expireTime)
        return true
      } catch (error) {
        return false
      }
    },
    async register ({ commit, getters }, { userLoginName, androidUserPass }) {
      try {
        const responseAuthenticate = await this.$axios.$post(
          getters.GET_URL + 'tkt/register',
          {
            userLoginName,
            androidUserPass
          }
        )

        const token = responseAuthenticate.token
        const expire = responseAuthenticate.expire
        commit('SET_TOKEN', token)
        const expireTime = new Date().getTime() + expire
        commit('SET_EXPIRETIME', expireTime)
        return true
      } catch (error) {
        return false
      }
    }
  }
}
export default authentication
