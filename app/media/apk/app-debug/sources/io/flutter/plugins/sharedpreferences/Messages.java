package io.flutter.plugins.sharedpreferences;

import android.util.Log;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.sharedpreferences.Messages;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class Messages {

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
    public interface SharedPreferencesApi {
        Boolean clear(String str, List<String> list);

        Map<String, Object> getAll(String str, List<String> list);

        Boolean remove(String str);

        Boolean setBool(String str, Boolean bool);

        Boolean setDouble(String str, Double d);

        Boolean setInt(String str, Long l);

        Boolean setString(String str, String str2);

        Boolean setStringList(String str, List<String> list);

        /* renamed from: io.flutter.plugins.sharedpreferences.Messages$SharedPreferencesApi$-CC  reason: invalid class name */
        /* loaded from: classes2.dex */
        public final /* synthetic */ class CC {
            public static MessageCodec<Object> getCodec() {
                return new StandardMessageCodec();
            }

            public static void setup(BinaryMessenger binaryMessenger, final SharedPreferencesApi api) {
                BinaryMessenger.TaskQueue taskQueue = binaryMessenger.makeBackgroundTaskQueue();
                BasicMessageChannel<Object> channel = new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.remove", getCodec(), taskQueue);
                if (api != null) {
                    channel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.sharedpreferences.Messages$SharedPreferencesApi$$ExternalSyntheticLambda0
                        @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                        public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                            Messages.SharedPreferencesApi.CC.lambda$setup$0(Messages.SharedPreferencesApi.this, obj, reply);
                        }
                    });
                } else {
                    channel.setMessageHandler(null);
                }
                BinaryMessenger.TaskQueue taskQueue2 = binaryMessenger.makeBackgroundTaskQueue();
                BasicMessageChannel<Object> channel2 = new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.setBool", getCodec(), taskQueue2);
                if (api != null) {
                    channel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.sharedpreferences.Messages$SharedPreferencesApi$$ExternalSyntheticLambda1
                        @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                        public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                            Messages.SharedPreferencesApi.CC.lambda$setup$1(Messages.SharedPreferencesApi.this, obj, reply);
                        }
                    });
                } else {
                    channel2.setMessageHandler(null);
                }
                BinaryMessenger.TaskQueue taskQueue3 = binaryMessenger.makeBackgroundTaskQueue();
                BasicMessageChannel<Object> channel3 = new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.setString", getCodec(), taskQueue3);
                if (api != null) {
                    channel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.sharedpreferences.Messages$SharedPreferencesApi$$ExternalSyntheticLambda2
                        @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                        public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                            Messages.SharedPreferencesApi.CC.lambda$setup$2(Messages.SharedPreferencesApi.this, obj, reply);
                        }
                    });
                } else {
                    channel3.setMessageHandler(null);
                }
                BinaryMessenger.TaskQueue taskQueue4 = binaryMessenger.makeBackgroundTaskQueue();
                BasicMessageChannel<Object> channel4 = new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.setInt", getCodec(), taskQueue4);
                if (api != null) {
                    channel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.sharedpreferences.Messages$SharedPreferencesApi$$ExternalSyntheticLambda3
                        @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                        public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                            Messages.SharedPreferencesApi.CC.lambda$setup$3(Messages.SharedPreferencesApi.this, obj, reply);
                        }
                    });
                } else {
                    channel4.setMessageHandler(null);
                }
                BinaryMessenger.TaskQueue taskQueue5 = binaryMessenger.makeBackgroundTaskQueue();
                BasicMessageChannel<Object> channel5 = new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.setDouble", getCodec(), taskQueue5);
                if (api != null) {
                    channel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.sharedpreferences.Messages$SharedPreferencesApi$$ExternalSyntheticLambda4
                        @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                        public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                            Messages.SharedPreferencesApi.CC.lambda$setup$4(Messages.SharedPreferencesApi.this, obj, reply);
                        }
                    });
                } else {
                    channel5.setMessageHandler(null);
                }
                BinaryMessenger.TaskQueue taskQueue6 = binaryMessenger.makeBackgroundTaskQueue();
                BasicMessageChannel<Object> channel6 = new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.setStringList", getCodec(), taskQueue6);
                if (api != null) {
                    channel6.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.sharedpreferences.Messages$SharedPreferencesApi$$ExternalSyntheticLambda5
                        @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                        public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                            Messages.SharedPreferencesApi.CC.lambda$setup$5(Messages.SharedPreferencesApi.this, obj, reply);
                        }
                    });
                } else {
                    channel6.setMessageHandler(null);
                }
                BinaryMessenger.TaskQueue taskQueue7 = binaryMessenger.makeBackgroundTaskQueue();
                BasicMessageChannel<Object> channel7 = new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.clear", getCodec(), taskQueue7);
                if (api != null) {
                    channel7.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.sharedpreferences.Messages$SharedPreferencesApi$$ExternalSyntheticLambda6
                        @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                        public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                            Messages.SharedPreferencesApi.CC.lambda$setup$6(Messages.SharedPreferencesApi.this, obj, reply);
                        }
                    });
                } else {
                    channel7.setMessageHandler(null);
                }
                BinaryMessenger.TaskQueue taskQueue8 = binaryMessenger.makeBackgroundTaskQueue();
                BasicMessageChannel<Object> channel8 = new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.getAll", getCodec(), taskQueue8);
                if (api != null) {
                    channel8.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.sharedpreferences.Messages$SharedPreferencesApi$$ExternalSyntheticLambda7
                        @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                        public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                            Messages.SharedPreferencesApi.CC.lambda$setup$7(Messages.SharedPreferencesApi.this, obj, reply);
                        }
                    });
                } else {
                    channel8.setMessageHandler(null);
                }
            }

            public static /* synthetic */ void lambda$setup$0(SharedPreferencesApi api, Object message, BasicMessageChannel.Reply reply) {
                ArrayList<Object> wrapped = new ArrayList<>();
                ArrayList<Object> args = (ArrayList) message;
                String keyArg = (String) args.get(0);
                try {
                    Boolean output = api.remove(keyArg);
                    wrapped.add(0, output);
                } catch (Throwable exception) {
                    ArrayList<Object> wrappedError = Messages.wrapError(exception);
                    wrapped = wrappedError;
                }
                reply.reply(wrapped);
            }

            public static /* synthetic */ void lambda$setup$1(SharedPreferencesApi api, Object message, BasicMessageChannel.Reply reply) {
                ArrayList<Object> wrapped = new ArrayList<>();
                ArrayList<Object> args = (ArrayList) message;
                String keyArg = (String) args.get(0);
                Boolean valueArg = (Boolean) args.get(1);
                try {
                    Boolean output = api.setBool(keyArg, valueArg);
                    wrapped.add(0, output);
                } catch (Throwable exception) {
                    ArrayList<Object> wrappedError = Messages.wrapError(exception);
                    wrapped = wrappedError;
                }
                reply.reply(wrapped);
            }

            public static /* synthetic */ void lambda$setup$2(SharedPreferencesApi api, Object message, BasicMessageChannel.Reply reply) {
                ArrayList<Object> wrapped = new ArrayList<>();
                ArrayList<Object> args = (ArrayList) message;
                String keyArg = (String) args.get(0);
                String valueArg = (String) args.get(1);
                try {
                    Boolean output = api.setString(keyArg, valueArg);
                    wrapped.add(0, output);
                } catch (Throwable exception) {
                    ArrayList<Object> wrappedError = Messages.wrapError(exception);
                    wrapped = wrappedError;
                }
                reply.reply(wrapped);
            }

            public static /* synthetic */ void lambda$setup$3(SharedPreferencesApi api, Object message, BasicMessageChannel.Reply reply) {
                Long valueOf;
                ArrayList<Object> wrapped = new ArrayList<>();
                ArrayList<Object> args = (ArrayList) message;
                String keyArg = (String) args.get(0);
                Number valueArg = (Number) args.get(1);
                if (valueArg == null) {
                    valueOf = null;
                } else {
                    try {
                        valueOf = Long.valueOf(valueArg.longValue());
                    } catch (Throwable exception) {
                        ArrayList<Object> wrappedError = Messages.wrapError(exception);
                        wrapped = wrappedError;
                    }
                }
                Boolean output = api.setInt(keyArg, valueOf);
                wrapped.add(0, output);
                reply.reply(wrapped);
            }

            public static /* synthetic */ void lambda$setup$4(SharedPreferencesApi api, Object message, BasicMessageChannel.Reply reply) {
                ArrayList<Object> wrapped = new ArrayList<>();
                ArrayList<Object> args = (ArrayList) message;
                String keyArg = (String) args.get(0);
                Double valueArg = (Double) args.get(1);
                try {
                    Boolean output = api.setDouble(keyArg, valueArg);
                    wrapped.add(0, output);
                } catch (Throwable exception) {
                    ArrayList<Object> wrappedError = Messages.wrapError(exception);
                    wrapped = wrappedError;
                }
                reply.reply(wrapped);
            }

            public static /* synthetic */ void lambda$setup$5(SharedPreferencesApi api, Object message, BasicMessageChannel.Reply reply) {
                ArrayList<Object> wrapped = new ArrayList<>();
                ArrayList<Object> args = (ArrayList) message;
                String keyArg = (String) args.get(0);
                List<String> valueArg = (List) args.get(1);
                try {
                    Boolean output = api.setStringList(keyArg, valueArg);
                    wrapped.add(0, output);
                } catch (Throwable exception) {
                    ArrayList<Object> wrappedError = Messages.wrapError(exception);
                    wrapped = wrappedError;
                }
                reply.reply(wrapped);
            }

            public static /* synthetic */ void lambda$setup$6(SharedPreferencesApi api, Object message, BasicMessageChannel.Reply reply) {
                ArrayList<Object> wrapped = new ArrayList<>();
                ArrayList<Object> args = (ArrayList) message;
                String prefixArg = (String) args.get(0);
                List<String> allowListArg = (List) args.get(1);
                try {
                    Boolean output = api.clear(prefixArg, allowListArg);
                    wrapped.add(0, output);
                } catch (Throwable exception) {
                    ArrayList<Object> wrappedError = Messages.wrapError(exception);
                    wrapped = wrappedError;
                }
                reply.reply(wrapped);
            }

            public static /* synthetic */ void lambda$setup$7(SharedPreferencesApi api, Object message, BasicMessageChannel.Reply reply) {
                ArrayList<Object> wrapped = new ArrayList<>();
                ArrayList<Object> args = (ArrayList) message;
                String prefixArg = (String) args.get(0);
                List<String> allowListArg = (List) args.get(1);
                try {
                    Map<String, Object> output = api.getAll(prefixArg, allowListArg);
                    wrapped.add(0, output);
                } catch (Throwable exception) {
                    ArrayList<Object> wrappedError = Messages.wrapError(exception);
                    wrapped = wrappedError;
                }
                reply.reply(wrapped);
            }
        }
    }
}
