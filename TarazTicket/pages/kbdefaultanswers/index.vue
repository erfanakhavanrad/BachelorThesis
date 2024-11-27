<template>
  <div v-if="resIsLaptop()">
    <t-grid-view
      id="TktDefaultConversationAnswer"
      :title="title"
      resource-data="tkt/defaultconversationanswers"
      resource-meta="tkt/defaultconversationanswers/meta"
      main-field-name="answerDesc"
      :filter-params="filterParams"
      :has-col-active="false"
      :has-col-delete="true"
      :has-col-edit="true"
      @onClearFilter="onClearFilter"
    >
      <template #filterElemets>
        <t-text-box-string
          id="answerDesc"
          v-model="filterParams.answerDesc"
          label="پاسخ پیش فرض"
        />
      </template>
    </t-grid-view>
  </div>
  <div v-else>
    <TListView
      id="TktDefaultConversationAnswer"
      :title="title"
      resource-data="tkt/defaultconversationanswers"
      resource-meta="tkt/defaultconversationanswers/meta"
      main-field-name="answerDesc"
      :filter-params="filterParams"
      :has-col-active="false"
      :has-delete="true"
      :has-edit="true"
      @onClearFilter="onClearFilter"
    >
      <template #filterElemets>
        <t-text-box-string
          id="answerDesc"
          v-model="filterParams.answerDesc"
          label="پاسخ پیش فرض"
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
  name: 'KbDefaultAnswers',
  components: {
    TGridView,
    TTextBoxString,
    TListView
  },
  data () {
    return {
      title: 'لیست پاسخ‌های آماده',
      filterParams: {
        answerDesc: null
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
