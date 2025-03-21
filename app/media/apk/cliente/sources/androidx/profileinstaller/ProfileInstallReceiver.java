package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import androidx.profileinstaller.i;
/* loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements i.c {
        a() {
        }

        @Override // androidx.profileinstaller.i.c
        public void a(int i5, Object obj) {
            i.f659b.a(i5, obj);
        }

        @Override // androidx.profileinstaller.i.c
        public void b(int i5, Object obj) {
            i.f659b.b(i5, obj);
            ProfileInstallReceiver.this.setResultCode(i5);
        }
    }

    static void a(i.c cVar) {
        int i5;
        if (Build.VERSION.SDK_INT >= 24) {
            Process.sendSignal(Process.myPid(), 10);
            i5 = 12;
        } else {
            i5 = 13;
        }
        cVar.b(i5, null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
            i.k(context, new g(), new a(), true);
        } else if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                if ("WRITE_SKIP_FILE".equals(string)) {
                    i.l(context, new g(), new a());
                } else if ("DELETE_SKIP_FILE".equals(string)) {
                    i.c(context, new g(), new a());
                }
            }
        } else if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
            a(new a());
        } else if (!"androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) || (extras = intent.getExtras()) == null) {
        } else {
            String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
            a aVar = new a();
            if ("DROP_SHADER_CACHE".equals(string2)) {
                androidx.profileinstaller.a.b(context, aVar);
            } else {
                aVar.b(16, null);
            }
        }
    }
}
