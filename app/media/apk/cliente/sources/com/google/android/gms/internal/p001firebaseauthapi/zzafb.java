package com.google.android.gms.internal.p001firebaseauthapi;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.q;
import com.google.firebase.auth.d2;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafb  reason: invalid package */
/* loaded from: classes.dex */
public final class zzafb {
    private String zza;
    private String zzb;
    private boolean zzc;
    private String zzd;
    private String zze;
    private zzafu zzf;
    private String zzg;
    private String zzh;
    private long zzi;
    private long zzj;
    private boolean zzk;
    private d2 zzl;
    private List<zzafq> zzm;
    private zzaq<zzafp> zzn;

    public zzafb() {
        this.zzf = new zzafu();
        this.zzn = zzaq.zzh();
    }

    public zzafb(String str, String str2, boolean z4, String str3, String str4, zzafu zzafuVar, String str5, String str6, long j5, long j6, boolean z5, d2 d2Var, List<zzafq> list, zzaq<zzafp> zzaqVar) {
        zzafu zzafuVar2;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z4;
        this.zzd = str3;
        this.zze = str4;
        if (zzafuVar == null) {
            zzafuVar2 = new zzafu();
        } else {
            List<zzafr> zza = zzafuVar.zza();
            zzafu zzafuVar3 = new zzafu();
            if (zza != null) {
                zzafuVar3.zza().addAll(zza);
            }
            zzafuVar2 = zzafuVar3;
        }
        this.zzf = zzafuVar2;
        this.zzg = str5;
        this.zzh = str6;
        this.zzi = j5;
        this.zzj = j6;
        this.zzk = false;
        this.zzl = null;
        this.zzm = list == null ? new ArrayList<>() : list;
        this.zzn = zzaqVar;
    }

    public final long zza() {
        return this.zzi;
    }

    public final zzafb zza(d2 d2Var) {
        this.zzl = d2Var;
        return this;
    }

    public final zzafb zza(String str) {
        this.zzd = str;
        return this;
    }

    public final zzafb zza(List<zzafr> list) {
        q.k(list);
        zzafu zzafuVar = new zzafu();
        this.zzf = zzafuVar;
        zzafuVar.zza().addAll(list);
        return this;
    }

    public final zzafb zza(boolean z4) {
        this.zzk = z4;
        return this;
    }

    public final long zzb() {
        return this.zzj;
    }

    public final zzafb zzb(String str) {
        this.zzb = str;
        return this;
    }

    public final Uri zzc() {
        if (TextUtils.isEmpty(this.zze)) {
            return null;
        }
        return Uri.parse(this.zze);
    }

    public final zzafb zzc(String str) {
        q.e(str);
        this.zzg = str;
        return this;
    }

    public final zzafb zzd(String str) {
        this.zze = str;
        return this;
    }

    public final zzaq<zzafp> zzd() {
        return this.zzn;
    }

    public final d2 zze() {
        return this.zzl;
    }

    public final zzafu zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zzd;
    }

    public final String zzh() {
        return this.zzb;
    }

    public final String zzi() {
        return this.zza;
    }

    public final String zzj() {
        return this.zzh;
    }

    public final List<zzafq> zzk() {
        return this.zzm;
    }

    public final List<zzafr> zzl() {
        return this.zzf.zza();
    }

    public final boolean zzm() {
        return this.zzc;
    }

    public final boolean zzn() {
        return this.zzk;
    }
}
