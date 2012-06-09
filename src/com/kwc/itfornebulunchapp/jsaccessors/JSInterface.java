package com.kwc.itfornebulunchapp.jsaccessors;

import android.webkit.WebView;
import com.kwc.itfornebulunchapp.LunsjActivity;
import com.kwc.itfornebulunchapp.handlers.DateHandler;
import com.kwc.itfornebulunchapp.handlers.LunchDecoder;

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

    /**
     * Constructor.
     * @param webView input WebView
     */
    public JSInterface(final WebView webView) {
        this.webView = webView;
    }

    /**
     * Returns a JSON formatted menu object to HTML.
     * @return JSON Object in String format.
     */
    @SuppressWarnings("unused")
    public String loadMenu() {
        if (!LunsjActivity.internalStorage.fileExists()) {
            LunsjActivity.internalStorage.writeToFile(LunchDecoder.jsonWeekMenuFormatter());
        }
        return LunsjActivity.internalStorage.readFromFile();
        //return LunchDecoder.jsonWeekMenuFormatter();
    }

    public int getWeekdayNumber() {
        return DateHandler.getWeekDayByNumber();
    }
}
