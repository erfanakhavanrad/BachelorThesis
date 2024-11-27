package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccPerCom;
import com.tarazgroup.tws.model.acc.AccPerComBody;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface AccPerComRepository extends TCrudRepository<AccPerCom>, CrudRepository<AccPerCom, BigDecimal> {

    default List<AccPerCom> accShowPerCom(AccPerCom accPerCom) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("Filter", null));
        tParameters.add(new TParameter("OtherFilter", null));
        tParameters.add(new TParameter("YearFilter", accPerCom._yearFilter()));
        tParameters.add(new TParameter("UserAccessFilter", null));
        tParameters.add(new TParameter("ServerFilter", accPerCom._serverFilter()));
        tParameters.add(new TParameter("GeneralFilter", null));
        tParameters.add(new TParameter("IsOtherInfo", false));
//        accPerCom.setRecordCount(new BigDecimal(14));// موقتی
//        accPerCom.setPageNumber(new BigDecimal(1));// موقتی
        tParameters.add(new TParameter("PageFilter", accPerCom._pageFilter()));
        return showSP("AccShowPerCom", tParameters, true);
    }

    default List<AccPerCom> accShowPerComNotUser(BigDecimal pageNumber, BigDecimal recordCount) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("Filter", null));
        tParameters.add(new TParameter("OtherFilter", null));
        tParameters.add(new TParameter("YearFilter", null));
        tParameters.add(new TParameter("UserAccessFilter", null));
        tParameters.add(new TParameter("ServerFilter", null));
        tParameters.add(new TParameter("GeneralFilter", null));
        tParameters.add(new TParameter("IsOtherInfo", false));
        tParameters.add(new TParameter("PageFilter", "AND PerComId not in (Select UserID from PubUsers) AND perComTypeID = 0 AND isMPerson = 1?"+pageNumber+","+recordCount+"?"));
        return showSP("AccShowPerCom", tParameters, true);
    }

    default AccPerCom accShowPerComByID(BigDecimal perComID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND main.perComID=" + perComID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("GeneralFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("AccShowPerCom", tParameters, true).get(0);
    }

    default void accDelPerCom(BigDecimal perComID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("PerComID", perComID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("WebUserType", null));
        delSP("AccDelPerCom", tParameters);
    }

    default AccPerCom accInsPerCom(AccPerComBody accPerComBody) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("PerComCode", accPerComBody.getAccPerCom().getPerComCode()));
        tParameters.add(new TParameter<>("PerComTitle", accPerComBody.getAccPerCom().getPerComTitle()));
        tParameters.add(new TParameter<>("PerComFName", accPerComBody.getAccPerCom().getPerComFName()));
        tParameters.add(new TParameter<>("PerComLName", accPerComBody.getAccPerCom().getPerComLName()));
        tParameters.add(new TParameter<>("SexID", accPerComBody.getAccPerCom().getSexID()));
        tParameters.add(new TParameter<>("PerComAddress", accPerComBody.getAccPerCom().getPerComAddress()));
        tParameters.add(new TParameter<>("PerComTypeID", accPerComBody.getAccPerCom().getPerComTypeID()));
        tParameters.add(new TParameter<>("TafsiliID", null));
        tParameters.add(new TParameter<>("TafsiliTypeID", accPerComBody.getAccPerCom().getTafsiliTypeID()));
        tParameters.add(new TParameter<>("IsMPerson", accPerComBody.getAccPerCom().getIsMPerson()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getCreatorID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("PerComNameLatin", accPerComBody.getAccPerCom().getPerComNameLatin()));
        tParameters.add(new TParameter<>("FatherName", accPerComBody.getAccPerCom().getFatherName()));
        tParameters.add(new TParameter<>("IsNotActive", accPerComBody.getAccPerCom().getIsNotActive()));
        tParameters.add(new TParameter<>("IsSaleCustomer", accPerComBody.getAccPerComOther().getIsSaleCustomer()));
        tParameters.add(new TParameter<>("IsSaleMan", accPerComBody.getAccPerComOther().getIsSaleMan()));
        tParameters.add(new TParameter<>("IsMarketingMan", accPerComBody.getAccPerComOther().getIsMarketingMan()));
        tParameters.add(new TParameter<>("IsProviderMan", accPerComBody.getAccPerComOther().getIsProviderMan()));
        tParameters.add(new TParameter<>("IsPerson", accPerComBody.getAccPerComOther().getIsPerson()));
        tParameters.add(new TParameter<>("IsStocker", accPerComBody.getAccPerComOther().getIsStocker()));
        tParameters.add(new TParameter<>("PercomTel", accPerComBody.getAccPerComOther().getPercomTel()));
        tParameters.add(new TParameter<>("PercomMobile", accPerComBody.getAccPerComOther().getPercomMobile()));
        tParameters.add(new TParameter<>("NationalCode", accPerComBody.getAccPerComOther().getNationalCode()));
        tParameters.add(new TParameter<>("CustomerCode", accPerComBody.getAccPerComOther().getCustomerCode()));
        tParameters.add(new TParameter<>("SalesManCode", accPerComBody.getAccPerComOther().getSalesManCode()));
        tParameters.add(new TParameter<>("MarketingManCode", accPerComBody.getAccPerComOther().getMarketingManCode()));
        tParameters.add(new TParameter<>("ProviderCode", accPerComBody.getAccPerComOther().getProviderCode()));
        tParameters.add(new TParameter<>("CustomerClassID", accPerComBody.getAccPerComOther().getCustomerClassID()));
        tParameters.add(new TParameter<>("SalesManClassID", accPerComBody.getAccPerComOther().getSalesManClassID()));
        tParameters.add(new TParameter<>("MarketingManClassID", accPerComBody.getAccPerComOther().getMarketingManClassID()));
        tParameters.add(new TParameter<>("CustomerGeoID", accPerComBody.getAccPerComOther().getCustomerGeoID()));
        tParameters.add(new TParameter<>("SalesManGeoID", accPerComBody.getAccPerComOther().getSalesManGeoID()));
        tParameters.add(new TParameter<>("MarketingManGeoID", accPerComBody.getAccPerComOther().getMarketingManGeoID()));
        tParameters.add(new TParameter<>("ProviderGeoID", accPerComBody.getAccPerComOther().getProviderGeoID()));
        tParameters.add(new TParameter<>("IsForeignProvider", accPerComBody.getAccPerComOther().getIsForeignProvider()));
        tParameters.add(new TParameter<>("IsCustomerNotActive", accPerComBody.getAccPerComOther().getIsCustomerNotActive()));
        tParameters.add(new TParameter<>("IsSalesManNotActive", accPerComBody.getAccPerComOther().getIsSalesManNotActive()));
        tParameters.add(new TParameter<>("IsMarketingManNotActive", accPerComBody.getAccPerComOther().getIsMarketingManNotActive()));
        tParameters.add(new TParameter<>("ISProviderManNotActive", accPerComBody.getAccPerComOther().getIsProviderManNotActive()));
        tParameters.add(new TParameter<>("ISStockerNotActive", accPerComBody.getAccPerComOther().getIsStockerNotActive()));
        tParameters.add(new TParameter<>("BirthDateStocker", accPerComBody.getAccPerComOther().getBirthDateStocker()));
        tParameters.add(new TParameter<>("NumberMemberStocker", accPerComBody.getAccPerComOther().getNumberMemberStocker()));
        tParameters.add(new TParameter<>("IdentityCodeStocker", accPerComBody.getAccPerComOther().getIdentityCodeStocker()));
        tParameters.add(new TParameter<>("IsAllowDuplicate", accPerComBody.getAccPerComOther().getIsAllowDuplicate()));
        tParameters.add(new TParameter<>("IsMpp", accPerComBody.getAccPerCom().getIsMpp()));
        tParameters.add(new TParameter<>("WebUserType", accPerComBody.getAccPerComOther().getWebUserType()));
        BigDecimal newID = insSP("AccInsPerCom", tParameters);
        return accShowPerComByID(newID);
    }

    default AccPerCom accUpdPerCom(BigDecimal perComID, AccPerComBody accPerComBody) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("PerComID", perComID));
        tParameters.add(new TParameter<>("PerComCode", accPerComBody.getAccPerCom().getPerComCode()));
        tParameters.add(new TParameter<>("PerComTitle", accPerComBody.getAccPerCom().getPerComTitle()));
        tParameters.add(new TParameter<>("PerComFName", accPerComBody.getAccPerCom().getPerComFName()));
        tParameters.add(new TParameter<>("PerComLName", accPerComBody.getAccPerCom().getPerComLName()));
        tParameters.add(new TParameter<>("SexID", accPerComBody.getAccPerCom().getSexID()));
        tParameters.add(new TParameter<>("PerComAddress", accPerComBody.getAccPerCom().getPerComAddress()));
        tParameters.add(new TParameter<>("PerComTypeID", accPerComBody.getAccPerCom().getPerComID()));
        tParameters.add(new TParameter<>("TafsiliTypeID", accPerComBody.getAccPerCom().getTafsiliTypeID()));
        tParameters.add(new TParameter<>("IsMPerson", accPerComBody.getAccPerCom().getIsMPerson()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("PerComNameLatin", accPerComBody.getAccPerCom().getPerComNameLatin()));
        tParameters.add(new TParameter<>("FatherName", accPerComBody.getAccPerCom().getFatherName()));
        tParameters.add(new TParameter<>("IsNotActive", accPerComBody.getAccPerCom().getIsNotActive()));
        tParameters.add(new TParameter<>("IsSaleCustomer", accPerComBody.getAccPerComOther().getIsSaleCustomer()));
        tParameters.add(new TParameter<>("IsSaleMan", accPerComBody.getAccPerComOther().getIsSaleMan()));
        tParameters.add(new TParameter<>("IsMarketingMan", accPerComBody.getAccPerComOther().getIsMarketingMan()));
        tParameters.add(new TParameter<>("IsProviderMan", accPerComBody.getAccPerComOther().getIsProviderMan()));
        tParameters.add(new TParameter<>("IsPerson", accPerComBody.getAccPerComOther().getIsPerson()));
        tParameters.add(new TParameter<>("IsStocker", accPerComBody.getAccPerComOther().getIsStocker()));
        tParameters.add(new TParameter<>("IsCustomerNotActive", accPerComBody.getAccPerComOther().getIsCustomerNotActive()));
        tParameters.add(new TParameter<>("IsSalesManNotActive", accPerComBody.getAccPerComOther().getIsSalesManNotActive()));
        tParameters.add(new TParameter<>("IsMarketingManNotActive", accPerComBody.getAccPerComOther().getIsMarketingManNotActive()));
        tParameters.add(new TParameter<>("IsProviderManNotActive", accPerComBody.getAccPerComOther().getIsProviderManNotActive()));
        tParameters.add(new TParameter<>("IsStockerNotActive", accPerComBody.getAccPerComOther().getIsStockerNotActive()));
        tParameters.add(new TParameter<>("CustomerCode", accPerComBody.getAccPerComOther().getCustomerCode()));
        tParameters.add(new TParameter<>("SalesManCode", accPerComBody.getAccPerComOther().getSalesManCode()));
        tParameters.add(new TParameter<>("MarketingManCode", accPerComBody.getAccPerComOther().getMarketingManCode()));
        tParameters.add(new TParameter<>("ProviderCode", accPerComBody.getAccPerComOther().getProviderCode()));
        tParameters.add(new TParameter<>("CustomerClassID", accPerComBody.getAccPerComOther().getCustomerClassID()));
        tParameters.add(new TParameter<>("SalesManClassID", accPerComBody.getAccPerComOther().getSalesManClassID()));
        tParameters.add(new TParameter<>("MarketingManClassID", accPerComBody.getAccPerComOther().getMarketingManClassID()));
        tParameters.add(new TParameter<>("CustomerGeoID", accPerComBody.getAccPerComOther().getCustomerGeoID()));
        tParameters.add(new TParameter<>("SalesManGeoID", accPerComBody.getAccPerComOther().getSalesManGeoID()));
        tParameters.add(new TParameter<>("MarketingManGeoID", accPerComBody.getAccPerComOther().getMarketingManGeoID()));
        tParameters.add(new TParameter<>("ProviderGeoID", accPerComBody.getAccPerComOther().getProviderGeoID()));
        tParameters.add(new TParameter<>("IsForeignProvider", accPerComBody.getAccPerComOther().getIsForeignProvider()));
        tParameters.add(new TParameter<>("BirthDateStocker", accPerComBody.getAccPerComOther().getBirthDateStocker()));
        tParameters.add(new TParameter<>("NumberMemberStocker", accPerComBody.getAccPerComOther().getNumberMemberStocker()));
        tParameters.add(new TParameter<>("IdentityCodeStocker", accPerComBody.getAccPerComOther().getIdentityCodeStocker()));
        tParameters.add(new TParameter<>("NationalCodeStocker", accPerComBody.getAccPerComOther().getNationalCodeStocker()));
        tParameters.add(new TParameter<>("IsMpp", accPerComBody.getAccPerCom().getIsMpp()));
        tParameters.add(new TParameter<>("WebUserType", accPerComBody.getAccPerComOther().getWebUserType()));
        updSP("AccUpdPerCom", tParameters);
        return accShowPerComByID(perComID);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"perComID", "perComID", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"perComCode", "کد", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"perComName", "شرح", Type.STRING, 250, true, true,  false));
        return new Meta(cols);
    }

    default Meta nameFamilyMeta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"perComID", "perComID", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"perComName", "نام کاربر", Type.STRING, 250, true, true,  false));
        return new Meta(cols);
    }

    default Meta personMeta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"perComID", "perComID", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"serverID", "serverID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"perComCode", "کد", Type.STRING, 50, true, true,  false));
        cols.add(new Col(null,"perComTitle", "عنوان", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"perComFName", "نام", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"perComLName", "نام خانوادگی", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"isMPerson", "کاربر", Type.BOOLEAN, 50, true, true,  false));
        cols.add(new Col(null,"perComAddress", "آدرس", Type.STRING, 200, true, true,  false));
        cols.add(new Col(null,"tafsiliCode", "کد تفصیلی", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"sexDesc", "جنسیت", Type.STRING, 70, true, true,  false));
        cols.add(new Col(null,"tafsiliTypeDesc", "گروه تفصیلی", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"perComNameLatin", "عنوان لاتين", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"fatherName", "نام پدر", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"isNotActive", "غیر فعال", Type.BOOLEAN, 80, true, true,  false));
        cols.add(new Col(null,"isMpp", "پرسنل تولید", Type.BOOLEAN, 100, true, true,  false));
        cols.add(new Col(null,"tafsiliID", "tafsiliID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"perComTypeID", "perComTypeID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"sexID", "sexID", Type.BOOLEAN, 0, false, false,  false));
        cols.add(new Col(null,"sexType", "sexType", Type.INTEGER, 0, false, false,  false));
        cols.add(new Col(null,"typeCode", "کد نوع شخص", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"typeDesc", "شرح نوع شخص", Type.STRING, 120, true, true,  false));
        cols.add(new Col(null,"buySaleTypeID", "buySaleTypeID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"buySaleTypeCode", "کد نوع خرید / فروش", Type.STRING, 130, true, true,  false));
        cols.add(new Col(null,"buySaleTypeDesc", "شرح نوع خرید / فروش", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"nationalCode", "شناسه ملی", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"economicCode", "کد اقتصادی", Type.STRING, 80, true, true,  false));
        cols.add(new Col(null,"perComTel", "تلفن", Type.STRING, 80, true, true,  false));
        cols.add(new Col(null,"perComMobile", "موبایل", Type.STRING, 80, true, true,  false));
        cols.add(new Col(null,"postalCode", "کدپستی", Type.STRING, 80, true, true,  false));
        cols.add(new Col(null,"preCityCode", "پیش کد شهر", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"stateCode", "کد استان", Type.STRING, 80, true, true,  false));
        cols.add(new Col(null,"stateName", "نام استان", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"cityCode", "کد شهر", Type.STRING, 80, true, true,  false));
        cols.add(new Col(null,"cityName", "نام شهر", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"zoneCode", "حوزه", Type.DECIMAL, 100, true, true,  false));
        cols.add(new Col(null,"isSaleCustomer", "مشتری", Type.BOOLEAN, 70, true, true,  false));
        cols.add(new Col(null,"customerCode", "کد مشتری", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"customerClassDesc", "طبقه مشتری", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"customerGeoDesc", "منطقه مشتری", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"isCustomerNotActive", "مشتری غیر فعال", Type.BOOLEAN, 120, true, true,  false));
        cols.add(new Col(null,"isSaleMan", "فروشنده", Type.BOOLEAN, 70, true, true,  false));
        cols.add(new Col(null,"salesManCode", "کد فروشنده", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"salesManClassDesc", "طبقه فروشنده", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"salesMangeoDesc", "منطقه فروشنده", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"isSalesManNotActive", "فروشنده غیرفعال", Type.BOOLEAN, 120, true, true,  false));
        cols.add(new Col(null,"isMarketingMan", "بازاریاب", Type.BOOLEAN, 70, true, true,  false));
        cols.add(new Col(null,"marketingManCode", "کد بازاریاب", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"marketingManClassDesc", "طبقه بازاریاب", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"marketingManGeoDesc", "منطقه بازاریاب", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"isMarketingManNotActive", "بازاریاب غیر فعال", Type.BOOLEAN, 120, true, true,  false));
        cols.add(new Col(null,"isProviderMan", "تامین کننده", Type.BOOLEAN, 150, true, true,  false));
        cols.add(new Col(null,"providerCode", "کد تامین کننده", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"isForeignProvider", "تامین کننده خارجی", Type.BOOLEAN, 150, true, true,  false));
        cols.add(new Col(null,"providerGeoDesc", "کشور تامین کننده", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"isProviderManNotActive", "تامین کننده غیر فعال", Type.BOOLEAN, 150, true, true,  false));
        cols.add(new Col(null,"isStocker", "سهام دار", Type.BOOLEAN, 150, true, true,  false));
        cols.add(new Col(null,"nationalCodeStocker", "کد ملی سهامدار", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"identityCodeStocker", "شماره شناسنامه سهامدار", Type.STRING, 200, true, true,  false));
        cols.add(new Col(null,"birthDateStocker", "تاریخ تولد سهامدار", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"numberMemberStocker", "شماره عضویت سهامدار", Type.STRING, 200, true, true,  false));
        cols.add(new Col(null,"isStockerNotActive", "سهام دار غیر فعال", Type.BOOLEAN, 150, true, true,  false));
        cols.add(new Col(null,"createDateShamsi", "زمان تنظیم", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"createUserName", "کاربر تنظیم کننده", Type.STRING, 130, true, true,  false));
        cols.add(new Col(null,"modifyDateShamsi", "زمان ویرایش", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"modifyUserName", "کاربر ویرایش کننده", Type.STRING, 130, true, true,  false));
        cols.add(new Col(null,"createDate", "createDate", Type.DATE, 0, false, false,  false));
        cols.add(new Col(null,"creatorID", "creatorID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"modifyDate", "modifyDate", Type.DATE, 0, false, false,  false));
        cols.add(new Col(null,"tafsiliTypeID", "tafsiliTypeID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"modifierID", "modifierID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"typeID", "typeID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"stateID", "stateID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"cityID", "cityID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"customerClassID", "customerClassID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"salesManClassID", "salesManClassID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"marketingManClassID", "marketingManClassID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"customerGeoID", "customerGeoID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"salesManGeoID", "salesManGeoID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"marketingManClassID", "marketingManClassID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"marketingManGeoID", "marketingManGeoID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"providerGeoID", "providerGeoID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"providerGeoCode", "providerGeoCode", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"providerType", "providerType", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"foreignProviderType", "foreignProviderType", Type.INTEGER, 0, false, false,  false));
        cols.add(new Col(null,"isPerson", "isPerson", Type.BOOLEAN, 0, false, false,  false));
        return new Meta(cols);
    }


    default Meta companyMeta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"perComID", "perComID", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"serverID", "serverID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"perComCode", "کد", Type.STRING, 50, true, true,  false));
        cols.add(new Col(null,"perComTitle", "عنوان", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"perComFName", "نام", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"perComLName", "نام خانوادگی", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"isMPerson", "کاربر", Type.BOOLEAN, 50, true, true,  false));
        cols.add(new Col(null,"perComAddress", "آدرس", Type.STRING, 200, true, true,  false));
        cols.add(new Col(null,"tafsiliCode", "کد تفصیلی", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"sexDesc", "جنسیت", Type.STRING, 70, true, true,  false));
        cols.add(new Col(null,"tafsiliTypeDesc", "گروه تفصیلی", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"perComNameLatin", "عنوان لاتين", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"fatherName", "نام پدر", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"isNotActive", "غیر فعال", Type.BOOLEAN, 80, true, true,  false));
        cols.add(new Col(null,"isMpp", "پرسنل تولید", Type.BOOLEAN, 100, true, true,  false));
        cols.add(new Col(null,"tafsiliID", "tafsiliID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"perComTypeID", "perComTypeID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"sexID", "sexID", Type.BOOLEAN, 0, false, false,  false));
        cols.add(new Col(null,"sexType", "sexType", Type.INTEGER, 0, false, false,  false));
        cols.add(new Col(null,"typeCode", "کد نوع شخص", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"typeDesc", "شرح نوع شخص", Type.STRING, 120, true, true,  false));
        cols.add(new Col(null,"buySaleTypeID", "buySaleTypeID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"buySaleTypeCode", "کد نوع خرید / فروش", Type.STRING, 130, true, true,  false));
        cols.add(new Col(null,"buySaleTypeDesc", "شرح نوع خرید / فروش", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"nationalCode", "شناسه ملی", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"economicCode", "کد اقتصادی", Type.STRING, 80, true, true,  false));
        cols.add(new Col(null,"perComTel", "تلفن", Type.STRING, 80, true, true,  false));
        cols.add(new Col(null,"perComMobile", "موبایل", Type.STRING, 80, true, true,  false));
        cols.add(new Col(null,"postalCode", "کدپستی", Type.STRING, 80, true, true,  false));
        cols.add(new Col(null,"preCityCode", "پیش کد شهر", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"stateCode", "کد استان", Type.STRING, 80, true, true,  false));
        cols.add(new Col(null,"stateName", "نام استان", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"cityCode", "کد شهر", Type.STRING, 80, true, true,  false));
        cols.add(new Col(null,"cityName", "نام شهر", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"zoneCode", "حوزه", Type.DECIMAL, 100, true, true,  false));
        cols.add(new Col(null,"isSaleCustomer", "مشتری", Type.BOOLEAN, 70, true, true,  false));
        cols.add(new Col(null,"customerCode", "کد مشتری", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"customerClassDesc", "طبقه مشتری", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"customerGeoDesc", "منطقه مشتری", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"isCustomerNotActive", "مشتری غیر فعال", Type.BOOLEAN, 120, true, true,  false));
        cols.add(new Col(null,"isSaleMan", "فروشنده", Type.BOOLEAN, 70, true, true,  false));
        cols.add(new Col(null,"salesManCode", "کد فروشنده", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"salesManClassDesc", "طبقه فروشنده", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"salesMangeoDesc", "منطقه فروشنده", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"isSalesManNotActive", "فروشنده غیرفعال", Type.BOOLEAN, 120, true, true,  false));
        cols.add(new Col(null,"isMarketingMan", "بازاریاب", Type.BOOLEAN, 70, true, true,  false));
        cols.add(new Col(null,"marketingManCode", "کد بازاریاب", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"marketingManClassDesc", "طبقه بازاریاب", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"marketingManGeoDesc", "منطقه بازاریاب", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"isMarketingManNotActive", "بازاریاب غیر فعال", Type.BOOLEAN, 120, true, true,  false));
        cols.add(new Col(null,"isProviderMan", "تامین کننده", Type.BOOLEAN, 150, true, true,  false));
        cols.add(new Col(null,"providerCode", "کد تامین کننده", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"isForeignProvider", "تامین کننده خارجی", Type.BOOLEAN, 150, true, true,  false));
        cols.add(new Col(null,"providerGeoDesc", "کشور تامین کننده", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"isProviderManNotActive", "تامین کننده غیر فعال", Type.BOOLEAN, 150, true, true,  false));
        cols.add(new Col(null,"isStocker", "سهام دار", Type.BOOLEAN, 150, true, true,  false));
        cols.add(new Col(null,"nationalCodeStocker", "کد ملی سهامدار", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"identityCodeStocker", "شماره شناسنامه سهامدار", Type.STRING, 200, true, true,  false));
        cols.add(new Col(null,"birthDateStocker", "تاریخ تولد سهامدار", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"numberMemberStocker", "شماره عضویت سهامدار", Type.STRING, 200, true, true,  false));
        cols.add(new Col(null,"isStockerNotActive", "سهام دار غیر فعال", Type.BOOLEAN, 150, true, true,  false));
        cols.add(new Col(null,"createDateShamsi", "زمان تنظیم", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"createUserName", "کاربر تنظیم کننده", Type.STRING, 130, true, true,  false));
        cols.add(new Col(null,"modifyDateShamsi", "زمان ویرایش", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"modifyUserName", "کاربر ویرایش کننده", Type.STRING, 130, true, true,  false));
        cols.add(new Col(null,"createDate", "createDate", Type.DATE, 0, false, false,  false));
        cols.add(new Col(null,"creatorID", "creatorID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"modifyDate", "modifyDate", Type.DATE, 0, false, false,  false));
        cols.add(new Col(null,"tafsiliTypeID", "tafsiliTypeID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"modifierID", "modifierID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"typeID", "typeID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"stateID", "stateID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"cityID", "cityID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"customerClassID", "customerClassID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"salesManClassID", "salesManClassID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"marketingManClassID", "marketingManClassID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"customerGeoID", "customerGeoID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"salesManGeoID", "salesManGeoID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"marketingManClassID", "marketingManClassID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"marketingManGeoID", "marketingManGeoID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"providerGeoID", "providerGeoID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"providerGeoCode", "providerGeoCode", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"providerType", "providerType", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"foreignProviderType", "foreignProviderType", Type.INTEGER, 0, false, false,  false));
        cols.add(new Col(null,"isPerson", "isPerson", Type.BOOLEAN, 0, false, false,  false));
        return new Meta(cols);
    }

}
