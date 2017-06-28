package com.eoe.drugstore.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eoe.drugstore.utils.MLog;

/**
 * Created by Jon on 2016/3/6.
 */
public abstract class BaseFragment extends Fragment {

    public String TAG = getClass().getName();


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        MLog.i(TAG," onAttach(Context context) ");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MLog.i(TAG,"onCreateView(LayoutInflater inflater");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MLog.i(TAG,"onActivityCreated  ");
    }

    @Override
    public void onStart() {
        super.onStart();
        MLog.i(TAG,"onStart()  ");
    }

    @Override
    public void onPause() {
        super.onPause();
        MLog.i(TAG,"onPause()  ");

    }

    @Override
    public void onStop() {
        super.onStop();
        MLog.i(TAG,"onStop()  ");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MLog.i(TAG,"onDestroy()  ");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        MLog.i(TAG,"onDetach()  ");

    }
}
