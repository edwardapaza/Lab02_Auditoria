package com.google.protobuf;

import com.google.protobuf.z;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y0 {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f2201a;

    static {
        char[] cArr = new char[80];
        f2201a = cArr;
        Arrays.fill(cArr, ' ');
    }

    private static void a(int i5, StringBuilder sb) {
        while (i5 > 0) {
            char[] cArr = f2201a;
            int length = i5 > cArr.length ? cArr.length : i5;
            sb.append(cArr, 0, length);
            i5 -= length;
        }
    }

    private static boolean b(Object obj) {
        Object obj2;
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == 0;
        } else if (obj instanceof Float) {
            return Float.floatToRawIntBits(((Float) obj).floatValue()) == 0;
        } else if (obj instanceof Double) {
            return Double.doubleToRawLongBits(((Double) obj).doubleValue()) == 0;
        } else {
            if (obj instanceof String) {
                obj2 = "";
            } else if (!(obj instanceof i)) {
                return obj instanceof w0 ? obj == ((w0) obj).b() : (obj instanceof Enum) && ((Enum) obj).ordinal() == 0;
            } else {
                obj2 = i.f1961b;
            }
            return obj.equals(obj2);
        }
    }

    private static String c(String str) {
        if (str.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toLowerCase(str.charAt(0)));
        for (int i5 = 1; i5 < str.length(); i5++) {
            char charAt = str.charAt(i5);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(StringBuilder sb, int i5, String str, Object obj) {
        String a5;
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                d(sb, i5, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                d(sb, i5, str, entry);
            }
        } else {
            sb.append('\n');
            a(i5, sb);
            sb.append(c(str));
            if (obj instanceof String) {
                sb.append(": \"");
                a5 = t1.c((String) obj);
            } else if (!(obj instanceof i)) {
                if (obj instanceof z) {
                    sb.append(" {");
                    e((z) obj, sb, i5 + 2);
                } else if (!(obj instanceof Map.Entry)) {
                    sb.append(": ");
                    sb.append(obj);
                    return;
                } else {
                    sb.append(" {");
                    Map.Entry entry2 = (Map.Entry) obj;
                    int i6 = i5 + 2;
                    d(sb, i6, "key", entry2.getKey());
                    d(sb, i6, "value", entry2.getValue());
                }
                sb.append("\n");
                a(i5, sb);
                sb.append("}");
                return;
            } else {
                sb.append(": \"");
                a5 = t1.a((i) obj);
            }
            sb.append(a5);
            sb.append('\"');
        }
    }

    private static void e(w0 w0Var, StringBuilder sb, int i5) {
        int i6;
        Method method;
        String substring;
        Object L;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = w0Var.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i7 = 0;
        while (true) {
            i6 = 3;
            if (i7 >= length) {
                break;
            }
            Method method3 = declaredMethods[i7];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i7++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring2 = ((String) entry.getKey()).substring(i6);
            if (substring2.endsWith("List") && !substring2.endsWith("OrBuilderList") && !substring2.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                substring = substring2.substring(0, substring2.length() - 4);
                L = z.L(method2, w0Var, new Object[0]);
            } else if (!substring2.endsWith("Map") || substring2.equals("Map") || (method = (Method) entry.getValue()) == null || !method.getReturnType().equals(Map.class) || method.isAnnotationPresent(Deprecated.class) || !Modifier.isPublic(method.getModifiers())) {
                if (hashSet.contains("set" + substring2)) {
                    if (substring2.endsWith("Bytes")) {
                        if (treeMap.containsKey("get" + substring2.substring(0, substring2.length() - 5))) {
                        }
                    }
                    Method method4 = (Method) entry.getValue();
                    Method method5 = (Method) hashMap.get("has" + substring2);
                    if (method4 != null) {
                        Object L2 = z.L(method4, w0Var, new Object[0]);
                        if (method5 == null ? !b(L2) : ((Boolean) z.L(method5, w0Var, new Object[0])).booleanValue()) {
                            d(sb, i5, substring2, L2);
                        }
                    }
                }
                i6 = 3;
            } else {
                substring = substring2.substring(0, substring2.length() - 3);
                L = z.L(method, w0Var, new Object[0]);
            }
            d(sb, i5, substring, L);
            i6 = 3;
        }
        if (w0Var instanceof z.c) {
            Iterator<Map.Entry<z.d, Object>> t5 = ((z.c) w0Var).extensions.t();
            while (t5.hasNext()) {
                Map.Entry<z.d, Object> next = t5.next();
                d(sb, i5, "[" + next.getKey().b() + "]", next.getValue());
            }
        }
        x1 x1Var = ((z) w0Var).unknownFields;
        if (x1Var != null) {
            x1Var.m(sb, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String f(w0 w0Var, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        e(w0Var, sb, 0);
        return sb.toString();
    }
}
