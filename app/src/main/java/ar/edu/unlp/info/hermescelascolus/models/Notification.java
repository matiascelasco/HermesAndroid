package ar.edu.unlp.info.hermescelascolus.models;

import java.util.Date;

/**
 * Created by laura on 22/02/16.
 */
public class Notification {

    private String category;
    private String content;
    private final String context = "CEDICA"; //this is constant, CEDICA
    private String kid;
    private Date sent;

    public String getKid() {
        return kid;
    }

    public void setKid(String kid) {
        this.kid = kid;
    }

    public Date getSent() {
        return sent;
    }

    public void setDateTimeSent(Date dateTimeSent) {
        this.sent = dateTimeSent;
    }

    public String getContext() {
        return context;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){ //pictogram name
        return this.content;
    }

    public String getCategory(){ //pictogram category
        return category;
    }
}
