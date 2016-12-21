package com.eoe.drugstore.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.eoe.drugstore.R;
import com.eoe.drugstore.activity.BitmapTest;
import com.eoe.drugstore.activity.CanvasActivity;
import com.eoe.drugstore.activity.CodeViewActivity;
import com.eoe.drugstore.activity.DataTypeActivity;
import com.eoe.drugstore.activity.GetUrlActivity;
import com.eoe.drugstore.activity.MultiThreadClientActivity;
import com.eoe.drugstore.activity.PathTestActivity;
import com.eoe.drugstore.activity.PathTextActivity;
import com.eoe.drugstore.activity.ViewAnimatorActivity;
import com.eoe.drugstore.utils.JumpSingleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


/**
 * 我的818
 * Created by Administrator on 2016/3/2.
 */
public class MineFragment extends ParentFragment implements AdapterView.OnItemClickListener {


    private TextView tvShow;
    private ListView mListview;
    private String[] arrString = {"简单例子", "聊天Socket", "URL获取读取网络链接", "在代码中控制UI界面", "自定义控件", "显示Bitmap图片", "绘图"
            , "Path类", "属性动画", "Data、Type属性与Intent-filter配置", "path绘制"};
    private Intent intent;
    private JumpSingleton jInstance;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initView(R.layout.fragment_mine, container);
    }

    @Override
    protected void setupData() {
        super.setupData();
        //socket简单事例
//        simpleSocket();
    }

    @Override
    protected void setupView(View v) {
        super.setupView(v);
        jInstance = JumpSingleton.getInstance(mContext);
        mListview = (ListView) v.findViewById(R.id.my_listview);
//        tvShow = (TextView) v.findViewById(R.id.tv_show);
        ListAdapter adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, arrString);
        mListview.setAdapter(adapter);
        mListview.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 1:
//                Toast.makeText(mContext, "显示出来吧", Toast.LENGTH_SHORT).show();
                intent = new Intent(mContext, MultiThreadClientActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(mContext, GetUrlActivity.class);
                startActivity(intent);
                break;
            case 3:
                //代码中控制UI界面
                break;
            case 4:
                intent = new Intent(mContext, CodeViewActivity.class);
                startActivity(intent);
                break;
            case 5:
                //显示bitmap
                JumpSingleton.getInstance(mContext).JumpNextAcitivy(BitmapTest.class, false);
                break;
            //在绘图
            case 6:
                JumpSingleton.getInstance(mContext).JumpNextAcitivy(CanvasActivity.class, false);
                break;
            case 7:
                //path 类
                JumpSingleton.getInstance(mContext).JumpNextAcitivy(PathTestActivity.class, false);
                break;
            case 8:
                JumpSingleton.getInstance(mContext).JumpNextAcitivy(ViewAnimatorActivity.class, false);
                break;
            case 9:
                //"Data、Type属性与Intent-filter配置"
                JumpSingleton.getInstance(mContext).JumpNextAcitivy(DataTypeActivity.class, false);
                break;
            case 10:
                //path绘制
                jInstance.JumpNextAcitivy(PathTextActivity.class, false);
                break;
        }
    }


    //socket简单事例
    private void simpleSocket() {
        new Thread() {
            @Override
            public void run() {
                try {
                    //建立连接到远程服务器的Socket
                    Socket socket = new Socket("192.168.1.102", 30000);
                    //将Socket对应的输入流包装成BufferedReader
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    //进行普通的I/O操作
                    String line = br.readLine();
                    tvShow.setText("来自服务器的数据" + line);
                    br.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }
}
