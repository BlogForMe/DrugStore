package com.eoe.drugstore.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


/**
 * Created by Administrator on 2016/4/22.
 * 自定义控件
 */
public class DrawView extends View {
    public float currentX = 40;
    public float currentY = 50;


    //创建并定义画笔
    Paint p = new Paint();

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画笔的颜色
        p.setColor(Color.RED);
        //绘制一个小圆
        canvas.drawCircle(currentX, currentY, 15, p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //修改currentX,currentY的属性
        currentX = event.getX();
        currentY = event.getY();
        invalidate();
        return true;
    }
}
