package com.kwc.itfornebulunchapp.view.javascriptInterface;

import android.webkit.WebView;
import com.kwc.itfornebulunchapp.LunsjActivity;
import com.kwc.itfornebulunchapp.controllers.DateHandler;
import com.kwc.itfornebulunchapp.controllers.MenuJsonEncoder;
import com.kwc.itfornebulunchapp.service.WeekMenuService;

/**
 * JSInteface.
 * This handles the function calls between the javascript
 * in the html and the java.
 *
 * Note: To call a javascript function from java part. Use this
 * webView.loadUrl("javascript:getJSONMenu()");
 *
 * @since 1.0
 * @author Marius Kristensen
 */

public class JSInterface {

    /**
     * WebView.
     */
    private WebView webView;
    private WeekMenuService weekMenuService;

    /**
     * Constructor.
     * @param webView input WebView
     */
    public JSInterface(final WebView webView) {
        this.webView = webView;
        weekMenuService = new WeekMenuService();
    }

    /**
     * Returns a JSON formatted menu object to HTML.
     * @return JSON Object in String format.
     */
    @SuppressWarnings("unused")
    public String loadMenu() {
        return weekMenuService.getWeekMenuJsonString();
    }

    public int getWeekdayNumber() {
        return DateHandler.getWeekDayByNumber();
    }
}
