package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SalePercentHeader;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Salehi
 */
public interface SalePercentHeaderRepository extends TCrudRepository<SalePercentHeader>, CrudRepository<SalePercentHeader, BigDecimal> {

    default List<SalePercentHeader> saleShowPercentHeader(SalePercentHeader salePercentHeader) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", salePercentHeader._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", salePercentHeader._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        // TODO در این اس پی باید پیج فیلتر اضافه شود
        //
        return showSP("SaleShowPercentHeader", tParameters, true);
    }

    default SalePercentHeader saleShowPercentHeaderByID(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", "And Main.VoucherHeaderID =" + voucherHeaderID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        //
        return showSP("SaleShowPercentHeader", tParameters, true).get(0);
    }

    default SalePercentHeader saleInsPercentHeader(SalePercentHeader salePercentHeader) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("VoucherNumber", salePercentHeader.getVoucherNumber()));
        tParameters.add(new TParameter<>("VoucherDate", salePercentHeader.getVoucherDate()));
        tParameters.add(new TParameter<>("VoucherDesc", salePercentHeader.getVoucherDesc()));
        tParameters.add(new TParameter<>("FromDate", salePercentHeader.getFromDate()));
        tParameters.add(new TParameter<>("ToDate", salePercentHeader.getToDate()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("YearID", salePercentHeader.getYearID()));
        tParameters.add(new TParameter<>("ComputBy", salePercentHeader.getComputBy()));
        tParameters.add(new TParameter<>("ComputType", salePercentHeader.getComputType()));
        tParameters.add(new TParameter<>("MarketingManIDs", salePercentHeader.getMarketingManIDs()));
        tParameters.add(new TParameter<>("GoodsGroupID", salePercentHeader.getGoodsGroupID()));
        tParameters.add(new TParameter<>("ClassCustomerID", salePercentHeader.getClassCustomerID()));
        tParameters.add(new TParameter<>("AllocateID", salePercentHeader.getAllocateID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsContinued", salePercentHeader.getIsContinued()));
        tParameters.add(new TParameter<>("IsBySecUnit", salePercentHeader.getIsBySecUnit()));
        //
        BigDecimal newID = insSP("SaleInsPercentHeader", tParameters);
        //
        return saleShowPercentHeaderByID(newID);
    }

    default SalePercentHeader saleUpdPercentHeader(BigDecimal voucherHeaderID, SalePercentHeader salePercentHeader) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("VoucherNumber", salePercentHeader.getVoucherNumber()));
        tParameters.add(new TParameter<>("VoucherDate", salePercentHeader.getVoucherDate()));
        tParameters.add(new TParameter<>("VoucherDesc", salePercentHeader.getVoucherDesc()));
        tParameters.add(new TParameter<>("FromDate", salePercentHeader.getFromDate()));
        tParameters.add(new TParameter<>("ToDate", salePercentHeader.getToDate()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("YearID", salePercentHeader.getYearID()));
        tParameters.add(new TParameter<>("ComputBy", salePercentHeader.getComputBy()));
        tParameters.add(new TParameter<>("ComputType", salePercentHeader.getComputType()));
        tParameters.add(new TParameter<>("MarketingManIDs", salePercentHeader.getMarketingManIDs()));
        tParameters.add(new TParameter<>("GoodsGroupID", salePercentHeader.getGoodsGroupID()));
        tParameters.add(new TParameter<>("ClassCustomerID", salePercentHeader.getClassCustomerID()));
        tParameters.add(new TParameter<>("AllocateID", salePercentHeader.getAllocateID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsContinued", salePercentHeader.getIsContinued()));
        tParameters.add(new TParameter<>("IsBySecUnit", salePercentHeader.getIsBySecUnit()));
        //
        updSP("SaleUpdPercentHeader", tParameters);
        //
        return saleShowPercentHeaderByID(voucherHeaderID);
    }

    default void saleDelPercentHeader(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        delSP("SaleDelPercentHeader", tParameters);
    }

    //TODO منوی پورسانت بازاریاب بررسی شود
//    default Meta meta() {
//        ArrayList<Col> cols = new ArrayList<>();
//        //
//        cols.add(new Col(null, "voucherHeaderID", "voucherHeaderID", Type.DECIMAL, 0, false, false, true));
//        cols.add(new Col(null, "voucherNumber", "شماره سند", Type.DECIMAL, 100, true, true, false));
//        cols.add(new Col(null, "voucherDate", "تاریخ سند", Type.STRING, 130, true, true, false));
//        cols.add(new Col(null, "voucherDesc", "توضیحات", Type.STRING, 100, true, true, false));
//        cols.add(new Col(null, "fromDate", "تاریخ موثر", Type.STRING, 120, true, true, false));
//        cols.add(new Col(null, "toDate", "تاریخ اعتبار", Type.DATE, 100, true, true, false));
//        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 100, false, false, false));
//        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 120, false, false, false));
//        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, false, false, false));
//        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 100, false, false, false));
//        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 100, false, false, false));
//        cols.add(new Col(null, "yearID", "yearID", Type.DECIMAL, 100, false, false, false));
//        cols.add(new Col(null, "computBy", "creatorID", Type.DECIMAL, 100, false, false, false));
//        cols.add(new Col(null, "computType", "creatorID", Type.DECIMAL, 100, false, false, false));
//        cols.add(new Col(null, "marketingManIDs", "marketingManIDs", Type.STRING, 100, false, false, false));
//        cols.add(new Col(null, "marketingManNames", "بازاریاب(ها)", Type.STRING, 100, false, false, false));
//        cols.add(new Col(null, "goodsGroupID", "goodsGroupID", Type.DECIMAL, 100, false, false, false));
//        cols.add(new Col(null, "groupDesc", "گروه کالا", Type.STRING, 100, true, true, false));
//        cols.add(new Col(null, "classCustomerID", "classCustomerID", Type.DECIMAL, 100, false, false, false));
//        cols.add(new Col(null, "classCustomer", "طبقه مشتری", Type.DECIMAL, 100, false, false, false));
//        cols.add(new Col(null, "allocateID", "allocateID", Type.DECIMAL, 100, false, false, false));
//        cols.add(new Col(null, "classLocate", "منطقه جغرافیایی", Type.STRING, 100, true, true, false));
//        cols.add(new Col(null, "computTypeDesc", "نوع محاسبه", Type.STRING, 100, true, true, false));
//        cols.add(new Col(null, "computByDesc", "محاسبه براساس", Type.STRING, 100, true, true, false));
//        cols.add(new Col(null, "isContinued", "creatorID", Type.DECIMAL, 100, false, false, false));
//        cols.add(new Col(null, "isContinuedDesc", "نحوه محاسبه پورسانت", Type.STRING, 100, true, true, false));
//        cols.add(new Col(null, "isBySecUnit", "isBySecUnit", Type.BOOLEAN, 100, false, false, false));
//        //
//        return new Meta(cols);
//    }

}
