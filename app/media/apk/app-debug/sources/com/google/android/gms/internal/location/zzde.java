package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.tasks.TaskCompletionSource;
/* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* loaded from: classes.dex */
final class zzde extends zzaa {
    final /* synthetic */ TaskCompletionSource zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzde(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.location.zzab
    public final void zzb(LocationSettingsResult locationSettingsResult) {
        TaskUtil.setResultOrApiException(locationSettingsResult.getStatus(), new LocationSettingsResponse(locationSettingsResult), this.zza);
    }
}
