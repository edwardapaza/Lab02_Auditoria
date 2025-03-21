package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
/* loaded from: classes.dex */
public final class LatLng extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LatLng> CREATOR = new zzj();
    public final double latitude;
    public final double longitude;

    public LatLng(double latitude, double longitude) {
        if (longitude < -180.0d || longitude >= 180.0d) {
            this.longitude = ((((longitude - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
        } else {
            this.longitude = longitude;
        }
        this.latitude = Math.max(-90.0d, Math.min(90.0d, latitude));
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof LatLng) {
            LatLng latLng = (LatLng) o;
            return Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(latLng.latitude) && Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(latLng.longitude);
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        long j = doubleToLongBits ^ (doubleToLongBits >>> 32);
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return ((((int) j) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        return "lat/lng: (" + this.latitude + "," + this.longitude + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        double d = this.latitude;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(out);
        SafeParcelWriter.writeDouble(out, 2, d);
        SafeParcelWriter.writeDouble(out, 3, this.longitude);
        SafeParcelWriter.finishObjectHeader(out, beginObjectHeader);
    }
}
