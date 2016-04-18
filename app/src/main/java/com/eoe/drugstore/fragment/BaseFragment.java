package com.eoe.drugstore.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eoe.drugstore.bean.BaseBean;
import com.lidroid.xutils.ViewUtils;

/**
 * Created by Jon on 2016/3/6.
 */
public abstract class BaseFragment extends Fragment {

    protected Context mContext;
    private LayoutInflater inflate;

    protected View initView(int resId, ViewGroup parent) {
        mContext = this.getActivity();
        inflate = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mContainerView = inflate.inflate(resId, parent, false);
        ViewUtils.inject(this, mContainerView);

        setupView(mContainerView);
        setupData();
        sendRequest();
        return mContainerView;
    }

    protected abstract void setupView(View mContainerView);

    protected abstract void setupData();

    protected  void sendRequest(){

    }

    protected  void setupRequest(int requestId, int dataType,
                                         BaseBean result){

    }


}
