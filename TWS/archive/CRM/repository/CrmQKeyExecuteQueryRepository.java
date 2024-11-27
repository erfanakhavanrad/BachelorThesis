package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.ShowSPReturnType;
import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmQKeyExecuteQuery;
import com.tarazgroup.tws.model.crm.CrmQKeyMapField;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@SuppressWarnings("Duplicates")
public interface CrmQKeyExecuteQueryRepository extends TCrudRepository<CrmQKeyExecuteQuery>, CrudRepository<CrmQKeyExecuteQuery, BigDecimal> {

    default List<Map<String, Object>> qKeyExecuteQuery(Map<String, String> params) {
        BigDecimal fieldID = new BigDecimal(params.get("fieldID"));
        BigDecimal pageNumber = new BigDecimal(params.get("pageNumber"));
        BigDecimal recordCount = new BigDecimal(params.get("recordCount"));
        params.remove("fieldID");
        params.remove("pageNumber");
        params.remove("recordCount");

        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FieldID", fieldID));

        StringBuilder pageFilterStringBuilder = new StringBuilder();

        for (Map.Entry<String, String> param : params.entrySet()) {
            pageFilterStringBuilder
                    .append(" AND ")
                    .append(param.getKey())
                    .append(" LIKE ")
                    .append("''%")
                    .append(param.getValue())
                    .append("%''");
        }
        String pageFilter = pageFilterStringBuilder.append("?").append(pageNumber).append(",").append(recordCount).append("?").toString();
        tParameters.add(new TParameter<>("PageFilter", pageFilter));

        List<Map<String, Object>> rows = execSPNativeQuery(CrmQKeyExecuteQuery.class, "CrmQKeyExecuteQuery", tParameters, ShowSPReturnType.MAP);
        return rows;
    }

    default Meta meta(CrmQKeyMapField crmQKeyMapField) {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, crmQKeyMapField.getpKName(), crmQKeyMapField.getpKName(), Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, crmQKeyMapField.getCodeName(), "کد", Type.STRING, 200, true, true, false));
        cols.add(new Col(null, crmQKeyMapField.getDescName(), "شرح", Type.STRING, 200, true, true, false));
        return new Meta(cols);
    }
}
