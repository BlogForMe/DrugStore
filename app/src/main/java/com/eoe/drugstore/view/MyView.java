package com.eoe.drugstore.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Jon on 2016/4/24.
 */
public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //把整张画布绘制成白色
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        //绘制圆形
        canvas.drawCircle(40, 40, 30, paint);
        //绘制正方形
        canvas.drawRect(10, 80, 70, 140, paint);
        //绘制矩形
        canvas.drawRect(10, 150, 70, 190, paint);
        RectF re1 = new RectF(10, 200, 70, 230);

        //绘制圆角矩形
        canvas.drawRoundRect(re1, 15, 15, paint);
        RectF rell = new RectF(10, 240, 70, 270);

        //绘制椭圆
        canvas.drawOval(rell, paint);
        //定义一个Path对象，成一个三角形
        Path path1 = new Path();
        path1.moveTo(10,340);



    }
}
