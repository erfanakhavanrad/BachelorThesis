package com.tarazgroup.tws.model.acc;


import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
        name = "AccShowPerCom",
        procedureName = "AccShowPerCom",
        resultClasses = {AccPerCom.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOtherInfo", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GeneralFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)
@NamedStoredProcedureQuery(
        name = "AccInsPerCom",
        procedureName = "AccInsPerCom",
        resultClasses = {AccPerCom.class},
        parameters = {
                @StoredProcedureParameter(name = "PerComCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComTitle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComFName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComLName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SexID", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComAddress", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComTypeID", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsMPerson", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComNameLatin", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FatherName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsSaleCustomer", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsSaleMan", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsMarketingMan", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsProviderMan", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsPerson", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsStocker", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PercomTel", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PercomMobile", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NationalCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SalesManCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MarketingManCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ProviderCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerClassID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SalesManClassID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MarketingManClassID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerGeoID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SalesManGeoID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MarketingManGeoID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ProviderGeoID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsForeignProvider", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCustomerNotActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsSalesManNotActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsMarketingManNotActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ISProviderManNotActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ISStockerNotActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BirthDateStocker", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NumberMemberStocker", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IdentityCodeStocker", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAllowDuplicate", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsMpp", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WebUserType", type = Integer.class, mode = ParameterMode.IN)
        }

)

@NamedStoredProcedureQuery(
        name = "AccDelPerCom",
        procedureName = "AccDelPerCom",
        resultClasses = {AccPerCom.class},
        parameters = {
                @StoredProcedureParameter(name = "PerComID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WebUserType", type = Integer.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "AccUpdPerCom",
        procedureName = "AccUpdPerCom",
        resultClasses = {AccPerCom.class},
        parameters = {
                @StoredProcedureParameter(name = "PerComID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComTitle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComFName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComLName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SexID", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComAddress", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComTypeID", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsMPerson", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComNameLatin", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FatherName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsSaleCustomer", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsSaleMan", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsMarketingMan", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsProviderMan", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsPerson", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsStocker", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCustomerNotActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsSalesManNotActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsMarketingManNotActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsProviderManNotActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsStockerNotActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SalesManCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MarketingManCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ProviderCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerClassID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SalesManClassID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MarketingManClassID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerGeoID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SalesManGeoID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MarketingManGeoID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ProviderGeoID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsForeignProvider", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BirthDateStocker", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NumberMemberStocker", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IdentityCodeStocker", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NationalCodeStocker", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsMpp", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WebUserType", type = Integer.class, mode = ParameterMode.IN),
        }
)

@Entity
@Table(name = "AccPerCom")
public class AccPerCom extends TParams implements Serializable{

    @Id
    @Column(name = "PerComID")
    private BigDecimal perComID;

    @Column(name = "ServerID")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "PerComCode")
    @Parameter
    private String perComCode;

    @Column(name = "PerComTitle")
    @Parameter
    private String perComTitle;

    @Column(name = "PerComFName")
    @Parameter
    private String perComFName;

    @Column(name = "SexDesc")
    private String sexDesc;

    @Column(name = "SexID")
    @Parameter
    private Boolean sexID;

    @Column(name = "SexType")
    private Integer sexType;

    @Column(name = "PerComAddress")
    @Parameter
    private String perComAddress;

    @Column(name = "PerComLName")
    @Parameter
    private String perComLName;

    @Column(name = "PerComNameLatin")
    @Parameter
    private String perComNameLatin;

    @Column(name = "PerComTypeID")
    private Integer perComTypeID;

    @Column(name = "TafsiliID")
    private BigDecimal tafsiliID;

    @Column(name = "IsMPerson")
    @Parameter
    private Boolean isMPerson;

    @Column(name = "CreateDate")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "CreatorID")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "CreateDateShamsi")
    private String createDateShamsi;

    @Column(name = "ModifyDateShamsi")
    private String modifyDateShamsi;

    @Column(name = "CreateUserName")
    private String createUserName;

    @Column(name = "ModifyUserName")
    private String modifyUserName;

    @Column(name = "TafsiliTypeID")
    private BigDecimal tafsiliTypeID;

    @Column(name = "TafsiliTypeDesc")
    private String tafsiliTypeDesc;

    @Column(name = "ModifierID")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "TafsiliCode")
    private String tafsiliCode;

    @Column(name = "FatherName")
    @Parameter(hidden = true)
    private String fatherName;

    @Column(name = "IsNotActive")
    @Parameter(hidden = true)
    private Boolean isNotActive;

    @Column(name = "TypeID")
    private BigDecimal typeID;

    @Column(name = "PostalCode")
    private String postalCode;

    @Column(name = "PreCityCode")
    private String preCityCode;

    @Column(name = "PerComTel")
    private String perComTel;

    @Column(name = "PercomMobile")
    private String perComMobile;

    @Column(name = "EconomicCode")
    private String economicCode;

    @Column(name = "NationalCode")
    private String nationalCode;

    @Column(name = "BuySaleTypeID")
    private BigDecimal buySaleTypeID;

    @Column(name = "ZoneCode")
    private String zoneCode;

    @Column(name = "StateID")
    private BigDecimal stateID;

    @Column(name = "CityID")
    private BigDecimal cityID;

    @Column(name = "StateCode")
    private String stateCode;

    @Column(name = "CityCode")
    private String cityCode;

    @Column(name = "StateName")
    private String stateName;

    @Column(name = "CityName")
    private String cityName;

    @Column(name = "BuySaleTypeDesc")
    private String buySaleTypeDesc;

    @Column(name = "TypeDesc")
    private String typeDesc;

    @Column(name = "BuySaleTypeCode")
    private String buySaleTypeCode;

    @Column(name = "TypeCode")
    private String typeCode;

    @Column(name = "IsProviderManNotActive")
    private Boolean isProviderManNotActive;

    @Column(name = "IsStockerNotActive")
    private Boolean isStockerNotActive;

    @Column(name = "IsCustomerNotActive")
    private Boolean isCustomerNotActive;

    @Column(name = "IsSalesManNotActive")
    private Boolean isSalesManNotActive;


    @Column(name = "IsMarketingManNotActive")
    private Boolean isMarketingManNotActive;

    @Column(name = "CustomerCode")
    private String customerCode;

    @Column(name = "SalesManCode")
    private String salesManCode;

    @Column(name = "MarketingManCode")
    private String marketingManCode;

    @Column(name = "ProviderCode")
    private String providerCode;

    @Column(name = "NumberMemberStocker")
    private String numberMemberStocker;

    @Column(name = "BirthDateStocker")
    private String birthDateStocker;

    @Column(name = "NationalCodeStocker")
    private String nationalCodeStocker;

    @Column(name = "IdentityCodeStocker")
    private String identityCodeStocker;

    @Column(name = "CustomerClassID")
    private BigDecimal customerClassID;

    @Column(name = "SalesManClassID")
    private BigDecimal salesManClassID;

    @Column(name = "MarketingManClassID")
    private BigDecimal marketingManClassID;

    @Column(name = "CustomerGeoID")
    private BigDecimal customerGeoID;

    @Column(name = "SalesManGeoID")
    private BigDecimal salesManGeoID;

    @Column(name = "MarketingManGeoID")
    private BigDecimal marketingManGeoID;

    @Column(name = "ProviderGeoID")
    private BigDecimal providerGeoID;

    @Column(name = "CustomerClassDesc")
    private String customerClassDesc;

    @Column(name = "SalesManClassDesc")
    private String salesManClassDesc;

    @Column(name = "MarketingManClassDesc")
    private String marketingManClassDesc;

    @Column(name = "CustomerGeoDesc")
    private String customerGeoDesc;

    @Column(name = "SalesMangeoDesc")
    private String salesMangeoDesc;

    @Column(name = "MarketingManGeoDesc")
    private String marketingManGeoDesc;

    @Column(name = "ProviderGeoDesc")
    private String providerGeoDesc;

    @Column(name = "ProviderGeoCode")
    private String providerGeoCode;

    @Column(name = "IsForeignProvider")
    private Boolean isForeignProvider;

    @Column(name = "ProviderType")
    private String providerType;

    @Column(name = "ForeignProviderType")
    private Integer foreignProviderType;

    @Column(name = "IsStocker")
    private Boolean isStocker;

    @Column(name = "IsSaleCustomer")
    private Boolean isSaleCustomer;

    @Column(name = "IsMarketingMan")
    private Boolean isMarketingMan;

    @Column(name = "IsSaleMan")
    private Boolean isSaleMan;

    @Column(name = "IsProviderMan")
    private Boolean isProviderMan;

    @Column(name = "IsPerson")
    private Boolean isPerson;

    @Column(name = "IsMpp")
    @Parameter(hidden = true)
    private Boolean isMpp;


    @Column(name = "PercomName")
    private String perComName;


    @Schema(
            example = "1"
    )
    public Integer getPerComTypeID() {
        return perComTypeID;
    }

    public void setPerComTypeID(Integer perComTypeID) {
        this.perComTypeID = perComTypeID;
    }


    @Schema(
            required = true,
            example = "10000221"
    )
    public BigDecimal getTafsiliID() {
        return tafsiliID;
    }

    public void setTafsiliID(BigDecimal tafsiliID) {
        this.tafsiliID = tafsiliID;
    }


    @Schema(accessMode = READ_ONLY)
    public BigDecimal getPerComID() {
        return perComID;
    }

    public void setPerComID(BigDecimal perComID) {
        this.perComID = perComID;
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
            example = "1"
    )
    public String getPerComCode() {
        return perComCode;
    }

    public void setPerComCode(String perComCode) {
        this.perComCode = perComCode;
    }

    @Schema(
            required = true,
            example = "مشتری حقیقی"
    )
    public String getPerComTitle() {
        return perComTitle;
    }

    public void setPerComTitle(String perComTitle) {
        this.perComTitle = perComTitle;
    }

    @Schema(
            required = true,
            example = "مرتضی"
    )
    public String getPerComFName() {
        return perComFName;
    }

    public void setPerComFName(String perComFName) {
        this.perComFName = perComFName;
    }

    @Schema(
            required = true,
            example = "نوری"
    )
    public String getPerComLName() {
        return perComLName;
    }

    public void setPerComLName(String perComLName) {
        this.perComLName = perComLName;
    }

    @Schema(
            example = "Nouri"
    )
    public String getPerComNameLatin() {
        return perComNameLatin;
    }

    public void setPerComNameLatin(String perComNameLatin) {
        this.perComNameLatin = perComNameLatin;
    }

    public Boolean getSexID() {
        return sexID;
    }

    public void setSexID(Boolean sexID) {
        this.sexID = sexID;
    }

    @Schema(
            required = false,
            example = "تهران، خیابان ولیعصر، نرسیده به میدان ونک، کوچه فوزی، پلاک 4، طبقه ششم"
    )
    public String getPerComAddress() {
        return perComAddress;
    }

    public void setPerComAddress(String perComAddress) {
        this.perComAddress = perComAddress;
    }

    @Schema(
            example = "false"
    )
    public Boolean getIsMPerson() {
        return isMPerson;
    }

    public void setIsMPerson(Boolean isMPerson) {
        this.isMPerson = isMPerson;
    }

    @Schema(hidden = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Schema(hidden = true)
    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    @Schema(hidden = true)
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Schema(hidden = true)
    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    @Schema(
            example = "ناصر"
    )
    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }


    @Schema(
            required = true,
            example = "true"
    )
    public Boolean getIsNotActive() {
        return isNotActive;
    }

    public void setIsNotActive(Boolean isNotActive) {
        this.isNotActive = isNotActive;
    }

    @Schema(
            required = true,
            example = "false"
    )
    public Boolean getIsMpp() {
        return isMpp;
    }

    public void setIsMpp(Boolean isMpp) {
        this.isMpp = isMpp;
    }

    @Schema(
            required = true,
            example = "معدن شکافان تهران "
    )
    public String getPerComName() {
        return perComName;
    }

    public void setPerComName(String perComName) {
        this.perComName = perComName;
    }

    public String getSexDesc() {
        return sexDesc;
    }

    public void setSexDesc(String sexDesc) {
        this.sexDesc = sexDesc;
    }



    public Integer getSexType() {
        return sexType;
    }

    public void setSexType(Integer sexType) {
        this.sexType = sexType;
    }

    public String getCreateDateShamsi() {
        return createDateShamsi;
    }

    public void setCreateDateShamsi(String createDateShamsi) {
        this.createDateShamsi = createDateShamsi;
    }

    public String getModifyDateShamsi() {
        return modifyDateShamsi;
    }

    public void setModifyDateShamsi(String modifyDateShamsi) {
        this.modifyDateShamsi = modifyDateShamsi;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getModifyUserName() {
        return modifyUserName;
    }

    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
    }

    public BigDecimal getTafsiliTypeID() {
        return tafsiliTypeID;
    }

    public void setTafsiliTypeID(BigDecimal tafsiliTypeID) {
        this.tafsiliTypeID = tafsiliTypeID;
    }

    public String getTafsiliTypeDesc() {
        return tafsiliTypeDesc;
    }

    public void setTafsiliTypeDesc(String tafsiliTypeDesc) {
        this.tafsiliTypeDesc = tafsiliTypeDesc;
    }

    public String getTafsiliCode() {
        return tafsiliCode;
    }

    public void setTafsiliCode(String tafsiliCode) {
        this.tafsiliCode = tafsiliCode;
    }

    public BigDecimal getTypeID() {
        return typeID;
    }

    public void setTypeID(BigDecimal typeID) {
        this.typeID = typeID;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPreCityCode() {
        return preCityCode;
    }

    public void setPreCityCode(String preCityCode) {
        this.preCityCode = preCityCode;
    }

    public String getPerComTel() {
        return perComTel;
    }

    public void setPerComTel(String perComTel) {
        this.perComTel = perComTel;
    }

    public String getPerComMobile() {
        return perComMobile;
    }

    public void setPerComMobile(String percomMobile) {
        this.perComMobile = percomMobile;
    }

    public String getEconomicCode() {
        return economicCode;
    }

    public void setEconomicCode(String economicCode) {
        this.economicCode = economicCode;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public BigDecimal getBuySaleTypeID() {
        return buySaleTypeID;
    }

    public void setBuySaleTypeID(BigDecimal buySaleTypeID) {
        this.buySaleTypeID = buySaleTypeID;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public BigDecimal getStateID() {
        return stateID;
    }

    public void setStateID(BigDecimal stateID) {
        this.stateID = stateID;
    }

    public BigDecimal getCityID() {
        return cityID;
    }

    public void setCityID(BigDecimal cityID) {
        this.cityID = cityID;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getBuySaleTypeDesc() {
        return buySaleTypeDesc;
    }

    public void setBuySaleTypeDesc(String buySaleTypeDesc) {
        this.buySaleTypeDesc = buySaleTypeDesc;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public String getBuySaleTypeCode() {
        return buySaleTypeCode;
    }

    public void setBuySaleTypeCode(String buySaleTypeCode) {
        this.buySaleTypeCode = buySaleTypeCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public Boolean getIsProviderManNotActive() {
        return isProviderManNotActive;
    }

    public void setIsProviderManNotActive(Boolean isProviderManNotActive) {
        this.isProviderManNotActive = isProviderManNotActive;
    }

    public Boolean getIsStockerNotActive() {
        return isStockerNotActive;
    }

    public void setIsStockerNotActive(Boolean isStockerNotActive) {
        this.isStockerNotActive = isStockerNotActive;
    }

    public Boolean getIsMarketingManNotActive() {
        return isMarketingManNotActive;
    }

    public void setIsMarketingManNotActive(Boolean isMarketingManNotActive) {
        this.isMarketingManNotActive = isMarketingManNotActive;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getSalesManCode() {
        return salesManCode;
    }

    public void setSalesManCode(String salesManCode) {
        this.salesManCode = salesManCode;
    }

    public String getMarketingManCode() {
        return marketingManCode;
    }

    public void setMarketingManCode(String marketingManCode) {
        this.marketingManCode = marketingManCode;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    public String getNumberMemberStocker() {
        return numberMemberStocker;
    }

    public void setNumberMemberStocker(String numberMemberStocker) {
        this.numberMemberStocker = numberMemberStocker;
    }

    public String getBirthDateStocker() {
        return birthDateStocker;
    }

    public void setBirthDateStocker(String birthDateStocker) {
        this.birthDateStocker = birthDateStocker;
    }

    public String getNationalCodeStocker() {
        return nationalCodeStocker;
    }

    public void setNationalCodeStocker(String nationalCodeStocker) {
        this.nationalCodeStocker = nationalCodeStocker;
    }

    public String getIdentityCodeStocker() {
        return identityCodeStocker;
    }

    public void setIdentityCodeStocker(String identityCodeStocker) {
        this.identityCodeStocker = identityCodeStocker;
    }

    public BigDecimal getCustomerClassID() {
        return customerClassID;
    }

    public void setCustomerClassID(BigDecimal customerClassID) {
        this.customerClassID = customerClassID;
    }

    public BigDecimal getSalesManClassID() {
        return salesManClassID;
    }

    public void setSalesManClassID(BigDecimal salesManClassID) {
        this.salesManClassID = salesManClassID;
    }

    public BigDecimal getMarketingManClassID() {
        return marketingManClassID;
    }

    public void setMarketingManClassID(BigDecimal marketingManClassID) {
        this.marketingManClassID = marketingManClassID;
    }

    public BigDecimal getCustomerGeoID() {
        return customerGeoID;
    }

    public void setCustomerGeoID(BigDecimal customerGeoID) {
        this.customerGeoID = customerGeoID;
    }

    public BigDecimal getSalesManGeoID() {
        return salesManGeoID;
    }

    public void setSalesManGeoID(BigDecimal salesManGeoID) {
        this.salesManGeoID = salesManGeoID;
    }

    public BigDecimal getMarketingManGeoID() {
        return marketingManGeoID;
    }

    public void setMarketingManGeoID(BigDecimal marketingManGeoID) {
        this.marketingManGeoID = marketingManGeoID;
    }

    public BigDecimal getProviderGeoID() {
        return providerGeoID;
    }

    public void setProviderGeoID(BigDecimal providerGeoID) {
        this.providerGeoID = providerGeoID;
    }

    public String getCustomerClassDesc() {
        return customerClassDesc;
    }

    public void setCustomerClassDesc(String customerClassDesc) {
        this.customerClassDesc = customerClassDesc;
    }

    public String getSalesManClassDesc() {
        return salesManClassDesc;
    }

    public void setSalesManClassDesc(String salesManClassDesc) {
        this.salesManClassDesc = salesManClassDesc;
    }

    public String getMarketingManClassDesc() {
        return marketingManClassDesc;
    }

    public void setMarketingManClassDesc(String marketingManClassDesc) {
        this.marketingManClassDesc = marketingManClassDesc;
    }

    public String getCustomerGeoDesc() {
        return customerGeoDesc;
    }

    public void setCustomerGeoDesc(String customerGeoDesc) {
        this.customerGeoDesc = customerGeoDesc;
    }

    public String getSalesMangeoDesc() {
        return salesMangeoDesc;
    }

    public void setSalesMangeoDesc(String salesMangeoDesc) {
        this.salesMangeoDesc = salesMangeoDesc;
    }

    public String getMarketingManGeoDesc() {
        return marketingManGeoDesc;
    }

    public void setMarketingManGeoDesc(String marketingManGeoDesc) {
        this.marketingManGeoDesc = marketingManGeoDesc;
    }

    public String getProviderGeoDesc() {
        return providerGeoDesc;
    }

    public void setProviderGeoDesc(String providerGeoDesc) {
        this.providerGeoDesc = providerGeoDesc;
    }

    public String getProviderGeoCode() {
        return providerGeoCode;
    }

    public void setProviderGeoCode(String providerGeoCode) {
        this.providerGeoCode = providerGeoCode;
    }

    public Boolean getIsForeignProvider() {
        return isForeignProvider;
    }

    public void setIsForeignProvider(Boolean isForeignProvider) {
        this.isForeignProvider = isForeignProvider;
    }

    public String getProviderType() {
        return providerType;
    }

    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }

    public Integer getForeignProviderType() {
        return foreignProviderType;
    }

    public void setForeignProviderType(Integer foreignProviderType) {
        this.foreignProviderType = foreignProviderType;
    }

    public Boolean getIsStocker() {
        return isStocker;
    }

    public void setIsStocker(Boolean isStocker) {
        this.isStocker = isStocker;
    }

    public Boolean getIsSaleCustomer() {
        return isSaleCustomer;
    }

    public void setIsSaleCustomer(Boolean isSaleCustomer) {
        this.isSaleCustomer = isSaleCustomer;
    }

    public Boolean getIsMarketingMan() {
        return isMarketingMan;
    }

    public void setIsMarketingMan(Boolean isMarketingMan) {
        this.isMarketingMan = isMarketingMan;
    }

    public Boolean getIsSaleMan() {
        return isSaleMan;
    }

    public void setIsSaleMan(Boolean isSaleMan) {
        this.isSaleMan = isSaleMan;
    }

    public Boolean getIsProviderMan() {
        return isProviderMan;
    }

    public void setIsProviderMan(Boolean isProviderMan) {
        this.isProviderMan = isProviderMan;
    }

    public Boolean getIsPerson() {
        return isPerson;
    }

    public void setIsPerson(Boolean isPerson) {
        this.isPerson = isPerson;
    }

    public Boolean getIsCustomerNotActive() {
        return isCustomerNotActive;
    }

    public void setIsCustomerNotActive(Boolean isCustomerNotActive) {
        this.isCustomerNotActive = isCustomerNotActive;
    }

    public Boolean getIsSalesManNotActive() {
        return isSalesManNotActive;
    }

    public void setIsSalesManNotActive(Boolean isSalesManNotActive) {
        this.isSalesManNotActive = isSalesManNotActive;
    }
}
