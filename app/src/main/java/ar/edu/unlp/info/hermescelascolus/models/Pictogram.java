package ar.edu.unlp.info.hermescelascolus.models;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;

public class Pictogram implements Model {

    public enum Size implements Model {
        SMALL(R.string.small, 128),
        MEDIUM(R.string.medium, 256),
        LARGE(R.string.large, 512);

        private int nameStringId;
        private int columnWidth;

        Size(int nameStringId, int columnWidth) {
            this.nameStringId = nameStringId;
            this.columnWidth = columnWidth;
        }

        @Override
        public long getId() {
            return ordinal();
        }

        public int getNameStringId() {
            return nameStringId;
        }

        public int getColumnWidth() {
            return columnWidth;
        }

    }


    private static Pictogram yes;
    private static Pictogram no;

    private static void setYesNo(){
        for (Pictogram p: Daos.PICTOGRAM.all()){
            if (p.getName().equals("si")){
                yes = p;
            }
            if (p.getName().equals("no")){
                no = p;
            }
        }
    }
    public static Pictogram getYes() {
        if (yes == null){
            setYesNo();
        }
        return yes;
    }

    public static Pictogram getNo() {
        if (no == null){
            setYesNo();
        }
        return no;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameToBeDisplayed() {

        // if (name.equals("Si")){
        //     return "Sí";  // not needed because Yes No notifications are never sent
        // }

        // capitalize first letter
        String nameToBeDisplayed = name.substring(0, 1).toUpperCase() + name.substring(1);
        nameToBeDisplayed = nameToBeDisplayed.replace("_ninio", "");
        nameToBeDisplayed = nameToBeDisplayed.replace("_ninia", "");
        nameToBeDisplayed = nameToBeDisplayed.replace("Banio", "Baño");
        nameToBeDisplayed = nameToBeDisplayed.replace('_', ' ');
        return nameToBeDisplayed;
    }

    private String getDirPath() {
        if (name.equals("si") || name.equals("no")){
            return "";
        }
        return category.getDir() + "/";
    }

    public String getSoundPath() {
        return getDirPath() + name + ".m4a";
    }

    public String getImagePath() {
        return getDirPath() + name + ".png";
    }

    private long id;
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
