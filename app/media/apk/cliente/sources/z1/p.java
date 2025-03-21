package z1;

import android.os.AsyncTask;
import com.google.android.gms.tasks.TaskExecutors;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f8960a = TaskExecutors.MAIN_THREAD;

    /* renamed from: b  reason: collision with root package name */
    public static final Executor f8961b = new androidx.profileinstaller.g();

    /* renamed from: c  reason: collision with root package name */
    public static final Executor f8962c = new b0(4, AsyncTask.THREAD_POOL_EXECUTOR);
}
