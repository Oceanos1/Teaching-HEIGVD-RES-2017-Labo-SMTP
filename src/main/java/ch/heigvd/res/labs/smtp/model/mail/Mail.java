package ch.heigvd.res.labs.smtp.model.mail;

import java.util.ArrayList;

/**
 * Created by Michael on 08.04.2017.
 */
public class Mail {

    public String sender;
    public ArrayList<String> recievers;
    public ArrayList<String> cc;
    public String subject;
    public String body;

    public Mail(String sender, ArrayList<String> recievers,ArrayList<String> cc,String subject, String body){
        this.sender=sender;
        this.recievers=recievers;
        this.cc = cc;
        this.subject=subject;
        this.body=body;
    }
    public String getSender(){
        return sender;
    }

    public ArrayList<String> getRecievers(){
        return recievers;
    }

    public ArrayList<String> getCC(){
        return cc;
    }

    public String getMessage(){
        return body;
    }


}
