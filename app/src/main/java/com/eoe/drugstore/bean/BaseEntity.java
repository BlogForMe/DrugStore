package com.eoe.drugstore.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/19.
 */

public class BaseEntity<E> implements Serializable {
    private int code;
    private String message;
    private E data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
