package ru.mirea.smelkin.hw;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

public class MyProgresDialog {
    public MyProgresDialog(Context context) {
        ProgressDialog pd = new ProgressDialog(context);
        pd.setTitle("Title");
        pd.setMessage("Message");
        pd.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        pd.show();
    }
}
