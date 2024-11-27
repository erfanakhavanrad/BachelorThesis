package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.model.pub.PubVoucherStat;
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
public interface PubVoucherStatRepostitory extends CrudRepository<PubVoucherStat, BigDecimal> {
}
