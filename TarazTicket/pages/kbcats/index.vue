<template>
  <div v-if="resIsLaptop()">
    <t-grid-view
      id="TktKnowledgeBaseCategory"
      :title="title"
      resource-data="tkt/knowledgebasecategories"
      resource-meta="tkt/knowledgebasecategories/meta"
      main-field-name="knowledgeBaseCategoryName"
      :filter-params="filterParams"
      :has-col-active="false"
      :has-col-delete="true"
      :has-col-edit="true"
      @onClearFilter="onClearFilter"
    >
      <template #filterElemets>
        <t-text-box-string
          id="knowledgeBaseCategoryName"
          v-model="filterParams.knowledgeBaseCategoryName"
          label="عنوان"
        />
      </template>
    </t-grid-view>
  </div>
  <div v-else>
    <TListView
      id="TktKnowledgeBaseCategory"
      :title="title"
      resource-data="tkt/knowledgebasecategories"
      resource-meta="tkt/knowledgebasecategories/meta"
      main-field-name="knowledgeBaseCategoryName"
      :filter-params="filterParams"
      :has-col-active="false"
      :has-col-delete="true"
      :has-col-edit="true"
      @onClearFilter="onClearFilter"
    >
      <template #resFilterElemets>
        <t-text-box-string
          id="knowledgeBaseCategoryName"
          v-model="filterParams.knowledgeBaseCategoryName"
          label="عنوان"
        />
      </template>
    </TListView>
  </div>
</template>

<script>
import common from '@/assets/common'
import TGridView from '@/components/gridview/TGridView.vue'
import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'
import TListView from '~/components/listview/TListView.vue'

export default {
  name: 'KbCats',
  components: {
    TGridView,
    TTextBoxString,
    TListView
  },
  data () {
    return {
      title: 'دسته بندی های پایگاه دانش',
      filterParams: {
        knowledgeBaseCategoryName: null
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
      this.filterParams = {}
    },
    resIsLaptop () {
      return common.isLargeScreen()
    }
  }
}
</script>
<style lang="scss" scoped></style>
