package q2;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import java.io.IOException;
import org.json.JSONArray;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6953a = d.class.getName() + ".aot-shared-library-name";

    /* renamed from: b  reason: collision with root package name */
    public static final String f6954b = d.class.getName() + ".vm-snapshot-data";

    /* renamed from: c  reason: collision with root package name */
    public static final String f6955c = d.class.getName() + ".isolate-snapshot-data";

    /* renamed from: d  reason: collision with root package name */
    public static final String f6956d = d.class.getName() + ".flutter-assets-dir";

    private static ApplicationInfo a(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e5) {
            throw new RuntimeException(e5);
        }
    }

    private static boolean b(Bundle bundle, String str, boolean z4) {
        return bundle == null ? z4 : bundle.getBoolean(str, z4);
    }

    private static String c(ApplicationInfo applicationInfo, Context context) {
        int i5;
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null && (i5 = bundle.getInt("io.flutter.network-policy", 0)) > 0) {
            JSONArray jSONArray = new JSONArray();
            try {
                XmlResourceParser xml = context.getResources().getXml(i5);
                xml.next();
                for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                    if (eventType == 2) {
                        if (xml.getName().equals("domain-config")) {
                            g(xml, jSONArray, false);
                        }
                    }
                }
                return jSONArray.toString();
            } catch (IOException | XmlPullParserException unused) {
                return null;
            }
        }
        return null;
    }

    private static String d(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        return bundle.getString(str, null);
    }

    public static b e(Context context) {
        ApplicationInfo a5 = a(context);
        return new b(d(a5.metaData, f6953a), d(a5.metaData, f6954b), d(a5.metaData, f6955c), d(a5.metaData, f6956d), c(a5, context), a5.nativeLibraryDir, b(a5.metaData, "io.flutter.automatically-register-plugins", true));
    }

    private static void f(XmlResourceParser xmlResourceParser, JSONArray jSONArray, boolean z4) {
        boolean attributeBooleanValue = xmlResourceParser.getAttributeBooleanValue(null, "includeSubdomains", false);
        xmlResourceParser.next();
        if (xmlResourceParser.getEventType() != 4) {
            throw new IllegalStateException("Expected text");
        }
        String trim = xmlResourceParser.getText().trim();
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(trim);
        jSONArray2.put(attributeBooleanValue);
        jSONArray2.put(z4);
        jSONArray.put(jSONArray2);
        xmlResourceParser.next();
        if (xmlResourceParser.getEventType() != 3) {
            throw new IllegalStateException("Expected end of domain tag");
        }
    }

    private static void g(XmlResourceParser xmlResourceParser, JSONArray jSONArray, boolean z4) {
        boolean attributeBooleanValue = xmlResourceParser.getAttributeBooleanValue(null, "cleartextTrafficPermitted", z4);
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 2) {
                if (xmlResourceParser.getName().equals("domain")) {
                    f(xmlResourceParser, jSONArray, attributeBooleanValue);
                } else if (xmlResourceParser.getName().equals("domain-config")) {
                    g(xmlResourceParser, jSONArray, attributeBooleanValue);
                } else {
                    h(xmlResourceParser);
                }
            } else if (next == 3) {
                return;
            }
        }
    }

    private static void h(XmlResourceParser xmlResourceParser) {
        String name = xmlResourceParser.getName();
        int eventType = xmlResourceParser.getEventType();
        while (true) {
            if (eventType == 3 && xmlResourceParser.getName() == name) {
                return;
            }
            eventType = xmlResourceParser.next();
        }
    }
}
