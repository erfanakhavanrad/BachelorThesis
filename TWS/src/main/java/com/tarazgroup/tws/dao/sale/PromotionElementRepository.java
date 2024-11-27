package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.ShowSPReturnType;
import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccBank;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.*;
import com.tarazgroup.tws.util.global.TCalendar;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.tabletype.sale.SaleVDTblType;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@SuppressWarnings("Duplicates")
public interface PromotionElementRepository
        extends TCrudRepository<PromotionElement>, CrudRepository<PromotionElement, BigDecimal> {

    default PromotionElement saleComputePromotion(SaleVoucher saleVoucher) {
        LogLogins logLogins = fetchUserDetail();
        SaleVoucherHeader saleVoucherHeader = saleVoucher.getHeader();
        List<SaleVoucherDetailLight> saleVoucherDetailLights = saleVoucher.getDetails();

        List<SaleVDTblType> saleVDTblTypes = new ArrayList<>();
        for (int i = 0; i < saleVoucherDetailLights.size(); i++) {
            // افزودن کالا برای محاسبه جایزه
            SaleVDTblType saleVDTblType = new SaleVDTblType();
            saleVDTblType.setRowNo(new BigDecimal(i));
            saleVDTblType.setVoucherDetailID(null);
            saleVDTblType.setVoucherHeaderID(null);
            saleVDTblType.setGoodsID(saleVoucherDetailLights.get(i).getGoodsID());
            saleVDTblType.setSecUnitID(saleVoucherDetailLights.get(i).getSecUnitID());
            saleVDTblType.setQuantity(saleVoucherDetailLights.get(i).getQuantity());
            saleVDTblType.setFee(saleVoucherDetailLights.get(i).getFee());
            saleVDTblType.setDetailXDesc(null);
            saleVDTblType.setdReferID(null);
            saleVDTblType.setCreatorID(null);
            saleVDTblType.setModifierID(null);
            saleVDTblType.setDifferentialID(null);
            saleVDTblType.setComputeValue(null);
            saleVDTblType.setCustomField1(null);
            saleVDTblType.setCustomField2(null);
            saleVDTblType.setCustomField3(null);
            saleVDTblType.setCustomField4(null);
            saleVDTblType.setCustomField5(null);
            saleVDTblType.setCustomField6(null);
            saleVDTblType.setCustomField7(null);
            saleVDTblType.setCustomField8(null);
            saleVDTblType.setCustomField9(null);
            saleVDTblType.setCustomField10(null);
            saleVDTblType.setCustomField11(null);
            saleVDTblType.setFeeAgreement(saleVoucherDetailLights.get(i).getFee());
            saleVDTblType.setFeeDiscountPrice(new BigDecimal(0));
            saleVDTblType.setFeeDiscountPercent(new BigDecimal(0));
            saleVDTblType.setFeeFrieghtCharges(null);
            saleVDTblType.setAllocatedQuantity2(null);
            saleVDTblType.setOverAllocatedQuantity2(null);
            saleVDTblType.setLCReferID(null);
            saleVDTblType.setAgrReferID(null);
            saleVDTblType.setQuantity2(null);
            saleVDTblType.setQuantity3(null);
            saleVDTblType.setSecUnitID2(null);
            saleVDTblType.setSecUnitID3(null);
            saleVDTblType.setCustomField12(null);
            saleVDTblType.setCustomField13(null);
            saleVDTblType.setCustomField14(null);
            saleVDTblType.setCustomField15(null);
            saleVDTblType.setCustomField16(null);
            saleVDTblType.setCustomField17(null);
            saleVDTblType.setCustomField18(null);
            saleVDTblType.setCustomField19(null);
            saleVDTblType.setCustomField20(null);
            saleVDTblType.setCustomField21(null);
            saleVDTblType.setCustomField22(null);
            saleVDTblType.setCustomField23(null);
            saleVDTblType.setCustomField24(null);
            saleVDTblType.setCustomField25(null);
            saleVDTblType.setStoreID(null);
            saleVDTblType.setCenter1ID(null);
            saleVDTblType.setCenter2ID(null);
            saleVDTblType.setCenter3ID(null);
            saleVDTblType.setiGUID(null);
            saleVDTblType.setTaxMab(null);
            saleVDTblType.setTollMab(null);
            saleVDTblType.setTaxCoEff(null);
            saleVDTblType.setIsPromotion(null);
            saleVDTblType.setBaseDReferID(null);
            saleVDTblType.setSecondGoodsID(null);
            saleVDTblType.setrRowMabPrice(null);
            saleVDTblType.setrRowMabPercent(null);
            saleVDTblType.setTollCoEff(null);
            saleVDTblType.setCurrencyID(null);
            saleVDTblTypes.add(saleVDTblType);
        }


        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherDate", new TCalendar().getIranianDateBySlashZero()));
        tParameters.add(new TParameter<>("CustomerID", saleVoucherHeader.getCustomerID()));

        tParameters.add(new TParameter<>("MarketingManID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("VoucherDetailID", null));
        tParameters.add(new TParameter<>("VoucherTypeID", saleVoucherHeader.getVoucherTypeID()));
        tParameters.add(new TParameter<>("IsBonus", null));
        tParameters.add(new TParameter<>("SalePrice", null));

        tParameters.add(new TParameter<>("IsOnlyPreview", null));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("SecUnitID", null));
        tParameters.add(new TParameter<>("StoreID", saleVoucherHeader.getStoreID()));
        tParameters.add(new TParameter<>("SaleCenterID", saleVoucherHeader.getSaleCenterID()));
//
        tParameters.add(new TParameter<>("DeliverCenterID", saleVoucherHeader.getDeliverCenterID()));
        tParameters.add(new TParameter<>("MarketingClassID", null));
        tParameters.add(new TParameter<>("SalesClassID", null));
        tParameters.add(new TParameter<>("SaleTypeID", saleVoucherHeader.getSaleTypeID()));
//        tParameters.add(new TParameter<>("SaleTypeID", null));
        tParameters.add(new TParameter<>("YearID", logLogins.getPubUser().getActiveYearID()));
        tParameters.add(new TParameter<>("VoucherHeaderID", null));
//
        tParameters.add(new TParameter<>("IsTest", null));
        tParameters.add(new TParameter<>("TVD", saleVDTblTypes));
        tParameters.add(new TParameter<>("PaymentWayID", null));
        List<Map<String, Object>> rows = execSPNativeQuery(PromotionElement.class, "SaleComputePromotion", tParameters, ShowSPReturnType.MAP);
        return new PromotionElement().fromArrayList(rows);
    }

    default void saleInsPromotion(BigDecimal voucherHeaderID, List<Element> elements) {//در واقع المنت اینزرت میکند نه جایزه
        LogLogins logLogins = fetchUserDetail();
        for (int i = 0; i < elements.size(); i++) {
            Element element = elements.get(i);
            List<TParameter<?>> tParameters = new ArrayList<>();
            tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
            tParameters.add(new TParameter<>("GoodsId", element.getGoodsID()));
            tParameters.add(new TParameter<>("ElementID", element.getElementID()));
            tParameters.add(new TParameter<>("ElementMab", element.getElementMab()));
            tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
            tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
            insSP("SaleInsPromotion", tParameters);
        }
    }
}
