package com.dexterous.flutterlocalnotifications.models.styles;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class InboxStyleInformation extends DefaultStyleInformation {
    public String contentTitle;
    public Boolean htmlFormatContentTitle;
    public Boolean htmlFormatLines;
    public Boolean htmlFormatSummaryText;
    public ArrayList<String> lines;
    public String summaryText;

    public InboxStyleInformation(Boolean htmlFormatTitle, Boolean htmlFormatBody, String contentTitle, Boolean htmlFormatContentTitle, String summaryText, Boolean htmlFormatSummaryText, ArrayList<String> lines, Boolean htmlFormatLines) {
        super(htmlFormatTitle, htmlFormatBody);
        this.contentTitle = contentTitle;
        this.htmlFormatContentTitle = htmlFormatContentTitle;
        this.summaryText = summaryText;
        this.htmlFormatSummaryText = htmlFormatSummaryText;
        this.lines = lines;
        this.htmlFormatLines = htmlFormatLines;
    }
}
