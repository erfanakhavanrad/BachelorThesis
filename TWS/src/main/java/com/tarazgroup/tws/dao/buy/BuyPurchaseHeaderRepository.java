package com.tarazgroup.tws.dao.buy;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.buy.BuyPurchaseHeader;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface BuyPurchaseHeaderRepository extends TCrudRepository<BuyPurchaseHeader>, CrudRepository<BuyPurchaseHeader, BigDecimal> {

    default List<BuyPurchaseHeader> buyShowPurchaseHeader(BigDecimal[] serverIds, BigDecimal[] yearIds, BuyPurchaseHeader buyPurchaseHeader) {
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
        String yearFilter = " AND Main.YearID IN (" + yearIdsStr + ") AND (Main.YearID in (Select YearID from dbo.PubUserAllocateYear Where UserID = 10000000) or (1 = 1))";
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", serverFilter));
        tParameters.add(new TParameter<>("YearFilter", yearFilter));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("ShowRemain", null));
        tParameters.add(new TParameter<>("VoucherTypeID", null));
        tParameters.add(new TParameter<>("RefTypeID", null));
        tParameters.add(new TParameter<>("PageFilter", buyPurchaseHeader._pageFilter()));
        return showSP("BuyShowPurchaseHeader", tParameters, true);
    }

    default List<BuyPurchaseHeader> buyShowPurchaseHeaderRefer(
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
        return showSP("BuyShowPurchaseHeader", tParameters, true);
    }

    default BuyPurchaseHeader buyShowPurchaseHeaderByID(BigDecimal voucherHeaderID) {
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
        return showSP("BuyShowPurchaseHeader", tParameters, true).get(0);
    }

    default Meta meta() {
        // later
        return null;
    }

}
