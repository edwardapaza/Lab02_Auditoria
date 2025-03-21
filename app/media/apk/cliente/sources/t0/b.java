package t0;

import android.os.IBinder;
import com.google.android.gms.common.internal.q;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.lang.reflect.Field;
import t0.a;
/* loaded from: classes.dex */
public final class b<T> extends a.AbstractBinderC0115a {

    /* renamed from: a  reason: collision with root package name */
    private final Object f7588a;

    private b(Object obj) {
        this.f7588a = obj;
    }

    @ResultIgnorabilityUnspecified
    public static <T> T b(a aVar) {
        if (aVar instanceof b) {
            return (T) ((b) aVar).f7588a;
        }
        IBinder asBinder = aVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i5 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i5++;
                field = field2;
            }
        }
        if (i5 != 1) {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        }
        q.k(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return (T) field.get(asBinder);
        } catch (IllegalAccessException e5) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e5);
        } catch (NullPointerException e6) {
            throw new IllegalArgumentException("Binder object is null.", e6);
        }
    }

    public static <T> a f(T t5) {
        return new b(t5);
    }
}
