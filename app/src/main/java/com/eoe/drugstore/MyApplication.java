package com.eoe.drugstore;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;

/**
 * Created by Jon on 2016/3/6.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this).setProgressiveJpegConfig(new SimpleProgressiveJpegConfig()).build();
        Fresco.initialize(this,config);
    }
}
