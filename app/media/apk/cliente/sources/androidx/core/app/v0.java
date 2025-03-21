package androidx.core.app;

import android.app.RemoteInput;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class v0 {

    /* renamed from: a  reason: collision with root package name */
    private final String f363a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f364b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence[] f365c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f366d;

    /* renamed from: e  reason: collision with root package name */
    private final int f367e;

    /* renamed from: f  reason: collision with root package name */
    private final Bundle f368f;

    /* renamed from: g  reason: collision with root package name */
    private final Set<String> f369g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        static void a(Object obj, Intent intent, Bundle bundle) {
            RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
        }

        public static RemoteInput b(v0 v0Var) {
            Set<String> d5;
            RemoteInput.Builder addExtras = new RemoteInput.Builder(v0Var.i()).setLabel(v0Var.h()).setChoices(v0Var.e()).setAllowFreeFormInput(v0Var.c()).addExtras(v0Var.g());
            if (Build.VERSION.SDK_INT >= 26 && (d5 = v0Var.d()) != null) {
                for (String str : d5) {
                    b.d(addExtras, str, true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                c.b(addExtras, v0Var.f());
            }
            return addExtras.build();
        }

        static Bundle c(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        static void a(v0 v0Var, Intent intent, Map<String, Uri> map) {
            RemoteInput.addDataResultToIntent(v0.a(v0Var), intent, map);
        }

        static Set<String> b(Object obj) {
            Set<String> allowedDataTypes;
            allowedDataTypes = ((RemoteInput) obj).getAllowedDataTypes();
            return allowedDataTypes;
        }

        static Map<String, Uri> c(Intent intent, String str) {
            Map<String, Uri> dataResultsFromIntent;
            dataResultsFromIntent = RemoteInput.getDataResultsFromIntent(intent, str);
            return dataResultsFromIntent;
        }

        static RemoteInput.Builder d(RemoteInput.Builder builder, String str, boolean z4) {
            RemoteInput.Builder allowDataType;
            allowDataType = builder.setAllowDataType(str, z4);
            return allowDataType;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {
        static int a(Object obj) {
            int editChoicesBeforeSending;
            editChoicesBeforeSending = ((RemoteInput) obj).getEditChoicesBeforeSending();
            return editChoicesBeforeSending;
        }

        static RemoteInput.Builder b(RemoteInput.Builder builder, int i5) {
            RemoteInput.Builder editChoicesBeforeSending;
            editChoicesBeforeSending = builder.setEditChoicesBeforeSending(i5);
            return editChoicesBeforeSending;
        }
    }

    static RemoteInput a(v0 v0Var) {
        return a.b(v0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RemoteInput[] b(v0[] v0VarArr) {
        if (v0VarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[v0VarArr.length];
        for (int i5 = 0; i5 < v0VarArr.length; i5++) {
            remoteInputArr[i5] = a(v0VarArr[i5]);
        }
        return remoteInputArr;
    }

    public boolean c() {
        return this.f366d;
    }

    public Set<String> d() {
        return this.f369g;
    }

    public CharSequence[] e() {
        return this.f365c;
    }

    public int f() {
        return this.f367e;
    }

    public Bundle g() {
        return this.f368f;
    }

    public CharSequence h() {
        return this.f364b;
    }

    public String i() {
        return this.f363a;
    }

    public boolean j() {
        return (c() || (e() != null && e().length != 0) || d() == null || d().isEmpty()) ? false : true;
    }
}
