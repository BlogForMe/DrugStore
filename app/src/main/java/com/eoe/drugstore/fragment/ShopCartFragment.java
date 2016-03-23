package com.eoe.drugstore.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.eoe.drugstore.R;
import com.eoe.drugstore.adapter.ExpandListAdapter;
import com.eoe.drugstore.bean.BaseBean;
import com.eoe.drugstore.bean.ShopCartBean;
import com.eoe.drugstore.httpnet.NetUtil;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;


/**
 * 购物车
 * Created by Administrator on 2016/3/2.
 */
public class ShopCartFragment extends ParentFragment {
    @ViewInject(R.id.elistview)
    private ExpandableListView eListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return initView(R.layout.fragment_shop, null);
    }


    @Override
    protected void setupView(View mContainerView) {
        super.setupView(mContainerView);
        eListView.setGroupIndicator(null);
        eListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(mContext, "父类", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        eListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(mContext, "子类", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        NetUtil.getcartRequest(mContext, "13917674553", "3c98265f02b13caf5744d0919936844c", 1002, httpOps);
    }

    @Override
    protected void setupData() {
        super.setupData();
    }

    @Override
    protected void setupRequest(int requestId, int dataType, BaseBean result) {
        super.setupRequest(requestId, dataType, result);
        List<BaseBean.ResultBean> resultList = result.getResult();
        List<ShopCartBean.ResultdataBean> resultDataList = resultList.get(0).getResultdata();

        eListView.setAdapter(new ExpandListAdapter(mContext,
                resultDataList));
        for (int i = 0; i < resultDataList.size(); i++) {
            eListView.expandGroup(i);
        }
    }

}

