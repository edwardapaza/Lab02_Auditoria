package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import io.flutter.plugins.imagepicker.Messages;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
class ImagePickerCache {
    private static final String FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY = "flutter_image_picker_image_path";
    static final String MAP_KEY_ERROR = "error";
    static final String MAP_KEY_IMAGE_QUALITY = "imageQuality";
    static final String MAP_KEY_MAX_HEIGHT = "maxHeight";
    static final String MAP_KEY_MAX_WIDTH = "maxWidth";
    static final String MAP_KEY_PATH_LIST = "pathList";
    static final String MAP_KEY_TYPE = "type";
    private static final String MAP_TYPE_VALUE_IMAGE = "image";
    private static final String MAP_TYPE_VALUE_VIDEO = "video";
    static final String SHARED_PREFERENCES_NAME = "flutter_image_picker_shared_preference";
    private static final String SHARED_PREFERENCE_ERROR_CODE_KEY = "flutter_image_picker_error_code";
    private static final String SHARED_PREFERENCE_ERROR_MESSAGE_KEY = "flutter_image_picker_error_message";
    private static final String SHARED_PREFERENCE_IMAGE_QUALITY_KEY = "flutter_image_picker_image_quality";
    private static final String SHARED_PREFERENCE_MAX_HEIGHT_KEY = "flutter_image_picker_max_height";
    private static final String SHARED_PREFERENCE_MAX_WIDTH_KEY = "flutter_image_picker_max_width";
    private static final String SHARED_PREFERENCE_PENDING_IMAGE_URI_PATH_KEY = "flutter_image_picker_pending_image_uri";
    private static final String SHARED_PREFERENCE_TYPE_KEY = "flutter_image_picker_type";
    private final Context context;

    /* loaded from: classes2.dex */
    public enum CacheType {
        IMAGE,
        VIDEO
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImagePickerCache(Context context) {
        this.context = context;
    }

    /* renamed from: io.flutter.plugins.imagepicker.ImagePickerCache$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$imagepicker$ImagePickerCache$CacheType;

        static {
            int[] iArr = new int[CacheType.values().length];
            $SwitchMap$io$flutter$plugins$imagepicker$ImagePickerCache$CacheType = iArr;
            try {
                iArr[CacheType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$io$flutter$plugins$imagepicker$ImagePickerCache$CacheType[CacheType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void saveType(CacheType type) {
        switch (AnonymousClass1.$SwitchMap$io$flutter$plugins$imagepicker$ImagePickerCache$CacheType[type.ordinal()]) {
            case 1:
                setType(MAP_TYPE_VALUE_IMAGE);
                return;
            case 2:
                setType(MAP_TYPE_VALUE_VIDEO);
                return;
            default:
                return;
        }
    }

    private void setType(String type) {
        SharedPreferences prefs = this.context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
        prefs.edit().putString(SHARED_PREFERENCE_TYPE_KEY, type).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void saveDimensionWithOutputOptions(Messages.ImageSelectionOptions options) {
        SharedPreferences prefs = this.context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        if (options.getMaxWidth() != null) {
            editor.putLong(SHARED_PREFERENCE_MAX_WIDTH_KEY, Double.doubleToRawLongBits(options.getMaxWidth().doubleValue()));
        }
        if (options.getMaxHeight() != null) {
            editor.putLong(SHARED_PREFERENCE_MAX_HEIGHT_KEY, Double.doubleToRawLongBits(options.getMaxHeight().doubleValue()));
        }
        editor.putInt(SHARED_PREFERENCE_IMAGE_QUALITY_KEY, options.getQuality().intValue());
        editor.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void savePendingCameraMediaUriPath(Uri uri) {
        SharedPreferences prefs = this.context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
        prefs.edit().putString(SHARED_PREFERENCE_PENDING_IMAGE_URI_PATH_KEY, uri.getPath()).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String retrievePendingCameraMediaUriPath() {
        SharedPreferences prefs = this.context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
        return prefs.getString(SHARED_PREFERENCE_PENDING_IMAGE_URI_PATH_KEY, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void saveResult(ArrayList<String> path, String errorCode, String errorMessage) {
        SharedPreferences prefs = this.context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        if (path != null) {
            Set<String> imageSet = new HashSet<>(path);
            editor.putStringSet(FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY, imageSet);
        }
        if (errorCode != null) {
            editor.putString(SHARED_PREFERENCE_ERROR_CODE_KEY, errorCode);
        }
        if (errorMessage != null) {
            editor.putString(SHARED_PREFERENCE_ERROR_MESSAGE_KEY, errorMessage);
        }
        editor.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        SharedPreferences prefs = this.context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
        prefs.edit().clear().apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Object> getCacheMap() {
        Object obj;
        Set<String> imagePathList;
        Map<String, Object> resultMap = new HashMap<>();
        boolean hasData = false;
        SharedPreferences prefs = this.context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
        if (prefs.contains(FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY) && (imagePathList = prefs.getStringSet(FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY, null)) != null) {
            ArrayList<String> pathList = new ArrayList<>(imagePathList);
            resultMap.put(MAP_KEY_PATH_LIST, pathList);
            hasData = true;
        }
        if (prefs.contains(SHARED_PREFERENCE_ERROR_CODE_KEY)) {
            Messages.CacheRetrievalError.Builder error = new Messages.CacheRetrievalError.Builder();
            error.setCode(prefs.getString(SHARED_PREFERENCE_ERROR_CODE_KEY, ""));
            hasData = true;
            if (prefs.contains(SHARED_PREFERENCE_ERROR_MESSAGE_KEY)) {
                error.setMessage(prefs.getString(SHARED_PREFERENCE_ERROR_MESSAGE_KEY, ""));
            }
            resultMap.put("error", error.build());
        }
        if (hasData) {
            if (prefs.contains(SHARED_PREFERENCE_TYPE_KEY)) {
                String typeValue = prefs.getString(SHARED_PREFERENCE_TYPE_KEY, "");
                if (typeValue.equals(MAP_TYPE_VALUE_VIDEO)) {
                    obj = Messages.CacheRetrievalType.VIDEO;
                } else {
                    obj = Messages.CacheRetrievalType.IMAGE;
                }
                resultMap.put(MAP_KEY_TYPE, obj);
            }
            if (prefs.contains(SHARED_PREFERENCE_MAX_WIDTH_KEY)) {
                long maxWidthValue = prefs.getLong(SHARED_PREFERENCE_MAX_WIDTH_KEY, 0L);
                resultMap.put(MAP_KEY_MAX_WIDTH, Double.valueOf(Double.longBitsToDouble(maxWidthValue)));
            }
            if (prefs.contains(SHARED_PREFERENCE_MAX_HEIGHT_KEY)) {
                long maxHeightValue = prefs.getLong(SHARED_PREFERENCE_MAX_HEIGHT_KEY, 0L);
                resultMap.put(MAP_KEY_MAX_HEIGHT, Double.valueOf(Double.longBitsToDouble(maxHeightValue)));
            }
            int imageQuality = prefs.getInt(SHARED_PREFERENCE_IMAGE_QUALITY_KEY, 100);
            resultMap.put(MAP_KEY_IMAGE_QUALITY, Integer.valueOf(imageQuality));
        }
        return resultMap;
    }
}
