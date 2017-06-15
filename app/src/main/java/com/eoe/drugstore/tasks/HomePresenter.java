package com.eoe.drugstore.tasks;


import org.reactivestreams.Subscription;

/**
 * Created by Administrator on 2017/6/14.
 */

public class HomePresenter implements TaskConstract.Presenter {
    TaskConstract.View fragmentView;
    private Subscription mSubscription;

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
    public void loadWerather() {

    }


}
