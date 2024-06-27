package com.company.dipizza.view.ui.common;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.company.dipizza.R;
import com.company.dipizza.view.ui.profile.CartView;
import com.company.dipizza.view.ui.registration.RegistrationView;
import com.company.dipizza.view.ui.welcome.WelcomeView;

public class FooterNavigationView extends AppCompatActivity {

    Button cartBtn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_footer_navigation);

        cartBtn = findViewById(R.id.directToCart);
        Log.d("footer loaded? ", "true");

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("clicked card ? ", "true");
                Intent directToSignUp = new Intent(FooterNavigationView.this, CartView.class);
                startActivity(directToSignUp);
            }
        });

    }


}
