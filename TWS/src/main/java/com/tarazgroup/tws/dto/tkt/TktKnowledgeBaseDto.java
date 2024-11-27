package com.tarazgroup.tws.dto.tkt;

import java.math.BigDecimal;

/***
 * @author A.Farahani
 * @date Apr-13, 2022
 ***/
public class TktKnowledgeBaseDto {

    private BigDecimal knowledgeBaseID;

    private String knowledgeBaseName;

    private BigDecimal knowledgeBaseCategoryID;

    private String knowledgeBaseDesc;

    private byte[] attachments;

    public BigDecimal getKnowledgeBaseID() {
        return knowledgeBaseID;
    }

    public void setKnowledgeBaseID(BigDecimal knowledgeBaseID) {
        this.knowledgeBaseID = knowledgeBaseID;
    }

    public String getKnowledgeBaseName() {
        return knowledgeBaseName;
    }

    public void setKnowledgeBaseName(String knowledgeBaseName) {
        this.knowledgeBaseName = knowledgeBaseName;
    }

    public BigDecimal getKnowledgeBaseCategoryID() {
        return knowledgeBaseCategoryID;
    }

    public void setKnowledgeBaseCategoryID(BigDecimal knowledgeBaseCategoryID) {
        this.knowledgeBaseCategoryID = knowledgeBaseCategoryID;
    }

    public String getKnowledgeBaseDesc() {
        return knowledgeBaseDesc;
    }

    public void setKnowledgeBaseDesc(String knowledgeBaseDesc) {
        this.knowledgeBaseDesc = knowledgeBaseDesc;
    }

    public byte[] getAttachments() {
        return attachments;
    }

    public void setAttachments(byte[] attachments) {
        this.attachments = attachments;
    }
}
