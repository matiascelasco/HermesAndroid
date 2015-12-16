package ar.edu.unlp.info.hermescelascolus.models;

import ar.edu.unlp.info.hermescelascolus.R;

public class Pictogram {

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getSoundId() {
        return R.raw.enojada;
        //return soundId;
    }

    public void setSoundId(int soundId) {
        this.imageId = soundId;
    }

    private int id;
    private int imageId;
    private int soundId;
    private Category category;
}
