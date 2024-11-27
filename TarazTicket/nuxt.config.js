// import axios from 'axios'
export default {
  // Global page headers: https://go.nuxtjs.dev/config-head
  head: {
    title: 'taraz ticket',
    htmlAttrs: {
      lang: 'en'
    },
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: '' },
      { name: 'format-detection', content: 'telephone=no' }
    ],

    link: [{ rel: 'icon', type: 'image/x-icon', href: '/ticket/favIconBlue.png' }]
  },

  // Global CSS: https://go.nuxtjs.dev/config-css
  css: ['@/assets/css/main.scss'],

  // Plugins to run before rendering page: https://go.nuxtjs.dev/config-plugins
  plugins: [
    '~/plugins/route.js',
    '~/plugins/axios.js',
    '~/plugins/tAxios.js',
    '~/plugins/vee-validate.js',
    { src: '~/plugins/persistedState.client.js' },
    { src: '~/plugins/tScroll.js', mode: 'client' },
    { src: '~/plugins/tToast.js', mode: 'client' },
    { src: '~/plugins/tNumber.js', mode: 'client' },
    { src: '~/plugins/vue-mask.js', mode: 'client' },
    { src: '~/plugins/tStore.js' },
    { src: '~/plugins/apexchart.js', mode: 'client' },
    { src: '~/plugins/bootstrapVueIcon.js', mode: 'client' },
    // { src: '~/plugins/tHtmlToPaper.js', mode: 'client' },
    { src: '~/plugins/tPrint.js', mode: 'client' },
    { src: '~/plugins/datePicker.js', mode: 'client' }
    // '~/plugins/direction-control'
  ],
  // Auto import components: https://go.nuxtjs.dev/config-components
  components: true,

  // Modules for dev and build (recommended): https://go.nuxtjs.dev/config-modules
  buildModules: [
    // https://go.nuxtjs.dev/eslint
    '@nuxtjs/eslint-module',
    '@nuxtjs/dotenv'
  ],

  // Modules: https://go.nuxtjs.dev/config-modules
  modules: [
    // https://go.nuxtjs.dev/bootstrap
    'bootstrap-vue/nuxt',
    // https://go.nuxtjs.dev/axios
    '@nuxtjs/axios',
    [
      'nuxt-fontawesome',
      {
        imports: [
          {
            set: '@fortawesome/free-solid-svg-icons',
            icons: ['fas']
          },
          {
            set: '@fortawesome/free-brands-svg-icons',
            icons: ['fab']
          }
        ]
      }
    ],
    'nuxt-leaflet'
    // [
    //   '@nuxtjs/i18n',
    //   {
    //     locales: [
    //       {
    //         code: 'en',
    //         dir: 'ltr',
    //         name: 'English',
    //         file: 'en.json'
    //       },
    //       {
    //         code: 'fa',
    //         dir: 'rtl', // that will be passed to your app
    //         name: 'Persian',
    //         file: 'fa.json'
    //       }
    //     ],
    //     defaultLocale: 'fa',
    //     langDir: 'translations/'
    //   }
    // ]
  ],

  // Axios module configuration: https://go.nuxtjs.dev/config-axios
  axios: {},
  router: {
    base: '/ticket/',
    middleware: ['routerGuard']
  },
  generate: {
    dir: 'ticket'
    // routes () {
    //   return ['/', '/dashboard/', '/dashboard/13']
    //   // return axios.get('http://localhost:8080/tws/tkt/knowledgebasecategories?pageNumber=1&recordCount=20').then((res) => {
    //   //   return res.data.map((page) => {
    //   //     const route = '/whatever/you/like/' + page.slug
    //   //     return route
    //   //   })
    //   // })
    // }
  },
  // Build Configuration: https://go.nuxtjs.dev/config-build
  build: {
    transpile: ['vee-validate/dist/rules']
  },
  target: 'static'
  // server: {
  //   port: 8000, // default: 3000
  //   host: '0.0.0.0' // default: localhost
  // }
}
