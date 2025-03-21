package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;
/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    private static final androidx.collection.f<String, String> f1084a = new androidx.collection.f<>();

    /* renamed from: b  reason: collision with root package name */
    private static Locale f1085b;

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            return s0.d.a(context).b(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String b(Context context) {
        return context.getResources().getString(k0.b.common_google_play_services_notification_channel_name);
    }

    public static String c(Context context, int i5) {
        return context.getResources().getString(i5 != 1 ? i5 != 2 ? i5 != 3 ? 17039370 : k0.b.common_google_play_services_enable_button : k0.b.common_google_play_services_update_button : k0.b.common_google_play_services_install_button);
    }

    public static String d(Context context, int i5) {
        Resources resources = context.getResources();
        String a5 = a(context);
        if (i5 != 1) {
            if (i5 == 2) {
                return q0.g.c(context) ? resources.getString(k0.b.common_google_play_services_wear_update_text) : resources.getString(k0.b.common_google_play_services_update_text, a5);
            } else if (i5 != 3) {
                if (i5 != 5) {
                    if (i5 != 7) {
                        if (i5 != 9) {
                            if (i5 != 20) {
                                switch (i5) {
                                    case 16:
                                        return h(context, "common_google_play_services_api_unavailable_text", a5);
                                    case i2.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                                        return h(context, "common_google_play_services_sign_in_failed_text", a5);
                                    case i2.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                                        return resources.getString(k0.b.common_google_play_services_updating_text, a5);
                                    default:
                                        return resources.getString(l0.m.common_google_play_services_unknown_issue, a5);
                                }
                            }
                            return h(context, "common_google_play_services_restricted_profile_text", a5);
                        }
                        return resources.getString(k0.b.common_google_play_services_unsupported_text, a5);
                    }
                    return h(context, "common_google_play_services_network_error_text", a5);
                }
                return h(context, "common_google_play_services_invalid_account_text", a5);
            } else {
                return resources.getString(k0.b.common_google_play_services_enable_text, a5);
            }
        }
        return resources.getString(k0.b.common_google_play_services_install_text, a5);
    }

    public static String e(Context context, int i5) {
        return (i5 == 6 || i5 == 19) ? h(context, "common_google_play_services_resolution_required_text", a(context)) : d(context, i5);
    }

    public static String f(Context context, int i5) {
        String i6 = i5 == 6 ? i(context, "common_google_play_services_resolution_required_title") : g(context, i5);
        return i6 == null ? context.getResources().getString(k0.b.common_google_play_services_notification_ticker) : i6;
    }

    public static String g(Context context, int i5) {
        String str;
        Resources resources = context.getResources();
        switch (i5) {
            case 1:
                return resources.getString(k0.b.common_google_play_services_install_title);
            case 2:
                return resources.getString(k0.b.common_google_play_services_update_title);
            case 3:
                return resources.getString(k0.b.common_google_play_services_enable_title);
            case 4:
            case 6:
            case i2.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return i(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return i(context, "common_google_play_services_network_error_title");
            case 8:
                str = "Internal error occurred. Please see logs for detailed information";
                break;
            case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                str = "Google Play services is invalid. Cannot recover.";
                break;
            case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                str = "Developer error occurred. Please see logs for detailed information";
                break;
            case 11:
                str = "The application is not licensed to the user.";
                break;
            case i2.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                StringBuilder sb = new StringBuilder(33);
                sb.append("Unexpected error code ");
                sb.append(i5);
                str = sb.toString();
                break;
            case 16:
                str = "One of the API components you attempted to connect to is not available.";
                break;
            case i2.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return i(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return i(context, "common_google_play_services_restricted_profile_title");
        }
        Log.e("GoogleApiAvailability", str);
        return null;
    }

    private static String h(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String i5 = i(context, str);
        if (i5 == null) {
            i5 = resources.getString(l0.m.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, i5, str2);
    }

    private static String i(Context context, String str) {
        androidx.collection.f<String, String> fVar = f1084a;
        synchronized (fVar) {
            Locale d5 = androidx.core.os.f.a(context.getResources().getConfiguration()).d(0);
            if (!d5.equals(f1085b)) {
                fVar.clear();
                f1085b = d5;
            }
            String str2 = fVar.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources d6 = l0.j.d(context);
            if (d6 == null) {
                return null;
            }
            int identifier = d6.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                Log.w("GoogleApiAvailability", str.length() != 0 ? "Missing resource: ".concat(str) : new String("Missing resource: "));
                return null;
            }
            String string = d6.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                Log.w("GoogleApiAvailability", str.length() != 0 ? "Got empty resource: ".concat(str) : new String("Got empty resource: "));
                return null;
            }
            fVar.put(str, string);
            return string;
        }
    }
}
