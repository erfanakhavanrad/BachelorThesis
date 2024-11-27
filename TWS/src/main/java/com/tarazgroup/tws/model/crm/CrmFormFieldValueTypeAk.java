package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.dto.tkt.ticket.AttachmentDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.LinkedHashMap;

/**
 * 9/24/22
 *
 * @author Erfan Akhavan
 */
// نکته بسیار مهم : حتما حتما ترتیب فیلد های این کلاس باید همانند ترتیب تیبل تایپ اس کیو ال باشد

@Entity
public class CrmFormFieldValueTypeAk {
    //
    @Id
    @Column
    private BigDecimal fieldID;
//

//    private SQLType fieldValue;

    @Column
    @Transient
    private Object fieldValue;
    //
//        return new SQLServerMetaData("FieldValue", microsoft.sql.Types.SQL_VARIANT);
//
    @Column
    private BigDecimal valueID;


    public BigDecimal getFieldID() {
        return fieldID;
    }

    public void setFieldID(BigDecimal fieldID) {
        this.fieldID = fieldID;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(Object fieldValue) {
        this.fieldValue = fieldValue;
    }

    public BigDecimal getValueID() {
        return valueID;
    }

    public void setValueID(BigDecimal valueID) {
        this.valueID = valueID;
    }


    public StringBuilder createQuery(String parameterName) {
        Field[] fields = this.getClass().getDeclaredFields();
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("INSERT INTO @").append(parameterName).append(" VALUES(").append("\n");
        try {
            for (Field field : fields) {
                Object value = field.get(this);
                if (field.getType().equals(java.math.BigDecimal.class)) {
                    if (value == null) {
                        sqlQuery.append("NULL").append(", --").append(field.getName()).append("\n");
                    } else {
                        sqlQuery.append(value).append(", --").append(field.getName()).append("\n");
                    }
                } else if (field.getType().equals(java.lang.String.class)) {
                    if (value == null) {
                        sqlQuery.append("NULL").append(", --").append(field.getName()).append("\n");
//                        System.out.println("first if" + field.getName());
                    } else {
                        sqlQuery.append("'").append(value).append("'").append(", --").append(field.getName()).append("\n");
//                        System.out.println("second if" + field.getName());

                    }
                } else if (field.getType().equals(java.util.Date.class)) {
                    if (value == null) {
                        sqlQuery.append("NULL").append(", --").append(field.getName()).append("\n");
                    } else {
                        sqlQuery.append("'").append(value).append("'").append(", --").append(field.getName()).append("\n");
                    }
                } else if (field.getType().equals(java.lang.Boolean.class)) {
                    if (value == null) {
                        sqlQuery.append("NULL").append(", --").append(field.getName()).append("\n");
                    } else {
                        sqlQuery.append(value).append(", --").append(field.getName()).append("\n");
                    }
                } else if (field.getType().equals(java.lang.Object.class)) {
//                    System.out.println("Field Name is " + field.getName().toString());

//                    System.out.println(value.getClass().getPackage()+" *Value type");
                    System.out.println();
//                    System.out.println(value.getClass().getTypeName()+" *Value type");
//                    System.out.println(Arrays.toString(value.getClass().getDeclaredFields()) +" *Value type");
//                    System.out.println(value.getClass().getName()+" *Value type");
//                    System.out.println(value.getClass().getPackage()+"Value type");

                    if (value == null) {
                        sqlQuery.append("NULL").append(", --").append(field.getName()).append("\n");
                    } else {
                        if (value.getClass() == java.math.BigDecimal.class) {
                            sqlQuery.append(value).append(", --").append(field.getName()).append("\n");
                        } else if (value.getClass() == java.lang.Integer.class) {
                            sqlQuery.append(value).append(", --").append(field.getName()).append("\n");
                        } else if (value.getClass() == java.lang.String.class) {
                            sqlQuery.append("'").append(value).append("'").append(", --").append(field.getName()).append("\n");
                        } else if (value.getClass() == java.util.Date.class) {
                            sqlQuery.append("'").append(value).append("'").append(", --").append(field.getName()).append("\n");
                        } else if (value.getClass() == java.lang.Boolean.class) {
                            sqlQuery.append((boolean) value ? 1 : 0).append(", --").append(field.getName()).append("\n");
                        } else if (value.getClass() == java.lang.Object.class) {
                            System.out.println("Object case");
                        } else if (value.getClass() == java.util.LinkedHashMap.class) {
                            System.out.println("Linked hashmap case");
//                            sqlQuery.append(value).append(", --").append(field.getName()).append("\n");
//                            bye[]
                            for (int i = 0; i < ((LinkedHashMap<?, ?>) value).size(); i++) {
                                System.out.println(i + " Linked map field.name " + field.getName()); // This is called twice
                                System.out.println(i + " Linked map value " + value); // It is called once because value id is null
                                System.out.println("Value size is " + ((LinkedHashMap<?, ?>) value).size());

                                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

                                AttachmentDto attachmentDto = new AttachmentDto();
//                                attachmentDto.setFileName(((LinkedHashMap<?, ?>) value).get());
//                                attachmentDto.setFileType();
//                                attachmentDto.setAttachment();

// keys are type, aName, file
                                try {
//                                    outputStream.write((byte[]) ((LinkedHashMap<?, ?>) value).get("type"));
//                                    outputStream.write((byte[]) ((LinkedHashMap<?, ?>) value).get("aName"));
                                    outputStream.write((byte[]) ((LinkedHashMap<?, ?>) value).get("file"));

//                                    TktAttachment tktAttachment = new TktAttachment();
//                                    AttachmentDto attachmentDto1 = new AttachmentDto();

                                    attachmentDto.setAttachment(outputStream.toByteArray());
                                    attachmentDto.setFileName((String) ((LinkedHashMap<?, ?>) value).get("aName"));
                                    attachmentDto.setFileType((String) ((LinkedHashMap<?, ?>) value).get("type"));

//                                    crmAttachmentRepository.crmInsAttachment();



                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

//                                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//                                try {
//                                    outputStream.write(tktTicketInsDto.getAttachmentObj().getAttachment());
//
//                                    tktAttachment.setAttachmentFile(outputStream.toByteArray());
//                                    tktAttachment.setFileName(tktTicketInsDto.getAttachmentObj().getFileName());
//                                    tktAttachment.setFileType(tktTicketInsDto.getAttachmentObj().getFileType());
//
//                                    tktAttachment.setAttachmentID(tktAttachmentRepository.tktInsAttachment(tktAttachment).getAttachmentID());
//
//                                    tktTicketAttachment.setAttachmentID(tktAttachment.getAttachmentID());
//                                    BigDecimal conversationID = tktTicketConversationRepository.tktShowTicketConv(ticketID).get(0).getTicketConversationID();
//                                    tktTicketAttachment.setTicketConversationID(conversationID);
//                                    tktTicketAttachmentRepository.tktInsTicketAttachment(tktTicketAttachment);
//
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                    System.out.println("Failed to add attachment " + tktTicketInsDto.getAttachmentObj().getFileName() + " to the list. Exception is " + e.toString());
//
//                                }

                            }
//                            Object object1 = new Object();
//                            Object object2 = new Object();
//                            Object object3 = new Object();
//                            CrmAttachmentRepos
//                            CrmAttachmentRepository crmAttachmentRepository;


                            sqlQuery.append("'").append(value).append("'").append(", --").append(field.getName()).append("\n");

                        }
//                        Class<?> type = field.getType();
//                        System.out.println("type.toString " + type.toString());
//                        System.out.println("type.getName  "+type.getName().toString());
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Field fieldLast = fields[fields.length - 1];
        sqlQuery.delete(sqlQuery.length() - 1 - (", --" + fieldLast.getName()).length(),
                sqlQuery.length()
        );
        sqlQuery.append(" --").append(fieldLast.getName()).append("\n");
        sqlQuery.append(")").append("\n");
        return sqlQuery;
    }

//    public LogLogins fetchUserDetail() {
//
//        @Autowired
//        private final HttpServletRequest request;
//
//        if (request.getHeader("Authorization") == null)
//            throw new InternalAuthenticationServiceException("Authorization Header Is Empty");
//        String authentication = request.getHeader("Authorization");
//        Double loginIDFromToken = new JWTTokenUtil().getLoginIDFromToken(authentication.substring(7));
//
//        Query query = entityManager.createQuery("select o from LogLogins o where " + "o.loginId = :loginID ").setParameter("loginID", new BigDecimal(loginIDFromToken.intValue()));
//        List<LogLogins> resultList = query.getResultList();
//        if (resultList.isEmpty()) {
//            throw new TUnAuthorizedException();
//        }
//        return resultList.get(0);
//    }

}
