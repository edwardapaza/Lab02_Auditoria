package androidx.media;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.util.ObjectsCompat;
import androidx.media.AudioAttributesCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public class AudioFocusRequestCompat {
    static final AudioAttributesCompat FOCUS_DEFAULT_ATTR = new AudioAttributesCompat.Builder().setUsage(1).build();
    private final AudioAttributesCompat mAudioAttributesCompat;
    private final Handler mFocusChangeHandler;
    private final int mFocusGain;
    private final Object mFrameworkAudioFocusRequest;
    private final AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener;
    private final boolean mPauseOnDuck;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FocusGainType {
    }

    AudioFocusRequestCompat(int focusGain, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler focusChangeHandler, AudioAttributesCompat audioFocusRequestCompat, boolean pauseOnDuck) {
        this.mFocusGain = focusGain;
        this.mFocusChangeHandler = focusChangeHandler;
        this.mAudioAttributesCompat = audioFocusRequestCompat;
        this.mPauseOnDuck = pauseOnDuck;
        if (Build.VERSION.SDK_INT < 26 && focusChangeHandler.getLooper() != Looper.getMainLooper()) {
            this.mOnAudioFocusChangeListener = new OnAudioFocusChangeListenerHandlerCompat(onAudioFocusChangeListener, focusChangeHandler);
        } else {
            this.mOnAudioFocusChangeListener = onAudioFocusChangeListener;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.mFrameworkAudioFocusRequest = new AudioFocusRequest.Builder(focusGain).setAudioAttributes(getAudioAttributes()).setWillPauseWhenDucked(pauseOnDuck).setOnAudioFocusChangeListener(this.mOnAudioFocusChangeListener, focusChangeHandler).build();
        } else {
            this.mFrameworkAudioFocusRequest = null;
        }
    }

    public int getFocusGain() {
        return this.mFocusGain;
    }

    public AudioAttributesCompat getAudioAttributesCompat() {
        return this.mAudioAttributesCompat;
    }

    public boolean willPauseWhenDucked() {
        return this.mPauseOnDuck;
    }

    public AudioManager.OnAudioFocusChangeListener getOnAudioFocusChangeListener() {
        return this.mOnAudioFocusChangeListener;
    }

    public Handler getFocusChangeHandler() {
        return this.mFocusChangeHandler;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AudioFocusRequestCompat that = (AudioFocusRequestCompat) o;
        return this.mFocusGain == that.mFocusGain && this.mPauseOnDuck == that.mPauseOnDuck && ObjectsCompat.equals(this.mOnAudioFocusChangeListener, that.mOnAudioFocusChangeListener) && ObjectsCompat.equals(this.mFocusChangeHandler, that.mFocusChangeHandler) && ObjectsCompat.equals(this.mAudioAttributesCompat, that.mAudioAttributesCompat);
    }

    public int hashCode() {
        return ObjectsCompat.hash(Integer.valueOf(this.mFocusGain), this.mOnAudioFocusChangeListener, this.mFocusChangeHandler, this.mAudioAttributesCompat, Boolean.valueOf(this.mPauseOnDuck));
    }

    AudioAttributes getAudioAttributes() {
        AudioAttributesCompat audioAttributesCompat = this.mAudioAttributesCompat;
        if (audioAttributesCompat != null) {
            return (AudioAttributes) audioAttributesCompat.unwrap();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioFocusRequest getAudioFocusRequest() {
        return (AudioFocusRequest) this.mFrameworkAudioFocusRequest;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean mAcceptsDelayedFocusGain;
        private AudioAttributesCompat mAudioAttributesCompat;
        private Handler mFocusChangeHandler;
        private int mFocusGain;
        private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener;
        private boolean mPauseOnDuck;

        public Builder(int focusGain) {
            this.mAudioAttributesCompat = AudioFocusRequestCompat.FOCUS_DEFAULT_ATTR;
            setFocusGain(focusGain);
        }

        public Builder(AudioFocusRequestCompat requestToCopy) {
            this.mAudioAttributesCompat = AudioFocusRequestCompat.FOCUS_DEFAULT_ATTR;
            if (requestToCopy == null) {
                throw new IllegalArgumentException("AudioFocusRequestCompat to copy must not be null");
            }
            this.mFocusGain = requestToCopy.getFocusGain();
            this.mOnAudioFocusChangeListener = requestToCopy.getOnAudioFocusChangeListener();
            this.mFocusChangeHandler = requestToCopy.getFocusChangeHandler();
            this.mAudioAttributesCompat = requestToCopy.getAudioAttributesCompat();
            this.mPauseOnDuck = requestToCopy.willPauseWhenDucked();
        }

        public Builder setFocusGain(int focusGain) {
            if (!isValidFocusGain(focusGain)) {
                throw new IllegalArgumentException("Illegal audio focus gain type " + focusGain);
            }
            if (Build.VERSION.SDK_INT < 19 && focusGain == 4) {
                focusGain = 2;
            }
            this.mFocusGain = focusGain;
            return this;
        }

        public Builder setOnAudioFocusChangeListener(AudioManager.OnAudioFocusChangeListener listener) {
            return setOnAudioFocusChangeListener(listener, new Handler(Looper.getMainLooper()));
        }

        public Builder setOnAudioFocusChangeListener(AudioManager.OnAudioFocusChangeListener listener, Handler handler) {
            if (listener == null) {
                throw new IllegalArgumentException("OnAudioFocusChangeListener must not be null");
            }
            if (handler == null) {
                throw new IllegalArgumentException("Handler must not be null");
            }
            this.mOnAudioFocusChangeListener = listener;
            this.mFocusChangeHandler = handler;
            return this;
        }

        public Builder setAudioAttributes(AudioAttributesCompat attributes) {
            if (attributes == null) {
                throw new NullPointerException("Illegal null AudioAttributes");
            }
            this.mAudioAttributesCompat = attributes;
            return this;
        }

        public Builder setWillPauseWhenDucked(boolean pauseOnDuck) {
            this.mPauseOnDuck = pauseOnDuck;
            return this;
        }

        public AudioFocusRequestCompat build() {
            if (this.mOnAudioFocusChangeListener == null) {
                throw new IllegalStateException("Can't build an AudioFocusRequestCompat instance without a listener");
            }
            return new AudioFocusRequestCompat(this.mFocusGain, this.mOnAudioFocusChangeListener, this.mFocusChangeHandler, this.mAudioAttributesCompat, this.mPauseOnDuck);
        }

        static boolean isValidFocusGain(int focusGain) {
            switch (focusGain) {
                case 1:
                case 2:
                case 3:
                case 4:
                    return true;
                default:
                    return false;
            }
        }
    }

    /* loaded from: classes.dex */
    private static class OnAudioFocusChangeListenerHandlerCompat implements Handler.Callback, AudioManager.OnAudioFocusChangeListener {
        private static final int FOCUS_CHANGE = 2782386;
        private final Handler mHandler;
        private final AudioManager.OnAudioFocusChangeListener mListener;

        OnAudioFocusChangeListenerHandlerCompat(AudioManager.OnAudioFocusChangeListener listener, Handler handler) {
            this.mListener = listener;
            this.mHandler = new Handler(handler.getLooper(), this);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int focusChange) {
            Handler handler = this.mHandler;
            handler.sendMessage(Message.obtain(handler, FOCUS_CHANGE, focusChange, 0));
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == FOCUS_CHANGE) {
                this.mListener.onAudioFocusChange(message.arg1);
                return true;
            }
            return false;
        }
    }
}
