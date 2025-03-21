package com.baseflow.geolocator.location;

import java.util.Map;
/* loaded from: classes2.dex */
public class ForegroundNotificationOptions {
    private final Integer color;
    private final boolean enableWakeLock;
    private final boolean enableWifiLock;
    private final String notificationChannelName;
    private final AndroidIconResource notificationIcon;
    private final String notificationText;
    private final String notificationTitle;
    private final boolean setOngoing;

    public static ForegroundNotificationOptions parseArguments(Map<String, Object> arguments) {
        Integer color;
        if (arguments != null) {
            AndroidIconResource notificationIcon = AndroidIconResource.parseArguments((Map) arguments.get("notificationIcon"));
            String notificationTitle = (String) arguments.get("notificationTitle");
            String notificationChannelName = (String) arguments.get("notificationChannelName");
            String notificationText = (String) arguments.get("notificationText");
            Boolean enableWifiLock = (Boolean) arguments.get("enableWifiLock");
            Boolean enableWakeLock = (Boolean) arguments.get("enableWakeLock");
            Boolean setOngoing = (Boolean) arguments.get("setOngoing");
            Object colorObject = arguments.get("color");
            if (colorObject == null) {
                color = null;
            } else {
                Integer color2 = Integer.valueOf(((Number) colorObject).intValue());
                color = color2;
            }
            return new ForegroundNotificationOptions(notificationTitle, notificationText, notificationChannelName, notificationIcon, enableWifiLock.booleanValue(), enableWakeLock.booleanValue(), setOngoing.booleanValue(), color);
        }
        return null;
    }

    private ForegroundNotificationOptions(String notificationTitle, String notificationText, String notificationChannelName, AndroidIconResource notificationIcon, boolean enableWifiLock, boolean enableWakeLock, boolean setOngoing, Integer color) {
        this.notificationTitle = notificationTitle;
        this.notificationText = notificationText;
        this.notificationChannelName = notificationChannelName;
        this.notificationIcon = notificationIcon;
        this.enableWifiLock = enableWifiLock;
        this.enableWakeLock = enableWakeLock;
        this.setOngoing = setOngoing;
        this.color = color;
    }

    public String getNotificationTitle() {
        return this.notificationTitle;
    }

    public String getNotificationText() {
        return this.notificationText;
    }

    public String getNotificationChannelName() {
        return this.notificationChannelName;
    }

    public AndroidIconResource getNotificationIcon() {
        return this.notificationIcon;
    }

    public boolean isEnableWifiLock() {
        return this.enableWifiLock;
    }

    public boolean isEnableWakeLock() {
        return this.enableWakeLock;
    }

    public boolean isSetOngoing() {
        return this.setOngoing;
    }

    public Integer getColor() {
        return this.color;
    }
}
