package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.q;
import java.util.Collections;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public final class a<O extends d> {

    /* renamed from: a  reason: collision with root package name */
    private final AbstractC0036a<?, O> f887a;

    /* renamed from: b  reason: collision with root package name */
    private final g<?> f888b;

    /* renamed from: c  reason: collision with root package name */
    private final String f889c;

    /* renamed from: com.google.android.gms.common.api.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0036a<T extends f, O> extends e<T, O> {
        @Deprecated
        public T buildClient(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, O o5, f.a aVar, f.b bVar) {
            return buildClient(context, looper, dVar, (com.google.android.gms.common.internal.d) o5, (com.google.android.gms.common.api.internal.e) aVar, (com.google.android.gms.common.api.internal.m) bVar);
        }

        public T buildClient(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, O o5, com.google.android.gms.common.api.internal.e eVar, com.google.android.gms.common.api.internal.m mVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    /* loaded from: classes.dex */
    public static class c<C extends b> {
    }

    /* loaded from: classes.dex */
    public interface d {

        /* renamed from: com.google.android.gms.common.api.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public interface InterfaceC0037a extends d {
            Account a();
        }

        /* loaded from: classes.dex */
        public interface b extends d {
            GoogleSignInAccount b();
        }

        /* loaded from: classes.dex */
        public static final class c implements d {
            private c() {
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e<T extends b, O> {
        public static final int API_PRIORITY_GAMES = 1;
        public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;
        public static final int API_PRIORITY_PLUS = 2;

        public List<Scope> getImpliedScopes(O o5) {
            return Collections.emptyList();
        }

        public int getPriority() {
            return API_PRIORITY_OTHER;
        }
    }

    /* loaded from: classes.dex */
    public interface f extends b {
        void connect(c.InterfaceC0039c interfaceC0039c);

        void disconnect();

        void disconnect(String str);

        l0.c[] getAvailableFeatures();

        String getEndpointPackageName();

        String getLastDisconnectMessage();

        int getMinApkVersion();

        void getRemoteService(com.google.android.gms.common.internal.j jVar, Set<Scope> set);

        Set<Scope> getScopesForConnectionlessNonSignIn();

        boolean isConnected();

        boolean isConnecting();

        void onUserSignOut(c.e eVar);

        boolean requiresGooglePlayServices();

        boolean requiresSignIn();
    }

    /* loaded from: classes.dex */
    public static final class g<C extends f> extends c<C> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends f> a(String str, AbstractC0036a<C, O> abstractC0036a, g<C> gVar) {
        q.l(abstractC0036a, "Cannot construct an Api with a null ClientBuilder");
        q.l(gVar, "Cannot construct an Api with a null ClientKey");
        this.f889c = str;
        this.f887a = abstractC0036a;
        this.f888b = gVar;
    }

    public final AbstractC0036a<?, O> a() {
        return this.f887a;
    }

    public final String b() {
        return this.f889c;
    }
}
