
package mailrobot.config;

import java.io.IOException;

/**
 *
 * @author oussama lagha
 */
public interface IconfigManager {
    /*
    @brief permet de charger les properties
    @param nom de fichier
    */
    public void loadFileProperties(String fileName)throws IOException;
    /*
    @brief permet de charger les victims
    @param nom de fichier
    */
    public void loadVictims(String fileName)throws IOException;
    /*
    @brief permet de charger les messages
    @param nom de fichier
    */
    public void loadMessages(String filename)throws IOException;
    
}
