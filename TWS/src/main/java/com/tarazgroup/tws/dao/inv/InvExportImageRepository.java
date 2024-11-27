package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.DriveType;
import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvExportImage;
import com.tarazgroup.tws.util.global.TCalendar;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Apr-26, 2022
 ***/
public interface InvExportImageRepository extends TCrudRepository<InvExportImage>, CrudRepository<InvExportImage, BigDecimal> {
    default InvExportImage invExportImage(String fromDate, String toDate, DriveType driveName) {

        TCalendar tCalendarFromDate = new TCalendar();
        tCalendarFromDate.setIranianDateBySlash(fromDate);

        TCalendar tCalendarToDate = new TCalendar();
        tCalendarToDate.setIranianDateBySlash(toDate);

        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FromDate", tCalendarFromDate.getGregorianDateBySlashZero()));
        tParameters.add(new TParameter<>("ToDate", tCalendarToDate.getGregorianDateBySlashZero()));
        tParameters.add(new TParameter<>("DriveName", driveName.name()));

//        showSP("InvExportImage", tParameters, true);

//                getRuntime().
//                exec("cmd /c start \"\" run.bat");
//        try {
////            File rptFile = ResourceUtils.getFile("classpath:static/bat/run.sh");
//            File rptFile = ResourceUtils.getFile("classpath:static/bat/run.bat");
//            String path = rptFile.getAbsolutePath();
////            Runtime.getRuntime().exec("chmod -R 777 "+path);
//            Runtime.getRuntime().exec(path);
////            int g = 0;
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        return showSP("InvExportImage", tParameters, true).get(0);

    }
}
