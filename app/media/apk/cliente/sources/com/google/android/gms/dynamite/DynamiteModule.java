package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.q;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public final class DynamiteModule {

    /* renamed from: h  reason: collision with root package name */
    private static Boolean f1226h = null;

    /* renamed from: i  reason: collision with root package name */
    private static String f1227i = null;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f1228j = false;

    /* renamed from: k  reason: collision with root package name */
    private static int f1229k = -1;

    /* renamed from: l  reason: collision with root package name */
    private static Boolean f1230l;

    /* renamed from: q  reason: collision with root package name */
    private static m f1235q;

    /* renamed from: r  reason: collision with root package name */
    private static n f1236r;

    /* renamed from: a  reason: collision with root package name */
    private final Context f1237a;

    /* renamed from: m  reason: collision with root package name */
    private static final ThreadLocal f1231m = new ThreadLocal();

    /* renamed from: n  reason: collision with root package name */
    private static final ThreadLocal f1232n = new com.google.android.gms.dynamite.b();

    /* renamed from: o  reason: collision with root package name */
    private static final b.a f1233o = new c();

    /* renamed from: b  reason: collision with root package name */
    public static final b f1220b = new d();

    /* renamed from: c  reason: collision with root package name */
    public static final b f1221c = new e();

    /* renamed from: d  reason: collision with root package name */
    public static final b f1222d = new f();

    /* renamed from: e  reason: collision with root package name */
    public static final b f1223e = new g();

    /* renamed from: f  reason: collision with root package name */
    public static final b f1224f = new h();

    /* renamed from: g  reason: collision with root package name */
    public static final b f1225g = new i();

    /* renamed from: p  reason: collision with root package name */
    public static final b f1234p = new j();

    /* loaded from: classes.dex */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* loaded from: classes.dex */
    public static class a extends Exception {
        /* synthetic */ a(String str, Throwable th, u0.d dVar) {
            super(str, th);
        }

        /* synthetic */ a(String str, u0.d dVar) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public interface b {

        /* loaded from: classes.dex */
        public interface a {
            int a(Context context, String str);

            int b(Context context, String str, boolean z4);
        }

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0040b {

            /* renamed from: a  reason: collision with root package name */
            public int f1238a = 0;

            /* renamed from: b  reason: collision with root package name */
            public int f1239b = 0;

            /* renamed from: c  reason: collision with root package name */
            public int f1240c = 0;
        }

        C0040b a(Context context, String str, a aVar);
    }

    private DynamiteModule(Context context) {
        q.k(context);
        this.f1237a = context;
    }

    public static int a(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            Class<?> loadClass = classLoader.loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (p.a(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            String valueOf = String.valueOf(declaredField.get(null));
            Log.e("DynamiteModule", "Module descriptor id '" + valueOf + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e5) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e5.getMessage())));
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0247  */
    @com.google.errorprone.annotations.ResultIgnorabilityUnspecified
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.dynamite.DynamiteModule c(android.content.Context r16, com.google.android.gms.dynamite.DynamiteModule.b r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 716
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.c(android.content.Context, com.google.android.gms.dynamite.DynamiteModule$b, java.lang.String):com.google.android.gms.dynamite.DynamiteModule");
    }

    public static int d(Context context, String str, boolean z4) {
        Field declaredField;
        Throwable th;
        RemoteException e5;
        Cursor cursor;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = f1226h;
                Cursor cursor2 = null;
                int i5 = 0;
                if (bool == null) {
                    try {
                        declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e6) {
                        String obj = e6.toString();
                        Log.w("DynamiteModule", "Failed to load module via V2: " + obj);
                        bool = Boolean.FALSE;
                    }
                    synchronized (declaredField.getDeclaringClass()) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader != ClassLoader.getSystemClassLoader()) {
                            if (classLoader != null) {
                                try {
                                    g(classLoader);
                                } catch (a unused) {
                                }
                                bool = Boolean.TRUE;
                                f1226h = bool;
                            } else if (!i(context)) {
                                return 0;
                            } else {
                                if (!f1228j) {
                                    Boolean bool2 = Boolean.TRUE;
                                    if (!bool2.equals(null)) {
                                        try {
                                            int e7 = e(context, str, z4, true);
                                            String str2 = f1227i;
                                            if (str2 != null && !str2.isEmpty()) {
                                                ClassLoader a5 = u0.b.a();
                                                if (a5 == null) {
                                                    if (Build.VERSION.SDK_INT >= 29) {
                                                        final String str3 = f1227i;
                                                        q.k(str3);
                                                        final ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                                                        a5 = new PathClassLoader(str3, systemClassLoader) { // from class: dalvik.system.DelegateLastClassLoader
                                                            static {
                                                                throw new NoClassDefFoundError();
                                                            }
                                                        };
                                                    } else {
                                                        String str4 = f1227i;
                                                        q.k(str4);
                                                        a5 = new com.google.android.gms.dynamite.a(str4, ClassLoader.getSystemClassLoader());
                                                    }
                                                }
                                                g(a5);
                                                declaredField.set(null, a5);
                                                f1226h = bool2;
                                                return e7;
                                            }
                                            return e7;
                                        } catch (a unused2) {
                                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        }
                                    }
                                }
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                            }
                        }
                        bool = Boolean.FALSE;
                        f1226h = bool;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return e(context, str, z4, false);
                    } catch (a e8) {
                        String message = e8.getMessage();
                        Log.w("DynamiteModule", "Failed to retrieve remote module version: " + message);
                        return 0;
                    }
                }
                m j5 = j(context);
                if (j5 != null) {
                    try {
                        try {
                            int a6 = j5.a();
                            if (a6 >= 3) {
                                k kVar = (k) f1231m.get();
                                if (kVar == null || (cursor = kVar.f1241a) == null) {
                                    Cursor cursor3 = (Cursor) t0.b.b(j5.o(t0.b.f(context), str, z4, ((Long) f1232n.get()).longValue()));
                                    if (cursor3 != null) {
                                        try {
                                            if (cursor3.moveToFirst()) {
                                                int i6 = cursor3.getInt(0);
                                                if (i6 <= 0 || !h(cursor3)) {
                                                    cursor2 = cursor3;
                                                }
                                                if (cursor2 != null) {
                                                    cursor2.close();
                                                }
                                                i5 = i6;
                                            }
                                        } catch (RemoteException e9) {
                                            e5 = e9;
                                            cursor2 = cursor3;
                                            String message2 = e5.getMessage();
                                            Log.w("DynamiteModule", "Failed to retrieve remote module version: " + message2);
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            return i5;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            cursor2 = cursor3;
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                    if (cursor3 != null) {
                                        cursor3.close();
                                    }
                                } else {
                                    i5 = cursor.getInt(0);
                                }
                            } else if (a6 == 2) {
                                Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                                i5 = j5.f(t0.b.f(context), str, z4);
                            } else {
                                Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                                i5 = j5.b(t0.b.f(context), str, z4);
                            }
                        } catch (RemoteException e10) {
                            e5 = e10;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                return i5;
            }
        } catch (Throwable th4) {
            q0.e.a(context, th4);
            throw th4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x009f, code lost:
        r8.close();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00dc  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int e(android.content.Context r8, java.lang.String r9, boolean r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.e(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    private static DynamiteModule f(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context);
    }

    private static void g(ClassLoader classLoader) {
        n nVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                nVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                nVar = queryLocalInterface instanceof n ? (n) queryLocalInterface : new n(iBinder);
            }
            f1236r = nVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e5) {
            throw new a("Failed to instantiate dynamite loader", e5, null);
        }
    }

    private static boolean h(Cursor cursor) {
        k kVar = (k) f1231m.get();
        if (kVar == null || kVar.f1241a != null) {
            return false;
        }
        kVar.f1241a = cursor;
        return true;
    }

    private static boolean i(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(f1230l)) {
            return true;
        }
        boolean z4 = false;
        if (f1230l == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (l0.g.e().g(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z4 = true;
            }
            Boolean valueOf = Boolean.valueOf(z4);
            f1230l = valueOf;
            z4 = valueOf.booleanValue();
            if (z4 && (applicationInfo = resolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                f1228j = true;
            }
        }
        if (!z4) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z4;
    }

    private static m j(Context context) {
        m mVar;
        synchronized (DynamiteModule.class) {
            m mVar2 = f1235q;
            if (mVar2 != null) {
                return mVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    mVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    mVar = queryLocalInterface instanceof m ? (m) queryLocalInterface : new m(iBinder);
                }
                if (mVar != null) {
                    f1235q = mVar;
                    return mVar;
                }
            } catch (Exception e5) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e5.getMessage());
            }
            return null;
        }
    }

    @ResultIgnorabilityUnspecified
    public Context b() {
        return this.f1237a;
    }
}
