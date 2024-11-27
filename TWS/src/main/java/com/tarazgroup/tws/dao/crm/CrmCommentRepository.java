package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmComment;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 10/16/22
 *
 * @author Erfan Akhavan
 */
public interface CrmCommentRepository extends TCrudRepository<CrmComment>, CrudRepository<CrmComment, BigDecimal> {
    default List<CrmComment> crmShowComments(CrmComment crmComment) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("FormID", crmComment.getFormID()));
        tParameters.add(new TParameter<>("RecordID", crmComment.getRecordID()));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("Filter", null));
        // if u want to add a fucking filter u should put it in this fucking OtherFilter Parameter =!
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmComment._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmComment._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmComment._pageFilter()));
        return showSP("CrmShowComment", tParameters, true);
    }

    default List<CrmComment> crmShowCommentsWithPathVariable(BigDecimal formID, BigDecimal recordID, CrmComment crmComment) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("FormID", formID));
        tParameters.add(new TParameter<>("RecordID", recordID));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmComment._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmComment._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmComment._pageFilter()));
        return showSP("CrmShowComment", tParameters, true);
    }


    //    GET BY ID
    default CrmComment crmShowCommentsByID(BigDecimal commentID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormID", null));
        tParameters.add(new TParameter<>("RecordID", null));
        tParameters.add(new TParameter<>("Filter", " WHERE Main.commentID=" + commentID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowComment", tParameters, true).get(0);
    }

    //    POST
    default CrmComment crmInsComment(CrmComment crmComment, BigDecimal formID, BigDecimal recordID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("FormID", formID));
        tParameters.add(new TParameter("RecordID", recordID));
        tParameters.add(new TParameter("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter("CommentDesc", crmComment.getCommentDesc()));
        tParameters.add(new TParameter("RefCommentID", crmComment.getRefCommentID()));
        tParameters.add(new TParameter("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("CrmInsComment", tParameters);
        return crmShowCommentsByID(newID);
    }


    default CrmComment crmUpdComment(BigDecimal commentID, CrmComment crmComment) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CommentID", commentID));
//        tParameters.add(new TParameter<>("FormID", crmComment.getFormID()));
//        tParameters.add(new TParameter<>("RecordID", crmComment.getRecordID()));
        tParameters.add(new TParameter<>("CommentDesc", crmComment.getCommentDesc()));
        tParameters.add(new TParameter<>("IsPin", crmComment.getIsPin()));
        tParameters.add(new TParameter<>("RefCommentID", crmComment.getRefCommentID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdComment", tParameters);
        return crmShowCommentsByID(commentID);
    }

    //    DELETE
    default void crmDelComment(BigDecimal commentID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CommentID", commentID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelComment", tParameters);
    }


    default CrmComment crmCommentToggleStatus(BigDecimal commentID) {

        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        Boolean isPinCondition = crmShowCommentsByID(commentID).getIsPin();

        if (isPinCondition) {
            isPinCondition = false;
        } else {
            isPinCondition = true;
        }

        tParameters.add(new TParameter("CommentID", commentID));
        tParameters.add(new TParameter("IsPin", isPinCondition));
        tParameters.add(new TParameter("ModifierID", logLogins.getPubUser().getUserID()));
        updSP("CrmToggleIsPin", tParameters);
        return crmShowCommentsByID(commentID);
    }


    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "commentID", "commentID" ,Type.DECIMAL, false,0, false, false, true));
        cols.add(new Col(null, "formID", "formID" ,Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "recordID", "recordID" ,Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "userID", "userID" ,Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "perComName", "نام" ,Type.STRING, false,50, true, true, false));
        cols.add(new Col(null, "commentDesc", "کامنت" ,Type.STRING, true,0, false, false, false));
        cols.add(new Col(null, "isPin", "isPin" ,Type.BOOLEAN, false,0, false, false, false));
        cols.add(new Col(null, "isReplied", "isReplied" ,Type.BOOLEAN, false,0, false, false, false));
        cols.add(new Col(null, "isMyComment", "isMyComment" ,Type.BOOLEAN, false,0, false, false, false));
        cols.add(new Col(null, "refCommentID", "refCommentID" ,Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "refUserID", "refUserID" ,Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "refPerComName", "refPerComName" ,Type.STRING, false,0, false, false, false));
        cols.add(new Col(null, "refCommentDesc", "refCommentDesc" ,Type.STRING, false,0, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID" ,Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "createDate", "createDate" ,Type.DATE, false,0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID" ,Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate" ,Type.DATE, false,0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID" ,Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "timeDiff", "timeDiff" ,Type.DECIMAL, false,0, false, false, false));

        return new Meta(cols);
    }


}
