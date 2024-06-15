package com.company.dipizza.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.company.dipizza.R;
import com.company.dipizza.view.ui.registration.RegistrationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent reg = new Intent(this, RegistrationView.class);
        startActivity(reg);

    }
}
