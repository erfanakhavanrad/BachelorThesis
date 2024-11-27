package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.sale.SaleAppointGrade;
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
public interface SaleAppointGradeRepository extends TCrudRepository<SaleAppointGrade>, CrudRepository<SaleAppointGrade, BigDecimal> {

    default List<SaleAppointGrade> saleShowAppointGrade(SaleAppointGrade saleAppointGrade) {
        // TODO در این اس پی باید پیج فیلتر اضافه شود
        List<TParameter<?>> tParameters = new ArrayList<>();
        // این کد رو نگه داشتم تا بعدا که پیج فیلتر اضافه شد بدانیم باید چه کنیم
//        tParameters.add(new TParameter<>("Filter", saleAppointGrade._filter1(filter)));
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", saleAppointGrade._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", saleAppointGrade._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("SaleShowAppointGrade", tParameters, true);
    }
}
