package com.tarazgroup.tws.util.global.responseheader;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public class ColExtended implements Serializable {
    // این کلاس برای فرمی است که برای ثبت سفارش نوین چوب طراحی شده و هر ستون پارامتری های بیشتری دارد
    private final String name;

    private final String title;

    private final int width;

    private final boolean visibility;

    private final boolean visibilityDefault;

    private final boolean isRequired;

    private final Type type;

    private final boolean isCode;// برای مواردی چون کیوکی که نیاز است بدانیم کدام ستون نقش کد را دارد

    private final boolean isDesc;// برای مواردی چون کیوکی که نیاز است بدانیم کدام ستون نقش شرح را دارد

    private final boolean isPK;

    private final boolean isActive;

    private final boolean isCustomField;

    private final String formulaParameter;

    private final String formulaCode;

    private final String formula;

    private final Origin origin;


    public ColExtended(
            String name,
            String title,
            Type type,
            int width,
            boolean visibility,
            boolean visibilityDefalut,
            String formulaParameter,
            String formulaCode,
            String formula,
            boolean isRequired,
            Origin origin,
            boolean isActive,
            boolean isCustomField,
            boolean isCode,
            boolean isDesc,
            boolean isPK
    ) {
        this.name = name;
        this.title = title;
        this.type = type;
        this.width = width;
        this.visibility = visibility;
        this.visibilityDefault = visibilityDefalut;
        this.formulaParameter = formulaParameter;
        this.formulaCode = formulaCode;
        this.formula = formula;
        this.isRequired = isRequired;
        this.origin = origin;
        this.isActive = isActive;
        this.isCustomField = isCustomField;
        this.isCode = isCode;
        this.isDesc = isDesc;
        this.isPK = isPK;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getFormulaParameter() {
        return formulaParameter;
    }

    public String getFormulaCode() {
        return formulaCode;
    }

    public int getWidth() {
        return width;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public boolean getIsRequired() {
        return isRequired;
    }

    public Type getType() {
        return type;
    }

    public boolean getIsCode() {
        return isCode;
    }

    public boolean getIsDesc() {
        return isDesc;
    }

    public boolean getIsPK() {
        return isPK;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public boolean getIsCustomField() {
        return isCustomField;
    }

    public String getFormula() {
        return formula;
    }

    public Origin getOrigin() {
        return origin;
    }

    public boolean isVisibilityDefault() {
        return visibilityDefault;
    }
}
