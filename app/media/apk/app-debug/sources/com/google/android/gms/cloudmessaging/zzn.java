package com.google.android.gms.cloudmessaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.firebase.messaging.Constants;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
/* loaded from: classes.dex */
public final class zzn implements ServiceConnection {
    zzp zzc;
    final /* synthetic */ zzu zzf;
    int zza = 0;
    final Messenger zzb = new Messenger(new com.google.android.gms.internal.cloudmessaging.zzf(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.gms.cloudmessaging.zzk
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i = message.arg1;
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Received response to request: " + i);
            }
            zzn zznVar = zzn.this;
            synchronized (zznVar) {
                zzr zzrVar = (zzr) zznVar.zze.get(i);
                if (zzrVar == null) {
                    Log.w("MessengerIpcClient", "Received response for unknown request: " + i);
                    return true;
                }
                zznVar.zze.remove(i);
                zznVar.zzf();
                Bundle data = message.getData();
                if (data.getBoolean("unsupported", false)) {
                    zzrVar.zzc(new zzs(4, "Not supported by GmsCore", null));
                    return true;
                }
                zzrVar.zza(data);
                return true;
            }
        }
    }));
    final Queue zzd = new ArrayDeque();
    final SparseArray zze = new SparseArray();

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzn(zzu zzuVar, zzm zzmVar) {
        this.zzf = zzuVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        zzu.zze(this.zzf).execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzg
            @Override // java.lang.Runnable
            public final void run() {
                zzn zznVar = zzn.this;
                IBinder iBinder2 = iBinder;
                synchronized (zznVar) {
                    try {
                        if (iBinder2 == null) {
                            zznVar.zza(0, "Null service connection");
                            return;
                        }
                        try {
                            zznVar.zzc = new zzp(iBinder2);
                            zznVar.zza = 2;
                            zznVar.zzc();
                        } catch (RemoteException e) {
                            zznVar.zza(0, e.getMessage());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        zzu.zze(this.zzf).execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzj
            @Override // java.lang.Runnable
            public final void run() {
                zzn.this.zza(2, "Service disconnected");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zza(int i, String str) {
        zzb(i, str, null);
    }

    final synchronized void zzb(int i, String str, Throwable th) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Disconnected: ".concat(String.valueOf(str)));
        }
        switch (this.zza) {
            case 0:
                throw new IllegalStateException();
            case 1:
            case 2:
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Unbinding service");
                }
                this.zza = 4;
                ConnectionTracker.getInstance().unbindService(zzu.zza(this.zzf), this);
                zzs zzsVar = new zzs(i, str, th);
                for (zzr zzrVar : this.zzd) {
                    zzrVar.zzc(zzsVar);
                }
                this.zzd.clear();
                for (int i2 = 0; i2 < this.zze.size(); i2++) {
                    ((zzr) this.zze.valueAt(i2)).zzc(zzsVar);
                }
                this.zze.clear();
                return;
            case 3:
                this.zza = 4;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc() {
        zzu.zze(this.zzf).execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzh
            @Override // java.lang.Runnable
            public final void run() {
                final zzr zzrVar;
                while (true) {
                    final zzn zznVar = zzn.this;
                    synchronized (zznVar) {
                        if (zznVar.zza != 2) {
                            return;
                        }
                        if (!zznVar.zzd.isEmpty()) {
                            zzrVar = (zzr) zznVar.zzd.poll();
                            zznVar.zze.put(zzrVar.zza, zzrVar);
                            zzu.zze(zznVar.zzf).schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzl
                                @Override // java.lang.Runnable
                                public final void run() {
                                    zzn.this.zze(zzrVar.zza);
                                }
                            }, 30L, TimeUnit.SECONDS);
                        } else {
                            zznVar.zzf();
                            return;
                        }
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        Log.d("MessengerIpcClient", "Sending ".concat(String.valueOf(String.valueOf(zzrVar))));
                    }
                    zzu zzuVar = zznVar.zzf;
                    Messenger messenger = zznVar.zzb;
                    int i = zzrVar.zzc;
                    Context zza = zzu.zza(zzuVar);
                    Message obtain = Message.obtain();
                    obtain.what = i;
                    obtain.arg1 = zzrVar.zza;
                    obtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", zzrVar.zzb());
                    bundle.putString("pkg", zza.getPackageName());
                    bundle.putBundle(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, zzrVar.zzd);
                    obtain.setData(bundle);
                    try {
                        zznVar.zzc.zza(obtain);
                    } catch (RemoteException e) {
                        zznVar.zza(2, e.getMessage());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zzd() {
        if (this.zza == 1) {
            zza(1, "Timed out while binding");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zze(int i) {
        zzr zzrVar = (zzr) this.zze.get(i);
        if (zzrVar != null) {
            Log.w("MessengerIpcClient", "Timing out request: " + i);
            this.zze.remove(i);
            zzrVar.zzc(new zzs(3, "Timed out waiting for response", null));
            zzf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zzf() {
        if (this.zza == 2 && this.zzd.isEmpty() && this.zze.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.zza = 3;
            ConnectionTracker.getInstance().unbindService(zzu.zza(this.zzf), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean zzg(zzr zzrVar) {
        switch (this.zza) {
            case 0:
                this.zzd.add(zzrVar);
                Preconditions.checkState(this.zza == 0);
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Starting bind to GmsCore");
                }
                this.zza = 1;
                Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                intent.setPackage("com.google.android.gms");
                try {
                    if (ConnectionTracker.getInstance().bindService(zzu.zza(this.zzf), intent, this, 1)) {
                        zzu.zze(this.zzf).schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzi
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzn.this.zzd();
                            }
                        }, 30L, TimeUnit.SECONDS);
                    } else {
                        zza(0, "Unable to bind to service");
                    }
                } catch (SecurityException e) {
                    zzb(0, "Unable to bind to service", e);
                }
                return true;
            case 1:
                this.zzd.add(zzrVar);
                return true;
            case 2:
                this.zzd.add(zzrVar);
                zzc();
                return true;
            default:
                return false;
        }
    }
}
