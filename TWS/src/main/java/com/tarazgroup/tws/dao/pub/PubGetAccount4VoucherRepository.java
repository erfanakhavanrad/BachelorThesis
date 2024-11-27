package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.pub.PubGetAccount4Vouchers;
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
public interface PubGetAccount4VoucherRepository extends TCrudRepository<PubGetAccount4Vouchers>, CrudRepository<PubGetAccount4Vouchers, BigDecimal> {

    default List<PubGetAccount4Vouchers> pubGetAccount4vouchers(BigDecimal voucherTypeID, String pageFilter){
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherTypeID",voucherTypeID));
        tParameters.add(new TParameter<>("PageFilter",pageFilter));
        return showSP("PubGetAccount4Vouchers",tParameters, true);
    }
    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"accountID","accountID", Type.DECIMAL,0, false,false,    true));
        cols.add(new Col(null,"accountCode", "کد", Type.STRING,150, true,true,   false));
        cols.add(new Col(null,"accountDesc", "شرح", Type.STRING,150, true,true,   false));

        return new Meta(cols);

    }
}
