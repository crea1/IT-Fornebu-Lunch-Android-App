package com.kwc.itfornebulunchapp.view.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import com.kwc.itfornebulunchapp.LunsjActivity;
import com.kwc.itfornebulunchapp.R;
import com.kwc.itfornebulunchapp.model.DayMenu;
import com.kwc.itfornebulunchapp.service.WeekMenuService;

/**
 * This class handles the 2x1 widget.
 *
 * @author Marius Kristensen
 * @since 1.3
 */
public class ITFornebuWidgetProvider extends AppWidgetProvider {

    private static final String LOGTAG = "ITFornebuLunchApp";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        ComponentName lunchWidget = new ComponentName(context, ITFornebuWidgetProvider.class);
        int[] allWidgetIds = appWidgetManager.getAppWidgetIds(lunchWidget);

        for (int widgetId : allWidgetIds) {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
            remoteViews.setTextViewText(R.id.update, "Oppdaterer...");
            appWidgetManager.updateAppWidget(widgetId, remoteViews);

            WeekMenuService weekMenuService = new WeekMenuService();
            DayMenu todaysMenu = weekMenuService.getTodaysDish();
            String updatedDish = todaysMenu.getDish();


            Log.d(LOGTAG, "updating widget(2x1) with text: " + updatedDish);
            //Update widget text
            remoteViews.setTextViewText(R.id.update, todaysMenu.getDish());
            remoteViews.setTextViewText(R.id.day, todaysMenu.getWeekday());

            // OnClickListener
            setupOnClickListener(context, appWidgetIds, remoteViews);

            // Update the widget
            appWidgetManager.updateAppWidget(widgetId, remoteViews);
        }
    }

    private void setupOnClickListener(Context context, int[] appWidgetIds, RemoteViews remoteViews) {

        // The onclick should load the main activity
        //Intent intent = new Intent(context, LunsjActivity.class);
        Intent intent = new Intent(context, ITFornebuWidgetProvider.class);
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

        //PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        remoteViews.setOnClickPendingIntent(R.id.smallWidgetLayout, pendingIntent);
    }
}
