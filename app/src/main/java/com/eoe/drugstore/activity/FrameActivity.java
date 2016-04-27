package com.eoe.drugstore.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.eoe.drugstore.R;

public class FrameActivity extends ParentActivity {

    private TextView tvStart, tvStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_frame);
    }

    @Override
    protected void setupView() {
        super.setupView();
        tvStart = (TextView) findViewById(R.id.t_start);
        tvStop = (TextView) findViewById(R.id.tv_stop);
        View ivAnim = (View) findViewById(R.id.iv_anim);
        final AnimationDrawable anim = (AnimationDrawable) ivAnim.getBackground();

        tvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim.start();
            }

        });


        tvStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim.stop();
            }
        });
    }


}
