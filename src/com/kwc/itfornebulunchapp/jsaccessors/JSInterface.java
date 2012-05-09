package com.kwc.itfornebulunchapp.jsaccessors;

import android.webkit.WebView;
import com.kwc.itfornebulunchapp.handlers.DateHandler;
import com.kwc.itfornebulunchapp.handlers.LunchDecoder;

/**
 * JSInteface.
 * This handles the function calls between the javascript
 * in the html and the java.
 * @since 1.0
 * @author Marius Kristensen
 */

public class JSInterface {

    /**
     * WebView.
     */
    private WebView webView;

    /**
     * Constructor.
     * @param webView input WebView
     */
    public JSInterface(final WebView webView) {
        this.webView = webView;
    }

    /**
     * Calls a JavaScript function to retrieve the menu.
     */
    public void callJson() {
        webView.loadUrl("javascript:getJSONMenu()");
    }

    /**
     * Calls a javascript function that updates the html.
     */
   public void callUpdate() {
        webView.loadUrl("javascript:updateThis()");
    }

    /**
     * Returns a JSON formatted menu object to HTML.
     * @return JSON Object in String format.
     */
    public String loadMenu() {
        return LunchDecoder.jsonWeekMenuFormatter();
    }

    public int getWeekdayNumber() {
        return DateHandler.getWeekDayByNumber();
    }
}
