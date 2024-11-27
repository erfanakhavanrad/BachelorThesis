package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleOtherInfo;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Salehi
 */
public interface SaleOtherInfoRepository extends TCrudRepository<SaleOtherInfo>, CrudRepository<SaleOtherInfo, BigDecimal> {

    default List<SaleOtherInfo> saleShowOtherInfo(SaleOtherInfo saleOtherInfo) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", saleOtherInfo._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", saleOtherInfo._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        //TODO ندارد pageFilter
        //
        return showSP("SaleShowOtherInfo", tParameters, true);
    }

    default SaleOtherInfo saleShowOtherInfoByID(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", "And Main.VoucherHeaderID =" + voucherHeaderID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        //
        return showSP("SaleShowOtherInfo", tParameters, true).get(0);
    }

    default SaleOtherInfo saleInsOtherInfo(SaleOtherInfo saleOtherInfo) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("VoucherHeaderID", saleOtherInfo.getVoucherHeaderID()));
        tParameters.add(new TParameter<>("ContractNumber", saleOtherInfo.getContractNumber()));
        tParameters.add(new TParameter<>("ContractDate", saleOtherInfo.getContractDate()));
        tParameters.add(new TParameter<>("BruntNumber", saleOtherInfo.getBruntNumber()));
        tParameters.add(new TParameter<>("CarNumber", saleOtherInfo.getCarNumber()));
        tParameters.add(new TParameter<>("OtherDesc", saleOtherInfo.getOtherDesc()));
        tParameters.add(new TParameter<>("XDesc", saleOtherInfo.getXDesc()));
        tParameters.add(new TParameter<>("DriverID", saleOtherInfo.getDriverID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("DistNameID", saleOtherInfo.getDistNameID()));
        // این اس پی newID بر نمی گرداند
        insSP("SaleInsOtherInfo", tParameters);
        return saleShowOtherInfoByID(saleOtherInfo.getVoucherHeaderID());
    }

    default SaleOtherInfo saleUpdOtherInfo(BigDecimal voucherHeaderID, SaleOtherInfo saleOtherInfo) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("ContractNumber", saleOtherInfo.getContractNumber()));
        tParameters.add(new TParameter<>("ContractDate", saleOtherInfo.getContractDate()));
        tParameters.add(new TParameter<>("BruntNumber", saleOtherInfo.getBruntNumber()));
        tParameters.add(new TParameter<>("CarNumber", saleOtherInfo.getCarNumber()));
        tParameters.add(new TParameter<>("OtherDesc", saleOtherInfo.getOtherDesc()));
        tParameters.add(new TParameter<>("XDesc", saleOtherInfo.getXDesc()));
        tParameters.add(new TParameter<>("DriverID", saleOtherInfo.getDriverID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("DistNameID", saleOtherInfo.getDistNameID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        updSP("SaleUpdOtherInfo", tParameters);
        //
        return saleShowOtherInfoByID(voucherHeaderID);
    }
}
