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
public class Info implements Serializable {
    // این کلاس اطلاعات اضافه در مورد ستون های متا ارايه می دهد
    private final String name;
    private final String text;
    private final String color;

    public Info(String name, String text, String color) {
        this.name = name;
        this.text = text;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public String getColor() {
        return color;
    }
}

