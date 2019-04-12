package main.java.parnkGenerator.model.mail;

public class Message {
    private String subject = "";
    private String data = "";

    public Message( String object, String data) {
        this.subject = object;
        this.data = data;
    }

    public Message() {

    }

    public String getData() {
        return data;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String object) {
        this.subject = object;
    }

    public void setData(String data) {
        this.data = data;
    }
}
