<template>
  <t-grid-view
    id="TktKnowledgeBaseCategory"
    :title="title"
    resource-data="tkt/ticketcategories/forgrid"
    resource-meta="tkt/ticketcategories/meta"
    main-field-name="ticketCategoryName"
    :filter-params="filterParams"
    :has-col-active="false"
    :has-col-delete="true"
    :has-col-edit="true"
    @onClearFilter="onClearFilter"
  >
    <template #filterElemets>
      <t-text-box-string
        id="ticketCategoryName"
        v-model="filterParams.ticketCategoryName"
        label="عنوان"
      />
      <t-combo-box
        id="departmentID"
        v-model="filterParams.departmentID"
        :filter-params="filterParamsDepartments"
        label="دپارتمان"
        resource-data="tkt/departments"
        resource-meta="tkt/departments/meta"
        main-field-name="departmentName"
      />
    </template>
  </t-grid-view>
</template>

<script>
import TGridView from '@/components/gridview/TGridView.vue'
import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'
import TComboBox from '~/components/dataentry/TComboBox.vue'

export default {
  name: 'Ticketcat',
  components: {
    TGridView,
    TTextBoxString,
    TComboBox
  },
  data () {
    return {
      title: 'دسته بندی تیکت ها',
      filterParams: {
        ticketCategoryName: null,
        departmentID: null
      }
    }
  },
  head () {
    return {
      title: this.title
    }
  },
  computed: {
    filterParamsDepartments () {
      return { filter: 'DepartmentID NOT IN (1,2)' }
    }
  },
  methods: {
    onClearFilter () {
      this.filterParams = {}
    }
  }
}
</script>
<style lang="scss" scoped></style>
