package com.eoe.drugstore.activity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.eoe.drugstore.R;

public class ViewAnimatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animator);
    }

    public void rotateAnimRun(View view) {
        ObjectAnimator.ofFloat(view, "rotationX", 0.0F, 360.0F).setDuration(500).start();
    }
}
