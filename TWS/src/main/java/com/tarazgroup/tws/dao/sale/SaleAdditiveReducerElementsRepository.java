package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleAdditiveReducerElements;
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

public interface SaleAdditiveReducerElementsRepository extends TCrudRepository<SaleAdditiveReducerElements>, CrudRepository<SaleAdditiveReducerElements, BigDecimal> {

    default List<SaleAdditiveReducerElements> saleShowAdditiveReducerElements(SaleAdditiveReducerElements saleAdditiveReducerElements) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", saleAdditiveReducerElements._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", saleAdditiveReducerElements._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        // TODO در این اس پی باید پیج فیلتر اضافه شود
        //
        return showSP("SaleShowAdditiveReducerElements", tParameters, true);
    }

    default SaleAdditiveReducerElements saleShowAdditiveReducerElementsByID(BigDecimal elementID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", "And Main.ElementID=" + elementID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        //
        return showSP("SaleShowAdditiveReducerElements", tParameters, true).get(0);
    }

    default SaleAdditiveReducerElements saleInsAdditiveReducerElements(SaleAdditiveReducerElements saleAdditiveReducerElements) {
        //
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("ElementDesc", saleAdditiveReducerElements.getElementDesc()));
        tParameters.add(new TParameter<>("ElementType", saleAdditiveReducerElements.getElementType()));
        tParameters.add(new TParameter<>("ComputeType", saleAdditiveReducerElements.getComputeType()));
        tParameters.add(new TParameter<>("BedAccountID", saleAdditiveReducerElements.getBedAccountID()));
        tParameters.add(new TParameter<>("BedTafsiliID", saleAdditiveReducerElements.getBedTafsiliID()));
        tParameters.add(new TParameter<>("BedTafsiliTypeID", saleAdditiveReducerElements.getBedTafsiliTypeID()));
        tParameters.add(new TParameter<>("BedCenter1TypeID", saleAdditiveReducerElements.getBedCenter1TypeID()));
        tParameters.add(new TParameter<>("BedCenter2TypeID", saleAdditiveReducerElements.getBedCenter2TypeID()));
        tParameters.add(new TParameter<>("BedCenter3TypeID", null));//این مقدار در اس پی Show وجود نداشت
        tParameters.add(new TParameter<>("SystemID", null));//از این مقدار در اس پی استفاده نشده بود
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ProrityLevel", saleAdditiveReducerElements.getProrityLevel()));
        tParameters.add(new TParameter<>("BesAccountID", saleAdditiveReducerElements.getBesAccountID()));
        tParameters.add(new TParameter<>("BesTafsiliID", saleAdditiveReducerElements.getBesTafsiliID()));
        tParameters.add(new TParameter<>("BesTafsiliTypeID", saleAdditiveReducerElements.getBesTafsiliTypeID()));
        tParameters.add(new TParameter<>("BesCenter1TypeID", saleAdditiveReducerElements.getBesCenter1TypeID()));
        tParameters.add(new TParameter<>("BesCenter2TypeID", saleAdditiveReducerElements.getBesCenter2TypeID()));
        tParameters.add(new TParameter<>("BesCenter3TypeID", null)); //از این مقدار در اس پی Show استفاده نشده بود
        tParameters.add(new TParameter<>("ComputeToNow", saleAdditiveReducerElements.getComputeToNow()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("isBed", saleAdditiveReducerElements.getIsBed()));
        tParameters.add(new TParameter<>("isBes", saleAdditiveReducerElements.getIsBes()));
        tParameters.add(new TParameter<>("GroupElementID", saleAdditiveReducerElements.getGroupElementID()));
        tParameters.add(new TParameter<>("GroupElementDesc", saleAdditiveReducerElements.getGroupElementDesc()));
        tParameters.add(new TParameter<>("IsTax", saleAdditiveReducerElements.getIsTax()));
        tParameters.add(new TParameter<>("IsToll", saleAdditiveReducerElements.getIsToll()));
        tParameters.add(new TParameter<>("IsBedAccount", saleAdditiveReducerElements.getIsBedAccount()));
        tParameters.add(new TParameter<>("IsBesAccount", saleAdditiveReducerElements.getIsBesAccount()));
        tParameters.add(new TParameter<>("IsBedAccount", saleAdditiveReducerElements.getIsBedAccount()));
        tParameters.add(new TParameter<>("BedVoucherDesc", saleAdditiveReducerElements.getBedVoucherDesc()));
        tParameters.add(new TParameter<>("BesVoucherDesc", saleAdditiveReducerElements.getBesVoucherDesc()));
        tParameters.add(new TParameter<>("IsNotActiveInNetRep", saleAdditiveReducerElements.getIsNotActiveInNetRep()));
        tParameters.add(new TParameter<>("BedTypes", saleAdditiveReducerElements.getBedTypes()));
        tParameters.add(new TParameter<>("BesTypes", saleAdditiveReducerElements.getBedTypes()));
        tParameters.add(new TParameter<>("SysID", saleAdditiveReducerElements.getSystemID()));
        tParameters.add(new TParameter<>("IsForSale", saleAdditiveReducerElements.getIsForSale()));
        tParameters.add(new TParameter<>("ElementUseType", saleAdditiveReducerElements.getElementUseType()));
        tParameters.add(new TParameter<>("IsRound", saleAdditiveReducerElements.getIsRound()));
        tParameters.add(new TParameter<>("RoundDigit", saleAdditiveReducerElements.getRoundDigit()));
        //
        BigDecimal newID = insSP("SaleInsAdditiveReducerElements", tParameters);
        //
        return saleShowAdditiveReducerElementsByID(newID);
    }

    default SaleAdditiveReducerElements saleUpdAdditiveReducerElements(BigDecimal elementID, SaleAdditiveReducerElements saleAdditiveReducerElements) {
        //
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("ElementID", elementID));
        tParameters.add(new TParameter<>("ElementDesc", saleAdditiveReducerElements.getElementDesc()));
        tParameters.add(new TParameter<>("ElementType", saleAdditiveReducerElements.getElementType()));
        tParameters.add(new TParameter<>("ComputeType", saleAdditiveReducerElements.getComputeType()));
        tParameters.add(new TParameter<>("BedAccountID", saleAdditiveReducerElements.getBedAccountID()));
        tParameters.add(new TParameter<>("BedTafsiliID", saleAdditiveReducerElements.getBedTafsiliID()));
        tParameters.add(new TParameter<>("BedTafsiliTypeID", saleAdditiveReducerElements.getBedTafsiliTypeID()));
        tParameters.add(new TParameter<>("BedCenter1TypeID", saleAdditiveReducerElements.getBedCenter1TypeID()));
        tParameters.add(new TParameter<>("BedCenter2TypeID", saleAdditiveReducerElements.getBedCenter2TypeID()));
        tParameters.add(new TParameter<>("BedCenter3TypeID", null));//این مقدار در اس پی Show وجود نداشت
        tParameters.add(new TParameter<>("SystemID", null));//از این مقدار در اس پی استفاده  نشده بود
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ProrityLevel", saleAdditiveReducerElements.getProrityLevel()));
        tParameters.add(new TParameter<>("BesAccountID", saleAdditiveReducerElements.getBesAccountID()));
        tParameters.add(new TParameter<>("BesTafsiliID", saleAdditiveReducerElements.getBesTafsiliID()));
        tParameters.add(new TParameter<>("BesTafsiliTypeID", saleAdditiveReducerElements.getBesTafsiliTypeID()));
        tParameters.add(new TParameter<>("BesCenter1TypeID", saleAdditiveReducerElements.getBesCenter1TypeID()));
        tParameters.add(new TParameter<>("BesCenter2TypeID", saleAdditiveReducerElements.getBesCenter2TypeID()));
        tParameters.add(new TParameter<>("BesCenter3TypeID", null)); //از این مقدار در اس پی Show استفاده نشده بود
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("isBed", saleAdditiveReducerElements.getIsBed()));
        tParameters.add(new TParameter<>("isBes", saleAdditiveReducerElements.getIsBes()));
        tParameters.add(new TParameter<>("ComputeToNow", saleAdditiveReducerElements.getComputeToNow()));
        tParameters.add(new TParameter<>("GroupElementID", saleAdditiveReducerElements.getGroupElementID()));
        tParameters.add(new TParameter<>("GroupElementDesc", saleAdditiveReducerElements.getGroupElementDesc()));
        tParameters.add(new TParameter<>("IsTax", saleAdditiveReducerElements.getIsTax()));
        tParameters.add(new TParameter<>("IsToll", saleAdditiveReducerElements.getIsToll()));
        tParameters.add(new TParameter<>("IsBedAccount", saleAdditiveReducerElements.getIsBedAccount()));
        tParameters.add(new TParameter<>("IsBesAccount", saleAdditiveReducerElements.getIsBesAccount()));
        tParameters.add(new TParameter<>("IsBedAccount", saleAdditiveReducerElements.getIsBedAccount()));
        tParameters.add(new TParameter<>("BedVoucherDesc", saleAdditiveReducerElements.getBedVoucherDesc()));
        tParameters.add(new TParameter<>("BesVoucherDesc", saleAdditiveReducerElements.getBesVoucherDesc()));
        tParameters.add(new TParameter<>("IsNotActiveInNetRep", saleAdditiveReducerElements.getIsNotActiveInNetRep()));
        tParameters.add(new TParameter<>("BedTypes", saleAdditiveReducerElements.getBedTypes()));
        tParameters.add(new TParameter<>("BesTypes", saleAdditiveReducerElements.getBesTypes()));
        tParameters.add(new TParameter<>("SysID", saleAdditiveReducerElements.getSystemID()));
        tParameters.add(new TParameter<>("IsForSale", saleAdditiveReducerElements.getIsForSale()));
        tParameters.add(new TParameter<>("ElementUseType", saleAdditiveReducerElements.getElementUseType()));
        tParameters.add(new TParameter<>("IsRound", saleAdditiveReducerElements.getIsRound()));
        tParameters.add(new TParameter<>("RoundDigit", saleAdditiveReducerElements.getRoundDigit()));
        //
        updSP("SaleUpdAdditiveReducerElements", tParameters);
        //
        return saleShowAdditiveReducerElementsByID(elementID);
    }

    default void saleDelAdditiveReducerElements(BigDecimal elementID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("ElementID", elementID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        delSP("SaleDelAdditiveReducerElements", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        //
        cols.add(new Col(null, "valueID", "valueID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "elementDesc", "عامل|عنوان", Type.STRING, 126, true, false, false));
        cols.add(new Col(null, "groupElementID", "عامل|گروه", Type.DECIMAL, 120, true, true, false));
        cols.add(new Col(null, "groupElementDesc", "عامل|عنوان گروه", Type.STRING, 120, true, true, false));
        cols.add(new Col(null, "elementTypeDesc", "نوع", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "computeTypeDesc", "نحوه محاسبه", Type.STRING, 120, true, true, false));
        cols.add(new Col(null, "computeToNowDesc", "ماهیت محاسبه", Type.STRING, 100, false, true, false));
        cols.add(new Col(null, "elementUseTypeDesc", "ماهیت عامل", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "prorityLevel", "اولویت محاسبه", Type.STRING, 120, true, false, false));
        cols.add(new Col(null, "isTax", "مالیات", Type.BOOLEAN, 100, true, false, false));
        cols.add(new Col(null, "isToll", "عوارض", Type.BOOLEAN, 100, true, false, false));
        cols.add(new Col(null, "isNotActiveInNetRep", "خنثی", Type.BOOLEAN, 100, true, false, false));
        cols.add(new Col(null, "isBed", "فعال بودن حساب|بدهکار", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "isBes", "فعال بودن حساب|بستانکار", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "bedAccountCode", "معین بدهکار|کد", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "bedAccountDesc", "معین بدهکار|شرح", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "besAccountCode", "معین بستانکار|کد", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "besAccountDesc", "معین بستانکار|شرح", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "bedTafsiliCode", "تفصیلی بدهکار|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "bedTafsiliDesc", "تفصیلی بدهکار|شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "besTafsiliCode", "تفصیلی بستانکار|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "besTafsiliDesc", "تفصیلی بستانکار|شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "bedTafsiliTypeDesc", "گروه تفصیلی|بدهکار", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "besTafsiliTypeDesc", "گروه تفصیلی|بستانکار", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "bedCenter1TypeDesc", "سطح ۵ |بدهکار", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "besCenter1TypeDesc", "سطح ۵ | بستانکار", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "bedCenter2TypeDesc", "سطح ۶|بدهکار", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "besCenter2TypeDesc", "سطح ۶|بستانکار", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "bedCenter3TypeDesc", "سطح ۷|بدهکار", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "besCenter3TypeDesc", "سطح ۷|بستانکار", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "isBedAccount", "دریافت اطلاعات از سرفصل صدور سند|بدهکار", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "isBesAccount", "دریافت اطلاعات از سرفصل صدور سند|بستانکار", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "bedVoucherDesc", "شرح سند|بدهکار", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "besVoucherDesc", "شرح سند|بستانکار", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "isForSale", "دریافت بابت فاکتور", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "isRound", "تخفیف روند|فعال", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "roundDigit", "تخفیف روند|ارقام روند", Type.INTEGER, 100, true, true, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, false, true, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 100, false, true, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 100, false, true, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 100, false, true, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 100, false, true, false));
        cols.add(new Col(null, "systemID", "systemID", Type.DECIMAL, 100, false, true, false));
        cols.add(new Col(null, "bedAccountID", "bedAccountID", Type.DECIMAL, 100, false, true, false));
        cols.add(new Col(null, "bedTafsiliID", "bedTafsiliID", Type.DECIMAL, 100, false, true, false));
        cols.add(new Col(null, "bedTafsiliTypeID", "bedTafsiliTypeID", Type.DECIMAL, 100, false, true, false));
        cols.add(new Col(null, "bedCenter1TypeID", "bedCenter1TypeID", Type.DECIMAL, 100, false, true, false));
        cols.add(new Col(null, "bedCenter1TypeID", "bedCenter1TypeID", Type.DECIMAL, 100, false, true, false));
        cols.add(new Col(null, "bedCenter2TypeID", "bedCenter2TypeID", Type.DECIMAL, 100, false, true, false));
        cols.add(new Col(null, "besAccountID", "besAccountID", Type.DECIMAL, 100, false, true, false));
        cols.add(new Col(null, "besTafsiliID", "besTafsiliID", Type.DECIMAL, 100, false, true, false));
        cols.add(new Col(null, "besTafsiliTypeID", "besTafsiliTypeID", Type.DECIMAL, 100, false, true, false));
        cols.add(new Col(null, "besCenter1TypeID", "besCenter1TypeID", Type.DECIMAL, 100, false, true, false));
        cols.add(new Col(null, "besCenter2TypeID", "besCenter2TypeID", Type.DECIMAL, 100, false, true, false));
        cols.add(new Col(null, "bedTypes", "bedTypes", Type.STRING, 100, false, true, false));
        cols.add(new Col(null, "besTypes", "besTypes", Type.STRING, 100, false, true, false));
        //
        return new Meta(cols);
    }

}
