package com.google.android.gms.internal.p001firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.q;
import com.google.firebase.auth.o0;
import o0.a;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacf  reason: invalid package */
/* loaded from: classes.dex */
public class zzacf {
    private final zzacc zza;
    private final a zzb;

    public zzacf(zzacc zzaccVar, a aVar) {
        this.zza = (zzacc) q.k(zzaccVar);
        this.zzb = (a) q.k(aVar);
    }

    public zzacf(zzacf zzacfVar) {
        this(zzacfVar.zza, zzacfVar.zzb);
    }

    public final void zza() {
        try {
            this.zza.zza();
        } catch (RemoteException e5) {
            this.zzb.b("RemoteException when sending delete account response.", e5, new Object[0]);
        }
    }

    public void zza(Status status) {
        try {
            this.zza.zza(status);
        } catch (RemoteException e5) {
            this.zzb.b("RemoteException when sending failure result.", e5, new Object[0]);
        }
    }

    public final void zza(Status status, o0 o0Var) {
        try {
            this.zza.zza(status, o0Var);
        } catch (RemoteException e5) {
            this.zzb.b("RemoteException when sending failure result.", e5, new Object[0]);
        }
    }

    public final void zza(zzaem zzaemVar) {
        try {
            this.zza.zza(zzaemVar);
        } catch (RemoteException e5) {
            this.zzb.b("RemoteException when sending create auth uri response.", e5, new Object[0]);
        }
    }

    public final void zza(zzafi zzafiVar) {
        try {
            this.zza.zza(zzafiVar);
        } catch (RemoteException e5) {
            this.zzb.b("RemoteException when sending Play Integrity Producer project response.", e5, new Object[0]);
        }
    }

    public final void zza(zzafj zzafjVar) {
        try {
            this.zza.zza(zzafjVar);
        } catch (RemoteException e5) {
            this.zzb.b("RemoteException when sending get recaptcha config response.", e5, new Object[0]);
        }
    }

    public final void zza(zzafm zzafmVar) {
        try {
            this.zza.zza(zzafmVar);
        } catch (RemoteException e5) {
            this.zzb.b("RemoteException when sending token result.", e5, new Object[0]);
        }
    }

    public final void zza(zzafm zzafmVar, zzafb zzafbVar) {
        try {
            this.zza.zza(zzafmVar, zzafbVar);
        } catch (RemoteException e5) {
            this.zzb.b("RemoteException when sending get token and account info user response", e5, new Object[0]);
        }
    }

    public final void zza(zzafv zzafvVar) {
        try {
            this.zza.zza(zzafvVar);
        } catch (RemoteException e5) {
            this.zzb.b("RemoteException when sending password reset response.", e5, new Object[0]);
        }
    }

    public final void zza(zzaga zzagaVar) {
        try {
            this.zza.zza(zzagaVar);
        } catch (RemoteException e5) {
            this.zzb.b("RemoteException when sending revoke token response.", e5, new Object[0]);
        }
    }

    public final void zza(zzagi zzagiVar) {
        try {
            this.zza.zza(zzagiVar);
        } catch (RemoteException e5) {
            this.zzb.b("RemoteException when sending start mfa enrollment response.", e5, new Object[0]);
        }
    }

    public final void zza(zzyi zzyiVar) {
        try {
            this.zza.zza(zzyiVar);
        } catch (RemoteException e5) {
            this.zzb.b("RemoteException when sending failure result for mfa", e5, new Object[0]);
        }
    }

    public final void zza(zzyj zzyjVar) {
        try {
            this.zza.zza(zzyjVar);
        } catch (RemoteException e5) {
            this.zzb.b("RemoteException when sending failure result with credential", e5, new Object[0]);
        }
    }

    public final void zza(o0 o0Var) {
        try {
            this.zza.zza(o0Var);
        } catch (RemoteException e5) {
            this.zzb.b("RemoteException when sending verification completed response.", e5, new Object[0]);
        }
    }

    public final void zza(String str) {
        try {
            this.zza.zza(str);
        } catch (RemoteException e5) {
            this.zzb.b("RemoteException when sending auto retrieval timeout response.", e5, new Object[0]);
        }
    }

    public final void zzb() {
        try {
            this.zza.zzb();
        } catch (RemoteException e5) {
            this.zzb.b("RemoteException when sending email verification response.", e5, new Object[0]);
        }
    }

    public void zzb(String str) {
        try {
            this.zza.zzb(str);
        } catch (RemoteException e5) {
            this.zzb.b("RemoteException when sending send verification code response.", e5, new Object[0]);
        }
    }

    public final void zzc() {
        try {
            this.zza.zzc();
        } catch (RemoteException e5) {
            this.zzb.b("RemoteException when setting FirebaseUI Version", e5, new Object[0]);
        }
    }

    public final void zzc(String str) {
        try {
            this.zza.zzc(str);
        } catch (RemoteException e5) {
            this.zzb.b("RemoteException when sending set account info response.", e5, new Object[0]);
        }
    }
}
