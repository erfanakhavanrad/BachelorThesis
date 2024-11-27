package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dto.sale.SaleSurroundingVouchersDto;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleVoucherHeader;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

public interface SaleVoucherHeaderRepository extends TCrudRepository<SaleVoucherHeader>, CrudRepository<SaleVoucherHeader, BigDecimal> {

    default List<SaleVoucherHeader> saleShowVoucherHeader(BigDecimal[] serverIds, BigDecimal[] yearIds, SaleVoucherHeader saleVoucherHeader) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        String serverIdsStr = "";
        String yearIdsStr = "";
        for (BigDecimal serverId : serverIds) {
            serverIdsStr += serverId.toString() + ",";
        }
        serverIdsStr = serverIdsStr.substring(0, serverIdsStr.length() - 1);
        for (BigDecimal yearId : yearIds) {
            yearIdsStr += yearId.toString() + ",";
        }
        yearIdsStr = yearIdsStr.substring(0, yearIdsStr.length() - 1);
        String serverFilter = " AND Main.ServerID IN (" + serverIdsStr + ") AND (Main.ServerID IN (Select ServerID from dbo.PubUsersAccessServer Where UserID = 10000000) OR (1 = 1))";
        String yearFilter = " AND Main.YearID IN (" + yearIdsStr + ")";
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", serverFilter));
        tParameters.add(new TParameter<>("YearFilter", yearFilter));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("ShowRemain", null));
        tParameters.add(new TParameter<>("VoucherTypeID", null));
        tParameters.add(new TParameter<>("RefTypeID", null));
        tParameters.add(new TParameter<>("PageFilter", saleVoucherHeader._pageFilter()));
        return showSP("SaleShowVoucherHeader", tParameters, true);
    }

    default SaleSurroundingVouchersDto saleShowVoucherHeaderSurroundings(BigDecimal currentVoucherHeaderID, BigDecimal[] serverIds, BigDecimal[] yearIds, SaleVoucherHeader saleVoucherHeader) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        String serverIdsStr = "";
        String yearIdsStr = "";
        for (BigDecimal serverId : serverIds) {
            serverIdsStr += serverId.toString() + ",";
        }
        serverIdsStr = serverIdsStr.substring(0, serverIdsStr.length() - 1);
        for (BigDecimal yearId : yearIds) {
            yearIdsStr += yearId.toString() + ",";
        }
        yearIdsStr = yearIdsStr.substring(0, yearIdsStr.length() - 1);
        String serverFilter = " AND Main.ServerID IN (" + serverIdsStr + ") AND (Main.ServerID IN (Select ServerID from dbo.PubUsersAccessServer Where UserID = 10000000) OR (1 = 1))";
        String yearFilter = " AND Main.YearID IN (" + yearIdsStr + ")";
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", serverFilter));
        tParameters.add(new TParameter<>("YearFilter", yearFilter));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("ShowRemain", null));
        tParameters.add(new TParameter<>("VoucherTypeID", null));
        tParameters.add(new TParameter<>("RefTypeID", null));
        tParameters.add(new TParameter<>("PageFilter", saleVoucherHeader._pageFilter()));
        final List<SaleVoucherHeader> saleShowVoucherHeader = showSP("SaleShowVoucherHeader", tParameters, true);

        List<BigDecimal> headersList = new ArrayList<>();
        for (int i = 0; i < saleShowVoucherHeader.size(); i++) {
            headersList.add(saleShowVoucherHeader.get(i).getVoucherHeaderID());
        }

        final int i = headersList.indexOf(currentVoucherHeaderID);

        BigDecimal previous = null, next = null;

        try {
            previous = headersList.get(i - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            next = headersList.get(i + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }


        SaleSurroundingVouchersDto saleSurroundingVouchersDto = new SaleSurroundingVouchersDto();
        saleSurroundingVouchersDto.setCurrentVoucher(currentVoucherHeaderID);
        saleSurroundingVouchersDto.setPreviousVoucher(previous);
        saleSurroundingVouchersDto.setNextVoucher(next);
        return saleSurroundingVouchersDto;

    }

    default List<SaleVoucherHeader> saleShowVoucherHeaderRefer(
            BigDecimal voucherTypeID,
            BigDecimal refTypeID,
            BigDecimal voucherNumber,
            String tafsiliDesc,
            String voucherDate,
            BigDecimal yearID) {
        String pageFilter = "";
        if (voucherNumber != null) {
            pageFilter += " AND VoucherNumber=" + voucherNumber;
        }
        if (tafsiliDesc != null) {
            pageFilter += " AND TafsiliDesc LIKE '%" + tafsiliDesc + "%'";
        }
        if (voucherDate != null) {
            pageFilter += " AND VoucherDate LIKE '%" + voucherDate + "%'";
        }

        pageFilter += "?,";

        String yearFilter = null;
        if (yearID != null) {
            yearFilter = " AND Main.YearID = " + yearID;

        }

        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", " AND LastStat.VoucherStatID = 4 AND Main.VoucherTypeID = " + refTypeID + " AND ISNULL(Main.RefTypeID,0) <> " + voucherTypeID));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", yearFilter));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("ShowRemain", true));
        tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        tParameters.add(new TParameter<>("RefTypeID", refTypeID));
        tParameters.add(new TParameter<>("PageFilter", pageFilter));
        return showSP("SaleShowVoucherHeader", tParameters, true);
    }

    default SaleVoucherHeader saleShowVoucherHeaderByID(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", "  AND Main.VoucherHeaderID = " + voucherHeaderID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("ShowRemain", null));
        tParameters.add(new TParameter<>("VoucherTypeID", null));
        tParameters.add(new TParameter<>("RefTypeID", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("SaleShowVoucherHeader", tParameters, true).get(0);
    }

    default void saleDelVoucher(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("SaleDelVoucherHeader", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "voucherHeaderID", "voucherHeaderID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "voucherTypeID", "voucherTypeID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "yearID", "yearID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "voucherDateG", "voucherDateG", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "vDateG", "vDateG", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "isLCStore", "isLCStore", Type.BOOLEAN, 0, false, false, false));
        cols.add(new Col(null, "perComTitle", "perComTitle", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "customerLatinName", "customerLatinName", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "salesManCode", "salesManCode", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "salesManName", "salesManName", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "marketingManCode", "marketingManCode", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "marketingManName", "marketingManName", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "voucherTypeDesc", "voucherTypeDesc", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "refTypeDesc", "refTypeDesc", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "tafsiliID", "tafsiliID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "saleTypeDesc", "saleTypeDesc", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "currencyName", "currencyName", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "customerClassID", "customerClassID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "salesClassID", "salesClassID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "marketingClassID", "marketingClassID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "lastReciverName", "lastReciverName", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "customVTypeDesc", "customVTypeDesc", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "invNumber", "invNumber", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "invReferID", "invReferID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "accNumber", "accNumber", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "accSerialCode", "accSerialCode", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "center1Code", "center1Code", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "center2Code", "center2Code", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "center3Code", "center3Code", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "center1Desc", "center1Desc", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "center2Desc", "center2Desc", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "center3Desc", "center3Desc", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "customerAddress", "customerAddress", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "percomMobile", "percomMobile", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "perComTel", "perComTel", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "isCurrency", "isCurrency", Type.BOOLEAN, 0, false, false, false));
        cols.add(new Col(null, "isLC", "isLC", Type.BOOLEAN, 0, false, false, false));
        cols.add(new Col(null, "isPayment", "isPayment", Type.BOOLEAN, 0, false, false, false));
        cols.add(new Col(null, "accountCode", "accountCode", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "accountDesc", "accountDesc", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "isEditReferHeader", "isEditReferHeader", Type.BOOLEAN, 0, false, false, false));
        cols.add(new Col(null, "isEditReferDetail", "isEditReferDetail", Type.BOOLEAN, 0, false, false, false));
        cols.add(new Col(null, "refTypeID", "refTypeID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "customerID", "customerID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "storeID", "storeID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "customerTID", "customerTID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "saleCenterID", "saleCenterID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "deliverCenterID", "deliverCenterID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "referNumber", "referNumber", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "referDate", "referDate", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "salesManID", "salesManID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "marketingManID", "marketingManID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "accID", "accID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "currencyID", "currencyID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "extraDesc", "extraDesc", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "orderType", "orderType", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "paymentWayID", "paymentWayID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "secondNumber", "secondNumber", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "referID", "referID", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "center1ID", "center1ID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "center2ID", "center2ID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "centcenter3IDer2ID", "center3ID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "accountID", "accountID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "dayCount", "dayCount", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "cashID", "cashID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "voucherStatID", "voucherStatID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "deliveryDate", "deliveryDate", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "deliveryManID", "deliveryManID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "baseRefTypeID", "baseRefTypeID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "isSettled", "isSettled", Type.BOOLEAN, 0, false, false, false));
        cols.add(new Col(null, "isManualPromotion", "isManualPromotion", Type.BOOLEAN, 0, false, false, false));
        cols.add(new Col(null, "rowID", "rowID", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "printCount", "printCount", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "otherPrintCount", "otherPrintCount", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "tableID", "tableID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "voucherNumber", "شماره سند", Type.DECIMAL, 90, true, true, false));
        cols.add(new Col(null, "voucherDate", "تاریخ سن", Type.STRING, 90, true, true, false));
        cols.add(new Col(null, "voucherTime", "زمان سند", Type.STRING, 90, true, true, false));
        cols.add(new Col(null, "sumQ", "جمع مقداری سند", Type.STRING, 90, true, true, false));
        cols.add(new Col(null, "saleMab", "قابل پرداخت", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "cashPrice", "مبلغ نقد دریافتی", Type.DECIMAL, 110, true, true, false));
        cols.add(new Col(null, "docPrice", "مبلغ چک دریافتی", Type.DECIMAL, 110, true, true, false));
        cols.add(new Col(null, "customerCode", "کد مشتری", Type.DECIMAL, 110, true, true, false));
        cols.add(new Col(null, "customerName", "نام مشتری", Type.STRING, 110, true, true, false));
        cols.add(new Col(null, "creatorName", "ایجاد کننده", Type.STRING, 110, true, true, false));
        cols.add(new Col(null, "controllerName", "کنترل کننده", Type.STRING, 110, true, true, false));
        cols.add(new Col(null, "voucherDesc", "شرح سند", Type.STRING, 200, true, true, false));
        cols.add(new Col(null, "tafsiliCode", "کد تفصیلی", Type.STRING, 80, true, true, false));
        cols.add(new Col(null, "tafsiliDesc", "شرح تفصیلی", Type.STRING, 80, true, true, false));
        cols.add(new Col(null, "saleCenterDesc", "مرکز فروش", Type.STRING, 80, true, true, false));
        cols.add(new Col(null, "deliverCenterDesc", "محل تحویل", Type.STRING, 80, true, true, false));
        cols.add(new Col(null, "voucherStatDesc", "وضعیت سند", Type.STRING, 80, true, true, false));
        cols.add(new Col(null, "storeCode", "کد انبار", Type.STRING, 80, true, true, false));
        cols.add(new Col(null, "storeName", "نام انبار", Type.STRING, 60, true, true, false));
        cols.add(new Col(null, "serverDesc", "محل صدور", Type.STRING, 60, true, true, false));
        cols.add(new Col(null, "paymentwayDesc", "شرایط پرداخت", Type.STRING, 100, true, true, false));
        return new Meta(cols);
    }
}
