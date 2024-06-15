package com.company.dipizza.utliz;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.company.dipizza.R;

public class EditTextValidations implements TextWatcher {
    private Activity activity;
    private EditText editText;
    private TextWatcher externalTextWatcher;

    public EditTextValidations(Activity activity, EditText editText, TextWatcher externalTextWatcher) {
        this.activity = activity;
        this.editText = editText;
        this.externalTextWatcher = externalTextWatcher;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        if (externalTextWatcher != null) {
            externalTextWatcher.beforeTextChanged(s, start, count, after);
        }
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (externalTextWatcher != null) {
            externalTextWatcher.onTextChanged(s, start, before, count);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
        validate(s.toString(), editText);
        if (externalTextWatcher != null) {
            externalTextWatcher.afterTextChanged(s);
        }
    }

    private void validate(String text, EditText editText) {
        if (editText.getId() == R.id.fullName) {
            if (text.isEmpty()) {
                editText.setError("Full Name is required");
            } else if (!text.matches("[a-zA-Z ]+")) {
                editText.setError("Full Name cannot contain numbers or special characters");
            } else {
                editText.setError(null);
            }
        } else if (editText.getId() == R.id.phone) {
            if (text.isEmpty()) {
                editText.setError("Phone Number is required");
            } else if (!text.matches("\\d{10}")) {
                editText.setError("Phone Number must be a 10-digit number");
            } else {
                editText.setError(null);
            }
        } else if (editText.getId() == R.id.email) {
            if (text.isEmpty()) {
                editText.setError("Email is required");
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(text).matches()) {
                editText.setError("Invalid Email Address");
            } else {
                editText.setError(null);
            }
        } else if (editText.getId() == R.id.password) {
            if (text.isEmpty()) {
                editText.setError("Password is required");
            } else if (text.contains(" ")) {
                editText.setError("Password cannot contain spaces");
            } else if (text.length() < 4) {
                editText.setError("Password must be at least 4 characters long");
            } else {
                editText.setError(null);
            }
        } else if (editText.getId() == R.id.confirmPwd) {
            EditText passwordInput = activity.findViewById(R.id.password);
            String password = passwordInput.getText().toString();
            if (!text.equals(password)) {
                editText.setError("Passwords do not match");
            } else {
                editText.setError(null);
            }
        }
    }
}
