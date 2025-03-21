package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
/* loaded from: classes.dex */
public final class s0 {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1199a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1200b;

    /* renamed from: c  reason: collision with root package name */
    private static String f1201c;

    /* renamed from: d  reason: collision with root package name */
    private static int f1202d;

    public static int a(Context context) {
        b(context);
        return f1202d;
    }

    private static void b(Context context) {
        Bundle bundle;
        synchronized (f1199a) {
            if (f1200b) {
                return;
            }
            f1200b = true;
            try {
                bundle = s0.d.a(context).a(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e5) {
                Log.wtf("MetadataValueReader", "This should never happen.", e5);
            }
            if (bundle == null) {
                return;
            }
            f1201c = bundle.getString("com.google.app.id");
            f1202d = bundle.getInt("com.google.android.gms.version");
        }
    }
}
