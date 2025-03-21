package com.google.firebase.ktx;

import com.google.firebase.components.ComponentRegistrar;
import e2.h;
import java.util.List;
import k1.c;
import t3.o;
/* loaded from: classes.dex */
public final class FirebaseCommonLegacyRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<c<?>> getComponents() {
        List<c<?>> b5;
        b5 = o.b(h.b("fire-core-ktx", "20.4.3"));
        return b5;
    }
}
