package com.eoe.drugstore.bean;

/**
 * Created by jon on 17-9-3.
 */

public class Token {
    /**
     * access_token : cee492ec-d643-47d8-8342-66076752d8d2
     * refresh_token : 545eccbc-184f-496f-abc6-d53b38fcd56e
     * uid : 1273137
     * token_type : bearer
     * expires_in : 410319
     */

    private String access_token;
    private String refresh_token;
    private int uid;
    private String token_type;
    private int expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
