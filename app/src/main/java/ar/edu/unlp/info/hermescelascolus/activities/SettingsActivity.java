package ar.edu.unlp.info.hermescelascolus.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.models.Kid;
import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Intent intent = getIntent();
        int kidId = intent.getIntExtra(KidActivity.KID_ID, -1);
        Kid kid = Daos.KID.getById(kidId);





        

        TextView textView = (TextView) findViewById(R.id.settings_text);
        textView.setText("Este es el coso de ajustes. El pibe se llama " + kid.getName());
    }
}
