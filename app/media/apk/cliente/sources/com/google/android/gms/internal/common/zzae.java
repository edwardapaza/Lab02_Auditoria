package com.google.android.gms.internal.common;
/* loaded from: classes.dex */
final class zzae extends zzz {
    private final zzag zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzae(zzag zzagVar, int i5) {
        super(zzagVar.size(), i5);
        this.zza = zzagVar;
    }

    @Override // com.google.android.gms.internal.common.zzz
    protected final Object zza(int i5) {
        return this.zza.get(i5);
    }
}
