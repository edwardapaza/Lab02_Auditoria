package u1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import com.google.firebase.firestore.z;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import u1.a3;
import u1.o0;
/* loaded from: classes.dex */
public final class a3 extends e1 {

    /* renamed from: c  reason: collision with root package name */
    private final c f7727c;

    /* renamed from: d  reason: collision with root package name */
    private final o f7728d;

    /* renamed from: e  reason: collision with root package name */
    private final f4 f7729e;

    /* renamed from: f  reason: collision with root package name */
    private final o1 f7730f;

    /* renamed from: g  reason: collision with root package name */
    private final g3 f7731g;

    /* renamed from: h  reason: collision with root package name */
    private final i2 f7732h;

    /* renamed from: i  reason: collision with root package name */
    private final SQLiteTransactionListener f7733i;

    /* renamed from: j  reason: collision with root package name */
    private SQLiteDatabase f7734j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f7735k;

    /* loaded from: classes.dex */
    class a implements SQLiteTransactionListener {
        a() {
        }

        @Override // android.database.sqlite.SQLiteTransactionListener
        public void onBegin() {
            a3.this.f7732h.i();
        }

        @Override // android.database.sqlite.SQLiteTransactionListener
        public void onCommit() {
            a3.this.f7732h.f();
        }

        @Override // android.database.sqlite.SQLiteTransactionListener
        public void onRollback() {
        }
    }

    /* loaded from: classes.dex */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        private final a3 f7737a;

        /* renamed from: b  reason: collision with root package name */
        private final String f7738b;

        /* renamed from: c  reason: collision with root package name */
        private final String f7739c;

        /* renamed from: d  reason: collision with root package name */
        private final List<Object> f7740d;

        /* renamed from: e  reason: collision with root package name */
        private int f7741e;

        /* renamed from: f  reason: collision with root package name */
        private final Iterator<Object> f7742f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(a3 a3Var, String str, List<Object> list, String str2) {
            this.f7741e = 0;
            this.f7737a = a3Var;
            this.f7738b = str;
            this.f7740d = Collections.emptyList();
            this.f7739c = str2;
            this.f7742f = list.iterator();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(a3 a3Var, String str, List<Object> list, List<Object> list2, String str2) {
            this.f7741e = 0;
            this.f7737a = a3Var;
            this.f7738b = str;
            this.f7740d = list;
            this.f7739c = str2;
            this.f7742f = list2.iterator();
        }

        private Object[] b() {
            ArrayList arrayList = new ArrayList(this.f7740d);
            for (int i5 = 0; this.f7742f.hasNext() && i5 < 900 - this.f7740d.size(); i5++) {
                arrayList.add(this.f7742f.next());
            }
            return arrayList.toArray();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            this.f7741e++;
            Object[] b5 = b();
            this.f7737a.v(this.f7738b + ((Object) z1.h0.z("?", b5.length, ", ")) + this.f7739c, b5);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int c() {
            return this.f7741e;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean d() {
            return this.f7742f.hasNext();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public d e() {
            Object[] b5;
            this.f7741e++;
            return this.f7737a.E(this.f7738b + ((Object) z1.h0.z("?", b5.length, ", ")) + this.f7739c).b(b());
        }
    }

    /* loaded from: classes.dex */
    static class c extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        private final o f7743a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f7744b;

        private c(Context context, o oVar, String str) {
            this(context, oVar, str, 16);
        }

        c(Context context, o oVar, String str, int i5) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i5);
            this.f7743a = oVar;
        }

        /* synthetic */ c(Context context, o oVar, String str, a aVar) {
            this(context, oVar, str);
        }

        private void c(SQLiteDatabase sQLiteDatabase) {
            if (this.f7744b) {
                return;
            }
            onConfigure(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f7744b = true;
            sQLiteDatabase.rawQuery("PRAGMA locking_mode = EXCLUSIVE", new String[0]).close();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            c(sQLiteDatabase);
            new z3(sQLiteDatabase, this.f7743a).j0(0);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
            c(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            c(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
            c(sQLiteDatabase);
            new z3(sQLiteDatabase, this.f7743a).j0(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private final SQLiteDatabase f7745a;

        /* renamed from: b  reason: collision with root package name */
        private final String f7746b;

        /* renamed from: c  reason: collision with root package name */
        private SQLiteDatabase.CursorFactory f7747c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(SQLiteDatabase sQLiteDatabase, String str) {
            this.f7745a = sQLiteDatabase;
            this.f7746b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Cursor g(Object[] objArr, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            a3.r(sQLiteQuery, objArr);
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }

        private Cursor h() {
            SQLiteDatabase.CursorFactory cursorFactory = this.f7747c;
            return cursorFactory != null ? this.f7745a.rawQueryWithFactory(cursorFactory, this.f7746b, null, null) : this.f7745a.rawQuery(this.f7746b, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public d b(final Object... objArr) {
            this.f7747c = new SQLiteDatabase.CursorFactory() { // from class: u1.b3
                @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
                public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                    Cursor g5;
                    g5 = a3.d.g(objArr, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
                    return g5;
                }
            };
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int c(z1.n<Cursor> nVar) {
            Cursor h5 = h();
            try {
                if (!h5.moveToFirst()) {
                    h5.close();
                    return 0;
                }
                nVar.accept(h5);
                h5.close();
                return 1;
            } catch (Throwable th) {
                if (h5 != null) {
                    try {
                        h5.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public <T> T d(z1.u<Cursor, T> uVar) {
            Cursor h5 = h();
            try {
                if (!h5.moveToFirst()) {
                    h5.close();
                    return null;
                }
                T apply = uVar.apply(h5);
                h5.close();
                return apply;
            } catch (Throwable th) {
                if (h5 != null) {
                    try {
                        h5.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int e(z1.n<Cursor> nVar) {
            Cursor h5 = h();
            int i5 = 0;
            while (h5.moveToNext()) {
                try {
                    i5++;
                    nVar.accept(h5);
                } catch (Throwable th) {
                    if (h5 != null) {
                        try {
                            h5.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            h5.close();
            return i5;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean f() {
            Cursor h5 = h();
            try {
                boolean z4 = !h5.moveToFirst();
                h5.close();
                return z4;
            } catch (Throwable th) {
                if (h5 != null) {
                    try {
                        h5.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    public a3(Context context, String str, v1.f fVar, o oVar, o0.b bVar) {
        this(oVar, bVar, new c(context, oVar, t(str, fVar), (a) null));
    }

    public a3(o oVar, o0.b bVar, c cVar) {
        this.f7733i = new a();
        this.f7727c = cVar;
        this.f7728d = oVar;
        this.f7729e = new f4(this, oVar);
        this.f7730f = new o1(this, oVar);
        this.f7731g = new g3(this, oVar);
        this.f7732h = new i2(this, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long B(Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long C(Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(SQLiteProgram sQLiteProgram, Object[] objArr) {
        int i5;
        long longValue;
        for (int i6 = 0; i6 < objArr.length; i6++) {
            Object obj = objArr[i6];
            if (obj == null) {
                sQLiteProgram.bindNull(i6 + 1);
            } else if (obj instanceof String) {
                sQLiteProgram.bindString(i6 + 1, (String) obj);
            } else {
                if (obj instanceof Integer) {
                    i5 = i6 + 1;
                    longValue = ((Integer) obj).intValue();
                } else if (obj instanceof Long) {
                    i5 = i6 + 1;
                    longValue = ((Long) obj).longValue();
                } else if (obj instanceof Double) {
                    sQLiteProgram.bindDouble(i6 + 1, ((Double) obj).doubleValue());
                } else if (!(obj instanceof byte[])) {
                    throw z1.b.a("Unknown argument %s of type %s", obj, obj.getClass());
                } else {
                    sQLiteProgram.bindBlob(i6 + 1, (byte[]) obj);
                }
                sQLiteProgram.bindLong(i5, longValue);
            }
        }
    }

    public static void s(Context context, v1.f fVar, String str) {
        String path = context.getDatabasePath(t(str, fVar)).getPath();
        String str2 = path + "-wal";
        File file = new File(path);
        File file2 = new File(path + "-journal");
        File file3 = new File(str2);
        try {
            z1.t.a(file);
            z1.t.a(file2);
            z1.t.a(file3);
        } catch (IOException e5) {
            throw new com.google.firebase.firestore.z("Failed to clear persistence." + e5, z.a.UNKNOWN);
        }
    }

    public static String t(String str, v1.f fVar) {
        try {
            return "firestore." + URLEncoder.encode(str, "utf-8") + "." + URLEncoder.encode(fVar.h(), "utf-8") + "." + URLEncoder.encode(fVar.e(), "utf-8");
        } catch (UnsupportedEncodingException e5) {
            throw new AssertionError(e5);
        }
    }

    private long x() {
        return ((Long) E("PRAGMA page_count").d(new z1.u() { // from class: u1.z2
            @Override // z1.u
            public final Object apply(Object obj) {
                Long B;
                B = a3.B((Cursor) obj);
                return B;
            }
        })).longValue();
    }

    private long y() {
        return ((Long) E("PRAGMA page_size").d(new z1.u() { // from class: u1.y2
            @Override // z1.u
            public final Object apply(Object obj) {
                Long C;
                C = a3.C((Cursor) obj);
                return C;
            }
        })).longValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // u1.e1
    /* renamed from: A */
    public f4 h() {
        return this.f7729e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteStatement D(String str) {
        return this.f7734j.compileStatement(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d E(String str) {
        return new d(this.f7734j, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // u1.e1
    public u1.a a() {
        return this.f7730f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // u1.e1
    public u1.b b(q1.j jVar) {
        return new v1(this, this.f7728d, jVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // u1.e1
    public l c(q1.j jVar) {
        return new e2(this, this.f7728d, jVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // u1.e1
    public b1 d(q1.j jVar, l lVar) {
        return new t2(this, this.f7728d, jVar, lVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // u1.e1
    public c1 e() {
        return new x2(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // u1.e1
    public l1 g() {
        return this.f7731g;
    }

    @Override // u1.e1
    public boolean i() {
        return this.f7735k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // u1.e1
    public <T> T j(String str, z1.z<T> zVar) {
        z1.w.a(e1.f7782a, "Starting transaction: %s", str);
        this.f7734j.beginTransactionWithListener(this.f7733i);
        try {
            T t5 = zVar.get();
            this.f7734j.setTransactionSuccessful();
            return t5;
        } finally {
            this.f7734j.endTransaction();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // u1.e1
    public void k(String str, Runnable runnable) {
        z1.w.a(e1.f7782a, "Starting transaction: %s", str);
        this.f7734j.beginTransactionWithListener(this.f7733i);
        try {
            runnable.run();
            this.f7734j.setTransactionSuccessful();
        } finally {
            this.f7734j.endTransaction();
        }
    }

    @Override // u1.e1
    public void l() {
        z1.b.d(this.f7735k, "SQLitePersistence shutdown without start!", new Object[0]);
        this.f7735k = false;
        this.f7734j.close();
        this.f7734j = null;
    }

    @Override // u1.e1
    public void m() {
        z1.b.d(!this.f7735k, "SQLitePersistence double-started!", new Object[0]);
        this.f7735k = true;
        try {
            this.f7734j = this.f7727c.getWritableDatabase();
            this.f7729e.B();
            this.f7732h.z(this.f7729e.r());
        } catch (SQLiteDatabaseLockedException e5) {
            throw new RuntimeException("Failed to gain exclusive lock to the Cloud Firestore client's offline persistence. This generally means you are using Cloud Firestore from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing Cloud Firestore in your Application class. If you are intentionally using Cloud Firestore from multiple processes, you can only enable offline persistence (that is, call setPersistenceEnabled(true)) in one of them.", e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int u(SQLiteStatement sQLiteStatement, Object... objArr) {
        sQLiteStatement.clearBindings();
        r(sQLiteStatement, objArr);
        return sQLiteStatement.executeUpdateDelete();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(String str, Object... objArr) {
        this.f7734j.execSQL(str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long w() {
        return x() * y();
    }

    @Override // u1.e1
    /* renamed from: z */
    public i2 f() {
        return this.f7732h;
    }
}
