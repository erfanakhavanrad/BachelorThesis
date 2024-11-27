package com.tarazgroup.tws.dto;

import java.math.BigDecimal;

/**
 * 9/1/22
 *
 * @author Erfan Akhavan
 */
public class AttachmentModel {

    private String photo;
    private byte[] photoByteArray;
    private String photoString;

    private BigDecimal voucherTypeID;

    public byte[] getPhotoByteArray() {
        return photoByteArray;
    }

    public void setPhotoByteArray(byte[] photoByteArray) {
        this.photoByteArray = photoByteArray;
    }

    public String getPhotoString() {
        return photoString;
    }

    public void setPhotoString(String photoString) {
        this.photoString = photoString;
    }


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
    }
}
