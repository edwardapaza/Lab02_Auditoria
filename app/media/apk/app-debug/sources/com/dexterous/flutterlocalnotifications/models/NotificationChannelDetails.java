package com.dexterous.flutterlocalnotifications.models;

import android.graphics.Color;
import java.io.Serializable;
import java.util.Map;
/* loaded from: classes2.dex */
public class NotificationChannelDetails implements Serializable {
    private static final String AUDIO_ATTRIBUTES_USAGE = "audioAttributesUsage";
    private static final String CHANNEL_ACTION = "channelAction";
    private static final String DESCRIPTION = "description";
    private static final String ENABLE_LIGHTS = "enableLights";
    private static final String ENABLE_VIBRATION = "enableVibration";
    private static final String GROUP_ID = "groupId";
    private static final String ID = "id";
    private static final String IMPORTANCE = "importance";
    private static final String LED_COLOR_ALPHA = "ledColorAlpha";
    private static final String LED_COLOR_BLUE = "ledColorBlue";
    private static final String LED_COLOR_GREEN = "ledColorGreen";
    private static final String LED_COLOR_RED = "ledColorRed";
    private static final String NAME = "name";
    private static final String PLAY_SOUND = "playSound";
    private static final String SHOW_BADGE = "showBadge";
    private static final String SOUND = "sound";
    private static final String SOUND_SOURCE = "soundSource";
    private static final String VIBRATION_PATTERN = "vibrationPattern";
    public Integer audioAttributesUsage;
    public NotificationChannelAction channelAction;
    public String description;
    public Boolean enableLights;
    public Boolean enableVibration;
    public String groupId;
    public String id;
    public Integer importance;
    public Integer ledColor;
    public String name;
    public Boolean playSound;
    public Boolean showBadge;
    public String sound;
    public SoundSource soundSource;
    public long[] vibrationPattern;

    public static NotificationChannelDetails from(Map<String, Object> arguments) {
        NotificationChannelDetails notificationChannel = new NotificationChannelDetails();
        notificationChannel.id = (String) arguments.get(ID);
        notificationChannel.name = (String) arguments.get(NAME);
        notificationChannel.description = (String) arguments.get(DESCRIPTION);
        notificationChannel.groupId = (String) arguments.get(GROUP_ID);
        notificationChannel.importance = (Integer) arguments.get(IMPORTANCE);
        notificationChannel.showBadge = (Boolean) arguments.get(SHOW_BADGE);
        notificationChannel.channelAction = NotificationChannelAction.values()[((Integer) arguments.get(CHANNEL_ACTION)).intValue()];
        notificationChannel.enableVibration = (Boolean) arguments.get(ENABLE_VIBRATION);
        notificationChannel.vibrationPattern = (long[]) arguments.get(VIBRATION_PATTERN);
        notificationChannel.playSound = (Boolean) arguments.get(PLAY_SOUND);
        notificationChannel.sound = (String) arguments.get(SOUND);
        notificationChannel.audioAttributesUsage = (Integer) arguments.get(AUDIO_ATTRIBUTES_USAGE);
        Integer soundSourceIndex = (Integer) arguments.get(SOUND_SOURCE);
        if (soundSourceIndex != null) {
            notificationChannel.soundSource = SoundSource.values()[soundSourceIndex.intValue()];
        }
        Integer a = (Integer) arguments.get(LED_COLOR_ALPHA);
        Integer r = (Integer) arguments.get(LED_COLOR_RED);
        Integer g = (Integer) arguments.get(LED_COLOR_GREEN);
        Integer b = (Integer) arguments.get(LED_COLOR_BLUE);
        if (a != null && r != null && g != null && b != null) {
            notificationChannel.ledColor = Integer.valueOf(Color.argb(a.intValue(), r.intValue(), g.intValue(), b.intValue()));
        }
        notificationChannel.enableLights = (Boolean) arguments.get(ENABLE_LIGHTS);
        return notificationChannel;
    }

    public static NotificationChannelDetails fromNotificationDetails(NotificationDetails notificationDetails) {
        NotificationChannelDetails notificationChannel = new NotificationChannelDetails();
        notificationChannel.id = notificationDetails.channelId;
        notificationChannel.name = notificationDetails.channelName;
        notificationChannel.description = notificationDetails.channelDescription;
        notificationChannel.importance = notificationDetails.importance;
        notificationChannel.showBadge = notificationDetails.channelShowBadge;
        if (notificationDetails.channelAction == null) {
            notificationChannel.channelAction = NotificationChannelAction.CreateIfNotExists;
        } else {
            notificationChannel.channelAction = notificationDetails.channelAction;
        }
        notificationChannel.enableVibration = notificationDetails.enableVibration;
        notificationChannel.vibrationPattern = notificationDetails.vibrationPattern;
        notificationChannel.playSound = notificationDetails.playSound;
        notificationChannel.sound = notificationDetails.sound;
        notificationChannel.soundSource = notificationDetails.soundSource;
        notificationChannel.audioAttributesUsage = notificationDetails.audioAttributesUsage;
        notificationChannel.ledColor = notificationDetails.ledColor;
        notificationChannel.enableLights = notificationDetails.enableLights;
        return notificationChannel;
    }
}
