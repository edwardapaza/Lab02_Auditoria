package androidx.media;

import android.media.VolumeProvider;
import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public abstract class VolumeProviderCompat {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;
    private Callback mCallback;
    private final int mControlType;
    private int mCurrentVolume;
    private final int mMaxVolume;
    private VolumeProvider mVolumeProviderFwk;

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public abstract void onVolumeChanged(VolumeProviderCompat volumeProviderCompat);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ControlType {
    }

    public VolumeProviderCompat(int volumeControl, int maxVolume, int currentVolume) {
        this.mControlType = volumeControl;
        this.mMaxVolume = maxVolume;
        this.mCurrentVolume = currentVolume;
    }

    public final int getCurrentVolume() {
        return this.mCurrentVolume;
    }

    public final int getVolumeControl() {
        return this.mControlType;
    }

    public final int getMaxVolume() {
        return this.mMaxVolume;
    }

    public final void setCurrentVolume(int currentVolume) {
        this.mCurrentVolume = currentVolume;
        if (Build.VERSION.SDK_INT >= 21) {
            VolumeProvider volumeProviderFwk = (VolumeProvider) getVolumeProvider();
            volumeProviderFwk.setCurrentVolume(currentVolume);
        }
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onVolumeChanged(this);
        }
    }

    public void onSetVolumeTo(int volume) {
    }

    public void onAdjustVolume(int direction) {
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public Object getVolumeProvider() {
        if (this.mVolumeProviderFwk == null && Build.VERSION.SDK_INT >= 21) {
            this.mVolumeProviderFwk = new VolumeProvider(this.mControlType, this.mMaxVolume, this.mCurrentVolume) { // from class: androidx.media.VolumeProviderCompat.1
                @Override // android.media.VolumeProvider
                public void onSetVolumeTo(int volume) {
                    VolumeProviderCompat.this.onSetVolumeTo(volume);
                }

                @Override // android.media.VolumeProvider
                public void onAdjustVolume(int direction) {
                    VolumeProviderCompat.this.onAdjustVolume(direction);
                }
            };
        }
        return this.mVolumeProviderFwk;
    }
}
