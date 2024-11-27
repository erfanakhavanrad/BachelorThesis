package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvLevel;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
public interface InvLevelRepository extends TCrudRepository<InvLevel>, CrudRepository<InvLevel, BigDecimal> {

    default List<InvLevel> invShowLevel(InvLevel invLevel) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invLevel._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invLevel._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("GroupID", null));
        tParameters.add(new TParameter<>("PageFilter", invLevel._pageFilter()));
        return showSP("InvShowLevel", tParameters, true);
    }

    default InvLevel invShowLevelByID(BigDecimal levelID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " And main.levelID= " + levelID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("GroupID", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("InvShowLevel", tParameters, true).get(0);
    }

    default InvLevel invInsLevel(InvLevel invLevel) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("LevelCode", invLevel.getLevelCode()));
        tParameters.add(new TParameter<>("LevelDesc", invLevel.getLevelDesc()));
        tParameters.add(new TParameter<>("LevelLatinDesc", invLevel.getLevelLatinDesc()));
        tParameters.add(new TParameter<>("LevelNumber", invLevel.getLevelNumber()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getCreatorID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsForceInputLevel", invLevel.getIsForceInputLevel()));
        tParameters.add(new TParameter<>("LevelCodeLen", invLevel.getLevelCodeLen()));
        tParameters.add(new TParameter<>("CoEff", invLevel.getCoEff()));
        tParameters.add(new TParameter<>("IsActiveInGoodsDesc", invLevel.getIsActiveInGoodsDesc()));
        tParameters.add(new TParameter<>("IsActiveInFormula", invLevel.getIsActiveInFormula()));
        tParameters.add(new TParameter<>("UnitID", invLevel.getUnitID()));
        tParameters.add(new TParameter<>("DefaultValue", invLevel.getDefaultValue()));
        tParameters.add(new TParameter<>("XFieldNo", invLevel.getxFieldNo()));
        tParameters.add(new TParameter<>("IsActiveLabelInGoodsDesc", invLevel.getIsActiveLabelInGoodsDescDsc()));
        BigDecimal newID = insSP("InvInsLevel", tParameters);
        InvLevel temp = new InvLevel();
        temp.setLevelID(newID);
        return invShowLevel(temp).get(0);
    }

    default void invDelLevel(BigDecimal levelID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("LevelID", levelID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("InvDelLevel", tParameters);
    }

    default InvLevel invUpdLevel(BigDecimal levelID, InvLevel invLevel) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("LevelID", levelID));
        tParameters.add(new TParameter<>("LevelCode", invLevel.getLevelCode()));
        tParameters.add(new TParameter<>("LevelDesc", invLevel.getLevelDesc()));
        tParameters.add(new TParameter<>("LevelNumber", invLevel.getLevelNumber()));
        tParameters.add(new TParameter<>("ModifierID", invLevel.getModifierID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsForceInputLevel", invLevel.getIsForceInputLevel()));
        tParameters.add(new TParameter<>("LevelCodeLen", invLevel.getLevelCodeLen()));
        tParameters.add(new TParameter<>("LevelLatinDesc", invLevel.getLevelLatinDesc()));
        tParameters.add(new TParameter<>("CoEff", invLevel.getCoEff()));
        tParameters.add(new TParameter<>("IsActiveInGoodsDesc", invLevel.getIsActiveInGoodsDesc()));
        tParameters.add(new TParameter<>("IsActiveInFormula", invLevel.getIsActiveInFormula()));
        tParameters.add(new TParameter<>("UnitID", invLevel.getUnitID()));
        tParameters.add(new TParameter<>("DefaultValue", invLevel.getDefaultValue()));
        tParameters.add(new TParameter<>("XFieldNo", invLevel.getxFieldNo()));
        tParameters.add(new TParameter<>("IsActiveLabelInGoodsDesc", invLevel.getIsActiveLabelInGoodsDesc()));
        updSP("InvUpdLevel", tParameters);
        InvLevel temp = new InvLevel();
        temp.setLevelID(levelID);
        return invShowLevel(temp).get(0);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "levelID", "levelID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "formulaCode", "کد پارامتری", Type.STRING, 60, true, true, false));
        cols.add(new Col(null, "levelCode", "کد", Type.STRING, 60, true, true, false));
        cols.add(new Col(null, "levelDesc", "عنوان طبقه", Type.STRING, 149, true, true, false));
        cols.add(new Col(null, "levelLatinDesc", "عنوان لاتین", Type.STRING, 69, true, true, false));
        cols.add(new Col(null, "levelNumber", "سطح طبقه", Type.DECIMAL, 60, true, true, false));
        cols.add(new Col(null, "isForceInputLevel", "اجباری", Type.BOOLEAN, 60, true, true, false));
        cols.add(new Col(null, "levelCodeLen", "طول کد", Type.DECIMAL, 60, true, true, false));
        cols.add(new Col(null, "coEff", "ضریب", Type.DECIMAL, 60, true, true, false));
        cols.add(new Col(null, "isActiveInGoodsDesc", "تاثیر در نام کالا", Type.BOOLEAN, 60, true, true, false));
        cols.add(new Col(null, "isActiveInFormula", "تاثیر در فرمول", Type.BOOLEAN, 60, true, true, false));
        cols.add(new Col(null, "defaultValue", "مقدار مشخصه پیش فرض", Type.DECIMAL, 52, true, true, false));
        cols.add(new Col(null, "unitDesc", "واحد", Type.DECIMAL, 60, true, true, false));
        cols.add(new Col(null, "xFieldNo", "فیلد اختیاری متناظر", Type.INTEGER, 60, true, true, false));
        cols.add(new Col(null, "isActiveLabelInGoodsDesc", "تاثیر نام طبقه در نام کالا", Type.BOOLEAN, 60, true, true, false));
        cols.add(new Col(null, "serverID", "ServerID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "createDate", "CreateDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifyDate", "ModifyDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifierID", "ModifierID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "creatorID", "CreatorID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "unitID", "unitID", Type.DECIMAL, 0, false, false, false));
        return new Meta(cols);
    }
}
