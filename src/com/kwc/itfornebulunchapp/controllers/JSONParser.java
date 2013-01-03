package com.kwc.itfornebulunchapp.controllers;

import android.util.Log;
import com.kwc.itfornebulunchapp.model.DayMenu;
import com.kwc.itfornebulunchapp.model.WeekMenu;
import com.kwc.itfornebulunchapp.service.WeekMenuService;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * JSONParser.
 * @since 1.0
 * @author Marius Kristensen
 */

public final class JSONParser {

    private static final String LOGTAG = "ITFornebuLunchApp";

    private static final String TAG_MONDAY = "Monday";
    private static final String TAG_TUESDAY = "Tuesday";
    private static final String TAG_WEDNESDAY = "Wednesday";
    private static final String TAG_THURSDAY = "Thursday";
    private static final String TAG_FRIDAY = "Friday";
    private static final String TAG_TIMESTAMP = "Timestamp";

    /**
     * Formats the internal java menu-object to a Json-object.
     * @return JSON-formatted string.
     */
    public String weekMenuToJSON(WeekMenu weekMenu) {

        String json =
        "{"
        + "\"Monday\":\"" + weekMenu.getMonday().getDish() + "\","
        + "\"Tuesday\":\"" + weekMenu.getTuesday().getDish() + "\","
        + "\"Wednesday\":\"" + weekMenu.getWednesday().getDish() + "\","
        + "\"Thursday\":\"" + weekMenu.getThursday().getDish() + "\","
        + "\"Friday\":\"" + weekMenu.getFriday().getDish() + "\","
        + "\"Timestamp\":\"" + weekMenu.getTimestamp() + "\","
        + "\"DayOfWeek\":\"" + DateHandler.getWeekDayByNumber() + "\""
        + "}";
        return json;
    }

    /**
     *
     * @param weekMenuJSONFormatted a json formatted string.
     * @return WeekMenu
     */
    public WeekMenu parseJSONToWeekMenu(String weekMenuJSONFormatted) {
        WeekMenu weekMenu = new WeekMenu(DateHandler.timestamp());
        try {
            JSONObject json = new JSONObject(weekMenuJSONFormatted);
            DayMenu monday = new DayMenu("Mandag", json.getString(TAG_MONDAY),2);
            weekMenu.setTuesday(new DayMenu("Tirsdag", json.getString(TAG_TUESDAY), 3));
            weekMenu.setWednesday(new DayMenu("Onsdag", json.getString(TAG_WEDNESDAY), 4));
            weekMenu.setThursday(new DayMenu("Torsdag", json.getString(TAG_THURSDAY), 5));
            weekMenu.setFriday(new DayMenu("Fredag", json.getString(TAG_FRIDAY), 6));
            weekMenu.setTimestamp(json.getString(TAG_TIMESTAMP));
            Log.d(LOGTAG, "Parsed json object to weekmenu object.");
        } catch (JSONException e) {
            Log.e(LOGTAG, "Failed to parse json object. " +weekMenuJSONFormatted);
        }

        return weekMenu;
    }


}
