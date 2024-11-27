package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "SaleShowMarketingManRoute",
        procedureName = "SaleShowMarketingManRoute",
        resultClasses = {SaleMarketingManRoute.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)


@NamedStoredProcedureQuery(
        name = "SaleInsMarketingManRoute",
        procedureName = "SaleInsMarketingManRoute",
        resultClasses = {SaleMarketingManRoute.class},
        parameters = {
                @StoredProcedureParameter(name = "MarketingManID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Latitude", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Longitude", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StartTime", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "EndTime", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "CustomerID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@Entity
public class SaleMarketingManRoute extends TParams implements Serializable {

    @Id
    @Column(name = "RouteID", columnDefinition = "decimal")
    private BigDecimal routeID;


    @Column(name = "MarketingManID")
    private BigDecimal marketingManID;


    @Column(name = "Latitude", columnDefinition = "decimal")
    private BigDecimal latitude;


    @Column(name = "Longitude", columnDefinition = "decimal")
    private BigDecimal longitude;


    @Column(name = "CreateDate", columnDefinition = "datetime")
    private String createDate;


    @Column(name = "StartTime", columnDefinition = "datetime")
    private String startTime;


    @Column(name = "EndTime", columnDefinition = "datetime")
    private String endTime;

    @Column(name = "WaitTimeHM")
    private String waitTimeHM;

    @Column(name = "DIFF")
    private String dIFF;

    @Column(name = "CreatorID", columnDefinition = "decimal")
    private BigDecimal creatorID;


    @Column(name = "ServerID", columnDefinition = "decimal")
    private BigDecimal serverID;

    @Column(name = "CustomerID")
    private BigDecimal customerID;

    @Column(name = "CustomerName")
    private String customerName;

    @Column(name = "CustomerCode")
    private String customerCode;


    @Schema(accessMode = READ_ONLY)
    public BigDecimal getRouteID() {
        return routeID;
    }

    public void setRouteID(BigDecimal routeID) {
        this.routeID = routeID;
    }


    @Schema(
            required = true,
            example = "10000005"
    )
    public BigDecimal getMarketingManID() {
        return marketingManID;
    }

    public void setMarketingManID(BigDecimal marketingManID) {
        this.marketingManID = marketingManID;
    }

    @Schema(
            required = true,
            example = "35.754242"
    )
    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Schema(
            required = true,
            example = "51.410005"
    )
    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Schema(hidden = true)
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Schema(
            required = true,
            example = "2020-07-05 11:20:01.000"
    )
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Schema(
            required = true,
            example = "2020-07-05 11:20:01.000"
    )
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Schema(hidden = true)
    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    @Schema(hidden = true)
    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    @Schema(
            required = true,
            example = "10000000"
    )

    public BigDecimal getCustomerID() {
        return customerID;
    }

    public void setCustomerID(BigDecimal customerID) {
        this.customerID = customerID;
    }

    public String getWaitTimeHM() {
        return waitTimeHM;
    }

    public void setWaitTimeHM(String waitTimeHM) {
        this.waitTimeHM = waitTimeHM;
    }

    public String getDIFF() {
        return dIFF;
    }

    public void setDIFF(String dIFF) {
        this.dIFF = dIFF;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

}

