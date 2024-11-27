<template>
  <b-overlay v-if="initializing" show class="t-loading" />
  <div v-else id="t-container-login" tabindex="1">
    <div id="t-item-login" class="col-sm-9 col-md-4 col-lg-4 col-xl-3">
      <b-card class="shadow-lg">
        <validation-observer ref="observer" v-slot="{ handleSubmit }">
          <b-form @submit.stop.prevent="handleSubmit(register)">
            <b-card-header header-class="t-b-card-header">
              <b-row class="flex-between">
                <h5 class="mr-2">ثبت نام</h5>
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
                name="ایمیل"
              >
                <b-form-group id="form-group-username">
                  <b-input-group>
                    <b-form-input
                      id="username"
                      v-model="form.email"
                      :state="validateState(validationContext)"
                      aria-describedby="form-invalid-feedback-email"
                      dir="rtl"
                      name="email"
                      placeholder="آدرس ایمیل"
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
                      dir="rtl"
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
              <nuxt-link to="/login" class="ml-3">
                ورود
              </nuxt-link>
              <input
                type="submit"
                value="ثبت نام"
                class="btn btn-info btn-sm w-25"
              >
            </b-card-footer>
          </b-form>
        </validation-observer>
      </b-card>
    </div>
    <b-overlay :show="overlayShow" no-wrap />
  </div>
</template>
<script>
import { mapActions } from 'vuex'
import { ValidationObserver, ValidationProvider } from 'vee-validate'
import VueScreenSize from 'vue-screen-size'

export default {
  components: {
    ValidationObserver,
    ValidationProvider
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
      form: {
        email: null,
        password: null
      }
    }
  },
  head () {
    return {
      title: this.head
    }
  },
  mounted () {
    this.head = 'ثبت نام'
    this.initializing = true
    this.$tstore.setIpPort()
    this.initializing = false
    // }
    // recognize screen size
    this.setDeviceSize({ width: this.$vssWidth, height: this.$vssHeight })
  },
  methods: {
    ...mapActions({
      data_register: 'authentication/register',
      setDeviceSize: '_deviceInfo/setSize'
    }),
    validateState ({ dirty, validated, valid = null }) {
      return dirty || validated ? valid : null
    },
    async register () {
      this.overlayShow = true
      if (
        await this.data_register({
          userLoginName: this.form.email.trim(),
          androidUserPass: this.form.password
        })
      ) {
        // await this.$tstore.initialize();
        this.$router.replace('/login')
      } else {
        this.overlayShow = false
      }
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
}

.t-b-card-header {
  background-color: white;
}

.t-b-card-footer {
  background-color: white;
}

.t-b-form-invalid-feedback {
  text-align: right;
  font-size: 60%;
}
.flex-between {
  display: flex;
  justify-content: space-between;
}
</style>
