package ar.edu.unlp.info.hermescelascolus.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.models.Kid;
import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;

public class TherapistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_therapist);

        Intent intent = getIntent();
        int kidId = intent.getIntExtra(InitialActivity.KID_ID, -1);
        Kid kid = Daos.KID.getById(kidId);

        TextView textView = (TextView) findViewById(R.id.therapist_text);
        textView.setText("Este es el modo terapeuta. El pibe se llama " + kid.getName());
    }
}
