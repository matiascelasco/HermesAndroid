package ar.edu.unlp.info.hermescelascolus.models;

import java.util.Date;

/**
 * Created by laura on 22/02/16.
 */
public class Notification {

    private int id;
    private Kid kid;
    private Date dateTimeSent;
    private String content; //pictogram's name
    private Category category;
    private final String context = "CEDICA"; //this is constant, CEDICA

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Kid getKid() {
        return kid;
    }

    public void setKid(Kid kid) {
        this.kid = kid;
    }

    public Date getDateTimeSent() {
        return dateTimeSent;
    }

    public void setDateTimeSent(Date dateTimeSent) {
        this.dateTimeSent = dateTimeSent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getContext() {
        return context;
    }
}
