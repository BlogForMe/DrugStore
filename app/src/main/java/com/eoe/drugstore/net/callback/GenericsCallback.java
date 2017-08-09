package com.eoe.drugstore.net.callback;

import java.lang.reflect.ParameterizedType;

import okhttp3.Response;

/**
 * Created by jon on 17-8-9.
 */

public abstract class GenericsCallback<T> extends ICallback<T> {
    IGenericsSericalizator mGenericsSericalizator;

    public GenericsCallback(IGenericsSericalizator mIGenericsSericalizator) {
        this.mGenericsSericalizator = mIGenericsSericalizator;
    }

    @Override
    public T parseNetworkResponse(Response response, int id) throws Exception {
        String string = response.body().string();
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        if (entityClass == String.class) {
            return (T) string;
        }
        T bean = mGenericsSericalizator.transform(string, entityClass);
        return bean;
    }


}
