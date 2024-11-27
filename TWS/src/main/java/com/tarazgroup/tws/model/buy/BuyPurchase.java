package com.tarazgroup.tws.model.buy;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "BuyInsPurchaseHD",
        procedureName = "BuyInsPurchaseHD",
        parameters = {
                @StoredProcedureParameter(name = "VoucherNumber", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDateG", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ProviderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReferNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReferDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BuyTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ExtraDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PaymentWayID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PersonBuyID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "TafsiliID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CostCenterID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReferID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CurrencyID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center1ID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center2ID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center3ID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BaseRefTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RowID", type = Timestamp.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TDel", type = Blob.class, mode = ParameterMode.IN),//we have to set `blob` for type. this is conventional.
                @StoredProcedureParameter(name = "TVD", type = Blob.class, mode = ParameterMode.IN),//we have to set `blob` for type. this is conventional.
                @StoredProcedureParameter(name = "TSerial", type = Blob.class, mode = ParameterMode.IN),//we have to set `blob` for type. this is conventional.
                @StoredProcedureParameter(name = "TSerialDel", type = Blob.class, mode = ParameterMode.IN),//we have to set `blob` for type. this is conventional.
                @StoredProcedureParameter(name = "DayCount", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DocPrice", type = BigDecimal.class, mode = ParameterMode.IN),
        }
)
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
public class BuyPurchase extends TParams implements Serializable {

    @Id
    private UUID _id = UUID.randomUUID();

    @OneToOne
    private BuyPurchaseHeader header;


    @OneToMany
    private List<BuyPurchaseDetail> details;


    public UUID get_id() {
        return _id;
    }

    public void set_id(UUID _id) {
        this._id = _id;
    }

    public BuyPurchaseHeader getHeader() {
        return header;
    }

    public void setHeader(BuyPurchaseHeader header) {
        this.header = header;
    }

    public List<BuyPurchaseDetail> getDetails() {
        return details;
    }

    public void setDetails(List<BuyPurchaseDetail> details) {
        this.details = details;
    }
}
