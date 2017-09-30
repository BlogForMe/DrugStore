package com.eoe.drugstore.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.eoe.drugstore.R;

public class FisrtActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fisrt);
    }

    public void goBack(View v) {
        Intent intent = new Intent();
        intent.putExtra("text","mytext");
        setResult(1,intent);//requestCode=1
        finish();

    }
}
