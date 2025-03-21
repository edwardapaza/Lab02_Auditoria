package j1;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public final class r {
    public static Status a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return new Status(17499);
        }
        String[] split = str.split(":", 2);
        split[0] = split[0].trim();
        if (split.length > 1 && (str2 = split[1]) != null) {
            split[1] = str2.trim();
        }
        List asList = Arrays.asList(split);
        return asList.size() > 1 ? b((String) asList.get(0), (String) asList.get(1)) : b((String) asList.get(0), null);
    }

    private static Status b(String str, String str2) {
        int i5;
        str.hashCode();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -2130504259:
                if (str.equals("USER_CANCELLED")) {
                    c5 = 0;
                    break;
                }
                break;
            case -2065866930:
                if (str.equals("INVALID_RECIPIENT_EMAIL")) {
                    c5 = 1;
                    break;
                }
                break;
            case -2014808264:
                if (str.equals("WEB_CONTEXT_ALREADY_PRESENTED")) {
                    c5 = 2;
                    break;
                }
                break;
            case -2005236790:
                if (str.equals("INTERNAL_SUCCESS_SIGN_OUT")) {
                    c5 = 3;
                    break;
                }
                break;
            case -2001169389:
                if (str.equals("INVALID_IDP_RESPONSE")) {
                    c5 = 4;
                    break;
                }
                break;
            case -1944433728:
                if (str.equals("DYNAMIC_LINK_NOT_ACTIVATED")) {
                    c5 = 5;
                    break;
                }
                break;
            case -1800638118:
                if (str.equals("QUOTA_EXCEEDED")) {
                    c5 = 6;
                    break;
                }
                break;
            case -1774756919:
                if (str.equals("WEB_NETWORK_REQUEST_FAILED")) {
                    c5 = 7;
                    break;
                }
                break;
            case -1699246888:
                if (str.equals("INVALID_RECAPTCHA_VERSION")) {
                    c5 = '\b';
                    break;
                }
                break;
            case -1603818979:
                if (str.equals("RECAPTCHA_NOT_ENABLED")) {
                    c5 = '\t';
                    break;
                }
                break;
            case -1587614300:
                if (str.equals("EXPIRED_OOB_CODE")) {
                    c5 = '\n';
                    break;
                }
                break;
            case -1584641425:
                if (str.equals("UNAUTHORIZED_DOMAIN")) {
                    c5 = 11;
                    break;
                }
                break;
            case -1583894766:
                if (str.equals("INVALID_OOB_CODE")) {
                    c5 = '\f';
                    break;
                }
                break;
            case -1458751677:
                if (str.equals("MISSING_EMAIL")) {
                    c5 = '\r';
                    break;
                }
                break;
            case -1421414571:
                if (str.equals("INVALID_CODE")) {
                    c5 = 14;
                    break;
                }
                break;
            case -1345867105:
                if (str.equals("TOKEN_EXPIRED")) {
                    c5 = 15;
                    break;
                }
                break;
            case -1340100504:
                if (str.equals("INVALID_TENANT_ID")) {
                    c5 = 16;
                    break;
                }
                break;
            case -1242922234:
                if (str.equals("ALTERNATE_CLIENT_IDENTIFIER_REQUIRED")) {
                    c5 = 17;
                    break;
                }
                break;
            case -1232010689:
                if (str.equals("INVALID_SESSION_INFO")) {
                    c5 = 18;
                    break;
                }
                break;
            case -1202691903:
                if (str.equals("SECOND_FACTOR_EXISTS")) {
                    c5 = 19;
                    break;
                }
                break;
            case -1112393964:
                if (str.equals("INVALID_EMAIL")) {
                    c5 = 20;
                    break;
                }
                break;
            case -1063710844:
                if (str.equals("ADMIN_ONLY_OPERATION")) {
                    c5 = 21;
                    break;
                }
                break;
            case -974503964:
                if (str.equals("MISSING_OR_INVALID_NONCE")) {
                    c5 = 22;
                    break;
                }
                break;
            case -863830559:
                if (str.equals("INVALID_CERT_HASH")) {
                    c5 = 23;
                    break;
                }
                break;
            case -828507413:
                if (str.equals("NO_SUCH_PROVIDER")) {
                    c5 = 24;
                    break;
                }
                break;
            case -749743758:
                if (str.equals("MFA_ENROLLMENT_NOT_FOUND")) {
                    c5 = 25;
                    break;
                }
                break;
            case -736207500:
                if (str.equals("MISSING_PASSWORD")) {
                    c5 = 26;
                    break;
                }
                break;
            case -646022241:
                if (str.equals("CREDENTIAL_TOO_OLD_LOGIN_AGAIN")) {
                    c5 = 27;
                    break;
                }
                break;
            case -595928767:
                if (str.equals("TIMEOUT")) {
                    c5 = 28;
                    break;
                }
                break;
            case -505579581:
                if (str.equals("INVALID_REQ_TYPE")) {
                    c5 = 29;
                    break;
                }
                break;
            case -406804866:
                if (str.equals("INVALID_LOGIN_CREDENTIALS")) {
                    c5 = 30;
                    break;
                }
                break;
            case -380728810:
                if (str.equals("INVALID_RECAPTCHA_ACTION")) {
                    c5 = 31;
                    break;
                }
                break;
            case -333672188:
                if (str.equals("OPERATION_NOT_ALLOWED")) {
                    c5 = ' ';
                    break;
                }
                break;
            case -294485423:
                if (str.equals("WEB_INTERNAL_ERROR")) {
                    c5 = '!';
                    break;
                }
                break;
            case -217128228:
                if (str.equals("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                    c5 = '\"';
                    break;
                }
                break;
            case -122667194:
                if (str.equals("MISSING_MFA_ENROLLMENT_ID")) {
                    c5 = '#';
                    break;
                }
                break;
            case -75433118:
                if (str.equals("USER_NOT_FOUND")) {
                    c5 = '$';
                    break;
                }
                break;
            case -52772551:
                if (str.equals("CAPTCHA_CHECK_FAILED")) {
                    c5 = '%';
                    break;
                }
                break;
            case -40686718:
                if (str.equals("WEAK_PASSWORD")) {
                    c5 = '&';
                    break;
                }
                break;
            case 15352275:
                if (str.equals("EMAIL_NOT_FOUND")) {
                    c5 = '\'';
                    break;
                }
                break;
            case 210308040:
                if (str.equals("UNSUPPORTED_FIRST_FACTOR")) {
                    c5 = '(';
                    break;
                }
                break;
            case 269327773:
                if (str.equals("INVALID_SENDER")) {
                    c5 = ')';
                    break;
                }
                break;
            case 278802867:
                if (str.equals("MISSING_PHONE_NUMBER")) {
                    c5 = '*';
                    break;
                }
                break;
            case 408411681:
                if (str.equals("INVALID_DYNAMIC_LINK_DOMAIN")) {
                    c5 = '+';
                    break;
                }
                break;
            case 423563023:
                if (str.equals("MISSING_MFA_PENDING_CREDENTIAL")) {
                    c5 = ',';
                    break;
                }
                break;
            case 429251986:
                if (str.equals("UNSUPPORTED_PASSTHROUGH_OPERATION")) {
                    c5 = '-';
                    break;
                }
                break;
            case 483847807:
                if (str.equals("EMAIL_EXISTS")) {
                    c5 = '.';
                    break;
                }
                break;
            case 491979549:
                if (str.equals("INVALID_ID_TOKEN")) {
                    c5 = '/';
                    break;
                }
                break;
            case 492072102:
                if (str.equals("WEB_STORAGE_UNSUPPORTED")) {
                    c5 = '0';
                    break;
                }
                break;
            case 492515765:
                if (str.equals("MISSING_CLIENT_TYPE")) {
                    c5 = '1';
                    break;
                }
                break;
            case 530628231:
                if (str.equals("MISSING_RECAPTCHA_VERSION")) {
                    c5 = '2';
                    break;
                }
                break;
            case 542728406:
                if (str.equals("PASSWORD_LOGIN_DISABLED")) {
                    c5 = '3';
                    break;
                }
                break;
            case 582457886:
                if (str.equals("UNVERIFIED_EMAIL")) {
                    c5 = '4';
                    break;
                }
                break;
            case 605031096:
                if (str.equals("REJECTED_CREDENTIAL")) {
                    c5 = '5';
                    break;
                }
                break;
            case 745638750:
                if (str.equals("INVALID_MFA_PENDING_CREDENTIAL")) {
                    c5 = '6';
                    break;
                }
                break;
            case 786916712:
                if (str.equals("INVALID_VERIFICATION_PROOF")) {
                    c5 = '7';
                    break;
                }
                break;
            case 799258561:
                if (str.equals("INVALID_PROVIDER_ID")) {
                    c5 = '8';
                    break;
                }
                break;
            case 819646646:
                if (str.equals("CREDENTIAL_MISMATCH")) {
                    c5 = '9';
                    break;
                }
                break;
            case 844240628:
                if (str.equals("WEB_CONTEXT_CANCELED")) {
                    c5 = ':';
                    break;
                }
                break;
            case 886186878:
                if (str.equals("REQUIRES_SECOND_FACTOR_AUTH")) {
                    c5 = ';';
                    break;
                }
                break;
            case 895302372:
                if (str.equals("MISSING_CLIENT_IDENTIFIER")) {
                    c5 = '<';
                    break;
                }
                break;
            case 922685102:
                if (str.equals("INVALID_MESSAGE_PAYLOAD")) {
                    c5 = '=';
                    break;
                }
                break;
            case 989000548:
                if (str.equals("RESET_PASSWORD_EXCEED_LIMIT")) {
                    c5 = '>';
                    break;
                }
                break;
            case 1034932393:
                if (str.equals("INVALID_PENDING_TOKEN")) {
                    c5 = '?';
                    break;
                }
                break;
            case 1072360691:
                if (str.equals("INVALID_CUSTOM_TOKEN")) {
                    c5 = '@';
                    break;
                }
                break;
            case 1094975491:
                if (str.equals("INVALID_PASSWORD")) {
                    c5 = 'A';
                    break;
                }
                break;
            case 1107081238:
                if (str.equals("<<Network Error>>")) {
                    c5 = 'B';
                    break;
                }
                break;
            case 1113992697:
                if (str.equals("INVALID_RECAPTCHA_TOKEN")) {
                    c5 = 'C';
                    break;
                }
                break;
            case 1141576252:
                if (str.equals("SESSION_EXPIRED")) {
                    c5 = 'D';
                    break;
                }
                break;
            case 1199811910:
                if (str.equals("MISSING_CODE")) {
                    c5 = 'E';
                    break;
                }
                break;
            case 1226505451:
                if (str.equals("FEDERATED_USER_ID_ALREADY_LINKED")) {
                    c5 = 'F';
                    break;
                }
                break;
            case 1308491624:
                if (str.equals("MISSING_RECAPTCHA_TOKEN")) {
                    c5 = 'G';
                    break;
                }
                break;
            case 1388786705:
                if (str.equals("INVALID_IDENTIFIER")) {
                    c5 = 'H';
                    break;
                }
                break;
            case 1433767024:
                if (str.equals("USER_DISABLED")) {
                    c5 = 'I';
                    break;
                }
                break;
            case 1442968770:
                if (str.equals("INVALID_PHONE_NUMBER")) {
                    c5 = 'J';
                    break;
                }
                break;
            case 1494923453:
                if (str.equals("INVALID_APP_CREDENTIAL")) {
                    c5 = 'K';
                    break;
                }
                break;
            case 1497901284:
                if (str.equals("TOO_MANY_ATTEMPTS_TRY_LATER")) {
                    c5 = 'L';
                    break;
                }
                break;
            case 1803454477:
                if (str.equals("MISSING_CONTINUE_URI")) {
                    c5 = 'M';
                    break;
                }
                break;
            case 1898790704:
                if (str.equals("MISSING_SESSION_INFO")) {
                    c5 = 'N';
                    break;
                }
                break;
            case 2063209097:
                if (str.equals("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                    c5 = 'O';
                    break;
                }
                break;
            case 2082564316:
                if (str.equals("UNSUPPORTED_TENANT_OPERATION")) {
                    c5 = 'P';
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                i5 = 18001;
                break;
            case 1:
                i5 = 17033;
                break;
            case 2:
                i5 = 17057;
                break;
            case 3:
                i5 = 17091;
                break;
            case 4:
            case 30:
            case '?':
                i5 = 17004;
                break;
            case 5:
                i5 = 17068;
                break;
            case 6:
                i5 = 17052;
                break;
            case 7:
                i5 = 17061;
                break;
            case '\b':
                i5 = 17206;
                break;
            case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                i5 = 17200;
                break;
            case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                i5 = 17029;
                break;
            case 11:
                i5 = 17038;
                break;
            case i2.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                i5 = 17030;
                break;
            case '\r':
                i5 = 17034;
                break;
            case 14:
                i5 = 17044;
                break;
            case 15:
                i5 = 17021;
                break;
            case 16:
                i5 = 17079;
                break;
            case i2.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                i5 = 18002;
                break;
            case i2.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                i5 = 17046;
                break;
            case 19:
                i5 = 17087;
                break;
            case 20:
            case 'H':
                i5 = 17008;
                break;
            case 21:
                i5 = 17085;
                break;
            case 22:
                i5 = 17094;
                break;
            case 23:
                i5 = 17064;
                break;
            case 24:
                i5 = 17016;
                break;
            case 25:
                i5 = 17084;
                break;
            case 26:
                i5 = 17035;
                break;
            case 27:
                i5 = 17014;
                break;
            case 28:
            case 'B':
                i5 = 17020;
                break;
            case 29:
                i5 = 17207;
                break;
            case 31:
                i5 = 17203;
                break;
            case ' ':
            case '3':
                i5 = 17006;
                break;
            case '!':
                i5 = 17062;
                break;
            case '\"':
                i5 = 17088;
                break;
            case '#':
                i5 = 17082;
                break;
            case '$':
            case '\'':
                i5 = 17011;
                break;
            case '%':
                i5 = 17056;
                break;
            case '&':
                i5 = 17026;
                break;
            case '(':
                i5 = 17089;
                break;
            case ')':
                i5 = 17032;
                break;
            case '*':
                i5 = 17041;
                break;
            case '+':
                i5 = 17074;
                break;
            case ',':
                i5 = 17081;
                break;
            case '-':
                i5 = 17095;
                break;
            case '.':
                i5 = 17007;
                break;
            case '/':
                i5 = 17017;
                break;
            case '0':
                i5 = 17065;
                break;
            case '1':
                i5 = 17204;
                break;
            case '2':
                i5 = 17205;
                break;
            case '4':
                i5 = 17086;
                break;
            case '5':
                i5 = 17075;
                break;
            case '6':
                i5 = 17083;
                break;
            case '7':
                i5 = 17049;
                break;
            case '8':
                i5 = 17071;
                break;
            case '9':
                i5 = 17002;
                break;
            case ':':
                i5 = 17058;
                break;
            case ';':
                i5 = 17078;
                break;
            case '<':
                i5 = 17093;
                break;
            case '=':
                i5 = 17031;
                break;
            case '>':
            case 'L':
                i5 = 17010;
                break;
            case '@':
                i5 = 17000;
                break;
            case 'A':
                i5 = 17009;
                break;
            case 'C':
                i5 = 17202;
                break;
            case 'D':
                i5 = 17051;
                break;
            case 'E':
                i5 = 17043;
                break;
            case 'F':
                i5 = 17025;
                break;
            case 'G':
                i5 = 17201;
                break;
            case 'I':
                i5 = 17005;
                break;
            case 'J':
                i5 = 17042;
                break;
            case 'K':
                i5 = 17028;
                break;
            case 'M':
                i5 = 17040;
                break;
            case 'N':
                i5 = 17045;
                break;
            case 'O':
                i5 = 17090;
                break;
            case 'P':
                i5 = 17073;
                break;
            default:
                i5 = 17499;
                break;
        }
        if (i5 == 17499) {
            if (str2 != null) {
                return new Status(i5, str + ":" + str2);
            }
            return new Status(i5, str);
        }
        return new Status(i5, str2);
    }
}
