package com.eoe.drugstore;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.eoe.drugstore.activity.MainActivity;

/**
 * Created by jon on 17-9-3.
 */

public class WebAppInterface {
    Context mContext;

    /**
     * Instantiate the interface and set the context
     */
    public WebAppInterface(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * Show a toast from the web page
     */
    @JavascriptInterface
    public void showToast(String toast) {
        Intent intent = new Intent(mContext, MainActivity.class);
        mContext.startActivity(intent);
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }
}

