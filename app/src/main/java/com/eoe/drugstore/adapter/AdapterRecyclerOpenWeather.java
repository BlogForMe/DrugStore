package com.eoe.drugstore.adapter;

import android.graphics.Path;
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

public class AdapterRecyclerOpenWeather<T extends List<OpenWeather.ListBean>> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private T openList;
    public static final int ITEM_TYPE_HEADER = 0;
    public static final int ITEM_TYPE_CONTENT = 1;


    private int mHeaderCount = 1; //头部View个数

    public AdapterRecyclerOpenWeather(T openList) {
        setList(openList);
    }

    /**
     * 更新数据
     * @param openList
     */
    public void replaceData(T openList) {
        setList(openList);
        notifyDataSetChanged();
    }

    private void setList(T dList) {
        this.openList = Preconditions.checkNotNull(dList);
    }

    @Override
    public int getItemViewType(int position) {
        if (mHeaderCount != 0 && position < mHeaderCount)
            return ITEM_TYPE_HEADER;
        else
            return ITEM_TYPE_CONTENT;
    }

    public static class HeHolder extends RecyclerView.ViewHolder {

        public HeHolder(View itemView) {
            super(itemView);
        }
    }


    //openWeather
    public static class OpenHolder extends RecyclerView.ViewHolder {
        private TextView tvDtTxt, tvWDescription, tvTemp;

        public OpenHolder(View v) {
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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_HEADER)
            return new HeHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_header, parent, false));
        else if (viewType == ITEM_TYPE_CONTENT)
            return new OpenHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_openw_item, parent, false));
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        OpenWeather.ListBean opemHolder = openList.get(position);
        if (holder instanceof OpenHolder) {
            ((OpenHolder) holder).getDtTxt().setText(opemHolder.getDt_txt());
            ((OpenHolder) holder).getTvTemp().setText(opemHolder.getWeather().get(0).getDescription());
            ((OpenHolder) holder).getTvWDescription().setText("温度 " + convertTmp(opemHolder.getMain().getTemp_min()));
        }
    }

    private double convertTmp(double temp_min) {
        return new BigDecimal(Double.toString(temp_min))
                .subtract(new BigDecimal(273.15)).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public int getItemCount() {
        return openList.size()+ITEM_TYPE_HEADER;
    }
}
