package com.kwc.itfornebulunchapp.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * @since 1.0
 * @author Marius Kristensen
 */
public class AlertBox {

    private static Context context;

    public AlertBox(Context context) {
        if (this.context == null) {
            this.context = context;
        }
    }

    /**
     * Displays an alertbox.
     * @param title the alertbox title.
     * @param message the message to be displayed.
     */
    public static void alertBox(String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // do some stuff here?
            }
        });
        alertDialog.show();
    }
}
