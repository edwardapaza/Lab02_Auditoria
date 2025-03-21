package h;

import android.os.Bundle;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f3088a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f3089b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f3090c;

    /* renamed from: d  reason: collision with root package name */
    public final Integer f3091d;

    /* renamed from: h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0058a {

        /* renamed from: a  reason: collision with root package name */
        private Integer f3092a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f3093b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f3094c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f3095d;

        public a a() {
            return new a(this.f3092a, this.f3093b, this.f3094c, this.f3095d);
        }
    }

    a(Integer num, Integer num2, Integer num3, Integer num4) {
        this.f3088a = num;
        this.f3089b = num2;
        this.f3090c = num3;
        this.f3091d = num4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f3088a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f3089b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f3090c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.f3091d;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}
