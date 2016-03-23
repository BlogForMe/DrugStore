package com.eoe.drugstore.httpnet;

import com.google.gson.internal.$Gson$Types;
import com.squareup.okhttp.Callback;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Jon on 2016/3/6.
 */
public abstract class BaseCallBack<T> implements Callback {
    public Type mType;

    static Type getSuperclassTypeParameter(Class<?> subclass) {
        Type superclass = subclass.getGenericSuperclass();
        if (superclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        ParameterizedType parameterized = (ParameterizedType) superclass;
        return $Gson$Types.canonicalize(parameterized.getActualTypeArguments()[0]);
    }


    public BaseCallBack() {
        mType = getSuperclassTypeParameter(getClass());
    }

}
