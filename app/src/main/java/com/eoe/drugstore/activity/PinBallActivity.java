package com.eoe.drugstore.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.eoe.drugstore.R;

import java.util.Random;

public class PinBallActivity extends ParentActivity {

    private boolean isLose;  //游戏是否结束的旗标
    Random random = new Random();


    private int ballX = random.nextInt(200) + 20; // ballX和ballY的坐标
    private int ballY = random.nextInt(10) + 20;

    private int racketY;  //球拍的垂直位置
    private int racketX = random.nextInt(200); //代表球拍的水平位置
    private int RACKET_WIDTH = 70, RACKET_HEGHT = 20; //球拍的宽度和高度
    private final int BALL_SIZE = 12; //小球的大小
    private int tableWidth, tableHeight; //获取屏幕的宽和高

    private double xyRate = random.nextDouble() - 0.5;//返回一个-0.5 ~0.5的的比率用于控制小球的运行方向
    private int ySpeed = 10;
    private int xSpeed = (int) (ySpeed * xyRate * 2);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉窗口标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init(R.layout.activity_pin_ball);
    }

    @Override
    protected void setupView() {
        super.setupView();
        //获取窗口管理器
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        //获取屏幕的宽和高
        tableWidth = metrics.widthPixels;
        tableHeight = metrics.heightPixels;
        racketY = tableHeight - 80;

        //创建GameView组件
        final GameView gameView = new GameView(this);
        setContentView(gameView);

//        final Handler handler = new Handler() {
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//                if (msg.what == 0x123)
//                    gameView.invalidate();
//            }
//        };
//
//
//        gameView.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                //获取由哪个键触发的事件
//                switch (event.getKeyCode()) {
//                    //控制挡板左移
//                    case KeyEvent.KEYCODE_A:
//                        if (racketX > 0)
//                            racketX -= 10;
//                        break;
//                    //控制挡板右移
//                    case KeyEvent.KEYCODE_D:
//                        if (racketX < tableHeight - RACKET_WIDTH)
//                            racketX += 10;
//                        break;
//                }
//                //通知gameView组件重绘
//                gameView.invalidate();
//                return true;
//            }
//        });
//
//
//        final Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                //如果小球碰到左边边框
//                if (ballX <= 0 || ballX >= tableWidth - BALL_SIZE)
//                    xSpeed = -xSpeed;
//                //如果球拍高度超出了球拍的位置，且横向不在球拍的范围之内，游戏结束
//                if (ballY >= racketY - BALL_SIZE && (ballX < racketX || ballX > racketX + RACKET_WIDTH)) {
//                    timer.cancel();
//                    //设置邮箱是否结束的旗标为true
//                    isLose = true;
//                } else if (ballY <= 0 || (ballY >= racketY - BALL_SIZE && ballX > racketX && ballX <= racketX + RACKET_WIDTH)) {
//                    ySpeed = -ySpeed;
//                }
//                //小球坐标增加
//                ballY += ySpeed;
//                ballX += xSpeed;
//                //发送消息通知系统重绘组件
//                handler.sendEmptyMessage(0x123);
//
//            }
//        }, 0, 100);


    }


    class GameView extends View {
        Paint paint = new Paint();

        public GameView(Context context) {
            super(context);
            setFocusable(true);
        }
        //重写View的onDraw方法，实现绘画

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            paint.setStyle(Paint.Style.FILL);
            //设置去锯齿
            paint.setAntiAlias(true);
            //如果游戏已经结束
            if (isLose) {
                paint.setColor(Color.RED);
                paint.setTextSize(40);
                canvas.drawText("游戏已结束", 50, 200, paint);
            } else {
                //设置颜色，并绘制小球
                paint.setColor(Color.rgb(240, 240, 80));
                canvas.drawCircle(ballX, ballY, BALL_SIZE, paint);

                //设置颜色，并绘制球拍
                paint.setColor(Color.rgb(80, 80, 200));
                canvas.drawRect(racketX, racketY, racketX + RACKET_WIDTH, racketY + RACKET_HEGHT, paint);
            }
        }
    }


}
