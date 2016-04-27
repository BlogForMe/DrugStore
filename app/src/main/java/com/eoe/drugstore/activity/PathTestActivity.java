package com.eoe.drugstore.activity;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.os.Bundle;
import android.view.View;

import com.eoe.drugstore.R;

public class PathTestActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_path_test);
    }

    class MyView extends View {
        float phase;
        PathEffect[] effects = new PathEffect[7];
        private Paint paint;
        Path path;

        public MyView(Context context) {
            super(context);
            paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(4);
            //创建并初始化Path
            path = new Path();
        }


    }
}
