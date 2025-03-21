package io.flutter.plugin.editing;

import io.flutter.embedding.engine.FlutterJNI;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final FlutterJNI f3926a;

    public a(FlutterJNI flutterJNI) {
        this.f3926a = flutterJNI;
    }

    public int a(CharSequence charSequence, int i5) {
        int length = charSequence.length();
        int i6 = length - 1;
        if (i5 >= i6) {
            return length;
        }
        int codePointAt = Character.codePointAt(charSequence, i5);
        int charCount = Character.charCount(codePointAt);
        int i7 = i5 + charCount;
        int i8 = 0;
        if (i7 == 0) {
            return 0;
        }
        if (codePointAt == 10) {
            if (Character.codePointAt(charSequence, i7) == 13) {
                charCount++;
            }
            return i5 + charCount;
        } else if (g(codePointAt)) {
            if (i7 >= i6 || !g(Character.codePointAt(charSequence, i7))) {
                return i7;
            }
            int i9 = i5;
            while (i9 > 0 && g(Character.codePointBefore(charSequence, i5))) {
                i9 -= Character.charCount(Character.codePointBefore(charSequence, i5));
                i8++;
            }
            if (i8 % 2 == 0) {
                charCount += 2;
            }
            return i5 + charCount;
        } else {
            if (f(codePointAt)) {
                charCount += Character.charCount(codePointAt);
            }
            if (codePointAt == 8419) {
                int codePointBefore = Character.codePointBefore(charSequence, i7);
                int charCount2 = i7 + Character.charCount(codePointBefore);
                if (charCount2 < length && i(codePointBefore)) {
                    int codePointAt2 = Character.codePointAt(charSequence, charCount2);
                    if (f(codePointAt2)) {
                        charCount += Character.charCount(codePointBefore) + Character.charCount(codePointAt2);
                    }
                } else if (f(codePointBefore)) {
                    charCount += Character.charCount(codePointBefore);
                }
                return i5 + charCount;
            }
            if (c(codePointAt)) {
                boolean z4 = false;
                int i10 = 0;
                do {
                    if (z4) {
                        charCount += Character.charCount(codePointAt) + i10 + 1;
                        z4 = false;
                    }
                    if (d(codePointAt)) {
                        break;
                    }
                    if (i7 < length) {
                        codePointAt = Character.codePointAt(charSequence, i7);
                        i7 += Character.charCount(codePointAt);
                        if (codePointAt != 8419) {
                            if (!d(codePointAt) && !i(codePointAt)) {
                                if (codePointAt == 8205) {
                                    codePointAt = Character.codePointAt(charSequence, i7);
                                    i7 += Character.charCount(codePointAt);
                                    if (i7 < length && i(codePointAt)) {
                                        codePointAt = Character.codePointAt(charSequence, i7);
                                        int charCount3 = Character.charCount(codePointAt);
                                        i7 += Character.charCount(codePointAt);
                                        i10 = charCount3;
                                        z4 = true;
                                        if (i7 < length || !z4) {
                                            break;
                                            break;
                                        }
                                    } else {
                                        z4 = true;
                                    }
                                }
                            } else {
                                charCount += Character.charCount(codePointAt) + 0;
                                break;
                            }
                        } else {
                            int codePointBefore2 = Character.codePointBefore(charSequence, i7);
                            int charCount4 = i7 + Character.charCount(codePointBefore2);
                            if (charCount4 < length && i(codePointBefore2)) {
                                int codePointAt3 = Character.codePointAt(charSequence, charCount4);
                                if (f(codePointAt3)) {
                                    charCount += Character.charCount(codePointBefore2) + Character.charCount(codePointAt3);
                                }
                            } else if (f(codePointBefore2)) {
                                charCount += Character.charCount(codePointBefore2);
                            }
                            return i5 + charCount;
                        }
                    }
                    i10 = 0;
                    if (i7 < length) {
                        break;
                    }
                } while (c(codePointAt));
            }
            return i5 + charCount;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x014c A[EDGE_INSN: B:100:0x014c->B:94:0x014c ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0144  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int b(java.lang.CharSequence r9, int r10) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.a.b(java.lang.CharSequence, int):int");
    }

    public boolean c(int i5) {
        return this.f3926a.isCodePointEmoji(i5);
    }

    public boolean d(int i5) {
        return this.f3926a.isCodePointEmojiModifier(i5);
    }

    public boolean e(int i5) {
        return this.f3926a.isCodePointEmojiModifierBase(i5);
    }

    public boolean f(int i5) {
        return (48 <= i5 && i5 <= 57) || i5 == 35 || i5 == 42;
    }

    public boolean g(int i5) {
        return this.f3926a.isCodePointRegionalIndicator(i5);
    }

    public boolean h(int i5) {
        return 917536 <= i5 && i5 <= 917630;
    }

    public boolean i(int i5) {
        return this.f3926a.isCodePointVariantSelector(i5);
    }
}
