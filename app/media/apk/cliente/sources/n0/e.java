package n0;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.internal.g;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.internal.base.zad;
/* loaded from: classes.dex */
public final class e extends g<a> {

    /* renamed from: a  reason: collision with root package name */
    private final x f6316a;

    public e(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, x xVar, com.google.android.gms.common.api.internal.e eVar, m mVar) {
        super(context, looper, 270, dVar, eVar, mVar);
        this.f6316a = xVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.c
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return queryLocalInterface instanceof a ? (a) queryLocalInterface : new a(iBinder);
    }

    @Override // com.google.android.gms.common.internal.c
    public final l0.c[] getApiFeatures() {
        return zad.zab;
    }

    @Override // com.google.android.gms.common.internal.c
    protected final Bundle getGetServiceRequestExtraArgs() {
        return this.f6316a.d();
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public final int getMinApkVersion() {
        return 203400000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.c
    public final String getServiceDescriptor() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String getStartServiceAction() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // com.google.android.gms.common.internal.c
    protected final boolean getUseDynamicLookup() {
        return true;
    }
}
