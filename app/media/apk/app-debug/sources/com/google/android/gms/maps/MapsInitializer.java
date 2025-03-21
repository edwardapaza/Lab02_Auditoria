package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.zzcc;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;
/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
/* loaded from: classes.dex */
public final class MapsInitializer {
    private static final String zza = MapsInitializer.class.getSimpleName();
    private static boolean zzb = false;
    private static Renderer zzc = Renderer.LEGACY;

    /* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
    /* loaded from: classes.dex */
    public enum Renderer {
        LEGACY,
        LATEST
    }

    private MapsInitializer() {
    }

    public static synchronized int initialize(Context context) {
        int initialize;
        synchronized (MapsInitializer.class) {
            initialize = initialize(context, null, null);
        }
        return initialize;
    }

    public static synchronized int initialize(Context context, Renderer preferredRenderer, OnMapsSdkInitializedCallback callback) {
        synchronized (MapsInitializer.class) {
            Preconditions.checkNotNull(context, "Context is null");
            Log.d(zza, "preferredRenderer: ".concat(String.valueOf(String.valueOf(preferredRenderer))));
            if (zzb) {
                if (callback != null) {
                    callback.onMapsSdkInitialized(zzc);
                }
                return 0;
            }
            try {
                com.google.android.gms.maps.internal.zzf zza2 = zzcc.zza(context, preferredRenderer);
                try {
                    CameraUpdateFactory.zza(zza2.zze());
                    BitmapDescriptorFactory.zza(zza2.zzj());
                    int i = 1;
                    zzb = true;
                    if (preferredRenderer != null) {
                        switch (preferredRenderer.ordinal()) {
                            case 0:
                                break;
                            case 1:
                                i = 2;
                                break;
                            default:
                                i = 0;
                                break;
                        }
                    } else {
                        i = 0;
                    }
                    try {
                        if (zza2.zzd() == 2) {
                            zzc = Renderer.LATEST;
                        }
                        zza2.zzl(ObjectWrapper.wrap(context), i);
                    } catch (RemoteException e) {
                        Log.e(zza, "Failed to retrieve renderer type or log initialization.", e);
                    }
                    Log.d(zza, "loadedRenderer: ".concat(String.valueOf(String.valueOf(zzc))));
                    if (callback != null) {
                        callback.onMapsSdkInitialized(zzc);
                    }
                    return 0;
                } catch (RemoteException e2) {
                    throw new RuntimeRemoteException(e2);
                }
            } catch (GooglePlayServicesNotAvailableException e3) {
                return e3.errorCode;
            }
        }
    }
}
