package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzic;
import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmn  reason: invalid package */
/* loaded from: classes.dex */
public final class zzmn {
    private static final Logger zza = Logger.getLogger(zzmn.class.getName());
    private static final zzmn zzb = new zzmn();
    private ConcurrentMap<String, zza> zzc = new ConcurrentHashMap();
    private ConcurrentMap<String, Boolean> zzd = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmn$zza */
    /* loaded from: classes.dex */
    public interface zza {
        zzbt<?> zza();

        <P> zzbt<P> zza(Class<P> cls);

        Class<?> zzb();

        Set<Class<?>> zzc();
    }

    private static <KeyProtoT extends zzakk> zza zza(zznb<KeyProtoT> zznbVar) {
        return new zzmp(zznbVar);
    }

    public static zzmn zza() {
        return zzb;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0092, code lost:
        r6.zzc.putIfAbsent(r0, r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final synchronized void zza(com.google.android.gms.internal.p001firebaseauthapi.zzmn.zza r7, boolean r8, boolean r9) {
        /*
            r6 = this;
            monitor-enter(r6)
            com.google.android.gms.internal.firebase-auth-api.zzbt r0 = r7.zza()     // Catch: java.lang.Throwable -> La8
            java.lang.String r0 = r0.zzb()     // Catch: java.lang.Throwable -> La8
            if (r9 == 0) goto L36
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Boolean> r1 = r6.zzd     // Catch: java.lang.Throwable -> La8
            boolean r1 = r1.containsKey(r0)     // Catch: java.lang.Throwable -> La8
            if (r1 == 0) goto L36
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Boolean> r1 = r6.zzd     // Catch: java.lang.Throwable -> La8
            java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Throwable -> La8
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> La8
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> La8
            if (r1 == 0) goto L22
            goto L36
        L22:
            java.security.GeneralSecurityException r7 = new java.security.GeneralSecurityException     // Catch: java.lang.Throwable -> La8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La8
            java.lang.String r9 = "New keys are already disallowed for key type "
            r8.<init>(r9)     // Catch: java.lang.Throwable -> La8
            r8.append(r0)     // Catch: java.lang.Throwable -> La8
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> La8
            r7.<init>(r8)     // Catch: java.lang.Throwable -> La8
            throw r7     // Catch: java.lang.Throwable -> La8
        L36:
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.android.gms.internal.firebase-auth-api.zzmn$zza> r1 = r6.zzc     // Catch: java.lang.Throwable -> La8
            java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Throwable -> La8
            com.google.android.gms.internal.firebase-auth-api.zzmn$zza r1 = (com.google.android.gms.internal.p001firebaseauthapi.zzmn.zza) r1     // Catch: java.lang.Throwable -> La8
            if (r1 == 0) goto L90
            java.lang.Class r2 = r1.zzb()     // Catch: java.lang.Throwable -> La8
            java.lang.Class r3 = r7.zzb()     // Catch: java.lang.Throwable -> La8
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> La8
            if (r2 == 0) goto L4f
            goto L90
        L4f:
            java.util.logging.Logger r8 = com.google.android.gms.internal.p001firebaseauthapi.zzmn.zza     // Catch: java.lang.Throwable -> La8
            java.util.logging.Level r9 = java.util.logging.Level.WARNING     // Catch: java.lang.Throwable -> La8
            java.lang.String r2 = "com.google.crypto.tink.internal.KeyManagerRegistry"
            java.lang.String r3 = "registerKeyManagerContainer"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La8
            java.lang.String r5 = "Attempted overwrite of a registered key manager for key type "
            r4.<init>(r5)     // Catch: java.lang.Throwable -> La8
            r4.append(r0)     // Catch: java.lang.Throwable -> La8
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> La8
            r8.logp(r9, r2, r3, r4)     // Catch: java.lang.Throwable -> La8
            java.security.GeneralSecurityException r8 = new java.security.GeneralSecurityException     // Catch: java.lang.Throwable -> La8
            java.lang.String r9 = "typeUrl (%s) is already registered with %s, cannot be re-registered with %s"
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> La8
            r3 = 0
            r2[r3] = r0     // Catch: java.lang.Throwable -> La8
            r0 = 1
            java.lang.Class r1 = r1.zzb()     // Catch: java.lang.Throwable -> La8
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> La8
            r2[r0] = r1     // Catch: java.lang.Throwable -> La8
            r0 = 2
            java.lang.Class r7 = r7.zzb()     // Catch: java.lang.Throwable -> La8
            java.lang.String r7 = r7.getName()     // Catch: java.lang.Throwable -> La8
            r2[r0] = r7     // Catch: java.lang.Throwable -> La8
            java.lang.String r7 = java.lang.String.format(r9, r2)     // Catch: java.lang.Throwable -> La8
            r8.<init>(r7)     // Catch: java.lang.Throwable -> La8
            throw r8     // Catch: java.lang.Throwable -> La8
        L90:
            if (r8 != 0) goto L98
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.android.gms.internal.firebase-auth-api.zzmn$zza> r8 = r6.zzc     // Catch: java.lang.Throwable -> La8
            r8.putIfAbsent(r0, r7)     // Catch: java.lang.Throwable -> La8
            goto L9d
        L98:
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.android.gms.internal.firebase-auth-api.zzmn$zza> r8 = r6.zzc     // Catch: java.lang.Throwable -> La8
            r8.put(r0, r7)     // Catch: java.lang.Throwable -> La8
        L9d:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Boolean> r7 = r6.zzd     // Catch: java.lang.Throwable -> La8
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r9)     // Catch: java.lang.Throwable -> La8
            r7.put(r0, r8)     // Catch: java.lang.Throwable -> La8
            monitor-exit(r6)
            return
        La8:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzmn.zza(com.google.android.gms.internal.firebase-auth-api.zzmn$zza, boolean, boolean):void");
    }

    private final synchronized zza zzc(String str) {
        if (!this.zzc.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type " + str);
        }
        return this.zzc.get(str);
    }

    public final zzbt<?> zza(String str) {
        return zzc(str).zza();
    }

    public final <P> zzbt<P> zza(String str, Class<P> cls) {
        zza zzc = zzc(str);
        if (zzc.zzc().contains(cls)) {
            return zzc.zza(cls);
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzc.zzb());
        Set<Class<?>> zzc2 = zzc.zzc();
        StringBuilder sb = new StringBuilder();
        boolean z4 = true;
        for (Class<?> cls2 : zzc2) {
            if (!z4) {
                sb.append(", ");
            }
            sb.append(cls2.getCanonicalName());
            z4 = false;
        }
        String sb2 = sb.toString();
        throw new GeneralSecurityException("Primitive type " + name + " not supported by key manager of type " + valueOf + ", supported primitives: " + sb2);
    }

    public final synchronized <P> void zza(zzbt<P> zzbtVar, zzic.zza zzaVar, boolean z4) {
        if (!zzaVar.zza()) {
            throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");
        }
        zza((zza) new zzmq(zzbtVar), false, z4);
    }

    public final synchronized <P> void zza(zzbt<P> zzbtVar, boolean z4) {
        zza((zzbt) zzbtVar, zzic.zza.zza, true);
    }

    public final synchronized <KeyProtoT extends zzakk> void zza(zznb<KeyProtoT> zznbVar, boolean z4) {
        if (!zznbVar.zza().zza()) {
            String valueOf = String.valueOf(zznbVar.getClass());
            throw new GeneralSecurityException("failed to register key manager " + valueOf + " as it is not FIPS compatible.");
        }
        zza(zza(zznbVar), false, true);
    }

    public final synchronized <KeyProtoT extends zzakk, PublicKeyProtoT extends zzakk> void zza(zzoq<KeyProtoT, PublicKeyProtoT> zzoqVar, zznb<PublicKeyProtoT> zznbVar, boolean z4) {
        zzic.zza zza2 = zzoqVar.zza();
        zzic.zza zza3 = zznbVar.zza();
        if (!zza2.zza()) {
            String valueOf = String.valueOf(zzoqVar.getClass());
            throw new GeneralSecurityException("failed to register key manager " + valueOf + " as it is not FIPS compatible.");
        } else if (!zza3.zza()) {
            String valueOf2 = String.valueOf(zznbVar.getClass());
            throw new GeneralSecurityException("failed to register key manager " + valueOf2 + " as it is not FIPS compatible.");
        } else {
            zza((zza) new zzmr(zzoqVar, zznbVar), true, true);
            zza(zza(zznbVar), false, false);
        }
    }

    public final boolean zzb(String str) {
        return this.zzd.get(str).booleanValue();
    }
}
