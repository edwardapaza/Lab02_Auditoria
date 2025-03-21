package io.flutter.plugins.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class FlutterFirebaseMessagingUtils {
    static final String EXTRA_REMOTE_MESSAGE = "notification";
    static final String IS_AUTO_INIT_ENABLED = "isAutoInitEnabled";
    static final int JOB_ID = 2020;
    private static final String KEY_COLLAPSE_KEY = "collapseKey";
    private static final String KEY_DATA = "data";
    private static final String KEY_FROM = "from";
    private static final String KEY_MESSAGE_ID = "messageId";
    private static final String KEY_MESSAGE_TYPE = "messageType";
    private static final String KEY_SENT_TIME = "sentTime";
    private static final String KEY_TO = "to";
    private static final String KEY_TTL = "ttl";
    static final String SHARED_PREFERENCES_KEY = "io.flutter.firebase.messaging.callback";

    FlutterFirebaseMessagingUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, Object> remoteMessageToMap(RemoteMessage remoteMessage) {
        Map<String, Object> messageMap = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<>();
        if (remoteMessage.getCollapseKey() != null) {
            messageMap.put(KEY_COLLAPSE_KEY, remoteMessage.getCollapseKey());
        }
        if (remoteMessage.getFrom() != null) {
            messageMap.put("from", remoteMessage.getFrom());
        }
        if (remoteMessage.getTo() != null) {
            messageMap.put(KEY_TO, remoteMessage.getTo());
        }
        if (remoteMessage.getMessageId() != null) {
            messageMap.put(KEY_MESSAGE_ID, remoteMessage.getMessageId());
        }
        if (remoteMessage.getMessageType() != null) {
            messageMap.put(KEY_MESSAGE_TYPE, remoteMessage.getMessageType());
        }
        if (remoteMessage.getData().size() > 0) {
            Set<Map.Entry<String, String>> entries = remoteMessage.getData().entrySet();
            for (Map.Entry<String, String> entry : entries) {
                dataMap.put(entry.getKey(), entry.getValue());
            }
        }
        messageMap.put("data", dataMap);
        messageMap.put(KEY_TTL, Integer.valueOf(remoteMessage.getTtl()));
        messageMap.put(KEY_SENT_TIME, Long.valueOf(remoteMessage.getSentTime()));
        if (remoteMessage.getNotification() != null) {
            messageMap.put(EXTRA_REMOTE_MESSAGE, remoteMessageNotificationToMap(remoteMessage.getNotification()));
        }
        return messageMap;
    }

    private static Map<String, Object> remoteMessageNotificationToMap(RemoteMessage.Notification notification) {
        Map<String, Object> notificationMap = new HashMap<>();
        Map<String, Object> androidNotificationMap = new HashMap<>();
        if (notification.getTitle() != null) {
            notificationMap.put("title", notification.getTitle());
        }
        if (notification.getTitleLocalizationKey() != null) {
            notificationMap.put("titleLocKey", notification.getTitleLocalizationKey());
        }
        if (notification.getTitleLocalizationArgs() != null) {
            notificationMap.put("titleLocArgs", Arrays.asList(notification.getTitleLocalizationArgs()));
        }
        if (notification.getBody() != null) {
            notificationMap.put("body", notification.getBody());
        }
        if (notification.getBodyLocalizationKey() != null) {
            notificationMap.put("bodyLocKey", notification.getBodyLocalizationKey());
        }
        if (notification.getBodyLocalizationArgs() != null) {
            notificationMap.put("bodyLocArgs", Arrays.asList(notification.getBodyLocalizationArgs()));
        }
        if (notification.getChannelId() != null) {
            androidNotificationMap.put("channelId", notification.getChannelId());
        }
        if (notification.getClickAction() != null) {
            androidNotificationMap.put("clickAction", notification.getClickAction());
        }
        if (notification.getColor() != null) {
            androidNotificationMap.put("color", notification.getColor());
        }
        if (notification.getIcon() != null) {
            androidNotificationMap.put("smallIcon", notification.getIcon());
        }
        if (notification.getImageUrl() != null) {
            androidNotificationMap.put("imageUrl", notification.getImageUrl().toString());
        }
        if (notification.getLink() != null) {
            androidNotificationMap.put("link", notification.getLink().toString());
        }
        if (notification.getNotificationCount() != null) {
            androidNotificationMap.put("count", notification.getNotificationCount());
        }
        if (notification.getNotificationPriority() != null) {
            androidNotificationMap.put("priority", notification.getNotificationPriority());
        }
        if (notification.getSound() != null) {
            androidNotificationMap.put("sound", notification.getSound());
        }
        if (notification.getTicker() != null) {
            androidNotificationMap.put("ticker", notification.getTicker());
        }
        if (notification.getVisibility() != null) {
            androidNotificationMap.put("visibility", notification.getVisibility());
        }
        if (notification.getTag() != null) {
            androidNotificationMap.put("tag", notification.getTag());
        }
        notificationMap.put("android", androidNotificationMap);
        return notificationMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isApplicationForeground(Context context) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> appProcesses;
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        if ((keyguardManager != null && keyguardManager.isKeyguardLocked()) || (activityManager = (ActivityManager) context.getSystemService("activity")) == null || (appProcesses = activityManager.getRunningAppProcesses()) == null) {
            return false;
        }
        String packageName = context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.importance == 100 && appProcess.processName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FirebaseMessaging getFirebaseMessagingForArguments(Map<String, Object> arguments) {
        return FirebaseMessaging.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RemoteMessage getRemoteMessageForArguments(Map<String, Object> arguments) {
        Map<String, Object> messageMap = (Map) Objects.requireNonNull(arguments.get("message"));
        String to = (String) Objects.requireNonNull(messageMap.get(KEY_TO));
        RemoteMessage.Builder builder = new RemoteMessage.Builder(to);
        String collapseKey = (String) messageMap.get(KEY_COLLAPSE_KEY);
        String messageId = (String) messageMap.get(KEY_MESSAGE_ID);
        String messageType = (String) messageMap.get(KEY_MESSAGE_TYPE);
        Integer ttl = (Integer) messageMap.get(KEY_TTL);
        Map<String, String> data = (Map) messageMap.get("data");
        if (collapseKey != null) {
            builder.setCollapseKey(collapseKey);
        }
        if (messageType != null) {
            builder.setMessageType(messageType);
        }
        if (messageId != null) {
            builder.setMessageId(messageId);
        }
        if (ttl != null) {
            builder.setTtl(ttl.intValue());
        }
        if (data != null) {
            builder.setData(data);
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, Object> getRemoteMessageNotificationForArguments(Map<String, Object> arguments) {
        Map<String, Object> messageMap = (Map) Objects.requireNonNull(arguments.get("message"));
        if (messageMap.get(EXTRA_REMOTE_MESSAGE) == null) {
            return null;
        }
        Map<String, Object> notification = (Map) messageMap.get(EXTRA_REMOTE_MESSAGE);
        return notification;
    }
}
