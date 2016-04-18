package com.eoe.drugstore.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eoe.drugstore.R;
import com.eoe.drugstore.activity.FragmentExerciseActivity;
import com.eoe.drugstore.utils.Logger;


/**
 * 首页
 * Created by Administrator on 2016/3/2.
 */
public class HomeFragment extends ParentFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Logger.d("onCreateView---");
        return initView(R.layout.fragment_home, container);
    }

    @Override
    protected void setupView(View v) {

        super.setupView(v);
        TextView tvClickme = (TextView) v.findViewById(R.id.clickme);
        tvClickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FragmentExerciseActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d("onCreate---");
    }

    @Override
    public void onStart() {
        super.onStart();
        Logger.d("onStart---");

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Logger.d("onAttach---");

    }



    @Override
    public void onPause() {
        super.onPause();
        Logger.d("onPause---");

    }

    @Override
    public void onStop() {
        super.onStop();
        Logger.d("onStop---");

    }

    @Override
    public void onResume() {
        super.onResume();
        Logger.d("onResume---");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Logger.d("onDestroyView---");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Logger.d("onDetach---");

    }
}
