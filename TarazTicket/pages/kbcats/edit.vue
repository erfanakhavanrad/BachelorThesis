<template>
  <t-update-panel
    :data-entry-model="dataEntryModel"
    :validation="validation"
    :title="title"
    resource-data="tkt/knowledgebasecategories"
    @onRetrieveRecord="onRetrieveRecord"
  >
    <template #dataEntryElements>
      <t-text-box-string
        id="knowledgeBaseCategoryName"
        v-model="knowledgeBaseCategoryName"
        :rules="rules.knowledgeBaseCategoryName"
        label="عنوان"
        @onChangedValidation="onChangedValidation"
      />
    </template>
  </t-update-panel>
</template>
<script>
import TUpdatePanel from '~/components/dataentry/TUpdatePanel.vue'
import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'
export default {
  components: { TUpdatePanel, TTextBoxString },
  data () {
    return {
      title: 'ویرایش دسته بندی پایگاه دانش',
      knowledgeBaseCategoryName: null,
      validation: {},
      rules: {
        knowledgeBaseCategoryName: { required: true, min: 3, max: 30 }
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
        knowledgeBaseCategoryName: this.knowledgeBaseCategoryName
      }
    }
  },
  methods: {
    onRetrieveRecord (data) {
      this.knowledgeBaseCategoryName = data.knowledgeBaseCategoryName
    },
    onChangedValidation (_validation) {
      this.validation = Object.assign({}, this.validation, _validation)
    }
  }
}
</script>
<style lang="scss" scoped></style>
