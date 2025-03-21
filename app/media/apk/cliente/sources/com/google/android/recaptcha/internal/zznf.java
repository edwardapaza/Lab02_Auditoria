package com.google.android.recaptcha.internal;

import i2.a0;
import i2.d0;
/* loaded from: classes.dex */
public final class zznf extends zzit implements zzkf {
    private static final zznf zzb;
    private int zzd;
    private Object zzf;
    private int zzg;
    private long zzl;
    private zzib zzm;
    private int zzn;
    private zzmr zzo;
    private zznr zzp;
    private zzlj zzr;
    private zzib zzs;
    private int zze = 0;
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    private String zzq = "";

    static {
        zznf zznfVar = new zznf();
        zzb = zznfVar;
        zzit.zzD(zznf.class, zznfVar);
    }

    private zznf() {
    }

    public static zznf zzH() {
        return zzb;
    }

    public static zznf zzI(byte[] bArr) {
        return (zznf) zzit.zzu(zzb, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzL(zznf zznfVar, String str) {
        str.getClass();
        zznfVar.zzj = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzN(zznf zznfVar, zzmr zzmrVar) {
        zznfVar.zzo = zzmrVar;
        zznfVar.zzd |= 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzO(zznf zznfVar, zznr zznrVar) {
        zznrVar.getClass();
        zznfVar.zzp = zznrVar;
        zznfVar.zzd |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzR(zznf zznfVar, String str) {
        str.getClass();
        zznfVar.zzh = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzS(zznf zznfVar, String str) {
        str.getClass();
        zznfVar.zzi = str;
    }

    public static zznc zzi() {
        return (zznc) zzb.zzp();
    }

    public final String zzJ() {
        return this.zzi;
    }

    public final String zzK() {
        return this.zzj;
    }

    public final boolean zzT() {
        return (this.zzd & 2) != 0;
    }

    public final int zzU() {
        int i5 = this.zzn;
        int i6 = i5 != 0 ? i5 != 1 ? i5 != 2 ? 0 : 4 : 3 : 2;
        if (i6 == 0) {
            return 1;
        }
        return i6;
    }

    @Deprecated
    public final long zzf() {
        return this.zzl;
    }

    public final zzmr zzg() {
        zzmr zzmrVar = this.zzo;
        return zzmrVar == null ? zzmr.zzj() : zzmrVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.recaptcha.internal.zzit
    public final Object zzh(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 != 0) {
            if (i6 != 2) {
                if (i6 != 3) {
                    if (i6 != 4) {
                        if (i6 != 5) {
                            return null;
                        }
                        return zzb;
                    }
                    return new zznc(null);
                }
                return new zznf();
            }
            return zzit.zzA(zzb, "\u0000\u000e\u0001\u0001\u0001\u000f\u000e\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003\u0003\u0004\f\u0005ဉ\u0001\u0006ဉ\u0002\u0007Ȉ\bȈ\tȈ\nဉ\u0000\u000bဉ\u0003\rဉ\u0004\u000eȈ\u000f<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", "zzi", "zzl", "zzn", "zzo", "zzp", "zzq", "zzj", "zzk", "zzm", "zzr", "zzs", "zzh", zzml.class});
        }
        return (byte) 1;
    }

    public final zzne zzj() {
        zzne zzneVar;
        int i5 = this.zzg;
        zzne zzneVar2 = zzne.UNKNOWN;
        switch (i5) {
            case 0:
                zzneVar = zzne.UNKNOWN;
                break;
            case 1:
                zzneVar = zzne.INIT_NATIVE;
                break;
            case 2:
                zzneVar = zzne.INIT_NETWORK;
                break;
            case 3:
                zzneVar = zzne.INIT_JS;
                break;
            case 4:
                zzneVar = zzne.INIT_TOTAL;
                break;
            case 5:
                zzneVar = zzne.EXECUTE_NATIVE;
                break;
            case 6:
                zzneVar = zzne.EXECUTE_JS;
                break;
            case 7:
                zzneVar = zzne.EXECUTE_TOTAL;
                break;
            case 8:
                zzneVar = zzne.CHALLENGE_ACCOUNT_NATIVE;
                break;
            case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                zzneVar = zzne.CHALLENGE_ACCOUNT_JS;
                break;
            case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                zzneVar = zzne.CHALLENGE_ACCOUNT_TOTAL;
                break;
            case 11:
                zzneVar = zzne.VERIFY_PIN_NATIVE;
                break;
            case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                zzneVar = zzne.VERIFY_PIN_JS;
                break;
            case 13:
                zzneVar = zzne.VERIFY_PIN_TOTAL;
                break;
            case 14:
                zzneVar = zzne.RUN_PROGRAM;
                break;
            case 15:
                zzneVar = zzne.FETCH_ALLOWLIST;
                break;
            case 16:
                zzneVar = zzne.JS_LOAD;
                break;
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                zzneVar = zzne.WEB_VIEW_RELOAD_JS;
                break;
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                zzneVar = zzne.INIT_NETWORK_MRI_ACTION;
                break;
            case 19:
                zzneVar = zzne.INIT_DOWNLOAD_JS;
                break;
            case 20:
                zzneVar = zzne.VALIDATE_INPUT;
                break;
            case 21:
                zzneVar = zzne.DOWNLOAD_JS;
                break;
            case 22:
                zzneVar = zzne.SAVE_CACHE_JS;
                break;
            case 23:
                zzneVar = zzne.LOAD_CACHE_JS;
                break;
            case 24:
                zzneVar = zzne.LOAD_WEBVIEW;
                break;
            case 25:
                zzneVar = zzne.COLLECT_SIGNALS;
                break;
            case 26:
                zzneVar = zzne.FETCH_TOKEN;
                break;
            case 27:
                zzneVar = zzne.POST_EXECUTE;
                break;
            default:
                zzneVar = null;
                break;
        }
        return zzneVar == null ? zzne.UNRECOGNIZED : zzneVar;
    }
}
