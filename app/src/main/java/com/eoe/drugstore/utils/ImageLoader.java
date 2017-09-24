package com.eoe.drugstore.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


/**
 * Created by Administrator on 2017/7/21.
 * Image Loader
 */

public class ImageLoader {

    public static void showImage(Context context, String imgUrl, ImageView imageView) {
//        String imageUrl = Constants.ip + imgUrl;
        Glide.with(context).load(imgUrl).into(imageView);
    }


}
