package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;
import com.tarazgroup.tws.util.tabletype.sale.SaleVDTblType;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
@NamedStoredProcedureQuery(
        name = "SaleComputePromotion",
        procedureName = "SaleComputePromotion",
        parameters = {
                @StoredProcedureParameter(name = "VoucherDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MarketingManID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Bonus", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "VoucherDetailID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsBonus", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCountOnly", type = Boolean.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "SalePrice", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOnlyPreview", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SecUnitID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SaleCenterID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DeliverCenterID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MarketingClassID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SalesClassID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SaleTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsTest", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TVD", type = SaleVDTblType.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PaymentWayID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleInsPromotion",
        procedureName = "SaleInsPromotion",
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsId", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ElementID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ElementMab", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
        }
)

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
public class PromotionElement extends TParams implements Serializable {
    @Id
    @Column(name = "_id", columnDefinition = "BINARY(16)")
    private UUID _id = UUID.randomUUID();

    @Column(name = "promotions")
    @OneToMany
    private List<Promotion> promotions;

    @Column(name = "elements")
    @OneToMany
    private List<Element> elements;

    public UUID get_id() {
        return _id;
    }

    public void set_id(UUID _id) {
        this._id = _id;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public PromotionElement fromArrayList(List<Map<String, Object>> rows) {
        List<Element> elements = new ArrayList<>();
        List<Promotion> promotions = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i).get("IsGoods") == null) {//elements
                // هنگام سیو سند فروش این مورد به اس پی
                //SaleInsPromotion فرستاده می شود
                Element element = new Element();
                element.setElementDesc((String) rows.get(i).get("ElementDesc"));
                element.setElementID(new BigDecimal(rows.get(i).get("ElementID").toString()));
                element.setElementMab(new BigDecimal(rows.get(i).get("PRMVal").toString()));
                element.setElementType(new BigDecimal(rows.get(i).get("ElementType").toString()));
                element.setGoodsID(new BigDecimal(rows.get(i).get("GoodsID").toString()));
                elements.add(element);
            } else if ((Boolean) rows.get(i).get("IsGoods")) {//promotion
                // هنگام سیو سند فروش این مورد به عنوان یک کالا به دیتیل سند اضافه میشود فقط
                // isPromotion = true
                Promotion promotion = new Promotion();
                promotion.setGoodsDesc((String) rows.get(i).get("GoodsDesc"));
                promotion.setGoodsID((BigDecimal) rows.get(i).get("GoodsID"));
                promotion.setQuantity((BigDecimal) rows.get(i).get("PRMVal"));
                promotion.setSecUnitID((BigDecimal) rows.get(i).get("SecUnitID"));
                promotion.setUnitDesc((String) rows.get(i).get("UnitDesc"));
                promotions.add(promotion);
            }
        }
        setElements(elements);
        setPromotions(promotions);
        return this;
    }
}




