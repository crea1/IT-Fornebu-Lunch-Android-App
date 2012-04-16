package com.kwc.itfornebulunchapp;

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
    public HTMLAssembler(HashMap<String, String> lunsj) {
        StringBuilder theMenu = new StringBuilder();
        theMenu.append(header());
        theMenu.append("The Menu");
       // for(String s : lunsj.keySet()) {
         //   theMenu.append(aDish(s,lunsj.get(s)));
       //    }
        theMenu.append(footer());
    }
    public String getTheMenu() {
        return theMenu.toString();
    }

    private String header() {
        StringBuilder page = new StringBuilder();
       // page.append("<!DOCTYPE html>");
        page.append("<html><head><title>IT Fornebu Lunsj</title>");
       // page.append("<link href=\"/assets/www/lunsj.css\" rel=\"stylesheet\" type=\"text/css\" />");
        page.append("</head>");
        page.append("<body>");
        page.append("<div id=\"container\">");
        return page.toString();
    }
    private String aDish(String day, String dish) {
        StringBuilder page = new StringBuilder();
        page.append("<p><span class=\"day\">"+day+"</span>");
        page.append("<span class=\"dish\">"+dish+"</span></p>");
        return page.toString();
    }

    private String footer() {
        StringBuilder page = new StringBuilder();
        page.append("</div>"); // end of container
        page.append("</body>");
        page.append("</html>");

        return page.toString();
    }
}
