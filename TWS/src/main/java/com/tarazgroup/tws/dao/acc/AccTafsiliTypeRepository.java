package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccTafsiliType;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
public interface AccTafsiliTypeRepository extends TCrudRepository<AccTafsiliType>, CrudRepository<AccTafsiliType, BigDecimal> {

    default List<AccTafsiliType> accShowTafsiliType(AccTafsiliType accTafsiliType) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accTafsiliType._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accTafsiliType._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", accTafsiliType._pageFilter()));
        return showSP("AccShowTafsiliType", tParameters, true);
    }

    default AccTafsiliType accShowTafsiliTypeByID(BigDecimal tafsiliTypeID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.TafsiliTypeID = " + tafsiliTypeID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("AccShowTafsiliType", tParameters, true).get(0);
    }

    default AccTafsiliType accInsTafsiliType(AccTafsiliType accTafsiliType) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("TafsiliTypeDesc", accTafsiliType.getTafsiliTypeDesc()));
        tParameters.add(new TParameter<>("StartNumber", accTafsiliType.getStartNumber()));
        tParameters.add(new TParameter<>("FinishNumber", accTafsiliType.getFinishNumber()));
        tParameters.add(new TParameter<>("RefTableName", null));
        tParameters.add(new TParameter<>("RefFieldName", null));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getCreatorID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("isAutoCode", accTafsiliType.isAutoCode()));
        tParameters.add(new TParameter<>("isAutoDelete", accTafsiliType.isAutoDelete()));
        tParameters.add(new TParameter<>("TafsiliIdentity", accTafsiliType.getTafsiliIdentity()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("TafsiliKindID", accTafsiliType.getTafsiliKindID()));
        tParameters.add(new TParameter<>("ShowInLevels", accTafsiliType.getShowInLevels()));
        BigDecimal newID = insSP("AccInsTafsiliType", tParameters);
        return accShowTafsiliTypeByID(newID);
    }

    default void accDelTafsiliType(BigDecimal tafsiliTypeID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("TafsiliTypeID", tafsiliTypeID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("AccDelTafsiliType", tParameters);
    }

    default AccTafsiliType accUpdTafsiliType(BigDecimal tafsiliTypeID, AccTafsiliType accTafsiliType) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("TafsiliTypeID", tafsiliTypeID));
        tParameters.add(new TParameter<>("TafsiliTypeDesc", accTafsiliType.getTafsiliTypeDesc()));
        tParameters.add(new TParameter<>("StartNumber", accTafsiliType.getStartNumber()));
        tParameters.add(new TParameter<>("FinishNumber", accTafsiliType.getFinishNumber()));
        tParameters.add(new TParameter<>("RefFieldName", accTafsiliType.getRefFieldName()));
        tParameters.add(new TParameter<>("RefTableName", accTafsiliType.getRefTableName()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("isAutoCode", accTafsiliType.isAutoCode()));
        tParameters.add(new TParameter<>("isAutoDelete", accTafsiliType.isAutoDelete()));
        tParameters.add(new TParameter<>("TafsiliIdentity", accTafsiliType.getTafsiliIdentity()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("TafsiliKindID", accTafsiliType.getTafsiliKindID()));
        tParameters.add(new TParameter<>("ShowInLevels", accTafsiliType.getShowInLevels()));
        updSP("AccUpdTafsiliType", tParameters);
        return accShowTafsiliTypeByID(tafsiliTypeID);
    }
}
