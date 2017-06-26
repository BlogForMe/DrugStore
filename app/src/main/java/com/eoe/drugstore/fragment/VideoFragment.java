package com.eoe.drugstore.fragment;


import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.eoe.drugstore.R;


import static com.eoe.drugstore.utils.Constants.WRITE_EXTERNAL_STORAGE_REQUEST_CODE;

/**
 * Created by Administrator on 2016/3/2.
 */
public class VideoFragment extends Fragment {


    private VideoView vView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_community, container, false);
        initView(v);
        initcheck();
        return v;
    }

    private void initcheck() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//                            当某条权限之前已经请求过，并且用户已经拒绝了该权限时，shouldShowRequestPermissionRationale ()方法返回的是true
            } else {
//                            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
            }
        }
    }

    private void initView(View v) {
        final String vUrl = Environment.getExternalStoragePublicDirectory(Environment.MEDIA_MOUNTED_READ_ONLY).getPath() + "/VID_20170529_205108.mp4";

        vView = (VideoView) v.findViewById(R.id.sf_view);
        vView.setMediaController(new MediaController(getActivity()));
        vView.setVideoPath(vUrl);
        vView.setOnCompletionListener(new MyPlayerOnCompletionListener());
        v.findViewById(R.id.bt_vedio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vView.start();
            }

        });
    }

    class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {

        }
    }


}
