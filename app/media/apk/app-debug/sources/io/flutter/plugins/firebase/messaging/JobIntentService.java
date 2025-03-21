package io.flutter.plugins.firebase.messaging;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class JobIntentService extends Service {
    static final boolean DEBUG = false;
    static final String TAG = "JobIntentService";
    WorkEnqueuer mCompatWorkEnqueuer;
    CommandProcessor mCurProcessor;
    CompatJobEngine mJobImpl;
    static final Object sLock = new Object();
    static final HashMap<ComponentNameWithWakeful, WorkEnqueuer> sClassWorkEnqueuer = new HashMap<>();
    boolean mStopped = false;
    boolean mDestroyed = false;
    final ArrayList<CompatWorkItem> mCompatQueue = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface CompatJobEngine {
        IBinder compatGetBinder();

        GenericWorkItem dequeueWork();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface GenericWorkItem {
        void complete();

        Intent getIntent();
    }

    protected abstract void onHandleWork(Intent intent);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ComponentNameWithWakeful {
        private ComponentName componentName;
        private boolean useWakefulService;

        ComponentNameWithWakeful(ComponentName componentName, boolean useWakefulService) {
            this.componentName = componentName;
            this.useWakefulService = useWakefulService;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class WorkEnqueuer {
        final ComponentName mComponentName;
        boolean mHasJobId;
        int mJobId;

        abstract void enqueueWork(Intent intent);

        WorkEnqueuer(ComponentName cn) {
            this.mComponentName = cn;
        }

        void ensureJobId(int jobId) {
            if (!this.mHasJobId) {
                this.mHasJobId = true;
                this.mJobId = jobId;
            } else if (this.mJobId != jobId) {
                throw new IllegalArgumentException("Given job ID " + jobId + " is different than previous " + this.mJobId);
            }
        }

        public void serviceStartReceived() {
        }

        public void serviceProcessingStarted() {
        }

        public void serviceProcessingFinished() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class CompatWorkEnqueuer extends WorkEnqueuer {
        private final Context mContext;
        private final PowerManager.WakeLock mLaunchWakeLock;
        boolean mLaunchingService;
        private final PowerManager.WakeLock mRunWakeLock;
        boolean mServiceProcessing;

        CompatWorkEnqueuer(Context context, ComponentName cn) {
            super(cn);
            this.mContext = context.getApplicationContext();
            PowerManager pm = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = pm.newWakeLock(1, cn.getClassName() + ":launch");
            this.mLaunchWakeLock = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = pm.newWakeLock(1, cn.getClassName() + ":run");
            this.mRunWakeLock = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        @Override // io.flutter.plugins.firebase.messaging.JobIntentService.WorkEnqueuer
        void enqueueWork(Intent work) {
            Intent intent = new Intent(work);
            intent.setComponent(this.mComponentName);
            if (this.mContext.startService(intent) != null) {
                synchronized (this) {
                    if (!this.mLaunchingService) {
                        this.mLaunchingService = true;
                        if (!this.mServiceProcessing) {
                            this.mLaunchWakeLock.acquire(60000L);
                        }
                    }
                }
            }
        }

        @Override // io.flutter.plugins.firebase.messaging.JobIntentService.WorkEnqueuer
        public void serviceStartReceived() {
            synchronized (this) {
                this.mLaunchingService = false;
            }
        }

        @Override // io.flutter.plugins.firebase.messaging.JobIntentService.WorkEnqueuer
        public void serviceProcessingStarted() {
            synchronized (this) {
                if (!this.mServiceProcessing) {
                    this.mServiceProcessing = true;
                    this.mRunWakeLock.acquire(600000L);
                    this.mLaunchWakeLock.release();
                }
            }
        }

        @Override // io.flutter.plugins.firebase.messaging.JobIntentService.WorkEnqueuer
        public void serviceProcessingFinished() {
            synchronized (this) {
                if (this.mServiceProcessing) {
                    if (this.mLaunchingService) {
                        this.mLaunchWakeLock.acquire(60000L);
                    }
                    this.mServiceProcessing = false;
                    this.mRunWakeLock.release();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {
        static final boolean DEBUG = false;
        static final String TAG = "JobServiceEngineImpl";
        final Object mLock;
        JobParameters mParams;
        final JobIntentService mService;

        /* loaded from: classes2.dex */
        final class WrapperWorkItem implements GenericWorkItem {
            final JobWorkItem mJobWork;

            WrapperWorkItem(JobWorkItem jobWork) {
                this.mJobWork = jobWork;
            }

            @Override // io.flutter.plugins.firebase.messaging.JobIntentService.GenericWorkItem
            public Intent getIntent() {
                return this.mJobWork.getIntent();
            }

            @Override // io.flutter.plugins.firebase.messaging.JobIntentService.GenericWorkItem
            public void complete() {
                synchronized (JobServiceEngineImpl.this.mLock) {
                    if (JobServiceEngineImpl.this.mParams != null) {
                        try {
                            JobServiceEngineImpl.this.mParams.completeWork(this.mJobWork);
                        } catch (IllegalArgumentException e) {
                            Log.e(JobServiceEngineImpl.TAG, "IllegalArgumentException: Failed to run mParams.completeWork(mJobWork)!", e);
                        } catch (SecurityException e2) {
                            Log.e(JobServiceEngineImpl.TAG, "SecurityException: Failed to run mParams.completeWork(mJobWork)!", e2);
                        }
                    }
                }
            }
        }

        JobServiceEngineImpl(JobIntentService service) {
            super(service);
            this.mLock = new Object();
            this.mService = service;
        }

        @Override // io.flutter.plugins.firebase.messaging.JobIntentService.CompatJobEngine
        public IBinder compatGetBinder() {
            return getBinder();
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters params) {
            this.mParams = params;
            this.mService.ensureProcessorRunningLocked(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters params) {
            boolean result = this.mService.doStopCurrentWork();
            synchronized (this.mLock) {
                this.mParams = null;
            }
            return result;
        }

        @Override // io.flutter.plugins.firebase.messaging.JobIntentService.CompatJobEngine
        public GenericWorkItem dequeueWork() {
            synchronized (this.mLock) {
                JobParameters jobParameters = this.mParams;
                if (jobParameters == null) {
                    return null;
                }
                try {
                    JobWorkItem work = jobParameters.dequeueWork();
                    if (work != null) {
                        work.getIntent().setExtrasClassLoader(this.mService.getClassLoader());
                        return new WrapperWorkItem(work);
                    }
                    return null;
                } catch (SecurityException e) {
                    Log.e(TAG, "Failed to run mParams.dequeueWork()!", e);
                    return null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class JobWorkEnqueuer extends WorkEnqueuer {
        private final JobInfo mJobInfo;
        private final JobScheduler mJobScheduler;

        JobWorkEnqueuer(Context context, ComponentName cn, int jobId) {
            super(cn);
            ensureJobId(jobId);
            JobInfo.Builder b = new JobInfo.Builder(jobId, this.mComponentName);
            this.mJobInfo = b.setOverrideDeadline(0L).build();
            this.mJobScheduler = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // io.flutter.plugins.firebase.messaging.JobIntentService.WorkEnqueuer
        void enqueueWork(Intent work) {
            this.mJobScheduler.enqueue(this.mJobInfo, new JobWorkItem(work));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class CompatWorkItem implements GenericWorkItem {
        final Intent mIntent;
        final int mStartId;

        CompatWorkItem(Intent intent, int startId) {
            this.mIntent = intent;
            this.mStartId = startId;
        }

        @Override // io.flutter.plugins.firebase.messaging.JobIntentService.GenericWorkItem
        public Intent getIntent() {
            return this.mIntent;
        }

        @Override // io.flutter.plugins.firebase.messaging.JobIntentService.GenericWorkItem
        public void complete() {
            JobIntentService.this.stopSelf(this.mStartId);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class CommandProcessor {
        private final Executor executor = Executors.newSingleThreadExecutor();
        private final Handler handler = new Handler(Looper.getMainLooper());

        CommandProcessor() {
        }

        public void execute() {
            this.executor.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.JobIntentService.CommandProcessor.1
                @Override // java.lang.Runnable
                public void run() {
                    while (true) {
                        GenericWorkItem work = JobIntentService.this.dequeueWork();
                        if (work == null) {
                            CommandProcessor.this.handler.post(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.JobIntentService.CommandProcessor.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    JobIntentService.this.processorFinished();
                                }
                            });
                            return;
                        } else {
                            JobIntentService.this.onHandleWork(work.getIntent());
                            work.complete();
                        }
                    }
                }
            });
        }

        public void cancel() {
            JobIntentService.this.processorFinished();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.mJobImpl = new JobServiceEngineImpl(this);
            this.mCompatWorkEnqueuer = null;
        }
        ComponentName cn = new ComponentName(this, getClass());
        this.mCompatWorkEnqueuer = getWorkEnqueuer(this, cn, false, 0, true);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        this.mCompatWorkEnqueuer.serviceStartReceived();
        synchronized (this.mCompatQueue) {
            this.mCompatQueue.add(new CompatWorkItem(intent != null ? intent : new Intent(), startId));
            ensureProcessorRunningLocked(true);
        }
        return 3;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        CompatJobEngine compatJobEngine = this.mJobImpl;
        if (compatJobEngine != null) {
            IBinder engine = compatJobEngine.compatGetBinder();
            return engine;
        }
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        doStopCurrentWork();
        synchronized (this.mCompatQueue) {
            this.mDestroyed = true;
            this.mCompatWorkEnqueuer.serviceProcessingFinished();
        }
    }

    public static void enqueueWork(Context context, Class cls, int jobId, Intent work, boolean useWakefulService) {
        enqueueWork(context, new ComponentName(context, cls), jobId, work, useWakefulService);
    }

    public static void enqueueWork(Context context, ComponentName component, int jobId, Intent work, boolean useWakefulService) {
        if (work == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (sLock) {
            WorkEnqueuer we = getWorkEnqueuer(context, component, true, jobId, useWakefulService);
            we.ensureJobId(jobId);
            try {
                we.enqueueWork(work);
            } catch (IllegalStateException e) {
                if (!useWakefulService) {
                    throw e;
                }
                getWorkEnqueuer(context, component, true, jobId, false).enqueueWork(work);
            }
        }
    }

    static WorkEnqueuer getWorkEnqueuer(Context context, ComponentName cn, boolean hasJobId, int jobId, boolean useWakefulService) {
        ComponentNameWithWakeful key = new ComponentNameWithWakeful(cn, useWakefulService);
        HashMap<ComponentNameWithWakeful, WorkEnqueuer> hashMap = sClassWorkEnqueuer;
        WorkEnqueuer we = hashMap.get(key);
        if (we == null) {
            if (Build.VERSION.SDK_INT >= 26 && !useWakefulService) {
                if (!hasJobId) {
                    throw new IllegalArgumentException("Can't be here without a job id");
                }
                we = new JobWorkEnqueuer(context, cn, jobId);
            } else {
                we = new CompatWorkEnqueuer(context, cn);
            }
            hashMap.put(key, we);
        }
        return we;
    }

    public boolean isStopped() {
        return this.mStopped;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    boolean doStopCurrentWork() {
        CommandProcessor commandProcessor = this.mCurProcessor;
        if (commandProcessor != null) {
            commandProcessor.cancel();
        }
        this.mStopped = true;
        return onStopCurrentWork();
    }

    void ensureProcessorRunningLocked(boolean reportStarted) {
        if (this.mCurProcessor == null) {
            this.mCurProcessor = new CommandProcessor();
            WorkEnqueuer workEnqueuer = this.mCompatWorkEnqueuer;
            if (workEnqueuer != null && reportStarted) {
                workEnqueuer.serviceProcessingStarted();
            }
            this.mCurProcessor.execute();
        }
    }

    void processorFinished() {
        ArrayList<CompatWorkItem> arrayList = this.mCompatQueue;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.mCurProcessor = null;
                ArrayList<CompatWorkItem> arrayList2 = this.mCompatQueue;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    ensureProcessorRunningLocked(false);
                } else if (!this.mDestroyed) {
                    this.mCompatWorkEnqueuer.serviceProcessingFinished();
                }
            }
        }
    }

    GenericWorkItem dequeueWork() {
        GenericWorkItem jobWork;
        CompatJobEngine compatJobEngine = this.mJobImpl;
        if (compatJobEngine == null || (jobWork = compatJobEngine.dequeueWork()) == null) {
            synchronized (this.mCompatQueue) {
                if (this.mCompatQueue.size() > 0) {
                    return this.mCompatQueue.remove(0);
                }
                return null;
            }
        }
        return jobWork;
    }
}
