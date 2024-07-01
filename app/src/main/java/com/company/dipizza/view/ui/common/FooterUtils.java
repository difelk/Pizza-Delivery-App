package com.company.dipizza.view.ui.common;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.company.dipizza.R;
import com.company.dipizza.view.ui.profile.CartView;
import com.company.dipizza.view.ui.registration.RegistrationView;
import com.company.dipizza.view.ui.welcome.WelcomeView;

public class FooterUtils {
    public static void setupFooterButtons(Context context, View rootView) {
        Button homeBtn = rootView.findViewById(R.id.directToHome);
        Button cartBtn = rootView.findViewById(R.id.directToCart);
        Button profileBtn = rootView.findViewById(R.id.directToProfile);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WelcomeView.class);
                context.startActivity(intent);
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CartView.class);
                context.startActivity(intent);
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RegistrationView.class);
                context.startActivity(intent);
            }
        });
    }
}
