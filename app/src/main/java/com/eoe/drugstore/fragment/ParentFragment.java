package com.eoe.drugstore.fragment;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;

import com.eoe.drugstore.bean.BaseBean;
import com.eoe.drugstore.httpnet.HttpOptions;


/**
 * Created by Jon on 2016/3/6.
 */
public class ParentFragment extends BaseFragment {
    protected HttpOptions httpOps;


    @Override
    protected View initView(int resId, ViewGroup parent) {
        httpOps = new HttpOptions.Builder().uiHandler(requestHandler)
                .requestMethod(HttpOptions.Method.POST).build();
        return super.initView(resId, parent);
    }

    @Override
    protected void sendRequest() {

    }

    @Override
    protected void setupRequest(int requestId, int dataType, BaseBean result) {

    }

    @Override
    protected void setupData() {

    }


    @Override
    protected void setupView(View mContainerView) {

    }

    /**
     * Http 请求返回
     */
    Handler requestHandler = new Handler() {
        public void handleMessage(Message msg) {
//			logger.i("requestHandler" + msg.obj.toString());
            BaseBean result = (BaseBean) msg.obj;
//            if (!TextUtils.isEmpty(data)) {
//                HashMap<String, Object> map = (HashMap<String, Object>) JsonParser
//                        .decode(data);
//                if (map == null) {
//                    showMeage("服务器返回格式有误");
//                    return;
//                }
//
//                try {
//                    ArrayList<Map<String, Object>> result = (ArrayList<Map<String, Object>>) map
//                            .get("result");
            setupRequest(msg.arg1, msg.arg2, result);
//                } catch (ClassCastException e) {
//                    e.printStackTrace();
//
//                }
//            }

        }
    };

}
