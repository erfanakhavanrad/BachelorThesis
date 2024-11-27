package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvGroupFormula;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 * Dec-20, 2021
 */
// TODO: 12/20/21 Doesn't have page filter

public interface InvGroupFormulaRepository extends TCrudRepository<InvGroupFormula>, CrudRepository<InvGroupFormula, BigDecimal> {
    default List<InvGroupFormula> invShowGroupFormula(InvGroupFormula invGroupFormula) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invGroupFormula._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invGroupFormula._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("InvShowGroupFormula", tParameters, true);
    }

    default InvGroupFormula invShowGroupFormulaByID(BigDecimal formulaID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.formulaID = " + formulaID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("InvShowGroupFormula", tParameters, true).get(0);
    }

    default InvGroupFormula invInsGroupFormula(InvGroupFormula invGroupFormula) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("GroupID", invGroupFormula.getGroupID()));
        tParameters.add(new TParameter<>("FormulaText", invGroupFormula.getFormulaText()));
        tParameters.add(new TParameter<>("FormulaType", invGroupFormula.getFormulaType()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("InvInsGroupFormula", tParameters);
        return invShowGroupFormulaByID(newID);
    }

    default InvGroupFormula invUpdGroupFormula(BigDecimal formulaID, InvGroupFormula invGroupFormula) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormulaID", formulaID));
        tParameters.add(new TParameter<>("GroupID", invGroupFormula.getGroupID()));
        tParameters.add(new TParameter<>("FormulaText", invGroupFormula.getFormulaText()));
        tParameters.add(new TParameter<>("FormulaType", invGroupFormula.getFormulaType()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("InvUpdGroupFormula", tParameters);
        return invShowGroupFormulaByID(formulaID);
    }

    default void invDelGroupFormula(BigDecimal formulaID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormulaID", formulaID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("InvDelGroupFormula", tParameters);
    }
}
