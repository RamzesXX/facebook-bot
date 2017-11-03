package com.khanchych.tutor.facebookbot.messages;

public class Event {

    private String object;
    private Entry[] entry;

    public String getObject() {
        return object;
    }

    public Entry[] getEntry() {
        return entry;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public void setEntry(Entry[] entry) {
        this.entry = entry;
    }
}