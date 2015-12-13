package ar.edu.unlp.info.hermescelascolus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class KidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kid);

        Intent intent = getIntent();
        String kidName = intent.getStringExtra(InitialActivity.KID_NAME);

        TextView textView = (TextView) findViewById(R.id.kid_text);
        textView.setText(kidName);
    }
}
