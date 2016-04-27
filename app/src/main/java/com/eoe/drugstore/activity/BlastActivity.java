package com.eoe.drugstore.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.eoe.drugstore.R;

import java.lang.reflect.Field;

public class BlastActivity extends ParentActivity {

    private MyDefineView myView;
    private AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_blast);
    }

    @Override
    protected void setupView() {
        super.setupView();
        //使用Framelayout布局管理器，它允许组件自己控制位置
        FrameLayout frame = new FrameLayout(this);
        setContentView(frame);
        //设置使用背景
        frame.setBackgroundResource(android.R.color.black);

        myView = new MyDefineView(this);
        //设置Myview用于显示blast动画
        myView.setBackgroundResource(R.drawable.frame_bomp);
        //设置MyView默认为隐藏
        myView.setVisibility(View.INVISIBLE);
        //获取动画对象
        anim = (AnimationDrawable) myView.getBackground();
        frame.addView(myView);
        frame.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //只处理按下事件（避免每次产生两个动画效果）
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //先停止动画效果
                    anim.stop();
                    float x = event.getX();
                    float y = event.getY();
                    //控制myView的显示位置
                    myView.setLocation((int) y - 40, (int) x - 20);
                    myView.setVisibility(View.VISIBLE);
                    //启动动画
                    anim.start();
                }
                return false;
            }
        });

    }

    //定义一个自定义view，该自定义view用于播放 “爆炸”效果
    class MyDefineView extends ImageView {

        public MyDefineView(Context context) {
            super(context);
        }

        //定义一个方法，该方法用于控制MyView的显示位置
        public void setLocation(int top, int left) {
            this.setFrame(left, top, left + 40, top + 40);
        }

        //重写该方法，控制如果动画播放最后一帧时，隐藏该View
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            try {
                Field filed = AnimationDrawable.class.getDeclaredField("mCurFrame");
                filed.setAccessible(true);
                //获取anim动画的当前帧
                int curFrame = filed.getInt(anim);
                //如果已经到了最后一帧
                if (curFrame == anim.getNumberOfFrames() - 1)
                    //让该view隐藏
                    setVisibility(View.INVISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
