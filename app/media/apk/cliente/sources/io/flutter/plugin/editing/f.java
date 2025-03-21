package io.flutter.plugin.editing;

import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import android.view.textservice.TextServicesManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import y2.q;
import z2.j;
/* loaded from: classes.dex */
public class f implements q.b, SpellCheckerSession.SpellCheckerSessionListener {

    /* renamed from: a  reason: collision with root package name */
    private final q f3955a;

    /* renamed from: b  reason: collision with root package name */
    private final TextServicesManager f3956b;

    /* renamed from: c  reason: collision with root package name */
    private SpellCheckerSession f3957c;

    /* renamed from: d  reason: collision with root package name */
    j.d f3958d;

    public f(TextServicesManager textServicesManager, q qVar) {
        this.f3956b = textServicesManager;
        this.f3955a = qVar;
        qVar.b(this);
    }

    @Override // y2.q.b
    public void a(String str, String str2, j.d dVar) {
        if (this.f3958d != null) {
            dVar.b("error", "Previous spell check request still pending.", null);
            return;
        }
        this.f3958d = dVar;
        c(str, str2);
    }

    public void b() {
        this.f3955a.b(null);
        SpellCheckerSession spellCheckerSession = this.f3957c;
        if (spellCheckerSession != null) {
            spellCheckerSession.close();
        }
    }

    public void c(String str, String str2) {
        Locale b5 = a3.b.b(str);
        if (this.f3957c == null) {
            this.f3957c = this.f3956b.newSpellCheckerSession(null, b5, this, true);
        }
        this.f3957c.getSentenceSuggestions(new TextInfo[]{new TextInfo(str2)}, 5);
    }

    @Override // android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener
    public void onGetSentenceSuggestions(SentenceSuggestionsInfo[] sentenceSuggestionsInfoArr) {
        ArrayList arrayList;
        j.d dVar;
        if (sentenceSuggestionsInfoArr.length == 0) {
            dVar = this.f3958d;
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList();
            SentenceSuggestionsInfo sentenceSuggestionsInfo = sentenceSuggestionsInfoArr[0];
            if (sentenceSuggestionsInfo == null) {
                dVar = this.f3958d;
                arrayList = new ArrayList();
            } else {
                for (int i5 = 0; i5 < sentenceSuggestionsInfo.getSuggestionsCount(); i5++) {
                    SuggestionsInfo suggestionsInfoAt = sentenceSuggestionsInfo.getSuggestionsInfoAt(i5);
                    int suggestionsCount = suggestionsInfoAt.getSuggestionsCount();
                    if (suggestionsCount > 0) {
                        HashMap hashMap = new HashMap();
                        int offsetAt = sentenceSuggestionsInfo.getOffsetAt(i5);
                        int lengthAt = sentenceSuggestionsInfo.getLengthAt(i5) + offsetAt;
                        hashMap.put("startIndex", Integer.valueOf(offsetAt));
                        hashMap.put("endIndex", Integer.valueOf(lengthAt));
                        ArrayList arrayList2 = new ArrayList();
                        boolean z4 = false;
                        for (int i6 = 0; i6 < suggestionsCount; i6++) {
                            String suggestionAt = suggestionsInfoAt.getSuggestionAt(i6);
                            if (!suggestionAt.equals("")) {
                                arrayList2.add(suggestionAt);
                                z4 = true;
                            }
                        }
                        if (z4) {
                            hashMap.put("suggestions", arrayList2);
                            arrayList.add(hashMap);
                        }
                    }
                }
                dVar = this.f3958d;
            }
        }
        dVar.a(arrayList);
        this.f3958d = null;
    }

    @Override // android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener
    public void onGetSuggestions(SuggestionsInfo[] suggestionsInfoArr) {
    }
}
