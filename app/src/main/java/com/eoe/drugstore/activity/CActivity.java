package com.eoe.drugstore.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.eoe.drugstore.R;

public class CActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_c);
        Button btClick = (Button) findViewById(R.id.bt_click);
        btClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jInstalce.JumpNextAcitivy(BActivity.class, false);
            }
        });
    }
}
