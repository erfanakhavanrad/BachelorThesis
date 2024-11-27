package com.tarazgroup.tws.dao.inv;

//import com.tarazgroup.tws.dao.TCrudRepository;
//import com.tarazgroup.tws.model.inv.InvSystemSetup;
//import com.tarazgroup.tws.model.log.LogLogins;
//import com.tarazgroup.tws.util.global.TParameter;
//import org.springframework.data.repository.CrudRepository;
//
//import javax.persistence.ParameterMode;
//import javax.persistence.StoredProcedureParameter;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;

/**
 * @author A.Farahani
 */
// TODO: 12/8/21 Doesn't have page filter

//public interface InvSystemSetupRepository extends TCrudRepository<InvSystemSetup>, CrudRepository<InvSystemSetup, BigDecimal> {
//    default List<InvSystemSetup> invShowSystemSetup(InvSystemSetup invSystemSetup) {
//        List<TParameter<?>> parameters = new ArrayList<>();
//        parameters.add(new TParameter<>("Filter", null));
//        parameters.add(new TParameter<>("OtherFilter", null));
//        parameters.add(new TParameter<>("ServerFilter", invSystemSetup._serverFilter()));
//        parameters.add(new TParameter<>("YearFilter", invSystemSetup._yearFilter()));
//        parameters.add(new TParameter<>("UserAccessFilter", null));
//        return showSP("InvShowSystemSetup", parameters, true);
//    }

    // PK = NULL => THERE IS AN ERROR FOR GETTING ELEMENT BY ID
//
//    default InvSystemSetup invInsSystemSetup(InvSystemSetup invSystemSetup) {
//        LogLogins logLogins = fetchUserDetail();
//        List<TParameter<?>> parameters = new ArrayList<>();
//        parameters.add(new TParameter<>("GoodsCodeLength", invSystemSetup.getGoodsCodeLength()));
//        parameters.add(new TParameter<>("GroupGoodsLength", invSystemSetup.getGroupGoodsLength()));
//        parameters.add(new TParameter<>("ControlInventory", invSystemSetup.getControlInventory()));
//        parameters.add(new TParameter<>("IsSerial", invSystemSetup.getIsSerial()));
//        parameters.add(new TParameter<>("IsNegativeStock", invSystemSetup.getIsNegativeStock()));
//        parameters.add(new TParameter<>("IsDetQuantity", invSystemSetup.getISDetQuantity()));
//        parameters.add(new TParameter<>("IsDifferential", invSystemSetup.getIsDifferential()));
//        parameters.add(new TParameter<>("IsDifferentialGoods", invSystemSetup.getIsDifferentialGoods()));
//        parameters.add(new TParameter<>("IsVoucherUse", invSystemSetup.getIsVoucherUse()));
//        parameters.add(new TParameter<>("IsFixedGoodsCode", invSystemSetup.getIsFixedGoodsCode()));
//        parameters.add(new TParameter<>("FixedTafsiliID", invSystemSetup.getFixTafsiliID()));
//        parameters.add(new TParameter<>("IsAutoVoucherUse", invSystemSetup.getIsAutoVoucherUse()));
//        parameters.add(new TParameter<>("FixCostCenterID", invSystemSetup.getFixCostCenterID()));
//        parameters.add(new TParameter<>("IsAutoFee", invSystemSetup.getIsAutoFee()));
//        parameters.add(new TParameter<>("IsComputeValue", invSystemSetup.getIsComputeValue()));
//        parameters.add(new TParameter<>("LenGroup1", invSystemSetup.getLenGroup1()));
//        parameters.add(new TParameter<>("LenGroup2", invSystemSetup.getLenGroup2()));
//        parameters.add(new TParameter<>("LenGroup3", invSystemSetup.getLenGroup3()));
//        parameters.add(new TParameter<>("LenGroup4", invSystemSetup.getLenGroup4()));
//        parameters.add(new TParameter<>("LenGroup5", invSystemSetup.getLenGroup5()));
//        parameters.add(new TParameter<>("LenGroup6", invSystemSetup.getLenGroup6()));
//        parameters.add(new TParameter<>("LenGroup7", invSystemSetup.getLenGroup7()));
//        parameters.add(new TParameter<>("LenGroup8", invSystemSetup.getLenGroup8()));
//        parameters.add(new TParameter<>("LenGroup9", invSystemSetup.getLenGroup9()));
//        parameters.add(new TParameter<>("LenGroup10", invSystemSetup.getLenGroup10()));
//        parameters.add(new TParameter<>("IsFix1", invSystemSetup.getIsFix1()));
//        parameters.add(new TParameter<>("IsFix2", invSystemSetup.getIsFix2()));
//        parameters.add(new TParameter<>("IsFix3", invSystemSetup.getIsFix3()));
//        parameters.add(new TParameter<>("IsFix4", invSystemSetup.getIsFix4()));
//        parameters.add(new TParameter<>("IsFix5", invSystemSetup.getIsFix5()));
//        parameters.add(new TParameter<>("IsFix6", invSystemSetup.getIsFix6()));
//        parameters.add(new TParameter<>("IsFix7", invSystemSetup.getIsFix7()));
//        parameters.add(new TParameter<>("IsFix8", invSystemSetup.getIsFix8()));
//        parameters.add(new TParameter<>("IsFix9", invSystemSetup.getIsFix9()));
//        parameters.add(new TParameter<>("IsFix10", invSystemSetup.getIsFix10()));
//        parameters.add(new TParameter<>("IsGroupCodeInGoodsCode", invSystemSetup.getIsGroupCodeInGoodsCode()));
//        parameters.add(new TParameter<>("IsGroupDescInGoodsDesc", invSystemSetup.getIsGroupDescInGoodsDesc()));
//        parameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        parameters.add(new TParameter<>("IsAccountInVoucher", invSystemSetup.getIsAccountInVoucher()));
//        parameters.add(new TParameter<>("IsUnit2InVoucher", invSystemSetup.getIsUnit2InVoucher()));
//        parameters.add(new TParameter<>("IsUnit3InVoucher", invSystemSetup.getIsUnit3InVoucher()));
//        parameters.add(new TParameter<>("IsStoreInDet", invSystemSetup.getIsStoreInDet()));
//        parameters.add(new TParameter<>("IsTafsili1InDet", invSystemSetup.getIsTafsili1InDet()));
//        parameters.add(new TParameter<>("IsTafsili2InDet", invSystemSetup.getIsTafsili2InDet()));
//        parameters.add(new TParameter<>("IsTafsili3InDet", invSystemSetup.getIsTafsili3InDet()));
//        parameters.add(new TParameter<>("LevelSepText", invSystemSetup.getLevelSepText()));
//        parameters.add(new TParameter<>("IsRightLevelGoodsCode", invSystemSetup.getIsRightLevelGoodsCode()));
//        parameters.add(new TParameter<>("BarCodeLength", invSystemSetup.getBarCodeLength()));
//        parameters.add(new TParameter<>("IsBaseFeeChange", invSystemSetup.getIsBaseFeeChange()));
//        parameters.add(new TParameter<>("IsGoodsDescFromDetailVal", invSystemSetup.getIsFix10()));
//        parameters.add(new TParameter<>("IsGroupBase", invSystemSetup.getIsGroupBase()));
//        parameters.add(new TParameter<>("IsFeeNew", invSystemSetup.getIsFeeNew()));
//        parameters.add(new TParameter<>("IsFromBarCode", invSystemSetup.getIsFromBarCode()));
//        parameters.add(new TParameter<>("IsAutoNumber", invSystemSetup.getIsAutoNumber()));
//        parameters.add(new TParameter<>("FixStoreID", invSystemSetup.getFixStoreID()));
//
//        //  CHECK THE SP ABOUT THIS COLUMN
//        parameters.add(new TParameter<>("IsRemainGoodsServer", invSystemSetup.getIsRemainGoodsServer()));
//        parameters.add(new TParameter<>("IsSelfAnalysisGoods", invSystemSetup.getIsSelfAnalysisGoods()));
//        parameters.add(new TParameter<>("IsRemainGoods", invSystemSetup.getIsRemainGoods()));
//        parameters.add(new TParameter<>("IsServerBaseAccountTopic", invSystemSetup.getIsServerBaseAccountTopic()));
//        parameters.add(new TParameter<>("IsByStore", invSystemSetup.getIsByStore()));
//        parameters.add(new TParameter<>("IsFeeTest", invSystemSetup.getIsFeeTest()));
//        parameters.add(new TParameter<>("IsMultipleAnalysis", invSystemSetup.getIsMultipleAnalysis()));
//
//        BigDecimal newID = insSP("InvInsSystemSetup", parameters);
//        return invShowSystemSetupByID(newID);
//    }
//}
