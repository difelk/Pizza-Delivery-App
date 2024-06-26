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

public class ForgotPasswordView extends AppCompatActivity {

    EditText emailInput;
    Button verifyEmaildButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_forgot_password);

        emailInput = findViewById(R.id.email);
        verifyEmaildButton = findViewById(R.id.verifyEmailButton);

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

        emailInput.addTextChangedListener(validationWatcher);

        checkFieldsForValidation();
    }

    public void handleVerifyEmail(View view) {
        String email = emailInput.getText().toString().trim();

        if (email.isEmpty()) {
            emailInput.setError("Email is required");
        }

        if (!email.isEmpty()){
            Intent intent = new Intent(ForgotPasswordView.this, VerifyEmailView.class);
            startActivity(intent);
        }

    }

    private void checkFieldsForValidation() {
        boolean isEmailValid = !emailInput.getText().toString().isEmpty();
        verifyEmaildButton.setEnabled(isEmailValid);
    }
}
