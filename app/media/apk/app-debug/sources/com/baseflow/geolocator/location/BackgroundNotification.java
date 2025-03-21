package com.baseflow.geolocator.location;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
/* loaded from: classes2.dex */
public class BackgroundNotification {
    private NotificationCompat.Builder builder;
    private final String channelId;
    private final Context context;
    private final Integer notificationId;

    public BackgroundNotification(Context context, String channelId, Integer notificationId, ForegroundNotificationOptions options) {
        this.context = context;
        this.notificationId = notificationId;
        this.channelId = channelId;
        this.builder = new NotificationCompat.Builder(context, channelId).setPriority(1);
        updateNotification(options, false);
    }

    private int getDrawableId(String iconName, String defType) {
        return this.context.getResources().getIdentifier(iconName, defType, this.context.getPackageName());
    }

    private PendingIntent buildBringToFrontIntent() {
        Intent intent = this.context.getPackageManager().getLaunchIntentForPackage(this.context.getPackageName());
        if (intent == null) {
            return null;
        }
        intent.setPackage(null);
        intent.setFlags(270532608);
        int flags = Build.VERSION.SDK_INT > 23 ? 134217728 | AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 134217728;
        return PendingIntent.getActivity(this.context, 0, intent, flags);
    }

    public void updateChannel(String channelName) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this.context);
            NotificationChannel channel = new NotificationChannel(this.channelId, channelName, 0);
            channel.setLockscreenVisibility(0);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void updateNotification(ForegroundNotificationOptions options, boolean notify) {
        int iconId = getDrawableId(options.getNotificationIcon().getName(), options.getNotificationIcon().getDefType());
        if (iconId == 0) {
            getDrawableId("ic_launcher.png", "mipmap");
        }
        this.builder = this.builder.setContentTitle(options.getNotificationTitle()).setSmallIcon(iconId).setContentText(options.getNotificationText()).setContentIntent(buildBringToFrontIntent()).setOngoing(options.isSetOngoing());
        Integer notificationColor = options.getColor();
        if (notificationColor != null) {
            this.builder = this.builder.setColor(notificationColor.intValue());
        }
        if (notify) {
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this.context);
            notificationManager.notify(this.notificationId.intValue(), this.builder.build());
        }
    }

    public void updateOptions(ForegroundNotificationOptions options, boolean isVisible) {
        updateNotification(options, isVisible);
    }

    public Notification build() {
        return this.builder.build();
    }
}
