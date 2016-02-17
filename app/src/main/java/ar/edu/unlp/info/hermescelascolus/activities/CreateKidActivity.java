package ar.edu.unlp.info.hermescelascolus.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.ValidationError;

public class CreateKidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_kid);

        Button btn = (Button) findViewById(R.id.create_kid_button);
        btn.setOnClickListener(new Button.OnClickListener(){

            private String getStringFromEditTextAndValidate(int id, String requiredMsg) throws ValidationError {
                EditText widget = (EditText) findViewById(id);
                String string = widget.getText().toString();
                if (string.equals("")){
                    throw new ValidationError(requiredMsg);
                }
                return string;
            }

            @Override
            public void onClick(View v) {
                try {
                    String firstName = getStringFromEditTextAndValidate(
                            R.id.first_name_input,
                            "R.string.first_name_required_msg");
                    String lastName = getStringFromEditTextAndValidate(
                            R.id.last_name_input,
                            "R.string.last_name_required_msg");
                } catch (ValidationError validationError) {
                    Toast.makeText(CreateKidActivity.this,
                            validationError.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
