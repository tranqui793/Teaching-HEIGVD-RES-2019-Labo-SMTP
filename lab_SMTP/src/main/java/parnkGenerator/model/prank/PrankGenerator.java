package main.java.parnkGenerator.model.prank;

import main.java.parnkGenerator.model.mail.Person;

import java.io.IOException;
import java.security.acl.Group;
import java.util.LinkedList;
import java.util.Random;

public class PrankGenerator {
    private ConfigurationManager config;
    Random random = new Random();

    public PrankGenerator(ConfigurationManager config) {
        this.config = config;

    }

    public Group createGroups() throws IOException {
        LinkedList<Person> victims = new LinkedList<>(config.);
        Group group = new Group();
        int victimSender = random.nextInt(config.getVictims().size());

        group.setVictemSender(config.getVictims().get(victimSender));

        for (int i = 0; i < (victims.size() / config.getNumberOfGroups()) -1 ; ++i) {
            int randomVictim = random.nextInt(victims.size());
            while (randomVictim == victimSender) {
                randomVictim = random.nextInt(victims.size());
            }
            group.addPerson(victims.get(randomVictim));
        }
        return group;
    }

    public LinkedList<Prank> createPranks() throws IOException {
        LinkedList<Prank> pranks = new LinkedList<>();

        for (int index = 0; index < config.getNumberOfGroups(); index++) {
            int mess = random.nextInt(config.getMessages().size());
            Group g=createGroups();
            Prank prank = new Prank(config.getMessages().get(mess), g);
            prank.setWitness(config.getWitnessCC());
            pranks.add(prank);

        }
        return pranks;
    }
}
