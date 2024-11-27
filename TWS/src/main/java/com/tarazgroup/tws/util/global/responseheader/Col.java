package com.tarazgroup.tws.util.global.responseheader;

import com.businessobjects.reports.crprompting.CRPromptValue;

import java.io.Serializable;
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
public class Col implements Serializable {
    private final BigDecimal id;

    private final String name;

    private final String title;

    private final Type type;

    private final int width;

    private final boolean visibility;

    private final boolean visibilityDefault;

    private boolean resVisibility;

    private Icon resIcon;

    private boolean isQuick;

    private String resourceData;

    private String resourceMeta;

    private boolean isEditable;

    private final boolean isPK;

    private List<Info> infos;

    private String mainFieldName;

//    private BigDecimal categoryID;
    private String categoryID;

    private boolean isRequired;


    public Col(
            BigDecimal id,
            String name,
            String title,
            Type type,
            int width,
            boolean visibility,
            boolean visibilityDefalut,
            boolean isPK
    ) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.type = type;
        this.width = width;
        this.visibility = visibility;
        this.visibilityDefault = visibilityDefalut;
        this.isEditable = false;
        this.infos = null;
        this.isPK = isPK;
    }

    // it is isQuick
    public Col(
            BigDecimal id,
            String name,
            String title,
            Type type,
            boolean isQuick,
            int width,
            boolean visibility,
            boolean visibilityDefalut,
            boolean isPK
    ) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.type = type;
        this.isQuick = isQuick;
        this.width = width;
        this.visibility = visibility;
        this.visibilityDefault = visibilityDefalut;
        this.isPK = isPK;
    }

    // this is for resourceData and resourceMeta
    public Col(
            BigDecimal id,
            String name,
            String title,
            Type type,
            boolean isQuick,
            String resourceData,
            String resourceMeta,
            String mainFieldName,
            int width,
            boolean visibility,
            boolean visibilityDefalut,
            boolean isPK
    ) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.type = type;
        this.isQuick = isQuick;
        this.resourceData = resourceData;
        this.resourceMeta = resourceMeta;
        this.mainFieldName = mainFieldName;
        this.width = width;
        this.visibility = visibility;
        this.visibilityDefault = visibilityDefalut;
        this.isPK = isPK;
    }

    public Col(
            BigDecimal id,
            String name,
            String title,
            Type type,
            int width,
            boolean visibility,
            boolean visibilityDefalut,
            boolean resVisibility,
            Icon resIcon,
            boolean isPK
    ) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.type = type;
        this.width = width;
        this.visibility = visibility;
        this.visibilityDefault = visibilityDefalut;
        this.resVisibility = resVisibility;
        this.resIcon = resIcon;
        this.isEditable = false;
        this.infos = null;
        this.isPK = isPK;
    }

    public Col(
            BigDecimal id,
            String name,
            String title,
            Type type,
            int width,
            boolean visibility,
            boolean visibilityDefalut,
            boolean isEditable,
            boolean isPK
    ) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.type = type;
        this.width = width;
        this.visibility = visibility;
        this.visibilityDefault = visibilityDefalut;
        this.isEditable = isEditable;
        this.infos = null;
        this.isPK = isPK;
    }

    public Col(
            BigDecimal id,
            String name,
            String title,
            Type type,
            int width,
            boolean visibility,
            boolean visibilityDefalut,
            List<Info> infos,
            boolean resVisibility,
            Icon resIcon,
            boolean isPK
    ) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.type = type;
        this.width = width;
        this.visibility = visibility;
        this.visibilityDefault = visibilityDefalut;
        this.isEditable = false;
        this.infos = infos;
        this.resVisibility = resVisibility;
        this.resIcon = resIcon;
        this.isPK = isPK;
    }

    public Col(BigDecimal id, String name, String title, Type type, int width, boolean visibility, boolean visibilityDefault, boolean isPK, String categoryID) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.type = type;
        this.width = width;
        this.visibility = visibility;
        this.visibilityDefault = visibilityDefault;
        this.isPK = isPK;
        this.categoryID = categoryID;
    }

    public BigDecimal getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public int getWidth() {
        return width;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public boolean isVisibilityDefault() {
        return visibilityDefault;
    }

    public boolean getResVisibility() {
        return resVisibility;
    }

    public Icon getResIcon() {
        return resIcon;
    }

    public Type getType() {
        return type;
    }

    public boolean getIsEditable() {
        return isEditable;
    }

    public List<Info> getInfos() {
        return infos;
    }

    public boolean getIsPK() {
        return isPK;
    }

    public boolean getIsQuick() {
        return isQuick;
    }

    public String getResourceData() {
        return resourceData;
    }

    public String getResourceMeta() {
        return resourceMeta;
    }

    public String getMainFieldName() {
        return mainFieldName;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(boolean required) {
        isRequired = required;
    }

    public Col(BigDecimal id, String name, String title, Type type, int width, boolean visibility, boolean visibilityDefault, boolean isQuick, boolean isPK, String categoryID, boolean isRequired) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.type = type;
        this.width = width;
        this.visibility = visibility;
        this.visibilityDefault = visibilityDefault;
        this.isQuick = isQuick;
        this.isPK = isPK;
        this.categoryID = categoryID;
        this.isRequired = isRequired;
    }
}