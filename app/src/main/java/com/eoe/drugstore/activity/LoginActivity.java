package com.eoe.drugstore.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.eoe.drugstore.R;

public class LoginActivity extends AppCompatActivity {

    private EditText etUser;
    private SharedPreferences settings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settings.edit().clear().commit();
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        etUser = (EditText) findViewById(R.id.et_user);
        settings = getSharedPreferences("login", Context.MODE_PRIVATE);

    }

    public void btLogin(View v) {
        String etUs = etUser.getText().toString();
        if (isCorrect(etUs)) {
            settings.edit().putString("name", "jon").commit();
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "用户名错误", Toast.LENGTH_SHORT).show();
        }
    }


   public boolean isCorrect(String etUs) {
        if ("jon".equals(etUs)) {
            return true;
        }
        return false;
    }


}
