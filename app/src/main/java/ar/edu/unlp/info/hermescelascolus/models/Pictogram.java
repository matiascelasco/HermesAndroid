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

    public Category2 getCategory() {
        return category;
    }

    public void setCategory(Category2 category) {
        this.category = category;
    }

    public int getSoundId() {
        return soundId;
    }

    public void setSoundId(int soundId) {
        this.soundId = soundId;
    }

    private int id;
    private int imageId;
    private int soundId;
    private Category2 category;
}
