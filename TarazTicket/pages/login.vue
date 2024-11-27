<template>
  <b-overlay v-if="initializing" show class="t-loading" />
  <div v-else id="t-container-login" tabindex="1">
    <client-only>
      <Particles
        color="#DCBA8F"
        :particles-number="150"
        shape-type="circle"
        :particle-size="4"
        movement-direction="top"
        lines-color="#17a2b8"
        :line-linked="true"
        :move-speed="1.3"
        :click-effect="true"
        :hover-effect="true"
        :lines-distance="100"
        class="hero-background"
      />
    </client-only>
    <div id="t-item-login" class="col-sm-9 col-md-4 col-lg-4 col-xl-3">
      <b-alert
        v-if="generalCustomersMessage != null && generalCustomersMessage != ''"
        class="t-general-customers-message shadow"
        show
      >
        <span style="display:table-row;:rtl;direction:rtl;text-align: right;">
          {{ generalCustomersMessage }}
        </span>
      </b-alert>
      <b-card class="shadow-lg">
        <validation-observer ref="observer" v-slot="{ handleSubmit }">
          <b-form @submit.stop.prevent="handleSubmit(login)">
            <b-card-header header-class="t-b-card-header">
              <b-row class="flex-between">
                <h5 class="mr-2">ورود به سامانه</h5>
                <b-avatar
                  class="ml-2"
                  :src="require('@/assets/logo.png')"
                  rounded="sm"
                  variant="info"
                />
              </b-row>
            </b-card-header>
            <b-card-body body-class="t-b-card-body">
              <validation-provider
                v-slot="validationContext"
                :rules="{ required: true, min: 3 }"
                name="نام کاربری"
              >
                <b-form-group id="form-group-username">
                  <b-input-group>
                    <b-form-input
                      id="username"
                      v-model="form.username"
                      :state="validateState(validationContext)"
                      aria-describedby="form-invalid-feedback-username"
                      name="username"
                      placeholder="نام کاربری"
                      size="sm"
                    />
                    <b-input-group-addon class="input-group-append">
                      <span
                        class="input-group-text"
                        style="height: calc(1.5em + 0.5rem - 1px)"
                      >
                        <font-awesome-icon icon="user" />
                      </span>
                    </b-input-group-addon>
                    <b-form-invalid-feedback
                      id="form-invalid-feedback-username"
                      class="t-b-form-invalid-feedback"
                      v-text="validationContext.errors[0]"
                    />
                  </b-input-group>
                </b-form-group>
              </validation-provider>
              <validation-provider
                v-slot="validationContext"
                :rules="{ required: true }"
                name="رمز عبور"
              >
                <b-form-group id="form-group-password">
                  <b-input-group>
                    <b-form-input
                      id="password"
                      v-model="form.password"
                      :state="validateState(validationContext)"
                      aria-describedby="form-invalid-feedback-password"
                      name="password"
                      placeholder="رمز عبور"
                      size="sm"
                      type="password"
                    />
                    <b-input-group-addon class="input-group-append">
                      <span
                        class="input-group-text"
                        style="height: calc(1.5em + 0.5rem - 1px)"
                      >
                        <font-awesome-icon icon="lock" />
                      </span>
                    </b-input-group-addon>

                    <b-form-invalid-feedback
                      id="form-invalid-feedback-password"
                      class="t-b-form-invalid-feedback"
                      v-text="validationContext.errors[0]"
                    />
                  </b-input-group>
                </b-form-group>
              </validation-provider>
            </b-card-body>
            <b-card-footer footer-class="t-b-card-footer">
              <nuxt-link to="/register" class="ml-3">
                ثبت نام
              </nuxt-link>
              <input
                type="submit"
                value="ورود"
                class="btn btn-info btn-sm w-25"
              >
            </b-card-footer>
            <!-- <b-card-footer footer-class="t-b-card-footer">
              <nuxt-link class="ml-3 passForgotlink" to="./login" @click.native="onClickShowPopUp()">
                فراموشی رمز عبور
              </nuxt-link>
            </b-card-footer> -->
          </b-form>
        </validation-observer>
      </b-card>
    </div>
    <b-overlay :show="overlayShow" no-wrap />
    <t-modal-yes-no
      ref="TModalYesNo"
      title="بازیابی رمز ورود"
      variant="light"
      size="lg"
    >
      <div class="resetPassPopUpText">
        ایمیل:
      </div>
      <b-input-group>
        <b-form-input
          id="username"
          v-model="emailAddres"
          aria-describedby="form-invalid-feedback-username"
          dir="rtl"
          name="username"
          placeholder="نام کاربری"
          size="sm"
        />
        <b-input-group-addon class="input-group-append">
          <span
            class="input-group-text"
            style="height: calc(1.5em + 0.5rem - 1px)"
          >
            <font-awesome-icon icon="user" />
          </span>
        </b-input-group-addon>
        <!-- <b-form-invalid-feedback
          id="form-invalid-feedback-username"
          class="t-b-form-invalid-feedback"
          v-text="validationContext.errors[0]"
        /> -->
      </b-input-group>
    </t-modal-yes-no>
  </div>
</template>
<script>
import { mapActions } from 'vuex'
import { ValidationObserver, ValidationProvider } from 'vee-validate'
import VueScreenSize from 'vue-screen-size'
import Vue from 'vue'
import VueHtmlToPaper from 'vue-html-to-paper'
import TModalYesNo from '~/components/general/TModalYesNo.vue'
import Particles from '~/components/general/Particles.vue'
const options = {
  name: '_blank',
  specs: ['fullscreen=no', 'titlebar=yes', 'scrollbars=yes'],
  styles: [
    'https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css',
    'https://unpkg.com/kidlat-css/css/kidlat.css',
    'public/test.css'
  ],
  timeout: 10000, // default timeout before the print window appears
  autoClose: true, // if false, the window will not close after printing
  // windowTitle: window.document.title, // override the window title
  windowTitle: 'asdasd' // override the window title
}

Vue.use(VueHtmlToPaper, options)

export default {
  components: {
    ValidationObserver,
    ValidationProvider,
    TModalYesNo,
    Particles
  },
  mixins: [VueScreenSize.VueScreenSizeMixin],
  layout: 'login',
  data () {
    return {
      head: null,
      initializing: true,
      overlayShow: false,
      ip: null,
      port: null,
      emailAddres: null,
      generalCustomersMessage: null,
      form: {
        username: null,
        password: null
      }
    }
  },
  head () {
    return {
      title: this.head,
      options: {
        name: '_blank',
        specs: ['fullscreen=no', 'titlebar=yes', 'scrollbars=yes'],
        styles: [
          'https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css',
          'https://unpkg.com/kidlat-css/css/kidlat.css',
          'test.css'
        ],
        timeout: 10000, // default timeout before the print window appears
        autoClose: true, // if false, the window will not close after printing
        // windowTitle: window.document.title, // override the window title
        windowTitle: 'ای ایران ای مرز پر گهر' // override the window title
      }
    }
  },
  async mounted () {
    this.head = 'ورود'
    this.initializing = true
    this.$tstore.setIpPort()
    this.initializing = false
    if (process.env.NODE_ENV !== 'production') {
      this.form.username = 'admin'
      this.form.password = '1'
      // this.form.username = 's@s.com'
      // this.form.password = '1'
    }
    // recognize screen size
    this.setDeviceSize({ width: this.$vssWidth, height: this.$vssHeight })
    await this.retrieveData()
  },
  methods: {
    ...mapActions({
      authenticate: 'authentication/authenticate',
      setDeviceSize: '_deviceInfo/setSize'
    }),
    validateState ({ dirty, validated, valid = null }) {
      return dirty || validated ? valid : null
    },
    async login () {
      this.overlayShow = true
      if (
        await this.authenticate({
          username: this.$tnumber.convertPersianNumber(
            // this.form.username.toLowerCase().trim()
            this.form.username.trim()
          ),
          password: this.$tnumber.convertPersianNumber(this.form.password)
        })
      ) {
        await this.$tstore.initialize()
        this.$router.replace('/')
      } else {
        this.overlayShow = false
      }
    },
    async retrieveData () {
      // واکشی دیتا( سطرها) از سرور
      const filterParams = {}
      filterParams.pageNumber = 1
      filterParams.recordCount = 1
      const response = await this.$taxios.get(
        'tkt/settings/generalmessage',
        filterParams
      )
      this.generalCustomersMessage = response.data.generalCustomersMessage
    },
    onClickShowPopUp () {
      this.$refs.TModalYesNo.show(() => {
        this.onResetPass(this.emailAddres)
      })
    },
    onResetPass (emailAddres) {
      this.retrieving = true
      this.$taxios
        .put('tkt/users/forgetpasswordlink/' + emailAddres)
        .then((response) => {
          this.retrieving = false
          if (response.status === 200) {
            alert('پسوورد جدید به ایمیل شما ارسال شد')
            this.$ttoast.createToast(
              'info',
              200,
              'OK',
              'Password has been reset',
              'پسورد ریست شد',
              3000
            )
          }
        })
        .catch(() => {
          this.retrieving = true
        })
    }
  }
}
</script>
<style scoped>
#t-container-login {
  display: flex;
  flex-direction: column;
  flex-wrap: nowrap;
  justify-content: center;
  align-items: center;
  height: 100vh;
  /* direction: ltr; */
}

.t-b-card-header {
  background-color: white;
  text-align: right;
}

.t-b-card-footer {
  background-color: white;
  text-align: center;
  direction: ltr;
  display: flex;
  justify-content: space-evenly;
}

.t-b-form-invalid-feedback {
  text-align: right;
  font-size: 60%;
}
.passForgotlink {
  display: flex;
  justify-content: center;
}
.resetPassPopUpText {
  height: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
  padding-left: 5px;
}
.hero-background {
  height: 100vh !important;
  width: 100vw !important;
  position: fixed !important;
  top: 0 !important;
  margin: 0 !important;
  padding: 0 !important;
  overflow: hidden !important;
  background-size: cover !important;
  background-repeat: no-repeat !important;
  background-blend-mode: overlay !important;
  background-attachment: fixed !important;
  background-position: fixed !important;
  background: #ebe8e8b9 !important;
  /* background-image: url('~assets/img/background.png') !important;
  z-index: 1 !important; */
}
.flex-between {
  display: flex;
  justify-content: space-between;
}
</style>
