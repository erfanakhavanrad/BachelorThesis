package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SalePriceListHeader;
import com.tarazgroup.tws.util.global.TCalendar;
import com.tarazgroup.tws.util.global.TParameter;
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
public interface SalePriceListHeaderRepository extends TCrudRepository<SalePriceListHeader>, CrudRepository<SalePriceListHeader, BigDecimal> {

    default List<SalePriceListHeader> saleShowPriceListHeader(SalePriceListHeader salePriceListHeader) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", salePriceListHeader._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", salePriceListHeader._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", salePriceListHeader._pageFilter()));
        return showSP("SaleShowPriceListheader", tParameters, true);
    }

    default SalePriceListHeader saleInsPriceListHeader(SalePriceListHeader salePriceListHeader) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("VoucherNumber", salePriceListHeader.getVoucherNumber()));
        TCalendar tc = new TCalendar();
        tc.setIranianDateBySlash(salePriceListHeader.getVoucherDate());
        tParameters.add(new TParameter<>("VoucherDate", tc.getIranianDateBySlashZero()));
        tParameters.add(new TParameter<>("VoucherDateG", tc.getSqlDate()));
        tParameters.add(new TParameter<>("VoucherDesc", salePriceListHeader.getVoucherDesc()));
        tParameters.add(new TParameter<>("FromDate", salePriceListHeader.getFromDate()));
        tParameters.add(new TParameter<>("ToDate", salePriceListHeader.getToDate()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getCreatorID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("YearID", salePriceListHeader.getYearID()));
        tParameters.add(new TParameter<>("SaleCenterID", salePriceListHeader.getSaleCenterID()));
        tParameters.add(new TParameter<>("SaleTypeID", salePriceListHeader.getSaleTypeID()));
        tParameters.add(new TParameter<>("CustomerClassID", salePriceListHeader.getCustomerClassID()));
        tParameters.add(new TParameter<>("SalesClassID", salePriceListHeader.getSalesClassID()));
        tParameters.add(new TParameter<>("MarketingClassID", salePriceListHeader.getMarketingClassID()));
        tParameters.add(new TParameter<>("DeliverCenterID", salePriceListHeader.getDeliverCenterID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("StoreID", salePriceListHeader.getStoreID()));
        tParameters.add(new TParameter<>("BuyTypeID", salePriceListHeader.getBuyTypeID()));
        tParameters.add(new TParameter<>("PaymentWayIDs", salePriceListHeader.getPaymentWayIDs()));
        BigDecimal newID = insSP("SaleInsPriceListheader", tParameters);
        SalePriceListHeader temp = new SalePriceListHeader();
        temp.setVoucherHeaderID(newID);
        return saleShowPriceListHeader(temp).get(0);
    }

    default void saleDelPriceListHeader(BigDecimal voucherID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("SaleDelPriceListheader", tParameters);
    }
}
