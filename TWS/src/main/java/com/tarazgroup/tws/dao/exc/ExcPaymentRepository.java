package com.tarazgroup.tws.dao.exc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.exc.ExcPayment;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */

// TODO: 12/8/21 Doesn't have page filter

public interface ExcPaymentRepository extends TCrudRepository<ExcPayment>, CrudRepository<ExcPayment, BigDecimal> {
    default List<ExcPayment> excShowPayment(ExcPayment excPayment) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", excPayment._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", excPayment._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("ExcShowPayment", tParameters, true);
    }
// TODO: 12/15/21 کلید اصلی وجود ندارد
//            کلید اصلی در entity جست و جو شد. در InsertSP جست و جو شد.
//   لازم است تا کلید اصلی با توجه به union های زیادی که در SP موجود میباشد ساخته شود.  در حال حاضر repository مقدار  null برمیگرداند


//    default ExcPayment excShowPaymentByID() {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("Filter", null));
//        tParameters.add(new TParameter<>("OtherFilter", null));
//        tParameters.add(new TParameter<>("ServerFilter", null));
//        tParameters.add(new TParameter<>("YearFilter", null));
//        tParameters.add(new TParameter<>("UserAccessFilter", null));
//        return null;
//    }

                                    /*
                                    exc is not necessary
                                     */
    //    default ExcPayment excInsPayment(ExcPaymentDto excPaymentDto) {
//        LogLogins logLogins = fetchUserDetail();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("VoucherHeaderID", excPaymentDto.getVoucherHeaderID()));
//        tParameters.add(new TParameter<>("VoucherDetailID", excPaymentDto.getVoucherDetailID()));
//        tParameters.add(new TParameter<>("DocNum", excPaymentDto.getDocNum()));
//        tParameters.add(new TParameter<>("DocPrice", excPaymentDto.getDocPrice()));
//        tParameters.add(new TParameter<>("DocDate", excPaymentDto.getDocDate()));
//        tParameters.add(new TParameter<>("BankID", excPaymentDto.getBankID()));
//        tParameters.add(new TParameter<>("AccountDesc", excPaymentDto.getAccountDesc()));
//        tParameters.add(new TParameter<>("PlaceID", excPaymentDto.getPlaceID()));
//        tParameters.add(new TParameter<>("DetailXDesc", excPaymentDto.getDetailXDesc()));
//        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        tParameters.add(new TParameter<>("BankBranch", excPaymentDto.getBankBranch()));
//        tParameters.add(new TParameter<>("ChequeDefineID", excPaymentDto.getChequeDefineID()));
//        tParameters.add(new TParameter<>("TafsiliID", excPaymentDto.getTafsiliID()));
//        tParameters.add(new TParameter<>("YearID", excPaymentDto.getYearID()));
//        tParameters.add(new TParameter<>("DetVoucherTypeID", excPaymentDto.getDetVoucherTypeID()));
//        tParameters.add(new TParameter<>("DetVoucherHeaderID", excPaymentDto.getDetVoucherHeaderID()));
//        tParameters.add(new TParameter<>("VoucherTypeID", excPaymentDto.getDetVoucherTypeID()));
//        tParameters.add(new TParameter<>("RecieptTypeId", excPaymentDto.getRecieptTypeId()));
//        tParameters.add(new TParameter<>("VoucherDateG", excPaymentDto.getVoucherDateG()));
//        tParameters.add(new TParameter<>("CashID", excPaymentDto.getCashID()));
//        tParameters.add(new TParameter<>("OtherSideID", excPaymentDto.getOtherSideID()));
//        tParameters.add(new TParameter<>("CustomFieldNo", excPaymentDto.getCustomFieldNo()));
//        tParameters.add(new TParameter<>("Center1ID", excPaymentDto.getCenter1ID()));
//        tParameters.add(new TParameter<>("Center2ID", excPaymentDto.getCenter2ID()));
//        tParameters.add(new TParameter<>("Center3ID", excPaymentDto.getCenter3ID()));
//        tParameters.add(new TParameter<>("SalesManID", excPaymentDto.getSalesManID()));
//        tParameters.add(new TParameter<>("MarketingManID", excPaymentDto.getMarketingManID()));
//        tParameters.add(new TParameter<>("DistNameID", excPaymentDto.getDistNameID()));
//        tParameters.add(new TParameter<>("DriverID", excPaymentDto.getDriverID()));
//        tParameters.add(new TParameter<>("CurrencyID", excPaymentDto.getCurrencyID()));
//        BigDecimal newID = insSP("ExcInsPayment", tParameters);
//        return null;
//    }
    // TODO: 12/15/21 ExcDelPayment SP has issues in SSMS and there is no ID to delete
//    default void excDelPayment() {
//        LogLogins logLogins = fetchUserDetail();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//    }
}
