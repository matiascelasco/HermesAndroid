package ar.edu.unlp.info.hermescelascolus.models;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.activities.KidActivity;
import ar.edu.unlp.info.hermescelascolus.activities.TherapistActivity;

public enum Mode {

    KID(KidActivity.class, R.layout.tab_fragment_kid),
    THERAPIST(TherapistActivity.class, R.layout.tab_fragment_grid);

    Mode(Class<?> activityClass, int fragmentLayoutId) {
        this.activityClass = activityClass;
        this.fragmentLayoutId = fragmentLayoutId;
    }

    private Class<?> activityClass;
    private int fragmentLayoutId;

    public Class<?> getActivityClass() {
        return activityClass;
    }
    public int getFragmentLayoutId() {
        return fragmentLayoutId;
    }
}
