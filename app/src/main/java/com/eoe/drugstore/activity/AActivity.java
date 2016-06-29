package com.eoe.drugstore.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.eoe.drugstore.R;

public class AActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_a);
        Button btClick = (Button) findViewById(R.id.bt_click);
        btClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jInstalce.JumpNextAcitivy(BActivity.class, false);
            }
        });


        ViewGroup.LayoutParams size = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


        Log.d("AActivity", "OnCreate---");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("AActivity", "onStart---");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("AActivity", "onResume---");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("AActivity", "onPause---");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("AActivity", "onDestroy---");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("AActivity", "onStop---");
    }
}
