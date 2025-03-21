package io.flutter.plugins.firebase.messaging;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
/* loaded from: classes2.dex */
public class FlutterFirebaseMessagingInitProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo info) {
        super.attachInfo(context, info);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (ContextHolder.getApplicationContext() == null) {
            Context context = getContext();
            if (context != null && context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            ContextHolder.setApplicationContext(context);
            return false;
        }
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
