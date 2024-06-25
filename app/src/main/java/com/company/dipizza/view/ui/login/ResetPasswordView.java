package com.company.dipizza.view.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.company.dipizza.R;
import com.company.dipizza.view.ui.home.CategoryView;

public class ResetPasswordView extends AppCompatActivity {

    EditText newPasswordInput;
    EditText confirmNewPasswordInput;
    Button updatePasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_reset_password);

        newPasswordInput = findViewById(R.id.newPassword);
        confirmNewPasswordInput = findViewById(R.id.confirmPassword);
        updatePasswordButton = findViewById(R.id.updatePasswordButton);

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

        newPasswordInput.addTextChangedListener(validationWatcher);
        confirmNewPasswordInput.addTextChangedListener(validationWatcher);

        checkFieldsForValidation();
    }

    public void handleResetPassword(View view) {
        String newPassword = newPasswordInput.getText().toString().trim();
        String confirmNewPassword = confirmNewPasswordInput.getText().toString().trim();

        if (newPassword.isEmpty()) {
            newPasswordInput.setError("New password is required");
            return;
        }

        if (confirmNewPassword.isEmpty()) {
            confirmNewPasswordInput.setError("Confirm new password");
            return;
        }

        if (!newPassword.equals(confirmNewPassword)) {
            confirmNewPasswordInput.setError("Passwords do not match");
            return;
        }
        if (!newPassword.isEmpty() && !confirmNewPassword.isEmpty() && newPassword.equals(confirmNewPassword)){
            Intent intent = new Intent(ResetPasswordView.this, LoginView.class);
            startActivity(intent);
        }
    }

    private void checkFieldsForValidation() {
        boolean isNewPasswordValid = !newPasswordInput.getText().toString().isEmpty();
        boolean isConfirmPasswordValid = !confirmNewPasswordInput.getText().toString().isEmpty();
        updatePasswordButton.setEnabled(isNewPasswordValid && isConfirmPasswordValid);
    }
}
