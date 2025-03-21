package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.List;
import java.util.Map;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaik  reason: invalid package */
/* loaded from: classes.dex */
final class zzaik implements zzanb {
    private final zzaii zza;

    private zzaik(zzaii zzaiiVar) {
        zzaii zzaiiVar2 = (zzaii) zzajc.zza(zzaiiVar, "output");
        this.zza = zzaiiVar2;
        zzaiiVar2.zza = this;
    }

    public static zzaik zza(zzaii zzaiiVar) {
        zzaik zzaikVar = zzaiiVar.zza;
        return zzaikVar != null ? zzaikVar : new zzaik(zzaiiVar);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final int zza() {
        return zzana.zza;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    @Deprecated
    public final void zza(int i5) {
        this.zza.zzj(i5, 4);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zza(int i5, double d5) {
        this.zza.zzb(i5, d5);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zza(int i5, float f5) {
        this.zza.zzb(i5, f5);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zza(int i5, int i6) {
        this.zza.zzh(i5, i6);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zza(int i5, long j5) {
        this.zza.zzf(i5, j5);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zza(int i5, zzahm zzahmVar) {
        this.zza.zzc(i5, zzahmVar);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final <K, V> void zza(int i5, zzakf<K, V> zzakfVar, Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zza.zzj(i5, 2);
            this.zza.zzl(zzakc.zza(zzakfVar, entry.getKey(), entry.getValue()));
            zzakc.zza(this.zza, zzakfVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zza(int i5, Object obj) {
        if (obj instanceof zzahm) {
            this.zza.zzd(i5, (zzahm) obj);
        } else {
            this.zza.zzb(i5, (zzakk) obj);
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zza(int i5, Object obj, zzalc zzalcVar) {
        zzaii zzaiiVar = this.zza;
        zzaiiVar.zzj(i5, 3);
        zzalcVar.zza((zzalc) ((zzakk) obj), (zzanb) zzaiiVar.zza);
        zzaiiVar.zzj(i5, 4);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zza(int i5, String str) {
        this.zza.zzb(i5, str);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zza(int i5, List<zzahm> list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            this.zza.zzc(i5, list.get(i6));
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zza(int i5, List<?> list, zzalc zzalcVar) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            zza(i5, list.get(i6), zzalcVar);
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zza(int i5, List<Boolean> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzb(i5, list.get(i6).booleanValue());
                i6++;
            }
            return;
        }
        this.zza.zzj(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += zzaii.zza(list.get(i8).booleanValue());
        }
        this.zza.zzl(i7);
        while (i6 < list.size()) {
            this.zza.zzb(list.get(i6).booleanValue());
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zza(int i5, boolean z4) {
        this.zza.zzb(i5, z4);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    @Deprecated
    public final void zzb(int i5) {
        this.zza.zzj(i5, 3);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zzb(int i5, int i6) {
        this.zza.zzg(i5, i6);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zzb(int i5, long j5) {
        this.zza.zzh(i5, j5);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zzb(int i5, Object obj, zzalc zzalcVar) {
        this.zza.zzc(i5, (zzakk) obj, zzalcVar);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zzb(int i5, List<String> list) {
        int i6 = 0;
        if (!(list instanceof zzajq)) {
            while (i6 < list.size()) {
                this.zza.zzb(i5, list.get(i6));
                i6++;
            }
            return;
        }
        zzajq zzajqVar = (zzajq) list;
        while (i6 < list.size()) {
            Object zzb = zzajqVar.zzb(i6);
            if (zzb instanceof String) {
                this.zza.zzb(i5, (String) zzb);
            } else {
                this.zza.zzc(i5, (zzahm) zzb);
            }
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zzb(int i5, List<?> list, zzalc zzalcVar) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            zzb(i5, list.get(i6), zzalcVar);
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zzb(int i5, List<Double> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzb(i5, list.get(i6).doubleValue());
                i6++;
            }
            return;
        }
        this.zza.zzj(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += zzaii.zza(list.get(i8).doubleValue());
        }
        this.zza.zzl(i7);
        while (i6 < list.size()) {
            this.zza.zzb(list.get(i6).doubleValue());
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zzc(int i5, int i6) {
        this.zza.zzh(i5, i6);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zzc(int i5, long j5) {
        this.zza.zzf(i5, j5);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zzc(int i5, List<Integer> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzh(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.zza.zzj(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += zzaii.zza(list.get(i8).intValue());
        }
        this.zza.zzl(i7);
        while (i6 < list.size()) {
            this.zza.zzj(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zzd(int i5, int i6) {
        this.zza.zzg(i5, i6);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zzd(int i5, long j5) {
        this.zza.zzg(i5, j5);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zzd(int i5, List<Integer> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzg(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.zza.zzj(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += zzaii.zzb(list.get(i8).intValue());
        }
        this.zza.zzl(i7);
        while (i6 < list.size()) {
            this.zza.zzi(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zze(int i5, int i6) {
        this.zza.zzi(i5, i6);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zze(int i5, long j5) {
        this.zza.zzh(i5, j5);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zze(int i5, List<Long> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzf(i5, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.zza.zzj(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += zzaii.zza(list.get(i8).longValue());
        }
        this.zza.zzl(i7);
        while (i6 < list.size()) {
            this.zza.zzf(list.get(i6).longValue());
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zzf(int i5, int i6) {
        this.zza.zzk(i5, i6);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zzf(int i5, List<Float> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzb(i5, list.get(i6).floatValue());
                i6++;
            }
            return;
        }
        this.zza.zzj(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += zzaii.zza(list.get(i8).floatValue());
        }
        this.zza.zzl(i7);
        while (i6 < list.size()) {
            this.zza.zzb(list.get(i6).floatValue());
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zzg(int i5, List<Integer> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzh(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.zza.zzj(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += zzaii.zzc(list.get(i8).intValue());
        }
        this.zza.zzl(i7);
        while (i6 < list.size()) {
            this.zza.zzj(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zzh(int i5, List<Long> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzh(i5, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.zza.zzj(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += zzaii.zzb(list.get(i8).longValue());
        }
        this.zza.zzl(i7);
        while (i6 < list.size()) {
            this.zza.zzh(list.get(i6).longValue());
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zzi(int i5, List<Integer> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzg(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.zza.zzj(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += zzaii.zze(list.get(i8).intValue());
        }
        this.zza.zzl(i7);
        while (i6 < list.size()) {
            this.zza.zzi(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zzj(int i5, List<Long> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzf(i5, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.zza.zzj(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += zzaii.zzc(list.get(i8).longValue());
        }
        this.zza.zzl(i7);
        while (i6 < list.size()) {
            this.zza.zzf(list.get(i6).longValue());
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zzk(int i5, List<Integer> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzi(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.zza.zzj(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += zzaii.zzf(list.get(i8).intValue());
        }
        this.zza.zzl(i7);
        while (i6 < list.size()) {
            this.zza.zzk(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zzl(int i5, List<Long> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzg(i5, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.zza.zzj(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += zzaii.zzd(list.get(i8).longValue());
        }
        this.zza.zzl(i7);
        while (i6 < list.size()) {
            this.zza.zzg(list.get(i6).longValue());
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zzm(int i5, List<Integer> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzk(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.zza.zzj(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += zzaii.zzh(list.get(i8).intValue());
        }
        this.zza.zzl(i7);
        while (i6 < list.size()) {
            this.zza.zzl(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzanb
    public final void zzn(int i5, List<Long> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzh(i5, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.zza.zzj(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += zzaii.zze(list.get(i8).longValue());
        }
        this.zza.zzl(i7);
        while (i6 < list.size()) {
            this.zza.zzh(list.get(i6).longValue());
            i6++;
        }
    }
}
