package io.flutter.plugins.imagepicker;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.lifecycle.FlutterLifecycleAdapter;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.imagepicker.ImagePickerDelegate;
import io.flutter.plugins.imagepicker.Messages;
import java.util.List;
/* loaded from: classes2.dex */
public class ImagePickerPlugin implements FlutterPlugin, ActivityAware, Messages.ImagePickerApi {
    ActivityState activityState;
    private FlutterPlugin.FlutterPluginBinding pluginBinding;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class LifeCycleObserver implements Application.ActivityLifecycleCallbacks, DefaultLifecycleObserver {
        private final Activity thisActivity;

        LifeCycleObserver(Activity activity) {
            this.thisActivity = activity;
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onCreate(LifecycleOwner owner) {
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onStart(LifecycleOwner owner) {
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onResume(LifecycleOwner owner) {
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onPause(LifecycleOwner owner) {
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onStop(LifecycleOwner owner) {
            onActivityStopped(this.thisActivity);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onDestroy(LifecycleOwner owner) {
            onActivityDestroyed(this.thisActivity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.thisActivity == activity && activity.getApplicationContext() != null) {
                ((Application) activity.getApplicationContext()).unregisterActivityLifecycleCallbacks(this);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (this.thisActivity == activity) {
                ImagePickerPlugin.this.activityState.getDelegate().saveStateBeforeResult();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ActivityState {
        private Activity activity;
        private ActivityPluginBinding activityBinding;
        private Application application;
        private ImagePickerDelegate delegate;
        private Lifecycle lifecycle;
        private BinaryMessenger messenger;
        private LifeCycleObserver observer;

        ActivityState(Application application, Activity activity, BinaryMessenger messenger, Messages.ImagePickerApi handler, PluginRegistry.Registrar registrar, ActivityPluginBinding activityBinding) {
            this.application = application;
            this.activity = activity;
            this.activityBinding = activityBinding;
            this.messenger = messenger;
            this.delegate = ImagePickerPlugin.this.constructDelegate(activity);
            Messages.ImagePickerApi.CC.setUp(messenger, handler);
            LifeCycleObserver lifeCycleObserver = new LifeCycleObserver(activity);
            this.observer = lifeCycleObserver;
            if (registrar != null) {
                application.registerActivityLifecycleCallbacks(lifeCycleObserver);
                registrar.addActivityResultListener(this.delegate);
                registrar.addRequestPermissionsResultListener(this.delegate);
                return;
            }
            activityBinding.addActivityResultListener(this.delegate);
            activityBinding.addRequestPermissionsResultListener(this.delegate);
            Lifecycle activityLifecycle = FlutterLifecycleAdapter.getActivityLifecycle(activityBinding);
            this.lifecycle = activityLifecycle;
            activityLifecycle.addObserver(this.observer);
        }

        ActivityState(ImagePickerDelegate delegate, Activity activity) {
            this.activity = activity;
            this.delegate = delegate;
        }

        void release() {
            ActivityPluginBinding activityPluginBinding = this.activityBinding;
            if (activityPluginBinding != null) {
                activityPluginBinding.removeActivityResultListener(this.delegate);
                this.activityBinding.removeRequestPermissionsResultListener(this.delegate);
                this.activityBinding = null;
            }
            Lifecycle lifecycle = this.lifecycle;
            if (lifecycle != null) {
                lifecycle.removeObserver(this.observer);
                this.lifecycle = null;
            }
            Messages.ImagePickerApi.CC.setUp(this.messenger, null);
            Application application = this.application;
            if (application != null) {
                application.unregisterActivityLifecycleCallbacks(this.observer);
                this.application = null;
            }
            this.activity = null;
            this.observer = null;
            this.delegate = null;
        }

        Activity getActivity() {
            return this.activity;
        }

        ImagePickerDelegate getDelegate() {
            return this.delegate;
        }
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        if (registrar.activity() == null) {
            return;
        }
        Activity activity = registrar.activity();
        Application application = (Application) registrar.context().getApplicationContext();
        ImagePickerPlugin plugin = new ImagePickerPlugin();
        plugin.setup(registrar.messenger(), application, activity, registrar, null);
    }

    public ImagePickerPlugin() {
    }

    ImagePickerPlugin(ImagePickerDelegate delegate, Activity activity) {
        this.activityState = new ActivityState(delegate, activity);
    }

    final ActivityState getActivityState() {
        return this.activityState;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        this.pluginBinding = binding;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        this.pluginBinding = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding binding) {
        setup(this.pluginBinding.getBinaryMessenger(), (Application) this.pluginBinding.getApplicationContext(), binding.getActivity(), null, binding);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        tearDown();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        onAttachedToActivity(binding);
    }

    private void setup(BinaryMessenger messenger, Application application, Activity activity, PluginRegistry.Registrar registrar, ActivityPluginBinding activityBinding) {
        this.activityState = new ActivityState(application, activity, messenger, this, registrar, activityBinding);
    }

    private void tearDown() {
        ActivityState activityState = this.activityState;
        if (activityState != null) {
            activityState.release();
            this.activityState = null;
        }
    }

    final ImagePickerDelegate constructDelegate(Activity setupActivity) {
        ImagePickerCache cache = new ImagePickerCache(setupActivity);
        ExifDataCopier exifDataCopier = new ExifDataCopier();
        ImageResizer imageResizer = new ImageResizer(setupActivity, exifDataCopier);
        return new ImagePickerDelegate(setupActivity, imageResizer, cache);
    }

    private ImagePickerDelegate getImagePickerDelegate() {
        ActivityState activityState = this.activityState;
        if (activityState == null || activityState.getActivity() == null) {
            return null;
        }
        return this.activityState.getDelegate();
    }

    private void setCameraDevice(ImagePickerDelegate delegate, Messages.SourceSpecification source) {
        ImagePickerDelegate.CameraDevice device;
        Messages.SourceCamera camera = source.getCamera();
        if (camera != null) {
            switch (AnonymousClass1.$SwitchMap$io$flutter$plugins$imagepicker$Messages$SourceCamera[camera.ordinal()]) {
                case 1:
                    device = ImagePickerDelegate.CameraDevice.FRONT;
                    break;
                default:
                    device = ImagePickerDelegate.CameraDevice.REAR;
                    break;
            }
            delegate.setCameraDevice(device);
        }
    }

    @Override // io.flutter.plugins.imagepicker.Messages.ImagePickerApi
    public void pickImages(Messages.SourceSpecification source, Messages.ImageSelectionOptions options, Messages.GeneralOptions generalOptions, Messages.Result<List<String>> result) {
        ImagePickerDelegate delegate = getImagePickerDelegate();
        if (delegate == null) {
            result.error(new Messages.FlutterError("no_activity", "image_picker plugin requires a foreground activity.", null));
            return;
        }
        setCameraDevice(delegate, source);
        if (generalOptions.getAllowMultiple().booleanValue()) {
            int limit = ImagePickerUtils.getLimitFromOption(generalOptions);
            delegate.chooseMultiImageFromGallery(options, generalOptions.getUsePhotoPicker().booleanValue(), limit, result);
            return;
        }
        switch (AnonymousClass1.$SwitchMap$io$flutter$plugins$imagepicker$Messages$SourceType[source.getType().ordinal()]) {
            case 1:
                delegate.chooseImageFromGallery(options, generalOptions.getUsePhotoPicker().booleanValue(), result);
                return;
            case 2:
                delegate.takeImageWithCamera(options, result);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.plugins.imagepicker.ImagePickerPlugin$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$imagepicker$Messages$SourceCamera;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$imagepicker$Messages$SourceType;

        static {
            int[] iArr = new int[Messages.SourceType.values().length];
            $SwitchMap$io$flutter$plugins$imagepicker$Messages$SourceType = iArr;
            try {
                iArr[Messages.SourceType.GALLERY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$io$flutter$plugins$imagepicker$Messages$SourceType[Messages.SourceType.CAMERA.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            int[] iArr2 = new int[Messages.SourceCamera.values().length];
            $SwitchMap$io$flutter$plugins$imagepicker$Messages$SourceCamera = iArr2;
            try {
                iArr2[Messages.SourceCamera.FRONT.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$io$flutter$plugins$imagepicker$Messages$SourceCamera[Messages.SourceCamera.REAR.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    @Override // io.flutter.plugins.imagepicker.Messages.ImagePickerApi
    public void pickMedia(Messages.MediaSelectionOptions mediaSelectionOptions, Messages.GeneralOptions generalOptions, Messages.Result<List<String>> result) {
        ImagePickerDelegate delegate = getImagePickerDelegate();
        if (delegate == null) {
            result.error(new Messages.FlutterError("no_activity", "image_picker plugin requires a foreground activity.", null));
        } else {
            delegate.chooseMediaFromGallery(mediaSelectionOptions, generalOptions, result);
        }
    }

    @Override // io.flutter.plugins.imagepicker.Messages.ImagePickerApi
    public void pickVideos(Messages.SourceSpecification source, Messages.VideoSelectionOptions options, Messages.GeneralOptions generalOptions, Messages.Result<List<String>> result) {
        ImagePickerDelegate delegate = getImagePickerDelegate();
        if (delegate == null) {
            result.error(new Messages.FlutterError("no_activity", "image_picker plugin requires a foreground activity.", null));
            return;
        }
        setCameraDevice(delegate, source);
        if (generalOptions.getAllowMultiple().booleanValue()) {
            result.error(new RuntimeException("Multi-video selection is not implemented"));
            return;
        }
        switch (AnonymousClass1.$SwitchMap$io$flutter$plugins$imagepicker$Messages$SourceType[source.getType().ordinal()]) {
            case 1:
                delegate.chooseVideoFromGallery(options, generalOptions.getUsePhotoPicker().booleanValue(), result);
                return;
            case 2:
                delegate.takeVideoWithCamera(options, result);
                return;
            default:
                return;
        }
    }

    @Override // io.flutter.plugins.imagepicker.Messages.ImagePickerApi
    public Messages.CacheRetrievalResult retrieveLostResults() {
        ImagePickerDelegate delegate = getImagePickerDelegate();
        if (delegate == null) {
            throw new Messages.FlutterError("no_activity", "image_picker plugin requires a foreground activity.", null);
        }
        return delegate.retrieveLostImage();
    }
}
