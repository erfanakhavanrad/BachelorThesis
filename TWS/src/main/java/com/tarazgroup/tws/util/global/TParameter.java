package com.tarazgroup.tws.util.global;

import com.tarazgroup.tws.model.crm.CrmFormFieldValueTypeAk;
import com.tarazgroup.tws.util.tabletype.TElement;
import com.tarazgroup.tws.util.tabletype.TSerial;
import com.tarazgroup.tws.util.tabletype.TempT2;
import com.tarazgroup.tws.util.tabletype.TempT3;
import com.tarazgroup.tws.util.tabletype.acc.AccVDTblType;
//import com.tarazgroup.tws.util.tabletype.crm.CrmFormFieldValueType;
import com.tarazgroup.tws.util.tabletype.inv.InvGroupFormulaTblType;
import com.tarazgroup.tws.util.tabletype.inv.InvVDTblType;
import com.tarazgroup.tws.util.tabletype.pub.PubUserBATblType;
import com.tarazgroup.tws.util.tabletype.sale.SaleVDTblType;

import javax.persistence.ParameterMode;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

public class TParameter<T> {
    final private String name;

    final private String type;

    final private T value;

    private Class type1;

    private ParameterMode parameterMode;

    public TParameter(String name, T value) {
        this.name = name;
        this.type = null;
        this.value = value;
    }

    public TParameter(String name, String type, T value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public T getValue() {
        return value;
    }

    public Class getType1() {
        return type1;
    }

    public void setType1(Class type1) {
        this.type1 = type1;
    }

    public boolean isTableType() {
        //TODO سایر تیبل تایپ ها هم اضافه شود به مرور
        if (this.type1.equals(TempT2.class) ||
                this.type1.equals(TempT3.class) ||
                this.type1.equals(SaleVDTblType.class) ||
                this.type1.equals(AccVDTblType.class) ||
                this.type1.equals(InvVDTblType.class) ||
                this.type1.equals(TSerial.class) ||
                this.type1.equals(TElement.class) ||
//                this.type1.equals(CrmFormFieldValueType.class) ||
                this.type1.equals(InvGroupFormulaTblType.class) ||
                this.type1.equals(PubUserBATblType.class) ||
                this.type1.equals(CrmFormFieldValueTypeAk.class)
        ) {
            return true;
        }
        return false;
    }

    public ParameterMode getParameterMode() {
        return parameterMode;
    }

    public void setParameterMode(ParameterMode parameterMode) {
        this.parameterMode = parameterMode;
    }
}
