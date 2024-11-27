package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvAccountTopic;
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
 * @author Erfan Akhavan
 */
public interface InvAccountTopicRepository extends TCrudRepository<InvAccountTopic>, CrudRepository<InvAccountTopic, BigDecimal> {
    default List<InvAccountTopic> invShowAccountTopics(InvAccountTopic invAccountTopic) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invAccountTopic._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invAccountTopic._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        // TODO: 10/26/21 doesn't have page filter
        return showSP("InvShowAccountTopic", tParameters, true);
    }

    default InvAccountTopic invShowAccountTopicByID(BigDecimal topicID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.topicID=" + topicID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("InvShowAccountTopic", tParameters, true).get(0);
    }

    default InvAccountTopic invInsAccountTopic(InvAccountTopic invAccountTopic) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("VoucherTypeID", invAccountTopic.getVoucherTypeID()));
        tParameters.add(new TParameter("BedAccountID", invAccountTopic.getBedAccountID()));
        tParameters.add(new TParameter("BesAccountID", invAccountTopic.getBesAccountID()));
        tParameters.add(new TParameter("BedTafsiliTypeID", invAccountTopic.getBedTafsiliTypeID()));
        tParameters.add(new TParameter("BesTafsiliTypeID", invAccountTopic.getBesTafsiliTypeID()));
        tParameters.add(new TParameter("BedCenter1TypeID", invAccountTopic.getBedCenter1TypeID()));
        tParameters.add(new TParameter("BesCenter1TypeID", invAccountTopic.getBesCenter1TypeID()));
        tParameters.add(new TParameter("BedCenter2TypeID", invAccountTopic.getBedCenter2TypeID()));
        tParameters.add(new TParameter("BesCenter2TypeID", invAccountTopic.getBesCenter2TypeID()));
        tParameters.add(new TParameter("BedCenter3TypeID", invAccountTopic.getBedCenter3TypeID()));
        tParameters.add(new TParameter("BesCenter3TypeID", invAccountTopic.getBesCenter3TypeID()));
        tParameters.add(new TParameter("BedVoucherDesc", invAccountTopic.getBedVoucherDesc()));
        tParameters.add(new TParameter("BesVoucherDesc", invAccountTopic.getBesVoucherDesc()));
        tParameters.add(new TParameter("StoreID", invAccountTopic.getStoreID()));
        tParameters.add(new TParameter("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter("GroupID", invAccountTopic.getGroupID()));
        tParameters.add(new TParameter("BedTypes", invAccountTopic.getBedTypes()));
        tParameters.add(new TParameter("BesTypes", invAccountTopic.getBesTypes()));
        tParameters.add(new TParameter("HVTypeID", invAccountTopic.gethVTypeID()));
        BigDecimal newID = insSP("InvInsAccountTopic", tParameters);
        return invShowAccountTopicByID(newID);
    }

    // values should be passed as formulas for this sp in order to work. Otherwise, it sends a 200 status code and 0 as SP result message but nothing gets updated.
    default InvAccountTopic invUpdAccountTopic(BigDecimal topicID, InvAccountTopic invAccountTopic) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TopicID", topicID));
        tParameters.add(new TParameter<>("VoucherTypeID", invAccountTopic.getVoucherTypeID()));
        tParameters.add(new TParameter<>("BedAccountID", invAccountTopic.getBedAccountID()));
        tParameters.add(new TParameter<>("BesAccountID", invAccountTopic.getBesAccountID()));
        tParameters.add(new TParameter<>("BedTafsiliTypeID", invAccountTopic.getBedTafsiliTypeID()));
        tParameters.add(new TParameter<>("BedCenter1TypeID", invAccountTopic.getBedCenter1TypeID()));
        tParameters.add(new TParameter<>("BesCenter1TypeID", invAccountTopic.getBesCenter1TypeID()));
        tParameters.add(new TParameter<>("BedCenter2TypeID", invAccountTopic.getBedCenter2TypeID()));
        tParameters.add(new TParameter<>("BesCenter2TypeID", invAccountTopic.getBesCenter2TypeID()));
        tParameters.add(new TParameter<>("BedCenter3TypeID", invAccountTopic.getBedCenter3TypeID()));
        tParameters.add(new TParameter<>("BesCenter3TypeID", invAccountTopic.getBesCenter3TypeID()));
        tParameters.add(new TParameter<>("BesTafsiliTypeID", invAccountTopic.getBesTafsiliTypeID()));
        tParameters.add(new TParameter<>("BedVoucherDesc", invAccountTopic.getBedVoucherDesc()));
        tParameters.add(new TParameter<>("BesVoucherDesc", invAccountTopic.getBesVoucherDesc()));
        tParameters.add(new TParameter<>("StoreID", invAccountTopic.getStoreID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("GroupID", invAccountTopic.getGroupID()));
        tParameters.add(new TParameter<>("BedTypes", invAccountTopic.getBedTypes()));
        tParameters.add(new TParameter<>("BesTypes", invAccountTopic.getBesTypes()));
        tParameters.add(new TParameter<>("HVTypeID", invAccountTopic.gethVTypeID()));
        updSP("InvUpdAccountTopic", tParameters);
        return invShowAccountTopicByID(topicID);
    }

    default void invDelAccountTopic(BigDecimal topicID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TopicID", topicID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("InvDelAccountTopic", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "topicID", "topicID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "voucherTypeID", "voucherTypeID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "bedAccountID", "bedAccountID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "besAccountID", "besAccountID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "bedTafsiliTypeID", "bedTafsiliTypeID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "besTafsiliTypeID", "besTafsiliTypeID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "bedCenter1TypeID", "bedCenter1TypeID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "besCenter1TypeID", "besCenter1TypeID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "bedCenter2TypeID", "bedCenter2TypeID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "besCenter2TypeID", "besCenter2TypeID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "bedCenter3TypeID", "bedCenter3TypeID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "besCenter3TypeID", "besCenter3TypeID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "bedVoucherDesc", "شرح سند|بدهکار", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "besVoucherDesc", "شرح سند|بستانکار", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "storeID", "storeID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "customVTypeDesc", "نوع سند", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "bedAccountCode", "معین بدهکار|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "besAccountCode", "معین بستانکار|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "bedAccountDesc", "معین بدهکار|شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "besAccountDesc", "معین بستانکار|شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "storeName", "نام انبار", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "bedTafsiliTypeDesc", "تفصيلي|بدهکار", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "besTafsiliTypeDesc", "تفصيلي|بستانکار", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "bedCenter1TypeDesc", "سطح 5|بدهکار", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "besCenter1TypeDesc", "سطح 5|بستانکار", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "bedCenter2TypeDesc", "سطح 6|بدهکار", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "besCenter2TypeDesc", "سطح 6|بستانکار", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "bedCenter3TypeDesc", "bedCenter3TypeDesc", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "besCenter3TypeDesc", "besCenter3TypeDesc", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "bedTypes", "bedTypes", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "besTypes", "besTypes", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "groupID", "groupID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "groupCode", "گروه کالا|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "groupDesc", "گروه کالا|شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "hVTypeID", "hVTypeID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "hVTypeDesc", "نوع سند اصلاحی", Type.STRING, 100, true, true, false));
        return new Meta(cols);

    }
}
