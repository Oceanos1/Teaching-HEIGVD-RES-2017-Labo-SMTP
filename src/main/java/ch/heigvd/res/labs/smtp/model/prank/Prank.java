package ch.heigvd.res.labs.smtp.model.prank;

import ch.heigvd.res.labs.smtp.model.mail.Personne;

import java.util.ArrayList;

/**
 * Created by Michael on 06.04.2017.
 */
public class Prank {
    private Personne envoyeur;
    private ArrayList<Personne> receveurs;
    private String messageToSend;

    public Prank(){
        receveurs = new ArrayList<Personne>();
    }

    public Personne getEnvoyeur(){
        return envoyeur;
    }

    public ArrayList<Personne> getReceveurs(){
        return receveurs;
    }

    public String getMessageToSend(){
        return messageToSend;
    }
}
