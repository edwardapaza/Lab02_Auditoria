package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Comparator;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaho  reason: invalid package */
/* loaded from: classes.dex */
final class zzaho implements Comparator<zzahm> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzahm zzahmVar, zzahm zzahmVar2) {
        zzahm zzahmVar3 = zzahmVar;
        zzahm zzahmVar4 = zzahmVar2;
        zzahs zzahsVar = (zzahs) zzahmVar3.iterator();
        zzahs zzahsVar2 = (zzahs) zzahmVar4.iterator();
        while (zzahsVar.hasNext() && zzahsVar2.hasNext()) {
            int compareTo = Integer.valueOf(zzahm.zza(zzahsVar.zza())).compareTo(Integer.valueOf(zzahm.zza(zzahsVar2.zza())));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzahmVar3.zzb()).compareTo(Integer.valueOf(zzahmVar4.zzb()));
    }
}
