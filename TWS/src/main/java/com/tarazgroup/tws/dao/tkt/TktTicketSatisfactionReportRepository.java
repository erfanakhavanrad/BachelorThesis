package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.ShowSPReturnType;
import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dto.tkt.charts.TChartTicketSatisfaction;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktTicketSatisfactionReport;
import com.tarazgroup.tws.util.global.TCalendar;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 4/13/22
 *
 * @author Erfan Akhavan
 */
public interface TktTicketSatisfactionReportRepository extends TCrudRepository<TktTicketSatisfactionReport>, CrudRepository<TktTicketSatisfactionReport, BigDecimal> {
    default TChartTicketSatisfaction tktTicketSatisfactionReport(
            String xFieldName,
            String[] yFieldNames,
            String[] yFieldTitles,
            String fromDate,
            String toDate,
//            String userName,
            BigDecimal organizationID,
            BigDecimal customerID,
            BigDecimal departmentID,
            BigDecimal staffID
    ) {
        TCalendar tCalendarFromDate = new TCalendar();
        tCalendarFromDate.setIranianDateBySlash(fromDate);

        TCalendar tCalendarToDate = new TCalendar();
        tCalendarToDate.setIranianDateBySlash(toDate);
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FromDate", tCalendarFromDate.getGregorianDateBySlashZero()));
        tParameters.add(new TParameter<>("ToDate", tCalendarToDate.getGregorianDateBySlashZero()));

        String filter = "";
//        if (userName != null) {
//            filter += " AND PCom.PerComName LIKE ''%" + userName + "%''";
//        }

        if (organizationID != null) {
            filter += " AND Org.OrganizationID = " + organizationID;
        }

        if (customerID != null) {
            filter += " AND Cus.CustomerID = " + customerID;
        }

        if (departmentID != null) {
            filter += " AND Dep.DepartmentID = " + departmentID;
        }
        if ( staffID != null) {
            filter += " AND SRole.StaffID = " + staffID;
        }
        tParameters.add(new TParameter<>("Filter", filter));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        if (Objects.equals(logLogins.getPubUser().getIsAdmin(),"1")) {
            tParameters.add(new TParameter<>("IsAdmin", true));
        } else {
            tParameters.add(new TParameter<>("IsAdmin", false));
        }

        List<Map<String, Object>> rows = execSPNativeQuery(TktTicketSatisfactionReport.class, "TktShowTicketSatisfactionReport", tParameters, ShowSPReturnType.MAP);
        return new TChartTicketSatisfaction(xFieldName, yFieldNames, yFieldTitles, rows);

    }

    default TChartTicketSatisfaction tktSatisfactionReportForStaff(
            String xFieldName,
            String[] yFieldNames,
            String[] yFieldTitles
    ) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        if (Objects.equals(logLogins.getPubUser().getIsAdmin(),"1")) {
            tParameters.add(new TParameter<>("IsAdmin", true));
        } else {
            tParameters.add(new TParameter<>("IsAdmin", false));
        }

        List<Map<String, Object>> rows = execSPNativeQuery(TktTicketSatisfactionReport.class, "TktShowSatisfactionReportForStaff", tParameters, ShowSPReturnType.MAP);
        return new TChartTicketSatisfaction(xFieldName, yFieldNames, yFieldTitles, rows);
    }

    default TChartTicketSatisfaction tktSatisfactionReportForCustomer(
            String xFieldName,
            String[] yFieldNames,
            String[] yFieldTitles
    ) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();

        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        if (Objects.equals(logLogins.getPubUser().getIsAdmin(),"1")) {
            tParameters.add(new TParameter<>("IsAdmin", true));
        } else {
            tParameters.add(new TParameter<>("IsAdmin", false));
        }

        List<Map<String, Object>> rows = execSPNativeQuery(TktTicketSatisfactionReport.class, "TktShowSatisfactionReportForCustomer", tParameters, ShowSPReturnType.MAP);
        return new TChartTicketSatisfaction(xFieldName, yFieldNames, yFieldTitles, rows);
    }
}
