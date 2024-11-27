package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.sale.SaleSaleType;
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
public interface SaleSaleTypeRepository extends TCrudRepository<SaleSaleType>, CrudRepository<SaleSaleType, BigDecimal> {

    default List<SaleSaleType> SaleShowSaleType(SaleSaleType saleSaleType) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", saleSaleType._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", saleSaleType._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", saleSaleType._pageFilter()));
        return showSP("SaleShowSaleType", tParameters, true);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        //
        cols.add(new Col(null, "saleTypeID", "saleTypeID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "saleTypeCode", "کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "saleTypeDesc", "شرح نوع فروش", Type.STRING, 130, true, true, false));
        cols.add(new Col(null, "isCurrency", "ارزی", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 120, false, true, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 120, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "isLC", "اعتباری", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "isPayment", "اقساطی", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "maxPrintCount", "تعاد دفعات مجاز چاپ فاکتور", Type.INTEGER, 100, true, true, false));
        //
        return new Meta(cols);
    }
}
