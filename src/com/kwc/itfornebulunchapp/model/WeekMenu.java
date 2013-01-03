package com.kwc.itfornebulunchapp.model;

/**
 * WeekMeny holds all the weeks dishes.
 * @since 1.0
 * @author Marius Kristensen
 */
public class WeekMenu {
    private DayMenu monday;
    private DayMenu tuesday;
    private DayMenu wednesday;
    private DayMenu thursday;
    private DayMenu friday;
    private DayMenu saturday;
    private DayMenu sunday;
    private String timestamp;

    public WeekMenu(String timestamp) {
        this.timestamp = timestamp;
    }

    public final DayMenu getMonday() {
        return monday;
    }

    public final void setMonday(final DayMenu monday) {
        this.monday = monday;
    }

    public final DayMenu getTuesday() {
        return tuesday;
    }

    public final void setTuesday(final DayMenu tuesday) {
        this.tuesday = tuesday;
    }

    public final DayMenu getWednesday() {
        return wednesday;
    }

    public final void setWednesday(final DayMenu wednesday) {
        this.wednesday = wednesday;
    }

    public final DayMenu getThursday() {
        return thursday;
    }

    public final void setThursday(final DayMenu thursday) {
        this.thursday = thursday;
    }

    public final DayMenu getFriday() {
        return friday;
    }

    public final void setFriday(final DayMenu friday) {
        this.friday = friday;
    }

    public final DayMenu getSaturday() {
        return saturday;
    }

    public final void setSaturday(final DayMenu saturday) {
        this.saturday = saturday;
    }

    public final DayMenu getSunday() {
        return sunday;
    }

    public final void setSunday(final DayMenu sunday) {
        this.sunday = sunday;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
