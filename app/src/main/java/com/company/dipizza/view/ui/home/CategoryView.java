package com.company.dipizza.view.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.company.dipizza.R;
import com.company.dipizza.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryView extends AppCompatActivity {

    private ScrollView scrollViewLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_category);

        scrollViewLayout = findViewById(R.id.categoryScrollWrap);
        displayCategories();
    }

    public void displayCategories() {
        List<Category> categories = new ArrayList<>();

        categories.add(new Category(1, "Category 1", R.drawable.pizza_img));
        categories.add(new Category(2, "Category 2", R.drawable.pizza_img));
        categories.add(new Category(3, "Category 3", R.drawable.pizza_img));
        categories.add(new Category(4, "Category 4", R.drawable.pizza_img));

        LinearLayout categoryLayout = findViewById(R.id.categoryLayout);

        LinearLayout rowLayout = null;
        for (int i = 0; i < categories.size(); i++) {
            if (i % 2 == 0) {
                rowLayout = new LinearLayout(this);
                rowLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                ));
                rowLayout.setOrientation(LinearLayout.HORIZONTAL);
                categoryLayout.addView(rowLayout);
            }

            LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
                    0,
                    getResources().getDimensionPixelSize(R.dimen.button_height),
                    1.0f
            );
            buttonParams.setMargins(20, 20, 20, 20);

            FrameLayout buttonLayout = new FrameLayout(this);
            buttonLayout.setLayoutParams(buttonParams);
            buttonLayout.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
            buttonLayout.setPadding(8, 8, 8, 8);

            final Category category = categories.get(i);
            buttonLayout.setOnClickListener(v -> {
                Log.d("CategoryView", "Category clicked: ID=" + category.getId() +
                        ", Name=" + category.getCategoryName());
                Intent directToMenu = new Intent(this, MenuView.class);
                directToMenu.putExtra("category", category.getCategoryName());
                directToMenu.putExtra("categoryID", category.getId());
                startActivity(directToMenu);
            });

            ImageView imageView = new ImageView(this);
            FrameLayout.LayoutParams imageParams = new FrameLayout.LayoutParams(
                    getResources().getDimensionPixelSize(R.dimen.image_width),
                    getResources().getDimensionPixelSize(R.dimen.image_height)
            );
            imageParams.gravity = Gravity.CENTER;
            imageView.setLayoutParams(imageParams);
            imageView.setImageResource(category.getCategoryIcon());

            TextView textView = new TextView(this);
            FrameLayout.LayoutParams textParams = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            textParams.gravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;
            textParams.setMargins(0, 12, 0, 0);
            textView.setLayoutParams(textParams);
            textView.setPadding(8, 8, 8, 8);
            textView.setTextSize(16);
            textView.setText(category.getCategoryName());

            buttonLayout.addView(imageView);
            buttonLayout.addView(textView);

            rowLayout.addView(buttonLayout);
        }
    }




}