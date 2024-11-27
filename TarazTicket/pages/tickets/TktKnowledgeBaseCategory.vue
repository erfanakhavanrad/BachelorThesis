<template>
  <t-list-view
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
      <t-text-box-integer
        id="creatorID"
        v-model="filterParams.creatorID"
        label="ایجاد کننده"
        has-comma
      />
    </template>
  </t-list-view>
</template>

<script>
import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'
import TTextBoxInteger from '~/components/dataentry/TTextBoxInteger.vue'
import TListView from '~/components/listview/TListView.vue'

export default {
  name: 'Tickets',
  components: {
    TTextBoxString,
    TTextBoxInteger,
    TListView
  },
  data () {
    return {
      title: 'دسته بندی های پایگاه دانش',
      filterParams: {
        knowledgeBaseCategoryName: null,
        serverID: 12345,
        serverID1: 569854,
        serverID2: 1.025,
        serverID3: 0.0235
      }
    }
  },
  head () {
    return {
      title: this.title
    }
  },
  methods: {
    onClearFilter () {
      this.filterParams = {}
    }
  }
}
</script>

<style></style>
