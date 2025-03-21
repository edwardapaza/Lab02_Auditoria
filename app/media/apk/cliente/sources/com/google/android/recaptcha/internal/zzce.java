package com.google.android.recaptcha.internal;

import e4.k;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import s3.t;
/* loaded from: classes.dex */
public abstract class zzce implements InvocationHandler {
    private final Object zza;

    public zzce(Object obj) {
        this.zza = obj;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        Object obj2;
        if (k.a(method.getName(), "toString") && method.getParameterTypes().length == 0) {
            return "Proxy@".concat(String.valueOf(Integer.toHexString(obj.hashCode())));
        }
        if (k.a(method.getName(), "hashCode") && method.getParameterTypes().length == 0) {
            return Integer.valueOf(System.identityHashCode(obj));
        }
        if (k.a(method.getName(), "equals") && method.getParameterTypes().length != 0) {
            boolean z4 = false;
            if (objArr != null && objArr.length != 0) {
                Object obj3 = objArr[0];
                if ((obj3 != null ? obj3.hashCode() : 0) == obj.hashCode()) {
                    z4 = true;
                }
            }
            return Boolean.valueOf(z4);
        } else if (zza(obj, method, objArr)) {
            if ((this.zza == null && k.a(method.getReturnType(), Void.TYPE)) || ((obj2 = this.zza) != null && k.a(zzgd.zza(obj2.getClass()), zzgd.zza(method.getReturnType())))) {
                Object obj4 = this.zza;
                return obj4 == null ? t.f7573a : obj4;
            }
            Object obj5 = this.zza;
            Class<?> returnType = method.getReturnType();
            throw new IllegalArgumentException(obj5 + " cannot be returned from method with return type " + returnType);
        } else {
            return t.f7573a;
        }
    }

    public abstract boolean zza(Object obj, Method method, Object[] objArr);
}
