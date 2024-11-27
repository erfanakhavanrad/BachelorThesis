package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.ShowSPReturnType;
import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dto.chart.TChart;
import com.tarazgroup.tws.model.acc.AccReportAccountReview;
import com.tarazgroup.tws.util.global.TParameter;
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
 * @author M.Nouri
 * @since 2.0.0
 */
public interface AccReportAccountReviewRepository extends TCrudRepository<AccReportAccountReview>, CrudRepository<AccReportAccountReview, BigDecimal> {

    default List<AccReportAccountReview> accReport_AccountReview(AccReportAccountReview accReport_accountReview, Integer reportLvl, Boolean remain, BigDecimal colNum, String fromDate,
                                                                 String toDate, String accountFilter, Boolean isCurrency, Boolean isTemp, String filterTypeVoucher, Boolean isShowContactInfo,
                                                                 Boolean isByServer, Boolean isShowLastActivity) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("GeneralFilter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accReport_accountReview._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accReport_accountReview._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("ReportLevel", reportLvl));
        tParameters.add(new TParameter<>("Remain", remain));
        tParameters.add(new TParameter<>("ColNum", colNum));
        tParameters.add(new TParameter<>("FromDate", fromDate));
        tParameters.add(new TParameter<>("ToDate", toDate));
        tParameters.add(new TParameter<>("AccountFilter", accountFilter));
        tParameters.add(new TParameter<>("IsCurrency", isCurrency));
        tParameters.add(new TParameter<>("IsTemp", isTemp));
        tParameters.add(new TParameter<>("FilterTypeVoucher", filterTypeVoucher));
        tParameters.add(new TParameter<>("IsShowContactInfo", isShowContactInfo));
        tParameters.add(new TParameter<>("PageFilter", accReport_accountReview._pageFilter()));
        tParameters.add(new TParameter<>("IsByServer", isByServer));
        tParameters.add(new TParameter<>("IsShowLastActivity", isShowLastActivity));
        return showSP("AccReport_AccountReview", tParameters, true);
    }

    default TChart accReportAccountReview(
            String[] srIDs,
            BigDecimal yearID,
            String fromDate,
            String toDate,
            String xFieldName,
            String[] yFieldNames,
            String[] yFieldTitles
    ) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("GeneralFilter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", " AND Main.ServerID IN (" + String.join(",", srIDs) + ")"));
        tParameters.add(new TParameter<>("YearFilter", " AND Main.YearID = " + yearID));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("ReportLevel", 0));
        tParameters.add(new TParameter<>("Remain", false));
        tParameters.add(new TParameter<>("ColNum", new BigDecimal(4)));
        tParameters.add(new TParameter<>("FromDate", fromDate));
        tParameters.add(new TParameter<>("ToDate", toDate));
        tParameters.add(new TParameter<>("AccountFilter", null));
        tParameters.add(new TParameter<>("IsCurrency", null));
        tParameters.add(new TParameter<>("IsTemp", null));
        tParameters.add(new TParameter<>("FilterTypeVoucher", null));
        tParameters.add(new TParameter<>("IsShowContactInfo", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        tParameters.add(new TParameter<>("IsByServer", null));
        tParameters.add(new TParameter<>("IsShowLastActivity", null));

        List<Map<String, Object>> rows = execSPNativeQuery(AccReportAccountReview.class, "AccReport_AccountReview", tParameters, ShowSPReturnType.MAP);
        return new TChart(xFieldName, yFieldNames, yFieldTitles, rows);
    }


    default List<Map<String, Object>> accReportAccountReview3(
            BigDecimal TafsiliID,
            String[] srIDs,
            BigDecimal yearID,
            String fromDate,
            String toDate,
            BigDecimal reportLevel,
            Boolean remain

    ) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        if (TafsiliID != null) {
            tParameters.add(new TParameter<>("Filter", " AND det.TafsiliID=" + TafsiliID));
        } else {
            tParameters.add(new TParameter<>("Filter", null));
        }
        tParameters.add(new TParameter<>("GeneralFilter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", " AND Main.ServerID IN (" + String.join(",", srIDs) + ")"));
        tParameters.add(new TParameter<>("YearFilter", " AND Main.YearID = " + yearID));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("ReportLevel", reportLevel));
        tParameters.add(new TParameter<>("Remain", remain));
        tParameters.add(new TParameter<>("ColNum", new BigDecimal(4)));
        tParameters.add(new TParameter<>("FromDate", fromDate));
        tParameters.add(new TParameter<>("ToDate", toDate));
        tParameters.add(new TParameter<>("AccountFilter", "and Charindex('',''+Cast(Det.AccountID as nvarchar)+'','', '',''+(select AccAccountIDs from SaleSysSetup)+'','') > 0"));
        tParameters.add(new TParameter<>("IsCurrency", null));
        tParameters.add(new TParameter<>("IsTemp", null));
        tParameters.add(new TParameter<>("FilterTypeVoucher", null));
        tParameters.add(new TParameter<>("IsShowContactInfo", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        tParameters.add(new TParameter<>("IsByServer", null));
        tParameters.add(new TParameter<>("IsShowLastActivity", null));

        List<Map<String, Object>> rows = execSPNativeQuery(AccReportAccountReview.class, "AccReport_AccountReview", tParameters, ShowSPReturnType.MAP);
        return rows;
    }


}
