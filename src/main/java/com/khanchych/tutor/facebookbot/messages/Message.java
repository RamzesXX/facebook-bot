package com.khanchych.tutor.facebookbot.messages;

public class Message {

    private String mid;
    private Long seq;
    private String text;

    public Message() {
    }

    public String getMid() {
        return mid;
    }

    public Long getSeq() {
        return seq;
    }

    public String getText() {
        return text;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public void setText(String text) {
        this.text = text;
    }
}