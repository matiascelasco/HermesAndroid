package ar.edu.unlp.info.hermescelascolus.models;

public class Pictogram implements Model {

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getSoundId() {
        return soundId;
    }

    public void setSoundId(int soundId) {
        this.soundId = soundId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String getDir() {
        if (name.equals("si") || name.equals("no")){
            return "";
        }
        return category.getDir();
    }

    public String getSoundPath() {
        return String.format("%s/%s.m4a", getDir(), name);
    }

    public String getImagePath() {
        return String.format("%s/%s.png", getDir(), name);
    }

    private long id;
    private int imageId;
    private int soundId;
    private Category category;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pictogram pictogram = (Pictogram) o;

        return id == pictogram.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}
