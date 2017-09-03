package com.eoe.drugstore.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.eoe.drugstore.R;
import com.eoe.drugstore.net.OkHttpHelper;
import com.eoe.drugstore.utils.DownloadUtil;

import java.util.concurrent.ExecutorService;


/**
 * 购物车
 * Created by Administrator on 2016/3/2.
 */
public class ShopCartFragment extends BaseFragment {
    private final String url = "https://github.com/BlogForMe/JAVA/raw/master/后弦-海口.mp3";
    private final String url1 = "https://github.com/BlogForMe/JAVA/raw/master/李健-沧海轻舟.flac";
    private final String url2 = "https://github.com/BlogForMe/JAVA/raw/master/杨沛宜-歌唱祖国 (国旗入场).mp3";

    private ProgressBar progressR, progressG, progressB;
    private ExecutorService exec;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_shop, null);
        progressR = (ProgressBar)v.findViewById(R.id.progress_r);
        progressB = (ProgressBar)v.findViewById(R.id.progress_b);
        progressG = (ProgressBar)v.findViewById(R.id.progress_g);

        v.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DownloadUtil.getInstance().download(url, "MP3", new DownloadUtil.OnDownloadListener() {
                    @Override
                    public void onDownloadSuccess() {

                    }

                    @Override
                    public void onDownloading(int progress) {
//                        Log.d(TAG, "进度 " + progress);
                        progressG.setProgress(progress);

                    }

                    @Override
                    public void onDownloadFailed() {

                    }
                });
                DownloadUtil.getInstance().download(url1, "MP3", new DownloadUtil.OnDownloadListener() {
                    @Override
                    public void onDownloadSuccess() {

                    }

                    @Override
                    public void onDownloading(int progress) {
//                        Log.d(TAG, "进度 " + progress);
                        progressB.setProgress(progress);

                    }

                    @Override
                    public void onDownloadFailed() {

                    }
                });
                DownloadUtil.getInstance().download(url2, "MP3", new DownloadUtil.OnDownloadListener() {
                    @Override
                    public void onDownloadSuccess() {

                    }

                    @Override
                    public void onDownloading(int progress) {
//                        Log.d(TAG, "进度 " + progress);
                        progressR.setProgress(progress);

                    }

                    @Override
                    public void onDownloadFailed() {

                    }
                });
            }
        });
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}

