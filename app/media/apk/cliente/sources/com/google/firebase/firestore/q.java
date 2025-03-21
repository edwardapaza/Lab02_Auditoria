package com.google.firebase.firestore;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class q {

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f1759b = Pattern.compile("[~*/\\[\\]]");

    /* renamed from: c  reason: collision with root package name */
    private static final q f1760c = new q(v1.r.f8134b);

    /* renamed from: a  reason: collision with root package name */
    private final v1.r f1761a;

    private q(List<String> list) {
        this.f1761a = v1.r.t(list);
    }

    private q(v1.r rVar) {
        this.f1761a = rVar;
    }

    public static q a() {
        return f1760c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q b(String str) {
        z1.y.c(str, "Provided field path must not be null.");
        z1.y.a(!f1759b.matcher(str).find(), "Use FieldPath.of() for field names containing '~*/[]'.", new Object[0]);
        try {
            return d(str.split("\\.", -1));
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Invalid field path (" + str + "). Paths must not be empty, begin with '.', end with '.', or contain '..'");
        }
    }

    public static q d(String... strArr) {
        z1.y.a(strArr.length > 0, "Invalid field path. Provided path must not be empty.", new Object[0]);
        int i5 = 0;
        while (i5 < strArr.length) {
            String str = strArr[i5];
            boolean z4 = (str == null || str.isEmpty()) ? false : true;
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid field name at argument ");
            i5++;
            sb.append(i5);
            sb.append(". Field names must not be null or empty.");
            z1.y.a(z4, sb.toString(), new Object[0]);
        }
        return new q(Arrays.asList(strArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v1.r c() {
        return this.f1761a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        return this.f1761a.equals(((q) obj).f1761a);
    }

    public int hashCode() {
        return this.f1761a.hashCode();
    }

    public String toString() {
        return this.f1761a.toString();
    }
}
