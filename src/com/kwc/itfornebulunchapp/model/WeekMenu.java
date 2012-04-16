package com.kwc.itfornebulunchapp.model;

/**
 * Created with IntelliJ IDEA.
 * User: Crea
 * Date: 16.04.12
 * Time: 21:57
 * To change this template use File | Settings | File Templates.
 */
public class WeekMenu {
    private DayMenu monday;
    private DayMenu tuesday;
    private DayMenu wednesday;
    private DayMenu thursday;
    private DayMenu friday;
    private DayMenu saturday;
    private DayMenu sunday;

    public DayMenu getMonday() {
        return monday;
    }

    public void setMonday(DayMenu monday) {
        this.monday = monday;
    }

    public DayMenu getTuesday() {
        return tuesday;
    }

    public void setTuesday(DayMenu tuesday) {
        this.tuesday = tuesday;
    }

    public DayMenu getWednesday() {
        return wednesday;
    }

    public void setWednesday(DayMenu wednesday) {
        this.wednesday = wednesday;
    }

    public DayMenu getThursday() {
        return thursday;
    }

    public void setThursday(DayMenu thursday) {
        this.thursday = thursday;
    }

    public DayMenu getFriday() {
        return friday;
    }

    public void setFriday(DayMenu friday) {
        this.friday = friday;
    }

    public DayMenu getSaturday() {
        return saturday;
    }

    public void setSaturday(DayMenu saturday) {
        this.saturday = saturday;
    }

    public DayMenu getSunday() {
        return sunday;
    }

    public void setSunday(DayMenu sunday) {
        this.sunday = sunday;
    }
}
