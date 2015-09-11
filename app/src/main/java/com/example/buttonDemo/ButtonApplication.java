package com.example.buttonDemo;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

/**
 * Created by SB on 07.09.15.
 */
public class ButtonApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Log.wtf("mediabuttonintentrec", "ButtonApplication.onCreate()");
        Intent serviceIntent = new Intent(this, ApplicationService.class);
        startService(serviceIntent);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

    }
}
