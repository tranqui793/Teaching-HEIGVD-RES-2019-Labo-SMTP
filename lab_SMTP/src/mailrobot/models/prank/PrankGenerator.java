package mailrobot.models.prank;

import java.io.IOException;
import mailrobot.config.ConfigManager;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Lagha Oussama
 */
public class PrankGenerator {

    private ConfigManager cf;

    private LinkedList<Prank> pranks;

    public PrankGenerator(ConfigManager cf) throws IOException {
        this.cf = cf;
        pranks = new LinkedList();

        for (int i = 0; i < cf.getNombreGroupe(); ++i) {
            pranks.add(new Prank());
        }
        generatePrank();
    }

    public LinkedList<Prank> getPranks() {
        return pranks;
    }

    /*
    *@brief permet de generer des prank en fonction du nombre du groupe 
     */
    public void generatePrank() {

        Random rand = new Random();

        int nbVictims = cf.getVictims().size();

        for (Prank prank : pranks) {

            prank.addWitnessRecipients(cf.getWitness());
            int idVictimSender = rand.nextInt(nbVictims);
            prank.setVictimSender(cf.getVictims().get(idVictimSender));

            LinkedList randomVictims = new LinkedList();
            for (int i = 0; i < nbVictims / cf.getNombreGroupe(); ++i) {

                int idVictim = rand.nextInt(nbVictims);
                while (idVictim == idVictimSender) {
                    idVictim = rand.nextInt(nbVictims);
                }
                randomVictims.add(cf.getVictims().get(idVictim));
            }
            prank.addVictimRespients(randomVictims);
            prank.setMessage(cf.getMessages().get(rand.nextInt(cf.getMessages().size())));
        }
    }
}
