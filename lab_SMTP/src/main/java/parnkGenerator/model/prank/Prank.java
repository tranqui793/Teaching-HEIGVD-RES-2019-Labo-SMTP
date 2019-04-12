package main.java.parnkGenerator.model.prank;

import main.java.parnkGenerator.model.mail.Message;
import main.java.parnkGenerator.model.mail.Person;

import java.security.acl.Group;
import java.util.LinkedList;

public class Prank {
    private Message message;
    private LinkedList<Person> witness;
    private Group group;

    public Prank(Message message,Group group){
        this.message=message;
        this.group=group;

    }
    public LinkedList<Person> getWitness() {
        return witness;
    }

    public void setWitness(LinkedList<Person> witness) {
        this.witness = witness;
    }


    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }


}
