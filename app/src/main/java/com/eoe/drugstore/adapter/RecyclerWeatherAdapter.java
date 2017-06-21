package com.eoe.drugstore.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eoe.drugstore.R;
import com.eoe.drugstore.bean.HeWeather;
import com.eoe.drugstore.utils.MLog;

import java.util.List;


/**
 * Created by Administrator on 2017/6/21.
 */

public class RecyclerWeatherAdapter extends RecyclerView.Adapter<RecyclerWeatherAdapter.ViewHolder> {
    List<HeWeather.HeWeather5Bean.DailyForecastBean> dailyList;

    public RecyclerWeatherAdapter(List<HeWeather.HeWeather5Bean.DailyForecastBean> dailyList) {
        this.dailyList = dailyList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.tv_text);
        }

        public TextView getTextView() {
            return textView;
        }

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_weatheritem, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        MLog.d("RecyclerWeatherAdapter", "Element " + position + "set.");
        viewHolder.getTextView().setText(dailyList.get(position).getCond().getTxt_n());
    }

    @Override
    public int getItemCount() {
        return dailyList.size();
    }


}
