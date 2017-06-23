package com.eoe.drugstore.adapter;

import android.support.v4.util.Preconditions;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eoe.drugstore.R;
import com.eoe.drugstore.bean.OpenWeather;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Created by jon on 17-6-22.
 * OpenWeather适配器
 */

public class AdapterRecyclerOpenWeather<T extends List<OpenWeather.ListBean>> extends RecyclerView.Adapter<AdapterRecyclerOpenWeather.ViewHolder> {

    private T openList;

    public AdapterRecyclerOpenWeather(T openList) {
        setList(openList);
    }


    /**
     * 更新数据
     *
     * @param openList
     */
    public void replaceData(T openList) {
        setList(openList);
        notifyDataSetChanged();
    }

    private void setList(T dList) {
        this.openList = Preconditions.checkNotNull(dList);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvDtTxt, tvWDescription, tvTemp;

        public ViewHolder(View v) {
            super(v);
            tvDtTxt = v.findViewById(R.id.tv_dt_txt);
            tvWDescription = v.findViewById(R.id.tv_w_description);
            tvTemp = v.findViewById(R.id.tv_temp);
        }

        public TextView getDtTxt() {
            return tvDtTxt;
        }

        public TextView getTvWDescription() {
            return tvWDescription;
        }

        public TextView getTvTemp() {
            return tvTemp;
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_openw_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        OpenWeather.ListBean opemHolder = openList.get(position);
        holder.getDtTxt().setText(opemHolder.getDt_txt());
        holder.getTvTemp().setText(opemHolder.getWeather().get(0).getDescription());
        holder.getTvWDescription().setText("温度 " + convertTmp(opemHolder.getMain().getTemp_min()));
    }

    private double convertTmp(double temp_min) {
        return new BigDecimal(Double.toString(temp_min))
                .subtract(new BigDecimal(273.15)).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public int getItemCount() {
        return openList.size();
    }
}
