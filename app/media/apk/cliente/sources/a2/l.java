package a2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f82a;

    public l(Context context, String str) {
        this.f82a = context.getSharedPreferences("FirebaseHeartBeat" + str, 0);
    }

    private synchronized void a() {
        long j5 = this.f82a.getLong("fire-count", 0L);
        String str = null;
        String str2 = "";
        for (Map.Entry<String, ?> entry : this.f82a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                for (String str3 : (Set) entry.getValue()) {
                    if (str == null || str.compareTo(str3) > 0) {
                        str2 = entry.getKey();
                        str = str3;
                    }
                }
            }
        }
        HashSet hashSet = new HashSet(this.f82a.getStringSet(str2, new HashSet()));
        hashSet.remove(str);
        this.f82a.edit().putStringSet(str2, hashSet).putLong("fire-count", j5 - 1).commit();
    }

    private synchronized String d(long j5) {
        Instant instant;
        if (Build.VERSION.SDK_INT < 26) {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j5));
        }
        instant = new Date(j5).toInstant();
        return instant.atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    private synchronized String e(String str) {
        for (Map.Entry<String, ?> entry : this.f82a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                for (String str2 : (Set) entry.getValue()) {
                    if (str.equals(str2)) {
                        return entry.getKey();
                    }
                }
                continue;
            }
        }
        return null;
    }

    private synchronized void h(String str) {
        String e5 = e(str);
        if (e5 == null) {
            return;
        }
        HashSet hashSet = new HashSet(this.f82a.getStringSet(e5, new HashSet()));
        hashSet.remove(str);
        (hashSet.isEmpty() ? this.f82a.edit().remove(e5) : this.f82a.edit().putStringSet(e5, hashSet)).commit();
    }

    private synchronized void m(String str, String str2) {
        h(str2);
        HashSet hashSet = new HashSet(this.f82a.getStringSet(str, new HashSet()));
        hashSet.add(str2);
        this.f82a.edit().putStringSet(str, hashSet).commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b() {
        SharedPreferences.Editor edit = this.f82a.edit();
        int i5 = 0;
        for (Map.Entry<String, ?> entry : this.f82a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                String d5 = d(System.currentTimeMillis());
                String key = entry.getKey();
                if (((Set) entry.getValue()).contains(d5)) {
                    HashSet hashSet = new HashSet();
                    hashSet.add(d5);
                    i5++;
                    edit.putStringSet(key, hashSet);
                } else {
                    edit.remove(key);
                }
            }
        }
        if (i5 == 0) {
            edit.remove("fire-count");
        } else {
            edit.putLong("fire-count", i5);
        }
        edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<m> c() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : this.f82a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                HashSet hashSet = new HashSet((Set) entry.getValue());
                hashSet.remove(d(System.currentTimeMillis()));
                if (!hashSet.isEmpty()) {
                    arrayList.add(m.a(entry.getKey(), new ArrayList(hashSet)));
                }
            }
        }
        l(System.currentTimeMillis());
        return arrayList;
    }

    synchronized boolean f(long j5, long j6) {
        return d(j5).equals(d(j6));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void g() {
        String d5 = d(System.currentTimeMillis());
        this.f82a.edit().putString("last-used-date", d5).commit();
        h(d5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean i(long j5) {
        return j("fire-global", j5);
    }

    synchronized boolean j(String str, long j5) {
        if (!this.f82a.contains(str)) {
            this.f82a.edit().putLong(str, j5).commit();
            return true;
        } else if (f(this.f82a.getLong(str, -1L), j5)) {
            return false;
        } else {
            this.f82a.edit().putLong(str, j5).commit();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void k(long j5, String str) {
        String d5 = d(j5);
        if (this.f82a.getString("last-used-date", "").equals(d5)) {
            String e5 = e(d5);
            if (e5 == null) {
                return;
            }
            if (e5.equals(str)) {
                return;
            }
            m(str, d5);
            return;
        }
        long j6 = this.f82a.getLong("fire-count", 0L);
        if (j6 + 1 == 30) {
            a();
            j6 = this.f82a.getLong("fire-count", 0L);
        }
        HashSet hashSet = new HashSet(this.f82a.getStringSet(str, new HashSet()));
        hashSet.add(d5);
        this.f82a.edit().putStringSet(str, hashSet).putLong("fire-count", j6 + 1).putString("last-used-date", d5).commit();
    }

    synchronized void l(long j5) {
        this.f82a.edit().putLong("fire-global", j5).commit();
    }
}
