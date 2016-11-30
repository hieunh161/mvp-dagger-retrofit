package vn.com.ndd.presentation.view.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by hieunh on 11/27/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public class ScreenReceiver extends BroadcastReceiver {
    public static boolean isScreenOn = true;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            // DO WHATEVER YOU NEED TO DO HERE
            isScreenOn = false;
        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            // AND DO WHATEVER YOU NEED TO DO HERE
            isScreenOn = true;
        }
    }
}
