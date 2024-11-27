package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.pub.PubUsers;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
public interface PubUsersRepository extends TCrudRepository<PubUsers>, CrudRepository<PubUsers, BigDecimal> {

    default int recordsCount(Map<String, String> params) {
        PubUsers pubUsers = setParams(PubUsers.class, params);
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("IsWebUser", null));
        tParameters.add(new TParameter<>("PageFilter", pubUsers._pageFilter()));
        return showSP("PubShowUsers", tParameters, true).size();
    }

    default List<PubUsers> pubShowUsers(PubUsers pubUsers) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("IsWebUser", null));
        tParameters.add(new TParameter<>("PageFilter", pubUsers._pageFilter()));
        return showSP("PubShowUsers", tParameters, true);
    }

    default PubUsers pubShowUsersByID(BigDecimal pubUsersID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND main.UserID=" + pubUsersID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("IsWebUser", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("PubShowUsers", tParameters, true).get(0);
    }

    default PubUsers pubUpdUsers(
            BigDecimal userID,
            BigDecimal userGroupID,
            String userLoginName,
            String userPassWord,
            String resetPassWord,
            Boolean isActive,
            BigDecimal activeYearID,
            Boolean isBackUpOperator,
            BigDecimal standByTime,
            BigDecimal deleteLogDays,
            Boolean isFullSearch,
            BigDecimal defaultServerID,
            Integer activeMonthID,
            String androidUser,
            String androidPass,
            BigDecimal grid1Color,
            BigDecimal grid2Color,
            String gridFont,
            Boolean colorType,
            Boolean isChangeColor,
            Boolean isDelGridConfig,
            Boolean isMasterUser,
            Boolean isRecovery,
            String macAddresses,
            Boolean isPopUp,
            Integer calendarType,
            Integer webUserType,
            Boolean isNotOtherInfoByDefault,
            String themeStyle,
            Integer alertPosition,
            Integer alertStyle
    ) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("UserID", userID));
        tParameters.add(new TParameter<>("UserGroupID", userGroupID));
        tParameters.add(new TParameter<>("UserLoginName", userLoginName));
        tParameters.add(new TParameter<>("UserPassWord", userPassWord));
        tParameters.add(new TParameter<>("ResetPassWord", resetPassWord));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsActive", isActive));
        tParameters.add(new TParameter<>("ActiveYearID", activeYearID));
        tParameters.add(new TParameter<>("IsBackUpOperator", isBackUpOperator));
        tParameters.add(new TParameter<>("StandByTime", standByTime));
        tParameters.add(new TParameter<>("DeleteLogDays", deleteLogDays));
        tParameters.add(new TParameter<>("IsFullSearch", isFullSearch));
        tParameters.add(new TParameter<>("DefaultServerID", defaultServerID));
        tParameters.add(new TParameter<>("ActiveMonthID", activeMonthID));
        tParameters.add(new TParameter<>("AndroidUser", androidUser));
        tParameters.add(new TParameter<>("AndroidPass", androidPass));
        tParameters.add(new TParameter<>("Grid1Color", grid1Color));
        tParameters.add(new TParameter<>("Grid2Color", grid2Color));
        tParameters.add(new TParameter<>("GridFont", gridFont));
        tParameters.add(new TParameter<>("ColorType", colorType));
        tParameters.add(new TParameter<>("IsChangeColor", isChangeColor));
        tParameters.add(new TParameter<>("IsDelGridConfig", isDelGridConfig));
        tParameters.add(new TParameter<>("IsMasterUser", isMasterUser));
        tParameters.add(new TParameter<>("IsRecovery", isRecovery));
        tParameters.add(new TParameter<>("MacAddresses", macAddresses));
        tParameters.add(new TParameter<>("IsPopUp", isPopUp));
        tParameters.add(new TParameter<>("CalendarType", calendarType));
        tParameters.add(new TParameter<>("WebUserType", webUserType));
        tParameters.add(new TParameter<>("IsNotOtherInfoByDefault", isNotOtherInfoByDefault));
        tParameters.add(new TParameter<>("ThemeStyle", themeStyle));
        tParameters.add(new TParameter<>("AlertPosition", alertPosition));
        tParameters.add(new TParameter<>("AlertStyle", alertStyle));
        updSP("PubUpdUsers", tParameters);
        return pubShowUsersByID(userID);
    }

    default PubUsers pubUpdUserActiveYearByID(BigDecimal activeYearID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ActiveYearID", activeYearID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getLoginId()));
        updSP("PubUpdUserActiveYear", tParameters);
        return pubShowUsersByID(logLogins.getPubUser().getUserID());
    }

    default void pubDelUser(BigDecimal userID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("UserID", userID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("PubDelUsers", tParameters);
    }

    //
//    default Meta meta() {
//        ArrayList<Col> cols = new ArrayList<>();
//        cols.add(new Col("userID", "userID", Type.DECIMAL, 0, false, false,  true));
//        cols.add(new Col("userPassWord", "نام کاربری", Type.STRING, 150, true, true,  false));
//        return new Meta(cols);
    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "userID", "userID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "userPassWord", "نام کاربری", Type.STRING, 150, true, true, false));
        return new Meta(cols);
    }

    default Meta meta1() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "userID", "userID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "personCode", "کد کاربری", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "firstName", "نام", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "lastName", "نام خانوادگی", Type.STRING, 120, true, true, false));
        cols.add(new Col(null, "userName", "نام کاربری", Type.STRING, 200, true, true, false));
        cols.add(new Col(null, "isActive", "فعال", Type.BOOLEAN, 80, true, true, false));
        cols.add(new Col(null, "yearDesc", "سال مالی فعال", Type.STRING, 130, true, true, false));
        cols.add(new Col(null, "serverDesc", "محل صدور فعال", Type.STRING, 150, true, true, false));
        cols.add(new Col(null, "isAndroidUser", "کاربر وب", Type.BOOLEAN, 80, true, true, false));
        return new Meta(cols);
    }


    default Meta metaReferTo() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "userID", "userID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "personCode", "کد", Type.STRING, 150, true, true, false));
        cols.add(new Col(null, "userName", "شرح", Type.STRING, 200, true, true, false));
        return new Meta(cols);
    }
}
