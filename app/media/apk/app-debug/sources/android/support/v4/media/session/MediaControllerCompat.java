package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import androidx.core.app.BundleCompat;
import androidx.core.app.ComponentActivity;
import androidx.media.AudioAttributesCompat;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class MediaControllerCompat {
    public static final String COMMAND_ADD_QUEUE_ITEM = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";
    public static final String COMMAND_ADD_QUEUE_ITEM_AT = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";
    public static final String COMMAND_ARGUMENT_INDEX = "android.support.v4.media.session.command.ARGUMENT_INDEX";
    public static final String COMMAND_ARGUMENT_MEDIA_DESCRIPTION = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";
    public static final String COMMAND_GET_EXTRA_BINDER = "android.support.v4.media.session.command.GET_EXTRA_BINDER";
    public static final String COMMAND_REMOVE_QUEUE_ITEM = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";
    public static final String COMMAND_REMOVE_QUEUE_ITEM_AT = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";
    static final String TAG = "MediaControllerCompat";
    private final MediaControllerImpl mImpl;
    private final ConcurrentHashMap<Callback, Boolean> mRegisteredCallbacks = new ConcurrentHashMap<>();
    private final MediaSessionCompat.Token mToken;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface MediaControllerImpl {
        void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat);

        void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i);

        void adjustVolume(int i, int i2);

        boolean dispatchMediaButtonEvent(KeyEvent keyEvent);

        Bundle getExtras();

        long getFlags();

        Object getMediaController();

        MediaMetadataCompat getMetadata();

        String getPackageName();

        PlaybackInfo getPlaybackInfo();

        PlaybackStateCompat getPlaybackState();

        List<MediaSessionCompat.QueueItem> getQueue();

        CharSequence getQueueTitle();

        int getRatingType();

        int getRepeatMode();

        PendingIntent getSessionActivity();

        Bundle getSessionInfo();

        int getShuffleMode();

        TransportControls getTransportControls();

        boolean isCaptioningEnabled();

        boolean isSessionReady();

        void registerCallback(Callback callback, Handler handler);

        void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat);

        void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        void setVolumeTo(int i, int i2);

        void unregisterCallback(Callback callback);
    }

    /* loaded from: classes.dex */
    private static class MediaControllerExtraData extends ComponentActivity.ExtraData {
        private final MediaControllerCompat mMediaController;

        MediaControllerExtraData(MediaControllerCompat mediaController) {
            this.mMediaController = mediaController;
        }

        MediaControllerCompat getMediaController() {
            return this.mMediaController;
        }
    }

    public static void setMediaController(Activity activity, MediaControllerCompat mediaController) {
        if (activity instanceof ComponentActivity) {
            ((ComponentActivity) activity).putExtraData(new MediaControllerExtraData(mediaController));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            MediaController controllerFwk = null;
            if (mediaController != null) {
                Object sessionTokenObj = mediaController.getSessionToken().getToken();
                controllerFwk = new MediaController(activity, (MediaSession.Token) sessionTokenObj);
            }
            activity.setMediaController(controllerFwk);
        }
    }

    public static MediaControllerCompat getMediaController(Activity activity) {
        MediaController controllerFwk;
        if (activity instanceof ComponentActivity) {
            MediaControllerExtraData extraData = (MediaControllerExtraData) ((ComponentActivity) activity).getExtraData(MediaControllerExtraData.class);
            if (extraData != null) {
                return extraData.getMediaController();
            }
            return null;
        } else if (Build.VERSION.SDK_INT < 21 || (controllerFwk = activity.getMediaController()) == null) {
            return null;
        } else {
            MediaSession.Token sessionTokenFwk = controllerFwk.getSessionToken();
            try {
                return new MediaControllerCompat(activity, MediaSessionCompat.Token.fromToken(sessionTokenFwk));
            } catch (RemoteException e) {
                Log.e(TAG, "Dead object in getMediaController.", e);
                return null;
            }
        }
    }

    static void validateCustomAction(String action, Bundle args) {
        if (action == null) {
            return;
        }
        char c = 65535;
        switch (action.hashCode()) {
            case -1348483723:
                if (action.equals(MediaSessionCompat.ACTION_FOLLOW)) {
                    c = 0;
                    break;
                }
                break;
            case 503011406:
                if (action.equals(MediaSessionCompat.ACTION_UNFOLLOW)) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                if (args == null || !args.containsKey(MediaSessionCompat.ARGUMENT_MEDIA_ATTRIBUTE)) {
                    throw new IllegalArgumentException("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action " + action + ".");
                }
                return;
            default:
                return;
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat session) {
        if (session == null) {
            throw new IllegalArgumentException("session must not be null");
        }
        MediaSessionCompat.Token sessionToken = session.getSessionToken();
        this.mToken = sessionToken;
        MediaControllerImpl impl = null;
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                impl = new MediaControllerImplApi21(context, sessionToken);
            } else {
                impl = new MediaControllerImplBase(sessionToken);
            }
        } catch (RemoteException e) {
            Log.w(TAG, "Failed to create MediaControllerImpl.", e);
        }
        this.mImpl = impl;
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token sessionToken) throws RemoteException {
        if (sessionToken == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.mToken = sessionToken;
        if (Build.VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaControllerImplApi21(context, sessionToken);
        } else {
            this.mImpl = new MediaControllerImplBase(sessionToken);
        }
    }

    public TransportControls getTransportControls() {
        return this.mImpl.getTransportControls();
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        if (keyEvent == null) {
            throw new IllegalArgumentException("KeyEvent may not be null");
        }
        return this.mImpl.dispatchMediaButtonEvent(keyEvent);
    }

    public PlaybackStateCompat getPlaybackState() {
        return this.mImpl.getPlaybackState();
    }

    public MediaMetadataCompat getMetadata() {
        return this.mImpl.getMetadata();
    }

    public List<MediaSessionCompat.QueueItem> getQueue() {
        return this.mImpl.getQueue();
    }

    public void addQueueItem(MediaDescriptionCompat description) {
        this.mImpl.addQueueItem(description);
    }

    public void addQueueItem(MediaDescriptionCompat description, int index) {
        this.mImpl.addQueueItem(description, index);
    }

    public void removeQueueItem(MediaDescriptionCompat description) {
        this.mImpl.removeQueueItem(description);
    }

    @Deprecated
    public void removeQueueItemAt(int index) {
        MediaSessionCompat.QueueItem item;
        List<MediaSessionCompat.QueueItem> queue = getQueue();
        if (queue != null && index >= 0 && index < queue.size() && (item = queue.get(index)) != null) {
            removeQueueItem(item.getDescription());
        }
    }

    public CharSequence getQueueTitle() {
        return this.mImpl.getQueueTitle();
    }

    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public int getRatingType() {
        return this.mImpl.getRatingType();
    }

    public boolean isCaptioningEnabled() {
        return this.mImpl.isCaptioningEnabled();
    }

    public int getRepeatMode() {
        return this.mImpl.getRepeatMode();
    }

    public int getShuffleMode() {
        return this.mImpl.getShuffleMode();
    }

    public long getFlags() {
        return this.mImpl.getFlags();
    }

    public PlaybackInfo getPlaybackInfo() {
        return this.mImpl.getPlaybackInfo();
    }

    public PendingIntent getSessionActivity() {
        return this.mImpl.getSessionActivity();
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.mToken;
    }

    public VersionedParcelable getSession2Token() {
        return this.mToken.getSession2Token();
    }

    public void setVolumeTo(int value, int flags) {
        this.mImpl.setVolumeTo(value, flags);
    }

    public void adjustVolume(int direction, int flags) {
        this.mImpl.adjustVolume(direction, flags);
    }

    public void registerCallback(Callback callback) {
        registerCallback(callback, null);
    }

    public void registerCallback(Callback callback, Handler handler) {
        if (callback == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        if (this.mRegisteredCallbacks.putIfAbsent(callback, true) != null) {
            Log.w(TAG, "the callback has already been registered");
            return;
        }
        if (handler == null) {
            handler = new Handler();
        }
        callback.setHandler(handler);
        this.mImpl.registerCallback(callback, handler);
    }

    public void unregisterCallback(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        if (this.mRegisteredCallbacks.remove(callback) == null) {
            Log.w(TAG, "the callback has never been registered");
            return;
        }
        try {
            this.mImpl.unregisterCallback(callback);
        } finally {
            callback.setHandler(null);
        }
    }

    public void sendCommand(String command, Bundle params, ResultReceiver cb) {
        if (TextUtils.isEmpty(command)) {
            throw new IllegalArgumentException("command must neither be null nor empty");
        }
        this.mImpl.sendCommand(command, params, cb);
    }

    public boolean isSessionReady() {
        return this.mImpl.isSessionReady();
    }

    public String getPackageName() {
        return this.mImpl.getPackageName();
    }

    public Bundle getSessionInfo() {
        return this.mImpl.getSessionInfo();
    }

    public Object getMediaController() {
        return this.mImpl.getMediaController();
    }

    /* loaded from: classes.dex */
    public static abstract class Callback implements IBinder.DeathRecipient {
        final MediaController.Callback mCallbackFwk;
        MessageHandler mHandler;
        IMediaControllerCallback mIControllerCallback;

        public Callback() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.mCallbackFwk = new MediaControllerCallbackApi21(this);
                return;
            }
            this.mCallbackFwk = null;
            this.mIControllerCallback = new StubCompat(this);
        }

        public void onSessionReady() {
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String event, Bundle extras) {
        }

        public void onPlaybackStateChanged(PlaybackStateCompat state) {
        }

        public void onMetadataChanged(MediaMetadataCompat metadata) {
        }

        public void onQueueChanged(List<MediaSessionCompat.QueueItem> queue) {
        }

        public void onQueueTitleChanged(CharSequence title) {
        }

        public void onExtrasChanged(Bundle extras) {
        }

        public void onAudioInfoChanged(PlaybackInfo info) {
        }

        public void onCaptioningEnabledChanged(boolean enabled) {
        }

        public void onRepeatModeChanged(int repeatMode) {
        }

        public void onShuffleModeChanged(int shuffleMode) {
        }

        public IMediaControllerCallback getIControllerCallback() {
            return this.mIControllerCallback;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            postToHandler(8, null, null);
        }

        void setHandler(Handler handler) {
            if (handler == null) {
                MessageHandler messageHandler = this.mHandler;
                if (messageHandler != null) {
                    messageHandler.mRegistered = false;
                    this.mHandler.removeCallbacksAndMessages(null);
                    this.mHandler = null;
                    return;
                }
                return;
            }
            MessageHandler messageHandler2 = new MessageHandler(handler.getLooper());
            this.mHandler = messageHandler2;
            messageHandler2.mRegistered = true;
        }

        void postToHandler(int what, Object obj, Bundle data) {
            MessageHandler messageHandler = this.mHandler;
            if (messageHandler != null) {
                Message msg = messageHandler.obtainMessage(what, obj);
                msg.setData(data);
                msg.sendToTarget();
            }
        }

        /* loaded from: classes.dex */
        private static class MediaControllerCallbackApi21 extends MediaController.Callback {
            private final WeakReference<Callback> mCallback;

            MediaControllerCallbackApi21(Callback callback) {
                this.mCallback = new WeakReference<>(callback);
            }

            @Override // android.media.session.MediaController.Callback
            public void onSessionDestroyed() {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.onSessionDestroyed();
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onSessionEvent(String event, Bundle extras) {
                MediaSessionCompat.ensureClassLoader(extras);
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    if (callback.mIControllerCallback == null || Build.VERSION.SDK_INT >= 23) {
                        callback.onSessionEvent(event, extras);
                    }
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onPlaybackStateChanged(PlaybackState stateObj) {
                Callback callback = this.mCallback.get();
                if (callback != null && callback.mIControllerCallback == null) {
                    callback.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(stateObj));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onMetadataChanged(MediaMetadata metadataObj) {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(metadataObj));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onQueueChanged(List<MediaSession.QueueItem> queue) {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.onQueueChanged(MediaSessionCompat.QueueItem.fromQueueItemList(queue));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onQueueTitleChanged(CharSequence title) {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.onQueueTitleChanged(title);
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onExtrasChanged(Bundle extras) {
                MediaSessionCompat.ensureClassLoader(extras);
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.onExtrasChanged(extras);
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onAudioInfoChanged(MediaController.PlaybackInfo info) {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.onAudioInfoChanged(new PlaybackInfo(info.getPlaybackType(), AudioAttributesCompat.wrap(info.getAudioAttributes()), info.getVolumeControl(), info.getMaxVolume(), info.getCurrentVolume()));
                }
            }
        }

        /* loaded from: classes.dex */
        private static class StubCompat extends IMediaControllerCallback.Stub {
            private final WeakReference<Callback> mCallback;

            StubCompat(Callback callback) {
                this.mCallback = new WeakReference<>(callback);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onEvent(String event, Bundle extras) throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(1, event, extras);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(8, null, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onPlaybackStateChanged(PlaybackStateCompat state) throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(2, state, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat metadata) throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(3, metadata, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> queue) throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(5, queue, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence title) throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(6, title, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onCaptioningEnabledChanged(boolean enabled) throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(11, Boolean.valueOf(enabled), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onRepeatModeChanged(int repeatMode) throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(9, Integer.valueOf(repeatMode), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChangedRemoved(boolean enabled) throws RemoteException {
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChanged(int shuffleMode) throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(12, Integer.valueOf(shuffleMode), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle extras) throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(7, extras, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo info) throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    PlaybackInfo pi = null;
                    if (info != null) {
                        pi = new PlaybackInfo(info.volumeType, info.audioStream, info.controlType, info.maxVolume, info.currentVolume);
                    }
                    callback.postToHandler(4, pi, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionReady() throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(13, null, null);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public class MessageHandler extends Handler {
            private static final int MSG_DESTROYED = 8;
            private static final int MSG_EVENT = 1;
            private static final int MSG_SESSION_READY = 13;
            private static final int MSG_UPDATE_CAPTIONING_ENABLED = 11;
            private static final int MSG_UPDATE_EXTRAS = 7;
            private static final int MSG_UPDATE_METADATA = 3;
            private static final int MSG_UPDATE_PLAYBACK_STATE = 2;
            private static final int MSG_UPDATE_QUEUE = 5;
            private static final int MSG_UPDATE_QUEUE_TITLE = 6;
            private static final int MSG_UPDATE_REPEAT_MODE = 9;
            private static final int MSG_UPDATE_SHUFFLE_MODE = 12;
            private static final int MSG_UPDATE_VOLUME = 4;
            boolean mRegistered;

            MessageHandler(Looper looper) {
                super(looper);
                this.mRegistered = false;
            }

            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                if (!this.mRegistered) {
                    return;
                }
                switch (msg.what) {
                    case 1:
                        Bundle extras = msg.getData();
                        MediaSessionCompat.ensureClassLoader(extras);
                        Callback.this.onSessionEvent((String) msg.obj, extras);
                        return;
                    case 2:
                        Callback.this.onPlaybackStateChanged((PlaybackStateCompat) msg.obj);
                        return;
                    case 3:
                        Callback.this.onMetadataChanged((MediaMetadataCompat) msg.obj);
                        return;
                    case 4:
                        Callback.this.onAudioInfoChanged((PlaybackInfo) msg.obj);
                        return;
                    case 5:
                        Callback.this.onQueueChanged((List) msg.obj);
                        return;
                    case 6:
                        Callback.this.onQueueTitleChanged((CharSequence) msg.obj);
                        return;
                    case 7:
                        Bundle extras2 = (Bundle) msg.obj;
                        MediaSessionCompat.ensureClassLoader(extras2);
                        Callback.this.onExtrasChanged(extras2);
                        return;
                    case 8:
                        Callback.this.onSessionDestroyed();
                        return;
                    case 9:
                        Callback.this.onRepeatModeChanged(((Integer) msg.obj).intValue());
                        return;
                    case 10:
                    default:
                        return;
                    case 11:
                        Callback.this.onCaptioningEnabledChanged(((Boolean) msg.obj).booleanValue());
                        return;
                    case 12:
                        Callback.this.onShuffleModeChanged(((Integer) msg.obj).intValue());
                        return;
                    case 13:
                        Callback.this.onSessionReady();
                        return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class TransportControls {
        public static final String EXTRA_LEGACY_STREAM_TYPE = "android.media.session.extra.LEGACY_STREAM_TYPE";

        public abstract void fastForward();

        public abstract void pause();

        public abstract void play();

        public abstract void playFromMediaId(String str, Bundle bundle);

        public abstract void playFromSearch(String str, Bundle bundle);

        public abstract void playFromUri(Uri uri, Bundle bundle);

        public abstract void prepare();

        public abstract void prepareFromMediaId(String str, Bundle bundle);

        public abstract void prepareFromSearch(String str, Bundle bundle);

        public abstract void prepareFromUri(Uri uri, Bundle bundle);

        public abstract void rewind();

        public abstract void seekTo(long j);

        public abstract void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle);

        public abstract void sendCustomAction(String str, Bundle bundle);

        public abstract void setCaptioningEnabled(boolean z);

        public abstract void setRating(RatingCompat ratingCompat);

        public abstract void setRating(RatingCompat ratingCompat, Bundle bundle);

        public abstract void setRepeatMode(int i);

        public abstract void setShuffleMode(int i);

        public abstract void skipToNext();

        public abstract void skipToPrevious();

        public abstract void skipToQueueItem(long j);

        public abstract void stop();

        TransportControls() {
        }

        public void setPlaybackSpeed(float speed) {
        }
    }

    /* loaded from: classes.dex */
    public static final class PlaybackInfo {
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;
        private final AudioAttributesCompat mAudioAttrsCompat;
        private final int mCurrentVolume;
        private final int mMaxVolume;
        private final int mPlaybackType;
        private final int mVolumeControl;

        PlaybackInfo(int type, int stream, int control, int max, int current) {
            this(type, new AudioAttributesCompat.Builder().setLegacyStreamType(stream).build(), control, max, current);
        }

        PlaybackInfo(int type, AudioAttributesCompat attrsCompat, int control, int max, int current) {
            this.mPlaybackType = type;
            this.mAudioAttrsCompat = attrsCompat;
            this.mVolumeControl = control;
            this.mMaxVolume = max;
            this.mCurrentVolume = current;
        }

        public int getPlaybackType() {
            return this.mPlaybackType;
        }

        @Deprecated
        public int getAudioStream() {
            return this.mAudioAttrsCompat.getLegacyStreamType();
        }

        public AudioAttributesCompat getAudioAttributes() {
            return this.mAudioAttrsCompat;
        }

        public int getVolumeControl() {
            return this.mVolumeControl;
        }

        public int getMaxVolume() {
            return this.mMaxVolume;
        }

        public int getCurrentVolume() {
            return this.mCurrentVolume;
        }
    }

    /* loaded from: classes.dex */
    static class MediaControllerImplBase implements MediaControllerImpl {
        private IMediaSession mBinder;
        private Bundle mSessionInfo;
        private TransportControls mTransportControls;

        public MediaControllerImplBase(MediaSessionCompat.Token token) {
            this.mBinder = IMediaSession.Stub.asInterface((IBinder) token.getToken());
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void registerCallback(Callback callback, Handler handler) {
            if (callback == null) {
                throw new IllegalArgumentException("callback may not be null.");
            }
            try {
                this.mBinder.asBinder().linkToDeath(callback, 0);
                this.mBinder.registerCallbackListener(callback.mIControllerCallback);
                callback.postToHandler(13, null, null);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in registerCallback.", e);
                callback.postToHandler(8, null, null);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void unregisterCallback(Callback callback) {
            if (callback == null) {
                throw new IllegalArgumentException("callback may not be null.");
            }
            try {
                this.mBinder.unregisterCallbackListener(callback.mIControllerCallback);
                this.mBinder.asBinder().unlinkToDeath(callback, 0);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in unregisterCallback.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean dispatchMediaButtonEvent(KeyEvent event) {
            if (event == null) {
                throw new IllegalArgumentException("event may not be null.");
            }
            try {
                this.mBinder.sendMediaButton(event);
                return false;
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in dispatchMediaButtonEvent.", e);
                return false;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            if (this.mTransportControls == null) {
                this.mTransportControls = new TransportControlsBase(this.mBinder);
            }
            return this.mTransportControls;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackStateCompat getPlaybackState() {
            try {
                return this.mBinder.getPlaybackState();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getPlaybackState.", e);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public MediaMetadataCompat getMetadata() {
            try {
                return this.mBinder.getMetadata();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getMetadata.", e);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public List<MediaSessionCompat.QueueItem> getQueue() {
            try {
                return this.mBinder.getQueue();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getQueue.", e);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat description) {
            try {
                long flags = this.mBinder.getFlags();
                if ((4 & flags) == 0) {
                    throw new UnsupportedOperationException("This session doesn't support queue management operations");
                }
                this.mBinder.addQueueItem(description);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in addQueueItem.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat description, int index) {
            try {
                long flags = this.mBinder.getFlags();
                if ((4 & flags) == 0) {
                    throw new UnsupportedOperationException("This session doesn't support queue management operations");
                }
                this.mBinder.addQueueItemAt(description, index);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in addQueueItemAt.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void removeQueueItem(MediaDescriptionCompat description) {
            try {
                long flags = this.mBinder.getFlags();
                if ((4 & flags) == 0) {
                    throw new UnsupportedOperationException("This session doesn't support queue management operations");
                }
                this.mBinder.removeQueueItem(description);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in removeQueueItem.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public CharSequence getQueueTitle() {
            try {
                return this.mBinder.getQueueTitle();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getQueueTitle.", e);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Bundle getExtras() {
            try {
                return this.mBinder.getExtras();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getExtras.", e);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRatingType() {
            try {
                return this.mBinder.getRatingType();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getRatingType.", e);
                return 0;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isCaptioningEnabled() {
            try {
                return this.mBinder.isCaptioningEnabled();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in isCaptioningEnabled.", e);
                return false;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRepeatMode() {
            try {
                return this.mBinder.getRepeatMode();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getRepeatMode.", e);
                return -1;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getShuffleMode() {
            try {
                return this.mBinder.getShuffleMode();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getShuffleMode.", e);
                return -1;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public long getFlags() {
            try {
                return this.mBinder.getFlags();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getFlags.", e);
                return 0L;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackInfo getPlaybackInfo() {
            try {
                ParcelableVolumeInfo info = this.mBinder.getVolumeAttributes();
                PlaybackInfo pi = new PlaybackInfo(info.volumeType, info.audioStream, info.controlType, info.maxVolume, info.currentVolume);
                return pi;
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getPlaybackInfo.", e);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PendingIntent getSessionActivity() {
            try {
                return this.mBinder.getLaunchPendingIntent();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getSessionActivity.", e);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void setVolumeTo(int value, int flags) {
            try {
                this.mBinder.setVolumeTo(value, flags, null);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in setVolumeTo.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void adjustVolume(int direction, int flags) {
            try {
                this.mBinder.adjustVolume(direction, flags, null);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in adjustVolume.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void sendCommand(String command, Bundle params, ResultReceiver cb) {
            try {
                this.mBinder.sendCommand(command, params, cb == null ? null : new MediaSessionCompat.ResultReceiverWrapper(cb));
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in sendCommand.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isSessionReady() {
            return true;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public String getPackageName() {
            try {
                return this.mBinder.getPackageName();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getPackageName.", e);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Bundle getSessionInfo() {
            try {
                this.mSessionInfo = this.mBinder.getSessionInfo();
            } catch (RemoteException e) {
                Log.d(MediaControllerCompat.TAG, "Dead object in getSessionInfo.", e);
            }
            return this.mSessionInfo == null ? Bundle.EMPTY : new Bundle(this.mSessionInfo);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Object getMediaController() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    static class TransportControlsBase extends TransportControls {
        private IMediaSession mBinder;

        public TransportControlsBase(IMediaSession binder) {
            this.mBinder = binder;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            try {
                this.mBinder.prepare();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in prepare.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String mediaId, Bundle extras) {
            try {
                this.mBinder.prepareFromMediaId(mediaId, extras);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in prepareFromMediaId.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(String query, Bundle extras) {
            try {
                this.mBinder.prepareFromSearch(query, extras);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in prepareFromSearch.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(Uri uri, Bundle extras) {
            try {
                this.mBinder.prepareFromUri(uri, extras);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in prepareFromUri.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void play() {
            try {
                this.mBinder.play();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in play.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromMediaId(String mediaId, Bundle extras) {
            try {
                this.mBinder.playFromMediaId(mediaId, extras);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in playFromMediaId.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromSearch(String query, Bundle extras) {
            try {
                this.mBinder.playFromSearch(query, extras);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in playFromSearch.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri uri, Bundle extras) {
            try {
                this.mBinder.playFromUri(uri, extras);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in playFromUri.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToQueueItem(long id) {
            try {
                this.mBinder.skipToQueueItem(id);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in skipToQueueItem.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void pause() {
            try {
                this.mBinder.pause();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in pause.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void stop() {
            try {
                this.mBinder.stop();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in stop.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void seekTo(long pos) {
            try {
                this.mBinder.seekTo(pos);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in seekTo.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void fastForward() {
            try {
                this.mBinder.fastForward();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in fastForward.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToNext() {
            try {
                this.mBinder.next();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in skipToNext.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void rewind() {
            try {
                this.mBinder.rewind();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in rewind.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToPrevious() {
            try {
                this.mBinder.previous();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in skipToPrevious.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat rating) {
            try {
                this.mBinder.rate(rating);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in setRating.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat rating, Bundle extras) {
            try {
                this.mBinder.rateWithExtras(rating, extras);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in setRating.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setPlaybackSpeed(float speed) {
            if (speed == 0.0f) {
                throw new IllegalArgumentException("speed must not be zero");
            }
            try {
                this.mBinder.setPlaybackSpeed(speed);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in setPlaybackSpeed.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setCaptioningEnabled(boolean enabled) {
            try {
                this.mBinder.setCaptioningEnabled(enabled);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in setCaptioningEnabled.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRepeatMode(int repeatMode) {
            try {
                this.mBinder.setRepeatMode(repeatMode);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in setRepeatMode.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setShuffleMode(int shuffleMode) {
            try {
                this.mBinder.setShuffleMode(shuffleMode);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in setShuffleMode.", e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle args) {
            sendCustomAction(customAction.getAction(), args);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(String action, Bundle args) {
            MediaControllerCompat.validateCustomAction(action, args);
            try {
                this.mBinder.sendCustomAction(action, args);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in sendCustomAction.", e);
            }
        }
    }

    /* loaded from: classes.dex */
    static class MediaControllerImplApi21 implements MediaControllerImpl {
        protected final MediaController mControllerFwk;
        private Bundle mSessionInfo;
        final MediaSessionCompat.Token mSessionToken;
        final Object mLock = new Object();
        private final List<Callback> mPendingCallbacks = new ArrayList();
        private HashMap<Callback, ExtraCallback> mCallbackMap = new HashMap<>();

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token sessionToken) throws RemoteException {
            this.mSessionToken = sessionToken;
            this.mControllerFwk = new MediaController(context, (MediaSession.Token) sessionToken.getToken());
            if (sessionToken.getExtraBinder() == null) {
                requestExtraBinder();
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public final void registerCallback(Callback callback, Handler handler) {
            this.mControllerFwk.registerCallback(callback.mCallbackFwk, handler);
            synchronized (this.mLock) {
                if (this.mSessionToken.getExtraBinder() != null) {
                    ExtraCallback extraCallback = new ExtraCallback(callback);
                    this.mCallbackMap.put(callback, extraCallback);
                    callback.mIControllerCallback = extraCallback;
                    try {
                        this.mSessionToken.getExtraBinder().registerCallbackListener(extraCallback);
                        callback.postToHandler(13, null, null);
                    } catch (RemoteException e) {
                        Log.e(MediaControllerCompat.TAG, "Dead object in registerCallback.", e);
                    }
                } else {
                    callback.mIControllerCallback = null;
                    this.mPendingCallbacks.add(callback);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public final void unregisterCallback(Callback callback) {
            this.mControllerFwk.unregisterCallback(callback.mCallbackFwk);
            synchronized (this.mLock) {
                if (this.mSessionToken.getExtraBinder() != null) {
                    try {
                        ExtraCallback extraCallback = this.mCallbackMap.remove(callback);
                        if (extraCallback != null) {
                            callback.mIControllerCallback = null;
                            this.mSessionToken.getExtraBinder().unregisterCallbackListener(extraCallback);
                        }
                    } catch (RemoteException e) {
                        Log.e(MediaControllerCompat.TAG, "Dead object in unregisterCallback.", e);
                    }
                } else {
                    this.mPendingCallbacks.remove(callback);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean dispatchMediaButtonEvent(KeyEvent event) {
            return this.mControllerFwk.dispatchMediaButtonEvent(event);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            return new TransportControlsApi21(this.mControllerFwk.getTransportControls());
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackStateCompat getPlaybackState() {
            if (this.mSessionToken.getExtraBinder() != null) {
                try {
                    return this.mSessionToken.getExtraBinder().getPlaybackState();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getPlaybackState.", e);
                }
            }
            PlaybackState stateFwk = this.mControllerFwk.getPlaybackState();
            if (stateFwk != null) {
                return PlaybackStateCompat.fromPlaybackState(stateFwk);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public MediaMetadataCompat getMetadata() {
            MediaMetadata metadataFwk = this.mControllerFwk.getMetadata();
            if (metadataFwk != null) {
                return MediaMetadataCompat.fromMediaMetadata(metadataFwk);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public List<MediaSessionCompat.QueueItem> getQueue() {
            List<MediaSession.QueueItem> queueFwks = this.mControllerFwk.getQueue();
            if (queueFwks != null) {
                return MediaSessionCompat.QueueItem.fromQueueItemList(queueFwks);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat description) {
            long flags = getFlags();
            if ((4 & flags) == 0) {
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            Bundle params = new Bundle();
            params.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, description);
            sendCommand(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM, params, null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat description, int index) {
            long flags = getFlags();
            if ((4 & flags) == 0) {
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            Bundle params = new Bundle();
            params.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, description);
            params.putInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX, index);
            sendCommand(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM_AT, params, null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void removeQueueItem(MediaDescriptionCompat description) {
            long flags = getFlags();
            if ((4 & flags) == 0) {
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            Bundle params = new Bundle();
            params.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, description);
            sendCommand(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM, params, null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public CharSequence getQueueTitle() {
            return this.mControllerFwk.getQueueTitle();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Bundle getExtras() {
            return this.mControllerFwk.getExtras();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRatingType() {
            if (Build.VERSION.SDK_INT < 22 && this.mSessionToken.getExtraBinder() != null) {
                try {
                    return this.mSessionToken.getExtraBinder().getRatingType();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getRatingType.", e);
                }
            }
            return this.mControllerFwk.getRatingType();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isCaptioningEnabled() {
            if (this.mSessionToken.getExtraBinder() != null) {
                try {
                    return this.mSessionToken.getExtraBinder().isCaptioningEnabled();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in isCaptioningEnabled.", e);
                    return false;
                }
            }
            return false;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRepeatMode() {
            if (this.mSessionToken.getExtraBinder() != null) {
                try {
                    return this.mSessionToken.getExtraBinder().getRepeatMode();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getRepeatMode.", e);
                    return -1;
                }
            }
            return -1;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getShuffleMode() {
            if (this.mSessionToken.getExtraBinder() != null) {
                try {
                    return this.mSessionToken.getExtraBinder().getShuffleMode();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getShuffleMode.", e);
                    return -1;
                }
            }
            return -1;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public long getFlags() {
            return this.mControllerFwk.getFlags();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackInfo getPlaybackInfo() {
            MediaController.PlaybackInfo volumeInfoFwk = this.mControllerFwk.getPlaybackInfo();
            if (volumeInfoFwk != null) {
                return new PlaybackInfo(volumeInfoFwk.getPlaybackType(), AudioAttributesCompat.wrap(volumeInfoFwk.getAudioAttributes()), volumeInfoFwk.getVolumeControl(), volumeInfoFwk.getMaxVolume(), volumeInfoFwk.getCurrentVolume());
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PendingIntent getSessionActivity() {
            return this.mControllerFwk.getSessionActivity();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void setVolumeTo(int value, int flags) {
            this.mControllerFwk.setVolumeTo(value, flags);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void adjustVolume(int direction, int flags) {
            this.mControllerFwk.adjustVolume(direction, flags);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void sendCommand(String command, Bundle params, ResultReceiver cb) {
            this.mControllerFwk.sendCommand(command, params, cb);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isSessionReady() {
            return this.mSessionToken.getExtraBinder() != null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public String getPackageName() {
            return this.mControllerFwk.getPackageName();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Bundle getSessionInfo() {
            if (this.mSessionToken.getExtraBinder() != null) {
                try {
                    this.mSessionInfo = this.mSessionToken.getExtraBinder().getSessionInfo();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getSessionInfo.", e);
                }
            }
            return this.mSessionInfo == null ? Bundle.EMPTY : new Bundle(this.mSessionInfo);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Object getMediaController() {
            return this.mControllerFwk;
        }

        private void requestExtraBinder() {
            sendCommand(MediaControllerCompat.COMMAND_GET_EXTRA_BINDER, null, new ExtraBinderRequestResultReceiver(this));
        }

        void processPendingCallbacksLocked() {
            if (this.mSessionToken.getExtraBinder() == null) {
                return;
            }
            for (Callback callback : this.mPendingCallbacks) {
                ExtraCallback extraCallback = new ExtraCallback(callback);
                this.mCallbackMap.put(callback, extraCallback);
                callback.mIControllerCallback = extraCallback;
                try {
                    this.mSessionToken.getExtraBinder().registerCallbackListener(extraCallback);
                    callback.postToHandler(13, null, null);
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in registerCallback.", e);
                }
            }
            this.mPendingCallbacks.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private WeakReference<MediaControllerImplApi21> mMediaControllerImpl;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImpl) {
                super(null);
                this.mMediaControllerImpl = new WeakReference<>(mediaControllerImpl);
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, Bundle resultData) {
                MediaControllerImplApi21 mediaControllerImpl = this.mMediaControllerImpl.get();
                if (mediaControllerImpl == null || resultData == null) {
                    return;
                }
                synchronized (mediaControllerImpl.mLock) {
                    mediaControllerImpl.mSessionToken.setExtraBinder(IMediaSession.Stub.asInterface(BundleCompat.getBinder(resultData, MediaSessionCompat.KEY_EXTRA_BINDER)));
                    mediaControllerImpl.mSessionToken.setSession2Token(ParcelUtils.getVersionedParcelable(resultData, MediaSessionCompat.KEY_SESSION2_TOKEN));
                    mediaControllerImpl.processPendingCallbacksLocked();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class ExtraCallback extends Callback.StubCompat {
            ExtraCallback(Callback callback) {
                super(callback);
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat metadata) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> queue) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence title) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle extras) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo info) throws RemoteException {
                throw new AssertionError();
            }
        }
    }

    /* loaded from: classes.dex */
    static class TransportControlsApi21 extends TransportControls {
        protected final MediaController.TransportControls mControlsFwk;

        TransportControlsApi21(MediaController.TransportControls controlsFwk) {
            this.mControlsFwk = controlsFwk;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            if (Build.VERSION.SDK_INT >= 24) {
                this.mControlsFwk.prepare();
            } else {
                sendCustomAction(MediaSessionCompat.ACTION_PREPARE, (Bundle) null);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String mediaId, Bundle extras) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.mControlsFwk.prepareFromMediaId(mediaId, extras);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID, mediaId);
            bundle.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, extras);
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(String query, Bundle extras) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.mControlsFwk.prepareFromSearch(query, extras);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(MediaSessionCompat.ACTION_ARGUMENT_QUERY, query);
            bundle.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, extras);
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(Uri uri, Bundle extras) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.mControlsFwk.prepareFromUri(uri, extras);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI, uri);
            bundle.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, extras);
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_URI, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void play() {
            this.mControlsFwk.play();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void pause() {
            this.mControlsFwk.pause();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void stop() {
            this.mControlsFwk.stop();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void seekTo(long pos) {
            this.mControlsFwk.seekTo(pos);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void fastForward() {
            this.mControlsFwk.fastForward();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void rewind() {
            this.mControlsFwk.rewind();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToNext() {
            this.mControlsFwk.skipToNext();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToPrevious() {
            this.mControlsFwk.skipToPrevious();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat rating) {
            this.mControlsFwk.setRating(rating != null ? (Rating) rating.getRating() : null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat rating, Bundle extras) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING, rating);
            bundle.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, extras);
            sendCustomAction(MediaSessionCompat.ACTION_SET_RATING, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setPlaybackSpeed(float speed) {
            if (speed == 0.0f) {
                throw new IllegalArgumentException("speed must not be zero");
            }
            Bundle bundle = new Bundle();
            bundle.putFloat(MediaSessionCompat.ACTION_ARGUMENT_PLAYBACK_SPEED, speed);
            sendCustomAction(MediaSessionCompat.ACTION_SET_PLAYBACK_SPEED, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setCaptioningEnabled(boolean enabled) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED, enabled);
            sendCustomAction(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRepeatMode(int repeatMode) {
            Bundle bundle = new Bundle();
            bundle.putInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE, repeatMode);
            sendCustomAction(MediaSessionCompat.ACTION_SET_REPEAT_MODE, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setShuffleMode(int shuffleMode) {
            Bundle bundle = new Bundle();
            bundle.putInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE, shuffleMode);
            sendCustomAction(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromMediaId(String mediaId, Bundle extras) {
            this.mControlsFwk.playFromMediaId(mediaId, extras);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromSearch(String query, Bundle extras) {
            this.mControlsFwk.playFromSearch(query, extras);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri uri, Bundle extras) {
            if (Build.VERSION.SDK_INT >= 23) {
                this.mControlsFwk.playFromUri(uri, extras);
            } else if (uri == null || Uri.EMPTY.equals(uri)) {
                throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
            } else {
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI, uri);
                bundle.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, extras);
                sendCustomAction(MediaSessionCompat.ACTION_PLAY_FROM_URI, bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToQueueItem(long id) {
            this.mControlsFwk.skipToQueueItem(id);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle args) {
            MediaControllerCompat.validateCustomAction(customAction.getAction(), args);
            this.mControlsFwk.sendCustomAction(customAction.getAction(), args);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(String action, Bundle args) {
            MediaControllerCompat.validateCustomAction(action, args);
            this.mControlsFwk.sendCustomAction(action, args);
        }
    }
}
