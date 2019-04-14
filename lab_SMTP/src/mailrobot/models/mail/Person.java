
package mailrobot.models.mail;

/**
 *
 * @author Lagha Oussama
 */
public class Person {
    private String nom;
    private String prenom;
    private String mail;

    public Person(String nom, String prenom, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
    }
    //getters and setters
    public Person(String mail){
        this.mail=mail;
    }


    public String getMail() {
        return mail;
    }
}
