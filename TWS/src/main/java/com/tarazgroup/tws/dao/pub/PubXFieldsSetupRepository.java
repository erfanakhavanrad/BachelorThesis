package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.pub.PubXFieldsSetup;
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
 * @author salman majidi
 * @since 2.0.0
 */
public interface PubXFieldsSetupRepository extends TCrudRepository<PubXFieldsSetup>, CrudRepository<PubXFieldsSetup, BigDecimal> {

    default List<PubXFieldsSetup> pubShowXFieldsSetup(BigDecimal voucherTypeID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        // تنها فیلد هایی می آید که به یک نوع سند خاص ربط داده شده و قابل نمایش هستند
        tParameters.add(new TParameter<>("PageFilter", " AND VoucherTypeID = " + voucherTypeID + " AND ISNULL(IsVisible,0) = 1?,?"));
        List<PubXFieldsSetup> PubXFieldsSetup1 = new ArrayList();
        List<PubXFieldsSetup> pubXFieldsSetups = showSP("PubShowXFieldsSetup", tParameters, true);
        for (int i = 0; i < pubXFieldsSetups.size(); i++) {
            PubXFieldsSetup pubXFieldsSetup = pubXFieldsSetups.get(i);
            if (pubXFieldsSetup.getVoucherTypeID().intValue() == voucherTypeID.intValue()) {
                PubXFieldsSetup1.add(pubXFieldsSetup);
            }
        }
        return PubXFieldsSetup1;
    }
}
