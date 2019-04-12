package main.java.parnkGenerator.model.mail;

import java.util.LinkedList;

public class Groupe {
    private Person sender;
    private final LinkedList<Person> members;

    public Groupe() {
        members = new LinkedList<Person>();
    }

    public Person getSender() {
        return sender;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }

    public void addPersons(Person e) {
        members.add(e);
    }
}
