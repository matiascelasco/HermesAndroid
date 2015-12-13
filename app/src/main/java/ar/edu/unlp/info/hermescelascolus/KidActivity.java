package ar.edu.unlp.info.hermescelascolus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ar.edu.unlp.info.hermescelascolus.dao.Daos;

public class KidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kid);

        Intent intent = getIntent();
        int kidId = intent.getIntExtra(InitialActivity.KID_ID, -1);
        Kid kid = Daos.KID.getById(kidId);

        TextView textView = (TextView) findViewById(R.id.kid_text);
        textView.setText(kid.getName());
    }
}
