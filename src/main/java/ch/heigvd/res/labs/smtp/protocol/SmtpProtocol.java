
package ch.heigvd.res.labs.smtp.protocol;

/**
 * Created by Michael on 04.04.2017.
 */
public class SmtpProtocol {


    public final static String VERSION = "1.0";

    public final static int DEFAULT_PORT = 25;

    public final static String CMD_EHLO = "EHLO ";
    public final static String CMD_MAIL_FROM = "MAIL FROM: ";
    public final static String CMD_RCPT_TO = "RCPT TO: ";
    public final static String CMD_DATA = "DATA\r\n";
    public final static String CMD_DATA_END = "\r\n.\r\n";
    public final static String CMD_BYE = "quit\r\n";


    public final static String[] SUPPORTED_COMMANDS = new String[]{CMD_EHLO, CMD_MAIL_FROM, CMD_RCPT_TO, CMD_DATA, CMD_DATA_END, CMD_BYE};



}