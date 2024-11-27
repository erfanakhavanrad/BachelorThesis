package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.ShowSPReturnType;
import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dto.IranMapDto;
import com.tarazgroup.tws.dto.chart.TChart;
import com.tarazgroup.tws.model.sale.SaleReportReviewL1;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public interface SaleReportReviewL1Repository extends TCrudRepository<SaleReportReviewL1>, CrudRepository<SaleReportReviewL1, BigDecimal> {


    default List<Map<String, Object>> saleReportReviewL1(
            String[] srIDs,
            BigDecimal yearID,
            String fromDate,
            String toDate,
            int repType) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", " AND Main.ServerID IN (" + String.join(",", srIDs) + ")"));
        tParameters.add(new TParameter<>("YearFilter", " AND Main.YearID = " + yearID + " AND Main.VoucherDate between ''" + fromDate + "'' AND ''" + toDate + "''"));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("VoucherTypeID", new BigDecimal(6004)));
        tParameters.add(new TParameter<>("RepType", repType));
        tParameters.add(new TParameter<>("IsShowElements", false));
        tParameters.add(new TParameter<>("IsRightJoin", false));
        tParameters.add(new TParameter<>("IsBuyRep", false));
        tParameters.add(new TParameter<>("BuyType", 1));
        tParameters.add(new TParameter<>("IsTaxToll", false));
        tParameters.add(new TParameter<>("IsBonus", null));
        tParameters.add(new TParameter<>("IsDistBonus", false));
        tParameters.add(new TParameter<>("IsXFields", null));
        tParameters.add(new TParameter<>("IsCurrency", null));
        tParameters.add(new TParameter<>("IsSecQuantity", null));
        tParameters.add(new TParameter<>("IsOnlyValue", null));
        tParameters.add(new TParameter<>("IsFeeAgr", null));
        List<Map<String, Object>> rows = execSPNativeQuery(SaleReportReviewL1.class, "SaleReport_Review_L1", tParameters, ShowSPReturnType.MAP);
        return rows;
    }

    default TChart saleReportReviewL1(
            String[] srIDs,
            BigDecimal yearID,
            String fromDate,
            String toDate,
            String xFieldName,
            String[] yFieldNames,
            String[] yFieldTitles,
            int repType
    ) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", " AND Main.ServerID IN (" + String.join(",", srIDs) + ")"));
        tParameters.add(new TParameter<>("YearFilter", " AND Main.YearID = " + yearID + " AND Main.VoucherDate between ''" + fromDate + "'' AND ''" + toDate + "''"));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("VoucherTypeID", new BigDecimal(6004)));
        tParameters.add(new TParameter<>("RepType", repType));
        tParameters.add(new TParameter<>("IsShowElements", false));
        tParameters.add(new TParameter<>("IsRightJoin", false));
        tParameters.add(new TParameter<>("IsBuyRep", false));
        tParameters.add(new TParameter<>("BuyType", 1));
        tParameters.add(new TParameter<>("IsTaxToll", false));
        tParameters.add(new TParameter<>("IsBonus", null));
        tParameters.add(new TParameter<>("IsDistBonus", false));
        tParameters.add(new TParameter<>("IsXFields", null));
        tParameters.add(new TParameter<>("IsCurrency", null));
        tParameters.add(new TParameter<>("IsSecQuantity", null));
        tParameters.add(new TParameter<>("IsOnlyValue", null));
        tParameters.add(new TParameter<>("IsFeeAgr", null));
        List<Map<String, Object>> rows = execSPNativeQuery(SaleReportReviewL1.class, "SaleReport_Review_L1", tParameters, ShowSPReturnType.MAP);
        switch (repType) {
            case 5:// کالا
            case 7:// بازاریاب
                return new TChart(xFieldName, yFieldNames, yFieldTitles, rows);
            default:
                return null;
        }

    }

    default List<Map<String, Object>> saleReportReviewL1IranMap(
            String[] srIDs,
            BigDecimal yearID,
            String fromDate,
            String toDate,
            int repType
    ) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", " AND Main.ServerID IN (" + String.join(",", srIDs) + ")"));
        tParameters.add(new TParameter<>("YearFilter", " AND Main.YearID = " + yearID + " AND Main.VoucherDate between ''" + fromDate + "'' AND ''" + toDate + "''"));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("VoucherTypeID", new BigDecimal(6004)));
        tParameters.add(new TParameter<>("RepType", repType));
        tParameters.add(new TParameter<>("IsShowElements", false));
        tParameters.add(new TParameter<>("IsRightJoin", false));
        tParameters.add(new TParameter<>("IsBuyRep", false));
        tParameters.add(new TParameter<>("BuyType", 1));
        tParameters.add(new TParameter<>("IsTaxToll", false));
        tParameters.add(new TParameter<>("IsBonus", null));
        tParameters.add(new TParameter<>("IsDistBonus", false));
        tParameters.add(new TParameter<>("IsXFields", null));
        tParameters.add(new TParameter<>("IsCurrency", null));
        tParameters.add(new TParameter<>("IsSecQuantity", null));
        tParameters.add(new TParameter<>("IsOnlyValue", null));
        tParameters.add(new TParameter<>("IsFeeAgr", null));
        List<Map<String, Object>> rows = execSPNativeQuery(SaleReportReviewL1.class, "SaleReport_Review_L1", tParameters, ShowSPReturnType.MAP);
        switch (repType) {
            case 28:// استان
                // این متد دیتا را برای استفاده در نقشه ایران مهیا میکند
                // ممکن است برخی از سطر ها نام استانش خالی باشد و  باید حذف شود
                rows.removeIf(row -> (row.get("mID") == null));
                return new IranMapDto().Convert(rows);
            default:
                return null;
        }
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "classID", "classID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "classCode", "کد", Type.STRING, 50, true, true, false));
        cols.add(new Col(null, "classDesc", "شرح", Type.STRING, 200, true, true, false));
        return new Meta(cols);
    }
}
