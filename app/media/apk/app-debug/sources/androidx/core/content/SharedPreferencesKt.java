package androidx.core.content;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* compiled from: SharedPreferences.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0087\b¨\u0006\t"}, d2 = {"edit", "", "Landroid/content/SharedPreferences;", "commit", "", "action", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "Lkotlin/ExtensionFunctionType;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SharedPreferencesKt {
    public static /* synthetic */ void edit$default(SharedPreferences $this$edit_u24default, boolean commit, Function1 action, int i, Object obj) {
        if ((i & 1) != 0) {
            commit = false;
        }
        SharedPreferences.Editor editor = $this$edit_u24default.edit();
        action.invoke(editor);
        if (commit) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static final void edit(SharedPreferences $this$edit, boolean commit, Function1<? super SharedPreferences.Editor, Unit> function1) {
        SharedPreferences.Editor editor = $this$edit.edit();
        function1.invoke(editor);
        if (commit) {
            editor.commit();
        } else {
            editor.apply();
        }
    }
}
