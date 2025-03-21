package io.grpc.internal;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class c1 {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f4603a = Logger.getLogger(c1.class.getName());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4604a;

        static {
            int[] iArr = new int[k2.b.values().length];
            f4604a = iArr;
            try {
                iArr[k2.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4604a[k2.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4604a[k2.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4604a[k2.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4604a[k2.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4604a[k2.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private c1() {
    }

    public static Object a(String str) {
        k2.a aVar = new k2.a(new StringReader(str));
        try {
            return e(aVar);
        } finally {
            try {
                aVar.close();
            } catch (IOException e5) {
                f4603a.log(Level.WARNING, "Failed to close", (Throwable) e5);
            }
        }
    }

    private static List<?> b(k2.a aVar) {
        aVar.c();
        ArrayList arrayList = new ArrayList();
        while (aVar.u()) {
            arrayList.add(e(aVar));
        }
        boolean z4 = aVar.M() == k2.b.END_ARRAY;
        z0.k.u(z4, "Bad token: " + aVar.p());
        aVar.j();
        return Collections.unmodifiableList(arrayList);
    }

    private static Void c(k2.a aVar) {
        aVar.I();
        return null;
    }

    private static Map<String, ?> d(k2.a aVar) {
        aVar.d();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (aVar.u()) {
            linkedHashMap.put(aVar.A(), e(aVar));
        }
        boolean z4 = aVar.M() == k2.b.END_OBJECT;
        z0.k.u(z4, "Bad token: " + aVar.p());
        aVar.l();
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private static Object e(k2.a aVar) {
        z0.k.u(aVar.u(), "unexpected end of JSON");
        switch (a.f4604a[aVar.M().ordinal()]) {
            case 1:
                return b(aVar);
            case 2:
                return d(aVar);
            case 3:
                return aVar.K();
            case 4:
                return Double.valueOf(aVar.z());
            case 5:
                return Boolean.valueOf(aVar.x());
            case 6:
                return c(aVar);
            default:
                throw new IllegalStateException("Bad token: " + aVar.p());
        }
    }
}
