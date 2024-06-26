package com.company.dipizza.view.ui.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.company.dipizza.R;
import com.company.dipizza.view.ui.home.CategoryView;
import com.company.dipizza.view.ui.login.LoginView;
import com.company.dipizza.view.ui.registration.RegistrationView;

public class WelcomeView extends AppCompatActivity {

    Button directsignUpButton;
    Button directGuestUserButton;
    Button directSignInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_welcome);

        directSignInButton = findViewById(R.id.loginBtn);
        directSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent directToLogIn = new Intent(WelcomeView.this, LoginView.class);
                startActivity(directToLogIn);
            }
        });


        directsignUpButton = findViewById(R.id.signUpDirect);
        directsignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent directToSignUp = new Intent(WelcomeView.this, RegistrationView.class);
                startActivity(directToSignUp);
            }
        });

        directGuestUserButton = findViewById(R.id.guestUserBtn);

        directGuestUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent directToCategory = new Intent(WelcomeView.this, CategoryView.class);
                startActivity(directToCategory);
            }
        });

    }
}
