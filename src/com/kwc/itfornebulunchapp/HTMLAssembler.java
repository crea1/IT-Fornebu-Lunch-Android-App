package com.kwc.itfornebulunchapp;

import com.kwc.itfornebulunchapp.model.DayMenu;
import com.kwc.itfornebulunchapp.model.WeekMenu;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: marhaukri
 * Date: 19.03.12
 * Time: 12:00
 * To change this template use File | Settings | File Templates.
 */
public class HTMLAssembler {
    private StringBuilder theMenu = new StringBuilder();
    private int dayOfWeek = 0;

    public HTMLAssembler(WeekMenu weekMenu,int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        theMenu.append(header());

        theMenu.append("<h3>The Menu</h3>");

        theMenu.append(aDish(weekMenu.getMonday()));
        theMenu.append(aDish(weekMenu.getTuesday()));
        theMenu.append(aDish(weekMenu.getWednesday()));
        theMenu.append(aDish(weekMenu.getThursday()));
        theMenu.append(aDish(weekMenu.getFriday()));

        theMenu.append(footer());
    }
    public String getTheMenu() {
        return theMenu.toString();
    }

    private String header() {
        StringBuilder page = new StringBuilder();
        page.append("<!DOCTYPE html>");
        page.append("<html><head><title>IT Fornebu Lunsj</title>");
        page.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
        page.append("<link href=\"lunsj.css\" rel=\"stylesheet\" type=\"text/css\" />");
        page.append("</head>");
        page.append("<body>");


            File f = new File("lunsj.css");


            //URL u = getClass().getProtectionDomain().getCodeSource().getLocation();
            //page.append(u);


        page.append("<div id=\"container\">");
        return page.toString();
    }
    private String aDish(DayMenu dayMenu) {
        String dayHeader =  "<h4>"+dayMenu.getWeekday()+"</h4>";
        String dayDish = "<span class=\"dish\">"+dayMenu.getDish()+"</span>";
        if (dayMenu.getDayOfWeek() == dayOfWeek) {
            dayHeader =  "<h4 style=\"background-color: #FF69B4\">"+dayMenu.getWeekday()+"</h4>";
        }

        return  dayHeader + dayDish;

    }

    private String footer() {
        StringBuilder page = new StringBuilder();
        page.append("</div>"); // end of container
        page.append("</body>");
        page.append("</html>");

        return page.toString();
    }
}
