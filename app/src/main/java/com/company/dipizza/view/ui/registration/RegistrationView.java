package com.company.dipizza.view.ui.registration;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.company.dipizza.R;
import com.company.dipizza.utliz.EditTextValidations;

public class RegistrationView extends AppCompatActivity{

    EditText fullNameInput;
    EditText phoneInput;
    EditText emailInput;
    EditText passwordInput;
    EditText confirmInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_registration);

        fullNameInput = findViewById(R.id.fullName);
        phoneInput = findViewById(R.id.phone);
        emailInput = findViewById(R.id.email);
        passwordInput = findViewById(R.id.password);
        confirmInput = findViewById(R.id.confirmPwd);

        fullNameInput.addTextChangedListener(new EditTextValidations(this, fullNameInput));
        phoneInput.addTextChangedListener(new EditTextValidations(this, phoneInput));
        emailInput.addTextChangedListener(new EditTextValidations(this, emailInput));
        passwordInput.addTextChangedListener(new EditTextValidations(this, passwordInput));
        confirmInput.addTextChangedListener(new EditTextValidations(this, confirmInput));
    }

}
