package com.google.android.gms.internal.p001firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.KeyAgreement;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwn  reason: invalid package */
/* loaded from: classes.dex */
public final class zzwn {
    public static int zza(EllipticCurve ellipticCurve) {
        return (zzmd.zza(ellipticCurve).subtract(BigInteger.ONE).bitLength() + 7) / 8;
    }

    private static BigInteger zza(BigInteger bigInteger, boolean z4, EllipticCurve ellipticCurve) {
        BigInteger zza = zzmd.zza(ellipticCurve);
        BigInteger mod = bigInteger.multiply(bigInteger).add(ellipticCurve.getA()).multiply(bigInteger).add(ellipticCurve.getB()).mod(zza);
        if (zza.signum() == 1) {
            BigInteger mod2 = mod.mod(zza);
            BigInteger bigInteger2 = null;
            BigInteger bigInteger3 = BigInteger.ZERO;
            if (!mod2.equals(bigInteger3)) {
                if (zza.testBit(0) && zza.testBit(1)) {
                    bigInteger2 = mod2.modPow(zza.add(BigInteger.ONE).shiftRight(2), zza);
                } else if (zza.testBit(0) && !zza.testBit(1)) {
                    bigInteger2 = BigInteger.ONE;
                    BigInteger shiftRight = zza.subtract(bigInteger2).shiftRight(1);
                    int i5 = 0;
                    while (true) {
                        BigInteger mod3 = bigInteger2.multiply(bigInteger2).subtract(mod2).mod(zza);
                        if (mod3.equals(BigInteger.ZERO)) {
                            break;
                        }
                        BigInteger modPow = mod3.modPow(shiftRight, zza);
                        BigInteger bigInteger4 = BigInteger.ONE;
                        if (modPow.add(bigInteger4).equals(zza)) {
                            BigInteger shiftRight2 = zza.add(bigInteger4).shiftRight(1);
                            BigInteger bigInteger5 = bigInteger2;
                            for (int bitLength = shiftRight2.bitLength() - 2; bitLength >= 0; bitLength--) {
                                BigInteger multiply = bigInteger5.multiply(bigInteger4);
                                bigInteger5 = bigInteger5.multiply(bigInteger5).add(bigInteger4.multiply(bigInteger4).mod(zza).multiply(mod3)).mod(zza);
                                BigInteger mod4 = multiply.add(multiply).mod(zza);
                                if (shiftRight2.testBit(bitLength)) {
                                    BigInteger mod5 = bigInteger5.multiply(bigInteger2).add(mod4.multiply(mod3)).mod(zza);
                                    bigInteger4 = bigInteger2.multiply(mod4).add(bigInteger5).mod(zza);
                                    bigInteger5 = mod5;
                                } else {
                                    bigInteger4 = mod4;
                                }
                            }
                            bigInteger2 = bigInteger5;
                        } else if (!modPow.equals(bigInteger4)) {
                            throw new InvalidAlgorithmParameterException("p is not prime");
                        } else {
                            bigInteger2 = bigInteger2.add(bigInteger4);
                            i5++;
                            if (i5 == 128 && !zza.isProbablePrime(80)) {
                                throw new InvalidAlgorithmParameterException("p is not prime");
                            }
                        }
                    }
                    bigInteger3 = bigInteger2;
                }
                if (bigInteger2 != null && bigInteger2.multiply(bigInteger2).mod(zza).compareTo(mod2) != 0) {
                    throw new GeneralSecurityException("Could not find a modular square root");
                }
                bigInteger3 = bigInteger2;
            }
            return z4 != bigInteger3.testBit(0) ? zza.subtract(bigInteger3).mod(zza) : bigInteger3;
        }
        throw new InvalidAlgorithmParameterException("p must be positive");
    }

    public static ECPrivateKey zza(zzwq zzwqVar, byte[] bArr) {
        return (ECPrivateKey) zzwr.zze.zza("EC").generatePrivate(new ECPrivateKeySpec(zzmb.zza(bArr), zza(zzwqVar)));
    }

    public static ECPublicKey zza(zzwq zzwqVar, zzwp zzwpVar, byte[] bArr) {
        return zza(zza(zzwqVar), zzwpVar, bArr);
    }

    public static ECPublicKey zza(ECParameterSpec eCParameterSpec, zzwp zzwpVar, byte[] bArr) {
        return (ECPublicKey) zzwr.zze.zza("EC").generatePublic(new ECPublicKeySpec(zza(eCParameterSpec.getCurve(), zzwpVar, bArr), eCParameterSpec));
    }

    public static ECParameterSpec zza(zzwq zzwqVar) {
        int ordinal = zzwqVar.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal == 2) {
                    return zzmd.zzc;
                }
                String valueOf = String.valueOf(zzwqVar);
                throw new NoSuchAlgorithmException("curve not implemented:" + valueOf);
            }
            return zzmd.zzb;
        }
        return zzmd.zza;
    }

    public static ECPoint zza(EllipticCurve ellipticCurve, zzwp zzwpVar, byte[] bArr) {
        ECPoint eCPoint;
        int zza = zza(ellipticCurve);
        int ordinal = zzwpVar.ordinal();
        boolean z4 = false;
        if (ordinal != 0) {
            if (ordinal == 1) {
                BigInteger zza2 = zzmd.zza(ellipticCurve);
                if (bArr.length == zza + 1) {
                    byte b5 = bArr[0];
                    if (b5 != 2) {
                        if (b5 != 3) {
                            throw new GeneralSecurityException("invalid format");
                        }
                        z4 = true;
                    }
                    BigInteger bigInteger = new BigInteger(1, Arrays.copyOfRange(bArr, 1, bArr.length));
                    if (bigInteger.signum() == -1 || bigInteger.compareTo(zza2) >= 0) {
                        throw new GeneralSecurityException("x is out of range");
                    }
                    return new ECPoint(bigInteger, zza(bigInteger, z4, ellipticCurve));
                }
                throw new GeneralSecurityException("compressed point has wrong length");
            } else if (ordinal != 2) {
                String valueOf = String.valueOf(zzwpVar);
                throw new GeneralSecurityException("invalid format:" + valueOf);
            } else if (bArr.length != zza * 2) {
                throw new GeneralSecurityException("invalid point size");
            } else {
                eCPoint = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 0, zza)), new BigInteger(1, Arrays.copyOfRange(bArr, zza, bArr.length)));
            }
        } else if (bArr.length != (zza * 2) + 1) {
            throw new GeneralSecurityException("invalid point size");
        } else {
            if (bArr[0] != 4) {
                throw new GeneralSecurityException("invalid point format");
            }
            int i5 = zza + 1;
            eCPoint = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 1, i5)), new BigInteger(1, Arrays.copyOfRange(bArr, i5, bArr.length)));
        }
        zzmd.zza(eCPoint, ellipticCurve);
        return eCPoint;
    }

    public static void zza(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) {
        zzb(eCPublicKey, eCPrivateKey);
        zzmd.zza(eCPublicKey.getW(), eCPrivateKey.getParams().getCurve());
    }

    public static byte[] zza(ECPrivateKey eCPrivateKey, ECPublicKey eCPublicKey) {
        zzb(eCPublicKey, eCPrivateKey);
        return zza(eCPrivateKey, eCPublicKey.getW());
    }

    private static byte[] zza(ECPrivateKey eCPrivateKey, ECPoint eCPoint) {
        zzmd.zza(eCPoint, eCPrivateKey.getParams().getCurve());
        PublicKey generatePublic = zzwr.zze.zza("EC").generatePublic(new ECPublicKeySpec(eCPoint, eCPrivateKey.getParams()));
        KeyAgreement zza = zzwr.zzc.zza("ECDH");
        zza.init(eCPrivateKey);
        try {
            zza.doPhase(generatePublic, true);
            byte[] generateSecret = zza.generateSecret();
            EllipticCurve curve = eCPrivateKey.getParams().getCurve();
            BigInteger bigInteger = new BigInteger(1, generateSecret);
            if (bigInteger.signum() == -1 || bigInteger.compareTo(zzmd.zza(curve)) >= 0) {
                throw new GeneralSecurityException("shared secret is out of range");
            }
            zza(bigInteger, true, curve);
            return generateSecret;
        } catch (IllegalStateException e5) {
            throw new GeneralSecurityException(e5);
        }
    }

    private static void zzb(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) {
        try {
            if (zzmd.zza(eCPublicKey.getParams(), eCPrivateKey.getParams())) {
                return;
            }
            throw new GeneralSecurityException("invalid public key spec");
        } catch (IllegalArgumentException | NullPointerException e5) {
            throw new GeneralSecurityException(e5);
        }
    }
}
