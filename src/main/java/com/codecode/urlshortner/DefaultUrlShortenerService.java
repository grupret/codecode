package com.codecode.urlshortner;

import java.util.Optional;

public final class DefaultUrlShortenerService implements UrlShortenerService {


    private final UrlRepository repository;
    private final UrlCache cache;
    private final Base62Encoder encoder;

    public DefaultUrlShortenerService(UrlRepository urlRepository, UrlCache urlCache, Base62Encoder base62Encoder) {
        this.repository = urlRepository;
        this.cache = urlCache;
        this.encoder = base62Encoder;

    }

    @Override
    public UrlDto shorten(String originalUrl) {

        String shortCode = encoder.encode(originalUrl.hashCode());
        repository.save(shortCode, originalUrl);
        cache.put(shortCode, originalUrl);
        return new UrlDto(originalUrl, "https://short.ly" + shortCode);
    }

    @Override
    public String expand(String shortUrl) {
        String code = shortUrl.replace("https://short.ly/", "");
        return Optional.ofNullable(cache.get(code)).or(() -> Optional.ofNullable(repository.find(code)))
                .orElseThrow(() -> new IllegalArgumentException("url Not Found"));
    }
}
