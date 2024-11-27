package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dao.crm.CrmFormRepository;
import com.tarazgroup.tws.model.crm.CrmComment;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.pub.PubButton;
import com.tarazgroup.tws.model.pub.PubQuickButtonInsert;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface PubQuickButtonInsertRepository extends TCrudRepository<PubQuickButtonInsert>, CrudRepository<PubQuickButtonInsert, BigDecimal> {
    default List<PubQuickButtonInsert> pubGetQuickButtonInsert(BigDecimal userID, BigDecimal systemID, boolean canView, PubQuickButtonInsert pubQuickButton, PubUsersRepository pubUsersRepository, CrmFormRepository crmFormRepository) throws InterruptedException {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("UserID", userID));
        tParameters.add(new TParameter<>("SystemID", systemID));
        tParameters.add(new TParameter<>("ButtonID", null));
        tParameters.add(new TParameter<>("CanView", canView));
        List<PubQuickButtonInsert> pubQuickButtons = showSP("CrmShowQuickButtonInsert", tParameters, true);


        return pubQuickButtons;
    }

    default PubQuickButtonInsert pubToggleFavorite(BigDecimal buttonID) {

        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("ButtonID", buttonID));
        tParameters.add(new TParameter("ModifierID", logLogins.getPubUser().getUserID()));
        updSP("CrmToggleFavorite", tParameters);
        return null;
    }

}
