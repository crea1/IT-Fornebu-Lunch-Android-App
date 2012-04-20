package com.kwc.itfornebulunchapp.model;

/**
 * Created with IntelliJ IDEA.
 * User: Crea
 * Date: 16.04.12
 * Time: 22:04
 * To change this template use File | Settings | File Templates.
 */
public class DayMenu {
    int dayOfWeek;
    String weekday;
    String dish;

    /**
     * Constructor
     * @param weekday - Name of day in String
     * @param dish What dish is served on this day
     * @param dayOfWeek Weekday number (i.e 1=monday, 2=tuesday)
     */
    public DayMenu(String weekday, String dish,int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        this.weekday = weekday;
        this.dish = dish;
    }

    public void setdayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }
}
