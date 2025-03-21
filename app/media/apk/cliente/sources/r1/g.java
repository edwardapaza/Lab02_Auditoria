package r1;

import android.util.Base64;
import com.google.protobuf.f1;
import com.google.protobuf.u1;
import i2.b;
import i2.d0;
import i2.u;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;
import s1.a1;
import s1.p;
import s1.q;
import s1.z0;
import v1.l;
import v1.r;
import v1.s;
import v1.t;
import v1.u;
import v1.w;
import v1.z;
import y1.o0;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final SimpleDateFormat f7149a;

    /* renamed from: b  reason: collision with root package name */
    private final o0 f7150b;

    public g(o0 o0Var) {
        this.f7150b = o0Var;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        this.f7149a = simpleDateFormat;
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        simpleDateFormat.setCalendar(gregorianCalendar);
    }

    private void A(List<q> list, JSONObject jSONObject) {
        p.b bVar;
        d0 d0Var;
        r j5 = j(jSONObject.getJSONObject("field"));
        String string = jSONObject.getString("op");
        string.hashCode();
        char c5 = 65535;
        switch (string.hashCode()) {
            case -2125479834:
                if (string.equals("IS_NAN")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1465346180:
                if (string.equals("IS_NULL")) {
                    c5 = 1;
                    break;
                }
                break;
            case -244195494:
                if (string.equals("IS_NOT_NAN")) {
                    c5 = 2;
                    break;
                }
                break;
            case 1019893512:
                if (string.equals("IS_NOT_NULL")) {
                    c5 = 3;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                bVar = p.b.EQUAL;
                d0Var = z.f8160a;
                list.add(p.e(j5, bVar, d0Var));
                return;
            case 1:
                bVar = p.b.EQUAL;
                d0Var = z.f8161b;
                list.add(p.e(j5, bVar, d0Var));
                return;
            case 2:
                bVar = p.b.NOT_EQUAL;
                d0Var = z.f8160a;
                list.add(p.e(j5, bVar, d0Var));
                return;
            case 3:
                bVar = p.b.NOT_EQUAL;
                d0Var = z.f8161b;
                list.add(p.e(j5, bVar, d0Var));
                return;
            default:
                throw new IllegalArgumentException("Unexpected unary filter: " + string);
        }
    }

    private d0 B(JSONObject jSONObject) {
        d0.b B0 = d0.B0();
        if (jSONObject.has("nullValue")) {
            B0.O(f1.NULL_VALUE);
        } else if (jSONObject.has("booleanValue")) {
            B0.H(jSONObject.optBoolean("booleanValue", false));
        } else if (jSONObject.has("integerValue")) {
            B0.L(jSONObject.optLong("integerValue"));
        } else if (jSONObject.has("doubleValue")) {
            B0.J(jSONObject.optDouble("doubleValue"));
        } else if (jSONObject.has("timestampValue")) {
            y(B0, jSONObject.get("timestampValue"));
        } else if (jSONObject.has("stringValue")) {
            B0.Q(jSONObject.optString("stringValue", ""));
        } else if (jSONObject.has("bytesValue")) {
            B0.I(com.google.protobuf.i.p(Base64.decode(jSONObject.getString("bytesValue"), 0)));
        } else if (jSONObject.has("referenceValue")) {
            B0.P(jSONObject.getString("referenceValue"));
        } else if (jSONObject.has("geoPointValue")) {
            l(B0, jSONObject.getJSONObject("geoPointValue"));
        } else if (jSONObject.has("arrayValue")) {
            a(B0, jSONObject.getJSONObject("arrayValue").optJSONArray("values"));
        } else if (!jSONObject.has("mapValue")) {
            throw new IllegalArgumentException("Unexpected value type: " + jSONObject);
        } else {
            o(B0, jSONObject.getJSONObject("mapValue").optJSONObject("fields"));
        }
        return B0.build();
    }

    private List<q> C(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            k(arrayList, jSONObject);
        }
        return arrayList;
    }

    private static int D(String str) {
        int i5 = 0;
        for (int i6 = 0; i6 < 9; i6++) {
            i5 *= 10;
            if (i6 < str.length()) {
                if (str.charAt(i6) < '0' || str.charAt(i6) > '9') {
                    throw new IllegalArgumentException("Invalid nanoseconds: " + str);
                }
                i5 += str.charAt(i6) - '0';
            }
        }
        return i5;
    }

    private void E(JSONArray jSONArray) {
        if (jSONArray.length() != 1) {
            throw new IllegalArgumentException("Only queries with a single 'from' clause are supported by the Android SDK");
        }
    }

    private void F(JSONObject jSONObject) {
        if (jSONObject.has("offset")) {
            throw new IllegalArgumentException("Queries with offsets are not supported by the Android SDK");
        }
    }

    private void G(JSONObject jSONObject) {
        if (jSONObject.has("select")) {
            throw new IllegalArgumentException("Queries with 'select' statements are not supported by the Android SDK");
        }
    }

    private void a(d0.b bVar, JSONArray jSONArray) {
        b.C0063b n02 = i2.b.n0();
        if (jSONArray != null) {
            for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                n02.F(B(jSONArray.getJSONObject(i5)));
            }
        }
        bVar.F(n02);
    }

    private i d(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("structuredQuery");
        G(jSONObject2);
        u p5 = p(jSONObject.getString("parent"));
        JSONArray jSONArray = jSONObject2.getJSONArray("from");
        E(jSONArray);
        JSONObject jSONObject3 = jSONArray.getJSONObject(0);
        boolean optBoolean = jSONObject3.optBoolean("allDescendants", false);
        String string = jSONObject3.getString("collectionId");
        if (!optBoolean) {
            p5 = p5.a(string);
            string = null;
        }
        List<q> C = C(jSONObject2.optJSONObject("where"));
        List<z0> r5 = r(jSONObject2.optJSONArray("orderBy"));
        s1.i u5 = u(jSONObject2.optJSONObject("startAt"));
        s1.i g5 = g(jSONObject2.optJSONObject("endAt"));
        F(jSONObject2);
        int m5 = m(jSONObject2);
        return new i(new a1(p5, string, C, r5, m5, a1.a.LIMIT_TO_FIRST, u5, g5).D(), n(jSONObject));
    }

    private void e(List<q> list, JSONObject jSONObject) {
        if (!jSONObject.getString("op").equals("AND")) {
            throw new IllegalArgumentException("The Android SDK only supports composite filters of type 'AND'");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("filters");
        if (optJSONArray != null) {
            for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                k(list, optJSONArray.getJSONObject(i5));
            }
        }
    }

    private s1.i g(JSONObject jSONObject) {
        if (jSONObject != null) {
            return new s1.i(s(jSONObject), !jSONObject.optBoolean("before", false));
        }
        return null;
    }

    private void h(List<q> list, JSONObject jSONObject) {
        list.add(p.e(j(jSONObject.getJSONObject("field")), i(jSONObject.getString("op")), B(jSONObject.getJSONObject("value"))));
    }

    private p.b i(String str) {
        return p.b.valueOf(str);
    }

    private r j(JSONObject jSONObject) {
        return r.u(jSONObject.getString("fieldPath"));
    }

    private void k(List<q> list, JSONObject jSONObject) {
        if (jSONObject.has("compositeFilter")) {
            e(list, jSONObject.getJSONObject("compositeFilter"));
        } else if (jSONObject.has("fieldFilter")) {
            h(list, jSONObject.getJSONObject("fieldFilter"));
        } else if (jSONObject.has("unaryFilter")) {
            A(list, jSONObject.getJSONObject("unaryFilter"));
        }
    }

    private void l(d0.b bVar, JSONObject jSONObject) {
        bVar.K(m2.a.j0().E(jSONObject.optDouble("latitude")).F(jSONObject.optDouble("longitude")));
    }

    private int m(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("limit");
        return optJSONObject != null ? optJSONObject.optInt("value", -1) : jSONObject.optInt("limit", -1);
    }

    private a1.a n(JSONObject jSONObject) {
        String optString = jSONObject.optString("limitType", "FIRST");
        if (optString.equals("FIRST")) {
            return a1.a.LIMIT_TO_FIRST;
        }
        if (optString.equals("LAST")) {
            return a1.a.LIMIT_TO_LAST;
        }
        throw new IllegalArgumentException("Invalid limit type for bundle query: " + optString);
    }

    private void o(d0.b bVar, JSONObject jSONObject) {
        u.b n02 = i2.u.n0();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                n02.G(next, B(jSONObject.getJSONObject(next)));
            }
        }
        bVar.M(n02);
    }

    private v1.u p(String str) {
        v1.u u5 = v1.u.u(str);
        if (this.f7150b.c0(u5)) {
            return u5.q(5);
        }
        throw new IllegalArgumentException("Resource name is not valid for current instance: " + str);
    }

    private List<z0> r(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i5);
                arrayList.add(z0.d(jSONObject.optString("direction", "ASCENDING").equals("ASCENDING") ? z0.a.ASCENDING : z0.a.DESCENDING, j(jSONObject.getJSONObject("field"))));
            }
        }
        return arrayList;
    }

    private List<d0> s(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("values");
        if (optJSONArray != null) {
            for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                arrayList.add(B(optJSONArray.getJSONObject(i5)));
            }
        }
        return arrayList;
    }

    private w t(Object obj) {
        return new w(v(obj));
    }

    private s1.i u(JSONObject jSONObject) {
        if (jSONObject != null) {
            return new s1.i(s(jSONObject), jSONObject.optBoolean("before", false));
        }
        return null;
    }

    private f1.q v(Object obj) {
        if (obj instanceof String) {
            return w((String) obj);
        }
        if (obj instanceof JSONObject) {
            return x((JSONObject) obj);
        }
        throw new IllegalArgumentException("Timestamps must be either ISO 8601-formatted strings or JSON objects");
    }

    private f1.q w(String str) {
        try {
            int indexOf = str.indexOf(84);
            if (indexOf == -1) {
                throw new IllegalArgumentException("Invalid timestamp: " + str);
            }
            int indexOf2 = str.indexOf(90, indexOf);
            if (indexOf2 == -1) {
                indexOf2 = str.indexOf(43, indexOf);
            }
            if (indexOf2 == -1) {
                indexOf2 = str.indexOf(45, indexOf);
            }
            if (indexOf2 == -1) {
                throw new IllegalArgumentException("Invalid timestamp: Missing valid timezone offset: " + str);
            }
            int i5 = 0;
            String substring = str.substring(0, indexOf2);
            String str2 = "";
            int indexOf3 = substring.indexOf(46);
            if (indexOf3 != -1) {
                String substring2 = substring.substring(0, indexOf3);
                str2 = substring.substring(indexOf3 + 1);
                substring = substring2;
            }
            long time = this.f7149a.parse(substring).getTime() / 1000;
            if (!str2.isEmpty()) {
                i5 = D(str2);
            }
            if (str.charAt(indexOf2) != 'Z') {
                long z4 = z(str.substring(indexOf2 + 1));
                time = str.charAt(indexOf2) == '+' ? time - z4 : time + z4;
            } else if (str.length() != indexOf2 + 1) {
                throw new IllegalArgumentException("Invalid timestamp: Invalid trailing data \"" + str.substring(indexOf2) + "\"");
            }
            return new f1.q(time, i5);
        } catch (ParseException e5) {
            throw new IllegalArgumentException("Failed to parse timestamp", e5);
        }
    }

    private f1.q x(JSONObject jSONObject) {
        return new f1.q(jSONObject.optLong("seconds"), jSONObject.optInt("nanos"));
    }

    private void y(d0.b bVar, Object obj) {
        f1.q v5 = v(obj);
        bVar.R(u1.j0().F(v5.n()).E(v5.h()));
    }

    private static long z(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            return ((Long.parseLong(str.substring(0, indexOf)) * 60) + Long.parseLong(str.substring(indexOf + 1))) * 60;
        }
        throw new IllegalArgumentException("Invalid offset value: " + str);
    }

    public e b(JSONObject jSONObject) {
        return new e(jSONObject.getString("id"), jSONObject.getInt("version"), t(jSONObject.get("createTime")), jSONObject.getInt("totalDocuments"), jSONObject.getLong("totalBytes"));
    }

    public h c(JSONObject jSONObject) {
        l k5 = l.k(p(jSONObject.getString("name")));
        w t5 = t(jSONObject.get("readTime"));
        boolean optBoolean = jSONObject.optBoolean("exists", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("queries");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                arrayList.add(optJSONArray.getString(i5));
            }
        }
        return new h(k5, t5, optBoolean, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b f(JSONObject jSONObject) {
        l k5 = l.k(p(jSONObject.getString("name")));
        w t5 = t(jSONObject.get("updateTime"));
        d0.b B0 = d0.B0();
        o(B0, jSONObject.getJSONObject("fields"));
        return new b(s.p(k5, t5, t.j(B0.E().h0())));
    }

    public j q(JSONObject jSONObject) {
        return new j(jSONObject.getString("name"), d(jSONObject.getJSONObject("bundledQuery")), t(jSONObject.get("readTime")));
    }
}
