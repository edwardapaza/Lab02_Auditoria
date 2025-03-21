package com.google.android.recaptcha.internal;

import i2.a0;
import i2.d0;
/* loaded from: classes.dex */
public final class zzph extends zzit implements zzkf {
    private static final zzph zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private zzot zzi;
    private int zzj;
    private zzoq zzk;

    static {
        zzph zzphVar = new zzph();
        zzb = zzphVar;
        zzit.zzD(zzph.class, zzphVar);
    }

    private zzph() {
    }

    public static /* synthetic */ void zzH(zzph zzphVar, int i5) {
        if (i5 == 1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        zzphVar.zze = i5 - 2;
    }

    public static /* synthetic */ void zzI(zzph zzphVar, int i5) {
        if (i5 == 1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        zzphVar.zzg = i5 - 2;
    }

    public static zzpg zzf() {
        return (zzpg) zzb.zzp();
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
                    return new zzpg(null);
                }
                return new zzph();
            }
            return zzit.zzA(zzb, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\f\u0002\u000b\u0003\f\u0004\f\u0005ဉ\u0000\u0006\u000b\u0007ဉ\u0001", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        return (byte) 1;
    }

    public final int zzj() {
        int i5;
        switch (this.zzg) {
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
            case 42:
                i5 = 44;
                break;
            case 43:
                i5 = 45;
                break;
            case 44:
                i5 = 46;
                break;
            case 45:
                i5 = 47;
                break;
            case 46:
                i5 = 48;
                break;
            case 47:
                i5 = 49;
                break;
            case 48:
                i5 = 50;
                break;
            case 49:
                i5 = 51;
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

    public final int zzk() {
        int i5;
        switch (this.zze) {
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
