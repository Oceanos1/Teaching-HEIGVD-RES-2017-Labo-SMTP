package ch.heigvd.res.labs.smtp.client;


import ch.heigvd.res.labs.smtp.model.mail.Mail;
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
    private int smtpServerPort = 25;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public SmtpClientImpl(String smtpServerAdress, int port) throws IOException {
        this.smtpServerAdress = smtpServerAdress;
        this.smtpServerPort = port;
    }

    private void sendToServer(String s) {
        out.println(s);
        out.flush();
    }


    public void sendMessage(Mail m) throws IOException {
        socket = new Socket(smtpServerAdress, smtpServerPort);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
        LOG.info(in.readLine());
        sendToServer(SmtpProtocol.CMD_EHLO);
        while (!in.readLine().startsWith("250 ")) {
            LOG.info(in.readLine());
        }

        sendToServer(SmtpProtocol.CMD_MAIL_FROM + m.getSender());
        LOG.info(in.readLine());

        for (String reciever : m.getRecievers()) {
            sendToServer(SmtpProtocol.CMD_RCPT_TO + reciever + "\r\n");
            LOG.info(in.readLine());
        }

        for (String reciever : m.getCC()) {
            sendToServer(SmtpProtocol.CMD_RCPT_TO + reciever + "\r\n");
            LOG.info(in.readLine());
        }

        sendToServer(SmtpProtocol.CMD_DATA);
        LOG.info(in.readLine());

        out.write("From: " + m.getSender() + "\r\n");

        ArrayList<String> recievers = m.getRecievers();
        ArrayList<String> cc = m.getCC();


        if (m.getRecievers().size() != 0) {
            out.write("To: " + recievers.get(0));
            for (int i = 1; i < recievers.size(); ++i) {
                out.write(", " + recievers.get(i));
            }
            out.write("\r\n");
        }

        if (m.getCC().size() != 0) {
            out.write("Cc: " + cc.get(0));
            for (int i = 1; i < cc.size(); ++i) {
                out.write(", " + cc.get(i));
            }
            out.write("\r\n");
        }

        out.flush();

        sendToServer(m.getMessage());
        sendToServer(SmtpProtocol.CMD_DATA_END);

        LOG.info(in.readLine());

        sendToServer(SmtpProtocol.CMD_BYE);
        socket.close();
        in.close();
        out.close();
        System.out.println("prank over");
    }


}
