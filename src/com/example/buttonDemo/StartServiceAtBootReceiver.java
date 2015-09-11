package com.example.buttonDemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by SB on 08.09.15.
 */
public class StartServiceAtBootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.wtf("startServiceAtBootReceiver","onReceive()");
        Intent serviceIntent = new Intent(context, ApplicationService.class);
        context.startService(serviceIntent);
    }
}
