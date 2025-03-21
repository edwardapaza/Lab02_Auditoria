package androidx.media;

import android.media.AudioManager;
import android.os.Build;
/* loaded from: classes.dex */
public final class AudioManagerCompat {
    public static final int AUDIOFOCUS_GAIN = 1;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE = 4;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
    private static final String TAG = "AudioManCompat";

    public static int requestAudioFocus(AudioManager audioManager, AudioFocusRequestCompat focusRequest) {
        if (audioManager == null) {
            throw new IllegalArgumentException("AudioManager must not be null");
        }
        if (focusRequest == null) {
            throw new IllegalArgumentException("AudioFocusRequestCompat must not be null");
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return audioManager.requestAudioFocus(focusRequest.getAudioFocusRequest());
        }
        return audioManager.requestAudioFocus(focusRequest.getOnAudioFocusChangeListener(), focusRequest.getAudioAttributesCompat().getLegacyStreamType(), focusRequest.getFocusGain());
    }

    public static int abandonAudioFocusRequest(AudioManager audioManager, AudioFocusRequestCompat focusRequest) {
        if (audioManager == null) {
            throw new IllegalArgumentException("AudioManager must not be null");
        }
        if (focusRequest == null) {
            throw new IllegalArgumentException("AudioFocusRequestCompat must not be null");
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return audioManager.abandonAudioFocusRequest(focusRequest.getAudioFocusRequest());
        }
        return audioManager.abandonAudioFocus(focusRequest.getOnAudioFocusChangeListener());
    }

    private AudioManagerCompat() {
    }
}
