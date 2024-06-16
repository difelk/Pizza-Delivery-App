package com.company.dipizza.view.ui.registration;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.company.dipizza.R;
import com.company.dipizza.utliz.EditTextValidations;

public class RegistrationView extends AppCompatActivity {

    EditText fullNameInput;
    EditText phoneInput;
    EditText emailInput;
    EditText passwordInput;
    EditText confirmInput;

    CheckBox termsAndPolicyCheck;

    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_registration);

        fullNameInput = findViewById(R.id.fullName);
        phoneInput = findViewById(R.id.phone);
        emailInput = findViewById(R.id.email);
        passwordInput = findViewById(R.id.password);
        confirmInput = findViewById(R.id.confirmPwd);
        signUpButton = findViewById(R.id.signUpButton);
        termsAndPolicyCheck = findViewById(R.id.termsAndPolicyCheck);

        TextWatcher validationWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkFieldsForValidation();
            }
        };

        fullNameInput.addTextChangedListener(new EditTextValidations(this, fullNameInput, validationWatcher));
        phoneInput.addTextChangedListener(new EditTextValidations(this, phoneInput, validationWatcher));
        emailInput.addTextChangedListener(new EditTextValidations(this, emailInput, validationWatcher));
        passwordInput.addTextChangedListener(new EditTextValidations(this, passwordInput, validationWatcher));
        confirmInput.addTextChangedListener(new EditTextValidations(this, confirmInput, validationWatcher));
        termsAndPolicyCheck.setOnCheckedChangeListener((buttonView, isChecked) -> checkFieldsForValidation());
        checkFieldsForValidation();
    }

    public void checkFieldsForValidation() {
        try{
            boolean isFullNameValid = fullNameInput.getError() == null && !fullNameInput.getText().toString().isEmpty();
            boolean isPhoneValid = phoneInput.getError() == null && !phoneInput.getText().toString().isEmpty();
            boolean isEmailValid = emailInput.getError() == null && !emailInput.getText().toString().isEmpty();
            boolean isPasswordValid = passwordInput.getError() == null && !passwordInput.getText().toString().isEmpty();
            boolean isConfirmPasswordValid = confirmInput.getError() == null && !confirmInput.getText().toString().isEmpty();
            boolean isTermsChecked = termsAndPolicyCheck.isChecked();

            Log.d("isFullNameValid ? ", String.valueOf(isFullNameValid));
            Log.d("isPhoneValid ? ", String.valueOf(isPhoneValid));
            Log.d("isEmailValid ? ", String.valueOf(isEmailValid));
            Log.d("isPasswordValid ? ", String.valueOf(isPasswordValid));
            Log.d("isConfirmPwdValid ? ", String.valueOf(isConfirmPasswordValid));

            signUpButton.setEnabled(isFullNameValid && isPhoneValid && isEmailValid && isPasswordValid && isConfirmPasswordValid && isTermsChecked);
        }catch (Exception e){
            Log.d("reg valdtin function:", e.getMessage());
        }


    }
}
