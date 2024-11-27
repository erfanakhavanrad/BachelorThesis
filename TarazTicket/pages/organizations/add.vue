<template>
  <t-insert-panel
    :data-entry-model="dataEntryModel"
    :validation="validation"
    :title="title"
    resource-data="tkt/organizations"
    @onInserted="onInserted"
  >
    <template #dataEntryElements>
      <div style="display: flex">
        <t-text-box-string
          id="perComTitle"
          v-model="perComTitle"
          :rules="rules.perComTitle"
          label="عنوان"
          style="flex-grow: 10"
          @onChangedValidation="onChangedValidation"
        />

        <t-text-box-string
          id="perComName"
          v-model="perComName"
          :rules="rules.perComName"
          label="نام"
          style="flex-grow: 10"
          @onChangedValidation="onChangedValidation"
        />
      </div>
      <t-text-box-string
        id="organizationAddress"
        v-model="organizationAddress"
        :rules="rules.organizationAddress"
        label="آدرس"
        @onChangedValidation="onChangedValidation"
      />

      <t-text-box-number
        id="organizationPhoneNumber"
        v-model="organizationPhoneNumber"
        :rules="rules.organizationPhoneNumber"
        label="تلفن ثابت"
        @onChangedValidation="onChangedValidation"
      />

      <t-text-box-url
        id="organizationWebsite"
        v-model="organizationWebsite"
        :rules="rules.organizationWebsite"
        label="وب سایت"
        @onChangedValidation="onChangedValidation"
      />

      <t-text-area
        id="organizationDesc"
        v-model="organizationDesc"
        :rules="rules.organizationDesc"
        label="توضیحات"
      />

      <t-jalali-calendar
        id="expirationDate"
        v-model="expirationDate"
        :rules="rules.expirationDate"
        label="اتمام دسترسی"
        @onChangedValidation="onChangedValidation"
      />

      <t-combo-box
        id="priorityID"
        v-model="priorityID"
        :rules="rules.priorityID"
        label="درجه اهمیت"
        resource-data="tkt/priorities"
        resource-meta="tkt/priorities/meta"
        main-field-name="priorityName"
        @onChangedValidation="onChangedValidation"
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
import TTextBoxUrl from '~/components/dataentry/TTextBoxUrl.vue'

export default {
  components: {
    TInsertPanel,
    TTextBoxString,
    TTextBoxNumber,
    TComboBox,
    TTextArea,
    TJalaliCalendar,
    TTextBoxUrl
  },
  data () {
    return {
      title: 'شرکت جدید',
      perComTitle: null,
      perComName: null,
      organizationAddress: null,
      organizationPhoneNumber: null,
      organizationWebsite: null,
      organizationDesc: null,
      expirationDate: null,
      priorityID: null,
      validation: {},
      rules: {
        perComTitle: { required: true, min: 3, max: 100 },
        perComName: { required: true, min: 3, max: 100 },
        organizationAddress: { required: true, min: 8, max: 300 },
        organizationPhoneNumber: { required: true, min: 8, max: 11 },
        organizationWebsite: { required: false },
        organizationDesc: { required: false },
        expirationDate: { required: true },
        priorityID: { required: true }
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
        perComTitle: this.perComTitle,
        perComName: this.perComName,
        organizationAddress: this.organizationAddress,
        organizationPhoneNumber: this.organizationPhoneNumber,
        organizationWebsite: this.organizationWebsite,
        organizationDesc: this.organizationDesc,
        expirationDate: this.expirationDate,
        priorityID: this.priorityID
      }
    }
  },
  methods: {
    onChangedValidation (_validation) {
      this.validation = Object.assign({}, this.validation, _validation)
    },
    onInserted () {
      this.perComTitle = null
      this.perComName = null
      this.organizationAddress = null
      this.organizationPhoneNumber = null
      this.organizationWebsite = null
      this.organizationDesc = null
      this.expirationDate = null
      this.priorityID = null
    }
  }
}
</script>
<style lang="scss" scoped></style>
