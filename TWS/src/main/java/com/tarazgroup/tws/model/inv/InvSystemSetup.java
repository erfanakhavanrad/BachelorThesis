//package com.tarazgroup.tws.model.inv;
//
//import com.tarazgroup.tws.util.global.TParams;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.math.BigDecimal;
//
///**
// * @author A.Farahani
// */
//// TODO: 11/27/21 pk is not existing
//@NamedStoredProcedureQuery(
//        name = "InvShowSystemSetup",
//        procedureName = "InvShowSystemSetup",
//        resultClasses = {InvSystemSetup.class},
//        parameters = {
//                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
//        }
//)
//
//@NamedStoredProcedureQuery(
//        name = "InvInsSystemSetup",
//        procedureName = "InvInsSystemSetup",
//        resultClasses = {InvSystemSetup.class},
//        parameters = {
//                @StoredProcedureParameter(name = "GoodsCodeLength", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "GroupGoodsLength", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ControlInventory", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsSerial", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsNegativeStock", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsDetQuantity", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsDifferential", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsDifferentialGoods", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsVoucherUse", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsFixedGoodsCode", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "FixedTafsiliID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsAutoVoucherUse", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "FixCostCenterID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsAutoFee", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsComputeValue", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "LenGroup1", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "LenGroup2", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "LenGroup3", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "LenGroup4", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "LenGroup5", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "LenGroup6", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "LenGroup7", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "LenGroup8", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "LenGroup9", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "LenGroup10", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsFix1", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsFix2", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsFix3", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsFix4", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsFix5", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsFix6", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsFix7", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsFix8", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsFix9", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsFix10", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsGroupCodeInGoodsCode", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsGroupDescInGoodsDesc", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "IsAccountInVoucher", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsUnit2InVoucher", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsUnit3InVoucher", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsStoreInDet", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsTafsili1InDet", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsTafsili2InDet", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsTafsili3InDet", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "LevelSepText", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsRightLevelGoodsCode", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "BarCodeLength", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsBaseFeeChange", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsGoodsDescFromDetailVal", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsGroupBase", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsFeeNew", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsFromBarCode", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsAutoNumber", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "FixStoreID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsRemainGoodsServer", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsSelfAnalysisGoods", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsRemainGoods", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsServerBaseAccountTopic", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsByStore", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsFeeTest", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsMultipleAnalysis", type = Boolean.class, mode = ParameterMode.IN)
//        }
//)
//
//@Entity
//public class InvSystemSetup extends TParams implements Serializable {
//        @Column(name = "GoodsCodeLength")
//        private Integer goodsCodeLength;
//
//        @Column(name = "GroupGoodsLength")
//        private Integer groupGoodsLength;
//
//        @Column(name = "ControlInventory")
//        private Boolean controlInventory;
//
//        @Column(name = "IsSerial")
//        private Boolean isSerial;
//
//        @Column(name = "IsNegativeStock")
//        private Boolean isNegativeStock;
//
//        @Column(name = "ISDetQuantity")
//        private Boolean iSDetQuantity;
//
//        @Column(name = "IsDifferential")
//        private Boolean isDifferential;
//
//        @Column(name = "IsDifferentialGoods")
//        private Boolean isDifferentialGoods;
//
//        @Column(name = "IsVoucherUse")
//        private Boolean isVoucherUse;
//
//        @Column(name = "IsFixedGoodsCode")
//        private Boolean isFixedGoodsCode;
//
//        @Column(name = "FixTafsiliID")
//        private BigDecimal fixTafsiliID;
//
//        @Column(name = "IsAutoVoucherUse")
//        private Boolean isAutoVoucherUse;
//
//        @Column(name = "FixCostCenterID")
//        private BigDecimal fixCostCenterID;
//
//        @Column(name = "IsAutoFee")
//        private Boolean isAutoFee;
//
//        @Column(name = "IsComputeValue")
//        private Boolean isComputeValue;
//
//        @Column(name = "LenGroup1")
//        private Integer lenGroup1;
//
//        @Column(name = "LenGroup2")
//        private Integer lenGroup2;
//
//        @Column(name = "LenGroup3")
//        private Integer lenGroup3;
//
//        @Column(name = "LenGroup4")
//        private Integer lenGroup4;
//
//        @Column(name = "LenGroup5")
//        private Integer lenGroup5;
//
//        @Column(name = "LenGroup6")
//        private Integer lenGroup6;
//
//        @Column(name = "LenGroup7")
//        private Integer lenGroup7;
//
//        @Column(name = "LenGroup8")
//        private Integer lenGroup8;
//
//        @Column(name = "LenGroup9")
//        private Integer lenGroup9;
//
//        @Column(name = "LenGroup10")
//        private Integer lenGroup10;
//
//        @Column(name = "IsFix1")
//        private Boolean isFix1;
//
//        @Column(name = "IsFix2")
//        private Boolean isFix2;
//
//        @Column(name = "IsFix3")
//        private Boolean isFix3;
//
//        @Column(name = "IsFix4")
//        private Boolean isFix4;
//
//        @Column(name = "IsFix5")
//        private Boolean isFix5;
//
//        @Column(name = "IsFix6")
//        private Boolean isFix6;
//
//        @Column(name = "IsFix7")
//        private Boolean isFix7;
//
//        @Column(name = "IsFix8")
//        private Boolean isFix8;
//
//        @Column(name = "IsFix9")
//        private Boolean isFix9;
//
//        @Column(name = "IsFix10")
//        private Boolean isFix10;
//
//        @Column(name = "IsGroupCodeInGoodsCode")
//        private Boolean isGroupCodeInGoodsCode;
//
//        @Column(name = "IsGroupDescInGoodsDesc")
//        private Boolean isGroupDescInGoodsDesc;
//
//        @Column(name = "IsAccountInVoucher")
//        private Boolean isAccountInVoucher;
//
//        @Column(name = "IsUnit2InVoucher")
//        private Boolean isUnit2InVoucher;
//
//        @Column(name = "IsUnit3InVoucher")
//        private Boolean isUnit3InVoucher;
//
//        @Column(name = "IsStoreInDet")
//        private Boolean isStoreInDet;
//
//        @Column(name = "LevelSepText")
//        private String levelSepText;
//
//        @Column(name = "IsRightLevelGoodsCode")
//        private Boolean isRightLevelGoodsCode;
//
//        @Column(name = "BarCodeLength")
//        private Integer barCodeLength;
//
//        @Column(name = "IsBaseFeeChange")
//        private Boolean isBaseFeeChange;
//
//        @Column(name = "IsTafsili1InDet")
//        private Boolean isTafsili1InDet;
//
//        @Column(name = "IsTafsili2InDet")
//        private Boolean isTafsili2InDet;
//
//        @Column(name = "IsTafsili3InDet")
//        private Boolean isTafsili3InDet;
//
//        @Column(name = "IsGoodsDescFromDetailVal")
//        private Boolean isGoodsDescFromDetailVal;
//
//        @Column(name = "IsGroupBase")
//        private Boolean isGroupBase;
//
//        @Column(name = "DTypeIDs")
//        private String dTypeIDs;
//
//        @Column(name = "HTypeIDs")
//        private String hTypeIDs;
//
//        @Column(name = "IsFeeNew")
//        private Boolean isFeeNew;
//
//        @Column(name = "IsFromBarCode")
//        private Boolean isFromBarCode;
//
//        @Column(name = "IsAutoNumber")
//        private Integer isAutoNumber;
//
//        @Column(name = "MTypeIDs")
//        private String mTypeIDs;
//
//        @Column(name = "FixStoreID")
//        private BigDecimal fixStoreID;
//
//        @Column(name = "IsRemainGoodsServer")
//        private Boolean isRemainGoodsServer;
//
//        @Column(name = "IsSelfAnalysisGoods")
//        private Boolean isSelfAnalysisGoods;
//
//        @Column(name = "IsRemainGoods")
//        private Boolean isRemainGoods;
//
//        @Column(name = "IsServerBaseAccountTopic")
//        private Boolean isServerBaseAccountTopic;
//
//        @Column(name = "IsByStore")
//        private Boolean isByStore;
//
//        @Column(name = "IsFeeTest")
//        private Boolean isFeeTest;
//
//        @Column(name = "IsCurrency")
//        private Boolean isCurrency;
//
//        @Column(name = "GroupSeparatorChar")
//        private String groupSeparatorChar;
//
//        @Column(name = "IsMultipleAnalysis")
//        private Boolean isMultipleAnalysis;
//
//        public Integer getGoodsCodeLength() {
//                return goodsCodeLength;
//        }
//
//        public void setGoodsCodeLength(Integer goodsCodeLength) {
//                this.goodsCodeLength = goodsCodeLength;
//        }
//
//        public Integer getGroupGoodsLength() {
//                return groupGoodsLength;
//        }
//
//        public void setGroupGoodsLength(Integer groupGoodsLength) {
//                this.groupGoodsLength = groupGoodsLength;
//        }
//
//        public Boolean getControlInventory() {
//                return controlInventory;
//        }
//
//        public void setControlInventory(Boolean controlInventory) {
//                this.controlInventory = controlInventory;
//        }
//
//        public Boolean getIsSerial() {
//                return isSerial;
//        }
//
//        public void setSerial(Boolean isSerial) {
//                this.isSerial = isSerial;
//        }
//
//        public Boolean getIsNegativeStock() {
//                return isNegativeStock;
//        }
//
//        public void setIsNegativeStock(Boolean isNegativeStock) {
//                this.isNegativeStock = isNegativeStock;
//        }
//
//        public Boolean getISDetQuantity() {
//                return iSDetQuantity;
//        }
//
//        public void setISDetQuantity(Boolean iSDetQuantity) {
//                this.iSDetQuantity = iSDetQuantity;
//        }
//
//        public Boolean getIsDifferential() {
//                return isDifferential;
//        }
//
//        public void setIsDifferential(Boolean isDifferential) {
//                this.isDifferential = isDifferential;
//        }
//
//        public Boolean getIsDifferentialGoods() {
//                return isDifferentialGoods;
//        }
//
//        public void setDifferentialGoods(Boolean isDifferentialGoods) {
//                this.isDifferentialGoods = isDifferentialGoods;
//        }
//
//        public Boolean getIsVoucherUse() {
//                return isVoucherUse;
//        }
//
//        public void setIsVoucherUse(Boolean isVoucherUse) {
//                this.isVoucherUse = isVoucherUse;
//        }
//
//        public Boolean getIsFixedGoodsCode() {
//                return isFixedGoodsCode;
//        }
//
//        public void setIsFixedGoodsCode(Boolean isFixedGoodsCode) {
//                this.isFixedGoodsCode = isFixedGoodsCode;
//        }
//
//        public BigDecimal getFixTafsiliID() {
//                return fixTafsiliID;
//        }
//
//        public void setFixTafsiliID(BigDecimal fixTafsiliID) {
//                this.fixTafsiliID = fixTafsiliID;
//        }
//
//        public Boolean getIsAutoVoucherUse() {
//                return isAutoVoucherUse;
//        }
//
//        public void setIsAutoVoucherUse(Boolean isAutoVoucherUse) {
//                this.isAutoVoucherUse = isAutoVoucherUse;
//        }
//
//        public BigDecimal getFixCostCenterID() {
//                return fixCostCenterID;
//        }
//
//        public void setFixCostCenterID(BigDecimal fixCostCenterID) {
//                this.fixCostCenterID = fixCostCenterID;
//        }
//
//        public Boolean getIsAutoFee() {
//                return isAutoFee;
//        }
//
//        public void setIsAutoFee(Boolean isAutoFee) {
//                this.isAutoFee = isAutoFee;
//        }
//
//        public Boolean getIsComputeValue() {
//                return isComputeValue;
//        }
//
//        public void setIsComputeValue(Boolean isComputeValue) {
//                this.isComputeValue = isComputeValue;
//        }
//
//        public Integer getLenGroup1() {
//                return lenGroup1;
//        }
//
//        public void setLenGroup1(Integer lenGroup1) {
//                this.lenGroup1 = lenGroup1;
//        }
//
//        public Integer getLenGroup2() {
//                return lenGroup2;
//        }
//
//        public void setLenGroup2(Integer lenGroup2) {
//                this.lenGroup2 = lenGroup2;
//        }
//
//        public Integer getLenGroup3() {
//                return lenGroup3;
//        }
//
//        public void setLenGroup3(Integer lenGroup3) {
//                this.lenGroup3 = lenGroup3;
//        }
//
//        public Integer getLenGroup4() {
//                return lenGroup4;
//        }
//
//        public void setLenGroup4(Integer lenGroup4) {
//                this.lenGroup4 = lenGroup4;
//        }
//
//        public Integer getLenGroup5() {
//                return lenGroup5;
//        }
//
//        public void setLenGroup5(Integer lenGroup5) {
//                this.lenGroup5 = lenGroup5;
//        }
//
//        public Integer getLenGroup6() {
//                return lenGroup6;
//        }
//
//        public void setLenGroup6(Integer lenGroup6) {
//                this.lenGroup6 = lenGroup6;
//        }
//
//        public Integer getLenGroup7() {
//                return lenGroup7;
//        }
//
//        public void setLenGroup7(Integer lenGroup7) {
//                this.lenGroup7 = lenGroup7;
//        }
//
//        public Integer getLenGroup8() {
//                return lenGroup8;
//        }
//
//        public void setLenGroup8(Integer lenGroup8) {
//                this.lenGroup8 = lenGroup8;
//        }
//
//        public Integer getLenGroup9() {
//                return lenGroup9;
//        }
//
//        public void setLenGroup9(Integer lenGroup9) {
//                this.lenGroup9 = lenGroup9;
//        }
//
//        public Integer getLenGroup10() {
//                return lenGroup10;
//        }
//
//        public void setLenGroup10(Integer lenGroup10) {
//                this.lenGroup10 = lenGroup10;
//        }
//
//        public Boolean getIsFix1() {
//                return isFix1;
//        }
//
//        public void setIsFix1(Boolean isFix1) {
//                this.isFix1 = isFix1;
//        }
//
//        public Boolean getIsFix2() {
//                return isFix2;
//        }
//
//        public void setIsFix2(Boolean isFix2) {
//                this.isFix2 = isFix2;
//        }
//
//        public Boolean getIsFix3() {
//                return isFix3;
//        }
//
//        public void setIsFix3(Boolean isFix3) {
//                this.isFix3 = isFix3;
//        }
//
//        public Boolean getIsFix4() {
//                return isFix4;
//        }
//
//        public void setIsFix4(Boolean isFix4) {
//                this.isFix4 = isFix4;
//        }
//
//        public Boolean getIsFix5() {
//                return isFix5;
//        }
//
//        public void setIsFix5(Boolean isFix5) {
//                this.isFix5 = isFix5;
//        }
//
//        public Boolean getIsFix6() {
//                return isFix6;
//        }
//
//        public void setIsFix6(Boolean isFix6) {
//                this.isFix6 = isFix6;
//        }
//
//        public Boolean getIsFix7() {
//                return isFix7;
//        }
//
//        public void setIsFix7(Boolean isFix7) {
//                this.isFix7 = isFix7;
//        }
//
//        public Boolean getIsFix8() {
//                return isFix8;
//        }
//
//        public void setIsFix8(Boolean isFix8) {
//                this.isFix8 = isFix8;
//        }
//
//        public Boolean getIsFix9() {
//                return isFix9;
//        }
//
//        public void setIsFix9(Boolean isFix9) {
//                this.isFix9 = isFix9;
//        }
//
//        public Boolean getIsFix10() {
//                return isFix10;
//        }
//
//        public void setIsFix10(Boolean isFix10) {
//                this.isFix10 = isFix10;
//        }
//
//        public Boolean getIsGroupCodeInGoodsCode() {
//                return isGroupCodeInGoodsCode;
//        }
//
//        public void setIsGroupCodeInGoodsCode(Boolean isGroupCodeInGoodsCode) {
//                this.isGroupCodeInGoodsCode = isGroupCodeInGoodsCode;
//        }
//
//        public Boolean getIsGroupDescInGoodsDesc() {
//                return isGroupDescInGoodsDesc;
//        }
//
//        public void setIsGroupDescInGoodsDesc(Boolean isGroupDescInGoodsDesc) {
//                this.isGroupDescInGoodsDesc = isGroupDescInGoodsDesc;
//        }
//
//        public Boolean getIsAccountInVoucher() {
//                return isAccountInVoucher;
//        }
//
//        public void setIsAccountInVoucher(Boolean isAccountInVoucher) {
//                this.isAccountInVoucher = isAccountInVoucher;
//        }
//
//        public Boolean getIsUnit2InVoucher() {
//                return isUnit2InVoucher;
//        }
//
//        public void setIsUnit2InVoucher(Boolean isUnit2InVoucher) {
//                this.isUnit2InVoucher = isUnit2InVoucher;
//        }
//
//        public Boolean getIsUnit3InVoucher() {
//                return isUnit3InVoucher;
//        }
//
//        public void setIsUnit3InVoucher(Boolean isUnit3InVoucher) {
//                this.isUnit3InVoucher = isUnit3InVoucher;
//        }
//
//        public Boolean getIsStoreInDet() {
//                return isStoreInDet;
//        }
//
//        public void setIsStoreInDet(Boolean isStoreInDet) {
//                this.isStoreInDet = isStoreInDet;
//        }
//
//        public String getLevelSepText() {
//                return levelSepText;
//        }
//
//        public void setLevelSepText(String levelSepText) {
//                this.levelSepText = levelSepText;
//        }
//
//        public Boolean getIsRightLevelGoodsCode() {
//                return isRightLevelGoodsCode;
//        }
//
//        public void setIsRightLevelGoodsCode(Boolean isRightLevelGoodsCode) {
//                this.isRightLevelGoodsCode = isRightLevelGoodsCode;
//        }
//
//        public Integer getBarCodeLength() {
//                return barCodeLength;
//        }
//
//        public void setBarCodeLength(Integer barCodeLength) {
//                this.barCodeLength = barCodeLength;
//        }
//
//        public Boolean getIsBaseFeeChange() {
//                return isBaseFeeChange;
//        }
//
//        public void setIsBaseFeeChange(Boolean isBaseFeeChange) {
//                this.isBaseFeeChange = isBaseFeeChange;
//        }
//
//        public Boolean getIsTafsili1InDet() {
//                return isTafsili1InDet;
//        }
//
//        public void setIsTafsili1InDet(Boolean isTafsili1InDet) {
//                this.isTafsili1InDet = isTafsili1InDet;
//        }
//
//        public Boolean getIsTafsili2InDet() {
//                return isTafsili2InDet;
//        }
//
//        public void setIsTafsili2InDet(Boolean isTafsili2InDet) {
//                this.isTafsili2InDet = isTafsili2InDet;
//        }
//
//        public Boolean getIsTafsili3InDet() {
//                return isTafsili3InDet;
//        }
//
//        public void setIsTafsili3InDet(Boolean isTafsili3InDet) {
//                this.isTafsili3InDet = isTafsili3InDet;
//        }
//
//        public Boolean getIsGoodsDescFromDetailVal() {
//                return isGoodsDescFromDetailVal;
//        }
//
//        public void setIsGoodsDescFromDetailVal(Boolean isGoodsDescFromDetailVal) {
//                this.isGoodsDescFromDetailVal = isGoodsDescFromDetailVal;
//        }
//
//        public Boolean getIsGroupBase() {
//                return isGroupBase;
//        }
//
//        public void setIsGroupBase(Boolean isGroupBase) {
//                this.isGroupBase = isGroupBase;
//        }
//
//        public String getdTypeIDs() {
//                return dTypeIDs;
//        }
//
//        public void setdTypeIDs(String dTypeIDs) {
//                this.dTypeIDs = dTypeIDs;
//        }
//
//        public String gethTypeIDs() {
//                return hTypeIDs;
//        }
//
//        public void sethTypeIDs(String hTypeIDs) {
//                this.hTypeIDs = hTypeIDs;
//        }
//
//        public Boolean getIsFeeNew() {
//                return isFeeNew;
//        }
//
//        public void setIsFeeNew(Boolean isFeeNew) {
//                this.isFeeNew = isFeeNew;
//        }
//
//        public Boolean getIsFromBarCode() {
//                return isFromBarCode;
//        }
//
//        public void setIsFromBarCode(Boolean isFromBarCode) {
//                this.isFromBarCode = isFromBarCode;
//        }
//
//        public Integer getIsAutoNumber() {
//                return isAutoNumber;
//        }
//
//        public void setIsAutoNumber(Integer isAutoNumber) {
//                this.isAutoNumber = isAutoNumber;
//        }
//
//        public String getmTypeIDs() {
//                return mTypeIDs;
//        }
//
//        public void setmTypeIDs(String mTypeIDs) {
//                this.mTypeIDs = mTypeIDs;
//        }
//
//        public BigDecimal getFixStoreID() {
//                return fixStoreID;
//        }
//
//        public void setFixStoreID(BigDecimal fixStoreID) {
//                this.fixStoreID = fixStoreID;
//        }
//
//        public Boolean getIsRemainGoodsServer() {
//                return isRemainGoodsServer;
//        }
//
//        public void setIsRemainGoodsServer(Boolean isRemainGoodsServer) {
//                this.isRemainGoodsServer = isRemainGoodsServer;
//        }
//
//        public Boolean getIsSelfAnalysisGoods() {
//                return isSelfAnalysisGoods;
//        }
//
//        public void setIsSelfAnalysisGoods(Boolean isSelfAnalysisGoods) {
//                this.isSelfAnalysisGoods = isSelfAnalysisGoods;
//        }
//
//        public Boolean getIsRemainGoods() {
//                return isRemainGoods;
//        }
//
//        public void setIsRemainGoods(Boolean isRemainGoods) {
//                this.isRemainGoods = isRemainGoods;
//        }
//
//        public Boolean getIsServerBaseAccountTopic() {
//                return isServerBaseAccountTopic;
//        }
//
//        public void setIsServerBaseAccountTopic(Boolean isServerBaseAccountTopic) {
//                this.isServerBaseAccountTopic = isServerBaseAccountTopic;
//        }
//
//        public Boolean getIsByStore() {
//                return isByStore;
//        }
//
//        public void setIsByStore(Boolean isByStore) {
//                this.isByStore = isByStore;
//        }
//
//        public Boolean getIsFeeTest() {
//                return isFeeTest;
//        }
//
//        public void setIsFeeTest(Boolean isFeeTest) {
//                this.isFeeTest = isFeeTest;
//        }
//
//        public Boolean getIsCurrency() {
//                return isCurrency;
//        }
//
//        public void setIsCurrency(Boolean isCurrency) {
//                this.isCurrency = isCurrency;
//        }
//
//        public String getGroupSeparatorChar() {
//                return groupSeparatorChar;
//        }
//
//        public void setGroupSeparatorChar(String groupSeparatorChar) {
//                this.groupSeparatorChar = groupSeparatorChar;
//        }
//
//        public Boolean getIsMultipleAnalysis() {
//                return isMultipleAnalysis;
//        }
//
//        public void setIsMultipleAnalysis(Boolean isMultipleAnalysis) {
//                this.isMultipleAnalysis = isMultipleAnalysis;
//        }
//}
//
