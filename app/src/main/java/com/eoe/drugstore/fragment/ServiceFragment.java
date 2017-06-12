package com.eoe.drugstore.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eoe.drugstore.R;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.annotations.NonNull;


/**
 * Created by Administrator on 2016/3/2.
 */
public class ServiceFragment extends Fragment {
    private static final String TAG = "RAndroidSamples";
    Flowable<String> flowable = Flowable.create(new FlowableOnSubscribe<String>() {
        @Override
        public void subscribe(@NonNull FlowableEmitter<String> e) throws Exception {
            e.onNext("hellow RxJava2");
            e.onComplete();
        }
    }, BackpressureStrategy.BUFFER);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_community, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
