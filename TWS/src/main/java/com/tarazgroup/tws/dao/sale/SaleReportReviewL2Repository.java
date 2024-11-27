package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.sale.SaleReportReviewL2;
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
 * @author Salman Majidi
 * @since 2.0.0
 */
public interface SaleReportReviewL2Repository extends TCrudRepository<SaleReportReviewL2>, CrudRepository<SaleReportReviewL2, BigDecimal> {

    default List<SaleReportReviewL2> saleReportReviewL2(
            String filter,
            String otherFilter,
            String serverFilter,
            String yearFilter,
            String userAccessFilter,
            BigDecimal voucherTypeID,
            int repType,
            boolean isShowElements,
            boolean isRightJoin,
            boolean isBuyRep,
            int buyType,
            boolean isBonus,
            boolean isSecQuantity
            ) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", filter));
        tParameters.add(new TParameter<>("OtherFilter", otherFilter));
        tParameters.add(new TParameter<>("ServerFilter", serverFilter));
        tParameters.add(new TParameter<>("YearFilter", yearFilter));
        tParameters.add(new TParameter<>("UserAccessFilter", userAccessFilter));
        tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        tParameters.add(new TParameter<>("RepType", repType));
        tParameters.add(new TParameter<>("IsShowElements", isShowElements));
        tParameters.add(new TParameter<>("IsRightJoin", isRightJoin));
        tParameters.add(new TParameter<>("IsBuyRep", isBuyRep));
        tParameters.add(new TParameter<>("BuyType", buyType));
        tParameters.add(new TParameter<>("IsBonus", isBonus));
        tParameters.add(new TParameter<>("IsSecQuantity", isSecQuantity));
        return showSP("SaleReport_Review_L2", tParameters, true);
    }

    default SaleReportReviewL2 saleReportReviewL2ByID(
            BigDecimal voucherHeaderID,
            BigDecimal voucherTypeID
    ) {
        // این متد خاص سیم و کابل نوشته شده است ولی ممکن است برای سایر موارد هم کاربردداشته باشد
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND main.voucherHeaderID="+voucherHeaderID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        tParameters.add(new TParameter<>("RepType", null));
        tParameters.add(new TParameter<>("IsShowElements", null));
        tParameters.add(new TParameter<>("IsRightJoin", null));
        tParameters.add(new TParameter<>("IsBuyRep", null));
        tParameters.add(new TParameter<>("BuyType", null));
        tParameters.add(new TParameter<>("IsBonus", null));
        tParameters.add(new TParameter<>("IsSecQuantity", null));
        return showSP("SaleReport_Review_L2", tParameters, true).get(0);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"classID","classID", Type.DECIMAL,0, false,false,    true));
        cols.add(new Col(null,"classCode", "کد", Type.STRING,50, true,true,   false));
        cols.add(new Col(null,"classDesc", "شرح", Type.STRING,200, true,true,   false));
        return new Meta(cols);
    }
}
