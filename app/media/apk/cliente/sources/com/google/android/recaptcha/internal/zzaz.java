package com.google.android.recaptcha.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import e4.g;
import e4.k;
import java.util.ArrayList;
import java.util.List;
import t3.o;
import t3.p;
import t3.x;
/* loaded from: classes.dex */
public final class zzaz extends SQLiteOpenHelper {
    public static final zzax zza = new zzax(null);
    private static final int zzb;
    private static zzaz zzc;

    static {
        int zzb2;
        zzb2 = zzax.zzb("18.4.0");
        zzb = zzb2;
    }

    public /* synthetic */ zzaz(Context context, g gVar) {
        super(context, "cesdb", (SQLiteDatabase.CursorFactory) null, zzb);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE ce (id INTEGER PRIMARY KEY,ts BIGINT NOT NULL,ss TEXT NOT NULL)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ce");
        sQLiteDatabase.execSQL("CREATE TABLE ce (id INTEGER PRIMARY KEY,ts BIGINT NOT NULL,ss TEXT NOT NULL)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ce");
        sQLiteDatabase.execSQL("CREATE TABLE ce (id INTEGER PRIMARY KEY,ts BIGINT NOT NULL,ss TEXT NOT NULL)");
    }

    public final int zza(List list) {
        String w5;
        if (list.isEmpty()) {
            return 0;
        }
        w5 = x.w(list, ", ", "(", ")", 0, null, zzay.zza, 24, null);
        return getWritableDatabase().delete("ce", "id IN ".concat(String.valueOf(w5)), null);
    }

    public final int zzb() {
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT COUNT(*) FROM ce", null);
        int i5 = -1;
        try {
            if (rawQuery.moveToNext()) {
                i5 = rawQuery.getInt(0);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
        rawQuery.close();
        return i5;
    }

    public final List zzd() {
        Cursor query = getReadableDatabase().query("ce", null, null, null, null, null, "ts ASC");
        List arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                try {
                    int i5 = query.getInt(query.getColumnIndexOrThrow("id"));
                    String string = query.getString(query.getColumnIndexOrThrow("ss"));
                    long j5 = query.getLong(query.getColumnIndexOrThrow("ts"));
                    k.b(string);
                    arrayList.add(new zzba(string, j5, i5));
                } catch (Exception unused) {
                    arrayList = p.f();
                }
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    public final boolean zzf(zzba zzbaVar) {
        List b5;
        b5 = o.b(zzbaVar);
        return zza(b5) == 1;
    }
}
