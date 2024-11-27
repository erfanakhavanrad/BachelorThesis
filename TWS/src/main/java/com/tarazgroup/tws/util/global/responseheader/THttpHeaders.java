package com.tarazgroup.tws.util.global.responseheader;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public class THttpHeaders {
    THttpHeaders() {

    }

    public static HttpHeaders httpHeadersPdf(String fileName) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_PDF);
        httpHeaders.add("Content-Disposition", "attachment; filename=" + fileName + ".pdf");
        httpHeaders.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return httpHeaders;
    }

    public static HttpHeaders httpHeadersExcel(String fileName) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        httpHeaders.add("Content-Disposition", "attachment; filename=" + fileName + ".xlsx");
        return httpHeaders;
    }
}
