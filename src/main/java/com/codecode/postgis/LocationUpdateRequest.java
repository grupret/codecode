package com.codecode.postgis;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class LocationUpdateRequest {


    private String vehicleId;
    private double latitude;
    private double longitude;
    private double speed;
    private double bearing;
    private Instant timestamp;


}
