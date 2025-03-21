package com.google.android.gms.tasks;
/* loaded from: classes.dex */
public class NativeOnCompleteListener implements OnCompleteListener<Object> {
    private final long zza;

    public NativeOnCompleteListener(long j5) {
        this.zza = j5;
    }

    public static void createAndAddCallback(Task<Object> task, long j5) {
        task.addOnCompleteListener(new NativeOnCompleteListener(j5));
    }

    public native void nativeOnComplete(long j5, Object obj, boolean z4, boolean z5, String str);

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task<Object> task) {
        Object obj;
        String str;
        Exception exception;
        if (task.isSuccessful()) {
            obj = task.getResult();
            str = null;
        } else if (task.isCanceled() || (exception = task.getException()) == null) {
            obj = null;
            str = null;
        } else {
            str = exception.getMessage();
            obj = null;
        }
        nativeOnComplete(this.zza, obj, task.isSuccessful(), task.isCanceled(), str);
    }
}
