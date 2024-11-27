package com.tarazgroup.tws.util.global;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tarazgroup.tws.util.global.responseheader.Type;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.DecimalMin;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;


/**
 * @author alireza_bayat
 * @since 2.0.0
 */

public class TParams implements ITParams {

    @Parameter
    @JsonIgnore
    private String[] srIDs;

    @Parameter
    @JsonIgnore
    private String[] yrIDs;

    @Parameter
    @JsonIgnore
    private BigDecimal pageNumber;

    @Parameter
    @JsonIgnore
    private BigDecimal recordCount;


    @Parameter
    @JsonIgnore
    private String filter;


    @Parameter
    @JsonIgnore
    private SortField sortField;

    @Schema(hidden = true)
    public String[] getSrIDs() {
        return srIDs;
    }

    public void setSrIDs(String[] srIDs) {
        this.srIDs = srIDs;
    }

    @Schema(hidden = true)
    public String[] getYrIDs() {
        return yrIDs;
    }

    public void setYrIDs(String[] yrIDs) {
        this.yrIDs = yrIDs;
    }

    @DecimalMin(value = "1", message = "pageNumber parameter minimum value must not be less than one.")
    @Schema(hidden = true)
    public BigDecimal getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(BigDecimal pageNumber) {
        this.pageNumber = pageNumber;
    }


    @DecimalMin(value = "1", message = "recordCount parameter minimum value must not be less than one.")
    @Schema(hidden = true)
    public BigDecimal getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(BigDecimal recordCount) {
        this.recordCount = recordCount;
    }

    @Schema(hidden = true)
    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    @Schema(hidden = true)
    public SortField getSortField() {
        return sortField;
    }

    public void setSortField(SortField sortField) {
        this.sortField = sortField;
    }

//    public void _setParams(Map<String, String> params) {
//        // این متد برای بدست آوردن تعداد کل رکورد ها کاربرد دارد
//        if (params.get("srIDs") != null) {
//            String[] srIDs = params.get("srIDs").split(",");
//            this.srIDs = srIDs;
//        }
//        if (params.get("yrIDs") != null) {
//            String[] yrIDs = params.get("yrIDs").split(",");
//            this.yrIDs = yrIDs;
//        }
//    }

    public String _pageFilter() {
        StringBuilder _pageFilter = new StringBuilder();

        // اضافه کردن فیلتر ترکیبی
        _pageFilter.append(createCombinateFilter(null, filter));
        _pageFilter.append("?");

        //  pageNumber  , recordCount  اضافه کردن
        if (pageNumber == null || recordCount == null) {
            _pageFilter.append(",");
        } else {
            _pageFilter.append(this.pageNumber).append(",").append(this.recordCount);
        }
        _pageFilter.append("?");

        // اضافه کردن sort
        if (sortField != null && sortField.getName() != null && !sortField.getName().isEmpty()) {
            _pageFilter.append(sortField.getName());
            if (sortField.isDesc()) {
                _pageFilter.append(" ").append("DESC");
            }
        }
        return _pageFilter.toString();
    }




    public String _pageFilterAK3(ArrayList<String> fieldsName, ArrayList<String> fieldsValue, ArrayList<Integer> fieldsType ) {
        StringBuilder _pageFilter = new StringBuilder();

        // اضافه کردن فیلتر ترکیبی
        _pageFilter.append(createCombinateFilterAk3(null, filter, fieldsName, fieldsValue, fieldsType));
        _pageFilter.append("?");

        //  pageNumber  , recordCount  اضافه کردن
        if (pageNumber == null || recordCount == null) {
            _pageFilter.append(",");
        } else {
            _pageFilter.append(this.pageNumber).append(",").append(this.recordCount);
        }
        _pageFilter.append("?");

        // اضافه کردن sort
        if (sortField != null && sortField.getName() != null && !sortField.getName().isEmpty()) {
            _pageFilter.append(sortField.getName());
            if (sortField.isDesc()) {
                _pageFilter.append(" ").append("DESC");
            }
        }
        return _pageFilter.toString();
    }


    public String _pageFilterAK2(ArrayList<String> fieldsName, ArrayList<Type> fieldsType, ArrayList<String> fieldsValue) {
        StringBuilder _pageFilter = new StringBuilder();

        // اضافه کردن فیلتر ترکیبی
        _pageFilter.append(createCombinateFilterAk2(null, filter, fieldsName, fieldsType, fieldsValue));
        _pageFilter.append("?");

        //  pageNumber  , recordCount  اضافه کردن
        if (pageNumber == null || recordCount == null) {
            _pageFilter.append(",");
        } else {
            _pageFilter.append(this.pageNumber).append(",").append(this.recordCount);
        }
        _pageFilter.append("?");

        // اضافه کردن sort
        if (sortField != null && sortField.getName() != null && !sortField.getName().isEmpty()) {
            _pageFilter.append(sortField.getName());
            if (sortField.isDesc()) {
                _pageFilter.append(" ").append("DESC");
            }
        }
        return _pageFilter.toString();
    }

//    public String _pageFilterAk( ArrayList<String> names, ArrayList<Type> typeArrayList) {
//        StringBuilder _pageFilter = new StringBuilder();
//
//        // اضافه کردن فیلتر ترکیبی
//        _pageFilter.append(createCombinateFilterAk(null, filter, names, typeArrayList));
//        _pageFilter.append("?");
//
//        //  pageNumber  , recordCount  اضافه کردن
//        if (pageNumber == null || recordCount == null) {
//            _pageFilter.append(",");
//        } else {
//            _pageFilter.append(this.pageNumber).append(",").append(this.recordCount);
//        }
//        _pageFilter.append("?");
//
//        // اضافه کردن sort
//        if (sortField != null && sortField.getName() != null && !sortField.getName().isEmpty()) {
//            _pageFilter.append(sortField.getName());
//            if (sortField.isDesc()) {
//                _pageFilter.append(" ").append("DESC");
//            }
//        }
//        return _pageFilter.toString();
//    }

    public String _serverFilter() {
        if (srIDs == null || srIDs.length == 0) {
            return null;
        }

        return " AND Main.ServerID IN (" + String.join(",", srIDs) + ")";
    }

    public String _yearFilter() {
        if (yrIDs == null || yrIDs.length == 0) {
            return null;
        }

        return " AND Main.YearID IN (" + String.join(",", yrIDs) + ")";
    }

    // دیگر به کد زیر نیازی نیست

//    @Override
//    public String _filter() {
//        if (_pageFilter() == null) {
//            String combinateFilter = createCombinateFilter(null, null).toString();
//            return combinateFilter.isEmpty() ? null : combinateFilter;
//        }
//        return null;
//    }


}
