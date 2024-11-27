package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.ShowSPReturnType;
import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dto.tkt.charts.TChartTicketStatus;
import com.tarazgroup.tws.dto.tkt.charts.TChartTicketUserStatus;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktTicketStatusReport;
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
public interface TktTicketStatusReportRepository extends TCrudRepository<TktTicketStatusReport>, CrudRepository<TktTicketStatusReport, BigDecimal> {

    default TChartTicketStatus tktTicketStatusReport(
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
        LogLogins logLogins = fetchUserDetail();
        TCalendar tCalendarToDate = new TCalendar();
        tCalendarToDate.setIranianDateBySlash(toDate);

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

        List<Map<String, Object>> rows = execSPNativeQuery(TktTicketStatusReport.class, "TktShowTicketStatusReport", tParameters, ShowSPReturnType.MAP);
        return new TChartTicketStatus(xFieldName, yFieldNames, yFieldTitles, rows);

    }

    default TChartTicketUserStatus tktTicketStatusReportForStaff(
            String xFieldName,
            String[] yFieldNames,
            String[] yFieldTitles
    ) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        if (Objects.equals(logLogins.getPubUser().getIsAdmin(),"1")) {
            tParameters.add(new TParameter<>("IsAdmin", true));
        } else {
            tParameters.add(new TParameter<>("IsAdmin", false));
        }

        List<Map<String, Object>> rows = execSPNativeQuery(
                TktTicketStatusReport.class,
                "TktShowTicketStatusReportForStaff",
                tParameters,
                ShowSPReturnType.MAP
        );
        return new TChartTicketUserStatus(
                xFieldName,
                yFieldNames,
                yFieldTitles,
                rows,
                logLogins.getPubUser().getUserID(),
                null);
    }

    default TChartTicketUserStatus tktTicketStatusReportForCustomer(
            String xFieldName,
            String[] yFieldNames,
            String[] yFieldTitles
    ) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        if (Objects.equals(logLogins.getPubUser().getIsAdmin(),"1")) {
            tParameters.add(new TParameter<>("IsAdmin", true));
        } else {
            tParameters.add(new TParameter<>("IsAdmin", false));
        }

        List<Map<String, Object>> rows = execSPNativeQuery(
                TktTicketStatusReport.class,
                "TktShowTicketStatusReportForCustomer",
                tParameters,
                ShowSPReturnType.MAP
        );
        return new TChartTicketUserStatus(
                xFieldName,
                yFieldNames,
                yFieldTitles,
                rows,
                null,
                logLogins.getPubUser().getUserID()
        );
    }

}
