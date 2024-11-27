package com.tarazgroup.tws.dao.buy;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.buy.BuyPurchase;
import com.tarazgroup.tws.model.buy.BuyPurchaseDetail;
import com.tarazgroup.tws.model.buy.BuyPurchaseHeader;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */

public interface
BuyPurchaseRepository extends TCrudRepository<BuyPurchase>, CrudRepository<BuyPurchase, BigDecimal> {

    default BuyPurchase buyShowPurchase(
            BuyPurchaseHeaderRepository buyPurchaseHeaderRepository,
            BuyPurchaseDetailRepository buyPurchaseDetailRepository,
            BigDecimal voucherHeaderID) {

        BuyPurchaseHeader buyPurchaseHeader = buyPurchaseHeaderRepository.buyShowPurchaseHeaderByID(voucherHeaderID);
        List<BuyPurchaseDetail> buyPurchaseDetails = buyPurchaseDetailRepository.buyShowPurchaseDetailByID(voucherHeaderID);

        BuyPurchase buyPurchase = new BuyPurchase();
        buyPurchase.setHeader(buyPurchaseHeader);
        buyPurchase.setDetails(buyPurchaseDetails);

        return buyPurchase;
    }


}
