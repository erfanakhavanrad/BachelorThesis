package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.ShowSPReturnType;
import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccBankBranch;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.PromotionElement;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("Duplicates")
public interface AccBankBranchRepository extends TCrudRepository<AccBankBranch>, CrudRepository<AccBankBranch, BigDecimal> {

    default List<AccBankBranch> accShowBankBranch(AccBankBranch accBankBranch) {
        ArrayList<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accBankBranch._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", accBankBranch._pageFilter()));
        return showSP("AccShowBankBranch", tParameters, true);
    }

    default List<AccBankBranch> accShowBankBranch1(AccBankBranch accBankBranch) {
        ArrayList<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accBankBranch._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", accBankBranch._pageFilter()));
        return execSPNativeQuery(AccBankBranch.class, "AccShowBankBranch", tParameters , ShowSPReturnType.NATIVE);
    }

    default AccBankBranch accShowBankBranchID(BigDecimal bankBranchID) {
        ArrayList<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND main.bankBranchID=" + bankBranchID));
        tParameters.add(new TParameter<>("OtherFilter", ""));
        tParameters.add(new TParameter<>("ServerFilter", ""));
        tParameters.add(new TParameter<>("YearFilter", ""));
        tParameters.add(new TParameter<>("UserAccessFilter", ""));
        tParameters.add(new TParameter<>("PageFilter", ""));
        return showSP("AccShowBankBranch", tParameters, true).get(0);
    }

    default void accDelBankBranch(BigDecimal bankBranchID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("BankBranchID", bankBranchID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("AccDelBankBranch", tParameters);
    }

    default AccBankBranch accInsBankBranch(AccBankBranch accBankBranch) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("BankBranchCode", accBankBranch.getBankBranchCode()));
        tParameters.add(new TParameter<>("BankBranchDesc", accBankBranch.getBankBranchDesc()));
        tParameters.add(new TParameter<>("BankBAddress", accBankBranch.getBankBAddress()));
        tParameters.add(new TParameter<>("BankBTelphone", accBankBranch.getBankBTelphone()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        BigDecimal newID = insSP("AccInsBankBranch", tParameters);
        return accShowBankBranchID(newID);
    }

    default AccBankBranch accUpdBankBranch(BigDecimal bankBranchID, AccBankBranch accBankBranch) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<java.io.Serializable>("BankBranchID", bankBranchID));
        tParameters.add(new TParameter<java.io.Serializable>("BankBranchCode", accBankBranch.getBankBranchCode()));
        tParameters.add(new TParameter<>("BankBranchDesc", accBankBranch.getBankBranchDesc()));
        tParameters.add(new TParameter<>("BankBAddress", accBankBranch.getBankBAddress()));
        tParameters.add(new TParameter<>("BankBTelphone", accBankBranch.getBankBTelphone()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("AccUpdBankBranch", tParameters);
        return accShowBankBranchID(bankBranchID);

    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "bankBranchID", "bankBranchID", Type.DECIMAL, 100, false, false, true));
        cols.add(new Col(null, "serverID", "serverID", Type.INTEGER, 100, false, false, false));
        cols.add(new Col(null, "bankBranchCode", "کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "bankBranchDesc", "نام", Type.STRING, 130, true, true, false));
        cols.add(new Col(null, "bankBAddress", "آدرس", Type.STRING, 200, true, true, false));
        cols.add(new Col(null, "bankBTelphone", "تلفن", Type.STRING, 80, true, true, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
        return new Meta(cols);
    }
}
