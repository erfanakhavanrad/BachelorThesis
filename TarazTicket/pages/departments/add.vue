<template>
  <t-insert-panel
    :data-entry-model="dataEntryModel"
    :validation="validation"
    :title="title"
    resource-data="tkt/departments"
    @onInserted="onInserted"
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
  </t-insert-panel>
</template>

<script>
import TInsertPanel from '~/components/dataentry/TInsertPanel.vue'
import TCheckBox from '~/components/dataentry/TCheckBox.vue'
import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'
import TTextBoxEmail from '~/components/dataentry/TTextBoxEmail.vue'
import TTextBoxInteger from '~/components/dataentry/TTextBoxInteger.vue'
export default {
  components: {
    TInsertPanel,
    TTextBoxString,
    TTextBoxEmail,
    TCheckBox,
    TTextBoxInteger
  },
  data () {
    return {
      title: 'دپارتمان جدید',
      departmentName: null,
      departmentEmailAddress: null,
      ticketTimeout: null,
      isVisibleForCustomers: null,
      validation: {},
      rules: {
        departmentName: { required: true, min: 1, max: 30 },
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
    onChangedValidation (_validation) {
      this.validation = Object.assign({}, this.validation, _validation)
    },
    onInserted () {
      this.departmentName = null
      this.departmentEmailAddress = null
      this.ticketTimeout = null
      this.isVisibleForCustomers = null
    }
  }
}
</script>
<style lang="scss" scoped></style>
