package l0;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.o1;
import com.google.android.gms.common.internal.p0;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class w extends o1 {

    /* renamed from: a  reason: collision with root package name */
    private final int f5900a;

    /* JADX INFO: Access modifiers changed from: protected */
    public w(byte[] bArr) {
        com.google.android.gms.common.internal.q.a(bArr.length == 25);
        this.f5900a = Arrays.hashCode(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] a(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e5) {
            throw new AssertionError(e5);
        }
    }

    abstract byte[] b();

    public final boolean equals(Object obj) {
        t0.a zzd;
        if (obj != null && (obj instanceof p0)) {
            try {
                p0 p0Var = (p0) obj;
                if (p0Var.zzc() == this.f5900a && (zzd = p0Var.zzd()) != null) {
                    return Arrays.equals(b(), (byte[]) t0.b.b(zzd));
                }
                return false;
            } catch (RemoteException e5) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e5);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f5900a;
    }

    @Override // com.google.android.gms.common.internal.p0
    public final int zzc() {
        return this.f5900a;
    }

    @Override // com.google.android.gms.common.internal.p0
    public final t0.a zzd() {
        return t0.b.f(b());
    }
}
