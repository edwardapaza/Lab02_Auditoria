package io.flutter.plugins.firebase.auth;

import com.google.firebase.components.ComponentRegistrar;
import e2.h;
import java.util.Collections;
import java.util.List;
import k1.c;
/* loaded from: classes.dex */
public class FlutterFirebaseAuthRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<c<?>> getComponents() {
        return Collections.singletonList(h.b("flutter-fire-auth", "4.20.0"));
    }
}
