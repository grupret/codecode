package com.codecode.postgis;


import com.uber.h3core.H3Core;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class H3IndexService {

    public String getH3Index(double lat, double lng) {
        try {
            return H3Core.newInstance().geoToH3Address(lat, lng, 9);
        } catch (Exception e) {

            throw new RuntimeException("Failed to generate a H3 Sequence");
        }
    }

    public List<String> getKRing(String h3Index, int ringSize) {
        try {
            return com.uber.h3core.H3Core.newInstance().kRing(h3Index, ringSize)
                    .stream().map(hex -> hex).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Unable to compute kRing", e);
        }
    }
}
