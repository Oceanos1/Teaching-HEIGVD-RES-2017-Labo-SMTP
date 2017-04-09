package ch.heigvd.res.labs.smtp.client;

import ch.heigvd.res.labs.smtp.model.prank.Prank;

import java.io.IOException;

/**
 * Created by Michael Spierer & Edward Ransome
 */
public interface ISmtpClient {


    public void sendMessage(Prank p) throws IOException;


}
