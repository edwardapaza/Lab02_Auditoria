package com.dexterous.flutterlocalnotifications;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ForegroundService extends Service {
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        ForegroundServiceStartParameter parameter;
        if (Build.VERSION.SDK_INT >= 33) {
            parameter = (ForegroundServiceStartParameter) intent.getSerializableExtra(ForegroundServiceStartParameter.EXTRA, ForegroundServiceStartParameter.class);
        } else {
            parameter = (ForegroundServiceStartParameter) intent.getSerializableExtra(ForegroundServiceStartParameter.EXTRA);
        }
        Notification notification = FlutterLocalNotificationsPlugin.createNotification(this, parameter.notificationData);
        if (parameter.foregroundServiceTypes != null && Build.VERSION.SDK_INT >= 29) {
            startForeground(parameter.notificationData.id.intValue(), notification, orCombineFlags(parameter.foregroundServiceTypes));
        } else {
            startForeground(parameter.notificationData.id.intValue(), notification);
        }
        return parameter.startMode;
    }

    private static int orCombineFlags(ArrayList<Integer> flags) {
        int flag = flags.get(0).intValue();
        for (int i = 1; i < flags.size(); i++) {
            flag |= flags.get(i).intValue();
        }
        return flag;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
