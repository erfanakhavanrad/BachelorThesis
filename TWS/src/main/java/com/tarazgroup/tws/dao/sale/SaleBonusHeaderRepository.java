package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleBonusHeader;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Salehi
 */

public interface SaleBonusHeaderRepository extends TCrudRepository<SaleBonusHeader>, CrudRepository<SaleBonusHeader, BigDecimal> {

    default List<SaleBonusHeader> saleShowBonusHeader(SaleBonusHeader saleBonusHeader) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", saleBonusHeader._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", saleBonusHeader._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        // TODO در این اس پی باید پیج فیلتر اضافه شود
        //
        return showSP("SaleShowBonusHeader", tParameters, true);
    }

    default SaleBonusHeader saleShowBonusHeaderByID(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", "And Main.VoucherHeaderID = " + voucherHeaderID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        //
        return showSP("SaleShowBonusHeader", tParameters, true).get(0);
    }

    default SaleBonusHeader saleInsBonusHeader(SaleBonusHeader saleBonusHeader) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("VoucherNumber", saleBonusHeader.getVoucherNumber()));
        tParameters.add(new TParameter<>("VoucherDate", saleBonusHeader.getVoucherDate()));
        tParameters.add(new TParameter<>("VoucherDesc", saleBonusHeader.getVoucherDesc()));
        tParameters.add(new TParameter<>("FromDate", saleBonusHeader.getFromDate()));
        tParameters.add(new TParameter<>("ToDate", saleBonusHeader.getToDate()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("YearID", saleBonusHeader.getYearID()));
        tParameters.add(new TParameter<>("ComputBy", saleBonusHeader.getComputBy()));
        tParameters.add(new TParameter<>("ComputType", saleBonusHeader.getComputType()));
        tParameters.add(new TParameter<>("GoodsGroupID", saleBonusHeader.getGoodsGroupID()));
        tParameters.add(new TParameter<>("ClassCustomerID", saleBonusHeader.getClassCustomer()));
        tParameters.add(new TParameter<>("AllocateID", saleBonusHeader.getAllocatedID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("ElementID", saleBonusHeader.getElementID()));
        tParameters.add(new TParameter<>("IsCountOnly", saleBonusHeader.getIsCountOnly()));
        tParameters.add(new TParameter<>("IsContinued", saleBonusHeader.getIsContinued()));
        tParameters.add(new TParameter<>("IsBySecUnit", saleBonusHeader.getIsBySecUnit()));
        tParameters.add(new TParameter<>("PromotionType", saleBonusHeader.getPromotionType()));
        tParameters.add(new TParameter<>("IsPromotion", saleBonusHeader.getIsPromotion()));
        tParameters.add(new TParameter<>("IsMonthPromotion", saleBonusHeader.getIsMonthPromotion()));
        tParameters.add(new TParameter<>("MonthPRMType", saleBonusHeader.getMonthRPMType()));
        tParameters.add(new TParameter<>("MarketingManIDs", saleBonusHeader.getMarketingManIDs()));
        tParameters.add(new TParameter<>("VoucherTypeIDs", saleBonusHeader.getVoucherTypeIDs()));
        tParameters.add(new TParameter<>("IsSingleCalc", saleBonusHeader.getIsSingleCalc()));
        tParameters.add(new TParameter<>("PaymentWayIDs", saleBonusHeader.getPaymentWayIDs()));
        tParameters.add(new TParameter<>("SaleTypeID", saleBonusHeader.getSaleTypeID()));
        //
        BigDecimal newID = insSP("SaleInsBonusHeader", tParameters);
        //
        return saleShowBonusHeaderByID(newID);
    }

    default SaleBonusHeader saleUpdBonusHeader(BigDecimal voucherHeaderID, SaleBonusHeader saleBonusHeader) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("VoucherNumber", saleBonusHeader.getVoucherNumber()));
        tParameters.add(new TParameter<>("VoucherDate", saleBonusHeader.getVoucherDate()));
        tParameters.add(new TParameter<>("VoucherDesc", saleBonusHeader.getVoucherDesc()));
        tParameters.add(new TParameter<>("FromDate", saleBonusHeader.getFromDate()));
        tParameters.add(new TParameter<>("ToDate", saleBonusHeader.getToDate()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("YearID", saleBonusHeader.getYearID()));
        tParameters.add(new TParameter<>("ComputBy", saleBonusHeader.getComputBy()));
        tParameters.add(new TParameter<>("ComputType", saleBonusHeader.getComputType()));
        tParameters.add(new TParameter<>("GoodsGroupID", saleBonusHeader.getGoodsGroupID()));
        tParameters.add(new TParameter<>("ClassCustomerID", saleBonusHeader.getClassCustomer()));
        tParameters.add(new TParameter<>("AllocateID", saleBonusHeader.getAllocatedID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("ElementID", saleBonusHeader.getElementID()));
        tParameters.add(new TParameter<>("IsCountOnly", saleBonusHeader.getIsCountOnly()));
        tParameters.add(new TParameter<>("IsContinued", saleBonusHeader.getIsContinued()));
        tParameters.add(new TParameter<>("IsBySecUnit", saleBonusHeader.getIsBySecUnit()));
        tParameters.add(new TParameter<>("IsPromotion", saleBonusHeader.getIsPromotion()));
        tParameters.add(new TParameter<>("PromotionType", saleBonusHeader.getPromotionType()));
        tParameters.add(new TParameter<>("IsMonthPromotion", saleBonusHeader.getIsMonthPromotion()));
        tParameters.add(new TParameter<>("MonthPRMType", saleBonusHeader.getMonthRPMType()));
        tParameters.add(new TParameter<>("MarketingManIDs", saleBonusHeader.getMarketingManIDs()));
        tParameters.add(new TParameter<>("VoucherTypeIDs", saleBonusHeader.getVoucherTypeIDs()));
        tParameters.add(new TParameter<>("IsSingleCalc", saleBonusHeader.getIsSingleCalc()));
        tParameters.add(new TParameter<>("PaymentWayIDs", saleBonusHeader.getPaymentWayIDs()));
        tParameters.add(new TParameter<>("SaleTypeID", saleBonusHeader.getSaleTypeID()));
        //
        updSP("SaleUpdBonusHeader", tParameters);
        //
        return saleShowBonusHeaderByID(voucherHeaderID);
    }

    default void saleDelBonusHeader(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        delSP("SaleDelBonusHeader", tParameters);
    }


    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        //
        cols.add(new Col(null, "voucherHeaderID", "voucherHeaderID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "voucherNumber", "شماره سند", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "voucherDate", "تاریخ سند", Type.STRING, 130, true, true, false));
        cols.add(new Col(null, "voucherDesc", "توضیحات", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "fromDate", "تاریخ موثر", Type.STRING, 120, true, true, false));
        cols.add(new Col(null, "toDate", "تاریخ اعتبار", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 120, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "yearID", "yearID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "computBy", "creatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "computType", "creatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "goodsGroupID", "goodsGroupID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "groupDesc", "گروه کالا", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "classCustomerID", "classCustomerID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "classCustomer", "طبقه مشتری", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "allocatedID", "allocatedID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "classLocate", "منطقه جغرافیایی", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "computTypeDesc", "نحوه محاسبه", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "computByDesc", "مبنای محاسبه", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "elementID", "elementID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "elementDesc", "نوع محاسبه|عامل", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "isCountOnly", "جایره تعدادی", Type.BOOLEAN, 100, false, false, false));
        cols.add(new Col(null, "isContinued", "محاسبه بصورت تصاعدی", Type.BOOLEAN, 100, false, false, false));
        cols.add(new Col(null, "isBySecUnit", "محاسبه بر اساس واحد فرعی", Type.BOOLEAN, 100, false, false, false));
        cols.add(new Col(null, "isPromotion", "محاسبه کل فاکتور (سبد کالا)", Type.BOOLEAN, 100, false, false, false));
        cols.add(new Col(null, "promotionType", "creatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "promotionTypeDesc", "نوع محاسبه|نوع انتخاب سند", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "isMonthPromotion", "محاسبه دوره ای|فعال", Type.BOOLEAN, 100, false, false, false));
        cols.add(new Col(null, "monthPRMType", "creatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "monthPRMTypeDesc", "محاسبه دوره ای|براساس", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "marketingManIDs", "marketingManIDs", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "voucherTypeIDs", "voucherTypeIDs", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "marketingManNames", "بازاریابان", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "voucherTypeDescs", "انواع سند", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "isSingleCalc", "محاسبه تک مرحله ای", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "paymentIDs", "creatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "saleTypeID", "saleTypeID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "saleTypeCode", "نوع فروش|کد", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "SaleTypeDesc", "نوع فروش|شرح", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "paymentwayDescs", "شرایط پرداخت", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "paymentwayIDs", "paymentwayIDs", Type.STRING, 100, false, false, false));
        //
        return new Meta(cols);
    }
}
