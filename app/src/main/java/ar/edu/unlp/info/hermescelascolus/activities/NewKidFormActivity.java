package ar.edu.unlp.info.hermescelascolus.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.validation.ValidationError;
import ar.edu.unlp.info.hermescelascolus.models.Kid;
import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;

public class NewKidFormActivity extends FormActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_kid);

        kid = new Kid();

        initializeBasicKidFields();

        saveButton.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    retrieveDataFromBasicKidFields();
                    Daos.KID.save(kid);
                    startKidActivity(kid);
                    //finish();

                } catch (ValidationError validationError) {
                    // don't do nothing. getValue method in validators
                    // takes care of showing the validation errors
                }

            }
        });
    }

    private void startKidActivity(Kid kid){
        Intent intent = new Intent(this, KidActivity.class);
        intent.putExtra(PictogramsActivity.KID_ID, kid.getId());
        startActivity(intent);
        //TODO: not sure if its a good idea to use always KID_ID from InitialActivity
    }


}
