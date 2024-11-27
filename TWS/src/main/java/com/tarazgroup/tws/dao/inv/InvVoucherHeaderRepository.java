package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvVoucherHeader;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
public interface InvVoucherHeaderRepository extends TCrudRepository<InvVoucherHeader>, CrudRepository<InvVoucherHeader, BigDecimal> {

    default List<InvVoucherHeader> invShowVoucherHeader(InvVoucherHeader invVoucherHeader) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", ""));
        tParameters.add(new TParameter<>("ServerFilter", invVoucherHeader._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invVoucherHeader._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", ""));
        tParameters.add(new TParameter<>("ShowRemain", null));
        tParameters.add(new TParameter<>("VoucherTypeID", null));
        tParameters.add(new TParameter<>("RefTypeID", null));
        tParameters.add(new TParameter<>("PageFilter", invVoucherHeader._pageFilter()));
        tParameters.add(new TParameter<>("UserID", null));
        return showSP("InvShowVoucherHeader", tParameters, true);
    }

    default List<InvVoucherHeader> invShowVoucherHeaderRefer(
            BigDecimal voucherTypeID,
            BigDecimal refTypeID,
            BigDecimal voucherNumber,
            String tafsiliDesc,
            String voucherDate,
            BigDecimal yearID

    ) {
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

        pageFilter += "?,?VoucherDate Desc";

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
        tParameters.add(new TParameter<>("UserID", null));
        return showSP("InvShowVoucherHeader", tParameters, true);
    }

    default InvVoucherHeader invShowVoucherHeaderByID(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("UserAccessFilter", ""));
        tParameters.add(new TParameter<>("OtherFilter", ""));
        tParameters.add(new TParameter<>("Filter", "AND main.VoucherHeaderID= " + voucherHeaderID));
        tParameters.add(new TParameter<>("ServerFilter", ""));
        tParameters.add(new TParameter<>("YearFilter", ""));
        tParameters.add(new TParameter<>("ShowRemain", null));
        tParameters.add(new TParameter<>("VoucherTypeID", null));
        tParameters.add(new TParameter<>("RefTypeID", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        tParameters.add(new TParameter<>("UserID", null));
        return showSP("InvShowVoucherHeader", tParameters, true).get(0);
    }
}
