package o;

import android.view.ViewGroup;
import androidx.lifecycle.i;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class t0 {

    /* renamed from: a  reason: collision with root package name */
    private final c0 f6660a;

    /* renamed from: b  reason: collision with root package name */
    private final ClassLoader f6661b;

    /* renamed from: d  reason: collision with root package name */
    int f6663d;

    /* renamed from: e  reason: collision with root package name */
    int f6664e;

    /* renamed from: f  reason: collision with root package name */
    int f6665f;

    /* renamed from: g  reason: collision with root package name */
    int f6666g;

    /* renamed from: h  reason: collision with root package name */
    int f6667h;

    /* renamed from: i  reason: collision with root package name */
    boolean f6668i;

    /* renamed from: k  reason: collision with root package name */
    String f6670k;

    /* renamed from: l  reason: collision with root package name */
    int f6671l;

    /* renamed from: m  reason: collision with root package name */
    CharSequence f6672m;

    /* renamed from: n  reason: collision with root package name */
    int f6673n;

    /* renamed from: o  reason: collision with root package name */
    CharSequence f6674o;

    /* renamed from: p  reason: collision with root package name */
    ArrayList<String> f6675p;

    /* renamed from: q  reason: collision with root package name */
    ArrayList<String> f6676q;

    /* renamed from: s  reason: collision with root package name */
    ArrayList<Runnable> f6678s;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<a> f6662c = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    boolean f6669j = true;

    /* renamed from: r  reason: collision with root package name */
    boolean f6677r = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f6679a;

        /* renamed from: b  reason: collision with root package name */
        s f6680b;

        /* renamed from: c  reason: collision with root package name */
        boolean f6681c;

        /* renamed from: d  reason: collision with root package name */
        int f6682d;

        /* renamed from: e  reason: collision with root package name */
        int f6683e;

        /* renamed from: f  reason: collision with root package name */
        int f6684f;

        /* renamed from: g  reason: collision with root package name */
        int f6685g;

        /* renamed from: h  reason: collision with root package name */
        i.b f6686h;

        /* renamed from: i  reason: collision with root package name */
        i.b f6687i;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i5, s sVar) {
            this.f6679a = i5;
            this.f6680b = sVar;
            this.f6681c = false;
            i.b bVar = i.b.RESUMED;
            this.f6686h = bVar;
            this.f6687i = bVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i5, s sVar, boolean z4) {
            this.f6679a = i5;
            this.f6680b = sVar;
            this.f6681c = z4;
            i.b bVar = i.b.RESUMED;
            this.f6686h = bVar;
            this.f6687i = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t0(c0 c0Var, ClassLoader classLoader) {
        this.f6660a = c0Var;
        this.f6661b = classLoader;
    }

    public t0 b(int i5, s sVar, String str) {
        k(i5, sVar, str, 1);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t0 c(ViewGroup viewGroup, s sVar, String str) {
        sVar.M = viewGroup;
        return b(viewGroup.getId(), sVar, str);
    }

    public t0 d(s sVar, String str) {
        k(0, sVar, str, 1);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(a aVar) {
        this.f6662c.add(aVar);
        aVar.f6682d = this.f6663d;
        aVar.f6683e = this.f6664e;
        aVar.f6684f = this.f6665f;
        aVar.f6685g = this.f6666g;
    }

    public abstract int f();

    public abstract int g();

    public abstract void h();

    public abstract void i();

    public t0 j() {
        if (this.f6668i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f6669j = false;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(int i5, s sVar, String str, int i6) {
        String str2 = sVar.W;
        if (str2 != null) {
            p.d.h(sVar, str2);
        }
        Class<?> cls = sVar.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = sVar.E;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + sVar + ": was " + sVar.E + " now " + str);
            }
            sVar.E = str;
        }
        if (i5 != 0) {
            if (i5 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + sVar + " with tag " + str + " to container view with no id");
            }
            int i7 = sVar.C;
            if (i7 != 0 && i7 != i5) {
                throw new IllegalStateException("Can't change container ID of fragment " + sVar + ": was " + sVar.C + " now " + i5);
            }
            sVar.C = i5;
            sVar.D = i5;
        }
        e(new a(i6, sVar));
    }

    public t0 l(s sVar) {
        e(new a(3, sVar));
        return this;
    }

    public t0 m(boolean z4) {
        this.f6677r = z4;
        return this;
    }
}
