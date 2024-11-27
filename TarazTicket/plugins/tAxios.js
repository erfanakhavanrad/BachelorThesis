export class TAxios {
  axios
  store

  constructor (axios, store) {
    this.axios = axios
    this.store = store
  }

  get (resource, params) {
    // todo
    // برای منطق ابف زیر یه راه حل دیگه پیدا کن
    // if (
    //   this.store.getters['authentication/GET_EXPIRETIME'] < new Date().getTime()
    // ) {
    //   await this.refreshToken()
    // }
    // url is :"http://localhost:8080/tws/"
    const url = this.store.getters['authentication/GET_URL']
    const token = this.store.getters['authentication/GET_TOKEN']
    return new Promise((resolve, reject) => {
      this.axios
        .get(url + resource, {
          params,
          headers: {
            Authorization: 'Bearer ' + token
          }
        })
        .then((response) => {
          return resolve(response)
        })
        .catch((error) => {
          return reject(error)
        })
    })
  }

  async post (resource, data) {
    if (
      this.store.getters['authentication/GET_EXPIRETIME'] < new Date().getTime()
    ) {
      await this.refreshToken()
    }

    const url = this.store.getters['authentication/GET_URL']
    const token = this.store.getters['authentication/GET_TOKEN']
    return new Promise((resolve, reject) => {
      this.axios
        .post(url + resource, data, {
          headers: {
            Authorization: 'Bearer ' + token
          }
        })
        .then((response) => {
          return resolve(response)
        })
        .catch((error) => {
          return reject(error)
        })
    })
  }

  async put (resource, path, data) {
    if (
      this.store.getters['authentication/GET_EXPIRETIME'] < new Date().getTime()
    ) {
      await this.refreshToken()
    }

    const url = this.store.getters['authentication/GET_URL']
    const token = this.store.getters['authentication/GET_TOKEN']
    let urlMain
    if (path == null) {
      urlMain = url + resource
    } else {
      urlMain = url + resource + '/' + path
    }
    return new Promise((resolve, reject) => {
      this.axios
        .put(urlMain, data, {
          headers: {
            Authorization: 'Bearer ' + token
          }
        })
        .then((response) => {
          return resolve(response)
        })
        .catch((error) => {
          return reject(error)
        })
    })
  }

  async patch (resource, path, data) {
    if (
      this.store.getters['authentication/GET_EXPIRETIME'] < new Date().getTime()
    ) {
      await this.refreshToken()
    }

    const url = this.store.getters['authentication/GET_URL']
    const token = this.store.getters['authentication/GET_TOKEN']
    return new Promise((resolve, reject) => {
      this.axios
        .patch(url + resource + '/' + path, data, {
          headers: {
            Authorization: 'Bearer ' + token
          }
        })
        .then((response) => {
          return resolve(response)
        })
        .catch((error) => {
          return reject(error)
        })
    })
  }

  async delete (resource, path, params) {
    if (
      this.store.getters['authentication/GET_EXPIRETIME'] < new Date().getTime()
    ) {
      await this.refreshToken()
    }

    const url = this.store.getters['authentication/GET_URL']
    const token = this.store.getters['authentication/GET_TOKEN']
    return new Promise((resolve, reject) => {
      this.axios
        .delete(url + resource + '/' + path, {
          params,
          headers: {
            Authorization: 'Bearer ' + token
          }
        })
        .then((response) => {
          return resolve(response)
        })
        .catch((error) => {
          return reject(error)
        })
    })
  }

  async refreshToken () {
    const url = this.store.getters['authentication/GET_URL']
    let token = this.store.getters['authentication/GET_TOKEN']
    const responseRefreshToken = await this.axios.get(
      url + 'authenticate/refreshtoken',
      {
        headers: {
          Authorization: 'Bearer ' + token
        }
      }
    )
    token = responseRefreshToken.data.token
    const expire = responseRefreshToken.data.expire

    this.store.commit('authentication/SET_TOKEN', token)

    const expireTime = new Date().getTime() + expire
    this.store.commit('authentication/SET_EXPIRETIME', expireTime)
  }

  async pdf (resource, params, title) {
    if (
      this.store.getters['authentication/GET_EXPIRETIME'] < new Date().getTime()
    ) {
      await this.refreshToken()
    }
    const url = this.store.getters['authentication/GET_URL']
    const token = this.store.getters['authentication/GET_TOKEN']
    return new Promise((resolve, reject) => {
      this.axios
        .get(url + resource, {
          params,
          headers: {
            Authorization: 'Bearer ' + token
          },
          responseType: 'blob'
        })
        .then((response) => {
          switch (response.status) {
            case 200: {
              const url = window.URL.createObjectURL(new Blob([response.data]))
              const a = document.createElement('a')
              a.href = url
              a.download = title + '.pdf'
              a.click()
              a.remove()
              return resolve(true)
            }
            default:
              return resolve(false)
          }
        })
        .catch((error) => {
          return reject(error)
        })
    })
  }

  async excel (resource, params, title) {
    // i think this convert to independent function

    if (
      this.store.getters['authentication/GET_EXPIRETIME'] < new Date().getTime()
    ) {
      await this.refreshToken()
    }
    const url = this.store.getters['authentication/GET_URL']
    const token = this.store.getters['authentication/GET_TOKEN']
    return new Promise((resolve, reject) => {
      this.axios
        .get(url + resource, {
          params,
          headers: {
            Authorization: 'Bearer ' + token
          },
          responseType: 'blob'
        })
        .then((response) => {
          switch (response.status) {
            case 200: {
              // const url = window.URL.createObjectURL(new Blob([response.data]))
              const url = window.URL.createObjectURL(
                this.writeXlsxFile.writeXlsxFile({ fileName: 'file.xlsx' })
              )
              const a = document.createElement('a')
              a.href = url
              a.download = title + '.xlsx'
              a.click()
              a.remove()
              return resolve(true)
            }
            default:
              return resolve(false)
          }
        })
        .catch((error) => {
          return reject(error)
        })
    })
  }

  getForDl (resource, params) {
    // todo
    // برای منطق ابف زیر یه راه حل دیگه پیدا کن
    // if (
    //   this.store.getters['authentication/GET_EXPIRETIME'] < new Date().getTime()
    // ) {
    //   await this.refreshToken()
    // }
    const url = this.store.getters['authentication/GET_URL']
    const token = this.store.getters['authentication/GET_TOKEN']
    return new Promise((resolve, reject) => {
      this.axios
        .get(url + resource, {
          params,
          headers: {
            Authorization: 'Bearer ' + token
          },
          responseType: 'blob'
        })
        .then((response) => {
          return resolve(response)
        })
        .catch((error) => {
          return reject(error)
        })
    })
  }
}
export default ({ $axios, store }, inject) => {
  inject('taxios', new TAxios($axios, store))
}
