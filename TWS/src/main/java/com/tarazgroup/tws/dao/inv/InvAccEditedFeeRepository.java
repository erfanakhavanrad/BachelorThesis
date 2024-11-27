package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvAccEditedFee;
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

public interface InvAccEditedFeeRepository extends TCrudRepository<InvAccEditedFee>, CrudRepository<InvAccEditedFee, BigDecimal> {
    // TODO: 11/21/21 complete this if windows form is found
    default List<InvAccEditedFee> invShowAccEditedFee(InvAccEditedFee invAccEditedFee) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invAccEditedFee._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invAccEditedFee._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("InvShowAccEditedFee", tParameters, true);
    }

    default InvAccEditedFee invShowAccEditedFeeByID(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " And Main.voucherHeaderID=" + voucherHeaderID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("InvShowAccEditedFee", tParameters, true).get(0);
    }


    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "voucherHeaderID", "", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "voucherNumber", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "voucherDate", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "voucherDateG", "", Type.DATE, 100, true, false, false));
        cols.add(new Col(null, "voucherTime", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "referNumber", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "referDate", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "voucherTypeID", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "voucherTypeDesc", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "refTypeID", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "refTypeDesc", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "center1ID", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "center2ID", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "center3ID", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "tafsiliID", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "tafsiliCode", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "tafsiliDesc", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "center1Code", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "center1Desc", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "center2Code", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "center2Desc", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "center3Code", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "center3Desc", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "storeID", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "storeCode", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "storeName", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "isLCStore", "", Type.BOOLEAN, 100, true, false, false));
        cols.add(new Col(null, "toStoreID", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "toStoreCode", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "toStoreName", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "voucherStatDesc", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "voucherStatID", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "yearID", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "createDate", "", Type.DATE, 100, true, false, false));
        cols.add(new Col(null, "creatorID", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "modifyDate", "", Type.DATE, 100, true, false, false));
        cols.add(new Col(null, "modifierID", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "serverID", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "usedasRefrenceIDs", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "voucherIdentity", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "voucherDesc", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "refrenceIDs", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "accID", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "referID", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "importExport", "", Type.INTEGER, 100, true, false, false));
        cols.add(new Col(null, "priceinVoucher", "", Type.BOOLEAN, 100, true, false, false));
        cols.add(new Col(null, "serverDesc", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "creatorName", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "controllerName", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "receiverName", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "customerID", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "accNumber", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "accountID", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "accountCode", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "accountDesc", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "isEditReferHeader", "", Type.BOOLEAN, 100, true, false, false));
        cols.add(new Col(null, "isEditReferDetail", "", Type.BOOLEAN, 100, true, false, false));
        cols.add(new Col(null, "refIdentity", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "goodsCode", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "barCode", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "goodsDesc", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "unitName", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "fee", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "feeNew", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "priceMain", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "priceEdited", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "priceExcept", "", Type.DECIMAL, 100, true, false, false));
        return new Meta(cols);
    }


}
