package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "InvReport_GetGoodsInventory",
        procedureName = "InvReport_GetGoodsInventory",
        resultClasses = {InvReport_GoodsInventory.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OutFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsRiali", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOrderPoint", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsBarCode", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RemainQ", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOnlyRemain", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsInformationGoods", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOnlyFeeR", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOnlyQRValues", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOnlyOrderPoint", type = Boolean.class, mode = ParameterMode.IN)
        }
)

//@Entity
public class InvReport_GoodsInventory extends TParams implements Serializable {
//
//    @Id
//    @Column(name = "")
//    private

}
