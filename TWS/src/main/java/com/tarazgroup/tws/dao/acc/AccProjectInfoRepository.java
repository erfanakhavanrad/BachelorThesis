package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.ResultErrMsgNewID;
import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccProjectInfo;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Jan-17, 2022
 ***/
public interface AccProjectInfoRepository extends TCrudRepository<AccProjectInfo>, CrudRepository<AccProjectInfo, BigDecimal> {
    default List<AccProjectInfo> accShowProjectInfo(AccProjectInfo accProjectInfo) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accProjectInfo._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accProjectInfo._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", accProjectInfo._pageFilter()));
        return showSP("AccShowProjectInfo", tParameters, true);
    }

    default AccProjectInfo accShowProjectInfoByID(BigDecimal projectid) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.Projectid = " + projectid));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("AccShowProjectInfo", tParameters, true).get(0);
    }

//    default AccProjectInfo accInsProjectInfo(AccProjectInfo accProjectInfo){
//        LogLogins logLogins = fetchUserDetail();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("StatusId", accProjectInfo.getStatusId()));
//        tParameters.add(new TParameter<>("EmployerId", accProjectInfo.getEmployerId()));
//        tParameters.add(new TParameter<>("ProjectPercent", accProjectInfo.getProjectPercent()));
//        tParameters.add(new TParameter<>("InsuranceRate", accProjectInfo.getInsuranceRate()));
//        tParameters.add(new TParameter<>("PayedCoefficient", accProjectInfo.getPayedCoefficient()));
//        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        tParameters.add(new TParameter<>("WorkShop", "TempT2", null));
//        tParameters.add(new TParameter<>("FirstPeriodInsuValue", accProjectInfo.getFirstPeriodInsuValue()));
//        tParameters.add(new TParameter<>("InsuranceDepositRate", accProjectInfo.getInsuranceDepositRate()));
//        BigDecimal newID = insSP("AccInsUpdProjectInfo", tParameters);
//        return accShowProjectInfoByID(newID);
//    }

    default AccProjectInfo accInsUpdProjectInfo(BigDecimal projectId,AccProjectInfo accProjectInfo){
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        if (projectId == null) {
            BigDecimal newID = insSP("AccInsUpdProjectInfo", tParameters);
            return accShowProjectInfoByID(newID);
        } else {
            tParameters.add(new TParameter<>("ProjectId", projectId));
        }
        tParameters.add(new TParameter<>("StatusId", accProjectInfo.getStatusId()));
        tParameters.add(new TParameter<>("EmployerId", accProjectInfo.getEmployerId()));
        tParameters.add(new TParameter<>("ProjectPercent", accProjectInfo.getProjectPercent()));
        tParameters.add(new TParameter<>("InsuranceRate", accProjectInfo.getInsuranceRate()));
        tParameters.add(new TParameter<>("PayedCoefficient", accProjectInfo.getPayedCoefficient()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        tParameters.add(new TParameter<>("WorkShop", "TempT2", null));
        tParameters.add(new TParameter<>("FirstPeriodInsuValue", accProjectInfo.getFirstPeriodInsuValue()));
        tParameters.add(new TParameter<>("InsuranceDepositRate", accProjectInfo.getInsuranceDepositRate()));
        ResultErrMsgNewID resultErrMsgNewID = execSPNativeQuery(AccProjectInfo.class, "AccInsVoucherHD", tParameters);
        return accShowProjectInfoByID(projectId);
    }

    default void accDelProjectInfo(BigDecimal projectid) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Projectid", projectid));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("AccDelProjectInfo", tParameters);
    }
}
