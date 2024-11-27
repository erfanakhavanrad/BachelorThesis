package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.pub.PubXFieldsValue;
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
 * @author salman majidi
 * @since 2.0.0
 */
public interface PubXFieldsValueRepository extends TCrudRepository<PubXFieldsValue>, CrudRepository<PubXFieldsValue, BigDecimal> {

    default List<PubXFieldsValue> pubShowXFieldsValue(int fieldNumber, String tableName) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FieldNumber", fieldNumber));
        tParameters.add(new TParameter<>("TableName", tableName));
        return showSP("PubShowXFieldsValue", tParameters, true);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"rowNumber", "rowNumber", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"mid", "کد", Type.STRING, 50, true, true,  false));
        cols.add(new Col(null,"mdesc", "شرح", Type.STRING, 300, true, true,  false));
        return new Meta(cols);
    }
}
