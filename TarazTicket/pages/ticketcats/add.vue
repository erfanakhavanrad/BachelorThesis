<template>
  <t-insert-panel
    :data-entry-model="dataEntryModel"
    :validation="validation"
    :title="title"
    resource-data="tkt/ticketcategories"
    @onInserted="onInserted"
  >
    <template #dataEntryElements>
      <t-text-box-string
        id="ticketCategoryName"
        v-model="ticketCategoryName"
        :rules="rules.ticketCategoryName"
        label="عنوان"
        @onChangedValidation="onChangedValidation"
      />
      <t-color
        id="ticketLabelColor"
        v-model="ticketLabelColor"
        label="رنگ برچسب"
      />
      <t-combo-box
        id="departmentID"
        v-model="departmentID"
        :rules="rules.departmentID"
        :filter-params="filterParamsDepartments"
        label="دپارتمان"
        resource-data="tkt/departments"
        resource-meta="tkt/departments/meta"
        main-field-name="departmentName"
        @onChangedValidation="onChangedValidation"
      />
    </template>
  </t-insert-panel>
</template>

<script>
import TInsertPanel from '~/components/dataentry/TInsertPanel.vue'
import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'
import TComboBox from '~/components/dataentry/TComboBox.vue'
import TColor from '~/components/dataentry/TColor.vue'

export default {
  components: {
    TInsertPanel,
    TTextBoxString,
    TComboBox,
    TColor
  },
  data () {
    return {
      title: 'دسته بندی جدید تیکت ها',
      ticketCategoryName: null,
      ticketLabelColor: null,
      departmentID: null,
      validation: {},
      rules: {
        ticketCategoryName: { required: true, min: 3, max: 30 },
        ticketLabelColor: null,
        departmentID: { required: true }
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
        ticketCategoryName: this.ticketCategoryName,
        ticketLabelColor: this.ticketLabelColor,
        departmentID: this.departmentID
      }
    },
    filterParamsDepartments () {
      return { filter: 'DepartmentID NOT IN (1,2)' }
    }
  },
  methods: {
    onChangedValidation (_validation) {
      this.validation = Object.assign({}, this.validation, _validation)
    },
    onInserted () {
      this.ticketCategoryName = null
      this.ticketLabelColor = null
      this.departmentID = null
    }
  }
}
</script>
<style lang="scss" scoped></style>
