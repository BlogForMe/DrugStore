package com.eoe.drugstore.tasks;


/**
 * Created by Administrator on 2017/6/14.
 */

public class HomePresenter implements TaskConstract.Presenter {
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
}
