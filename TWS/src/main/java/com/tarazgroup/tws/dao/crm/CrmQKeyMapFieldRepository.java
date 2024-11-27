package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmQKeyMapField;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 11/12/22
 *
 * @author Erfan Akhavan
 */
public interface CrmQKeyMapFieldRepository extends TCrudRepository <CrmQKeyMapField>, CrudRepository<CrmQKeyMapField, BigDecimal> {
    default List<CrmQKeyMapField> crmShowQKeyMapField(CrmQKeyMapField crmQKeyMapField) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmQKeyMapField._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmQKeyMapField._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmQKeyMapField._pageFilter()));
        return showSP("CrmShowQKeyMapField", tParameters, true);
    }

    default CrmQKeyMapField crmShowQKeyMapFieldByFieldID(BigDecimal fieldID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.fieldID=" + fieldID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowQKeyMapField", tParameters, true).get(0);
    }

    default CrmQKeyMapField crmInsQKeyMapField(CrmQKeyMapField crmQKeyMapField) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FieldID", crmQKeyMapField.getFieldID()));
        tParameters.add(new TParameter<>("QKeyID", crmQKeyMapField.getqKeyID()));
        tParameters.add(new TParameter<>("Query", crmQKeyMapField.getQuery()));
        tParameters.add(new TParameter<>("WhereCondition", crmQKeyMapField.getWhereCondition()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("CrmInsQKeyMapField", tParameters);
        return crmShowQKeyMapFieldByFieldID(newID);
    }

    default void crmDelQKeyMapField(BigDecimal fieldID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FieldID", fieldID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelQKeyMapField", tParameters);
    }

    default CrmQKeyMapField crmUpdQKeyMapField(BigDecimal fieldID, CrmQKeyMapField crmQKeyMapField) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FieldID", fieldID));
        tParameters.add(new TParameter<>("QKeyID", crmQKeyMapField.getqKeyID()));
        tParameters.add(new TParameter<>("Query", crmQKeyMapField.getQuery()));
        tParameters.add(new TParameter<>("WhereCondition", crmQKeyMapField.getWhereCondition()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdQKeyMapField", tParameters);
        return crmShowQKeyMapFieldByFieldID(fieldID);
    }

    default InputStreamResource excel(CrmQKeyMapField crmQKeyMapField) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmQKeyMapField._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmQKeyMapField._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmQKeyMapField._pageFilter()));
        List<CrmQKeyMapField> rows = showSP("CrmShowQKeyMapField", tParameters, false);
        return exportToExcel(rows, meta().getCols(), "فرم ها");
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"fieldID", "fieldID", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"qKeyID", "qKeyID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"fieldTitle", "نام فیلد", Type.STRING, 120, true, true,  false));
        cols.add(new Col(null,"tableName", "نام جدول", Type.STRING, 120, true, true,  false));
        cols.add(new Col(null,"pKName", "کلید اصلی", Type.STRING, 110, true, true,  false));
        cols.add(new Col(null,"codeName", "کد", Type.STRING, 110, true, true,  false));
        cols.add(new Col(null,"descName", "شرح", Type.STRING, 110, true, true,  false));
        cols.add(new Col(null,"query", "کوئری", Type.STRING, 300, true, true,  false));
        cols.add(new Col(null,"whereCondition", "شرط", Type.STRING, 200, true, true,  false));
        cols.add(new Col(null,"creatorID", "creatorID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"createDate", "createDate", Type.DATE, 0, false, false,  false));
        cols.add(new Col(null,"modifierID", "modifierID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"modifyDate", "modifyDate", Type.DATE, 0, false, false,  false));
        cols.add(new Col(null,"serverID", "serverID", Type.INTEGER, 0, false, false,  false));
        return new Meta(cols);
    }
}
