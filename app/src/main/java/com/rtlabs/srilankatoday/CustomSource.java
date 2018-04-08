package com.rtlabs.srilankatoday;

/**
 * Created by thari on 3/16/2018.
 */

public class CustomSource {

    public String getSourceName() {
        return sourceName;
    }

    private String sourceName;

    private String rsslink;

    public String getRsslink() {
        return rsslink;
    }

    public CustomSource(String sourceName, String rsslink) {
        this.sourceName = sourceName;
        this.rsslink = rsslink;
    }
}
