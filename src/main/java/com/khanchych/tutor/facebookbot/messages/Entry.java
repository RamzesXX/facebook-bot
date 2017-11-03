package com.khanchych.tutor.facebookbot.messages;

import java.util.Date;

public class Entry {

    private Long id;
    private Date time;
    private Messaging[] messaging;

    public Entry() {
    }

    public Long getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public Messaging[] getMessaging() {
        return messaging;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setMessaging(Messaging[] messaging) {
        this.messaging = messaging;
    }
}
