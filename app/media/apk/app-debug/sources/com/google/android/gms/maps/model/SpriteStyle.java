package com.google.android.gms.maps.model;

import com.google.android.gms.maps.model.StampStyle;
/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
/* loaded from: classes.dex */
public class SpriteStyle extends StampStyle {

    /* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
    /* loaded from: classes.dex */
    public static final class Builder extends StampStyle.Builder<Builder> {
        private Builder() {
        }

        /* synthetic */ Builder(zzs zzsVar) {
        }

        public SpriteStyle build() {
            return new SpriteStyle(this.zza);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.android.gms.maps.model.StampStyle.Builder
        protected Builder self() {
            return this;
        }

        @Override // com.google.android.gms.maps.model.StampStyle.Builder
        protected final /* bridge */ /* synthetic */ Builder self() {
            return this;
        }
    }

    public SpriteStyle(BitmapDescriptor stamp) {
        super(stamp);
    }

    public static Builder newBuilder(BitmapDescriptor stamp) {
        return new Builder(null).stamp(stamp);
    }
}
