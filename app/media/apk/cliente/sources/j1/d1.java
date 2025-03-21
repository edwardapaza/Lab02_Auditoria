package j1;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.internal.p001firebaseauthapi.zzafm;
/* loaded from: classes.dex */
public final class d1 {

    /* renamed from: a  reason: collision with root package name */
    private volatile int f5367a;

    /* renamed from: b  reason: collision with root package name */
    private final t f5368b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f5369c;

    private d1(Context context, t tVar) {
        this.f5369c = false;
        this.f5367a = 0;
        this.f5368b = tVar;
        com.google.android.gms.common.api.internal.c.c((Application) context.getApplicationContext());
        com.google.android.gms.common.api.internal.c.b().a(new c1(this));
    }

    public d1(f1.f fVar) {
        this(fVar.m(), new t(fVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f() {
        return this.f5367a > 0 && !this.f5369c;
    }

    public final void b() {
        this.f5368b.b();
    }

    public final void c(int i5) {
        if (i5 > 0 && this.f5367a == 0) {
            this.f5367a = i5;
            if (f()) {
                this.f5368b.c();
            }
        } else if (i5 == 0 && this.f5367a != 0) {
            this.f5368b.b();
        }
        this.f5367a = i5;
    }

    public final void d(zzafm zzafmVar) {
        if (zzafmVar == null) {
            return;
        }
        long zza = zzafmVar.zza();
        if (zza <= 0) {
            zza = 3600;
        }
        t tVar = this.f5368b;
        tVar.f5476b = zzafmVar.zzb() + (zza * 1000);
        tVar.f5477c = -1L;
        if (f()) {
            this.f5368b.c();
        }
    }
}
