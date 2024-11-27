package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;
import com.tarazgroup.tws.util.tabletype.TempT2;
import com.tarazgroup.tws.util.tabletype.TempT3;
import com.tarazgroup.tws.util.tabletype.acc.AccVDTblType;

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
        name = "AccInsVoucherHD",
        procedureName = "AccInsVoucherHD",
        resultClasses = {AccVoucher.class},
        parameters = {
//                @StoredProcedureParameter(name = "VoucherNumber", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "VoucherDate", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "VoucherDesc", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "SerialCode", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "DayCode", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "SecondaryCode", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ReferNumber", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ReferDate", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "VoucherStatID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsDeleted", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "RefrenceNumber", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "VoucherDateG", type = Date.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsFromExcel", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsAutoVch", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "RefID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "RowID", type = Timestamp.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "TDel", type = Blob.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "TempT2", type = Blob.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "TempT3", type = Blob.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "TVD", type = Blob.class, mode = ParameterMode.IN)
                @StoredProcedureParameter(name = "VoucherNumber", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "SerialCode", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DayCode", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SecondaryCode", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReferNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReferDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherStatID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsDeleted", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefrenceNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDateG", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsFromExcel", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAutoVch", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RowID", type = Timestamp.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TDel", type = TempT2.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TempT2", type = TempT2.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TempT3", type = TempT3.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TVD", type = AccVDTblType.class, mode = ParameterMode.IN)

        }
)

@Entity
public class AccVoucher extends TParams implements Serializable {

    @Id
    private UUID _id = UUID.randomUUID();

    @OneToOne
    private AccVoucherHeader header;

    @OneToMany
    private List<AccVoucherDetail> details;

    public UUID get_id() {
        return _id;
    }

    public void set_id(UUID _id) {
        this._id = _id;
    }

    public List<AccVoucherDetail> getDetails() {
        return details;
    }

    public void setDetails(List<AccVoucherDetail> accVoucherDetails) {
        this.details = accVoucherDetails;
    }

    public AccVoucherHeader getHeader() {
        return header;
    }

    public void setHeader(AccVoucherHeader accVoucherHeader) {
        this.header = accVoucherHeader;
    }
}
