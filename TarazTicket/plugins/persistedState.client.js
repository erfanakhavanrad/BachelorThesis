import createPersistedState from 'vuex-persistedstate'

export default ({ store }) => {
  createPersistedState({
    paths: [
      'authentication',
      '_deviceInfo'

      // 'db',
      // 'servers',
      // 'theme',
      // 'user',
      // '_years'
    ]
  })(store)
}
