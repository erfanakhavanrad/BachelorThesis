package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.WebAccReportAccountReview4Post;
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
public interface WebAccReportAccountReview4PostRepository extends TCrudRepository<WebAccReportAccountReview4Post>, CrudRepository<WebAccReportAccountReview4Post, BigDecimal> {

    default List<WebAccReportAccountReview4Post> accountReview4Post(String fromBujCode, String toBujCode, String fromDate, String toDate,
                                                                    String compCode, String costCode, Boolean isCost, Integer inComeType) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FromBujCode", fromBujCode));
        tParameters.add(new TParameter<>("ToBujCode", toBujCode));
        tParameters.add(new TParameter<>("FromDate", fromDate));
        tParameters.add(new TParameter<>("ToDate",toDate));
        tParameters.add(new TParameter<>("CompCode",compCode));
        tParameters.add(new TParameter<>("CostCode",costCode));
        tParameters.add(new TParameter<>("IsCost",isCost));
        tParameters.add(new TParameter<>("InComeType",inComeType));
        return showSP("Web_AccReport_AccountReview_4Post",tParameters, true);
    }
}
