<template>
  <t-insert-panel
    :data-entry-model="dataEntryModel"
    :validation="validation"
    :title="title"
    resource-data="tkt/tickets"
    @onInserted="onInserted"
  >
    <template #dataEntryElements>
      <t-combo-box
        v-if="isShowFromDepartmentID"
        id="fromDepartmentID"
        v-model="fromDepartmentID"
        :rules="rules.fromDepartmentID"
        label="از دپارتمان"
        :resource-data="resourceDataFromDepartment"
        resource-meta="tkt/departments/meta"
        main-field-name="departmentName"
        @onChangedValidation="onChangedValidation"
      />
      <t-combo-box
        id="toDepartmentID"
        v-model="toDepartmentID"
        :rules="rules.toDepartmentID"
        label="به دپارتمان"
        resource-data="tkt/departments"
        resource-meta="tkt/departments/meta"
        main-field-name="departmentName"
        @onChangedValidation="onChangedValidation"
      />
      <t-combo-box
        v-if="isCustomer === false"
        id="toUserID"
        v-model="toUserID"
        :rules="rules.toUserID"
        label="کاربر"
        :resource-data="resourceDataStaff"
        resource-meta="tkt/users/meta"
        main-field-name="fullUsername"
        async
        @onChangedValidation="onChangedValidation"
      />
      <t-combo-box
        id="ticketCategoryID"
        v-model="ticketCategoryID"
        :rules="rules.ticketCategoryID"
        :filter-params="filterParamsTicketCategories"
        label="دسته بندی تیکت"
        resource-data="tkt/ticketcategories"
        resource-meta="tkt/ticketcategories/meta"
        main-field-name="ticketCategoryName"
        @onChangedValidation="onChangedValidation"
      />

      <t-combo-box
        v-if="isCustomer === false"
        id="answerID"
        v-model="answerID"
        :rules="rules.answerID"
        label="انتخاب از بین پاسخ‌های پیش فرض"
        resource-data="tkt/defaultconversationanswers"
        resource-meta="tkt/defaultconversationanswers/meta"
        main-field-name="answerDesc"
        @onChangedValidation="onChangedValidation"
        @onSelect="onSelectDefaultConversationAnswer"
      />

      <t-text-box-string
        id="ticketTitle"
        v-model="ticketTitle"
        :rules="rules.ticketTitle"
        label="عنوان"
        @onChangedValidation="onChangedValidation"
      />

      <t-text-area
        id="ticketDesc"
        v-model="ticketDesc"
        :rules="rules.ticketDesc"
        label="پیغام"
        @onChangedValidation="onChangedValidation"
      />
      <t-combo-box
        id="priorityID"
        v-model="priorityID"
        :rules="rules.priorityID"
        label="اهمیت"
        resource-data="tkt/priorities"
        resource-meta="tkt/priorities/meta"
        main-field-name="priorityName"
        @onChangedValidation="onChangedValidation"
      />

      <t-file
        id="attachmentF"
        v-model="attachmentF"
        label="فایل های الحاقی"
        @onChangedValidation="onChangedValidationResponse"
        @on-input-file="onInputFile"
      />
    </template>
  </t-insert-panel>
</template>

<script>
import { mapGetters } from 'vuex'
import TInsertPanel from '~/components/dataentry/TInsertPanel.vue'
import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'
import TComboBox from '~/components/dataentry/TComboBox.vue'
import TTextArea from '~/components/dataentry/TTextArea.vue'
import TFile from '~/components/dataentry/TFile.vue'

export default {
  components: {
    TInsertPanel,
    TTextBoxString,
    TComboBox,
    TTextArea,
    TFile
  },
  data () {
    // بدون وابستگی
    return {
      title: 'تیکت جدید',
      toDepartmentID: null,
      fromDepartmentID: null,
      fromUserID: null,
      toUserID: null,
      ticketCategoryID: null,
      ticketTitle: null,
      ticketDesc: null,
      priorityID: null,
      attachmentF: null, // data entry response
      tst: null,
      answerID: null,
      validation: {},
      attachment: {},
      rules: {
        toDepartmentID: { required: true },
        fromDepartmentID: { required: true },
        toUserID: { required: true },
        ticketCategoryID: { required: true },
        ticketTitle: { required: true, min: 2, max: 30 },
        knowledgeBaseCategoryName: { required: true, min: 3, max: 30 },
        ticketDesc: { required: true, min: 5, max: 1000 },
        priorityID: { required: true },
        answerID: { required: false },
        attachmentF: { required: false }
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
      perComID: '_user/GET_PERCOMID',
      isCustomer: '_user/IS_CUSTOMER',
      organizationID: '_user/GET_ORGANIZATIONID',
      departmentIDs: '_user/GET_DEPARTMENTIDS'
    }),
    isShowFromDepartmentID () {
      if (this.isCustomer) {
        // اگر مشتری است نباید کمبوی از دپارتمان را ببیند
        return false
      } else if (this.departmentIDs.length === 1) {
        // اگر کارمند است ولی تنها در یک
        // دپارتمان حضور دارد هم نباید کمبوی
        // از دپارتمان را ببیند
        return false
      }
      // اگر هم کارمند است و هم در بیش از یک دپارتمان حضور دارد
      // میتواند کمبوی از دپارتمان را ببیند
      return true
    },
    defaultDepartmentID () {
      // if (this.isCustomer) {
      //   // اگر مشتری است دپارتمان ندارد
      //   return null
      // }
      if (this.departmentIDs.length === 1) {
        // اگر کارمند است ولی تنها در یک
        // دپارتمان حضور دارد
        // تنها دپارتمان موجود برای آن احاظ میشود
        return this.departmentIDs[0]
      }
      // اگر هم کارمند است و هم در بیش از یک دپارتمان حضور دارد
      // دپارتمان پیشفرض ندارد و باید از کمبو پر شود
      return null
    },
    dataEntryModel () {
      const attachmentObjTmp = {}
      attachmentObjTmp.fileName = this.attachment.name
      attachmentObjTmp.fileType = this.attachment.type
      attachmentObjTmp.attachment = this.attachmentF

      return {
        toDepartmentID: this.toDepartmentID,
        fromDepartmentID: this.fromDepartmentID,
        fromUserID: this.fromUserID,
        toUserID: this.toUserID,
        ticketCategoryID: this.ticketCategoryID,
        ticketTitle: this.ticketTitle,
        ticketDesc: this.ticketDesc,
        priorityID: this.priorityID,
        fromOrganizationID: this.organizationID, // فقط اگر مشتری لاگین کرده باشد این فیلد پر می شود
        attachmentObj: attachmentObjTmp
      }
    },
    resourceDataFromDepartment () {
      if (this.perComID == null) {
        return null
      } else {
        return `tkt/users/${this.perComID}/departments`
      }
    },
    resourceDataStaff () {
      if (this.toDepartmentID == null) {
        return null
      } else {
        return 'tkt/departments/' + this.toDepartmentID + '/users'
      }
    },
    filterParamsTicketCategories () {
      if (this.toDepartmentID == null) {
        return {}
      } else {
        return { departmentID: this.toDepartmentID }
      }
    }
  },
  mounted () {
    this.fromUserID = this.perComID
    this.fromDepartmentID = this.defaultDepartmentID
  },
  methods: {
    onChangedValidation (_validation) {
      this.validation = Object.assign({}, this.validation, _validation)
    },
    onInputFile (attachment) {
      this.attachment.name = attachment.aName
      this.attachment.type = attachment.type
      // this.attachment.attachment = this.attachmentF
    },
    onSelectDefaultConversationAnswer (answerDesc) {
      this.ticketDesc = answerDesc
    },
    onInserted (data) {
      this.toDepartmentID = null
      this.fromDepartmentID = this.defaultDepartmentID
      this.fromUserID = null
      this.toUserID = null
      this.ticketCategoryID = null
      this.ticketTitle = null
      this.ticketDesc = null
      this.priorityID = null
      this.attachment = null

      this.$router.push({
        name: 'tickets-edit',
        query: {
          id: data.ticketID
        }
      })
    }
  }
}
</script>
<style lang="scss" scoped></style>
