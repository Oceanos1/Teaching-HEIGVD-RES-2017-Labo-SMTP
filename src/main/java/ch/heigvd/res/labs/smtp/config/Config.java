package ch.heigvd.res.labs.smtp.config;

import ch.heigvd.res.labs.smtp.model.mail.Personne;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Michael on 08.04.2017.
 */
public class Config implements IConfig {

    private String smtpServerAddress;
    private int smtpServerPort;
    private final List<Personne> victims;
    private final List<String> messages;
    private int numberOfGroups;
    private List<Personne> cc;

    public Config() throws IOException {
        victims = loadAddressesFromFile("./config/victims.RES.utf8");
        messages = loadMessagesFromFile("./config/messages.utf8");
        loadProprietes("./config/config.properties");
    }

    public List<Personne> loadAddressesFromFile(String fileName) throws IOException {
        List<Personne> personnes = new ArrayList<Personne>();
        FileInputStream fis = new FileInputStream(fileName);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader reader = new BufferedReader(isr);
        String addresse = reader.readLine();
        while (addresse != null) {
            personnes.add(new Personne(addresse));
            addresse = reader.readLine();
        }


        return personnes;
    }

    public List<String> loadMessagesFromFile(String fileName) throws IOException {
        List<String> result = new ArrayList<String>();
        FileInputStream fis = new FileInputStream(fileName);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader reader = new BufferedReader(isr);
        String line = reader.readLine();
        while (line != null) {
            StringBuilder sb = new StringBuilder();
            while ((line != null) && (!line.equals("=="))) {
                sb.append(line + "\r\n");
            }
            result.add(sb.toString());
            line = reader.readLine();
        }
        return result;
    }

    private void loadProprietes(String fileName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        Properties properties = new Properties();
        properties.load(fis);
        this.smtpServerAddress = properties.getProperty("smtpServerAdress");
        this.smtpServerPort = Integer.parseInt(properties.getProperty("smtpServerPort"));
        this.numberOfGroups = Integer.parseInt(properties.getProperty("numberOfGroups"));

        this.cc = new ArrayList<Personne>();
        String witnesses = properties.getProperty("witnessesToCC");
        String[] witnessesAddresses = witnesses.split(",");
        for (String a : witnessesAddresses) {
            this.cc.add(new Personne(a));
        }

    }
}
