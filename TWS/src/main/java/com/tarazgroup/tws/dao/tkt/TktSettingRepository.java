package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktSetting;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Jan-30, 2022
 ***/
public interface TktSettingRepository extends TCrudRepository<TktSetting>, CrudRepository<TktSetting, BigDecimal> {
//    default List<TktSetting> tktShowSetting(TktSetting tktSetting) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("Filter", null));
//        tParameters.add(new TParameter<>("OtherFilter", null));
//        tParameters.add(new TParameter<>("ServerFilter", tktSetting._serverFilter()));
//        tParameters.add(new TParameter<>("YearFilter", tktSetting._yearFilter()));
//        tParameters.add(new TParameter<>("UserAccessFilter", null));
//        tParameters.add(new TParameter<>("PageFilter", tktSetting._pageFilter()));
//        return showSP("TktShowSetting", tParameters, true);
//    }

    default TktSetting tktShowSetting() {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.SettingID = " + 10000001));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowSetting", tParameters, true).get(0);
    }

    default TktSetting tktInsSetting(TktSetting tktSetting) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SystemTitle", tktSetting.getSystemTitle()));
        tParameters.add(new TParameter<>("LogoLinkReference", tktSetting.getLogoLinkReference()));
        tParameters.add(new TParameter<>("NumberOfRows", tktSetting.getNumberOfRows()));
        tParameters.add(new TParameter<>("LanguageID", tktSetting.getLanguageID()));
        tParameters.add(new TParameter<>("TimeZoneID", tktSetting.getTimeZoneID()));
        tParameters.add(new TParameter<>("MaximumAttachmentVolume", tktSetting.getMaximumAttachmentVolume()));
        tParameters.add(new TParameter<>("UsingUsernameInsteadOfEmail", tktSetting.getUsingUsernameInsteadOfEmail()));
        tParameters.add(new TParameter<>("ChangeUsernameAccess", tktSetting.getChangeUsernameAccess()));
        tParameters.add(new TParameter<>("UsernameExample", tktSetting.getUsernameExample()));
        tParameters.add(new TParameter<>("RegexPattern", tktSetting.getRegexPattern()));
        tParameters.add(new TParameter<>("CloseTicketByUsers", tktSetting.getCloseTicketByUsers()));
        tParameters.add(new TParameter<>("SatisfactionSurvey", tktSetting.getSatisfactionSurvey()));
        tParameters.add(new TParameter<>("ShowOpenTicketsForStaff", tktSetting.getShowOpenTicketsForStaff()));
        tParameters.add(new TParameter<>("NotificationViaEmail", tktSetting.getNotificationViaEmail()));
        tParameters.add(new TParameter<>("InsTicketMessageInEmail", tktSetting.getInsTicketMessageInEmail()));
        tParameters.add(new TParameter<>("InsTicketLinkInEmail", tktSetting.getInsTicketLinkInEmail()));
        tParameters.add(new TParameter<>("NotificationViaSMS", tktSetting.getNotificationViaSMS()));
        tParameters.add(new TParameter<>("InsTicketLinkInSMS", tktSetting.getInsTicketLinkInSMS()));
        tParameters.add(new TParameter<>("NotificationViaTelegram", tktSetting.getNotificationViaTelegram()));
        tParameters.add(new TParameter<>("InsTicketMessageInTelegram", tktSetting.getInsTicketMessageInTelegram()));
        tParameters.add(new TParameter<>("InsTicketLinkInTelegram", tktSetting.getInsTicketLinkInTelegram()));
        tParameters.add(new TParameter<>("CustomerMembershipStatus", tktSetting.getInsTicketLinkInTelegram()));
        tParameters.add(new TParameter<>("SuspendedSystemStatus", tktSetting.getSuspendedSystemStatus()));
        tParameters.add(new TParameter<>("SuspendedSystemMessage", tktSetting.getSuspendedSystemMessage()));
        tParameters.add(new TParameter<>("GeneralCustomersMessage", tktSetting.getGeneralCustomersMessage()));
        tParameters.add(new TParameter<>("GeneralStaffMessage", tktSetting.getGeneralStaffMessage()));
        tParameters.add(new TParameter<>("ConfidentialAPIConnectionKey", tktSetting.getConfidentialAPIConnectionKey()));
        tParameters.add(new TParameter<>("ValidIPsForAPI", tktSetting.getValidIPsForAPI()));
        tParameters.add(new TParameter<>("WebhookAddress", tktSetting.getWebhookAddress()));
        tParameters.add(new TParameter<>("ConfidentialWebhookConnectionKey", tktSetting.getConfidentialWebhookConnectionKey()));
        tParameters.add(new TParameter<>("Logo", tktSetting.getLogo()));
        tParameters.add(new TParameter<>("FavIcon", tktSetting.getFavIcon()));
        tParameters.add(new TParameter<>("SMTPServerAddress", tktSetting.getsMTPServerAddress()));
        tParameters.add(new TParameter<>("SMTPPort", tktSetting.getsMTPPort()));
        tParameters.add(new TParameter<>("SMTPUsername", tktSetting.getsMTPUsername()));
        tParameters.add(new TParameter<>("SMTPPassword", tktSetting.getsMTPPassword()));
        tParameters.add(new TParameter<>("SendViaSMTP", tktSetting.getSendViaSMTP()));
        tParameters.add(new TParameter<>("SMSPanelUsername", tktSetting.getsMSPanelUsername()));
        tParameters.add(new TParameter<>("SMSPanelPassword", tktSetting.getsMSPanelPassword()));
        tParameters.add(new TParameter<>("SMSPhoneNumber", tktSetting.getsMSPhoneNumber()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("TktInsSetting", tParameters);
        return tktShowSetting();
    }

    default  TktSetting tktUpdSetting(BigDecimal settingID, TktSetting tktSetting) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SettingID", settingID));
        tParameters.add(new TParameter<>("SystemTitle", tktSetting.getSystemTitle()));
        tParameters.add(new TParameter<>("LogoLinkReference", tktSetting.getLogoLinkReference()));
        tParameters.add(new TParameter<>("NumberOfRows", tktSetting.getNumberOfRows()));
        tParameters.add(new TParameter<>("LanguageID", tktSetting.getLanguageID()));
        tParameters.add(new TParameter<>("TimeZoneID", tktSetting.getTimeZoneID()));
        tParameters.add(new TParameter<>("MaximumAttachmentVolume", tktSetting.getMaximumAttachmentVolume()));
        tParameters.add(new TParameter<>("UsingUsernameInsteadOfEmail", tktSetting.getUsingUsernameInsteadOfEmail()));
        tParameters.add(new TParameter<>("ChangeUsernameAccess", tktSetting.getChangeUsernameAccess()));
        tParameters.add(new TParameter<>("UsernameExample", tktSetting.getUsernameExample()));
        tParameters.add(new TParameter<>("RegexPattern", tktSetting.getRegexPattern()));
        tParameters.add(new TParameter<>("CloseTicketByUsers", tktSetting.getCloseTicketByUsers()));
        tParameters.add(new TParameter<>("SatisfactionSurvey", tktSetting.getSatisfactionSurvey()));
        tParameters.add(new TParameter<>("ShowOpenTicketsForStaff", tktSetting.getShowOpenTicketsForStaff()));
        tParameters.add(new TParameter<>("NotificationViaEmail", tktSetting.getNotificationViaEmail()));
        tParameters.add(new TParameter<>("InsTicketMessageInEmail", tktSetting.getInsTicketMessageInEmail()));
        tParameters.add(new TParameter<>("InsTicketLinkInEmail", tktSetting.getInsTicketLinkInEmail()));
        tParameters.add(new TParameter<>("NotificationViaSMS", tktSetting.getNotificationViaSMS()));
        tParameters.add(new TParameter<>("InsTicketLinkInSMS", tktSetting.getInsTicketLinkInSMS()));
        tParameters.add(new TParameter<>("NotificationViaTelegram", tktSetting.getNotificationViaTelegram()));
        tParameters.add(new TParameter<>("InsTicketMessageInTelegram", tktSetting.getInsTicketMessageInTelegram()));
        tParameters.add(new TParameter<>("InsTicketLinkInTelegram", tktSetting.getInsTicketLinkInTelegram()));
        tParameters.add(new TParameter<>("CustomerMembershipStatus", tktSetting.getInsTicketLinkInTelegram()));
        tParameters.add(new TParameter<>("SuspendedSystemStatus", tktSetting.getSuspendedSystemStatus()));
        tParameters.add(new TParameter<>("SuspendedSystemMessage", tktSetting.getSuspendedSystemMessage()));
        tParameters.add(new TParameter<>("GeneralCustomersMessage", tktSetting.getGeneralCustomersMessage()));
        tParameters.add(new TParameter<>("GeneralStaffMessage", tktSetting.getGeneralStaffMessage()));
        tParameters.add(new TParameter<>("ConfidentialAPIConnectionKey", tktSetting.getConfidentialAPIConnectionKey()));
        tParameters.add(new TParameter<>("ValidIPsForAPI", tktSetting.getValidIPsForAPI()));
        tParameters.add(new TParameter<>("WebhookAddress", tktSetting.getWebhookAddress()));
        tParameters.add(new TParameter<>("ConfidentialWebhookConnectionKey", tktSetting.getConfidentialWebhookConnectionKey()));
        tParameters.add(new TParameter<>("Logo", tktSetting.getLogo()));
        tParameters.add(new TParameter<>("FavIcon", tktSetting.getFavIcon()));
        tParameters.add(new TParameter<>("SMTPServerAddress", tktSetting.getsMTPServerAddress()));
        tParameters.add(new TParameter<>("SMTPPort", tktSetting.getsMTPPort()));
        tParameters.add(new TParameter<>("SMTPUsername", tktSetting.getsMTPUsername()));
        tParameters.add(new TParameter<>("SMTPPassword", tktSetting.getsMTPPassword()));
        tParameters.add(new TParameter<>("SendViaSMTP", tktSetting.getSendViaSMTP()));
        tParameters.add(new TParameter<>("SMSPanelUsername", tktSetting.getsMSPanelUsername()));
        tParameters.add(new TParameter<>("SMSPanelPassword", tktSetting.getsMSPanelPassword()));
        tParameters.add(new TParameter<>("SMSPhoneNumber", tktSetting.getsMSPhoneNumber()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktUpdSetting", tParameters);
        return tktShowSetting();
    }

    default void tktDelSetting(BigDecimal settingID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SettingID", settingID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TktDelSetting", tParameters);
    }

    default Meta meta(){
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "settingID",                        "settingID",                               Type.DECIMAL, 0,   false, false, true ));
        cols.add(new Col(null, "systemTitle",                      "عنوان سیستم",                             Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "logoLinkReference",                "لینک ارجاع از لوگو",                      Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "numberOfRows",                     "تعداد سطر گزارش ها در هر صفحه",           Type.INTEGER, 100, true,  true,  false));
        cols.add(new Col(null, "languageID",                       "languageID",                                    Type.DECIMAL,  100, false,  false,  false));
        cols.add(new Col(null, "languageName",                    "زبان",                                    Type.STRING,  100, true,  true,  false));

        cols.add(new Col(null, "timeZoneID",                       "timeZoneID",                              Type.DECIMAL,  100, false,  false,  false));
        cols.add(new Col(null, "timeZoneTitle",                     "منطقه زمانی",                             Type.STRING,  100, true,  true,  false));

        cols.add(new Col(null, "maximumAttachmentVolume",          "حداکثر حجم مجاز فایل الحاقی",             Type.INTEGER, 100, true,  true,  false));
        cols.add(new Col(null, "usingUsernameInsteadOfEmail",      "استفاده از نام کاربری به جای ایمیل",      Type.BOOLEAN, 100, true,  true,  false));
        cols.add(new Col(null, "changeUsernameAccess",             "امکان تغییر نام کاربری",                  Type.BOOLEAN, 100, true,  true,  false));
        cols.add(new Col(null, "usernameExample",                  "مثال نام کاربری",                         Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "regexPattern",                     "الگوی Regex نام کاربری",                  Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "closeTicketByUsers",               "مجوز بستن تیکت توسط کلیه کاربران",        Type.BOOLEAN, 100, true,  true,  false));
        cols.add(new Col(null, "satisfactionSurvey",               "نظرسنجی رضایتمندی از مشتریان و پرسنل",    Type.BOOLEAN, 100, true,  true,  false));
        cols.add(new Col(null, "showOpenTicketsForStaff",          "نمایش تیکت های باز برای پرسنل عادی",      Type.BOOLEAN, 100, true,  true,  false));
        cols.add(new Col(null, "notificationViaEmail",             "اطلاع رسانی از طریق ایمیل",                Type.BOOLEAN, 100, true,  true,  false));
        cols.add(new Col(null, "insTicketMessageInEmail",          "درج متن تیکت در ایمیل اطلاع رسانی",        Type.BOOLEAN, 100, true,  true,  false));
        cols.add(new Col(null, "insTicketLinkInEmail",             "درج لینک تیکت در متن ایمیل اطلاع رسانی",   Type.BOOLEAN, 100, true,  true,  false));
        cols.add(new Col(null, "notificationViaSMS",               "اطلاع رسانی از طریق پیامک",                Type.BOOLEAN, 100, true,  true,  false));
        cols.add(new Col(null, "insTicketLinkInSMS",               "درج لینک تیکت در متن پیامک",              Type.BOOLEAN, 100, true,  true,  false));
        cols.add(new Col(null, "notificationViaTelegram",          "اطلاع رسانی از طریق تلگرام",               Type.BOOLEAN, 100, true,  true,  false));
        cols.add(new Col(null, "insTicketMessageInTelegram",       "درج متن تیکت در پیام اطلاع رسانی تلگرام",  Type.BOOLEAN, 100, true,  true,  false));
        cols.add(new Col(null, "insTicketLinkInTelegram",          "درج لینک تیکت در پیام اطلاع رسانی تلگرام", Type.BOOLEAN, 100, true,  true,  false));
        cols.add(new Col(null, "customerMembershipStatus",         "وضعیت عضویت مشتریان",                     Type.BOOLEAN, 100, true,  true,  false));
        cols.add(new Col(null, "suspendedSystemStatus",            "وضعیت معلق بودن سیستم",                   Type.BOOLEAN, 100, true,  true,  false));
        cols.add(new Col(null, "suspendedSystemMessage",           "پیغام حالت تعلیق سیستم",                  Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "generalCustomersMessage",          "پیغام عمومی مشتریان",                     Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "generalStaffMessage",              "پیغام عمومی کارمندان",                    Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "confidentialAPIConnectionKey",     "کلید محرمانه ارتباط با API",              Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "validIPsForAPI",                   "IP های معتبر برای API",                   Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "webhookAddress",                   "آدرس Webhook",                            Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "confidentialWebhookConnectionKey", "کلید محرمانه ارتباط با Webhook",          Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "sMTPServerAddress",                "آدرس سرور SMTP",                          Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "sMTPPort",                         "پورت SMTP",                               Type.TINYINTEGER,  100, true,  true,  false));
        cols.add(new Col(null, "sMTPUsername",                    "نام کاربری",                              Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "sMTPPassword",                    "کلمه عبور",                               Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "sendViaSMTP",                      "ارسال از طریق SMTP",                      Type.BOOLEAN, 100, true,  true,  false));
        cols.add(new Col(null, "sMSPanelUsername",                 "نام کاربری پنل پیامک",                    Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "sMSPanelPassword",                 "رمز عبور پنل پیامک",                      Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "sMSPhoneNumber",                   "شماره ارسال پیامک",                       Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "creatorID",                        "creatorID",                               Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "createDate",                       "createDate",                              Type.DATE,    0,   false, false, false));
        cols.add(new Col(null, "modifierID",                       "modifierID",                              Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "modifyDate",                       "modifyDate",                              Type.DATE,    0,   false, false, false));
        cols.add(new Col(null, "serverID",                         "serverID",                                Type.DECIMAL, 0,   false, false, false));
        return new Meta(cols);
    }
}
