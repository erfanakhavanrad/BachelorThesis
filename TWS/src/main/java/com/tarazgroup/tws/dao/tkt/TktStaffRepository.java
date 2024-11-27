package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dto.router.TRouter;
import com.tarazgroup.tws.dto.tkt.TktStaffDto;
import com.tarazgroup.tws.dto.tkt.department.TicketStatus;
import com.tarazgroup.tws.dto.tkt.routerParams.TRouterParamsUser;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktChangePassword;
import com.tarazgroup.tws.model.tkt.TktStaff;
import com.tarazgroup.tws.model.tkt.TktStaffRole;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.*;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Jan-29, 2022
 ***/

public interface TktStaffRepository extends TCrudRepository<TktStaff>, CrudRepository<TktStaff, BigDecimal> {

    default List<TktStaff> tktShowStaff1(TktStaff tktStaff) {
        ArrayList<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktStaff._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktStaff._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktStaff._pageFilter()));
        return showSP("TktShowStaff", tParameters, true);
    }

    default List<com.tarazgroup.tws.dto.tkt.staff.TktStaff> tktShowStaff(TktStaff tktStaff, BigDecimal departmentID) {
        ArrayList<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktStaff._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktStaff._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        if (departmentID != null && departmentID.intValue() != 1 && departmentID.intValue() != 2) {
            tParameters.add(new TParameter<>("PageFilter", "AND  DepartmentIDs like '%" + departmentID + "%'" + tktStaff._pageFilter()));
        } else {
            tParameters.add(new TParameter<>("PageFilter", tktStaff._pageFilter()));
        }
        List<TktStaff> tktStaffs = showSP("TktShowStaff", tParameters, true);
        List<com.tarazgroup.tws.dto.tkt.staff.TktStaff> __tktStaffs = new ArrayList<>();

        for (TktStaff _tktStaff : tktStaffs) {
            com.tarazgroup.tws.dto.tkt.staff.TktStaff __tktStaff = new com.tarazgroup.tws.dto.tkt.staff.TktStaff();
            __tktStaff.setStaffID(_tktStaff.getStaffID());
            __tktStaff.setUserName(_tktStaff.getUserName());
            __tktStaff.setDepartmentNames(_tktStaff.getDepartmentNames());
            TicketStatus ticketStatus = new TicketStatus();
            ticketStatus.setOpen(_tktStaff.getOpen());
            ticketStatus.setInProgress(_tktStaff.getInProgress());
            ticketStatus.setAnswered(_tktStaff.getAnswered());
            ticketStatus.setFounderAnswer(_tktStaff.getFounderAnswer());
            ticketStatus.setClosed(_tktStaff.getClosed());
            __tktStaff.setTicketStatus(ticketStatus);
            __tktStaff.setReceived(
                    new TRouter(_tktStaff.getReceived().toString(),
                            "arrow-down",
                            "tickets",
                            new TRouterParamsUser(null, _tktStaff.getStaffID()),
                            null)
            );
            __tktStaff.setSent(
                    new TRouter(_tktStaff.getSent().toString(),
                            "arrow-up",
                            "tickets",
                            new TRouterParamsUser(_tktStaff.getStaffID(), null),
                            null)
            );
            __tktStaffs.add(__tktStaff);
        }

        return __tktStaffs;

    }

//    default List<TktStaff> tktShowStaffByIDDep(BigDecimal departmentID /*, TktCustomerRepository tktCustomerRepository*/) {
//        ArrayList<TParameter<?>> tParameters = new ArrayList<>();
//        BigDecimal a = new BigDecimal("2");
////        if (departmentID == a){
//////            List<TktCustomer>  ff = tktCustomerRepository.tktShowCustomer(new TktCustomer());
//////            return  null;
////         } else{
//            tParameters.add(new TParameter<>("Filter", " AND A.DepartmentIDs LIKE '%" + departmentID + "%'"));
//            tParameters.add(new TParameter<>("OtherFilter", null));
//            tParameters.add(new TParameter<>("ServerFilter", null));
//            tParameters.add(new TParameter<>("YearFilter", null));
//            tParameters.add(new TParameter<>("UserAccessFilter", null));
//            tParameters.add(new TParameter<>("PageFilter", null));
//            return showSP("TktShowStaff", tParameters, true);
//        }
////    }
//
////    default TktStaff convertCustomerToStaff(TktCustomer tktCustomer) {
////       return  null;
////    }

    default TktStaff tktShowStaffByID1(BigDecimal staffID) {
        ArrayList<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND A.StaffID = " + staffID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowStaff", tParameters, true).get(0);
    }

    default TktStaffDto tktShowStaffByID(BigDecimal staffID, TktStaffRoleRepository tktStaffRoleRepository) {
        ArrayList<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND main.StaffID = " + staffID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        TktStaff tktStaff = showSP("TktShowStaff", tParameters, true).get(0);
        TktStaffDto tktStaffDto = new TktStaffDto();

        // اول
        tktStaffDto.setStaffID(tktStaff.getStaffID());
        tktStaffDto.setPerComFName(tktStaff.getPerComFName());
        tktStaffDto.setPerComLName(tktStaff.getPerComLName());
        tktStaffDto.setEmail(tktStaff.getUserLoginName());
        tktStaffDto.setUserMobileNumber(tktStaff.getUserMobileNumber());
        tktStaffDto.setPassword(tktStaff.getAndroidUserPass());
        tktStaffDto.setHasAccessSendTicketToCustomer(tktStaff.getHasAccessSendTicketToCustomer());
        tktStaffDto.setHasAccessToCustomerInfo(tktStaff.getHasAccessToCustomerInfo());

        List<TktStaffRole> tktStaffRoles = tktStaffRoleRepository.tktShowStaffRoleByStaffID(staffID);
        BigDecimal[] roles = new BigDecimal[tktStaffRoles.size()];
        for (int i = 0; i < tktStaffRoles.size(); i++) {
//            roles[i] = tktStaffRoles.get(i).getStaffRoleID();
            roles[i] = tktStaffRoles.get(i).getRoleID();
//            roles[i] = tktStaffRoles.get(i).getStaffID();
//            roles[i] = tktStaffRoles.get(i).getLoginID();
//            roles[i] = tktStaffRoles.get(i).getModifierID();
        }
        // از ریپو رول ها رول های این کاربر را بگیر و به صورت آرایه ای از بیگ ست کن

        tktStaffDto.setRoles(roles);
        return tktStaffDto;
    }

    default TktStaff tktInsStaff1(TktStaff tktStaff) throws NoSuchAlgorithmException {
        LogLogins logLogins = fetchUserDetail();
        TktChangePassword tktChangePassword = new TktChangePassword();
        String hashedUserAndPassword = md5Generator(tktChangePassword.getUserName() + "$$$$" + tktChangePassword.getPassword());
        List<TParameter<?>> tParameter = new ArrayList<>();
        tParameter.add(new TParameter<>("PerComFName", tktStaff.getPerComFName()));
        tParameter.add(new TParameter<>("PerComLName", tktStaff.getPerComLName()));
        tParameter.add(new TParameter<>("UserLoginName", tktStaff.getUserLoginName()));
        tParameter.add(new TParameter<>("UserMobileNumber", tktStaff.getUserMobileNumber()));
        tParameter.add(new TParameter<>("StaffImg", tktStaff.getStaffImg()));
        tParameter.add(new TParameter<>("HasAccessSendTicketToCustomer", tktStaff.getHasAccessSendTicketToCustomer()));
        tParameter.add(new TParameter<>("HasAccessToCustomerInfo", tktStaff.getHasAccessToCustomerInfo()));
        tParameter.add(new TParameter<>("IsNotActive", tktStaff.getIsNotActive()));
        tParameter.add(new TParameter<>("AndroidUserPass", tktStaff.getAndroidUserPass()));
        tParameter.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameter.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameter.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("TktInsStaff", tParameter);
        return tktShowStaffByID1(newID);
    }

    default String md5Generator(String webUserPass) throws NoSuchAlgorithmException {
        MessageDigest m;
        m = MessageDigest.getInstance("MD5");
        byte[] data = webUserPass.getBytes(StandardCharsets.UTF_8);
        m.update(data, 0, data.length);
        BigInteger i = new BigInteger(1, m.digest());
        return String.format("%1$032X", i);
    }

    default TktStaffDto tktInsStaff(TktStaffDto tktStaffDto, TktStaffRoleRepository tktStaffRoleRepository) throws NoSuchAlgorithmException {
//        TktChangePassword tktChangePassword = new TktChangePassword();
        String hashedUserAndPassword = md5Generator(tktStaffDto.getEmail() + "$$$$" + tktStaffDto.getPassword());
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameter = new ArrayList<>();


        tParameter.add(new TParameter<>("PerComFName", tktStaffDto.getPerComFName()));
        tParameter.add(new TParameter<>("PerComLName", tktStaffDto.getPerComLName()));
        tParameter.add(new TParameter<>("UserLoginName", tktStaffDto.getEmail()));
        tParameter.add(new TParameter<>("UserMobileNumber", tktStaffDto.getUserMobileNumber()));
//        tParameter.add(new TParameter<>("AndroidUserPass", hashedUserAndPassword));

        // just password
        tParameter.add(new TParameter<>("AndroidUserPass", tktStaffDto.getPassword()));

        tParameter.add(new TParameter<>("StaffImg", tktStaffDto.getStaffImg()));
        tParameter.add(new TParameter<>("HasAccessSendTicketToCustomer", tktStaffDto.getHasAccessSendTicketToCustomer()));
        tParameter.add(new TParameter<>("HasAccessToCustomerInfo", tktStaffDto.getHasAccessToCustomerInfo()));
        tParameter.add(new TParameter<>("IsNotActive", false));
        tParameter.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameter.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameter.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal staffsID = insSP("TktInsStaff", tParameter);
//        if (tktStaffDto.getRoles() == null){
//            throw  new Exception("لطفا نقش دپارتمان کارمند را مشخص کنید");
//        } else {
        for (int i = 0; i < tktStaffDto.getRoles().length; i++) {
            TktStaffRole tktStaffRole = new TktStaffRole();
            tktStaffRole.setStaffID(staffsID);
            tktStaffRole.setRoleID(tktStaffDto.getRoles()[i]);
            tktStaffRoleRepository.tktInsStaffRole(tktStaffRole);
        }
//        }
        return tktShowStaffByID(staffsID, tktStaffRoleRepository);

    }

    default TktStaffDto tktUpdStaff(BigDecimal staffID, TktStaffDto tktStaffDto, TktStaffRoleRepository tktStaffRoleRepository) throws NoSuchAlgorithmException {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameter = new ArrayList<>();
//        TktChangePassword tktChangePassword = new TktChangePassword();
//        String hashedUserAndPassword = md5Generator( tktChangePassword.getUserName() + "$$$$" + tktChangePassword.getPassword());
        tParameter.add(new TParameter<>("StaffID", staffID));
        tParameter.add(new TParameter<>("PerComFName", tktStaffDto.getPerComFName()));
        tParameter.add(new TParameter<>("PerComLName", tktStaffDto.getPerComLName()));
        tParameter.add(new TParameter<>("UserLoginName", tktStaffDto.getEmail()));
        tParameter.add(new TParameter<>("UserMobileNumber", tktStaffDto.getUserMobileNumber()));
        tParameter.add(new TParameter<>("StaffImg", tktStaffDto.getStaffImg()));
//        tParameter.add(new TParameter<>("AndroidUserPass", hashedUserAndPassword));
        tParameter.add(new TParameter<>("HasAccessSendTicketToCustomer", tktStaffDto.getHasAccessSendTicketToCustomer()));
        tParameter.add(new TParameter<>("HasAccessToCustomerInfo", tktStaffDto.getHasAccessToCustomerInfo()));
        tParameter.add(new TParameter<>("IsNotActive", tktStaffDto.getIsNotActive()));
        tParameter.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameter.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktUpdStaff", tParameter);
        // همه رول های این کاربر حذف شه از طرسق اس پی آخر اس پی کد حذف بزن

//        if (tktStaffDto.getRoles() == null){
//            throw  new NoSuchAlgorithmException("لطفا نقش دپارتمان کارمند را مشخص کنید");
//        } else {

        for (int i = 0; i < tktStaffDto.getRoles().length; i++) {
            TktStaffRole tktStaffRole = new TktStaffRole();
            tktStaffRole.setStaffID(staffID);
            tktStaffRole.setRoleID(tktStaffDto.getRoles()[i]);
            tktStaffRoleRepository.tktInsStaffRole(tktStaffRole);
        }
//        }
        // سپس فور بزن شبیه اینزرت روی رول ها
        return tktShowStaffByID(staffID, tktStaffRoleRepository);
    }

    default void tktDelStaff(BigDecimal staffID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameter = new ArrayList<>();
        tParameter.add(new TParameter<>("StaffID", staffID));
        tParameter.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TktDelStaff", tParameter);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "staffID", "staffID", Type.DECIMAL, 0, false, false,false, Icon.none, true));
        cols.add(new Col(null, "userName", "نام", Type.STRING, 200, true, true,true, Icon.none, false));
        cols.add(new Col(null, "departmentNames", "دپارتمان ها", Type.STRING, 300, true, true,true, Icon.industry, false));
        List<Info> infosTicketStatus = new ArrayList<>();
        Info infoOpen = new Info("open", "باز", "warning");
        Info infoInProgress = new Info("inProgress", "در حال بررسی", "danger");
        Info infoAnswered = new Info("answered", "پاسخ داده شده", "info");
        Info infoFounderAnswer = new Info("founderAnswer", "پاسخ ایجاد کننده تیکت", "success");
        Info infoClosed = new Info("closed", "بسته شده", "primary");
        infosTicketStatus.add(infoOpen);
        infosTicketStatus.add(infoInProgress);
        infosTicketStatus.add(infoAnswered);
        infosTicketStatus.add(infoFounderAnswer);
        infosTicketStatus.add(infoClosed);
        cols.add(new Col(null, "ticketStatus", "تیکت ها", Type.OBJECT, 550, true, true, infosTicketStatus,false, Icon.none, false));
        cols.add(new Col(null, "received", "دریافتی", Type.ROUTER, 70, true, true,false, Icon.none, false));
        cols.add(new Col(null, "sent", "ارسالی", Type.ROUTER, 70, true, true,false, Icon.none, false));
        return new Meta(cols);
    }

    default Meta meta1() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "staffID", "staffID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "perComFName", "*نام", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "perComLName", "*نام خانوادگی", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "userName", "نام", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "departmentIDs", "departmentIDs", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "departments", "دپارتمان ها", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "userLoginName", "*ایمیل", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "userMobileNumber", "شماره موبایل", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "androidUserPass", "کلمه عبور", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "isNotActive", "isNotActive", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "staffImg", "عکس", Type.IMAGE, 100, true, true, false));
        cols.add(new Col(null, "open", "باز", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "inProgress", "در حال بررسی", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "answered", "پاسخ داده شده", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "founderAnswer", "پاسخ ایجاد کننده تیتک", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "HasAccessSendTicketToCustomer", "دسترسی ارسال تیکت به مشتریان", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "HasAccessToCustomerInfo", "دسترسی به اطلاعات مشتریان", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "closed", "بسته شده", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "received", "دریافتی", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "sent", "ارسالی", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "roles", "نقش ها", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "isOwner", "isOwner", Type.BOOLEAN, 100, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false, false));

        return new Meta(cols);
    }
}
