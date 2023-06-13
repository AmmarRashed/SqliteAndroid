package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listViewProducts;
    MyDBHandler dbHandler;
    EditText edit_text_name, edit_text_price;
    Button button_add, button_find, button_delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_text_name = findViewById(R.id.edit_text_name);
        edit_text_price = findViewById(R.id.edit_text_price);
        button_add = findViewById(R.id.button_add);
        button_find = findViewById(R.id.button_find);
        button_delete = findViewById(R.id.button_delete);
        listViewProducts = findViewById(R.id.listViewProducts);
        dbHandler = new MyDBHandler(this);

        displayAllProducts();

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit_text_name.getText().toString();
                int price = Integer.parseInt(edit_text_price.getText().toString());
                Product p = new Product(name, price);
                dbHandler.addProduct(p);
                displayAllProducts();
            }
        });

        button_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO
                // remember to call the displaySomeProducts method
            }
        });

        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO
                // Remember to update the listview
            }
        });
    }

    public void displayAllProducts() {
        List<Product> products = dbHandler.getAllProducts();
        displaySomeProducts(products);
    }

    public void displaySomeProducts(List<Product> products){
        ProductList adapter = new ProductList(this, products);
        listViewProducts.setAdapter(adapter);
    }
}