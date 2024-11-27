package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvLevel;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.pub.PubXFieldsFormula;
import com.tarazgroup.tws.model.pub.PubXFieldsSetup;
import com.tarazgroup.tws.model.sale.SaleVoucherDetailLight;
import com.tarazgroup.tws.model.sale.SaleVoucherHeader;
import com.tarazgroup.tws.util.global.TCalendar;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.*;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public interface SaleVoucherDetailLightRepository extends TCrudRepository<SaleVoucherDetailLight>, CrudRepository<SaleVoucherHeader, BigDecimal> {

    default List<SaleVoucherDetailLight> saleShowVoucherDetailLightByID(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<TParameter<?>>();
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("SaleShowVoucherDetail_Light", tParameters, true);
    }


    default Meta meta(List<PubXFieldsSetup> pubXFieldsSetups, List<PubXFieldsFormula> pubXFieldsFormulas, List<InvLevel> invLevels) {
        LogLogins logLogins = fetchUserDetail();
        TCalendar tCalendar = new TCalendar();
        tCalendar.setGregorianDate(new Date());

        ArrayList<ColExtended> colsExtended = new ArrayList<>();
        colsExtended.add(new ColExtended("voucherDetailID", "voucherDetailID", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("voucherHeaderID", "voucherHeaderID", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("serverID", "serverID", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("goodsID", "goodsID", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("secondGoodsID", "secondGoodsID", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("secGoodsCode", "secGoodsCode", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("secGoodsDesc", "secGoodsDesc", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("quantity2", "quantity2", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("quantity3", "quantity3", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("quantity2Type", "quantity2Type", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("quantity3Type", "quantity3Type", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("secUnitID", "secUnitID", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("secUnitID2", "secUnitID2", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("secUnitID3", "secUnitID3", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("secUnitName2", "secUnitName2", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("secUnitName3", "secUnitName3", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("ratio2", "ratio2", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("ratio3", "ratio3", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("storeID", "storeID", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("dStoreCode", "dStoreCode", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("dStoreName", "dStoreName", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("center1ID", "center1ID", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("center2ID", "center2ID", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("center3ID", "center3ID", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("dCenter1Code", "dCenter1Code", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("dCenter2Code", "dCenter2Code", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("dCenter3Code", "dCenter3Code", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("dCenter1Desc", "dCenter1Desc", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("dCenter2Desc", "dCenter2Desc", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("dCenter3Desc", "dCenter3Desc", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("groupID", "groupID", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("groupCode", "groupCode", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("groupDesc", "groupDesc", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("serialID", "serialID", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("serialType", "serialType", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("serialDesc", "serialDesc", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("rRowMabPercent", "rRowMabPercent", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("rRowMabPrice", "rRowMabPrice", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("finalQuantity", "finalQuantity", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("finalQuantity2", "finalQuantity2", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("baseDReferID", "baseDReferID", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("dReferID", "dReferID", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("dReferNumber", "dReferNumber", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("dReferDate", "dReferDate", Type.DATE, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("lCReferID", "lCReferID", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("lCNo", "lCNo", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("lCOpenDate", "lCOpenDate", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("greenLicNo", "greenLicNo", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("greenLicDate", "greenLicDate", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("differentialID", "differentialID", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("differentialDesc", "differentialDesc", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("agrReferID", "agrReferID", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("agrNo", "agrNo", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("agrIndicatorNo", "agrIndicatorNo", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("invRefID", "invRefID", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("invRefDesc", "invRefDesc", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("feeFrieghtCharges", "feeFrieghtCharges", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("totalFeeFrieghtCharges", "totalFeeFrieghtCharges", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("kootajNo", "kootajNo", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("agreeTypeID", "agreeTypeID", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("isPromotion", "isPromotion", Type.BOOLEAN, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("rowPriceOLD", "rowPriceOLD", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("isFixFee", "isFixFee", Type.BOOLEAN, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("grossRowPrice", "grossRowPrice", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("techInfo", "techInfo", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("latinDesc", "latinDesc", Type.STRING, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("feeAgreement", "feeAgreement", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("feeDiscountPrice", "feeAfeeDiscountPricegreement", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("feeDiscountPercent", "feeDiscountPercent", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("taxMab", "taxMab", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("tollMab", "tollMab", Type.DECIMAL, 0, false, false, null, null, null, false, null, false, false, false, false, true));
        colsExtended.add(new ColExtended("computeType", "tollMab", Type.BOOLEAN, 0, false, false, null, null, null, false, null, false, false, false, false, true));


        SaleGoodsParams saleGoodsParams = new SaleGoodsParams(tCalendar.getIranianDateBySlashZero(), new BigDecimal(6001), logLogins.getPubUser().getUserID(), false);
        Origin originSaleGoods = new Origin("sale/goods", "goodsID", null, saleGoodsParams);
        PubXFieldsFormula pubXFieldsFormulaGoodsCode = pubXFieldsFormula(pubXFieldsFormulas, "goodsCode");
        colsExtended.add(new ColExtended("goodsCode", "کد کالا", Type.QKEY, 100, true, true, pubXFieldsFormulaGoodsCode == null ? null : pubXFieldsFormulaGoodsCode.getMCode(), null, null, false, originSaleGoods, true, false, false, false, false));
        colsExtended.add(new ColExtended("barCode", "بارکد کالا", Type.STRING, 100, true, true, null, null, null, false, null, false, false, false, false, false));
        colsExtended.add(new ColExtended("unitName", "واحد کالا", Type.STRING, 100, true, true, null, null, null, false, null, false, false, false, false, false));
        colsExtended.add(new ColExtended("computeValue", "ضریب", Type.DECIMAL, 50, true, true, null, null, null, false, null, false, false, false, false, false));
        colsExtended.add(new ColExtended("goodsDesc", "شرح کالا", Type.STRING, 200, true, true, null, null, null, false, null, false, false, false, false, false));
        colsExtended.add(new ColExtended("quantity", "مقدار", Type.DECIMAL, 70, true, true, null, null, null, false, null, true, false, false, false, false));


        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 1));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 2));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 3));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 4));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 5));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 6));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 7));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 8));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 9));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 10));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 11));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 12));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 13));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 14));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 15));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 16));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 17));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 18));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 19));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 20));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 21));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 22));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 23));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 24));
        colsExtended.add(colCustomField(pubXFieldsSetups, pubXFieldsFormulas, invLevels, 25));
        colsExtended.add(new ColExtended("fee", "فی", Type.DECIMAL, 80, true, true, null, null, null, false, null, false, false, false, false, false));
        colsExtended.add(new ColExtended("rowPrice", "مبلغ", Type.DECIMAL, 80, true, true, null, null, null, false, null, false, false, false, false, false));
        colsExtended.add(new ColExtended("detailXDesc", "شرح ردیف", Type.DECIMAL, 100, true, true, null, null, null, false, null, false, false, false, false, false));
        return new Meta(colsExtended);
    }
    // in dar TCacheModal estefade mishavad
    default Meta metaForWeb(List<PubXFieldsFormula> pubXFieldsFormulas) {
        LogLogins logLogins = fetchUserDetail();
        TCalendar tCalendar = new TCalendar();
        tCalendar.setGregorianDate(new Date());

        ArrayList<Col> cols = new ArrayList<>();

        SaleGoodsParams saleGoodsParams = new SaleGoodsParams(tCalendar.getIranianDateBySlashZero(), new BigDecimal(6001), logLogins.getPubUser().getUserID(), false);
        Origin originSaleGoods = new Origin("sale/goods", "goodsID", null, saleGoodsParams);
        PubXFieldsFormula pubXFieldsFormulaGoodsCode = pubXFieldsFormula(pubXFieldsFormulas, "goodsCode");

        cols.add(new Col(null, "goodsCode", "کد کالا", Type.TLOOKUP, true, "sale/goods?voucherDate=1401%2F08%2F29&voucherTypeID=6001", "sale/goods/meta", "goodsDesc", 100, true, true, true));
        cols.add(new Col(null, "barCode", "بارکد کالا", Type.STRING, 100, true, true, false));
//        cols.add(new Col(null, "unitName", "واحد کالا", Type.TLOOKUP, true, "inv/secunits", "mata bayad biad inja", "secUnitDesc", 100, true, true, true));
        cols.add(new Col(null, "computeValue", "ضریب", Type.DECIMAL, 50, true, true, false));
        cols.add(new Col(null, "goodsDesc", "شرح کالا", Type.STRING, 200, true, true, false));
        cols.add(new Col(null, "quantity", "تعداد", Type.DECIMAL, 70, true, true, false));
        cols.add(new Col(null, "baseFee", "فی", Type.DECIMAL, 80, true, true, false));
        cols.add(new Col(null, "fee", "مبلغ", Type.DECIMAL, 80, true, true, false));
        cols.add(new Col(null, "detailXDesc", "شرح ردیف", Type.DECIMAL, 100, true, true, false));

//        for (int i = 0; i < cols.size(); i++) {
//            Arrays.toString()
//            System.out.println("SIZE WAS " + cols.size());
//            System.out.println("ols.get(i) " + cols.get(i).toString());
            //            System.out.println("HEYYYYYYYYYYYYYYYYYYYYYYYY " + Arrays.toString(out[i].split("=")));
//        }
        // Commented by Khers

        return new Meta(cols);

        //        BigDecimal id,
//        String name,
//        String title,
//        Type type,
//        int width,
//        boolean visibility,
//        boolean visibilityDefalut,
//        boolean isPK
//                // ------------------
//        BigDecimal id,
//        String name,
//        String title,
//        Type type,
//        boolean isQuick,
//        String resourceData,
//        String resourceMeta,
//        String mainFieldName,
//        int width,
//        boolean visibility,
//        boolean visibilityDefalut,
//        boolean isPK
        // -------------------

    }

    default ColExtended colCustomField(
            List<PubXFieldsSetup> pubXFieldsSetups,
            List<PubXFieldsFormula> pubXFieldsFormulas,
            List<InvLevel> invLevels,
            int fieldNumber) {

        List<InvLevel> invLevel = invLevels.stream()
                .filter(item -> item.getxFieldNo().intValue() == fieldNumber)
                .collect(Collectors.toList());

        String formulaCode = null;
        if (!invLevel.isEmpty()) {
            formulaCode = invLevel.get(0).getFormulaCode();
        }

        PubXFieldsSetup pubXFieldsSetup = pubXFieldsSetup(pubXFieldsSetups, fieldNumber);
        String fieldNumberStr = String.valueOf(fieldNumber);
        String customField = "customField" + fieldNumberStr;
        ColExtended colExtended;
        if (pubXFieldsSetup != null) {
            PubXFieldsFormula pubXFieldsFormula = pubXFieldsFormula(pubXFieldsFormulas, customField);
            Type type = fieldTypeToEnumType(pubXFieldsSetup.getFieldType(), pubXFieldsSetup.getIsSelectable());

            //محاسبه عرض
            String title = pubXFieldsSetup.getCustomCaption();
            int width = 0;
            if (title.length() > 0 && title.length() < 5) {
                width = 50;
            } else if (title.length() >= 5 && title.length() < 10) {
                width = 80;
            } else {
                width = 110;
            }
            //******************************************************************************

            //اجباری بودن یا نبودن فیلد
            // اگر فیلدی آپشنال نباشد یعنی اجباری است و هنگام ثبت سند باید پر شود
            boolean isRequired = !pubXFieldsSetup.getIsOptional();
            //******************************************************************************

            if (pubXFieldsSetup.getIsFormula()) {
                colExtended = new ColExtended(customField, title, type, width, true, true, pubXFieldsFormula.getMCode(), formulaCode, pubXFieldsSetup.getFormulaText(), isRequired, null, false, true, false, false, false);
            } else {
                PubXFieldsValueParams pubXFieldsValueParams = new PubXFieldsValueParams(fieldNumber, "SaleVoucherDetailXFields");
                Origin originPubXFieldsValue = new Origin("pub/xfieldsvalue", "rowNumber", null, pubXFieldsValueParams);
                colExtended = new ColExtended(customField, title, type, width, true, true, pubXFieldsFormula.getMCode(), formulaCode, null, isRequired, originPubXFieldsValue, true, true, false, false, false);
            }
        } else {
            if (fieldNumber == 11) {
                colExtended = new ColExtended(customField, customField, Type.DECIMAL, 0, false, false, null, formulaCode, null, false, null, false, true, false, false, false);
            } else {
                colExtended = new ColExtended(customField, customField, Type.STRING, 0, false, false, null, formulaCode, null, false, null, false, true, false, false, false);
            }
        }
        return colExtended;
    }

    default PubXFieldsSetup pubXFieldsSetup(List<PubXFieldsSetup> pubXFieldsSetups, int fieldNumber) {
        for (int i = 0; i < pubXFieldsSetups.size(); i++) {
            if (pubXFieldsSetups.get(i).getFieldNumber().intValue() == fieldNumber) {
                return pubXFieldsSetups.get(i);
            }
        }
        return null;
    }

    default PubXFieldsFormula pubXFieldsFormula(List<PubXFieldsFormula> pubXFieldsFormulas, String fieldName) {
        String fieldName1 = "";
        switch (fieldName) {
            case "fee":
                fieldName1 = "@Fee";
                break;
            case "quantity":
                fieldName1 = "@Qty";
                break;
            case "goodsCode":
                fieldName1 = "@GC";
                break;
            case "customField1":
                fieldName1 = "@F01";
                break;
            case "customField2":
                fieldName1 = "@F02";
                break;
            case "customField3":
                fieldName1 = "@F03";
                break;
            case "customField4":
                fieldName1 = "@F04";
                break;
            case "customField5":
                fieldName1 = "@F05";
                break;
            case "customField6":
                fieldName1 = "@F06";
                break;
            case "customField7":
                fieldName1 = "@F07";
                break;
            case "customField8":
                fieldName1 = "@F08";
                break;
            case "customField9":
                fieldName1 = "@F09";
                break;
            case "customField10":
                fieldName1 = "@F10";
                break;
            case "customField11":
                fieldName1 = "@F11";
                break;
            case "customField12":
                fieldName1 = "@F12";
                break;
            case "customField13":
                fieldName1 = "@F13";
                break;
            case "customField14":
                fieldName1 = "@F14";
                break;
            case "customField15":
                fieldName1 = "@F15";
                break;
            case "customField16":
                fieldName1 = "@F16";
                break;
            case "customField17":
                fieldName1 = "@F17";
                break;
            case "customField18":
                fieldName1 = "@F18";
                break;
            case "customField19":
                fieldName1 = "@F19";
                break;
            case "customField20":
                fieldName1 = "@F20";
                break;
            case "customField21":
                fieldName1 = "@F21";
                break;
            case "customField22":
                fieldName1 = "@F22";
                break;
            case "customField23":
                fieldName1 = "@F23";
                break;
            case "customField24":
                fieldName1 = "@F24";
                break;
            case "customField25":
                fieldName1 = "@F25";
        }

        for (int i = 0; i < pubXFieldsFormulas.size(); i++) {
            if (pubXFieldsFormulas.get(i).getMCode().toUpperCase().equals(fieldName1.toUpperCase())) {
                return pubXFieldsFormulas.get(i);
            }
        }
        return null;
    }

    default Type fieldTypeToEnumType(Integer fieldType, Boolean isSelectable) {
        if (isSelectable.booleanValue()) {
            return Type.QKEY;
        }
        switch (fieldType.intValue()) {
            case 2:
                return Type.DATE;
            case 3:
                return Type.DECIMAL;
            case 1:
            default://سایر حالت ها
                return Type.STRING;
        }
    }
}

class SaleGoodsParams implements Serializable {
    private final String voucherDate;

    private final BigDecimal voucherTypeID;

    private final BigDecimal customerID;

    private final boolean hasPrice;

    public SaleGoodsParams(
            String voucherDate,
            BigDecimal voucherTypeID,
            BigDecimal customerID,
            boolean hasPrice
    ) {
        this.voucherDate = voucherDate;
        this.voucherTypeID = voucherTypeID;
        this.customerID = customerID;
        this.hasPrice = hasPrice;
    }

    public String getVoucherDate() {
        return voucherDate;
    }

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public BigDecimal getCustomerID() {
        return customerID;
    }

    public boolean isHasPrice() {
        return hasPrice;
    }
}

class PubXFieldsValueParams implements Serializable {
    private final int fieldNumber;

    private final String tableName;

    public PubXFieldsValueParams(
            int fieldNumber,
            String tableName
    ) {
        this.fieldNumber = fieldNumber;
        this.tableName = tableName;
    }

    public int getFieldNumber() {
        return fieldNumber;
    }

    public String getTableName() {
        return tableName;
    }
}
