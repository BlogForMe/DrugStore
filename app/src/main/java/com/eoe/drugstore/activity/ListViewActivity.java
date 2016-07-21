package com.eoe.drugstore.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eoe.drugstore.R;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    protected final ArrayList<String> list = new ArrayList<String>();
    private ArrayList<String> alist;

    public static final String TAG = "ListViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
//        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.main_layout);
//        View buttonLayout = LayoutInflater.from(this).inflate(R.layout.button_layout, null);
////        mainLayout.addView(buttonLayout);
//        ViewParent viewParent = mainLayout.getParent();
//        Log.d(TAG, "the parent of mainLayout is  " + viewParent);

        ListView lvList = (ListView) findViewById(R.id.lv_list);
        alist = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            alist.add(String.valueOf(i));
        }
        ListViewAdapter listAdapter = new ListViewAdapter();
        lvList.setAdapter(listAdapter);
    }

    class ListViewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return alist.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView mTextView = new TextView(ListViewActivity.this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//            lp.setMargins(200,0,0, 0);
            mTextView.setPadding(0,200,0,0);
            mTextView.setText(alist.get(position));
            return mTextView;
        }
    }

}
