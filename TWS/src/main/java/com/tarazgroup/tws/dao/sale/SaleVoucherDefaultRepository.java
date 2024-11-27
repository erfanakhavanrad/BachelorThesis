package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleVoucherDefault;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.*;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author salman majidi
 * @since 2.0.0
 */
public interface SaleVoucherDefaultRepository extends TCrudRepository<SaleVoucherDefault>, CrudRepository<SaleVoucherDefault, BigDecimal> {

    default List<SaleVoucherDefault> saleVoucherDefaultLoggedInUser(BigDecimal voucherTypeID,boolean throwIfNoCOntent) {
        LogLogins logLogins = fetchUserDetail();
        String filter = " AND main.UserID=" + logLogins.getPubUser().getUserID();
        if (voucherTypeID != null) {
            filter+=" AND main.VoucherTypeID="+voucherTypeID;
        }
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("Filter", filter));
        tParameters.add(new TParameter("OtherFilter", null));
        tParameters.add(new TParameter("ServerFilter", null));
        tParameters.add(new TParameter("PageFilter", null));
        tParameters.add(new TParameter("UserAccessFilter", null));
        tParameters.add(new TParameter("YearFilter", null));
        return showSP("SaleShowVoucherDefault", tParameters, throwIfNoCOntent);
    }

    default List<SaleVoucherDefault> saleVoucherDefault(BigDecimal voucherTypeID ,BigDecimal UserID ) {
        String filter = " AND main.UserID=" + UserID;
        if (voucherTypeID != null) {
            filter+=" AND main.VoucherTypeID="+voucherTypeID;
        }
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("Filter", filter));
        tParameters.add(new TParameter("OtherFilter", null));
        tParameters.add(new TParameter("ServerFilter", null));
        tParameters.add(new TParameter("PageFilter", null));
        tParameters.add(new TParameter("UserAccessFilter", null));
        tParameters.add(new TParameter("YearFilter", null));
        return showSP("SaleShowVoucherDefault", tParameters, true);
    }
    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        // Sale center
        cols.add(new Col(null, "saleCenterID", "saleCenterID", Type.DECIMAL, 0, false, false,false, Icon.none, true));
        cols.add(new Col(null, "saleCenterDesc", "عنوان مرکز فروش", Type.STRING, 0, false, false,false, Icon.none, false));
        // Deliever
        cols.add(new Col(null, "deliverCenterID", "deliverCenterID", Type.DECIMAL, 0, false, false,false, Icon.none, true));
        cols.add(new Col(null, "deliverCenterDesc", "عنوان مرکز تحویل", Type.STRING, 0, false, false,false, Icon.none, false));
        // store
        cols.add(new Col(null, "storeID", "عنوان انبار", Type.DECIMAL, 0, false, false,false, Icon.none, false));
        // customer
        cols.add(new Col(null, "customerID", "customerID", Type.DECIMAL, 0, false, false,false, Icon.none, true));
        cols.add(new Col(null, "customerName", "عنوان مشتری", Type.STRING, 0, false, false,false, Icon.none, false));
        // Marketing Man
        cols.add(new Col(null, "marketingManID", "marketingManID", Type.DECIMAL, 0, false, false,false, Icon.none, true));
        cols.add(new Col(null, "marketingManName", "عنوان بازاریاب", Type.STRING, 0, false, false,false, Icon.none, false));
        // seller man
        cols.add(new Col(null, "saleManID", "saleManID", Type.DECIMAL, 0, false, false,false, Icon.none, true));
        cols.add(new Col(null, "salesManName", "عنوان فروشنده", Type.STRING, 0, false, false,false, Icon.none, false));
        // payment ID
        cols.add(new Col(null, "paymentWayIDs", "paymentWayIDs", Type.DECIMAL, 0, false, false,false, Icon.none, true));
        cols.add(new Col(null, "paymentwayDescs", "عنوان مشتری", Type.STRING, 0, false, false,false, Icon.none, false));
        //
        return new Meta(cols);
    }
}
