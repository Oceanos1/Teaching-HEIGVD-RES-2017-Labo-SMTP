package ch.heigvd.res.labs.smtp.model.prank;

import ch.heigvd.res.labs.smtp.model.mail.Personne;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 06.04.2017.
 */
public class Prank {
    private Personne envoyeur;
    private final List<Personne> receveurs;
    private final List<Personne> cc;

    private String messageToSend;

    public Prank(Personne envoyeur, List<Personne> receveurs, List<Personne> cc, String messageToSend) {
        this.envoyeur = envoyeur;
        this.receveurs = new ArrayList<Personne>(receveurs);
        this.cc = new ArrayList<Personne>(cc);
        this.messageToSend = messageToSend;
    }

    public Personne getEnvoyeur() {
        return envoyeur;
    }

    public List<Personne> getReceveurs() {
        return receveurs;
    }

    public List<Personne> getCc() {
        return cc;
    }

    public String getMessageToSend() {
        return messageToSend;
    }
}
