package com.eoe.drugstore.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.eoe.drugstore.R;
import com.eoe.drugstore.utils.DataUtil;
import com.eoe.drugstore.utils.JsonParser;

import java.util.HashMap;

public class JsonAcitvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_acitvity);
        String s = DataUtil.readLocalJson(this, "data.json");

        HashMap<String, Object> myJson = (HashMap<String, Object>) JsonParser.decode(s);

    }
}
