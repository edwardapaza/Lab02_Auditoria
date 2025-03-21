package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final androidx.collection.a<String, Method> f694a;

    /* renamed from: b  reason: collision with root package name */
    protected final androidx.collection.a<String, Method> f695b;

    /* renamed from: c  reason: collision with root package name */
    protected final androidx.collection.a<String, Class> f696c;

    public a(androidx.collection.a<String, Method> aVar, androidx.collection.a<String, Method> aVar2, androidx.collection.a<String, Class> aVar3) {
        this.f694a = aVar;
        this.f695b = aVar2;
        this.f696c = aVar3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void N(x.a aVar) {
        try {
            I(c(aVar.getClass()).getName());
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(aVar.getClass().getSimpleName() + " does not have a Parcelizer", e5);
        }
    }

    private Class c(Class<? extends x.a> cls) {
        Class cls2 = this.f696c.get(cls.getName());
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
            this.f696c.put(cls.getName(), cls3);
            return cls3;
        }
        return cls2;
    }

    private Method d(String str) {
        Method method = this.f694a.get(str);
        if (method == null) {
            System.currentTimeMillis();
            Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
            this.f694a.put(str, declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    private Method e(Class cls) {
        Method method = this.f695b.get(cls.getName());
        if (method == null) {
            Class c5 = c(cls);
            System.currentTimeMillis();
            Method declaredMethod = c5.getDeclaredMethod("write", cls, a.class);
            this.f695b.put(cls.getName(), declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    protected abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i5) {
        w(i5);
        A(bArr);
    }

    protected abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i5) {
        w(i5);
        C(charSequence);
    }

    protected abstract void E(int i5);

    public void F(int i5, int i6) {
        w(i6);
        E(i5);
    }

    protected abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i5) {
        w(i5);
        G(parcelable);
    }

    protected abstract void I(String str);

    public void J(String str, int i5) {
        w(i5);
        I(str);
    }

    protected <T extends x.a> void K(T t5, a aVar) {
        try {
            e(t5.getClass()).invoke(null, t5, aVar);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        } catch (IllegalAccessException e6) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e6);
        } catch (NoSuchMethodException e7) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e7);
        } catch (InvocationTargetException e8) {
            if (!(e8.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e8);
            }
            throw ((RuntimeException) e8.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(x.a aVar) {
        if (aVar == null) {
            I(null);
            return;
        }
        N(aVar);
        a b5 = b();
        K(aVar, b5);
        b5.a();
    }

    public void M(x.a aVar, int i5) {
        w(i5);
        L(aVar);
    }

    protected abstract void a();

    protected abstract a b();

    public boolean f() {
        return false;
    }

    protected abstract boolean g();

    public boolean h(boolean z4, int i5) {
        return !m(i5) ? z4 : g();
    }

    protected abstract byte[] i();

    public byte[] j(byte[] bArr, int i5) {
        return !m(i5) ? bArr : i();
    }

    protected abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i5) {
        return !m(i5) ? charSequence : k();
    }

    protected abstract boolean m(int i5);

    protected <T extends x.a> T n(String str, a aVar) {
        try {
            return (T) d(str).invoke(null, aVar);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        } catch (IllegalAccessException e6) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e6);
        } catch (NoSuchMethodException e7) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e7);
        } catch (InvocationTargetException e8) {
            if (e8.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e8.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e8);
        }
    }

    protected abstract int o();

    public int p(int i5, int i6) {
        return !m(i6) ? i5 : o();
    }

    protected abstract <T extends Parcelable> T q();

    public <T extends Parcelable> T r(T t5, int i5) {
        return !m(i5) ? t5 : (T) q();
    }

    protected abstract String s();

    public String t(String str, int i5) {
        return !m(i5) ? str : s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends x.a> T u() {
        String s5 = s();
        if (s5 == null) {
            return null;
        }
        return (T) n(s5, b());
    }

    public <T extends x.a> T v(T t5, int i5) {
        return !m(i5) ? t5 : (T) u();
    }

    protected abstract void w(int i5);

    public void x(boolean z4, boolean z5) {
    }

    protected abstract void y(boolean z4);

    public void z(boolean z4, int i5) {
        w(i5);
        y(z4);
    }
}
