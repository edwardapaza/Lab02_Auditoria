package androidx.lifecycle;

import android.content.Context;
import androidx.lifecycle.x;
import java.util.List;
/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements v.a<m> {
    @Override // v.a
    public List<Class<? extends v.a<?>>> a() {
        List<Class<? extends v.a<?>>> f5;
        f5 = t3.p.f();
        return f5;
    }

    @Override // v.a
    /* renamed from: c */
    public m b(Context context) {
        e4.k.e(context, "context");
        androidx.startup.a d5 = androidx.startup.a.d(context);
        e4.k.d(d5, "getInstance(context)");
        if (d5.e(ProcessLifecycleInitializer.class)) {
            j.a(context);
            x.b bVar = x.f599m;
            bVar.b(context);
            return bVar.a();
        }
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml".toString());
    }
}
