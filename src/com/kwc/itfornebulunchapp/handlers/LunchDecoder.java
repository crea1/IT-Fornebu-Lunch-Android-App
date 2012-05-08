package com.kwc.itfornebulunchapp.handlers;

import com.kwc.itfornebulunchapp.LunsjActivity;
import com.kwc.itfornebulunchapp.model.WeekMenu;
import com.kwc.itfornebulunchapp.utils.AlertBox;

/**
 * LunchDecoder.
 * @since 1.0
 * @author Marius Kristensen
 */

public final class LunchDecoder {
    private LunchDecoder() {
    }

    /**
     * This method reads the HTML from the Lunch page at itfornebu.no
     * and searches for the menu using a regexp. It then sorts the
     * data to the different weekdays.
     * @return WeekMenu object
     */
    private static WeekMenu getLunch() {
        // Get HTML
        String content = DataFetcher.fetchHTML();

        if (content != null) {
            return DataSorter.sortLunchData(content);
        } else {
            //todo add some error handling here.
            System.out.println("********************************");
            return null;
        }
    }

    /**
     * Formats the internal java menu-object to a Json-object.
     * @return JSON-formatted string.
     */
    public static String jsonWeekMenuFormatter() {
        WeekMenu menu = getLunch();
        String s =
        "{"
        + "\"Monday\":\"" + menu.getMonday().getDish() + "\","
        + "\"Tuesday\":\"" + menu.getTuesday().getDish() + "\","
        + "\"Wednesday\":\"" + menu.getWednesday().getDish() + "\","
        + "\"Thursday\":\"" + menu.getThursday().getDish() + "\","
        + "\"Friday\":\"" + menu.getFriday().getDish() + "\""
        + "}";
        return s;
    }


}
