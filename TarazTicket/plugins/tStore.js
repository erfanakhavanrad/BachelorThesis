// وظیفه این کلاس مقداردهی به استور است
// هر زمان
// لاگ اوت شود
// صفحه رفرش شود
// رووت عوض شود
// نیاز است که ماژول های استور مقدار بگیرند
export class TStore {
  store
  router
  constructor (store, router) {
    this.store = store
    this.router = router
  }

  async initialize () {
    // ماژول های حیاتی زیر از سرور دیتا گرفته و پر میشوند
    this.store.dispatch('_theme/clear')
    await this.store.dispatch('_applicationInfo/retrieve')

    await this.store.dispatch('_db/retrieve')
    await this.store.dispatch('_user/retrieve')
    await this.store.dispatch('_years/retrieve')
    await this.store.dispatch('_servers/retrieve')
    const perComID = this.store.getters['_user/GET_PERCOMID']
    await this.store.dispatch('_buttons/retrieve', {
      perComID
    })
  }

  clear () {
    // خالی کردن ماژول های استور
    this.store.dispatch('_theme/clear')
    this.store.dispatch('authentication/clear')
    this.store.dispatch('_applicationInfo/clear')
    this.store.dispatch('_db/clear')
    this.store.dispatch('_user/clear')
    this.store.dispatch('_years/clear')
    this.store.dispatch('_servers/clear')
    this.store.dispatch('_buttons/clear')
  }

  setIpPort () {
    if (process.browser) {
      const ip = window.location.hostname
      const protocol = window.location.protocol
      this.store.commit('authentication/SET_PROTOCOL', protocol)
      this.store.commit('authentication/SET_IP', ip)
      if (process.env.NODE_ENV === 'production') {
        const port = window.location.port
        this.store.commit('authentication/SET_PORT', port)
      } else {
        this.store.commit('authentication/SET_PORT', 8080)
      }
    }
  }
}
export default ({ store, app }, inject) => {
  inject('tstore', new TStore(store, app.router))
}
