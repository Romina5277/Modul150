package ch.axa.meatbackend.mongo.model;

import org.springframework.data.annotation.Id;

public class Name {
    @Id
    private String id;

    private String vorname;
    private String nachname;

    public Name() {

    }

    public Name(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    @Override
    public String toString() {
        return String.format("Name[id=%s, vorname='%s', nachname='%s']", id, vorname, nachname);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
}
