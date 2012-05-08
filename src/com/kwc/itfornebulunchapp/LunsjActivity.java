package com.kwc.itfornebulunchapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.*;
import com.kwc.itfornebulunchapp.jsaccessors.JSInterface;


//http://code.google.com/p/myandroidwidgets/source/browse/#svn%2Ftrunk%2FJQueryExample
//http://techdroid.kbeanie.com/2010/10/android-webview-javascript-and-css.html


public class LunsjActivity extends Activity    
{
    final String mimetype = "text/html";
    final String encoding = "UTF-8";
    private WebView webView = null;
    private static final String LOG_TAG = "ITFORNEBU-LUNCH";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("file:///android_asset/www/index.html");

        //Javascript accessors
        JSInterface jsInterface = new JSInterface(webView);
        webView.addJavascriptInterface(jsInterface, "jsinterface");

    }



    /**
     * Provides a hook for calling "alert" from javascript. Useful for
     * debugging your javascript.
     */
    final class MyWebChromeClient extends WebChromeClient {
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            Log.d(LOG_TAG, message);
            result.confirm();
            return true;
        }
    }



}

