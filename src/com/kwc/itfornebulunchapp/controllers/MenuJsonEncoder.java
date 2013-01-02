package com.kwc.itfornebulunchapp.controllers;

import com.kwc.itfornebulunchapp.model.WeekMenu;
import com.kwc.itfornebulunchapp.service.WeekMenuService;

/**
 * MenuJsonEncoder.
 * @since 1.0
 * @author Marius Kristensen
 */

public final class MenuJsonEncoder {
    private MenuJsonEncoder() {
    }

    /**
     * Formats the internal java menu-object to a Json-object.
     * @return JSON-formatted string.
     */
    public static String jsonWeekMenuFormatter() {
        WeekMenuService weekMenuStuff = new WeekMenuService();

        WeekMenu menu = weekMenuStuff.getWeekMenu();
        String s =
        "{"
        + "\"Monday\":\"" + menu.getMonday().getDish() + "\","
        + "\"Tuesday\":\"" + menu.getTuesday().getDish() + "\","
        + "\"Wednesday\":\"" + menu.getWednesday().getDish() + "\","
        + "\"Thursday\":\"" + menu.getThursday().getDish() + "\","
        + "\"Friday\":\"" + menu.getFriday().getDish() + "\","
        + "\"Timestamp\":\"" + DateHandler.timestamp() + "\","
        + "\"DayOfWeek\":\"" + DateHandler.getWeekDayByNumber() + "\""
        + "}";
        return s;
    }


}
