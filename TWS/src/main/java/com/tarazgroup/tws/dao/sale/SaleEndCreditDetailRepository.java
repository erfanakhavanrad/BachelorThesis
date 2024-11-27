package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleEndCreditDetail;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Salehi
 */

public interface SaleEndCreditDetailRepository extends TCrudRepository<SaleEndCreditDetail>, CrudRepository<SaleEndCreditDetail, BigDecimal> {

    default List<SaleEndCreditDetail> saleShowEndCreditDetail(SaleEndCreditDetail saleEndCreditDetail) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", saleEndCreditDetail._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", saleEndCreditDetail._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        // TODO در این اس پی باید پیج فیلتر اضافه شود
        //
        return showSP("SaleShowEndCreditDetail", tParameters, true);
    }

    default SaleEndCreditDetail saleShowEndCreditDetailById(BigDecimal voucherDetailID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", "And Det.voucherDetailID = " + voucherDetailID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        //
        return showSP("SaleShowEndCreditDetail", tParameters, true).get(0);
    }

    default SaleEndCreditDetail saleInsEndCreditDetail(SaleEndCreditDetail saleEndCreditDetail) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("VoucherHeaderID", saleEndCreditDetail.getVoucherHeaderID()));
        tParameters.add(new TParameter<>("CustomerID", saleEndCreditDetail.getCustomerID()));
        tParameters.add(new TParameter<>("EndCashCredit", saleEndCreditDetail.getEndCashCredit()));
        tParameters.add(new TParameter<>("EndCheckCredit", saleEndCreditDetail.getEndCheckCredit()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsInVoucher", saleEndCreditDetail.getIsInVoucher()));
        tParameters.add(new TParameter<>("LeastCredit", saleEndCreditDetail.getLeastCredit()));
        tParameters.add(new TParameter<>("PersonTypeID", saleEndCreditDetail.getPersonTypeID()));
        tParameters.add(new TParameter<>("CountOpenFact", saleEndCreditDetail.getCountOpenFact()));
        //
        BigDecimal newID = insSP("SaleInsEndCreditDetail", tParameters);
        //
        return saleShowEndCreditDetailById(newID);
    }

    default SaleEndCreditDetail saleUpdEndCreditDetail(BigDecimal voucherDetailID, SaleEndCreditDetail saleEndCreditDetail) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("VoucherDetailID", voucherDetailID));
        tParameters.add(new TParameter<>("CustomerID", saleEndCreditDetail.getCustomerID()));
        tParameters.add(new TParameter<>("EndCashCredit", saleEndCreditDetail.getEndCashCredit()));
        tParameters.add(new TParameter<>("EndCheckCredit", saleEndCreditDetail.getEndCheckCredit()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsInVoucher", saleEndCreditDetail.getIsInVoucher()));
        tParameters.add(new TParameter<>("LeastCredit", saleEndCreditDetail.getLeastCredit()));
        tParameters.add(new TParameter<>("PersonTypeID", saleEndCreditDetail.getPersonTypeID()));
        tParameters.add(new TParameter<>("CountOpenFact", saleEndCreditDetail.getCountOpenFact()));
        //
        updSP("SaleUpdEndCreditDetail", tParameters);
        //
        return saleShowEndCreditDetailById(voucherDetailID);
    }

    default void saleDelEndCreditDetail(BigDecimal voucherDetailID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("VoucherDetailID", voucherDetailID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        delSP("SaleDelEndCreditDetail", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        //
        cols.add(new Col(null, "voucherDetailID", "voucherDetailID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "voucherHeaderID", "voucherHeaderID", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "customerID", "customerID", Type.DECIMAL, 130, true, true, false));
        cols.add(new Col(null, "endCashCredit", "بدهی اعتبارس", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "endCheckCredit", "بدهی اسنادی", Type.DECIMAL, 120, true, true, false));
        cols.add(new Col(null, "totalEndCredit", "جمع سقف اعتبار", Type.DECIMAL, 120, true, true, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 120, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "customerCode", "کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "percomCode", "serverID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "percomLname", "نام خانوادگی", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "perComFName", "نام/عنوان", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "isInVoucher", "serverID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "isInVoucherDesc", "محدوده سند", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "leastCredit", "حداقل اعتبار", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "personTypeID", "personTypeID", Type.INTEGER, 100, false, false, false));
        cols.add(new Col(null, "personTypeDesc", "نوع شخص", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "countOpenFact", "تعداد فاکتور تسویه نشده", Type.DECIMAL, 100, true, true, false));
        //
        return new Meta(cols);
    }
}
