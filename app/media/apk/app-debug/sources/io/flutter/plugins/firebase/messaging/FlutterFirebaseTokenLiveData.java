package io.flutter.plugins.firebase.messaging;

import androidx.lifecycle.LiveData;
/* loaded from: classes2.dex */
public class FlutterFirebaseTokenLiveData extends LiveData<String> {
    private static FlutterFirebaseTokenLiveData instance;

    public static FlutterFirebaseTokenLiveData getInstance() {
        if (instance == null) {
            instance = new FlutterFirebaseTokenLiveData();
        }
        return instance;
    }

    public void postToken(String token) {
        postValue(token);
    }
}
