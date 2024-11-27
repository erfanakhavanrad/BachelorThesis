//package com.tarazgroup.tws.model.pub;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.tarazgroup.tws.util.global.TParams;
//import io.swagger.v3.oas.annotations.Parameter;
//import io.swagger.v3.oas.annotations.media.Schema;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.math.BigDecimal;
//import java.util.Date;
//
//import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;
//
///**
// * @author alireza_bayat
// * @since 2.0.0
// */
//
//@NamedStoredProcedureQuery(
//        name = "PubShowUsers",
//        procedureName = "PubShowUsers",
//        resultClasses = {PubUsers1.class},
//        parameters = {
//                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsWebUser", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
//        }
//)
//
//@NamedStoredProcedureQuery(
//        name = "PubUpdUsers",
//        procedureName = "PubUpdUsers",
//        parameters = {
//                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "UserGroupID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "UserLoginName", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "UserPassWord", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ResetPassWord", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "IsActive", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ActiveYearID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsBackUpOperator", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "StandByTime", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "DeleteLogDays", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsFullSearch", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "DefaultServerID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ActiveMonthID", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "AndroidUser", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "AndroidPass", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Grid1Color", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Grid2Color", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "GridFont", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ColorType", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsChangeColor", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsDelGridConfig", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsMasterUser", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsRecovery", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "MacAddresses", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsPopUp", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "CalendarType", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "WebUserType", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsNotOtherInfoByDefault", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ThemeStyle", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "AlertPosition", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "AlertStyle", type = Integer.class, mode = ParameterMode.IN)
//        }
//)
//
//@NamedStoredProcedureQuery(
//        name = "PubDelUsers",
//        procedureName = "PubDelUsers",
//        resultClasses = {PubUsers1.class},
//        parameters = {
//                @StoredProcedureParameter(name = "UserID",type = BigDecimal.class,mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result",type = BigDecimal.class,mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "LoginID",type = BigDecimal.class,mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ErrMsg",type = String.class,mode = ParameterMode.OUT)
//        }
//)
////@NamedNativeQueries({
////        @NamedNativeQuery(name = "SaleSysSetup", query = "SELECT row_number() OVER (ORDER BY IsByStore) _id,* FROM SaleSysSetup", resultClass = SaleSysSetup.class),
////})
//@Entity
//public class PubUsers1 extends TParams implements Serializable {
//
//    @Id
//    @Column(name = "UserID")
//    @Parameter
//    private BigDecimal userID;
//
//    @Column(name = "ServerID")
//    @Parameter(hidden = true)
//    private BigDecimal serverID;
//
//    @Column(name = "UserGroupID")
//    @Parameter
//    private BigDecimal userGroupID;
//
//    @Column(name = "UserLoginName")
//    @Parameter
//    @Transient
//    private String userLoginName;
//
//    @Column(name = "UserPassWord")
//    @Parameter
//    private String userPassWord;
//
//    @Column(name = "ResetPassWord")
//    @Parameter
//    private Boolean resetPassWord;
//
//    @Column(name = "CreateDate")
//    @Parameter(hidden = true)
//    private Date createDate;
//
//    @Column(name = "ModifyDate")
//    @Parameter(hidden = true)
//    private Date modifyDate;
//
//    @Column(name = "CreatorID")
//    @Parameter(hidden = true)
//    private BigDecimal creatorID;
//
//    @Column(name = "ModifierID")
//    @Parameter(hidden = true)
//    private BigDecimal modifierID;
//
//    @Column(name = "IsActive")
//    @Parameter
//    private Boolean isActive;
//
//    @Column(name = "IsAdmin")
//    @Parameter
//    private Boolean isAdmin;
//
//    @Column(name = "ActiveYearID")
//    @Parameter
//    private BigDecimal activeYearID;
//
//    @Column(name = "IsBackUpOperator")
//    @Parameter
//    private Boolean isBackUpOperator;
//
//    @Transient
//    @Column(name = "IsDefaultHomePage")
//    @Parameter
//    private String isDefaultHomePage;
//
//    @Column(name = "StandByTime")
//    @Parameter
//    private BigDecimal standByTime;
//
//    @Column(name = "HotKeyNew")
//    @Parameter
//    private String hotKeyNew;
//
//    @Column(name = "HotKeyEdit")
//    @Parameter
//    private String hotKeyEdit;
//
//    @Column(name = "HotKeySave")
//    @Parameter
//    private String hotKeySave;
//
//    @Column(name = "HotKeyDel")
//    @Parameter
//    private String hotKeyDel;
//
//    @Column(name = "HotKeyRefresh")
//    @Parameter
//    private String hotKeyRefresh;
//
//    @Column(name = "HotKeyCrystal")
//    @Parameter
//    private String hotKeyCrystal;
//
//    @Column(name = "HotKeyFilter")
//    @Parameter
//    private String hotKeyFilter;
//
//    @Column(name = "DeleteLogDays")
//    @Parameter
//    private BigDecimal deleteLogDays;
//
//    @Column(name = "IsFullSearch")
//    @Parameter
//    private String isFullSearch;
//
//    @Column(name = "ServerIDs")
//    @Parameter(hidden = true)
//    private String serverIDs;
//
//    @Column(name = "DefaultServerID")
//    @Parameter
//    private BigDecimal defaultServerID;
//
//    @Transient
//    @Column(name = "IsEditorUser")
//    @Parameter
//    private String isEditorUser;
//
//    @Column(name = "AndroidUserPass")
//    @Parameter(hidden = true)
//    @Transient
//    private String androidUserPass;
//
//    @Column(name = "IsAndroidUser")
//    @Parameter(hidden = true)
//    private Boolean isAndroidUser;
//
//    @Column(name = "YearDesc")
//    @Parameter(hidden = true)
//    private String yearDesc;
//
//    @Column(name = "ServerDesc")
//    @Parameter(hidden = true)
//    private String serverDesc;
//
//    @Column(name = "ActiveMonthID")
//    @Parameter
//    private BigDecimal activeMonthID;
//
//    @Transient
//    @Column(name = "Grid1Color")
//    @Parameter(hidden = true)
//    private BigDecimal grid1Color;
//
//    @Transient
//    @Column(name = "Grid2Color")
//    @Parameter(hidden = true)
//    private BigDecimal grid2Color;
//
//    @Transient
//    @Column(name = "ColorType")
//    @Parameter(hidden = true)
//    private String colorType;
//
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    @Transient
//    @Column(name = "GridFont")
//    @Parameter(hidden = true)
//    private String gridFont;
//
//    @Column(name = "IsMasterUser")
//    @Parameter
//    private String isMasterUser;
//
//    @Column(name = "IsRecovery")
//    @Parameter
//    private String isRecovery;
//
//    @Column(name = "MacAddresses")
//    @Parameter(hidden = true)
//    private String macAddresses;
//
//    @Column(name = "IsPopUp")
//    @Parameter
//    private String isPopUp;
//
//    @Column(name = "CalendarType")
//    @Parameter
//    private BigDecimal calendarType;
//
//    @Column(name = "WebUserName")
//    @Parameter
//    private String webUserName;
//
//    @Column(name = "IsNotOtherInfoByDefault")
//    @Parameter
//    private String isNotOtherInfoByDefault;
//
//    @Column(name = "ThemeStyle")
//    @Parameter
//    private String themeStyle;
//
//    @Column(name = "PersonCode")
//    @Parameter
//    private String personCode;
//
//    @Column(name = "FirstName")
//    @Parameter
//    private String firstName;
//
//    @Column(name = "LastName")
//    @Parameter
//    private String lastName;
//
//    @Column(name = "UserName")
//    @Parameter
//    private String userName;
//
//    public String getPersonCode() {
//        return personCode;
//    }
//
//    public void setPersonCode(String personCode) {
//        this.personCode = personCode;
//    }
//
//    @Schema(hidden = true)
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    @Schema(hidden = true)
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    @Schema(hidden = true)
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    @Schema(accessMode = READ_ONLY)
//    public BigDecimal getUserID() {
//        return userID;
//    }
//
//    public void setUserID(BigDecimal userID) {
//        this.userID = userID;
//    }
//
//    @Schema(hidden = true)
//    public BigDecimal getServerID() {
//        return serverID;
//    }
//
//    public void setServerID(BigDecimal serverID) {
//        this.serverID = serverID;
//    }
//
//    @Schema(
//            required = false
//    )
//    public BigDecimal getUserGroupID() {
//        return userGroupID;
//    }
//
//    public void setUserGroupID(BigDecimal userGroupID) {
//        this.userGroupID = userGroupID;
//    }
//
//    @Schema(hidden = true)
//    public String getUserLoginName() {
//        return userLoginName;
//    }
//
//    public void setUserLoginName(String userLoginName) {
//        this.userLoginName = userLoginName;
//    }
//
//    @Schema(
//            required = false
//    )
//    public String getUserPassWord() {
//        return userPassWord;
//    }
//
//    public void setUserPassWord(String userPassWord) {
//        this.userPassWord = userPassWord;
//    }
//
//    @Schema(
//            required = true,
//            example = "true"
//    )
//    public Boolean getResetPassWord() {
//        return resetPassWord;
//    }
//
//    public void setResetPassWord(Boolean resetPassWord) {
//        this.resetPassWord = resetPassWord;
//    }
//
//    @Schema(hidden = true)
//    public Date getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(Date createDate) {
//        this.createDate = createDate;
//    }
//
//    @Schema(hidden = true)
//    public Date getModifyDate() {
//        return modifyDate;
//    }
//
//    public void setModifyDate(Date modifyDate) {
//        this.modifyDate = modifyDate;
//    }
//
//    @Schema(hidden = true)
//    public BigDecimal getCreatorID() {
//        return creatorID;
//    }
//
//    public void setCreatorID(BigDecimal creatorID) {
//        this.creatorID = creatorID;
//    }
//
//    @Schema(hidden = true)
//    public BigDecimal getModifierID() {
//        return modifierID;
//    }
//
//    public void setModifierID(BigDecimal modifierID) {
//        this.modifierID = modifierID;
//    }
//
//    @Schema(
//            required = true,
//            example = "false"
//    )
//    public Boolean getIsActive() {
//        return isActive;
//    }
//
//    public void setIsActive(Boolean isActive) {
//        this.isActive = isActive;
//    }
//
//    @Schema(
//            required = true,
//            example = "false"
//    )
//    public Boolean getIsAdmin() {
//        return isAdmin;
//    }
//
//    public void setIsAdmin(Boolean isAdmin) {
//        this.isAdmin = isAdmin;
//    }
//
//    @Schema(
//            required = false,
//            example = "10000018"
//    )
//    public BigDecimal getActiveYearID() {
//        return activeYearID;
//    }
//
//    public void setActiveYearID(BigDecimal activeYearID) {
//        this.activeYearID = activeYearID;
//    }
//
//    @Schema(
//            required = true,
//            example = "false"
//    )
//    public Boolean getIsBackUpOperator() {
//        return isBackUpOperator;
//    }
//
//    public void setIsBackUpOperator(Boolean isBackUpOperator) {
//        this.isBackUpOperator = isBackUpOperator;
//    }
//
//    @Schema(
//            required = true,
//            example = "false"
//    )
//    public String getIsDefaultHomePage() {
//        return isDefaultHomePage;
//    }
//
//    public void setIsDefaultHomePage(String isDefaultHomePage) {
//        this.isDefaultHomePage = isDefaultHomePage;
//    }
//
//    @Schema(
//            required = true,
//            example = "60"
//    )
//    public BigDecimal getStandByTime() {
//        return standByTime;
//    }
//
//    public void setStandByTime(BigDecimal standByTime) {
//        this.standByTime = standByTime;
//    }
//
//    @Schema(
//            required = false
//    )
//    public String getHotKeyNew() {
//        return hotKeyNew;
//    }
//
//    public void setHotKeyNew(String hotKeyNew) {
//        this.hotKeyNew = hotKeyNew;
//    }
//
//    @Schema(
//            required = false
//    )
//    public String getHotKeyEdit() {
//        return hotKeyEdit;
//    }
//
//    public void setHotKeyEdit(String hotKeyEdit) {
//        this.hotKeyEdit = hotKeyEdit;
//    }
//
//    @Schema(
//            required = false
//    )
//    public String getHotKeySave() {
//        return hotKeySave;
//    }
//
//    public void setHotKeySave(String hotKeySave) {
//        this.hotKeySave = hotKeySave;
//    }
//
//    @Schema(
//            required = false
//    )
//    public String getHotKeyDel() {
//        return hotKeyDel;
//    }
//
//    public void setHotKeyDel(String hotKeyDel) {
//        this.hotKeyDel = hotKeyDel;
//    }
//
//    @Schema(
//            required = false
//    )
//    public String getHotKeyRefresh() {
//        return hotKeyRefresh;
//    }
//
//    public void setHotKeyRefresh(String hotKeyRefresh) {
//        this.hotKeyRefresh = hotKeyRefresh;
//    }
//
//    @Schema(
//            required = false
//    )
//    public String getHotKeyCrystal() {
//        return hotKeyCrystal;
//    }
//
//    public void setHotKeyCrystal(String hotKeyCrystal) {
//        this.hotKeyCrystal = hotKeyCrystal;
//    }
//
//    @Schema(
//            required = false
//    )
//    public String getHotKeyFilter() {
//        return hotKeyFilter;
//    }
//
//    public void setHotKeyFilter(String hotKeyFilter) {
//        this.hotKeyFilter = hotKeyFilter;
//    }
//
//    @Schema(
//            required = true,
//            example = "1"
//    )
//    public BigDecimal getDeleteLogDays() {
//        return deleteLogDays;
//    }
//
//    public void setDeleteLogDays(BigDecimal deleteLogDays) {
//        this.deleteLogDays = deleteLogDays;
//    }
//
//    @Schema(
//            required = true,
//            example = "false"
//    )
//    public String getIsFullSearch() {
//        return isFullSearch;
//    }
//
//    public void setIsFullSearch(String isFullSearch) {
//        this.isFullSearch = isFullSearch;
//    }
//
//    @Schema(hidden = true)
//    public String getServerIDs() {
//        return serverIDs;
//    }
//
//    public void setServerIDs(String serverIDs) {
//        this.serverIDs = serverIDs;
//    }
//
//    @Schema(
//            required = true,
//            example = "1"
//    )
//    public BigDecimal getDefaultServerID() {
//        return defaultServerID;
//    }
//
//    public void setDefaultServerID(BigDecimal defaultServerID) {
//        this.defaultServerID = defaultServerID;
//    }
//
//    @Schema(
//            required = true,
//            example = "false"
//    )
//    public String getIsEditorUser() {
//        return isEditorUser;
//    }
//
//    public void setIsEditorUser(String isEditorUser) {
//        this.isEditorUser = isEditorUser;
//    }
//
//    @Schema(hidden = true)
//    public String getAndroidUserPass() {
//        return androidUserPass;
//    }
//
//    public void setAndroidUserPass(String androidUserPass) {
//        this.androidUserPass = androidUserPass;
//    }
//
//    @Schema(
//            required = false
//    )
//    public BigDecimal getActiveMonthID() {
//        return activeMonthID;
//    }
//
//    public void setActiveMonthID(BigDecimal activeMonthID) {
//        this.activeMonthID = activeMonthID;
//    }
//
//    @Schema(hidden = true)
//    public BigDecimal getGrid1Color() {
//        return grid1Color;
//    }
//
//    public void setGrid1Color(BigDecimal grid1Color) {
//        this.grid1Color = grid1Color;
//    }
//
//    @Schema(hidden = true)
//    public BigDecimal getGrid2Color() {
//        return grid2Color;
//    }
//
//    public void setGrid2Color(BigDecimal grid2Color) {
//        this.grid2Color = grid2Color;
//    }
//
//    @Schema(hidden = true)
//    public String getColorType() {
//        return colorType;
//    }
//
//    public void setColorType(String colorType) {
//        this.colorType = colorType;
//    }
//
//    @Schema(hidden = true)
//    public String getGridFont() {
//        return gridFont;
//    }
//
//    public void setGridFont(String gridFont) {
//        this.gridFont = gridFont;
//    }
//
//    @Schema(
//            required = true,
//            example = "false"
//    )
//    public String getIsMasterUser() {
//        return isMasterUser;
//    }
//
//    public void setIsMasterUser(String isMasterUser) {
//        this.isMasterUser = isMasterUser;
//    }
//
//    @Schema(
//            required = true,
//            example = "false"
//    )
//    public String getIsRecovery() {
//        return isRecovery;
//    }
//
//    public void setIsRecovery(String isRecovery) {
//        this.isRecovery = isRecovery;
//    }
//
//    @Schema(hidden = true)
//    public String getMacAddresses() {
//        return macAddresses;
//    }
//
//    public void setMacAddresses(String macAddresses) {
//        this.macAddresses = macAddresses;
//    }
//
//    @Schema(
//            required = true,
//            example = "false"
//    )
//    public String getIsPopUp() {
//        return isPopUp;
//    }
//
//    public void setIsPopUp(String isPopUp) {
//        this.isPopUp = isPopUp;
//    }
//
//    @Schema(
//            required = true,
//            example = "1"
//    )
//    public BigDecimal getCalendarType() {
//        return calendarType;
//    }
//
//    public void setCalendarType(BigDecimal calendarType) {
//        this.calendarType = calendarType;
//    }
//
//    @Schema(hidden = true)
//    public String getWebUserName() {
//        return webUserName;
//    }
//
//    public void setWebUserName(String webUserName) {
//        this.webUserName = webUserName;
//    }
//
//    @Schema(
//            required = true,
//            example = "false"
//    )
//    public String getIsNotOtherInfoByDefault() {
//        return isNotOtherInfoByDefault;
//    }
//
//    public void setIsNotOtherInfoByDefault(String isNotOtherInfoByDefault) {
//        this.isNotOtherInfoByDefault = isNotOtherInfoByDefault;
//    }
//
//    @Schema(
//            required = false,
//            example = "windows"
//    )
//    public String getThemeStyle() {
//        return themeStyle;
//    }
//
//    public void setThemeStyle(String themeStyle) {
//        this.themeStyle = themeStyle;
//    }
//
//    public Boolean getIsAndroidUser() {
//        return isAndroidUser;
//    }
//
//    public void setIsAndroidUser(Boolean isAndroidUser) {
//        this.isAndroidUser = isAndroidUser;
//    }
//
//    public String getYearDesc() {
//        return yearDesc;
//    }
//
//    public void setYearDesc(String yearDesc) {
//        this.yearDesc = yearDesc;
//    }
//
//    public String getServerDesc() {
//        return serverDesc;
//    }
//
//    public void setServerDesc(String serverDesc) {
//        this.serverDesc = serverDesc;
//    }
//}
