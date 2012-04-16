package com.kwc.itfornebulunchapp.model;

/**
 * Created with IntelliJ IDEA.
 * User: Crea
 * Date: 16.04.12
 * Time: 22:04
 * To change this template use File | Settings | File Templates.
 */
public class DayMenu {
    public DayMenu(String weekday, String dish) {
        this.weekday = weekday;
        this.dish = dish;
    }

    String weekday;
    String dish;

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
