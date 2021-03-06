package com.eoe.drugstore.adapter;

import android.support.v4.util.Preconditions;
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
 * 和风天气  数据适配
 */

public class AdapterRecyclerWeather extends RecyclerView.Adapter<AdapterRecyclerWeather.ViewHolder> {
    List<HeWeather.HeWeather5Bean.DailyForecastBean> dailyList;

    public AdapterRecyclerWeather(List<HeWeather.HeWeather5Bean.DailyForecastBean> dailyList) {
        setList(dailyList);
    }

    /**
     * 更新数据
     *
     * @param dList
     */
    public void replaceData(List<HeWeather.HeWeather5Bean.DailyForecastBean> dList) {
        setList(dList);
        notifyDataSetChanged();
    }

    private void setList(List<HeWeather.HeWeather5Bean.DailyForecastBean> dList) {
        this.dailyList = Preconditions.checkNotNull(dList);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private  TextView textData, tv_txtd, tv_txtn, tv_tmp;

        public ViewHolder(View v) {
            super(v);
            textData = (TextView) v.findViewById(R.id.tv_date);
            tv_txtd = (TextView) v.findViewById(R.id.tv_txt_d);
            tv_txtn = (TextView) v.findViewById(R.id.tv_txt_n);
            tv_tmp = (TextView) v.findViewById(R.id.tv_tmp);
        }

        public TextView getTextData() {
            return textData;
        }

        public TextView getTextd() {
            return tv_txtd;
        }

        public TextView getTextn() {
            return tv_txtn;
        }

        public TextView getTexttmp() {
            return tv_tmp;
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
        viewHolder.getTextData().setText(dailyList.get(position).getDate());
        viewHolder.getTextd().setText(dailyList.get(position).getCond().getTxt_d());
        viewHolder.getTextn().setText(dailyList.get(position).getCond().getTxt_n());
        viewHolder.getTexttmp().setText(dailyList.get(position).getTmp().getMin() + " ~~~ " + dailyList.get(position).getTmp().getMax());
    }

    @Override
    public int getItemCount() {
        return dailyList.size();
    }


}
