package ar.edu.unlp.info.hermescelascolus.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.ValidationError;
import ar.edu.unlp.info.hermescelascolus.models.Kid;
import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;

public class CreateKidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_kid);

        Button btn = (Button) findViewById(R.id.create_kid_button);
        btn.setOnClickListener(new Button.OnClickListener(){

            private String getStringFromEditTextAndValidate(int id, int requiredMsgId) throws ValidationError {
                EditText widget = (EditText) findViewById(id);
                String string = widget.getText().toString();
                if (string.equals("")){
                    throw new ValidationError(getResources().getString(requiredMsgId));
                }
                return string;
            }

            @Override
            public void onClick(View v) {
                try {
                    String firstName = getStringFromEditTextAndValidate(
                            R.id.first_name_input,
                            R.string.first_name_required_msg);
                    String lastName = getStringFromEditTextAndValidate(
                            R.id.last_name_input,
                            R.string.last_name_required_msg);
                    Kid kid = new Kid();
                    kid.setName(firstName);
                    kid.setSurname(lastName);
                    Daos.KID.save(kid);
                    startKidActivity(kid);
                } catch (ValidationError validationError) {
                    Toast.makeText(CreateKidActivity.this,
                            validationError.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void startKidActivity(Kid kid){
        Intent intent = new Intent(this, KidActivity.class);
        intent.putExtra(InitialActivity.KID_ID, kid.getId());
        startActivity(intent);
    }


}
