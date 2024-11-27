package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.pub.PubVoucherType;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Abbas
 * Salman Majidi
 * @since v2.0.0
 */

public interface PubVoucherTypeRepository extends TCrudRepository<PubVoucherType>, CrudRepository<PubVoucherType, BigDecimal> {

    default List<PubVoucherType> pubShowVoucherTypeSysIDTypeID(BigDecimal[] voucherTypeIDs, PubVoucherType pubVoucherType) {
        if (voucherTypeIDs != null) {
            String vTypeIDs = "";
            for (int i = 0; i < voucherTypeIDs.length; i++) {
                vTypeIDs += voucherTypeIDs[i].toString() + ",";
            }
            vTypeIDs = vTypeIDs.substring(0, vTypeIDs.length() - 1);
            pubVoucherType.setFilter(" VoucherTypeID IN (" + vTypeIDs + ")");

        }
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("Filter", null));
        parameters.add(new TParameter<>("OtherFilter", pubVoucherType._otherFilter()));
        parameters.add(new TParameter<>("ServerFilter", null));
        parameters.add(new TParameter<>("YearFilter", null));
        parameters.add(new TParameter<>("UserAccessFilter", null));
        parameters.add(new TParameter<>("IsWebUser", null));
        parameters.add(new TParameter<>("PageFilter", pubVoucherType._pageFilter()));
        return showSP("PubShowVoucherType", parameters, true);
    }

    default List<PubVoucherType> pubShowVoucherTypeRefers(BigDecimal voucherTypeID) {
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("Filter", " AND main.VoucherTypeID IN (SELECT VoucherTypeID FROM PubVoucherType WHERE CHARINDEX(CAST(VoucherTypeID AS varchar(50) )+ ',',(SELECT RefrenceIDs FROM PubVoucherType WHERE VoucherTypeID = " + voucherTypeID + ")+',') >0)"));
        parameters.add(new TParameter<>("OtherFilter", null));
        parameters.add(new TParameter<>("ServerFilter", null));
        parameters.add(new TParameter<>("YearFilter", null));
        parameters.add(new TParameter<>("UserAccessFilter", null));
        parameters.add(new TParameter<>("IsWebUser", null));
        parameters.add(new TParameter<>("PageFilter", null));
        return showSP("PubShowVoucherType", parameters, true);
    }


    default PubVoucherType pubShowVoucherTypeByIDAndroid(BigDecimal voucherTypeID) {
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("Filter", " AND main.VoucherTypeID = " + voucherTypeID));
        parameters.add(new TParameter<>("OtherFilter", null));
        parameters.add(new TParameter<>("ServerFilter", null));
        parameters.add(new TParameter<>("YearFilter", null));
        parameters.add(new TParameter<>("UserAccessFilter", null));
        parameters.add(new TParameter<>("IsWebUser", null));
        parameters.add(new TParameter<>("PageFilter", null));
        return showSP("PubShowVoucherType", parameters, true).get(0);
    }


    default PubVoucherType pubShowVoucherTypeByID(BigDecimal voucherTypeID) {
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("Filter", " AND main.VoucherTypeID = " + voucherTypeID));
        parameters.add(new TParameter<>("OtherFilter", null));
        parameters.add(new TParameter<>("ServerFilter", null));
        parameters.add(new TParameter<>("YearFilter", null));
        parameters.add(new TParameter<>("UserAccessFilter", null));
        parameters.add(new TParameter<>("IsWebUser", null));
        parameters.add(new TParameter<>("PageFilter", null));
        return showSP("PubShowVoucherType", parameters, true).get(0);
    }

    default PubVoucherType pubInsVoucherType(PubVoucherType pubVoucherType) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("VoucherIdentity", pubVoucherType.getVoucherIdentity()));
        tParameters.add(new TParameter<>("VoucherIdentityDesc", pubVoucherType.getVoucherIdentityDesc()));
        tParameters.add(new TParameter<>("VoucherTypeDesc", pubVoucherType.getVoucherTypeDesc()));
        tParameters.add(new TParameter<>("CustomVTypeDesc", pubVoucherType.getCustomVTypeDesc()));
        tParameters.add(new TParameter<>("ImportExport", pubVoucherType.getImportExport()));
        tParameters.add(new TParameter<>("isAutoPrice", pubVoucherType.getIsAutoPrice()));
        tParameters.add(new TParameter<>("PriceInVoucher", pubVoucherType.getIsPriceInVoucher()));
        tParameters.add(new TParameter<>("IsNotActive", pubVoucherType.getIsNotActive()));
        tParameters.add(new TParameter<>("IsDuplicateGoods", pubVoucherType.getIsDuplicateGoods()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsEditReferHeader", pubVoucherType.getIsEditReferHeader()));
        tParameters.add(new TParameter<>("IsEditReferDetail", pubVoucherType.getIsEditReferDetail()));
        tParameters.add(new TParameter<>("IsReferDateInAcc", pubVoucherType.getIsReferDateInAcc()));
        tParameters.add(new TParameter<>("SystemID", pubVoucherType.getSystemID()));
        tParameters.add(new TParameter<>("IsAcc", pubVoucherType.getIsAcc()));
        tParameters.add(new TParameter<>("IsBOM", pubVoucherType.getIsBOM()));
        tParameters.add(new TParameter<>("IsPriceFromBOM", pubVoucherType.getIsPriceFromBOM()));
        tParameters.add(new TParameter<>("IsAllocatedStoreForAutoVoucher", pubVoucherType.getIsAllocatedStoreForAutoVoucher()));
        tParameters.add(new TParameter<>("IsReferNoInAcc", pubVoucherType.getIsReferNoInAcc()));
        tParameters.add(new TParameter<>("IsAutoNumber", pubVoucherType.getIsAutoNumber()));
        tParameters.add(new TParameter<>("SMSDesc", pubVoucherType.getSMSDesc()));
        tParameters.add(new TParameter<>("IsSaveSMS", pubVoucherType.getIsSaveSMS()));
        tParameters.add(new TParameter<>("SMSCenterID", pubVoucherType.getSMSCenterID()));
        tParameters.add(new TParameter<>("IsTotalRefTypeCheck", pubVoucherType.getIsTotalRefTypeCheck()));
        tParameters.add(new TParameter<>("IsPriceList", pubVoucherType.getIsPriceList()));
        tParameters.add(new TParameter<>("IsShowInAnalysis", pubVoucherType.getIsShowInAnalysis()));
        tParameters.add(new TParameter<>("IsByGroupPricing", pubVoucherType.getIsByGroupPricing()));
        tParameters.add(new TParameter<>("IsByReferPricing", pubVoucherType.getIsByReferPricing()));
        tParameters.add(new TParameter<>("MaxRows", pubVoucherType.getMaxRows()));
        tParameters.add(new TParameter<>("AnalysisRefType", pubVoucherType.getAnalysisRefType()));
        tParameters.add(new TParameter<>("IsForceWithRefer", pubVoucherType.getIsForceWithRefer()));
        tParameters.add(new TParameter<>("SelSerialType", pubVoucherType.getSelSerialType()));
        tParameters.add(new TParameter<>("IsForceSerial", pubVoucherType.getIsForceSerial()));
        tParameters.add(new TParameter<>("IsForceAnalysisNo", pubVoucherType.getIsForceAnalysisNo()));
        tParameters.add(new TParameter<>("SMSSendType", pubVoucherType.getSMSSendType()));
        tParameters.add(new TParameter<>("IsDisposableRefer", pubVoucherType.getIsDisposableRefer()));
        tParameters.add(new TParameter<>("SerialRefTypeID", pubVoucherType.getSerialRefTypeID()));
        tParameters.add(new TParameter<>("IsNotSerialQuantity", pubVoucherType.getIsNotSerialQuantity()));
        tParameters.add(new TParameter<>("IsAutoStoreByInventory", pubVoucherType.getIsAutoStoreByInventory()));
        tParameters.add(new TParameter<>("IsBaseAnalysis", pubVoucherType.getIsBaseAnalysis()));
        tParameters.add(new TParameter<>("SelFeeType", pubVoucherType.getSelFeeType()));
        tParameters.add(new TParameter<>("IsCostSharePricing", pubVoucherType.getIsCostSharePricing()));
        tParameters.add(new TParameter<>("IsNotCheckSerialRemain", pubVoucherType.getIsNotCheckSerialRemain()));
        tParameters.add(new TParameter<>("MinTolerance", pubVoucherType.getMinTolerance()));
        tParameters.add(new TParameter<>("MaxTolerance", pubVoucherType.getMaxTolerance()));
        tParameters.add(new TParameter<>("OverQuantityPercent", pubVoucherType.getOverQuantityPercent()));
        tParameters.add(new TParameter<>("IsDeputyGoodsControl", pubVoucherType.getIsDeputyGoodsControl()));
        tParameters.add(new TParameter<>("IsAnalysisGoodsControl", pubVoucherType.getIsAnalysisGoodsControl()));
        BigDecimal newID = insSP("PubInsVoucherType", tParameters);
        PubVoucherType temp = new PubVoucherType();
        temp.setVoucherTypeID(newID);
        return pubShowVoucherTypeSysIDTypeID(null, temp).get(0);
    }

    default PubVoucherType pubUpdVoucherType(BigDecimal voucherTypeID, PubVoucherType pubVoucherType) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        tParameters.add(new TParameter<>("CustomVTypeDesc", pubVoucherType.getCustomVTypeDesc()));
        tParameters.add(new TParameter<>("OrderType", pubVoucherType.getOrderType()));
        tParameters.add(new TParameter<>("isAutoPrice", pubVoucherType.getIsAutoPrice()));
        tParameters.add(new TParameter<>("PriceInVoucher", pubVoucherType.getIsPriceInVoucher()));
        tParameters.add(new TParameter<>("IsNotActive", pubVoucherType.getIsNotActive()));
        tParameters.add(new TParameter<>("IsDuplicateGoods", pubVoucherType.getIsDuplicateGoods()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsEditReferHeader", pubVoucherType.getIsEditReferHeader()));
        tParameters.add(new TParameter<>("IsEditReferDetail", pubVoucherType.getIsEditReferDetail()));
        tParameters.add(new TParameter<>("IsReferDateInAcc", pubVoucherType.getIsReferDateInAcc()));
        tParameters.add(new TParameter<>("IsAutoNumber", pubVoucherType.getIsAutoNumber()));
        tParameters.add(new TParameter<>("IsAcc", pubVoucherType.getIsAcc()));
        tParameters.add(new TParameter<>("IsBOM", pubVoucherType.getIsBOM()));
        tParameters.add(new TParameter<>("IsPriceFromBOM", pubVoucherType.getIsPriceFromBOM()));
        tParameters.add(new TParameter<>("IsAllocatedStoreForAutoVoucher", pubVoucherType.getIsAllocatedStoreForAutoVoucher()));
        tParameters.add(new TParameter<>("IsReferNoInAcc", pubVoucherType.getIsReferNoInAcc()));
        tParameters.add(new TParameter<>("SMSDesc", pubVoucherType.getSMSDesc()));
        tParameters.add(new TParameter<>("IsSaveSMS", pubVoucherType.getIsSaveSMS()));
        tParameters.add(new TParameter<>("SMSCenterID", pubVoucherType.getSMSCenterID()));
        tParameters.add(new TParameter<>("IsTotalRefTypeCheck", pubVoucherType.getIsTotalRefTypeCheck()));
        tParameters.add(new TParameter<>("ISPriceList", pubVoucherType.getIsPriceList()));
        tParameters.add(new TParameter<>("VoucherIdentity", pubVoucherType.getVoucherIdentity()));
        tParameters.add(new TParameter<>("ImportExport", pubVoucherType.getImportExport()));
        tParameters.add(new TParameter<>("IsShowInAnalysis", pubVoucherType.getIsShowInAnalysis()));
        tParameters.add(new TParameter<>("IsByGroupPricing", pubVoucherType.getIsByGroupPricing()));
        tParameters.add(new TParameter<>("IsByReferPricing", pubVoucherType.getIsByReferPricing()));
        tParameters.add(new TParameter<>("SelSerialType", pubVoucherType.getSelSerialType()));
        tParameters.add(new TParameter<>("MaxRows", pubVoucherType.getMaxRows()));
        tParameters.add(new TParameter<>("AnalysisRefType", pubVoucherType.getAnalysisRefType()));
        tParameters.add(new TParameter<>("IsForceWithRefer", pubVoucherType.getIsForceWithRefer()));
        tParameters.add(new TParameter<>("IsForceSerial", pubVoucherType.getIsForceSerial()));
        tParameters.add(new TParameter<>("IsForceAnalysisNo", pubVoucherType.getIsForceAnalysisNo()));
        tParameters.add(new TParameter<>("SMSSendType", pubVoucherType.getSMSSendType()));
        tParameters.add(new TParameter<>("IsDisposableRefer", pubVoucherType.getIsDisposableRefer()));
        tParameters.add(new TParameter<>("SerialRefTypeID", pubVoucherType.getSerialRefTypeID()));
        tParameters.add(new TParameter<>("IsNotSerialQuantity", pubVoucherType.getIsNotSerialQuantity()));
        tParameters.add(new TParameter<>("IsAutoStoreByInventory", pubVoucherType.getIsAutoStoreByInventory()));
        tParameters.add(new TParameter<>("IsBaseAnalysis", pubVoucherType.getIsBaseAnalysis()));
        tParameters.add(new TParameter<>("SelFeeType", pubVoucherType.getSelFeeType()));
        tParameters.add(new TParameter<>("IsCostSharePricing", pubVoucherType.getIsCostSharePricing()));
        tParameters.add(new TParameter<>("IsNotCheckSerialRemain", pubVoucherType.getIsNotCheckSerialRemain()));
        tParameters.add(new TParameter<>("MinTolerance", pubVoucherType.getMinTolerance()));
        tParameters.add(new TParameter<>("MaxTolerance", pubVoucherType.getMaxTolerance()));
        tParameters.add(new TParameter<>("OverQuantityPercent", pubVoucherType.getOverQuantityPercent()));
        tParameters.add(new TParameter<>("IsDeputyGoodsControl", pubVoucherType.getIsDeputyGoodsControl()));
        tParameters.add(new TParameter<>("IsAnalysisGoodsControl", pubVoucherType.getIsAnalysisGoodsControl()));
        updSP("PubUpdVoucherType", tParameters);
        PubVoucherType temp = new PubVoucherType();
        temp.setVoucherTypeID(voucherTypeID);
        return pubShowVoucherTypeSysIDTypeID(null, temp).get(0);
    }

    default void pubDelVoucherType(BigDecimal voucherTypeID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("PubDelVoucherType", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "voucherTypeID", "voucherTypeID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "customVTypeDesc", "نوع", Type.STRING, 250, true, true, false));
        return new Meta(cols);
    }
}
