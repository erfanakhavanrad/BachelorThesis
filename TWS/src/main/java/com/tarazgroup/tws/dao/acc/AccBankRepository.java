package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.ShowSPReturnType;
import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccBank;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.json.JSONArray;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@SuppressWarnings("Duplicates")
public interface AccBankRepository extends TCrudRepository<AccBank>, CrudRepository<AccBank, BigDecimal> {
    // TODO: 11/21/21 write this method for bank branch because it is needed in Vuejs  *Akhavan*
    default int recordsCount(Map<String, String> params) {
        AccBank accBank = setParams(AccBank.class, params);
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accBank._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accBank._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", accBank._pageFilter()));
        return showSP("AccShowBank", tParameters, true).size();
    }

    default List<AccBank> accShowBank(AccBank accBank) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accBank._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accBank._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", accBank._pageFilter()));
        return showSP("AccShowBank", tParameters, true);
    }

    default List<AccBank> accShowBankNative(AccBank accBank) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accBank._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accBank._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", accBank._pageFilter()));
        return execSPNativeQuery(AccBank.class, "AccShowBank", tParameters, ShowSPReturnType.NATIVE);
    }

    default List<Map<String, Object>> accShowBankMap(AccBank accBank) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accBank._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accBank._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", accBank._pageFilter()));
        return execSPNativeQuery(AccBank.class, "AccShowBank", tParameters, ShowSPReturnType.MAP);
    }

    default List accShowBankMapTest() {
        return execSPNativeQueryTest(" SELECT BankID as id,BankName  FROM AccBank as bank SELECT BankBranchCode  ,BankBranchDesc  FROM AccBankBranch");
    }

    default List accShowBankMapTestAk(String query) {
//        return execSPNativeQueryTestAK(" SELECT *  FROM AccBank as bank SELECT BankBranchCode  ,BankBranchDesc  FROM AccBankBranch");
        return execSPNativeQueryTestAK(query);
    }

    default AccBank accShowBankByID(BigDecimal bankID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND main.bankID=" + bankID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("AccShowBank", tParameters, true).get(0);
    }

    default AccBank accInsBank(AccBank accBank) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("BankName", accBank.getBankName()));
        tParameters.add(new TParameter<>("BankLatinName", accBank.getBankLatinName()));
        tParameters.add(new TParameter<>("TaxCode", accBank.getTaxCode()));
        tParameters.add(new TParameter<>("BankCode", accBank.getBankCode()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("AccInsBank", tParameters);
        return accShowBankByID(newID);
    }

    default void accDelBank(BigDecimal bankID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("BankID", bankID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("AccDelBank", tParameters);
    }

    default AccBank accUpdBank(BigDecimal bankID, AccBank accBank) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("BankID", bankID));
        tParameters.add(new TParameter<>("BankName", accBank.getBankName()));
        tParameters.add(new TParameter<>("BankLatinName", accBank.getBankLatinName()));
        tParameters.add(new TParameter<>("TaxCode", accBank.getTaxCode()));
        tParameters.add(new TParameter<>("BankCode", accBank.getBankCode()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("AccUpdBank", tParameters);
        return accShowBankByID(bankID);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "bankId", "bankId", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "bankCode", "کد بانک", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "taxCode", "کد مالیاتی", Type.STRING, 130, true, true, false));
        cols.add(new Col(null, "bankName", "نام بانک", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "bankLatinName", "نام لاتین بانک", Type.STRING, 120, true, true, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.INTEGER, 100, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 120, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, false, false, false));
        return new Meta(cols);
    }

    default InputStreamResource excel() {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        List<AccBank> rows = showSP("AccShowBank", tParameters, false);
        return exportToExcel(rows, meta().getCols(), "بانک ها");
    }

    default InputStreamResource reportPDF() {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        HashMap<String, Object> parameterFields = new HashMap();
        return exportCrystalReportToPDF(AccBank.class, "accbank", parameterFields, tParameters, ShowSPReturnType.NATIVE);
    }
}
