package com.google.android.recaptcha.internal;

import i2.a0;
import i2.d0;
import java.util.List;
/* loaded from: classes.dex */
public final class zzpr extends zzit implements zzkf {
    public static final zzir zzb;
    public static final zzir zzd;
    private static final zzpr zze;
    private int zzf;
    private int zzg;
    private zzjb zzh = zzit.zzx();

    static {
        zzpr zzprVar = new zzpr();
        zze = zzprVar;
        zzit.zzD(zzpr.class, zzprVar);
        zzhl zzg = zzhl.zzg();
        zzmb zzmbVar = zzmb.zzi;
        zzb = zzit.zzq(zzg, "", null, null, 490775251, zzmbVar, String.class);
        zzd = zzit.zzq(zzhl.zzg(), "", null, null, 490775252, zzmbVar, String.class);
    }

    private zzpr() {
    }

    public final int zzf() {
        return this.zzf;
    }

    public final int zzg() {
        return this.zzg;
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
                        return zze;
                    }
                    return new zzpo(null);
                }
                return new zzpr();
            }
            return zzit.zzA(zze, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\f\u0002\u000b\u0003\u001b", new Object[]{"zzf", "zzg", "zzh", zzpq.class});
        }
        return (byte) 1;
    }

    public final List zzj() {
        return this.zzh;
    }

    public final int zzk() {
        int i5;
        switch (this.zzf) {
            case 0:
                i5 = 2;
                break;
            case 1:
                i5 = 3;
                break;
            case 2:
                i5 = 4;
                break;
            case 3:
                i5 = 5;
                break;
            case 4:
                i5 = 6;
                break;
            case 5:
                i5 = 7;
                break;
            case 6:
                i5 = 8;
                break;
            case 7:
                i5 = 9;
                break;
            case 8:
                i5 = 10;
                break;
            case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                i5 = 11;
                break;
            case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                i5 = 12;
                break;
            case 11:
                i5 = 13;
                break;
            case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                i5 = 14;
                break;
            case 13:
                i5 = 15;
                break;
            case 14:
                i5 = 16;
                break;
            case 15:
                i5 = 17;
                break;
            case 16:
                i5 = 18;
                break;
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                i5 = 19;
                break;
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                i5 = 20;
                break;
            case 19:
                i5 = 21;
                break;
            case 20:
                i5 = 22;
                break;
            case 21:
                i5 = 23;
                break;
            case 22:
                i5 = 24;
                break;
            case 23:
                i5 = 25;
                break;
            case 24:
                i5 = 26;
                break;
            case 25:
                i5 = 27;
                break;
            case 26:
                i5 = 28;
                break;
            case 27:
                i5 = 29;
                break;
            case 28:
                i5 = 30;
                break;
            case 29:
                i5 = 31;
                break;
            case 30:
                i5 = 32;
                break;
            case 31:
                i5 = 33;
                break;
            case 32:
                i5 = 34;
                break;
            case 33:
                i5 = 35;
                break;
            case 34:
                i5 = 36;
                break;
            case 35:
                i5 = 37;
                break;
            case 36:
                i5 = 38;
                break;
            case 37:
                i5 = 39;
                break;
            case 38:
                i5 = 40;
                break;
            case 39:
                i5 = 41;
                break;
            case 40:
                i5 = 42;
                break;
            case 41:
                i5 = 43;
                break;
            default:
                i5 = 0;
                break;
        }
        if (i5 == 0) {
            return 1;
        }
        return i5;
    }
}
