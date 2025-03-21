package io.flutter.plugins.firebase.firestore;

import com.google.firebase.components.ComponentRegistrar;
import e2.h;
import java.util.Collections;
import java.util.List;
import k1.c;
/* loaded from: classes.dex */
public class FlutterFirebaseFirestoreRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<c<?>> getComponents() {
        return Collections.singletonList(h.b("flutter-fire-fst", "4.17.5"));
    }
}
