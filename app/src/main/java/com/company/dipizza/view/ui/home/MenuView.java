package com.company.dipizza.view.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.company.dipizza.R;
import com.company.dipizza.model.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuView extends AppCompatActivity {

    int categoryID;
    String categoryName;

    TextView headerTitle;

    LinearLayout menuItemWrap;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu);
        try {
            Intent menuIntent = getIntent();
            categoryID = menuIntent.getIntExtra("categoryID", -1);
            categoryName = menuIntent.getStringExtra("category");

            headerTitle = findViewById(R.id.menuTitle);
            headerTitle.setText(categoryName);

            List<MenuItem> categories = new ArrayList<>();

            Map<String, Double> sizeToPriceMap1 = new HashMap<>();
            sizeToPriceMap1.put("L", 100.0);
            sizeToPriceMap1.put("M", 100.0);
            sizeToPriceMap1.put("S", 100.0);

            Map<String, Double> sizeToPriceMap2 = new HashMap<>();
            sizeToPriceMap2.put("L", 100.0);
            sizeToPriceMap2.put("M", 100.0);
            sizeToPriceMap2.put("S", 100.0);

            Map<String, Double> sizeToPriceMap3 = new HashMap<>();
            sizeToPriceMap3.put("L", 100.0);
            sizeToPriceMap3.put("M", 100.0);
            sizeToPriceMap3.put("S", 100.0);

            Map<String, Double> sizeToPriceMap4 = new HashMap<>();
            sizeToPriceMap4.put("L", 100.0);
            sizeToPriceMap4.put("M", 100.0);
            sizeToPriceMap4.put("S", 100.0);

            categories.add(new MenuItem(1, "Menu item 1", "","pizza", null, null,sizeToPriceMap1));
            categories.add(new MenuItem(2, "Menu item  2", "","pizza",null,null,sizeToPriceMap2));
            categories.add(new MenuItem(3, "Menu item  3", "","pizza",null,null,sizeToPriceMap3));
            categories.add(new MenuItem(4, "Menu item  4","", "pizza",null,null,sizeToPriceMap4));

            menuItemWrap = findViewById(R.id.menuLayout);

            for (MenuItem item : categories) {
                Log.d("M item: ", String.valueOf(item.toString()));
            }



        } catch (Exception e) {
            Log.d("ERROR IN MENU: ", e.getMessage());
        }






    }
}
