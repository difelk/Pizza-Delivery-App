package com.company.dipizza.view.ui.home;

import android.os.Bundle;
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

        LinearLayout categoryLayout = findViewById(R.id.categoryLayout);

        for (Category category : categories) {
            LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
                    getResources().getDimensionPixelSize(R.dimen.button_width),
                    getResources().getDimensionPixelSize(R.dimen.button_height)
            );
            buttonParams.setMargins(0, 40, getResources().getDimensionPixelSize(R.dimen.button_margin), 0);

            FrameLayout buttonLayout = new FrameLayout(this);
            buttonLayout.setLayoutParams(buttonParams);
            buttonLayout.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white)); // Set background color to white

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
            textParams.setMargins(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.text_margin));
            textView.setLayoutParams(textParams);
            textView.setPadding(8, 8, 8, 8);
            textView.setText(category.getCategoryName());

            buttonLayout.addView(imageView);
            buttonLayout.addView(textView);

            categoryLayout.addView(buttonLayout);
        }
    }


}