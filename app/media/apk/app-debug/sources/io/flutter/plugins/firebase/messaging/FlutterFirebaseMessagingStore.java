package io.flutter.plugins.firebase.messaging;

import android.content.SharedPreferences;
import com.google.firebase.messaging.RemoteMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FlutterFirebaseMessagingStore {
    private static final String KEY_NOTIFICATION_IDS = "notification_ids";
    private static final int MAX_SIZE_NOTIFICATIONS = 100;
    private static final String PREFERENCES_FILE = "io.flutter.plugins.firebase.messaging";
    private static FlutterFirebaseMessagingStore instance;
    private final String DELIMITER = ",";
    private SharedPreferences preferences;

    public static FlutterFirebaseMessagingStore getInstance() {
        if (instance == null) {
            instance = new FlutterFirebaseMessagingStore();
        }
        return instance;
    }

    private SharedPreferences getPreferences() {
        if (this.preferences == null) {
            this.preferences = ContextHolder.getApplicationContext().getSharedPreferences("io.flutter.plugins.firebase.messaging", 0);
        }
        return this.preferences;
    }

    public void setPreferencesStringValue(String key, String value) {
        getPreferences().edit().putString(key, value).apply();
    }

    public String getPreferencesStringValue(String key, String defaultValue) {
        return getPreferences().getString(key, defaultValue);
    }

    public void storeFirebaseMessage(RemoteMessage remoteMessage) {
        String remoteMessageString = new JSONObject(FlutterFirebaseMessagingUtils.remoteMessageToMap(remoteMessage)).toString();
        setPreferencesStringValue(remoteMessage.getMessageId(), remoteMessageString);
        String notifications = getPreferencesStringValue(KEY_NOTIFICATION_IDS, "") + remoteMessage.getMessageId() + ",";
        List<String> allNotificationList = new ArrayList<>(Arrays.asList(notifications.split(",")));
        if (allNotificationList.size() > 100) {
            String firstRemoteMessageId = allNotificationList.get(0);
            getPreferences().edit().remove(firstRemoteMessageId).apply();
            notifications = notifications.replace(firstRemoteMessageId + ",", "");
        }
        setPreferencesStringValue(KEY_NOTIFICATION_IDS, notifications);
    }

    public Map<String, Object> getFirebaseMessageMap(String remoteMessageId) {
        String remoteMessageString = getPreferencesStringValue(remoteMessageId, null);
        if (remoteMessageString != null) {
            try {
                Map<String, Object> argumentsMap = new HashMap<>(1);
                Map<String, Object> messageOutMap = jsonObjectToMap(new JSONObject(remoteMessageString));
                messageOutMap.put("to", remoteMessageId);
                argumentsMap.put("message", messageOutMap);
                return argumentsMap;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void removeFirebaseMessage(String remoteMessageId) {
        getPreferences().edit().remove(remoteMessageId).apply();
        String notifications = getPreferencesStringValue(KEY_NOTIFICATION_IDS, "");
        if (!notifications.isEmpty()) {
            setPreferencesStringValue(KEY_NOTIFICATION_IDS, notifications.replace(remoteMessageId + ",", ""));
        }
    }

    private Map<String, Object> jsonObjectToMap(JSONObject jsonObject) throws JSONException {
        Map<String, Object> map = new HashMap<>();
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object value = jsonObject.get(key);
            if (value instanceof JSONArray) {
                value = jsonArrayToList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = jsonObjectToMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }

    public List<Object> jsonArrayToList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if (value instanceof JSONArray) {
                value = jsonArrayToList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = jsonObjectToMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }
}
