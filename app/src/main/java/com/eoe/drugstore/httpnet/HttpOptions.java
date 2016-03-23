package com.eoe.drugstore.httpnet;

import android.os.Handler;

/**
 * Created by Jon on 2016/3/6.
 */
public class HttpOptions {

    public  enum Method {
        GET, POST;
    }

    private Method method;
    private Handler uiHandler;

    public HttpOptions(Builder builder) {
        this.method = builder.method;
        this.uiHandler = builder.uiHandler;
    }

    public Method getMethod() {
        return this.method;
    }

    public Handler getUiHandler() {
        return this.uiHandler;
    }

    public static class Builder {
        private Handler uiHandler = null;
        private Method method;


        public Builder requestMethod(Method method) {
            this.method = method;
            return this;
        }

        public Builder uiHandler(Handler handler) {
            this.uiHandler = handler;
            return this;
        }

        public HttpOptions build() {
            return new HttpOptions(this);
        }
    }
}
