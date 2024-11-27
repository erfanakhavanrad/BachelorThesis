package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.ShowSPReturnType;
import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvVoucherDetailImage;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public interface InvVoucherDetailImageRepository extends TCrudRepository<InvVoucherDetailImage>, CrudRepository<InvVoucherDetailImage, BigDecimal> {

    default InputStreamResource reportPDF(
            BigDecimal voucherTypeID,
            BigDecimal refTypeID,
            BigDecimal storeID,
            BigDecimal groupID,
            String goodsDesc,
            String goodsCode,
            String rptFileName
    ) {
        // نمایش کلیه ردیف های یک نوع مرجع خاص است
        String pageFilter = "";
        if (goodsCode != null) {
            pageFilter += " AND goodsCode LIKE N''%" + goodsCode + "%''";
        }
        if (goodsDesc != null) {
            pageFilter += " AND goodsDesc LIKE N''%" + goodsDesc + "%''";
        }
        pageFilter += "?,?goodsDesc";
        String filter = " AND LastStat.VoucherStatID = 4 AND Main.VoucherTypeID = " + refTypeID;
        if (groupID != null) {
            filter += " AND GGroup.GroupID=" + groupID;
        }
        List<TParameter<?>> tParameters = new ArrayList<TParameter<?>>();
        tParameters.add(new TParameter<>("Filter", filter));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("ShowRemain", true));
        tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        tParameters.add(new TParameter<>("RefTypeID", refTypeID));
        tParameters.add(new TParameter<>("PageFilter", pageFilter));
        tParameters.add(new TParameter<>("StoreID", storeID));

        HashMap<String, Object> parameterFields = new HashMap();
        return exportCrystalReportToPDF(InvVoucherDetailImage.class, rptFileName, parameterFields, tParameters, ShowSPReturnType.MAP);
    }
}
