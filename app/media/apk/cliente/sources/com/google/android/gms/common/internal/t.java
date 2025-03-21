package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
/* loaded from: classes.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f1203a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1204b;

    public t(Context context) {
        q.k(context);
        Resources resources = context.getResources();
        this.f1203a = resources;
        this.f1204b = resources.getResourcePackageName(l0.m.common_google_play_services_unknown_issue);
    }

    public String a(String str) {
        int identifier = this.f1203a.getIdentifier(str, "string", this.f1204b);
        if (identifier == 0) {
            return null;
        }
        return this.f1203a.getString(identifier);
    }
}
