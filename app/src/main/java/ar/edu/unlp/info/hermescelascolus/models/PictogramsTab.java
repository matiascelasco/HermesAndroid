package ar.edu.unlp.info.hermescelascolus.models;

import java.util.List;

public class PictogramsTab {
    private String title;
    private List<Pictogram> pictograms;

    public PictogramsTab(String title, List<Pictogram> pictograms) {
        this.title = title;
        this.pictograms = pictograms;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Pictogram> getPictograms() {
        return pictograms;
    }

    public void setPictograms(List<Pictogram> pictograms) {
        this.pictograms = pictograms;
    }
}
