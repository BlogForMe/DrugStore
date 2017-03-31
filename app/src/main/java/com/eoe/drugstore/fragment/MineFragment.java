package com.eoe.drugstore.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.eoe.drugstore.R;
import com.eoe.drugstore.activity.LoginActivity;


/**
 * 我
 * Created by Administrator on 2016/3/2.
 */
public class MineFragment extends ParentFragment {


    private String[] arrString = {"清除", "URL获取读取网络链接", "在代码中控制UI界面", "自定义控件", "显示Bitmap图片", "绘图"
            , "Path类", "属性动画", "Data、Type属性与Intent-filter配置", "path绘制"};
    private Intent intent;
    private SharedPreferences settings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initView(R.layout.fragment_mine, container);
    }

    @Override
    protected void setupData() {
        super.setupData();
        settings = mContext.getSharedPreferences("login", Context.MODE_PRIVATE);
        if (TextUtils.isEmpty(settings.getString("name", ""))) {
            intent = new Intent(mContext, LoginActivity.class);
            startActivity(intent);
        }
    }


    @Override
    protected void setupView(View v) {
        v.findViewById(R.id.btClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings.edit().clear().commit();
                Toast.makeText(mContext, "显示出来吧", Toast.LENGTH_SHORT).show();
            }
        });
    }


//    @Override
//    protected void setupView(View v) {
//        super.setupView(v);
//        jInstance = JumpSingleton.getInstance(mContext);
//        mListview = (ListView) v.findViewById(R.id.my_listview);
////        tvShow = (TextView) v.findViewById(R.id.tv_show);
//        ListAdapter adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, arrString);
//        mListview.setAdapter(adapter);
//        mListview.setOnItemClickListener(this);
//    }


//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        switch (position) {
//            case 1:
//                settings.edit().clear().commit();
//                Toast.makeText(mContext, "显示出来吧", Toast.LENGTH_SHORT).show();
//
//                break;
//            case 2:
//                intent = new Intent(mContext, GetUrlActivity.class);
//                startActivity(intent);
//                break;
//            case 3:
//                //代码中控制UI界面
//                break;
//            case 4:
//                //画圆
//                intent = new Intent(mContext, CodeViewActivity.class);
//                startActivity(intent);
//                break;
//            //在绘图
//            case 6:
//                JumpSingleton.getInstance(mContext).JumpNextAcitivy(CanvasActivity.class, false);
//                break;
//            case 7:
//                //path 类
//                JumpSingleton.getInstance(mContext).JumpNextAcitivy(PathTestActivity.class, false);
//                break;
//            case 8:
//                JumpSingleton.getInstance(mContext).JumpNextAcitivy(ViewAnimatorActivity.class, false);
//                break;
//            case 9:
//                //"Data、Type属性与Intent-filter配置"
//                JumpSingleton.getInstance(mContext).JumpNextAcitivy(DataTypeActivity.class, false);
//                break;
//            case 10:
//                //path绘制
//                jInstance.JumpNextAcitivy(PathTextActivity.class, false);
//                break;
//        }
//    }


}
