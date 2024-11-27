<template>
  <t-update-panel
    :data-entry-model="dataEntryModel"
    :validation="validation"
    :title="title"
    resource-data="tkt/departments"
    @onRetrieveRecord="onRetrieveRecord"
  >
    <template #dataEntryElements>
      <t-text-box-string
        id="departmentName"
        v-model="departmentName"
        :rules="rules.departmentName"
        label="عنوان"
        @onChangedValidation="onChangedValidation"
      />

      <t-text-box-email
        id="departmentEmailAddress"
        v-model="departmentEmailAddress"
        :rules="rules.departmentEmailAddress"
        label="آدرس ایمیل"
        @onChangedValidation="onChangedValidation"
      />

      <!-- <t-text-box-date-time
        id="ticketTimeout"
        v-model="ticketTimeout"
        :rules="rules.ticketTimeout"
        label="مهلت پیش فرض بسته شدن تیکت"
        @onChangedValidation="onChangedValidation"
      /> -->

      <t-text-box-integer
        id="ticketTimeout"
        v-model="ticketTimeout"
        :rules="rules.ticketTimeout"
        label="مهلت پیش فرض بسته شدن تیکت به ساعت"
        @onChangedValidation="onChangedValidation"
      />

      <t-check-box
        id="isVisibleForCustomers"
        v-model="isVisibleForCustomers"
        label="قابل مشاهده برای مشتریان"
      />
    </template>
  </t-update-panel>
</template>
<script>
import TUpdatePanel from '~/components/dataentry/TUpdatePanel.vue'
import TCheckBox from '~/components/dataentry/TCheckBox.vue'
import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'
import TTextBoxEmail from '~/components/dataentry/TTextBoxEmail.vue'
import TTextBoxInteger from '~/components/dataentry/TTextBoxInteger.vue'
export default {
  components: {
    TUpdatePanel,
    TTextBoxString,
    TTextBoxEmail,
    TCheckBox,
    TTextBoxInteger
  },
  data () {
    return {
      title: 'ویرایش دپارتمان',
      departmentName: null,
      departmentEmailAddress: null,
      ticketTimeout: null,
      isVisibleForCustomers: null,
      validation: {},
      rules: {
        departmentName: { required: true, min: 3, max: 30 },
        departmentEmailAddress: { required: true },
        ticketTimeout: { required: true }
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
        departmentName: this.departmentName,
        departmentEmailAddress: this.departmentEmailAddress,
        ticketTimeout: this.ticketTimeout,
        isVisibleForCustomers: this.isVisibleForCustomers
      }
    }
  },
  methods: {
    onRetrieveRecord (data) {
      this.departmentName = data.departmentName
      this.departmentEmailAddress = data.departmentEmailAddress
      this.ticketTimeout = data.ticketTimeout
      this.isVisibleForCustomers = data.isVisibleForCustomers
    },
    onChangedValidation (_validation) {
      this.validation = Object.assign({}, this.validation, _validation)
    }
  }
}
</script>
<style lang="scss" scoped></style>
