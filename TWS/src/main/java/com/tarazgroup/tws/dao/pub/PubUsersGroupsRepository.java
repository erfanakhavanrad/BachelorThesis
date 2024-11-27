package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.pub.PubUsersGroups;
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
public interface PubUsersGroupsRepository extends TCrudRepository<PubUsersGroups>, CrudRepository<PubUsersGroups, BigDecimal> {

    default List<PubUsersGroups> pubShowUsersGroups(PubUsersGroups pubUsersGroups) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", pubUsersGroups._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", pubUsersGroups._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("PubShowUsersGroups", tParameters, true);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"userGroupID", "userGroupID", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"userGroupCode", "کد گروه", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"userGroupFName", "نام گروه", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"userGroupEName", "نام لاتین", Type.STRING, 200, true, true,  false));
        cols.add(new Col(null,"userGroupBriefName", "نام اختصاری", Type.STRING, 100, true, true,  false));
        return new Meta(cols);
    }

}
