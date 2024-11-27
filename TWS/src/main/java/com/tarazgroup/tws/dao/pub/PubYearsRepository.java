package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.pub.PubYears;
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
public interface PubYearsRepository extends TCrudRepository<PubYears>, CrudRepository<PubYears, BigDecimal> {

    default List<PubYears> pubShowYears(PubYears pubYears) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", pubYears._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", pubYears._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("IsWebUser", null));
        tParameters.add(new TParameter<>("PageFilter", pubYears._pageFilter()));
        return showSP("PubShowYears", tParameters, true);
    }

    default PubYears pubShowYearsByYearID(BigDecimal yearID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.YearID=" + yearID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("IsWebUser", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("PubShowYears", tParameters, true).get(0);
    }

    default PubYears pubInsYears(PubYears pubYears) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("ShamsiYear", pubYears.getShamsiYear()));
        tParameters.add(new TParameter<>("StartShamsiDate", pubYears.getStartShamsiDate()));
        tParameters.add(new TParameter<>("EndShamsiDate", pubYears.getEndShamsiDate()));
        tParameters.add(new TParameter<>("YearDesc", pubYears.getYearDesc()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("PubInsYears", tParameters);
        return pubShowYearsByYearID(newID);
    }

    default void pubDelYears(BigDecimal yearID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("YearID", null));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("YrID", yearID));
        delSP("PubDelYears", tParameters);
    }

    default PubYears pubUpdYears(PubYears pubYears, BigDecimal yearID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("YearID", yearID));
        tParameters.add(new TParameter<>("ShamsiYear", pubYears.getShamsiYear()));
        tParameters.add(new TParameter<>("StartShamsiDate", pubYears.getStartShamsiDate()));
        tParameters.add(new TParameter<>("EndShamsiDate", pubYears.getEndShamsiDate()));
        tParameters.add(new TParameter<>("YearDesc", pubYears.getYearDesc()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("YRID", yearID));
        updSP("PubUpdYears", tParameters);
        return pubShowYearsByYearID(yearID);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"yearID", "yearID", Type.DECIMAL, 100, false, false,  true));
        cols.add(new Col(null,"createDate", "createDate", Type.DATE, 120, false, false,  false));
        cols.add(new Col(null,"creatorID", "creatorID", Type.DECIMAL, 100, false, false,  false));
        cols.add(new Col(null,"modifyDate", "modifyDate", Type.DATE, 100, false, false,  false));
        cols.add(new Col(null,"modifierID", "modifierID", Type.DECIMAL, 100, false, false,  false));
        cols.add(new Col(null,"serverID", "serverID", Type.INTEGER, 100, false, false,  false));
        cols.add(new Col(null,"yearDesc", "شرح", Type.STRING, 120, true, true,  false));
        cols.add(new Col(null,"startShamsiDate", "شروع سال مالی", Type.DATE, 130, true, true,  false));
        cols.add(new Col(null,"endShamsiDate", "پایان سال مالی", Type.DATE, 100, true, true,  false));
        cols.add(new Col(null,"shamsiYear", "عدد سال", Type.INTEGER, 100, true, true,  false));
        return new Meta(cols);
    }
}