package com.eoe.drugstore.fragment;


import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eoe.drugstore.MyApplication;
import com.eoe.drugstore.R;
import com.eoe.drugstore.exoplayer2.EventLogger;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Util;

import static com.eoe.drugstore.utils.Constants.WRITE_EXTERNAL_STORAGE_REQUEST_CODE;

/**
 * Created by Administrator on 2016/3/2.
 * Video play
 */
public class VideoFragment extends Fragment  {
    public static final DefaultBandwidthMeter BANDWIDTH_METER = new DefaultBandwidthMeter();
    private SimpleExoPlayer player;
    String vUrl = "http://covertness.qiniudn.com/android_zaixianyingyinbofangqi_test_baseline.mp4";
    //    String vUrl = "https://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4";
    private String url = Environment.getExternalStorageDirectory().getPath() + "/xmy60" + "/0037-37.flv";

    private SimpleExoPlayerView simpleExoPlayerView;
    Uri mp4VideoUri = Uri.parse(url);
    String extenstion;
    private DataSource.Factory mediaDataSourceFactory;
    private Handler mainHandler;
    private EventLogger eventLogger;
    private int resumeWindow;
    private long resumePosition;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_community, container, false);
//        permissionCheck();
        mediaDataSourceFactory = buildDataSourceFactory(true);
        simpleExoPlayerView = (SimpleExoPlayerView) v.findViewById(R.id.player_view);
        mainHandler = new Handler();
        clearResumePosition();
        return v;
    }



    private void clearResumePosition() {
        resumeWindow = C.INDEX_UNSET;
        resumePosition = C.INDEX_UNSET;
    }


    @Override
    public void onStart() {
        super.onStart();
        if (Util.SDK_INT > 23) {
            initializePlayer();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (Util.SDK_INT <= 23 || player == null) {
            initializePlayer();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (Util.SDK_INT <= 23) {
            releasePlayer();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (Util.SDK_INT > 23) {
            releasePlayer();
        }
    }


    private void initializePlayer() {
        TrackSelection.Factory videoTrackSectionFactory =
                new AdaptiveTrackSelection.Factory(BANDWIDTH_METER);

        DefaultTrackSelector trackSelector = new DefaultTrackSelector(videoTrackSectionFactory);
        LoadControl loadControl = new DefaultLoadControl();
        DataSource.Factory dataSourceFactory = buildDataSourceFactory(true);
        //2.创建ExoPlayer
        MediaSource videoSource = new ExtractorMediaSource(mp4VideoUri,
                dataSourceFactory, new DefaultExtractorsFactory(), null, null);

        player = ExoPlayerFactory.newSimpleInstance(getActivity(), trackSelector, loadControl);
//        eventLogger = new EventLogger(trackSelector);
        simpleExoPlayerView.setPlayer(player);
        player.prepare(videoSource);
    }


    /**
     * Returns a new DataSource factory.
     *
     * @param useBandwidthMeter
     * @return
     */
    private DataSource.Factory buildDataSourceFactory(boolean useBandwidthMeter) {
        return ((MyApplication) getActivity().getApplication())
                .buildDataSourceFactory(useBandwidthMeter ? BANDWIDTH_METER : null);
    }


    private void releasePlayer() {
        player.release();
    }


    private void hideSystemUi() {
        simpleExoPlayerView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    private void permissionCheck() {
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

    private void updateResumePosition() {
        resumeWindow = player.getCurrentWindowIndex();
        resumePosition = player.isCurrentWindowSeekable() ? Math.max(0, player.getCurrentPosition())
                : C.TIME_UNSET;
    }

}
