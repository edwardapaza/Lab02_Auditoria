package io.flutter.plugins.imagepicker;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import com.google.firebase.messaging.Constants;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.imagepicker.ImagePickerCache;
import io.flutter.plugins.imagepicker.ImagePickerDelegate;
import io.flutter.plugins.imagepicker.Messages;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class ImagePickerDelegate implements PluginRegistry.ActivityResultListener, PluginRegistry.RequestPermissionsResultListener {
    static final int REQUEST_CAMERA_IMAGE_PERMISSION = 2345;
    static final int REQUEST_CAMERA_VIDEO_PERMISSION = 2355;
    static final int REQUEST_CODE_CHOOSE_IMAGE_FROM_GALLERY = 2342;
    static final int REQUEST_CODE_CHOOSE_MEDIA_FROM_GALLERY = 2347;
    static final int REQUEST_CODE_CHOOSE_MULTI_IMAGE_FROM_GALLERY = 2346;
    static final int REQUEST_CODE_CHOOSE_VIDEO_FROM_GALLERY = 2352;
    static final int REQUEST_CODE_TAKE_IMAGE_WITH_CAMERA = 2343;
    static final int REQUEST_CODE_TAKE_VIDEO_WITH_CAMERA = 2353;
    private final Activity activity;
    private final ImagePickerCache cache;
    private CameraDevice cameraDevice;
    private final ExecutorService executor;
    final String fileProviderName;
    private final FileUriResolver fileUriResolver;
    private final FileUtils fileUtils;
    private final ImageResizer imageResizer;
    private PendingCallState pendingCallState;
    private final Object pendingCallStateLock;
    private Uri pendingCameraMediaUri;
    private final PermissionManager permissionManager;

    /* loaded from: classes2.dex */
    public enum CameraDevice {
        REAR,
        FRONT
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface FileUriResolver {
        void getFullImagePath(Uri uri, OnPathReadyListener onPathReadyListener);

        Uri resolveFileProviderUriForFile(String str, File file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface OnPathReadyListener {
        void onPathReady(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface PermissionManager {
        void askForPermission(String str, int i);

        boolean isPermissionGranted(String str);

        boolean needRequestCameraPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class PendingCallState {
        public final Messages.ImageSelectionOptions imageOptions;
        public final Messages.Result<List<String>> result;
        public final Messages.VideoSelectionOptions videoOptions;

        PendingCallState(Messages.ImageSelectionOptions imageOptions, Messages.VideoSelectionOptions videoOptions, Messages.Result<List<String>> result) {
            this.imageOptions = imageOptions;
            this.videoOptions = videoOptions;
            this.result = result;
        }
    }

    public ImagePickerDelegate(final Activity activity, ImageResizer imageResizer, ImagePickerCache cache) {
        this(activity, imageResizer, null, null, null, cache, new PermissionManager() { // from class: io.flutter.plugins.imagepicker.ImagePickerDelegate.1
            @Override // io.flutter.plugins.imagepicker.ImagePickerDelegate.PermissionManager
            public boolean isPermissionGranted(String permissionName) {
                return ActivityCompat.checkSelfPermission(activity, permissionName) == 0;
            }

            @Override // io.flutter.plugins.imagepicker.ImagePickerDelegate.PermissionManager
            public void askForPermission(String permissionName, int requestCode) {
                ActivityCompat.requestPermissions(activity, new String[]{permissionName}, requestCode);
            }

            @Override // io.flutter.plugins.imagepicker.ImagePickerDelegate.PermissionManager
            public boolean needRequestCameraPermission() {
                return ImagePickerUtils.needRequestCameraPermission(activity);
            }
        }, new AnonymousClass2(activity), new FileUtils(), Executors.newSingleThreadExecutor());
    }

    /* renamed from: io.flutter.plugins.imagepicker.ImagePickerDelegate$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass2 implements FileUriResolver {
        final /* synthetic */ Activity val$activity;

        AnonymousClass2(Activity activity) {
            this.val$activity = activity;
        }

        @Override // io.flutter.plugins.imagepicker.ImagePickerDelegate.FileUriResolver
        public Uri resolveFileProviderUriForFile(String fileProviderName, File file) {
            return FileProvider.getUriForFile(this.val$activity, fileProviderName, file);
        }

        @Override // io.flutter.plugins.imagepicker.ImagePickerDelegate.FileUriResolver
        public void getFullImagePath(Uri imageUri, final OnPathReadyListener listener) {
            Activity activity = this.val$activity;
            String[] strArr = new String[1];
            strArr[0] = imageUri != null ? imageUri.getPath() : "";
            MediaScannerConnection.scanFile(activity, strArr, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: io.flutter.plugins.imagepicker.ImagePickerDelegate$2$$ExternalSyntheticLambda0
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public final void onScanCompleted(String str, Uri uri) {
                    ImagePickerDelegate.OnPathReadyListener.this.onPathReady(str);
                }
            });
        }
    }

    ImagePickerDelegate(Activity activity, ImageResizer imageResizer, Messages.ImageSelectionOptions pendingImageOptions, Messages.VideoSelectionOptions pendingVideoOptions, Messages.Result<List<String>> result, ImagePickerCache cache, PermissionManager permissionManager, FileUriResolver fileUriResolver, FileUtils fileUtils, ExecutorService executor) {
        this.pendingCallStateLock = new Object();
        this.activity = activity;
        this.imageResizer = imageResizer;
        this.fileProviderName = activity.getPackageName() + ".flutter.image_provider";
        if (result != null) {
            this.pendingCallState = new PendingCallState(pendingImageOptions, pendingVideoOptions, result);
        }
        this.permissionManager = permissionManager;
        this.fileUriResolver = fileUriResolver;
        this.fileUtils = fileUtils;
        this.cache = cache;
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCameraDevice(CameraDevice device) {
        this.cameraDevice = device;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void saveStateBeforeResult() {
        ImagePickerCache.CacheType cacheType;
        synchronized (this.pendingCallStateLock) {
            PendingCallState pendingCallState = this.pendingCallState;
            if (pendingCallState == null) {
                return;
            }
            Messages.ImageSelectionOptions localImageOptions = pendingCallState.imageOptions;
            ImagePickerCache imagePickerCache = this.cache;
            if (localImageOptions != null) {
                cacheType = ImagePickerCache.CacheType.IMAGE;
            } else {
                cacheType = ImagePickerCache.CacheType.VIDEO;
            }
            imagePickerCache.saveType(cacheType);
            if (localImageOptions != null) {
                this.cache.saveDimensionWithOutputOptions(localImageOptions);
            }
            Uri localPendingCameraMediaUri = this.pendingCameraMediaUri;
            if (localPendingCameraMediaUri != null) {
                this.cache.savePendingCameraMediaUriPath(localPendingCameraMediaUri);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Messages.CacheRetrievalResult retrieveLostImage() {
        Map<String, Object> cacheMap = this.cache.getCacheMap();
        if (cacheMap.isEmpty()) {
            return null;
        }
        Messages.CacheRetrievalResult.Builder result = new Messages.CacheRetrievalResult.Builder();
        Messages.CacheRetrievalType type = (Messages.CacheRetrievalType) cacheMap.get("type");
        if (type != null) {
            result.setType(type);
        }
        result.setError((Messages.CacheRetrievalError) cacheMap.get(Constants.IPC_BUNDLE_KEY_SEND_ERROR));
        ArrayList<String> pathList = (ArrayList) cacheMap.get("pathList");
        if (pathList != null) {
            ArrayList<String> newPathList = new ArrayList<>();
            Iterator<String> it = pathList.iterator();
            while (it.hasNext()) {
                String path = it.next();
                Double maxWidth = (Double) cacheMap.get("maxWidth");
                Double maxHeight = (Double) cacheMap.get("maxHeight");
                Integer boxedImageQuality = (Integer) cacheMap.get("imageQuality");
                int imageQuality = boxedImageQuality == null ? 100 : boxedImageQuality.intValue();
                newPathList.add(this.imageResizer.resizeImageIfNeeded(path, maxWidth, maxHeight, imageQuality));
            }
            result.setPaths(newPathList);
        }
        this.cache.clear();
        return result.build();
    }

    public void chooseMediaFromGallery(Messages.MediaSelectionOptions options, Messages.GeneralOptions generalOptions, Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult(options.getImageSelectionOptions(), null, result)) {
            finishWithAlreadyActiveError(result);
        } else {
            launchPickMediaFromGalleryIntent(generalOptions);
        }
    }

    private void launchPickMediaFromGalleryIntent(Messages.GeneralOptions generalOptions) {
        Intent pickMediaIntent;
        if (generalOptions.getUsePhotoPicker().booleanValue()) {
            if (generalOptions.getAllowMultiple().booleanValue()) {
                int limit = ImagePickerUtils.getLimitFromOption(generalOptions);
                pickMediaIntent = new ActivityResultContracts.PickMultipleVisualMedia(limit).createIntent((Context) this.activity, new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE).build());
            } else {
                pickMediaIntent = new ActivityResultContracts.PickVisualMedia().createIntent((Context) this.activity, new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE).build());
            }
        } else {
            pickMediaIntent = new Intent("android.intent.action.GET_CONTENT");
            pickMediaIntent.setType("*/*");
            String[] mimeTypes = {"video/*", "image/*"};
            pickMediaIntent.putExtra("CONTENT_TYPE", mimeTypes);
            pickMediaIntent.putExtra("android.intent.extra.ALLOW_MULTIPLE", generalOptions.getAllowMultiple());
        }
        this.activity.startActivityForResult(pickMediaIntent, REQUEST_CODE_CHOOSE_MEDIA_FROM_GALLERY);
    }

    public void chooseVideoFromGallery(Messages.VideoSelectionOptions options, boolean usePhotoPicker, Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult(null, options, result)) {
            finishWithAlreadyActiveError(result);
        } else {
            launchPickVideoFromGalleryIntent(Boolean.valueOf(usePhotoPicker));
        }
    }

    private void launchPickVideoFromGalleryIntent(Boolean usePhotoPicker) {
        Intent pickVideoIntent;
        if (usePhotoPicker.booleanValue()) {
            pickVideoIntent = new ActivityResultContracts.PickVisualMedia().createIntent((Context) this.activity, new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.VideoOnly.INSTANCE).build());
        } else {
            pickVideoIntent = new Intent("android.intent.action.GET_CONTENT");
            pickVideoIntent.setType("video/*");
        }
        this.activity.startActivityForResult(pickVideoIntent, REQUEST_CODE_CHOOSE_VIDEO_FROM_GALLERY);
    }

    public void takeVideoWithCamera(Messages.VideoSelectionOptions options, Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult(null, options, result)) {
            finishWithAlreadyActiveError(result);
        } else if (needRequestCameraPermission() && !this.permissionManager.isPermissionGranted("android.permission.CAMERA")) {
            this.permissionManager.askForPermission("android.permission.CAMERA", REQUEST_CAMERA_VIDEO_PERMISSION);
        } else {
            launchTakeVideoWithCameraIntent();
        }
    }

    private void launchTakeVideoWithCameraIntent() {
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        Messages.VideoSelectionOptions localVideoOptions = null;
        synchronized (this.pendingCallStateLock) {
            PendingCallState pendingCallState = this.pendingCallState;
            if (pendingCallState != null) {
                localVideoOptions = pendingCallState.videoOptions;
            }
        }
        if (localVideoOptions != null && localVideoOptions.getMaxDurationSeconds() != null) {
            int maxSeconds = localVideoOptions.getMaxDurationSeconds().intValue();
            intent.putExtra("android.intent.extra.durationLimit", maxSeconds);
        }
        if (this.cameraDevice == CameraDevice.FRONT) {
            useFrontCamera(intent);
        }
        File videoFile = createTemporaryWritableVideoFile();
        this.pendingCameraMediaUri = Uri.parse("file:" + videoFile.getAbsolutePath());
        Uri videoUri = this.fileUriResolver.resolveFileProviderUriForFile(this.fileProviderName, videoFile);
        intent.putExtra("output", videoUri);
        grantUriPermissions(intent, videoUri);
        try {
            this.activity.startActivityForResult(intent, REQUEST_CODE_TAKE_VIDEO_WITH_CAMERA);
        } catch (ActivityNotFoundException e) {
            try {
                videoFile.delete();
            } catch (SecurityException exception) {
                exception.printStackTrace();
            }
            finishWithError("no_available_camera", "No cameras available for taking pictures.");
        }
    }

    public void chooseImageFromGallery(Messages.ImageSelectionOptions options, boolean usePhotoPicker, Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult(options, null, result)) {
            finishWithAlreadyActiveError(result);
        } else {
            launchPickImageFromGalleryIntent(Boolean.valueOf(usePhotoPicker));
        }
    }

    public void chooseMultiImageFromGallery(Messages.ImageSelectionOptions options, boolean usePhotoPicker, int limit, Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult(options, null, result)) {
            finishWithAlreadyActiveError(result);
        } else {
            launchMultiPickImageFromGalleryIntent(Boolean.valueOf(usePhotoPicker), limit);
        }
    }

    private void launchPickImageFromGalleryIntent(Boolean usePhotoPicker) {
        Intent pickImageIntent;
        if (usePhotoPicker.booleanValue()) {
            pickImageIntent = new ActivityResultContracts.PickVisualMedia().createIntent((Context) this.activity, new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE).build());
        } else {
            pickImageIntent = new Intent("android.intent.action.GET_CONTENT");
            pickImageIntent.setType("image/*");
        }
        this.activity.startActivityForResult(pickImageIntent, REQUEST_CODE_CHOOSE_IMAGE_FROM_GALLERY);
    }

    private void launchMultiPickImageFromGalleryIntent(Boolean usePhotoPicker, int limit) {
        Intent pickMultiImageIntent;
        if (usePhotoPicker.booleanValue()) {
            pickMultiImageIntent = new ActivityResultContracts.PickMultipleVisualMedia(limit).createIntent((Context) this.activity, new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE).build());
        } else {
            pickMultiImageIntent = new Intent("android.intent.action.GET_CONTENT");
            pickMultiImageIntent.setType("image/*");
            pickMultiImageIntent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        }
        this.activity.startActivityForResult(pickMultiImageIntent, REQUEST_CODE_CHOOSE_MULTI_IMAGE_FROM_GALLERY);
    }

    public void takeImageWithCamera(Messages.ImageSelectionOptions options, Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult(options, null, result)) {
            finishWithAlreadyActiveError(result);
        } else if (needRequestCameraPermission() && !this.permissionManager.isPermissionGranted("android.permission.CAMERA")) {
            this.permissionManager.askForPermission("android.permission.CAMERA", REQUEST_CAMERA_IMAGE_PERMISSION);
        } else {
            launchTakeImageWithCameraIntent();
        }
    }

    private boolean needRequestCameraPermission() {
        PermissionManager permissionManager = this.permissionManager;
        if (permissionManager == null) {
            return false;
        }
        return permissionManager.needRequestCameraPermission();
    }

    private void launchTakeImageWithCameraIntent() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (this.cameraDevice == CameraDevice.FRONT) {
            useFrontCamera(intent);
        }
        File imageFile = createTemporaryWritableImageFile();
        this.pendingCameraMediaUri = Uri.parse("file:" + imageFile.getAbsolutePath());
        Uri imageUri = this.fileUriResolver.resolveFileProviderUriForFile(this.fileProviderName, imageFile);
        intent.putExtra("output", imageUri);
        grantUriPermissions(intent, imageUri);
        try {
            this.activity.startActivityForResult(intent, REQUEST_CODE_TAKE_IMAGE_WITH_CAMERA);
        } catch (ActivityNotFoundException e) {
            try {
                imageFile.delete();
            } catch (SecurityException exception) {
                exception.printStackTrace();
            }
            finishWithError("no_available_camera", "No cameras available for taking pictures.");
        }
    }

    private File createTemporaryWritableImageFile() {
        return createTemporaryWritableFile(".jpg");
    }

    private File createTemporaryWritableVideoFile() {
        return createTemporaryWritableFile(".mp4");
    }

    private File createTemporaryWritableFile(String suffix) {
        String filename = UUID.randomUUID().toString();
        File externalFilesDirectory = this.activity.getCacheDir();
        try {
            externalFilesDirectory.mkdirs();
            File image = File.createTempFile(filename, suffix, externalFilesDirectory);
            return image;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void grantUriPermissions(Intent intent, Uri imageUri) {
        List<ResolveInfo> compatibleActivities;
        PackageManager packageManager = this.activity.getPackageManager();
        if (Build.VERSION.SDK_INT >= 33) {
            compatibleActivities = packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of((long) PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH));
        } else {
            compatibleActivities = queryIntentActivitiesPreApi33(packageManager, intent);
        }
        for (ResolveInfo info : compatibleActivities) {
            this.activity.grantUriPermission(info.activityInfo.packageName, imageUri, 3);
        }
    }

    private static List<ResolveInfo> queryIntentActivitiesPreApi33(PackageManager packageManager, Intent intent) {
        return packageManager.queryIntentActivities(intent, 65536);
    }

    @Override // io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener
    public boolean onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        boolean permissionGranted = grantResults.length > 0 && grantResults[0] == 0;
        switch (requestCode) {
            case REQUEST_CAMERA_IMAGE_PERMISSION /* 2345 */:
                if (permissionGranted) {
                    launchTakeImageWithCameraIntent();
                    break;
                }
                break;
            case REQUEST_CAMERA_VIDEO_PERMISSION /* 2355 */:
                if (permissionGranted) {
                    launchTakeVideoWithCameraIntent();
                    break;
                }
                break;
            default:
                return false;
        }
        if (!permissionGranted) {
            switch (requestCode) {
                case REQUEST_CAMERA_IMAGE_PERMISSION /* 2345 */:
                case REQUEST_CAMERA_VIDEO_PERMISSION /* 2355 */:
                    finishWithError("camera_access_denied", "The user did not allow camera access.");
                    break;
            }
        }
        return true;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public boolean onActivityResult(int requestCode, final int resultCode, final Intent data) {
        Runnable handlerRunnable;
        switch (requestCode) {
            case REQUEST_CODE_CHOOSE_IMAGE_FROM_GALLERY /* 2342 */:
                handlerRunnable = new Runnable() { // from class: io.flutter.plugins.imagepicker.ImagePickerDelegate$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImagePickerDelegate.this.m158x759b8bb5(resultCode, data);
                    }
                };
                break;
            case REQUEST_CODE_TAKE_IMAGE_WITH_CAMERA /* 2343 */:
                handlerRunnable = new Runnable() { // from class: io.flutter.plugins.imagepicker.ImagePickerDelegate$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImagePickerDelegate.this.m160xd14cc073(resultCode);
                    }
                };
                break;
            case REQUEST_CODE_CHOOSE_MULTI_IMAGE_FROM_GALLERY /* 2346 */:
                handlerRunnable = new Runnable() { // from class: io.flutter.plugins.imagepicker.ImagePickerDelegate$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImagePickerDelegate.this.m159xa3742614(resultCode, data);
                    }
                };
                break;
            case REQUEST_CODE_CHOOSE_MEDIA_FROM_GALLERY /* 2347 */:
                handlerRunnable = new Runnable() { // from class: io.flutter.plugins.imagepicker.ImagePickerDelegate$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImagePickerDelegate.this.m161xff255ad2(resultCode, data);
                    }
                };
                break;
            case REQUEST_CODE_CHOOSE_VIDEO_FROM_GALLERY /* 2352 */:
                handlerRunnable = new Runnable() { // from class: io.flutter.plugins.imagepicker.ImagePickerDelegate$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImagePickerDelegate.this.m162x2cfdf531(resultCode, data);
                    }
                };
                break;
            case REQUEST_CODE_TAKE_VIDEO_WITH_CAMERA /* 2353 */:
                handlerRunnable = new Runnable() { // from class: io.flutter.plugins.imagepicker.ImagePickerDelegate$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImagePickerDelegate.this.m163x5ad68f90(resultCode);
                    }
                };
                break;
            default:
                return false;
        }
        this.executor.execute(handlerRunnable);
        return true;
    }

    private ArrayList<MediaPath> getPathsFromIntent(Intent data, boolean includeMimeType) {
        String path;
        ArrayList<MediaPath> paths = new ArrayList<>();
        Uri uri = data.getData();
        if (uri == null) {
            ClipData clipData = data.getClipData();
            if (clipData == null) {
                return null;
            }
            for (int i = 0; i < data.getClipData().getItemCount(); i++) {
                Uri uri2 = data.getClipData().getItemAt(i).getUri();
                if (uri2 == null || (path = this.fileUtils.getPathFromUri(this.activity, uri2)) == null) {
                    return null;
                }
                String mimeType = includeMimeType ? this.activity.getContentResolver().getType(uri2) : null;
                paths.add(new MediaPath(path, mimeType));
            }
        } else {
            String path2 = this.fileUtils.getPathFromUri(this.activity, uri);
            if (path2 == null) {
                return null;
            }
            paths.add(new MediaPath(path2, null));
        }
        return paths;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleChooseImageResult */
    public void m158x759b8bb5(int resultCode, Intent data) {
        if (resultCode == -1 && data != null) {
            ArrayList<MediaPath> paths = getPathsFromIntent(data, false);
            if (paths == null) {
                finishWithError("no_valid_image_uri", "Cannot find the selected image.");
                return;
            } else {
                handleMediaResult(paths);
                return;
            }
        }
        finishWithSuccess(null);
    }

    /* loaded from: classes2.dex */
    public class MediaPath {
        final String mimeType;
        final String path;

        public MediaPath(String path, String mimeType) {
            this.path = path;
            this.mimeType = mimeType;
        }

        public String getPath() {
            return this.path;
        }

        public String getMimeType() {
            return this.mimeType;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleChooseMediaResult */
    public void m161xff255ad2(int resultCode, Intent intent) {
        if (resultCode == -1 && intent != null) {
            ArrayList<MediaPath> paths = getPathsFromIntent(intent, true);
            if (paths == null) {
                finishWithError("no_valid_media_uri", "Cannot find the selected media.");
                return;
            } else {
                handleMediaResult(paths);
                return;
            }
        }
        finishWithSuccess(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleChooseMultiImageResult */
    public void m159xa3742614(int resultCode, Intent intent) {
        if (resultCode == -1 && intent != null) {
            ArrayList<MediaPath> paths = getPathsFromIntent(intent, false);
            if (paths == null) {
                finishWithError("missing_valid_image_uri", "Cannot find at least one of the selected images.");
                return;
            } else {
                handleMediaResult(paths);
                return;
            }
        }
        finishWithSuccess(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleChooseVideoResult */
    public void m162x2cfdf531(int resultCode, Intent data) {
        if (resultCode == -1 && data != null) {
            ArrayList<MediaPath> paths = getPathsFromIntent(data, false);
            if (paths == null || paths.size() < 1) {
                finishWithError("no_valid_video_uri", "Cannot find the selected video.");
                return;
            } else {
                finishWithSuccess(paths.get(0).path);
                return;
            }
        }
        finishWithSuccess(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleCaptureImageResult */
    public void m160xd14cc073(int resultCode) {
        Uri parse;
        if (resultCode == -1) {
            Uri localPendingCameraMediaUri = this.pendingCameraMediaUri;
            FileUriResolver fileUriResolver = this.fileUriResolver;
            if (localPendingCameraMediaUri != null) {
                parse = localPendingCameraMediaUri;
            } else {
                parse = Uri.parse(this.cache.retrievePendingCameraMediaUriPath());
            }
            fileUriResolver.getFullImagePath(parse, new OnPathReadyListener() { // from class: io.flutter.plugins.imagepicker.ImagePickerDelegate$$ExternalSyntheticLambda6
                @Override // io.flutter.plugins.imagepicker.ImagePickerDelegate.OnPathReadyListener
                public final void onPathReady(String str) {
                    ImagePickerDelegate.this.m157x7d5317a0(str);
                }
            });
            return;
        }
        finishWithSuccess(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$handleCaptureImageResult$6$io-flutter-plugins-imagepicker-ImagePickerDelegate  reason: not valid java name */
    public /* synthetic */ void m157x7d5317a0(String path) {
        handleImageResult(path, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleCaptureVideoResult */
    public void m163x5ad68f90(int resultCode) {
        Uri parse;
        if (resultCode == -1) {
            Uri localPendingCameraMediaUrl = this.pendingCameraMediaUri;
            FileUriResolver fileUriResolver = this.fileUriResolver;
            if (localPendingCameraMediaUrl != null) {
                parse = localPendingCameraMediaUrl;
            } else {
                parse = Uri.parse(this.cache.retrievePendingCameraMediaUriPath());
            }
            fileUriResolver.getFullImagePath(parse, new OnPathReadyListener() { // from class: io.flutter.plugins.imagepicker.ImagePickerDelegate$$ExternalSyntheticLambda7
                @Override // io.flutter.plugins.imagepicker.ImagePickerDelegate.OnPathReadyListener
                public final void onPathReady(String str) {
                    ImagePickerDelegate.this.finishWithSuccess(str);
                }
            });
            return;
        }
        finishWithSuccess(null);
    }

    void handleImageResult(String path, boolean shouldDeleteOriginalIfScaled) {
        Messages.ImageSelectionOptions localImageOptions = null;
        synchronized (this.pendingCallStateLock) {
            PendingCallState pendingCallState = this.pendingCallState;
            if (pendingCallState != null) {
                localImageOptions = pendingCallState.imageOptions;
            }
        }
        if (localImageOptions != null) {
            String finalImagePath = getResizedImagePath(path, localImageOptions);
            if (finalImagePath != null && !finalImagePath.equals(path) && shouldDeleteOriginalIfScaled) {
                new File(path).delete();
            }
            finishWithSuccess(finalImagePath);
            return;
        }
        finishWithSuccess(path);
    }

    private String getResizedImagePath(String path, Messages.ImageSelectionOptions outputOptions) {
        return this.imageResizer.resizeImageIfNeeded(path, outputOptions.getMaxWidth(), outputOptions.getMaxHeight(), outputOptions.getQuality().intValue());
    }

    private void handleMediaResult(ArrayList<MediaPath> paths) {
        Messages.ImageSelectionOptions localImageOptions = null;
        synchronized (this.pendingCallStateLock) {
            PendingCallState pendingCallState = this.pendingCallState;
            if (pendingCallState != null) {
                localImageOptions = pendingCallState.imageOptions;
            }
        }
        ArrayList<String> finalPaths = new ArrayList<>();
        if (localImageOptions != null) {
            for (int i = 0; i < paths.size(); i++) {
                MediaPath path = paths.get(i);
                String finalPath = path.path;
                if (path.mimeType == null || !path.mimeType.startsWith("video/")) {
                    finalPath = getResizedImagePath(path.path, localImageOptions);
                }
                finalPaths.add(finalPath);
            }
            finishWithListSuccess(finalPaths);
            return;
        }
        for (int i2 = 0; i2 < paths.size(); i2++) {
            finalPaths.add(paths.get(i2).path);
        }
        finishWithListSuccess(finalPaths);
    }

    private boolean setPendingOptionsAndResult(Messages.ImageSelectionOptions imageOptions, Messages.VideoSelectionOptions videoOptions, Messages.Result<List<String>> result) {
        synchronized (this.pendingCallStateLock) {
            if (this.pendingCallState != null) {
                return false;
            }
            this.pendingCallState = new PendingCallState(imageOptions, videoOptions, result);
            this.cache.clear();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishWithSuccess(String imagePath) {
        ArrayList<String> pathList = new ArrayList<>();
        if (imagePath != null) {
            pathList.add(imagePath);
        }
        Messages.Result<List<String>> localResult = null;
        synchronized (this.pendingCallStateLock) {
            PendingCallState pendingCallState = this.pendingCallState;
            if (pendingCallState != null) {
                localResult = pendingCallState.result;
            }
            this.pendingCallState = null;
        }
        if (localResult == null) {
            if (!pathList.isEmpty()) {
                this.cache.saveResult(pathList, null, null);
                return;
            }
            return;
        }
        localResult.success(pathList);
    }

    private void finishWithListSuccess(ArrayList<String> imagePaths) {
        Messages.Result<List<String>> localResult = null;
        synchronized (this.pendingCallStateLock) {
            PendingCallState pendingCallState = this.pendingCallState;
            if (pendingCallState != null) {
                localResult = pendingCallState.result;
            }
            this.pendingCallState = null;
        }
        if (localResult == null) {
            this.cache.saveResult(imagePaths, null, null);
        } else {
            localResult.success(imagePaths);
        }
    }

    private void finishWithAlreadyActiveError(Messages.Result<List<String>> result) {
        result.error(new Messages.FlutterError("already_active", "Image picker is already active", null));
    }

    private void finishWithError(String errorCode, String errorMessage) {
        Messages.Result<List<String>> localResult = null;
        synchronized (this.pendingCallStateLock) {
            PendingCallState pendingCallState = this.pendingCallState;
            if (pendingCallState != null) {
                localResult = pendingCallState.result;
            }
            this.pendingCallState = null;
        }
        if (localResult == null) {
            this.cache.saveResult(null, errorCode, errorMessage);
        } else {
            localResult.error(new Messages.FlutterError(errorCode, errorMessage, null));
        }
    }

    private void useFrontCamera(Intent intent) {
        if (Build.VERSION.SDK_INT >= 22) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
            if (Build.VERSION.SDK_INT >= 26) {
                intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
                return;
            }
            return;
        }
        intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
    }
}
