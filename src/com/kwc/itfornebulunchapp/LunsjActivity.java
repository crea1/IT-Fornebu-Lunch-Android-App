package com.kwc.itfornebulunchapp;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.kwc.itfornebulunchapp.jsaccessors.JSInterface;


//http://code.google.com/p/myandroidwidgets/source/browse/#svn%2Ftrunk%2FJQueryExample
//http://techdroid.kbeanie.com/2010/10/android-webview-javascript-and-css.html

/**
 * The main activity.
 * @since 1.0
 * @author Marius Kristensen
 */

public class LunsjActivity extends Activity {

    private WebView webView = null;
    private static final String LOG_TAG = "ITFORNEBU-LUNCH";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("file:///android_asset/www/index.html");

        //Javascript accessors
        JSInterface jsInterface = new JSInterface(webView);
        webView.addJavascriptInterface(jsInterface, "jsinterface");

    }
}

