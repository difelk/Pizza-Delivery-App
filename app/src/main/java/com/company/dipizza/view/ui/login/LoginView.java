package com.company.dipizza.view.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.company.dipizza.R;
import com.company.dipizza.view.ui.home.CategoryView;
import com.company.dipizza.view.ui.registration.RegistrationView;

public class LoginView extends AppCompatActivity {

    EditText usernameInput;
    EditText passwordInput;
    Button loginButton;
    TextView forgotPasswordLink;
    TextView signUpLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        usernameInput = findViewById(R.id.username);
        passwordInput = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        forgotPasswordLink = findViewById(R.id.forgotPassword);
        signUpLink = findViewById(R.id.signUpLink);

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

        usernameInput.addTextChangedListener(validationWatcher);
        passwordInput.addTextChangedListener(validationWatcher);

        checkFieldsForValidation();
    }

    public void handleLogin(View view) {
        String username = usernameInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (username.isEmpty()) {
            usernameInput.setError("Username is required");
            return;
        }

        if (password.isEmpty()) {
            passwordInput.setError("Password is required");
            return;
        }

        if (!username.isEmpty() && !password.isEmpty()){
            Intent intent = new Intent(LoginView.this, CategoryView.class);
            startActivity(intent);
        }

    }

    public void handleForgotPassword(View view) {
        Intent intent = new Intent(LoginView.this, ForgotPasswordView.class);
        startActivity(intent);
    }

    public void handleSignUp(View view) {
        Intent intent = new Intent(LoginView.this, RegistrationView.class);
        startActivity(intent);
    }

    private void checkFieldsForValidation() {
        boolean isUsernameValid = !usernameInput.getText().toString().isEmpty();
        boolean isPasswordValid = !passwordInput.getText().toString().isEmpty();
        loginButton.setEnabled(isUsernameValid && isPasswordValid);
    }
}
