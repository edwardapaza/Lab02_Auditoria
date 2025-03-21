package com.google.android.recaptcha.internal;

import android.net.Uri;
import android.text.TextUtils;
import e4.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import k4.o;
import t3.p;
import t3.q;
/* loaded from: classes.dex */
public final class zzfb {
    public static final zzfb zza = new zzfb();
    private static final List zzb;

    static {
        List h5;
        h5 = p.h("www.recaptcha.net", "www.gstatic.com/recaptcha", "www.gstatic.cn/recaptcha");
        zzb = zze(h5);
    }

    private zzfb() {
    }

    public static final boolean zza(Uri uri) {
        return zzd(uri) && zzc(uri.toString());
    }

    public static final boolean zzb(Uri uri) {
        return zzd(uri);
    }

    private static final boolean zzc(String str) {
        boolean m5;
        List<String> list = zzb;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (String str2 : list) {
            m5 = o.m(str, str2, false, 2, null);
            if (m5) {
                return true;
            }
        }
        return false;
    }

    private static final boolean zzd(Uri uri) {
        return (TextUtils.isEmpty(uri.toString()) || !k.a("https", uri.getScheme()) || TextUtils.isEmpty(uri.getHost())) ? false : true;
    }

    private static final List zze(List list) {
        int k5;
        k5 = q.k(list, 10);
        ArrayList arrayList = new ArrayList(k5);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add("https://" + ((String) it.next()) + "/");
        }
        return arrayList;
    }
}
