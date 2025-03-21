package com.dexterous.flutterlocalnotifications;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationManagerCompat;
import com.dexterous.flutterlocalnotifications.models.NotificationDetails;
import com.dexterous.flutterlocalnotifications.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class ScheduledNotificationReceiver extends BroadcastReceiver {
    private static final String TAG = "ScheduledNotifReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Notification notification;
        String notificationDetailsJson = intent.getStringExtra(FlutterLocalNotificationsPlugin.NOTIFICATION_DETAILS);
        if (StringUtils.isNullOrEmpty(notificationDetailsJson).booleanValue()) {
            int notificationId = intent.getIntExtra("notification_id", 0);
            if (Build.VERSION.SDK_INT >= 33) {
                notification = (Notification) intent.getParcelableExtra("notification", Notification.class);
            } else {
                notification = (Notification) intent.getParcelableExtra("notification");
            }
            if (notification == null) {
                FlutterLocalNotificationsPlugin.removeNotificationFromCache(context, Integer.valueOf(notificationId));
                Log.e(TAG, "Failed to parse a notification from  Intent. ID: " + notificationId);
                return;
            }
            notification.when = System.currentTimeMillis();
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
            notificationManager.notify(notificationId, notification);
            boolean repeat = intent.getBooleanExtra("repeat", false);
            if (!repeat) {
                FlutterLocalNotificationsPlugin.removeNotificationFromCache(context, Integer.valueOf(notificationId));
                return;
            }
            return;
        }
        Gson gson = FlutterLocalNotificationsPlugin.buildGson();
        Type type = new TypeToken<NotificationDetails>() { // from class: com.dexterous.flutterlocalnotifications.ScheduledNotificationReceiver.1
        }.getType();
        NotificationDetails notificationDetails = (NotificationDetails) gson.fromJson(notificationDetailsJson, type);
        FlutterLocalNotificationsPlugin.showNotification(context, notificationDetails);
        FlutterLocalNotificationsPlugin.scheduleNextNotification(context, notificationDetails);
    }
}
