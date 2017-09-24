package com.eoe.drugstore.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eoe.drugstore.R;
import com.eoe.drugstore.bean.GankBean;
import com.eoe.drugstore.bean.NetEaseTop;
import com.eoe.drugstore.utils.ImageLoader;

import java.util.List;


/**
 * Created by Administrator on 2017/7/17.
 */

public class BeautyFragment extends Fragment implements BeautyContract.View, SwipeRefreshLayout.OnRefreshListener {
    private LinearLayoutManager mLayoutManager;
    private LayoutManagerType mCurrentLayoutManagerType;
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 60;
    protected String[] mDataset;
    private AdapterBeauty mAapter;
    private BeautyContract.Presenter hvPresenter;
    private RecyclerView mRecycleView;
    //    LoadDialog dialog;
    private SwipeRefreshLayout mSwipeRefreshWidget;


    @Override
    public void setPresenter(BeautyContract.Presenter presenter) {
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (getView() == null) {
            return;
        }
//        dialog.show();
        mSwipeRefreshWidget.setRefreshing(true);
    }

    @Override
    public void hideLoadingIndicator() {
        mSwipeRefreshWidget.setRefreshing(false);
    }

    @Override
    public void showRecycler(List<GankBean.ResultsBean> bList) {
//        dialog.dismiss();
        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mAapter.setNetDate(bList);
    }

    @Override
    public void onRefresh() {
        hvPresenter.start(true);
    }

    private enum LayoutManagerType {
        GRDI_LAYOUT_MANAGER,
        LINERY_LAYOUT_MANAGER;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_beauty, null);
        mSwipeRefreshWidget = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_refresh_widget);
        mRecycleView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
//        dialog = new LoadDialog(getActivity(), R.style.LoadDialog);

        mSwipeRefreshWidget.setOnRefreshListener(this);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mCurrentLayoutManagerType = LayoutManagerType.LINERY_LAYOUT_MANAGER;
        mAapter = new AdapterBeauty(getActivity());
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAapter);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPresenter();
        onRefresh();
    }

    protected void initPresenter() {
        hvPresenter = new BeautyPresenter(this);
    }

    /**
     * Recycler适配器
     */
    private static class AdapterBeauty extends RecyclerView.Adapter<AdapterBeauty.ViewHolder> {
        private List<GankBean.ResultsBean> bhList;
        private Context context;

        public AdapterBeauty(Context ctx) {
            this.context = ctx;
        }

        public void setNetDate(List<GankBean.ResultsBean> data) {
            this.bhList = data;
            this.notifyDataSetChanged();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            //            private final ImageView ivNews; //图片
            private final TextView tvDesc; //描述
            private final TextView tvPublishedAt;  //标题

            public ViewHolder(View v) {
                super(v);
//                ivNews = (ImageView) v.findViewById(R.id.iv_news);
                tvDesc = (TextView) v.findViewById(R.id.tv_desc);
                tvPublishedAt = (TextView) v.findViewById(R.id.tv_publishedAt);
            }

            public TextView getPublishedAt() {
                return tvPublishedAt;
            }

            public TextView getTextDescribe() {
                return tvDesc;
            }
//
//            public ImageView getImage() {
//                return ivNews;
//            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_news_gank, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            if (holder instanceof ViewHolder) {
                GankBean.ResultsBean news = bhList.get(position);
                if (news == null)
                    return;
                holder.getTextDescribe().setText(news.getDesc());
                holder.getPublishedAt().setText(news.getPublishedAt());
//                ImageLoader.showImage(context, news.getImgsrc(), holder.getImage());
            }
        }

        @Override
        public int getItemCount() {
            if (bhList == null) {
                return 0;
            } else {
                return bhList.size();
            }
        }
    }
}
