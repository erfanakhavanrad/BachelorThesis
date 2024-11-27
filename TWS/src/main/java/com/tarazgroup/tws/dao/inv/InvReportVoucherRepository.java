package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvReportVoucher;
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
public interface InvReportVoucherRepository extends TCrudRepository<InvReportVoucher>, CrudRepository<InvReportVoucher, BigDecimal> {
    default List<InvReportVoucher> invShowReportVoucher(InvReportVoucher invReportVoucher) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invReportVoucher._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invReportVoucher._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", invReportVoucher._pageFilter()));
        tParameters.add(new TParameter<>("UserID", null));
        return showSP("InvReport_Voucher", tParameters, true);
    }

    default InvReportVoucher invShowReportVoucherByID(BigDecimal voucherDetailID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " And Det.VoucherDetailID= " + voucherDetailID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        tParameters.add(new TParameter<>("UserID", null));
        return showSP("InvReport_Voucher", tParameters, true).get(0);
    }


    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "voucherDetailID", "voucherDetailID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "voucherTypeID", "voucherTypeID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "detailXDesc", "شرح ردیف", Type.STRING, 130, true, true, false));
        cols.add(new Col(null, "fee", "فی", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "feeTest", "فی آزمایشی|فی", Type.DECIMAL, 120, true, true, false));
        cols.add(new Col(null, "quantity", "مقدار", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "computeValue", "ضریب واحد فرعی", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "goodsID", "goodsID", Type.DECIMAL, 120, false, false, false));
        cols.add(new Col(null, "voucherDate", "شماره سند", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "voucherNumber", "شماره سند", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "storeID", "storeID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "toStoreID", "toStoreID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "serialType", "serialType", Type.INTEGER, 100, false, false, false));
        cols.add(new Col(null, "serialDesc", "serialDesc", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "serverDesc", "serverDesc", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "tafsiliID", "tafsiliID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "tafsiliCode", "کد تفصیلی", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "tafsiliDesc", "طرف مقابل", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "storeCode", "انبار|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "storeName", "انبار|شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "voucherHeaderID", "voucherHeaderID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "toStoreCode", "انبار تحویل گیرنده|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "toStoreName", "انبار تحویل گیرنده|شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "rowPrice", "مبلغ", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "creatorName", "تنظیم کننده", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "controllerName", "controllerName", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "voucherStatID", "voucherStatID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "voucherStatDesc", "وضعیت سند", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "goodsCode", "کالا|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "techInfo", "کالا|مشخصات فنی", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "barCode", "کالا|بارکد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "goodsDesc", "کالا|شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "latinDesc", "کالا|شرح لاتین", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "dReferDate", "تاریخ عطف", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "dReferNumber", "شماره عطف", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "unitName", "واحد کالا", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "voucherDesc", "توضیحات سند", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "voucherTypeDesc", "نوع سند", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "refTypeDesc", "نوع مرجع", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "accNumber", "سند حسابداری|شماره", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "accDate", "سند حسابداری|تاریخ", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "customField1", "آلایش(جگر و سنگدان)", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "customField2", "ورود - تعداد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "customField3", "تعداد تلفات", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "customField4", "وزن تلفات", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "customField5", "تعداد ضبطی دامپزشک", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "customField6", "تعداد ضبطی دامپزشک", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "customField7", "customField7", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "customField8", "customField8", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "customField9", "customField9", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "customField10", "customField10", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "customField11", "customField11", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "customField12", "customField12", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "customField13", "customField13", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "customField14", "customField14", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "customField15", "customField15", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "customField16", "customField16", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "customField17", "customField17", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "customField18", "customField18", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "customField19", "customField19", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "customField20", "customField20", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "customField21", "customField21", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "customField22", "customField22", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "customField23", "customField23", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "customField24", "customField24", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "customField25", "customField25", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "feeAgreement", "فی برآوردی", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "feeDiscountPrice", "تخفیف نقدی", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "feeDiscountPercent", "تخفیف درصدی", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "feeFrieghtCharges", "تخفیف درصدی", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "lCReferID", "lCReferID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "lCNo", "اعتبار|شماره گشایش", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "lCOpenDate", "اعتبار|تاریخ گشایش", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "greenLicNo", "اعتبار|شماره پروانه سبز", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "kootajNo", "اعتبار|شماره کوتاژ", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "greenLicDate", "اعتبار|تاریخ صدور پروانه سبز", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "lCDisChargCode", "گمرک مقصد|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "lCDisChargDesc", "گمرک مقصد|شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "isBasket", "سبد کالا", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "agrReferID", "agrReferID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "agrNo", "قرارداد|شماره سند", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "agrIndicatorNo", "قرارداد|شماره اندیکاتور", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "importExport", "importExport", Type.INTEGER, 100, false, false, false));
        cols.add(new Col(null, "center1Code", "سطح 5|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "center2Code", "سطح 6|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "center3Code", "سطح 7|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "center1Desc", "سطح 5|شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "center2Desc", "سطح 6|شرح", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "center3Desc", "سطح 7|شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "quantity2", "واحد فرعی 2|مقدار", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "quantity3", "واحد فرعی 3|مقدار", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "ratio2", "واحد فرعی 2|نسبت", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "ratio3", "واحد فرعی 3|نسبت", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "secUnitName2", "واحد فرعی 2|عنوان", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "secUnitName3", "واحد فرعی 3|عنوان", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "groupCode", "گروه کالا|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "groupDesc", "گروه کالا|شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "tagValue", "tagValue", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "referNumber", "شماره عطف", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "referDate", "تاریخ عطف", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "feeNew", "اصلاحی|فی", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "priceMain", "اصلی|ریال", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "priceEdited", "اصلاحی|ریال", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "priceTest", "فی آزمایشی|مبلغ", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "priceExcept", "تفاوت فی اصلی و اصلاحی", Type.DECIMAL, 100, true, true, false));
        return new Meta(cols);
    }
}
