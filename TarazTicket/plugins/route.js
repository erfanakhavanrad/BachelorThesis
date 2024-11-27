export default ({ app, store, error }) => {
  function _isLoggedin () {
    let token = ''
    if (localStorage.getItem('vuex') != null) {
      token = JSON.parse(localStorage.getItem('vuex')).authentication.token
    }
    switch (token) {
      case '':
        // یعنی کاربر لاگین نشده
        return false
      default:
        // یعنی کاربر لاگین شده
        return true
    }
  }
  function _isReload () {
    const backEndVersion = store.getters['_applicationInfo/GET_VERSION']
    switch (backEndVersion) {
      case null:
        // یا کاربر یوآرال را تغییر داده
        // یا صفحه رفرش شده
        return true

      default:
        // یو آر ال دستکاری نشده
        return false
    }
  }
  function _webAddress (routeName) {
    const webAddress = routeName.split('-')[0]
    return webAddress
  }
  function _canView (webAddress) {
    const menuAccessByWebAddress =
      store.getters['_buttons/GET_ACCESSIBILITY_BY_WEBADDRESS']
    const canView = menuAccessByWebAddress(webAddress).canView
    return canView
  }
  app.router.beforeEach(async (to, from, next) => {
    if (process.client) {
      switch (to.name) {
        case 'login':
          next()
          app.$tstore.clear()
          break
        case 'register':
          next()
          app.$tstore.clear()
          break
        default:
          switch (_isLoggedin()) {
            case false: // لاگین نشده
              next({ name: 'login', replace: true })
              break

            default:
              // لاگین شده
              switch (_isReload()) {
                case true:
                  // ریلود شده
                  await app.$tstore.initialize()
                  switch (to.name) {
                    case null:
                      next({
                        name: 'index',
                        replace: true,
                        params: { statusCode: 404, message: 'صفحه یافت نشد !' }
                      })
                      break

                    default: {
                      const webAddress = _webAddress(to.name)
                      switch (webAddress) {
                        case 'index':
                          next()
                          break
                        default:
                          switch (_canView(webAddress)) {
                            case true: // دسترسی مجاز است
                              next()
                              break

                            default:
                              // دسترسی مجاز نیست
                              next({
                                name: webAddress,
                                replace: true,
                                params: {
                                  statusCode: 403,
                                  message: 'دسترسی مجاز نیست !'
                                }
                              })
                              break
                          }
                          break
                      }
                      break
                    }
                  }
                  break

                default:
                  // ریلود نشده
                  next()
                  break
              }
              break
          }
          break
      }
    } else {
      next()
    }
  })

  app.router.afterEach((to, from) => {
    if (process.client) {
      switch (to.params.statusCode) {
        case 403:
        case 404:
          error({
            statusCode: to.params.statusCode,
            message: to.params.message
          })
          break

        default:
          break
      }
    }
  })
}
