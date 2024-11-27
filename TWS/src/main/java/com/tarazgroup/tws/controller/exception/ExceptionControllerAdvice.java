package com.tarazgroup.tws.controller.exception;

import com.tarazgroup.tws.util.exception.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * <p>
 * Exception Handler.
 * </p>
 *
 * @author alireza_bayat
 * @since 2.0.0
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @Value("${SystemID}")
    private BigDecimal systemID;

    //<editor-fold defaultstate="collapsed" desc="5XX">

    /**
     * <p>
     * {@link Exception} handle Exception
     * </p>
     *
     * @see ExceptionHandler
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionModel handleException(Exception ex, HttpServletRequest request) {
        ex.printStackTrace();
        return new ExceptionModel(
                "Internal Server Error",
                "server exception occurs, please call server admin!",
                request.getServletPath(),
                500);
    }

    /**
     * {@link JpaObjectRetrievalFailureException} handle JpaObjectRetrievalFailureException
     *
     * @see ExceptionHandler
     */
    @ExceptionHandler(JpaObjectRetrievalFailureException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionModel handleExceptionSignature(JpaObjectRetrievalFailureException ex, HttpServletRequest request) {
        return new ExceptionModel(
                "Internal Server Error",
                ex.getMessage(),
                request.getServletPath(),
                500);
    }

    @ExceptionHandler(TStoredProcedureExecutionException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionModel handleTStoredProcedureParameterException(HttpServletRequest request, TStoredProcedureExecutionException e) {
        return new ExceptionModel(
                "Internal Server Error",
                e.getMessage(),
                request.getServletPath(),
                500);
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="2XX">

    /**
     * <p>
     * {@link TNoContentException} handle TException
     * </p>
     *
     * @see ExceptionHandler
     */
    @ExceptionHandler(TNoContentException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleTException() {
    }

    /**
     * <p>
     * {@link NoSuchElementException} handle NoSuchElementException
     * </p>
     *
     * @see ExceptionHandler
     */
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleNoSuchElementException() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="4XX">

    /**
     * {@link MethodArgumentTypeMismatchException} handle MethodArgumentTypeMismatchException
     *
     * @see ExceptionHandler
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionModel handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException ex,
            HttpServletRequest request) {
        List<HashMap<String, String>> errors = new ArrayList<>();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name", ex.getName());
        hashMap.put("value", ex.getMessage());
        errors.add(hashMap);
        return new ExceptionModel(
                "Bad Request",
                null,
                request.getServletPath(),
                400,
                errors
        );
    }

    /**
     * {@link BindException} handle BindException
     *
     * @see ExceptionHandler
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionModel BeanPropertyBindingResult(
            BindException ex,
            HttpServletRequest request) {
        List<HashMap<String, String>> errMaps = new ArrayList<>();
        for (FieldError fieldError : ex.getFieldErrors()) {
            HashMap<String, String> map = new HashMap<>();
            map.put("name", fieldError.getField());
            map.put("value", fieldError.getDefaultMessage());
            errMaps.add(map);
        }
        return new ExceptionModel(
                "Bad Request",
                null,
                request.getServletPath(),
                400,
                errMaps
        );
    }

    /**
     * {@link MethodArgumentNotValidException} handle MethodArgumentNotValidException
     *
     * @see ExceptionHandler
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionModel handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {
        List<HashMap<String, String>> errors = new ArrayList<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("name", fieldError.getField());
            hashMap.put("value", fieldError.getDefaultMessage());
            errors.add(hashMap);
        }
        return new ExceptionModel(
                "Bad Request",
                null,
                request.getServletPath(),
                400,
                errors
        );
    }

    /**
     * {@link TUnAuthorizedException} handle TUNAUTHORIZEDException
     *
     * @see ExceptionHandler
     */
    @ExceptionHandler(TUnAuthorizedException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public ExceptionModel handleExceptionUTUNAUTHORIZED(HttpServletRequest request) {
        return new ExceptionModel(
                "Unauthorized",
                "The login record is deleted in database!",
                request.getServletPath(),
                401);
    }

    /**
     * {@link TktInvalidTokenException} handle UPGRADE_REQUIREDException
     *
     * @see ExceptionHandler
     */
    @ExceptionHandler(TktInvalidTokenException.class)
    @ResponseStatus(value = HttpStatus.PAYMENT_REQUIRED)
    public ExceptionModel handleExceptionUPGRADE_REQUIRED(HttpServletRequest request) {
        return new ExceptionModel(
                "PaymentRequired",
                "License has expired. Please contact system administrator!",
                request.getServletPath(),
                402);
    }


    /**
     * {@link InternalAuthenticationServiceException} handle InternalAuthenticationServiceException
     *
     * @see ExceptionHandler
     */
    @ExceptionHandler(InternalAuthenticationServiceException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ExceptionModel handleExceptionUnAuthorized() {
        List<HashMap<String, String>> errors = new ArrayList<>();
        HashMap<String, String> hashMapEng = new HashMap<>();
        hashMapEng.put("name", "eng");
        hashMapEng.put("value", "The following username and password is not valid!");
        errors.add(hashMapEng);
        HashMap<String, String> hashMapPer = new HashMap<>();
        hashMapPer.put("name", "per");
        hashMapPer.put("value", "نام کاربری یا رمز عبور نادرست است !");
        errors.add(hashMapPer);
        return new ExceptionModel(
                "Forbidden",
                null,
                "/authenticate",
                403,
                errors
        );
    }

    /**
     * {@link EmptyResultDataAccessException} handle EmptyResultDataAccessException
     *
     * @see ExceptionHandler
     */
    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ExceptionModel handleExceptionEmptyResultDataAccessException(
            EmptyResultDataAccessException ex,
            HttpServletRequest request) {
        return new ExceptionModel(
                "Not Found",
                ex.getMessage(),
                request.getServletPath(),
                404);
    }

    /**
     * {@link TNotFoundException} handle TNotFoundException
     *
     * @see ExceptionHandler
     */
    @ExceptionHandler(TNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ExceptionModel handleExceptionUTNotFound(HttpServletRequest request) {
        return new ExceptionModel(
                "Not Found",
                "There is no entity to delete or update!",
                request.getServletPath(),
                404);
    }

    /**
     * {@link TCrystalReportFileNotFoundException} handle TCrystalReportFileNotFoundException
     *
     * @see ExceptionHandler
     */
    @ExceptionHandler(TCrystalReportFileNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ExceptionModel handleExceptionTCrystalReportFileNotFound(TCrystalReportFileNotFoundException tCrystalReportFileNotFoundException, HttpServletRequest request) {
        List<HashMap<String, String>> errors = new ArrayList<>();
        HashMap<String, String> hashMapEng = new HashMap<>();
        hashMapEng.put("name", "eng");
        hashMapEng.put("value", tCrystalReportFileNotFoundException.getMessage());
        errors.add(hashMapEng);
        HashMap<String, String> hashMapPer = new HashMap<>();
        hashMapPer.put("name", "per");
        hashMapPer.put("value", "فایل کریستال ریپورت وجود ندارد !");
        errors.add(hashMapPer);
        return new ExceptionModel(
                "Not Found",
                "There is no rpt file !",
                request.getServletPath(),
                404,
                errors
        );
    }

    /**
     * {@link TCrystalReportDataSourceException} handle TCrystalReportDataSourceException
     *
     * @see ExceptionHandler
     */
    @ExceptionHandler(TCrystalReportDataSourceException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionModel handleExceptionTCrystalReportDataSource(TCrystalReportDataSourceException tCrystalReportDataSourceException, HttpServletRequest request) {
        List<HashMap<String, String>> errors = new ArrayList<>();
        HashMap<String, String> hashMapEng = new HashMap<>();
        hashMapEng.put("name", "eng");
        hashMapEng.put("value", tCrystalReportDataSourceException.getMessage());
        errors.add(hashMapEng);
        HashMap<String, String> hashMapPer = new HashMap<>();
        hashMapPer.put("name", "per");
        hashMapPer.put("value", "دیتاسورس فایل کریستال ریپورت بدرستی تنظیم نشده است !");
        errors.add(hashMapPer);
        return new ExceptionModel(
                "Internal Server Error",
                "Taraz Server Error",
                request.getServletPath(),
                512,
                errors
        );
    }

    /**
     * {@link TCrystalReportFieldNotFoundException} handle TCrystalReportFieldNotFoundException
     *
     * @see ExceptionHandler
     */
    @ExceptionHandler(TCrystalReportFieldNotFoundException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionModel handleExceptionTCrystalReportFieldNotFound(TCrystalReportFieldNotFoundException tCrystalReportFieldNotFoundException, HttpServletRequest request) {
        List<HashMap<String, String>> errors = new ArrayList<>();
        HashMap<String, String> hashMapEng = new HashMap<>();
        hashMapEng.put("name", "eng");
        hashMapEng.put("value", tCrystalReportFieldNotFoundException.getMessage());
        errors.add(hashMapEng);
        HashMap<String, String> hashMapPer = new HashMap<>();
        hashMapPer.put("name", "per");
        hashMapPer.put("value", "فیلد های فایل کریستال ریپورت بدرستی وارد نشده است !");
        errors.add(hashMapPer);
        return new ExceptionModel(
                "Internal Server Error",
                "Taraz Server Error",
                request.getServletPath(),
                512,
                errors
        );
    }

    /**
     * {@link TExcelIOException} handle TExcelIOException
     *
     * @see ExceptionHandler
     */
    @ExceptionHandler(TExcelIOException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ExceptionModel> handleExceptionTExcelIOException(TExcelIOException tExcelIOException, HttpServletRequest request) {
        List<HashMap<String, String>> errors = new ArrayList<>();
        HashMap<String, String> hashMapEng = new HashMap<>();
        hashMapEng.put("name", "eng");
        hashMapEng.put("value", tExcelIOException.getMessage());
        errors.add(hashMapEng);
        HashMap<String, String> hashMapPer = new HashMap<>();
        hashMapPer.put("name", "per");
        hashMapPer.put("value", "خطا در ایجاد فایل اکسل !");
        errors.add(hashMapPer);

        return ResponseEntity
                .status(500)
                .body(new ExceptionModel(
                        "Internal Server Error",
                        "Taraz Server Error",
                        request.getServletPath(),
                        512,
                        errors
                ));
    }

    /**
     * {@link HttpRequestMethodNotSupportedException} handle HttpRequestMethodNotSupportedException
     *
     * @see ExceptionHandler
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
    public ExceptionModel handleExceptionHttpRequestMethodNotSupported(HttpServletRequest request) {
        return new ExceptionModel(
                "Method Not Allowed",
                "This calling of method is not supported!",
                request.getServletPath(),
                405);
    }

    /**
     * {@link TConflictException} handle TConflictException
     *
     * @see ExceptionHandler
     */
    @ExceptionHandler(TConflictException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ExceptionModel handleExceptionConflict(
            TConflictException tConflictException,
            HttpServletRequest request) {
        return new ExceptionModel(
                "Conflict",
                tConflictException.getMessage(),
                request.getServletPath(),
                tConflictException.getStatus()
        );
    }

    /**
     * {@link TSqlException} handle TSqlException
     *
     * @see ExceptionHandler
     */
    @ExceptionHandler(TSqlException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ExceptionModel handleExceptionSql(
            TSqlException tSqlException,
            HttpServletRequest request) {
        return new ExceptionModel(
                "Conflict",
                tSqlException.getMessage(),
                request.getServletPath(),
                409);
    }
    //</editor-fold>
}
