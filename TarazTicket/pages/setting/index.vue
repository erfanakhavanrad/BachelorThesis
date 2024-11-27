<template>
  <b-overlay :show="isLoading">
    <b-card
      ref="card"
      header-tag="header"
      footer-tag="footer"
      header-class="t-card-header"
      body-class="t-card-body"
      footer-class="t-card-footer"
      class="t-card"
    >
      <template #header>
        <div id="t-title">
          {{ title }}
        </div>
      </template>
      <b-card no-body>
        <b-tabs card nav-class="t-tabs">
          <b-tab active>
            <template #title>
              <font-awesome-icon icon="cogs" />
              <span>تنظیمات عمومی</span>
            </template>

            <t-text-box-string
              id="systemTitle"
              v-model="dataEntryModel.systemTitle"
              :rules="{ required: true, min: 5 }"
              label="عنوان سیستم"
            />
            <t-text-box-url
              id="logoLinkReference"
              v-model="dataEntryModel.logoLinkReference"
              :rules="{ required: false, min: 5 }"
              label="لینک ارجاع از لوگو"
            />
            <t-text-box-range
              id="numberOfRows"
              v-model="dataEntryModel.numberOfRows"
              :min="25"
              :max="100"
              :step="25"
              label="تعداد سطر گزارش ها در هر صفحه"
            />

            <t-combo-box
              id="languageID"
              v-model="dataEntryModel.languageID"
              :rules="{ required: true }"
              label="زبان"
              resource-data="tkt/languages"
              resource-meta="tkt/languages/meta"
              main-field-name="languageName"
            />

            <t-combo-box
              id="timeZoneID"
              v-model="dataEntryModel.timeZoneID"
              :rules="{ required: true }"
              label="منطقه زمانی"
              resource-data="tkt/timezones"
              resource-meta="tkt/timezones/meta"
              main-field-name="timeZoneTitle"
            />

            <t-combo-box
              id="maximumAttachmentVolume"
              v-model="dataEntryModel.maximumAttachmentVolume"
              :options="maximumAttachmentVolumeOptions"
              label="حداکثر حجم مجاز فایل الحاقی"
            />

            <t-check-box
              id="usingUsernameInsteadOfEmail"
              v-model="dataEntryModel.usingUsernameInsteadOfEmail"
              label="استفاده از نام کاربری به جای ایمیل"
            />

            <t-check-box
              id="changeUsernameAccess"
              v-model="dataEntryModel.changeUsernameAccess"
              label="امکان تغییر نام کاربری"
            />

            <t-text-box-string
              id="usernameExample"
              v-model="dataEntryModel.usernameExample"
              :rules="{ required: false }"
              label="مثال نام کاربری"
            />

            <t-text-box-string
              id="regexPattern"
              v-model="dataEntryModel.regexPattern"
              :rules="{ required: false }"
              label="الگوی Regex نام کاربری"
            />
            <t-check-box
              id="closeTicketByUsers"
              v-model="dataEntryModel.closeTicketByUsers"
              label="مجوز بستن تیکت توسط کلیه کاربران"
            />

            <t-check-box
              id="satisfactionSurvey"
              v-model="dataEntryModel.satisfactionSurvey"
              label="نظرسنجی رضایتمندی از مشتریان و پرسنل"
            />
            <t-check-box
              id="showOpenTicketsForStaff"
              v-model="dataEntryModel.showOpenTicketsForStaff"
              label="نمایش تیکت های باز برای پرسنل عادی"
            />
            <t-check-box
              id="notificationViaEmail"
              v-model="dataEntryModel.notificationViaEmail"
              label="اطلاع رسانی از طریق ایمیل"
            />
            <t-check-box
              id="insTicketMessageInEmail"
              v-model="dataEntryModel.insTicketMessageInEmail"
              label="درج متن تیکت در ایمیل اطلاع رسانی"
            />
            <t-check-box
              id="insTicketLinkInEmail"
              v-model="dataEntryModel.insTicketLinkInEmail"
              label="درج لینک تیکت در متن ایمیل اطلاع رسانی"
            />
            <t-check-box
              id="notificationViaSMS"
              v-model="dataEntryModel.notificationViaSMS"
              label="اطلاع رسانی از طریق پیامک"
            />
            <t-check-box
              id="insTicketLinkInSMS"
              v-model="dataEntryModel.insTicketLinkInSMS"
              label="درج لینک تیکت در متن پیامک"
            />
            <t-check-box
              id="notificationViaTelegram"
              v-model="dataEntryModel.notificationViaTelegram"
              label="اطلاع رسانی از طریق تلگرام"
            />
            <t-check-box
              id="insTicketMessageInTelegram"
              v-model="dataEntryModel.insTicketMessageInTelegram"
              label="درج متن تیکت در پیام اطلاع رسانی تلگرام"
            />
            <t-check-box
              id="insTicketLinkInTelegram"
              v-model="dataEntryModel.insTicketLinkInTelegram"
              label="درج لینک تیکت در پیام اطلاع رسانی تلگرام"
            />
            <t-check-box
              id="customerMembershipStatus"
              v-model="dataEntryModel.customerMembershipStatus"
              label="وضعیت عضویت مشتریان"
            />
            <t-check-box
              id="suspendedSystemStatus"
              v-model="dataEntryModel.suspendedSystemStatus"
              label="وضعیت معلق بودن سیستم"
            />
            <t-text-area
              id="suspendedSystemMessage"
              v-model="dataEntryModel.suspendedSystemMessage"
              :rules="{ required: false }"
              label="پیغام حالت تعلیق سیستم"
            />
            <t-text-area
              id="generalCustomersMessage"
              v-model="dataEntryModel.generalCustomersMessage"
              :rules="{ required: false }"
              label="پیغام عمومی مشتریان"
            />
            <t-text-area
              id="generalStaffMessage"
              v-model="dataEntryModel.generalStaffMessage"
              :rules="{ required: false }"
              label="پیغام عمومی کارمندان"
            />
            <t-text-box-string
              id="confidentialAPIConnectionKey"
              v-model="dataEntryModel.confidentialAPIConnectionKey"
              :rules="{ required: false }"
              label="کلید محرمانه ارتباط با API"
            />

            <t-text-area
              id="validIPsForAPI"
              v-model="dataEntryModel.validIPsForAPI"
              :rules="{ required: false }"
              label="IP های معتبر برای API"
            />
            <t-text-box-url
              id="webhookAddress"
              v-model="dataEntryModel.webhookAddress"
              :rules="{ required: false, min: 5 }"
              label="آدرس Webhook"
            />
            <t-text-box-string
              id="confidentialWebhookConnectionKey"
              v-model="dataEntryModel.confidentialWebhookConnectionKey"
              :rules="{ required: false }"
              label="کلید محرمانه ارتباط با Webhook"
            />

            <t-file id="logo" v-model="dataEntryModel.logo" label="فایل" />

            <t-file
              id="favicon"
              v-model="dataEntryModel.favIcon"
              label="favicon"
            />
          </b-tab>
          <b-tab>
            <template #title>
              <font-awesome-icon icon="envelope" />
              <span>تنظیمات ایمیل</span>
            </template>
            <t-text-box-string
              id="sMTPServerAddress"
              v-model="dataEntryModel.sMTPServerAddress"
              :rules="{ required: false }"
              label="آدرس سرور SMTP"
            />

            <t-text-box-integer
              id="sMTPPort"
              v-model="dataEntryModel.sMTPPort"
              :rules="{ required: false, min: 2, max: 5 }"
              label="پورت SMTP"
            />

            <t-text-box-string
              id="sMTPUsername"
              v-model="dataEntryModel.sMTPUsername"
              :rules="{ required: false }"
              label="نام کاربری"
            />

            <t-text-box-password
              id="sMTPPassword"
              v-model="dataEntryModel.sMTPPassword"
              :rules="{ required: false }"
              label="کلمه عبور"
            />

            <t-check-box
              id="sendViaSMTP"
              v-model="dataEntryModel.sendViaSMTP"
              label="ارسال از طریق SMTP"
            />
          </b-tab>
          <b-tab>
            <template #title>
              <font-awesome-icon icon="sms" />
              <span>تنظیمات پیامک</span>
            </template>
            <t-text-box-string
              id="sMSPanelUsername"
              v-model="dataEntryModel.sMSPanelUsername"
              :rules="{ required: false }"
              label="نام کاربری پنل پیامک"
            />

            <t-text-box-password
              id="sMSPanelPassword"
              v-model="dataEntryModel.sMSPanelPassword"
              :rules="{ required: false }"
              label="رمز عبور پنل پیامک"
            />

            <t-text-box-string
              id="sMSPhoneNumber"
              v-model="dataEntryModel.sMSPhoneNumber"
              :rules="{ required: false }"
              label="شماره ارسال پیامک"
            />
          </b-tab>
        </b-tabs>
      </b-card>
      <template #footer>
        <b-button-group size="sm">
          <b-button variant="info" title="اعمال تغییرات" @click="onSave">
            <span>اعمال تغییرات</span>
            <font-awesome-icon icon="check" size="lg" />
          </b-button>
        </b-button-group>
      </template>
    </b-card>
  </b-overlay>
</template>

<script>
import { mapGetters } from 'vuex'
import TFile from '~/components/dataentry/TFile.vue'
import TCheckBox from '~/components/dataentry/TCheckBox.vue'
import TComboBox from '~/components/dataentry/TComboBox.vue'
import TTextArea from '~/components/dataentry/TTextArea.vue'
import TTextBoxRange from '~/components/dataentry/TTextBoxRange.vue'
import TTextBoxString from '~/components/dataentry/TTextBoxString.vue'
import TTextBoxInteger from '~/components/dataentry/TTextBoxInteger.vue'
import TTextBoxUrl from '~/components/dataentry/TTextBoxUrl.vue'
import TTextBoxPassword from '~/components/dataentry/TTextBoxPassword.vue'
export default {
  name: 'Generalsetting',
  components: {
    TTextBoxString,
    TTextBoxInteger,
    TTextBoxUrl,
    TTextBoxRange,
    TComboBox,
    TCheckBox,
    TTextArea,
    TFile,
    TTextBoxPassword
  },
  data () {
    return {
      resourceData: 'tkt/settings',
      title: 'تنظیمات عمومی',
      isLoading: false,
      dataEntryModel: {},
      maximumAttachmentVolumeOptions: [
        { value: 100, text: '100KB' },
        { value: 300, text: '300KB' },
        { value: 500, text: '500KB' },
        { value: 1000, text: '1MB' },
        { value: 2000, text: '2MB' },
        { value: 3000, text: '3MB' },
        { value: 4000, text: '4MB' },
        { value: 5000, text: '5MB' },
        { value: 6000, text: '6MB' },
        { value: 7000, text: '7MB' },
        { value: 8000, text: '8MB' },
        { value: 9000, text: '9MB' },
        { value: 10000, text: '10MB' },
        { value: 20000, text: '20MB' },
        { value: 30000, text: '30MB' },
        { value: 40000, text: '40MB' },
        { value: 50000, text: '50MB' },
        { value: 60000, text: '60MB' },
        { value: 70000, text: '70MB' },
        { value: 80000, text: '80MB' },
        { value: 90000, text: '90MB' },
        { value: 100000, text: '100MB' }
      ]
    }
  },
  head () {
    return {
      title: this.title,
      isLoading: false
    }
  },
  computed: {
    ...mapGetters({
      serverID: '_user/GET_DEFAULT_SERVERID'
    }),
    recordID () {
      return this.dataEntryModel.settingID
    },
    mode () {
      if (JSON.stringify(this.dataEntryModel) === '{}') {
        return 'INSERT'
      }
      return 'UPDATE'
    }
  },
  async created () {
    this.isLoading = true
    await this.retrieveRecord()
    this.isLoading = false
  },
  methods: {
    async retrieveRecord () {
      // بسته به این که سرور آی دی یوزر لاگین شده چیست تنها ستینگ مربوط به این
      // سرور آی دی از سرور گرفته میشود
      const filterParams = {}
      filterParams.srIDs = this.serverID
      const response = await this.$taxios.get('tkt/settings', filterParams)
      if (response.data !== '') {
        // 200
        this.dataEntryModel = response.data
      }
    },
    onSave () {
      if (this.mode === 'INSERT') {
        this.onInsert()
      } else {
        // UPDATE
        this.onUpdate()
      }
    },
    onInsert () {
      this.isLoading = true
      const dataEntryModel = JSON.parse(JSON.stringify(this.dataEntryModel))
      this.$taxios
        .post(this.resourceData, dataEntryModel)
        .then((response) => {
          this.isLoading = false
          if (response.status === 200) {
            this.$ttoast.createToast(
              'success',
              200,
              'OK',
              'Record inserted successfully',
              'رکورد با موفقیت اضافه شد',
              3000
            )
          }
        })
        .catch(() => {
          this.isLoading = false
        })
    },
    onUpdate () {
      this.isLoading = true
      const dataEntryModel = JSON.parse(JSON.stringify(this.dataEntryModel))
      this.$taxios
        .put(this.resourceData, this.recordID, dataEntryModel)
        .then((response) => {
          this.isLoading = false
          if (response.status === 200) {
            this.$ttoast.createToast(
              'info',
              200,
              'OK',
              'Record updated successfully',
              'رکورد با موفقیت آپدیت شد',
              3000
            )
          }
        })
        .catch(() => {
          this.isLoading = false
        })
    }
  }
}
</script>
<style lang="scss" scoped>
$menuHeight: 80px; // ارتفاع منوی بالای صفحه
// #region card
$cardMargin: 1rem; // مارجین کارد
$cardHeaderHeight: 4rem; // ارتفاع هدر کارد
$cardBodyMargin: 1rem; // مارجین بادی کارد
// #endregion

// #region footer
$actionButtonWidth: 9rem; // عرض دکمه های فوتر
// #endregion

.t-card {
  margin: $cardMargin;
  .t-card-header {
    z-index: 2;
    height: $cardHeaderHeight;
    position: sticky;
    top: $menuHeight;
    background-color: var(--t-color-0-96);
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    // border: 1px solid var(--t-color-0-80);

    #t-title {
      align-self: center;
      font-weight: bold;
    }
  }
  .t-card-body {
    padding: $cardBodyMargin;
    :deep(.t-tabs) {
      font-size: 0.8rem;
    }
  }
  .t-card-footer {
    display: flex;
    flex-direction: row;
    direction: ltr;
    justify-content: right;
    button {
      width: $actionButtonWidth;
    }
  }
}
</style>
