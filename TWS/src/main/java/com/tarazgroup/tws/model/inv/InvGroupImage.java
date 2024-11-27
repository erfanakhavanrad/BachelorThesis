//package com.tarazgroup.tws.model.inv;
//
//import com.tarazgroup.tws.util.global.TParams;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.math.BigDecimal;
//
///**
// * @author A.Farahani
// * Dec-20, 2021
// */
//
//@NamedStoredProcedureQuery(
//        name = "InvShowGroupImage",
//        procedureName = "InvShowGroupImage",
//        resultClasses = {InvGroupImage.class},
//        parameters = {
//                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode= ParameterMode.IN),
//                @StoredProcedureParameter(name  = "ServerFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
//        }
//)
//
//@NamedStoredProcedureQuery(
//        name = "InvInsGroupImage",
//        procedureName = "InvInsGroupImage",
//        parameters = {
//                @StoredProcedureParameter(name = "GroupID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ImageGroup", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
//        }
//)
//
//@NamedStoredProcedureQuery(
//        name = "InvDelGroupImage",
//        procedureName = "InvDelGroupImage",
//        parameters = {
//                @StoredProcedureParameter(name = "GroupID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
//        }
//)
//
//@Entity
//public class InvGroupImage extends TParams implements Serializable {
//    @Id
//    @Column(name = "GroupID")
//    private BigDecimal groupID;
//
//    @Column(name = "ImageGroup")
//    private String imageGroup;
//
//    public BigDecimal getGroupID() {
//        return groupID;
//    }
//
//    public void setGroupID(BigDecimal groupID) {
//        this.groupID = groupID;
//    }
//
//    public String getImageGroup() {
//        return imageGroup;
//    }
//
//    public void setImageGroup(String imageGroup) {
//        this.imageGroup = imageGroup;
//    }
//}
