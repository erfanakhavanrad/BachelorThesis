package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccProject;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
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
public interface AccProjectRepository extends TCrudRepository<AccProject>, CrudRepository<AccProject, BigDecimal> {

    default List<AccProject> accShowProject(AccProject accProject) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("Filter", null));
        tParameters.add(new TParameter("OtherFilter", ""));
        tParameters.add(new TParameter("UserAccessFilter", ""));
        tParameters.add(new TParameter("ServerFilter", ""));
        tParameters.add(new TParameter("YearFilter", ""));
        tParameters.add(new TParameter("PageFilter", accProject._pageFilter()));
        return showSP("AccShowProject", tParameters, true);
    }

    default AccProject accShowProjectByID(BigDecimal projectID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("Filter", " AND main.Projectid = " + projectID));
        tParameters.add(new TParameter("OtherFilter", ""));
        tParameters.add(new TParameter("UserAccessFilter", ""));
        tParameters.add(new TParameter("ServerFilter", ""));
        tParameters.add(new TParameter("YearFilter", ""));
        tParameters.add(new TParameter("PageFilter", null));
        return showSP("AccShowProject", tParameters, true).get(0);
    }


    default AccProject accInsProject(AccProject accProject) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("ProjectCode", accProject.getProjectCode()));
        tParameters.add(new TParameter<>("ProjectDesc", accProject.getProjectDesc()));
        tParameters.add(new TParameter<>("Tafsiliid", null));
        tParameters.add(new TParameter<>("TafsiliTypeID", accProject.getTafsiliTypeID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getCreatorID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("AccInsProject", tParameters);
        return accShowProjectByID(newID);
    }

    default void accDelProject(BigDecimal projectID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("Projectid", projectID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("AccDelProject", tParameters);
    }

    default AccProject accUpdProject(BigDecimal projectID, AccProject accProject) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("Projectid", projectID));
        tParameters.add(new TParameter<>("ProjectCode", accProject.getProjectCode()));
        tParameters.add(new TParameter<>("ProjectDesc", accProject.getProjectDesc()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("TafsiliTypeID", accProject.getTafsiliTypeID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("AccUpdProject", tParameters);
        return accShowProjectByID(projectID);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"projectID", "projectID", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"projectCode", "کد پروژه", Type.STRING, 200, true, true,  false));
        cols.add(new Col(null,"projectDesc", "شرح", Type.STRING, 730, true, true,  false));
        cols.add(new Col(null,"tafsiliid", "tafsiliid", Type.DECIMAL, 0, false, true,  false));
        cols.add(new Col(null,"tafsiliCode", "کد تفصیلی", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"tafsiliTypeID", "tafsiliTypeID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"tafsiliTypeDesc", "tafsiliTypeDesc", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"createDate", "createDate", Type.DATE, 0, false, false,  false));
        cols.add(new Col(null,"creatorID", "creatorID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"modifyDate", "modifyDate", Type.DATE, 0, false, false,  false));
        cols.add(new Col(null,"modifierID", "modifierID", Type.DECIMAL, 0, false, false,  false));
        return new Meta(cols);
    }
}
