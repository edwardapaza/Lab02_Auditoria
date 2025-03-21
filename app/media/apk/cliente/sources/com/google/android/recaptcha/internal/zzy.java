package com.google.android.recaptcha.internal;

import android.content.Context;
import e4.k;
import h4.c;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k4.o;
import t3.m;
import t3.q;
import t3.x;
/* loaded from: classes.dex */
public final class zzy implements zzh {
    private final Context zza;
    private final String zzb = "rce_";
    private final zzad zzc;

    public zzy(Context context) {
        this.zza = context;
        this.zzc = new zzad(context);
    }

    @Override // com.google.android.recaptcha.internal.zzh
    public final String zza(String str) {
        File file = new File(this.zza.getCacheDir(), this.zzb.concat(String.valueOf(str)));
        if (file.exists()) {
            return new String(zzad.zza(file), StandardCharsets.UTF_8);
        }
        return null;
    }

    @Override // com.google.android.recaptcha.internal.zzh
    public final void zzb() {
        boolean m5;
        try {
            File[] listFiles = this.zza.getCacheDir().listFiles();
            if (listFiles != null) {
                ArrayList<File> arrayList = new ArrayList();
                for (File file : listFiles) {
                    m5 = o.m(file.getName(), this.zzb, false, 2, null);
                    if (m5) {
                        arrayList.add(file);
                    }
                }
                for (File file2 : arrayList) {
                    file2.delete();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.google.android.recaptcha.internal.zzh
    public final void zzc(String str, String str2) {
        int k5;
        List c5;
        String w5;
        c cVar = new c('A', 'z');
        k5 = q.k(cVar, 10);
        ArrayList arrayList = new ArrayList(k5);
        Iterator<Character> it = cVar.iterator();
        while (it.hasNext()) {
            arrayList.add(Character.valueOf(((m) it).b()));
        }
        c5 = t3.o.c(arrayList);
        w5 = x.w(c5.subList(0, 8), "", null, null, 0, null, null, 62, null);
        File file = new File(this.zza.getCacheDir(), this.zzb.concat(String.valueOf(w5)));
        zzad.zzb(file, String.valueOf(str2).getBytes(StandardCharsets.UTF_8));
        file.renameTo(new File(this.zza.getCacheDir(), this.zzb.concat(String.valueOf(str))));
    }

    @Override // com.google.android.recaptcha.internal.zzh
    public final boolean zzd(String str) {
        try {
            File[] listFiles = this.zza.getCacheDir().listFiles();
            File file = null;
            if (listFiles != null) {
                int length = listFiles.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    File file2 = listFiles[i5];
                    String name = file2.getName();
                    String str2 = this.zzb;
                    if (k.a(name, str2 + str)) {
                        file = file2;
                        break;
                    }
                    i5++;
                }
            }
            return file != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
