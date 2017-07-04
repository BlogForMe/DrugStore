package com.eoe.drugstore.fragment;


import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eoe.drugstore.MyApplication;
import com.eoe.drugstore.R;
import com.eoe.drugstore.exoplayer2.EventLogger;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import static com.eoe.drugstore.utils.Constants.WRITE_EXTERNAL_STORAGE_REQUEST_CODE;

/**
 * Created by Administrator on 2016/3/2.
 * Video play
 */
public class VideoFragment extends BaseFragment {
    public static final DefaultBandwidthMeter BANDWIDTH_METER = new DefaultBandwidthMeter();
    private SimpleExoPlayer player;
    //    String vUrl = Environment.getExternalStorageDirectory().getPath()  /*+"/mv.mp4"*/ + "/xmy.flv";
    String vUrl = "http://107.173.10.164/Demo/evedio/XMYP37.flv";
    private SimpleExoPlayerView simpleExoPlayerView;
    //    Uri mp4VideoUri = Uri.parse("https://storage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%20Hangin'%20with%20the%20Google%20Search%20Bar.mp4");
    Uri mp4VideoUri = Uri.parse(vUrl);
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


    DefaultTrackSelector trackSelector = new DefaultTrackSelector();

    private void initializePlayer() {
        TrackSelection.Factory adaptiveTrackSectionFactory =
                new AdaptiveTrackSelection.Factory(BANDWIDTH_METER);

        //2.创建ExoPlayer
        player = ExoPlayerFactory.newSimpleInstance(
                new DefaultRenderersFactory(getActivity()),
                new DefaultTrackSelector(adaptiveTrackSectionFactory),
                new DefaultLoadControl());
//        eventLogger = new EventLogger(trackSelector);
        simpleExoPlayerView.setPlayer(player);
        player.setPlayWhenReady(true);
//        MediaSource mediaSource = new ExtractorMediaSource(mp4VideoUri, mediaDataSourceFactory, new DefaultExtractorsFactory(),
//                mainHandler, eventLogger);
        MediaSource mediaSource = buildMediaSource(mp4VideoUri);

//        boolean haveResumePosition = resumePosition != C.INDEX_UNSET;
//        if (haveResumePosition) {
//            player.seekTo(resumeWindow, resumePosition);
//        }
        player.prepare(mediaSource, false, false);
    }

    private MediaSource buildMediaSource(Uri uri) {
        DataSource.Factory dataSourceFactory = new DefaultHttpDataSourceFactory("ua", BANDWIDTH_METER);
        DashChunkSource.Factory dashChunkSourceFactory = new DefaultDashChunkSource.Factory(dataSourceFactory);
        return new DashMediaSource(uri, dataSourceFactory, dashChunkSourceFactory, null, null);
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
