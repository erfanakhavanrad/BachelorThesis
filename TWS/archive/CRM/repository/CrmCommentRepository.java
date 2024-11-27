package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmAudience;
import com.tarazgroup.tws.model.crm.CrmComment;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@SuppressWarnings("Duplicates")
public interface CrmCommentRepository extends TCrudRepository<CrmComment>, CrudRepository<CrmComment, BigDecimal> {

    default List<CrmComment> crmShowComment(Map<String, String> params) {
        String formIDs = params.get("formIDs");
        BigDecimal recordID = new BigDecimal(params.get("recordID"));
        BigDecimal serverID = new BigDecimal(params.get("serverID"));
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", " AND main.ServerID=" + serverID));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", " AND FormID IN (" + formIDs + ") AND recordID=" + recordID + "?,?"));
        return showSP("CrmShowComment", tParameters, true);
    }

    default CrmComment crmShowCommentByID(BigDecimal commentID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.commentID=" + commentID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowComment", tParameters, true).get(0);
    }

    default CrmComment crmInsComment(CrmComment crmComment) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("RecordID", crmComment.getRecordID()));
        tParameters.add(new TParameter<>("CommentDesc", crmComment.getCommentDesc()));
        tParameters.add(new TParameter<>("RefCommentID", crmComment.getRefCommentID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("FormID", crmComment.getFormID()));
        BigDecimal newID = insSP("CrmInsComment", tParameters);
        return crmShowCommentByID(newID);
    }

    default void crmDelComment(BigDecimal commentID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CommentID", commentID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelComment", tParameters);
    }

    default CrmComment crmUpdComment(BigDecimal commentID, CrmComment crmComment) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CommentID", commentID));
        tParameters.add(new TParameter<>("RecordID", crmComment.getRecordID()));
        tParameters.add(new TParameter<>("CommentDesc", crmComment.getCommentDesc()));
        tParameters.add(new TParameter<>("RefCommentID", crmComment.getRefCommentID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdComment", tParameters);
        return crmShowCommentByID(commentID);
    }

    default InputStreamResource excel(CrmComment crmComment) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmComment._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmComment._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmComment._pageFilter()));
        List<CrmComment> rows = showSP("CrmShowComment", tParameters, false);
        return exportToExcel(rows, meta().getCols(), "فرم ها");
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "commentID", "commentID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "refCommentID", "refCommentID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "commentDesc", "کامنت", Type.STRING, 200, true, true, false));
        cols.add(new Col(null, "refCommentDesc", "کامنت مرجع", Type.STRING, 200, true, true, false));
        cols.add(new Col(null, "commentOwner", "کامنت دهنده", Type.STRING, 200, true, true, false));
        cols.add(new Col(null, "refCommentOwner", "کامنت دهنده مرجع", Type.STRING, 200, true, true, false));
        cols.add(new Col(null, "recordID", "recordID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.INTEGER, 0, false, false, false));
        return new Meta(cols);
    }
}
