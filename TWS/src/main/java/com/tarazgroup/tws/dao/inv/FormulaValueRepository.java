package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.ResultErrMsgNewID;
import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.FormulaValue;
import com.tarazgroup.tws.model.inv.InvFormulaValue;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.tabletype.inv.InvGroupFormulaTblType;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@SuppressWarnings("Duplicates")
public interface FormulaValueRepository
        extends TCrudRepository<FormulaValue>, CrudRepository<FormulaValue, BigDecimal> {

    default FormulaValue invGetFormulaValue(InvFormulaValue invFormulaValue) {

        List<TParameter<?>> tParameters = new ArrayList<>();
        // پر کردن پارامتر های معمولی
        tParameters.add(new TParameter<>("GroupID", invFormulaValue.getGroupID()));
        tParameters.add(new TParameter<>("Q1", invFormulaValue.getQuantity()));
        tParameters.add(new TParameter<>("Q2", invFormulaValue.getQuantity2()));
        tParameters.add(new TParameter<>("Q3", invFormulaValue.getQuantity3()));
        tParameters.add(new TParameter<>("Q4", invFormulaValue.getFee()));

        //InvGroupFormulaTblType  پر کردن لیست
        List<InvGroupFormulaTblType> invGroupFormulaTblTypes = new ArrayList<>();
        for (int i = 0; i < invFormulaValue.getInvGroupFormulaTblTypes().length; i++) {
            invGroupFormulaTblTypes.add(invFormulaValue.getInvGroupFormulaTblTypes()[i]);
        }


        tParameters.add(new TParameter<>("TVD", "InvGroupFormulaTblType", invGroupFormulaTblTypes));
        ResultErrMsgNewID resultErrMsgNewID = execSPNativeQuery(FormulaValue.class, "InvGetFormulaValue", tParameters);
        FormulaValue formulaValue = new FormulaValue();
        formulaValue.setFormulaValue1(resultErrMsgNewID.getFormulaValue1());
        formulaValue.setFormulaValue2(resultErrMsgNewID.getFormulaValue2());
        formulaValue.setFormulaValue3(resultErrMsgNewID.getFormulaValue3());
        formulaValue.setFormulaValue4(resultErrMsgNewID.getFormulaValue4());
        return formulaValue;
    }
}
