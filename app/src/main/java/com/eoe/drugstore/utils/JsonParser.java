package com.eoe.drugstore.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {


    public static Map decode(String data) {
        if ((data == null) || (data.equals(""))) {
            return null;
        }
        Map map = null;
        data = data.trim();
        if (data.startsWith("{"))
            try {
                JSONObject jsonObj = new JSONObject(data);
                if (jsonObj != null)
                    map = parserJSONObject(jsonObj);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        else {
        }
        return map;
    }

    private static Map parserJSONObject(JSONObject jsonObject) {
        Map map = null;
        try {
            if (jsonObject != null) {
                map = new HashMap();
                Iterator a = jsonObject.keys();
                while (a.hasNext()) {
                    String str = (String) a.next();
                    Object obj = jsonObject.get(str);
                    if (obj instanceof JSONObject)
                        map.put(str, parserJSONObject((JSONObject) obj));
                    else if (obj instanceof JSONArray)
                        map.put(str, parserJSONArray((JSONArray) obj));
                    else if (obj instanceof String)
                        map.put(str, (String) obj);
                    else if (obj instanceof Long)
                        map.put(str, ((Long) obj).longValue());
                    else if (obj instanceof Double)
                        map.put(str, ((Double) obj).doubleValue());
                    else if (obj instanceof Float)
                        map.put(str, ((Float) obj).floatValue());
                    else if (obj instanceof Integer)
                        map.put(str, ((Integer) obj).intValue());
                    else if (obj instanceof Boolean)
                        map.put(str, ((Boolean) obj).toString());
                }
            }
        } catch (Exception e) {
        }
        return map;
    }

    private static List parserJSONArray(JSONArray jsonArray) {
        List list = null;
        try {
            if (jsonArray != null) {
                list = new ArrayList();
                int len = jsonArray.length();
                for (int i = 0; i < len; ++i) {
                    Map hashMap = new HashMap();
                    Object obj = jsonArray.get(i);
                    String strArrayTag = jsonArray.getString(i);
                    if (obj instanceof JSONObject)
                        list.add(parserJSONObject((JSONObject) obj));
                    else if (obj instanceof JSONArray)
                        list.add(parserJSONArray((JSONArray) obj));
                    else if (obj instanceof String)
                        list.add((String) obj);
                    else if (obj instanceof Long)
                        list.add(((Long) obj).longValue());
                    else if (obj instanceof Double)
                        list.add(((Double) obj).doubleValue());
                    else if (obj instanceof Float)
                        list.add(((Float) obj).floatValue());
                    else if (obj instanceof Integer)
                        list.add(((Integer) obj).intValue());
                    else if (obj instanceof Boolean)
                        list.add(((Boolean) obj).toString());
                }
            }
        } catch (Exception e) {
        }
        return list;
    }
}


