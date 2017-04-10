package com.eoe.drugstore.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eoe.drugstore.R;
import com.eoe.drugstore.service.BindService;

/**
 * Created by Jon on 2016/4/17.
 * 练习构建Fragment
 */
public class ArticleFragment extends BaseFragment implements View.OnClickListener {
    String TAG = "---ArticleFragment -----";
    private Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initView(R.layout.fragment_article, null);
    }

    @Override
    protected void setupView(View v) {
        TextView tvStart = (TextView) v.findViewById(R.id.tv_start);
        TextView tvStop = (TextView) v.findViewById(R.id.tv_stop);
        TextView tvBind = (TextView) v.findViewById(R.id.tv_bind);
        TextView tvUnbing = (TextView) v.findViewById(R.id.tv_unbing);
        TextView tvGetBind = (TextView) v.findViewById(R.id.tv_getbing);
//        final Intent intent = new Intent(getActivity(), FirstService.class);

        TextView tvIntentService = (TextView) v.findViewById(R.id.tv_intent_service);


         intent = new Intent(getActivity(), BindService.class);
        tvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startService(intent);
            }
        });
        tvStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().stopService(intent);

            }
        });
        tvBind.setOnClickListener(this);
        tvUnbing.setOnClickListener(this);
        tvGetBind.setOnClickListener(this);
        tvIntentService.setOnClickListener(this);

    }

    @Override
    protected void setupData() {
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.tv_intent_service:
//                Intent intent1 = new Intent(getActivity(), MyIntentService.class);
//                getActivity().startActivity(intent1);
//                break;
//        }
    }


//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Log.i(TAG,"onCreate---");
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        Log.i(TAG,"onStart---");
//
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        Log.i(TAG,"onAttach---");
//
//    }
//
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        Log.i(TAG,"onPause---");
//
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        Log.i(TAG,"onStop---");
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        Log.i(TAG,"onResume---");
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        Log.i(TAG,"onDestroyView---");
//
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        Log.i(TAG,"onDetach---");
//
//    }
}
