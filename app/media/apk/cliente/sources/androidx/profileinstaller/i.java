package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.util.Log;
import androidx.profileinstaller.i;
import i2.d0;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final c f658a = new a();

    /* renamed from: b  reason: collision with root package name */
    static final c f659b = new b();

    /* loaded from: classes.dex */
    class a implements c {
        a() {
        }

        @Override // androidx.profileinstaller.i.c
        public void a(int i5, Object obj) {
        }

        @Override // androidx.profileinstaller.i.c
        public void b(int i5, Object obj) {
        }
    }

    /* loaded from: classes.dex */
    class b implements c {
        b() {
        }

        @Override // androidx.profileinstaller.i.c
        public void a(int i5, Object obj) {
            Log.d("ProfileInstaller", i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 4 ? i5 != 5 ? "" : "DIAGNOSTIC_PROFILE_IS_COMPRESSED" : "DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_REF_PROFILE_EXISTS" : "DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_CURRENT_PROFILE_EXISTS");
        }

        @Override // androidx.profileinstaller.i.c
        public void b(int i5, Object obj) {
            String str;
            switch (i5) {
                case 1:
                    str = "RESULT_INSTALL_SUCCESS";
                    break;
                case 2:
                    str = "RESULT_ALREADY_INSTALLED";
                    break;
                case 3:
                    str = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                case 4:
                    str = "RESULT_NOT_WRITABLE";
                    break;
                case 5:
                    str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                case 6:
                    str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                case 7:
                    str = "RESULT_IO_EXCEPTION";
                    break;
                case 8:
                    str = "RESULT_PARSE_EXCEPTION";
                    break;
                case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                default:
                    str = "";
                    break;
                case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                case 11:
                    str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
            }
            if (i5 == 6 || i5 == 7 || i5 == 8) {
                Log.e("ProfileInstaller", str, (Throwable) obj);
            } else {
                Log.d("ProfileInstaller", str);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(int i5, Object obj);

        void b(int i5, Object obj);
    }

    static boolean b(File file) {
        return new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Context context, Executor executor, c cVar) {
        b(context.getFilesDir());
        g(executor, cVar, 11, null);
    }

    static boolean d(PackageInfo packageInfo, File file, c cVar) {
        File file2 = new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        if (file2.exists()) {
            try {
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file2));
                long readLong = dataInputStream.readLong();
                dataInputStream.close();
                boolean z4 = readLong == packageInfo.lastUpdateTime;
                if (z4) {
                    cVar.b(2, null);
                }
                return z4;
            } catch (IOException unused) {
                return false;
            }
        }
        return false;
    }

    static void f(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            dataOutputStream.writeLong(packageInfo.lastUpdateTime);
            dataOutputStream.close();
        } catch (IOException unused) {
        }
    }

    static void g(Executor executor, final c cVar, final int i5, final Object obj) {
        executor.execute(new Runnable() { // from class: androidx.profileinstaller.h
            @Override // java.lang.Runnable
            public final void run() {
                i.c.this.b(i5, obj);
            }
        });
    }

    private static boolean h(AssetManager assetManager, String str, PackageInfo packageInfo, File file, String str2, Executor executor, c cVar) {
        androidx.profileinstaller.c cVar2 = new androidx.profileinstaller.c(assetManager, executor, cVar, str2, "dexopt/baseline.prof", "dexopt/baseline.profm", new File(new File("/data/misc/profiles/cur/0", str), "primary.prof"));
        if (cVar2.e()) {
            boolean n5 = cVar2.i().m().n();
            if (n5) {
                f(packageInfo, file);
            }
            return n5;
        }
        return false;
    }

    public static void i(Context context) {
        j(context, new g(), f658a);
    }

    public static void j(Context context, Executor executor, c cVar) {
        k(context, executor, cVar, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k(Context context, Executor executor, c cVar, boolean z4) {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        boolean z5 = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (z4 || !d(packageInfo, filesDir, cVar)) {
                Log.d("ProfileInstaller", "Installing profile for " + context.getPackageName());
                if (h(assets, packageName, packageInfo, filesDir, name, executor, cVar) && z4) {
                    z5 = true;
                }
            } else {
                Log.d("ProfileInstaller", "Skipping profile installation for " + context.getPackageName());
            }
            o.c(context, z5);
        } catch (PackageManager.NameNotFoundException e5) {
            cVar.b(7, e5);
            o.c(context, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void l(Context context, Executor executor, c cVar) {
        try {
            f(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
            g(executor, cVar, 10, null);
        } catch (PackageManager.NameNotFoundException e5) {
            g(executor, cVar, 7, e5);
        }
    }
}
