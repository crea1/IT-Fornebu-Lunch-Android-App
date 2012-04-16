package com.kwc.itfornebulunchapp;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class LunsjActivity extends Activity    
{
    final String mimetype = "text/html";
    final String encoding = "UTF-8";
    private WebView webView = null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        //webView.loadUrl("file:///android_asset/www/index.html");
        //HTMLAssembler htmlAssembler = new HTMLAssembler(LunsjDecoder.getLunsj());
        String html = "<html><body><h3>"+LunsjDecoder.getLunsj()+"<h3></body></html>";
        //String html = htmlAssembler.getTheMenu();
        System.out.println(html);
        webView.loadData(html, mimetype, encoding);

    }
}
