package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.tkt.TktVisitStatus;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 5/18/22
 *
 * @author Erfan Akhavan
 */
public interface TktVisitStatusRepository extends TCrudRepository<TktVisitStatus>, CrudRepository<TktVisitStatus, BigDecimal> {


    default List<TktVisitStatus> tktShowVisitStatus(TktVisitStatus tktVisitStatus) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("PageFilter", tktVisitStatus._pageFilter()));
        return showSP("TktShowVisitStatus", tParameters, true);
    }


    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "visitID", "visitID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "isVisited", " تیکت", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "visitStatus", "وضعیت دیده شدن تیکت", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 100, false, false, false));

        return new Meta(cols);
    }


}
