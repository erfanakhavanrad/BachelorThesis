package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleGetCustomer;
import com.tarazgroup.tws.util.global.TCalendar;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
public interface SaleGetCustomerRepository extends TCrudRepository<SaleGetCustomer>, CrudRepository<SaleGetCustomer, BigDecimal> {

    // متد زیر خاص نرم افزار اندرویدی تنظیم شده است
    default List<SaleGetCustomer> saleGetCustomers(
            String customerName,
            BigDecimal storeID,
            BigDecimal voucherTypeID,
            Boolean isShowCustomerByMarketingMan,
            Boolean canCreateCustomerInAndroid
    ) {
        LogLogins logLogins = fetchUserDetail();
        String filter;

        if (canCreateCustomerInAndroid == null) {
            canCreateCustomerInAndroid = false;
        }


//        if (canCreateCustomerInAndroid) {
////            اگر این فیلد
////            true
////            باشد بازاریاب حق دارد از طریق اندروید مشتری تعریف کند و همچنین وقتی لبست مشتریان در اندروید لود میشود هیچ فیلتر ندارد
//            filter = "";
//        } else {
            if (isShowCustomerByMarketingMan != null && isShowCustomerByMarketingMan) {
                filter = " AND Main.CustomerID IN (Select CustomerID FROM [dbo].[SaleAllocatedCustomer] Where MarketingManID =" + logLogins.getPubUser().getUserID() + ") ";
            } else {
                filter = " AND Main.GeoID IN (Select GeoID FROM [dbo].[SaleAllocatedMarketingMan] Where MarketingManID =" + logLogins.getPubUser().getUserID() + ") ";
            }
//        }


        if (customerName != null && !customerName.equals("")) {
            filter += " AND (PerCom.PerComFName like N'%" + customerName + "%' OR PerCom.PerComLName like N'%" + customerName + "%')";
        }
        TCalendar tCalendar = new TCalendar();
        tCalendar.setGregorianDate(new Date());
        String VoucherDate = tCalendar.getIranianDateBySlashZero();

        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", filter));
        tParameters.add(new TParameter<>("VoucherDate", VoucherDate));
        tParameters.add(new TParameter<>("RefTypeID", null));
        tParameters.add(new TParameter<>("StoreID", storeID));
        tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        tParameters.add(new TParameter<>("VoucherHeaderID", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        tParameters.add(new TParameter<>("IsCredit", false));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        return showSP("SaleGetCustomers", tParameters, true);
    }

    default List<SaleGetCustomer> saleGetCustomer(SaleGetCustomer saleGetCustomer) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("VoucherDate", null));
        tParameters.add(new TParameter<>("RefTypeID", null));
        tParameters.add(new TParameter<>("StoreID", null));
        tParameters.add(new TParameter<>("VoucherTypeID", null));
        tParameters.add(new TParameter<>("VoucherHeaderID", null));
        tParameters.add(new TParameter<>("PageFilter", saleGetCustomer._pageFilter()));
        tParameters.add(new TParameter<>("IsCredit", false));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        return showSP("SaleGetCustomers", tParameters, true);
    }

    default SaleGetCustomer saleGetCustomerByID(BigDecimal customerID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("Filter", " AND Main.customerID = " + customerID));
        tParameters.add(new TParameter<>("VoucherDate", null));
        tParameters.add(new TParameter<>("RefTypeID", null));
        tParameters.add(new TParameter<>("StoreID", null));
        tParameters.add(new TParameter<>("VoucherTypeID", null));
        tParameters.add(new TParameter<>("VoucherHeaderID", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        tParameters.add(new TParameter<>("IsCredit", false));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        return showSP("SaleGetCustomers", tParameters, true).get(0);
    }

}
