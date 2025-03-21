package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.location.zzek;
/* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* loaded from: classes.dex */
public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    /* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
    /* loaded from: classes.dex */
    public static final class Builder {
        private double zze;
        private double zzf;
        private float zzg;
        private String zza = null;
        private int zzb = 3;
        private long zzc = -1;
        private short zzd = -1;
        private int zzh = 0;
        private int zzi = -1;

        public Geofence build() {
            if (this.zza != null) {
                int i = this.zzb;
                if (i != 0) {
                    if ((i & 4) == 0 || this.zzi >= 0) {
                        if (this.zzc != Long.MIN_VALUE) {
                            if (this.zzd != -1) {
                                if (this.zzh >= 0) {
                                    return new zzek(this.zza, this.zzb, (short) 1, this.zze, this.zzf, this.zzg, this.zzc, this.zzh, this.zzi);
                                }
                                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
                            }
                            throw new IllegalArgumentException("Geofence region not set.");
                        }
                        throw new IllegalArgumentException("Expiration not set.");
                    }
                    throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELL.");
                }
                throw new IllegalArgumentException("Transitions types not set.");
            }
            throw new IllegalArgumentException("Request ID not set.");
        }

        public Builder setCircularRegion(double latitude, double longitude, float radius) {
            boolean z = latitude >= -90.0d && latitude <= 90.0d;
            StringBuilder sb = new StringBuilder(String.valueOf(latitude).length() + 18);
            sb.append("Invalid latitude: ");
            sb.append(latitude);
            Preconditions.checkArgument(z, sb.toString());
            boolean z2 = longitude >= -180.0d && longitude <= 180.0d;
            StringBuilder sb2 = new StringBuilder(String.valueOf(longitude).length() + 19);
            sb2.append("Invalid longitude: ");
            sb2.append(longitude);
            Preconditions.checkArgument(z2, sb2.toString());
            boolean z3 = radius > 0.0f;
            StringBuilder sb3 = new StringBuilder(String.valueOf(radius).length() + 16);
            sb3.append("Invalid radius: ");
            sb3.append(radius);
            Preconditions.checkArgument(z3, sb3.toString());
            this.zzd = (short) 1;
            this.zze = latitude;
            this.zzf = longitude;
            this.zzg = radius;
            return this;
        }

        public Builder setExpirationDuration(long durationMillis) {
            if (durationMillis < 0) {
                this.zzc = -1L;
            } else {
                this.zzc = DefaultClock.getInstance().elapsedRealtime() + durationMillis;
            }
            return this;
        }

        public Builder setLoiteringDelay(int i) {
            this.zzi = i;
            return this;
        }

        public Builder setNotificationResponsiveness(int i) {
            this.zzh = i;
            return this;
        }

        public Builder setRequestId(String requestId) {
            this.zza = (String) Preconditions.checkNotNull(requestId, "Request ID can't be set to null");
            return this;
        }

        public Builder setTransitionTypes(int i) {
            this.zzb = i;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
    /* loaded from: classes.dex */
    public @interface GeofenceTransition {
    }

    /* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
    /* loaded from: classes.dex */
    public @interface TransitionTypes {
    }

    long getExpirationTime();

    double getLatitude();

    int getLoiteringDelay();

    double getLongitude();

    int getNotificationResponsiveness();

    float getRadius();

    String getRequestId();

    int getTransitionTypes();
}
