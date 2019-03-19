package com.iteso.test;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.iteso.test.beans.ItemProducts;

public class Activity_Detail extends AppCompatActivity {

    public EditText name;
    public EditText store;
    public EditText location;
    public EditText phone;
    public ImageView image;
    ItemProducts itemProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemProducts = getIntent().getParcelableExtra("ITEM");
        setContentView(R.layout.activity__detail);
        name = (EditText) findViewById(R.id.activity_detail_name);
        store = (EditText) findViewById(R.id.activity_detail_store);
        location = (EditText) findViewById(R.id.activity_detail_location);
        phone = (EditText) findViewById(R.id.activity_detail_phone);
        image = (ImageView) findViewById(R.id.activity_detail_image);

        name.setText(itemProducts.getTitle());
        store.setText(itemProducts.getStore());
        location.setText(itemProducts.getLocation());
        phone.setText(itemProducts.getPhone());
        switch (itemProducts.getImage()){
            case 0:
                image.setImageResource(R.drawable.alienware);
                break;
            case 1:
                image.setImageResource(R.drawable.mac);
                break;
            case 2:
                image.setImageResource(R.drawable.micro);
                break;
            case 3:
                image.setImageResource(R.drawable.pillows);
                break;
            case 4:
                image.setImageResource(R.drawable.refrigerator);
                break;
            case 5:
                image.setImageResource(R.drawable.sheets);
                break;
            default:
                image.setImageResource(R.drawable.alienware);
                break;
        }
    }

    public void salvar(View v){

            itemProducts.setTitle(name.getText().toString());
            itemProducts.setStore(store.getText().toString());
            itemProducts.setLocation(location.getText().toString());
            itemProducts.setPhone(phone.getText().toString());
            Intent intent = new Intent();
            intent.putExtra("ITEM", itemProducts);
            setResult(1, intent);
            finish();
        }

}
