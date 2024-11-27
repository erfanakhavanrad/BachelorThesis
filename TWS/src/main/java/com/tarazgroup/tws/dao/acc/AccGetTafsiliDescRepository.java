package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccGetTafsiliDesc;
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
public interface AccGetTafsiliDescRepository extends TCrudRepository<AccGetTafsiliDesc>, CrudRepository<AccGetTafsiliDesc, BigDecimal> {

    default List<AccGetTafsiliDesc> accGetTafsiliDesc(AccGetTafsiliDesc accGetTafsiliDesc, BigDecimal accID, BigDecimal tafsiliLevel, String center1Code,
                                                      String center2Code, String center3Code, String dCenter1Code, String dCenter2Code, String dCenter3Code) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("AccID", accID));
        tParameters.add(new TParameter<>("TafsiliLevel", tafsiliLevel));
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("TafsiliID", accGetTafsiliDesc.getTafsiliID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("TafsiliCode", accGetTafsiliDesc.getTafsiliCode()));
        tParameters.add(new TParameter<>("Center1Code", center1Code));
        tParameters.add(new TParameter<>("Center2Code", center2Code));
        tParameters.add(new TParameter<>("Center3Code", center3Code));
        tParameters.add(new TParameter<>("DCenter1Code", dCenter1Code));
        tParameters.add(new TParameter<>("DCenter2Code", dCenter2Code));
        tParameters.add(new TParameter<>("DCenter3Code", dCenter3Code));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("PageFilter", accGetTafsiliDesc._pageFilter()));
        return showSP("AccGetTafsiliDesc", tParameters, true);
    }

    default List<AccGetTafsiliDesc> accGetTafslisDescsByVoucherTypeID(
            BigDecimal voucherTypeID,
            BigDecimal tafsiliID,
            String tafsiliCode,
            String tafsiliDesc
    ) {
        String pageFilter = "";
        if (tafsiliID != null) {
            pageFilter += " AND main.TafsiliID = " + tafsiliID;
        } else {
            if (tafsiliCode != null) {
                pageFilter += " AND main.TafsiliCode LIKE'%" + tafsiliCode + "%' ";
            }
            if (tafsiliDesc != null) {
                pageFilter += " AND main.TafsiliDesc LIKE'%" + tafsiliDesc + "%' ";
            }
        }
        pageFilter += "?,";
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("AccID", null));
        tParameters.add(new TParameter<>("TafsiliLevel", null));
        tParameters.add(new TParameter<>("Filter", " And Main.TafsiliTypeID in (Select TafsiliTypeID from InvTafsiliTypeToVoucherType Where LevelCenter = 1 and VoucherTypeID =" + voucherTypeID + ")"));
        tParameters.add(new TParameter<>("TafsiliID", null));
        tParameters.add(new TParameter<>("LoginID", null));
        tParameters.add(new TParameter<>("TafsiliCode", null));
        tParameters.add(new TParameter<>("Center1Code", null));
        tParameters.add(new TParameter<>("Center2Code", null));
        tParameters.add(new TParameter<>("Center3Code", null));
        tParameters.add(new TParameter<>("DCenter1Code", null));
        tParameters.add(new TParameter<>("DCenter2Code", null));
        tParameters.add(new TParameter<>("DCenter3Code", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("PageFilter", pageFilter));
        return showSP("AccGetTafsiliDesc", tParameters, true);
    }

    default List<AccGetTafsiliDesc> accGetTafslisDescsByVoucherTypeIDCrm(
            BigDecimal voucherTypeID,
            BigDecimal tafsiliID,
            String tafsiliCode,
            String tafsiliDesc,
            BigDecimal levelCenter
    ) {
        String pageFilter = "";
        if (tafsiliID != null) {
            pageFilter += " AND main.TafsiliID = " + tafsiliID;
        } else {
            if (tafsiliCode != null) {
                pageFilter += " AND main.TafsiliCode LIKE'%" + tafsiliCode + "%' ";
            }
            if (tafsiliDesc != null) {
                pageFilter += " AND main.TafsiliDesc LIKE'%" + tafsiliDesc + "%' ";
            }
        }
        pageFilter += "?,";
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("AccID", null));
        tParameters.add(new TParameter<>("TafsiliLevel", null));
        tParameters.add(new TParameter<>("Filter", " And Main.TafsiliTypeID in (Select TafsiliTypeID from InvTafsiliTypeToVoucherType Where LevelCenter = "+ levelCenter+" and VoucherTypeID =" + voucherTypeID + ")"));
        tParameters.add(new TParameter<>("TafsiliID", null));
        tParameters.add(new TParameter<>("LoginID", null));
        tParameters.add(new TParameter<>("TafsiliCode", null));
        tParameters.add(new TParameter<>("Center1Code", null));
        tParameters.add(new TParameter<>("Center2Code", null));
        tParameters.add(new TParameter<>("Center3Code", null));
        tParameters.add(new TParameter<>("DCenter1Code", null));
        tParameters.add(new TParameter<>("DCenter2Code", null));
        tParameters.add(new TParameter<>("DCenter3Code", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("PageFilter", pageFilter));
        return showSP("AccGetTafsiliDesc", tParameters, true);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "tafsiliID", "tafsiliID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "tafsiliCode", "کد", Type.STRING, 150, true, true, false));
        cols.add(new Col(null, "tafsiliDesc", "شرح", Type.STRING, 150, true, true, false));

        return new Meta(cols);

    }
}
