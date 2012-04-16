package com.kwc.itfornebulunchapp;

import com.kwc.itfornebulunchapp.model.DayMenu;
import com.kwc.itfornebulunchapp.model.WeekMenu;

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
    public HTMLAssembler(WeekMenu weekMenu) {
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
        page.append("<link href=\"/assets/www/lunsj.css\" rel=\"stylesheet\" type=\"text/css\" />");
        page.append("</head>");
        page.append("<body>");
        page.append("<div id=\"container\">");
        return page.toString();
    }
    private String aDish(DayMenu dayMenu) {
        return  "<h4>"+dayMenu.getWeekday()+"</h4>" +
                "<span class=\"dish\">"+dayMenu.getDish()+"</span></p>";
    }

    private String footer() {
        StringBuilder page = new StringBuilder();
        page.append("</div>"); // end of container
        page.append("</body>");
        page.append("</html>");

        return page.toString();
    }
}
