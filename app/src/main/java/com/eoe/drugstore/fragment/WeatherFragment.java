package com.eoe.drugstore.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eoe.drugstore.R;
import com.eoe.drugstore.bean.HeWeather;
import com.eoe.drugstore.tasks.WeatherContract;
import com.eoe.drugstore.tasks.WeatherPresenter;


/**
 * 首页
 * Created by Administrator on 2016/3/2.
 *
 * https://github.com/googlesamples/android-RecyclerView
 */
public class WeatherFragment extends Fragment implements WeatherContract.View {
    WeatherContract.Presenter homePresenter;
    public final String TAG = getClass().getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homePresenter = new WeatherPresenter(this);
        View root = inflater.inflate(R.layout.fragment_home, null);
        root.findViewById(R.id.bt_post_weather).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homePresenter.okHttpGet();
            }
        });
        return root;
    }


    @Override
    public void setPresenter(WeatherContract.Presenter presenter) {

    }


    @Override
    public void showWeather(HeWeather reponseHe) {
        Log.i(TAG, reponseHe.getHeWeather5().get(0).getBasic().getCity());
    }
}
