package com.example.buttonDemo;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;

/**
 * Created by SB on 10.09.15.
 */
public class Utils {

    public static synchronized void wakeUp(Context context)
    {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);


        PowerManager.WakeLock wakeLock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK
                | PowerManager.ACQUIRE_CAUSES_WAKEUP
                | PowerManager.ON_AFTER_RELEASE, "MyWakeLock");
        wakeLock.acquire();
        KeyguardManager km = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);

        final KeyguardManager.KeyguardLock kl = km .newKeyguardLock("MyKeyguardLock");
        kl.disableKeyguard();

        wakeLock.release();

    }
}
