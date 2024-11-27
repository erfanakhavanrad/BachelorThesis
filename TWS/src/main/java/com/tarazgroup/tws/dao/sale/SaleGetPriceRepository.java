package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dao.pub.PubYearsRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.pub.PubYears;
import com.tarazgroup.tws.model.sale.SaleGetPrice;
import com.tarazgroup.tws.model.sale.SaleVoucherDefault;
import com.tarazgroup.tws.util.exception.TNoContentException;
import com.tarazgroup.tws.util.global.SortField;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
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
public interface SaleGetPriceRepository extends TCrudRepository<SaleGetPrice>, CrudRepository<SaleGetPrice, BigDecimal> {

    default List<SaleGetPrice> saleGetPrice(BigDecimal goodsID,
            String ip,
            String port,
            ServletWebServerApplicationContext servletWebServerApplicationContext,
            SaleVoucherDefaultRepository saleVoucherDefaultRepository,
            PubYearsRepository pubYearsRepository,
            BigDecimal customerClassID,
            BigDecimal salesClassID,
            BigDecimal marketingClassID,
            String voucherDate,
            String goodsCode,
            BigDecimal customerID,
            String barCode,
            String goodsDesc,
            BigDecimal groupID,
            BigDecimal voucherTypeID,
            BigDecimal storeID,
            Boolean isOnlyFree,
            Boolean isWithImage,
            BigDecimal buyTypeID,
            BigDecimal paymentWayID,
            Boolean isByStore,
            Boolean isOnlyRemain,
            BigDecimal marketingManID,
            Boolean isNotHasRemain,
            Boolean hasPrice,
            BigDecimal pageNumber,
            BigDecimal recordCount,
            String sortFieldName,
            Boolean sortFieldDesc
    ) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        SaleVoucherDefault saleVoucherDefault;
        List<SaleVoucherDefault> saleVoucherDefaults = saleVoucherDefaultRepository.saleVoucherDefaultLoggedInUser(voucherTypeID, false);
        if (saleVoucherDefaults.isEmpty()) {
            // این اس پی حتما به سیل ووچر دیفالت نیاز دارد و اگر خالی باشد یکسری پارامتر ها خالی به اس پی پاس داده میشود
            // ممکن است این مسیله در سیستم فروش مشکل ساز شود ولی در سیستم انبار مشکلی نیست
//            throw new TNoContentException();
            saleVoucherDefault = new SaleVoucherDefault();
        } else {
            saleVoucherDefault = saleVoucherDefaults.get(0);
        }

        PubYears pubYears = pubYearsRepository.pubShowYearsByYearID(logLogins.getPubUser().getActiveYearID());
        if (pubYears == null) {
            throw new TNoContentException();
        }


        String pageFilter = "";
        if (hasPrice != null && hasPrice) {
            pageFilter += " AND main.price > 0";
        }
//
        if (isOnlyRemain != null && isOnlyRemain) {
            pageFilter += " AND main.Remain IS NOT NULL AND main.Remain > 0";
        }


        if (barCode != null && !barCode.equals("")) {
            pageFilter += " AND main.barCode = '" + barCode + "'";
        }

        if (goodsID != null && !goodsID.equals("")) {
            pageFilter += " AND main.goodsID = '" + goodsID + "'";
        }

        if (goodsDesc != null && !goodsDesc.equals("")) {
            pageFilter += " AND main.goodsDesc LIKE '%" + goodsDesc + "%'";
        }

        if (groupID != null && !groupID.toString().equals("")) {
            pageFilter += " AND main.groupID = " + groupID;
        }

        if (pageNumber == null || recordCount == null) {
            pageFilter += "?,";
        } else {
            pageFilter += "?" + pageNumber + "," + recordCount;
        }


        SortField sortField = new SortField();
        if (sortFieldDesc !=null && sortFieldName != null) {
            sortField.setName(sortFieldName);
            sortField.setDesc(sortFieldDesc);

            if (sortField != null && sortField.getName() != null && !sortField.getName().isEmpty()) {
                pageFilter += "?";
                pageFilter += sortField.getName();
                if (sortField.isDesc()) {
                    pageFilter += " ";
                    pageFilter += "DESC";
                }
            }

        } else {
            System.out.println("Either SortFieldName or SortFieldDesc passed as null");
        }
//
//        if (sortField != null && sortField.getName() != null && !sortField.getName().isEmpty()) {
//            _pageFilter.append(sortField.getName());
//            if (sortField.isDesc()) {
//                _pageFilter.append(" ").append("DESC");
//            }
//        }
//        return _pageFilter.toString();


        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("SaleCenterID", saleVoucherDefault.getSaleCenterID()));
        tParameters.add(new TParameter<>("DeliverCenterID", saleVoucherDefault.getDeliverCenterID()));
        tParameters.add(new TParameter<>("CustomerClassID", customerClassID));
        tParameters.add(new TParameter<>("SalesClassID", salesClassID));
        tParameters.add(new TParameter<>("MarketingClassID", marketingClassID));
        tParameters.add(new TParameter<>("SaleTypeID", saleVoucherDefault.getSaleTypeID()));
        tParameters.add(new TParameter<>("VoucherDate", voucherDate));
        tParameters.add(new TParameter<>("StoreID", storeID));
        tParameters.add(new TParameter<>("GoodsCode", goodsCode));
        tParameters.add(new TParameter<>("FromDate", pubYears.getStartShamsiDate()));
        tParameters.add(new TParameter<>("YearID", logLogins.getPubUser().getActiveYearID()));
        tParameters.add(new TParameter<>("CustomerID", customerID));
        tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        tParameters.add(new TParameter<>("IsOnlyFee", isOnlyFree));
        tParameters.add(new TParameter<>("IsWithImage", isWithImage));
        tParameters.add(new TParameter<>("BuyTypeID", buyTypeID));
        tParameters.add(new TParameter<>("PaymentWayID", paymentWayID == null ? new BigDecimal(28) : paymentWayID));
        tParameters.add(new TParameter<>("PageFilter", pageFilter));
        tParameters.add(new TParameter<>("IsByStore", isByStore));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("IsOnlyRemain", null));
        tParameters.add(new TParameter<>("MarketingManID", marketingManID));
        tParameters.add(new TParameter<>("IsNotHasRemain", isNotHasRemain));
        List<SaleGetPrice> saleGetPrices = showSP("SaleGetPrice", tParameters, true);


        File fileStaticImagesGoods;
        try {
            fileStaticImagesGoods = ResourceUtils.getFile("classpath:static/images/goods");
            File[] fileGoodsImageDirs = fileStaticImagesGoods.listFiles();
            String[] goodsImageDirNames = fileStaticImagesGoods.list();
            for (int i = 0; i < fileGoodsImageDirs.length; i++) {
                String[] goodsImageFileNames = fileGoodsImageDirs[i].list();
                Arrays.sort(goodsImageFileNames);
                List<String> imageUrls = imageUrls(ip, port, goodsImageDirNames[i], goodsImageFileNames);
                for (int j = 0; j < saleGetPrices.size(); j++) {
                    SaleGetPrice saleGetPrice = saleGetPrices.get(j);
                    if (saleGetPrice.getGoodsID().toString().equals(goodsImageDirNames[i])) {
                        saleGetPrice.setImageUrls(imageUrls);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return saleGetPrices;
        }
    }

/** ******************************************************************************************************************* */
//default List<SaleGetPrice> saleGetPriceWithGoodsID(BigDecimal goodsID,
//        String ip,
//        String port,
//        ServletWebServerApplicationContext servletWebServerApplicationContext,
//        SaleVoucherDefaultRepository saleVoucherDefaultRepository,
//        PubYearsRepository pubYearsRepository,
//        BigDecimal customerClassID,
//        BigDecimal salesClassID,
//        BigDecimal marketingClassID,
//        String voucherDate,
//        String goodsCode,
//        BigDecimal customerID,
//        String barCode,
//        String goodsDesc,
//        BigDecimal groupID,
//        BigDecimal voucherTypeID,
//        BigDecimal storeID,
//        Boolean isOnlyFree,
//        Boolean isWithImage,
//        BigDecimal buyTypeID,
//        BigDecimal paymentWayID,
//        Boolean isByStore,
//        Boolean isOnlyRemain,
//        BigDecimal marketingManID,
//        Boolean isNotHasRemain,
//        Boolean hasPrice,
//        BigDecimal pageNumber,
//        BigDecimal recordCount
//) {
//    List<TParameter<?>> tParameters = new ArrayList<>();
//    LogLogins logLogins = fetchUserDetail();
//    SaleVoucherDefault saleVoucherDefault;
//    List<SaleVoucherDefault> saleVoucherDefaults = saleVoucherDefaultRepository.saleVoucherDefaultLoggedInUser(voucherTypeID, false);
//    if (saleVoucherDefaults.isEmpty()) {
//        // این اس پی حتما به سیل ووچر دیفالت نیاز دارد و اگر خالی باشد یکسری پارامتر ها خالی به اس پی پاس داده میشود
//        // ممکن است این مسیله در سیستم فروش مشکل ساز شود ولی در سیستم انبار مشکلی نیست
////            throw new TNoContentException();
//        saleVoucherDefault = new SaleVoucherDefault();
//    } else {
//        saleVoucherDefault = saleVoucherDefaults.get(0);
//    }
//
//    PubYears pubYears = pubYearsRepository.pubShowYearsByYearID(logLogins.getPubUser().getActiveYearID());
//    if (pubYears == null) {
//        throw new TNoContentException();
//    }
//
//
//    String pageFilter = "";
//    if (hasPrice != null && hasPrice) {
//        pageFilter += " AND main.price > 0";
//    }
////
//    if (isOnlyRemain != null && isOnlyRemain) {
//        pageFilter += " AND main.Remain IS NOT NULL AND main.Remain > 0";
//    }
//
//
//    if (barCode != null && !barCode.equals("")) {
//        pageFilter += " AND main.barCode = '" + barCode + "'";
//    }
//
//    if (goodsDesc != null && !goodsDesc.equals("")) {
//        pageFilter += " AND main.goodsDesc LIKE '%" + goodsDesc + "%'";
//    }
//
//    if (groupID != null && !groupID.toString().equals("")) {
//        pageFilter += " AND main.groupID = " + groupID;
//    }
//
//    if (pageNumber == null || recordCount == null) {
//        pageFilter += "?,";
//    } else {
//        pageFilter += "?" + pageNumber + "," + recordCount;
//    }
//
//
//    tParameters.add(new TParameter<>("Filter", null));
//    tParameters.add(new TParameter<>("SaleCenterID", saleVoucherDefault.getSaleCenterID()));
//    tParameters.add(new TParameter<>("DeliverCenterID", saleVoucherDefault.getDeliverCenterID()));
//    tParameters.add(new TParameter<>("CustomerClassID", customerClassID));
//    tParameters.add(new TParameter<>("SalesClassID", salesClassID));
//    tParameters.add(new TParameter<>("MarketingClassID", marketingClassID));
//    tParameters.add(new TParameter<>("SaleTypeID", saleVoucherDefault.getSaleTypeID()));
//    tParameters.add(new TParameter<>("VoucherDate", voucherDate));
//    tParameters.add(new TParameter<>("StoreID", storeID));
//    tParameters.add(new TParameter<>("GoodsCode", goodsCode));
//    tParameters.add(new TParameter<>("FromDate", pubYears.getStartShamsiDate()));
//    tParameters.add(new TParameter<>("YearID", logLogins.getPubUser().getActiveYearID()));
//    tParameters.add(new TParameter<>("CustomerID", customerID));
//    tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
//    tParameters.add(new TParameter<>("IsOnlyFee", isOnlyFree));
//    tParameters.add(new TParameter<>("IsWithImage", isWithImage));
//    tParameters.add(new TParameter<>("BuyTypeID", buyTypeID));
//    tParameters.add(new TParameter<>("PaymentWayID", paymentWayID == null ? new BigDecimal(28) : paymentWayID));
//    tParameters.add(new TParameter<>("PageFilter", pageFilter));
//    tParameters.add(new TParameter<>("IsByStore", isByStore));
//    tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
//    tParameters.add(new TParameter<>("IsOnlyRemain", null));
//    tParameters.add(new TParameter<>("MarketingManID", marketingManID));
//    tParameters.add(new TParameter<>("IsNotHasRemain", isNotHasRemain));
//    List<SaleGetPrice> saleGetPrices = showSP("SaleGetPrice", tParameters, true);
//
//
//    File fileStaticImagesGoods;
//    try {
//        fileStaticImagesGoods = ResourceUtils.getFile("classpath:static/images/goods");
//        File[] fileGoodsImageDirs = fileStaticImagesGoods.listFiles();
//        String[] goodsImageDirNames = fileStaticImagesGoods.list();
//        for (int i = 0; i < fileGoodsImageDirs.length; i++) {
//            String[] goodsImageFileNames = fileGoodsImageDirs[i].list();
//            Arrays.sort(goodsImageFileNames);
//            List<String> imageUrls = imageUrls(ip, port, goodsImageDirNames[i], goodsImageFileNames);
//            for (int j = 0; j < saleGetPrices.size(); j++) {
//                SaleGetPrice saleGetPrice = saleGetPrices.get(j);
//                if (saleGetPrice.getGoodsID().toString().equals(goodsImageDirNames[i])) {
//                    saleGetPrice.setImageUrls(imageUrls);
//                    break;
//                }
//            }
//        }
//    } catch (IOException e) {
//        e.printStackTrace();
//    } finally {
//        return saleGetPrices;
//    }
//}

/** ***************************************************************************************************** */

    //     By ID
//    default SaleGetPrice saleGetPrice(BigDecimal goodsID) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("Filter", " AND Main.goodsID=" + goodsID));
//        tParameters.add(new TParameter<>("SaleCenterID", null));
//        tParameters.add(new TParameter<>("DeliverCenterID", null));
//        tParameters.add(new TParameter<>("CustomerClassID", null));
//        tParameters.add(new TParameter<>("SalesClassID", null));
//        tParameters.add(new TParameter<>("MarketingClassID", null));
//        tParameters.add(new TParameter<>("SaleTypeID", null));
//        tParameters.add(new TParameter<>("VoucherDate", null));
//        tParameters.add(new TParameter<>("StoreID", null));
//        tParameters.add(new TParameter<>("GoodsCode", null));
//        tParameters.add(new TParameter<>("FromDate", null));
//        tParameters.add(new TParameter<>("YearID", null));
//        tParameters.add(new TParameter<>("CustomerID", null));
//        tParameters.add(new TParameter<>("VoucherTypeID", null));
//        tParameters.add(new TParameter<>("IsOnlyFee", null));
//        tParameters.add(new TParameter<>("IsWithImage", null));
//        tParameters.add(new TParameter<>("BuyTypeID", null));
//        tParameters.add(new TParameter<>("PaymentWayID", null));
//        tParameters.add(new TParameter<>("PageFilter", null));
//        tParameters.add(new TParameter<>("IsByStore", null));
//        tParameters.add(new TParameter<>("UserID", null));
//        tParameters.add(new TParameter<>("IsOnlyRemain", null));
//        tParameters.add(new TParameter<>("MarketingManID", null));
//        tParameters.add(new TParameter<>("IsNotHasRemain", null));
//        return showSP("SaleGetPrice", tParameters, true).get(0);
//    }

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

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "goodsID", "goodsID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "priceListID", "priceListID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "unitId", "unitId", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "lastListSaleFee", "lastListSaleFee", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "lastSaleFee", "lastSaleFee", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "techInfo", "techInfo", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "storeID", "storeID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "storeCode", "storeCode", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "storeName", "storeName", Type.STRING, 200, false, false, false));
        cols.add(new Col(null, "baseFee", "baseFee", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "price1", "price1", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "price2", "price2", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "buyPrice", "buyPrice", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "buyPrice1", "buyPrice1", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "buySecUnitID1", "buySecUnitID1", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "lastBuyFee", "lastBuyFee", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "defaultSecUnitID", "defaultSecUnitID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "secUnitID", "secUnitID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "secUnitID2", "secUnitID2", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "secUnitDesc", "secUnitDesc", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "remain", "remain", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "secRemain", "secRemain", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "lastListBuyFee", "lastListBuyFee", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "differentialID", "differentialID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "differentialDesc", "differentialDesc", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "serialType", "serialType", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "serialDesc", "serialDesc", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "groupID", "groupID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "groupCode", "groupCode", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "groupDesc", "groupDesc", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "typeDesc", "typeDesc", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "latinDesc", "latinDesc", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "customTarrifNo", "customTarrifNo", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "goodsBriefName", "goodsBriefName", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "isbasket", "isbasket", Type.BOOLEAN, 0, false, false, false));
        cols.add(new Col(null, "otherBarCode", "otherBarCode", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "goodsDiscountPercent", "goodsDiscountPercent", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "goodsDiscountPrice", "goodsDiscountPrice", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "selType", "selType", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "isQuantitativeDesc", "isQuantitativeDesc", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "quantitative", "quantitative", Type.BOOLEAN, 0, false, false, false));
        cols.add(new Col(null, "fixFee", "fixFee", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "goodsCode", "کد کالا", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "goodsDesc", "شرح کالا", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "price", "قیمت", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "barCode", "بارکد کالا", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "unitDesc", "واحد اصلی کالا", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "secUnitName", "واحد فرعی کالا", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "computeValue", "ضریب", Type.DECIMAL, 100, true, true, false));
        return new Meta(cols);
    }

}


//try {
//        fileStaticImagesGoods = ResourceUtils.getFile("classpath:static/images/goods");
//        File[] fileGoodsImageDirs = fileStaticImagesGoods.listFiles();
//        String[] goodsImageDirNames = fileStaticImagesGoods.list();
//        String ip = InetAddress.getLocalHost().getHostAddress();
//        int port = servletWebServerApplicationContext.getWebServer().getPort();
//        for (int i = 0; i < fileGoodsImageDirs.length; i++) {
//        String[] goodsImageFileNames = fileGoodsImageDirs[i].list();
//        Arrays.sort(goodsImageFileNames);
//        List<String> imageUrls = imageUrls(ip, port, goodsImageDirNames[i], goodsImageFileNames);
//
//        for (int j = 0; j < saleGetPrices.size(); j++) {
//        SaleGetPrice saleGetPrice = saleGetPrices.get(j);
//        if (saleGetPrice.getGoodsID().toString().equals(goodsImageDirNames[i])) {
//        saleGetPrice.setImageUrls(imageUrls);
//        break;
//        }
//        }
//        }
//        } catch (IOException e) {
//        e.printStackTrace();
//        } finally {
//        return saleGetPrices;
//        }
