package com.eoe.drugstore.activity;

import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.eoe.drugstore.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Jon on 2016/4/24.
 * 使用Bitmap显示图片
 */
public class BitmapTest extends ParentActivity {
    private ImageView ivImageView;
    private AssetManager assets;
    private String[] images;
    private Button btNext;
    int currentImg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_bitmap_test);
    }

    @Override
    protected void setupView() {
        super.setupView();
        ivImageView = (ImageView) findViewById(R.id.iv_imageview);
        btNext = (Button) findViewById(R.id.bt_next);

    }

    @Override
    protected void setupData() {
        super.setupData();
        try {
            assets = getAssets();
            //获取/assets目录下所有文件
            images = assets.list("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取bn按钮
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //如果发生数组越界
                if (currentImg > images.length)
                    currentImg = 0;
                //找到下一个图片文件
                while (!images[currentImg].endsWith(".png") && !images[currentImg].endsWith(".jpg") && !images[currentImg].endsWith(".gif")) {
                    currentImg++;
                    //如果已经发生数组越界
                    if (currentImg >= images.length)
                        currentImg = 0;
                }


                InputStream assetFile = null;
                try {
                    //打开指定资源对应的输入流
                    assetFile = assets.open(images[currentImg++]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                BitmapDrawable bitmapDrawable = (BitmapDrawable) ivImageView.getDrawable();

                //如果图片还未回收，先强制回收图片
                if (bitmapDrawable != null && !bitmapDrawable.getBitmap().isRecycled())
                    bitmapDrawable.getBitmap().recycle();

                //改变ImageView显示的图片
                ivImageView.setImageBitmap(BitmapFactory.decodeStream(assetFile));
            }
        });


    }

}
