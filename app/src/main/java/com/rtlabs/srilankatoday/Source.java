package com.rtlabs.srilankatoday;

/**
 * Created by thari on 3/5/2018.
 */

public class Source {

    public String getSourceName() {
        return sourceName;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    private String sourceName;

    private int imageResourceId;

    private String rsslink;

    public String getRsslink() {
        return rsslink;
    }

    public Source(String sourceName, int imageResourceId, String rsslink) {
        this.sourceName = sourceName;
        this.imageResourceId = imageResourceId;
        this.rsslink = rsslink;
    }
}
