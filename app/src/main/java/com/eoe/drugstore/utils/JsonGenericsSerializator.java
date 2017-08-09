package com.eoe.drugstore.utils;

import com.eoe.drugstore.net.callback.IGenericsSericalizator;
import com.google.gson.Gson;

/**
 * Created by jon on 17-8-9.
 */

public class JsonGenericsSerializator implements IGenericsSericalizator {
    Gson mGson = new Gson();

    @Override
    public <T> T transform(String response, Class<T> classOft) {
        return mGson.fromJson(response, classOft);
    }
}
