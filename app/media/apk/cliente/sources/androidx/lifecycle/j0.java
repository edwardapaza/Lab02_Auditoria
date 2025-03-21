package androidx.lifecycle;

import androidx.lifecycle.i0;
/* loaded from: classes.dex */
public final /* synthetic */ class j0 {
    public static h0 a(i0.b bVar, Class cls) {
        e4.k.e(cls, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    public static h0 b(i0.b bVar, Class cls, r.a aVar) {
        e4.k.e(cls, "modelClass");
        e4.k.e(aVar, "extras");
        return bVar.a(cls);
    }
}
