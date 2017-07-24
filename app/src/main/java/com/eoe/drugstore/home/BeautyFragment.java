package com.eoe.drugstore.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eoe.drugstore.R;
import com.eoe.drugstore.bean.BeautyRecycler;
import com.eoe.drugstore.utils.ImageLoader;
import com.eoe.drugstore.utils.LoadDialog;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */

public class BeautyFragment extends Fragment implements BeautyContract.View {
    private LinearLayoutManager mLayoutManager;
    private LayoutManagerType mCurrentLayoutManagerType;
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 60;
    protected String[] mDataset;
    private AdapterBeauty mAapter;
    private BeautyContract.Presenter hvPresenter;
    private RecyclerView mRecycleView;
    LoadDialog dialog;


    @Override
    public void setPresenter(BeautyContract.Presenter presenter) {
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (getView() == null) {
            return;
        }
        dialog.show();
    }

    @Override
    public void showRecycler(List<BeautyRecycler.HmListBean> bList) {
        dialog.dismiss();
        Log.i("BeautyFragment", "faf" + bList.get(0).getH_describe());
        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
        mCurrentLayoutManagerType = LayoutManagerType.GRDI_LAYOUT_MANAGER;
        mAapter = new AdapterBeauty(getActivity(), bList);

        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAapter);
    }

    private enum LayoutManagerType {
        GRDI_LAYOUT_MANAGER,
        LINERY_LAYOUT_MANAGER;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_beauty, null);
        mRecycleView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        dialog = new LoadDialog(getActivity(), R.style.LoadDialog);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPresenter();
    }

    protected void initPresenter() {
        hvPresenter = new BeautyPresenter(this);
        hvPresenter.start();
    }


    /**
     * Recycler适配器
     */
    private static class AdapterBeauty extends RecyclerView.Adapter<AdapterBeauty.ViewHolder> {
        private List<BeautyRecycler.HmListBean> bhList;
        private Context ctx;

        public AdapterBeauty(Context ctx, List<BeautyRecycler.HmListBean> bList) {
            this.ctx = ctx;
            this.bhList = bList;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private TextView tvTitle;  //标题
            private TextView tvDescribe; //描述
            private ImageView ivImgHb; //图片

            public ViewHolder(View v) {
                super(v);
                tvTitle = (TextView) v.findViewById(R.id.tv_title);
                tvDescribe = (TextView) v.findViewById(R.id.tv_describe);
                ivImgHb = (ImageView) v.findViewById(R.id.iv_img_hb);
            }

            public TextView getTextTitle() {
                return tvTitle;
            }

            public TextView getTextDescribe() {
                return tvDescribe;
            }

            public ImageView getImage() {
                return ivImgHb;
            }


        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.adapter_item_beauty, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.getTextTitle().setText(bhList.get(position).getH_title());
            holder.getTextDescribe().setText(bhList.get(position).getH_describe());
            ImageLoader.showImage(ctx, bhList.get(position).getH_imgurl(), holder.getImage());
        }

        @Override
        public int getItemCount() {
            return bhList.size();
        }
    }
}
