package ch.heigvd.res.labs.smtp.model.mail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 08.04.2017.
 */
public class Group {
    List<Personne> group;

    public Group(){
        group = new ArrayList<Personne>();
    }

    public void addPerson(Personne p){
        group.add(p);
    }

    public List<Personne> getGroup(){
        return group;
    }
}
