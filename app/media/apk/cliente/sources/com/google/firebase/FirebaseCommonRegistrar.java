package com.google.firebase;

import a2.f;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentRegistrar;
import e2.e;
import e2.h;
import java.util.ArrayList;
import java.util.List;
import k1.c;
/* loaded from: classes.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String e(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return applicationInfo != null ? String.valueOf(applicationInfo.targetSdkVersion) : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String f(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return (applicationInfo == null || Build.VERSION.SDK_INT < 24) ? "" : String.valueOf(applicationInfo.minSdkVersion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String g(Context context) {
        int i5 = Build.VERSION.SDK_INT;
        return context.getPackageManager().hasSystemFeature("android.hardware.type.television") ? "tv" : context.getPackageManager().hasSystemFeature("android.hardware.type.watch") ? "watch" : (i5 < 23 || !context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) ? (i5 < 26 || !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) ? "" : "embedded" : "auto";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String h(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName != null ? i(installerPackageName) : "";
    }

    private static String i(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<c<?>> getComponents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(e2.c.c());
        arrayList.add(f.g());
        arrayList.add(h.b("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(h.b("fire-core", "20.4.3"));
        arrayList.add(h.b("device-name", i(Build.PRODUCT)));
        arrayList.add(h.b("device-model", i(Build.DEVICE)));
        arrayList.add(h.b("device-brand", i(Build.BRAND)));
        arrayList.add(h.c("android-target-sdk", new h.a() { // from class: f1.h
            @Override // e2.h.a
            public final String a(Object obj) {
                String e5;
                e5 = FirebaseCommonRegistrar.e((Context) obj);
                return e5;
            }
        }));
        arrayList.add(h.c("android-min-sdk", new h.a() { // from class: f1.i
            @Override // e2.h.a
            public final String a(Object obj) {
                String f5;
                f5 = FirebaseCommonRegistrar.f((Context) obj);
                return f5;
            }
        }));
        arrayList.add(h.c("android-platform", new h.a() { // from class: f1.j
            @Override // e2.h.a
            public final String a(Object obj) {
                String g5;
                g5 = FirebaseCommonRegistrar.g((Context) obj);
                return g5;
            }
        }));
        arrayList.add(h.c("android-installer", new h.a() { // from class: f1.k
            @Override // e2.h.a
            public final String a(Object obj) {
                String h5;
                h5 = FirebaseCommonRegistrar.h((Context) obj);
                return h5;
            }
        }));
        String a5 = e.a();
        if (a5 != null) {
            arrayList.add(h.b("kotlin", a5));
        }
        return arrayList;
    }
}
