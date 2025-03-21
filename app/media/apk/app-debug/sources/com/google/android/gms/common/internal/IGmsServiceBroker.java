package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.core.view.MotionEventCompat;
/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public interface IGmsServiceBroker extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IGmsServiceBroker {
        public Stub() {
            attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            IGmsCallbacks zzabVar;
            if (i > 16777215) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzabVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
                zzabVar = queryLocalInterface instanceof IGmsCallbacks ? (IGmsCallbacks) queryLocalInterface : new zzab(readStrongBinder);
            }
            if (i != 46) {
                if (i == 47) {
                    if (parcel.readInt() != 0) {
                        zzak.CREATOR.createFromParcel(parcel);
                    }
                    throw new UnsupportedOperationException();
                }
                parcel.readInt();
                if (i != 4) {
                    parcel.readString();
                    switch (i) {
                        case 1:
                            parcel.readString();
                            parcel.createStringArray();
                            parcel.readString();
                            if (parcel.readInt() != 0) {
                                Bundle bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                                break;
                            }
                            break;
                        case 2:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 23:
                        case 25:
                        case 27:
                        case 37:
                        case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                        case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                        case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                            if (parcel.readInt() != 0) {
                                Bundle bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                                break;
                            }
                            break;
                        case 9:
                            parcel.readString();
                            parcel.createStringArray();
                            parcel.readString();
                            parcel.readStrongBinder();
                            parcel.readString();
                            if (parcel.readInt() != 0) {
                                Bundle bundle3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                                break;
                            }
                            break;
                        case 10:
                            parcel.readString();
                            parcel.createStringArray();
                            break;
                        case 19:
                            parcel.readStrongBinder();
                            if (parcel.readInt() != 0) {
                                Bundle bundle4 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                                break;
                            }
                            break;
                        case 20:
                        case 30:
                            parcel.createStringArray();
                            parcel.readString();
                            if (parcel.readInt() != 0) {
                                Bundle bundle5 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                                break;
                            }
                            break;
                        case MotionEventCompat.AXIS_GENERIC_3 /* 34 */:
                            parcel.readString();
                            break;
                    }
                }
                throw new UnsupportedOperationException();
            }
            getService(zzabVar, parcel.readInt() != 0 ? GetServiceRequest.CREATOR.createFromParcel(parcel) : null);
            Preconditions.checkNotNull(parcel2);
            parcel2.writeNoException();
            return true;
        }
    }

    void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest) throws RemoteException;
}
