package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import u.d;
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: f  reason: collision with root package name */
    public static final a f520f = new a(null);

    /* renamed from: g  reason: collision with root package name */
    private static final Class<? extends Object>[] f521g = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f522a = new LinkedHashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, d.c> f523b = new LinkedHashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Object> f524c = new LinkedHashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, p4.j<Object>> f525d = new LinkedHashMap();

    /* renamed from: e  reason: collision with root package name */
    private final d.c f526e = new d.c() { // from class: androidx.lifecycle.a0
        @Override // u.d.c
        public final Bundle a() {
            Bundle d5;
            d5 = b0.d(b0.this);
            return d5;
        }
    };

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e4.g gVar) {
            this();
        }

        public final boolean a(Object obj) {
            Class[] clsArr;
            if (obj == null) {
                return true;
            }
            for (Class cls : b0.f521g) {
                e4.k.b(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle d(b0 b0Var) {
        Map l5;
        e4.k.e(b0Var, "this$0");
        l5 = t3.h0.l(b0Var.f523b);
        for (Map.Entry entry : l5.entrySet()) {
            b0Var.e((String) entry.getKey(), ((d.c) entry.getValue()).a());
        }
        Set<String> keySet = b0Var.f522a.keySet();
        ArrayList arrayList = new ArrayList(keySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : keySet) {
            arrayList.add(str);
            arrayList2.add(b0Var.f522a.get(str));
        }
        return androidx.core.os.b.a(s3.p.a("keys", arrayList), s3.p.a("values", arrayList2));
    }

    public final d.c c() {
        return this.f526e;
    }

    public final <T> void e(String str, T t5) {
        e4.k.e(str, "key");
        if (!f520f.a(t5)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't put value with type ");
            e4.k.b(t5);
            sb.append(t5.getClass());
            sb.append(" into saved state");
            throw new IllegalArgumentException(sb.toString());
        }
        Object obj = this.f524c.get(str);
        s sVar = obj instanceof s ? (s) obj : null;
        if (sVar != null) {
            sVar.i(t5);
        } else {
            this.f522a.put(str, t5);
        }
        p4.j<Object> jVar = this.f525d.get(str);
        if (jVar == null) {
            return;
        }
        jVar.setValue(t5);
    }
}
