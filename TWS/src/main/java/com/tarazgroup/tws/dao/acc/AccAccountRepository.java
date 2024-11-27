package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccAccount;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
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

public interface AccAccountRepository extends TCrudRepository<AccAccount>, CrudRepository<AccAccount, BigDecimal> {

    default List<AccAccount> accShowAccountGorooh(AccAccount accAccount) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("Filter", " AND Main.AccountLevel= 0 "));
        tParameters.add(new TParameter("OtherFilter", null));
        tParameters.add(new TParameter("ServerFilter", null));
        tParameters.add(new TParameter("YearFilter", null));
        tParameters.add(new TParameter("UserAccessFilter", null));
        tParameters.add(new TParameter("PageFilter", accAccount._pageFilter()));
        return showSP("AccShowAccount", tParameters, true);
    }

    default List<AccAccount> accShowAccountKol(BigDecimal[] serverIds, AccAccount accAccount) {
//        if (filter == null) {
//            filter = "";
//        } else {
//            filter = " AND " + filter;
//        }
        String serverIdsStr = "";
        for (BigDecimal serverId : serverIds) {
            serverIdsStr += serverId.toString() + ",";
        }
        serverIdsStr = serverIdsStr.substring(0, serverIdsStr.length() - 1);
        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter("Filter", " AND Main.AccountLevel=1 " + filter));
        tParameters.add(new TParameter("Filter", null));
        tParameters.add(new TParameter("OtherFilter", null));
        tParameters.add(new TParameter("ServerFilter", " AND Main.ServerID IN (" + serverIdsStr + ") AND (Main.ServerID IN (SELECT ServerID FROM dbo.PubUsersAccessServer WHERE UserID = 10000000) OR (1 = 1))"));
        tParameters.add(new TParameter("YearFilter", null));
        tParameters.add(new TParameter("UserAccessFilter", null));
        tParameters.add(new TParameter("PageFilter", accAccount._pageFilter()));
        return showSP("AccShowAccount", tParameters, true);
    }

    default AccAccount accShowAccountByID(BigDecimal accountID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND main.accountID=" + accountID));
        tParameters.add(new TParameter("OtherFilter", ""));
        tParameters.add(new TParameter("ServerFilter", ""));
        tParameters.add(new TParameter("YearFilter", ""));
        tParameters.add(new TParameter("UserAccessFilter", ""));
        tParameters.add(new TParameter("PageFilter", ""));
        return showSP("AccShowAccount", tParameters, true).get(0);
    }

    default AccAccount accInsAccountGorooh(AccAccount accAccount) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("AccountCode", accAccount.getAccountCode()));
        tParameters.add(new TParameter<>("AccountDesc", accAccount.getAccountDesc()));
        tParameters.add(new TParameter<>("AccountFatherID", new BigDecimal(-1)));
        tParameters.add(new TParameter<>("AccountLevel", new BigDecimal(0)));
        tParameters.add(new TParameter<>("IsCurrency", null));
        tParameters.add(new TParameter<>("Trace", null));
        tParameters.add(new TParameter<>("IsDocCount", null));
        tParameters.add(new TParameter<>("IsWarning", null));
        tParameters.add(new TParameter<>("IsError", null));
        tParameters.add(new TParameter<>("IsNotActive", null));
        tParameters.add(new TParameter<>("AccountNature", accAccount.getAccountNature()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("AccountXDesc", null));
        tParameters.add(new TParameter<>("AccountLatinDesc", null));
        tParameters.add(new TParameter<>("YearID", null));
        BigDecimal newID = insSP("AccInsAccount", tParameters);
        return accShowAccountByID(newID);
    }

    default AccAccount accInsAccountKol(AccAccount accAccount) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("AccountCode", accAccount.getAccountCode()));
        tParameters.add(new TParameter<>("AccountDesc", accAccount.getAccountDesc()));
        tParameters.add(new TParameter<>("AccountFatherID", accAccount.getAccountFatherID()));
        tParameters.add(new TParameter<>("AccountLevel", new BigDecimal(1)));
        tParameters.add(new TParameter<>("IsCurrency", null));
        tParameters.add(new TParameter<>("Trace", null));
        tParameters.add(new TParameter<>("IsDocCount", null));
        tParameters.add(new TParameter<>("IsWarning", null));
        tParameters.add(new TParameter<>("IsError", null));
        tParameters.add(new TParameter<>("IsNotActive", null));
        tParameters.add(new TParameter<>("AccountNature", accAccount.getAccountNature()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("AccountXDesc", null));
        tParameters.add(new TParameter<>("AccountLatinDesc", null));
        tParameters.add(new TParameter<>("YearID", null));
        BigDecimal newID = insSP("AccInsAccount", tParameters);
        return accShowAccountByID(newID);
    }

    default AccAccount accUpdAccountGorooh(BigDecimal accountID, AccAccount accAccount) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("AccountID", accountID));
        tParameters.add(new TParameter<>("AccountCode", accAccount.getAccountCode()));
        tParameters.add(new TParameter<>("AccountDesc", accAccount.getAccountDesc()));
        tParameters.add(new TParameter<>("IsCurrency", accAccount.getIsCurrency()));
        tParameters.add(new TParameter<>("Trace", accAccount.getTrace()));
        tParameters.add(new TParameter<>("IsDocCount", accAccount.getIsDocCount()));
        tParameters.add(new TParameter<>("IsWarning", accAccount.getIsWarning()));
        tParameters.add(new TParameter<>("IsError", accAccount.getIsError()));
        tParameters.add(new TParameter<>("IsNotActive", accAccount.getIsNotActive()));
        tParameters.add(new TParameter<>("AccountNature", accAccount.getAccountNature()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("AccountXDesc", accAccount.getAccountXDesc()));
        tParameters.add(new TParameter<>("AccountLatinDesc", accAccount.getAccountLatinDesc()));
        updSP("AccUpdAccount", tParameters);
        return accShowAccountByID(accountID);
    }

    default AccAccount accUpdAccountKol(BigDecimal accountID, AccAccount accAccount) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("AccountID", accountID));
        tParameters.add(new TParameter<>("AccountCode", accAccount.getAccountCode()));
        tParameters.add(new TParameter<>("AccountDesc", accAccount.getAccountDesc()));
        tParameters.add(new TParameter<>("IsCurrency", accAccount.getIsCurrency()));
        tParameters.add(new TParameter<>("Trace", accAccount.getTrace()));
        tParameters.add(new TParameter<>("IsDocCount", accAccount.getIsDocCount()));
        tParameters.add(new TParameter<>("IsWarning", accAccount.getIsWarning()));
        tParameters.add(new TParameter<>("IsError", accAccount.getIsError()));
        tParameters.add(new TParameter<>("IsNotActive", accAccount.getIsNotActive()));
        tParameters.add(new TParameter<>("AccountNature", accAccount.getAccountNature()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("AccountXDesc", accAccount.getAccountXDesc()));
        tParameters.add(new TParameter<>("AccountLatinDesc", accAccount.getAccountLatinDesc()));
        updSP("AccUpdAccount", tParameters);
        return accShowAccountByID(accountID);
    }

    default void accDelAccount(BigDecimal accountID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("AccountID", accountID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("AccDelAccount", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"accountID", "accountID", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"accountCode", "کد", Type.STRING, 80, true, true,  false));
        cols.add(new Col(null,"accountDesc", "شرح", Type.STRING, 250, true, true,  false));
        cols.add(new Col(null,"yearDesc", "سال مالی", Type.STRING, 130, true, true,  false));
        cols.add(new Col(null,"accountNatureDesc", "ماهیت", Type.STRING, 120, true, true,  false));
        cols.add(new Col(null,"serverID", "serverID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"accountLevel", "accountLevel", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"groupsAccountID", "groupsAccountID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"groupsAccountCode", "groupsAccountCode", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"groupsAccountDesc", "groupsAccountDesc", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"colAccountID", "colAccountID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"colAccountCode", "colAccountCode", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"colAccountDesc", "colAccountDesc", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"accountFatherID", "accountFatherID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"createDate", "createDate", Type.DATE, 0, false, false,  false));
        cols.add(new Col(null,"creatorID", "creatorID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"modifyDate", "modifyDate", Type.DATE, 0, false, false,  false));
        cols.add(new Col(null,"modifierID", "modifierID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"isCurrency", "isCurrency", Type.BOOLEAN, 0, false, false,  false));
        cols.add(new Col(null,"trace", "trace", Type.BOOLEAN, 0, false, false,  false));
        cols.add(new Col(null,"isDocCount", "isDocCount", Type.BOOLEAN, 0, false, false,  false));
        cols.add(new Col(null,"isWarning", "isWarning", Type.BOOLEAN, 0, false, false,  false));
        cols.add(new Col(null,"isError", "isError", Type.BOOLEAN, 0, false, false,  false));
        cols.add(new Col(null,"isNotActive", "isNotActive", Type.BOOLEAN, 0, false, false,  false));
        cols.add(new Col(null,"accountNature", "accountNature", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"accountLatinDesc", "accountLatinDesc", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"accountXDesc", "accountXDesc", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"tafsiliTypeStr", "tafsiliTypeStr", Type.STRING, 0, false, false,  false));
        return new Meta(cols);
    }

}
