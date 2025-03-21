package com.dexterous.flutterlocalnotifications;

import com.dexterous.flutterlocalnotifications.models.NotificationDetails;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ForegroundServiceStartParameter implements Serializable {
    public static final String EXTRA = "com.dexterous.flutterlocalnotifications.ForegroundServiceStartParameter";
    public final ArrayList<Integer> foregroundServiceTypes;
    public final NotificationDetails notificationData;
    public final int startMode;

    public ForegroundServiceStartParameter(NotificationDetails notificationData, int startMode, ArrayList<Integer> foregroundServiceTypes) {
        this.notificationData = notificationData;
        this.startMode = startMode;
        this.foregroundServiceTypes = foregroundServiceTypes;
    }

    public String toString() {
        return "ForegroundServiceStartParameter{notificationData=" + this.notificationData + ", startMode=" + this.startMode + ", foregroundServiceTypes=" + this.foregroundServiceTypes + '}';
    }
}
