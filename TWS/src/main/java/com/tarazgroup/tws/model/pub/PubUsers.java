package com.tarazgroup.tws.model.pub;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author alireza_bayat
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "PubShowUsers",
        procedureName = "PubShowUsers",
        resultClasses = {PubUsers.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsWebUser", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "PubUpdUsers",
        procedureName = "PubUpdUsers",
        parameters = {
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserGroupID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserLoginName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserPassWord", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ResetPassWord", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ActiveYearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsBackUpOperator", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StandByTime", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DeleteLogDays", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsFullSearch", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DefaultServerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ActiveMonthID", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AndroidUser", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AndroidPass", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Grid1Color", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Grid2Color", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GridFont", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ColorType", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsChangeColor", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsDelGridConfig", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsMasterUser", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsRecovery", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MacAddresses", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsPopUp", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CalendarType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WebUserType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotOtherInfoByDefault", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ThemeStyle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AlertPosition", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AlertStyle", type = Integer.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "PubDelUsers",
        procedureName = "PubDelUsers",
        resultClasses = {PubUsers.class},
        parameters = {
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)


@NamedStoredProcedureQuery(
        name = "PubUpdUserActiveYear",
            procedureName = "PubUpdUserActiveYear",
        resultClasses = {PubUsers.class},
        parameters = {
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ActiveYearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN)

        }
)

//@NamedNativeQueries({
//        @NamedNativeQuery(name = "SaleSysSetup", query = "SELECT row_number() OVER (ORDER BY IsByStore) _id,* FROM SaleSysSetup", resultClass = SaleSysSetup.class),
//})
@Entity
public class PubUsers extends TParams implements Serializable {

    @Id
    @Column(name = "UserID")
    @Parameter
    private BigDecimal userID;

    @Column(name = "ServerID")
    @Parameter
    private BigDecimal serverID;

    @Column(name = "UserGroupID")
    @Parameter
    private BigDecimal userGroupID;

    @Column(name = "IsAdmin")
    @Parameter
    private Boolean isAdmin;

    @Column(name = "UserLoginName")
    @Parameter
    private String userLoginName;

    @Column(name = "UserPassWord")
    @Parameter
    private String userPassWord;

    @Column(name = "ResetPassWord")
    @Parameter
    private String resetPassWord;

    @Column(name = "CreateDate")
    @Parameter
    private Date createDate;

    @Column(name = "ModifyDate")
    @Parameter
    private Date modifyDate;

    @Column(name = "CreatorID")
    @Parameter
    private BigDecimal creatorID;

    @Column(name = "ModifierID")
    @Parameter
    private BigDecimal modifierID;

    @Column(name = "ServerIDs")
    @Parameter
    private String serverIDs;

    @Column(name = "PersonCode")
    @Parameter
    private String personCode;

    @Column(name = "FirstName")
    @Parameter
    private String firstName;

    @Column(name = "LastName")
    @Parameter
    private String lastName;

    @Column(name = "UserName")
    @Parameter
    private String userName;

    @Column(name = "IsActive")
    @Parameter
    private Boolean isActive;

    @Column(name = "GroupDesc")
    @Parameter
    private String groupDesc;

    @Column(name = "YearDesc")
    @Parameter
    private String yearDesc;

    @Column(name = "ActiveYearID")
    @Parameter
    private BigDecimal activeYearID;

    @Column(name = "IsBackUpOperator")
    @Parameter
    private Boolean isBackUpOperator;

    @Column(name = "StandByTime")
    @Parameter
    private String standByTime;

    @Column(name = "HotKeyNew")
    @Parameter
    private String hotKeyNew;

    @Column(name = "HotKeyEdit")
    @Parameter
    private String hotKeyEdit;

    @Column(name = "HotKeySave")
    @Parameter
    private String hotKeySave;

    @Column(name = "HotKeyDel")
    @Parameter
    private String hotKeyDel;

    @Column(name = "HotKeyRefresh")
    @Parameter
    private String hotKeyRefresh;

    @Column(name = "HotKeyCrystal")
    @Parameter
    private String hotKeyCrystal;

    @Column(name = "HotKeyFilter")
    @Parameter
    private String hotKeyFilter;

    @Column(name = "DeleteLogDays")
    @Parameter
    private BigDecimal deleteLogDays;

    @Column(name = "IsFullSearch")
    @Parameter
    private Boolean isFullSearch;

    @Column(name = "DefaultServerID")
    @Parameter
    private BigDecimal defaultServerID;

    @Column(name = "ServerDesc")
    @Parameter
    private String serverDesc;

    @Column(name = "ActiveMonthID")
    @Parameter
    private Integer activeMonthID;

    @Column(name = "IsAndroidUser")
    @Parameter
    private Boolean isAndroidUser;

    @Column(name = "IsMasterUser")
    @Parameter
    private Boolean isMasterUser;

    @Column(name = "IsRecovery")
    @Parameter
    private Boolean isRecovery;

    @Column(name = "MacAddresses")
    @Parameter
    private String macAddresses;

    @Column(name = "IsPopUp")
    @Parameter
    private Boolean isPopUp;

    @Column(name = "CalendarType")
    @Parameter
    private BigDecimal calendarType;

    @Column(name = "CalendarTypeDesc")
    @Parameter
    private String calendarTypeDesc;

    @Column(name = "WebUserName")
    @Parameter
    private String webUserName;

    @Column(name = "IsNotOtherInfoByDefault")
    @Parameter
    private Boolean isNotOtherInfoByDefault;

    @Column(name = "ThemeStyle")
    @Parameter
    private String themeStyle;

    @Column(name = "AlertPosition")
    @Parameter
    private Integer alertPosition;

    @Column(name = "AlertStyle")
    @Parameter
    private Integer alertStyle;

    @Column(name = "AlertPositionDesc")
    @Parameter
    private String alertPositionDesc;

    @Column(name = "AlertStyleDesc")
    @Parameter
    private String alertStyleDesc;

    public BigDecimal getUserID() {
        return userID;
    }

    public void setUserID(BigDecimal userID) {
        this.userID = userID;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public BigDecimal getUserGroupID() {
        return userGroupID;
    }

    public void setUserGroupID(BigDecimal userGroupID) {
        this.userGroupID = userGroupID;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public String getResetPassWord() {
        return resetPassWord;
    }

    public void setResetPassWord(String resetPassWord) {
        this.resetPassWord = resetPassWord;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public String getServerIDs() {
        return serverIDs;
    }

    public void setServerIDs(String serverIDs) {
        this.serverIDs = serverIDs;
    }

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public String getYearDesc() {
        return yearDesc;
    }

    public void setYearDesc(String yearDesc) {
        this.yearDesc = yearDesc;
    }

    public BigDecimal getActiveYearID() {
        return activeYearID;
    }

    public void setActiveYearID(BigDecimal activeYearID) {
        this.activeYearID = activeYearID;
    }

    public Boolean getIsBackUpOperator() {
        return isBackUpOperator;
    }

    public void setIsBackUpOperator(Boolean isBackUpOperator) {
        this.isBackUpOperator = isBackUpOperator;
    }

    public String getStandByTime() {
        return standByTime;
    }

    public void setStandByTime(String standByTime) {
        this.standByTime = standByTime;
    }

    public String getHotKeyNew() {
        return hotKeyNew;
    }

    public void setHotKeyNew(String hotKeyNew) {
        this.hotKeyNew = hotKeyNew;
    }

    public String getHotKeyEdit() {
        return hotKeyEdit;
    }

    public void setHotKeyEdit(String hotKeyEdit) {
        this.hotKeyEdit = hotKeyEdit;
    }

    public String getHotKeySave() {
        return hotKeySave;
    }

    public void setHotKeySave(String hotKeySave) {
        this.hotKeySave = hotKeySave;
    }

    public String getHotKeyDel() {
        return hotKeyDel;
    }

    public void setHotKeyDel(String hotKeyDel) {
        this.hotKeyDel = hotKeyDel;
    }

    public String getHotKeyRefresh() {
        return hotKeyRefresh;
    }

    public void setHotKeyRefresh(String hotKeyRefresh) {
        this.hotKeyRefresh = hotKeyRefresh;
    }

    public String getHotKeyCrystal() {
        return hotKeyCrystal;
    }

    public void setHotKeyCrystal(String hotKeyCrystal) {
        this.hotKeyCrystal = hotKeyCrystal;
    }

    public String getHotKeyFilter() {
        return hotKeyFilter;
    }

    public void setHotKeyFilter(String hotKeyFilter) {
        this.hotKeyFilter = hotKeyFilter;
    }

    public BigDecimal getDeleteLogDays() {
        return deleteLogDays;
    }

    public void setDeleteLogDays(BigDecimal deleteLogDays) {
        this.deleteLogDays = deleteLogDays;
    }

    public Boolean getIsFullSearch() {
        return isFullSearch;
    }

    public void setIsFullSearch(Boolean isFullSearch) {
        this.isFullSearch = isFullSearch;
    }

    public BigDecimal getDefaultServerID() {
        return defaultServerID;
    }

    public void setDefaultServerID(BigDecimal defaultServerID) {
        this.defaultServerID = defaultServerID;
    }

    public String getServerDesc() {
        return serverDesc;
    }

    public void setServerDesc(String serverDesc) {
        this.serverDesc = serverDesc;
    }

    public Integer getActiveMonthID() {
        return activeMonthID;
    }

    public void setActiveMonthID(Integer activeMonthID) {
        this.activeMonthID = activeMonthID;
    }

    public Boolean getIsAndroidUser() {
        return isAndroidUser;
    }

    public void setIsAndroidUser(Boolean isAndroidUser) {
        this.isAndroidUser = isAndroidUser;
    }

    public Boolean getIsMasterUser() {
        return isMasterUser;
    }

    public void setIsMasterUser(Boolean isMasterUser) {
        this.isMasterUser = isMasterUser;
    }

    public Boolean getIsRecovery() {
        return isRecovery;
    }

    public void setIsRecovery(Boolean isRecovery) {
        this.isRecovery = isRecovery;
    }

    public String getMacAddresses() {
        return macAddresses;
    }

    public void setMacAddresses(String macAddresses) {
        this.macAddresses = macAddresses;
    }

    public Boolean getIsPopUp() {
        return isPopUp;
    }

    public void setIsPopUp(Boolean isPopUp) {
        this.isPopUp = isPopUp;
    }

    public BigDecimal getCalendarType() {
        return calendarType;
    }

    public void setCalendarType(BigDecimal calendarType) {
        this.calendarType = calendarType;
    }

    public String getCalendarTypeDesc() {
        return calendarTypeDesc;
    }

    public void setCalendarTypeDesc(String calendarTypeDesc) {
        this.calendarTypeDesc = calendarTypeDesc;
    }

    public String getWebUserName() {
        return webUserName;
    }

    public void setWebUserName(String webUserName) {
        this.webUserName = webUserName;
    }

    public Boolean getIsNotOtherInfoByDefault() {
        return isNotOtherInfoByDefault;
    }

    public void setIsNotOtherInfoByDefault(Boolean isNotOtherInfoByDefault) {
        this.isNotOtherInfoByDefault = isNotOtherInfoByDefault;
    }

    public String getThemeStyle() {
        return themeStyle;
    }

    public void setThemeStyle(String themeStyle) {
        this.themeStyle = themeStyle;
    }

    public Integer getAlertPosition() {
        return alertPosition;
    }

    public void setAlertPosition(Integer alertPosition) {
        this.alertPosition = alertPosition;
    }

    public Integer getAlertStyle() {
        return alertStyle;
    }

    public void setAlertStyle(Integer alertStyle) {
        this.alertStyle = alertStyle;
    }

    public String getAlertPositionDesc() {
        return alertPositionDesc;
    }

    public void setAlertPositionDesc(String alertPositionDesc) {
        this.alertPositionDesc = alertPositionDesc;
    }

    public String getAlertStyleDesc() {
        return alertStyleDesc;
    }

    public void setAlertStyleDesc(String alertStyleDesc) {
        this.alertStyleDesc = alertStyleDesc;
    }
}
