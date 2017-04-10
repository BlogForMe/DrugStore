package com.eoe.drugstore.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eoe.drugstore.R;
import com.eoe.drugstore.service.MessengerService;


/**
 * Created by Administrator on 2016/3/2.
 */
public class ServiceFragment extends Fragment {
    boolean mBound = false;   //确保点击在 绑定之后发生的
    private Context mContext;
    Messenger mServuce = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_community, container, false);
        mContext = getActivity();
        initView(v);
        return v;
    }

    private void initView(View v) {
        v.findViewById(R.id.bt_messsge).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayHello();
            }
        });
    }

    ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // This is called when the connection with the service has been   established, giving us the object we can use to
            // interact with the service.  We are communicating with the  service using a Messenger, so here we get a client-side
            // representation of that from the raw IBinder object.
            mServuce = new Messenger(service);
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServuce = null;
            mBound = false;
        }
    };

    public void sayHello() {
        if (!mBound) return;
        Message msg = Message.obtain(null, MessengerService.MSG_SAY_HELLO, 0, 0);
        try {
            mServuce.send(msg);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Intent intent = new Intent();
        intent.setClassName(getContext(), "com.eoe.drugstore.service.MessengerService");
        mContext.bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mBound) {
            mContext.unbindService(mConnection);
            mBound = false;
        }
    }


    //图片处理
//    jInstance.JumpNextAcitivy(PictureProgressActivity.class, false);


}
