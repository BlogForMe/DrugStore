package com.eoe.drugstore.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.eoe.drugstore.R;

public class BActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_b);
        Button btClick = (Button) findViewById(R.id.bt_click);
        btClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jInstalce.JumpNextAcitivy(CActivity.class, false);
            }
        });



            Log.d("BActivity", "onCreate---");
    }




    @Override
    protected void onStart() {
        super.onStart();
        Log.d("BActivity", "onStart---");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("BActivity", "onResume---");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("AActivity", "onPause---");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("BActivity", "onDestroy---");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("BActivity", "onStop---");
    }
}
