export default function ({ $axios, app, redirect }) {
  $axios.onRequest((config) => {})
  $axios.onError((error) => {
    const status = error.response.status
    const data = error.response.data
    switch (status) {
      case 401: // Unauthorized
        app.$ttoast.createToastTokenExpire()
        break
      case 402: // PaymentRequired
        app.$ttoast.createToastLicenseExpire()
        break
      case 403: // Forbidden
        app.$ttoast.createToast(
          'danger',
          data.status,
          data.error,
          data.errors[0].value,
          data.errors[1].value,
          5000
        )
        break
      case 404: // Not Found
        app.$ttoast.createToast(
          'secondary',
          data.status,
          data.error,
          data.message,
          'وب سرویس مورد نظر یافت نشد'
        )
        break
      case 409: // DB Error
        if (data.status < 0) {
          app.$ttoast.createToast('info', status, '', '', data.message, 10000)
        } else {
          app.$ttoast.createToast(
            'warning',
            status,
            data.error,
            data.message,
            'خطای دیتابیس',
            5000
          )
        }

        break
      case 500: // Internal Server Error
        switch (data.status) {
          case 512:
            app.$ttoast.createToast(
              'danger',
              data.status,
              data.error,
              data.errors[0].value,
              data.errors[1].value,
              7000
            )
            break

          default:
            app.$ttoast.createToast(
              'danger',
              data.status,
              data.error,
              data.message,
              'خطای داخلی سرور . لطفا با ادمین تماس بگیرید',
              7000
            )
            break
        }

        break
      default:
        break
    }
  })
}
