package b3;

import android.view.PointerIcon;
import java.util.HashMap;
import y2.i;
/* loaded from: classes.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    private static HashMap<String, Integer> f754c;

    /* renamed from: a  reason: collision with root package name */
    private final c f755a;

    /* renamed from: b  reason: collision with root package name */
    private final i f756b;

    /* loaded from: classes.dex */
    class a implements i.b {
        a() {
        }

        @Override // y2.i.b
        public void a(String str) {
            b.this.f755a.setPointerIcon(b.this.d(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b3.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0029b extends HashMap<String, Integer> {
        C0029b() {
            put("alias", 1010);
            put("allScroll", 1013);
            put("basic", 1000);
            put("cell", 1006);
            put("click", 1002);
            put("contextMenu", 1001);
            put("copy", 1011);
            put("forbidden", 1012);
            put("grab", 1020);
            put("grabbing", 1021);
            put("help", 1003);
            put("move", 1013);
            put("none", 0);
            put("noDrop", 1012);
            put("precise", 1007);
            put("text", 1008);
            put("resizeColumn", 1014);
            put("resizeDown", 1015);
            put("resizeUpLeft", 1016);
            put("resizeDownRight", 1017);
            put("resizeLeft", 1014);
            put("resizeLeftRight", 1014);
            put("resizeRight", 1014);
            put("resizeRow", 1015);
            put("resizeUp", 1015);
            put("resizeUpDown", 1015);
            put("resizeUpLeft", 1017);
            put("resizeUpRight", 1016);
            put("resizeUpLeftDownRight", 1017);
            put("resizeUpRightDownLeft", 1016);
            put("verticalText", 1009);
            put("wait", 1004);
            put("zoomIn", 1018);
            put("zoomOut", 1019);
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        PointerIcon b(int i5);

        void setPointerIcon(PointerIcon pointerIcon);
    }

    public b(c cVar, i iVar) {
        this.f755a = cVar;
        this.f756b = iVar;
        iVar.b(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PointerIcon d(String str) {
        Object orDefault;
        if (f754c == null) {
            f754c = new C0029b();
        }
        orDefault = f754c.getOrDefault(str, 1000);
        return this.f755a.b(((Integer) orDefault).intValue());
    }

    public void c() {
        this.f756b.b(null);
    }
}
