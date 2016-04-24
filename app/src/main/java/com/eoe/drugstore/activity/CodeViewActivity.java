package com.eoe.drugstore.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.eoe.drugstore.R;
import com.eoe.drugstore.view.DrawView;

/**
 * 2.1.3代码中控制UI界面
 */
public class CodeViewActivity extends AppCompatActivity {
    //当第一次创建该Activity时回调该方法
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        //创建一个线性布局管理器
//        LinearLayout layout = new LinearLayout(this);
//        //设置该Activity显示layout
//        setContentView(layout);
//        //创建一个Textview
//        final TextView show = new TextView(this);
//        //创建一个按钮
//        Button bn = new Button(this);
//        bn.setText("确认");
//        bn.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        //向容器内添加Textview
//        layout.addView(show);
//        layout.addView(bn);
//        bn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                show.setText("hello" + new Date());
//            }
//        });
        setContentView(R.layout.activity_code_view);
        LinearLayout lRoot = (LinearLayout) findViewById(R.id.root);

        final DrawView draw = new DrawView(this);
        draw.setMinimumHeight(300);
        draw.setMinimumWidth(500);
        //设置自定义控件的宽高
        lRoot.addView(draw);


    }
}
