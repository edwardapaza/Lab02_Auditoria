package androidx.core.app;

import android.app.RemoteInput;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class RemoteInput {
    public static final int EDIT_CHOICES_BEFORE_SENDING_AUTO = 0;
    public static final int EDIT_CHOICES_BEFORE_SENDING_DISABLED = 1;
    public static final int EDIT_CHOICES_BEFORE_SENDING_ENABLED = 2;
    private static final String EXTRA_DATA_TYPE_RESULTS_DATA = "android.remoteinput.dataTypeResultsData";
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    private static final String EXTRA_RESULTS_SOURCE = "android.remoteinput.resultsSource";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    public static final int SOURCE_CHOICE = 1;
    public static final int SOURCE_FREE_FORM_INPUT = 0;
    private final boolean mAllowFreeFormTextInput;
    private final Set<String> mAllowedDataTypes;
    private final CharSequence[] mChoices;
    private final int mEditChoicesBeforeSending;
    private final Bundle mExtras;
    private final CharSequence mLabel;
    private final String mResultKey;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface EditChoicesBeforeSending {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Source {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemoteInput(String resultKey, CharSequence label, CharSequence[] choices, boolean allowFreeFormTextInput, int editChoicesBeforeSending, Bundle extras, Set<String> allowedDataTypes) {
        this.mResultKey = resultKey;
        this.mLabel = label;
        this.mChoices = choices;
        this.mAllowFreeFormTextInput = allowFreeFormTextInput;
        this.mEditChoicesBeforeSending = editChoicesBeforeSending;
        this.mExtras = extras;
        this.mAllowedDataTypes = allowedDataTypes;
        if (getEditChoicesBeforeSending() == 2 && !getAllowFreeFormInput()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    public String getResultKey() {
        return this.mResultKey;
    }

    public CharSequence getLabel() {
        return this.mLabel;
    }

    public CharSequence[] getChoices() {
        return this.mChoices;
    }

    public Set<String> getAllowedDataTypes() {
        return this.mAllowedDataTypes;
    }

    public boolean isDataOnly() {
        return (getAllowFreeFormInput() || (getChoices() != null && getChoices().length != 0) || getAllowedDataTypes() == null || getAllowedDataTypes().isEmpty()) ? false : true;
    }

    public boolean getAllowFreeFormInput() {
        return this.mAllowFreeFormTextInput;
    }

    public int getEditChoicesBeforeSending() {
        return this.mEditChoicesBeforeSending;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private CharSequence[] mChoices;
        private CharSequence mLabel;
        private final String mResultKey;
        private final Set<String> mAllowedDataTypes = new HashSet();
        private final Bundle mExtras = new Bundle();
        private boolean mAllowFreeFormTextInput = true;
        private int mEditChoicesBeforeSending = 0;

        public Builder(String resultKey) {
            if (resultKey == null) {
                throw new IllegalArgumentException("Result key can't be null");
            }
            this.mResultKey = resultKey;
        }

        public Builder setLabel(CharSequence label) {
            this.mLabel = label;
            return this;
        }

        public Builder setChoices(CharSequence[] choices) {
            this.mChoices = choices;
            return this;
        }

        public Builder setAllowDataType(String mimeType, boolean doAllow) {
            if (doAllow) {
                this.mAllowedDataTypes.add(mimeType);
            } else {
                this.mAllowedDataTypes.remove(mimeType);
            }
            return this;
        }

        public Builder setAllowFreeFormInput(boolean allowFreeFormTextInput) {
            this.mAllowFreeFormTextInput = allowFreeFormTextInput;
            return this;
        }

        public Builder setEditChoicesBeforeSending(int editChoicesBeforeSending) {
            this.mEditChoicesBeforeSending = editChoicesBeforeSending;
            return this;
        }

        public Builder addExtras(Bundle extras) {
            if (extras != null) {
                this.mExtras.putAll(extras);
            }
            return this;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public RemoteInput build() {
            return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormTextInput, this.mEditChoicesBeforeSending, this.mExtras, this.mAllowedDataTypes);
        }
    }

    public static Map<String, Uri> getDataResultsFromIntent(Intent intent, String remoteInputResultKey) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getDataResultsFromIntent(intent, remoteInputResultKey);
        }
        Intent clipDataIntent = getClipDataIntentFromIntent(intent);
        if (clipDataIntent == null) {
            return null;
        }
        Map<String, Uri> results = new HashMap<>();
        Bundle extras = clipDataIntent.getExtras();
        for (String key : extras.keySet()) {
            if (key.startsWith(EXTRA_DATA_TYPE_RESULTS_DATA)) {
                String mimeType = key.substring(EXTRA_DATA_TYPE_RESULTS_DATA.length());
                if (!mimeType.isEmpty()) {
                    Bundle bundle = clipDataIntent.getBundleExtra(key);
                    String uriStr = bundle.getString(remoteInputResultKey);
                    if (uriStr != null && !uriStr.isEmpty()) {
                        results.put(mimeType, Uri.parse(uriStr));
                    }
                }
            }
        }
        if (results.isEmpty()) {
            return null;
        }
        return results;
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        if (Build.VERSION.SDK_INT >= 20) {
            return Api20Impl.getResultsFromIntent(intent);
        }
        Intent clipDataIntent = getClipDataIntentFromIntent(intent);
        if (clipDataIntent == null) {
            return null;
        }
        return (Bundle) clipDataIntent.getExtras().getParcelable(EXTRA_RESULTS_DATA);
    }

    public static void addResultsToIntent(RemoteInput[] remoteInputs, Intent intent, Bundle results) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api20Impl.addResultsToIntent(fromCompat(remoteInputs), intent, results);
            return;
        }
        if (Build.VERSION.SDK_INT >= 20) {
            Bundle existingTextResults = getResultsFromIntent(intent);
            int resultsSource = getResultsSource(intent);
            if (existingTextResults == null) {
                existingTextResults = results;
            } else {
                existingTextResults.putAll(results);
            }
            for (RemoteInput input : remoteInputs) {
                Map<String, Uri> existingDataResults = getDataResultsFromIntent(intent, input.getResultKey());
                RemoteInput[] arr = {input};
                Api20Impl.addResultsToIntent(fromCompat(arr), intent, existingTextResults);
                if (existingDataResults != null) {
                    addDataResultToIntent(input, intent, existingDataResults);
                }
            }
            setResultsSource(intent, resultsSource);
            return;
        }
        Intent clipDataIntent = getClipDataIntentFromIntent(intent);
        if (clipDataIntent == null) {
            clipDataIntent = new Intent();
        }
        Bundle resultsBundle = clipDataIntent.getBundleExtra(EXTRA_RESULTS_DATA);
        if (resultsBundle == null) {
            resultsBundle = new Bundle();
        }
        for (RemoteInput remoteInput : remoteInputs) {
            Object result = results.get(remoteInput.getResultKey());
            if (result instanceof CharSequence) {
                resultsBundle.putCharSequence(remoteInput.getResultKey(), (CharSequence) result);
            }
        }
        clipDataIntent.putExtra(EXTRA_RESULTS_DATA, resultsBundle);
        intent.setClipData(ClipData.newIntent(RESULTS_CLIP_LABEL, clipDataIntent));
    }

    public static void addDataResultToIntent(RemoteInput remoteInput, Intent intent, Map<String, Uri> results) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.addDataResultToIntent(remoteInput, intent, results);
            return;
        }
        Intent clipDataIntent = getClipDataIntentFromIntent(intent);
        if (clipDataIntent == null) {
            clipDataIntent = new Intent();
        }
        for (Map.Entry<String, Uri> entry : results.entrySet()) {
            String mimeType = entry.getKey();
            Uri uri = entry.getValue();
            if (mimeType != null) {
                Bundle resultsBundle = clipDataIntent.getBundleExtra(getExtraResultsKeyForData(mimeType));
                if (resultsBundle == null) {
                    resultsBundle = new Bundle();
                }
                resultsBundle.putString(remoteInput.getResultKey(), uri.toString());
                clipDataIntent.putExtra(getExtraResultsKeyForData(mimeType), resultsBundle);
            }
        }
        intent.setClipData(ClipData.newIntent(RESULTS_CLIP_LABEL, clipDataIntent));
    }

    public static void setResultsSource(Intent intent, int source) {
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.setResultsSource(intent, source);
            return;
        }
        Intent clipDataIntent = getClipDataIntentFromIntent(intent);
        if (clipDataIntent == null) {
            clipDataIntent = new Intent();
        }
        clipDataIntent.putExtra(EXTRA_RESULTS_SOURCE, source);
        intent.setClipData(ClipData.newIntent(RESULTS_CLIP_LABEL, clipDataIntent));
    }

    public static int getResultsSource(Intent intent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getResultsSource(intent);
        }
        Intent clipDataIntent = getClipDataIntentFromIntent(intent);
        if (clipDataIntent == null) {
            return 0;
        }
        return clipDataIntent.getExtras().getInt(EXTRA_RESULTS_SOURCE, 0);
    }

    private static String getExtraResultsKeyForData(String mimeType) {
        return EXTRA_DATA_TYPE_RESULTS_DATA + mimeType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static android.app.RemoteInput[] fromCompat(RemoteInput[] srcArray) {
        if (srcArray == null) {
            return null;
        }
        android.app.RemoteInput[] result = new android.app.RemoteInput[srcArray.length];
        for (int i = 0; i < srcArray.length; i++) {
            result[i] = fromCompat(srcArray[i]);
        }
        return result;
    }

    static android.app.RemoteInput fromCompat(RemoteInput src) {
        return Api20Impl.fromCompat(src);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RemoteInput fromPlatform(android.app.RemoteInput src) {
        return Api20Impl.fromPlatform(src);
    }

    private static Intent getClipDataIntentFromIntent(Intent intent) {
        ClipData clipData = intent.getClipData();
        if (clipData == null) {
            return null;
        }
        ClipDescription clipDescription = clipData.getDescription();
        if (!clipDescription.hasMimeType("text/vnd.android.intent") || !clipDescription.getLabel().toString().contentEquals(RESULTS_CLIP_LABEL)) {
            return null;
        }
        return clipData.getItemAt(0).getIntent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api26Impl {
        private Api26Impl() {
        }

        static Map<String, Uri> getDataResultsFromIntent(Intent intent, String remoteInputResultKey) {
            return android.app.RemoteInput.getDataResultsFromIntent(intent, remoteInputResultKey);
        }

        static Set<String> getAllowedDataTypes(Object remoteInput) {
            return ((android.app.RemoteInput) remoteInput).getAllowedDataTypes();
        }

        static void addDataResultToIntent(RemoteInput remoteInput, Intent intent, Map<String, Uri> results) {
            android.app.RemoteInput.addDataResultToIntent(RemoteInput.fromCompat(remoteInput), intent, results);
        }

        static RemoteInput.Builder setAllowDataType(RemoteInput.Builder builder, String mimeType, boolean doAllow) {
            return builder.setAllowDataType(mimeType, doAllow);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api20Impl {
        private Api20Impl() {
        }

        static Bundle getResultsFromIntent(Intent intent) {
            return android.app.RemoteInput.getResultsFromIntent(intent);
        }

        static void addResultsToIntent(Object remoteInputs, Intent intent, Bundle results) {
            android.app.RemoteInput.addResultsToIntent((android.app.RemoteInput[]) remoteInputs, intent, results);
        }

        static RemoteInput fromPlatform(Object srcObj) {
            Set<String> allowedDataTypes;
            android.app.RemoteInput src = (android.app.RemoteInput) srcObj;
            Builder builder = new Builder(src.getResultKey()).setLabel(src.getLabel()).setChoices(src.getChoices()).setAllowFreeFormInput(src.getAllowFreeFormInput()).addExtras(src.getExtras());
            if (Build.VERSION.SDK_INT >= 26 && (allowedDataTypes = Api26Impl.getAllowedDataTypes(src)) != null) {
                for (String allowedDataType : allowedDataTypes) {
                    builder.setAllowDataType(allowedDataType, true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                builder.setEditChoicesBeforeSending(Api29Impl.getEditChoicesBeforeSending(src));
            }
            return builder.build();
        }

        public static android.app.RemoteInput fromCompat(RemoteInput src) {
            Set<String> allowedDataTypes;
            RemoteInput.Builder builder = new RemoteInput.Builder(src.getResultKey()).setLabel(src.getLabel()).setChoices(src.getChoices()).setAllowFreeFormInput(src.getAllowFreeFormInput()).addExtras(src.getExtras());
            if (Build.VERSION.SDK_INT >= 26 && (allowedDataTypes = src.getAllowedDataTypes()) != null) {
                for (String allowedDataType : allowedDataTypes) {
                    Api26Impl.setAllowDataType(builder, allowedDataType, true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                Api29Impl.setEditChoicesBeforeSending(builder, src.getEditChoicesBeforeSending());
            }
            return builder.build();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api29Impl {
        private Api29Impl() {
        }

        static int getEditChoicesBeforeSending(Object remoteInput) {
            return ((android.app.RemoteInput) remoteInput).getEditChoicesBeforeSending();
        }

        static RemoteInput.Builder setEditChoicesBeforeSending(RemoteInput.Builder builder, int editChoicesBeforeSending) {
            return builder.setEditChoicesBeforeSending(editChoicesBeforeSending);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }

        static void setResultsSource(Intent intent, int source) {
            android.app.RemoteInput.setResultsSource(intent, source);
        }

        static int getResultsSource(Intent intent) {
            return android.app.RemoteInput.getResultsSource(intent);
        }
    }
}
