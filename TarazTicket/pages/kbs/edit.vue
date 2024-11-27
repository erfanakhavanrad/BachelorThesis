<template>
  <t-update-panel
    :data-entry-model="dataEntryModel"
    :validation="validation"
    :title="title"
    resource-data="tkt/knowledgebases"
    @onRetrieveRecord="onRetrieveRecord"
  >
    <template #dataEntryElements>
      <t-text-box-string
        id="knowledgeBaseName"
        v-model="knowledgeBaseName"
        :rules="rules.knowledgeBaseName"
        label="عنوان"
        @onChangedValidation="onChangedValidation"
      />
      <t-combo-box
        id="knowledgeBaseCategoryID"
        v-model="knowledgeBaseCategoryID"
        :rules="rules.knowledgeBaseCategoryID"
        label="دسته بندی"
        resource-data="tkt/knowledgebasecategories"
        resource-meta="tkt/knowledgebasecategories/meta"
        main-field-name="knowledgeBaseCategoryName"
        @onChangedValidation="onChangedValidation"
      />
      <t-text-area
        id="knowledgeBaseDesc"
        v-model="knowledgeBaseDesc"
        :rules="rules.knowledgeBaseDesc"
        label="توضیحات"
        @onChangedValidation="onChangedValidation"
      />
      <t-file id="attachment" v-model="attachment" label="فایل های الحاقی" />
    </template>
  </t-update-panel>
</template>
<script>
import TUpdatePanel from '~/components/dataentry/TUpdatePanel.vue'
import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'
import TComboBox from '~/components/dataentry/TComboBox.vue'
import TTextArea from '~/components/dataentry/TTextArea.vue'
import TFile from '~/components/dataentry/TFile.vue'

export default {
  components: {
    TUpdatePanel,
    TTextBoxString,
    TComboBox,
    TTextArea,
    TFile
  },
  data () {
    return {
      title: 'ویرایش مقاله',
      knowledgeBaseName: null,
      knowledgeBaseCategoryID: null,
      knowledgeBaseDesc: null,
      attachment: null,
      validation: {},
      rules: {
        knowledgeBaseName: { required: true, min: 3, max: 30 },
        knowledgeBaseCategoryID: { required: true },
        knowledgeBaseDesc: { required: false }
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
        knowledgeBaseName: this.knowledgeBaseName,
        knowledgeBaseCategoryID: this.knowledgeBaseCategoryID,
        knowledgeBaseDesc: this.knowledgeBaseDesc,
        attachment: this.attachment
      }
    }
  },
  methods: {
    onRetrieveRecord (data) {
      this.knowledgeBaseName = data.knowledgeBaseName
      this.knowledgeBaseCategoryID = data.knowledgeBaseCategoryID
      this.knowledgeBaseDesc = data.knowledgeBaseDesc
      this.attachment = data.attachment
    },
    onChangedValidation (_validation) {
      this.validation = Object.assign({}, this.validation, _validation)
    }
  }
}
</script>
<style lang="scss" scoped></style>
