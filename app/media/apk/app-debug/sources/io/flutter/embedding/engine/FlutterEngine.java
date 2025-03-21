package io.flutter.embedding.engine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface;
import io.flutter.embedding.engine.plugins.service.ServiceControlSurface;
import io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.embedding.engine.systemchannels.DeferredComponentChannel;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.ProcessTextChannel;
import io.flutter.embedding.engine.systemchannels.RestorationChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.embedding.engine.systemchannels.SpellCheckChannel;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.plugin.text.ProcessTextPlugin;
import io.flutter.util.ViewUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class FlutterEngine implements ViewUtils.DisplayUpdater {
    private static final String TAG = "FlutterEngine";
    private final AccessibilityChannel accessibilityChannel;
    private final DartExecutor dartExecutor;
    private final DeferredComponentChannel deferredComponentChannel;
    private final EngineLifecycleListener engineLifecycleListener;
    private final Set<EngineLifecycleListener> engineLifecycleListeners;
    private final FlutterJNI flutterJNI;
    private final LifecycleChannel lifecycleChannel;
    private final LocalizationChannel localizationChannel;
    private final LocalizationPlugin localizationPlugin;
    private final MouseCursorChannel mouseCursorChannel;
    private final NavigationChannel navigationChannel;
    private final PlatformChannel platformChannel;
    private final PlatformViewsController platformViewsController;
    private final FlutterEngineConnectionRegistry pluginRegistry;
    private final ProcessTextChannel processTextChannel;
    private final FlutterRenderer renderer;
    private final RestorationChannel restorationChannel;
    private final SettingsChannel settingsChannel;
    private final SpellCheckChannel spellCheckChannel;
    private final SystemChannel systemChannel;
    private final TextInputChannel textInputChannel;

    /* loaded from: classes.dex */
    public interface EngineLifecycleListener {
        void onEngineWillDestroy();

        void onPreEngineRestart();
    }

    public FlutterEngine(Context context) {
        this(context, null);
    }

    public FlutterEngine(Context context, String[] dartVmArgs) {
        this(context, null, null, dartVmArgs, true);
    }

    public FlutterEngine(Context context, String[] dartVmArgs, boolean automaticallyRegisterPlugins) {
        this(context, null, null, dartVmArgs, automaticallyRegisterPlugins);
    }

    public FlutterEngine(Context context, String[] dartVmArgs, boolean automaticallyRegisterPlugins, boolean waitForRestorationData) {
        this(context, null, null, new PlatformViewsController(), dartVmArgs, automaticallyRegisterPlugins, waitForRestorationData);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI) {
        this(context, flutterLoader, flutterJNI, null, true);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI, String[] dartVmArgs, boolean automaticallyRegisterPlugins) {
        this(context, flutterLoader, flutterJNI, new PlatformViewsController(), dartVmArgs, automaticallyRegisterPlugins);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI, PlatformViewsController platformViewsController, String[] dartVmArgs, boolean automaticallyRegisterPlugins) {
        this(context, flutterLoader, flutterJNI, platformViewsController, dartVmArgs, automaticallyRegisterPlugins, false);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI, PlatformViewsController platformViewsController, String[] dartVmArgs, boolean automaticallyRegisterPlugins, boolean waitForRestorationData) {
        this(context, flutterLoader, flutterJNI, platformViewsController, dartVmArgs, automaticallyRegisterPlugins, waitForRestorationData, null);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI, PlatformViewsController platformViewsController, String[] dartVmArgs, boolean automaticallyRegisterPlugins, boolean waitForRestorationData, FlutterEngineGroup group) {
        AssetManager assetManager;
        FlutterJNI flutterJNI2;
        FlutterLoader flutterLoader2;
        this.engineLifecycleListeners = new HashSet();
        this.engineLifecycleListener = new EngineLifecycleListener() { // from class: io.flutter.embedding.engine.FlutterEngine.1
            @Override // io.flutter.embedding.engine.FlutterEngine.EngineLifecycleListener
            public void onPreEngineRestart() {
                Log.v(FlutterEngine.TAG, "onPreEngineRestart()");
                for (EngineLifecycleListener lifecycleListener : FlutterEngine.this.engineLifecycleListeners) {
                    lifecycleListener.onPreEngineRestart();
                }
                FlutterEngine.this.platformViewsController.onPreEngineRestart();
                FlutterEngine.this.restorationChannel.clearData();
            }

            @Override // io.flutter.embedding.engine.FlutterEngine.EngineLifecycleListener
            public void onEngineWillDestroy() {
            }
        };
        try {
            assetManager = context.createPackageContext(context.getPackageName(), 0).getAssets();
        } catch (PackageManager.NameNotFoundException e) {
            assetManager = context.getAssets();
        }
        FlutterInjector injector = FlutterInjector.instance();
        if (flutterJNI != null) {
            flutterJNI2 = flutterJNI;
        } else {
            flutterJNI2 = injector.getFlutterJNIFactory().provideFlutterJNI();
        }
        this.flutterJNI = flutterJNI2;
        DartExecutor dartExecutor = new DartExecutor(flutterJNI2, assetManager);
        this.dartExecutor = dartExecutor;
        dartExecutor.onAttachedToJNI();
        DeferredComponentManager deferredComponentManager = FlutterInjector.instance().deferredComponentManager();
        this.accessibilityChannel = new AccessibilityChannel(dartExecutor, flutterJNI2);
        DeferredComponentChannel deferredComponentChannel = new DeferredComponentChannel(dartExecutor);
        this.deferredComponentChannel = deferredComponentChannel;
        this.lifecycleChannel = new LifecycleChannel(dartExecutor);
        LocalizationChannel localizationChannel = new LocalizationChannel(dartExecutor);
        this.localizationChannel = localizationChannel;
        this.mouseCursorChannel = new MouseCursorChannel(dartExecutor);
        this.navigationChannel = new NavigationChannel(dartExecutor);
        this.platformChannel = new PlatformChannel(dartExecutor);
        this.processTextChannel = new ProcessTextChannel(dartExecutor, context.getPackageManager());
        this.restorationChannel = new RestorationChannel(dartExecutor, waitForRestorationData);
        this.settingsChannel = new SettingsChannel(dartExecutor);
        this.spellCheckChannel = new SpellCheckChannel(dartExecutor);
        this.systemChannel = new SystemChannel(dartExecutor);
        this.textInputChannel = new TextInputChannel(dartExecutor);
        if (deferredComponentManager != null) {
            deferredComponentManager.setDeferredComponentChannel(deferredComponentChannel);
        }
        LocalizationPlugin localizationPlugin = new LocalizationPlugin(context, localizationChannel);
        this.localizationPlugin = localizationPlugin;
        if (flutterLoader != null) {
            flutterLoader2 = flutterLoader;
        } else {
            flutterLoader2 = injector.flutterLoader();
        }
        if (!flutterJNI2.isAttached()) {
            flutterLoader2.startInitialization(context.getApplicationContext());
            flutterLoader2.ensureInitializationComplete(context, dartVmArgs);
        }
        flutterJNI2.addEngineLifecycleListener(this.engineLifecycleListener);
        flutterJNI2.setPlatformViewsController(platformViewsController);
        flutterJNI2.setLocalizationPlugin(localizationPlugin);
        flutterJNI2.setDeferredComponentManager(injector.deferredComponentManager());
        if (!flutterJNI2.isAttached()) {
            attachToJni();
        }
        this.renderer = new FlutterRenderer(flutterJNI2);
        this.platformViewsController = platformViewsController;
        platformViewsController.onAttachedToJNI();
        FlutterEngineConnectionRegistry flutterEngineConnectionRegistry = new FlutterEngineConnectionRegistry(context.getApplicationContext(), this, flutterLoader2, group);
        this.pluginRegistry = flutterEngineConnectionRegistry;
        localizationPlugin.sendLocalesToFlutter(context.getResources().getConfiguration());
        if (automaticallyRegisterPlugins && flutterLoader2.automaticallyRegisterPlugins()) {
            GeneratedPluginRegister.registerGeneratedPlugins(this);
        }
        ViewUtils.calculateMaximumDisplayMetrics(context, this);
        ProcessTextPlugin processTextPlugin = new ProcessTextPlugin(getProcessTextChannel());
        flutterEngineConnectionRegistry.add(processTextPlugin);
    }

    private void attachToJni() {
        Log.v(TAG, "Attaching to JNI.");
        this.flutterJNI.attachToNative();
        if (!isAttachedToJni()) {
            throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
        }
    }

    private boolean isAttachedToJni() {
        return this.flutterJNI.isAttached();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlutterEngine spawn(Context context, DartExecutor.DartEntrypoint dartEntrypoint, String initialRoute, List<String> dartEntrypointArgs, PlatformViewsController platformViewsController, boolean automaticallyRegisterPlugins, boolean waitForRestorationData) {
        if (isAttachedToJni()) {
            FlutterJNI newFlutterJNI = this.flutterJNI.spawn(dartEntrypoint.dartEntrypointFunctionName, dartEntrypoint.dartEntrypointLibrary, initialRoute, dartEntrypointArgs);
            return new FlutterEngine(context, null, newFlutterJNI, platformViewsController, null, automaticallyRegisterPlugins, waitForRestorationData);
        }
        throw new IllegalStateException("Spawn can only be called on a fully constructed FlutterEngine");
    }

    public void destroy() {
        Log.v(TAG, "Destroying.");
        for (EngineLifecycleListener listener : this.engineLifecycleListeners) {
            listener.onEngineWillDestroy();
        }
        this.pluginRegistry.destroy();
        this.platformViewsController.onDetachedFromJNI();
        this.dartExecutor.onDetachedFromJNI();
        this.flutterJNI.removeEngineLifecycleListener(this.engineLifecycleListener);
        this.flutterJNI.setDeferredComponentManager(null);
        this.flutterJNI.detachFromNativeAndReleaseResources();
        if (FlutterInjector.instance().deferredComponentManager() != null) {
            FlutterInjector.instance().deferredComponentManager().destroy();
            this.deferredComponentChannel.setDeferredComponentManager(null);
        }
    }

    public void addEngineLifecycleListener(EngineLifecycleListener listener) {
        this.engineLifecycleListeners.add(listener);
    }

    public void removeEngineLifecycleListener(EngineLifecycleListener listener) {
        this.engineLifecycleListeners.remove(listener);
    }

    public DartExecutor getDartExecutor() {
        return this.dartExecutor;
    }

    public FlutterRenderer getRenderer() {
        return this.renderer;
    }

    public AccessibilityChannel getAccessibilityChannel() {
        return this.accessibilityChannel;
    }

    public LifecycleChannel getLifecycleChannel() {
        return this.lifecycleChannel;
    }

    public LocalizationChannel getLocalizationChannel() {
        return this.localizationChannel;
    }

    public NavigationChannel getNavigationChannel() {
        return this.navigationChannel;
    }

    public PlatformChannel getPlatformChannel() {
        return this.platformChannel;
    }

    public ProcessTextChannel getProcessTextChannel() {
        return this.processTextChannel;
    }

    public RestorationChannel getRestorationChannel() {
        return this.restorationChannel;
    }

    public SettingsChannel getSettingsChannel() {
        return this.settingsChannel;
    }

    public DeferredComponentChannel getDeferredComponentChannel() {
        return this.deferredComponentChannel;
    }

    public SystemChannel getSystemChannel() {
        return this.systemChannel;
    }

    public MouseCursorChannel getMouseCursorChannel() {
        return this.mouseCursorChannel;
    }

    public TextInputChannel getTextInputChannel() {
        return this.textInputChannel;
    }

    public SpellCheckChannel getSpellCheckChannel() {
        return this.spellCheckChannel;
    }

    public PluginRegistry getPlugins() {
        return this.pluginRegistry;
    }

    public LocalizationPlugin getLocalizationPlugin() {
        return this.localizationPlugin;
    }

    public PlatformViewsController getPlatformViewsController() {
        return this.platformViewsController;
    }

    public ActivityControlSurface getActivityControlSurface() {
        return this.pluginRegistry;
    }

    public ServiceControlSurface getServiceControlSurface() {
        return this.pluginRegistry;
    }

    public BroadcastReceiverControlSurface getBroadcastReceiverControlSurface() {
        return this.pluginRegistry;
    }

    public ContentProviderControlSurface getContentProviderControlSurface() {
        return this.pluginRegistry;
    }

    @Override // io.flutter.util.ViewUtils.DisplayUpdater
    public void updateDisplayMetrics(float width, float height, float density) {
        this.flutterJNI.updateDisplayMetrics(0, width, height, density);
    }
}
