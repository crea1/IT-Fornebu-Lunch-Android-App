package com.kwc.itfornebulunchapp.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import com.kwc.itfornebulunchapp.R;
import com.kwc.itfornebulunchapp.service.WeekMenuService;

import java.util.Random;

/**
 * This class handles the widget.
 *
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
            WeekMenuService weekMenuService = new WeekMenuService();
            String updatedText = weekMenuService.getTodaysDish();

            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);

            Log.d(LOGTAG, "updating widget with text: " + updatedText);
            //Update widget text
            remoteViews.setTextViewText(R.id.update, updatedText);

            // OnClickListener
            setupOnClickListener(context, appWidgetIds, remoteViews);

            // Update the widget
            appWidgetManager.updateAppWidget(widgetId, remoteViews);
        }
    }

    private void setupOnClickListener(Context context, int[] appWidgetIds, RemoteViews remoteViews) {
        Intent intent = new Intent(context, ITFornebuWidgetProvider.class);

        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        remoteViews.setOnClickPendingIntent(R.id.update, pendingIntent);
    }
}
