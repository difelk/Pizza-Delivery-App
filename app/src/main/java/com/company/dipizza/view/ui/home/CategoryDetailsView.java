package com.company.dipizza.view.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.company.dipizza.R;

public class CategoryDetailsView extends AppCompatActivity {

    private ImageView categoryImage;
    private TextView pizzaName;
    private TextView ingredients;
    private TextView quantity;
    private Button decreaseQty;
    private Button increaseQty;
    private Button sizeSmall;
    private Button sizeMedium;
    private Button sizeLarge;
    private TextView price;

    private int currentQty = 0;
    private String currentSize = "M";
    private double defaultPrice = 1000.0;
    private double sizePrice = 0.0;
    private double totalPrice = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_category_details);

        categoryImage = findViewById(R.id.categoryImage);
        pizzaName = findViewById(R.id.pizzaName);
        ingredients = findViewById(R.id.ingredients);
        quantity = findViewById(R.id.quantity);
        decreaseQty = findViewById(R.id.decreaseQty);
        increaseQty = findViewById(R.id.increaseQty);
        sizeSmall = findViewById(R.id.sizeSmall);
        sizeMedium = findViewById(R.id.sizeMedium);
        sizeLarge = findViewById(R.id.sizeLarge);
        price = findViewById(R.id.price);

        pizzaName.setText("Margherita");
        ingredients.setText("Tomato, Mozzarella, Basil");
        sizePrice = defaultPrice * 1.30;
//        totalPrice = sizePrice * currentQty;
//        price.setText(String.format("Rs. %.2f", totalPrice));
        handlePrice();
    }

    public void handleDecreaseQty(View view) {
        if (currentQty > 0) {
            currentQty--;
            quantity.setText(String.valueOf(currentQty));
//            totalPrice = sizePrice * currentQty;
//            price.setText(String.format("Rs. %.2f", totalPrice));
            handlePrice();
        }
    }

    public void handleIncreaseQty(View view) {
        if (currentQty < 9) {
            currentQty++;
            quantity.setText(String.valueOf(currentQty));
//            totalPrice = sizePrice * currentQty;
//            price.setText(String.format("Rs. %.2f", totalPrice));
            handlePrice();
        }
    }

    public void handleSizeSmall(View view) {
        currentSize = "S";
        sizePrice = defaultPrice;
//        totalPrice = sizePrice * currentQty;
//        price.setText(String.format("Rs. %.2f", totalPrice));
        handlePrice();
    }

    public void handleSizeMedium(View view) {
        currentSize = "M";
        sizePrice = defaultPrice * 1.30;
//        totalPrice = sizePrice * currentQty;
//        price.setText(String.format("Rs. %.2f", totalPrice));
        handlePrice();
    }

    public void handleSizeLarge(View view) {
        currentSize = "L";
        sizePrice = (defaultPrice * 1.30) * 1.40;
//        totalPrice = sizePrice * currentQty;
//        price.setText(String.format("Rs. %.2f", totalPrice));
        handlePrice();
    }

    public void handlePrice(){
        totalPrice = sizePrice * currentQty;
        price.setText(String.format("Rs. %.2f", totalPrice));
    }

}
