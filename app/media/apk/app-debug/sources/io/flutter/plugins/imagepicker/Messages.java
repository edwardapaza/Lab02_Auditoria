package io.flutter.plugins.imagepicker;

import android.util.Log;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.imagepicker.Messages;
import java.io.ByteArrayOutputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class Messages {

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    @interface CanIgnoreReturnValue {
    }

    /* loaded from: classes2.dex */
    public interface NullableResult<T> {
        void error(Throwable th);

        void success(T t);
    }

    /* loaded from: classes2.dex */
    public interface Result<T> {
        void error(Throwable th);

        void success(T t);
    }

    /* loaded from: classes2.dex */
    public interface VoidResult {
        void error(Throwable th);

        void success();
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
    public enum SourceCamera {
        REAR(0),
        FRONT(1);
        
        final int index;

        SourceCamera(int index) {
            this.index = index;
        }
    }

    /* loaded from: classes2.dex */
    public enum SourceType {
        CAMERA(0),
        GALLERY(1);
        
        final int index;

        SourceType(int index) {
            this.index = index;
        }
    }

    /* loaded from: classes2.dex */
    public enum CacheRetrievalType {
        IMAGE(0),
        VIDEO(1);
        
        final int index;

        CacheRetrievalType(int index) {
            this.index = index;
        }
    }

    /* loaded from: classes2.dex */
    public static final class GeneralOptions {
        private Boolean allowMultiple;
        private Long limit;
        private Boolean usePhotoPicker;

        public Boolean getAllowMultiple() {
            return this.allowMultiple;
        }

        public void setAllowMultiple(Boolean setterArg) {
            if (setterArg == null) {
                throw new IllegalStateException("Nonnull field \"allowMultiple\" is null.");
            }
            this.allowMultiple = setterArg;
        }

        public Boolean getUsePhotoPicker() {
            return this.usePhotoPicker;
        }

        public void setUsePhotoPicker(Boolean setterArg) {
            if (setterArg == null) {
                throw new IllegalStateException("Nonnull field \"usePhotoPicker\" is null.");
            }
            this.usePhotoPicker = setterArg;
        }

        public Long getLimit() {
            return this.limit;
        }

        public void setLimit(Long setterArg) {
            this.limit = setterArg;
        }

        GeneralOptions() {
        }

        /* loaded from: classes2.dex */
        public static final class Builder {
            private Boolean allowMultiple;
            private Long limit;
            private Boolean usePhotoPicker;

            public Builder setAllowMultiple(Boolean setterArg) {
                this.allowMultiple = setterArg;
                return this;
            }

            public Builder setUsePhotoPicker(Boolean setterArg) {
                this.usePhotoPicker = setterArg;
                return this;
            }

            public Builder setLimit(Long setterArg) {
                this.limit = setterArg;
                return this;
            }

            public GeneralOptions build() {
                GeneralOptions pigeonReturn = new GeneralOptions();
                pigeonReturn.setAllowMultiple(this.allowMultiple);
                pigeonReturn.setUsePhotoPicker(this.usePhotoPicker);
                pigeonReturn.setLimit(this.limit);
                return pigeonReturn;
            }
        }

        ArrayList<Object> toList() {
            ArrayList<Object> toListResult = new ArrayList<>(3);
            toListResult.add(this.allowMultiple);
            toListResult.add(this.usePhotoPicker);
            toListResult.add(this.limit);
            return toListResult;
        }

        static GeneralOptions fromList(ArrayList<Object> list) {
            Long valueOf;
            GeneralOptions pigeonResult = new GeneralOptions();
            Object allowMultiple = list.get(0);
            pigeonResult.setAllowMultiple((Boolean) allowMultiple);
            Object usePhotoPicker = list.get(1);
            pigeonResult.setUsePhotoPicker((Boolean) usePhotoPicker);
            Object limit = list.get(2);
            if (limit == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(limit instanceof Integer ? ((Integer) limit).intValue() : ((Long) limit).longValue());
            }
            pigeonResult.setLimit(valueOf);
            return pigeonResult;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ImageSelectionOptions {
        private Double maxHeight;
        private Double maxWidth;
        private Long quality;

        public Double getMaxWidth() {
            return this.maxWidth;
        }

        public void setMaxWidth(Double setterArg) {
            this.maxWidth = setterArg;
        }

        public Double getMaxHeight() {
            return this.maxHeight;
        }

        public void setMaxHeight(Double setterArg) {
            this.maxHeight = setterArg;
        }

        public Long getQuality() {
            return this.quality;
        }

        public void setQuality(Long setterArg) {
            if (setterArg == null) {
                throw new IllegalStateException("Nonnull field \"quality\" is null.");
            }
            this.quality = setterArg;
        }

        ImageSelectionOptions() {
        }

        /* loaded from: classes2.dex */
        public static final class Builder {
            private Double maxHeight;
            private Double maxWidth;
            private Long quality;

            public Builder setMaxWidth(Double setterArg) {
                this.maxWidth = setterArg;
                return this;
            }

            public Builder setMaxHeight(Double setterArg) {
                this.maxHeight = setterArg;
                return this;
            }

            public Builder setQuality(Long setterArg) {
                this.quality = setterArg;
                return this;
            }

            public ImageSelectionOptions build() {
                ImageSelectionOptions pigeonReturn = new ImageSelectionOptions();
                pigeonReturn.setMaxWidth(this.maxWidth);
                pigeonReturn.setMaxHeight(this.maxHeight);
                pigeonReturn.setQuality(this.quality);
                return pigeonReturn;
            }
        }

        ArrayList<Object> toList() {
            ArrayList<Object> toListResult = new ArrayList<>(3);
            toListResult.add(this.maxWidth);
            toListResult.add(this.maxHeight);
            toListResult.add(this.quality);
            return toListResult;
        }

        static ImageSelectionOptions fromList(ArrayList<Object> list) {
            Long valueOf;
            ImageSelectionOptions pigeonResult = new ImageSelectionOptions();
            Object maxWidth = list.get(0);
            pigeonResult.setMaxWidth((Double) maxWidth);
            Object maxHeight = list.get(1);
            pigeonResult.setMaxHeight((Double) maxHeight);
            Object quality = list.get(2);
            if (quality == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(quality instanceof Integer ? ((Integer) quality).intValue() : ((Long) quality).longValue());
            }
            pigeonResult.setQuality(valueOf);
            return pigeonResult;
        }
    }

    /* loaded from: classes2.dex */
    public static final class MediaSelectionOptions {
        private ImageSelectionOptions imageSelectionOptions;

        public ImageSelectionOptions getImageSelectionOptions() {
            return this.imageSelectionOptions;
        }

        public void setImageSelectionOptions(ImageSelectionOptions setterArg) {
            if (setterArg == null) {
                throw new IllegalStateException("Nonnull field \"imageSelectionOptions\" is null.");
            }
            this.imageSelectionOptions = setterArg;
        }

        MediaSelectionOptions() {
        }

        /* loaded from: classes2.dex */
        public static final class Builder {
            private ImageSelectionOptions imageSelectionOptions;

            public Builder setImageSelectionOptions(ImageSelectionOptions setterArg) {
                this.imageSelectionOptions = setterArg;
                return this;
            }

            public MediaSelectionOptions build() {
                MediaSelectionOptions pigeonReturn = new MediaSelectionOptions();
                pigeonReturn.setImageSelectionOptions(this.imageSelectionOptions);
                return pigeonReturn;
            }
        }

        ArrayList<Object> toList() {
            ArrayList<Object> toListResult = new ArrayList<>(1);
            ImageSelectionOptions imageSelectionOptions = this.imageSelectionOptions;
            toListResult.add(imageSelectionOptions == null ? null : imageSelectionOptions.toList());
            return toListResult;
        }

        static MediaSelectionOptions fromList(ArrayList<Object> list) {
            ImageSelectionOptions fromList;
            MediaSelectionOptions pigeonResult = new MediaSelectionOptions();
            Object imageSelectionOptions = list.get(0);
            if (imageSelectionOptions == null) {
                fromList = null;
            } else {
                fromList = ImageSelectionOptions.fromList((ArrayList) imageSelectionOptions);
            }
            pigeonResult.setImageSelectionOptions(fromList);
            return pigeonResult;
        }
    }

    /* loaded from: classes2.dex */
    public static final class VideoSelectionOptions {
        private Long maxDurationSeconds;

        public Long getMaxDurationSeconds() {
            return this.maxDurationSeconds;
        }

        public void setMaxDurationSeconds(Long setterArg) {
            this.maxDurationSeconds = setterArg;
        }

        /* loaded from: classes2.dex */
        public static final class Builder {
            private Long maxDurationSeconds;

            public Builder setMaxDurationSeconds(Long setterArg) {
                this.maxDurationSeconds = setterArg;
                return this;
            }

            public VideoSelectionOptions build() {
                VideoSelectionOptions pigeonReturn = new VideoSelectionOptions();
                pigeonReturn.setMaxDurationSeconds(this.maxDurationSeconds);
                return pigeonReturn;
            }
        }

        ArrayList<Object> toList() {
            ArrayList<Object> toListResult = new ArrayList<>(1);
            toListResult.add(this.maxDurationSeconds);
            return toListResult;
        }

        static VideoSelectionOptions fromList(ArrayList<Object> list) {
            long longValue;
            Long valueOf;
            VideoSelectionOptions pigeonResult = new VideoSelectionOptions();
            Object maxDurationSeconds = list.get(0);
            if (maxDurationSeconds == null) {
                valueOf = null;
            } else {
                if (maxDurationSeconds instanceof Integer) {
                    longValue = ((Integer) maxDurationSeconds).intValue();
                } else {
                    longValue = ((Long) maxDurationSeconds).longValue();
                }
                valueOf = Long.valueOf(longValue);
            }
            pigeonResult.setMaxDurationSeconds(valueOf);
            return pigeonResult;
        }
    }

    /* loaded from: classes2.dex */
    public static final class SourceSpecification {
        private SourceCamera camera;
        private SourceType type;

        public SourceType getType() {
            return this.type;
        }

        public void setType(SourceType setterArg) {
            if (setterArg == null) {
                throw new IllegalStateException("Nonnull field \"type\" is null.");
            }
            this.type = setterArg;
        }

        public SourceCamera getCamera() {
            return this.camera;
        }

        public void setCamera(SourceCamera setterArg) {
            this.camera = setterArg;
        }

        SourceSpecification() {
        }

        /* loaded from: classes2.dex */
        public static final class Builder {
            private SourceCamera camera;
            private SourceType type;

            public Builder setType(SourceType setterArg) {
                this.type = setterArg;
                return this;
            }

            public Builder setCamera(SourceCamera setterArg) {
                this.camera = setterArg;
                return this;
            }

            public SourceSpecification build() {
                SourceSpecification pigeonReturn = new SourceSpecification();
                pigeonReturn.setType(this.type);
                pigeonReturn.setCamera(this.camera);
                return pigeonReturn;
            }
        }

        ArrayList<Object> toList() {
            ArrayList<Object> toListResult = new ArrayList<>(2);
            SourceType sourceType = this.type;
            toListResult.add(sourceType == null ? null : Integer.valueOf(sourceType.index));
            SourceCamera sourceCamera = this.camera;
            toListResult.add(sourceCamera != null ? Integer.valueOf(sourceCamera.index) : null);
            return toListResult;
        }

        static SourceSpecification fromList(ArrayList<Object> list) {
            SourceSpecification pigeonResult = new SourceSpecification();
            Object type = list.get(0);
            pigeonResult.setType(SourceType.values()[((Integer) type).intValue()]);
            Object camera = list.get(1);
            pigeonResult.setCamera(camera == null ? null : SourceCamera.values()[((Integer) camera).intValue()]);
            return pigeonResult;
        }
    }

    /* loaded from: classes2.dex */
    public static final class CacheRetrievalError {
        private String code;
        private String message;

        public String getCode() {
            return this.code;
        }

        public void setCode(String setterArg) {
            if (setterArg == null) {
                throw new IllegalStateException("Nonnull field \"code\" is null.");
            }
            this.code = setterArg;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String setterArg) {
            this.message = setterArg;
        }

        CacheRetrievalError() {
        }

        /* loaded from: classes2.dex */
        public static final class Builder {
            private String code;
            private String message;

            public Builder setCode(String setterArg) {
                this.code = setterArg;
                return this;
            }

            public Builder setMessage(String setterArg) {
                this.message = setterArg;
                return this;
            }

            public CacheRetrievalError build() {
                CacheRetrievalError pigeonReturn = new CacheRetrievalError();
                pigeonReturn.setCode(this.code);
                pigeonReturn.setMessage(this.message);
                return pigeonReturn;
            }
        }

        ArrayList<Object> toList() {
            ArrayList<Object> toListResult = new ArrayList<>(2);
            toListResult.add(this.code);
            toListResult.add(this.message);
            return toListResult;
        }

        static CacheRetrievalError fromList(ArrayList<Object> list) {
            CacheRetrievalError pigeonResult = new CacheRetrievalError();
            Object code = list.get(0);
            pigeonResult.setCode((String) code);
            Object message = list.get(1);
            pigeonResult.setMessage((String) message);
            return pigeonResult;
        }
    }

    /* loaded from: classes2.dex */
    public static final class CacheRetrievalResult {
        private CacheRetrievalError error;
        private List<String> paths;
        private CacheRetrievalType type;

        public CacheRetrievalType getType() {
            return this.type;
        }

        public void setType(CacheRetrievalType setterArg) {
            if (setterArg == null) {
                throw new IllegalStateException("Nonnull field \"type\" is null.");
            }
            this.type = setterArg;
        }

        public CacheRetrievalError getError() {
            return this.error;
        }

        public void setError(CacheRetrievalError setterArg) {
            this.error = setterArg;
        }

        public List<String> getPaths() {
            return this.paths;
        }

        public void setPaths(List<String> setterArg) {
            if (setterArg == null) {
                throw new IllegalStateException("Nonnull field \"paths\" is null.");
            }
            this.paths = setterArg;
        }

        CacheRetrievalResult() {
        }

        /* loaded from: classes2.dex */
        public static final class Builder {
            private CacheRetrievalError error;
            private List<String> paths;
            private CacheRetrievalType type;

            public Builder setType(CacheRetrievalType setterArg) {
                this.type = setterArg;
                return this;
            }

            public Builder setError(CacheRetrievalError setterArg) {
                this.error = setterArg;
                return this;
            }

            public Builder setPaths(List<String> setterArg) {
                this.paths = setterArg;
                return this;
            }

            public CacheRetrievalResult build() {
                CacheRetrievalResult pigeonReturn = new CacheRetrievalResult();
                pigeonReturn.setType(this.type);
                pigeonReturn.setError(this.error);
                pigeonReturn.setPaths(this.paths);
                return pigeonReturn;
            }
        }

        ArrayList<Object> toList() {
            ArrayList<Object> toListResult = new ArrayList<>(3);
            CacheRetrievalType cacheRetrievalType = this.type;
            toListResult.add(cacheRetrievalType == null ? null : Integer.valueOf(cacheRetrievalType.index));
            CacheRetrievalError cacheRetrievalError = this.error;
            toListResult.add(cacheRetrievalError != null ? cacheRetrievalError.toList() : null);
            toListResult.add(this.paths);
            return toListResult;
        }

        static CacheRetrievalResult fromList(ArrayList<Object> list) {
            CacheRetrievalResult pigeonResult = new CacheRetrievalResult();
            Object type = list.get(0);
            pigeonResult.setType(CacheRetrievalType.values()[((Integer) type).intValue()]);
            Object error = list.get(1);
            pigeonResult.setError(error == null ? null : CacheRetrievalError.fromList((ArrayList) error));
            Object paths = list.get(2);
            pigeonResult.setPaths((List) paths);
            return pigeonResult;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ImagePickerApiCodec extends StandardMessageCodec {
        public static final ImagePickerApiCodec INSTANCE = new ImagePickerApiCodec();

        private ImagePickerApiCodec() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.flutter.plugin.common.StandardMessageCodec
        public Object readValueOfType(byte type, ByteBuffer buffer) {
            switch (type) {
                case Byte.MIN_VALUE:
                    return CacheRetrievalError.fromList((ArrayList) readValue(buffer));
                case -127:
                    return CacheRetrievalResult.fromList((ArrayList) readValue(buffer));
                case -126:
                    return GeneralOptions.fromList((ArrayList) readValue(buffer));
                case -125:
                    return ImageSelectionOptions.fromList((ArrayList) readValue(buffer));
                case -124:
                    return MediaSelectionOptions.fromList((ArrayList) readValue(buffer));
                case -123:
                    return SourceSpecification.fromList((ArrayList) readValue(buffer));
                case -122:
                    return VideoSelectionOptions.fromList((ArrayList) readValue(buffer));
                default:
                    return super.readValueOfType(type, buffer);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.flutter.plugin.common.StandardMessageCodec
        public void writeValue(ByteArrayOutputStream stream, Object value) {
            if (value instanceof CacheRetrievalError) {
                stream.write(128);
                writeValue(stream, ((CacheRetrievalError) value).toList());
            } else if (value instanceof CacheRetrievalResult) {
                stream.write(129);
                writeValue(stream, ((CacheRetrievalResult) value).toList());
            } else if (value instanceof GeneralOptions) {
                stream.write(130);
                writeValue(stream, ((GeneralOptions) value).toList());
            } else if (value instanceof ImageSelectionOptions) {
                stream.write(131);
                writeValue(stream, ((ImageSelectionOptions) value).toList());
            } else if (value instanceof MediaSelectionOptions) {
                stream.write(132);
                writeValue(stream, ((MediaSelectionOptions) value).toList());
            } else if (value instanceof SourceSpecification) {
                stream.write(133);
                writeValue(stream, ((SourceSpecification) value).toList());
            } else if (value instanceof VideoSelectionOptions) {
                stream.write(134);
                writeValue(stream, ((VideoSelectionOptions) value).toList());
            } else {
                super.writeValue(stream, value);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface ImagePickerApi {
        void pickImages(SourceSpecification sourceSpecification, ImageSelectionOptions imageSelectionOptions, GeneralOptions generalOptions, Result<List<String>> result);

        void pickMedia(MediaSelectionOptions mediaSelectionOptions, GeneralOptions generalOptions, Result<List<String>> result);

        void pickVideos(SourceSpecification sourceSpecification, VideoSelectionOptions videoSelectionOptions, GeneralOptions generalOptions, Result<List<String>> result);

        CacheRetrievalResult retrieveLostResults();

        /* renamed from: io.flutter.plugins.imagepicker.Messages$ImagePickerApi$-CC  reason: invalid class name */
        /* loaded from: classes2.dex */
        public final /* synthetic */ class CC {
            public static MessageCodec<Object> getCodec() {
                return ImagePickerApiCodec.INSTANCE;
            }

            public static void setUp(BinaryMessenger binaryMessenger, final ImagePickerApi api) {
                BinaryMessenger.TaskQueue taskQueue = binaryMessenger.makeBackgroundTaskQueue();
                BasicMessageChannel<Object> channel = new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.image_picker_android.ImagePickerApi.pickImages", getCodec(), taskQueue);
                if (api != null) {
                    channel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.imagepicker.Messages$ImagePickerApi$$ExternalSyntheticLambda0
                        @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                        public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                            Messages.ImagePickerApi.CC.lambda$setUp$0(Messages.ImagePickerApi.this, obj, reply);
                        }
                    });
                } else {
                    channel.setMessageHandler(null);
                }
                BinaryMessenger.TaskQueue taskQueue2 = binaryMessenger.makeBackgroundTaskQueue();
                BasicMessageChannel<Object> channel2 = new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.image_picker_android.ImagePickerApi.pickVideos", getCodec(), taskQueue2);
                if (api != null) {
                    channel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.imagepicker.Messages$ImagePickerApi$$ExternalSyntheticLambda1
                        @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                        public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                            Messages.ImagePickerApi.CC.lambda$setUp$1(Messages.ImagePickerApi.this, obj, reply);
                        }
                    });
                } else {
                    channel2.setMessageHandler(null);
                }
                BasicMessageChannel<Object> channel3 = new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.image_picker_android.ImagePickerApi.pickMedia", getCodec());
                if (api != null) {
                    channel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.imagepicker.Messages$ImagePickerApi$$ExternalSyntheticLambda2
                        @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                        public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                            Messages.ImagePickerApi.CC.lambda$setUp$2(Messages.ImagePickerApi.this, obj, reply);
                        }
                    });
                } else {
                    channel3.setMessageHandler(null);
                }
                BinaryMessenger.TaskQueue taskQueue3 = binaryMessenger.makeBackgroundTaskQueue();
                BasicMessageChannel<Object> channel4 = new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.image_picker_android.ImagePickerApi.retrieveLostResults", getCodec(), taskQueue3);
                if (api != null) {
                    channel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.imagepicker.Messages$ImagePickerApi$$ExternalSyntheticLambda3
                        @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                        public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                            Messages.ImagePickerApi.CC.lambda$setUp$3(Messages.ImagePickerApi.this, obj, reply);
                        }
                    });
                } else {
                    channel4.setMessageHandler(null);
                }
            }

            public static /* synthetic */ void lambda$setUp$0(ImagePickerApi api, Object message, final BasicMessageChannel.Reply reply) {
                final ArrayList<Object> wrapped = new ArrayList<>();
                ArrayList<Object> args = (ArrayList) message;
                SourceSpecification sourceArg = (SourceSpecification) args.get(0);
                ImageSelectionOptions optionsArg = (ImageSelectionOptions) args.get(1);
                GeneralOptions generalOptionsArg = (GeneralOptions) args.get(2);
                Result<List<String>> resultCallback = new Result<List<String>>() { // from class: io.flutter.plugins.imagepicker.Messages.ImagePickerApi.1
                    @Override // io.flutter.plugins.imagepicker.Messages.Result
                    public void success(List<String> result) {
                        wrapped.add(0, result);
                        reply.reply(wrapped);
                    }

                    @Override // io.flutter.plugins.imagepicker.Messages.Result
                    public void error(Throwable error) {
                        ArrayList<Object> wrappedError = Messages.wrapError(error);
                        reply.reply(wrappedError);
                    }
                };
                api.pickImages(sourceArg, optionsArg, generalOptionsArg, resultCallback);
            }

            public static /* synthetic */ void lambda$setUp$1(ImagePickerApi api, Object message, final BasicMessageChannel.Reply reply) {
                final ArrayList<Object> wrapped = new ArrayList<>();
                ArrayList<Object> args = (ArrayList) message;
                SourceSpecification sourceArg = (SourceSpecification) args.get(0);
                VideoSelectionOptions optionsArg = (VideoSelectionOptions) args.get(1);
                GeneralOptions generalOptionsArg = (GeneralOptions) args.get(2);
                Result<List<String>> resultCallback = new Result<List<String>>() { // from class: io.flutter.plugins.imagepicker.Messages.ImagePickerApi.2
                    @Override // io.flutter.plugins.imagepicker.Messages.Result
                    public void success(List<String> result) {
                        wrapped.add(0, result);
                        reply.reply(wrapped);
                    }

                    @Override // io.flutter.plugins.imagepicker.Messages.Result
                    public void error(Throwable error) {
                        ArrayList<Object> wrappedError = Messages.wrapError(error);
                        reply.reply(wrappedError);
                    }
                };
                api.pickVideos(sourceArg, optionsArg, generalOptionsArg, resultCallback);
            }

            public static /* synthetic */ void lambda$setUp$2(ImagePickerApi api, Object message, final BasicMessageChannel.Reply reply) {
                final ArrayList<Object> wrapped = new ArrayList<>();
                ArrayList<Object> args = (ArrayList) message;
                MediaSelectionOptions mediaSelectionOptionsArg = (MediaSelectionOptions) args.get(0);
                GeneralOptions generalOptionsArg = (GeneralOptions) args.get(1);
                Result<List<String>> resultCallback = new Result<List<String>>() { // from class: io.flutter.plugins.imagepicker.Messages.ImagePickerApi.3
                    @Override // io.flutter.plugins.imagepicker.Messages.Result
                    public void success(List<String> result) {
                        wrapped.add(0, result);
                        reply.reply(wrapped);
                    }

                    @Override // io.flutter.plugins.imagepicker.Messages.Result
                    public void error(Throwable error) {
                        ArrayList<Object> wrappedError = Messages.wrapError(error);
                        reply.reply(wrappedError);
                    }
                };
                api.pickMedia(mediaSelectionOptionsArg, generalOptionsArg, resultCallback);
            }

            public static /* synthetic */ void lambda$setUp$3(ImagePickerApi api, Object message, BasicMessageChannel.Reply reply) {
                ArrayList<Object> wrapped = new ArrayList<>();
                try {
                    CacheRetrievalResult output = api.retrieveLostResults();
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
