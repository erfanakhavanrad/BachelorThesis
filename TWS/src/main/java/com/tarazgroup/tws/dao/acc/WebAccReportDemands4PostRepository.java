package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.WebAccReportDemands4Post;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Erfan Akhavan
 */
public interface WebAccReportDemands4PostRepository extends TCrudRepository<WebAccReportDemands4Post>, CrudRepository<WebAccReportDemands4Post, BigDecimal> {

    default List<WebAccReportDemands4Post> accWebShowReportDemands(Integer yearNo, Integer monthNo) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("YearNo", yearNo));
        tParameters.add(new TParameter<>("MonthNo", monthNo));
        return showSP("Web_AccReport_Demands_4Post", tParameters, true);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "serverName", "نام سرور", Type.STRING, 150, true, true, false));
        cols.add(new Col(null, "vahedEjraei", "واحد اجرایی", Type.STRING, 150, true, true, false));
        cols.add(new Col(null, "mandeMotalebatPayanDoreSale99", "مانده مطالبات پایان دوره سال 99", Type.DECIMAL, 150, true, true, false));
        cols.add(new Col(null, "mandeMotalebatAzMahGhablSanavati", "مانده مطالبات از ماه قبل|سنواتی", Type.DECIMAL, 150, true, true, false));
        cols.add(new Col(null, "mandeMotalebatAzMahGhablJari", "مانده مطالبات از ماه قبل|جاری", Type.DECIMAL, 150, true, true, false));
        cols.add(new Col(null, "ijadTeyMah", "ایجاد طی ماه", Type.DECIMAL, 150, true, true, false));
        cols.add(new Col(null, "vosoolTeyMahSanavati", "وصولی طی ماه|سنواتی", Type.DECIMAL, 150, true, true, false));
        cols.add(new Col(null, "vosoolTeyMahJari", "وصولی طی ماه|جاری", Type.DECIMAL, 150, true, true, false));
        cols.add(new Col(null, "MablaghMashmoolBimeDarGoroohMofasa", "مبلغ مشمول بیمه در گروه مفاصا حساب", Type.DECIMAL, 150, true, true, false));
        cols.add(new Col(null, "mablaghHosnAnjgamKar", "مبلغ حسن انجام کار", Type.DECIMAL, 150, true, true, false));
        cols.add(new Col(null, "motalebatMashcookVosool", "مطالبات مشکوک الوصول", Type.DECIMAL, 150, true, true, false));
        cols.add(new Col(null, "motalebatLaVosool", "مطالبات لاوصول", Type.DECIMAL, 150, true, true, false));
        cols.add(new Col(null, "tedadGharardad", "تعداد قرارداد", Type.INTEGER, 150, true, true, false));
        cols.add(new Col(null, "vosoliTeyMahJamKolVosooli", "وصولی طی ماه|جمع کل وصولی", Type.DECIMAL, 150, true, true, false));
        cols.add(new Col(null, "mandeSanavati", "مانده|سنواتی", Type.DECIMAL, 150, true, true, false));
        cols.add(new Col(null, "mandeJAri", "مانده|جاری", Type.DECIMAL, 150, true, true, false));
        cols.add(new Col(null, "mandeKhalesMotalebat", "مانده خالص مطالبات", Type.DECIMAL, 150, true, true, false));
        return new Meta(cols);
    }

    default InputStreamResource excel(Integer yearNo, Integer monthNo) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("YearNo", yearNo));
        tParameters.add(new TParameter<>("MonthNo", monthNo));
        List<WebAccReportDemands4Post> rows = showSP("Web_AccReport_Demands_4Post", tParameters, false);
        return exportToExcel(rows, meta().getCols(), "فرم ها");
    }


}
