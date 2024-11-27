package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvVoucherDetail;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
public interface InvVoucherDetailRepository extends TCrudRepository<InvVoucherDetail>, CrudRepository<InvVoucherDetail, BigDecimal> {

    default List<InvVoucherDetail> invShowVoucherDetailByID(
            BigDecimal voucherHeaderID,
            boolean showRemain,
            BigDecimal voucherTypeID,
            BigDecimal refTypeID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", "AND main.VoucherHeaderID=" + voucherHeaderID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("ShowRemain", showRemain));
        tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        tParameters.add(new TParameter<>("RefTypeID", refTypeID));
        tParameters.add(new TParameter<>("PageFilter", null));
        tParameters.add(new TParameter<>("StoreID", null));
        return showSP("InvShowVoucherDetail", tParameters, true);
    }

    default List<InvVoucherDetail> invShowVoucherDetailReferWithoutImage(
            BigDecimal storeID,
            BigDecimal voucherTypeID,
            BigDecimal refTypeID) {
        // این متد ردیف هایی را بر میگرداند که عکس را شامل نمیشود
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND (Main.StoreID = " +
                storeID + " or Main.ToStoreID = " + storeID +
                ") and LastStat.VoucherStatID = 4 and Main.VoucherTypeID = " +
                refTypeID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("ShowRemain", true));
        tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        tParameters.add(new TParameter<>("RefTypeID", refTypeID));
        tParameters.add(new TParameter<>("PageFilter", null));
        tParameters.add(new TParameter<>("StoreID", storeID));
        return showSP("InvShowVoucherDetail", tParameters, true);
    }

    default List<InvVoucherDetail> invShowVoucherDetailRefer(
            String ip, String port,
            BigDecimal voucherTypeID,
            BigDecimal refTypeID,
            BigDecimal storeID,
            BigDecimal groupID,
            String goodsDesc,
            String goodsCode,
            InvVoucherDetail invVoucherDetail) {
        // نمایش کلیه ردیف های یک نوع مرجع خاص است
        String pageFilter = "";
        if (goodsCode != null) {
            pageFilter += " AND goodsCode LIKE N'%" + goodsCode + "%'";
        }
        if (goodsDesc != null) {
            pageFilter += " AND goodsDesc LIKE N'%" + goodsDesc + "%'";
        }
        pageFilter += "?,?goodsDesc";
        String filter = " AND LastStat.VoucherStatID = 4 AND Main.VoucherTypeID = " + refTypeID;
        if (groupID != null) {
            filter += " AND GGroup.GroupID=" + groupID;
        }
        List<TParameter<?>> tParameters = new ArrayList<TParameter<?>>();
        tParameters.add(new TParameter<>("Filter", filter));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invVoucherDetail._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invVoucherDetail._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("ShowRemain", true));
        tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        tParameters.add(new TParameter<>("RefTypeID", refTypeID));
        tParameters.add(new TParameter<>("PageFilter", pageFilter));
        tParameters.add(new TParameter<>("StoreID", storeID));

        List<InvVoucherDetail> invVoucherDetails = showSP("InvShowVoucherDetail", tParameters, true);


        File fileStaticImagesGoods;
        try {
            fileStaticImagesGoods = ResourceUtils.getFile("classpath:static/images/goods");
            File[] fileGoodsImageDirs = fileStaticImagesGoods.listFiles();
            String[] goodsImageDirNames = fileStaticImagesGoods.list();
            for (int i = 0; i < fileGoodsImageDirs.length; i++) {
                String[] goodsImageFileNames = fileGoodsImageDirs[i].list();
                Arrays.sort(goodsImageFileNames);
                List<String> imageUrls = imageUrls(ip, port, goodsImageDirNames[i], goodsImageFileNames);
                for (int j = 0; j < invVoucherDetails.size(); j++) {
                    InvVoucherDetail invVoucherDetail1 = invVoucherDetails.get(j);
                    if (invVoucherDetail1.getGoodsID().toString().equals(goodsImageDirNames[i])) {
                        invVoucherDetail1.setImageUrls(imageUrls);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return invVoucherDetails;
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
