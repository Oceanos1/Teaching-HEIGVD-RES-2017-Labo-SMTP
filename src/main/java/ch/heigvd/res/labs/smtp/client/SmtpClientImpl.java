package ch.heigvd.res.labs.smtp.client;


import ch.heigvd.res.labs.smtp.protocol.SmtpProtocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class implements the client side of the protocol specification (version 1).
 *
 * Created by Michael on 04.04.2017.
 */
public class SmtpClientImpl implements ISmtpClient {


    private static final Logger LOG = Logger.getLogger(ISmtpClient.class.getName());

    Socket socket;
    boolean connected = false;
    BufferedReader in;
    PrintWriter out;

    void sendToServer(String s) {
        out.println(s);
        out.flush();
    }

    public void connect(String server, int port) throws IOException {
        try {
            socket = new Socket(server, port);
            connected = true;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "Unable to connect to server: {0}", e.getMessage());
            return;
        }
        in.readLine();
    }

    public void disconnect() throws IOException {
        LOG.log(Level.INFO, "client has requested to be disconnected.");
        if (connected == false) {
            return;
        }
        connected = false;
        sendToServer(SmtpProtocol.CMD_BYE);

        //close input output & socket
        out.close();
        in.close();
        socket.close();
    }

    public boolean isConnected() {
        return connected;
    }


    public void sendMessage(){

    }


}
