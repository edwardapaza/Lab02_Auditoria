package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.zzcc;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
/* loaded from: classes.dex */
final class zzai extends DeferredLifecycleHelper {
    protected OnDelegateCreatedListener zza;
    private final ViewGroup zzb;
    private final Context zzc;
    private final GoogleMapOptions zzd;
    private final List zze = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzai(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
        this.zzb = viewGroup;
        this.zzc = context;
        this.zzd = googleMapOptions;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper
    protected final void createDelegate(OnDelegateCreatedListener onDelegateCreatedListener) {
        this.zza = onDelegateCreatedListener;
        zzb();
    }

    public final void zza(OnMapReadyCallback onMapReadyCallback) {
        if (getDelegate() != null) {
            ((zzah) getDelegate()).getMapAsync(onMapReadyCallback);
        } else {
            this.zze.add(onMapReadyCallback);
        }
    }

    public final void zzb() {
        if (this.zza != null && getDelegate() == null) {
            try {
                MapsInitializer.initialize(this.zzc);
                IMapViewDelegate zzg = zzcc.zza(this.zzc, null).zzg(ObjectWrapper.wrap(this.zzc), this.zzd);
                if (zzg == null) {
                    return;
                }
                this.zza.onDelegateCreated(new zzah(this.zzb, zzg));
                for (OnMapReadyCallback onMapReadyCallback : this.zze) {
                    ((zzah) getDelegate()).getMapAsync(onMapReadyCallback);
                }
                this.zze.clear();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            } catch (GooglePlayServicesNotAvailableException e2) {
            }
        }
    }
}
