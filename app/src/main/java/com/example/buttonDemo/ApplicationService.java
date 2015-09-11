package com.example.buttonDemo;

import android.app.IntentService;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by SB on 08.09.15.
 */
public class ApplicationService extends Service {

    BroadcastReceiver headsetClickReceiver;
    ScheduledExecutorService scheduleTaskExecutor;
    public ApplicationService() {
        super();
    }

    @Override
    public IBinder onBind(Intent intent) {

        Log.wtf("application service", "onBind" + intent);
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.wtf("application service", "onStartCommand" + intent);
        return START_STICKY;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        scheduleTaskExecutor = Executors.newScheduledThreadPool(1);
        //nalezy wykonwyac raz na jakis czas z powodu ze inna aplikacja moze zarejstrowac sie na mediabuttoneventreceiver odrejestrowujac nasza aplikacje!
        scheduleTaskExecutor.scheduleAtFixedRate(new Runnable() {
            public void run() {
                Log.wtf("service", "registering receivers ");
                IntentFilter filter = new IntentFilter(Intent.ACTION_MEDIA_BUTTON);
                headsetClickReceiver = MediaButtonIntentReceiver.getInstance();
                filter.setPriority(Integer.MAX_VALUE);
                registerReceiver(headsetClickReceiver, filter);
                ((AudioManager)getSystemService(AUDIO_SERVICE)).registerMediaButtonEventReceiver(new ComponentName(ApplicationService.this, MediaButtonIntentReceiver.class));
            }
        }, 0, 30, TimeUnit.SECONDS);
    }




    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.wtf("service", "unregistering receiver ondestroy()");
        this.unregisterReceiver(this.headsetClickReceiver);
    }
}
