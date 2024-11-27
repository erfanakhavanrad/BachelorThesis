<template>
  <t-update-panel
    :data-entry-model="dataEntryModel"
    :validation="validation"
    :title="title"
    resource-data="tkt/defaultconversationanswers"
    @onRetrieveRecord="onRetrieveRecord"
  >
    <template #dataEntryElements>
      <t-text-area
        id="answerDesc"
        v-model="answerDesc"
        :rules="rules.answerDesc"
        label="ویرایش متن پاسخ"
        @onChangedValidation="onChangedValidation"
      />
    </template>
  </t-update-panel>
</template>
<script>
import TUpdatePanel from '~/components/dataentry/TUpdatePanel.vue'
import TTextArea from '~/components/dataentry/TTextArea.vue'
export default {
  components: { TUpdatePanel, TTextArea },
  data () {
    return {
      title: 'ویرایش پاسخ پیش فرض',
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
    onRetrieveRecord (data) {
      this.answerDesc = data.answerDesc
    },
    onChangedValidation (_validation) {
      this.validation = Object.assign({}, this.validation, _validation)
    }
  }
}
</script>
<style lang="scss" scoped></style>
