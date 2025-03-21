package u;

import android.os.Bundle;
import androidx.lifecycle.i;
import androidx.lifecycle.k;
import androidx.lifecycle.m;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import u.d;
/* loaded from: classes.dex */
public final class b implements k {

    /* renamed from: b  reason: collision with root package name */
    public static final a f7703b = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final f f7704a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e4.g gVar) {
            this();
        }
    }

    public b(f fVar) {
        e4.k.e(fVar, "owner");
        this.f7704a = fVar;
    }

    private final void h(String str) {
        try {
            Class<? extends U> asSubclass = Class.forName(str, false, b.class.getClassLoader()).asSubclass(d.a.class);
            e4.k.d(asSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    Object newInstance = declaredConstructor.newInstance(new Object[0]);
                    e4.k.d(newInstance, "{\n                constr…wInstance()\n            }");
                    ((d.a) newInstance).a(this.f7704a);
                } catch (Exception e5) {
                    throw new RuntimeException("Failed to instantiate " + str, e5);
                }
            } catch (NoSuchMethodException e6) {
                throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e6);
            }
        } catch (ClassNotFoundException e7) {
            throw new RuntimeException("Class " + str + " wasn't found", e7);
        }
    }

    @Override // androidx.lifecycle.k
    public void d(m mVar, i.a aVar) {
        e4.k.e(mVar, "source");
        e4.k.e(aVar, "event");
        if (aVar != i.a.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        mVar.a().c(this);
        Bundle b5 = this.f7704a.k().b("androidx.savedstate.Restarter");
        if (b5 == null) {
            return;
        }
        ArrayList<String> stringArrayList = b5.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        for (String str : stringArrayList) {
            h(str);
        }
    }
}
