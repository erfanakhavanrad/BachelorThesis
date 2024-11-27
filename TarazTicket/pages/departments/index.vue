<template>
  <div v-if="resIsLaptop()">
    <t-grid-view
      id="TktDepartments"
      :title="title"
      resource-data="tkt/departments"
      resource-meta="tkt/departments/meta"
      main-field-name="departmentName"
      :filter-params="filterParams"
      :has-col-active="false"
      :has-col-delete="true"
      :has-col-edit="true"
      @onClearFilter="onClearFilter"
    >
      <template #filterElemets>
        <t-text-box-string
          id="departmentName"
          v-model="filterParams.departmentName"
          label="عنوان"
        />
        <t-text-box-email-search
          id="departmentEmailAddress"
          v-model="filterParams.departmentEmailAddress"
          label="آدرس ایمیل"
        />
      </template>
    </t-grid-view>
  </div>
  <div v-else>
    <TListView
      id="TktDepartments"
      :title="title"
      resource-data="tkt/departments"
      resource-meta="tkt/departments/meta"
      main-field-name="departmentName"
      :filter-params="filterParams"
      :has-col-active="false"
      has-delete="true"
      has-edit="true"
      @onClearFilter="onClearFilter"
    >
      <template #resFilterElemets>
        <t-text-box-string
          id="departmentName"
          v-model="filterParams.departmentName"
          label="عنوان"
        />
        <t-text-box-email-search
          id="departmentEmailAddress"
          v-model="filterParams.departmentEmailAddress"
          label="آدرس ایمیل"
        />
      </template>
    </TListView>
  </div>
</template>

<script>
import common from '@/assets/common'
import TGridView from '@/components/gridview/TGridView.vue'
import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'
import TTextBoxEmailSearch from '~/components/dataentry/TTextBoxEmailSearch.vue'
import TListView from '~/components/listview/TListView.vue'

export default {
  name: 'Department',
  components: {
    TGridView,
    TTextBoxString,
    TTextBoxEmailSearch,
    TListView
  },
  data () {
    return {
      title: 'دپارتمان ها',
      filterParams: {
        departmentName: null,
        departmentEmailAddress: null,
        filter: 'DepartmentID NOT IN (1,2)'
      }
    }
  },
  head () {
    return {
      title: this.title
    }
  },
  created () {},
  methods: {
    onClearFilter () {
      this.filterParams = {
        filter: 'DepartmentID NOT IN (1,2)'
      }
    },
    resIsLaptop () {
      return common.isLargeScreen()
    }
  }
}
</script>
<style lang="scss" scoped></style>
