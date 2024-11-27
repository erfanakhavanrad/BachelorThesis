package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author A.Farahani
 * @date Jan-30, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "TktShowSetting",
        procedureName = "TktShowSetting",
        resultClasses = {TktSetting.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "TktInsSetting",
        procedureName = "TktInsSetting",
        parameters = {
                @StoredProcedureParameter(name = "SystemTitle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LogoLinkReference", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NumberOfRows", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LanguageID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TimeZoneID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MaximumAttachmentVolume", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UsingUsernameInsteadOfEmail", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ChangeUsernameAccess", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UsernameExample", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RegexPattern", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CloseTicketByUsers", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SatisfactionSurvey", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ShowOpenTicketsForStaff", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NotificationViaEmail", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "InsTicketMessageInEmail", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "InsTicketLinkInEmail", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NotificationViaSMS", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "InsTicketLinkInSMS", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NotificationViaTelegram", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "InsTicketMessageInTelegram", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "InsTicketLinkInTelegram", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerMembershipStatus", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SuspendedSystemStatus", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SuspendedSystemMessage", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GeneralCustomersMessage", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GeneralStaffMessage", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ConfidentialAPIConnectionKey", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ValidIPsForAPI", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WebhookAddress", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ConfidentialWebhookConnectionKey", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Logo", type = byte[].class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FavIcon", type = byte[].class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SMTPServerAddress", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SMTPPort", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SMTPUsername", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SMTPPassword", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SendViaSMTP", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SMSPanelUsername", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SMSPanelPassword", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SMSPhoneNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktUpdSetting",
        procedureName = "TktUpdSetting",
        parameters = {
                @StoredProcedureParameter(name = "SettingID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SystemTitle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LogoLinkReference", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NumberOfRows", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LanguageID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TimeZoneID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MaximumAttachmentVolume", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UsingUsernameInsteadOfEmail", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ChangeUsernameAccess", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UsernameExample", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RegexPattern", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CloseTicketByUsers", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SatisfactionSurvey", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ShowOpenTicketsForStaff", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NotificationViaEmail", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "InsTicketMessageInEmail", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "InsTicketLinkInEmail", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NotificationViaSMS", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "InsTicketLinkInSMS", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NotificationViaTelegram", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "InsTicketMessageInTelegram", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "InsTicketLinkInTelegram", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerMembershipStatus", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SuspendedSystemStatus", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SuspendedSystemMessage", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GeneralCustomersMessage", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GeneralStaffMessage", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ConfidentialAPIConnectionKey", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ValidIPsForAPI", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WebhookAddress", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ConfidentialWebhookConnectionKey", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Logo", type = byte[].class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FavIcon", type = byte[].class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SMTPServerAddress", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SMTPPort", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SMTPUsername", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SMTPPassword", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SendViaSMTP", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SMSPanelUsername", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SMSPanelPassword", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SMSPhoneNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktDelSetting",
        procedureName = "TktDelSetting",
        parameters = {
                @StoredProcedureParameter(name = "SettingID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class TktSetting extends TParams implements Serializable {
    @Id
    @Column(name = "SettingID")
    private BigDecimal settingID;

    @Column(name = "SystemTitle")
    private String systemTitle;

    @Column(name = "LogoLinkReference")
    private String logoLinkReference;

    @Column(name = "NumberOfRows")
    private Integer numberOfRows;

    @Column(name = "LanguageID")
    private BigDecimal languageID;

    @Column(name = "LanguageName")
    private String languageName;

    @Column(name = "TimeZoneID")
    private BigDecimal timeZoneID;

    @Column(name = "TimeZoneTitle")
    private String timeZoneTitle;

    @Column(name = "MaximumAttachmentVolume")
    private Integer maximumAttachmentVolume;

    @Column(name = "UsingUsernameInsteadOfEmail")
    private Boolean usingUsernameInsteadOfEmail;

    @Column(name = "ChangeUsernameAccess")
    private Boolean changeUsernameAccess;

    @Column(name = "UsernameExample")
    private String usernameExample;

    @Column(name = "RegexPattern")
    private String regexPattern;

    @Column(name = "CloseTicketByUsers")
    private Boolean closeTicketByUsers;

    @Column(name = "SatisfactionSurvey")
    private Boolean satisfactionSurvey;

    @Column(name = "ShowOpenTicketsForStaff")
    private Boolean showOpenTicketsForStaff;

    @Column(name = "NotificationViaEmail")
    private Boolean notificationViaEmail;

    @Column(name = "InsTicketMessageInEmail")
    private Boolean insTicketMessageInEmail;

    @Column(name = "InsTicketLinkInEmail")
    private Boolean insTicketLinkInEmail;

    @Column(name = "NotificationViaSMS")
    private Boolean notificationViaSMS;

    @Column(name = "InsTicketLinkInSMS")
    private Boolean insTicketLinkInSMS;

    @Column(name = "NotificationViaTelegram")
    private Boolean notificationViaTelegram;

    @Column(name = "InsTicketMessageInTelegram")
    private Boolean insTicketMessageInTelegram;

    @Column(name = "InsTicketLinkInTelegram")
    private Boolean insTicketLinkInTelegram;

    @Column(name = "CustomerMembershipStatus")
    private Boolean customerMembershipStatus;

    @Column(name = "SuspendedSystemStatus")
    private Boolean suspendedSystemStatus;

    @Column(name = "SuspendedSystemMessage")
    private String suspendedSystemMessage;

    @Column(name = "GeneralCustomersMessage")
    private String generalCustomersMessage;

    @Column(name = "GeneralStaffMessage")
    private String generalStaffMessage;

    @Column(name = "ConfidentialAPIConnectionKey")
    private String confidentialAPIConnectionKey;

    @Column(name = "ValidIPsForAPI")
    private String validIPsForAPI;

    @Column(name = "WebhookAddress")
    private String webhookAddress;

    @Column(name = "ConfidentialWebhookConnectionKey")
    private String confidentialWebhookConnectionKey;

    @Column(name = "Logo")
    private byte[] logo;

    @Column(name = "FavIcon")
    private byte[] favIcon;

    @Column(name = "SMTPServerAddress")
    private String sMTPServerAddress;

    @Column(name = "SMTPPort")
    private Integer sMTPPort;

    @Column(name = "SMTPUsername")
    private String sMTPUsername;

    @Column(name = "SMTPPassword")
    private String sMTPPassword;

    @Column(name = "SendViaSMTP")
    private Boolean sendViaSMTP;

    @Column(name = "SMSPanelUsername")
    private String sMSPanelUsername;

    @Column(name = "SMSPanelPassword")
    private String sMSPanelPassword;

    @Column(name = "SMSPhoneNumber")
    private String sMSPhoneNumber;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    public BigDecimal getSettingID() {
        return settingID;
    }

    public void setSettingID(BigDecimal settingID) {
        this.settingID = settingID;
    }

    public String getSystemTitle() {
        return systemTitle;
    }

    public void setSystemTitle(String systemTitle) {
        this.systemTitle = systemTitle;
    }

    public String getLogoLinkReference() {
        return logoLinkReference;
    }

    public void setLogoLinkReference(String logoLinkReference) {
        this.logoLinkReference = logoLinkReference;
    }

    public Integer getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(Integer numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public BigDecimal getLanguageID() {
        return languageID;
    }

    public void setLanguageID(BigDecimal languageID) {
        this.languageID = languageID;
    }

    public BigDecimal getTimeZoneID() {
        return timeZoneID;
    }

    public void setTimeZoneID(BigDecimal timeZoneID) {
        this.timeZoneID = timeZoneID;
    }

    public Integer getMaximumAttachmentVolume() {
        return maximumAttachmentVolume;
    }

    public void setMaximumAttachmentVolume(Integer maximumAttachmentVolume) {
        this.maximumAttachmentVolume = maximumAttachmentVolume;
    }

    public Boolean getUsingUsernameInsteadOfEmail() {
        return usingUsernameInsteadOfEmail;
    }

    public void setUsingUsernameInsteadOfEmail(Boolean usingUsernameInsteadOfEmail) {
        this.usingUsernameInsteadOfEmail = usingUsernameInsteadOfEmail;
    }

    public Boolean getChangeUsernameAccess() {
        return changeUsernameAccess;
    }

    public void setChangeUsernameAccess(Boolean changeUsernameAccess) {
        this.changeUsernameAccess = changeUsernameAccess;
    }

    public String getUsernameExample() {
        return usernameExample;
    }

    public void setUsernameExample(String usernameExample) {
        this.usernameExample = usernameExample;
    }

    public String getRegexPattern() {
        return regexPattern;
    }

    public void setRegexPattern(String regexPattern) {
        this.regexPattern = regexPattern;
    }

    public Boolean getCloseTicketByUsers() {
        return closeTicketByUsers;
    }

    public void setCloseTicketByUsers(Boolean closeTicketByUsers) {
        this.closeTicketByUsers = closeTicketByUsers;
    }

    public Boolean getSatisfactionSurvey() {
        return satisfactionSurvey;
    }

    public void setSatisfactionSurvey(Boolean satisfactionSurvey) {
        this.satisfactionSurvey = satisfactionSurvey;
    }

    public Boolean getShowOpenTicketsForStaff() {
        return showOpenTicketsForStaff;
    }

    public void setShowOpenTicketsForStaff(Boolean showOpenTicketsForStaff) {
        this.showOpenTicketsForStaff = showOpenTicketsForStaff;
    }

    public Boolean getNotificationViaEmail() {
        return notificationViaEmail;
    }

    public void setNotificationViaEmail(Boolean notificationViaEmail) {
        this.notificationViaEmail = notificationViaEmail;
    }

    public Boolean getInsTicketMessageInEmail() {
        return insTicketMessageInEmail;
    }

    public void setInsTicketMessageInEmail(Boolean insTicketMessageInEmail) {
        this.insTicketMessageInEmail = insTicketMessageInEmail;
    }

    public Boolean getInsTicketLinkInEmail() {
        return insTicketLinkInEmail;
    }

    public void setInsTicketLinkInEmail(Boolean insTicketLinkInEmail) {
        this.insTicketLinkInEmail = insTicketLinkInEmail;
    }

    public Boolean getNotificationViaSMS() {
        return notificationViaSMS;
    }

    public void setNotificationViaSMS(Boolean notificationViaSMS) {
        this.notificationViaSMS = notificationViaSMS;
    }

    public Boolean getInsTicketLinkInSMS() {
        return insTicketLinkInSMS;
    }

    public void setInsTicketLinkInSMS(Boolean insTicketLinkInSMS) {
        this.insTicketLinkInSMS = insTicketLinkInSMS;
    }

    public Boolean getNotificationViaTelegram() {
        return notificationViaTelegram;
    }

    public void setNotificationViaTelegram(Boolean notificationViaTelegram) {
        this.notificationViaTelegram = notificationViaTelegram;
    }

    public Boolean getInsTicketMessageInTelegram() {
        return insTicketMessageInTelegram;
    }

    public void setInsTicketMessageInTelegram(Boolean insTicketMessageInTelegram) {
        this.insTicketMessageInTelegram = insTicketMessageInTelegram;
    }

    public Boolean getInsTicketLinkInTelegram() {
        return insTicketLinkInTelegram;
    }

    public void setInsTicketLinkInTelegram(Boolean insTicketLinkInTelegram) {
        this.insTicketLinkInTelegram = insTicketLinkInTelegram;
    }

    public Boolean getCustomerMembershipStatus() {
        return customerMembershipStatus;
    }

    public void setCustomerMembershipStatus(Boolean customerMembershipStatus) {
        this.customerMembershipStatus = customerMembershipStatus;
    }

    public Boolean getSuspendedSystemStatus() {
        return suspendedSystemStatus;
    }

    public void setSuspendedSystemStatus(Boolean suspendedSystemStatus) {
        this.suspendedSystemStatus = suspendedSystemStatus;
    }

    public String getSuspendedSystemMessage() {
        return suspendedSystemMessage;
    }

    public void setSuspendedSystemMessage(String suspendedSystemMessage) {
        this.suspendedSystemMessage = suspendedSystemMessage;
    }

    public String getGeneralCustomersMessage() {
        return generalCustomersMessage;
    }

    public void setGeneralCustomersMessage(String generalCustomersMessage) {
        this.generalCustomersMessage = generalCustomersMessage;
    }

    public String getGeneralStaffMessage() {
        return generalStaffMessage;
    }

    public void setGeneralStaffMessage(String generalStaffMessage) {
        this.generalStaffMessage = generalStaffMessage;
    }

    public String getConfidentialAPIConnectionKey() {
        return confidentialAPIConnectionKey;
    }

    public void setConfidentialAPIConnectionKey(String confidentialAPIConnectionKey) {
        this.confidentialAPIConnectionKey = confidentialAPIConnectionKey;
    }

    public String getValidIPsForAPI() {
        return validIPsForAPI;
    }

    public void setValidIPsForAPI(String validIPsForAPI) {
        this.validIPsForAPI = validIPsForAPI;
    }

    public String getWebhookAddress() {
        return webhookAddress;
    }

    public void setWebhookAddress(String webhookAddress) {
        this.webhookAddress = webhookAddress;
    }

    public String getConfidentialWebhookConnectionKey() {
        return confidentialWebhookConnectionKey;
    }

    public void setConfidentialWebhookConnectionKey(String confidentialWebhookConnectionKey) {
        this.confidentialWebhookConnectionKey = confidentialWebhookConnectionKey;
    }

    public String getsMTPServerAddress() {
        return sMTPServerAddress;
    }

    public void setsMTPServerAddress(String sMTPServerAddress) {
        this.sMTPServerAddress = sMTPServerAddress;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public byte[] getFavIcon() {
        return favIcon;
    }

    public void setFavIcon(byte[] favIcon) {
        this.favIcon = favIcon;
    }

    public Integer getsMTPPort() {
        return sMTPPort;
    }

    public void setsMTPPort(Integer sMTPPort) {
        this.sMTPPort = sMTPPort;
    }

    public String getsMTPUsername() {
        return sMTPUsername;
    }

    public void setsMTPUsername(String emailUsername) {
        this.sMTPUsername = emailUsername;
    }

    public String getsMTPPassword() {
        return sMTPPassword;
    }

    public void setsMTPPassword(String emailPassword) {
        this.sMTPPassword = emailPassword;
    }

    public Boolean getSendViaSMTP() {
        return sendViaSMTP;
    }

    public void setSendViaSMTP(Boolean sendViaSMTP) {
        this.sendViaSMTP = sendViaSMTP;
    }

    public String getsMSPanelUsername() {
        return sMSPanelUsername;
    }

    public void setsMSPanelUsername(String sMSPanelUsername) {
        this.sMSPanelUsername = sMSPanelUsername;
    }

    public String getsMSPanelPassword() {
        return sMSPanelPassword;
    }

    public void setsMSPanelPassword(String sMSPanelPassword) {
        this.sMSPanelPassword = sMSPanelPassword;
    }

    public String getsMSPhoneNumber() {
        return sMSPhoneNumber;
    }

    public void setsMSPhoneNumber(String sMSPhoneNumber) {
        this.sMSPhoneNumber = sMSPhoneNumber;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getTimeZoneTitle() {
        return timeZoneTitle;
    }

    public void setTimeZoneTitle(String timeZoneTitle) {
        this.timeZoneTitle = timeZoneTitle;
    }
}
