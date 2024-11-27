<template>
  <t-update-panel
    :data-entry-model="dataEntryModel"
    :validation="validation"
    :title="title"
    resource-data="tkt/staff"
    @onRetrieveRecord="onRetrieveRecord"
  >
    <template #dataEntryElements>
      <t-text-box-string
        id="perComFName"
        v-model="perComFName"
        :rules="rules.perComFName"
        label="نام"
        @onChangedValidation="onChangedValidation"
      />

      <t-text-box-string
        id="perComLName"
        v-model="perComLName"
        :rules="rules.perComLName"
        label="نام خانوادگی"
        @onChangedValidation="onChangedValidation"
      />

      <t-text-box-email
        id="email"
        v-model="email"
        :rules="rules.email"
        label="ایمیل"
        :disabled="true"
        @onChangedValidation="onChangedValidation"
      />

      <t-text-box-password
        v-if="false"
        id="password"
        v-model="password"
        :rules="rules.password"
        label="کلمه عبور"
        @onChangedValidation="onChangedValidation"
      />

      <t-text-box-number
        id="userMobileNumber"
        v-model="userMobileNumber"
        :rules="rules.userMobileNumber"
        label="شماره موبایل"
        @onChangedValidation="onChangedValidation"
      />

      <t-file v-if="false" id="tst" v-model="tst" label="عکس" />

      <t-check-box
        id="hasAccessSendTicketToCustomer"
        v-model="hasAccessSendTicketToCustomer"
        label="دسترسی ارسال تیکت به مشتریان"
      />

      <t-check-box
        id="hasAccessToCustomerInfo"
        v-model="hasAccessToCustomerInfo"
        label="دسترسی به اطلاعات مشتریان"
      />
      <t-radio-button-group
        id="roles"
        v-model="roles"
        label="نقش در دپارتمان"
        :rules="rules.roles"
        resource-data="tkt/roles"
        resource-meta="tkt/roles/meta"
        main-field-name="roleName"
        group-by-field-name="departmentID"
        @onChangedValidation="onChangedValidation"
      />
    </template>
  </t-update-panel>
</template>
<script>
import TUpdatePanel from '~/components/dataentry/TUpdatePanel.vue'
import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'
import TTextBoxNumber from '~/components/dataentry/TTextBoxNumber.vue'
import TCheckBox from '~/components/dataentry/TCheckBox.vue'
import TTextBoxEmail from '~/components/dataentry/TTextBoxEmail.vue'
import TRadioButtonGroup from '~/components/dataentry/TRadioButtonGroup.vue'
import TTextBoxPassword from '~/components/dataentry/TTextBoxPassword.vue'
import TFile from '~/components/dataentry/TFile.vue'

export default {
  components: {
    TUpdatePanel,
    TTextBoxString,
    TTextBoxNumber,
    TCheckBox,
    TTextBoxEmail,
    TRadioButtonGroup,
    TTextBoxPassword,
    TFile
  },
  data () {
    return {
      title: 'ویرایش اطلاعات کارمند',
      perComFName: null,
      perComLName: null,
      email: null,
      password: null,
      userMobileNumber: null,
      hasAccessSendTicketToCustomer: null,
      hasAccessToCustomerInfo: null,
      roles: null,
      validation: {},
      rules: {
        perComFName: { required: true, min: 3, max: 30 },
        perComLName: { required: true, min: 3, max: 30 },
        email: { required: true },
        userMobileNumber: { min: 11, max: 11 },
        roles: { required: true }
      }
    }
  },
  head () {
    return {
      title: this.title
    }
  },
  computed: {
    dataEntryModel () {
      return {
        perComFName: this.perComFName,
        perComLName: this.perComLName,
        email: this.email,
        password: this.password,
        userMobileNumber: this.userMobileNumber,
        hasAccessSendTicketToCustomer: this.hasAccessSendTicketToCustomer,
        hasAccessToCustomerInfo: this.hasAccessToCustomerInfo,
        roles: this.roles
      }
    }
  },
  methods: {
    onRetrieveRecord (data) {
      this.perComFName = data.perComFName
      this.perComLName = data.perComLName
      this.email = data.email
      this.password = data.password
      this.userMobileNumber = data.userMobileNumber
      this.hasAccessSendTicketToCustomer = data.hasAccessSendTicketToCustomer
      this.hasAccessToCustomerInfo = data.hasAccessToCustomerInfo
      this.roles = data.roles
    },
    onChangedValidation (_validation) {
      this.validation = Object.assign({}, this.validation, _validation)
    }
  }
}
</script>
<style lang="scss" scoped></style>
