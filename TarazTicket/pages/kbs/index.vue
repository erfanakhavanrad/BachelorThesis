<template>
  <div v-if="resIsLaptop()">
    <t-grid-view
      id="TktKnowledgebases"
      :title="title"
      resource-data="tkt/knowledgebases"
      resource-meta="tkt/knowledgebases/meta"
      main-field-name="knowledgeBaseName"
      :filter-params="filterParams"
      :has-col-active="false"
      :has-col-delete="true"
      :has-col-edit="true"
      @onClearFilter="onClearFilter"
    >
      <template #filterElemets>
        <t-text-box-string
          id="knowledgeBaseName"
          v-model="filterParams.knowledgeBaseName"
          label="عنوان"
        />
        <t-combo-box
          id="knowledgeBaseCategoryID"
          v-model="filterParams.knowledgeBaseCategoryID"
          label="دسته بندی"
          resource-data="tkt/knowledgebasecategories"
          resource-meta="tkt/knowledgebasecategories/meta"
          main-field-name="knowledgeBaseCategoryName"
        />
      </template>
    </t-grid-view>
  </div>
  <div v-else>
    <TListView
      id="TktKnowledgebases"
      :title="title"
      resource-data="tkt/knowledgebases"
      resource-meta="tkt/knowledgebases/meta"
      main-field-name="knowledgeBaseName"
      :filter-params="filterParams"
      :has-col-active="false"
      :has-col-delete="true"
      :has-col-edit="true"
      @onClearFilter="onClearFilter"
    >
      <template #resFilterElemets>
        <t-text-box-string
          id="knowledgeBaseName"
          v-model="filterParams.knowledgeBaseName"
          label="عنوان"
        />
        <t-combo-box
          id="knowledgeBaseCategoryID"
          v-model="filterParams.knowledgeBaseCategoryID"
          label="دسته بندی"
          resource-data="tkt/knowledgebasecategories"
          resource-meta="tkt/knowledgebasecategories/meta"
          main-field-name="knowledgeBaseCategoryName"
        />
      </template>
    </TListView>
  </div>
</template>

<script>
import common from '@/assets/common'
import TGridView from '@/components/gridview/TGridView.vue'
import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'
import TComboBox from '~/components/dataentry/TComboBox.vue'
import TListView from '~/components/listview/TListView.vue'

export default {
  name: 'Kbs',
  components: {
    TGridView,
    TTextBoxString,
    TComboBox,
    TListView
  },
  data () {
    return {
      title: 'مدیریت مقالات پایگاه دانش',
      filterParams: {}
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
