<template>
  <t-insert-panel
    :data-entry-model="dataEntryModel"
    :validation="validation"
    :title="title"
    resource-data="tkt/knowledgebasecategories"
    @onInserted="onInserted"
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
  </t-insert-panel>
</template>

<script>
import TInsertPanel from '~/components/dataentry/TInsertPanel.vue'
import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'
export default {
  components: {
    TInsertPanel,
    TTextBoxString
  },
  data () {
    return {
      title: 'دسته بندی جدید پایگاه دانش',
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
    onChangedValidation (_validation) {
      this.validation = Object.assign({}, this.validation, _validation)
    },
    onInserted () {
      this.knowledgeBaseCategoryName = null
    }
  }
}
</script>
<style lang="scss" scoped></style>
