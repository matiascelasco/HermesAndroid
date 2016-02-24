package ar.edu.unlp.info.hermescelascolus.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridLayout;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.models.Mode;
import ar.edu.unlp.info.hermescelascolus.validation.EditTextValidator;
import ar.edu.unlp.info.hermescelascolus.validation.IpValidator;
import ar.edu.unlp.info.hermescelascolus.validation.NonEmptyStringValidator;
import ar.edu.unlp.info.hermescelascolus.validation.RegexValidator;
import ar.edu.unlp.info.hermescelascolus.validation.ValidationError;
import ar.edu.unlp.info.hermescelascolus.models.Category;
import ar.edu.unlp.info.hermescelascolus.models.Settings;
import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;

public class SettingsFormActivity extends FormActivity {

    public final static String KID_ID = "ar.edu.unlp.info.hermescelascolus.KID_ID";
    public static final String PREVIOUS_MODE_ORDINAL =
            "ar.edu.unlp.info.hermescelascolus.PREVIOUS_MODE_ORDINAL";
    private final Map<Category, CheckBox> checkboxByCategory = new EnumMap<>(Category.class);
    private Settings settings;
    private EditTextValidator ipValidator;
    private EditTextValidator portValidator;
    private Mode previousMode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Intent intent = getIntent();

        long kidId = intent.getLongExtra(KID_ID, -1);
        int previousModeOrdinal = intent.getIntExtra(PREVIOUS_MODE_ORDINAL, -1);

        kid = Daos.KID.getById(kidId);
        previousMode = Mode.values()[previousModeOrdinal];
        settings = Daos.SETTINGS.all().get(0);

        initializeBasicKidFields();

        firstNameInput.setText(kid.getName());
        lastNameInput.setText(kid.getSurname());
        genderInput.setSelection(kid.getGender().ordinal());

        Set<Category> categories = new HashSet<>(kid.getCategories());

        GridLayout checkboxContainer = (GridLayout) findViewById(R.id.category_checkboxes);
        for (Category c: Category.values()){
            CheckBox checkBox = new AppCompatCheckBox(this);
            checkBox.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            checkBox.setText(c.name());
            checkBox.setChecked(categories.contains(c));
            checkboxContainer.addView(checkBox);
            checkboxByCategory.put(c, checkBox);
        }


        EditText ipInput = (EditText) findViewById(R.id.monitor_ip_address_input);
        ipValidator =
                new EditTextValidator(
                        ipInput,
                        new NonEmptyStringValidator(getResources().getString(R.string.ip_required_msg)),
                        new IpValidator(getResources().getString(R.string.ip_invalid))
                );
        ipInput.setText(settings.getMonitorIp());

        EditText portInput = (EditText) findViewById(R.id.monitor_port_input);
        portValidator =
                new EditTextValidator(
                        portInput,
                        new NonEmptyStringValidator(getResources().getString(R.string.port_required_msg)),
                        new RegexValidator(
                                getResources().getString(R.string.port_invalid),
                                "^([0-9]{1,4}|[1-5][0-9]{4}|6[0-4][0-9]{3}|65[0-4][0-9]{2}|655[0-2][0-9]|6553[0-5])$"
                        )
                );
        portInput.setText(settings.getMonitorPort());

        saveButton.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    retrieveDataFromBasicKidFields();

                    LinkedList<Category> checkedCategories = new LinkedList<>();
                    for (Category c : Category.values()) {
                        if (checkboxByCategory.get(c).isChecked()) {
                            checkedCategories.add(c);
                        }
                    }
                    kid.setCategories(checkedCategories);

                    //TODO: pictogram size

                    String ip = ipValidator.getValue();
                    String port = portValidator.getValue();
                    settings.setMonitorIp(ip);
                    settings.setMonitorPort(port);

                    Daos.SETTINGS.save(settings);
                    Daos.KID.save(kid);

                    startPreviousActivity();

                } catch (ValidationError validationError) {
                    // don't do nothing. getValue method in validators
                    // takes care of showing the validation errors
                }
            }
        });

        Button deleteButton = (Button) findViewById(R.id.delete_kid_button);
        deleteButton.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                Daos.KID.delete(kid);
                startInitialActivity();
            }
        });

    }

    private void startInitialActivity() {
        Intent intent = new Intent(this, InitialActivity.class);
        startActivity(intent);
    }

    private void startPreviousActivity(){
        Intent intent = new Intent(this, previousMode.getActivityClass());
        intent.putExtra(PictogramsActivity.KID_ID, kid.getId());
        startActivity(intent);
    }
}
