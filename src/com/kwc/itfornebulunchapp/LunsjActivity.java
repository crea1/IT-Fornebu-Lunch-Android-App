package com.kwc.itfornebulunchapp;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.webkit.WebView;

import java.io.IOException;


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



        HTMLAssembler htmlAssembler = new HTMLAssembler(LunsjDecoder.getLunsj(), DateHandler.getWeekDayByNumber());

        String html = htmlAssembler.getTheMenu();

        webView.loadData(html, mimetype, encoding);

    }



}
