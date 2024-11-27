package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccTafsiliKind;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */
public interface AccTafsiliKindRepository extends TCrudRepository<AccTafsiliKind>, CrudRepository<AccTafsiliKind, BigDecimal> {
    default List<AccTafsiliKind> accShowTafsiliKind(AccTafsiliKind accTafsiliKind) {
        List<TParameter<?>> tparameters = new ArrayList<>();
        tparameters.add(new TParameter<>("Filter", null));
        tparameters.add(new TParameter<>("OtherFilter", null));
        tparameters.add(new TParameter<>("UserAccessFilter", null));
        tparameters.add(new TParameter<>("YearFilter", accTafsiliKind._yearFilter()));
        tparameters.add(new TParameter<>("PageFilter", accTafsiliKind._pageFilter()));
        return showSP("AccShowTafsiliKind", tparameters, true);
    }

    default AccTafsiliKind accShowTafsiliKindByID(BigDecimal tafsiliKindID) {
        List<TParameter<?>> tparameters = new ArrayList<>();
        tparameters.add(new TParameter<>("Filter", "AND main.tafsiliKindID=" + tafsiliKindID));
        tparameters.add(new TParameter<>("OtherFilter", null));
        tparameters.add(new TParameter<>("UserAccessFilter", null));
        tparameters.add(new TParameter<>("YearFilter", null));
        tparameters.add(new TParameter<>("PageFilter", null));
        return showSP("AccShowTafsiliKind", tparameters, true).get(0);
    }
}
