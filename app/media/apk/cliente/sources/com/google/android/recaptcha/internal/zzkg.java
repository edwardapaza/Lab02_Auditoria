package com.google.android.recaptcha.internal;

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
public final class zzkg {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzke zzkeVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzkeVar, sb, 0);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(StringBuilder sb, int i5, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                zzb(sb, i5, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                zzb(sb, i5, str, entry);
            }
        } else {
            sb.append('\n');
            zzc(i5, sb);
            if (!str.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Character.toLowerCase(str.charAt(0)));
                for (int i6 = 1; i6 < str.length(); i6++) {
                    char charAt = str.charAt(i6);
                    if (Character.isUpperCase(charAt)) {
                        sb2.append("_");
                    }
                    sb2.append(Character.toLowerCase(charAt));
                }
                str = sb2.toString();
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzlg.zza(new zzgt(((String) obj).getBytes(zzjc.zzb))));
                sb.append('\"');
            } else if (obj instanceof zzgw) {
                sb.append(": \"");
                sb.append(zzlg.zza((zzgw) obj));
                sb.append('\"');
            } else if (obj instanceof zzit) {
                sb.append(" {");
                zzd((zzit) obj, sb, i5 + 2);
                sb.append("\n");
                zzc(i5, sb);
                sb.append("}");
            } else if (!(obj instanceof Map.Entry)) {
                sb.append(": ");
                sb.append(obj);
            } else {
                int i7 = i5 + 2;
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                zzb(sb, i7, "key", entry2.getKey());
                zzb(sb, i7, "value", entry2.getValue());
                sb.append("\n");
                zzc(i5, sb);
                sb.append("}");
            }
        }
    }

    private static void zzc(int i5, StringBuilder sb) {
        while (i5 > 0) {
            int i6 = 80;
            if (i5 <= 80) {
                i6 = i5;
            }
            sb.append(zza, 0, i6);
            i5 -= i6;
        }
    }

    private static void zzd(zzke zzkeVar, StringBuilder sb, int i5) {
        int i6;
        Object obj;
        Method method;
        String substring;
        Object zzz;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzkeVar.getClass().getDeclaredMethods();
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
                zzz = zzit.zzz(method2, zzkeVar, new Object[0]);
            } else if (!substring2.endsWith("Map") || substring2.equals("Map") || (method = (Method) entry.getValue()) == null || !method.getReturnType().equals(Map.class) || method.isAnnotationPresent(Deprecated.class) || !Modifier.isPublic(method.getModifiers())) {
                if (hashSet.contains("set".concat(substring2)) && (!substring2.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring2.substring(0, substring2.length() - 5)))))) {
                    Method method4 = (Method) entry.getValue();
                    Method method5 = (Method) hashMap.get("has".concat(substring2));
                    if (method4 != null) {
                        Object zzz2 = zzit.zzz(method4, zzkeVar, new Object[0]);
                        if (method5 != null) {
                            if (!((Boolean) zzit.zzz(method5, zzkeVar, new Object[0])).booleanValue()) {
                            }
                            zzb(sb, i5, substring2, zzz2);
                        } else if (zzz2 instanceof Boolean) {
                            if (!((Boolean) zzz2).booleanValue()) {
                            }
                            zzb(sb, i5, substring2, zzz2);
                        } else if (zzz2 instanceof Integer) {
                            if (((Integer) zzz2).intValue() == 0) {
                            }
                            zzb(sb, i5, substring2, zzz2);
                        } else if (zzz2 instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zzz2).floatValue()) == 0) {
                            }
                            zzb(sb, i5, substring2, zzz2);
                        } else if (zzz2 instanceof Double) {
                            if (Double.doubleToRawLongBits(((Double) zzz2).doubleValue()) == 0) {
                            }
                            zzb(sb, i5, substring2, zzz2);
                        } else {
                            if (zzz2 instanceof String) {
                                obj = "";
                            } else if (zzz2 instanceof zzgw) {
                                obj = zzgw.zzb;
                            } else if (zzz2 instanceof zzke) {
                                if (zzz2 == ((zzke) zzz2).zzY()) {
                                }
                                zzb(sb, i5, substring2, zzz2);
                            } else {
                                if ((zzz2 instanceof Enum) && ((Enum) zzz2).ordinal() == 0) {
                                }
                                zzb(sb, i5, substring2, zzz2);
                            }
                            if (zzz2.equals(obj)) {
                            }
                            zzb(sb, i5, substring2, zzz2);
                        }
                    }
                }
                i6 = 3;
            } else {
                substring = substring2.substring(0, substring2.length() - 3);
                zzz = zzit.zzz(method, zzkeVar, new Object[0]);
            }
            zzb(sb, i5, substring, zzz);
            i6 = 3;
        }
        if (zzkeVar instanceof zzip) {
            Iterator zzf = ((zzip) zzkeVar).zzb.zzf();
            while (zzf.hasNext()) {
                Map.Entry entry2 = (Map.Entry) zzf.next();
                int i8 = ((zziq) entry2.getKey()).zza;
                zzb(sb, i5, "[" + i8 + "]", entry2.getValue());
            }
        }
        zzlm zzlmVar = ((zzit) zzkeVar).zzc;
        if (zzlmVar != null) {
            zzlmVar.zzi(sb, i5);
        }
    }
}
