package mailrobot.smtp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import mailrobot.models.mail.Person;
import mailrobot.models.prank.Prank;

/**
 *
 * @author Lagha Oussama
 */
public class SmtpClient implements ISmtpClient {

    private String serverAddress;
    private int smtpServerPort ;
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    public SmtpClient(String serverAddress, int smtpServerPort) {
        this.serverAddress = serverAddress;
        this.smtpServerPort = smtpServerPort;
    }

    @Override
    public void sendMessage(Prank prank) throws IOException {
        socket = new Socket(serverAddress, smtpServerPort);
        writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        String line = reader.readLine();
        writer.print("EHLO localhost\r\n");
        writer.flush();
        line = reader.readLine();
        if (!line.startsWith("250")) {
            throw new IOException("SMTP error " + line);
        }
        while (line.startsWith("250-")) {
            line = reader.readLine();
        }
        writer.write("MAIL FROM:"); 
        writer.write(prank.getVictimSender().getMail());
        writer.write("\r\n");
        writer.flush();
        line = reader.readLine();
        for (Person to : prank.getVictimRecipients()) {
            writer.write("RCPT TO:");
            writer.write(to.getMail());
            writer.write("\r\n");
            writer.flush();
        }
        for (Person to : prank.getWitnessRecipients()) {
            writer.write("RCPT TO:");
            writer.write(to.getMail());
            writer.write("\r\n");
            writer.flush();

        }
        writer.write("DATA");
        writer.write("\r\n");
        writer.flush();
        line = reader.readLine();
        writer.write("from: " + prank.getVictimSender().getMail() + "\r\n");
        Iterator<Person> it = prank.getVictimRecipients().iterator();
        writer.write("To: " + it.next().getMail());
        while (it.hasNext()) {
            writer.write("," + it.next().getMail());
        }
        writer.write("\r\n");
        it = prank.getWitnessRecipients().iterator();
        writer.write("Cc: " + it.next().getMail());
        while (it.hasNext()) {
            writer.write("," + it.next().getMail());
        }
        writer.write("\r\n");
        writer.flush();
        writer.write("SUBJECT : "+prank.getMessage().getSubject());
        writer.write("\n\r");
        writer.flush();
        writer.write(prank.getMessage().getBody()+"\r\n");
        writer.flush();
        writer.write(".");
        writer.write("\r\n");
        writer.flush();
        line = reader.readLine();
        writer.write("QUIT\r\n");
        writer.flush();
        reader.close();
        writer.close();
        socket.close();
    }
}
