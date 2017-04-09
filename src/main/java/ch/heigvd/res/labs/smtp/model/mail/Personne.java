package ch.heigvd.res.labs.smtp.model.mail;

/**
 * Created by Michael Spierer & Edward Ransome
 */
public class Personne {
    private String name;
    private String lastName;
    private String email;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Personne(String email) {
        this.email = email;
        String[] getNames = email.split("@")[0].split("\\.");
        //recupere le nom et le prenom du mailet mets la premiere lettre en majuscule
        name = getNames[0].substring(0, 1).toUpperCase() + getNames[0].substring(1);
        lastName = getNames[1].substring(0, 1).toUpperCase() + getNames[1].substring(1);
    }

    public Personne(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }



}
