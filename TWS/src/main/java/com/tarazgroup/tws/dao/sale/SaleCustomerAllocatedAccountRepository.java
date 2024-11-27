package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleCustomerAllocatedAccount;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * @author A.Salehi
 */

public interface SaleCustomerAllocatedAccountRepository extends TCrudRepository<SaleCustomerAllocatedAccount>, CrudRepository<SaleCustomerAllocatedAccount, BigDecimal> {

    default List<SaleCustomerAllocatedAccount> saleShowCustomerAllocatedAccount(SaleCustomerAllocatedAccount saleCustomerAllocatedAccount) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", saleCustomerAllocatedAccount._serverFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        // TODO در این اس پی باید پیج فیلتر اضافه شود
        //
        return showSP("SaleShowCustomerAllocatedAccount", tParameters, true);
    }

    default SaleCustomerAllocatedAccount saleShowCustomerAllocatedAccountByID(BigDecimal MID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", "And Main.MID = " + MID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        //
        return showSP("SaleShowCustomerAllocatedAccount", tParameters, true).get(0);
    }

    default SaleCustomerAllocatedAccount saleInsCustomerAllocatedAccount(SaleCustomerAllocatedAccount saleCustomerAllocatedAccount) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("CustomerID", saleCustomerAllocatedAccount.getCustomerID()));
        tParameters.add(new TParameter<>("BankID", saleCustomerAllocatedAccount.getBankID()));
        tParameters.add(new TParameter<>("BankBranchDesc", saleCustomerAllocatedAccount.getBankBranchDesc()));
        tParameters.add(new TParameter<>("BankAccountNumber", saleCustomerAllocatedAccount.getBankAccountNumber()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        BigDecimal newID = insSP("SaleInsCustomerAllocatedAccount", tParameters);
        //
        return saleShowCustomerAllocatedAccountByID(newID);
    }

    default SaleCustomerAllocatedAccount saleUpdCustomerAllocatedAccount(BigDecimal mID, SaleCustomerAllocatedAccount saleCustomerAllocatedAccount) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("MID", mID));
        tParameters.add(new TParameter<>("CustomerID", saleCustomerAllocatedAccount.getCustomerID()));
        tParameters.add(new TParameter<>("BankID", saleCustomerAllocatedAccount.getBankID()));
        tParameters.add(new TParameter<>("BankBranchDesc", saleCustomerAllocatedAccount.getBankBranchDesc()));
        tParameters.add(new TParameter<>("BankAccountNumber", saleCustomerAllocatedAccount.getBankAccountNumber()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        updSP("SaleUpdCustomerAllocatedAccount", tParameters);
        //
        return saleShowCustomerAllocatedAccountByID(mID);
    }

    default void SaleDelCustomerAllocatedAccount(BigDecimal mId) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("MID", mId));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        delSP("SaleDelCustomerAllocatedAccount", tParameters);
    }

}
