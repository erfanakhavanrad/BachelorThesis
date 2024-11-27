package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleVoucherHeader;
import com.tarazgroup.tws.model.sale.SaleVoucherHeaderXFields;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Salehi
 */


public interface SaleVoucherHeaderXFieldsRepository extends TCrudRepository<SaleVoucherHeaderXFields>, CrudRepository<SaleVoucherHeaderXFields, BigDecimal> {

    default List<SaleVoucherHeaderXFields> saleShowVoucherHeaderXFields(SaleVoucherHeaderXFields saleVoucherHeaderXFields) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", saleVoucherHeaderXFields._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", saleVoucherHeaderXFields._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        //TODO ندارد PageFilter
        return showSP("SaleShowVoucherHeaderXFields", tParameters, true);
    }

    default SaleVoucherHeaderXFields saleShowVoucherHeaderXFieldsByID(BigDecimal xFieldID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", "And Main.XFieldID=" + xFieldID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("SaleShowVoucherHeaderXFields", tParameters, true).get(0);
    }

    default SaleVoucherHeaderXFields saleInsVoucherHeaderXFields(SaleVoucherHeaderXFields saleVoucherHeaderXFields) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("VoucherHeaderID", saleVoucherHeaderXFields.getVoucherHeaderID()));
        tParameters.add(new TParameter<>("CustomField26", saleVoucherHeaderXFields.getCustomField26()));
        tParameters.add(new TParameter<>("CustomField27", saleVoucherHeaderXFields.getCustomField27()));
        tParameters.add(new TParameter<>("CustomField28", saleVoucherHeaderXFields.getCustomField28()));
        tParameters.add(new TParameter<>("CustomField29", saleVoucherHeaderXFields.getCustomField29()));
        tParameters.add(new TParameter<>("CustomField30", saleVoucherHeaderXFields.getCustomField30()));
        tParameters.add(new TParameter<>("CustomField31", saleVoucherHeaderXFields.getCustomField31()));
        tParameters.add(new TParameter<>("CustomField32", saleVoucherHeaderXFields.getCustomField32()));
        tParameters.add(new TParameter<>("CustomField33", saleVoucherHeaderXFields.getCustomField33()));
        tParameters.add(new TParameter<>("CustomField34", saleVoucherHeaderXFields.getCustomField34()));
        tParameters.add(new TParameter<>("CustomField35", saleVoucherHeaderXFields.getCustomField35()));
        tParameters.add(new TParameter<>("CustomField36", saleVoucherHeaderXFields.getCustomField36()));
        tParameters.add(new TParameter<>("CustomField37", saleVoucherHeaderXFields.getCustomField37()));
        tParameters.add(new TParameter<>("CustomField38", saleVoucherHeaderXFields.getCustomField38()));
        tParameters.add(new TParameter<>("CustomField39", saleVoucherHeaderXFields.getCustomField39()));
        tParameters.add(new TParameter<>("CustomField40", saleVoucherHeaderXFields.getCustomField40()));
        tParameters.add(new TParameter<>("CustomField41", saleVoucherHeaderXFields.getCustomField41()));
        tParameters.add(new TParameter<>("CustomField42", saleVoucherHeaderXFields.getCustomField42()));
        tParameters.add(new TParameter<>("CustomField43", saleVoucherHeaderXFields.getCustomField43()));
        tParameters.add(new TParameter<>("CustomField44", saleVoucherHeaderXFields.getCustomField44()));
        tParameters.add(new TParameter<>("CustomField45", saleVoucherHeaderXFields.getCustomField45()));
        tParameters.add(new TParameter<>("CustomField46", saleVoucherHeaderXFields.getCustomField46()));
        tParameters.add(new TParameter<>("CustomField47", saleVoucherHeaderXFields.getCustomField47()));
        tParameters.add(new TParameter<>("CustomField48", saleVoucherHeaderXFields.getCustomField48()));
        tParameters.add(new TParameter<>("CustomField49", saleVoucherHeaderXFields.getCustomField49()));
        tParameters.add(new TParameter<>("CustomField50", saleVoucherHeaderXFields.getCustomField50()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("SaleInsVoucherHeaderXFields", tParameters);
        return saleShowVoucherHeaderXFieldsByID(newID);
    }


    default SaleVoucherHeaderXFields saleUpdVoucherHeaderXFields(BigDecimal xFieldID, SaleVoucherHeaderXFields saleVoucherHeaderXFields) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("XFieldID", xFieldID));
        tParameters.add(new TParameter<>("VoucherHeaderID", saleVoucherHeaderXFields.getVoucherHeaderID()));
        tParameters.add(new TParameter<>("CustomField26", saleVoucherHeaderXFields.getCustomField26()));
        tParameters.add(new TParameter<>("CustomField27", saleVoucherHeaderXFields.getCustomField27()));
        tParameters.add(new TParameter<>("CustomField28", saleVoucherHeaderXFields.getCustomField28()));
        tParameters.add(new TParameter<>("CustomField29", saleVoucherHeaderXFields.getCustomField29()));
        tParameters.add(new TParameter<>("CustomField30", saleVoucherHeaderXFields.getCustomField30()));
        tParameters.add(new TParameter<>("CustomField31", saleVoucherHeaderXFields.getCustomField31()));
        tParameters.add(new TParameter<>("CustomField32", saleVoucherHeaderXFields.getCustomField32()));
        tParameters.add(new TParameter<>("CustomField33", saleVoucherHeaderXFields.getCustomField33()));
        tParameters.add(new TParameter<>("CustomField34", saleVoucherHeaderXFields.getCustomField34()));
        tParameters.add(new TParameter<>("CustomField35", saleVoucherHeaderXFields.getCustomField35()));
        tParameters.add(new TParameter<>("CustomField36", saleVoucherHeaderXFields.getCustomField36()));
        tParameters.add(new TParameter<>("CustomField37", saleVoucherHeaderXFields.getCustomField37()));
        tParameters.add(new TParameter<>("CustomField38", saleVoucherHeaderXFields.getCustomField38()));
        tParameters.add(new TParameter<>("CustomField39", saleVoucherHeaderXFields.getCustomField39()));
        tParameters.add(new TParameter<>("CustomField40", saleVoucherHeaderXFields.getCustomField40()));
        tParameters.add(new TParameter<>("CustomField41", saleVoucherHeaderXFields.getCustomField41()));
        tParameters.add(new TParameter<>("CustomField42", saleVoucherHeaderXFields.getCustomField42()));
        tParameters.add(new TParameter<>("CustomField43", saleVoucherHeaderXFields.getCustomField43()));
        tParameters.add(new TParameter<>("CustomField44", saleVoucherHeaderXFields.getCustomField44()));
        tParameters.add(new TParameter<>("CustomField45", saleVoucherHeaderXFields.getCustomField45()));
        tParameters.add(new TParameter<>("CustomField46", saleVoucherHeaderXFields.getCustomField46()));
        tParameters.add(new TParameter<>("CustomField47", saleVoucherHeaderXFields.getCustomField47()));
        tParameters.add(new TParameter<>("CustomField48", saleVoucherHeaderXFields.getCustomField48()));
        tParameters.add(new TParameter<>("CustomField49", saleVoucherHeaderXFields.getCustomField49()));
        tParameters.add(new TParameter<>("CustomField50", saleVoucherHeaderXFields.getCustomField50()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("SaleUpdVoucherHeaderXFields", tParameters);
        return saleShowVoucherHeaderXFieldsByID(xFieldID);
    }

    default void saleDelVoucherHeaderXFields(BigDecimal xFieldID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("XFieldID", xFieldID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("SaleDelVoucherHeaderXFields",tParameters);
    }

}
