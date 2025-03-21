package com.google.protobuf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t1 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f2141a;

        a(i iVar) {
            this.f2141a = iVar;
        }

        @Override // com.google.protobuf.t1.b
        public byte a(int i5) {
            return this.f2141a.k(i5);
        }

        @Override // com.google.protobuf.t1.b
        public int size() {
            return this.f2141a.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface b {
        byte a(int i5);

        int size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(i iVar) {
        return b(new a(iVar));
    }

    static String b(b bVar) {
        String str;
        StringBuilder sb = new StringBuilder(bVar.size());
        for (int i5 = 0; i5 < bVar.size(); i5++) {
            int a5 = bVar.a(i5);
            if (a5 == 34) {
                str = "\\\"";
            } else if (a5 == 39) {
                str = "\\'";
            } else if (a5 != 92) {
                switch (a5) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                        str = "\\t";
                        break;
                    case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case i2.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (a5 < 32 || a5 > 126) {
                            sb.append('\\');
                            sb.append((char) (((a5 >>> 6) & 3) + 48));
                            sb.append((char) (((a5 >>> 3) & 7) + 48));
                            a5 = (a5 & 7) + 48;
                        }
                        sb.append((char) a5);
                        continue;
                        break;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(String str) {
        return a(i.r(str));
    }
}
