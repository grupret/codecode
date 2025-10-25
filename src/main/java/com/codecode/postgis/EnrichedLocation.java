package com.codecode.postgis;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class EnrichedLocation {
    private String vehicleId;
    private String h3Index;
    private String roadSegmentId;
    private List<String> geofences;
    private double latitude;
    private double longitude;
    private Instant timestamp;
}
