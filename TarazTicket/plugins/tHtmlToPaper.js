import Vue from 'vue'
import VueHtmlToPaper from 'vue-html-to-paper'

const options = {
  name: '_blank',
  specs: ['fullscreen=no', 'titlebar=yes', 'scrollbars=yes'],
  styles: [
    'https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css',
    'https://unpkg.com/kidlat-css/css/kidlat.css',
    './public/test.css'
  ],
  timeout: 10000, // default timeout before the print window appears
  autoClose: true, // if false, the window will not close after printing
  // windowTitle: window.document.title, // override the window title
  windowTitle: 'asdasd' // override the window title
}

Vue.use(VueHtmlToPaper, options)

// Vue.use(VueHtmlToPaper)
