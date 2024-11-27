package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccPerComType;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface AccPerComTypeRepository extends TCrudRepository<AccPerComType>, CrudRepository<AccPerComType, BigDecimal> {

    default public List<AccPerComType> accShowPerComtype(AccPerComType accPerComType) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", accPerComType._pageFilter()));
        return showSP("AccShowPerComType", tParameters, true);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"perComTypeID", "perComTypeID", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"perComTypeDesc", "عنوان", Type.STRING, 200, true, true,  false));
        return new Meta(cols);
    }

}
