package com.eoe.drugstore.net;

import com.google.gson.internal.$Gson$Types;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Administrator on 2017/6/20.
 */

public abstract class GsonResponseHandler<T> implements IResponseHandler {
    Type mType;

    public GsonResponseHandler() {
        Type myClass = getClass().getGenericSuperclass();//获取父类的class对象
        if (myClass instanceof Class) {
            throw new RuntimeException("Missing type parameter");
        }
        ParameterizedType parameter = (ParameterizedType) myClass;
        mType = $Gson$Types.canonicalize(parameter.getActualTypeArguments()[0]);
    }

    public Type getmType() {
        return mType;
    }

    public abstract void onSuccess(int statusCode, T response);


}
