import Vue from 'vue'
const { $createElement, $bvToast } = new Vue({})
export class TToast {
  createToast (variant, status, error, errorsEng, errorsPer, autoHideDelay) {
    if (autoHideDelay == null) {
      autoHideDelay = 1000
    }
    const h = $createElement(
      'div',
      {
        class: ['d-flex', 'flex-grow-1', 'align-items-baseline', 'mr-2'],
        on: {
          mouseenter () {},
          mouseleave () {}
        }
      },
      [
        $createElement(
          'small',
          { class: 'ml-auto text-italics' },
          '(' + status + ')'
        ),
        $createElement('strong', { class: 'mr-2' }, error)
      ]
    )
    const b = $createElement(
      'div',
      {
        attrs: {
          id: 't-toast'
        },
        style: 'display:table;width:100%;'
      },
      [
        $createElement(
          'strong',
          { style: 'display:table-row;:rtl;direction:rtl;text-align: right;' },
          errorsPer
        ),
        $createElement('hr'),
        $createElement(
          'small',
          { style: 'display:table-row;direction:ltr;text-align: left;' },
          errorsEng
        )
      ]
    )

    const toaster = 'b-toaster-bottom-left'
    // if (status === 403) {
    //   toaster = 'b-toaster-top-full'
    // }

    $bvToast.toast(b, {
      title: h,
      toaster,
      variant,
      appendToast: true,
      solid: true,
      autoHideDelay
    })
  }

  createToastTokenExpire () {
    const h = $createElement(
      'div',
      {
        class: ['d-flex', 'flex-grow-1', 'align-items-baseline', 'mr-2']
      },
      [
        $createElement(
          'strong',
          { class: 'mr-2' },
          'اعتبار توکن به پایان رسیده است'
        ),
        $createElement('small', { class: 'ml-auto text-italics' }, '401')
      ]
    )
    const b = $createElement(
      'div',
      {
        attrs: {
          id: 't-toast'
        },
        style: 'display:table;width:100%;'
      },
      [
        $createElement(
          'a',
          {
            style: 'display:table-row;:rtl;direction:rtl;text-align: center;',
            attrs: { href: '/ticket/login' }
          },
          'ورود به برنامه'
        )
      ]
    )

    $bvToast.toast(b, {
      title: h,
      toaster: 'b-toaster-top-center',
      variant: 'danger',
      appendToast: true,
      solid: true,
      autoHideDelay: 1000000
    })
  }

  createToastLicenseExpire () {
    const h = $createElement(
      'div',
      {
        class: ['d-flex', 'flex-grow-1', 'align-items-baseline', 'mr-2']
      },
      [
        $createElement(
          'strong',
          { class: 'mr-2' },
          'اعتبار -لایسنس سامانه تیکتینگ- شما به پایان رسیده است'
        ),
        $createElement('small', { class: 'ml-auto text-italics' }, '402')
      ]
    )
    const b = $createElement(
      'div',
      {
        attrs: {
          id: 't-toast'
        },
        style: 'display:table;width:100%;'
      },
      [
        $createElement(
          'a',
          {
            style: 'display:table-row;:rtl;direction:rtl;text-align: center;',
            attrs: { href: 'https://tarazgroup.com/' }
          },
          'لطفا جهت تمدید حساب خود، با تراز سامانه تماس بگیرید.'
        )
      ]
    )

    $bvToast.toast(b, {
      title: h,
      toaster: 'b-toaster-top-center',
      variant: 'warning',
      appendToast: true,
      solid: true,
      autoHideDelay: 1000000
    })
  }
}
export default (context, inject) => {
  inject('ttoast', new TToast())
}
