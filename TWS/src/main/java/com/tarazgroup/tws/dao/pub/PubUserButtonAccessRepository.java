package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.ResultErrMsgNewID;
import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.pub.PubUserButtonAccess;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Erfan Akhavan
 */
public interface PubUserButtonAccessRepository extends TCrudRepository<PubUserButtonAccess>, CrudRepository<PubUserButtonAccess, BigDecimal> {

    default List<PubUserButtonAccess> pubShowUserButtonAccess(BigDecimal userID, BigDecimal systemID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND ISNULL(Button.UserID," + userID + ") = " + userID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("SysFilter", " AND Main.SystemID IN (" + systemID + ")"));
        tParameters.add(new TParameter<>("UserID", userID));
        tParameters.add(new TParameter<>("PageFilter", " AND ButtonID <> SystemID ?,?"));
        return showSP("PubShowUserButtonAccess", tParameters, true);
    }

    default void pubInsUserButtonAccess(PubUserButtonAccess pubUserButtonAccess) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ButtonID", pubUserButtonAccess.getButtonID()));
        tParameters.add(new TParameter<>("UserID", pubUserButtonAccess.getUserID()));
        tParameters.add(new TParameter<>("CanView", pubUserButtonAccess.getCanView()));
        tParameters.add(new TParameter<>("CanAdd", pubUserButtonAccess.getCanAdd()));
        tParameters.add(new TParameter<>("CanEdit", pubUserButtonAccess.getCanEdit()));
        tParameters.add(new TParameter<>("CanDel", pubUserButtonAccess.getCanDel()));
        tParameters.add(new TParameter<>("CanPrint", pubUserButtonAccess.getCanPrint()));
        tParameters.add(new TParameter<>("AccessFilterStr", null));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("UserAccessFilterStr", null));
        tParameters.add(new TParameter<>("TimeLimited", null));
        tParameters.add(new TParameter<>("EditDelTime", null));
        tParameters.add(new TParameter<>("TVD", null));
        ResultErrMsgNewID resultErrMsgNewID = execSPNativeQuery(PubUserButtonAccess.class, "PubInsUserButtonAccess", tParameters);
    }

    default void pubDelUserButtonAccess(BigDecimal userID, BigDecimal buttonID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("UserID", userID));
        tParameters.add(new TParameter<>("ButtonID", buttonID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("PubDelUserButtonAccess", tParameters);
    }

    default PubUserButtonAccess pubShowUserButtonAccessByID(BigDecimal buttonID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " And main.ButtonID= " + buttonID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("SysFilter", null));
        tParameters.add(new TParameter<>("UserID", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("PubShowUserButtonAccess", tParameters, true).get(0);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "buttonID", "buttonID", Type.DECIMAL, 0, false, false, false, true));
        cols.add(new Col(null, "buttonDesc", "عنوان", Type.STRING, 300, true, true, false, false));
        cols.add(new Col(null, "canView", "نمایش", Type.BOOLEAN, 100, true, true, true, false));
        cols.add(new Col(null, "canAdd", "ایجاد", Type.BOOLEAN, 100, true, true, true, false));
        cols.add(new Col(null, "canEdit", "ویرایش", Type.BOOLEAN, 100, true, true, true, false));
        cols.add(new Col(null, "canDel", "حذف", Type.BOOLEAN, 100, true, true, true, false));
        cols.add(new Col(null, "canPrint", "چاپ", Type.BOOLEAN, 100, true, true, true, false));


        // ستون های زیر فعلا چون نیاز نبود اضافه نکردم
        cols.add(new Col(null, "timeLimited", "محدوده زمانی", Type.BOOLEAN, 120, false, false, false, false));
        cols.add(new Col(null, "editDelTime", "زمان مجاز ویرایش/حذف به روز", Type.DECIMAL, 100, false, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, false, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.INTEGER, 100, false, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 100, false, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 100, false, false, false, false));
        cols.add(new Col(null, "fatherID", "fatherID", Type.DECIMAL, 100, false, false, false, false));
        cols.add(new Col(null, "accessFilterStr", "دسترسی خاص", Type.STRING, 100, false, false, false, false));
        cols.add(new Col(null, "userAccessFilterStr", "userAccessFilterStr", Type.STRING, 100, false, false, false, false));
        cols.add(new Col(null, "systemID", "systemID", Type.DECIMAL, 100, false, false, false, false));
        cols.add(new Col(null, "isUserAccessFilterStr", "دسترسی خاص دارد", Type.BOOLEAN, 100, false, false, false, false));
        cols.add(new Col(null, "webAddress", "webAddress", Type.STRING, 100, false, false, false, false));
        return new Meta(cols);
    }


}
