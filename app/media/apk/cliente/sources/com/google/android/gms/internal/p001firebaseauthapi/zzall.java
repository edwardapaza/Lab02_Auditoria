package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzall  reason: invalid package */
/* loaded from: classes.dex */
public final class zzall extends zzalt {
    private final /* synthetic */ zzalh zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzall(zzalh zzalhVar) {
        super(zzalhVar);
        this.zza = zzalhVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzalt, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzalj(this.zza);
    }
}
