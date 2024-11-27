// import Vue from 'vue'
import { extend, localize } from 'vee-validate'
import fa from 'vee-validate/dist/locale/fa.json'
import { required, min, max } from 'vee-validate/dist/rules'
// Vue.use(VeeValidate)
// جز موارد زیر هرکدام نیاز بود اضافه شود
extend('required', required)
extend('min', min)
extend('max', max)
localize('fa', fa)
