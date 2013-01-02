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
            DayMenu todaysMenu = weekMenuService.getTodaysDish();
            String updatedDish = todaysMenu.getDish();

            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);

            Log.d(LOGTAG, "updating widget with text: " + updatedDish);
            //Update widget text
            remoteViews.setTextViewText(R.id.update, todaysMenu.getDish());
            remoteViews.setTextViewText(R.id.day, todaysMenu.getWeekday());

            // OnClickListener
            //setupOnClickListener(context, appWidgetIds, remoteViews);

            // Update the widget
            appWidgetManager.updateAppWidget(widgetId, remoteViews);
        }
    }

    private void setupOnClickListener(Context context, int[] appWidgetIds, RemoteViews remoteViews) {

        // The onclick should load the main activity
        Intent intent = new Intent(context, LunsjActivity.class);
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        remoteViews.setOnClickPendingIntent(R.id.update, pendingIntent);
    }
}
