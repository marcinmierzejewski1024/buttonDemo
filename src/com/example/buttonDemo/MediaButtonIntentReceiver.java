package com.example.buttonDemo;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

/**
 * Created by SB on 07.09.15.
 */
public class MediaButtonIntentReceiver extends BroadcastReceiver{

    static MediaButtonIntentReceiver instance;
    public static synchronized MediaButtonIntentReceiver getInstance(){
        if(instance == null)
            instance = new MediaButtonIntentReceiver();

        return instance;
    }

    public MediaButtonIntentReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {

//        String intentAction = intent.getAction();

//        Log.wtf("mediabuttonintentrec","on Receive()"+intentAction);
//
//        Toast.makeText(context, "BUTTON PRESSED!", Toast.LENGTH_SHORT).show();
//
//        if (!Intent.ACTION_MEDIA_BUTTON.equals(intentAction)) {
//            return;
//        }
//        KeyEvent event = (KeyEvent)intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
//        if (event == null) {
//            return;
//        }
//        int action = event.getAction();
//        //if (action == KeyEvent.ACTION_DOWN) {
//
//            Utils.wakeUp(context);
//            Intent activityIntent = new Intent(context, MyActivity.class);
//            activityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//            context.startActivity(activityIntent);
//
//
//
//        //}
////        abortBroadcast();
    }









}