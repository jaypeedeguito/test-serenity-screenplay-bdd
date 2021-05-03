package com.framework.scaped.models;

public class PageTitleInformation {

    private final String title;

    public PageTitleInformation(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("{title='%s'}", title);
    }
}
