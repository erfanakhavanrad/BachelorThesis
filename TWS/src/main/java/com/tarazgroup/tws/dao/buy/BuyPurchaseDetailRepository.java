package com.tarazgroup.tws.dao.buy;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.buy.BuyPurchaseDetail;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public interface BuyPurchaseDetailRepository extends TCrudRepository<BuyPurchaseDetail>, CrudRepository<BuyPurchaseDetail, BigDecimal> {

    default List<BuyPurchaseDetail> buyShowPurchaseDetailByID(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<TParameter<?>>();
        tParameters.add(new TParameter<>("Filter", "AND main.VoucherHeaderID=" + voucherHeaderID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("ShowRemain", null));
        tParameters.add(new TParameter<>("VoucherTypeID", null));
        tParameters.add(new TParameter<>("RefTypeID", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("BuyShowPurchaseDetail", tParameters, true);
    }

    default List<BuyPurchaseDetail> buyShowPurchaseDetailByID(
            String ip,
            String port,
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
        tParameters.add(new TParameter<>("PageFilter", null));

        List<BuyPurchaseDetail> buyPurchaseDetails =  showSP("BuyShowPurchaseDetail", tParameters, true);


        File fileStaticImagesGoods;
        try {
            fileStaticImagesGoods = ResourceUtils.getFile("classpath:static/images/goods");
            File[] fileGoodsImageDirs = fileStaticImagesGoods.listFiles();
            String[] goodsImageDirNames = fileStaticImagesGoods.list();
            for (int i = 0; i < fileGoodsImageDirs.length; i++) {
                String[] goodsImageFileNames = fileGoodsImageDirs[i].list();
                Arrays.sort(goodsImageFileNames);
                List<String> imageUrls = imageUrls(ip, port, goodsImageDirNames[i], goodsImageFileNames);
                for (int j = 0; j < buyPurchaseDetails.size(); j++) {
                    BuyPurchaseDetail buyPurchaseDetail = buyPurchaseDetails.get(j);
                    if (buyPurchaseDetail.getGoodsID().toString().equals(goodsImageDirNames[i])) {
                        buyPurchaseDetail.setImageUrls(imageUrls);
//                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return buyPurchaseDetails;
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

    default List<BuyPurchaseDetail> buyShowPurchaseDetailRefer(
            String ip, String port,
            BigDecimal voucherTypeID,
            BigDecimal refTypeID,
            BigDecimal groupID,
            BuyPurchaseDetail buyPurchaseDetail) {
        // نمایش کلیه ردیف های یک نوع مرجع خاص است
        String filter = "";
        if (groupID != null) {
            filter += " AND GG.GroupID=" + groupID;
        }
        List<TParameter<?>> tParameters = new ArrayList<TParameter<?>>();
        tParameters.add(new TParameter<>("Filter", filter));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", buyPurchaseDetail._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", buyPurchaseDetail._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("ShowRemain", true));
        tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        tParameters.add(new TParameter<>("RefTypeID", refTypeID));
        tParameters.add(new TParameter<>("PageFilter", buyPurchaseDetail._pageFilter()));

        List<BuyPurchaseDetail> buyPurchaseDetails =  showSP("BuyShowPurchaseDetail", tParameters, true);


        File fileStaticImagesGoods;
        try {
            fileStaticImagesGoods = ResourceUtils.getFile("classpath:static/images/goods");
            File[] fileGoodsImageDirs = fileStaticImagesGoods.listFiles();
            String[] goodsImageDirNames = fileStaticImagesGoods.list();
            for (int i = 0; i < fileGoodsImageDirs.length; i++) {
                String[] goodsImageFileNames = fileGoodsImageDirs[i].list();
                Arrays.sort(goodsImageFileNames);
                List<String> imageUrls = imageUrls(ip, port, goodsImageDirNames[i], goodsImageFileNames);
                for (int j = 0; j < buyPurchaseDetails.size(); j++) {
                    BuyPurchaseDetail buyPurchaseDetail1 = buyPurchaseDetails.get(j);
                    if (buyPurchaseDetail1.getGoodsID().toString().equals(goodsImageDirNames[i])) {
                        buyPurchaseDetail1.setImageUrls(imageUrls);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return buyPurchaseDetails;
        }
    }
}
