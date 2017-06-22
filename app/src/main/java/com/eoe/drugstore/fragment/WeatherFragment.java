package com.eoe.drugstore.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.eoe.drugstore.R;
import com.eoe.drugstore.adapter.RecyclerWeatherAdapter;
import com.eoe.drugstore.bean.HeWeather;
import com.eoe.drugstore.tasks.WeatherContract;
import com.eoe.drugstore.tasks.WeatherPresenter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 首页
 * Created by Administrator on 2016/3/2.
 * <p>
 * 官网demo
 * https://github.com/googlesamples/android-RecyclerView
 * <p>
 * blog :
 * http://blog.csdn.net/leejizhou/article/details/51179233
 */
public class WeatherFragment extends Fragment implements WeatherContract.View {
    WeatherContract.Presenter homePresenter;
    public final String TAG = getClass().getSimpleName();
    private RecyclerView recyclerView;
    protected RecyclerView.LayoutManager mLayoutManager;
    private List<HeWeather.HeWeather5Bean.DailyForecastBean> dailyList = new ArrayList<>(0);//recyclerView上的数据
    private RecyclerWeatherAdapter mRecyclerAdapter;

    private static final int SPAN_COUNT = 2, DATASET_COUNT = 60;

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
        //样式选择按钮
        v.findViewById(R.id.linear_layout_rb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRecyclerViewLayoutManager(LayoutManagerType.LINEAR_LAYOUT_MANAGER);
            }
        });
        v.findViewById(R.id.grid_layout_rb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRecyclerViewLayoutManager(LayoutManagerType.GRID_LAYOUT_MANAGER);
            }
        });

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);
        mRecyclerAdapter = new RecyclerWeatherAdapter(dailyList);
        recyclerView.setAdapter(mRecyclerAdapter);
    }

    private void setRecyclerViewLayoutManager(LayoutManagerType layoutMangerType) {
        homePresenter.okHttpGet();
        int scrollPosition = 0;
        if (recyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        }
        switch (layoutMangerType) {
            case GRID_LAYOUT_MANAGER:
                mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            case LINEAR_LAYOUT_MANAGER:
                mLayoutManager = new LinearLayoutManager(getActivity());
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
        dailyList = reponseHe.getHeWeather5().get(0).getDaily_forecast();
        mRecyclerAdapter.replaceData(dailyList);
    }
}
