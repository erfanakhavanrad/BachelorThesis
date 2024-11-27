<template>
  <t-insert-panel
    :data-entry-model="dataEntryModel"
    :validation="validation"
    :title="title"
    resource-data="tkt/defaultconversationanswers"
    @onInserted="onInserted"
  >
    <template #dataEntryElements>
      <t-text-area
        id="answerDesc"
        v-model="answerDesc"
        :rules="rules.answerDesc"
        label="متن پاسخ"
        @onChangedValidation="onChangedValidation"
      />
    </template>
  </t-insert-panel>
</template>

<script>
import TInsertPanel from '~/components/dataentry/TInsertPanel.vue'
import TTextArea from '~/components/dataentry/TTextArea.vue'
export default {
  components: {
    TInsertPanel,
    TTextArea
  },
  data () {
    return {
      title: 'ایجاد پاسخ پیش فرض جدید',
      answerDesc: null,
      validation: {},
      rules: {
        answerDesc: { required: true, min: 3, max: 1000 }
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
        answerDesc: this.answerDesc
      }
    }
  },
  methods: {
    onChangedValidation (_validation) {
      this.validation = Object.assign({}, this.validation, _validation)
    },
    onInserted () {
      this.answerDesc = null
    }
  }
}
</script>
<style lang="scss" scoped></style>
