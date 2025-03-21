package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Account f1086a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Scope> f1087b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Scope> f1088c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<com.google.android.gms.common.api.a<?>, b0> f1089d;

    /* renamed from: e  reason: collision with root package name */
    private final int f1090e;

    /* renamed from: f  reason: collision with root package name */
    private final View f1091f;

    /* renamed from: g  reason: collision with root package name */
    private final String f1092g;

    /* renamed from: h  reason: collision with root package name */
    private final String f1093h;

    /* renamed from: i  reason: collision with root package name */
    private final w0.a f1094i;

    /* renamed from: j  reason: collision with root package name */
    private Integer f1095j;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Account f1096a;

        /* renamed from: b  reason: collision with root package name */
        private androidx.collection.b<Scope> f1097b;

        /* renamed from: c  reason: collision with root package name */
        private String f1098c;

        /* renamed from: d  reason: collision with root package name */
        private String f1099d;

        /* renamed from: e  reason: collision with root package name */
        private w0.a f1100e = w0.a.f8211j;

        public d a() {
            return new d(this.f1096a, this.f1097b, null, 0, null, this.f1098c, this.f1099d, this.f1100e, false);
        }

        public a b(String str) {
            this.f1098c = str;
            return this;
        }

        public final a c(Collection<Scope> collection) {
            if (this.f1097b == null) {
                this.f1097b = new androidx.collection.b<>();
            }
            this.f1097b.addAll(collection);
            return this;
        }

        public final a d(Account account) {
            this.f1096a = account;
            return this;
        }

        public final a e(String str) {
            this.f1099d = str;
            return this;
        }
    }

    public d(Account account, Set<Scope> set, Map<com.google.android.gms.common.api.a<?>, b0> map, int i5, View view, String str, String str2, w0.a aVar, boolean z4) {
        this.f1086a = account;
        Set<Scope> emptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f1087b = emptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.f1089d = map;
        this.f1091f = view;
        this.f1090e = i5;
        this.f1092g = str;
        this.f1093h = str2;
        this.f1094i = aVar == null ? w0.a.f8211j : aVar;
        HashSet hashSet = new HashSet(emptySet);
        for (b0 b0Var : map.values()) {
            hashSet.addAll(b0Var.f1078a);
        }
        this.f1088c = Collections.unmodifiableSet(hashSet);
    }

    public Account a() {
        return this.f1086a;
    }

    public Account b() {
        Account account = this.f1086a;
        return account != null ? account : new Account(c.DEFAULT_ACCOUNT, "com.google");
    }

    public Set<Scope> c() {
        return this.f1088c;
    }

    public String d() {
        return this.f1092g;
    }

    public Set<Scope> e() {
        return this.f1087b;
    }

    public final w0.a f() {
        return this.f1094i;
    }

    public final Integer g() {
        return this.f1095j;
    }

    public final String h() {
        return this.f1093h;
    }

    public final void i(Integer num) {
        this.f1095j = num;
    }
}
