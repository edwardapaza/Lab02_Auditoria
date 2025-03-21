package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import v.b;
import v.c;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    private static volatile a f688d;

    /* renamed from: e  reason: collision with root package name */
    private static final Object f689e = new Object();

    /* renamed from: c  reason: collision with root package name */
    final Context f692c;

    /* renamed from: b  reason: collision with root package name */
    final Set<Class<? extends v.a<?>>> f691b = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    final Map<Class<?>, Object> f690a = new HashMap();

    a(Context context) {
        this.f692c = context.getApplicationContext();
    }

    private <T> T c(Class<? extends v.a<?>> cls, Set<Class<?>> set) {
        T t5;
        if (w.a.h()) {
            try {
                w.a.c(cls.getSimpleName());
            } finally {
                w.a.f();
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f690a.containsKey(cls)) {
            t5 = (T) this.f690a.get(cls);
        } else {
            set.add(cls);
            v.a<?> newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            List<Class<? extends v.a<?>>> a5 = newInstance.a();
            if (!a5.isEmpty()) {
                for (Class<? extends v.a<?>> cls2 : a5) {
                    if (!this.f690a.containsKey(cls2)) {
                        c(cls2, set);
                    }
                }
            }
            t5 = (T) newInstance.b(this.f692c);
            set.remove(cls);
            this.f690a.put(cls, t5);
        }
        return t5;
    }

    public static a d(Context context) {
        if (f688d == null) {
            synchronized (f689e) {
                if (f688d == null) {
                    f688d = new a(context);
                }
            }
        }
        return f688d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        try {
            try {
                w.a.c("Startup");
                b(this.f692c.getPackageManager().getProviderInfo(new ComponentName(this.f692c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e5) {
                throw new c(e5);
            }
        } finally {
            w.a.f();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void b(Bundle bundle) {
        String string = this.f692c.getString(b.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (v.a.class.isAssignableFrom(cls)) {
                            this.f691b.add(cls);
                        }
                    }
                }
                for (Class<? extends v.a<?>> cls2 : this.f691b) {
                    c(cls2, hashSet);
                }
            } catch (ClassNotFoundException e5) {
                throw new c(e5);
            }
        }
    }

    public boolean e(Class<? extends v.a<?>> cls) {
        return this.f691b.contains(cls);
    }
}
