package com.eoe.drugstore.utils;

import com.eoe.drugstore.bean.NetEaseTop;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jon on 17-9-11.
 */

public class NewsJsonUtils {

    /**
     * 将获取到的json转换为新闻列表对象
     *
     * @param res
     * @param value
     * @return
     */
    public static List<NetEaseTop> readJsonNetEaseTops(String res, String value) {
        List<NetEaseTop> beans = new ArrayList<NetEaseTop>();
        try {
            JsonParser parser = new JsonParser();
            JsonObject jsonObj = parser.parse(res).getAsJsonObject();
            JsonElement jsonElement = jsonObj.get(value);
            if (jsonElement == null) {
                return null;
            }
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for (int i = 1; i < jsonArray.size(); i++) {
                JsonObject jo = jsonArray.get(i).getAsJsonObject();
                if (jo.has("skipType") && "special".equals(jo.get("skipType").getAsString())) {
                    continue;
                }
                if (jo.has("TAGS") && !jo.has("TAG")) {
                    continue;
                }

                if (!jo.has("imgextra")) {
                    NetEaseTop news = JsonUtils.deserialize(jo, NetEaseTop.class);
                    beans.add(news);
                }
            }
        } catch (Exception e) {
        }
        return beans;
    }
}
