package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author A.Farahani
 * @date Feb-07, 2023
 ***/
@NamedStoredProcedureQuery(
        name = "CrmShowActivity",
        procedureName = "CrmShowActivity",
        resultClasses = {CrmActivity.class},
        parameters = {
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmInsActivity",
        procedureName = "CrmInsActivity",
        resultClasses = {CrmActivity.class},
        parameters = {
                @StoredProcedureParameter(name = "FormID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RecordID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IdentityID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ActivityName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StartDateG", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StartTime", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReferID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "EndDateG", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "EndTime", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "HasAnnouncement", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StatusID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PriorityID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "HasReminder", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AlarmDateBeforeG", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AlarmTimeBefore", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LocationID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "HasRepeat", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RepeatDay", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RepeatTime", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RepeatDateUntilG", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsPublic", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ActivityDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReferToBaseUserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RelatedUserIDs", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "AudienceIDs", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsAlarm", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmUpdActivity",
        procedureName = "CrmUpdActivity",
        resultClasses = {CrmActivity.class},
        parameters = {
                @StoredProcedureParameter(name = "ActivityID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StatusID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PriorityID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReferID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LocationID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ActivityName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ActivityDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StartDateG", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StartTime", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "EndDateG", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "EndTime", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AlarmDateBeforeG", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AlarmTimeBefore", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RelatedUserIDs", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsPublic", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "HasAnnouncement", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "HasReminder", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "HasRepeat", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RepeatDay", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RepeatTime", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RepeatDateUntilG", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)

        }
)

@NamedStoredProcedureQuery(
        name = "CrmDelActivity",
        procedureName = "CrmDelActivity",
        resultClasses = {CrmActivity.class},
        parameters = {
                @StoredProcedureParameter(name = "ActivityID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@Entity
public class CrmActivity extends TParams implements Serializable {
    @Id
    @Column(name = "ActivityID")
    private BigDecimal activityID;

    @Column(name = "ReferID")
    private BigDecimal referID;

    @Column(name = "FormID")
    private BigDecimal formID;

    @Column(name = "RecordID")
    private BigDecimal recordID;

    @Column(name = "IdentityID")
    private BigDecimal identityID;

    @Column(name = "TypeID")
    private BigDecimal typeID;

    @Column(name = "StatusID")
    private BigDecimal statusID;

    @Column(name = "VoucherTypeID")
    private BigDecimal voucherTypeID;

    @Column(name = "PriorityID")
    private BigDecimal priorityID;

    @Column(name = "ReferToBaseUserID")
    private BigDecimal referToBaseUserID;

    @Column(name = "LocationID")
    private BigDecimal locationID;

    @Column(name = "ActivityName")
    private String activityName;

    @Column(name = "ActivityDesc")
    private String activityDesc;

    @Column(name = "StartDateG")
    private Date startDateG;

    @Column(name = "EndDateG")
    private Date endDateG;

    @Column(name = "AlarmDateBeforeG")
    private Date alarmDateBeforeG;

    @Column(name = "RelatedUserIDs")
    private String relatedUserIDs;

    @Column(name = "AudienceIDs")
    private String audienceIDs;

    @Column(name = "IsAlarm")
    private Boolean isAlarm;

    @Column(name = "IsPublic")
    private Boolean isPublic;

    @Column(name = "HasAnnouncement")
    private Boolean hasAnnouncement;

    @Column(name = "HasReminder")
    private Boolean hasReminder;

    @Column(name = "HasRepeat")
    private Boolean hasRepeat;

    @Column(name = "RepeatDay")
    private Integer repeatDay;

    @Column(name = "RepeatTime")
    private String repeatTime;

    @Column(name = "RepeatDateUntilG")
    private Date repeatDateUntilG;

    @Column(name = "RepeatDateUntil")
    private String repeatDateUntil;

    @Column(name = "ReferDesc")
    private String referDesc;

//    @Column(name = "ReferCode")
//    private String referCode;

    @Column(name = "IdentityDesc")
    private String identityDesc;

    @Column(name = "IdentityLatinDesc")
    private String identityLatinDesc;

    @Column(name = "IdentityColor")
    private String identityColor;

    @Column(name = "TypeDesc")
    private String typeDesc;

    @Column(name = "TypeIcon")
    private String typeIcon;

    @Column(name = "StatusTitle")
    private String statusTitle;

    @Column(name = "StatusColor")
    private String statusColor;

//    @Column(name = "CustomVTypeDesc")
//    private String customVTypeDesc;

//    @Column(name = "PriorityCode")
//    private String priorityCode;

    @Column(name = "PriorityName")
    private String priorityName;

    @Column(name = "PriorityColor")
    private String priorityColor;

    @Column(name = "ReferToBaseUserName")
    private String referToBaseUserName;

    @Column(name = "LocationDesc")
    private String locationDesc;

    @Column(name = "StartDate")
    private String startDate;

    @Column(name = "EndDate")
    private String endDate;

    @Column(name = "StartTime")
    private String startTime;

    @Column(name = "EndTime")
    private String endTime;

    @Column(name = "AlarmDateBefore")
    private String alarmDateBefore;

    @Column(name = "AlarmTimeBefore")
    private String alarmTimeBefore;

    @Column(name = "RelatedUserNames")
    private String relatedUserNames;

    @Column(name = "AudienceNames")
    private String audienceNames;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "CreateDate")
    private Date createDate;


    @Column(name = "ModifyDate")
    private Date modifyDate;

    public BigDecimal getActivityID() {
        return activityID;
    }

    public void setActivityID(BigDecimal activityID) {
        this.activityID = activityID;
    }

    public BigDecimal getReferID() {
        return referID;
    }

    public void setReferID(BigDecimal referID) {
        this.referID = referID;
    }

    public BigDecimal getFormID() {
        return formID;
    }

    public void setFormID(BigDecimal formID) {
        this.formID = formID;
    }

    public BigDecimal getRecordID() {
        return recordID;
    }

    public void setRecordID(BigDecimal recordID) {
        this.recordID = recordID;
    }

    public BigDecimal getIdentityID() {
        return identityID;
    }

    public void setIdentityID(BigDecimal identityID) {
        this.identityID = identityID;
    }

    public BigDecimal getTypeID() {
        return typeID;
    }

    public void setTypeID(BigDecimal typeID) {
        this.typeID = typeID;
    }

    public BigDecimal getStatusID() {
        return statusID;
    }

    public void setStatusID(BigDecimal statusID) {
        this.statusID = statusID;
    }

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
    }

    public BigDecimal getPriorityID() {
        return priorityID;
    }

    public void setPriorityID(BigDecimal priorityID) {
        this.priorityID = priorityID;
    }

    public BigDecimal getReferToBaseUserID() {
        return referToBaseUserID;
    }

    public void setReferToBaseUserID(BigDecimal referToBaseUserID) {
        this.referToBaseUserID = referToBaseUserID;
    }

    public BigDecimal getLocationID() {
        return locationID;
    }

    public void setLocationID(BigDecimal locationID) {
        this.locationID = locationID;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
    }

    public Date getStartDateG() {
        return startDateG;
    }

    public void setStartDateG(Date startDateG) {
        this.startDateG = startDateG;
    }

    public Date getEndDateG() {
        return endDateG;
    }

    public void setEndDateG(Date endDateG) {
        this.endDateG = endDateG;
    }

    public Date getAlarmDateBeforeG() {
        return alarmDateBeforeG;
    }

    public void setAlarmDateBeforeG(Date alarmDateBeforeG) {
        this.alarmDateBeforeG = alarmDateBeforeG;
    }

    public String getRelatedUserIDs() {
        return relatedUserIDs;
    }

    public void setRelatedUserIDs(String relatedUserIDs) {
        this.relatedUserIDs = relatedUserIDs;
    }

    public String getAudienceIDs() {
        return audienceIDs;
    }

    public void setAudienceIDs(String audienceIDs) {
        this.audienceIDs = audienceIDs;
    }

    public Boolean getIsAlarm() {
        return isAlarm;
    }

    public void setIsAlarm(Boolean isAlarm) {
        this.isAlarm = isAlarm;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public Boolean getHasAnnouncement() {
        return hasAnnouncement;
    }

    public void setHasAnnouncement(Boolean hasAnnouncement) {
        this.hasAnnouncement = hasAnnouncement;
    }

    public Boolean getHasReminder() {
        return hasReminder;
    }

    public void setHasReminder(Boolean hasReminder) {
        this.hasReminder = hasReminder;
    }

    public Boolean getHasRepeat() {
        return hasRepeat;
    }

    public void setHasRepeat(Boolean hasRepeat) {
        this.hasRepeat = hasRepeat;
    }

    public Integer getRepeatDay() {
        return repeatDay;
    }

    public void setRepeatDay(Integer repeatDay) {
        this.repeatDay = repeatDay;
    }

    public String getRepeatTime() {
        return repeatTime;
    }

    public void setRepeatTime(String repeatTime) {
        this.repeatTime = repeatTime;
    }

    public Date getRepeatDateUntilG() {
        return repeatDateUntilG;
    }

    public void setRepeatDateUntilG(Date repeatDateUntilG) {
        this.repeatDateUntilG = repeatDateUntilG;
    }

    public String getRepeatDateUntil() {
        return repeatDateUntil;
    }

    public void setRepeatDateUntil(String repeatDateUntil) {
        this.repeatDateUntil = repeatDateUntil;
    }

    public String getIdentityDesc() {
        return identityDesc;
    }

    public void setIdentityDesc(String identityDesc) {
        this.identityDesc = identityDesc;
    }

    public String getIdentityLatinDesc() {
        return identityLatinDesc;
    }

    public void setIdentityLatinDesc(String identityLatinDesc) {
        this.identityLatinDesc = identityLatinDesc;
    }

    public String getReferToBaseUserName() {
        return referToBaseUserName;
    }

    public void setReferToBaseUserName(String referToBaseUserName) {
        this.referToBaseUserName = referToBaseUserName;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAlarmDateBefore() {
        return alarmDateBefore;
    }

    public void setAlarmDateBefore(String alarmDateBefore) {
        this.alarmDateBefore = alarmDateBefore;
    }

    public String getAlarmTimeBefore() {
        return alarmTimeBefore;
    }

    public void setAlarmTimeBefore(String alarmTimeBefore) {
        this.alarmTimeBefore = alarmTimeBefore;
    }

    public String getRelatedUserNames() {
        return relatedUserNames;
    }

    public void setRelatedUserNames(String relatedUserNames) {
        this.relatedUserNames = relatedUserNames;
    }

    public String getAudienceNames() {
        return audienceNames;
    }

    public void setAudienceNames(String audienceNames) {
        this.audienceNames = audienceNames;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getStatusTitle() {
        return statusTitle;
    }

    public void setStatusTitle(String statusTitle) {
        this.statusTitle = statusTitle;
    }

    public String getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public String getTypeIcon() {
        return typeIcon;
    }

    public void setTypeIcon(String typeIcon) {
        this.typeIcon = typeIcon;
    }

    public String getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(String statusColor) {
        this.statusColor = statusColor;
    }

    public String getIdentityColor() {
        return identityColor;
    }

    public void setIdentityColor(String identityColor) {
        this.identityColor = identityColor;
    }

    public String getPriorityColor() {
        return priorityColor;
    }

    public void setPriorityColor(String priorityColor) {
        this.priorityColor = priorityColor;
    }

    public String getReferDesc() {
        return referDesc;
    }

    public void setReferDesc(String referDesc) {
        this.referDesc = referDesc;
    }
}



