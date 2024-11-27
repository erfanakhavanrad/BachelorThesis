package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.sale.SaleSysSetup;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */

public interface SaleSysSetupRepository extends TCrudRepository<SaleSysSetup>, CrudRepository<SaleSysSetup, BigDecimal> {

    default SaleSysSetup selectSaleSysSetup() {
        return findAllByNamedQuery("SaleSysSetup").get(0);
    }

}
