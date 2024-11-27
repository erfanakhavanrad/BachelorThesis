package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.sale.SaleVoucherHeaderShop;
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
public interface SaleVoucherHeaderShopRepository extends TCrudRepository<SaleVoucherHeaderShop>, CrudRepository<SaleVoucherHeaderShop, BigDecimal> {

    default List<SaleVoucherHeaderShop> saleShowVoucherHeaderShop(SaleVoucherHeaderShop saleVoucherHeaderShop, BigDecimal recCnt, BigDecimal pageNo, Boolean isPaging, Boolean isList) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", saleVoucherHeaderShop._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", saleVoucherHeaderShop._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("YearID", saleVoucherHeaderShop.getYearID()));
        tParameters.add(new TParameter<>("RecCnt", recCnt));
        tParameters.add(new TParameter<>("PageNo", pageNo));
        tParameters.add(new TParameter<>("IsPaging", isPaging));
        tParameters.add(new TParameter<>("IsList", isList));
        tParameters.add(new TParameter<>("PageFilter", saleVoucherHeaderShop._pageFilter()));
        return showSP("SaleShowVoucherHeader_Shop", tParameters, true);
    }

    default SaleVoucherHeaderShop saleShowVoucherHeaderShopByID(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", "And Main.VoucherHeaderID=" + voucherHeaderID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("YearID", null));
        tParameters.add(new TParameter<>("RecCnt", null));
        tParameters.add(new TParameter<>("PageNo", null));
        tParameters.add(new TParameter<>("IsPaging", null));
        tParameters.add(new TParameter<>("IsList", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("SaleShowVoucherHeader_Shop", tParameters, true).get(0);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "voucherHeaderID", "VoucherHeaderID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "voucherNumber", "سند|شماره", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "voucherDate", "سند|تاریخ", Type.STRING, 130, true, true, false));
        cols.add(new Col(null, "voucherTime", "سند|زمان ثبت", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "voucherDateG", "نام لاتین بانک", Type.DATE, 120, true, true, false));
        cols.add(new Col(null, "customerID", "modifyDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "storeID", "StoreID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "createDate", "CreateDate", Type.DATE, 120, false, false, false));
        cols.add(new Col(null, "creatorID", "CreatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "modifyDate", "ModifyDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "modifierID", "ModifierID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "serverID", "ServerID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "yearID", "YearID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "saleCenterID", "SaleCenterID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "deliverCenterID", "DeliverCenterID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "customerCode", "مشتری|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "customerName", "مشتری|عنوان", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "perComFName", "creatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "perComLName", "creatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "storeCode", "انبار|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "storeName", "انبار|شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "saleCenterDesc", "مرکز فروش", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "deliverCenterDesc", "محل تحویل", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "voucherTypeID", "VoucherTypeID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "voucherTypeDesc", "VoucherTypeDesc", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "saleTypeDesc", "نوع فروش|عنوان", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "currencyName", "نوع ارز", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "currencyID", "CurrencyID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "saleTypeID", "SaleTypeID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "paymentWayID", "PaymentWayID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "voucherStatID", "VoucherStatID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "voucherStatDesc", "وضعیت سند", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "creatorName", "تنظیم کننده", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "paymentwayType", "PaymentwayType", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "paymentwayDesc", "شرایط پرداخت", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "customVTypeDesc", "نوع سند", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "accID", "AccID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "serverDesc", "محل صدور", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "accNumber", "سند|شماره سند حسابداری", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "accSerialCode", "AccSerialCode", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "percomAddress", "مشتری|آدرس", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "percomMobile", "مشتری|موبایل", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "perComTel", "مشتری|تلفن", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "isCurrency", "IsCurrency", Type.BOOLEAN, 100, false, false, false));
        cols.add(new Col(null, "salesManName", "فروشنده|عنوان", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "marketingManName", "بازاریاب|نام", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "salesManCode", "فروشنده|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "marketingManCode", "بازاریاب|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "center1Code", "سطح 5|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "center1Desc", "سطح 5|شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "center2Code", "سطح 6|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "center2Desc", "سطح 6|شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "center3Code", "سطح 7|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "center3Desc", "سطح 7|شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "secondNumber", "SecondNumber", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "referNumber", "ReferNumber", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "referDate", "ReferDate", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "rowID", "rowID", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "sexID", "sexID", Type.BOOLEAN, 100, false, false, false));
        cols.add(new Col(null, "percomTitle", "percomTitle", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "percomTypeID", "percomTypeID", Type.INTEGER, 100, false, false, false));
        cols.add(new Col(null, "distNameID", "distNameID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "distName", "distName", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "printCount", "printCount", Type.INTEGER, 100, false, false, false));
        cols.add(new Col(null, "otherPrintCount", "otherPrintCount", Type.INTEGER, 100, false, false, false));
        cols.add(new Col(null, "goodsDesc", "کالاها|شرح", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "goodsCode", "کالاها|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "voucherDesc", "voucherDesc", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "tableID", "tableID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "tableCode", "tableCode", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "tableName", "tableName", Type.STRING, 100, false, false, false));
        return new Meta(cols);
    }
}
