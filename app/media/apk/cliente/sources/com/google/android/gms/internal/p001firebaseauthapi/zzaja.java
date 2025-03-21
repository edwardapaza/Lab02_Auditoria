package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.a;
import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
import com.google.android.gms.internal.p001firebaseauthapi.zzaja.zzb;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaja  reason: invalid package */
/* loaded from: classes.dex */
public abstract class zzaja<MessageType extends zzaja<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzahd<MessageType, BuilderType> {
    private static Map<Object, zzaja<?, ?>> zzc = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzame zzb = zzame.zzc();

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaja$zza */
    /* loaded from: classes.dex */
    protected static class zza<T extends zzaja<T, ?>> extends zzahh<T> {
        private final T zza;

        public zza(T t5) {
            this.zza = t5;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaja$zzb */
    /* loaded from: classes.dex */
    public static abstract class zzb<MessageType extends zzaja<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzahf<MessageType, BuilderType> {
        protected MessageType zza;
        private final MessageType zzb;

        /* JADX INFO: Access modifiers changed from: protected */
        public zzb(MessageType messagetype) {
            this.zzb = messagetype;
            if (messagetype.zzv()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.zza = (MessageType) messagetype.zzn();
        }

        private static <MessageType> void zza(MessageType messagetype, MessageType messagetype2) {
            zzaky.zza().zza((zzaky) messagetype).zza(messagetype, messagetype2);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahf
        public /* synthetic */ Object clone() {
            zzb zzbVar = (zzb) this.zzb.zza(zze.zze, null, null);
            zzbVar.zza = (MessageType) zzg();
            return zzbVar;
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb.equals(messagetype)) {
                return this;
            }
            if (!this.zza.zzv()) {
                zzi();
            }
            zza(this.zza, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahf
        public final /* synthetic */ zzahf zzc() {
            return (zzb) clone();
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzakn
        /* renamed from: zzd */
        public final MessageType zzf() {
            MessageType messagetype = (MessageType) zzg();
            if (messagetype.zzu()) {
                return messagetype;
            }
            throw new zzamc(messagetype);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzakn
        /* renamed from: zze */
        public MessageType zzg() {
            if (this.zza.zzv()) {
                this.zza.zzs();
                return this.zza;
            }
            return this.zza;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void zzh() {
            if (this.zza.zzv()) {
                return;
            }
            zzi();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void zzi() {
            MessageType messagetype = (MessageType) this.zzb.zzn();
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzakm
        public final /* synthetic */ zzakk zzr() {
            return this.zzb;
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzakm
        public final boolean zzu() {
            return zzaja.zza(this.zza, false);
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaja$zzc */
    /* loaded from: classes.dex */
    static final class zzc implements zzaiu<zzc> {
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaiu
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaiu
        public final zzakn zza(zzakn zzaknVar, zzakk zzakkVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaiu
        public final zzakt zza(zzakt zzaktVar, zzakt zzaktVar2) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaiu
        public final zzamo zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaiu
        public final zzamy zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaiu
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaiu
        public final boolean zze() {
            throw new NoSuchMethodError();
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaja$zzd */
    /* loaded from: classes.dex */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzaja<MessageType, BuilderType> implements zzakm {
        protected zzais<zzc> zzc = zzais.zzb();

        /* JADX INFO: Access modifiers changed from: package-private */
        public final zzais<zzc> zza() {
            if (this.zzc.zzf()) {
                this.zzc = (zzais) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaja$zze */
    /* loaded from: classes.dex */
    public enum zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzh = {1, 2, 3, 4, 5, 6, 7};

        public static int[] zza() {
            return (int[]) zzh.clone();
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaja$zzf */
    /* loaded from: classes.dex */
    public static class zzf<ContainingType extends zzakk, Type> extends zzaim<ContainingType, Type> {
    }

    private final int zza() {
        return zzaky.zza().zza((zzaky) this).zzb(this);
    }

    private static <T extends zzaja<T, ?>> T zza(T t5) {
        if (t5 == null || t5.zzu()) {
            return t5;
        }
        throw new zzamc(t5).zza().zza(t5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzaja<T, ?>> T zza(T t5, zzahm zzahmVar, zzaip zzaipVar) {
        return (T) zza(zzb(t5, zzahmVar, zzaipVar));
    }

    private static <T extends zzaja<T, ?>> T zza(T t5, zzaib zzaibVar, zzaip zzaipVar) {
        T t6 = (T) t5.zzn();
        try {
            zzalc zza2 = zzaky.zza().zza((zzaky) t6);
            zza2.zza(t6, zzaig.zza(zzaibVar), zzaipVar);
            zza2.zzc(t6);
            return t6;
        } catch (zzajj e5) {
            e = e5;
            if (e.zzk()) {
                e = new zzajj(e);
            }
            throw e.zza(t6);
        } catch (zzamc e6) {
            throw e6.zza().zza(t6);
        } catch (IOException e7) {
            if (e7.getCause() instanceof zzajj) {
                throw ((zzajj) e7.getCause());
            }
            throw new zzajj(e7).zza(t6);
        } catch (RuntimeException e8) {
            if (e8.getCause() instanceof zzajj) {
                throw ((zzajj) e8.getCause());
            }
            throw e8;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzaja<T, ?>> T zza(T t5, InputStream inputStream, zzaip zzaipVar) {
        zzaib zzaicVar;
        if (inputStream == null) {
            byte[] bArr = zzajc.zzb;
            zzaicVar = zzaib.zza(bArr, 0, bArr.length, false);
        } else {
            zzaicVar = new zzaic(inputStream);
        }
        return (T) zza(zza(t5, zzaicVar, zzaipVar));
    }

    private static <T extends zzaja<T, ?>> T zza(T t5, byte[] bArr, int i5, int i6, zzaip zzaipVar) {
        T t6 = (T) t5.zzn();
        try {
            zzalc zza2 = zzaky.zza().zza((zzaky) t6);
            zza2.zza(t6, bArr, 0, i6, new zzahl(zzaipVar));
            zza2.zzc(t6);
            return t6;
        } catch (zzajj e5) {
            e = e5;
            if (e.zzk()) {
                e = new zzajj(e);
            }
            throw e.zza(t6);
        } catch (zzamc e6) {
            throw e6.zza().zza(t6);
        } catch (IOException e7) {
            if (e7.getCause() instanceof zzajj) {
                throw ((zzajj) e7.getCause());
            }
            throw new zzajj(e7).zza(t6);
        } catch (IndexOutOfBoundsException unused) {
            throw zzajj.zzi().zza(t6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzaja<T, ?>> T zza(T t5, byte[] bArr, zzaip zzaipVar) {
        return (T) zza(zza(t5, bArr, 0, bArr.length, zzaipVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzaja<?, ?>> T zza(Class<T> cls) {
        zzaja<?, ?> zzajaVar = zzc.get(cls);
        if (zzajaVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzajaVar = zzc.get(cls);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException("Class initialization cannot fail.", e5);
            }
        }
        if (zzajaVar == null) {
            zzajaVar = (T) ((zzaja) zzamh.zza(cls)).zza(zze.zzf, (Object) null, (Object) null);
            if (zzajaVar == null) {
                throw new IllegalStateException();
            }
            zzc.put(cls, zzajaVar);
        }
        return (T) zzajaVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzajg<E> zza(zzajg<E> zzajgVar) {
        int size = zzajgVar.size();
        return zzajgVar.zza(size == 0 ? 10 : size << 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zza(zzakk zzakkVar, String str, Object[] objArr) {
        return new zzala(zzakkVar, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e5);
        } catch (InvocationTargetException e6) {
            Throwable cause = e6.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzaja<?, ?>> void zza(Class<T> cls, T t5) {
        t5.zzt();
        zzc.put(cls, t5);
    }

    protected static final <T extends zzaja<T, ?>> boolean zza(T t5, boolean z4) {
        byte byteValue = ((Byte) t5.zza(zze.zza, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzd2 = zzaky.zza().zza((zzaky) t5).zzd(t5);
        if (z4) {
            t5.zza(zze.zzb, zzd2 ? t5 : null, null);
        }
        return zzd2;
    }

    private final int zzb(zzalc<?> zzalcVar) {
        return zzalcVar == null ? zzaky.zza().zza((zzaky) this).zza(this) : zzalcVar.zza(this);
    }

    private static <T extends zzaja<T, ?>> T zzb(T t5, zzahm zzahmVar, zzaip zzaipVar) {
        zzaib zzc2 = zzahmVar.zzc();
        T t6 = (T) zza(t5, zzc2, zzaipVar);
        try {
            zzc2.zzb(0);
            return t6;
        } catch (zzajj e5) {
            throw e5.zza(t6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzajg<E> zzo() {
        return zzalb.zzd();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzaky.zza().zza((zzaky) this).zzb(this, (zzaja) obj);
        }
        return false;
    }

    public int hashCode() {
        if (zzv()) {
            return zza();
        }
        if (this.zza == 0) {
            this.zza = zza();
        }
        return this.zza;
    }

    public String toString() {
        return zzakp.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahd
    final int zza(zzalc zzalcVar) {
        if (!zzv()) {
            if (zzh() != Integer.MAX_VALUE) {
                return zzh();
            }
            int zzb2 = zzb(zzalcVar);
            zzb(zzb2);
            return zzb2;
        }
        int zzb3 = zzb(zzalcVar);
        if (zzb3 >= 0) {
            return zzb3;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zzb3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zza(int i5, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzakk
    public final void zza(zzaii zzaiiVar) {
        zzaky.zza().zza((zzaky) this).zza((zzalc) this, (zzanb) zzaik.zza(zzaiiVar));
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahd
    final void zzb(int i5) {
        if (i5 >= 0) {
            this.zzd = (i5 & a.e.API_PRIORITY_OTHER) | (this.zzd & Integer.MIN_VALUE);
            return;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + i5);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahd
    final int zzh() {
        return this.zzd & a.e.API_PRIORITY_OTHER;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzakk
    public final int zzk() {
        return zza((zzalc) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends zzaja<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzl() {
        return (BuilderType) zza(zze.zze, (Object) null, (Object) null);
    }

    public final BuilderType zzm() {
        return (BuilderType) ((zzb) zza(zze.zze, (Object) null, (Object) null)).zza(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MessageType zzn() {
        return (MessageType) zza(zze.zzd, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzakk
    public final /* synthetic */ zzakn zzp() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzakk
    public final /* synthetic */ zzakn zzq() {
        return ((zzb) zza(zze.zze, (Object) null, (Object) null)).zza(this);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzakm
    public final /* synthetic */ zzakk zzr() {
        return (zzaja) zza(zze.zzf, (Object) null, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzs() {
        zzaky.zza().zza((zzaky) this).zzc(this);
        zzt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzt() {
        this.zzd &= a.e.API_PRIORITY_OTHER;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzakm
    public final boolean zzu() {
        return zza(this, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzv() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }
}
