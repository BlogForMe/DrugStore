package com.eoe.drugstore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eoe.drugstore.R;
import com.eoe.drugstore.bean.ShopCartBean;

import java.util.List;


/**
 * Created by Jon on 2016/3/18.
 */
public class ExpandListAdapter extends BaseExpandableListAdapter {
    Context context;
    List<ShopCartBean.ResultdataBean> resultDataList;
    private LayoutInflater inflate;

    public ExpandListAdapter(Context context,
                             List<ShopCartBean.ResultdataBean> resultDataList) {
        this.context = context;
        this.resultDataList = resultDataList;
        inflate = LayoutInflater.from(context);

    }

    public Object getGroup(int groupPosition) {
        return resultDataList.get(groupPosition);
    }


    public int getGroupCount() {
        return resultDataList.size();
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        ViewHolder1 viewHolder1;
        if (null == convertView) {
            convertView = inflate.inflate(R.layout.adapter_item_header, null);

            viewHolder1 = new ViewHolder1();
            viewHolder1.tvHeader = (TextView) convertView
                    .findViewById(R.id.tv_header);
            viewHolder1.llShopNext = (LinearLayout) convertView
                    .findViewById(R.id.ll_shop_next);
            viewHolder1.ll_total = (LinearLayout) convertView
                    .findViewById(R.id.ll_total);
            viewHolder1.tvGetCoubon = (TextView) convertView
                    .findViewById(R.id.tv_get_coubon);
            convertView.setTag(viewHolder1);
        } else {
            viewHolder1 = (ViewHolder1) convertView.getTag();
        }
        viewHolder1.tvHeader
                .setText(resultDataList.get(groupPosition).getShopname());
        //
        // viewHolder1.ll_total.setSelected(sc.get(position));
        // viewHolder1.ll_total.setTag(position);
        // ArrayList<Map<String, Object>> lotteryinfoList =
        // (ArrayList<Map<String, Object>>) contentMap
        // .get("lotteryinfo");
        // if (lotteryinfoList.isEmpty()) {
        // viewHolder1.tvGetCoubon.setVisibility(View.GONE);
        // } else {
        // viewHolder1.tvGetCoubon.setVisibility(View.VISIBLE);
        // }
        // viewHolder1.ll_total.setOnClickListener(selectClick);
        // viewHolder1.tvGetCoubon.setTag(position);
        // viewHolder1.tvGetCoubon.setOnClickListener(selectClick);
        // viewHolder1.llShopNext.setOnClickListener(selectClick);
        // viewHolder1.llShopNext.setTag(contentMap);
        return convertView;
    }

    public int getChildrenCount(int groupPosition) {
        return resultDataList.get(groupPosition).getDruginfo().size();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return resultDataList.get(groupPosition).getDruginfo().get(childPosition);
    }


    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        ViewHolder2 viewHolder2 = null;
        if (null == convertView) {
            convertView = inflate.inflate(R.layout.adapter_item_content_new,
                    null);
            viewHolder2 = new ViewHolder2();
            viewHolder2.content = (TextView) convertView
                    .findViewById(R.id.tv_shopname);
            viewHolder2.tvShopPrice = (TextView) convertView
                    .findViewById(R.id.tv_shop_price);
            viewHolder2.ibAdd = (ImageView) convertView
                    .findViewById(R.id.ib_add);
            viewHolder2.ivReduce = (ImageView) convertView
                    .findViewById(R.id.ib_reduce);
            viewHolder2.llAdreduce = (LinearLayout) convertView
                    .findViewById(R.id.ll_adreduce);
            viewHolder2.tvCount = (TextView) convertView
                    .findViewById(R.id.tv_count);
            viewHolder2.llCheck = (LinearLayout) convertView
                    .findViewById(R.id.ll_check);
            viewHolder2.rlGostore = (RelativeLayout) convertView
                    .findViewById(R.id.rl_gostore);
            viewHolder2.ivImageview = (ImageView) convertView
                    .findViewById(R.id.iv_imageview);
            convertView.setTag(viewHolder2);
        } else {
            viewHolder2 = (ViewHolder2) convertView.getTag();
        }

//        ImageLoader.getInstance().displayImage(
//                (String) getChildData(groupPosition, childPosition).get(
//                        "drugimg"), viewHolder2.ivImageview, options);


        // if (flagAdd) {
        // viewHolder2.llAdreduce.setVisibility(View.VISIBLE);
        // viewHolder2.tvCount.setVisibility(View.GONE);
        // } else {
        // viewHolder2.llAdreduce.setVisibility(View.GONE);
        // viewHolder2.tvCount.setVisibility(View.VISIBLE);
        // }
        // // 下架否
        // if ("3".equals(contentMap.get("status"))) {
        // if (flagAdd) {
        // viewHolder2.llCheck.setVisibility(View.VISIBLE);
        // } else {
        // viewHolder2.llCheck.setVisibility(View.INVISIBLE);
        // }
        // viewHolder2.tvShopPrice.setText("商品失效");
        // viewHolder2.tvShopPrice.setTextColor(context.getResources()
        // .getColor(R.color.bg_white));
        // viewHolder2.tvShopPrice.setBackgroundColor(0xffD4D4D4);
        // } else if ("2".equals(contentMap.get("status"))) {
        // viewHolder2.llCheck.setVisibility(View.VISIBLE);
        viewHolder2.tvShopPrice.setText("¥"
                + getChildData(groupPosition, childPosition).getPrice());
//         viewHolder2.tvShopPrice.setBackgroundColor(0xfff8f8f8);
//         viewHolder2.tvShopPrice.setTextColor(context.getResources()
//         .getColor(R.color.text_yellow));

        viewHolder2.tvCount.setText("×" + getChildData(groupPosition, childPosition).getNum());

        viewHolder2.llCheck.setSelected(getChildData(groupPosition, childPosition).isSelect());
        // viewHolder2.llCheck.setTag(position);
//        viewHolder2.llCheck.setOnClickListener(new SelectClick(groupPosition, childPosition));
        // String sNum = (String) contentMap.get("num");
        // viewHolder2.tvDrugcount.setText(sNum);
        // if (!TextUtils.isEmpty(sNum)) {
        // if (Integer.parseInt(sNum) == 1) {
        // viewHolder2.ivReduce
        // .setBackgroundResource(R.drawable.btn_reduce_later);
        // } else {
        // viewHolder2.ivReduce
        // .setBackgroundResource(R.drawable.btn_reduce);
        // }
        // }
        // // 绑定数据
//        viewHolder2.content.setText((String) getChildData(groupPosition, childPosition).get("drugname"));
        //
        // viewHolder2.ibAdd.setTag(R.id.tag_second, viewHolder2.tvDrugcount);
        // viewHolder2.ibAdd.setTag(R.id.tag_third, contentMap);
        //
        // viewHolder2.ivReduce.setTag(R.id.tag_second,
        // viewHolder2.tvDrugcount);
        // viewHolder2.ivReduce.setTag(R.id.tag_third, contentMap);
        //
        // viewHolder2.ibAdd.setOnClickListener(new OnClick());
        // viewHolder2.ivReduce.setOnClickListener(new OnClick());
        // viewHolder2.ibAdd.setTag(R.id.tag_first, viewHolder2.ivReduce);
        // viewHolder2.ivReduce.setTag(R.id.tag_first, viewHolder2.ivReduce);
        //
        // String did = (String) contentMap.get("did");
        // viewHolder2.rlGostore.setTag(R.id.tag_first, did);
        // viewHolder2.rlGostore.setOnClickListener(selectClick);
        //
        return convertView;
    }

    /**
     * 子项点击
     */
    class SelectClick implements View.OnClickListener {
        private int groupPosition, childPosition;

        public SelectClick(int groupPosition, int childPosition) {
            this.groupPosition = groupPosition;
            this.childPosition = childPosition;
        }

        @Override
        public void onClick(View v) {
            boolean isSelect = getChildData(groupPosition, childPosition).isSelect();
            getChildData(groupPosition, childPosition).setIsSelect(!isSelect);
            v.setSelected(!isSelect);
            if (isCheckAll(groupPosition)) {

            }

        }


    }


    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class ViewHolder1 {
        public LinearLayout llShopNext;
        public TextView tvGetCoubon;
        private TextView tvHeader;
        private LinearLayout ll_total;

    }

    class ViewHolder2 {
        public LinearLayout llCheck;
        private TextView content;
        private TextView tvShopPrice;
        private ImageView ibAdd;
        private TextView tvDrugcount;
        private ImageView ivReduce;
        private LinearLayout llAdreduce;
        private TextView tvCount;
        private RelativeLayout rlGostore;
        private ImageView ivImageview;
    }

    /**
     * 获取子目录数据
     *
     * @param groupPosition
     * @param childPosition
     * @return
     */
    private ShopCartBean.ResultdataBean.DruginfoBean getChildData(int groupPosition,
                                                                  int childPosition) {
        return resultDataList.get(groupPosition).getDruginfo().get(childPosition);
    }

    /**
     * 判断是否全选
     *
     * @param groupPosition
     * @return
     */
    private Boolean isCheckAll(int groupPosition) {
        for (ShopCartBean.ResultdataBean.DruginfoBean drugBean : resultDataList.get(groupPosition).getDruginfo()) {
            if (!drugBean.isSelect()) {
                return false;
            }
        }
        return true;
    }

}
