package t;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f  reason: collision with root package name */
    private static final Object f7574f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static a f7575g;

    /* renamed from: a  reason: collision with root package name */
    private final Context f7576a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<BroadcastReceiver, ArrayList<c>> f7577b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, ArrayList<c>> f7578c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<b> f7579d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private final Handler f7580e;

    /* renamed from: t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class HandlerC0114a extends Handler {
        HandlerC0114a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                a.this.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final Intent f7582a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<c> f7583b;

        b(Intent intent, ArrayList<c> arrayList) {
            this.f7582a = intent;
            this.f7583b = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        final IntentFilter f7584a;

        /* renamed from: b  reason: collision with root package name */
        final BroadcastReceiver f7585b;

        /* renamed from: c  reason: collision with root package name */
        boolean f7586c;

        /* renamed from: d  reason: collision with root package name */
        boolean f7587d;

        c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f7584a = intentFilter;
            this.f7585b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f7585b);
            sb.append(" filter=");
            sb.append(this.f7584a);
            if (this.f7587d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private a(Context context) {
        this.f7576a = context;
        this.f7580e = new HandlerC0114a(context.getMainLooper());
    }

    public static a b(Context context) {
        a aVar;
        synchronized (f7574f) {
            if (f7575g == null) {
                f7575g = new a(context.getApplicationContext());
            }
            aVar = f7575g;
        }
        return aVar;
    }

    void a() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.f7577b) {
                size = this.f7579d.size();
                if (size <= 0) {
                    return;
                }
                bVarArr = new b[size];
                this.f7579d.toArray(bVarArr);
                this.f7579d.clear();
            }
            for (int i5 = 0; i5 < size; i5++) {
                b bVar = bVarArr[i5];
                int size2 = bVar.f7583b.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    c cVar = bVar.f7583b.get(i6);
                    if (!cVar.f7587d) {
                        cVar.f7585b.onReceive(this.f7576a, bVar.f7582a);
                    }
                }
            }
        }
    }

    public void c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f7577b) {
            c cVar = new c(intentFilter, broadcastReceiver);
            ArrayList<c> arrayList = this.f7577b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f7577b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(cVar);
            for (int i5 = 0; i5 < intentFilter.countActions(); i5++) {
                String action = intentFilter.getAction(i5);
                ArrayList<c> arrayList2 = this.f7578c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f7578c.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    public boolean d(Intent intent) {
        int i5;
        String str;
        ArrayList arrayList;
        ArrayList<c> arrayList2;
        String str2;
        synchronized (this.f7577b) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f7576a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z4 = (intent.getFlags() & 8) != 0;
            if (z4) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<c> arrayList3 = this.f7578c.get(intent.getAction());
            if (arrayList3 != null) {
                if (z4) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i6 = 0;
                while (i6 < arrayList3.size()) {
                    c cVar = arrayList3.get(i6);
                    if (z4) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + cVar.f7584a);
                    }
                    if (cVar.f7586c) {
                        if (z4) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        i5 = i6;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i5 = i6;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = resolveTypeIfNeeded;
                        int match = cVar.f7584a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z4) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(cVar);
                            cVar.f7586c = true;
                            i6 = i5 + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        } else if (z4) {
                            Log.v("LocalBroadcastManager", "  Filter did not match: " + (match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                        }
                    }
                    arrayList4 = arrayList;
                    i6 = i5 + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    resolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i7 = 0; i7 < arrayList5.size(); i7++) {
                        ((c) arrayList5.get(i7)).f7586c = false;
                    }
                    this.f7579d.add(new b(intent, arrayList5));
                    if (!this.f7580e.hasMessages(1)) {
                        this.f7580e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void e(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f7577b) {
            ArrayList<c> remove = this.f7577b.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                c cVar = remove.get(size);
                cVar.f7587d = true;
                for (int i5 = 0; i5 < cVar.f7584a.countActions(); i5++) {
                    String action = cVar.f7584a.getAction(i5);
                    ArrayList<c> arrayList = this.f7578c.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            c cVar2 = arrayList.get(size2);
                            if (cVar2.f7585b == broadcastReceiver) {
                                cVar2.f7587d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.f7578c.remove(action);
                        }
                    }
                }
            }
        }
    }
}
