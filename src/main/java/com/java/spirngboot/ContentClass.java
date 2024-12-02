package com.java.spirngboot;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContentClass {
    private Date date;
    private String user;
    private String content;

    public ContentClass(String user, String content) {
        this.date = new Date();
        this.user = user;
        this.content = content;
    }

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(date);
    }

    public String getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }
}
