package com.example.alc40;

public class ScreenItem {
    String Title, Desc;
    int ScreenTag;

    public ScreenItem(String title, String desc, int screenTag) {
        Title = title;
        Desc = desc;
        ScreenTag = screenTag;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public int getScreenTag() {
        return ScreenTag;
    }

    public void setScreenTag(int screenTag) {
        ScreenTag = screenTag;
    }
}
