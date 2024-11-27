package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author A.Farahani
 */
@NamedStoredProcedureQuery(
        name = "InvGetStoreUser_Web",
        procedureName = "InvGetStoreUser_Web",
        resultClasses = {InvGetStoreUserWeb.class},
        parameters = {
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class InvGetStoreUserWeb extends TParams implements Serializable {
    @Id
    @Column(name = "StoreID")
    private BigDecimal storeID;

    @Column(name = "StoreCode")
    private String storeCode;

    @Column(name = "StoreName")
    private String storeName;

    @Column(name = "IsLCStore")
    private Boolean isLCStore;

    public BigDecimal getStoreID() {
        return storeID;
    }



    public void setStoreID(BigDecimal storeID) {
        this.storeID = storeID;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Boolean getIsLCStore() {
        return isLCStore;
    }

    public void setIsLCStore(Boolean isLCStore) {
        this.isLCStore = isLCStore;
    }
}
