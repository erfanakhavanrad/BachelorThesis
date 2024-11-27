package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * @author Abbas Ashrafi,
 * @since v2.0.0
 */

@NamedStoredProcedureQuery(
        name = "AccShowTafsiliIdentity",
        procedureName = "AccShowTafsiliIdentity",
        resultClasses = {AccTafsiliIdentity.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
@Table(name = "AccTafsiliIdentity")
public class AccTafsiliIdentity extends TParams implements Serializable {

    @Id
    @Column(name = "TafsiliIdentity")
    @Parameter
    private Integer tafsiliIdentity;

    @Column(name = "TafsiliIdentityDesc")
    @Parameter
    private String tafsiliIdentityDesc;

    @Column(name = "TableName")
    private String tableName;

    @Column(name = "FieldName")
    @Parameter
    private String fieldName;

    @Column(name = "RowCnt")
    private Integer rowCnt;

    @Column(name = "PgCnt")
    private Integer pgCnt;

//    @Column(name = "JoinStr")
//    @Parameter
//    private String joinStr;

//    @Column(name = "WhereCond")
//    @Parameter
//    private String whereCond;

//    @Column(name = "CodeFieldName")
//    @Parameter
//    private String codeFieldName;

//    @Column(name = "DescFieldName")
//    @Parameter
//    private String descFieldName;

    @Schema(accessMode = READ_ONLY)
    public Integer getTafsiliIdentity() {
        return tafsiliIdentity;
    }

    public void setTafsiliIdentity(Integer tafsiliIdentity) {
        this.tafsiliIdentity = tafsiliIdentity;
    }

    @NotNull(message = "tafsiliIdentityDesc is mandatory")
    @Schema(
            required = true,
            example = "اشخاص حقیقی"
    )
    public String getTafsiliIdentityDesc() {
        return tafsiliIdentityDesc;
    }

    public void setTafsiliIdentityDesc(String tafsiliIdentityDesc) {
        this.tafsiliIdentityDesc = tafsiliIdentityDesc;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Integer getRowCnt() {
        return rowCnt;
    }

    public void setRowCnt(Integer rowCnt) {
        this.rowCnt = rowCnt;
    }

    public Integer getPgCnt() {
        return pgCnt;
    }

    public void setPgCnt(Integer pgCnt) {
        this.pgCnt = pgCnt;
    }

    //    public String getJoinStr() {
//        return joinStr;
//    }

//    public void setJoinStr(String joinStr) {
//        this.joinStr = joinStr;
//    }

//    @Schema(
//            example = "WhereCond"
//    )
//    public String getWhereCond() {
//        return whereCond;
//    }

//    public void setWhereCond(String whereCond) {
//        this.whereCond = whereCond;
//    }

//    @Schema(
//            example = "codeFieldName"
//    )
//    public String getCodeFieldName() {
//        return codeFieldName;
//    }

//    public void setCodeFieldName(String codeFieldName) {
//        this.codeFieldName = codeFieldName;
//    }

//    @Schema(
//            example = "descFieldName"
//    )
//    public String getDescFieldName() {
//        return descFieldName;
//    }

//    public void setDescFieldName(String descFieldName) {
//        this.descFieldName = descFieldName;
//    }
}
