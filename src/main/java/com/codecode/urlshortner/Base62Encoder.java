package com.codecode.urlshortner;

public class Base62Encoder {
    private static final String Base62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encode(int num) {
        var builder = new StringBuilder();
        while (num > 0) {
            builder.append(Base62.charAt(num % 62));
            num /= 62;
        }
        return builder.reverse().toString();
    }
}
