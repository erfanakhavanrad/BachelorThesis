<template>
  <t-insert-panel
    :data-entry-model="dataEntryModel"
    :validation="validation"
    :title="title"
    resource-data="tkt/customers"
    @onInserted="onInserted"
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
        id="userLoginName"
        v-model="userLoginName"
        :rules="rules.userLoginName"
        label="ایمیل"
        @onChangedValidation="onChangedValidation"
      />

      <t-text-box-password
        id="androidUserPass"
        v-model="androidUserPass"
        :rules="rules.androidUserPass"
        label="کلمه عبور"
        @onChangedValidation="onChangedValidation"
      />

      <t-combo-box
        id="organizationID"
        v-model="organizationID"
        :rules="rules.organizationID"
        label="سازمان"
        resource-data="tkt/organizations"
        resource-meta="tkt/organizations/meta"
        main-field-name="organizationName"
        @onChangedValidation="onChangedValidation"
      />

      <t-text-box-string
        id="organizationalRank"
        v-model="organizationalRank"
        :rules="rules.organizationalRank"
        label="سمت سازمانی"
        @onChangedValidation="onChangedValidation"
      />

      <t-text-box-number
        id="anyDeskID"
        v-model="anyDeskID"
        :rules="rules.anyDeskID"
        label="آی-دی انی‌دسک"
        @onChangedValidation="onChangedValidation"
      />

      <t-text-box-number
        id="userMobileNumber"
        v-model="userMobileNumber"
        :rules="rules.userMobileNumber"
        label="شماره موبایل"
        @onChangedValidation="onChangedValidation"
      />

      <t-text-box-number
        id="customerPhoneNumber"
        v-model="customerPhoneNumber"
        :rules="rules.customerPhoneNumber"
        label="تلفن ثابت"
        @onChangedValidation="onChangedValidation"
      />

      <t-text-box-integer
        id="customerInternalNumber"
        v-model="customerInternalNumber"
        :rules="rules.customerInternalNumber"
        label="داخلی"
        @onChangedValidation="onChangedValidation"
      />

      <t-text-area
        id="customerDesc"
        v-model="customerDesc"
        :rules="rules.customerDesc"
        label="توضیحات"
      />

      <t-jalali-calendar
        id="accountExpirationDate"
        v-model="accountExpirationDate"
        :rules="rules.accountExpirationDate"
        label="تاریخ انقضا اکانت"
        @onChangedValidation="onChangedValidation"
      />

      <t-combo-box
        id="priorityID"
        v-model="priorityID"
        :rules="rules.priorityID"
        label="درجه اهمیت مشتری"
        resource-data="tkt/priorities"
        resource-meta="tkt/priorities/meta"
        main-field-name="priorityName"
        @onChangedValidation="onChangedValidation"
      />

      <t-check-box
        id="isOrganizationOwner"
        v-model="isOrganizationOwner"
        label="سرپرست سازمان"
      />
    </template>
  </t-insert-panel>
</template>

<script>
import TInsertPanel from '~/components/dataentry/TInsertPanel.vue'
import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'
import TTextBoxNumber from '~/components/dataentry/TTextBoxNumber.vue'
import TComboBox from '~/components/dataentry/TComboBox.vue'
import TTextArea from '~/components/dataentry/TTextArea.vue'
import TJalaliCalendar from '~/components/dataentry/TJalaliCalendar.vue'
import TCheckBox from '~/components/dataentry/TCheckBox.vue'
import TTextBoxInteger from '~/components/dataentry/TTextBoxInteger.vue'
import TTextBoxPassword from '~/components/dataentry/TTextBoxPassword.vue'
import TTextBoxEmail from '~/components/dataentry/TTextBoxEmail.vue'

export default {
  components: {
    TInsertPanel,
    TTextBoxString,
    TTextBoxNumber,
    TComboBox,
    TTextArea,
    TJalaliCalendar,
    TCheckBox,
    TTextBoxInteger,
    TTextBoxPassword,
    TTextBoxEmail
  },
  data () {
    return {
      title: 'اضافه کردن مشتری',
      perComFName: null,
      perComLName: null,
      userLoginName: null,
      androidUserPass: null,
      organizationID: null,
      organizationalRank: null,
      anyDeskID: null,
      customerPhoneNumber: null,
      userMobileNumber: null,
      customerInternalNumber: null,
      customerDesc: null,
      accountExpirationDate: null,
      priorityID: null,
      isOrganizationOwner: null,
      validation: {},
      rules: {
        perComFName: { required: true, min: 3, max: 30 },
        perComLName: { required: true, min: 3, max: 30 },
        userLoginName: { required: true },
        androidUserPass: { required: true, min: 6, max: 30 },
        organizationID: { required: true },
        organizationalRank: { required: true, min: 3, max: 30 },
        anyDeskID: { required: true, min: 9, max: 9 },
        userMobileNumber: { required: false, min: 11, max: 11 },
        customerPhoneNumber: { required: false, min: 8, max: 11 },
        customerInternalNumber: { required: false },
        customerDesc: { required: false },
        accountExpirationDate: { required: true },
        priorityID: { required: true },
        isOrganizationOwner: { required: false }
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
        userLoginName: this.userLoginName,
        androidUserPass: this.androidUserPass,
        organizationID: this.organizationID,
        organizationalRank: this.organizationalRank,
        anyDeskID: this.anyDeskID,
        customerPhoneNumber: this.customerPhoneNumber,
        userMobileNumber: this.userMobileNumber,
        customerInternalNumber: this.customerInternalNumber,
        customerDesc: this.customerDesc,
        accountExpirationDate: this.accountExpirationDate,
        priorityID: this.priorityID,
        isOrganizationOwner: this.isOrganizationOwner
      }
    }
  },
  methods: {
    onChangedValidation (_validation) {
      this.validation = Object.assign({}, this.validation, _validation)
    },
    onInserted () {
      this.perComFName = null
      this.perComLName = null
      this.userLoginName = null
      this.androidUserPass = null
      this.organizationID = null
      this.organizationalRank = null
      this.anyDeskID = null
      this.customerPhoneNumber = null
      this.userMobileNumber = null
      this.customerInternalNumber = null
      this.customerDesc = null
      this.accountExpirationDate = null
      this.priorityID = null
      this.isOrganizationOwner = null
    }
  }
}
</script>
<style lang="scss" scoped></style>
