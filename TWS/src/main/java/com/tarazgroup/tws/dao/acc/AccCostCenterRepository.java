package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccCostCenter;
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
 * @Since 2.0.0
 */
public interface AccCostCenterRepository extends TCrudRepository<AccCostCenter>, CrudRepository<AccCostCenter, BigDecimal> {

    default List<AccCostCenter> accShowCostCenter(AccCostCenter accCostCenter) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("PageFilter", accCostCenter._pageFilter()));
        return showSP("AccShowCostCenter", tParameters, true);
    }

    default AccCostCenter accShowCostCenterByID(BigDecimal costCenterID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", "AND main.costCenterID=" + costCenterID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("AccShowCostCenter", tParameters, true).get(0);
    }

    default AccCostCenter accInsCostCenter(AccCostCenter accCostCenter) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CostCenterCode", accCostCenter.getCostCenterCode()));
        tParameters.add(new TParameter<>("CostCenterDesc", accCostCenter.getCostCenterDesc()));
        tParameters.add(new TParameter<>("CostCenterTypeID", accCostCenter.getCostCenterTypeID()));
        tParameters.add(new TParameter<>("TafsiliID", null));
        tParameters.add(new TParameter<>("TafsiliTypeID", accCostCenter.getTafsiliTypeID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("CostCenterFatherID", null));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("AccInsCostCenter", tParameters);
        return accShowCostCenterByID(newID);
    }

    default AccCostCenter accUpdCostCenter(BigDecimal costCenterID, AccCostCenter accCostCenter) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("CostCenterID", costCenterID));
        tParameters.add(new TParameter<>("CostCenterCode", accCostCenter.getCostCenterCode()));
        tParameters.add(new TParameter<>("CostCenterDesc", accCostCenter.getCostCenterDesc()));
        tParameters.add(new TParameter<>("TafsiliTypeID", accCostCenter.getTafsiliTypeID()));
        tParameters.add(new TParameter<>("CostCenterTypeID", accCostCenter.getCostCenterTypeID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("AccUpdCostCenter", tParameters);
        return accShowCostCenterByID(costCenterID);
    }

    default void accDelCostCenter(BigDecimal costCenterID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("CostCenterID", costCenterID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("AccDelCostCenter", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"costCenterID", "CostCenterID", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"serverID", "serverID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"costCenterCode", "کد مرکز هزینه", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"costCenterDesc", "شرح مرکز هزینه", Type.STRING, 200, true, true,  false));
        cols.add(new Col(null,"costCenterTypeID", "costCenterTypeID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"tafsiliID", "tafsiliID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"tafsiliCode", "کد تفصیلی", Type.STRING, 200, true, true,  false));
        cols.add(new Col(null,"createDate", "createDate", Type.DATE, 0, false, false,  false));
        cols.add(new Col(null,"creatorID", "creatorID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"modifyDate", "modifyDate", Type.DATE, 0, false, false,  false));
        cols.add(new Col(null,"modifierID", "modifierID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"tafsiliTypeID", "tafsiliTypeID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"tafsiliTypeDesc", "tafsiliTypeDesc", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"costCenterTypeCode", "costCenterTypeCode", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"costCenterTypeDesc", "نوع مرکز هزینه", Type.STRING, 100, true, true,  false));
        return new Meta(cols);
    }

}


