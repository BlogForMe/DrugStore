package com.eoe.drugstore.fragment;


import android.Manifest;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
public class ServiceFragment extends Fragment {


    private VideoView vView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_community, container, false);
        initView(v);
        return v;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case WRITE_EXTERNAL_STORAGE_REQUEST_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    //permission denied
                }
                return;
            }


        }
    }

    private void initView(View v) {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//                            当某条权限之前已经请求过，并且用户已经拒绝了该权限时，shouldShowRequestPermissionRationale ()方法返回的是true
            } else {
//                            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
            }
        }


//        String vUrl = Environment.getExternalStorageDirectory().getPath() + "/VID_20170529_205108.mp4";
////        Uri uri = Uri.parse(vUrl);
//        vView = (VideoView) v.findViewById(R.id.sf_view);
//        vView.setMediaController(new MediaController(getActivity()));
//        vView.setVideoPath(vUrl);
//        vView.setOnCompletionListener(new MyPlayerOnCompletionListener());
//
//        v.findViewById(R.id.bt_vedio).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                vView.start();
//            }
//        });
    }

    class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {

        }
    }


}
