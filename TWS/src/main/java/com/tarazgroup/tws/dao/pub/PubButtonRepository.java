package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dao.crm.CrmFormRepository;
import com.tarazgroup.tws.model.pub.PubButton;
import com.tarazgroup.tws.model.pub.PubQuickButtonInsert;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@SuppressWarnings("Duplicates")
public interface PubButtonRepository extends TCrudRepository<PubButton>, CrudRepository<PubButton, BigDecimal> {

    default List<PubButton> pubGetButtonAccess(BigDecimal userID, BigDecimal systemID, boolean canView, PubButton pubButton, PubUsersRepository pubUsersRepository, CrmFormRepository crmFormRepository) throws InterruptedException {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("UserID", userID));
        tParameters.add(new TParameter<>("SystemID", systemID));
        tParameters.add(new TParameter<>("FatherID", pubButton.getFatherID()));
        tParameters.add(new TParameter<>("ButtonID", pubButton.getButtonCode()));
        tParameters.add(new TParameter<>("CanView", canView));
        List<PubButton> pubButtons = showSP("PubGetButtonAccess", tParameters, true);

        //<editor-fold defaultstate="collapsed" desc="کد های زیر را فعلا غیر فعال کردم چون اس پی های سی آر ام برای مشتریان اندروید ممکن است وجود نداشته باشد">
        // با توجه به سرور آی دی فرم های سی آر ام که کاربر تعریف کزده را پیدا میکنیم
//        List<CrmForm> crmFormsUser =crmFormRepository.crmShowFormsUser(pubUsersRepository);;
//
//        //باتن آی دی منوی `فرم های سفارشی` باید همواره در دیتابیس 13400 باشد و نباید تغییر کند
//        for (int i = 0; i < crmFormsUser.size(); i++) {
//            CrmForm crmForm = crmFormsUser.get(i);
//            PubButton pubButton1 = new PubButton();
//            pubButton1.setButtonCode("001340" + (i + 1));
//            pubButton1.setButtonDesc(crmForm.getFormName());
//            pubButton1.setButtonID(new BigDecimal(13400 + i + 1));
//            pubButton1.setCanAdd(true);
//            pubButton1.setCanDel(true);
//            pubButton1.setCanEdit(true);
//            pubButton1.setCanPrint(true);
//            pubButton1.setCanView(true);
//            pubButton1.setFatherID(new BigDecimal(13400));
//            pubButton1.setRefSystemID(null);
//            pubButton1.setSystemID(new BigDecimal(13));
//            pubButton1.setWebAddress("formcustoms-formid");
//            pubButton1.setQuery("{\"formID\":" + crmForm.getFormID() + "}");
//            pubButtons.add(pubButton1);
//        }
        //</editor-fold>

        return pubButtons;
    }

    default boolean isvalid() {

        return true;
    }

}

// موارد زیر را پاک نکن شاید نیاز شد

//        // فرصت
//        //باتن آی دی فرصت باید همواره در دیتابیس 13101 باشد و نباید تغییر کند
//        CrmForm crmFormPotencial = crmForms.stream()
//                .filter(cf -> !cf.getCanDelete() && cf.getButtonID().intValue() == 13101)
//                .findAny()
//                .orElse(null);
//        PubButton pubButtonPotencial = pubButtons.stream()
//                .filter(pb -> pb.getButtonID().intValue() == 13101)
//                .findAny()
//                .orElse(null);
//        BigDecimal formIDPotencial = crmFormPotencial.getFormID();
//        pubButtonPotencial.setQuery("{\"formID\":" + formIDPotencial + "}");
//
//        // کمپین
//        //باتن آی دی کمپین باید همواره در دیتابیس 13102 باشد و نباید تغییر کند
//        CrmForm crmFormCampaign = crmForms.stream()
//                .filter(cf -> !cf.getCanDelete() && cf.getButtonID().intValue() == 13102)
//                .findAny()
//                .orElse(null);
//        PubButton pubButtonCampaign = pubButtons.stream()
//                .filter(pb -> pb.getButtonID().intValue() == 13102)
//                .findAny()
//                .orElse(null);
//        BigDecimal formIDCampaign = crmFormCampaign.getFormID();
//        pubButtonCampaign.setQuery("{\"formID\":" + formIDCampaign + "}");
//
//        // مشتری
//        //باتن آی دی مشتری باید همواره در دیتابیس 13201 باشد و نباید تغییر کند
//        CrmForm crmFormCustomer = crmForms.stream()
//                .filter(cf -> !cf.getCanDelete() && cf.getButtonID().intValue() == 13201)
//                .findAny()
//                .orElse(null);
//        PubButton pubButtonCustomer = pubButtons.stream()
//                .filter(pb -> pb.getButtonID().intValue() == 13201)
//                .findAny()
//                .orElse(null);
//        BigDecimal formIDCustomer = crmFormCustomer.getFormID();
//        pubButtonCustomer.setQuery("{\"formID\":" + formIDCustomer + "}");
//
//        // تیکت
//        //باتن آی دی تیکت باید همواره در دیتابیس 13202 باشد و نباید تغییر کند
//        CrmForm crmFormTicket = crmForms.stream()
//                .filter(cf -> !cf.getCanDelete() && cf.getButtonID().intValue() == 13202)
//                .findAny()
//                .orElse(null);
//        PubButton pubButtonTicket = pubButtons.stream()
//                .filter(pb -> pb.getButtonID().intValue() == 13202)
//                .findAny()
//                .orElse(null);
//        BigDecimal formIDTicket = crmFormTicket.getFormID();
//        pubButtonTicket.setQuery("{\"formID\":" + formIDTicket + "}");

// فرم های سفارشی کاربر یه منو ها اضافه  می شود
//        List<CrmForm> crmFormsCanDelete = crmForms.stream()
//                .filter(cf -> cf.getCanDelete())
//                .collect(Collectors.toList());
