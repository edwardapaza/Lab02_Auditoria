package com.google.firebase.firestore;

import java.util.Objects;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private final q f1642a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1643b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1644c;

    /* loaded from: classes.dex */
    public static class b extends a {
        private b(q qVar) {
            super(qVar, "average");
        }
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        private c() {
            super(null, "count");
        }
    }

    /* loaded from: classes.dex */
    public static class d extends a {
        private d(q qVar) {
            super(qVar, "sum");
        }
    }

    private a(q qVar, String str) {
        String str2;
        this.f1642a = qVar;
        this.f1643b = str;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (qVar == null) {
            str2 = "";
        } else {
            str2 = "_" + qVar;
        }
        sb.append(str2);
        this.f1644c = sb.toString();
    }

    public static b a(String str) {
        return new b(q.b(str));
    }

    public static c b() {
        return new c();
    }

    public static d f(String str) {
        return new d(q.b(str));
    }

    public String c() {
        return this.f1644c;
    }

    public String d() {
        q qVar = this.f1642a;
        return qVar == null ? "" : qVar.toString();
    }

    public String e() {
        return this.f1643b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            q qVar = this.f1642a;
            return (qVar == null || aVar.f1642a == null) ? qVar == null && aVar.f1642a == null : this.f1643b.equals(aVar.e()) && d().equals(aVar.d());
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(e(), d());
    }
}
