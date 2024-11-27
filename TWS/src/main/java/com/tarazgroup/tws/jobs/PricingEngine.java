package com.tarazgroup.tws.jobs;

import com.tarazgroup.tws.dao.inv.InvVoucherDetailImageRepository;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
@Service
public class PricingEngine {
    static final Logger LOGGER = Logger.getLogger(PricingEngine.class.getName());

    final private InvVoucherDetailImageRepository invVoucherDetailImageRepository;

    public PricingEngine(InvVoucherDetailImageRepository invVoucherDetailImageRepository) {
        this.invVoucherDetailImageRepository = invVoucherDetailImageRepository;
    }

//    @Scheduled(initialDelay = 2000, fixedRate = 4000)
//    public void refreshPricingParameters() {
//        Random random = new Random();
//        LOGGER.info("computing price at " + random.nextInt());
//    }
//
//    @Scheduled(initialDelay = 2000, fixedRate = 4000)
//    public void buildPDFImageFeeRemain() {
//        // ریپورت
//        // InvShowVoucherDetail_Image_IFR.rpt
//        // یک ساعت یکبار بساز و در فولدر ریسورس قرار بده
//        invVoucherDetailImageRepository.reportPDF(
//                new BigDecimal(6001),
//                new BigDecimal(1262),
//                new BigDecimal(10000007),
//                null,
//                null,
//                null,
//                "inv/voucherdetail/InvShowVoucherDetail_Image_IFR"
//        );
//        //TODO
//        // InputStreamResource
//        // رو تبدیل به فایل پی دی اف کن و سیو کن ..
//        // dynamic / pdf
//    }

//    @Scheduled(initialDelay = 2000, fixedRate = 1000)
//    @Async
//    public void refreshPricingParameters() throws InterruptedException {
//        Random random = new Random();
//        LOGGER.info("computing price at "+ random.nextInt());
//        Thread.sleep(5000);
//    }
}
