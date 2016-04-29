package com.eoe.drugstore.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
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
        path1.moveTo(10, 340);
        path1.lineTo(70, 340);
        path1.lineTo(40, 290);
        path1.close();

        //根据path进行绘制，
        canvas.drawPath(path1, paint);

        //定义一个path对象 封闭成五角形
        Path path2 = new Path();
        path2.moveTo(26, 360);
        path2.moveTo(54, 360);
        path2.moveTo(70, 392);
        path2.moveTo(40, 420);
        path2.moveTo(10, 392);
        path2.close();
        //根据path进行绘制 绘制五角形
        canvas.drawPath(path2, paint);

        //设置填充风格后绘制
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        canvas.drawCircle(120, 40, 30, paint);

        //为Panit设置渐变器
        LinearGradient mShader = new LinearGradient(0, 0, 40, 60, new int[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW}, null, Shader.TileMode.REPEAT);
        paint.setShader(mShader);
        //设置阴影
        paint.setShadowLayer(45, 10, 10, Color.GRAY);
        //绘制圆形
        canvas.drawCircle(200, 40, 30, paint);
        //绘制正方形
        canvas.drawRect(170, 80, 230, 140, paint);
        //绘制矩形
        canvas.drawRect(170, 150, 230, 190, paint);
        RectF re3 = new RectF(170, 200, 230, 230);

        //绘制圆角矩形
        canvas.drawRoundRect(re3, 15, 15, paint);
        RectF re31 = new RectF(170, 200, 230, 270);
        //绘制椭圆
        canvas.drawOval(re3, paint);
        Path path5 = new Path();
        path5.moveTo(170, 340);
        path5.moveTo(230, 340);
        path5.moveTo(200, 290);
        path5.close();

    }
}
