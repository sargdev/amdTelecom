package com.sarg.assessment4.model;

public class Sms {

    private String body;
    private String to;
    private String from;

    public Sms(String body, String recipientPhone, String senderName) {
        this.body = body;
        this.to = recipientPhone;
        this.from = senderName;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return "{" +
                "\"body\":\"" + body + '\"' +
                ", \"to\":\"" + to + '\"' +
                ", \"from\":\"" + from + '\"' +
                '}';
    }
}
