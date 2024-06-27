package com.company.dipizza.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.company.dipizza.R;
import com.company.dipizza.view.ui.profile.SettingsView;
import com.company.dipizza.view.ui.welcome.WelcomeView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent welcome = new Intent(this, WelcomeView.class);
//        Intent reg = new Intent(this, RegistrationView.class);
        Intent settings = new Intent(this, SettingsView.class);
        startActivity(settings);

    }

}
