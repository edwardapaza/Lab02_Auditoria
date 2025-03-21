package com.google.android.gms.internal.location;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* loaded from: classes.dex */
public final class zzev extends zzet {
    private final zzex zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzev(zzex zzexVar, int i) {
        super(zzexVar.size(), i);
        this.zza = zzexVar;
    }

    @Override // com.google.android.gms.internal.location.zzet
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
