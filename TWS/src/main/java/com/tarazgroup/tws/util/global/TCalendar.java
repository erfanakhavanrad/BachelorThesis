package com.tarazgroup.tws.util.global;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class TCalendar {
    private int irYear;

    private int irMonth;

    private int irDay;

    private int gYear;

    private int gMonth;

    private int gDay;

    private int juYear;

    private int juMonth;

    private int juDay;

    private int leap;

    private int JDN;

    private int march;

    public TCalendar() {
        Calendar calendar = new GregorianCalendar();
        this.setGregorianDate(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
    }

    private String getIranianDateByDash() {
        return this.irYear + "-" + this.irMonth + "-" + this.irDay;
    }

    public void setIranianDateByDash(String iranianDate) {
        String[] arrIranianDate = iranianDate.split("-");
        this.irYear = Integer.parseInt(arrIranianDate[0]);
        this.irMonth = Integer.parseInt(arrIranianDate[1]);
        this.irDay = Integer.parseInt(arrIranianDate[2]);
        this.JDN = this.IranianDateToJDN();
        this.JDNToIranian();
        this.JDNToJulian();
        this.JDNToGregorian();
    }

    public String getIranianDateBySlash() {
        return this.irYear + "/" + this.irMonth + "/" + this.irDay;
    }

    public void setIranianDateBySlash(String iranianDate) {
        String[] arrIranianDate = iranianDate.split("/");
        this.irYear = Integer.parseInt(arrIranianDate[0]);
        this.irMonth = Integer.parseInt(arrIranianDate[1]);
        this.irDay = Integer.parseInt(arrIranianDate[2]);
        this.JDN = this.IranianDateToJDN();
        this.JDNToIranian();
        this.JDNToJulian();
        this.JDNToGregorian();
    }

    public Date convertIranianDateTimeToGregorianDateTime(String iranianDateTime) {
        if (iranianDateTime == null || iranianDateTime.isEmpty()) {
            return null;
        }
        String[] arrIranianDateTime = iranianDateTime.split(" ");
        return getGregorianDateTimeBySlashZero(arrIranianDateTime[0], arrIranianDateTime[1]);
    }

    public String getIranianDateByDashZero() {
        String str_irMonth;
        if (this.irMonth < 10) {
            str_irMonth = "0" + this.irMonth;
        } else {
            str_irMonth = "" + this.irMonth;
        }

        String str_irDay;
        if (this.irDay < 10) {
            str_irDay = "0" + this.irDay;
        } else {
            str_irDay = "" + this.irDay;
        }

        return this.irYear + "-" + str_irMonth + "-" + str_irDay;
    }

    public String getIranianDateBySlashZero() {
        String str_irMonth;
        if (this.irMonth < 10) {
            str_irMonth = "0" + this.irMonth;
        } else {
            str_irMonth = "" + this.irMonth;
        }

        String str_irDay;
        if (this.irDay < 10) {
            str_irDay = "0" + this.irDay;
        } else {
            str_irDay = "" + this.irDay;
        }

        return this.irYear + "/" + str_irMonth + "/" + str_irDay;
    }

    private String getGregorianDateByDash() {
        return this.gYear + "-" + this.gMonth + "-" + this.gDay;
    }

    public void setGregorianDateByDash(String gregorianDate) {
        String[] arrgregorianDate = gregorianDate.split("-");
        this.gYear = Integer.parseInt(arrgregorianDate[0]);
        this.gMonth = Integer.parseInt(arrgregorianDate[1]);
        this.gDay = Integer.parseInt(arrgregorianDate[2]);
        this.JDN = this.gregorianDateToJDN(this.gYear, this.gMonth, this.gDay);
        this.JDNToIranian();
        this.JDNToJulian();
        this.JDNToGregorian();
    }

    public String getGregorianDateBySlash() {
        return this.gYear + "/" + this.gMonth + "/" + this.gDay;
    }

    public void setGregorianDateBySlash(String gregorianDate) {
        String[] arrgregorianDate = gregorianDate.split("/");
        this.gYear = Integer.parseInt(arrgregorianDate[0]);
        this.gMonth = Integer.parseInt(arrgregorianDate[1]);
        this.gDay = Integer.parseInt(arrgregorianDate[2]);
        this.JDN = this.gregorianDateToJDN(this.gYear, this.gMonth, this.gDay);
        this.JDNToIranian();
        this.JDNToJulian();
        this.JDNToGregorian();
    }

    public String getGregorianDateByDashZero() {
        String str_gMonth;
        if (this.gMonth < 10) {
            str_gMonth = "0" + this.gMonth;
        } else {
            str_gMonth = "" + this.gMonth;
        }

        String str_gDay;
        if (this.gDay < 10) {
            str_gDay = "0" + this.gDay;
        } else {
            str_gDay = "" + this.gDay;
        }

        return this.gYear + "-" + str_gMonth + "-" + str_gDay;
    }

    public String getGregorianDateBySlashZero() {
        String str_gMonth;
        if (this.gMonth < 10) {
            str_gMonth = "0" + this.gMonth;
        } else {
            str_gMonth = "" + this.gMonth;
        }

        String str_gDay;
        if (this.gDay < 10) {
            str_gDay = "0" + this.gDay;
        } else {
            str_gDay = "" + this.gDay;
        }

        return this.gYear + "/" + str_gMonth + "/" + str_gDay;
    }

    public Date getGregorianDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

        try {
            return formatter.parse(this.gYear + "/" + this.gMonth + "/" + this.gDay);
        } catch (ParseException var3) {
            Logger.getLogger(TCalendar.class.getName()).log(Level.SEVERE, (String) null, var3);
            return null;
        }
    }

    public void setGregorianDate(Date gregorianDate) {
        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String[] arrgregorianDate = formatter.format(gregorianDate).split("/");
        this.gYear = Integer.parseInt(arrgregorianDate[0]);
        this.gMonth = Integer.parseInt(arrgregorianDate[1]);
        this.gDay = Integer.parseInt(arrgregorianDate[2]);
        this.JDN = this.gregorianDateToJDN(this.gYear, this.gMonth, this.gDay);
        this.JDNToIranian();
        this.JDNToJulian();
        this.JDNToGregorian();
    }

    public String getGregorianDateByTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return formatter.format(new Date());
    }

    public java.sql.Date getSqlDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

        try {
            Date date1 = formatter.parse(this.gYear + "/" + this.gMonth + "/" + this.gDay);
            return new java.sql.Date(date1.getTime());
        } catch (ParseException var3) {
            Logger.getLogger(TCalendar.class.getName()).log(Level.SEVERE, (String) null, var3);
            return null;
        }
    }

    public void setSqlDate(java.sql.Date sqlDate) {
        Date gregorianDate = new Date(sqlDate.getTime());
        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String[] arrgregorianDate = formatter.format(gregorianDate).split("/");
        this.gYear = Integer.parseInt(arrgregorianDate[0]);
        this.gMonth = Integer.parseInt(arrgregorianDate[1]);
        this.gDay = Integer.parseInt(arrgregorianDate[2]);
        this.JDN = this.gregorianDateToJDN(this.gYear, this.gMonth, this.gDay);
        this.JDNToIranian();
        this.JDNToJulian();
        this.JDNToGregorian();
    }

    public void setIranianDate(int year, int month, int day) {
        this.irYear = year;
        this.irMonth = month;
        this.irDay = day;
        this.JDN = this.IranianDateToJDN();
        this.JDNToIranian();
        this.JDNToJulian();
        this.JDNToGregorian();
    }

    public void setGregorianDate(int year, int month, int day) {
        this.gYear = year;
        this.gMonth = month;
        this.gDay = day;
        this.JDN = this.gregorianDateToJDN(year, month, day);
        this.JDNToIranian();
        this.JDNToJulian();
        this.JDNToGregorian();
    }

    public int getIranianYear() {
        return this.irYear;
    }

    public int getIranianMonth() {
        return this.irMonth;
    }

    public int getIranianDay() {
        return this.irDay;
    }

    public int getGregorianYear() {
        return this.gYear;
    }

    public int getGregorianMonth() {
        return this.gMonth;
    }

    public int getGregorianDay() {
        return this.gDay;
    }

    public int getJulianYear() {
        return this.juYear;
    }

    public int getJulianMonth() {
        return this.juMonth;
    }

    public int getJulianDay() {
        return this.juDay;
    }

    public void previousDay(int days) {
        this.JDN -= days;
        this.JDNToIranian();
        this.JDNToJulian();
        this.JDNToGregorian();
    }

    private String getJulianDate() {
        return this.juYear + "-" + this.juMonth + "-" + this.juDay;
    }

    private int getDayOfWeek() {
        return this.JDN % 7;
    }

    public void nextDay() {
        ++this.JDN;
        this.JDNToIranian();
        this.JDNToJulian();
        this.JDNToGregorian();
    }

    public void nextDay(int days) {
        this.JDN += days;
        this.JDNToIranian();
        this.JDNToJulian();
        this.JDNToGregorian();
    }

    public void previousDay() {
        --this.JDN;
        this.JDNToIranian();
        this.JDNToJulian();
        this.JDNToGregorian();
    }

    public void setJulianDate(int year, int month, int day) {
        this.juYear = year;
        this.juMonth = month;
        this.juDay = day;
        this.JDN = this.julianDateToJDN(year, month, day);
        this.JDNToIranian();
        this.JDNToJulian();
        this.JDNToGregorian();
    }

    private void IranianCalendar() {
        int[] Breaks = new int[]{-61, 9, 38, 199, 426, 686, 756, 818, 1111, 1181, 1210, 1635, 2060, 2097, 2192, 2262, 2324, 2394, 2456, 3178};
        this.gYear = this.irYear + 621;
        int leapJ = -14;
        int jp = Breaks[0];
        int j = 1;

        int jm;
        int jump;
        do {
            jm = Breaks[j];
            jump = jm - jp;
            if (this.irYear >= jm) {
                leapJ += jump / 33 * 8 + jump % 33 / 4;
                jp = jm;
            }

            ++j;
        } while (j < 20 && this.irYear >= jm);

        int N = this.irYear - jp;
        leapJ += N / 33 * 8 + (N % 33 + 3) / 4;
        if (jump % 33 == 4 && jump - N == 4) {
            ++leapJ;
        }

        int leapG = this.gYear / 4 - (this.gYear / 100 + 1) * 3 / 4 - 150;
        this.march = 20 + leapJ - leapG;
        if (jump - N < 6) {
            N = N - jump + (jump + 4) / 33 * 33;
        }

        this.leap = ((N + 1) % 33 - 1) % 4;
        if (this.leap == -1) {
            this.leap = 4;
        }

    }

    public boolean IsLeap(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(1, year + 621);
        return cal.getActualMaximum(6) > 365;
    }

    private int IranianDateToJDN() {
        this.IranianCalendar();
        return this.gregorianDateToJDN(this.gYear, 3, this.march) + (this.irMonth - 1) * 31 - this.irMonth / 7 * (this.irMonth - 7) + this.irDay - 1;
    }

    private void JDNToIranian() {
        this.JDNToGregorian();
        this.irYear = this.gYear - 621;
        this.IranianCalendar();
        int JDN1F = this.gregorianDateToJDN(this.gYear, 3, this.march);
        int k = this.JDN - JDN1F;
        if (k >= 0) {
            if (k <= 185) {
                this.irMonth = 1 + k / 31;
                this.irDay = k % 31 + 1;
                return;
            }

            k -= 186;
        } else {
            --this.irYear;
            k += 179;
            if (this.leap == 1) {
                ++k;
            }
        }

        this.irMonth = 7 + k / 30;
        this.irDay = k % 30 + 1;
    }

    private int julianDateToJDN(int year, int month, int day) {
        return (year + (month - 8) / 6 + 100100) * 1461 / 4 + (153 * ((month + 9) % 12) + 2) / 5 + day - 34840408;
    }

    private void JDNToJulian() {
        int j = 4 * this.JDN + 139361631;
        int i = j % 1461 / 4 * 5 + 308;
        this.juDay = i % 153 / 5 + 1;
        this.juMonth = i / 153 % 12 + 1;
        this.juYear = j / 1461 - 100100 + (8 - this.juMonth) / 6;
    }

    private int gregorianDateToJDN(int year, int month, int day) {
        int jdn = (year + (month - 8) / 6 + 100100) * 1461 / 4 + (153 * ((month + 9) % 12) + 2) / 5 + day - 34840408;
        jdn = jdn - (year + 100100 + (month - 8) / 6) / 100 * 3 / 4 + 752;
        return jdn;
    }

    private void JDNToGregorian() {
        int j = 4 * this.JDN + 139361631;
        j += (4 * this.JDN + 183187720) / 146097 * 3 / 4 * 4 - 3908;
        int i = j % 1461 / 4 * 5 + 308;
        this.gDay = i % 153 / 5 + 1;
        this.gMonth = i / 153 % 12 + 1;
        this.gYear = j / 1461 - 100100 + (8 - this.gMonth) / 6;
    }

    public boolean validate(String str_date) {
        String[] str_split = str_date.split("-");
        int year = Integer.parseInt(str_split[0]);
        int month = Integer.parseInt(str_split[1]);
        int day = Integer.parseInt(str_split[2]);
        if (day != 0 && month != 0) {
            boolean isKabise = false;
            if (year % 33 == 1 || year % 33 == 5 || year % 33 == 9 || year % 33 == 13 || year % 33 == 17 || year % 33 == 22 || year % 33 == 26 || year % 33 == 30) {
                isKabise = true;
            }

            if (month <= 6 && day <= 31) {
                return true;
            } else if (month > 6 && month < 12 && day <= 30) {
                return true;
            } else if (month == 12) {
                if (isKabise) {
                    return day <= 30;
                } else {
                    return day <= 29;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private String getWeekDayStr() {
        String[] weekDayStr = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        return weekDayStr[this.getDayOfWeek()];
    }

    public String toString() {
        return this.getWeekDayStr() + ", Gregorian:[" + this.getGregorianDateByDash() + "], Julian:[" + this.getJulianDate() + "], Iranian:[" + this.getIranianDateByDash() + "]";
    }

    public Date getGregorianDateTimeBySlashZero(String iranianDate, String time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        setIranianDateBySlash(iranianDate);
        try {
            return simpleDateFormat.parse(getGregorianDateBySlashZero() + " " + time);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
