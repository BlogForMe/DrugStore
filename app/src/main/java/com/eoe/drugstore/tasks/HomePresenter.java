package com.eoe.drugstore.tasks;


import android.util.Log;

import com.eoe.drugstore.bean.BaseEntity;
import com.eoe.drugstore.bean.User;
import com.eoe.drugstore.retrofit.RetrofitFactory;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/6/14.
 */

public class HomePresenter implements TaskConstract.Presenter {
    public static final String TAG = "HomePresenter";
    TaskConstract.View fragmentView;

    public HomePresenter(TaskConstract.View fragment) {
        this.fragmentView = fragment;
        fragment.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public void getTask() {
        fragmentView.requestTask();
    }

    @Override
    public void loadWeather() {
        Map<String, String> map = new HashMap<>();
        map.put("id", "123");
        map.put("name", "gesanri");

        Observable observable = RetrofitFactory.getInstance().getUser(map);
        observable.compose(composeFunction).subscribe(new Observer<BaseEntity<User>>() {

            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(BaseEntity<User> value) {
                User user = value.getData();
                Log.i(TAG, "ss" + user.getName() + "  " + user.getName());
//                name.setText("姓名：" + user.getName());
//                age.setText("年龄：" + user.getAge());

            }

//            @Override
//            public void onNext(BaseEntity<User> value) {
//            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });
    }


    ObservableTransformer<Observable, ObservableSource> composeFunction = new ObservableTransformer<Observable, ObservableSource>() {
        @Override
        public ObservableSource apply(Observable observable) {
            return observable.retry(1)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };


}


