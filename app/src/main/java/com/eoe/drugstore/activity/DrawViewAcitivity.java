package com.eoe.drugstore.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.eoe.drugstore.R;
import com.eoe.drugstore.utils.JumpSingleton;

public class DrawViewAcitivity extends ParentActivity {
    String[] arrayView = {"绘制游戏动画","弹球游戏"};
    private ListView lvList;
    private JumpSingleton jumpSingleton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_draw_view);
    }

    @Override
    protected void setupView() {
        super.setupView();
        jumpSingleton = JumpSingleton.getInstance(mContext);
        lvList = (ListView) findViewById(R.id.lv_list);
    }

    @Override
    protected void setupData() {
        super.setupData();
        lvList.setAdapter(new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, arrayView));
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        //疯狂讲义第七章
                        jumpSingleton.JumpNextAcitivy(HandDrawAcitivy.class, false);
                        break;
                    case 1:
                        //弹球游戏
                        jumpSingleton.JumpNextAcitivy(PinBallActivity.class,false);

                }

            }
        });
    }

}
