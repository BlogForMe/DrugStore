package com.eoe.drugstore.activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.eoe.drugstore.R;
import com.eoe.drugstore.utils.DataUtil;
import com.eoe.drugstore.utils.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JsonAcitvity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_acitvity);
        String s = DataUtil.readLocalJson(this, "data.json");

        HashMap<String, Object> myJson = (HashMap<String, Object>) JsonParser.decode(s);


        final SharedPreferences sp = getSharedPreferences("MySharePreferecne", MODE_PRIVATE);
        sp.edit().putString("json", s).commit();
        findViewById(R.id.tv_want).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fjf = sp.getString("json", "");
                HashMap<String, Object> myJson = (HashMap<String, Object>) JsonParser.decode(fjf);
                HashMap<String, Object> dataMap = (HashMap<String, Object>) myJson.get("data");
                HashMap<String, Object> FastTastList = (HashMap<String, Object>) dataMap.get("FastTaskList");
                ArrayList<Map<String, Object>> PointList = (ArrayList<Map<String, Object>>) FastTastList.get("PointList");

                Boolean flag = isPackage(PointList);
                Log.i("JsonAcitvity---", flag.toString());


            }
        });


    }

    private Boolean isPackage(ArrayList<Map<String, Object>> PointList) {
        for (Map<String, Object> map : PointList)
            if ("com.syqy.wecash".equals(map.get("package_name"))) {
                return true;
            }
        return false;
    }
}
