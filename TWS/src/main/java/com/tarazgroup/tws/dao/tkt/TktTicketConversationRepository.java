package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dto.tkt.Attachment_Dto;
import com.tarazgroup.tws.dto.tkt.TktTicketConversationDto;
import com.tarazgroup.tws.dto.tkt.ticket.AttachmentDto;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktAttachment;
import com.tarazgroup.tws.model.tkt.TktTicket;
import com.tarazgroup.tws.model.tkt.TktTicketAttachment;
import com.tarazgroup.tws.model.tkt.TktTicketConversation;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * @author A.Farahani
 * @date Feb-05, 2022
 ***/
public interface TktTicketConversationRepository extends TCrudRepository<TktTicketConversation>, CrudRepository<TktTicketConversation, BigDecimal> {
    default List<TktTicketConversation> tktShowTicketConversation(TktTicketConversation tktTicketConversation) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("PageFilter", tktTicketConversation._pageFilter()));
        return showSP("TktShowTicketConversation", tParameters, true);
    }

    default List<TktTicketConversation> tktShowTicketConv(/*TktTicketConversation tktTicketConversation,*/ BigDecimal ticketID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("Filter", " AND Main.TicketID = " + ticketID));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowTicketConversation", tParameters, true);
    }


//    default TktTicketConversationDto tktShowTicketConversationAttachments(BigDecimal ticketID, BigDecimal ticketConversationID, TktTicketAttachmentRepository tktTicketAttachmentRepository) {
//        ArrayList<TParameter<?>> tParameters = new ArrayList<>();
//        LogLogins logLogins = fetchUserDetail();
//        tParameters.add(new TParameter<>("Filter", " AND Main.TicketID = " + ticketID));
//        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("PageFilter", null));
//
//        TktTicketConversation tktTicketConversation = showSP("TktShowTicketConversation", tParameters, true).get(0);
//        TktTicketConversationDto tktTicketConversationDto = new TktTicketConversationDto();
//
//        tktTicketConversationDto.setTicketConversationID(tktTicketConversation.getTicketConversationID());
//        tktTicketConversationDto.setTicketID(tktTicketConversation.getTicketID());
//        tktTicketConversationDto.setTicketConversationReferID(tktTicketConversation.getTicketConversationReferID());
//        tktTicketConversationDto.setFromUserID(tktTicketConversation.getFromUserID());
//        tktTicketConversationDto.setTicketDesc(tktTicketConversation.getTicketDesc());
//        tktTicketConversationDto.setIsConfidential(tktTicketConversation.getIsConfidential());
//
//        List<TktTicketAttachment> tktTicketAttachments = tktTicketAttachmentRepository.tktShowTicketAttachmentByTicketConversationID(ticketConversationID);
//        //  BigDecimal[] attachments = new BigDecimal[tktTicketAttachments.size()];
//
//        List<Attachment_Dto> attachmentDtoList = new ArrayList<>();
//        List<byte[]> attachments = new ArrayList<>();
//
//        for (int i = 0; i < tktTicketAttachments.size(); i++) {
//
//            Attachment_Dto attachmentDto = new Attachment_Dto();
//            attachmentDto.setId(tktTicketAttachments.get(i).getAttachmentID());
//            attachmentDto.setType("pdf");
//            attachmentDtoList.add(attachmentDto);
//            attachments.add(tktTicketAttachments.get(i).getAttachmentFile());
//
//        }
//        tktTicketConversationDto.setAttachmentsList(attachmentDtoList);
//        tktTicketConversationDto.setAttachments(attachments);
//
//
//
//
//
//        return tktTicketConversationDto;
//    }


    default TktTicketConversationDto tktShowTicketConversationAttachments(BigDecimal ticketID, BigDecimal ticketConversationID, TktTicketAttachmentRepository tktTicketAttachmentRepository) {
        ArrayList<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("Filter", " AND Main.TicketID = " + ticketID));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("PageFilter", null));
        TktTicketConversation tktTicketConversation = showSP("TktShowTicketConversation", tParameters, true).get(0);
        TktTicketConversationDto tktTicketConversationDto = new TktTicketConversationDto();

        tktTicketConversationDto.setTicketConversationID(tktTicketConversation.getTicketConversationID());
        tktTicketConversationDto.setTicketID(tktTicketConversation.getTicketID());
        tktTicketConversationDto.setTicketConversationReferID(tktTicketConversation.getTicketConversationReferID());
        tktTicketConversationDto.setFromUserID(tktTicketConversation.getFromUserID());
        tktTicketConversationDto.setTicketDesc(tktTicketConversation.getTicketDesc());
        tktTicketConversationDto.setIsConfidential(tktTicketConversation.getIsConfidential());


        List<TktTicketAttachment> tktTicketAttachments = tktTicketAttachmentRepository.tktShowTicketAttachmentByTicketConversationID(ticketConversationID);
//        TktTicketAttachment tktTicketAttachments = tktTicketAttachmentRepository.tktShowTicketAttachmentByTicketConversationID(ticketConversationID);

        //  BigDecimal[] attachments = new BigDecimal[tktTicketAttachments.size()];

        List<Attachment_Dto> attachmentDtoList = new ArrayList<>();
        byte[] attachments = new byte[]{};
        if (tktTicketAttachments.size() > 0) {


            Attachment_Dto attachment_dto = new Attachment_Dto();
            attachment_dto.setId(tktTicketAttachments.get(0).getAttachmentID());
            attachment_dto.setType("pdf");
            attachmentDtoList.add(attachment_dto);
//            attachments.add(tktTicketAttachments.get(i).getAttachmentFile());
            AttachmentDto attachmentDto = new AttachmentDto();
            attachmentDto.setAttachment(tktTicketAttachments.get(0).getAttachmentFile());
            attachmentDto.setFileName(tktTicketAttachments.get(0).getFileName());
            attachmentDto.setFileType(tktTicketAttachments.get(0).getFileType());

            tktTicketConversationDto.setAttachmentsList(attachmentDtoList);
            tktTicketConversationDto.setAttachmentObj(attachmentDto);

        }
        return tktTicketConversationDto;
    }


//    default TktTicketConversationDto tktShowTicketConversationAttachments(BigDecimal ticketConversationID, TktTicketAttachmentRepository tktTicketAttachmentRepository) {
//        ArrayList<TParameter<?>> tParameters = new ArrayList<>();
//        LogLogins logLogins = fetchUserDetail();
//        tParameters.add(new TParameter<>("Filter", null));
//        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("PageFilter", null));
//
//        TktTicketConversation tktTicketConversation = showSP("TktShowTicketConversation", tParameters, true).get(0);
//        TktTicketConversationDto tktTicketConversationDto = new TktTicketConversationDto();
//
//        tktTicketConversationDto.setTicketConversationID(tktTicketConversation.getTicketConversationID());
//        tktTicketConversationDto.setTicketID(tktTicketConversation.getTicketID());
//        tktTicketConversationDto.setTicketConversationReferID(tktTicketConversation.getTicketConversationReferID());
//        tktTicketConversationDto.setFromUserID(tktTicketConversation.getFromUserID());
//        tktTicketConversationDto.setTicketDesc(tktTicketConversation.getTicketDesc());
//        tktTicketConversationDto.setIsConfidential(tktTicketConversation.getIsConfidential());
//
//        List<TktTicketAttachment> tktTicketAttachments = tktTicketAttachmentRepository.tktShowTicketAttachmentByTicketConversationID(ticketConversationID);
//        BigDecimal[] attachments = new BigDecimal[tktTicketAttachments.size()];
//
//        for (int i = 0; i < tktTicketAttachments.size(); i++) {
//            attachments[i] = tktTicketAttachments.get(i).getAttachmentID();
//        }
//       //
//
//        tktTicketConversationDto.setAttachmentIDs(attachments);
//        return tktTicketConversationDto;
//    }

    default TktTicketConversation tktShowTicketConversationByID(BigDecimal ticketConversationID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("Filter", " AND Main.TicketConversationID = " + ticketConversationID));
        tParameters.add(new TParameter<>("UserID", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowTicketConversation", tParameters, true).get(0);
    }


    default TktTicketConversationDto tktInsTicketConversation(TktTicketConversationDto tktTicketConversationDto,
                                                              TktTicketAttachmentRepository tktTicketAttachmentRepository,
                                                              TktAttachmentRepository tktAttachmentRepository,
                                                              TktTicketRepository tktTicketRepository) {


        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TicketID", tktTicketConversationDto.getTicketID()));
        tParameters.add(new TParameter<>("TicketConversationReferID", tktTicketConversationDto.getTicketConversationReferID()));
        tParameters.add(new TParameter<>("FromUserID", tktTicketConversationDto.getFromUserID()));
        tParameters.add(new TParameter<>("TicketDesc", tktTicketConversationDto.getTicketDesc()));
        tParameters.add(new TParameter<>("IsConfidential", tktTicketConversationDto.getIsConfidential()));
        tParameters.add(new TParameter<>("ReferIDs", tktTicketConversationDto.getReferIDs()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal conversationID = insSP("TktInsTicketConversation", tParameters);

        TktTicket tktTicket = new TktTicket();
        if (tktTicketConversationDto.getStatusID() != null) {
            tktTicket.setStatusID(tktTicketConversationDto.getStatusID());
            tktTicketRepository.tktUpdStatus(tktTicketConversationDto.getTicketID(), tktTicket);
        }

//        TktTicketAttachment tktTicketAttachment = new TktTicketAttachment();
//        TktAttachment tktAttachment = new TktAttachment();
//        if(tktTicketConversationDto.getAttachments()!=null){
//            for (int i = 0; i < tktTicketConversationDto.getAttachments().size(); i++) {
//                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//
//                try {
//                    outputStream.write(tktTicketConversationDto.getAttachments().get(i));
//
//                    tktAttachment.setAttachmentFile(outputStream.toByteArray());
//
//                    tktAttachment.setAttachmentID(tktAttachmentRepository.tktInsAttachment(tktAttachment).getAttachmentID());
//
//                    tktTicketAttachment.setAttachmentID(tktAttachment.getAttachmentID());
//                    tktTicketAttachment.setTicketConversationID(conversationID);
//                    tktTicketAttachmentRepository.tktInsTicketAttachment(tktTicketAttachment);
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    System.out.println("Failed to add attachment " + Arrays.toString(tktTicketConversationDto.getAttachments().get(i)) + " to the list. Exception is " + e.toString());
//
//                }
//            }
//        }

        TktTicketAttachment tktTicketAttachment = new TktTicketAttachment();
        TktAttachment tktAttachment = new TktAttachment();
        if (tktTicketConversationDto.getAttachmentObj().getAttachment() != null) {

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            try {
                outputStream.write(tktTicketConversationDto.getAttachmentObj().getAttachment());

                tktAttachment.setAttachmentFile(outputStream.toByteArray());
                tktAttachment.setFileName(tktTicketConversationDto.getAttachmentObj().getFileName());
                tktAttachment.setFileType(tktTicketConversationDto.getAttachmentObj().getFileType());

                tktAttachment.setAttachmentID(tktAttachmentRepository.tktInsAttachment(tktAttachment).getAttachmentID());

                tktTicketAttachment.setAttachmentID(tktAttachment.getAttachmentID());
                tktTicketAttachment.setAttachmentID(tktAttachment.getAttachmentID());
                tktTicketAttachment.setTicketConversationID(conversationID);
                tktTicketAttachmentRepository.tktInsTicketAttachment(tktTicketAttachment);

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to add attachment " + tktTicketConversationDto.getAttachmentObj().getFileName() + " to the list. Exception is " + e.toString());

            }

        }


        return tktShowTicketConversationAttachments(tktTicketConversationDto.getTicketID(), conversationID, tktTicketAttachmentRepository);
    }

// Ins without attachments
//    default TktTicketConversation tktInsTicketConversation1(TktTicketConversation tktTicketConversation) {
//        LogLogins logLogins = fetchUserDetail();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("TicketID", tktTicketConversation.getTicketID()));
//        tParameters.add(new TParameter<>("TicketConversationReferID", tktTicketConversation.getTicketConversationReferID()));
//        tParameters.add(new TParameter<>("FromUserID", tktTicketConversation.getFromUserID()));
//        tParameters.add(new TParameter<>("TicketDesc", tktTicketConversation.getTicketDesc()));
//
////        tParameters.add(new TParameter<>("Attachment", null)); // موقتا نال است
//        tParameters.add(new TParameter<>("IsConfidential", tktTicketConversation.getIsConfidential()));
//        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        BigDecimal newID = insSP("TktInsTicketConversation", tParameters);
//        return tktShowTicketConversationByID(newID);
//    }

    default TktTicketConversationDto tktUpdTicketConversation(BigDecimal ticketConversationID,
                                                              TktTicketConversationDto tktTicketConversationDto,
                                                              TktTicketAttachmentRepository tktTicketAttachmentRepository,
                                                              TktAttachmentRepository tktAttachmentRepository,
                                                              TktTicketRepository tktTicketRepository) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TicketConversationID", ticketConversationID));
        tParameters.add(new TParameter<>("FromUserID", tktTicketConversationDto.getFromUserID()));
        tParameters.add(new TParameter<>("TicketDesc", tktTicketConversationDto.getTicketDesc()));
//        tParameters.add(new TParameter<>("Attachment", null)); // موقتا نال است
        tParameters.add(new TParameter<>("IsConfidential", tktTicketConversationDto.getIsConfidential()));
        tParameters.add(new TParameter<>("ReferIDs", tktTicketConversationDto.getReferIDs()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktUpdTicketConversation", tParameters);

        TktTicket tktTicket = new TktTicket();
        if (tktTicketConversationDto.getStatusID() != null) {
            tktTicket.setStatusID(tktTicketConversationDto.getStatusID());
            tktTicketRepository.tktUpdStatus(tktTicketConversationDto.getTicketID(), tktTicket);
        }

        TktTicketAttachment tktTicketAttachment = new TktTicketAttachment();
        TktAttachment tktAttachment = new TktAttachment();
        if (tktTicketConversationDto.getAttachmentObj().getAttachment() != null) {

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            try {
                outputStream.write(tktTicketConversationDto.getAttachmentObj().getAttachment());

                tktAttachment.setAttachmentFile(outputStream.toByteArray());
                tktAttachment.setFileName(tktTicketConversationDto.getAttachmentObj().getFileName());
                tktAttachment.setFileType(tktTicketConversationDto.getAttachmentObj().getFileType());

                tktAttachment.setAttachmentID(tktAttachmentRepository.tktInsAttachment(tktAttachment).getAttachmentID());

                tktTicketAttachment.setAttachmentID(tktAttachment.getAttachmentID());
                tktTicketAttachment.setAttachmentID(tktAttachment.getAttachmentID());
                tktTicketAttachment.setTicketConversationID(ticketConversationID);
                tktTicketAttachmentRepository.tktInsTicketAttachment(tktTicketAttachment);

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to add attachment " + tktTicketConversationDto.getAttachmentObj().getFileName() + " to the list. Exception is " + e.toString());

            }

        }

        return tktShowTicketConversationAttachments(tktTicketConversationDto.getTicketID(), ticketConversationID, tktTicketAttachmentRepository);
    }

    default void tktDelTicketConversation(BigDecimal ticketConversationID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TicketConversationID", ticketConversationID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TktDelTicketConversation", tParameters);
    }


    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "ticketConversationID", "ticketConversationID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "ticketConversationReferID", "ticketConversationReferID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "ticketID", "ticketID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "fromUserID", "fromUserID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "fromUserName", "fromUserName", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "fromUserReferID", "fromUserReferID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "fromUserNameRefer", "fromUserNameRefer", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "ticketDesc", "ticketDesc", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "staffSignature", "staffSignature", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "ticketDescRefer", "ticketDescRefer", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "isFirst", "IsFirst", Type.BOOLEAN, 100, false, false, false));
        cols.add(new Col(null, "isReplied", "isReplied", Type.BOOLEAN, 100, false, false, false));
        cols.add(new Col(null, "hasAttachment", "hasAttachment", Type.BOOLEAN, 100, false, false, false));
        cols.add(new Col(null, "createDateS", "createDateS", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "modifyDateS", "modifyDateS", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false, false));

        return new Meta(cols);
    }
}
