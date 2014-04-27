package com.protodx.notifier;

import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

/**
 * Notification subclass to fire off light
 * requests when status bar changes
 */
public class NotificationListener extends NotificationListenerService {

    private static final String ETH_URL = "http://192.168.0.10:3000/notice?duration=10";

    private static final String WIFI_URL = "http://192.168.0.2:3000/notice?duration=10";

    private static final boolean DBG = true;

    private static final String TAG = "NotificationListener";

    @Override
    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        if(DBG){
            Log.d(TAG, "onNotificationPosted()");
        }
        LightLightsTask task = new LightLightsTask();
        task.execute(ETH_URL);
        task.execute(WIFI_URL);
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification statusBarNotification) {
        if(DBG){
            Log.d(TAG, "onNotificationRemoved()");
        }
    }
}