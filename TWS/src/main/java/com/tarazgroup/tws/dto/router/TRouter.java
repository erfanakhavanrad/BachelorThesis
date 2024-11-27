package com.tarazgroup.tws.dto.router;

/**
 * <p>
 * این کلاس برای نوع ستون
 * router
 * ساخته شده است . یعنی در گرید فرانت اند اگر ستونی نوعش از جنس روتر باشه شکلش شبیه یک دکمه میشود که با کلیک روی آن به
 * یک صفحه دیگر میرویم
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public class TRouter {
    final private String value; // مقداری که داخل دکمه نمایش میابد
    final private String icon; // آیکن دکمه
    final private String name; // با کلیک روی دکمه به چه صفحه ای برویم
    final private TRouterParams params; // متناظر با پارامز روتر ویو ایکس
    final private TRouterQuery query; // متناظر با کوئری روتر ویو ایکس

    public TRouter(String value, String icon, String name, TRouterParams params, TRouterQuery query) {
        this.value = value;
        this.icon = icon;
        this.name = name;
        this.params = params;
        this.query = query;
    }

    public String getValue() {
        return value;
    }

    public String getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public TRouterParams getParams() {
        return params;
    }

    public TRouterQuery getQuery() {
        return query;
    }
}
