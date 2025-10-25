package com.codecode.postgis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeofenceService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> queryGeofences(double lat, double lng) {
        String sql = "SELECT zone_name FROM geofence_zones WHERE ST_Within(ST_SetSRID(ST_MakePoint(?, ?), 4326), geom)";
        return jdbcTemplate.queryForList(sql, new Object[]{lng, lat}, String.class);
    }
}
