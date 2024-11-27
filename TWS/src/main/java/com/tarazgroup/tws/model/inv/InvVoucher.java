package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;
import com.tarazgroup.tws.util.tabletype.TSerial;
import com.tarazgroup.tws.util.tabletype.TempT2;
import com.tarazgroup.tws.util.tabletype.inv.InvVDTblType;

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
 * @author M.Nouri
 * @since 2.0.0
 */
@NamedStoredProcedureQuery(
        name = "InvInsVoucherHD",
        procedureName = "InvInsVoucherHD",
        resultClasses = {InvVoucher.class},
        parameters = {
                @StoredProcedureParameter(name = "VoucherNumber", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDateG", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReferNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReferDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToStoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherStatID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "VoucherDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReferID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AnalysisSetup", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center1ID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center2ID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center3ID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BaseRefTypeId", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RowID", type = Timestamp.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TDel", type = TempT2.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TVD", type = InvVDTblType.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TSerial", type = TSerial.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TSerialDel", type = TempT2.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CurrencyID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MppDID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MppOPCProcessID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AnalysisNo", type = BigDecimal.class, mode = ParameterMode.IN)
//                @StoredProcedureParameter(name = "DeliveryID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)


@Entity
public class InvVoucher extends TParams implements Serializable {

    @Id
    private UUID _id = UUID.randomUUID();

    @OneToOne
    private InvVoucherHeader header;

    @OneToMany
    private List<InvVoucherDetail> details;


    public UUID get_id() {
        return _id;
    }

    public void set_id(UUID _id) {
        this._id = _id;
    }

    public List<InvVoucherDetail> getDetails() {
        return details;
    }

    public void setDetails(List<InvVoucherDetail> invVoucherDetails) {
        this.details = invVoucherDetails;
    }

    public InvVoucherHeader getHeader() {
        return header;
    }

    public void setHeader(InvVoucherHeader invVoucherHeaders) {
        this.header = invVoucherHeaders;
    }
}
