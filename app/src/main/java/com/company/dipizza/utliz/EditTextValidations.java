package com.company.dipizza.utliz;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import javax.xml.validation.Validator;

public class EditTextValidations implements TextWatcher {
    EditText editText;
    Validator validator;

    public EditTextValidations(EditText editText, Validator validator) {
        this.editText = editText;
        this.validator = validator;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        validator.validate(editText, s.toString());
    }

    public interface Validator {
        void validate(EditText editText, String text);
    }
}
