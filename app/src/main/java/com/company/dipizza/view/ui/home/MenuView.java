package com.company.dipizza.view.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.company.dipizza.R;

public class MenuView extends AppCompatActivity {

    int categoryID;
    String categoryName;

    TextView headerTitle;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu);
        try {
            Intent menuIntent = getIntent();
            categoryID = Integer.parseInt(menuIntent.getStringExtra("categoryID"));
            categoryName = menuIntent.getStringExtra("category");

            headerTitle = findViewById(R.id.menuTitle);
            headerTitle.setText(categoryName);
        } catch (Exception e) {
            Log.d("ERROR IN MENU: ", e.getMessage());
        }


    }
}
