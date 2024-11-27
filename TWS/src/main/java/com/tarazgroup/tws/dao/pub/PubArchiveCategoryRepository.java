package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.pub.PubArchiveCategory;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 * Dec 14 2021
 */
public interface PubArchiveCategoryRepository extends TCrudRepository<PubArchiveCategory>, CrudRepository<PubArchiveCategory, BigDecimal> {
    default List<PubArchiveCategory> pubShowArchiveCategory(PubArchiveCategory pubArchiveCategory) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", pubArchiveCategory._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", pubArchiveCategory._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", pubArchiveCategory._pageFilter()));
        return showSP("PubShowArchiveCategory", tParameters, true);
    }

    default PubArchiveCategory pubShowArchiveCategoryByID(BigDecimal categoryID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.CategoryID = " + categoryID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("PubShowArchiveCategory", tParameters, true).get(0);
    }

    default PubArchiveCategory pubInsArchiveCategory(PubArchiveCategory pubArchiveCategory) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CategoryCode", pubArchiveCategory.getCategoryCode()));
        tParameters.add(new TParameter<>("CategoryName", pubArchiveCategory.getCategoryName()));
        tParameters.add(new TParameter<>("WorkStationID", pubArchiveCategory.getWorkStationID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("PubInsArchiveCategory", tParameters);
        return pubShowArchiveCategoryByID(newID);
    }

    default PubArchiveCategory pubUpdArchiveCategory(BigDecimal categoryID, PubArchiveCategory pubArchiveCategory) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CategoryID", categoryID));
        tParameters.add(new TParameter<>("CategoryCode", pubArchiveCategory.getCategoryCode()));
        tParameters.add(new TParameter<>("CategoryName", pubArchiveCategory.getCategoryName()));
        tParameters.add(new TParameter<>("WorkStationID", pubArchiveCategory.getWorkStationID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("PubUpdArchiveCategory", tParameters);
        return pubShowArchiveCategoryByID(categoryID);
    }

    default void pubDelArchiveCategory(BigDecimal categoryID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CategoryID", categoryID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("PubDelArchiveCategory", tParameters);
    }
}
