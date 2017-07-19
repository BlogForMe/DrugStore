package com.eoe.drugstore.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eoe.drugstore.R;

/**
 * Created by Administrator on 2017/7/17.
 */

public class BeautyFragment extends Fragment {
    private LinearLayoutManager mLayoutManager;
    private LayoutManagerType mCurrentLayoutManagerType;
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 60;
    protected String[] mDataset;
    private AdapterBeauty mAapter;

    private enum LayoutManagerType {
        GRDI_LAYOUT_MANAGER,
        LINERY_LAYOUT_MANAGER;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initDataset();

        View rootView = inflater.inflate(R.layout.fragment_beauty, null);
        RecyclerView mRecycleView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
        mCurrentLayoutManagerType = LayoutManagerType.GRDI_LAYOUT_MANAGER;
        mAapter = new AdapterBeauty(mDataset);
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAapter);
        return rootView;
    }

    private void initDataset() {
        mDataset = new String[DATASET_COUNT];
        for (int i = 0; i < DATASET_COUNT; i++) {
            mDataset[i] = "This is element #" + i;
        }
    }


   private static class AdapterBeauty extends RecyclerView.Adapter<AdapterBeauty.ViewHolder> {
        private static final String TAG = "AdapterBeauty";
        private String[] mDataset;


        class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView textView;

            public ViewHolder(View v) {
                super(v);
                textView = (TextView) v.findViewById(R.id.textView);
            }

            public TextView getTextView() {
                return textView;
            }

        }

        public AdapterBeauty(String[] dataset) {
            mDataset = dataset;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.adapter_item_beauty, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.getTextView().setText(mDataset[position]);
        }

        @Override
        public int getItemCount() {
            return mDataset.length;
        }
    }
}
