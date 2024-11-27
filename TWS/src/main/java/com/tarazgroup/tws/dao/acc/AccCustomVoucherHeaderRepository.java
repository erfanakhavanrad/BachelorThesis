package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccCustomVoucherHeader;
import com.tarazgroup.tws.model.log.LogLogins;
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
public interface AccCustomVoucherHeaderRepository extends TCrudRepository<AccCustomVoucherHeader>, CrudRepository<AccCustomVoucherHeader, BigDecimal> {

    default List<AccCustomVoucherHeader> accShowCustomVoucherHeader(AccCustomVoucherHeader accCustomVoucherHeader){
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter",null));
        tParameters.add(new TParameter<>("OtherFilter",null));
        tParameters.add(new TParameter<>("ServerFilter",accCustomVoucherHeader._pageFilter()));
        tParameters.add(new TParameter<>("YearFilter",accCustomVoucherHeader._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter",null));
        tParameters.add(new TParameter<>("PageFilter",accCustomVoucherHeader._pageFilter()));
        return showSP("AccShowCustomVoucherHeader",tParameters,true);
    }

    default AccCustomVoucherHeader accShowCustomVoucherHeaderByID(BigDecimal voucherID){
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter"," AND Main.VoucherID = " + voucherID));
        tParameters.add(new TParameter<>("OtherFilter",null));
        tParameters.add(new TParameter<>("ServerFilter",null));
        tParameters.add(new TParameter<>("YearFilter",null));
        tParameters.add(new TParameter<>("UserAccessFilter",null));
        tParameters.add(new TParameter<>("PageFilter",null));
        return showSP("AccShowCustomVoucherHeader",tParameters,true).get(0);
    }

    default AccCustomVoucherHeader accInsCustomVoucherHeader(AccCustomVoucherHeader accCustomVoucherHeader) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherNumber", accCustomVoucherHeader.getVoucherNumber()));
        tParameters.add(new TParameter<>("VoucherDate", accCustomVoucherHeader.getVoucherDate()));
        tParameters.add(new TParameter<>("VoucherDateG", accCustomVoucherHeader.getVoucherDateG()));
        tParameters.add(new TParameter<>("SerialCode", accCustomVoucherHeader.getSerialCode()));
        tParameters.add(new TParameter<>("DayCode", accCustomVoucherHeader.getDayCode()));
        tParameters.add(new TParameter<>("SecondaryCode", accCustomVoucherHeader.getSecondaryCode()));
        tParameters.add(new TParameter<>("ReferNumber", accCustomVoucherHeader.getReferNumber()));
        tParameters.add(new TParameter<>("ReferDate", accCustomVoucherHeader.getReferDate()));
        tParameters.add(new TParameter<>("RefrenceNumber", accCustomVoucherHeader.getRefrenceNumber()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("YearID", accCustomVoucherHeader.getYearID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsDay", accCustomVoucherHeader.getIsDay()));
        tParameters.add(new TParameter<>("DayCount", accCustomVoucherHeader.getDayCount()));
        tParameters.add(new TParameter<>("VoucherDesc", accCustomVoucherHeader.getVoucherDesc()));
        BigDecimal newID = insSP("AccInsCustomVoucherHeader", tParameters);
        return accShowCustomVoucherHeaderByID(newID);
    }

    default AccCustomVoucherHeader accUpdCustomVoucherHeader(BigDecimal voucherID, AccCustomVoucherHeader accCustomVoucherHeader) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherID", voucherID));
        tParameters.add(new TParameter<>("VoucherNumber", accCustomVoucherHeader.getVoucherNumber()));
        tParameters.add(new TParameter<>("VoucherDate", accCustomVoucherHeader.getVoucherDate()));
        tParameters.add(new TParameter<>("VoucherDateG", accCustomVoucherHeader.getVoucherDateG()));
        tParameters.add(new TParameter<>("SerialCode", accCustomVoucherHeader.getSerialCode()));
        tParameters.add(new TParameter<>("DayCode", accCustomVoucherHeader.getDayCode()));
        tParameters.add(new TParameter<>("SecondaryCode", accCustomVoucherHeader.getSecondaryCode()));
        tParameters.add(new TParameter<>("ReferNumber", accCustomVoucherHeader.getReferNumber()));
        tParameters.add(new TParameter<>("ReferDate", accCustomVoucherHeader.getReferDate()));
        tParameters.add(new TParameter<>("RefrenceNumber", accCustomVoucherHeader.getRefrenceNumber()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("YearID", accCustomVoucherHeader.getYearID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("VoucherDesc", accCustomVoucherHeader.getVoucherDesc()));
        updSP("AccUpdCustomVoucherHeader", tParameters);
        return accShowCustomVoucherHeaderByID(voucherID);
    }

    default void accDelCustomVoucherHeader(BigDecimal voucherID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherID", voucherID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("AccDelCustomVoucherHeader", tParameters);
    }
}
