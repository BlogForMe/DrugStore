package com.eoe.drugstore.tasks;


import android.util.Log;

import com.eoe.drugstore.retrofit.RetrofitHelper;

import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

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
        Retrofit retrofit = RetrofitHelper.getRetrofit();
        APIService service = retrofit.create(APIService.class);
//        Observable observable = service.getData("DemoServlet");
        Observable observable = service.testGet3();

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        Log.i(TAG, "输出" + s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


}


