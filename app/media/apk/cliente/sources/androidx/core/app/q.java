package androidx.core.app;

import android.app.Notification;
import android.app.Notification$CallStyle;
import android.app.PendingIntent;
import android.app.Person;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes.dex */
public class q {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Bundle f272a;

        /* renamed from: b  reason: collision with root package name */
        private IconCompat f273b;

        /* renamed from: c  reason: collision with root package name */
        private final v0[] f274c;

        /* renamed from: d  reason: collision with root package name */
        private final v0[] f275d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f276e;

        /* renamed from: f  reason: collision with root package name */
        boolean f277f;

        /* renamed from: g  reason: collision with root package name */
        private final int f278g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f279h;
        @Deprecated

        /* renamed from: i  reason: collision with root package name */
        public int f280i;

        /* renamed from: j  reason: collision with root package name */
        public CharSequence f281j;

        /* renamed from: k  reason: collision with root package name */
        public PendingIntent f282k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f283l;

        /* renamed from: androidx.core.app.q$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0013a {

            /* renamed from: a  reason: collision with root package name */
            private final IconCompat f284a;

            /* renamed from: b  reason: collision with root package name */
            private final CharSequence f285b;

            /* renamed from: c  reason: collision with root package name */
            private final PendingIntent f286c;

            /* renamed from: d  reason: collision with root package name */
            private boolean f287d;

            /* renamed from: e  reason: collision with root package name */
            private final Bundle f288e;

            /* renamed from: f  reason: collision with root package name */
            private ArrayList<v0> f289f;

            /* renamed from: g  reason: collision with root package name */
            private int f290g;

            /* renamed from: h  reason: collision with root package name */
            private boolean f291h;

            /* renamed from: i  reason: collision with root package name */
            private boolean f292i;

            /* renamed from: j  reason: collision with root package name */
            private boolean f293j;

            public C0013a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            private C0013a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, v0[] v0VarArr, boolean z4, int i5, boolean z5, boolean z6, boolean z7) {
                this.f287d = true;
                this.f291h = true;
                this.f284a = iconCompat;
                this.f285b = d.d(charSequence);
                this.f286c = pendingIntent;
                this.f288e = bundle;
                this.f289f = v0VarArr == null ? null : new ArrayList<>(Arrays.asList(v0VarArr));
                this.f287d = z4;
                this.f290g = i5;
                this.f291h = z5;
                this.f292i = z6;
                this.f293j = z7;
            }

            private void b() {
                if (this.f292i && this.f286c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public a a() {
                b();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<v0> arrayList3 = this.f289f;
                if (arrayList3 != null) {
                    Iterator<v0> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        v0 next = it.next();
                        if (next.j()) {
                            arrayList.add(next);
                        } else {
                            arrayList2.add(next);
                        }
                    }
                }
                v0[] v0VarArr = arrayList.isEmpty() ? null : (v0[]) arrayList.toArray(new v0[arrayList.size()]);
                return new a(this.f284a, this.f285b, this.f286c, this.f288e, arrayList2.isEmpty() ? null : (v0[]) arrayList2.toArray(new v0[arrayList2.size()]), v0VarArr, this.f287d, this.f290g, this.f291h, this.f292i, this.f293j);
            }
        }

        public a(int i5, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i5 != 0 ? IconCompat.h(null, "", i5) : null, charSequence, pendingIntent);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, v0[] v0VarArr, v0[] v0VarArr2, boolean z4, int i5, boolean z5, boolean z6, boolean z7) {
            this.f277f = true;
            this.f273b = iconCompat;
            if (iconCompat != null && iconCompat.l() == 2) {
                this.f280i = iconCompat.j();
            }
            this.f281j = d.d(charSequence);
            this.f282k = pendingIntent;
            this.f272a = bundle == null ? new Bundle() : bundle;
            this.f274c = v0VarArr;
            this.f275d = v0VarArr2;
            this.f276e = z4;
            this.f278g = i5;
            this.f277f = z5;
            this.f279h = z6;
            this.f283l = z7;
        }

        public PendingIntent a() {
            return this.f282k;
        }

        public boolean b() {
            return this.f276e;
        }

        public Bundle c() {
            return this.f272a;
        }

        public IconCompat d() {
            int i5;
            if (this.f273b == null && (i5 = this.f280i) != 0) {
                this.f273b = IconCompat.h(null, "", i5);
            }
            return this.f273b;
        }

        public v0[] e() {
            return this.f274c;
        }

        public int f() {
            return this.f278g;
        }

        public boolean g() {
            return this.f277f;
        }

        public CharSequence h() {
            return this.f281j;
        }

        public boolean i() {
            return this.f283l;
        }

        public boolean j() {
            return this.f279h;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends f {

        /* renamed from: e  reason: collision with root package name */
        private CharSequence f294e;

        @Override // androidx.core.app.q.f
        public void a(Bundle bundle) {
            super.a(bundle);
        }

        @Override // androidx.core.app.q.f
        public void b(p pVar) {
            Notification.BigTextStyle bigText = new Notification.BigTextStyle(pVar.a()).setBigContentTitle(this.f332b).bigText(this.f294e);
            if (this.f334d) {
                bigText.setSummaryText(this.f333c);
            }
        }

        @Override // androidx.core.app.q.f
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public b h(CharSequence charSequence) {
            this.f294e = d.d(charSequence);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {
        public static Notification.BubbleMetadata a(c cVar) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        boolean A;
        boolean B;
        String C;
        Bundle D;
        int E;
        int F;
        Notification G;
        RemoteViews H;
        RemoteViews I;
        RemoteViews J;
        String K;
        int L;
        String M;
        long N;
        int O;
        int P;
        boolean Q;
        Notification R;
        boolean S;
        Object T;
        @Deprecated
        public ArrayList<String> U;

        /* renamed from: a  reason: collision with root package name */
        public Context f295a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<a> f296b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<t0> f297c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<a> f298d;

        /* renamed from: e  reason: collision with root package name */
        CharSequence f299e;

        /* renamed from: f  reason: collision with root package name */
        CharSequence f300f;

        /* renamed from: g  reason: collision with root package name */
        PendingIntent f301g;

        /* renamed from: h  reason: collision with root package name */
        PendingIntent f302h;

        /* renamed from: i  reason: collision with root package name */
        RemoteViews f303i;

        /* renamed from: j  reason: collision with root package name */
        IconCompat f304j;

        /* renamed from: k  reason: collision with root package name */
        CharSequence f305k;

        /* renamed from: l  reason: collision with root package name */
        int f306l;

        /* renamed from: m  reason: collision with root package name */
        int f307m;

        /* renamed from: n  reason: collision with root package name */
        boolean f308n;

        /* renamed from: o  reason: collision with root package name */
        boolean f309o;

        /* renamed from: p  reason: collision with root package name */
        f f310p;

        /* renamed from: q  reason: collision with root package name */
        CharSequence f311q;

        /* renamed from: r  reason: collision with root package name */
        CharSequence f312r;

        /* renamed from: s  reason: collision with root package name */
        CharSequence[] f313s;

        /* renamed from: t  reason: collision with root package name */
        int f314t;

        /* renamed from: u  reason: collision with root package name */
        int f315u;

        /* renamed from: v  reason: collision with root package name */
        boolean f316v;

        /* renamed from: w  reason: collision with root package name */
        String f317w;

        /* renamed from: x  reason: collision with root package name */
        boolean f318x;

        /* renamed from: y  reason: collision with root package name */
        String f319y;

        /* renamed from: z  reason: collision with root package name */
        boolean f320z;

        @Deprecated
        public d(Context context) {
            this(context, null);
        }

        public d(Context context, String str) {
            this.f296b = new ArrayList<>();
            this.f297c = new ArrayList<>();
            this.f298d = new ArrayList<>();
            this.f308n = true;
            this.f320z = false;
            this.E = 0;
            this.F = 0;
            this.L = 0;
            this.O = 0;
            this.P = 0;
            Notification notification = new Notification();
            this.R = notification;
            this.f295a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.R.audioStreamType = -1;
            this.f307m = 0;
            this.U = new ArrayList<>();
            this.Q = true;
        }

        protected static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        private void j(int i5, boolean z4) {
            Notification notification;
            int i6;
            if (z4) {
                notification = this.R;
                i6 = i5 | notification.flags;
            } else {
                notification = this.R;
                i6 = (~i5) & notification.flags;
            }
            notification.flags = i6;
        }

        public d a(int i5, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f296b.add(new a(i5, charSequence, pendingIntent));
            return this;
        }

        public Notification b() {
            return new u(this).c();
        }

        public Bundle c() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        public d e(boolean z4) {
            j(16, z4);
            return this;
        }

        public d f(String str) {
            this.K = str;
            return this;
        }

        public d g(PendingIntent pendingIntent) {
            this.f301g = pendingIntent;
            return this;
        }

        public d h(CharSequence charSequence) {
            this.f300f = d(charSequence);
            return this;
        }

        public d i(CharSequence charSequence) {
            this.f299e = d(charSequence);
            return this;
        }

        public d k(boolean z4) {
            this.f320z = z4;
            return this;
        }

        public d l(int i5) {
            this.f307m = i5;
            return this;
        }

        public d m(int i5) {
            this.R.icon = i5;
            return this;
        }

        public d n(f fVar) {
            if (this.f310p != fVar) {
                this.f310p = fVar;
                if (fVar != null) {
                    fVar.g(this);
                }
            }
            return this;
        }

        public d o(CharSequence charSequence) {
            this.R.tickerText = d(charSequence);
            return this;
        }

        public d p(long j5) {
            this.R.when = j5;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends f {

        /* renamed from: e  reason: collision with root package name */
        private int f321e;

        /* renamed from: f  reason: collision with root package name */
        private t0 f322f;

        /* renamed from: g  reason: collision with root package name */
        private PendingIntent f323g;

        /* renamed from: h  reason: collision with root package name */
        private PendingIntent f324h;

        /* renamed from: i  reason: collision with root package name */
        private PendingIntent f325i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f326j;

        /* renamed from: k  reason: collision with root package name */
        private Integer f327k;

        /* renamed from: l  reason: collision with root package name */
        private Integer f328l;

        /* renamed from: m  reason: collision with root package name */
        private IconCompat f329m;

        /* renamed from: n  reason: collision with root package name */
        private CharSequence f330n;

        /* loaded from: classes.dex */
        static class a {
            static Notification.Builder a(Notification.Builder builder, String str) {
                return builder.addPerson(str);
            }

            static Notification.Builder b(Notification.Builder builder, String str) {
                return builder.setCategory(str);
            }
        }

        /* loaded from: classes.dex */
        static class b {
            static Parcelable a(Icon icon) {
                return icon;
            }

            static Notification.Action.Builder b(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(icon, charSequence, pendingIntent);
            }

            static void c(Notification.Builder builder, Icon icon) {
                builder.setLargeIcon(icon);
            }
        }

        /* loaded from: classes.dex */
        static class c {
            static Notification.Builder a(Notification.Builder builder, Person person) {
                return s.a(builder, person);
            }

            static Parcelable b(Person person) {
                return person;
            }
        }

        /* loaded from: classes.dex */
        static class d {
            static Notification$CallStyle a(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification$CallStyle.forIncomingCall(person, pendingIntent, pendingIntent2);
            }

            static Notification$CallStyle b(Person person, PendingIntent pendingIntent) {
                return Notification$CallStyle.forOngoingCall(person, pendingIntent);
            }

            static Notification$CallStyle c(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification$CallStyle.forScreeningCall(person, pendingIntent, pendingIntent2);
            }

            static Notification$CallStyle d(Notification$CallStyle notification$CallStyle, int i5) {
                return notification$CallStyle.setAnswerButtonColorHint(i5);
            }

            static Notification.Action.Builder e(Notification.Action.Builder builder, boolean z4) {
                Notification.Action.Builder authenticationRequired;
                authenticationRequired = builder.setAuthenticationRequired(z4);
                return authenticationRequired;
            }

            static Notification$CallStyle f(Notification$CallStyle notification$CallStyle, int i5) {
                return notification$CallStyle.setDeclineButtonColorHint(i5);
            }

            static Notification$CallStyle g(Notification$CallStyle notification$CallStyle, boolean z4) {
                return notification$CallStyle.setIsVideo(z4);
            }

            static Notification$CallStyle h(Notification$CallStyle notification$CallStyle, Icon icon) {
                return notification$CallStyle.setVerificationIcon(icon);
            }

            static Notification$CallStyle i(Notification$CallStyle notification$CallStyle, CharSequence charSequence) {
                return notification$CallStyle.setVerificationText(charSequence);
            }
        }

        private String i() {
            Resources resources;
            int i5;
            int i6 = this.f321e;
            if (i6 == 1) {
                resources = this.f331a.f295a.getResources();
                i5 = i.e.call_notification_incoming_text;
            } else if (i6 == 2) {
                resources = this.f331a.f295a.getResources();
                i5 = i.e.call_notification_ongoing_text;
            } else if (i6 != 3) {
                return null;
            } else {
                resources = this.f331a.f295a.getResources();
                i5 = i.e.call_notification_screening_text;
            }
            return resources.getString(i5);
        }

        private boolean j(a aVar) {
            return aVar != null && aVar.c().getBoolean("key_action_priority");
        }

        private a k(int i5, int i6, Integer num, int i7, PendingIntent pendingIntent) {
            if (num == null) {
                num = Integer.valueOf(androidx.core.content.a.getColor(this.f331a.f295a, i7));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.f331a.f295a.getResources().getString(i6));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
            a a5 = new a.C0013a(IconCompat.g(this.f331a.f295a, i5), spannableStringBuilder, pendingIntent).a();
            a5.c().putBoolean("key_action_priority", true);
            return a5;
        }

        private a l() {
            int i5 = i.c.ic_call_answer_video;
            int i6 = i.c.ic_call_answer;
            PendingIntent pendingIntent = this.f323g;
            if (pendingIntent == null) {
                return null;
            }
            boolean z4 = this.f326j;
            return k(z4 ? i5 : i6, z4 ? i.e.call_notification_answer_video_action : i.e.call_notification_answer_action, this.f327k, i.b.call_notification_answer_color, pendingIntent);
        }

        private a m() {
            int i5;
            Integer num;
            int i6;
            int i7 = i.c.ic_call_decline;
            PendingIntent pendingIntent = this.f324h;
            if (pendingIntent == null) {
                i5 = i.e.call_notification_hang_up_action;
                num = this.f328l;
                i6 = i.b.call_notification_decline_color;
                pendingIntent = this.f325i;
            } else {
                i5 = i.e.call_notification_decline_action;
                num = this.f328l;
                i6 = i.b.call_notification_decline_color;
            }
            return k(i7, i5, num, i6, pendingIntent);
        }

        @Override // androidx.core.app.q.f
        public void a(Bundle bundle) {
            Parcelable q5;
            String str;
            Parcelable i5;
            String str2;
            super.a(bundle);
            bundle.putInt("android.callType", this.f321e);
            bundle.putBoolean("android.callIsVideo", this.f326j);
            t0 t0Var = this.f322f;
            if (t0Var != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    i5 = c.b(t0Var.h());
                    str2 = "android.callPerson";
                } else {
                    i5 = t0Var.i();
                    str2 = "android.callPersonCompat";
                }
                bundle.putParcelable(str2, i5);
            }
            IconCompat iconCompat = this.f329m;
            if (iconCompat != null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    q5 = b.a(iconCompat.s(this.f331a.f295a));
                    str = "android.verificationIcon";
                } else {
                    q5 = iconCompat.q();
                    str = "android.verificationIconCompat";
                }
                bundle.putParcelable(str, q5);
            }
            bundle.putCharSequence("android.verificationText", this.f330n);
            bundle.putParcelable("android.answerIntent", this.f323g);
            bundle.putParcelable("android.declineIntent", this.f324h);
            bundle.putParcelable("android.hangUpIntent", this.f325i);
            Integer num = this.f327k;
            if (num != null) {
                bundle.putInt("android.answerColor", num.intValue());
            }
            Integer num2 = this.f328l;
            if (num2 != null) {
                bundle.putInt("android.declineColor", num2.intValue());
            }
        }

        @Override // androidx.core.app.q.f
        public void b(p pVar) {
            int i5 = Build.VERSION.SDK_INT;
            CharSequence charSequence = null;
            r1 = null;
            Notification$CallStyle a5 = null;
            charSequence = null;
            if (i5 < 31) {
                Notification.Builder a6 = pVar.a();
                t0 t0Var = this.f322f;
                a6.setContentTitle(t0Var != null ? t0Var.c() : null);
                Bundle bundle = this.f331a.D;
                if (bundle != null && bundle.containsKey("android.text")) {
                    charSequence = this.f331a.D.getCharSequence("android.text");
                }
                if (charSequence == null) {
                    charSequence = i();
                }
                a6.setContentText(charSequence);
                t0 t0Var2 = this.f322f;
                if (t0Var2 != null) {
                    if (i5 >= 23 && t0Var2.a() != null) {
                        b.c(a6, this.f322f.a().s(this.f331a.f295a));
                    }
                    if (i5 >= 28) {
                        c.a(a6, this.f322f.h());
                    } else {
                        a.a(a6, this.f322f.d());
                    }
                }
                a.b(a6, "call");
                return;
            }
            int i6 = this.f321e;
            if (i6 == 1) {
                a5 = d.a(this.f322f.h(), this.f324h, this.f323g);
            } else if (i6 == 2) {
                a5 = d.b(this.f322f.h(), this.f325i);
            } else if (i6 == 3) {
                a5 = d.c(this.f322f.h(), this.f325i, this.f323g);
            } else if (Log.isLoggable("NotifCompat", 3)) {
                Log.d("NotifCompat", "Unrecognized call type in CallStyle: " + String.valueOf(this.f321e));
            }
            if (a5 != null) {
                a5.setBuilder(pVar.a());
                Integer num = this.f327k;
                if (num != null) {
                    d.d(a5, num.intValue());
                }
                Integer num2 = this.f328l;
                if (num2 != null) {
                    d.f(a5, num2.intValue());
                }
                d.i(a5, this.f330n);
                IconCompat iconCompat = this.f329m;
                if (iconCompat != null) {
                    d.h(a5, iconCompat.s(this.f331a.f295a));
                }
                d.g(a5, this.f326j);
            }
        }

        @Override // androidx.core.app.q.f
        protected String c() {
            return "androidx.core.app.NotificationCompat$CallStyle";
        }

        public ArrayList<a> h() {
            a m5 = m();
            a l5 = l();
            ArrayList<a> arrayList = new ArrayList<>(3);
            arrayList.add(m5);
            int i5 = 2;
            ArrayList<a> arrayList2 = this.f331a.f296b;
            if (arrayList2 != null) {
                for (a aVar : arrayList2) {
                    if (aVar.j()) {
                        arrayList.add(aVar);
                    } else if (!j(aVar) && i5 > 1) {
                        arrayList.add(aVar);
                        i5--;
                    }
                    if (l5 != null && i5 == 1) {
                        arrayList.add(l5);
                        i5--;
                    }
                }
            }
            if (l5 != null && i5 >= 1) {
                arrayList.add(l5);
            }
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        protected d f331a;

        /* renamed from: b  reason: collision with root package name */
        CharSequence f332b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f333c;

        /* renamed from: d  reason: collision with root package name */
        boolean f334d = false;

        public void a(Bundle bundle) {
            if (this.f334d) {
                bundle.putCharSequence("android.summaryText", this.f333c);
            }
            CharSequence charSequence = this.f332b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String c5 = c();
            if (c5 != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", c5);
            }
        }

        public abstract void b(p pVar);

        protected abstract String c();

        public RemoteViews d(p pVar) {
            return null;
        }

        public RemoteViews e(p pVar) {
            return null;
        }

        public RemoteViews f(p pVar) {
            return null;
        }

        public void g(d dVar) {
            if (this.f331a != dVar) {
                this.f331a = dVar;
                if (dVar != null) {
                    dVar.n(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }
}
