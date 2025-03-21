package c;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.i;
import androidx.lifecycle.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Integer, String> f761a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final Map<String, Integer> f762b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, c> f763c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    ArrayList<String> f764d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    final transient Map<String, b<?>> f765e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    final Map<String, Object> f766f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    final Bundle f767g = new Bundle();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [I] */
    /* loaded from: classes.dex */
    public class a<I> extends c.c<I> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f768a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d.a f769b;

        a(String str, d.a aVar) {
            this.f768a = str;
            this.f769b = aVar;
        }

        @Override // c.c
        public void b(I i5, androidx.core.app.d dVar) {
            Integer num = d.this.f762b.get(this.f768a);
            if (num != null) {
                d.this.f764d.add(this.f768a);
                try {
                    d.this.f(num.intValue(), this.f769b, i5, dVar);
                    return;
                } catch (Exception e5) {
                    d.this.f764d.remove(this.f768a);
                    throw e5;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f769b + " and input " + i5 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // c.c
        public void c() {
            d.this.k(this.f768a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b<O> {

        /* renamed from: a  reason: collision with root package name */
        final c.b<O> f771a;

        /* renamed from: b  reason: collision with root package name */
        final d.a<?, O> f772b;

        b(c.b<O> bVar, d.a<?, O> aVar) {
            this.f771a = bVar;
            this.f772b = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        final i f773a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<k> f774b;

        void a() {
            Iterator<k> it = this.f774b.iterator();
            while (it.hasNext()) {
                this.f773a.c(it.next());
            }
            this.f774b.clear();
        }
    }

    private void a(int i5, String str) {
        this.f761a.put(Integer.valueOf(i5), str);
        this.f762b.put(str, Integer.valueOf(i5));
    }

    private <O> void d(String str, int i5, Intent intent, b<O> bVar) {
        if (bVar == null || bVar.f771a == null || !this.f764d.contains(str)) {
            this.f766f.remove(str);
            this.f767g.putParcelable(str, new c.a(i5, intent));
            return;
        }
        bVar.f771a.a(bVar.f772b.c(i5, intent));
        this.f764d.remove(str);
    }

    private int e() {
        int c5 = f4.c.f3050a.c(2147418112);
        while (true) {
            int i5 = c5 + 65536;
            if (!this.f761a.containsKey(Integer.valueOf(i5))) {
                return i5;
            }
            c5 = f4.c.f3050a.c(2147418112);
        }
    }

    private void j(String str) {
        if (this.f762b.get(str) != null) {
            return;
        }
        a(e(), str);
    }

    public final boolean b(int i5, int i6, Intent intent) {
        String str = this.f761a.get(Integer.valueOf(i5));
        if (str == null) {
            return false;
        }
        d(str, i6, intent, this.f765e.get(str));
        return true;
    }

    public final <O> boolean c(int i5, O o5) {
        c.b<?> bVar;
        String str = this.f761a.get(Integer.valueOf(i5));
        if (str == null) {
            return false;
        }
        b<?> bVar2 = this.f765e.get(str);
        if (bVar2 == null || (bVar = bVar2.f771a) == null) {
            this.f767g.remove(str);
            this.f766f.put(str, o5);
            return true;
        } else if (this.f764d.remove(str)) {
            bVar.a(o5);
            return true;
        } else {
            return true;
        }
    }

    public abstract <I, O> void f(int i5, d.a<I, O> aVar, I i6, androidx.core.app.d dVar);

    public final void g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.f764d = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.f767g.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i5 = 0; i5 < stringArrayList.size(); i5++) {
            String str = stringArrayList.get(i5);
            if (this.f762b.containsKey(str)) {
                Integer remove = this.f762b.remove(str);
                if (!this.f767g.containsKey(str)) {
                    this.f761a.remove(remove);
                }
            }
            a(integerArrayList.get(i5).intValue(), stringArrayList.get(i5));
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f762b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f762b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f764d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f767g.clone());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> c.c<I> i(String str, d.a<I, O> aVar, c.b<O> bVar) {
        j(str);
        this.f765e.put(str, new b<>(bVar, aVar));
        if (this.f766f.containsKey(str)) {
            Object obj = this.f766f.get(str);
            this.f766f.remove(str);
            bVar.a(obj);
        }
        c.a aVar2 = (c.a) this.f767g.getParcelable(str);
        if (aVar2 != null) {
            this.f767g.remove(str);
            bVar.a(aVar.c(aVar2.b(), aVar2.a()));
        }
        return new a(str, aVar);
    }

    final void k(String str) {
        Integer remove;
        if (!this.f764d.contains(str) && (remove = this.f762b.remove(str)) != null) {
            this.f761a.remove(remove);
        }
        this.f765e.remove(str);
        if (this.f766f.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f766f.get(str));
            this.f766f.remove(str);
        }
        if (this.f767g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f767g.getParcelable(str));
            this.f767g.remove(str);
        }
        c cVar = this.f763c.get(str);
        if (cVar != null) {
            cVar.a();
            this.f763c.remove(str);
        }
    }
}
