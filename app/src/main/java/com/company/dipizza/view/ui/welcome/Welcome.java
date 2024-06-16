package com.company.dipizza.view.ui.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.company.dipizza.R;
import com.company.dipizza.view.ui.registration.RegistrationView;

public class Welcome extends AppCompatActivity {

    Button directsignUpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_welcome);



        directsignUpButton = findViewById(R.id.signUpDirect);
        directsignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent directToSignUp = new Intent(Welcome.this, RegistrationView.class);
                startActivity(directToSignUp);
            }
        });

    }
}
