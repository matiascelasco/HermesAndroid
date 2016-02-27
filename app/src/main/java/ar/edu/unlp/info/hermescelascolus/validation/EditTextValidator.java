package ar.edu.unlp.info.hermescelascolus.validation;

import android.widget.EditText;

import java.util.Arrays;
import java.util.List;

public class EditTextValidator {
    private EditText editText;
    private List<Validator<String>> validators;

    @SafeVarargs
    public EditTextValidator(EditText editText, Validator<String>... validators) {
        this.editText = editText;
        this.validators = Arrays.asList(validators);
    }

    public String getValue() throws ValidationError {
        String value = editText.getText().toString();
        for (Validator<String> v: validators){
            if (!v.isValid(value)){
                editText.setError(v.getMessage());
                throw new ValidationError(v.getMessage());
            }
        }
        // Remove trailing spaces at the beginning and the end of the string
        return value.replaceAll("^\\s+", "").replaceAll("\\s+$", "");
    }
}
