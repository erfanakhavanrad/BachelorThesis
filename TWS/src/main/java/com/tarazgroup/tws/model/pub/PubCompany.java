package com.tarazgroup.tws.model.pub;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.math.BigDecimal;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

@NamedStoredProcedureQuery(
        name = "PubShowCompany",
        procedureName = "PubShowCompany",
        resultClasses = {PubCompany.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class PubCompany extends TParams  {

    @Id
    @Column(name = "CompanyID", columnDefinition = "decimal")
    private BigDecimal companyID;

    @Column(name = "CompanyFName", columnDefinition = "varbinary")
    private String companyFName;

    @Column(name = "CompanyEName", columnDefinition = "nvarchar")
    private String companyEName;

    @Column(name = "CompanyBriefName", columnDefinition = "nvarchar")
    private String companyBriefName;

    @Column(name = "Address", columnDefinition = "nvarchar")
    private String address;

    @Column(name = "ZipCode", columnDefinition = "nvarchar")
    private String zipCode;

    @Column(name = "Tel", columnDefinition = "nvarchar")
    private String tel;

    @Column(name = "EconomicCode", columnDefinition = "nvarchar")
    private String economicCode;

    @Column(name = "RegistrationCode", columnDefinition = "nvarchar")
    private String registrationCode;

    @Column(name = "WebSite", columnDefinition = "nvarchar")
    private String webSite;

    @Column(name = "CompanyLogo", columnDefinition = "varbinary")
    private String companyLogo;

    @Column(name = "GeneralManagerID", columnDefinition = "decimal")
    private BigDecimal generalManagerID;

    @Column(name = "GeneralManager2ID", columnDefinition = "decimal")
    private BigDecimal generalManager2ID;

    @Column(name = "SystemInstallDir", columnDefinition = "nvarchar")
    private String systemInstallDir;

    @Column(name = "ServerInstallDir", columnDefinition = "nvarchar")
    private String serverInstallDir;

    @Column(name = "BackUpAdress", columnDefinition = "nvarchar")
    private String backUpAdress;

    @Column(name = "BackUpFileAdress", columnDefinition = "nvarchar")
    private String backUpFileAdress;

    @Column(name = "CompanyDesc", columnDefinition = "nvarchar")
    private String companyDesc;

    @Column(name = "IsArabicKBD", columnDefinition = "bit")
    private Boolean isArabicKBD;

    @Column(name = "CompanyCode", columnDefinition = "varchar")
    private String CompanyCode;

    @Column(name = "ActiveSyss", columnDefinition = "varchar")
    private String activeSyss;

    @Column(name = "GeneralManagerDesc", columnDefinition = "varchar")
    private String generalManagerDesc;

    @Column(name = "GeneralManager1Desc", columnDefinition = "varchar")
    private String generalManager1Desc;



    @Schema(accessMode = READ_ONLY)
    public BigDecimal getCompanyID() {
        return companyID;
    }

    public void setCompanyID(BigDecimal companyID) {
        this.companyID = companyID;
    }

    public String getCompanyFName() {
        return companyFName;
    }

    public void setCompanyFName(String companyFName) {
        this.companyFName = companyFName;
    }

    public String getCompanyEName() {
        return companyEName;
    }

    public void setCompanyEName(String companyEName) {
        this.companyEName = companyEName;
    }

    public String getCompanyBriefName() {
        return companyBriefName;
    }

    public void setCompanyBriefName(String companyBriefName) {
        this.companyBriefName = companyBriefName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEconomicCode() {
        return economicCode;
    }

    public void setEconomicCode(String economicCode) {
        this.economicCode = economicCode;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public BigDecimal getGeneralManagerID() {
        return generalManagerID;
    }

    public void setGeneralManagerID(BigDecimal generalManagerID) {
        this.generalManagerID = generalManagerID;
    }

    public BigDecimal getGeneralManager2ID() {
        return generalManager2ID;
    }

    public void setGeneralManager2ID(BigDecimal generalManager2ID) {
        this.generalManager2ID = generalManager2ID;
    }

    public String getSystemInstallDir() {
        return systemInstallDir;
    }

    public void setSystemInstallDir(String systemInstallDir) {
        this.systemInstallDir = systemInstallDir;
    }

    public String getServerInstallDir() {
        return serverInstallDir;
    }

    public void setServerInstallDir(String serverInstallDir) {
        this.serverInstallDir = serverInstallDir;
    }

    public String getBackUpAdress() {
        return backUpAdress;
    }

    public void setBackUpAdress(String backUpAdress) {
        this.backUpAdress = backUpAdress;
    }

    public String getBackUpFileAdress() {
        return backUpFileAdress;
    }

    public void setBackUpFileAdress(String backUpFileAdress) {
        this.backUpFileAdress = backUpFileAdress;
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    public Boolean getArabicKBD() {
        return isArabicKBD;
    }

    public void setArabicKBD(Boolean arabicKBD) {
        isArabicKBD = arabicKBD;
    }

    public String getCompanyCode() {
        return CompanyCode;
    }

    public void setCompanyCode(String companyCode) {
        CompanyCode = companyCode;
    }

    public String getActiveSyss() {
        return activeSyss;
    }

    public void setActiveSyss(String activeSyss) {
        this.activeSyss = activeSyss;
    }

    public String getGeneralManagerDesc() {
        return generalManagerDesc;
    }

    public void setGeneralManagerDesc(String generalManagerDesc) {
        this.generalManagerDesc = generalManagerDesc;
    }

    public String getGeneralManager1Desc() {
        return generalManager1Desc;
    }

    public void setGeneralManager1Desc(String generalManager1Desc) {
        this.generalManager1Desc = generalManager1Desc;
    }
}

