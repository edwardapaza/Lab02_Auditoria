package io.flutter.plugins;

import d3.u;
import e3.w;
import io.flutter.embedding.engine.a;
import io.flutter.plugins.firebase.core.i;
import n2.b;
/* loaded from: classes.dex */
public final class GeneratedPluginRegistrant {
    private static final String TAG = "GeneratedPluginRegistrant";

    public static void registerWith(a aVar) {
        try {
            aVar.r().g(new w());
        } catch (Exception e5) {
            b.c(TAG, "Error registering plugin cloud_firestore, io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestorePlugin", e5);
        }
        try {
            aVar.r().g(new u());
        } catch (Exception e6) {
            b.c(TAG, "Error registering plugin firebase_auth, io.flutter.plugins.firebase.auth.FlutterFirebaseAuthPlugin", e6);
        }
        try {
            aVar.r().g(new i());
        } catch (Exception e7) {
            b.c(TAG, "Error registering plugin firebase_core, io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin", e7);
        }
    }
}
