package com.tarazgroup.tws.model.pub;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author A.Farahani
 * @date Dec-15, 2021
 */

@NamedStoredProcedureQuery(
        name = "PubShowFilters",
        procedureName = "PubShowFilters",
        resultClasses = {PubFilters.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class PubFilters extends TParams implements Serializable {
    @Id
    @Column(name = "FilterID")
    private BigDecimal filterID;

    @Column(name = "FilterType")
    private Integer filterType;

    @Column(name = "FilterTitle")
    private String filterTitle;

    @Column(name = "FilterQuery")
    private String filterQuery;

    @Column(name = "IncludedForms")
    private String includedForms;

    @Column(name = "IsSelect")
    private Boolean isSelect;

    @Column(name = "FilterField")
    private String filterField;

    @Column(name = "FilterOrder")
    private Integer filterOrder;

    @Column(name = "FilterCombineQuery")
    private String filterCombineQuery;

    @Column(name = "FilterCombineField")
    private String filterCombineField;

    public BigDecimal getFilterID() {
        return filterID;
    }

    public void setFilterID(BigDecimal filterID) {
        this.filterID = filterID;
    }

    public Integer getFilterType() {
        return filterType;
    }

    public void setFilterType(Integer filterType) {
        this.filterType = filterType;
    }

    public String getFilterTitle() {
        return filterTitle;
    }

    public void setFilterTitle(String filterTitle) {
        this.filterTitle = filterTitle;
    }

    public String getFilterQuery() {
        return filterQuery;
    }

    public void setFilterQuery(String filterQuery) {
        this.filterQuery = filterQuery;
    }

    public String getIncludedForms() {
        return includedForms;
    }

    public void setIncludedForms(String includedForms) {
        this.includedForms = includedForms;
    }

    public Boolean getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(Boolean isSelect) {
        this.isSelect = isSelect;
    }

    public String getFilterField() {
        return filterField;
    }

    public void setFilterField(String filterField) {
        this.filterField = filterField;
    }

    public Integer getFilterOrder() {
        return filterOrder;
    }

    public void setFilterOrder(Integer filterOrder) {
        this.filterOrder = filterOrder;
    }

    public String getFilterCombineQuery() {
        return filterCombineQuery;
    }

    public void setFilterCombineQuery(String filterCombineQuery) {
        this.filterCombineQuery = filterCombineQuery;
    }

    public String getFilterCombineField() {
        return filterCombineField;
    }

    public void setFilterCombineField(String filterCombineField) {
        this.filterCombineField = filterCombineField;
    }
}
