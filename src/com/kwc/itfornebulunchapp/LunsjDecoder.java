package com.kwc.itfornebulunchapp;

import com.kwc.itfornebulunchapp.model.DayMenu;
import com.kwc.itfornebulunchapp.model.WeekMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: marhaukri
 * Date: 19.03.12
 * Time: 10:59
 * To change this template use File | Settings | File Templates.
 */
public class LunsjDecoder {
    public static WeekMenu getLunsj() {
        WeekMenu theWeekMenu = new WeekMenu();
        String url = "http://leietaker.itfornebu.no/itfornebu/kantinemeny";
        String line, s1 = "", s2 ="";
        StringBuilder content = new StringBuilder();
        HashMap<String,String> menu = new HashMap<String, String>();

        // Read url content into StringBuilder
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            //return "O'oh! Noe feilet under henting av lunsj";
        }

        // Regexp to find related html
        String expr = "<span class=\"menu_title\">"
                + "(.*?)"
                + "</span>.*?"
                + "<span class=\"menu_body\"><p>"
                + "(.*?)"
                + "</p></span>";
        Pattern patt = Pattern.compile(expr);
        Matcher matt = patt.matcher(content.toString());
        while (matt.find()) {
            // put unsorted items into menu
            menu.put(matt.group(1).toLowerCase().trim(), matt.group(2));
        }

        theWeekMenu.setMonday(new DayMenu("Monday",menu.get("mandag")));
        theWeekMenu.setTuesday(new DayMenu("Tuesday", menu.get("tirsdag")));
        theWeekMenu.setWednesday(new DayMenu("Wednesday", menu.get("onsdag")));
        theWeekMenu.setThursday(new DayMenu("Thursday", menu.get("torsdag")));
        theWeekMenu.setFriday(new DayMenu("Friday", menu.get("fredag")));

        return theWeekMenu;
    }

    /**
     * dayOfTheWeek
     * This method finds todays weekday and translates it to the corresponding
     * norwegian date
     * @return
     */
    private static HashMap<Integer, String> dayOfTheWeek() {
        Calendar cal = new GregorianCalendar();
        HashMap<Integer,String> m = new HashMap<Integer, String>();
        m.put(2,"mandag");
        m.put(3,"tirsdag");
        m.put(4,"onsdag");
        m.put(5,"torsdag");
        m.put(6,"fredag");
        m.put(7,"lørdag");
        m.put(1,"søndag");
        int day = cal.get(Calendar.DAY_OF_WEEK);
        return m;
    }
}
