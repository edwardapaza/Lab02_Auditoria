package com.dexterous.flutterlocalnotifications.models.styles;
/* loaded from: classes2.dex */
public class BigTextStyleInformation extends DefaultStyleInformation {
    public String bigText;
    public String contentTitle;
    public Boolean htmlFormatBigText;
    public Boolean htmlFormatContentTitle;
    public Boolean htmlFormatSummaryText;
    public String summaryText;

    public BigTextStyleInformation(Boolean htmlFormatTitle, Boolean htmlFormatBody, String bigText, Boolean htmlFormatBigText, String contentTitle, Boolean htmlFormatContentTitle, String summaryText, Boolean htmlFormatSummaryText) {
        super(htmlFormatTitle, htmlFormatBody);
        this.bigText = bigText;
        this.htmlFormatBigText = htmlFormatBigText;
        this.contentTitle = contentTitle;
        this.htmlFormatContentTitle = htmlFormatContentTitle;
        this.summaryText = summaryText;
        this.htmlFormatSummaryText = htmlFormatSummaryText;
    }
}
