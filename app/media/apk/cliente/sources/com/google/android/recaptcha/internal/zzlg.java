package com.google.android.recaptcha.internal;

import i2.a0;
import i2.d0;
/* loaded from: classes.dex */
final class zzlg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzgw zzgwVar) {
        String str;
        StringBuilder sb = new StringBuilder(zzgwVar.zzd());
        for (int i5 = 0; i5 < zzgwVar.zzd(); i5++) {
            int zza = zzgwVar.zza(i5);
            if (zza == 34) {
                str = "\\\"";
            } else if (zza == 39) {
                str = "\\'";
            } else if (zza != 92) {
                switch (zza) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                        str = "\\t";
                        break;
                    case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (zza < 32 || zza > 126) {
                            sb.append('\\');
                            sb.append((char) (((zza >>> 6) & 3) + 48));
                            sb.append((char) (((zza >>> 3) & 7) + 48));
                            zza = (zza & 7) + 48;
                        }
                        sb.append((char) zza);
                        continue;
                        break;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
