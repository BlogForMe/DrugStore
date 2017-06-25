package com.eoe.drugstore.fragment;


import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import com.eoe.drugstore.R;

/**
 * Created by Administrator on 2016/3/2.
 */
public class ServiceFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_community, container, false);
//        getActivity().requestWindowFeature(Window.FEATURE_NO_TITLE);  //去掉 title
//        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); //设置全屏
//        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        initView(v);
        return v;
    }

    private void initView(View v) {
        String vUrl = Environment.getExternalStorageDirectory().getPath() + "/VID_20170529_205108.mp4";
//        Uri uri = Uri.parse(vUrl);
        final VideoView vView = (VideoView) v.findViewById(R.id.sf_view);
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
