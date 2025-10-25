package com.codecode.urlshortner;

public interface UrlRepository {

    void save(String code, String originalUrl);
    String find(String code);
}
