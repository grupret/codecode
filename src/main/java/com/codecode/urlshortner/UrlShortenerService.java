package com.codecode.urlshortner;

public sealed interface UrlShortenerService permits DefaultUrlShortenerService {
    UrlDto shorten(String originalUrl);

    String expand(String shortUrl);
}
