package com.codecode.urlshortner;

public interface UrlCache {
    void put(String code, String url);
    String get(String code);
}
