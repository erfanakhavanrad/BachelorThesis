package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccBalanceFormula;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */
public interface AccBalanceFormulaRepository extends TCrudRepository<AccBalanceFormula>, CrudRepository<AccBalanceFormula, BigDecimal> {
    default List<AccBalanceFormula> accShowBalanceFormula(AccBalanceFormula accBalanceFormula) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accBalanceFormula._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accBalanceFormula._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", accBalanceFormula._pageFilter()));
        return showSP("AccShowBalanceFormula", tParameters, true);
    }

    default AccBalanceFormula accShowBalanceFormulaByID(BigDecimal formulaID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.FormulaID = " + formulaID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("AccShowBalanceFormula", tParameters, true).get(0);
    }

    default AccBalanceFormula accInsBalanceFormula(AccBalanceFormula accBalanceFormula) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("FormulaDesc", accBalanceFormula.getFormulaDesc()));
        tParameters.add(new TParameter<>("FormulaText", accBalanceFormula.getFormulaText()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("AccInsBalanceFormula", tParameters);
        return accShowBalanceFormulaByID(newID);
    }

    default AccBalanceFormula accUpdBalanceFormula(BigDecimal formulaID, AccBalanceFormula accBalanceFormula) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("FormulaID", formulaID));
        tParameters.add(new TParameter<>("FormulaDesc", accBalanceFormula.getFormulaDesc()));
        tParameters.add(new TParameter<>("FormulaText", accBalanceFormula.getFormulaText()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("AccUpdBalanceFormula", tParameters);
        return accShowBalanceFormulaByID(formulaID);
    }

    default void accDelBalanceFormula(BigDecimal formulaID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
            tParameters.add(new TParameter<>("FormulaID", formulaID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("AccDelBalanceFormula", tParameters);
    }
}
