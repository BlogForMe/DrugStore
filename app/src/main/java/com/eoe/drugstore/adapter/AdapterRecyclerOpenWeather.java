package com.eoe.drugstore.adapter;

import android.support.v4.util.Preconditions;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.eoe.drugstore.bean.OpenWeather;

import java.util.List;

/**
 * Created by jon on 17-6-22.
 */

public class AdapterRecyclerOpenWeather<T> extends RecyclerView.Adapter<AdapterRecyclerOpenWeather.ViewHolder> {

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

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
