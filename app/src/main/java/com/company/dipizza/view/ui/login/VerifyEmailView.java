package com.company.dipizza.view.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.company.dipizza.R;

public class VerifyEmailView extends AppCompatActivity {

    EditText emailVerifyCodeInput;
    Button verifyEmailCodeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_verify_email_code);

        emailVerifyCodeInput = findViewById(R.id.emailVerification);
        verifyEmailCodeButton = findViewById(R.id.verifyEmailCodeButton);

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

        emailVerifyCodeInput.addTextChangedListener(validationWatcher);

        checkFieldsForValidation();
    }

    public void handleVerifyEmailByCode(View view) {
        String emailCode = emailVerifyCodeInput.getText().toString().trim();

        if (emailCode.isEmpty()) {
            emailVerifyCodeInput.setError("Verification Code is required");
        }

        if (!emailCode.isEmpty()){
            Intent intent = new Intent(VerifyEmailView.this, ResetPasswordView.class);
            startActivity(intent);
        }

    }

    private void checkFieldsForValidation() {
        boolean isEmailCodeValid = !emailVerifyCodeInput.getText().toString().isEmpty();
        verifyEmailCodeButton.setEnabled(isEmailCodeValid);
    }
}
