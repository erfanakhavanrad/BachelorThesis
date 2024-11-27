package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dto.router.TRouter;
import com.tarazgroup.tws.dto.tkt.ticket.TRouterQueryTicket;
import com.tarazgroup.tws.dto.tkt.ticket.TktTicketDto;
import com.tarazgroup.tws.dto.tkt.ticket.TktTicketInsDto;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktAttachment;
import com.tarazgroup.tws.model.tkt.TktTicket;
import com.tarazgroup.tws.model.tkt.TktTicketAttachment;
import com.tarazgroup.tws.util.global.TCalendar;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Icon;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/***
 * @author A.Farahani
 * @date Jan-31, 2022
 ***/
public interface TktTicketRepository extends TCrudRepository<TktTicket>, CrudRepository<TktTicket, BigDecimal> {


    default List<com.tarazgroup.tws.dto.tkt.ticket.TktTicketDto> tktShowTicket(TktTicket tktTicket, TktUserRepository tktUserRepository) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("Filter", createFilter(tktTicket, tktUserRepository)));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktTicket._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktTicket._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", " ?" + tktTicket.getPageNumber() + "," + tktTicket.getRecordCount() + "? "));

        List<TktTicket> tktTickets = showSP("TktShowTicket", tParameters, true);
        List<com.tarazgroup.tws.dto.tkt.ticket.TktTicketDto> __tktTickets = new ArrayList<>();
        for (TktTicket _tktTicket : tktTickets
        ) {
            com.tarazgroup.tws.dto.tkt.ticket.TktTicketDto __tktTicket = new com.tarazgroup.tws.dto.tkt.ticket.TktTicketDto();
            __tktTicket.setTicketID(_tktTicket.getTicketID());
            __tktTicket.setIsVisited(_tktTicket.getIsVisited());

            __tktTicket.setTicketNumber(
                    new TRouter(_tktTicket.getTicketNumber().toString(),
                            null,
                            "tickets-edit",
                            null,
                            new TRouterQueryTicket(_tktTicket.getTicketID()))
            );
            __tktTicket.setPriorityName(_tktTicket.getPriorityName());
            __tktTicket.setTicketCategoryName(_tktTicket.getTicketCategoryName());
//            __tktTicket.setTicketTitle(_tktTicket.getTicketTitle());
            __tktTicket.setTicketTitle(
                    new TRouter(_tktTicket.getTicketTitle(),
                            null,
                            "tickets-edit",
                            null,
                            new TRouterQueryTicket(_tktTicket.getTicketID()))
            );


            __tktTicket.setCategoryTitle(_tktTicket.getCategoryTitle());
            __tktTicket.setFromUser(_tktTicket.getFromUser());
            __tktTicket.setToUser(_tktTicket.getToUser());
            __tktTicket.setStatusTitle(_tktTicket.getStatusTitle());
            __tktTicket.setSatisfactionName(_tktTicket.getSatisfactionName());

            __tktTicket.setCreateDate(_tktTicket.getCreateDate());
            __tktTicket.setModifyDate(_tktTicket.getModifyDate());
            __tktTicket.setClosureTime(_tktTicket.getClosureTime());
            __tktTickets.add(__tktTicket);
        }

        return __tktTickets;
    }

    default TktTicket tktShowTicketByID(BigDecimal ticketID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("UserID", null));
        tParameters.add(new TParameter<>("Filter", " AND Main.TicketID = " + ticketID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowTicket", tParameters, true).get(0);

    }

    default String createFilter(TktTicket tktTicket, TktUserRepository tktUserRepository) {
        String filterParam = "";
        TCalendar tCalendar = new TCalendar();
        LogLogins logLogins = fetchUserDetail();
        String staffQuery = "AND (Main.FromUserID = " + logLogins.getPubUser().getUserID() + " OR Main.ToUserID = " + logLogins.getPubUser().getUserID() + " OR Main.TicketID IN (SELECT TMain.TicketID FROM TktTicket TMain LEFT JOIN TktUser TTUser ON TTUser.UserID = TMain.FromUserID WHERE TTUser.IsCustomer = 1  AND Main.StatusID = 10000001 AND TMain.ToUserID IN (SELECT SMain.StaffID FROM TktStaff SMain JOIN TktStaffRole SSRole ON SSRole.StaffID = SMain.StaffID JOIN TktRole STRole ON STRole.RoleID = SSRole.RoleID JOIN TktDepartment SDep ON STRole.DepartmentID = SDep.DepartmentID WHERE STRole.IsOwner = 1 AND SDep.DepartmentID IN (SELECT DMain.DepartmentID FROM TktDepartment DMain JOIN TktRole DTRole ON DTRole.DepartmentID = DMain.DepartmentID JOIN TktStaffRole DSRole ON DSRole.RoleID = DTRole.RoleID WHERE DSRole.StaffID = " + logLogins.getPubUser().getUserID() + "))))";
        String staffOwnerQuery = "AND (Main.FromUserID = " + logLogins.getPubUser().getUserID() + " OR Main.ToUserID = " + logLogins.getPubUser().getUserID() + " OR Main.TicketID IN (SELECT TMain.TicketID FROM TktTicket TMain WHERE TMain.ToUserID IN (SELECT SMain.StaffID FROM TktStaff SMain JOIN TktStaffRole SSRole ON SMain.StaffID = SSRole.StaffID JOIN TktRole STRole ON SSRole.RoleID = STRole.RoleID JOIN TktDepartment SDep ON STRole.DepartmentID = SDep.DepartmentID WHERE SDep.DepartmentID IN (SELECT DMain.DepartmentID FROM TktDepartment DMain JOIN TktRole DTRole ON DTRole.DepartmentID = DMain.DepartmentID JOIN TktStaffRole DSRole ON DSRole.RoleID = DTRole.RoleID WHERE DSRole.StaffID = " + logLogins.getPubUser().getUserID() + ")) OR TMain.FromUserID IN (SELECT SMain.StaffID FROM TktStaff SMain JOIN TktStaffRole SSRole ON SMain.StaffID = SSRole.StaffID JOIN TktRole STRole ON SSRole.RoleID = STRole.RoleID JOIN TktDepartment SDep ON STRole.DepartmentID = SDep.DepartmentID WHERE SDep.DepartmentID IN (SELECT DMain.DepartmentID FROM TktDepartment DMain JOIN TktRole DTRole ON DTRole.DepartmentID = DMain.DepartmentID JOIN TktStaffRole DSRole ON DSRole.RoleID = DTRole.RoleID WHERE DSRole.StaffID = " + logLogins.getPubUser().getUserID() + "))))";
        String customerQuery = " AND (Main.FromUserID = " + logLogins.getPubUser().getUserID() + " OR Main.ToUserID = " + logLogins.getPubUser().getUserID() + ")";
        String customerOwnerQuery = " AND (Main.FromUserID = " + logLogins.getPubUser().getUserID() + " OR Main.ToUserID = " + logLogins.getPubUser().getUserID() + " OR Main.TicketID IN (SELECT TMain.TicketID FROM TktTicket TMain LEFT JOIN TktCustomer TFCustomer ON TFCustomer.CustomerID = TMain.FromUserID LEFT JOIN TktCustomer TTCustomer ON TTCustomer.CustomerID = TMain.ToUserID WHERE 1 = 1 AND (TFCustomer.IsOrganizationOwner = 0 AND TFCustomer.OrganizationID = " + tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getOrganizationID() + ") OR (TTCustomer.IsOrganizationOwner = 0 AND TTCustomer.OrganizationID = " + tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getOrganizationID() + ")))";


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

        if (tktTicket.getFromOrganizationName() != null) {
            if (Objects.equals(logLogins.getPubUser().getIsAdmin(), "1")) {
                filterParam += "AND FOrg.OrganizationName LIKE '%" + tktTicket.getFromOrganizationName() +
                        "%' OR CONCAT_WS(' ', FAP.PerComTitle, FAP.PerComFName, FAP.PerComLName) like dbo.PubConvertArabicToPersian('%" + tktTicket.getFromOrganizationName() + "%')";
            } else {
                if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getIsCustomer() == false) {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += staffQuery + "AND FOrg.OrganizationName LIKE '%" + tktTicket.getFromOrganizationName() +
                                "%' OR CONCAT_WS(' ', FAP.PerComTitle, FAP.PerComFName, FAP.PerComLName) like dbo.PubConvertArabicToPersian('%" + tktTicket.getFromOrganizationName() + "%')";
                    } else {
                        filterParam += staffOwnerQuery + "AND FOrg.OrganizationName LIKE '%" + tktTicket.getFromOrganizationName() +
                                "%' OR CONCAT_WS(' ', FAP.PerComTitle, FAP.PerComFName, FAP.PerComLName) like dbo.PubConvertArabicToPersian('%" + tktTicket.getFromOrganizationName() + "%')";
                    }
                } else {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += customerQuery + "AND FOrg.OrganizationName LIKE '%" + tktTicket.getFromOrganizationName() +
                                "%' OR CONCAT_WS(' ', FAP.PerComTitle, FAP.PerComFName, FAP.PerComLName) like dbo.PubConvertArabicToPersian('%" + tktTicket.getFromOrganizationName() + "%')";
                    } else {
                        filterParam += customerOwnerQuery + "AND FOrg.OrganizationName LIKE '%" + tktTicket.getFromOrganizationName() +
                                "%' OR CONCAT_WS(' ', FAP.PerComTitle, FAP.PerComFName, FAP.PerComLName) like dbo.PubConvertArabicToPersian('%" + tktTicket.getFromOrganizationName() + "%')";
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

        if (tktTicket.getToOrganizationName() != null) {
            if (Objects.equals(logLogins.getPubUser().getIsAdmin(), "1")) {
                filterParam += "AND TOrg.OrganizationName LIKE '%" + tktTicket.getToOrganizationName() +
                        "%' OR CONCAT_WS(' ', TAP.PerComTitle, TAP.PerComFName, TAP.PerComLName) like dbo.PubConvertArabicToPersian('%" + tktTicket.getToOrganizationName() + "%')";
            } else {
                if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getIsCustomer() == false) {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += staffQuery + "AND TOrg.OrganizationName LIKE '%" + tktTicket.getToOrganizationName() +
                                "%' OR CONCAT_WS(' ', TAP.PerComTitle, TAP.PerComFName, TAP.PerComLName) like dbo.PubConvertArabicToPersian('%" + tktTicket.getToOrganizationName() + "%')";
                    } else {
                        filterParam += staffOwnerQuery + "AND TOrg.OrganizationName LIKE '%" + tktTicket.getToOrganizationName() +
                                "%' OR CONCAT_WS(' ', TAP.PerComTitle, TAP.PerComFName, TAP.PerComLName) like dbo.PubConvertArabicToPersian('%" + tktTicket.getToOrganizationName() + "%')";
                    }
                } else {
                    if (tktUserRepository.tktShowUserByID(logLogins.getPubUser().getUserID()).getHasOwnership() == false) {
                        filterParam += customerQuery + "AND TOrg.OrganizationName LIKE '%" + tktTicket.getToOrganizationName() +
                                "%' OR CONCAT_WS(' ', TAP.PerComTitle, TAP.PerComFName, TAP.PerComLName) like dbo.PubConvertArabicToPersian('%" + tktTicket.getToOrganizationName() + "%')";
                    } else {
                        filterParam += customerOwnerQuery + "AND TOrg.OrganizationName LIKE '%" + tktTicket.getToOrganizationName() +
                                "%' OR CONCAT_WS(' ', TAP.PerComTitle, TAP.PerComFName, TAP.PerComLName) like dbo.PubConvertArabicToPersian('%" + tktTicket.getToOrganizationName() + "%')";
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


//    default TktTicket tktInsTicket(TktTicket tktTicket) {
//        LogLogins logLogins = fetchUserDetail();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("PriorityID", tktTicket.getPriorityID()));
//        tParameters.add(new TParameter<>("TicketCategoryID", tktTicket.getTicketCategoryID()));
//        tParameters.add(new TParameter<>("TicketTitle", tktTicket.getTicketTitle()));
//        tParameters.add(new TParameter<>("TicketDesc", tktTicket.getTicketDesc()));
//        if (tktTicket.getFromDepartmentID().intValue() == 1) {
//            tParameters.add(new TParameter<>("FromDepartmentID", null));
//        } else if (tktTicket.getFromDepartmentID().intValue() == 2) {
//            tParameters.add(new TParameter<>("FromDepartmentID", null));
//        } else {
//            tParameters.add(new TParameter<>("FromDepartmentID", tktTicket.getFromDepartmentID()));
//        }
//        tParameters.add(new TParameter<>("FromOrganizationID", tktTicket.getFromOrganizationID()));
//        tParameters.add(new TParameter<>("FromUserID", tktTicket.getFromUserID()));
//        if (tktTicket.getToDepartmentID().intValue() == 1) {
//            tParameters.add(new TParameter<>("ToDepartmentID", null));
//        } else if (tktTicket.getToDepartmentID().intValue() == 2) {
//            tParameters.add(new TParameter<>("ToDepartmentID", null));
//        } else {
//            tParameters.add(new TParameter<>("ToDepartmentID", tktTicket.getToDepartmentID()));
//        }
//        tParameters.add(new TParameter<>("ToOrganizationID", tktTicket.getToOrganizationID()));
//        tParameters.add(new TParameter<>("ToUserID", tktTicket.getToUserID()));
////        tParameters.add(new TParameter<>("Attachment", null)); // موقتی نال میدهیم
//        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        BigDecimal newID = insSP("TktInsTicket", tParameters);
//        return tktShowTicketByID(newID);
//    }

    default TktTicket tktInsTicket(TktTicketInsDto tktTicketInsDto,
                                   TktTicketAttachmentRepository tktTicketAttachmentRepository,
                                   TktAttachmentRepository tktAttachmentRepository,
                                   TktTicketConversationRepository tktTicketConversationRepository
    ) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("PriorityID", tktTicketInsDto.getPriorityID()));
        tParameters.add(new TParameter<>("TicketCategoryID", tktTicketInsDto.getTicketCategoryID()));
        tParameters.add(new TParameter<>("TicketTitle", tktTicketInsDto.getTicketTitle()));
        tParameters.add(new TParameter<>("TicketDesc", tktTicketInsDto.getTicketDesc()));
        if (tktTicketInsDto.getFromDepartmentID().intValue() == 1) {
            tParameters.add(new TParameter<>("FromDepartmentID", null));
        } else if (tktTicketInsDto.getFromDepartmentID().intValue() == 2) {
            tParameters.add(new TParameter<>("FromDepartmentID", null));
        } else {
            tParameters.add(new TParameter<>("FromDepartmentID", tktTicketInsDto.getFromDepartmentID()));
        }
        tParameters.add(new TParameter<>("FromOrganizationID", tktTicketInsDto.getFromOrganizationID()));
        tParameters.add(new TParameter<>("FromUserID", tktTicketInsDto.getFromUserID()));
        if (tktTicketInsDto.getToDepartmentID().intValue() == 1) {
            tParameters.add(new TParameter<>("ToDepartmentID", null));
        } else if (tktTicketInsDto.getToDepartmentID().intValue() == 2) {
            tParameters.add(new TParameter<>("ToDepartmentID", null));
        } else {
            tParameters.add(new TParameter<>("ToDepartmentID", tktTicketInsDto.getToDepartmentID()));
        }
        tParameters.add(new TParameter<>("ToOrganizationID", tktTicketInsDto.getToOrganizationID()));
        tParameters.add(new TParameter<>("ToUserID", tktTicketInsDto.getToUserID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal ticketID = insSP("TktInsTicket", tParameters);

        TktTicketAttachment tktTicketAttachment = new TktTicketAttachment();
        TktAttachment tktAttachment = new TktAttachment();
        if (tktTicketInsDto.getAttachmentObj().getAttachment() != null) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try {
                outputStream.write(tktTicketInsDto.getAttachmentObj().getAttachment());

                tktAttachment.setAttachmentFile(outputStream.toByteArray());
                tktAttachment.setFileName(tktTicketInsDto.getAttachmentObj().getFileName());
                tktAttachment.setFileType(tktTicketInsDto.getAttachmentObj().getFileType());

                tktAttachment.setAttachmentID(tktAttachmentRepository.tktInsAttachment(tktAttachment).getAttachmentID());

                tktTicketAttachment.setAttachmentID(tktAttachment.getAttachmentID());
                tktTicketAttachment.setAttachmentID(tktAttachment.getAttachmentID());
                BigDecimal conversationID = tktTicketConversationRepository.tktShowTicketConv(ticketID).get(0).getTicketConversationID();
                tktTicketAttachment.setTicketConversationID(conversationID);
                tktTicketAttachmentRepository.tktInsTicketAttachment(tktTicketAttachment);

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to add attachment " + tktTicketInsDto.getAttachmentObj().getFileName() + " to the list. Exception is " + e.toString());

            }
        }

        return tktShowTicketByID(ticketID);
    }

    default TktTicket tktUpdTicket(BigDecimal ticketID,
                                   TktTicketInsDto tktTicketInsDto,
                                   TktTicketAttachmentRepository tktTicketAttachmentRepository,
                                   TktAttachmentRepository tktAttachmentRepository,
                                   TktTicketConversationRepository tktTicketConversationRepository
    ) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TicketID", ticketID));
        tParameters.add(new TParameter<>("IsVisited", tktTicketInsDto.getIsVisited()));
        tParameters.add(new TParameter<>("StatusID", tktTicketInsDto.getStatusID()));
        //khers
        tParameters.add(new TParameter<>("SatisfactionID", tktTicketInsDto.getSatisfactionID()));
        if (tktTicketInsDto.getFromDepartmentID().intValue() == 1) {
            tParameters.add(new TParameter<>("FromDepartmentID", null));
        } else if (tktTicketInsDto.getFromDepartmentID().intValue() == 2) {
            tParameters.add(new TParameter<>("FromDepartmentID", null));
        } else {
            tParameters.add(new TParameter<>("FromDepartmentID", tktTicketInsDto.getFromDepartmentID()));
        }
        tParameters.add(new TParameter<>("FromUserID", tktTicketInsDto.getFromUserID()));
        if (tktTicketInsDto.getToDepartmentID().intValue() == 1) {
            tParameters.add(new TParameter<>("ToDepartmentID", null));
        } else if (tktTicketInsDto.getToDepartmentID().intValue() == 2) {
            tParameters.add(new TParameter<>("ToDepartmentID", null));
        } else {
            tParameters.add(new TParameter<>("ToDepartmentID", tktTicketInsDto.getToDepartmentID()));
        }
        tParameters.add(new TParameter<>("ToUserID", tktTicketInsDto.getToUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktUpdTicket", tParameters);

        TktTicketAttachment tktTicketAttachment = new TktTicketAttachment();
        TktAttachment tktAttachment = new TktAttachment();
        if (tktTicketInsDto.getAttachmentObj().getAttachment() != null) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try {
                outputStream.write(tktTicketInsDto.getAttachmentObj().getAttachment());

                tktAttachment.setAttachmentFile(outputStream.toByteArray());
                tktAttachment.setFileName(tktTicketInsDto.getAttachmentObj().getFileName());
                tktAttachment.setFileType(tktTicketInsDto.getAttachmentObj().getFileType());

                tktAttachment.setAttachmentID(tktAttachmentRepository.tktInsAttachment(tktAttachment).getAttachmentID());

                tktTicketAttachment.setAttachmentID(tktAttachment.getAttachmentID());
                tktTicketAttachment.setAttachmentID(tktAttachment.getAttachmentID());
                BigDecimal conversationID = tktTicketConversationRepository.tktShowTicketConv(ticketID).get(0).getTicketConversationID();
                tktTicketAttachment.setTicketConversationID(conversationID);
                tktTicketAttachmentRepository.tktInsTicketAttachment(tktTicketAttachment);

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to add attachment " + tktTicketInsDto.getAttachmentObj().getFileName() + " to the list. Exception is " + e.toString());

            }
        }

        return tktShowTicketByID(ticketID);
    }

    default TktTicket tktUpdStatus(BigDecimal ticketID, TktTicket tktTicket) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TicketID", ticketID));
        tParameters.add(new TParameter<>("StatusID", tktTicket.getStatusID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getModifierID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktChangeTicketStatus", tParameters);
        return tktShowTicketByID(ticketID);
    }


    default TktTicket tktUpdSatisfaction(BigDecimal ticketID, TktTicket tktTicket) {
        // khers
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TicketID", ticketID));
        tParameters.add(new TParameter<>("SatisfactionID", tktTicket.getSatisfactionID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getModifierID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktChangeTicketSatisfaction", tParameters);
        return tktShowTicketByID(ticketID);
    }


    default void tktDelTicket(BigDecimal ticketID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TicketID", ticketID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TktDelTicket", tParameters);
    }

    // IsSecretMessage needs to be handled later at both SQL and Java side.
    default TktTicket tktTicketTransfer(BigDecimal ticketID, TktTicket tktTicket) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TicketID", ticketID));
        tParameters.add(new TParameter<>("ToDepartmentID", tktTicket.getToDepartmentID()));
        tParameters.add(new TParameter<>("FromUserID", tktTicket.getFromUserID()));
        tParameters.add(new TParameter<>("ToUserID", tktTicket.getToUserID()));
        tParameters.add(new TParameter<>("TicketDesc", tktTicket.getTicketDesc()));
        tParameters.add(new TParameter<>("IsConfidential", tktTicket.getIsConfidential()));
        tParameters.add(new TParameter<>("ReferIDs", tktTicket.getReferIDs()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktTicketTransfer", tParameters);
        return tktShowTicketByID(ticketID);
    }

    default TktTicket tktUpdIsVisited(BigDecimal ticketID, TktTicket tktTicket) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TicketID", ticketID));
        tParameters.add(new TParameter<>("IsVisited", tktTicket.getIsVisited()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getModifierID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktChangeIsVisited", tParameters);
        return tktShowTicketByID(ticketID);
    }

    default TktTicket tktReferToMe(BigDecimal ticketID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TicketID", ticketID));
        tParameters.add(new TParameter<>("ToDepartmentID", tktShowTicketByID(ticketID).getToDepartmentID()));
        tParameters.add(new TParameter<>("ToUserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktReferToMe", tParameters);
        return tktShowTicketByID(ticketID);
    }


    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "ticketID", "ticketID", Type.DECIMAL, 0, false, false, false, Icon.none, true));
        cols.add(new Col(null, "isVisited", "", Type.ISVISITED, 70, true, true, true, Icon.none, false));
        cols.add(new Col(null, "ticketNumber", "#", Type.ROUTER, 70, true, true, true, Icon.none, false));
        cols.add(new Col(null, "priorityName", "اهمیت", Type.PCOLOR, 100, true, true, true, Icon.none, false));

        cols.add(new Col(null, "ticketTitle", "عنوان", Type.ROUTER, 140, true, true, true, Icon.none, false));
        cols.add(new Col(null, "ticketCategoryName", "دسته بندی", Type.STRING, 100, true, true, false, Icon.none, false));
        cols.add(new Col(null, "fromUser", "از", Type.STRING, 230, true, true, true, Icon.arrow_left, false));
        cols.add(new Col(null, "toUser", "به", Type.STRING, 230, true, true, true, Icon.arrow_right, false));
        cols.add(new Col(null, "statusTitle", "وضعیت", Type.STRING, 140, true, true, false, Icon.none, false));
        cols.add(new Col(null, "satisfactionName", "رضایتمندی", Type.EMOJI, 90, true, true, false, Icon.none, false));
        cols.add(new Col(null, "createDate", "ایجاد", Type.STRING, 120, true, true, false, Icon.none, false));
        cols.add(new Col(null, "modifyDate", "به روز رسانی", Type.STRING, 120, true, true, false, Icon.none, false));
        cols.add(new Col(null, "closureTime", "مدت پاسخگویی", Type.STRING, 120, true, true, false, Icon.none, false));
        cols.add(new Col(null, "priorityID", "priorityID", Type.DECIMAL, 0, false, false, false, Icon.none, false));
        cols.add(new Col(null, "ticketCategoryID", "ticketCategoryID", Type.DECIMAL, 100, false, false, false, Icon.none, false));
        cols.add(new Col(null, "fromUserID", "fromUserID", Type.DECIMAL, 0, false, false, false, Icon.none, false));
        cols.add(new Col(null, "toUserID", "toUserID", Type.DECIMAL, 0, false, false, false, Icon.none, false));
        cols.add(new Col(null, "statusID", "statusID", Type.DECIMAL, 0, false, false, false, Icon.none, false));
        cols.add(new Col(null, "SatisfactionID", "SatisfactionID", Type.DECIMAL, 0, false, false, false, Icon.none, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false, false, Icon.none, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false, Icon.none, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false, Icon.none, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false, Icon.none, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false, false, Icon.none, false));

        return new Meta(cols);
    }
}



/*
*     default String createFilter1(TktTicket tktTicket) {
        String filterParam = "";

        LogLogins logLogins = fetchUserDetail();
        if (Objects.equals(logLogins.getPubUser().getIsAdmin(), "1")) {

            if (tktTicket.getTicketTitle() != null) {
                filterParam = " AND Main.TicketTitle LIKE '%" + tktTicket.getTicketTitle() + "%'";
            }

            if (tktTicket.getTicketCategoryID() != null) {
                filterParam += "AND Main.TicketCategoryID = " + tktTicket.getTicketCategoryID();
            }

            if (tktTicket.getTicketNumber() != null) {
                filterParam += "AND Main.TicketNumber = " + tktTicket.getTicketNumber();
            }

            if (tktTicket.getFromDepartmentID() != null) {
                filterParam += "AND Main.FromDepartmentID = " + tktTicket.getFromDepartmentID();
            }

            if (tktTicket.getFromOrganizationID() != null) {
                filterParam += "AND Main.FromOrganizationID = " + tktTicket.getFromOrganizationID();
            }

            if (tktTicket.getFromUserID() != null) {
                // AND FUser.IsCustomer = 0
//                filterParam += "AND FUser.IsCustomer = 0" ;
                filterParam += "AND Main.FromUserID = " + tktTicket.getFromUserID();
            }

            if (tktTicket.getToDepartmentID() != null) {
                filterParam += "AND Main.ToDepartmentID = " + tktTicket.getToDepartmentID();
            }

            if (tktTicket.getToOrganizationID() != null) {
                filterParam += "AND Main.ToOrganizationID = " + tktTicket.getToOrganizationID();
            }

            if (tktTicket.getToUserID() != null) {
                filterParam += "AND Main.ToUserID = " + tktTicket.getToUserID();
            }

            if (tktTicket.getStatusID() != null) {
                filterParam += "AND Main.StatusID = " + tktTicket.getStatusID();
            }

            if (tktTicket.getPriorityID() != null) {
                filterParam += "AND Main.PriorityID = " + tktTicket.getPriorityID();
            }

            if (tktTicket.getSatisfactionID() != null) {
                filterParam += "AND Main.SatisfactionID = " + tktTicket.getSatisfactionID();
            }

            if (tktTicket.getCreateDate() != null) {
                filterParam += "AND Main.CreateDate = " + tktTicket.getCreateDate();
            }

            if (tktTicket.getModifyDate() != null) {
                filterParam += "AND Main.ModifyDate = " + tktTicket.getModifyDate();
            }
        }
        else if (Objects.equals(logLogins.getPubUser().getIsAdmin(), "0")) {

            filterParam = " AND Main.FromUserID = " + logLogins.getPubUser().getUserID() + " OR Main.ToUserID = " + logLogins.getPubUser().getUserID();

            if (tktTicket.getTicketTitle() != null) {
                filterParam = " AND Main.TicketTitle LIKE '%" + tktTicket.getTicketTitle() + "%'";
            }

            if (tktTicket.getTicketCategoryID() != null) {
                filterParam += "AND Main.TicketCategoryID = " + tktTicket.getTicketCategoryID();
            }

            if (tktTicket.getTicketNumber() != null) {
                filterParam += "AND Main.TicketNumber = " + tktTicket.getTicketNumber();
            }

            if (tktTicket.getFromDepartmentID() != null) {
                filterParam += "AND Main.FromDepartmentID = " + tktTicket.getFromDepartmentID();
            }

            if (tktTicket.getFromOrganizationID() != null) {
                filterParam += "AND Main.FromOrganizationID = " + tktTicket.getFromOrganizationID();
            }

            if (tktTicket.getFromUserID() != null) {
                filterParam += "AND Main.FromUserID = " + tktTicket.getFromUserID();
            }

            if (tktTicket.getToDepartmentID() != null) {
                filterParam += "AND Main.ToDepartmentID = " + tktTicket.getToDepartmentID();
            }

            if (tktTicket.getToOrganizationID() != null) {
                filterParam += "AND Main.ToOrganizationID = " + tktTicket.getToOrganizationID();
            }

            if (tktTicket.getToUserID() != null) {
                filterParam += "AND Main.ToUserID = " + tktTicket.getToUserID();
            }

            if (tktTicket.getStatusID() != null) {
                filterParam += "AND Main.StatusID = " + tktTicket.getStatusID();
            }

            if (tktTicket.getPriorityID() != null) {
                filterParam += "AND Main.PriorityID = " + tktTicket.getPriorityID();
            }

            if (tktTicket.getSatisfactionID() != null) {
                filterParam += "AND Main.SatisfactionID = " + tktTicket.getSatisfactionID();
            }

            if (tktTicket.getCreateDate() != null) {
                filterParam += "AND Main.CreateDate = " + tktTicket.getCreateDate();
            }

            if (tktTicket.getModifyDate() != null) {
                filterParam += "AND Main.ModifyDate = " + tktTicket.getModifyDate();
            }
        }
        return filterParam;
    }
* */
