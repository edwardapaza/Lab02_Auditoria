package com.google.android.gms.internal.p001firebaseauthapi;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajy  reason: invalid package */
/* loaded from: classes.dex */
public final class zzajy implements zzalf {
    private static final zzakl zza = new zzakb();
    private final zzakl zzb;

    public zzajy() {
        this(new zzakd(zzajb.zza(), zza()));
    }

    private zzajy(zzakl zzaklVar) {
        this.zzb = (zzakl) zzajc.zza(zzaklVar, "messageInfoFactory");
    }

    private static zzakl zza() {
        try {
            return (zzakl) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zza;
        }
    }

    private static boolean zza(zzaki zzakiVar) {
        return zzaka.zza[zzakiVar.zzb().ordinal()] != 1;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzalf
    public final <T> zzalc<T> zza(Class<T> cls) {
        zzale.zza((Class<?>) cls);
        zzaki zza2 = this.zzb.zza(cls);
        if (zza2.zzc()) {
            return zzaja.class.isAssignableFrom(cls) ? zzakq.zza(zzale.zzb(), zzait.zzb(), zza2.zza()) : zzakq.zza(zzale.zza(), zzait.zza(), zza2.zza());
        } else if (zzaja.class.isAssignableFrom(cls)) {
            boolean zza3 = zza(zza2);
            zzaks zzb = zzaku.zzb();
            zzajt zzb2 = zzajt.zzb();
            zzamb<?, ?> zzb3 = zzale.zzb();
            return zza3 ? zzako.zza(cls, zza2, zzb, zzb2, zzb3, zzait.zzb(), zzakj.zzb()) : zzako.zza(cls, zza2, zzb, zzb2, zzb3, (zzair<?>) null, zzakj.zzb());
        } else {
            boolean zza4 = zza(zza2);
            zzaks zza5 = zzaku.zza();
            zzajt zza6 = zzajt.zza();
            zzamb<?, ?> zza7 = zzale.zza();
            return zza4 ? zzako.zza(cls, zza2, zza5, zza6, zza7, zzait.zza(), zzakj.zza()) : zzako.zza(cls, zza2, zza5, zza6, zza7, (zzair<?>) null, zzakj.zza());
        }
    }
}
