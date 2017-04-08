package ch.heigvd.res.labs.smtp;

import java.io.*;
import java.util.ArrayList;


/**
 * Created by Michael on 04.04.2017.
 */
public final class Parser {



//pour lire un fichier de mail

    public static ArrayList<Personne> getPersonnes(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        ArrayList<Personne> personnes = new ArrayList<Personne>();
        String s;
        while ((s = reader.readLine()) != null) {
            personnes.add(new Personne(s));
        }
        reader.close();
        return personnes;
    }

    //pour lire un fichier de mail

    public static ArrayList<String> getMessages(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        ArrayList<String> personnes = new ArrayList<String>();
        String s;
        while ((s = reader.readLine()) != null) {
            personnes.add(new Personne(s));
        }
        reader.close();
        return personnes;
    }
}
