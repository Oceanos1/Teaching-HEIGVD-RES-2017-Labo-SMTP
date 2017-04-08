package ch.heigvd.res.labs.smtp;


import ch.heigvd.res.labs.smtp.client.SmtpClientImpl;
import ch.heigvd.res.labs.smtp.config.Config;
import ch.heigvd.res.labs.smtp.config.IConfig;
import ch.heigvd.res.labs.smtp.model.mail.Group;
import ch.heigvd.res.labs.smtp.model.mail.Personne;
import ch.heigvd.res.labs.smtp.model.prank.Prank;
import ch.heigvd.res.labs.smtp.model.prank.PrankGenerator;

import java.io.IOException;
import java.util.List;

/**
 * Created by Michael on 04.04.2017.
 */
public class SmtpPrankApplication {

    public static void main(String[] args) throws IOException {
        IConfig config = new Config();
        PrankGenerator prankGenerator = new PrankGenerator(config);

        SmtpClientImpl sci = new SmtpClientImpl(config.getSmtpServerAddress(),config.getSmtpServerPort());

        List<Prank> pranks = prankGenerator.generatePranks();
        for(Prank p : pranks){
            sci.sendMessage(p);
        }

    }
}
