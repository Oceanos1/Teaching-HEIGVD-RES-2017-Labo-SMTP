package ch.heigvd.res.labs.smtp;


import ch.heigvd.res.labs.smtp.config.Config;
import ch.heigvd.res.labs.smtp.config.IConfig;
import ch.heigvd.res.labs.smtp.model.mail.Personne;
import ch.heigvd.res.labs.smtp.model.prank.PrankGenerator;

import java.io.IOException;

/**
 * Created by Michael on 04.04.2017.
 */
public class SmtpPrankApplication {

    public static void main(String[] args) throws IOException {
        IConfig config = new Config();
        PrankGenerator prankGenerator = new PrankGenerator(config);


    }
}
