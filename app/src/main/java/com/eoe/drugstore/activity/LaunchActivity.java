package com.eoe.drugstore.activity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.eoe.drugstore.R;
import com.eoe.drugstore.WebAppInterface;
import com.eoe.drugstore.bean.Token;
import com.eoe.drugstore.net.OkHttpHelper;
import com.eoe.drugstore.net.callback.GenericsCallback;
import com.eoe.drugstore.utils.JsonGenericsSerializator;
import com.eoe.drugstore.utils.SharePreferenceHelper;

import okhttp3.Call;

public class LaunchActivity extends AppCompatActivity {
    private String TAG = getClass().getSimpleName();
    private WebView myWebView;
    private String oUrl = "https://www.oschina.net/action/oauth2/authorize?response_type=code&client_id=N3qGu8ZkRvnWCA9P9ocC&redirect_uri=http://move.pengbo.us/";
    private WebSettings webSettings;
    public static String code;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        myWebView = (WebView) findViewById(R.id.web_view);

        webSettings = myWebView.getSettings();

        //支持JavaScript
//        webSettings.setJavaScriptEnabled(true); // 在 onStop 和 onResume 里分别把 setJavaScriptEnabled() 给设置成 false 和 true 即可

        /**
         *  设置自适应屏幕,两者合用
         */
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); //缩放至屏幕的大小

        /**
         * 缩放操作
         */
        webSettings.setSupportZoom(true);  //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false);//隐藏原生的缩放控件

//        myWebView.setWebChromeClient(new MyWebViewClient());
        myWebView.setWebViewClient(new MyViewClient());


        myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");

//        myWebView.loadUrl(oUrl);
        myWebView.loadUrl("file:///android_asset/java.html");

    }


    public void getToken(View v) {
        String codeUrl = "https://www.oschina.net/action/openapi/token?client_id=N3qGu8ZkRvnWCA9P9ocC&client_secret=VvNt6DJ5BQ3YRqYfl5KSSwn3xR5cILkj&\n" +
                "redirect_uri=http://move.pengbo.us/&code=" + code + "&grant_type=authorization_code";
        OkHttpHelper.get()
                .url(codeUrl)
                .id(100)
                .build()
                .execute(new GenericsCallback<Token>(new JsonGenericsSerializator()) {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(Token response, int id) {
                        SharePreferenceHelper sp = new SharePreferenceHelper(LaunchActivity.this, SharePreferenceHelper.SPFILE);
                        sp.put(SharePreferenceHelper.SP_KEY_TOKEN, response.getAccess_token());
                        String token = String.valueOf(sp.<String>get(SharePreferenceHelper.SP_KEY_TOKEN, ""));
                        Log.i(TAG, token);
                    }
                });
    }


    public void goMainActivity(View v) {
        MainActivity.goMainActiivty(this);
    }

    private class MyViewClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
//            Log.i(TAG, "onPageStarted" + url);
        }

        @Override
        public void onPageCommitVisible(WebView view, String url) {
            super.onPageCommitVisible(view, url);
//            Log.i(TAG, "onPageCommitVisible" + url);
        }

        @Override
        public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
            super.doUpdateVisitedHistory(view, url, isReload);
//            Log.i(TAG, "doUpdateVisitedHistory" + url);

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (url.contains("http://move.pengbo.us/?code=")) {
                code = Uri.parse(url).getQueryParameter("code");
                Log.i(TAG, "onPageFinished " + url + "  " + code);
            }
        }

        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
//            Log.i(TAG, "onLoadResource " + url);
        }
    }


    private class MyWebViewClient extends WebChromeClient {

    }

    @Override
    protected void onStop() {
        super.onStop();
        webSettings.setJavaScriptEnabled(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        webSettings.setJavaScriptEnabled(true);
    }
}
