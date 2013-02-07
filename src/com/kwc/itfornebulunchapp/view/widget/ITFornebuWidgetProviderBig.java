package com.kwc.itfornebulunchapp.view.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;
import com.kwc.itfornebulunchapp.LunsjActivity;
import com.kwc.itfornebulunchapp.R;
import com.kwc.itfornebulunchapp.model.DayMenu;
import com.kwc.itfornebulunchapp.service.WeekMenuService;

/**
 * This class handles the big 4x1 widget.
 *
 * @author Marius Kristensen
 * @since 1.3
 */
public class ITFornebuWidgetProviderBig extends AppWidgetProvider {

    private static final String LOGTAG = "ITFornebuLunchApp";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        ComponentName lunchWidget = new ComponentName(context, ITFornebuWidgetProviderBig.class);
        int[] allWidgetIds = appWidgetManager.getAppWidgetIds(lunchWidget);

        for (int widgetId : allWidgetIds) {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_big_layout);

            WeekMenuService weekMenuService = new WeekMenuService();
            remoteViews.setImageViewResource(R.id.updateWidgetButton, R.drawable.ic_menu_block);
            appWidgetManager.updateAppWidget(widgetId, remoteViews);
            DayMenu todaysMenu = weekMenuService.getTodaysDish();
            String updatedDish = todaysMenu.getDishWithoutHTML();


            Log.d(LOGTAG, "updating widget(4x1) with text: " + updatedDish);
            //Update widget text
            remoteViews.setTextViewText(R.id.update, updatedDish);
            remoteViews.setTextViewText(R.id.day, todaysMenu.getWeekday());
            remoteViews.setImageViewResource(R.id.updateWidgetButton, R.drawable.ic_menu_refresh);

            // OnClickListener
            Intent intent = new Intent(context, ITFornebuWidgetProviderBig.class);
            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            remoteViews.setOnClickPendingIntent(R.id.updateWidgetButton, pendingIntent);

            // Update the widget
            appWidgetManager.updateAppWidget(widgetId, remoteViews);
        }
    }
}
