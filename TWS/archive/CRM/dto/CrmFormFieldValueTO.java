package com.tarazgroup.tws.dto.crm;

import com.tarazgroup.tws.util.tabletype.crm.CrmFormFieldValueType;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
// منظور از
// TO
//Transfer Object
//است
public class CrmFormFieldValueTO {

    private List<CrmFormFieldValueType> formFieldValues;

    public List<CrmFormFieldValueType> getFormFieldValues() {
        return formFieldValues;
    }

    public void setFormFieldValues(List<CrmFormFieldValueType> formFieldValues) {
        this.formFieldValues = formFieldValues;
    }
}
