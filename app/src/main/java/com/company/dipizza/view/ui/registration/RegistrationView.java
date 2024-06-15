package com.company.dipizza.view.ui.registration;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.company.dipizza.R;

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

        TextWatcher validationTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("text change", s.toString());
//                validate(s.toString(), (EditText) getCurrentFocus());
            }
        };

        fullNameInput.addTextChangedListener(validationTextWatcher);
        phoneInput.addTextChangedListener(validationTextWatcher);
        emailInput.addTextChangedListener(validationTextWatcher);
        passwordInput.addTextChangedListener(validationTextWatcher);
        confirmInput.addTextChangedListener(validationTextWatcher);


    }

}
