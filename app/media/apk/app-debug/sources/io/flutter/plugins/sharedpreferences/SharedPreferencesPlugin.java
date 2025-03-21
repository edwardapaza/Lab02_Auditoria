package io.flutter.plugins.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.sharedpreferences.Messages;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class SharedPreferencesPlugin implements FlutterPlugin, Messages.SharedPreferencesApi {
    private static final String BIG_INTEGER_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy";
    private static final String DOUBLE_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu";
    private static final String LIST_IDENTIFIER = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu";
    private static final String SHARED_PREFERENCES_NAME = "FlutterSharedPreferences";
    private static final String TAG = "SharedPreferencesPlugin";
    private SharedPreferencesListEncoder listEncoder;
    private SharedPreferences preferences;

    public SharedPreferencesPlugin() {
        this(new ListEncoder());
    }

    SharedPreferencesPlugin(SharedPreferencesListEncoder listEncoder) {
        this.listEncoder = listEncoder;
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        SharedPreferencesPlugin plugin = new SharedPreferencesPlugin();
        plugin.setUp(registrar.messenger(), registrar.context());
    }

    private void setUp(BinaryMessenger messenger, Context context) {
        this.preferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
        try {
            Messages.SharedPreferencesApi.CC.setup(messenger, this);
        } catch (Exception ex) {
            Log.e(TAG, "Received exception while setting up SharedPreferencesPlugin", ex);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        setUp(binding.getBinaryMessenger(), binding.getApplicationContext());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        Messages.SharedPreferencesApi.CC.setup(binding.getBinaryMessenger(), null);
    }

    @Override // io.flutter.plugins.sharedpreferences.Messages.SharedPreferencesApi
    public Boolean setBool(String key, Boolean value) {
        return Boolean.valueOf(this.preferences.edit().putBoolean(key, value.booleanValue()).commit());
    }

    @Override // io.flutter.plugins.sharedpreferences.Messages.SharedPreferencesApi
    public Boolean setString(String key, String value) {
        if (value.startsWith(LIST_IDENTIFIER) || value.startsWith(BIG_INTEGER_PREFIX) || value.startsWith(DOUBLE_PREFIX)) {
            throw new RuntimeException("StorageError: This string cannot be stored as it clashes with special identifier prefixes");
        }
        return Boolean.valueOf(this.preferences.edit().putString(key, value).commit());
    }

    @Override // io.flutter.plugins.sharedpreferences.Messages.SharedPreferencesApi
    public Boolean setInt(String key, Long value) {
        return Boolean.valueOf(this.preferences.edit().putLong(key, value.longValue()).commit());
    }

    @Override // io.flutter.plugins.sharedpreferences.Messages.SharedPreferencesApi
    public Boolean setDouble(String key, Double value) {
        String doubleValueStr = Double.toString(value.doubleValue());
        return Boolean.valueOf(this.preferences.edit().putString(key, DOUBLE_PREFIX + doubleValueStr).commit());
    }

    @Override // io.flutter.plugins.sharedpreferences.Messages.SharedPreferencesApi
    public Boolean remove(String key) {
        return Boolean.valueOf(this.preferences.edit().remove(key).commit());
    }

    @Override // io.flutter.plugins.sharedpreferences.Messages.SharedPreferencesApi
    public Boolean setStringList(String key, List<String> value) throws RuntimeException {
        return Boolean.valueOf(this.preferences.edit().putString(key, LIST_IDENTIFIER + this.listEncoder.encode(value)).commit());
    }

    @Override // io.flutter.plugins.sharedpreferences.Messages.SharedPreferencesApi
    public Map<String, Object> getAll(String prefix, List<String> allowList) throws RuntimeException {
        Set<String> allowSet = allowList == null ? null : new HashSet<>(allowList);
        return getAllPrefs(prefix, allowSet);
    }

    @Override // io.flutter.plugins.sharedpreferences.Messages.SharedPreferencesApi
    public Boolean clear(String prefix, List<String> allowList) throws RuntimeException {
        SharedPreferences.Editor clearEditor = this.preferences.edit();
        Map<String, ?> allPrefs = this.preferences.getAll();
        ArrayList<String> filteredPrefs = new ArrayList<>();
        for (String key : allPrefs.keySet()) {
            if (key.startsWith(prefix) && (allowList == null || allowList.contains(key))) {
                filteredPrefs.add(key);
            }
        }
        Iterator<String> it = filteredPrefs.iterator();
        while (it.hasNext()) {
            clearEditor.remove(it.next());
        }
        return Boolean.valueOf(clearEditor.commit());
    }

    private Map<String, Object> getAllPrefs(String prefix, Set<String> allowList) throws RuntimeException {
        Map<String, ?> allPrefs = this.preferences.getAll();
        Map<String, Object> filteredPrefs = new HashMap<>();
        for (String key : allPrefs.keySet()) {
            if (key.startsWith(prefix) && (allowList == null || allowList.contains(key))) {
                filteredPrefs.put(key, transformPref(key, allPrefs.get(key)));
            }
        }
        return filteredPrefs;
    }

    private Object transformPref(String key, Object value) {
        if (value instanceof String) {
            String stringValue = (String) value;
            if (stringValue.startsWith(LIST_IDENTIFIER)) {
                return this.listEncoder.decode(stringValue.substring(LIST_IDENTIFIER.length()));
            }
            if (stringValue.startsWith(BIG_INTEGER_PREFIX)) {
                String encoded = stringValue.substring(BIG_INTEGER_PREFIX.length());
                return new BigInteger(encoded, 36);
            } else if (stringValue.startsWith(DOUBLE_PREFIX)) {
                String doubleStr = stringValue.substring(DOUBLE_PREFIX.length());
                return Double.valueOf(doubleStr);
            }
        } else if (value instanceof Set) {
            List<String> listValue = new ArrayList<>((Set) value);
            this.preferences.edit().remove(key).putString(key, LIST_IDENTIFIER + this.listEncoder.encode(listValue)).apply();
            return listValue;
        }
        return value;
    }

    /* loaded from: classes2.dex */
    static class ListEncoder implements SharedPreferencesListEncoder {
        ListEncoder() {
        }

        @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesListEncoder
        public String encode(List<String> list) throws RuntimeException {
            try {
                ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                ObjectOutputStream stream = new ObjectOutputStream(byteStream);
                stream.writeObject(list);
                stream.flush();
                return Base64.encodeToString(byteStream.toByteArray(), 0);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesListEncoder
        public List<String> decode(String listString) throws RuntimeException {
            try {
                ObjectInputStream stream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(listString, 0)));
                return (List) stream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
