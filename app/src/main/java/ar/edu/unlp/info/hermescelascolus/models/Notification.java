package ar.edu.unlp.info.hermescelascolus.models;

import java.util.Date;

public class Notification {

    private String category;
    private String content;
    private final String context = "CEDICA"; //this is constant, CEDICA
    private String kid;
    private Date sent;

    public Notification(String kidName, Pictogram pictogram){
        this.content = pictogram.getNameToBeDisplayed();
        this.kid = kidName;
        this.sent = new Date();
        this.category = pictogram.getCategory().getNameToBeDisplayed();
    }
}
