package io.flutter.plugin.common;

import io.flutter.Log;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class BasicMessageChannel<T> {
    public static final String CHANNEL_BUFFERS_CHANNEL = "dev.flutter/channel-buffers";
    private static final String TAG = "BasicMessageChannel#";
    private final MessageCodec<T> codec;
    private final BinaryMessenger messenger;
    private final String name;
    private final BinaryMessenger.TaskQueue taskQueue;

    /* loaded from: classes.dex */
    public interface MessageHandler<T> {
        void onMessage(T t, Reply<T> reply);
    }

    /* loaded from: classes.dex */
    public interface Reply<T> {
        void reply(T t);
    }

    public BasicMessageChannel(BinaryMessenger messenger, String name, MessageCodec<T> codec) {
        this(messenger, name, codec, null);
    }

    public BasicMessageChannel(BinaryMessenger messenger, String name, MessageCodec<T> codec, BinaryMessenger.TaskQueue taskQueue) {
        if (messenger == null) {
            Log.e(TAG, "Parameter messenger must not be null.");
        }
        if (name == null) {
            Log.e(TAG, "Parameter name must not be null.");
        }
        if (codec == null) {
            Log.e(TAG, "Parameter codec must not be null.");
        }
        this.messenger = messenger;
        this.name = name;
        this.codec = codec;
        this.taskQueue = taskQueue;
    }

    public void send(T message) {
        send(message, null);
    }

    public void send(T message, Reply<T> callback) {
        this.messenger.send(this.name, this.codec.encodeMessage(message), callback != null ? new IncomingReplyHandler(callback) : null);
    }

    public void setMessageHandler(MessageHandler<T> handler) {
        if (this.taskQueue != null) {
            this.messenger.setMessageHandler(this.name, handler != null ? new IncomingMessageHandler(handler) : null, this.taskQueue);
        } else {
            this.messenger.setMessageHandler(this.name, handler != null ? new IncomingMessageHandler(handler) : null);
        }
    }

    public void resizeChannelBuffer(int newSize) {
        resizeChannelBuffer(this.messenger, this.name, newSize);
    }

    public void setWarnsOnChannelOverflow(boolean warns) {
        setWarnsOnChannelOverflow(this.messenger, this.name, warns);
    }

    private static ByteBuffer packetFromEncodedMessage(ByteBuffer message) {
        message.flip();
        byte[] bytes = new byte[message.remaining()];
        message.get(bytes);
        ByteBuffer packet = ByteBuffer.allocateDirect(bytes.length);
        packet.put(bytes);
        return packet;
    }

    public static void resizeChannelBuffer(BinaryMessenger messenger, String channel, int newSize) {
        StandardMethodCodec codec = StandardMethodCodec.INSTANCE;
        Object[] arguments = {channel, Integer.valueOf(newSize)};
        MethodCall methodCall = new MethodCall("resize", Arrays.asList(arguments));
        ByteBuffer message = codec.encodeMethodCall(methodCall);
        ByteBuffer packet = packetFromEncodedMessage(message);
        messenger.send(CHANNEL_BUFFERS_CHANNEL, packet);
    }

    public static void setWarnsOnChannelOverflow(BinaryMessenger messenger, String channel, boolean warns) {
        StandardMethodCodec codec = StandardMethodCodec.INSTANCE;
        Object[] arguments = {channel, Boolean.valueOf(!warns)};
        MethodCall methodCall = new MethodCall("overflow", Arrays.asList(arguments));
        ByteBuffer message = codec.encodeMethodCall(methodCall);
        ByteBuffer packet = packetFromEncodedMessage(message);
        messenger.send(CHANNEL_BUFFERS_CHANNEL, packet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class IncomingReplyHandler implements BinaryMessenger.BinaryReply {
        private final Reply<T> callback;

        private IncomingReplyHandler(Reply<T> callback) {
            this.callback = callback;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryReply
        public void reply(ByteBuffer reply) {
            try {
                this.callback.reply(BasicMessageChannel.this.codec.decodeMessage(reply));
            } catch (RuntimeException e) {
                Log.e(BasicMessageChannel.TAG + BasicMessageChannel.this.name, "Failed to handle message reply", e);
            }
        }
    }

    /* loaded from: classes.dex */
    private final class IncomingMessageHandler implements BinaryMessenger.BinaryMessageHandler {
        private final MessageHandler<T> handler;

        private IncomingMessageHandler(MessageHandler<T> handler) {
            this.handler = handler;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler
        public void onMessage(ByteBuffer message, final BinaryMessenger.BinaryReply callback) {
            try {
                this.handler.onMessage(BasicMessageChannel.this.codec.decodeMessage(message), new Reply<T>() { // from class: io.flutter.plugin.common.BasicMessageChannel.IncomingMessageHandler.1
                    @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                    public void reply(T reply) {
                        callback.reply(BasicMessageChannel.this.codec.encodeMessage(reply));
                    }
                });
            } catch (RuntimeException e) {
                Log.e(BasicMessageChannel.TAG + BasicMessageChannel.this.name, "Failed to handle message", e);
                callback.reply(null);
            }
        }
    }
}
