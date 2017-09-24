package com.eoe.drugstore.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;


import java.lang.reflect.Type;

/**
 * Created by jon on 17-9-12.
 */

public class JsonUtils {
    private static Gson mGson = new Gson();

    public static <T> String serialize(T object) {
        return mGson.toJson(object);
    }

    public static <T> T deserialize(String json, Class<T> clz) {
        return mGson.fromJson(json, clz);
    }

    public static <T> T deserialize(JsonObject json, Class<T> clz) throws JsonSyntaxException {
        return mGson.fromJson(json, clz);
    }

    public static <T> T deserizlize(String json, Type type) {
        return mGson.fromJson(json, type);
    }

}
