package ch.heigvd.res.labs.smtp.config;

import ch.heigvd.res.labs.smtp.model.mail.Personne;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Michael on 08.04.2017.
 */
public interface IConfig {

    List<Personne> loadAddressesFromFile(String filename) throws IOException;

    List<String> loadMessagesFromFile(String filename) throws IOException;

    List<Personne> getVictims();

    List<String> getMessages();

    int getNumberOfGroups();

    List<Personne> getCc();

    public String getSmtpServerAddress();

    public int getSmtpServerPort();

}
