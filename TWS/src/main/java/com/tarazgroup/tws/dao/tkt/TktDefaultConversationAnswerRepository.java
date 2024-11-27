package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktDefaultConversationAnswer;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Icon;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date May-24, 2022
 ***/
public interface TktDefaultConversationAnswerRepository extends TCrudRepository<TktDefaultConversationAnswer>, CrudRepository<TktDefaultConversationAnswer, BigDecimal> {
    default List<TktDefaultConversationAnswer> tktShowDefaultConversationAnswer(TktDefaultConversationAnswer tktDefaultConversationAnswer) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("Filter", "And Main.userID = " + logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("PageFilter", tktDefaultConversationAnswer._pageFilter()));
        return showSP("TktShowDefaultConversationAnswer", tParameters, true);
    }

    default TktDefaultConversationAnswer tktShowDefaultConversationAnswerByID(BigDecimal answerID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("Filter", " AND Main.AnswerID = " + answerID));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowDefaultConversationAnswer", tParameters, true).get(0);
    }

    default TktDefaultConversationAnswer tktInsDefaultConversationAnswer(TktDefaultConversationAnswer tktDefaultConversationAnswer) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("AnswerDesc", tktDefaultConversationAnswer.getAnswerDesc()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("TktInsDefaultConversationAnswer", tParameters);
        return tktShowDefaultConversationAnswerByID(newID);
    }

    default TktDefaultConversationAnswer tktUpdDefaultConversationAnswer(BigDecimal answerID, TktDefaultConversationAnswer tktDefaultConversationAnswer) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("AnswerID", answerID));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("AnswerDesc", tktDefaultConversationAnswer.getAnswerDesc()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktUpdDefaultConversationAnswer", tParameters);
        return tktShowDefaultConversationAnswerByID(answerID);
    }

    default void tktDelDefaultConversationAnswer(BigDecimal answerID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("AnswerID", answerID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TktDelDefaultConversationAnswer", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "answerID", "answerID", Type.DECIMAL, 0, false, false,false, Icon.none, true));
        cols.add(new Col(null, "userID", "userID", Type.DECIMAL, 0, false, false,false,Icon.none, false));
        cols.add(new Col(null, "answerDesc", "پاسخ پیشفرض", Type.STRING, 100, true, true,true,Icon.none, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false,false,Icon.none, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false,false,Icon.none, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false,false,Icon.none, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false,false,Icon.none, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false,false,Icon.none, false));

        return new Meta(cols);
    }
}
