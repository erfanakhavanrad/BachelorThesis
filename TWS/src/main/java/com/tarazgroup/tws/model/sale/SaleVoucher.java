package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;
import com.tarazgroup.tws.util.tabletype.TElement;
import com.tarazgroup.tws.util.tabletype.TSerial;
import com.tarazgroup.tws.util.tabletype.TempT2;
import com.tarazgroup.tws.util.tabletype.sale.SaleVDTblType;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
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
        name = "SaleInsVoucherHD",
        procedureName = "SaleInsVoucherHD",
        parameters = {
                @StoredProcedureParameter(name = "VoucherNumber", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDateG", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SaleCenterID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DeliverCenterID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReferNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReferDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SalesManID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MarketingManID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SaleTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SecondNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CurrencyID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PaymentWayID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ExtraDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ReferID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AnalysisSetup", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center1ID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center2ID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center3ID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DayCount", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DocPrice", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CashID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BaseRefTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsManualPromotion", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAndroidUser", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAmendment", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ContractNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ContractDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BruntNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CarNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "XDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DriverID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DistNameID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RowID", type = Timestamp.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TDel", type = TempT2.class, mode = ParameterMode.IN),//we have to set `blob` for type. this is conventional.
                @StoredProcedureParameter(name = "TVD", type = SaleVDTblType.class, mode = ParameterMode.IN),//we have to set `blob` for type. this is conventional.
                @StoredProcedureParameter(name = "TSerial", type = TSerial.class, mode = ParameterMode.IN),//we have to set `blob` for type. this is conventional.
                @StoredProcedureParameter(name = "TSerialDel", type = TempT2.class, mode = ParameterMode.IN),//we have to set `blob` for type. this is conventional.
                @StoredProcedureParameter(name = "TElement", type = TElement.class, mode = ParameterMode.IN),//we have to set `blob` for type. this is conventional.
                @StoredProcedureParameter(name = "WebUserType", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TableID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
public class SaleVoucher extends TParams implements Serializable {

    @Id
    private UUID _id = UUID.randomUUID();

    @OneToOne
    private SaleVoucherHeader header;

    private SaleVoucherOther other;

    @OneToMany
    private List<SaleVoucherDetailLight> details;

    @OneToMany
    private List<Promotion> promotions;

    @OneToMany
    private List<Element> elements;

    public UUID get_id() {
        return _id;
    }

    public void set_id(UUID _id) {
        this._id = _id;
    }

    public SaleVoucherHeader getHeader() {
        return header;
    }

    public void setHeader(SaleVoucherHeader header) {
        this.header = header;
    }

    public SaleVoucherOther getOther() {
        return other;
    }

    public void setOther(SaleVoucherOther other) {
        this.other = other;
    }

    public List<SaleVoucherDetailLight> getDetails() {
        return details;
    }

    public void setDetails(List<SaleVoucherDetailLight> details) {
        this.details = details;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }
}
