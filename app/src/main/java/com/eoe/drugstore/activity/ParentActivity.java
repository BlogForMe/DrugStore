package com.eoe.drugstore.activity;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.eoe.drugstore.httpnet.HttpOptions;
import com.eoe.drugstore.utils.JumpSingleton;


/**
 * Created by ZhangGuanghua on 2016/3/4.
 */

public class ParentActivity extends BaseActivity implements OnClickListener {


    HttpOptions httpOps;
    // SharedPreferences名称
    private static final String SHAREPREFRENCE_NAME = "818MODIFY";
    public static final String FIRST_START_TAG = "firstStartTag";

    protected LayoutInflater inflate;
    protected JumpSingleton jInstalce;


    @Override
    protected void init(int layoutId) {
        super.init(layoutId);
        jInstalce = JumpSingleton.getInstance(mContext);
        httpOps = new HttpOptions.Builder().uiHandler(requestHandler)
                .requestMethod(HttpOptions.Method.POST).build();
        inflate = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);


    }


    public Handler requestHandler = new Handler() {
        public void handleMessage(Message msg) {
            setupRequest(msg.arg1, msg.arg2, msg);
        }
    };

    @Override
    protected void setupView() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void setupData() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void sendRequest() {
        // TODO Auto-generated method stub

    }


    @Override
    protected void onResume() {
        super.onResume();
        // 友盟session的统计
        /*MobclickAgent.onPageStart(this.getClass().getName());
        MobclickAgent.onResume(this);*/
    }

    public void onPause() {
        super.onPause();
        // 友盟session的统计
//        MobclickAgent.onPageEnd(this.getClass().getName());
//        MobclickAgent.onPause(this);

    }


    @Override
    protected void setupRequest(int requestId, int dataType,
                                Message msg) {
        // TODO Auto-generated method stub

    }

    protected Boolean isLogin(String loginName, String uid) {
        SharedPreferences sp = mContext.getSharedPreferences(loginName, 0);
        String hUid = sp.getString(uid, "");
        if (TextUtils.isEmpty(hUid)) {
            return false;
        }
        return true;

    }

    protected void setSharePreference(String loginName, String uid,
                                      String logincode, String userName, String loginType) {
        SharedPreferences sp = getSharedPreferences(loginName, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("uid", uid);
        editor.putString("logincode", logincode);
        editor.putString("username", userName);
        editor.putString("loginType", loginType);
        editor.commit();

    }


    // 共同 读取共享数据 String类型值
    protected String getComSharePreference(String key) {
        SharedPreferences sp = getSharedPreferences(SHAREPREFRENCE_NAME,
                MODE_PRIVATE);
        String hUid = sp.getString(key, "");
        return hUid;
    }

    // 共同 存储共享数据 String类型值
    protected void setComSharePreference(String key, String value) {
        SharedPreferences sp = getSharedPreferences(SHAREPREFRENCE_NAME,
                MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
    }

    // 共同 读取共享数据 Integer类型值
    protected Integer getComSharePreferenceInt(String key) {
        SharedPreferences sp = getSharedPreferences(SHAREPREFRENCE_NAME,
                MODE_PRIVATE);
        Integer hUid = sp.getInt(key, 0);

        return hUid;
    }

    // 共同 存储共享数据 Integer类型值
    protected void setComSharePreference(String key, Integer value) {
        SharedPreferences sp = getSharedPreferences(SHAREPREFRENCE_NAME,
                MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    protected void setAddressSharePreference(String address, String aid) {
        SharedPreferences sp = getSharedPreferences(address, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("aid", aid);
        editor.commit();

    }

    protected String getAddressSharePreference(String address, String aid) {
        SharedPreferences sp = getSharedPreferences(address,
                MODE_APPEND);
        String s = sp.getString(aid, "");
        return s;
    }

    protected String getLoginSharePreference(String loginName, String key) {
        SharedPreferences sp = getSharedPreferences(loginName,
                MODE_APPEND);
        String s = sp.getString(key, "");
        return s;
    }

    // 首次启动状态获取
    protected String getFirstStartSharePreference() {
        SharedPreferences sp = getSharedPreferences(SHAREPREFRENCE_NAME,
                MODE_PRIVATE);
        String hUid = sp.getString(FIRST_START_TAG, "");
        return hUid;
    }

    // 首次启动状态存储
    protected void setFirstStartSharePreference(String value) {
        SharedPreferences sp = getSharedPreferences(SHAREPREFRENCE_NAME,
                MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(FIRST_START_TAG, value);
        editor.commit();
    }



   /* protected Handler requestHandlerlong = new Handler() {
        public void handleMessage(Message msg) {
            // logger.i("requestHandler" + msg.obj.toString());
            String data = msg.obj.toString();
            if (!TextUtils.isEmpty(data)) {
                HashMap<String, Object> map = (HashMap<String, Object>) JsonParser
                        .decode(data);
                if (map == null) {
                    showMsg("服务器返回格式有误");
                    return;
                }
                ArrayList<HashMap<String, Object>> result = (ArrayList<HashMap<String, Object>>) map
                        .get("result");

                setupRequest(msg.arg1, msg.arg2, result);
            }

        };
    };*/


  /*protected void setupTopBaseView(String title, boolean isReturn) {
        // TODO Auto-generated method stub
        this.findViewById(R.id.btn_left).setOnClickListener(topListener);
        ((TextView) this.findViewById(R.id.top_title)).setText(title);
        if (!isReturn) {
            this.findViewById(R.id.btn_left).setVisibility(View.INVISIBLE);
        }
    }

      protected void setupTopBaseView(String title, boolean isReturn,
                                    Boolean isRight) {
        this.findViewById(R.id.btn_left).setOnClickListener(topListener);
        ((TextView) this.findViewById(R.id.top_title)).setText(title);
        if (!isReturn) {
            this.findViewById(R.id.btn_left).setVisibility(View.INVISIBLE);
        }
        if (isRight) {
            this.findViewById(R.id.btn_right).setVisibility(View.VISIBLE);
        }
    }

    protected void setupTopBaseView(String title, boolean isReturn,
                                    String rightName, Boolean isRight) {
        this.findViewById(R.id.btn_left).setOnClickListener(topListener);

        ((TextView) this.findViewById(R.id.top_title)).setText(title);
        ((TextView) this.findViewById(R.id.btn_right)).setText(rightName);

        if (!isReturn) {
            this.findViewById(R.id.btn_left).setVisibility(View.INVISIBLE);
        }
        if (isRight) {
            this.findViewById(R.id.btn_right).setVisibility(View.VISIBLE);
        }
    }

    OnClickListener topListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };*/

   /*protected void setupBottomBaseView(int tabindex) {

        RelativeLayout rlTab1 = (RelativeLayout) findViewById(R.id.rl_tab1);
        RelativeLayout rlTab2 = (RelativeLayout) findViewById(R.id.rl_tab2);
        RelativeLayout rlTab3 = (RelativeLayout) findViewById(R.id.rl_tab3);
        RelativeLayout rlTab4 = (RelativeLayout) findViewById(R.id.rl_tab4);
        RelativeLayout rlTab5 = (RelativeLayout) findViewById(R.id.rl_tab5);
        RelativeLayout[] rlArray = new RelativeLayout[] { rlTab1, rlTab2,
                rlTab3, rlTab4, rlTab5 };
        for (int i = 0; i < 5; i++) {
            rlArray[i].setOnClickListener(baseListener);
            if (i == tabindex) {
                rlArray[i].setSelected(true);
            } else {
                rlArray[i].setSelected(false);
            }
        }

    }

    OnClickListener baseListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()) {
                case R.id.rl_tab1:
                    if (mContext instanceof Tab1Activity) {
                        return;
                    } else {
                        intent = new Intent(mContext, Tab1Activity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                    break;
                case R.id.rl_tab2:
                    if (mContext instanceof CommunityHomePageActivity) {
                        return;
                    }

                    if (isLogin("login", "uid")) {
                        intent = new Intent(mContext, CommunityHomePageActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    } else {
                        jumpNextpage(LoginActivity.class, false);
                    }



                    break;
                case R.id.rl_tab3:
                    Constants.userid = getLoginSharePreference("login", "uid");
                    Constants.username = getLoginSharePreference("login",
                            "username");
                    // 到小能
                    XiaoNengUtil.openChat(mContext, "0", "0", "", "", "", "");
                    break;
                case R.id.rl_tab4:
                    if (mContext instanceof Tab4Activity) {
                        return;
                    }
                    if (isLogin("login", "uid")) {
                        intent = new Intent(mContext, Tab4Activity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    } else {
                        jumpNextpage(LoginActivity.class, false);
                    }
                    break;
                case R.id.rl_tab5:
                    if (mContext instanceof Tab5Activity) {
                        return;
                    }
                    if (isLogin("login", "uid")) {
                        intent = new Intent(mContext, Tab5Activity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    } else {
                        jumpNextpage(LoginActivity.class, false);
                    }
                    break;

            }

        }
    };*/

    public void showMsg(String object) {
        Toast.makeText(this, object, Toast.LENGTH_SHORT).show();

    }

   /* public void showToastIcon(String msg) {
        View toastRoot = getLayoutInflater().inflate(R.layout.toast_icon, null);
        TextView message = (TextView) toastRoot.findViewById(R.id.message);
        message.setText(msg);
        Toast toastStart = new Toast(this);
        // toastStart.setGravity(Gravity.BOTTOM, 0, 10);
        toastStart.setGravity(Gravity.CENTER, 0, 0);
        toastStart.setDuration(Toast.LENGTH_LONG);
        toastStart.setView(toastRoot);
        toastStart.getView().getBackground().setAlpha(127);
        toastStart.show();
    }*/

    /*public void showToast(String msg, int timeLong) {
        View toastRoot = getLayoutInflater().inflate(R.layout.toast, null);
        TextView message = (TextView) toastRoot.findViewById(R.id.message);
        message.setText(msg);
        Toast toastStart = new Toast(this);
        toastStart.setGravity(Gravity.CENTER, 0, 0);
        toastStart.setDuration(timeLong);
        toastStart.setView(toastRoot);
        toastStart.getView().getBackground().setAlpha(127);
        toastStart.show();
    }*/

    /*boolean exitFlag = false;

    Timer timer = new Timer();

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            if ((mContext instanceof Tab1Activity)
                    || (mContext instanceof CommunityHomePageActivity)
                    || (mContext instanceof ChatActivity)
                    || (mContext instanceof Tab4Activity)
                    || (mContext instanceof Tab5Activity)) {
                 退出前处理
                if (exitFlag) {
                    mController.appExit();
                } else {
                    exitFlag = true;
                    showMsg("再按一次返回退出");

                    TimerTask task = new TimerTask() {

                        @Override
                        public void run() {
                            exitFlag = false;

                        }
                    };
                    timer.schedule(task, 1500);
                }
            } else {
                finish();
            }

        }
        return false;
    }*/

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

    }


}
