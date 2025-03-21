package j1;

import com.google.android.gms.internal.p001firebaseauthapi.zzafv;
/* loaded from: classes.dex */
public final class z1 implements com.google.firebase.auth.d {

    /* renamed from: a  reason: collision with root package name */
    private final int f5513a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5514b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5515c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.firebase.auth.b f5516d;

    public z1(zzafv zzafvVar) {
        this.f5514b = zzafvVar.zzg() ? zzafvVar.zzc() : zzafvVar.zzb();
        this.f5515c = zzafvVar.zzb();
        com.google.firebase.auth.b bVar = null;
        if (!zzafvVar.zzh()) {
            this.f5513a = 3;
            this.f5516d = null;
            return;
        }
        String zzd = zzafvVar.zzd();
        zzd.hashCode();
        char c5 = 65535;
        int i5 = 5;
        switch (zzd.hashCode()) {
            case -1874510116:
                if (zzd.equals("REVERT_SECOND_FACTOR_ADDITION")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1452371317:
                if (zzd.equals("PASSWORD_RESET")) {
                    c5 = 1;
                    break;
                }
                break;
            case -1341836234:
                if (zzd.equals("VERIFY_EMAIL")) {
                    c5 = 2;
                    break;
                }
                break;
            case -1099157829:
                if (zzd.equals("VERIFY_AND_CHANGE_EMAIL")) {
                    c5 = 3;
                    break;
                }
                break;
            case 870738373:
                if (zzd.equals("EMAIL_SIGNIN")) {
                    c5 = 4;
                    break;
                }
                break;
            case 970484929:
                if (zzd.equals("RECOVER_EMAIL")) {
                    c5 = 5;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                i5 = 6;
                break;
            case 1:
                i5 = 0;
                break;
            case 2:
                i5 = 1;
                break;
            case 3:
                break;
            case 4:
                i5 = 4;
                break;
            case 5:
                i5 = 2;
                break;
            default:
                i5 = 3;
                break;
        }
        this.f5513a = i5;
        if (i5 == 4 || i5 == 3) {
            this.f5516d = null;
            return;
        }
        if (zzafvVar.zzf()) {
            bVar = new a2(zzafvVar.zzb(), n0.a(zzafvVar.zza()));
        } else if (zzafvVar.zzg()) {
            bVar = new y1(zzafvVar.zzc(), zzafvVar.zzb());
        } else if (zzafvVar.zze()) {
            bVar = new x1(zzafvVar.zzb());
        }
        this.f5516d = bVar;
    }

    @Override // com.google.firebase.auth.d
    public final int a() {
        return this.f5513a;
    }

    @Override // com.google.firebase.auth.d
    public final com.google.firebase.auth.b b() {
        return this.f5516d;
    }
}
