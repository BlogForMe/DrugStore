package com.eoe.drugstore.net.callback;

/**
 * Created by jon on 17-8-9.
 */

public interface IGenericsSericalizator {
    <T> T transform(String response, Class<T> classOft);
}
