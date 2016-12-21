package com.eoe.drugstore.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/12/8.
 */

public class RoundImageView extends View {
    public RoundImageView(Context context) {
        super(context);
    }

    public RoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        RectF rectF = new RectF(60, 80, 500, 600);
        Paint p = new Paint();
        p.setColor(Color.YELLOW);
        canvas.drawRoundRect(rectF, 20, 20, p);
//        canvas.drawRect(rectF, p);
    }
}
