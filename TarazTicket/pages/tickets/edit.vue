<template>
  <b-overlay :show="isLoading">
    <b-card
      header-tag="header"
      header-class="t-card-header-ticket"
      body-class="t-card-body-ticket"
      class="t-card-ticket"
    >
      <template #header>
        <div id="t-title-ticket">
          وضعیت تیکت:
          {{ ticket.statusTitle }}
        </div>
        <b-button-group id="t-button-group-actionbar" size="sm">
          <b-button
            v-if="isVisibleButtonReferToMe"
            variant="primary"
            title="ارجاع به من"
            @click="onClickReferToMe"
          >
            <span>ارجاع به من</span>
            <font-awesome-icon icon="reply" size="lg" />
          </b-button>
          <b-button
            v-if="isVisibleSatisfactionButton"
            variant="info"
            title="رضایت مندی"
            @click="onClickSatisfaction"
          >
            <span>رضایت مندی</span>
            <font-awesome-icon icon="smile" size="lg" />
          </b-button>
          <b-button
            v-if="isVisibleReOpenButton"
            variant="warning"
            title="دوباره باز کردن تیکت"
            @click="onClickReOpenTicket"
          >
            <span>دوباره باز کردن تیکت</span>
            <font-awesome-icon icon="folder-open" size="lg" />
          </b-button>
          <b-button
            v-else-if="isVisibleCloseButtonAndAnswerButton"
            variant="success"
            title="بستن"
            @click="onClickCloseTicket"
          >
            <span>بستن</span>
            <font-awesome-icon icon="folder" size="lg" />
          </b-button>
          <b-button
            v-if="isVisibleCloseButtonAndAnswerButton"
            variant="primary"
            title="پاسخ به تیکت"
            @click="onClickResponseTicket"
          >
            <span>پاسخ به تیکت</span>
            <font-awesome-icon icon="undo" size="lg" />
          </b-button>
          <b-button
            v-if="isVisibleTransferButton"
            variant="secondary"
            title="انتقال"
            @click="onClickTransferTicket"
          >
            <span>انتقال</span>
            <font-awesome-icon icon="exchange-alt" size="lg" />
          </b-button>
          <b-button
            v-if="ticket.statusID != 10000007"
            variant="outline-secondary"
            title="بروزرسانی لیست"
            @click="onRefresh"
          >
            <font-awesome-icon icon="sync" size="lg" />
          </b-button>
        </b-button-group>
      </template>
      <b-collapse
        id="t-collapse-ticket-response"
        v-model="ticketResponsePanelVisibility"
        @hidden="scrollToTop"
        @shown="scrollToTop"
      >
        <b-card
          id="t-card-ticket-response"
          footer-tag="footer"
          footer-class="t-card-ticket-response-footer"
        >
          <b-card-text id="t-card-text-ticket-response">
            <t-text-box-string
              id="ticketTitle"
              v-model="ticket.ticketTitle"
              disabled
              label="عنوان"
            />
            <t-combo-box
              v-if="isCustomer === false"
              id="statusID"
              v-model="statusID"
              :rules="{ required: true }"
              :filter-params="filterParamsTicketStatus"
              label="وضعیت جدید تیکت"
              resource-data="tkt/statuses"
              resource-meta="tkt/statuses/meta"
              main-field-name="statusTitle"
              @onChangedValidation="onChangedValidationResponse"
            />

            <t-combo-box
              v-if="isCustomer === false"
              id="answerID"
              v-model="answerID"
              :rules="{ required: false }"
              label="انتخاب از بین پاسخ‌های پیش فرض"
              resource-data="tkt/defaultconversationanswers"
              resource-meta="tkt/defaultconversationanswers/meta"
              main-field-name="answerDesc"
              @onSelect="onSelectDefaultConversationAnswer"
            />

            <t-text-area
              v-if="ticketDescRefer != null"
              id="ticketDescRefer"
              v-model="ticketDescRefer"
              :rules="{ required: true }"
              disabled
              label="در پاسخ به"
              @onChangedValidation="onChangedValidationResponse"
            />
            <t-text-area
              id="ticketDesc"
              v-model="ticketDesc"
              :rules="{ required: true }"
              label="پیغام"
              @onChangedValidation="onChangedValidationResponse"
            />
            <t-file
              id="attachmentF"
              v-model="attachmentF"
              label="فایل های الحاقی"
              @onChangedValidation="onChangedValidationResponse"
              @on-input-file="onInputFile"
            />

            <t-check-box
              v-if="!isCustomer"
              id="isConfidential"
              v-model="isConfidential"
              label="پیغام محرمانه"
            />

            <t-combo-box
              v-if="isConfidential"
              id="referID"
              v-model="referID"
              :rules="{ required: false }"
              label="ارجاع به"
              resource-data="tkt/users"
              resource-meta="tkt/users/meta"
              main-field-name="perComName"
            />
          </b-card-text>
          <template #footer>
            <b-button-group size="sm">
              <b-button
                variant="outline-secondary"
                title="انصراف"
                @click="onCancelResponse"
              >
                <span>انصراف</span>
                <font-awesome-icon icon="times" size="lg" />
              </b-button>
              <b-button
                v-if="isVisibleCloseButtonAndAnswerButton"
                variant="success"
                title="ارسال پاسخ و بستن تیکت"
                :disabled="!isValidDataEntryResponse"
                @click="onSendResponseAndCloseTicket"
              >
                <span>ارسال پاسخ و بستن تیکت</span>
                <font-awesome-icon icon="check" size="lg" />
              </b-button>
              <b-button
                variant="info"
                :title="sendResponseButtonTitle"
                :disabled="!isValidDataEntryResponse"
                @click="onBeforeSendResponseTicket"
              >
                <span>{{ sendResponseButtonTitle }}</span>
                <font-awesome-icon icon="paper-plane" size="lg" />
              </b-button>
            </b-button-group>
          </template>
        </b-card>
      </b-collapse>

      <b-collapse
        id="t-collapse-ticket-transfer"
        v-model="ticketTransferPanelVisibility"
        @hidden="scrollToTop"
        @shown="scrollToTop"
      >
        <b-card
          id="t-card-ticket-transfer"
          footer-tag="footer"
          footer-class="t-card-ticket-transfer-footer"
        >
          <b-card-text id="t-card-text-ticket-transfer">
            <t-combo-box
              id="departmentID"
              v-model="toDepartmentID"
              :rules="{ required: true }"
              :filter-params="filterParamsDepartments"
              label="به دپارتمان"
              resource-data="tkt/departments"
              resource-meta="tkt/departments/meta"
              main-field-name="departmentName"
              @onChangedValidation="onChangedValidationTransfer"
            />
            <t-combo-box
              id="toUserID"
              v-model="toUserID"
              :rules="{ required: true }"
              label="کاربر"
              :resource-data="resourceDataStaff"
              resource-meta="tkt/users/meta"
              main-field-name="perComName"
              async
              @onChangedValidation="onChangedValidationTransfer"
            />

            <t-combo-box
              v-if="isCustomer === false"
              id="answerID"
              v-model="answerID"
              :rules="{ required: false }"
              label="انتخاب از بین پاسخ‌های پیش فرض"
              resource-data="tkt/defaultconversationanswers"
              resource-meta="tkt/defaultconversationanswers/meta"
              main-field-name="answerDesc"
              @onSelect="onSelectDefaultConversationAnswer"
            />

            <t-text-area
              id="ticketDesc"
              v-model="ticketDesc"
              :rules="{ required: false }"
              label="پیغام"
              @onChangedValidation="onChangedValidationTransfer"
            />
            <t-check-box
              id="isConfidential"
              v-model="isConfidential"
              label="پیغام محرمانه"
            />

            <t-combo-box
              v-if="isConfidential"
              id="referID"
              v-model="referID"
              :rules="{ required: false }"
              label="ارجاع به"
              resource-data="tkt/users"
              resource-meta="tkt/users/meta"
              main-field-name="perComName"
            />
          </b-card-text>
          <template #footer>
            <b-button-group size="sm">
              <b-button
                variant="outline-secondary"
                title="انصراف"
                @click="onCancelTransfer"
              >
                <span>انصراف</span>
                <font-awesome-icon icon="times" size="lg" />
              </b-button>
              <b-button
                variant="info"
                title="انتقال"
                :disabled="!isValidDataEntryTransfer"
                @click="onSendTransferTicket"
              >
                <span>انتقال</span>
                <font-awesome-icon icon="exchange-alt" size="lg" />
              </b-button>
            </b-button-group>
          </template>
        </b-card>
      </b-collapse>
      <b-card
        header-tag="header"
        header-class="t-card-header-conversation"
        body-class="t-card-body-conversation"
        class="t-card-conversation"
      >
        <template #header>
          <div>
            <div id="t-title-conversation">
              <div id="t-title-conversation-title">
                <font-awesome-icon icon="ticket-alt" size="sm" />
                <span>تیکت</span>
                <span>{{ ticket.ticketNumber }}</span>
                <span>|</span>
                <span>{{ ticket.ticketTitle }}</span>
              </div>
              <div id="t-title-conversation-actions">
                <b-button
                  variant="primary"
                  title="چاپ"
                  @click="onClickPrintTicket"
                >
                  <font-awesome-icon icon="print" size="sm" />
                </b-button>
              </div>
            </div>
            <div v-if="conversationFirst != null" id="t-first-conversation">
              <t-chat :conversation="conversationFirst" :ticket="ticket" />
            </div>
            <span
              v-else
              id="t-span-no-first-conversation"
            >اولین پیام این تیکت ایجاد نشده یا بنا به دلایلی حذف شده است</span>
          </div>
        </template>
        <span
          v-if="conversationOther.length == 0 && !isLoading"
          id="t-span-no-other-conversation"
        >
          برای این تیکت هیچ پیامی بین کاربران رد و بدل نشده است
        </span>
        <t-chat
          v-for="conversation in conversationOther"
          v-else
          :key="conversation.ticketConversationID"
          :conversation="conversation"
          :ticket="ticket"
          @onClickEditChat="onClickEditChat"
          @onClickDeleteChat="onClickDeleteChat"
          @onClickReplyChat="onClickReplyChat"
        />
      </b-card>
    </b-card>
    <div v-if="!isCustomer" id="t-container-customer-organization-info">
      <b-card
        header-tag="header"
        header-class="t-card-header-organization-info"
        body-class="t-card-body-organization-info"
        class="t-card-organization-info"
      >
        <template #header>
          <font-awesome-icon icon="info" />
          <span>اطلاعات سازمان / دپارتمان</span>
        </template>
        <div id="t-organization-info">
          <span class="t-item">
            <font-awesome-icon
              icon="industry"
              size="lg"
              title="نام سازمان / دپارتمان"
            />
            <span>{{ ticketCreatorOrganizationInfo.name }}</span>
          </span>
          <span class="t-item">
            <font-awesome-icon icon="phone" size="lg" title="تلفن" />
            <span>{{ ticketCreatorOrganizationInfo.phone }}</span>
          </span>
          <span class="t-item">
            <font-awesome-icon icon="map" size="lg" title="آدرس" />
            <span>{{ ticketCreatorOrganizationInfo.address }}</span>
          </span>
          <span class="t-item">
            <font-awesome-icon icon="globe" size="lg" title="سایت" />
            <span>{{ ticketCreatorOrganizationInfo.website }}</span>
          </span>
        </div>
      </b-card>
      <b-card
        header-tag="header"
        header-class="t-card-header-customer-info"
        body-class="t-card-body-customer-info"
        class="t-card-customer-info"
      >
        <template #header>
          <font-awesome-icon icon="info" />
          <span>اطلاعات ایجاد کننده تیکت</span>
        </template>
        <div id="t-customer-info">
          <span class="t-item">
            <font-awesome-icon
              icon="user"
              size="lg"
              title="نام و نام خانوادگی"
            />
            <span>{{
              ticketCreatorPersonalInfo.perComFName +
                ' ' +
                ticketCreatorPersonalInfo.perComLName
            }}</span>
          </span>
          <span class="t-item">
            <font-awesome-icon icon="fingerprint" title="آی دی انی دسک" />
            <span>{{ ticketCreatorPersonalInfo.anyDeskID }}</span>
          </span>
          <span class="t-item">
            <font-awesome-icon icon="building" title="سازمان" />
            <span>{{
              ticketCreatorPersonalInfo.organizationName != null
                ? ticketCreatorPersonalInfo.organizationName
                : ticketCreatorPersonalInfo.departmentNames
            }}</span>
          </span>
          <span class="t-item">
            <font-awesome-icon icon="envelope" title="نام کاربری" />
            <span>{{ ticketCreatorPersonalInfo.userLoginName }}</span>
          </span>
          <span class="t-item">
            <font-awesome-icon icon="mobile-alt" title="موبایل" />
            <span>{{ ticketCreatorPersonalInfo.userMobileNumber }}</span>
          </span>
          <span class="t-item">
            <font-awesome-icon icon="phone" title="تلفن" />
            <span>{{ ticketCreatorPersonalInfo.userPhoneNumber }}</span>
          </span>
        </div>
      </b-card>
    </div>
    <t-modal-yes-no
      ref="TModalYesNo"
      title="حذف پیام"
      variant="danger"
      size="sm"
    >
      <div
        style="
          height: 50px;
          display: flex;
          justify-content: center;
          align-items: center;
        "
      >
        آیا از حذف این پیام اطمینان دارید؟
      </div>
    </t-modal-yes-no>
    <t-modal-ticket-satisfaction
      ref="TModalTicketSatisfaction"
      title="رضایت مندی"
      variant="success"
      size="lg"
    />
  </b-overlay>
</template>
<script>
import { mapGetters } from 'vuex'
import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'
import TComboBox from '~/components/dataentry/TComboBox.vue'
import TTextArea from '~/components/dataentry/TTextArea.vue'
import TFile from '~/components/dataentry/TFile.vue'
import TCheckBox from '~/components/dataentry/TCheckBox.vue'
import TChat from '~/components/dataentry/TChat.vue'
import TModalTicketSatisfaction from '~/components/general/TModalTicketSatisfaction.vue'
import TModalYesNo from '~/components/general/TModalYesNo.vue'

export default {
  components: {
    TTextBoxString,
    TComboBox,
    TTextArea,
    TFile,
    TCheckBox,
    TChat,
    TModalTicketSatisfaction,
    TModalYesNo
  },
  data () {
    return {
      validationDataEntryResponse: null,
      validationDataEntryTransfer: null,
      isLoading: false,
      ticketResponsePanelVisibility: false,
      ticketTransferPanelVisibility: false,
      ticket: {}, // دیتای این تیکت در اینجا قرار می گیرد
      statusID: null, // data entry response
      answerID: null, // data entry response
      ticketDesc: null, // data entry response & transfer
      ticketDescRefer: null, // data entry response
      attachmentF: null, // data entry response
      isConfidential: null, // data entry response & transfer
      referID: null,
      referIDs: null,
      ticketConversationID: null, // data entry response
      ticketConversationReferID: null, // data entry response
      toDepartmentID: null, // data entry transfer
      toUserID: null, // data entry transfer
      conversations: [], // چت های این تیکت در این متغیر قرار میگیرد
      defaultConverSationAnswer: null,
      ticketCreatorPersonalInfo: {},
      ticketCreatorOrganizationInfo: {},
      attachment: {}
    }
  },
  head () {
    return {
      title: this.ticketTitle
    }
  },
  computed: {
    ...mapGetters({
      perComID: '_user/GET_PERCOMID',
      isCustomer: '_user/IS_CUSTOMER',
      isAdmin: '_user/IS_ADMIN',
      username: '_user/GET_NAME_FAMILY',
      hasOwnership: '_user/HAS_OWNERSHIP'
    }),
    isVisibleButtonReferToMe () {
      if (
        this.ticket.statusID === 10000001 &&
        !this.isCustomer &&
        !this.isAdmin &&
        this.ticket.fromUserID !== this.perComID &&
        this.ticket.toUserID !== this.perComID &&
        this.ticket.fromOrganizationID != null &&
        !this.hasOwnership
      ) {
        return true
      }
      return false
    },
    filterParamsDepartments () {
      return { filter: 'DepartmentID NOT IN (1,2)' }
    },
    isUserReceiver () {
      // آیا گیرنده این تیکت من هستم ؟
      if (this.ticket.toUserID === this.perComID) {
        return true
      }
      return false
    },
    isVisibleSatisfactionButton () {
      if (
        (this.ticket.fromUserID === this.perComID &&
          this.ticket.statusID === 10000006 &&
          this.isCustomer &&
          this.ticket.satisfactionID == null) ||
        (this.ticket.fromUserID === this.perComID &&
          this.ticket.statusID === 10000003 &&
          !this.isCustomer &&
          this.ticket.satisfactionID == null)
      ) {
        return true
      }
      return false
    },
    isVisibleReOpenButton () {
      if (
        this.ticket.statusID === 10000006 ||
        (this.ticket.statusID === 10000003 && !this.isCustomer)
      ) {
        return true
      }
      return false
    },
    isVisibleTransferButton () {
      if (
        this.ticket.fromUserID !== this.perComID &&
        !this.isCustomer &&
        this.ticket.statusID !== 10000003 &&
        this.ticket.statusID !== 10000006 &&
        this.ticket.statusID !== 10000007
      ) {
        if (
          (this.ticket.fromOrganizationID != null &&
            this.ticket.statusID !== 10000001 &&
            !this.hasOwnership) ||
          (this.ticket.fromOrganizationID != null &&
            this.ticket.statusID === 10000001 &&
            this.ticket.toUserID === this.perComID) ||
          (this.ticket.fromOrganizationID != null && this.hasOwnership) ||
          this.ticket.fromOrganizationID == null
        ) {
          return true
        }
        return false
      }
      return false
    },
    isVisibleCloseButtonAndAnswerButton () {
      if (this.isCustomer) {
        if (
          this.ticket.statusID !== 10000006 &&
          this.ticket.statusID !== 10000007
        ) {
          // Show close button
          return true
        }
        return false
      } else {
        // is employee
        if (
          (this.ticket.statusID !== 10000006 &&
            this.ticket.statusID !== 10000007 &&
            this.ticket.fromOrganizationID != null &&
            this.ticket.statusID !== 10000003 &&
            this.ticket.statusID !== 10000001 &&
            !this.hasOwnership) ||
          (this.ticket.statusID !== 10000006 &&
            this.ticket.statusID !== 10000007 &&
            this.ticket.fromOrganizationID == null &&
            this.ticket.statusID !== 10000003) ||
          (this.ticket.statusID !== 10000006 &&
            this.ticket.statusID !== 10000007 &&
            this.isAdmin &&
            this.ticket.statusID !== 10000003) ||
          (this.ticket.statusID !== 10000006 &&
            this.ticket.statusID !== 10000007 &&
            this.hasOwnership &&
            this.ticket.statusID !== 10000003) ||
          (this.ticket.statusID === 10000001 &&
            this.ticket.fromOrganizationID != null &&
            this.ticket.toUserID === this.perComID)
        ) {
          return true
        }
        return false
      }
    },
    isValidDataEntryResponse () {
      // برای تک تک فیلد ها ولیدیشن چک میشود و به محض این که یک فیلد ولید نبود کل فرم غیر ولید میشود
      for (const key in this.validationDataEntryResponse) {
        if (!this.validationDataEntryResponse[key]) {
          return false
        }
      }
      return true
    },
    isValidDataEntryTransfer () {
      // برای تک تک فیلد ها ولیدیشن چک میشود و به محض این که یک فیلد ولید نبود کل فرم غیر ولید میشود
      for (const key in this.validationDataEntryTransfer) {
        if (!this.validationDataEntryTransfer[key]) {
          return false
        }
      }
      return true
    },
    resourceDataStaff () {
      if (this.toDepartmentID == null) {
        return null
      } else {
        return 'tkt/departments/' + this.toDepartmentID + '/users'
      }
    },
    filterParamsTicketStatus () {
      return { filter: 'statusTypeID = 1' }
    },
    recordID () {
      return this.$route.query.id
    },
    ticketTitle () {
      return this.ticket.ticketTitle
    },
    conversationFirst () {
      // اولین پیام
      return this.conversations.find(conversation => conversation.isFirst)
    },
    conversationOther () {
      // سایر پیام ها به جز پیام اول
      return this.conversations.filter(conversation => !conversation.isFirst)
    },
    sendResponseButtonTitle () {
      if (this.ticketConversationID == null) {
        return 'ارسال پاسخ'
      }
      return 'ویرایش پاسخ'
    }
  },
  async created () {
    this.isLoading = true
    await this.updatePage()
    await this.retrieveTicketCreatorPersonalInfo()
    await this.retrieveTicketCreatorOrganizationInfo()
    await this.makeTicketVisited()
    this.isLoading = false
  },
  methods: {
    // #region page control
    scrollToTop () {
      setTimeout(() => {
        this.$tscroll.onScrollToTop()
      }, 10)
    },
    scrollToBottom () {
      setTimeout(() => {
        this.$tscroll.onScrollToBottom()
      }, 10)
    },
    async updatePage () {
      // گرفتن تیکت از سرور
      // گرفتن چت ها از سرور
      // اسکرول به پایین صفحه
      await this.retrieveTicket()
      await this.retrieveConversation()
      this.scrollToTop()
    },
    // #endregion

    // #region action bar actions
    onClickReferToMe () {
      // نباید بدون بادی باشد(فعلا همینطور هست تا بعدا درموردش فکر شود)
      const referModel = {}
      this.$taxios
        .put('tkt/tickets', this.recordID + '/refertome', referModel)
        .then(async (response) => {
          this.isLoading = false
          if (response.status === 200) {
            this.$ttoast.createToast(
              'info',
              200,
              'success',
              'ticket refered successfully ',
              `تیکت با موفقیت به ${this.username} ارجاع شد`,
              3000
            )
            await this.updatePage()
          }
        })
        .catch(() => {
          this.isLoading = false
        })
    },
    onClickSatisfaction () {
      this.$refs.TModalTicketSatisfaction.show(
        (satisfactionID) => {
          this.onChangeSatisfaction(satisfactionID, null)
          // console.log('khers for confirm')
        },
        () => {
          // Here is on cancel
          // console.log('khers for cancelling')
          this.updatePage()
        }
      )
    },
    onClickReOpenTicket () {
      this.ticketResponsePanelVisibility = !this.ticketResponsePanelVisibility
      this.ticketTransferPanelVisibility = false
    },
    onClickCloseTicket () {
      this.ticketResponsePanelVisibility = false
      this.ticketTransferPanelVisibility = false
      if (this.ticket.fromUserID === this.perComID) {
        // console.log('Khers')
        this.$refs.TModalTicketSatisfaction.show(
          (satisfactionID) => {
            this.onChangeSatisfaction(satisfactionID, null)
            if (this.isCustomer) {
              // console.log('khers')
              this.onChangeStatus(10000006)
              this.ticketResponsePanelVisibility = false
              this.ticketTransferPanelVisibility = false
            } else {
              this.onChangeStatus(10000003)
            }
            // console.log('khers for confirm')
          },
          () => {
            // Here is on cancel
            // console.log('khers for cancelling')
            this.updatePage()
          }
        )
      } else if (this.ticket.fromUserID !== this.perComID) {
        if (this.isCustomer) {
          this.onChangeStatus(10000006)
        } else {
          this.onChangeStatus(10000003)
        }
      }
      // تیکت بسته می شود
    },
    onClickResponseTicket () {
      this.statusID = null
      this.answerID = null
      this.ticketDesc = null
      this.attachmentF = null
      this.ticketDescRefer = null
      this.attachmentFile = null
      this.isConfidential = null
      this.referID = null
      this.referIDs = null
      this.ticketConversationID = null
      this.toDepartmentID = null
      this.toUserID = null
      // for response
      this.ticketResponsePanelVisibility = !this.ticketResponsePanelVisibility
      this.ticketTransferPanelVisibility = false
    },
    onClickTransferTicket () {
      this.statusID = null
      this.answerID = null
      this.ticketDesc = null
      this.attachmentF = null
      this.ticketDescRefer = null
      this.attachmentFile = null
      this.isConfidential = null
      this.referID = null
      this.referIDs = null
      this.ticketConversationID = null
      this.toDepartmentID = null
      this.toUserID = null
      // for transfer
      this.ticketResponsePanelVisibility = false
      this.ticketTransferPanelVisibility = !this.ticketTransferPanelVisibility
    },
    // #endregion

    // #region server operation
    async retrieveTicketCreatorPersonalInfo () {
      const response = await this.$taxios.get(
        'tkt/users/' + this.ticket.fromUserID
      )
      this.ticketCreatorPersonalInfo = response.data
    },
    async retrieveTicketCreatorOrganizationInfo () {
      let response
      if (this.ticketCreatorPersonalInfo.organizationID == null) {
        // ایجاد کننده تیکت کارمند است
        response = await this.$taxios.get(
          'tkt/departments/' +
            this.ticketCreatorPersonalInfo.departmentIDs.split(',')[0]
        )
        this.ticketCreatorOrganizationInfo = {
          name: response.data.departmentName,
          phone: null,
          address: null,
          website: null
        }
      } else {
        // ایجاد کنند تیکت مشتری است
        response = await this.$taxios.get(
          'tkt/organizations/' + this.ticketCreatorPersonalInfo.organizationID
        )
        this.ticketCreatorOrganizationInfo = {
          name: response.data.organizationName,
          phone: response.data.organizationPhoneNumber,
          address: response.data.organizationAddress,
          website: response.data.organizationWebsite
        }
      }
    },
    async retrieveTicket () {
      // مشخصات این تیکت خاص از سرور گرفته می شود
      const response = await this.$taxios.get('tkt/tickets/' + this.recordID)
      this.ticket = response.data
    },
    async retrieveConversation () {
      // چت های این تیکت خاص از سرور گرفته میشود
      const response = await this.$taxios.get(
        'tkt/tickets/' + this.recordID + '/conversations'
      )
      if (response.data !== '') {
        this.conversations = response.data
      }
    },
    async makeTicketVisited () {
      // اگر من گیرنده تیکت باشم به محض لود شدن صفحه باید وضعیت ویزیت شدن تیکت ویزیت شده شود
      if (this.isUserReceiver && !this.ticket.isVisited) {
        await this.$taxios.put(
          'tkt/tickets',
          this.recordID + '/changeisvisited',
          {
            isVisited: true
          }
        )
      }
    },

    onChangeStatus (statusID) {
      let persianMsg = null
      let englishMsg = null
      switch (statusID) {
        case 10000001:
          persianMsg = 'تیکت باز شد'
          englishMsg = 'The Ticket is opened'
          break

        case 10000002:
          persianMsg = 'تیکت در حال بررسی است'
          englishMsg = 'The Ticket is processing'
          break

        case 10000003:
          persianMsg = 'تیکت توسط کارمند بسته شد'
          englishMsg = 'The Ticket is closed by the Employee'
          break

        case 10000004:
          persianMsg = 'تیکت پاسخ داده شد'
          englishMsg = 'The Ticket is responsed'
          break

        case 10000005:
          persianMsg = 'ایجاد کننده تیکت به تیکت پاسخ داد'
          englishMsg = 'The Ticket creator made a response'
          break

        case 10000006:
          persianMsg = 'تیکت توسط مشتری بسته شد'
          englishMsg = 'The Ticket is closed by the Customer'
          break

        default:
          break
      }
      this.isLoading = true
      const body = {
        statusID
      }
      this.$taxios
        .put('tkt/tickets', this.recordID + '/changestatus', body)
        .then(async (response) => {
          this.isLoading = false
          if (response.status === 200) {
            this.$ttoast.createToast(
              'info',
              200,
              'OK',
              englishMsg,
              persianMsg,
              3000
            )
            await this.updatePage()
          }
        })
        .catch(() => {
          this.isLoading = false
        })
    },
    onChangeSatisfaction (satisfactionID, callback) {
      this.isLoading = true
      const satisfactionModel = {
        satisfactionID
      }
      this.$taxios
        .put(
          'tkt/tickets',
          this.recordID + '/changesatisfaction',
          satisfactionModel
        )
        .then(async (response) => {
          this.isLoading = false
          if (response.status === 200) {
            this.$ttoast.createToast(
              'info',
              200,
              'OK',
              'Ticket satisfaction updated successfully',
              'میزان رضایت در سیستم ثبت شد',
              3000
            )
            await this.updatePage()
            // callback()
          }
        })
        .catch(() => {
          this.isLoading = false
        })
    },
    // #endregion

    // #region data entry response actions
    clearDataEntry () {
      // for response
      this.statusID = null
      this.answerID = null
      this.ticketDesc = null
      this.attachmentF = null
      this.ticketDescRefer = null
      this.attachmentFile = null
      this.isConfidential = null
      this.referID = null
      this.referIDs = null
      this.ticketConversationID = null
      // for transfer
      this.toDepartmentID = null
      this.toUserID = null
    },
    onSelectDefaultConversationAnswer (answerDesc) {
      this.ticketDesc = answerDesc
    },
    onCancelResponse () {
      // انصراف از ارسال پاسخ یا ویرایش چت
      this.clearDataEntry()
      this.ticketResponsePanelVisibility = false
    },
    async onSendResponseAndCloseTicket () {
      // پاسخ ارسال میگردد
      await this.onSendResponseTicket()
      // تیکت بسته می شود
      if (this.isCustomer) {
        this.onChangeStatus(10000006)
      } else {
        this.onChangeStatus(10000003)
      }
    },
    async onBeforeSendResponseTicket () {
      if (
        this.ticket.statusID === 10000003 ||
        this.ticket.statusID === 10000006
      ) {
        this.onChangeStatus(10000001)
        await this.onSendResponseTicket()
      } else if (!this.isCustomer) {
        this.onChangeStatus(this.statusID)
        await this.onSendResponseTicket()
      } else if (this.isCustomer) {
        await this.onSendResponseTicket()
      } else {
        //
      }
    },
    onSendResponseTicket () {
      // ارسال پاسخ
      this.isLoading = true
      this.ticketResponsePanelVisibility = false
      if (this.referID) {
        this.referIDs = `${this.perComID},${this.referID}`
      } else {
        this.referIDs = null
      }
      const body = {}
      const attachmentObjTmp = {}
      body.ticketID = this.ticket.ticketID
      body.fromUserID = this.perComID
      body.ticketDesc = this.ticketDesc
      body.ticketConversationReferID = this.ticketConversationReferID // برای حالت رپلای
      body.isConfidential = this.isConfidential
      body.referIDs = this.referIDs
      body.statusID = this.statusID
      attachmentObjTmp.fileName = this.attachment.name
      attachmentObjTmp.fileType = this.attachment.type
      attachmentObjTmp.attachment = this.attachmentF
      body.attachmentObj = attachmentObjTmp

      if (this.ticketConversationID == null) {
        // Insert
        return new Promise((resolve, reject) => {
          this.$taxios
            .post('tkt/ticketconversations', body)
            .then(async (response) => {
              this.isLoading = false
              if (response.status === 200) {
                this.clearDataEntry()
                await this.updatePage()
                return resolve(response)
              }
            })
            .catch((error) => {
              this.isLoading = false
              return reject(error)
            })
        })
      } else {
        // Update
        return new Promise((resolve, reject) => {
          this.$taxios
            .put('tkt/ticketconversations', this.ticketConversationID, body)
            .then(async (response) => {
              this.isLoading = false
              if (response.status === 200) {
                this.$ttoast.createToast(
                  'info',
                  200,
                  'OK',
                  'Record updated successfully',
                  'پیام ویرایش شد',
                  3000
                )
                this.clearDataEntry()
                await this.updatePage()
                return resolve(response)
              }
            })
            .catch((error) => {
              this.isLoading = false
              return reject(error)
            })
        })
      }
    },
    onChangedValidationResponse (_validationDataEntryResponse) {
      this.validationDataEntryResponse = Object.assign(
        {},
        this.validationDataEntryResponse,
        _validationDataEntryResponse
      )
    },
    onInputFile (attachment) {
      this.attachment.name = attachment.aName
      this.attachment.type = attachment.type
    },
    // #endregion

    // #region data entry transfer actions
    onCancelTransfer () {
      // انصراف از انتقال
      this.clearDataEntry()
      this.ticketTransferPanelVisibility = false
    },
    async onSendTransferTicket () {
      this.isLoading = true
      this.ticketTransferPanelVisibility = false
      if (this.referID) {
        this.referIDs = `${this.perComID},${this.referID}`
      } else {
        this.referIDs = null
      }
      const body = {}
      body.fromUserID = this.perComID
      body.toDepartmentID = this.toDepartmentID
      body.toUserID = this.toUserID
      body.ticketDesc = this.ticketDesc
      body.isConfidential = this.isConfidential
      body.referIDs = this.referIDs

      const response = await this.$taxios.put(
        'tkt/tickets',
        this.recordID + '/transfer',
        body
      )

      this.isLoading = false
      if (response.status === 200) {
        this.$ttoast.createToast(
          'info',
          200,
          'OK',
          'Ticket is Transfered',
          'تیکت منتقل شد',
          3000
        )
        this.$router.push({
          name: 'tickets'
        })
        // this.clearDataEntry()
        // await this.updatePage()
      }
    },
    onChangedValidationTransfer (_validationDataEntryTransfer) {
      this.validationDataEntryTransfer = Object.assign(
        {},
        this.validationDataEntryTransfer,
        _validationDataEntryTransfer
      )
    },
    // #endregion

    // #region conversation
    onClickEditChat (conversation) {
      console.log('conversation.statusID')
      console.log(conversation.statusID)
      this.statusID = conversation.statusID
      this.statusTitle = conversation.statusTitle
      this.ticketDesc = conversation.ticketDesc
      this.ticketConversationID = conversation.ticketConversationID
      this.isConfidential = conversation.isConfidential
      this.ticketResponsePanelVisibility = true
      this.scrollToTop()
    },
    onClickDeleteChat (ticketConversationID) {
      this.$refs.TModalYesNo.show(() => {
        this.onDeleteChat(ticketConversationID)
      })
    },
    onDeleteChat (ticketConversationID) {
      // حذف پیام
      this.isLoading = true
      this.$taxios
        .delete('tkt/ticketconversations', ticketConversationID)
        .then(async (response) => {
          this.isLoading = false
          if (response.status === 204) {
            this.$ttoast.createToast(
              'danger',
              204,
              'No Content',
              'Record Deleted successfully',
              'پبام با موفقیت حذف شد',
              3000
            )
            await this.updatePage()
          }
        })
        .catch(() => {
          this.isLoading = false
        })
    },
    onClickReplyChat (conversation) {
      this.ticketDescRefer = conversation.ticketDesc
      this.ticketConversationReferID = conversation.ticketConversationID
      this.ticketResponsePanelVisibility = true
      this.scrollToTop()
    },
    // #endregion

    // #region print
    onClickPrintTicket () {
      this.$tprint.create(this.ticket.ticketTitle, () => {
        let html = this._Print_Title()
        html += this._Print_Conv(this.conversationFirst)
        this.conversationOther.forEach((conversation) => {
          html += this._Print_Conv(conversation)
        })
        return html
      })
    },
    _Print_Title () {
      const styleDiv = this.$tprint.createStyle({
        width: '100%',
        display: 'flex',
        'flex-direction': 'row',
        'justify-content': 'right',
        'align-items': 'center'
      })
      const styleSpanTicketNumber = this.$tprint.createStyle({
        padding: '5px'
      })
      const styleSpanTicketTitle = this.$tprint.createStyle({
        padding: '5px'
      })
      let title = ''
      title += this.$tprint.openElement('div', styleDiv)

      title += this.$tprint.openElement('span', null)
      title += 'تیکت'
      title += this.$tprint.closeElement('span')

      title += this.$tprint.openElement('span', styleSpanTicketNumber)
      title += this.ticket.ticketNumber
      title += this.$tprint.closeElement('span')

      title += this.$tprint.openElement('span', null)
      title += '|'
      title += this.$tprint.closeElement('span')

      title += this.$tprint.openElement('span', styleSpanTicketTitle)
      title += this.ticket.ticketTitle
      title += this.$tprint.closeElement('span')

      title += this.$tprint.closeElement('div')

      title += '</br><hr/>'
      return title
    },
    _Print_Conv (conversation) {
      const styleTable = this.$tprint.createStyle({
        width: '100%',
        'border-radius': '8px',
        border: '1px solid grey',
        padding: '5px'
      })
      const styleTd1 = this.$tprint.createStyle({
        'border-bottom': '1px dashed grey',
        'font-size': 'smaller',
        padding: '2px'
      })
      const styleTd2 = this.$tprint.createStyle({
        padding: '20px'
      })
      const styleTd3 = this.$tprint.createStyle({
        'font-size': 'smaller',
        'font-style': 'italic',
        padding: '2px',
        'text-align': 'left',
        direction: 'ltr'
      })
      let firstConv = ''
      firstConv += this.$tprint.openElement('table', styleTable)

      firstConv += this.$tprint.openElement('tr', null)
      firstConv += this.$tprint.openElement('td', styleTd1)
      firstConv += conversation.fromUserName
      firstConv += this.$tprint.closeElement('td')
      firstConv += this.$tprint.closeElement('tr')

      firstConv += this.$tprint.openElement('tr', null)
      firstConv += this.$tprint.openElement('td', styleTd2)
      firstConv += conversation.ticketDesc
      firstConv += this.$tprint.closeElement('td')
      firstConv += this.$tprint.closeElement('tr')

      firstConv += this.$tprint.openElement('tr', null)
      firstConv += this.$tprint.openElement('td', styleTd3)
      firstConv += conversation.modifyDateS
      firstConv += this.$tprint.closeElement('td')
      firstConv += this.$tprint.closeElement('tr')

      firstConv += this.$tprint.closeElement('table')

      firstConv += '</br>'
      return firstConv
    },
    async retrieveData () {
      // واکشی دیتا( سطرها) از سرور
      this.retrieving = true
      const filterParams = JSON.parse(JSON.stringify(this.filterParams))
      Object.keys(filterParams).forEach((key, val) => {
        if (filterParams[key] === null || filterParams[key] === '') {
          delete filterParams[key]
        }
      })
      // filterParams.filter = this.filter
      // filterParams.pageNumber = this.pgeNmbr
      // filterParams.recordCount = this.recordCount

      // filterParams.pageNumber = this.pageNumber
      // filterParams.recordCount = this.recordCount

      // if (this.hasServerIDCol) {
      //   // اگر ستون سرور آی دی داریم محل های صدور را به سرور پاس میدهیم
      //   filterParams.srIDs = this.serverIDs.join(',')
      // }

      // if (this.hasYearIDCol) {
      //   // اگر ستون یر آی دی داریم سال های مالی را به سرور پاس میدهیم
      //   filterParams.yrIDs = this.yearIDs.join(',')
      // }
      const response = await this.$taxios.get(this.resourceData, filterParams)
      this.data = response.data
      this.retrieving = false
    },
    async onRefresh () {
      await this.updatePage()
    }
    // #endregion
  }
}
</script>
<style lang="scss" scoped>
$headerTopTicket: 80px; //  فاصله هدر تیکت از بالای صفحه
$headerTopConversation: 144px; // فاصله هدر چت ها از بالای صفحه
// #region card
$cardMargin: 1rem; // مارجین کارد
$cardHeaderHeight: 4rem; // ارتفاع هدر کارد
$cardBodyMargin: 1rem; // مارجین بادی کارد
$collapsePadding: 20rem;
$customerOrganizationInfoMargin: 1rem;
// #endregion

// #region actionbar
$actionbarButtonWidth: 8rem; // عرض دکمه های اکشن بار
// #endregion

// #region footer
$actionButtonWidth: 9rem; // عرض دکمه های فوتر
// #endregion

.t-card-ticket {
  margin: $cardMargin;
  .t-card-header-ticket {
    z-index: 2;
    height: $cardHeaderHeight;
    position: sticky;
    top: $headerTopTicket;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    background-color: var(--t-color-0-96);
    // border: 1px solid var(--t-color-0-80);

    #t-title-ticket {
      align-self: center;
      font-weight: bold;
    }
    #t-button-group-actionbar {
      direction: ltr;
      button {
        margin-left: 4px;
        margin-right: 4px;
        // width: $actionbarButtonWidth;
      }
    }
  }
  .t-card-body-ticket {
    padding: $cardBodyMargin;
    :deep(.t-tabs) {
      font-size: 0.8rem;
    }
    #t-collapse-ticket-response {
      padding-right: $collapsePadding;
      padding-left: $collapsePadding;
      #t-card-ticket-response {
        margin-bottom: $cardMargin;
        #t-card-text-ticket-response {
          display: flex;
          flex-direction: column;
        }
        .t-card-ticket-response-footer {
          display: flex;
          flex-direction: row;
          direction: ltr;
          justify-content: flex-end;
          button {
            margin-left: 4px;
            margin-right: 4px;
          }
        }
      }
    }

    #t-collapse-ticket-transfer {
      padding-right: $collapsePadding;
      padding-left: $collapsePadding;
      #t-card-ticket-transfer {
        margin-bottom: $cardMargin;
        #t-card-text-ticket-transfer {
          display: flex;
          flex-direction: column;
        }
        .t-card-ticket-transfer-footer {
          display: flex;
          flex-direction: row;
          direction: ltr;
          justify-content: flex-end;
          button {
            margin-left: 4px;
            margin-right: 4px;
          }
        }
      }
    }

    .t-card-conversation {
      .t-card-header-conversation {
        z-index: 3;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        position: sticky;
        top: $headerTopConversation;
        background-color: var(--t-color-0-96);
        #t-span-no-first-conversation {
          display: flex;
          justify-content: center;
          font-style: italic;
        }

        #t-title-conversation {
          display: flex;
          flex-direction: row;
          flex-grow: 1;
          justify-content: space-between;
        }
        #t-title-conversation-title {
          display: flex;
          flex-direction: row;
          justify-content: space-between;
          align-items: center;
          span {
            padding-right: 0.5rem;
          }
        }
        #t-title-conversation-actions {
          // دکمه چاپ
          display: flex;
          flex-direction: row;
          justify-content: space-between;
          align-items: center;
        }
        #t-first-conversation {
          direction: ltr;
        }
      }

      .t-card-body-conversation {
        display: flex;
        flex-direction: column;
        align-items: center;
        direction: ltr;
        #t-span-no-other-conversation {
          display: flex;
          justify-content: center;
          font-style: italic;
        }
      }
    }
  }
}
#t-container-customer-organization-info {
  margin: $customerOrganizationInfoMargin;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  font-family: IRANSansX;
  .t-card-customer-info {
    width: 50%;
    margin-right: 1rem;
    .t-card-header-customer-info {
      display: flex;
      flex-direction: row;
      justify-content: space-between;
      align-items: center;
    }
    .t-card-body-customer-info {
      #t-customer-info {
        display: flex;
        flex-direction: column;
        align-items: flex-start;
        font-size: smaller;
        .t-item {
          display: flex;
          flex-direction: row;
          justify-content: space-between;
          padding-bottom: 1rem;
          span {
            padding-right: 1rem;
          }
        }
      }
    }
  }
  .t-card-organization-info {
    width: 50%;
    margin-left: 1rem;
    .t-card-header-organization-info {
      display: flex;
      flex-direction: row;
      justify-content: space-between;
      align-items: center;
    }
    .t-card-body-organization-info {
      #t-organization-info {
        display: flex;
        flex-direction: column;
        align-items: flex-start;
        font-size: smaller;
        .t-item {
          display: flex;
          flex-direction: row;
          justify-content: space-between;
          padding-bottom: 1rem;
          span {
            padding-right: 1rem;
          }
        }
      }
    }
  }
}
</style>
