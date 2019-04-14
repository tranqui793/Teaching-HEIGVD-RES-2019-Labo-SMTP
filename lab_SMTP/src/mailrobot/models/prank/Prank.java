package mailrobot.models.prank;

import java.util.LinkedList;
import java.util.List;
import mailrobot.models.mail.Message;
import mailrobot.models.mail.Person;

/**
 *
 * @author Lagha Oussama
 */
public class Prank {

    private Person victimSender;
    private final LinkedList<Person> victimRecipients = new LinkedList<>();
    private final LinkedList<Person> witnessRecipients = new LinkedList<>();
    private Message message;
//Getters and Setters
    public Person getVictimSender() {
        return victimSender;
    }

    public void setVictimSender(Person person) {
        this.victimSender = person;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public void addVictimRespients(List<Person> victims) {
        victimRecipients.addAll(victims);
    }

    public void addWitnessRecipients(List<Person> witness) {
        witnessRecipients.addAll(witness);
    }

    public List<Person> getVictimRecipients() {
        return victimRecipients;
    }

    public List<Person> getWitnessRecipients() {
        return witnessRecipients;
    }

}
