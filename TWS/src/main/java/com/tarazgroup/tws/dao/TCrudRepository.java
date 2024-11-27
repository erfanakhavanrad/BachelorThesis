package com.tarazgroup.tws.dao;

import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.TParams;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import org.json.JSONArray;
import org.springframework.core.io.InputStreamResource;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Interface for generic Taraz CRUD operations on a repository for a specific type.
 *
 * @author Salman Majidi
 */

public interface TCrudRepository<T extends TParams> {
    LogLogins fetchUserDetail();

    /**
     * Get primary key fieldname from entity
     *
     * @param t entity
     * @return primary key fieldname
     */
    default Field getPKField(T t) {
        for (Field field : t.getClass().getDeclaredFields()) {
            for (Annotation annotation : field.getAnnotations()) {
                if (annotation.annotationType() == javax.persistence.Id.class) {
                    return field;
                }
            }
        }
        return null;
    }

    default <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
        ArrayList<T> newList = new ArrayList<T>();
        for (T element : list) {
            boolean isExist = false;
            for (T newElement : newList) {
                if (newElement.equals(element)) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                newList.add(element);
            }
        }
        return newList;
    }

    /**
     * Get tablename from entity
     *
     * @param t entity
     * @return tablename
     */
    default String getTableName(T t) {
        return t.getClass().getAnnotation(javax.persistence.Table.class).name();
    }

    /**
     * Get tablename from entity
     *
     * @param t entity
     */
    default void setPKValue(T t, Field pkField, BigDecimal newID) {
        try {
            pkField.setAccessible(true);
            pkField.set(t, newID);
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }


    /**
     * Insert by Taraz stored procedure implementation (SPI)
     *
     * @param t entity
     * @return T
     */
    T insSPI(T t);


    /**
     * Update by Taraz stored procedure implementation (SPI)
     *
     * @param t       entity
     * @param pkValue primary key
     * @return T
     */
    T updSPI(T t, BigDecimal pkValue);


    /**
     * Execute show stored procedure
     *
     * @param storedProcedureName name of stored procedure
     * @param tParameters         list of parameters
     * @return list of entities
     */
    List<T> showSP(String storedProcedureName, List<TParameter<?>> tParameters, boolean throwIfNoCOntent);


    /**
     * Return Final runnabble sp with its parameters as string
     * @param storedProcedureName
     * @param tParameters
     * @param throwIfNoCOntent
     * @return
     */
    List<T> showFinalSP(String storedProcedureName, List<TParameter<?>> tParameters, boolean throwIfNoCOntent);

    /**
     * اجرای اس پی هایی که خروجی اش
     * ResultList
     * است
     * مثلا
     * SaleComputePromotion
     *
     * @param clazz   Entity Class
     * @param tParams SP Parameters
     * @return List
     */
    List execSPNativeQuery(Class<T> clazz, String storedProcedureName, List<TParameter<?>> tParams, ShowSPReturnType showSPReturnType);


    List<?> execSPNativeQueryTest(String query);
    List<?> execSPNativeQueryTestAK(String query);

    /**
     * اجرای اس پی هایی که خروجی اش
     * Result ErrMsg NewID
     * است
     * مثلا
     * SaleInsVoucherHD
     *
     * @param clazz   Entity Class
     * @param tParams SP Parameters
     * @return ResultErrMsgNewID
     */
    ResultErrMsgNewID execSPNativeQuery(Class<T> clazz, String storedProcedureName, List<TParameter<?>> tParams);
    ResultErrMsgNewID execSPNativeQueryTSerial(Class<T> clazz, String storedProcedureName, List<TParameter<?>> tParams);

    List mixed(String queryString);
    List mixed2(String queryString);
    List mixed3(String queryString);

    ResultErrMsgNewID execSPNativeQueryForVoucher(Class<T> clazz, String storedProcedureName, List<TParameter<?>> tParams);


    /**
     * Akhavan method
     */
    ArrayList<BigDecimal> execSPNativeQueryAk(Class<T> clazz, String storedProcedureName, List<TParameter<?>> tParams);

    ArrayList<BigDecimal> execSPNativeQueryAk2(Class<T> clazz, String storedProcedureName, List<TParameter<?>> tParams);

    ResultErrMsgNewID execSPNativeQueryMultiResultSet(Class<T> clazz, String storedProcedureName, List<TParameter<?>> tParams);


    /**
     * Execute insert stored procedure
     *
     * @param storedProcedureName name of stored procedure
     * @param tParameters         list of parameters
     * @param clazz               entity class
     * @return T
     */
    T insSP(String storedProcedureName, List<TParameter<?>> tParameters, Class<T> clazz);

    /**
     * Execute insert stored procedure without newID
     *
     * @param storedProcedureName name of stored procedure
     * @param tParameters         list of parameters
     */
    BigDecimal  insSP(String storedProcedureName, List<TParameter<?>> tParameters);

    /**
     * Execute delete stored procedure
     *
     * @param storedProcedureName name of stored procedure
     * @param tParameters         list of parameters
     */
    void delSP(String storedProcedureName, List<TParameter<?>> tParameters);

    void delSPNew(String storedProcedureName, List<TParameter<?>> tParameters);

    /**
     * Execute update stored procedure
     *
     * @param storedProcedureName name of stored procedure
     * @param tParameters         list of parameters
     * @param clazz               entity class
     * @param pkValue             primary key
     * @return T
     */
    T updSP(String storedProcedureName, List<TParameter<?>> tParameters, Class<T> clazz, BigDecimal pkValue);

    void updSP(String storedProcedureName, List<TParameter<?>> tParameters);

    void noPKUpdSP(String storedProcedureName, List<TParameter<?>> tParameters);

    List<T> findAllByNamedQuery(String namedQuery);


    /**
     * Base64 Encoder
     *
     * @param meta
     * @return String
     */
    String base64Encoder(Meta meta);

    /**
     * Base64 Export Static File To StreamResource
     *
     * @param fileName
     * @return InputStreamResource
     */
    InputStreamResource staticFileToStreamResource(String fileName);

    /**
     * Base64 Export Crystal Report To PDF StreamResource
     *
     * @param rptFileName
     * @param parameterFields فیلد های خود کریستال
     * @param tParameters     پارامترهای اس پی
     * @return InputStreamResource
     */
    InputStreamResource exportCrystalReportToPDF(
            Class<T> clazz,
            String rptFileName,
            HashMap<String, Object> parameterFields,
            List<TParameter<?>> tParameters,
            ShowSPReturnType showSPReturnType);

    /**
     * Base64 Export To Excel StreamResource
     *
     * @return InputStreamResource
     */
    InputStreamResource exportToExcel(List rows, List<Col> cols, String sheetName);

    T setParams(Class<T> clazz, Map<String, String> params);
}
