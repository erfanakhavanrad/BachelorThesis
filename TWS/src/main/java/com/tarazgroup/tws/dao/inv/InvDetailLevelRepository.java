package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvDetailLevel;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
public interface InvDetailLevelRepository extends TCrudRepository<InvDetailLevel>, CrudRepository<InvDetailLevel, BigDecimal> {

    default List<InvDetailLevel> invShowDetailLevel(InvDetailLevel invDetailLevel) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invDetailLevel._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invDetailLevel._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", invDetailLevel._pageFilter()));
        return showSP("InvShowDetailLevel", tParameters, true);
    }

    default InvDetailLevel invShowDetailLevelByID(BigDecimal detailLevelID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " And main.detailLevelID= " + detailLevelID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("InvShowDetailLevel", tParameters, true).get(0);
    }

    default void invDelDetailLevel(BigDecimal invDetailLevelID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("DetailLevelID", invDetailLevelID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("InvDelDetailLevel", tParameters);
    }

    default InvDetailLevel invInsDetailLevel(InvDetailLevel invDetailLevel) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("DetailLevelCode", invDetailLevel.getDetailLevelCode()));
        tParameters.add(new TParameter<>("DetailLevelName", invDetailLevel.getDetailLevelName()));
        tParameters.add(new TParameter<>("DetailLevelLatinName", invDetailLevel.getDetailLevelLatinName()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getCreatorID()));
        tParameters.add(new TParameter<>("LevelID", invDetailLevel.getLevelID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("InvInsDetailLevel", tParameters);
        InvDetailLevel temp = new InvDetailLevel();
        temp.setDetailLevelID(newID);
        return invShowDetailLevel(temp).get(0);
    }

    default InvDetailLevel invUpdDetailLevel(BigDecimal detailLevelID, InvDetailLevel invDetailLevel) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("DetailLevelID", detailLevelID));
        tParameters.add(new TParameter<>("DetailLevelCode", invDetailLevel.getDetailLevelCode()));
        tParameters.add(new TParameter<>("DetailLevelName", invDetailLevel.getDetailLevelName()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LevelID", invDetailLevel.getLevelID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("DetailLevelLatinName", invDetailLevel.getDetailLevelLatinName()));
        updSP("InvUpdDetailLevel", tParameters);
        InvDetailLevel temp = new InvDetailLevel();
        temp.setDetailLevelID(detailLevelID);
        return invShowDetailLevel(temp).get(0);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "detailLevelID", "detailLevelID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "detailLevelCode", "زیر طبقه|کد", Type.STRING, 60, true, true, false));
        cols.add(new Col(null, "detailLevelName", "زیر طبقه|شرح", Type.STRING, 60, true, true, false));
        cols.add(new Col(null, "detailLevelLatinName", "زیر طبقه|عنوان لاتین", Type.STRING, 149, true, true, false));
        cols.add(new Col(null, "levelCode", "طبقه اصلی|کد", Type.STRING, 149, true, true, false));
        cols.add(new Col(null, "levelDesc", "طبقه اصلی|عنوان", Type.STRING, 149, true, true, false));
        cols.add(new Col(null, "levelLatinDesc", "طبقه اصلی|شرح لاتین", Type.STRING, 149, true, true, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 149, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 149, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 149, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 149, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 149, false, false, false));
        cols.add(new Col(null, "levelID", "کد طبقه", Type.DECIMAL, 149, false, false, false));
        return new Meta(cols);
    }
}
