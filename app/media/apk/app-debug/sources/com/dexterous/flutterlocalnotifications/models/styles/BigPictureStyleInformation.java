package com.dexterous.flutterlocalnotifications.models.styles;

import com.dexterous.flutterlocalnotifications.models.BitmapSource;
/* loaded from: classes2.dex */
public class BigPictureStyleInformation extends DefaultStyleInformation {
    public Object bigPicture;
    public BitmapSource bigPictureBitmapSource;
    public String contentTitle;
    public Boolean hideExpandedLargeIcon;
    public Boolean htmlFormatContentTitle;
    public Boolean htmlFormatSummaryText;
    public Object largeIcon;
    public BitmapSource largeIconBitmapSource;
    public String summaryText;

    public BigPictureStyleInformation(Boolean htmlFormatTitle, Boolean htmlFormatBody, String contentTitle, Boolean htmlFormatContentTitle, String summaryText, Boolean htmlFormatSummaryText, Object largeIcon, BitmapSource largeIconBitmapSource, Object bigPicture, BitmapSource bigPictureBitmapSource, Boolean hideExpandedLargeIcon) {
        super(htmlFormatTitle, htmlFormatBody);
        this.contentTitle = contentTitle;
        this.htmlFormatContentTitle = htmlFormatContentTitle;
        this.summaryText = summaryText;
        this.htmlFormatSummaryText = htmlFormatSummaryText;
        this.largeIcon = largeIcon;
        this.largeIconBitmapSource = largeIconBitmapSource;
        this.bigPicture = bigPicture;
        this.bigPictureBitmapSource = bigPictureBitmapSource;
        this.hideExpandedLargeIcon = hideExpandedLargeIcon;
    }
}
