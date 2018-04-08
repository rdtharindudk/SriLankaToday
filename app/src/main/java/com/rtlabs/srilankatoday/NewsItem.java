package com.rtlabs.srilankatoday;

/**
 * Created by thari on 3/6/2018.
 */

public class NewsItem {

    private String pubDate;
    private String headline;
    private String description;
    private String link;

    public String getPubDate() {
        return pubDate;
    }

    public NewsItem(String headline, String description, String link, String pubDate) {
        this.headline = headline;
        this.description = description;
        this.link = link;
        this.pubDate = pubDate;
    }

    public String getHeadline() {
        return headline;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }
}
