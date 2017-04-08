package ch.heigvd.res.labs.smtp.client;


import ch.heigvd.res.labs.smtp.model.mail.Mail;
import ch.heigvd.res.labs.smtp.model.mail.Personne;
import ch.heigvd.res.labs.smtp.model.prank.Prank;
import ch.heigvd.res.labs.smtp.protocol.SmtpProtocol;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * This class implements the client side of the protocol specification (version 1).
 * <p>
 * Created by Michael on 04.04.2017.
 */
public class SmtpClientImpl implements ISmtpClient {


    private static final Logger LOG = Logger.getLogger(SmtpClientImpl.class.getName());

    private String smtpServerAdress;
    private int smtpServerPort;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public SmtpClientImpl(String smtpServerAdress, int port) throws IOException {
        this.smtpServerAdress = smtpServerAdress;
        this.smtpServerPort = port;
    }

    private void sendToServer(String s) {
        out.print(s);
        out.flush();
    }


    public void sendMessage(Prank p) throws IOException {
        String response;
        socket = new Socket(smtpServerAdress, smtpServerPort);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

        response=in.readLine();
        LOG.info(response);


        sendToServer(SmtpProtocol.CMD_EHLO + "prankGenerator.com\r\n");


        while (!(response = in.readLine()).startsWith("250 ")) {
            LOG.info(response);
        }
        LOG.info(response);

        sendToServer(SmtpProtocol.CMD_MAIL_FROM + p.getEnvoyeur().getEmail()+"\r\n");
        response=in.readLine();
        LOG.info(response);

        for (Personne reciever : p.getReceveurs()) {
            sendToServer(SmtpProtocol.CMD_RCPT_TO + reciever.getEmail() + "\r\n");
            response=in.readLine();
            LOG.info(response);
        }

        for (Personne reciever : p.getCc()) {
            sendToServer(SmtpProtocol.CMD_RCPT_TO + reciever.getEmail() + "\r\n");
            response=in.readLine();
            LOG.info(response);
        }

        sendToServer(SmtpProtocol.CMD_DATA+"\r\n");
        response=in.readLine();
        LOG.info(response);

        out.write("From: " + p.getEnvoyeur().getEmail() + "\r\n");


        if (p.getReceveurs().size() != 0) {
            out.write("To: " + p.getReceveurs().get(0).getEmail());
            for (int i = 1; i < p.getReceveurs().size(); ++i) {
                out.write(", " + p.getReceveurs().get(i).getEmail());
            }
            out.write("\r\n");
        }

        if (p.getCc().size() != 0) {
            out.write("Cc: " + p.getCc().get(0).getEmail());
            for (int i = 1; i < p.getCc().size(); ++i) {
                out.write(", " + p.getCc().get(i).getEmail());
            }
            out.write("\r\n");
        }

        out.flush();

        sendToServer(p.getMessageToSend());
        sendToServer(SmtpProtocol.CMD_DATA_END);

        response=in.readLine();
        LOG.info(response);

        sendToServer(SmtpProtocol.CMD_BYE);
        socket.close();
        in.close();
        out.close();
    }


}
