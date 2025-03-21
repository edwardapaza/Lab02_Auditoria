package io.flutter.plugins.firebase.core;

import android.util.Log;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class GeneratedAndroidFirebaseCore {

    /* loaded from: classes2.dex */
    public interface Result<T> {
        void error(Throwable th);

        void success(T t);
    }

    /* loaded from: classes2.dex */
    public static class FlutterError extends RuntimeException {
        public final String code;
        public final Object details;

        public FlutterError(String code, String message, Object details) {
            super(message);
            this.code = code;
            this.details = details;
        }
    }

    protected static ArrayList<Object> wrapError(Throwable exception) {
        ArrayList<Object> errorList = new ArrayList<>(3);
        if (exception instanceof FlutterError) {
            FlutterError error = (FlutterError) exception;
            errorList.add(error.code);
            errorList.add(error.getMessage());
            errorList.add(error.details);
        } else {
            errorList.add(exception.toString());
            errorList.add(exception.getClass().getSimpleName());
            errorList.add("Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
        }
        return errorList;
    }

    /* loaded from: classes2.dex */
    public static final class PigeonFirebaseOptions {
        private String androidClientId;
        private String apiKey;
        private String appGroupId;
        private String appId;
        private String authDomain;
        private String databaseURL;
        private String deepLinkURLScheme;
        private String iosBundleId;
        private String iosClientId;
        private String measurementId;
        private String messagingSenderId;
        private String projectId;
        private String storageBucket;
        private String trackingId;

        public String getApiKey() {
            return this.apiKey;
        }

        public void setApiKey(String setterArg) {
            if (setterArg == null) {
                throw new IllegalStateException("Nonnull field \"apiKey\" is null.");
            }
            this.apiKey = setterArg;
        }

        public String getAppId() {
            return this.appId;
        }

        public void setAppId(String setterArg) {
            if (setterArg == null) {
                throw new IllegalStateException("Nonnull field \"appId\" is null.");
            }
            this.appId = setterArg;
        }

        public String getMessagingSenderId() {
            return this.messagingSenderId;
        }

        public void setMessagingSenderId(String setterArg) {
            if (setterArg == null) {
                throw new IllegalStateException("Nonnull field \"messagingSenderId\" is null.");
            }
            this.messagingSenderId = setterArg;
        }

        public String getProjectId() {
            return this.projectId;
        }

        public void setProjectId(String setterArg) {
            if (setterArg == null) {
                throw new IllegalStateException("Nonnull field \"projectId\" is null.");
            }
            this.projectId = setterArg;
        }

        public String getAuthDomain() {
            return this.authDomain;
        }

        public void setAuthDomain(String setterArg) {
            this.authDomain = setterArg;
        }

        public String getDatabaseURL() {
            return this.databaseURL;
        }

        public void setDatabaseURL(String setterArg) {
            this.databaseURL = setterArg;
        }

        public String getStorageBucket() {
            return this.storageBucket;
        }

        public void setStorageBucket(String setterArg) {
            this.storageBucket = setterArg;
        }

        public String getMeasurementId() {
            return this.measurementId;
        }

        public void setMeasurementId(String setterArg) {
            this.measurementId = setterArg;
        }

        public String getTrackingId() {
            return this.trackingId;
        }

        public void setTrackingId(String setterArg) {
            this.trackingId = setterArg;
        }

        public String getDeepLinkURLScheme() {
            return this.deepLinkURLScheme;
        }

        public void setDeepLinkURLScheme(String setterArg) {
            this.deepLinkURLScheme = setterArg;
        }

        public String getAndroidClientId() {
            return this.androidClientId;
        }

        public void setAndroidClientId(String setterArg) {
            this.androidClientId = setterArg;
        }

        public String getIosClientId() {
            return this.iosClientId;
        }

        public void setIosClientId(String setterArg) {
            this.iosClientId = setterArg;
        }

        public String getIosBundleId() {
            return this.iosBundleId;
        }

        public void setIosBundleId(String setterArg) {
            this.iosBundleId = setterArg;
        }

        public String getAppGroupId() {
            return this.appGroupId;
        }

        public void setAppGroupId(String setterArg) {
            this.appGroupId = setterArg;
        }

        PigeonFirebaseOptions() {
        }

        /* loaded from: classes2.dex */
        public static final class Builder {
            private String androidClientId;
            private String apiKey;
            private String appGroupId;
            private String appId;
            private String authDomain;
            private String databaseURL;
            private String deepLinkURLScheme;
            private String iosBundleId;
            private String iosClientId;
            private String measurementId;
            private String messagingSenderId;
            private String projectId;
            private String storageBucket;
            private String trackingId;

            public Builder setApiKey(String setterArg) {
                this.apiKey = setterArg;
                return this;
            }

            public Builder setAppId(String setterArg) {
                this.appId = setterArg;
                return this;
            }

            public Builder setMessagingSenderId(String setterArg) {
                this.messagingSenderId = setterArg;
                return this;
            }

            public Builder setProjectId(String setterArg) {
                this.projectId = setterArg;
                return this;
            }

            public Builder setAuthDomain(String setterArg) {
                this.authDomain = setterArg;
                return this;
            }

            public Builder setDatabaseURL(String setterArg) {
                this.databaseURL = setterArg;
                return this;
            }

            public Builder setStorageBucket(String setterArg) {
                this.storageBucket = setterArg;
                return this;
            }

            public Builder setMeasurementId(String setterArg) {
                this.measurementId = setterArg;
                return this;
            }

            public Builder setTrackingId(String setterArg) {
                this.trackingId = setterArg;
                return this;
            }

            public Builder setDeepLinkURLScheme(String setterArg) {
                this.deepLinkURLScheme = setterArg;
                return this;
            }

            public Builder setAndroidClientId(String setterArg) {
                this.androidClientId = setterArg;
                return this;
            }

            public Builder setIosClientId(String setterArg) {
                this.iosClientId = setterArg;
                return this;
            }

            public Builder setIosBundleId(String setterArg) {
                this.iosBundleId = setterArg;
                return this;
            }

            public Builder setAppGroupId(String setterArg) {
                this.appGroupId = setterArg;
                return this;
            }

            public PigeonFirebaseOptions build() {
                PigeonFirebaseOptions pigeonReturn = new PigeonFirebaseOptions();
                pigeonReturn.setApiKey(this.apiKey);
                pigeonReturn.setAppId(this.appId);
                pigeonReturn.setMessagingSenderId(this.messagingSenderId);
                pigeonReturn.setProjectId(this.projectId);
                pigeonReturn.setAuthDomain(this.authDomain);
                pigeonReturn.setDatabaseURL(this.databaseURL);
                pigeonReturn.setStorageBucket(this.storageBucket);
                pigeonReturn.setMeasurementId(this.measurementId);
                pigeonReturn.setTrackingId(this.trackingId);
                pigeonReturn.setDeepLinkURLScheme(this.deepLinkURLScheme);
                pigeonReturn.setAndroidClientId(this.androidClientId);
                pigeonReturn.setIosClientId(this.iosClientId);
                pigeonReturn.setIosBundleId(this.iosBundleId);
                pigeonReturn.setAppGroupId(this.appGroupId);
                return pigeonReturn;
            }
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> toListResult = new ArrayList<>(14);
            toListResult.add(this.apiKey);
            toListResult.add(this.appId);
            toListResult.add(this.messagingSenderId);
            toListResult.add(this.projectId);
            toListResult.add(this.authDomain);
            toListResult.add(this.databaseURL);
            toListResult.add(this.storageBucket);
            toListResult.add(this.measurementId);
            toListResult.add(this.trackingId);
            toListResult.add(this.deepLinkURLScheme);
            toListResult.add(this.androidClientId);
            toListResult.add(this.iosClientId);
            toListResult.add(this.iosBundleId);
            toListResult.add(this.appGroupId);
            return toListResult;
        }

        static PigeonFirebaseOptions fromList(ArrayList<Object> list) {
            PigeonFirebaseOptions pigeonResult = new PigeonFirebaseOptions();
            Object apiKey = list.get(0);
            pigeonResult.setApiKey((String) apiKey);
            Object appId = list.get(1);
            pigeonResult.setAppId((String) appId);
            Object messagingSenderId = list.get(2);
            pigeonResult.setMessagingSenderId((String) messagingSenderId);
            Object projectId = list.get(3);
            pigeonResult.setProjectId((String) projectId);
            Object authDomain = list.get(4);
            pigeonResult.setAuthDomain((String) authDomain);
            Object databaseURL = list.get(5);
            pigeonResult.setDatabaseURL((String) databaseURL);
            Object storageBucket = list.get(6);
            pigeonResult.setStorageBucket((String) storageBucket);
            Object measurementId = list.get(7);
            pigeonResult.setMeasurementId((String) measurementId);
            Object trackingId = list.get(8);
            pigeonResult.setTrackingId((String) trackingId);
            Object deepLinkURLScheme = list.get(9);
            pigeonResult.setDeepLinkURLScheme((String) deepLinkURLScheme);
            Object androidClientId = list.get(10);
            pigeonResult.setAndroidClientId((String) androidClientId);
            Object iosClientId = list.get(11);
            pigeonResult.setIosClientId((String) iosClientId);
            Object iosBundleId = list.get(12);
            pigeonResult.setIosBundleId((String) iosBundleId);
            Object appGroupId = list.get(13);
            pigeonResult.setAppGroupId((String) appGroupId);
            return pigeonResult;
        }
    }

    /* loaded from: classes2.dex */
    public static final class PigeonInitializeResponse {
        private Boolean isAutomaticDataCollectionEnabled;
        private String name;
        private PigeonFirebaseOptions options;
        private Map<String, Object> pluginConstants;

        public String getName() {
            return this.name;
        }

        public void setName(String setterArg) {
            if (setterArg == null) {
                throw new IllegalStateException("Nonnull field \"name\" is null.");
            }
            this.name = setterArg;
        }

        public PigeonFirebaseOptions getOptions() {
            return this.options;
        }

        public void setOptions(PigeonFirebaseOptions setterArg) {
            if (setterArg == null) {
                throw new IllegalStateException("Nonnull field \"options\" is null.");
            }
            this.options = setterArg;
        }

        public Boolean getIsAutomaticDataCollectionEnabled() {
            return this.isAutomaticDataCollectionEnabled;
        }

        public void setIsAutomaticDataCollectionEnabled(Boolean setterArg) {
            this.isAutomaticDataCollectionEnabled = setterArg;
        }

        public Map<String, Object> getPluginConstants() {
            return this.pluginConstants;
        }

        public void setPluginConstants(Map<String, Object> setterArg) {
            if (setterArg == null) {
                throw new IllegalStateException("Nonnull field \"pluginConstants\" is null.");
            }
            this.pluginConstants = setterArg;
        }

        PigeonInitializeResponse() {
        }

        /* loaded from: classes2.dex */
        public static final class Builder {
            private Boolean isAutomaticDataCollectionEnabled;
            private String name;
            private PigeonFirebaseOptions options;
            private Map<String, Object> pluginConstants;

            public Builder setName(String setterArg) {
                this.name = setterArg;
                return this;
            }

            public Builder setOptions(PigeonFirebaseOptions setterArg) {
                this.options = setterArg;
                return this;
            }

            public Builder setIsAutomaticDataCollectionEnabled(Boolean setterArg) {
                this.isAutomaticDataCollectionEnabled = setterArg;
                return this;
            }

            public Builder setPluginConstants(Map<String, Object> setterArg) {
                this.pluginConstants = setterArg;
                return this;
            }

            public PigeonInitializeResponse build() {
                PigeonInitializeResponse pigeonReturn = new PigeonInitializeResponse();
                pigeonReturn.setName(this.name);
                pigeonReturn.setOptions(this.options);
                pigeonReturn.setIsAutomaticDataCollectionEnabled(this.isAutomaticDataCollectionEnabled);
                pigeonReturn.setPluginConstants(this.pluginConstants);
                return pigeonReturn;
            }
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> toListResult = new ArrayList<>(4);
            toListResult.add(this.name);
            PigeonFirebaseOptions pigeonFirebaseOptions = this.options;
            toListResult.add(pigeonFirebaseOptions == null ? null : pigeonFirebaseOptions.toList());
            toListResult.add(this.isAutomaticDataCollectionEnabled);
            toListResult.add(this.pluginConstants);
            return toListResult;
        }

        static PigeonInitializeResponse fromList(ArrayList<Object> list) {
            PigeonInitializeResponse pigeonResult = new PigeonInitializeResponse();
            Object name = list.get(0);
            pigeonResult.setName((String) name);
            Object options = list.get(1);
            pigeonResult.setOptions(options == null ? null : PigeonFirebaseOptions.fromList((ArrayList) options));
            Object isAutomaticDataCollectionEnabled = list.get(2);
            pigeonResult.setIsAutomaticDataCollectionEnabled((Boolean) isAutomaticDataCollectionEnabled);
            Object pluginConstants = list.get(3);
            pigeonResult.setPluginConstants((Map) pluginConstants);
            return pigeonResult;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class FirebaseCoreHostApiCodec extends StandardMessageCodec {
        public static final FirebaseCoreHostApiCodec INSTANCE = new FirebaseCoreHostApiCodec();

        private FirebaseCoreHostApiCodec() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.flutter.plugin.common.StandardMessageCodec
        public Object readValueOfType(byte type, ByteBuffer buffer) {
            switch (type) {
                case Byte.MIN_VALUE:
                    return PigeonFirebaseOptions.fromList((ArrayList) readValue(buffer));
                case -127:
                    return PigeonInitializeResponse.fromList((ArrayList) readValue(buffer));
                default:
                    return super.readValueOfType(type, buffer);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.flutter.plugin.common.StandardMessageCodec
        public void writeValue(ByteArrayOutputStream stream, Object value) {
            if (value instanceof PigeonFirebaseOptions) {
                stream.write(128);
                writeValue(stream, ((PigeonFirebaseOptions) value).toList());
            } else if (value instanceof PigeonInitializeResponse) {
                stream.write(129);
                writeValue(stream, ((PigeonInitializeResponse) value).toList());
            } else {
                super.writeValue(stream, value);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface FirebaseCoreHostApi {
        void initializeApp(String str, PigeonFirebaseOptions pigeonFirebaseOptions, Result<PigeonInitializeResponse> result);

        void initializeCore(Result<List<PigeonInitializeResponse>> result);

        void optionsFromResource(Result<PigeonFirebaseOptions> result);

        /* renamed from: io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore$FirebaseCoreHostApi$-CC  reason: invalid class name */
        /* loaded from: classes2.dex */
        public final /* synthetic */ class CC {
            public static MessageCodec<Object> getCodec() {
                return FirebaseCoreHostApiCodec.INSTANCE;
            }

            public static void setup(BinaryMessenger binaryMessenger, final FirebaseCoreHostApi api) {
                BasicMessageChannel<Object> channel = new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.FirebaseCoreHostApi.initializeApp", getCodec());
                if (api != null) {
                    channel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore$FirebaseCoreHostApi$$ExternalSyntheticLambda0
                        @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                        public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                            GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.CC.lambda$setup$0(GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.this, obj, reply);
                        }
                    });
                } else {
                    channel.setMessageHandler(null);
                }
                BasicMessageChannel<Object> channel2 = new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.FirebaseCoreHostApi.initializeCore", getCodec());
                if (api != null) {
                    channel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore$FirebaseCoreHostApi$$ExternalSyntheticLambda1
                        @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                        public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                            GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.CC.lambda$setup$1(GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.this, obj, reply);
                        }
                    });
                } else {
                    channel2.setMessageHandler(null);
                }
                BasicMessageChannel<Object> channel3 = new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.FirebaseCoreHostApi.optionsFromResource", getCodec());
                if (api != null) {
                    channel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore$FirebaseCoreHostApi$$ExternalSyntheticLambda2
                        @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                        public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                            GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.CC.lambda$setup$2(GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.this, obj, reply);
                        }
                    });
                } else {
                    channel3.setMessageHandler(null);
                }
            }

            public static /* synthetic */ void lambda$setup$0(FirebaseCoreHostApi api, Object message, final BasicMessageChannel.Reply reply) {
                final ArrayList<Object> wrapped = new ArrayList<>();
                ArrayList<Object> args = (ArrayList) message;
                String appNameArg = (String) args.get(0);
                PigeonFirebaseOptions initializeAppRequestArg = (PigeonFirebaseOptions) args.get(1);
                Result<PigeonInitializeResponse> resultCallback = new Result<PigeonInitializeResponse>() { // from class: io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.1
                    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.Result
                    public void success(PigeonInitializeResponse result) {
                        wrapped.add(0, result);
                        reply.reply(wrapped);
                    }

                    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.Result
                    public void error(Throwable error) {
                        ArrayList<Object> wrappedError = GeneratedAndroidFirebaseCore.wrapError(error);
                        reply.reply(wrappedError);
                    }
                };
                api.initializeApp(appNameArg, initializeAppRequestArg, resultCallback);
            }

            public static /* synthetic */ void lambda$setup$1(FirebaseCoreHostApi api, Object message, final BasicMessageChannel.Reply reply) {
                final ArrayList<Object> wrapped = new ArrayList<>();
                Result<List<PigeonInitializeResponse>> resultCallback = new Result<List<PigeonInitializeResponse>>() { // from class: io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.2
                    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.Result
                    public void success(List<PigeonInitializeResponse> result) {
                        wrapped.add(0, result);
                        reply.reply(wrapped);
                    }

                    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.Result
                    public void error(Throwable error) {
                        ArrayList<Object> wrappedError = GeneratedAndroidFirebaseCore.wrapError(error);
                        reply.reply(wrappedError);
                    }
                };
                api.initializeCore(resultCallback);
            }

            public static /* synthetic */ void lambda$setup$2(FirebaseCoreHostApi api, Object message, final BasicMessageChannel.Reply reply) {
                final ArrayList<Object> wrapped = new ArrayList<>();
                Result<PigeonFirebaseOptions> resultCallback = new Result<PigeonFirebaseOptions>() { // from class: io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.3
                    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.Result
                    public void success(PigeonFirebaseOptions result) {
                        wrapped.add(0, result);
                        reply.reply(wrapped);
                    }

                    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.Result
                    public void error(Throwable error) {
                        ArrayList<Object> wrappedError = GeneratedAndroidFirebaseCore.wrapError(error);
                        reply.reply(wrappedError);
                    }
                };
                api.optionsFromResource(resultCallback);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface FirebaseAppHostApi {
        void delete(String str, Result<Void> result);

        void setAutomaticDataCollectionEnabled(String str, Boolean bool, Result<Void> result);

        void setAutomaticResourceManagementEnabled(String str, Boolean bool, Result<Void> result);

        /* renamed from: io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore$FirebaseAppHostApi$-CC  reason: invalid class name */
        /* loaded from: classes2.dex */
        public final /* synthetic */ class CC {
            public static MessageCodec<Object> getCodec() {
                return new StandardMessageCodec();
            }

            public static void setup(BinaryMessenger binaryMessenger, final FirebaseAppHostApi api) {
                BasicMessageChannel<Object> channel = new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.FirebaseAppHostApi.setAutomaticDataCollectionEnabled", getCodec());
                if (api != null) {
                    channel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore$FirebaseAppHostApi$$ExternalSyntheticLambda0
                        @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                        public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                            GeneratedAndroidFirebaseCore.FirebaseAppHostApi.CC.lambda$setup$0(GeneratedAndroidFirebaseCore.FirebaseAppHostApi.this, obj, reply);
                        }
                    });
                } else {
                    channel.setMessageHandler(null);
                }
                BasicMessageChannel<Object> channel2 = new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.FirebaseAppHostApi.setAutomaticResourceManagementEnabled", getCodec());
                if (api != null) {
                    channel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore$FirebaseAppHostApi$$ExternalSyntheticLambda1
                        @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                        public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                            GeneratedAndroidFirebaseCore.FirebaseAppHostApi.CC.lambda$setup$1(GeneratedAndroidFirebaseCore.FirebaseAppHostApi.this, obj, reply);
                        }
                    });
                } else {
                    channel2.setMessageHandler(null);
                }
                BasicMessageChannel<Object> channel3 = new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.FirebaseAppHostApi.delete", getCodec());
                if (api != null) {
                    channel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore$FirebaseAppHostApi$$ExternalSyntheticLambda2
                        @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                        public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                            GeneratedAndroidFirebaseCore.FirebaseAppHostApi.CC.lambda$setup$2(GeneratedAndroidFirebaseCore.FirebaseAppHostApi.this, obj, reply);
                        }
                    });
                } else {
                    channel3.setMessageHandler(null);
                }
            }

            public static /* synthetic */ void lambda$setup$0(FirebaseAppHostApi api, Object message, final BasicMessageChannel.Reply reply) {
                final ArrayList<Object> wrapped = new ArrayList<>();
                ArrayList<Object> args = (ArrayList) message;
                String appNameArg = (String) args.get(0);
                Boolean enabledArg = (Boolean) args.get(1);
                Result<Void> resultCallback = new Result<Void>() { // from class: io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseAppHostApi.1
                    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.Result
                    public void success(Void result) {
                        wrapped.add(0, null);
                        reply.reply(wrapped);
                    }

                    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.Result
                    public void error(Throwable error) {
                        ArrayList<Object> wrappedError = GeneratedAndroidFirebaseCore.wrapError(error);
                        reply.reply(wrappedError);
                    }
                };
                api.setAutomaticDataCollectionEnabled(appNameArg, enabledArg, resultCallback);
            }

            public static /* synthetic */ void lambda$setup$1(FirebaseAppHostApi api, Object message, final BasicMessageChannel.Reply reply) {
                final ArrayList<Object> wrapped = new ArrayList<>();
                ArrayList<Object> args = (ArrayList) message;
                String appNameArg = (String) args.get(0);
                Boolean enabledArg = (Boolean) args.get(1);
                Result<Void> resultCallback = new Result<Void>() { // from class: io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseAppHostApi.2
                    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.Result
                    public void success(Void result) {
                        wrapped.add(0, null);
                        reply.reply(wrapped);
                    }

                    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.Result
                    public void error(Throwable error) {
                        ArrayList<Object> wrappedError = GeneratedAndroidFirebaseCore.wrapError(error);
                        reply.reply(wrappedError);
                    }
                };
                api.setAutomaticResourceManagementEnabled(appNameArg, enabledArg, resultCallback);
            }

            public static /* synthetic */ void lambda$setup$2(FirebaseAppHostApi api, Object message, final BasicMessageChannel.Reply reply) {
                final ArrayList<Object> wrapped = new ArrayList<>();
                ArrayList<Object> args = (ArrayList) message;
                String appNameArg = (String) args.get(0);
                Result<Void> resultCallback = new Result<Void>() { // from class: io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseAppHostApi.3
                    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.Result
                    public void success(Void result) {
                        wrapped.add(0, null);
                        reply.reply(wrapped);
                    }

                    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.Result
                    public void error(Throwable error) {
                        ArrayList<Object> wrappedError = GeneratedAndroidFirebaseCore.wrapError(error);
                        reply.reply(wrappedError);
                    }
                };
                api.delete(appNameArg, resultCallback);
            }
        }
    }
}
