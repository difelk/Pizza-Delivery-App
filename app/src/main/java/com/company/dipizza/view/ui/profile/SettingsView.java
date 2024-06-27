package com.company.dipizza.view.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.company.dipizza.R;
import com.company.dipizza.view.ui.login.ForgotPasswordView;

public class SettingsView extends AppCompatActivity {

    private LinearLayout accountOptions;
    private LinearLayout moreOptions;
    private LinearLayout storeLocationOptions;
    private LinearLayout languageOptions;
    private LinearLayout currencyOptions;
    private TextView selectedLanguage;
    private TextView selectedCurrency;
    private TextView selectedStoreLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_settings);

        accountOptions = findViewById(R.id.accountOptions);
        moreOptions = findViewById(R.id.moreOptions);
        storeLocationOptions = findViewById(R.id.storeLocationOptions);
        languageOptions = findViewById(R.id.languageOptions);
        currencyOptions = findViewById(R.id.currencyOptions);
        selectedLanguage = findViewById(R.id.selectedLanguage);
        selectedCurrency = findViewById(R.id.selectedCurrency);
        selectedStoreLocation = findViewById(R.id.selectedStoreLocation);
    }

    public void handleAccountOptions(View view) {
        if (accountOptions.getVisibility() == View.VISIBLE) {
            accountOptions.setVisibility(View.GONE);
        } else {
            accountOptions.setVisibility(View.VISIBLE);
        }
    }

    public void handleMoreOptions(View view) {
        if (moreOptions.getVisibility() == View.VISIBLE) {
            moreOptions.setVisibility(View.GONE);
        } else {
            moreOptions.setVisibility(View.VISIBLE);
        }
    }

    public void handleRedirectToChangePassword(View view) {
        Intent intent = new Intent(SettingsView.this, ForgotPasswordView.class);
        startActivity(intent);
    }

    public void handleRedirectToPayment(View view) {
//        Intent intent = new Intent(SettingsView.this, );
//        startActivity(intent);
    }

    public void handleRedirectToOrderHistory(View view) {
//        Intent intent = new Intent(SettingsView.this, );
//        startActivity(intent);
    }

    public void handleRedirectToDeliveryAddress(View view) {
//        Intent intent = new Intent(SettingsView.this, );
//        startActivity(intent);
    }

    public void handleRedirectToNotifications(View view) {
//        Intent intent = new Intent(SettingsView.this, );
//        startActivity(intent);
    }



    public void handleStoreLocationOptions(View view) {
        if (storeLocationOptions.getVisibility() == View.GONE) {
            storeLocationOptions.setVisibility(View.VISIBLE);
            languageOptions.setVisibility(View.GONE);
            currencyOptions.setVisibility(View.GONE);
        } else {
            storeLocationOptions.setVisibility(View.GONE);
        }

    }

    public void handleStoreLocationSelection(View view) {
        TextView selectedLocationTxtView = (TextView) view;
        selectedStoreLocation.setText(selectedLocationTxtView.getText().toString());
        selectedStoreLocation.setVisibility(View.VISIBLE);
        storeLocationOptions.setVisibility(View.GONE);
    }

    public void handleLanguageOptions(View view) {
        if (languageOptions.getVisibility() == View.GONE) {
            languageOptions.setVisibility(View.VISIBLE);
            storeLocationOptions.setVisibility(View.GONE);
            currencyOptions.setVisibility(View.GONE);
        } else {
            languageOptions.setVisibility(View.GONE);
        }

    }

    public void handleLanguageSelection(View view) {
        TextView selectedLanguageTxtView = (TextView) view;
        selectedLanguage.setText(selectedLanguageTxtView.getText().toString());
        selectedLanguage.setVisibility(View.VISIBLE);
        languageOptions.setVisibility(View.GONE);
    }

    public void handleCurrencyOptions(View view) {
        if (currencyOptions.getVisibility() == View.GONE) {
            currencyOptions.setVisibility(View.VISIBLE);
            storeLocationOptions.setVisibility(View.GONE);
            languageOptions.setVisibility(View.GONE);
        } else {
            currencyOptions.setVisibility(View.GONE);
        }

    }

    public void handleCurrencySelection(View view) {
        TextView selectedCurrencyTxtView = (TextView) view;
        selectedCurrency.setText(selectedCurrencyTxtView.getText().toString());
        selectedCurrency.setVisibility(View.VISIBLE);
        currencyOptions.setVisibility(View.GONE);
    }
}
