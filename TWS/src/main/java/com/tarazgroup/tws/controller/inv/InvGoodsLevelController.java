package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvGoodsLevelRepository;
import com.tarazgroup.tws.dao.inv.InvGoodsRepository;
import com.tarazgroup.tws.model.inv.InvGoods;
import com.tarazgroup.tws.model.inv.InvGoodsLevel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author salman majidi
 * @since v2.0.0
 */

@Validated
@RestController
@RequestMapping(value = "/inv/goodslevels")
@Tag(name = "GoodsLevel")
public class InvGoodsLevelController {

    final private InvGoodsLevelRepository invGoodsLevelRepository;

    final private InvGoodsRepository invGoodsRepository;


    @Autowired
    public InvGoodsLevelController(InvGoodsLevelRepository invGoodsLevelRepository, InvGoodsRepository invGoodsRepository) {
        this.invGoodsLevelRepository = invGoodsLevelRepository;
        this.invGoodsRepository = invGoodsRepository;
    }

    @Operation(
            summary = "Retrieve all goods level",
            description = "<code>Retrieve</code> all <i><b>goods level</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvGoodsLevel>> goodsLevel(@RequestParam BigDecimal[] goodsIDs) {
        List<InvGoodsLevel> invGoodsLevels = new ArrayList();
        for (int i = 0; i <goodsIDs.length ; i++) {
            InvGoods invGoods =  invGoodsRepository.invShowGoodsByID(goodsIDs[i]);
            List<InvGoodsLevel> invGoodsLevels1  = invGoodsLevelRepository.invShowGoodsLevel(goodsIDs[i],invGoods.getGroupID());
            // به خاطر این که ممکن است برخی از گودز آی دی ها نال باشد مجبوریم خودمان دستی آنها را دوباره ست کنیم
            for (int j = 0; j <invGoodsLevels1.size() ; j++) {
                invGoodsLevels1.get(j).setGoodsID(goodsIDs[i]);
            }
            invGoodsLevels.addAll(invGoodsLevels1);
        }

        return ResponseEntity.ok(invGoodsLevels);
    }
}
