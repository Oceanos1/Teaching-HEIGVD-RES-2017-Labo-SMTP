package ch.heigvd.res.labs.smtp.model.prank;

import ch.heigvd.res.labs.smtp.config.IConfig;
import ch.heigvd.res.labs.smtp.model.mail.Group;
import ch.heigvd.res.labs.smtp.model.mail.Personne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Michael on 08.04.2017.
 */
public class PrankGenerator {
    private IConfig config;

    public PrankGenerator(IConfig config) {
        this.config = config;
    }

    public List<Prank> generatePranks() {
        int i = 0;
        List<Prank> pranks = new ArrayList<Prank>();
        List<String> messages = new ArrayList<String>(config.getMessages());

        int numberOfGroups = config.getNumberOfGroups();
        int numberOfVictims = config.getVictims().size();

        if (numberOfVictims / numberOfGroups < 3) {
            numberOfGroups = numberOfVictims / 3;
            System.out.println("at least 3 victims per group");
        }

        List<Group> groups = generateGroups(config.getVictims(), numberOfGroups);
        for (Group g : groups) {
            List<Personne> victims = g.getGroup();
            Collections.shuffle(victims);
            Personne sender = victims.remove(0);


            String message = messages.get(i);
            i = (i + 1) % messages.size();

            Prank p = new Prank(sender, victims, config.getCc(), message);

            pranks.add(p);


        }
        return pranks;
    }

    public List<Group> generateGroups(List<Personne> victims, int numberOfGroups) {
        List<Group> groups = new ArrayList<Group>();
        List<Personne> victimesRestantes = new ArrayList<Personne>(victims);
        Collections.shuffle(victimesRestantes);

        for (int i = 0; i < numberOfGroups; ++i) {
            groups.add(new Group());
        }
        int i = 0;
        Group groupCible;
        while (victimesRestantes.size() > 0) {
            groupCible = groups.get(i);
            i = (i + 1) % groups.size();
            groupCible.addPerson(victimesRestantes.remove(0));
        }

        return groups;
    }
}
