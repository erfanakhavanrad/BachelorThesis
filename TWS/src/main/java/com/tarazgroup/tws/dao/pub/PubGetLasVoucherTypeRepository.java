package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.pub.PubGetLastVoucherType;
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
public interface PubGetLasVoucherTypeRepository extends TCrudRepository<PubGetLastVoucherType>, CrudRepository<PubGetLastVoucherType, BigDecimal> {

    default List<PubGetLastVoucherType> pubGetLastVoucherType(BigDecimal voucherHeaderID, BigDecimal voucherTypeID, BigDecimal voucherDetailID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        tParameters.add(new TParameter<>("VoucherDetailID", voucherDetailID));
        return showSP("PubGetLastVoucherType", tParameters, true);
    }
}
