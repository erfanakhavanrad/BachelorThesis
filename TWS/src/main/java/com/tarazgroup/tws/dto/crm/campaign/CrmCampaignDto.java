package com.tarazgroup.tws.dto.crm.campaign;

import com.tarazgroup.tws.dto.lookup.TLookUp;

import java.math.BigDecimal;
import java.util.Date;

public class CrmCampaignDto {
    private BigDecimal campaignID;
    private TLookUp statusID;
    private String statusTitle;
    private TLookUp campaignTypeID;
    private String campaignTypeName;
    private Integer campaignCode;
    private String campaignTitle;
    private String campaignDesc;
    private TLookUp perComID;
    private String perComName;
    private Date startDateG;
    private String startDate;
    private Date endDateG;
    private String endDate;
    private String productIDs;
    private String targetSociety;
    private BigDecimal allocatedCosts;
    private BigDecimal expectedReceivedAmount;
    private BigDecimal actualCost;
    private BigDecimal actualReceivedAmount;
}
