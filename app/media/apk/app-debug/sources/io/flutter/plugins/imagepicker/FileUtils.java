package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import io.flutter.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
/* loaded from: classes2.dex */
class FileUtils {
    /* JADX INFO: Access modifiers changed from: package-private */
    public String getPathFromUri(Context context, Uri uri) {
        try {
            InputStream inputStream = context.getContentResolver().openInputStream(uri);
            String uuid = UUID.randomUUID().toString();
            File targetDirectory = new File(context.getCacheDir(), uuid);
            targetDirectory.mkdir();
            targetDirectory.deleteOnExit();
            String fileName = getImageName(context, uri);
            String extension = getImageExtension(context, uri);
            if (fileName == null) {
                Log.w("FileUtils", "Cannot get file name for " + uri);
                if (extension == null) {
                    extension = ".jpg";
                }
                fileName = "image_picker" + extension;
            } else if (extension != null) {
                fileName = getBaseName(fileName) + extension;
            }
            File file = new File(targetDirectory, fileName);
            OutputStream outputStream = new FileOutputStream(file);
            copy(inputStream, outputStream);
            String path = file.getPath();
            outputStream.close();
            if (inputStream != null) {
                inputStream.close();
            }
            return path;
        } catch (IOException e) {
            return null;
        } catch (SecurityException e2) {
            return null;
        }
    }

    private static String getImageExtension(Context context, Uri uriImage) {
        String extension;
        try {
            if (uriImage.getScheme().equals("content")) {
                MimeTypeMap mime = MimeTypeMap.getSingleton();
                extension = mime.getExtensionFromMimeType(context.getContentResolver().getType(uriImage));
            } else {
                extension = MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uriImage.getPath())).toString());
            }
            if (extension == null || extension.isEmpty()) {
                return null;
            }
            return "." + extension;
        } catch (Exception e) {
            return null;
        }
    }

    private static String getImageName(Context context, Uri uriImage) {
        Cursor cursor = queryImageName(context, uriImage);
        if (cursor != null) {
            try {
                if (cursor.moveToFirst() && cursor.getColumnCount() >= 1) {
                    String string = cursor.getString(0);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return string;
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    private static Cursor queryImageName(Context context, Uri uriImage) {
        return context.getContentResolver().query(uriImage, new String[]{"_display_name"}, null, null, null);
    }

    private static void copy(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[4096];
        while (true) {
            int bytesRead = in.read(buffer);
            if (bytesRead != -1) {
                out.write(buffer, 0, bytesRead);
            } else {
                out.flush();
                return;
            }
        }
    }

    private static String getBaseName(String fileName) {
        int lastDotIndex = fileName.lastIndexOf(46);
        if (lastDotIndex < 0) {
            return fileName;
        }
        return fileName.substring(0, lastDotIndex);
    }
}
