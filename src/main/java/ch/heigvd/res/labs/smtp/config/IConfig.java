package ch.heigvd.res.labs.smtp.config;

import ch.heigvd.res.labs.smtp.model.mail.Personne;

import java.io.IOException;
import java.util.List;

/**
 * Created by Michael Spierer & Edward Ransome
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
