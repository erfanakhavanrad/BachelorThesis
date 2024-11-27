<template>
  <div v-if="resIsLaptop()">
    <t-grid-view
      id="TktStaff"
      :title="title"
      resource-data="tkt/staff"
      resource-meta="tkt/staff/meta"
      main-field-name="userName"
      :filter-params="filterParams"
      :has-col-active="false"
      :has-col-delete="true"
      :has-col-edit="true"
      :has-col-reset-pass="true"
      :has-col-menu-access="isAdmin ? true : false"
      @onClearFilter="onClearFilter"
    >
      <template #filterElemets>
        <t-text-box-string
          id="userName"
          v-model="filterParams.userName"
          label="نام"
        />

        <t-combo-box
          id="departmentID"
          v-model="filterParams.departmentID"
          label="دپارتمان"
          resource-data="tkt/departments"
          resource-meta="tkt/departments/meta"
          main-field-name="departmentName"
        />
      </template>
    </t-grid-view>
  </div>
  <div v-else>
    <TListView
      id="TktStaff"
      :title="title"
      resource-data="tkt/staff"
      resource-meta="tkt/staff/meta"
      main-field-name="userName"
      :filter-params="filterParams"
      :has-col-active="false"
      :has-delete="true"
      :has-edit="true"
      :has-col-menu-access="isAdmin ? true : false"
      @onClearFilter="onClearFilter"
    >
      <template #resFilterElemets>
        <t-text-box-string
          id="userName"
          v-model="filterParams.userName"
          label="نام"
        />

        <t-combo-box
          id="departmentID"
          v-model="filterParams.departmentID"
          label="دپارتمان"
          resource-data="tkt/departments"
          resource-meta="tkt/departments/meta"
          main-field-name="departmentName"
        />
      </template>
    </TListView>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import common from '@/assets/common'
import TGridView from '@/components/gridview/TGridView.vue'
import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'
import TComboBox from '~/components/dataentry/TComboBox.vue'
import TListView from '~/components/listview/TListView.vue'

export default {
  name: 'Staff',
  components: {
    TGridView,
    TTextBoxString,
    TComboBox,
    TListView
  },
  data () {
    return {
      title: 'کارمندان',
      filterParams: {
        knowledgeBaseCategoryName: null,
        creatorID: null,
        createDate: null
      }
    }
  },
  head () {
    return {
      title: this.title
    }
  },
  computed: {
    ...mapGetters({
      isAdmin: '_user/IS_ADMIN'
    })
  },
  // created () {
  //   this.filterParams = this.$route.params
  // },
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
