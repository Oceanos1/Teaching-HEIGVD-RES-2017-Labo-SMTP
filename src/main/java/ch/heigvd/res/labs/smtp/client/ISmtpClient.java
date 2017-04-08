package ch.heigvd.res.labs.smtp.client;

import ch.heigvd.res.labs.smtp.model.mail.Mail;
import ch.heigvd.res.labs.smtp.model.prank.Prank;

import java.io.IOException;
import java.util.List;

/**
 * Created by Michael on 04.04.2017.
 */
public interface ISmtpClient {


    public void sendMessage(Prank p) throws IOException;


}
