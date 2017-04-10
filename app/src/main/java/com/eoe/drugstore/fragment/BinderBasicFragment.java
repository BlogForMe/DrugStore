package com.eoe.drugstore.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.eoe.drugstore.R;
import com.eoe.drugstore.service.LocalService;

/**
 * * Service绑定练习
 * https://developer.android.com/guide/components/bound-services.html#Creating
 */
public class BinderBasicFragment extends Fragment {
    boolean mBound = false;   //确保点击在 绑定之后发生的
    LocalService mService;
    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = null;
        try {
            v = inflater.inflate(R.layout.fragment_binder_basic, container, false);
        } catch (InflateException e) {
            e.printStackTrace();
        }
        mContext = getActivity();
//        initView(v);
        return v;
    }

//    private void initView(View v) {
//        v.findViewById(R.id.bt_get_number).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mBound) {
//                    int num = mService.getRandomNumber();
//                    Toast.makeText(mContext, "number: " + num, Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        if (mBound) {
//            mContext.unbindService(mConnection);
//            mBound = false;
//        }
//    }
//
//    /**
//     * Defines callbacks for service binding, passed to bindService()
//     */
//    private ServiceConnection mConnection = new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            LocalService.LocalBinder binder = (LocalService.LocalBinder) service;
//            mService = binder.getService();
//            mBound = true;
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//            mBound = false;
//        }
//    };
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        Intent intent = new Intent(mContext, LocalService.class);
//        mContext.bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
//    }

}
