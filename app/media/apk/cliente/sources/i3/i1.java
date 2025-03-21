package i3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
/* loaded from: classes.dex */
final class i1 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    class a<T> implements Comparator<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f3422a;

        a(b bVar) {
            this.f3422a = bVar;
        }

        @Override // java.util.Comparator
        public int compare(T t5, T t6) {
            int b5 = this.f3422a.b(t5) - this.f3422a.b(t6);
            return b5 != 0 ? b5 : t5.getClass().getName().compareTo(t6.getClass().getName());
        }
    }

    /* loaded from: classes.dex */
    public interface b<T> {
        boolean a(T t5);

        int b(T t5);
    }

    private static <T> T a(Class<T> cls, Class<?> cls2) {
        try {
            return (T) cls2.asSubclass(cls).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassCastException unused) {
            return null;
        } catch (Throwable th) {
            throw new ServiceConfigurationError(String.format("Provider %s could not be instantiated %s", cls2.getName(), th), th);
        }
    }

    static <T> Iterable<T> b(Class<T> cls, Iterable<Class<?>> iterable) {
        ArrayList arrayList = new ArrayList();
        for (Class<?> cls2 : iterable) {
            Object a5 = a(cls, cls2);
            if (a5 != null) {
                arrayList.add(a5);
            }
        }
        return arrayList;
    }

    public static <T> Iterable<T> c(Class<T> cls, ClassLoader classLoader) {
        ServiceLoader load = ServiceLoader.load(cls, classLoader);
        return !load.iterator().hasNext() ? ServiceLoader.load(cls) : load;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(ClassLoader classLoader) {
        try {
            Class.forName("android.app.Application", false, classLoader);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static <T> List<T> e(Class<T> cls, Iterable<Class<?>> iterable, ClassLoader classLoader, b<T> bVar) {
        Iterable b5 = d(classLoader) ? b(cls, iterable) : c(cls, classLoader);
        ArrayList arrayList = new ArrayList();
        for (T t5 : b5) {
            if (bVar.a(t5)) {
                arrayList.add(t5);
            }
        }
        Collections.sort(arrayList, Collections.reverseOrder(new a(bVar)));
        return Collections.unmodifiableList(arrayList);
    }
}
