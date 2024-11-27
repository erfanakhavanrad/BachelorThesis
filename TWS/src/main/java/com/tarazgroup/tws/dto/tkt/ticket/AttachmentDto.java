package com.tarazgroup.tws.dto.tkt.ticket;

/***
 * @author A.Farahani
 * @date Aug-21, 2022
 ***/
public class AttachmentDto {
    private String fileName;

    private String fileType;

    private byte[] attachment;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }
}
