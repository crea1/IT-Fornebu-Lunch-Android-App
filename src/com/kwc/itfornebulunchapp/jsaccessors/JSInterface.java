package com.kwc.itfornebulunchapp.jsaccessors;

import android.webkit.WebView;
import com.kwc.itfornebulunchapp.LunsjDecoder;

/**
 * Created with IntelliJ IDEA.
 * User: Crea
 * Date: 02.05.12
 * Time: 19:03
 * To change this template use File | Settings | File Templates.
 */
public class JSInterface {

    private WebView webView;

    public JSInterface(WebView webView)
    {
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
        return LunsjDecoder.JSONWeekMenu();
    }
}
