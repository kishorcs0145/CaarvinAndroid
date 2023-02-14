package com.caarvin.Utils;

import android.content.Context;
import android.widget.Toast;

public class Utilities {

    //for toast
    public static void showToast(Context screenObj, String alertMsg) {
        Toast.makeText(screenObj, alertMsg, Toast.LENGTH_SHORT).show();
    }
}
