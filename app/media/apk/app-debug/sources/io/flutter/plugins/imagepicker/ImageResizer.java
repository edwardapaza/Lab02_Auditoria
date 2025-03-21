package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import androidx.core.util.SizeFCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
class ImageResizer {
    private final Context context;
    private final ExifDataCopier exifDataCopier;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageResizer(Context context, ExifDataCopier exifDataCopier) {
        this.context = context;
        this.exifDataCopier = exifDataCopier;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String resizeImageIfNeeded(java.lang.String r19, java.lang.Double r20, java.lang.Double r21, int r22) {
        /*
            r18 = this;
            r14 = r18
            r15 = r19
            androidx.core.util.SizeFCompat r16 = r18.readFileDimensions(r19)
            float r0 = r16.getWidth()
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto La0
            float r0 = r16.getHeight()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L1c
            goto La0
        L1c:
            r0 = 1
            if (r20 != 0) goto L2a
            if (r21 != 0) goto L2a
            r1 = 100
            r12 = r22
            if (r12 >= r1) goto L28
            goto L2c
        L28:
            r1 = 0
            goto L2d
        L2a:
            r12 = r22
        L2c:
            r1 = 1
        L2d:
            r17 = r1
            if (r17 != 0) goto L32
            return r15
        L32:
            java.lang.String r1 = "/"
            java.lang.String[] r1 = r15.split(r1)     // Catch: java.io.IOException -> L99
            r11 = r1
            int r1 = r11.length     // Catch: java.io.IOException -> L99
            int r1 = r1 - r0
            r13 = r11[r1]     // Catch: java.io.IOException -> L99
            float r0 = r16.getWidth()     // Catch: java.io.IOException -> L99
            double r2 = (double) r0     // Catch: java.io.IOException -> L99
            float r0 = r16.getHeight()     // Catch: java.io.IOException -> L99
            double r4 = (double) r0     // Catch: java.io.IOException -> L99
            r1 = r18
            r6 = r20
            r7 = r21
            androidx.core.util.SizeFCompat r0 = r1.calculateTargetSize(r2, r4, r6, r7)     // Catch: java.io.IOException -> L99
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options     // Catch: java.io.IOException -> L99
            r1.<init>()     // Catch: java.io.IOException -> L99
            float r2 = r0.getWidth()     // Catch: java.io.IOException -> L99
            int r2 = (int) r2     // Catch: java.io.IOException -> L99
            float r3 = r0.getHeight()     // Catch: java.io.IOException -> L99
            int r3 = (int) r3     // Catch: java.io.IOException -> L99
            int r2 = r14.calculateSampleSize(r1, r2, r3)     // Catch: java.io.IOException -> L99
            r1.inSampleSize = r2     // Catch: java.io.IOException -> L99
            android.graphics.Bitmap r2 = r14.decodeFile(r15, r1)     // Catch: java.io.IOException -> L99
            if (r2 != 0) goto L6f
            return r15
        L6f:
            float r3 = r0.getWidth()     // Catch: java.io.IOException -> L99
            double r3 = (double) r3     // Catch: java.io.IOException -> L99
            java.lang.Double r10 = java.lang.Double.valueOf(r3)     // Catch: java.io.IOException -> L99
            float r3 = r0.getHeight()     // Catch: java.io.IOException -> L99
            double r3 = (double) r3     // Catch: java.io.IOException -> L99
            java.lang.Double r3 = java.lang.Double.valueOf(r3)     // Catch: java.io.IOException -> L99
            r8 = r18
            r9 = r2
            r4 = r11
            r11 = r3
            r12 = r22
            java.io.File r3 = r8.resizedImage(r9, r10, r11, r12, r13)     // Catch: java.io.IOException -> L99
            java.lang.String r5 = r3.getPath()     // Catch: java.io.IOException -> L99
            r14.copyExif(r15, r5)     // Catch: java.io.IOException -> L99
            java.lang.String r5 = r3.getPath()     // Catch: java.io.IOException -> L99
            return r5
        L99:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        La0:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.imagepicker.ImageResizer.resizeImageIfNeeded(java.lang.String, java.lang.Double, java.lang.Double, int):java.lang.String");
    }

    private File resizedImage(Bitmap bmp, Double width, Double height, int imageQuality, String outputImageName) throws IOException {
        Bitmap scaledBmp = createScaledBitmap(bmp, width.intValue(), height.intValue(), false);
        File file = createImageOnExternalDirectory("/scaled_" + outputImageName, scaledBmp, imageQuality);
        return file;
    }

    private SizeFCompat calculateTargetSize(double originalWidth, double originalHeight, Double maxWidth, Double maxHeight) {
        double aspectRatio = originalWidth / originalHeight;
        boolean shouldDownscale = true;
        boolean hasMaxWidth = maxWidth != null;
        boolean hasMaxHeight = maxHeight != null;
        double width = hasMaxWidth ? Math.min(originalWidth, Math.round(maxWidth.doubleValue())) : originalWidth;
        double height = hasMaxHeight ? Math.min(originalHeight, Math.round(maxHeight.doubleValue())) : originalHeight;
        boolean shouldDownscaleWidth = hasMaxWidth && maxWidth.doubleValue() < originalWidth;
        boolean shouldDownscaleHeight = hasMaxHeight && maxHeight.doubleValue() < originalHeight;
        if (!shouldDownscaleWidth && !shouldDownscaleHeight) {
            shouldDownscale = false;
        }
        if (shouldDownscale) {
            double WidthForMaxHeight = height * aspectRatio;
            double heightForMaxWidth = width / aspectRatio;
            if (heightForMaxWidth > height) {
                width = Math.round(WidthForMaxHeight);
            } else {
                height = Math.round(heightForMaxWidth);
            }
        }
        return new SizeFCompat((float) width, (float) height);
    }

    private File createFile(File externalFilesDirectory, String child) {
        File image = new File(externalFilesDirectory, child);
        if (!image.getParentFile().exists()) {
            image.getParentFile().mkdirs();
        }
        return image;
    }

    private FileOutputStream createOutputStream(File imageFile) throws IOException {
        return new FileOutputStream(imageFile);
    }

    private void copyExif(String filePathOri, String filePathDest) {
        try {
            this.exifDataCopier.copyExif(new ExifInterface(filePathOri), new ExifInterface(filePathDest));
        } catch (Exception ex) {
            Log.e("ImageResizer", "Error preserving Exif data on selected image: " + ex);
        }
    }

    SizeFCompat readFileDimensions(String path) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        decodeFile(path, options);
        return new SizeFCompat(options.outWidth, options.outHeight);
    }

    private Bitmap decodeFile(String path, BitmapFactory.Options opts) {
        return BitmapFactory.decodeFile(path, opts);
    }

    private Bitmap createScaledBitmap(Bitmap bmp, int width, int height, boolean filter) {
        return Bitmap.createScaledBitmap(bmp, width, height, filter);
    }

    private int calculateSampleSize(BitmapFactory.Options options, int targetWidth, int targetHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        int sampleSize = 1;
        if (height > targetHeight || width > targetWidth) {
            int halfHeight = height / 2;
            int halfWidth = width / 2;
            while (halfHeight / sampleSize >= targetHeight && halfWidth / sampleSize >= targetWidth) {
                sampleSize *= 2;
            }
        }
        return sampleSize;
    }

    private File createImageOnExternalDirectory(String name, Bitmap bitmap, int imageQuality) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        boolean saveAsPNG = bitmap.hasAlpha();
        if (saveAsPNG) {
            Log.d("ImageResizer", "image_picker: compressing is not supported for type PNG. Returning the image with original quality");
        }
        bitmap.compress(saveAsPNG ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, imageQuality, outputStream);
        File cacheDirectory = this.context.getCacheDir();
        File imageFile = createFile(cacheDirectory, name);
        FileOutputStream fileOutput = createOutputStream(imageFile);
        fileOutput.write(outputStream.toByteArray());
        fileOutput.close();
        return imageFile;
    }
}
