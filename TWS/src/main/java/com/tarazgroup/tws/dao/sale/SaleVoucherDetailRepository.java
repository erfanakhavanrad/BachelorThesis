package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.sale.SaleVoucherDetail;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public interface SaleVoucherDetailRepository extends TCrudRepository<SaleVoucherDetail>, CrudRepository<SaleVoucherDetail, BigDecimal> {

    default List<SaleVoucherDetail> saleShowVoucherDetailByID(
            BigDecimal voucherHeaderID,
            boolean showRemain,
            BigDecimal voucherTypeID,
            BigDecimal refTypeID) {
        List<TParameter<?>> tParameters = new ArrayList<TParameter<?>>();
        tParameters.add(new TParameter<>("Filter", "AND main.VoucherHeaderID=" + voucherHeaderID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("ShowRemain", showRemain));
        tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        tParameters.add(new TParameter<>("RefTypeID", refTypeID));
        tParameters.add(new TParameter<>("PageFilter", "?,?"));
        return showSP("SaleShowVoucherDetail", tParameters, true);
    }

    default List<SaleVoucherDetail> saleShowVoucherDetailRefer(
            String ip, String port,
            BigDecimal storeID,
            BigDecimal voucherTypeID,
            BigDecimal refTypeID
    ) {
        // نمایش کلیه ردیف های یک نوع مرجع خاص است
        String filter = " AND ISNULL(Canceling.IsCancel,0) = 0 AND LastStat.VoucherStatID = 4 and Main.VoucherTypeID = " + refTypeID + " and Main.StoreID = " + storeID;
        List<TParameter<?>> tParameters = new ArrayList<TParameter<?>>();
        tParameters.add(new TParameter<>("Filter", filter));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", " AND Main.ServerID in (1)"));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("ShowRemain", true));
        tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        tParameters.add(new TParameter<>("RefTypeID", refTypeID));
        tParameters.add(new TParameter<>("PageFilter", " AND _RemainQ>0?,?"));

        List<SaleVoucherDetail> saleVoucherDetail = showSP("SaleShowVoucherDetail", tParameters, true);


        File fileStaticImagesGoods;
        try {
            fileStaticImagesGoods = ResourceUtils.getFile("classpath:static/images/goods");
            File[] fileGoodsImageDirs = fileStaticImagesGoods.listFiles();
            String[] goodsImageDirNames = fileStaticImagesGoods.list();
            for (int i = 0; i < fileGoodsImageDirs.length; i++) {
                String[] goodsImageFileNames = fileGoodsImageDirs[i].list();
                Arrays.sort(goodsImageFileNames);
                List<String> imageUrls = imageUrls(ip, port, goodsImageDirNames[i], goodsImageFileNames);
                for (int j = 0; j < saleVoucherDetail.size(); j++) {
                    SaleVoucherDetail saleVoucherDetail1 = saleVoucherDetail.get(j);
                    if (saleVoucherDetail1.getGoodsID().toString().equals(goodsImageDirNames[i])) {
                        saleVoucherDetail1.setImageUrls(imageUrls);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return saleVoucherDetail;
        }
    }

    default List<String> imageUrls(String ip, String port, String directoryName, String[] goodsImageFileNames) {
        List<String> imageUrls = new ArrayList<>();
        for (int i = 0; i < goodsImageFileNames.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://");
            stringBuilder.append(ip);
            stringBuilder.append(":");
            stringBuilder.append(port);
            stringBuilder.append("/tws/images/goods/");
            stringBuilder.append(directoryName);
            stringBuilder.append("/");
            stringBuilder.append(goodsImageFileNames[i]);
            imageUrls.add(stringBuilder.toString());
        }
        return imageUrls;
    }


}


