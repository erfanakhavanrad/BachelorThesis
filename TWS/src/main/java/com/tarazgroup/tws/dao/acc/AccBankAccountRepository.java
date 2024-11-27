package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccBankAccount;
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
public interface AccBankAccountRepository extends TCrudRepository<AccBankAccount>, CrudRepository<AccBankAccount, BigDecimal> {

    default List<AccBankAccount> accShowBankAccount(AccBankAccount accBankAccount) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accBankAccount._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accBankAccount._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", accBankAccount._pageFilter()));
        return showSP("AccShowBankAccount", tParameters, true);
    }

    default AccBankAccount accInsBankAccount(AccBankAccount accBankAccount) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("BankAccountNumber", accBankAccount.getBankAccountNumber()));
        tParameters.add(new TParameter<>("BankBranchID", accBankAccount.getBankBranchID()));
        tParameters.add(new TParameter<>("AccountKindID", accBankAccount.getAccountKindID()));
        tParameters.add(new TParameter<>("TafsiliID", accBankAccount.getTafsiliID()));
        tParameters.add(new TParameter<>("TafsiliTypeID", accBankAccount.getTafsiliTypeID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getCreatorID()));
        tParameters.add(new TParameter<>("IsCurrency", accBankAccount.getIsCurrency()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("BankID", accBankAccount.getBankID()));
        tParameters.add(new TParameter<>("BankAccountOwner", accBankAccount.getBankAccountOwner()));
        tParameters.add(new TParameter<>("SystemID", logLogins.getSystemId()));
        tParameters.add(new TParameter<>("ShebaNo", accBankAccount.getShebaNo()));
        tParameters.add(new TParameter<>("IsControlAccount", null));
        tParameters.add(new TParameter<>("CardCode", accBankAccount.getCardCode()));
        BigDecimal newID = insSP("AccInsBankAccount", tParameters);
        AccBankAccount temp = new AccBankAccount();
        temp.setBankAccountID(newID);
        return accShowBankAccount(temp).get(0);
    }

    default void accDelBankAccount(BigDecimal bankAccountID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("BankAccountID", bankAccountID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("AccDelBankAccount", tParameters);
    }

    default AccBankAccount accUpdBankAccount(BigDecimal bankAccountID, AccBankAccount accBankAccount) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("BankAccountID", bankAccountID));
        tParameters.add(new TParameter<>("BankAccountNumber", accBankAccount.getBankAccountNumber()));
        tParameters.add(new TParameter<>("BankBranchID", accBankAccount.getBankBranchID()));
        tParameters.add(new TParameter<>("AccountKindID", accBankAccount.getAccountKindID()));
        tParameters.add(new TParameter<>("TafsiliTypeID", accBankAccount.getTafsiliTypeID()));
        tParameters.add(new TParameter<>("IsCurrency", accBankAccount.getIsCurrency()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("BankID", accBankAccount.getBankID()));
        tParameters.add(new TParameter<>("BankAccountOwner", accBankAccount.getBankAccountOwner()));
        tParameters.add(new TParameter<>("ShebaNo", accBankAccount.getShebaNo()));
        tParameters.add(new TParameter<>("IsControlAccount", accBankAccount.getIsControlAccount()));
        tParameters.add(new TParameter<>("CardCode", accBankAccount.getCardCode()));
        updSP("AccUpdBankAccount", tParameters);
        AccBankAccount temp = new AccBankAccount();
        temp.setBankAccountID(bankAccountID);
        return accShowBankAccount(temp).get(0);

    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"bankAccountID", "bankAccountID", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"bankAccountOwner", "نام صاحب حساب", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"bankAccountNumber", "شماره حساب", Type.STRING, 300, true, true,  false));
        cols.add(new Col(null,"bankBranchID", "bankBranchID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"accountKindID", "accountKindID", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"shebaNo", "شبا", Type.STRING, 300, true, true,  false));
        cols.add(new Col(null,"bankBranchCode", "کد شعبه", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"bankBranchDesc", "نام شعبه", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"bankName", "نام بانک", Type.STRING, 200, true, true,  false));
        cols.add(new Col(null,"accountKindCode", "کد نوع حساب", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"accountKindDesc", "نوع حساب بانکی", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"tafsiliCode", "کد تفصیلی", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"bankID", "bankID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"cardCode", "شماره کارت", Type.STRING, 200, true, true,  false));
        return new Meta(cols);
    }


}
