package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzakk;
import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzor  reason: invalid package */
/* loaded from: classes.dex */
final class zzor<PrimitiveT, KeyProtoT extends zzakk, PublicKeyProtoT extends zzakk> extends zzml<PrimitiveT, KeyProtoT> implements zzcp<PrimitiveT> {
    private final zzoq<KeyProtoT, PublicKeyProtoT> zza;
    private final zznb<PublicKeyProtoT> zzb;

    public zzor(zzoq<KeyProtoT, PublicKeyProtoT> zzoqVar, zznb<PublicKeyProtoT> zznbVar, Class<PrimitiveT> cls) {
        super(zzoqVar, cls);
        this.zza = zzoqVar;
        this.zzb = zznbVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzcp
    public final zzux zzc(zzahm zzahmVar) {
        try {
            KeyProtoT zza = this.zza.zza(zzahmVar);
            this.zza.zzb(zza);
            PublicKeyProtoT zza2 = this.zza.zza((zzoq<KeyProtoT, PublicKeyProtoT>) zza);
            this.zzb.zzb(zza2);
            return (zzux) ((zzaja) zzux.zza().zza(this.zzb.zzd()).zza(zza2.zzi()).zza(this.zzb.zzc()).zzf());
        } catch (zzajj e5) {
            throw new GeneralSecurityException("expected serialized proto of type ", e5);
        }
    }
}
