package biz.weatherjon.www;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import biz.weatherjon.www.tasks.HomePresenter;
import biz.weatherjon.www.tasks.TaskConstract;


/**
 * 首页
 * Created by Administrator on 2016/3/2.
 */
public class HomeFragment extends Fragment implements TaskConstract.View {
    public static final String TAG = "HomeFragment";
    private TaskConstract.Presenter homePresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homePresenter = new HomePresenter(this);

        View root = inflater.inflate(R.layout.fragment_home, null);
//        root.findViewById(R.id.bt_post_weather).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                homePresenter.loadWeather();
//            }
//        });
//        root.findViewById(R.id.bt_get_field).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//               homePresenter.getfield();
//            }
//        });


        return root;
    }


    @Override
    public void setPresenter(TaskConstract.Presenter presenter) {

    }

    @Override
    public void requestTask() {

    }
}
