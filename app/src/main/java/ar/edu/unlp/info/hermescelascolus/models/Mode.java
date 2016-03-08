package ar.edu.unlp.info.hermescelascolus.models;

import ar.edu.unlp.info.hermescelascolus.activities.KidActivity;
import ar.edu.unlp.info.hermescelascolus.activities.TherapistActivity;

public enum Mode {

    KID(KidActivity.class),
    THERAPIST(TherapistActivity.class);

    Mode(Class<?> activityClass) {
        this.activityClass = activityClass;
    }

    private Class<?> activityClass;

    public Class<?> getActivityClass() {
        return activityClass;
    }
}
