package ar.edu.unlp.info.hermescelascolus.activities;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.models.Gender;
import ar.edu.unlp.info.hermescelascolus.models.Kid;
import ar.edu.unlp.info.hermescelascolus.validation.EditTextValidator;
import ar.edu.unlp.info.hermescelascolus.validation.NonEmptyStringValidator;
import ar.edu.unlp.info.hermescelascolus.validation.ValidationError;

@SuppressLint("Registered")
public class FormActivity extends AppCompatActivity {
    protected Kid kid;
    protected EditText firstNameInput;
    protected EditTextValidator firstNameValidator;
    protected EditText lastNameInput;
    protected EditTextValidator lastNameValidator;
    protected Spinner genderInput;
    protected Button saveButton;

    protected void initializeBasicKidFields(){
        firstNameInput = (EditText) findViewById(R.id.first_name_input);
        firstNameValidator =
                new EditTextValidator(
                        firstNameInput,
                        new NonEmptyStringValidator(getResources().getString(R.string.first_name_required_msg))
                );

        lastNameInput = (EditText) findViewById(R.id.last_name_input);
        lastNameValidator =
                new EditTextValidator(
                        lastNameInput,
                        new NonEmptyStringValidator(getResources().getString(R.string.last_name_required_msg))
                );


        genderInput = (Spinner) findViewById(R.id.gender_input);
        List<GenderWrapper> wrappers = new ArrayList<>();
        for (Gender gender: Gender.values()){
            wrappers.add(new GenderWrapper(getResources().getString(gender.getNameStringId()), gender));
        }

        ArrayAdapter<GenderWrapper> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                wrappers
        );
        genderInput.setAdapter(adapter);

        saveButton = (Button) findViewById(R.id.save_button);
    }

    protected void retrieveDataFromBasicKidFields() throws ValidationError {
        String firstName = firstNameValidator.getValue();
        String lastName = lastNameValidator.getValue();
        Gender gender = ((GenderWrapper) genderInput.getSelectedItem()).getGender();

        kid.setName(firstName);
        kid.setSurname(lastName);
        kid.setGender(gender);

    }

}
