package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.ShowSPReturnType;
import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.sale.SaleCrystalRepVoucher;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public interface SaleCrystalRepVoucherRepository extends TCrudRepository<SaleCrystalRepVoucher>, CrudRepository<SaleCrystalRepVoucher, BigDecimal> {


    default List<Map<String, Object>> saleCrystalRepVoucher(
            String filter,
            String otherFilter,
            String serverFilter,
            String yearFilter,
            String userAccessFilter,
            BigDecimal voucherTypeID
    ) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", filter));
        tParameters.add(new TParameter<>("OtherFilter", otherFilter));
        tParameters.add(new TParameter<>("ServerFilter", serverFilter));
        tParameters.add(new TParameter<>("YearFilter", yearFilter));
        tParameters.add(new TParameter<>("UserAccessFilter", userAccessFilter));
        tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        List<Map<String, Object>> rows = execSPNativeQuery(SaleCrystalRepVoucher.class, "Sale_CrystalRep_Voucher", tParameters, ShowSPReturnType.MAP);
        return rows;
    }

    default InputStreamResource reportPDF(BigDecimal voucherHeaderID) {
        // چون این متد برای اندروید نوشته شده
        // تنها گزارش مربوط به یک سند خاص مد نظر است
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.VoucherHeaderID=" + voucherHeaderID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("VoucherTypeID", null));
        HashMap<String, Object> parameterFields = new HashMap();
        return exportCrystalReportToPDF(SaleCrystalRepVoucher.class, "Sale_CrystalRep_Voucher", parameterFields, tParameters, ShowSPReturnType.MAP);
    }

    default InputStreamResource excel(BigDecimal voucherHeaderID) {
        // چون این متد برای اندروید نوشته شده
        // تنها گزارش مربوط به یک سند خاص مد نظر است
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.VoucherHeaderID=" + voucherHeaderID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("VoucherTypeID", null));
        List<Map<String, Object>> rows = execSPNativeQuery(SaleCrystalRepVoucher.class, "Sale_CrystalRep_Voucher", tParameters, ShowSPReturnType.MAP);
        return exportToExcel(rows, meta().getCols(), "سند فروش");
    }
    default Meta meta() {
        // این متا برای استفاده در گزارش اکسل ایجا شده است
        // به خاطر همین برای استفاده در فرم فرانت اند باید متای دیگری ساخته شود
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "VoucherDetailID", "VoucherDetailID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "VoucherHeaderID", "VoucherHeaderID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "VoucherTypeDesc", "نوع سند", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "GoodsDesc", "نام کالا", Type.STRING, 250, true, true, false));
        cols.add(new Col(null, "Fee", "فی", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "Quantity", "تعداد", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "UnitName", "واحد فرعی", Type.STRING, 150, true, true, false));
        cols.add(new Col(null, "ComputeValue", "ضریب", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "RowPrice", "قیمت", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "MainUnitName", "واحد اصلی", Type.STRING, 150, true, true, false));
        cols.add(new Col(null, "شماره سند", "شماره سند", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "VoucherDate", "تاریخ سند", Type.STRING, 130, true, true, false));
        cols.add(new Col(null, "PerComTitle", "عنوان", Type.STRING, 150, true, true, false));
        cols.add(new Col(null, "PerComFName", "نام", Type.STRING, 200, true, true, false));
        cols.add(new Col(null, "PerComLName", "نام خانوادگی", Type.STRING, 200, true, true, false));
        cols.add(new Col(null, "PerComAddress", "آدرس", Type.STRING, 350, true, true, false));
        cols.add(new Col(null, "VoucherDesc", "شرح", Type.STRING, 200, true, true, false));
        cols.add(new Col(null, "SalesManName", "فروشنده", Type.STRING, 120, true, true, false));
        cols.add(new Col(null, "MarketingManName", "بازاریاب", Type.STRING, 120, true, true, false));
        return new Meta(cols);
    }

}
