
package mailrobot.models.mail;

/**
 *
 * @author Lagha Oussama
 */

public class Message {
    private String subject;
    private String body;

    public Message( String subject, String body) {
        this.subject = subject;
        this.body = body;
    }
//Getters and Setters
    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

}
