package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.tkt.TktOutOfWorkHour;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 5/30/22
 *
 * @author Erfan Akhavan
 */
public interface TktOutOfWorkHourRepository extends TCrudRepository<TktOutOfWorkHour>, CrudRepository<TktOutOfWorkHour, BigDecimal> {


    default List<TktOutOfWorkHour> tktShowOutOfWorkHour() {
        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("PageFilter",null));
        return showSP("TktShowOutOfWorkHour", tParameters, true);
    }

}
