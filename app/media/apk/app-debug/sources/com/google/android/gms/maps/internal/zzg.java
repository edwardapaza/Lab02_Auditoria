package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
/* loaded from: classes.dex */
public final class zzg extends com.google.android.gms.internal.maps.zza implements IGoogleMapDelegate {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IGoogleMapDelegate");
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final com.google.android.gms.internal.maps.zzl addCircle(CircleOptions circleOptions) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(zza, circleOptions);
        Parcel zzJ = zzJ(35, zza);
        com.google.android.gms.internal.maps.zzl zzb = com.google.android.gms.internal.maps.zzk.zzb(zzJ.readStrongBinder());
        zzJ.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final com.google.android.gms.internal.maps.zzr addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(zza, groundOverlayOptions);
        Parcel zzJ = zzJ(12, zza);
        com.google.android.gms.internal.maps.zzr zzb = com.google.android.gms.internal.maps.zzq.zzb(zzJ.readStrongBinder());
        zzJ.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final com.google.android.gms.internal.maps.zzad addMarker(MarkerOptions markerOptions) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(zza, markerOptions);
        Parcel zzJ = zzJ(11, zza);
        com.google.android.gms.internal.maps.zzad zzb = com.google.android.gms.internal.maps.zzac.zzb(zzJ.readStrongBinder());
        zzJ.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void addOnMapCapabilitiesChangedListener(zzal zzalVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzalVar);
        zzc(110, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final com.google.android.gms.internal.maps.zzag addPolygon(PolygonOptions polygonOptions) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(zza, polygonOptions);
        Parcel zzJ = zzJ(10, zza);
        com.google.android.gms.internal.maps.zzag zzb = com.google.android.gms.internal.maps.zzaf.zzb(zzJ.readStrongBinder());
        zzJ.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final com.google.android.gms.internal.maps.zzaj addPolyline(PolylineOptions polylineOptions) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(zza, polylineOptions);
        Parcel zzJ = zzJ(9, zza);
        com.google.android.gms.internal.maps.zzaj zzb = com.google.android.gms.internal.maps.zzai.zzb(zzJ.readStrongBinder());
        zzJ.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final com.google.android.gms.internal.maps.zzam addTileOverlay(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(zza, tileOverlayOptions);
        Parcel zzJ = zzJ(13, zza);
        com.google.android.gms.internal.maps.zzam zzb = com.google.android.gms.internal.maps.zzal.zzb(zzJ.readStrongBinder());
        zzJ.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void animateCamera(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, iObjectWrapper);
        zzc(5, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void animateCameraWithCallback(IObjectWrapper iObjectWrapper, zzd zzdVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, iObjectWrapper);
        com.google.android.gms.internal.maps.zzc.zze(zza, zzdVar);
        zzc(6, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void animateCameraWithDurationAndCallback(IObjectWrapper iObjectWrapper, int i, zzd zzdVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, iObjectWrapper);
        zza.writeInt(i);
        com.google.android.gms.internal.maps.zzc.zze(zza, zzdVar);
        zzc(7, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void clear() throws RemoteException {
        zzc(14, zza());
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final CameraPosition getCameraPosition() throws RemoteException {
        Parcel zzJ = zzJ(1, zza());
        CameraPosition cameraPosition = (CameraPosition) com.google.android.gms.internal.maps.zzc.zza(zzJ, CameraPosition.CREATOR);
        zzJ.recycle();
        return cameraPosition;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final com.google.android.gms.internal.maps.zzo getFeatureLayer(com.google.android.gms.maps.model.zzd zzdVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(zza, zzdVar);
        Parcel zzJ = zzJ(112, zza);
        com.google.android.gms.internal.maps.zzo zzb = com.google.android.gms.internal.maps.zzn.zzb(zzJ.readStrongBinder());
        zzJ.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final com.google.android.gms.internal.maps.zzu getFocusedBuilding() throws RemoteException {
        Parcel zzJ = zzJ(44, zza());
        com.google.android.gms.internal.maps.zzu zzb = com.google.android.gms.internal.maps.zzt.zzb(zzJ.readStrongBinder());
        zzJ.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void getMapAsync(zzat zzatVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzatVar);
        zzc(53, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final com.google.android.gms.internal.maps.zzaa getMapCapabilities() throws RemoteException {
        Parcel zzJ = zzJ(109, zza());
        com.google.android.gms.internal.maps.zzaa zzb = com.google.android.gms.internal.maps.zzz.zzb(zzJ.readStrongBinder());
        zzJ.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final int getMapType() throws RemoteException {
        Parcel zzJ = zzJ(15, zza());
        int readInt = zzJ.readInt();
        zzJ.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final float getMaxZoomLevel() throws RemoteException {
        Parcel zzJ = zzJ(2, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final float getMinZoomLevel() throws RemoteException {
        Parcel zzJ = zzJ(3, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final Location getMyLocation() throws RemoteException {
        Parcel zzJ = zzJ(23, zza());
        Location location = (Location) com.google.android.gms.internal.maps.zzc.zza(zzJ, Location.CREATOR);
        zzJ.recycle();
        return location;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final IProjectionDelegate getProjection() throws RemoteException {
        IProjectionDelegate zzbuVar;
        Parcel zzJ = zzJ(26, zza());
        IBinder readStrongBinder = zzJ.readStrongBinder();
        if (readStrongBinder == null) {
            zzbuVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            zzbuVar = queryLocalInterface instanceof IProjectionDelegate ? (IProjectionDelegate) queryLocalInterface : new zzbu(readStrongBinder);
        }
        zzJ.recycle();
        return zzbuVar;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final IUiSettingsDelegate getUiSettings() throws RemoteException {
        IUiSettingsDelegate zzcaVar;
        Parcel zzJ = zzJ(25, zza());
        IBinder readStrongBinder = zzJ.readStrongBinder();
        if (readStrongBinder == null) {
            zzcaVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            zzcaVar = queryLocalInterface instanceof IUiSettingsDelegate ? (IUiSettingsDelegate) queryLocalInterface : new zzca(readStrongBinder);
        }
        zzJ.recycle();
        return zzcaVar;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final boolean isBuildingsEnabled() throws RemoteException {
        Parcel zzJ = zzJ(40, zza());
        boolean zzf = com.google.android.gms.internal.maps.zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final boolean isIndoorEnabled() throws RemoteException {
        Parcel zzJ = zzJ(19, zza());
        boolean zzf = com.google.android.gms.internal.maps.zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final boolean isMyLocationEnabled() throws RemoteException {
        Parcel zzJ = zzJ(21, zza());
        boolean zzf = com.google.android.gms.internal.maps.zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final boolean isTrafficEnabled() throws RemoteException {
        Parcel zzJ = zzJ(17, zza());
        boolean zzf = com.google.android.gms.internal.maps.zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void moveCamera(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, iObjectWrapper);
        zzc(4, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void onCreate(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(zza, bundle);
        zzc(54, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void onDestroy() throws RemoteException {
        zzc(57, zza());
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void onEnterAmbient(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(zza, bundle);
        zzc(81, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void onExitAmbient() throws RemoteException {
        zzc(82, zza());
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void onLowMemory() throws RemoteException {
        zzc(58, zza());
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void onPause() throws RemoteException {
        zzc(56, zza());
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void onResume() throws RemoteException {
        zzc(55, zza());
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(zza, bundle);
        Parcel zzJ = zzJ(60, zza);
        if (zzJ.readInt() != 0) {
            bundle.readFromParcel(zzJ);
        }
        zzJ.recycle();
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void onStart() throws RemoteException {
        zzc(101, zza());
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void onStop() throws RemoteException {
        zzc(102, zza());
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void removeOnMapCapabilitiesChangedListener(zzal zzalVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzalVar);
        zzc(111, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void resetMinMaxZoomPreference() throws RemoteException {
        zzc(94, zza());
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setBuildingsEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = com.google.android.gms.internal.maps.zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(41, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setContentDescription(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc(61, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final boolean setIndoorEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = com.google.android.gms.internal.maps.zzc.zza;
        zza.writeInt(z ? 1 : 0);
        Parcel zzJ = zzJ(20, zza);
        boolean zzf = com.google.android.gms.internal.maps.zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setInfoWindowAdapter(zzi zziVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zziVar);
        zzc(33, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setLatLngBoundsForCameraTarget(LatLngBounds latLngBounds) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(zza, latLngBounds);
        zzc(95, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setLocationSource(ILocationSourceDelegate iLocationSourceDelegate) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, iLocationSourceDelegate);
        zzc(24, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final boolean setMapStyle(MapStyleOptions mapStyleOptions) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(zza, mapStyleOptions);
        Parcel zzJ = zzJ(91, zza);
        boolean zzf = com.google.android.gms.internal.maps.zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setMapType(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzc(16, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setMaxZoomPreference(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(93, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setMinZoomPreference(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(92, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setMyLocationEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = com.google.android.gms.internal.maps.zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(22, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setOnCameraChangeListener(zzn zznVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zznVar);
        zzc(27, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setOnCameraIdleListener(zzp zzpVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzpVar);
        zzc(99, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setOnCameraMoveCanceledListener(zzr zzrVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzrVar);
        zzc(98, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setOnCameraMoveListener(zzt zztVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zztVar);
        zzc(97, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setOnCameraMoveStartedListener(zzv zzvVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzvVar);
        zzc(96, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setOnCircleClickListener(zzx zzxVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzxVar);
        zzc(89, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setOnGroundOverlayClickListener(zzz zzzVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzzVar);
        zzc(83, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setOnIndoorStateChangeListener(zzab zzabVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzabVar);
        zzc(45, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setOnInfoWindowClickListener(zzad zzadVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzadVar);
        zzc(32, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setOnInfoWindowCloseListener(zzaf zzafVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzafVar);
        zzc(86, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setOnInfoWindowLongClickListener(zzah zzahVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzahVar);
        zzc(84, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setOnMapClickListener(zzan zzanVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzanVar);
        zzc(28, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setOnMapLoadedCallback(zzap zzapVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzapVar);
        zzc(42, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setOnMapLongClickListener(zzar zzarVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzarVar);
        zzc(29, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setOnMarkerClickListener(zzav zzavVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzavVar);
        zzc(30, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setOnMarkerDragListener(zzax zzaxVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzaxVar);
        zzc(31, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setOnMyLocationButtonClickListener(zzaz zzazVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzazVar);
        zzc(37, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setOnMyLocationChangeListener(zzbb zzbbVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzbbVar);
        zzc(36, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setOnMyLocationClickListener(zzbd zzbdVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzbdVar);
        zzc(107, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setOnPoiClickListener(zzbf zzbfVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzbfVar);
        zzc(80, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setOnPolygonClickListener(zzbh zzbhVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzbhVar);
        zzc(85, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setOnPolylineClickListener(zzbj zzbjVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzbjVar);
        zzc(87, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setPadding(int i, int i2, int i3, int i4) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeInt(i2);
        zza.writeInt(i3);
        zza.writeInt(i4);
        zzc(39, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setTrafficEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = com.google.android.gms.internal.maps.zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(18, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setWatermarkEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = com.google.android.gms.internal.maps.zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(51, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void snapshot(zzbw zzbwVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzbwVar);
        com.google.android.gms.internal.maps.zzc.zze(zza, iObjectWrapper);
        zzc(38, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void snapshotForTest(zzbw zzbwVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzbwVar);
        zzc(71, zza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void stopAnimation() throws RemoteException {
        zzc(8, zza());
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final boolean useViewLifecycleWhenInFragment() throws RemoteException {
        Parcel zzJ = zzJ(59, zza());
        boolean zzf = com.google.android.gms.internal.maps.zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }
}
