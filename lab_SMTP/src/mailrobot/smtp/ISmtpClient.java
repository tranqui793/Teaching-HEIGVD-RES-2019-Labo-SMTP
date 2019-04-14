
package mailrobot.smtp;

import java.io.IOException;
import mailrobot.models.prank.Prank;

/**
 *
 * @author Lagha Oussama
 */
public interface ISmtpClient {
    /*
    *@brief permet l'envoi d'un mail au server
    */
    public void sendMessage(Prank prank)throws IOException;
}
