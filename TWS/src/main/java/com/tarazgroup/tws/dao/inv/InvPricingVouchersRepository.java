package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvPricingVouchers;
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
public interface InvPricingVouchersRepository extends TCrudRepository<InvPricingVouchers>, CrudRepository<InvPricingVouchers, BigDecimal> {
    default List<InvPricingVouchers> invShowPricingVoucher(InvPricingVouchers invPricingVouchers) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        // TODO: 11/15/21 Doesn't have page filter
        BigDecimal modifierIDValue = BigDecimal.valueOf(0.0);
        BigDecimal loginIDValue = BigDecimal.valueOf(0.0);
        // values of IsPrc, ModifierID, LoginID, IsLC mustn't be null
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invPricingVouchers._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invPricingVouchers._yearFilter()));
        tParameters.add(new TParameter<>("IsPrc", false));
        tParameters.add(new TParameter<>("ModifierID", modifierIDValue));
        tParameters.add(new TParameter<>("LoginID", loginIDValue));
        tParameters.add(new TParameter<>("IsLC", false));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("InvPricingVouchers", tParameters, true);
    }

    default InvPricingVouchers invShowPricingVoucherByID(BigDecimal tVoucherDetailID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " And main.tVoucherDetailID= " + tVoucherDetailID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("IsPrc", null));
        tParameters.add(new TParameter<>("ModifierID", null));
        tParameters.add(new TParameter<>("LoginID", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("IsLC", null));
        return showSP("InvPricingVouchers", tParameters, true).get(0);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "tVoucherDetailID", "tVoucherDetailID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "qR", "qR", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "feeR", "feeR", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "feeRTest", "feeRTest", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tImportExport", "tImportExport", Type.INTEGER, 300, true, true, false));
        cols.add(new Col(null, "tRefImportExport", "tRefImportExport", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tisAutoPrice", "tisAutoPrice", Type.BOOLEAN, 300, true, true, false));
        cols.add(new Col(null, "tRowPrice", "tRowPrice", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tRowPriceTest", "tRowPriceTest", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "TDReferID", "TDReferID", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "TRefTypeID", "TRefTypeID", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tPricingMethod", "tPricingMethod", Type.INTEGER, 300, true, true, false));
        cols.add(new Col(null, "tGoodsID", "tGoodsID", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tGroupID", "tGroupID", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tStoreID", "tStoreID", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tFormulaValue", "tFormulaValue", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tVocuherTypeID", "tVocuherTypeID", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tFeeFromBuy", "tFeeFromBuy", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tToStoreID", "tToStoreID", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tAccID", "tAccID", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tBOMValue", "tBOMValue", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tIsPriceFromBOM", "tIsPriceFromBOM", Type.BOOLEAN, 300, true, true, false));
        cols.add(new Col(null, "tVoucherStatID", "tVoucherStatID", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tAccIDNew", "tAccIDNew", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tVoucherDateG", "tVoucherDateG", Type.DATE, 300, true, true, false));
        cols.add(new Col(null, "tEffectDateG", "tEffectDateG", Type.DATE, 300, true, true, false));
        cols.add(new Col(null, "tRowPriceNew", "tRowPriceNew", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tVoucherNumber", "tVoucherNumber", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tVoucherDate", "tVoucherDate", Type.STRING, 300, true, true, false));
        cols.add(new Col(null, "tAvgFee", "tAvgFee", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tAvgFeeTest", "tAvgFeeTest", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tImportPrice", "tImportPrice", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tExportPrice", "tExportPrice", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tIsPriceList", "tIsPriceList", Type.BOOLEAN, 300, true, true, false));
        cols.add(new Col(null, "tBuyVDID", "tBuyVDID", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tLCReferID", "tLCReferID", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tFeeLC", "tFeeLC", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tReferDate", "tReferDate", Type.STRING, 300, true, true, false));
        cols.add(new Col(null, "tBaseDReferID", "tBaseDReferID", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tIsLC", "tIsLC", Type.BOOLEAN, 300, true, true, false));
        cols.add(new Col(null, "tIsByReferPricing", "tIsByReferPricing", Type.BOOLEAN, 300, true, true, false));
        cols.add(new Col(null, "tIsByGroupPricing", "tIsByGroupPricing", Type.BOOLEAN, 300, true, true, false));
        cols.add(new Col(null, "tOrderType", "tOrderType", Type.INTEGER, 300, true, true, false));
        cols.add(new Col(null, "tAvgBOMFee", "tAvgBOMFee", Type.DECIMAL, 300, true, true, false));
        cols.add(new Col(null, "tAvgBOMFeeTest", "tAvgBOMFeeTest", Type.DECIMAL, 300, true, true, false));
        return new Meta(cols);
    }


}
