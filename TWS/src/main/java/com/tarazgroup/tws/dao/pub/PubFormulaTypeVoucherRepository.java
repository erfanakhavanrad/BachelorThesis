package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.pub.PubFormulaTypeVoucher;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */
public interface PubFormulaTypeVoucherRepository extends TCrudRepository<PubFormulaTypeVoucher>, CrudRepository<PubFormulaTypeVoucher, BigDecimal> {
    default List<PubFormulaTypeVoucher> pubShowFormulaTypeVoucher(PubFormulaTypeVoucher pubFormulaTypeVoucher) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", pubFormulaTypeVoucher._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", pubFormulaTypeVoucher._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", pubFormulaTypeVoucher._pageFilter()));
        return showSP("PubShowFormulaTypeVoucher", tParameters, true);
    }

    default PubFormulaTypeVoucher pubShowFormulaTypeVoucherByID(BigDecimal formulaID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", "AND main.formulaID=" + formulaID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("PubShowFormulaTypeVoucher", tParameters, true).get(0);
    }

    default PubFormulaTypeVoucher pubInsFormulaTypeVoucher(PubFormulaTypeVoucher pubFormulaTypeVoucher) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormulaDesc", pubFormulaTypeVoucher.getFormulaDesc()));
        tParameters.add(new TParameter<>("FormulaText", pubFormulaTypeVoucher.getFormulaText()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("PubInsFormulaTypeVoucher", tParameters);
        return pubShowFormulaTypeVoucherByID(newID);
    }

    default PubFormulaTypeVoucher pubUpdFormulaTypeVoucher(BigDecimal formulaID, PubFormulaTypeVoucher pubFormulaTypeVoucher) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormulaID", formulaID));
        tParameters.add(new TParameter<>("FormulaDesc", pubFormulaTypeVoucher.getFormulaDesc()));
        tParameters.add(new TParameter<>("FormulaText", pubFormulaTypeVoucher.getFormulaText()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("PubUpdFormulaTypeVoucher",tParameters);
        return pubShowFormulaTypeVoucherByID(formulaID);
    }

    default void  pubDelFormulaTypeVoucher(BigDecimal formulaID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormulaID", formulaID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("PubDelFormulaTypeVoucher", tParameters);
    }
}
