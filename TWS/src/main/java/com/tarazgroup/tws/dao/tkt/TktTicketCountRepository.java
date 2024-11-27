package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktTicket;
import com.tarazgroup.tws.model.tkt.TktTicketCount;
import com.tarazgroup.tws.util.global.TCalendar;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 7/16/22
 *
 * @author Erfan Akhavan
 */
public interface TktTicketCountRepository extends TCrudRepository<TktTicketCount>, CrudRepository<TktTicketCount, BigDecimal> {

    default String createFilter(TktTicket tktTicket, TktUserRepository tktUserRepository) {
        String filterParam = "";
        TCalendar tCalendar = new TCalendar();
        LogLogins logLogins = fetchUserDetail();
        String staffQuery = "AND (Main.FromUserID = " + logLogins.getPubUser().getUserID() + " OR Main.ToUserID = " + logLogins.getPubUser().getUserID() + " OR Main.TicketID IN (SELECT TMain.TicketID FROM TktTicket TMain LEFT JOIN TktUser TTUser ON TTUser.UserID = TMain.FromUserID WHERE TTUser.IsCustomer = 1 AND TMain.ToUserID IN (SELECT SMain.StaffID FROM TktStaff SMain JOIN TktStaffRole SSRole ON SSRole.StaffID = SMain.StaffID JOIN TktRole STRole ON STRole.RoleID = SSRole.RoleID JOIN TktDepartment SDep ON STRole.DepartmentID = SDep.DepartmentID WHERE STRole.IsOwner = 1 AND SDep.DepartmentID IN (SELECT DMain.DepartmentID FROM TktDepartment DMain JOIN TktRole DTRole ON DTRole.DepartmentID = DMain.DepartmentID JOIN TktStaffRole DSRole ON DSRole.RoleID = DTRole.RoleID WHERE DSRole.StaffID = " + logLogins.getPubUser().getUserID() + "))))";
        String staffOwnerQuery = "AND (Main.FromUserID = " + logLogins.getPubUser().getUserID() + " OR Main.ToUserID = " + logLogins.getPubUser().getUserID() + " OR Main.TicketID IN (SELECT TMain.TicketID FROM TktTicket TMain WHERE TMain.ToUserID IN (SELECT SMain.StaffID FROM TktStaff SMain JOIN TktStaffRole SSRole ON SMain.StaffID = SSRole.StaffID JOIN TktRole STRole ON SSRole.RoleID = STRole.RoleID JOIN TktDepartment SDep ON STRole.DepartmentID = SDep.DepartmentID WHERE STRole.IsOwner = 0 AND SDep.DepartmentID IN (SELECT DMain.DepartmentID FROM TktDepartment DMain JOIN TktRole DTRole ON DTRole.DepartmentID = DMain.DepartmentID JOIN TktStaffRole DSRole ON DSRole.RoleID = DTRole.RoleID WHERE DSRole.StaffID = " + logLogins.getPubUser().getUserID() + ")) OR TMain.FromUserID IN (SELECT SMain.StaffID FROM TktStaff SMain JOIN TktStaffRole SSRole ON SMain.StaffID = SSRole.StaffID JOIN TktRole STRole ON SSRole.RoleID = STRole.RoleID JOIN TktDepartment SDep ON STRole.DepartmentID = SDep.DepartmentID WHERE STRole.IsOwner = 0 AND SDep.DepartmentID IN (SELECT DMain.DepartmentID FROM TktDepartment DMain JOIN TktRole DTRole ON DTRole.DepartmentID = DMain.DepartmentID JOIN TktStaffRole DSRole ON DSRole.RoleID = DTRole.RoleID WHERE DSRole.StaffID = " + logLogins.getPubUser().getUserID() + "))))";
        String customerQuery = " AND (Main.FromUserID = " + logLogins.getPubUser().getUserID() + " OR Main.ToUserID = " + logLogins.getPubUser().getUserID() + ")";
        String customerOwnerQuery = " AND (Main.FromUserID IN (" + logLogins.getPubUser().getUserID() + " , (SELECT TOP 1 C.CustomerID FROM TktCustomer C LEFT JOIN TktOrganization O ON C.OrganizationID = O.OrganizationID WHERE C.IsOrganizationOwner = 0 AND O.OrganizationID = " + tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getOrganizationID() + ")) OR Main.ToUserID IN (" + logLogins.getPubUser().getUserID() + ", (SELECT TOP 1 C.CustomerID FROM TktCustomer C LEFT JOIN TktOrganization O ON C.OrganizationID = O.OrganizationID WHERE C.IsOrganizationOwner = 0 AND O.OrganizationID = " + tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getOrganizationID() + " )) )";

        if (tktTicket.getTicketTitle() != null) {
            // Administrator
            if (Objects.equals(logLogins.getPubUser().getIsAdmin(), "1")) {
                filterParam += " AND Main.TicketTitle LIKE '%" + tktTicket.getTicketTitle() + "%'";
            } else {
                //staff
                if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getIsCustomer() == false) {
                    // staff
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += staffQuery + " AND Main.TicketTitle LIKE '%" + tktTicket.getTicketTitle() + "%'";
                        // owner staff
                    } else {
                        filterParam += staffOwnerQuery + " AND Main.TicketTitle LIKE '%" + tktTicket.getTicketTitle() + "%'";
                    }
                    //customers
                } else {
                    // customer
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += customerQuery + " AND Main.TicketTitle LIKE '%" + tktTicket.getTicketTitle() + "%'";
                        // company manager
                    } else {
                        filterParam += customerOwnerQuery + "AND Main.TicketTitle LIKE '%" + tktTicket.getTicketTitle() + "%'";
                    }
                }
            }
        }
        if (tktTicket.getTicketCategoryID() != null) {
            if (Objects.equals(logLogins.getPubUser().getIsAdmin(), "1")) {
                filterParam += "AND Main.TicketCategoryID = " + tktTicket.getTicketCategoryID();
            } else {
                if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getIsCustomer() == false) {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += staffQuery + "AND Main.TicketCategoryID = " + tktTicket.getTicketCategoryID();
                    } else {
                        filterParam += staffOwnerQuery + "AND Main.TicketCategoryID = " + tktTicket.getTicketCategoryID();
                    }
                } else {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += customerQuery + "AND Main.TicketCategoryID = " + tktTicket.getTicketCategoryID();
                    } else {
                        filterParam += customerOwnerQuery + "AND Main.TicketCategoryID = " + tktTicket.getTicketCategoryID();
                    }
                }
            }
        }

        if (tktTicket.getTicketNumber() != null) {
            if (Objects.equals(logLogins.getPubUser().getIsAdmin(), "1")) {
                filterParam += "AND Main.TicketNumber = " + tktTicket.getTicketNumber();
            } else {
                if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getIsCustomer() == false) {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += staffQuery + "AND Main.TicketNumber = " + tktTicket.getTicketNumber();
                    } else {
                        filterParam += staffOwnerQuery + "AND Main.TicketNumber = " + tktTicket.getTicketNumber();
                    }
                } else {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += customerQuery + "AND Main.TicketNumber = " + tktTicket.getTicketNumber();
                    } else {
                        filterParam += customerOwnerQuery + "AND Main.TicketNumber = " + tktTicket.getTicketNumber();
                    }
                }
            }
        }

        if (tktTicket.getFromDepartmentID() != null) {
            if (Objects.equals(logLogins.getPubUser().getIsAdmin(), "1")) {
                filterParam += "AND Main.FromDepartmentID = " + tktTicket.getFromDepartmentID();
            } else {
                if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getIsCustomer() == false) {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += staffQuery + "AND Main.FromDepartmentID = " + tktTicket.getFromDepartmentID();
                    } else {
                        filterParam += staffOwnerQuery + "AND Main.FromDepartmentID = " + tktTicket.getFromDepartmentID();
                    }
                } else {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += customerQuery + "AND Main.FromDepartmentID = " + tktTicket.getFromDepartmentID();
                    } else {
                        filterParam += customerOwnerQuery + "AND Main.FromDepartmentID = " + tktTicket.getFromDepartmentID();
                    }
                }
            }
        }

        if (tktTicket.getFromOrganizationID() != null) {
            if (Objects.equals(logLogins.getPubUser().getIsAdmin(), "1")) {
                filterParam += "AND Main.FromOrganizationID = " + tktTicket.getFromOrganizationID();
            } else {
                if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getIsCustomer() == false) {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += staffQuery + "AND Main.FromOrganizationID = " + tktTicket.getFromOrganizationID();
                    } else {
                        filterParam += staffOwnerQuery + "AND Main.FromOrganizationID = " + tktTicket.getFromOrganizationID();
                    }
                } else {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += customerQuery + "AND Main.FromOrganizationID = " + tktTicket.getFromOrganizationID();
                    } else {
                        filterParam += customerOwnerQuery + "AND Main.FromOrganizationID = " + tktTicket.getFromOrganizationID();
                    }
                }
            }
        }

        if (tktTicket.getFromUserID() != null) {

            if (Objects.equals(logLogins.getPubUser().getIsAdmin(), "1")) {
                if (Objects.equals(tktTicket.getFromUserID(), logLogins.getPubUser().getUserID())) {
                    filterParam += "AND FUser.IsCustomer = 0";
                } else {
                    filterParam += "AND Main.FromUserID = " + tktTicket.getFromUserID();
                }
            } else {
                if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getIsCustomer() == false) {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += staffQuery + "AND Main.FromUserID = " + tktTicket.getFromUserID();
                    } else {
                        filterParam += staffOwnerQuery + "AND Main.FromUserID = " + tktTicket.getFromUserID();
                    }
                } else {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += customerQuery + "AND Main.FromUserID = " + tktTicket.getFromUserID();
                    } else {
                        filterParam += customerOwnerQuery + "AND Main.FromUserID = " + tktTicket.getFromUserID();
                    }
                }
            }
        }

        if (tktTicket.getToDepartmentID() != null) {
            if (Objects.equals(logLogins.getPubUser().getIsAdmin(), "1")) {
                filterParam += "AND Main.ToDepartmentID = " + tktTicket.getToDepartmentID();
            } else {
                if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getIsCustomer() == false) {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += staffQuery + "AND Main.ToDepartmentID = " + tktTicket.getToDepartmentID();
                    } else {
                        filterParam += staffOwnerQuery + "AND Main.ToDepartmentID = " + tktTicket.getToDepartmentID();
                    }
                } else {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += customerQuery + "AND Main.ToDepartmentID = " + tktTicket.getToDepartmentID();
                    } else {
                        filterParam += customerOwnerQuery + "AND Main.ToDepartmentID = " + tktTicket.getToDepartmentID();
                    }
                }
            }
        }

        if (tktTicket.getToOrganizationID() != null) {
            if (Objects.equals(logLogins.getPubUser().getIsAdmin(), "1")) {
                filterParam += "AND Main.ToOrganizationID = " + tktTicket.getToOrganizationID();
            } else {
                if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getIsCustomer() == false) {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += staffQuery + "AND Main.ToOrganizationID = " + tktTicket.getToOrganizationID();
                    } else {
                        filterParam += staffOwnerQuery + "AND Main.ToOrganizationID = " + tktTicket.getToOrganizationID();
                    }
                } else {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += customerQuery + "AND Main.ToOrganizationID = " + tktTicket.getToOrganizationID();
                    } else {
                        filterParam += customerOwnerQuery + "AND Main.ToOrganizationID = " + tktTicket.getToOrganizationID();
                    }
                }
            }
        }

        if (tktTicket.getToUserID() != null) {
            if (Objects.equals(logLogins.getPubUser().getIsAdmin(), "1")) {
                if (Objects.equals(tktTicket.getFromUserID(), logLogins.getPubUser().getUserID())) {
                    filterParam += "AND FUser.IsCustomer = 1";
                } else {
                    filterParam += "AND Main.ToUserID = " + tktTicket.getToUserID();
                }
            } else {
                if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getIsCustomer() == false) {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += staffQuery + "AND Main.ToUserID = " + tktTicket.getToUserID();
                    } else {
                        filterParam += staffOwnerQuery + "AND Main.ToUserID = " + tktTicket.getToUserID();
                    }
                } else {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += customerQuery + "AND Main.ToUserID = " + tktTicket.getToUserID();
                    } else {
                        filterParam += customerOwnerQuery + "AND Main.ToUserID = " + tktTicket.getToUserID();
                    }
                }
            }
        }

        if (tktTicket.getStatusID() != null) {
            if (Objects.equals(logLogins.getPubUser().getIsAdmin(), "1")) {
                filterParam += "AND Main.StatusID = " + tktTicket.getStatusID();
            } else {
                if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getIsCustomer() == false) {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += staffQuery + "AND Main.StatusID = " + tktTicket.getStatusID();
                    } else {
                        filterParam += staffOwnerQuery + "AND Main.StatusID = " + tktTicket.getStatusID();
                    }
                } else {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += customerQuery + "AND Main.StatusID = " + tktTicket.getStatusID();
                    } else {
                        filterParam += customerOwnerQuery + "AND Main.StatusID = " + tktTicket.getStatusID();
                    }
                }
            }
        }

        if (tktTicket.getPriorityID() != null) {
            if (Objects.equals(logLogins.getPubUser().getIsAdmin(), "1")) {
                filterParam += "AND Main.PriorityID = " + tktTicket.getPriorityID();
            } else {
                if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getIsCustomer() == false) {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += staffQuery + "AND Main.PriorityID = " + tktTicket.getPriorityID();
                    } else {
                        filterParam += staffOwnerQuery + "AND Main.PriorityID = " + tktTicket.getPriorityID();
                    }
                } else {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += customerQuery + "AND Main.PriorityID = " + tktTicket.getPriorityID();
                    } else {
                        filterParam += customerOwnerQuery + "AND Main.PriorityID = " + tktTicket.getPriorityID();
                    }
                }
            }
        }

        if (tktTicket.getSatisfactionID() != null) {
            if (Objects.equals(logLogins.getPubUser().getIsAdmin(), "1")) {
                filterParam += "AND Main.SatisfactionID = " + tktTicket.getSatisfactionID();
            } else {
                if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getIsCustomer() == false) {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += staffQuery + "AND Main.SatisfactionID = " + tktTicket.getSatisfactionID();
                    } else {
                        filterParam += staffOwnerQuery + "AND Main.SatisfactionID = " + tktTicket.getSatisfactionID();
                    }
                } else {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += customerQuery + "AND Main.SatisfactionID = " + tktTicket.getSatisfactionID();
                    } else {
                        filterParam += customerOwnerQuery + "AND Main.SatisfactionID = " + tktTicket.getSatisfactionID();
                    }
                }
            }
        }

        if (tktTicket.getCreateDate() != null) {
            if (Objects.equals(logLogins.getPubUser().getIsAdmin(), "1")) {
                tCalendar.setIranianDateBySlash(tktTicket.getCreateDate());
                filterParam += "AND Main.CreateDate BETWEEN '" + tCalendar.getGregorianDateBySlashZero() + " 00:00:00.000'" + "AND '" + tCalendar.getGregorianDateBySlashZero() + " 23:59:59.000'";
            } else {
                if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getIsCustomer() == false) {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        tCalendar.setIranianDateBySlash(tktTicket.getCreateDate());
                        filterParam += staffQuery + "AND Main.CreateDate BETWEEN '" + tCalendar.getGregorianDateBySlashZero() + " 00:00:00.000'" + "AND '" + tCalendar.getGregorianDateBySlashZero() + " 23:59:59.000'";
                    } else {
                        tCalendar.setIranianDateBySlash(tktTicket.getCreateDate());
                        filterParam += staffOwnerQuery + "AND Main.CreateDate BETWEEN '" + tCalendar.getGregorianDateBySlashZero() + " 00:00:00.000'" + "AND '" + tCalendar.getGregorianDateBySlashZero() + " 23:59:59.000'";
                    }
                } else {
                    tCalendar.setIranianDateBySlash(tktTicket.getCreateDate());
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += customerQuery + "AND Main.CreateDate BETWEEN '" + tCalendar.getGregorianDateBySlashZero() + " 00:00:00.000'" + "AND '" + tCalendar.getGregorianDateBySlashZero() + " 23:59:59.000'";
                    } else {
                        tCalendar.setIranianDateBySlash(tktTicket.getCreateDate());
                        filterParam += customerOwnerQuery + "AND Main.CreateDate BETWEEN '" + tCalendar.getGregorianDateBySlashZero() + " 00:00:00.000'" + "AND '" + tCalendar.getGregorianDateBySlashZero() + " 23:59:59.000'";
                    }
                }
            }
        }

        if (tktTicket.getModifyDate() != null) {
            if (Objects.equals(logLogins.getPubUser().getIsAdmin(), "1")) {
                tCalendar.setIranianDateBySlash(tktTicket.getModifyDate());
                filterParam += "AND Main.ModifyDate BETWEEN '" + tCalendar.getGregorianDateBySlashZero() + " 00:00:00.000'" + "AND '" + tCalendar.getGregorianDateBySlashZero() + " 23:59:59.000'";
            } else {
                if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getIsCustomer() == false) {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        tCalendar.setIranianDateBySlash(tktTicket.getModifyDate());
                        filterParam += staffQuery + "AND Main.ModifyDate BETWEEN '" + tCalendar.getGregorianDateBySlashZero() + " 00:00:00.000'" + "AND '" + tCalendar.getGregorianDateBySlashZero() + " 23:59:59.000'";
                    } else {
                        tCalendar.setIranianDateBySlash(tktTicket.getModifyDate());
                        filterParam += staffOwnerQuery + "AND Main.ModifyDate BETWEEN '" + tCalendar.getGregorianDateBySlashZero() + " 00:00:00.000'" + "AND '" + tCalendar.getGregorianDateBySlashZero() + " 23:59:59.000'";
                    }
                } else {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        tCalendar.setIranianDateBySlash(tktTicket.getModifyDate());
                        filterParam += customerQuery + "AND Main.ModifyDate BETWEEN '" + tCalendar.getGregorianDateBySlashZero() + " 00:00:00.000'" + "AND '" + tCalendar.getGregorianDateBySlashZero() + " 23:59:59.000'";
                    } else {
                        tCalendar.setIranianDateBySlash(tktTicket.getModifyDate());
                        filterParam += customerOwnerQuery + "AND Main.ModifyDate BETWEEN '" + tCalendar.getGregorianDateBySlashZero() + " 00:00:00.000'" + "AND '" + tCalendar.getGregorianDateBySlashZero() + " 23:59:59.000'";
                    }
                }
            }
        }

        if (filterParam == "") {
            if (Objects.equals(logLogins.getPubUser().getIsAdmin(), "0")) {
                if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getIsCustomer() == false) {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += staffQuery;
                    } else {
                        filterParam += staffOwnerQuery;
                    }
                } else {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += customerQuery;
                    } else {
                        filterParam += customerOwnerQuery;
                    }
                }
            }
        }


        return filterParam;
    }

    default TktTicketCount tktShowCount(TktTicket tktTicket, TktUserRepository tktUserRepository) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        System.out.println("*********************************************");
//        System.out.println(tktTicketRepository.createFilter(tktTicket, tktUserRepository));
        System.out.println("*********************************************");

//        tParameters.add(new TParameter<>("Filter", tktTicketRepository.createFilter(tktTicket, tktUserRepository)));
//        tParameters.add(new TParameter<>("Filter", " AND Main. " + tktTicket+" ''"));
//        tParameters.add(new TParameter<>("Filter", "  AND Main.tickettitle LIKE ''%سند%'''"));
//        tParameters.add(new TParameter<>("Filter", "  AND Main." + tktTicket.getFilter()));
        tParameters.add(new TParameter<>("Filter", createFilter(tktTicket,tktUserRepository)));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("TktShowTicketCount", tParameters, true).get(0);
    }

}
