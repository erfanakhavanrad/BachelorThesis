package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleAccountTopic;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 * @date Dec-25, 2021
 */
// TODO: 12/25/21 doesn't have page filter

public interface SaleAccountTopicRepository extends TCrudRepository<SaleAccountTopic>, CrudRepository<SaleAccountTopic, BigDecimal> {
    default List<SaleAccountTopic> saleShowAccountTopic(SaleAccountTopic saleAccountTopic) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", saleAccountTopic._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", saleAccountTopic._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("SaleShowAccountTopic", tParameters, true);
    }

    default SaleAccountTopic saleShowAccountTopicByID(BigDecimal topicID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", "AND Main.topicID = " + topicID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("SaleShowAccountTopic", tParameters, true).get(0);
    }

    default SaleAccountTopic saleInsAccountTopic(SaleAccountTopic saleAccountTopic) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherTypeID",saleAccountTopic.getVoucherTypeID()));
        tParameters.add(new TParameter<>("BedAccountID",saleAccountTopic.getBedAccountID()));
        tParameters.add(new TParameter<>("BesAccountID",saleAccountTopic.getBesAccountID()));
        tParameters.add(new TParameter<>("BedTafsiliTypeID",saleAccountTopic.getBedTafsiliTypeID()));
        tParameters.add(new TParameter<>("BesTafsiliTypeID",saleAccountTopic.getBesTafsiliTypeID()));
        tParameters.add(new TParameter<>("BedCenter1TypeID",saleAccountTopic.getBedCenter1TypeID()));
        tParameters.add(new TParameter<>("BesCenter1TypeID",saleAccountTopic.getBesCenter1TypeID()));
        tParameters.add(new TParameter<>("BedCenter2TypeID",saleAccountTopic.getBedCenter2TypeID()));
        tParameters.add(new TParameter<>("BesCenter2TypeID",saleAccountTopic.getBesCenter2TypeID()));
        tParameters.add(new TParameter<>("BedCenter3TypeID",saleAccountTopic.getBedCenter3TypeID()));
        tParameters.add(new TParameter<>("BesCenter3TypeID",saleAccountTopic.getBesCenter3TypeID()));
        tParameters.add(new TParameter<>("BedVoucherDesc", saleAccountTopic.getBedVoucherDesc()));
        tParameters.add(new TParameter<>("BesVoucherDesc",saleAccountTopic.getBesVoucherDesc()));
        tParameters.add(new TParameter<>("CreatorID",logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID",logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID",logLogins.getLoginId()));
        tParameters.add(new TParameter<>("SaleTypeID",saleAccountTopic.getSaleTypeID()));
        tParameters.add(new TParameter<>("GroupID", saleAccountTopic.getGroupID()));
        tParameters.add(new TParameter<>("BedTafsiliID",saleAccountTopic.getBedTafsiliID()));
        tParameters.add(new TParameter<>("BesTafsiliID",saleAccountTopic.getBesTafsiliID()));
        tParameters.add(new TParameter<>("IsReverseVoucher",saleAccountTopic.getIsReverseVoucher()));
        tParameters.add(new TParameter<>("ElementsEntryType",saleAccountTopic.getElementsEntryType()));
        tParameters.add(new TParameter<>("BedTypes",saleAccountTopic.getBedTypes()));
        tParameters.add(new TParameter<>("BesTypes",saleAccountTopic.getBesTypes()));
        BigDecimal newID = insSP("SaleInsAccountTopic", tParameters);
        return saleShowAccountTopicByID(newID);
    }

    default SaleAccountTopic saleUpdAccountTopic(BigDecimal topicID,SaleAccountTopic saleAccountTopic) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TopicID", topicID));
        tParameters.add(new TParameter<>("VoucherTypeID",saleAccountTopic.getVoucherTypeID()));
        tParameters.add(new TParameter<>("BedAccountID",saleAccountTopic.getBedAccountID()));
        tParameters.add(new TParameter<>("BesAccountID",saleAccountTopic.getBesAccountID()));
        tParameters.add(new TParameter<>("BedTafsiliTypeID",saleAccountTopic.getBedTafsiliTypeID()));
        tParameters.add(new TParameter<>("BesTafsiliTypeID",saleAccountTopic.getBesTafsiliTypeID()));
        tParameters.add(new TParameter<>("BedCenter1TypeID",saleAccountTopic.getBedCenter1TypeID()));
        tParameters.add(new TParameter<>("BesCenter1TypeID",saleAccountTopic.getBesCenter1TypeID()));
        tParameters.add(new TParameter<>("BedCenter2TypeID",saleAccountTopic.getBedCenter2TypeID()));
        tParameters.add(new TParameter<>("BesCenter2TypeID",saleAccountTopic.getBesCenter2TypeID()));
        tParameters.add(new TParameter<>("BedCenter3TypeID",saleAccountTopic.getBedCenter3TypeID()));
        tParameters.add(new TParameter<>("BesCenter3TypeID",saleAccountTopic.getBesCenter3TypeID()));
        tParameters.add(new TParameter<>("BedVoucherDesc", saleAccountTopic.getBedVoucherDesc()));
        tParameters.add(new TParameter<>("BesVoucherDesc",saleAccountTopic.getBesVoucherDesc()));
        tParameters.add(new TParameter<>("ModifierID",logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID",logLogins.getLoginId()));
        tParameters.add(new TParameter<>("SaleTypeID",saleAccountTopic.getSaleTypeID()));
        tParameters.add(new TParameter<>("GroupID", saleAccountTopic.getGroupID()));
        tParameters.add(new TParameter<>("BedTafsiliID",saleAccountTopic.getBedTafsiliID()));
        tParameters.add(new TParameter<>("BesTafsiliID",saleAccountTopic.getBesTafsiliID()));
        tParameters.add(new TParameter<>("IsReverseVoucher",saleAccountTopic.getIsReverseVoucher()));
        tParameters.add(new TParameter<>("ElementsEntryType",saleAccountTopic.getElementsEntryType()));
        tParameters.add(new TParameter<>("BedTypes",saleAccountTopic.getBedTypes()));
        tParameters.add(new TParameter<>("BesTypes",saleAccountTopic.getBesTypes()));
        updSP("SaleUpdAccountTopic", tParameters);
        return saleShowAccountTopicByID(topicID);
    }

    default void saleDelAccountTopic(BigDecimal topicID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TopicID", topicID));
        tParameters.add(new TParameter<>("LoginID",logLogins.getLoginId()));
        delSP("SaleDelAccountTopic", tParameters);
    }


}
