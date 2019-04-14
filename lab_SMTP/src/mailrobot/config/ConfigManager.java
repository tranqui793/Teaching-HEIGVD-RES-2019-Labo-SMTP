package mailrobot.config;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import mailrobot.models.mail.Person;
import java.util.LinkedList;
import java.util.Properties;
import mailrobot.models.mail.Message;

/**
 *
 * @author oussama lagha
 */
public final class ConfigManager implements IconfigManager {

    private String SMTPServerAdress;
    private int SMTPServerPort;
    private int nombreGroupe;
    private LinkedList<Person> witness;
    private LinkedList<Person> victims;
    private LinkedList<Message> messages;
//constructor
    public ConfigManager() throws IOException {
        witness = new LinkedList();
        victims = new LinkedList();
        messages = new LinkedList();
        loadFileProperties("./src/configuration//properties.properties");
        loadVictims("./src/configuration//listVictims.txt");
        loadMessages("./src/configuration//messages.utf8");
    }
    
    @Override
    public void loadFileProperties(String fileName) throws IOException {

        FileInputStream in = new FileInputStream(fileName);
        Properties prop = new Properties();
        prop.load(in);
        this.SMTPServerAdress = prop.getProperty("ServerAdress");
        this.SMTPServerPort = Integer.valueOf(prop.getProperty("serverPort"));
        this.nombreGroupe = Integer.valueOf(prop.getProperty("nbGroups"));
        String Witns = prop.getProperty("witnessesToCC");
        String[] wit = Witns.split(",");
        for (String s : wit) {
            witness.add(new Person(s));
        }
        in.close();
    }

    @Override
    public void loadVictims(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String mail;
        while ((mail = bufferedReader.readLine()) != null) {
            victims.add(new Person(mail));
        }
        fileReader.close();
        bufferedReader.close();
    }

    @Override
    public void loadMessages(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String message;
        while ((message = bufferedReader.readLine()) != null) {
            String subject = message;
            bufferedReader.readLine();
            String body = "";
            String s;
            while (!"@@@".equals(s = bufferedReader.readLine())) {
                body += s;
            }
            messages.add(new Message(subject, body));
        }
        fileReader.close();
        bufferedReader.close();
    }
//Getters and Setters
    public String getSMTPServerAdress() {
        return SMTPServerAdress;
    }

    public int getSMTPServerPort() {
        return SMTPServerPort;
    }

    public int getNombreGroupe() {
        return nombreGroupe;
    }

    public LinkedList<Person> getWitness() {
        return witness;
    }

    public LinkedList<Person> getVictims() {
        return victims;
    }

    public LinkedList<Message> getMessages() {
        return messages;
    }

}
