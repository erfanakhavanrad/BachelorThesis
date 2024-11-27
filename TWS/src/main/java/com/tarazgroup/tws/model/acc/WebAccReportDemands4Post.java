package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "Web_AccReport_Demands_4Post",
        procedureName = "Web_AccReport_Demands_4Post",
        resultClasses = {WebAccReportDemands4Post.class},
        parameters = {
                @StoredProcedureParameter(name = "YearNo", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MonthNo", type = Integer.class, mode = ParameterMode.IN)
        }
)

@Entity
public class WebAccReportDemands4Post extends TParams implements Serializable {

    @Id
    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "ServerName")
    private String serverName;

    @Column(name = "واحد اجرایی")
    private String vahedEjraei;

    @Column(name = "مانده مطالبات پایان دوره سال 99")
    private BigDecimal mandeMotalebatPayanDoreSale99;

    @Column(name = "مانده مطالبات از ماه قبل|سنواتی")
    private BigDecimal mandeMotalebatAzMahGhablSanavati;

    @Column(name = "مانده مطالبات از ماه قبل|جاری")
    private BigDecimal mandeMotalebatAzMahGhablJari;

    @Column(name = "ایجاد طی ماه")
    private BigDecimal ijadTeyMah;

    @Column(name = "وصولی طی ماه|سنواتی")
    private BigDecimal vosoolTeyMahSanavati;

    @Column(name = "وصولی طی ماه|جاری")
    private BigDecimal vosoolTeyMahJari;

    @Column(name = "مبلغ مشمول بیمه در گروه مفاصا حساب")
    private BigDecimal MablaghMashmoolBimeDarGoroohMofasa;

    @Column(name = "مبلغ حسن انجام کار")
    private BigDecimal mablaghHosnAnjgamKar;

    @Column(name = "مطالبات مشکوک الوصول")
    private BigDecimal motalebatMashcookVosool;

    @Column(name = "مطالبات لاوصول")
    private BigDecimal motalebatLaVosool;

    @Column(name = "تعداد  قرارداد")
    private Integer tedadGharardad;

    @Column(name = "وصولی طی ماه|جمع کل وصولی")
    private BigDecimal vosoliTeyMahJamKolVosooli;

    @Column(name = "مانده|سنواتی")
    private BigDecimal mandeSanavati;

    @Column(name = "مانده|جاری")
    private BigDecimal mandeJAri;

    @Column(name = "مانده خالص مطالبات")
    private BigDecimal mandeKhalesMotalebat;

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getVahedEjraei() {
        return vahedEjraei;
    }

    public void setVahedEjraei(String vahedEjraei) {
        this.vahedEjraei = vahedEjraei;
    }

    public BigDecimal getMandeMotalebatPayanDoreSale99() {
        return mandeMotalebatPayanDoreSale99;
    }

    public void setMandeMotalebatPayanDoreSale99(BigDecimal mandeMotalebatPayanDoreSale99) {
        this.mandeMotalebatPayanDoreSale99 = mandeMotalebatPayanDoreSale99;
    }

    public BigDecimal getMandeMotalebatAzMahGhablSanavati() {
        return mandeMotalebatAzMahGhablSanavati;
    }

    public void setMandeMotalebatAzMahGhablSanavati(BigDecimal mandeMotalebatAzMahGhablSanavati) {
        this.mandeMotalebatAzMahGhablSanavati = mandeMotalebatAzMahGhablSanavati;
    }

    public BigDecimal getMandeMotalebatAzMahGhablJari() {
        return mandeMotalebatAzMahGhablJari;
    }

    public void setMandeMotalebatAzMahGhablJari(BigDecimal mandeMotalebatAzMahGhablJari) {
        this.mandeMotalebatAzMahGhablJari = mandeMotalebatAzMahGhablJari;
    }

    public BigDecimal getIjadTeyMah() {
        return ijadTeyMah;
    }

    public void setIjadTeyMah(BigDecimal ijadTeyMah) {
        this.ijadTeyMah = ijadTeyMah;
    }

    public BigDecimal getVosoolTeyMahSanavati() {
        return vosoolTeyMahSanavati;
    }

    public void setVosoolTeyMahSanavati(BigDecimal vosoolTeyMahSanavati) {
        this.vosoolTeyMahSanavati = vosoolTeyMahSanavati;
    }

    public BigDecimal getVosoolTeyMahJari() {
        return vosoolTeyMahJari;
    }

    public void setVosoolTeyMahJari(BigDecimal vosoolTeyMahJari) {
        this.vosoolTeyMahJari = vosoolTeyMahJari;
    }

    public BigDecimal getMablaghMashmoolBimeDarGoroohMofasa() {
        return MablaghMashmoolBimeDarGoroohMofasa;
    }

    public void setMablaghMashmoolBimeDarGoroohMofasa(BigDecimal mablaghMashmoolBimeDarGoroohMofasa) {
        MablaghMashmoolBimeDarGoroohMofasa = mablaghMashmoolBimeDarGoroohMofasa;
    }

    public BigDecimal getMablaghHosnAnjgamKar() {
        return mablaghHosnAnjgamKar;
    }

    public void setMablaghHosnAnjgamKar(BigDecimal mablaghHosnAnjgamKar) {
        this.mablaghHosnAnjgamKar = mablaghHosnAnjgamKar;
    }

    public BigDecimal getMotalebatMashcookVosool() {
        return motalebatMashcookVosool;
    }

    public void setMotalebatMashcookVosool(BigDecimal motalebatMashcookVosool) {
        this.motalebatMashcookVosool = motalebatMashcookVosool;
    }

    public BigDecimal getMotalebatLaVosool() {
        return motalebatLaVosool;
    }

    public void setMotalebatLaVosool(BigDecimal motalebatLaVosool) {
        this.motalebatLaVosool = motalebatLaVosool;
    }

    public Integer getTedadGharardad() {
        return tedadGharardad;
    }

    public void setTedadGharardad(Integer tedadGharardad) {
        this.tedadGharardad = tedadGharardad;
    }

    public BigDecimal getVosoliTeyMahJamKolVosooli() {
        return vosoliTeyMahJamKolVosooli;
    }

    public void setVosoliTeyMahJamKolVosooli(BigDecimal vosoliTeyMahJamKolVosooli) {
        this.vosoliTeyMahJamKolVosooli = vosoliTeyMahJamKolVosooli;
    }

    public BigDecimal getMandeSanavati() {
        return mandeSanavati;
    }

    public void setMandeSanavati(BigDecimal mandeSanavati) {
        this.mandeSanavati = mandeSanavati;
    }

    public BigDecimal getMandeJAri() {
        return mandeJAri;
    }

    public void setMandeJAri(BigDecimal mandeJAri) {
        this.mandeJAri = mandeJAri;
    }

    public BigDecimal getMandeKhalesMotalebat() {
        return mandeKhalesMotalebat;
    }

    public void setMandeKhalesMotalebat(BigDecimal mandeKhalesMotalebat) {
        this.mandeKhalesMotalebat = mandeKhalesMotalebat;
    }
}
