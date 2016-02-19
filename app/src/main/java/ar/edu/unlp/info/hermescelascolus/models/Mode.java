package ar.edu.unlp.info.hermescelascolus.models;

import android.app.Activity;

import ar.edu.unlp.info.hermescelascolus.activities.KidActivity;
import ar.edu.unlp.info.hermescelascolus.activities.TabsWithPictogramsActivity;
import ar.edu.unlp.info.hermescelascolus.activities.TherapistActivity;

public enum Mode {

    KID(KidActivity.class), THERAPIST(TherapistActivity.class);

    Mode(Class<?> activityClass) {
        this.activityClass = activityClass;
    }

    public Class<?> getActivityClass() {
        return activityClass;
    }

    private Class<?> activityClass;

}
