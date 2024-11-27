package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvStoreCountExcelSetup;
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
 * @author Erfan Akhavan
 */

public interface InvStoreCountExcelSetupRepository extends TCrudRepository<InvStoreCountExcelSetup>, CrudRepository<InvStoreCountExcelSetup, BigDecimal> {
    default List<InvStoreCountExcelSetup> invShowStoreExcelSetup(InvStoreCountExcelSetup invStoreCountExcelSetup) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invStoreCountExcelSetup._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invStoreCountExcelSetup._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
//        tParameters.add(new TParameter<>("PageFilter", invStoreCountExcelSetup._pageFilter()));
        return showSP("InvShowStoreCountExcelSetup", tParameters, true);
    }

    default InvStoreCountExcelSetup invShowStoreExcelSetupByID(BigDecimal FirstRowIsColumns) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("InvShowStoreCountExcelSetup", tParameters, true).get(0);
    }

    default InvStoreCountExcelSetup invInsStoreExcelSetup(InvStoreCountExcelSetup invStoreCountExcelSetup) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FirstRowIsColumns", invStoreCountExcelSetup.getIsFirstRowIsColumns()));
        tParameters.add(new TParameter<>("Add13ToDateCol", invStoreCountExcelSetup.getIsAdd13ToDateCol()));
        tParameters.add(new TParameter<>("Col1", invStoreCountExcelSetup.getCol1()));
        tParameters.add(new TParameter<>("Col2", invStoreCountExcelSetup.getCol2()));
        tParameters.add(new TParameter<>("Col3", invStoreCountExcelSetup.getCol3()));
        tParameters.add(new TParameter<>("Col4", invStoreCountExcelSetup.getCol4()));
        tParameters.add(new TParameter<>("Col5", invStoreCountExcelSetup.getCol5()));
        tParameters.add(new TParameter<>("Col6", invStoreCountExcelSetup.getCol6()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("InvInsStoreCountExcelSetup", tParameters);
        return invShowStoreExcelSetupByID(newID);
    }


    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "firstRowIsColumns", "firstRowIsColumns", Type.BOOLEAN, 0, false, false, true));
        cols.add(new Col(null, "add13ToDateCol", "add13ToDateCol", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "col1", "شمارش ۱", Type.INTEGER, 100, true, true, false));
        cols.add(new Col(null, "col2", "شمارش ۲", Type.INTEGER, 100, true, true, false));
        cols.add(new Col(null, "col3", "شمارش ۳", Type.INTEGER, 100, true, true, false));
        cols.add(new Col(null, "col4", "شمارش ۴", Type.INTEGER, 100, true, true, false));
        cols.add(new Col(null, "col5", "شمارش ۵", Type.INTEGER, 100, true, true, false));
        cols.add(new Col(null, "col6", "شمارش ۶", Type.INTEGER, 100, true, true, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
        return new Meta(cols);
    }


}
