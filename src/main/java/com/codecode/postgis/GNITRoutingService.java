package com.codecode.postgis;

import org.springframework.stereotype.Service;

@Service
public class GNITRoutingService {

    public String resolveSegment(double lat, double lng) {
        return "segment-" + Math.round(lat * 1000) + "-" + Math.round(lng * 1000);
    }
}
