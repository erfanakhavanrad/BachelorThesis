package com.tarazgroup.tws.dao.exc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.exc.ExcProduct;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 * Dec-20, 2021
 */

// TODO: 12/20/21 doesn't have page filter

public interface ExcProductRepository extends TCrudRepository<ExcProduct>, CrudRepository<ExcProduct, BigDecimal> {
    default List<ExcProduct> excShowProduct(ExcProduct excProduct) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", excProduct._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", excProduct._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("ExcShowProduct", tParameters,true);
    }

    default ExcProduct excShowProductByID(BigDecimal productID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.productID  = " + productID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("ExcShowProduct", tParameters,true).get(0);
    }

    default ExcProduct excInsProduct(ExcProduct excProduct) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ProductCode", excProduct.getProductCode()));
        tParameters.add(new TParameter<>("ProductDescLatin", excProduct.getProductDescLatin()));
        tParameters.add(new TParameter<>("ProductDesc", excProduct.getProductDesc()));
        tParameters.add(new TParameter<>("ProductTypeID", excProduct.getProductTypeID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("Symbol", excProduct.getSymbol()));
        tParameters.add(new TParameter<>("IsNotActive", excProduct.GetIsNotActive()));
        BigDecimal newID = insSP("ExcInsProduct", tParameters);
        return excShowProductByID(newID);
    }

    default ExcProduct excUpdProduct(BigDecimal productID, ExcProduct excProduct) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ProductID", productID));
        tParameters.add(new TParameter<>("ProductCode", excProduct.getProductCode()));
        tParameters.add(new TParameter<>("ProductDescLatin", excProduct.getProductDescLatin()));
        tParameters.add(new TParameter<>("ProductDesc", excProduct.getProductDesc()));
        tParameters.add(new TParameter<>("ProductTypeID", excProduct.getProductTypeID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("Symbol", excProduct.getSymbol()));
        tParameters.add(new TParameter<>("IsNotActive", excProduct.GetIsNotActive()));
        updSP("ExcUpdProduct", tParameters);
        return excShowProductByID(productID);
    }

    default void excDelProduct(BigDecimal productID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ProductID", productID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("ExcDelProduct", tParameters);
    }

}
