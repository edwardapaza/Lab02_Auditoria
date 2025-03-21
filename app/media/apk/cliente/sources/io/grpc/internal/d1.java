package io.grpc.internal;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class d1 {

    /* renamed from: a  reason: collision with root package name */
    private static final long f4667a = TimeUnit.SECONDS.toNanos(1);

    public static List<Map<String, ?>> a(List<?> list) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            if (!(list.get(i5) instanceof Map)) {
                throw new ClassCastException(String.format(Locale.US, "value %s for idx %d in %s is not object", list.get(i5), Integer.valueOf(i5), list));
            }
        }
        return list;
    }

    public static List<String> b(List<?> list) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            if (!(list.get(i5) instanceof String)) {
                throw new ClassCastException(String.format(Locale.US, "value '%s' for idx %d in '%s' is not string", list.get(i5), Integer.valueOf(i5), list));
            }
        }
        return list;
    }

    private static boolean c(long j5, int i5) {
        if (j5 >= -315576000000L && j5 <= 315576000000L) {
            long j6 = i5;
            if (j6 >= -999999999 && j6 < f4667a) {
                int i6 = (j5 > 0L ? 1 : (j5 == 0L ? 0 : -1));
                if (i6 >= 0 && i5 >= 0) {
                    return true;
                }
                if (i6 <= 0 && i5 <= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Boolean d(Map<String, ?> map, String str) {
        if (map.containsKey(str)) {
            Object obj = map.get(str);
            if (obj instanceof Boolean) {
                return (Boolean) obj;
            }
            throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not Boolean", obj, str, map));
        }
        return null;
    }

    public static List<?> e(Map<String, ?> map, String str) {
        if (map.containsKey(str)) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                return (List) obj;
            }
            throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not List", obj, str, map));
        }
        return null;
    }

    public static List<Map<String, ?>> f(Map<String, ?> map, String str) {
        List<?> e5 = e(map, str);
        if (e5 == null) {
            return null;
        }
        return a(e5);
    }

    public static List<String> g(Map<String, ?> map, String str) {
        List<?> e5 = e(map, str);
        if (e5 == null) {
            return null;
        }
        return b(e5);
    }

    public static Double h(Map<String, ?> map, String str) {
        if (map.containsKey(str)) {
            Object obj = map.get(str);
            if (obj instanceof Double) {
                return (Double) obj;
            }
            if (obj instanceof String) {
                try {
                    return Double.valueOf(Double.parseDouble((String) obj));
                } catch (NumberFormatException unused) {
                    throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not a double", obj, str));
                }
            }
            throw new IllegalArgumentException(String.format("value '%s' for key '%s' in '%s' is not a number", obj, str, map));
        }
        return null;
    }

    public static Integer i(Map<String, ?> map, String str) {
        if (map.containsKey(str)) {
            Object obj = map.get(str);
            if (!(obj instanceof Double)) {
                if (obj instanceof String) {
                    try {
                        return Integer.valueOf(Integer.parseInt((String) obj));
                    } catch (NumberFormatException unused) {
                        throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not an integer", obj, str));
                    }
                }
                throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not an integer", obj, str));
            }
            Double d5 = (Double) obj;
            int intValue = d5.intValue();
            if (intValue == d5.doubleValue()) {
                return Integer.valueOf(intValue);
            }
            throw new ClassCastException("Number expected to be integer: " + d5);
        }
        return null;
    }

    public static Map<String, ?> j(Map<String, ?> map, String str) {
        if (map.containsKey(str)) {
            Object obj = map.get(str);
            if (obj instanceof Map) {
                return (Map) obj;
            }
            throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not object", obj, str, map));
        }
        return null;
    }

    public static String k(Map<String, ?> map, String str) {
        if (map.containsKey(str)) {
            Object obj = map.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not String", obj, str, map));
        }
        return null;
    }

    public static Long l(Map<String, ?> map, String str) {
        String k5 = k(map, str);
        if (k5 == null) {
            return null;
        }
        try {
            return Long.valueOf(n(k5));
        } catch (ParseException e5) {
            throw new RuntimeException(e5);
        }
    }

    private static long m(long j5, int i5) {
        long j6 = i5;
        long j7 = f4667a;
        if (j6 <= (-j7) || j6 >= j7) {
            j5 = c1.b.a(j5, j6 / j7);
            i5 = (int) (j6 % j7);
        }
        if (j5 > 0 && i5 < 0) {
            i5 = (int) (i5 + j7);
            j5--;
        }
        if (j5 < 0 && i5 > 0) {
            i5 = (int) (i5 - j7);
            j5++;
        }
        if (c(j5, i5)) {
            return p(TimeUnit.SECONDS.toNanos(j5), i5);
        }
        throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", Long.valueOf(j5), Integer.valueOf(i5)));
    }

    private static long n(String str) {
        boolean z4;
        String str2;
        if (str.isEmpty() || str.charAt(str.length() - 1) != 's') {
            throw new ParseException("Invalid duration string: " + str, 0);
        }
        if (str.charAt(0) == '-') {
            str = str.substring(1);
            z4 = true;
        } else {
            z4 = false;
        }
        String substring = str.substring(0, str.length() - 1);
        int indexOf = substring.indexOf(46);
        if (indexOf != -1) {
            str2 = substring.substring(indexOf + 1);
            substring = substring.substring(0, indexOf);
        } else {
            str2 = "";
        }
        long parseLong = Long.parseLong(substring);
        int o5 = str2.isEmpty() ? 0 : o(str2);
        if (parseLong < 0) {
            throw new ParseException("Invalid duration string: " + str, 0);
        }
        if (z4) {
            parseLong = -parseLong;
            o5 = -o5;
        }
        try {
            return m(parseLong, o5);
        } catch (IllegalArgumentException unused) {
            throw new ParseException("Duration value is out of range.", 0);
        }
    }

    private static int o(String str) {
        int i5 = 0;
        for (int i6 = 0; i6 < 9; i6++) {
            i5 *= 10;
            if (i6 < str.length()) {
                if (str.charAt(i6) < '0' || str.charAt(i6) > '9') {
                    throw new ParseException("Invalid nanoseconds.", 0);
                }
                i5 += str.charAt(i6) - '0';
            }
        }
        return i5;
    }

    private static long p(long j5, long j6) {
        long j7 = j5 + j6;
        return (((j6 ^ j5) > 0L ? 1 : ((j6 ^ j5) == 0L ? 0 : -1)) < 0) | ((j5 ^ j7) >= 0) ? j7 : ((j7 >>> 63) ^ 1) + Long.MAX_VALUE;
    }
}
