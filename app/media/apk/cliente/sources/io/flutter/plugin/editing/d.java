package io.flutter.plugin.editing;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.InputMethodManager;
import com.google.android.gms.common.api.a;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.editing.e;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import y2.s;
/* loaded from: classes.dex */
public class d extends BaseInputConnection implements e.b {

    /* renamed from: a  reason: collision with root package name */
    private final View f3927a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3928b;

    /* renamed from: c  reason: collision with root package name */
    private final s f3929c;

    /* renamed from: d  reason: collision with root package name */
    private final e f3930d;

    /* renamed from: e  reason: collision with root package name */
    private final EditorInfo f3931e;

    /* renamed from: f  reason: collision with root package name */
    private ExtractedTextRequest f3932f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3933g;

    /* renamed from: h  reason: collision with root package name */
    private CursorAnchorInfo.Builder f3934h;

    /* renamed from: i  reason: collision with root package name */
    private ExtractedText f3935i;

    /* renamed from: j  reason: collision with root package name */
    private InputMethodManager f3936j;

    /* renamed from: k  reason: collision with root package name */
    private final Layout f3937k;

    /* renamed from: l  reason: collision with root package name */
    private io.flutter.plugin.editing.a f3938l;

    /* renamed from: m  reason: collision with root package name */
    private final a f3939m;

    /* renamed from: n  reason: collision with root package name */
    private int f3940n;

    /* loaded from: classes.dex */
    public interface a {
        boolean b(KeyEvent keyEvent);
    }

    public d(View view, int i5, s sVar, a aVar, e eVar, EditorInfo editorInfo) {
        this(view, i5, sVar, aVar, eVar, editorInfo, new FlutterJNI());
    }

    public d(View view, int i5, s sVar, a aVar, e eVar, EditorInfo editorInfo, FlutterJNI flutterJNI) {
        super(view, true);
        this.f3933g = false;
        this.f3935i = new ExtractedText();
        this.f3940n = 0;
        this.f3927a = view;
        this.f3928b = i5;
        this.f3929c = sVar;
        this.f3930d = eVar;
        eVar.a(this);
        this.f3931e = editorInfo;
        this.f3939m = aVar;
        this.f3938l = new io.flutter.plugin.editing.a(flutterJNI);
        this.f3937k = new DynamicLayout(eVar, new TextPaint(), a.e.API_PRIORITY_OTHER, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.f3936j = (InputMethodManager) view.getContext().getSystemService("input_method");
    }

    private boolean b(int i5) {
        if (i5 == 16908319) {
            setSelection(0, this.f3930d.length());
            return true;
        } else if (i5 == 16908320) {
            int selectionStart = Selection.getSelectionStart(this.f3930d);
            int selectionEnd = Selection.getSelectionEnd(this.f3930d);
            if (selectionStart != selectionEnd) {
                int min = Math.min(selectionStart, selectionEnd);
                int max = Math.max(selectionStart, selectionEnd);
                ((ClipboardManager) this.f3927a.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.f3930d.subSequence(min, max)));
                this.f3930d.delete(min, max);
                setSelection(min, min);
            }
            return true;
        } else if (i5 == 16908321) {
            int selectionStart2 = Selection.getSelectionStart(this.f3930d);
            int selectionEnd2 = Selection.getSelectionEnd(this.f3930d);
            if (selectionStart2 != selectionEnd2) {
                ((ClipboardManager) this.f3927a.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.f3930d.subSequence(Math.min(selectionStart2, selectionEnd2), Math.max(selectionStart2, selectionEnd2))));
            }
            return true;
        } else if (i5 == 16908322) {
            ClipData primaryClip = ((ClipboardManager) this.f3927a.getContext().getSystemService("clipboard")).getPrimaryClip();
            if (primaryClip != null) {
                CharSequence coerceToText = primaryClip.getItemAt(0).coerceToText(this.f3927a.getContext());
                int max2 = Math.max(0, Selection.getSelectionStart(this.f3930d));
                int max3 = Math.max(0, Selection.getSelectionEnd(this.f3930d));
                int min2 = Math.min(max2, max3);
                int max4 = Math.max(max2, max3);
                if (min2 != max4) {
                    this.f3930d.delete(min2, max4);
                }
                this.f3930d.insert(min2, coerceToText);
                int length = min2 + coerceToText.length();
                setSelection(length, length);
            }
            return true;
        } else {
            return false;
        }
    }

    private CursorAnchorInfo c() {
        CursorAnchorInfo.Builder builder = this.f3934h;
        if (builder == null) {
            this.f3934h = new CursorAnchorInfo.Builder();
        } else {
            builder.reset();
        }
        this.f3934h.setSelectionRange(this.f3930d.i(), this.f3930d.h());
        int g5 = this.f3930d.g();
        int f5 = this.f3930d.f();
        if (g5 < 0 || f5 <= g5) {
            this.f3934h.setComposingText(-1, "");
        } else {
            this.f3934h.setComposingText(g5, this.f3930d.toString().subSequence(g5, f5));
        }
        return this.f3934h.build();
    }

    private ExtractedText d(ExtractedTextRequest extractedTextRequest) {
        ExtractedText extractedText = this.f3935i;
        extractedText.startOffset = 0;
        extractedText.partialStartOffset = -1;
        extractedText.partialEndOffset = -1;
        extractedText.selectionStart = this.f3930d.i();
        this.f3935i.selectionEnd = this.f3930d.h();
        this.f3935i.text = (extractedTextRequest == null || (extractedTextRequest.flags & 1) == 0) ? this.f3930d.toString() : this.f3930d;
        return this.f3935i;
    }

    private boolean e(boolean z4, boolean z5) {
        int selectionStart = Selection.getSelectionStart(this.f3930d);
        int selectionEnd = Selection.getSelectionEnd(this.f3930d);
        boolean z6 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        int max = z4 ? Math.max(this.f3938l.b(this.f3930d, selectionEnd), 0) : Math.min(this.f3938l.a(this.f3930d, selectionEnd), this.f3930d.length());
        if (selectionStart == selectionEnd && !z5) {
            z6 = true;
        }
        if (z6) {
            setSelection(max, max);
        } else {
            setSelection(selectionStart, max);
        }
        return true;
    }

    private boolean g(boolean z4, boolean z5) {
        int selectionStart = Selection.getSelectionStart(this.f3930d);
        int selectionEnd = Selection.getSelectionEnd(this.f3930d);
        boolean z6 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        if (selectionStart == selectionEnd && !z5) {
            z6 = true;
        }
        beginBatchEdit();
        if (z6) {
            if (z4) {
                Selection.moveUp(this.f3930d, this.f3937k);
            } else {
                Selection.moveDown(this.f3930d, this.f3937k);
            }
            int selectionStart2 = Selection.getSelectionStart(this.f3930d);
            setSelection(selectionStart2, selectionStart2);
        } else {
            if (z4) {
                Selection.extendUp(this.f3930d, this.f3937k);
            } else {
                Selection.extendDown(this.f3930d, this.f3937k);
            }
            setSelection(Selection.getSelectionStart(this.f3930d), Selection.getSelectionEnd(this.f3930d));
        }
        endBatchEdit();
        return true;
    }

    private byte[] h(InputStream inputStream, int i5) {
        int i6;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[i5];
        while (true) {
            try {
                i6 = inputStream.read(bArr);
            } catch (IOException unused) {
                i6 = -1;
            }
            if (i6 == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i6);
        }
    }

    @Override // io.flutter.plugin.editing.e.b
    public void a(boolean z4, boolean z5, boolean z6) {
        this.f3936j.updateSelection(this.f3927a, this.f3930d.i(), this.f3930d.h(), this.f3930d.g(), this.f3930d.f());
        ExtractedTextRequest extractedTextRequest = this.f3932f;
        if (extractedTextRequest != null) {
            this.f3936j.updateExtractedText(this.f3927a, extractedTextRequest.token, d(extractedTextRequest));
        }
        if (this.f3933g) {
            this.f3936j.updateCursorAnchorInfo(this.f3927a, c());
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        this.f3930d.b();
        this.f3940n++;
        return super.beginBatchEdit();
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int i5) {
        return super.clearMetaKeyStates(i5);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public void closeConnection() {
        super.closeConnection();
        this.f3930d.l(this);
        while (this.f3940n > 0) {
            endBatchEdit();
            this.f3940n--;
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo inputContentInfo, int i5, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 25 && (i5 & 1) != 0) {
            try {
                inputContentInfo.requestPermission();
                if (inputContentInfo.getDescription().getMimeTypeCount() > 0) {
                    inputContentInfo.requestPermission();
                    Uri contentUri = inputContentInfo.getContentUri();
                    String mimeType = inputContentInfo.getDescription().getMimeType(0);
                    Context context = this.f3927a.getContext();
                    if (contentUri != null) {
                        try {
                            InputStream openInputStream = context.getContentResolver().openInputStream(contentUri);
                            if (openInputStream != null) {
                                byte[] h5 = h(openInputStream, 65536);
                                HashMap hashMap = new HashMap();
                                hashMap.put("mimeType", mimeType);
                                hashMap.put("data", h5);
                                hashMap.put("uri", contentUri.toString());
                                this.f3929c.b(this.f3928b, hashMap);
                                inputContentInfo.releasePermission();
                                return true;
                            }
                        } catch (FileNotFoundException unused) {
                            inputContentInfo.releasePermission();
                            return false;
                        }
                    }
                    inputContentInfo.releasePermission();
                }
            } catch (Exception unused2) {
            }
        }
        return false;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i5) {
        return super.commitText(charSequence, i5);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i5, int i6) {
        if (this.f3930d.i() == -1) {
            return true;
        }
        return super.deleteSurroundingText(i5, i6);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i5, int i6) {
        return super.deleteSurroundingTextInCodePoints(i5, i6);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        boolean endBatchEdit = super.endBatchEdit();
        this.f3940n--;
        this.f3930d.d();
        return endBatchEdit;
    }

    public boolean f(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            if (keyEvent.getKeyCode() == 21) {
                return e(true, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 22) {
                return e(false, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 19) {
                return g(true, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 20) {
                return g(false, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 160) {
                EditorInfo editorInfo = this.f3931e;
                if ((131072 & editorInfo.inputType) == 0) {
                    performEditorAction(editorInfo.imeOptions & 255);
                    return true;
                }
            }
            int selectionStart = Selection.getSelectionStart(this.f3930d);
            int selectionEnd = Selection.getSelectionEnd(this.f3930d);
            int unicodeChar = keyEvent.getUnicodeChar();
            if (selectionStart >= 0 && selectionEnd >= 0 && unicodeChar != 0) {
                int min = Math.min(selectionStart, selectionEnd);
                int max = Math.max(selectionStart, selectionEnd);
                beginBatchEdit();
                if (min != max) {
                    this.f3930d.delete(min, max);
                }
                this.f3930d.insert(min, (CharSequence) String.valueOf((char) unicodeChar));
                int i5 = min + 1;
                setSelection(i5, i5);
                endBatchEdit();
                return true;
            }
        }
        return false;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        return super.finishComposingText();
    }

    @Override // android.view.inputmethod.BaseInputConnection
    public Editable getEditable() {
        return this.f3930d;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i5) {
        boolean z4 = (i5 & 1) != 0;
        if (z4 == (this.f3932f == null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled text monitoring ");
            sb.append(z4 ? "on" : "off");
            n2.b.a("InputConnectionAdaptor", sb.toString());
        }
        this.f3932f = z4 ? extractedTextRequest : null;
        return d(extractedTextRequest);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i5) {
        beginBatchEdit();
        boolean b5 = b(i5);
        endBatchEdit();
        return b5;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i5) {
        if (i5 == 0) {
            this.f3929c.o(this.f3928b);
        } else if (i5 == 1) {
            this.f3929c.g(this.f3928b);
        } else if (i5 == 2) {
            this.f3929c.f(this.f3928b);
        } else if (i5 == 3) {
            this.f3929c.l(this.f3928b);
        } else if (i5 == 4) {
            this.f3929c.m(this.f3928b);
        } else if (i5 == 5) {
            this.f3929c.h(this.f3928b);
        } else if (i5 != 7) {
            this.f3929c.e(this.f3928b);
        } else {
            this.f3929c.j(this.f3928b);
        }
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String str, Bundle bundle) {
        this.f3929c.i(this.f3928b, str, bundle);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int i5) {
        if ((i5 & 1) != 0) {
            this.f3936j.updateCursorAnchorInfo(this.f3927a, c());
        }
        boolean z4 = (i5 & 2) != 0;
        if (z4 != this.f3933g) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled cursor monitoring ");
            sb.append(z4 ? "on" : "off");
            n2.b.a("InputConnectionAdaptor", sb.toString());
        }
        this.f3933g = z4;
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        return this.f3939m.b(keyEvent);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i5, int i6) {
        return super.setComposingRegion(i5, i6);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i5) {
        beginBatchEdit();
        boolean commitText = charSequence.length() == 0 ? super.commitText(charSequence, i5) : super.setComposingText(charSequence, i5);
        endBatchEdit();
        return commitText;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setSelection(int i5, int i6) {
        beginBatchEdit();
        boolean selection = super.setSelection(i5, i6);
        endBatchEdit();
        return selection;
    }
}
