package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;

/***
 * @author A.Farahani
 * @date Apr-26, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "InvExportImage",
        procedureName = "InvExportImage",
        resultClasses = {InvExportImage.class},
        parameters = {
                @StoredProcedureParameter(name = "FromDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DriveName", type = String.class, mode = ParameterMode.IN)
        }
)
@Entity
public class InvExportImage extends TParams implements Serializable {

    @Id
    @Column(name = "MID")
    private Integer mID;

    @Column(name = "MSG")
    private String mSG;

    public Integer getmID() {
        return mID;
    }

    public void setmID(Integer mID) {
        this.mID = mID;
    }

    public String getmSG() {
        return mSG;
    }

    public void setmSG(String mSG) {
        this.mSG = mSG;
    }

    //    @Id
//    private UUID _id = UUID.randomUUID();
//
////    private DriveType driveName;
//
//    public UUID get_id() {
//        return _id;
//    }
//
//    public void set_id(UUID _id) {
//        this._id = _id;
//    }

//    public DriveType getDriveName() {
//        return driveName;
//    }
//
//    public void setDriveName(DriveType driveName) {
//        this.driveName = driveName;
//    }
}
