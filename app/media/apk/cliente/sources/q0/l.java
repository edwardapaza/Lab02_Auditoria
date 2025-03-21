package q0;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import com.google.android.gms.common.internal.q;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static String f6933a;

    /* renamed from: b  reason: collision with root package name */
    private static int f6934b;

    public static String a() {
        BufferedReader bufferedReader;
        String processName;
        if (f6933a == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                processName = Application.getProcessName();
                f6933a = processName;
            } else {
                int i5 = f6934b;
                if (i5 == 0) {
                    i5 = Process.myPid();
                    f6934b = i5;
                }
                String str = null;
                str = null;
                str = null;
                BufferedReader bufferedReader2 = null;
                if (i5 > 0) {
                    try {
                        String str2 = "/proc/" + i5 + "/cmdline";
                        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            bufferedReader = new BufferedReader(new FileReader(str2));
                            try {
                                String readLine = bufferedReader.readLine();
                                q.k(readLine);
                                str = readLine.trim();
                            } catch (IOException unused) {
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader2 = bufferedReader;
                                i.a(bufferedReader2);
                                throw th;
                            }
                        } finally {
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                        }
                    } catch (IOException unused2) {
                        bufferedReader = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    i.a(bufferedReader);
                }
                f6933a = str;
            }
        }
        return f6933a;
    }
}
