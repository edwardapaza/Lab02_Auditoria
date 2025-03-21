package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.q;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements p {

    /* renamed from: a  reason: collision with root package name */
    private final Context f352a;

    /* renamed from: b  reason: collision with root package name */
    private final Notification.Builder f353b;

    /* renamed from: c  reason: collision with root package name */
    private final q.d f354c;

    /* renamed from: d  reason: collision with root package name */
    private RemoteViews f355d;

    /* renamed from: e  reason: collision with root package name */
    private RemoteViews f356e;

    /* renamed from: f  reason: collision with root package name */
    private final List<Bundle> f357f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f358g = new Bundle();

    /* renamed from: h  reason: collision with root package name */
    private int f359h;

    /* renamed from: i  reason: collision with root package name */
    private RemoteViews f360i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        static Notification.Action.Builder e(int i5, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i5, charSequence, pendingIntent);
        }

        static String f(Notification notification) {
            return notification.getGroup();
        }

        static Notification.Builder g(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        static Notification.Builder h(Notification.Builder builder, boolean z4) {
            return builder.setGroupSummary(z4);
        }

        static Notification.Builder i(Notification.Builder builder, boolean z4) {
            return builder.setLocalOnly(z4);
        }

        static Notification.Builder j(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    /* loaded from: classes.dex */
    static class b {
        static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        static Notification.Builder c(Notification.Builder builder, int i5) {
            return builder.setColor(i5);
        }

        static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        static Notification.Builder f(Notification.Builder builder, int i5) {
            return builder.setVisibility(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {
        static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        static Notification.Builder b(Notification.Builder builder, Icon icon) {
            Notification.Builder largeIcon;
            largeIcon = builder.setLargeIcon(icon);
            return largeIcon;
        }

        static Notification.Builder c(Notification.Builder builder, Object obj) {
            Notification.Builder smallIcon;
            smallIcon = builder.setSmallIcon((Icon) obj);
            return smallIcon;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z4) {
            Notification.Action.Builder allowGeneratedReplies;
            allowGeneratedReplies = builder.setAllowGeneratedReplies(z4);
            return allowGeneratedReplies;
        }

        static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            Notification.Builder customBigContentView;
            customBigContentView = builder.setCustomBigContentView(remoteViews);
            return customBigContentView;
        }

        static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            Notification.Builder customContentView;
            customContentView = builder.setCustomContentView(remoteViews);
            return customContentView;
        }

        static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            Notification.Builder customHeadsUpContentView;
            customHeadsUpContentView = builder.setCustomHeadsUpContentView(remoteViews);
            return customHeadsUpContentView;
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            Notification.Builder remoteInputHistory;
            remoteInputHistory = builder.setRemoteInputHistory(charSequenceArr);
            return remoteInputHistory;
        }
    }

    /* loaded from: classes.dex */
    static class e {
        static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        static Notification.Builder b(Notification.Builder builder, int i5) {
            Notification.Builder badgeIconType;
            badgeIconType = builder.setBadgeIconType(i5);
            return badgeIconType;
        }

        static Notification.Builder c(Notification.Builder builder, boolean z4) {
            Notification.Builder colorized;
            colorized = builder.setColorized(z4);
            return colorized;
        }

        static Notification.Builder d(Notification.Builder builder, int i5) {
            Notification.Builder groupAlertBehavior;
            groupAlertBehavior = builder.setGroupAlertBehavior(i5);
            return groupAlertBehavior;
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            Notification.Builder settingsText;
            settingsText = builder.setSettingsText(charSequence);
            return settingsText;
        }

        static Notification.Builder f(Notification.Builder builder, String str) {
            Notification.Builder shortcutId;
            shortcutId = builder.setShortcutId(str);
            return shortcutId;
        }

        static Notification.Builder g(Notification.Builder builder, long j5) {
            Notification.Builder timeoutAfter;
            timeoutAfter = builder.setTimeoutAfter(j5);
            return timeoutAfter;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class f {
        static Notification.Builder a(Notification.Builder builder, Person person) {
            Notification.Builder addPerson;
            addPerson = builder.addPerson(person);
            return addPerson;
        }

        static Notification.Action.Builder b(Notification.Action.Builder builder, int i5) {
            Notification.Action.Builder semanticAction;
            semanticAction = builder.setSemanticAction(i5);
            return semanticAction;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class g {
        static Notification.Builder a(Notification.Builder builder, boolean z4) {
            Notification.Builder allowSystemGeneratedContextualActions;
            allowSystemGeneratedContextualActions = builder.setAllowSystemGeneratedContextualActions(z4);
            return allowSystemGeneratedContextualActions;
        }

        static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            Notification.Builder bubbleMetadata2;
            bubbleMetadata2 = builder.setBubbleMetadata(bubbleMetadata);
            return bubbleMetadata2;
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z4) {
            Notification.Action.Builder contextual;
            contextual = builder.setContextual(z4);
            return contextual;
        }

        static Notification.Builder d(Notification.Builder builder, Object obj) {
            Notification.Builder locusId;
            locusId = builder.setLocusId((LocusId) obj);
            return locusId;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class h {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z4) {
            Notification.Action.Builder authenticationRequired;
            authenticationRequired = builder.setAuthenticationRequired(z4);
            return authenticationRequired;
        }

        static Notification.Builder b(Notification.Builder builder, int i5) {
            Notification.Builder foregroundServiceBehavior;
            foregroundServiceBehavior = builder.setForegroundServiceBehavior(i5);
            return foregroundServiceBehavior;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(q.d dVar) {
        int i5;
        Object obj;
        this.f354c = dVar;
        Context context = dVar.f295a;
        this.f352a = context;
        int i6 = Build.VERSION.SDK_INT;
        this.f353b = i6 >= 26 ? e.a(context, dVar.K) : new Notification.Builder(dVar.f295a);
        Notification notification = dVar.R;
        this.f353b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, dVar.f303i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(dVar.f299e).setContentText(dVar.f300f).setContentInfo(dVar.f305k).setContentIntent(dVar.f301g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.f302h, (notification.flags & 128) != 0).setNumber(dVar.f306l).setProgress(dVar.f314t, dVar.f315u, dVar.f316v);
        if (i6 < 23) {
            Notification.Builder builder = this.f353b;
            IconCompat iconCompat = dVar.f304j;
            builder.setLargeIcon(iconCompat == null ? null : iconCompat.i());
        } else {
            Notification.Builder builder2 = this.f353b;
            IconCompat iconCompat2 = dVar.f304j;
            c.b(builder2, iconCompat2 == null ? null : iconCompat2.s(context));
        }
        this.f353b.setSubText(dVar.f311q).setUsesChronometer(dVar.f309o).setPriority(dVar.f307m);
        q.f fVar = dVar.f310p;
        if (fVar instanceof q.e) {
            for (q.a aVar : ((q.e) fVar).h()) {
                b(aVar);
            }
        } else {
            Iterator<q.a> it = dVar.f296b.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
        }
        Bundle bundle = dVar.D;
        if (bundle != null) {
            this.f358g.putAll(bundle);
        }
        int i7 = Build.VERSION.SDK_INT;
        this.f355d = dVar.H;
        this.f356e = dVar.I;
        this.f353b.setShowWhen(dVar.f308n);
        a.i(this.f353b, dVar.f320z);
        a.g(this.f353b, dVar.f317w);
        a.j(this.f353b, dVar.f319y);
        a.h(this.f353b, dVar.f318x);
        this.f359h = dVar.O;
        b.b(this.f353b, dVar.C);
        b.c(this.f353b, dVar.E);
        b.f(this.f353b, dVar.F);
        b.d(this.f353b, dVar.G);
        b.e(this.f353b, notification.sound, notification.audioAttributes);
        List<String> e5 = i7 < 28 ? e(f(dVar.f297c), dVar.U) : dVar.U;
        if (e5 != null && !e5.isEmpty()) {
            for (String str : e5) {
                b.a(this.f353b, str);
            }
        }
        this.f360i = dVar.J;
        if (dVar.f298d.size() > 0) {
            Bundle bundle2 = dVar.c().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i8 = 0; i8 < dVar.f298d.size(); i8++) {
                bundle4.putBundle(Integer.toString(i8), n0.a(dVar.f298d.get(i8)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            dVar.c().putBundle("android.car.EXTENSIONS", bundle2);
            this.f358g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 23 && (obj = dVar.T) != null) {
            c.c(this.f353b, obj);
        }
        if (i9 >= 24) {
            this.f353b.setExtras(dVar.D);
            d.e(this.f353b, dVar.f313s);
            RemoteViews remoteViews = dVar.H;
            if (remoteViews != null) {
                d.c(this.f353b, remoteViews);
            }
            RemoteViews remoteViews2 = dVar.I;
            if (remoteViews2 != null) {
                d.b(this.f353b, remoteViews2);
            }
            RemoteViews remoteViews3 = dVar.J;
            if (remoteViews3 != null) {
                d.d(this.f353b, remoteViews3);
            }
        }
        if (i9 >= 26) {
            e.b(this.f353b, dVar.L);
            e.e(this.f353b, dVar.f312r);
            e.f(this.f353b, dVar.M);
            e.g(this.f353b, dVar.N);
            e.d(this.f353b, dVar.O);
            if (dVar.B) {
                e.c(this.f353b, dVar.A);
            }
            if (!TextUtils.isEmpty(dVar.K)) {
                this.f353b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i9 >= 28) {
            Iterator<t0> it2 = dVar.f297c.iterator();
            while (it2.hasNext()) {
                f.a(this.f353b, it2.next().h());
            }
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            g.a(this.f353b, dVar.Q);
            g.b(this.f353b, q.c.a(null));
        }
        if (i10 >= 31 && (i5 = dVar.P) != 0) {
            h.b(this.f353b, i5);
        }
        if (dVar.S) {
            if (this.f354c.f318x) {
                this.f359h = 2;
            } else {
                this.f359h = 1;
            }
            this.f353b.setVibrate(null);
            this.f353b.setSound(null);
            int i11 = notification.defaults & (-2) & (-3);
            notification.defaults = i11;
            this.f353b.setDefaults(i11);
            if (i10 >= 26) {
                if (TextUtils.isEmpty(this.f354c.f317w)) {
                    a.g(this.f353b, "silent");
                }
                e.d(this.f353b, this.f359h);
            }
        }
    }

    private void b(q.a aVar) {
        int i5 = Build.VERSION.SDK_INT;
        IconCompat d5 = aVar.d();
        Notification.Action.Builder a5 = i5 >= 23 ? c.a(d5 != null ? d5.r() : null, aVar.h(), aVar.a()) : a.e(d5 != null ? d5.j() : 0, aVar.h(), aVar.a());
        if (aVar.e() != null) {
            for (RemoteInput remoteInput : v0.b(aVar.e())) {
                a.c(a5, remoteInput);
            }
        }
        Bundle bundle = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 24) {
            d.a(a5, aVar.b());
        }
        bundle.putInt("android.support.action.semanticAction", aVar.f());
        if (i6 >= 28) {
            f.b(a5, aVar.f());
        }
        if (i6 >= 29) {
            g.c(a5, aVar.j());
        }
        if (i6 >= 31) {
            h.a(a5, aVar.i());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.g());
        a.b(a5, bundle);
        a.a(this.f353b, a.d(a5));
    }

    private static List<String> e(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        androidx.collection.b bVar = new androidx.collection.b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    private static List<String> f(List<t0> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (t0 t0Var : list) {
            arrayList.add(t0Var.g());
        }
        return arrayList;
    }

    private void g(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults = notification.defaults & (-2) & (-3);
    }

    @Override // androidx.core.app.p
    public Notification.Builder a() {
        return this.f353b;
    }

    public Notification c() {
        Bundle a5;
        RemoteViews f5;
        RemoteViews d5;
        q.f fVar = this.f354c.f310p;
        if (fVar != null) {
            fVar.b(this);
        }
        RemoteViews e5 = fVar != null ? fVar.e(this) : null;
        Notification d6 = d();
        if (e5 != null || (e5 = this.f354c.H) != null) {
            d6.contentView = e5;
        }
        if (fVar != null && (d5 = fVar.d(this)) != null) {
            d6.bigContentView = d5;
        }
        if (fVar != null && (f5 = this.f354c.f310p.f(this)) != null) {
            d6.headsUpContentView = f5;
        }
        if (fVar != null && (a5 = q.a(d6)) != null) {
            fVar.a(a5);
        }
        return d6;
    }

    protected Notification d() {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 26) {
            return this.f353b.build();
        }
        if (i5 >= 24) {
            Notification build = this.f353b.build();
            if (this.f359h != 0) {
                if (a.f(build) != null && (build.flags & 512) != 0 && this.f359h == 2) {
                    g(build);
                }
                if (a.f(build) != null && (build.flags & 512) == 0 && this.f359h == 1) {
                    g(build);
                }
            }
            return build;
        }
        this.f353b.setExtras(this.f358g);
        Notification build2 = this.f353b.build();
        RemoteViews remoteViews = this.f355d;
        if (remoteViews != null) {
            build2.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.f356e;
        if (remoteViews2 != null) {
            build2.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.f360i;
        if (remoteViews3 != null) {
            build2.headsUpContentView = remoteViews3;
        }
        if (this.f359h != 0) {
            if (a.f(build2) != null && (build2.flags & 512) != 0 && this.f359h == 2) {
                g(build2);
            }
            if (a.f(build2) != null && (build2.flags & 512) == 0 && this.f359h == 1) {
                g(build2);
            }
        }
        return build2;
    }
}
