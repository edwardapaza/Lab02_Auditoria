package io.flutter.plugins.firebase.core;

import com.google.firebase.components.ComponentRegistrar;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class FlutterFirebaseCoreRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<k1.c<?>> getComponents() {
        return Collections.singletonList(e2.h.b("flutter-fire-core", "2.32.0"));
    }
}
