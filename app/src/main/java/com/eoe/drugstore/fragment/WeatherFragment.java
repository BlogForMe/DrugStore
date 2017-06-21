package com.eoe.drugstore.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eoe.drugstore.R;
import com.eoe.drugstore.adapter.RecyclerWeatherAdapter;
import com.eoe.drugstore.bean.HeWeather;
import com.eoe.drugstore.tasks.WeatherContract;
import com.eoe.drugstore.tasks.WeatherPresenter;

import java.util.List;


/**
 * 首页
 * Created by Administrator on 2016/3/2.
 * <p>
 * https://github.com/googlesamples/android-RecyclerView
 */
public class WeatherFragment extends Fragment implements WeatherContract.View {
    WeatherContract.Presenter homePresenter;
    public final String TAG = getClass().getSimpleName();
    private RecyclerView recyclerView;
    protected RecyclerView.LayoutManager mLayoutManager;

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    protected LayoutManagerType mCurrentLayoutManagerType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, null);
        homePresenter = new WeatherPresenter(this);
        setupView(root);
        return root;
    }

    protected void setupView(View v) {
//        v.findViewById(R.id.bt_post_weather).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                homePresenter.okHttpGet();
//            }
//        });

        homePresenter.okHttpGet();
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);
    }

    private void setRecyclerViewLayoutManager(LayoutManagerType layoutMangerType) {
        int scrollPosition = 0;
        if (recyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        }
        switch (layoutMangerType) {
            case LINEAR_LAYOUT_MANAGER:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            default:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        }
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.scrollToPosition(scrollPosition);
    }

    @Override
    public void setPresenter(WeatherContract.Presenter presenter) {

    }


    @Override
    public void showWeather(HeWeather reponseHe) {
        Log.i(TAG, reponseHe.getHeWeather5().get(0).getBasic().getCity());

        List<HeWeather.HeWeather5Bean.DailyForecastBean> dailyList = reponseHe.getHeWeather5().get(0).getDaily_forecast();
        recyclerView.setAdapter(new RecyclerWeatherAdapter(dailyList));
    }
}
