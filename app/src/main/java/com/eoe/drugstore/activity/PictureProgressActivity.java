package com.eoe.drugstore.activity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.eoe.drugstore.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class PictureProgressActivity extends ParentActivity {

    private SimpleDraweeView ivImageView;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_picture_progress);
    }

    @Override
    protected void setupView() {
        super.setupView();
        SimpleDraweeView ivSimpleDraw = (SimpleDraweeView) findViewById(R.id.iv_simpledraw);  //fresco框架显示图片


        ivImageView = (SimpleDraweeView) findViewById(R.id.iv_imageview);     //ImageView显示图片
        Uri uri = Uri.parse("http://www.hyhy.tech/he.jpg");
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri).setProgressiveRenderingEnabled(true).build();

        PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder().setImageRequest(request).build();
        ivSimpleDraw.setController(controller);

        ivImageView.setImageURI(Uri.parse("http://www.hyhy.tech/beauty.jpg"));

    }

    @Override
    protected void setupData() {
        super.setupData();
     /*   new Thread() {
            @Override
            public void run() {
                super.run();
                try {

                    //定义一个url对象
                    URL url = new URL("http://www.hyhy.tech/beauty.jpg");
                    //打开该URL对应的资源的输入流
                    InputStream is = url.openStream();
                    //从InputStream中解析出图片
                    bitmap = BitmapFactory.decodeStream(is);
                    //发送消息、通知UI组件显示该图片
                    handler.sendEmptyMessage(0x123);
                    is.close();
                    //再次打开URL对应的资源的输入流
                    is = url.openStream();
                    //打开手机文件对应的输出流
                    FileOutputStream os = openFileOutput("crazyit.jpg", MODE_ENABLE_WRITE_AHEAD_LOGGING);
                    byte[] buff = new byte[1024];
                    int hasRead = 0;
                    //将URL对应的资源下载到本地
                    while ((hasRead = is.read(buff)) > 0) {
                        os.write(buff, 0, hasRead);
                    }
                    is.close();
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();*/
    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //使用ImageView显示该图片
            ivImageView.setImageURI(Uri.parse("http://www.hyhy.tech/beauty.jpg"));
        }
    };
}
