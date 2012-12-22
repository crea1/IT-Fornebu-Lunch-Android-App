package com.kwc.itfornebulunchapp.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import android.widget.RemoteViews;
import com.kwc.itfornebulunchapp.R;

import java.util.Random;

/**
 * @author Marius Kristensen
 * @since 1.3
 */
public class ITFornebuWidgetProvider extends AppWidgetProvider {

    private static final String LOGTAG = "LUNCHWIDGET";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        ComponentName lunchWidget = new ComponentName(context, ITFornebuWidgetProvider.class);
        int[] allWidgetIds = appWidgetManager.getAppWidgetIds(lunchWidget);

        for (int widgetId : allWidgetIds) {
            String updatedText = "someText :D " +new Random().nextInt(100);

            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);

            Log.w(LOGTAG, "updating widet with text: " + updatedText);
            //Update widget text
            remoteViews.setTextViewText(R.id.update, updatedText);

            // Update the widget
            appWidgetManager.updateAppWidget(widgetId, remoteViews);
        }
    }
}
