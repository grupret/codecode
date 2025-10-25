package com.codecode.postgis;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class VehicleRepository {

private final Map<String, EnrichedLocation> store = new ConcurrentHashMap<>();
private final Map<String, List<EnrichedLocation>> history = new ConcurrentHashMap<>();


    public void saveLatestLocation(EnrichedLocation loc) {
        store.put(loc.getVehicleId(), loc);
        history.computeIfAbsent(loc.getVehicleId(), k -> new ArrayList<>()).add(loc);
    }

    public EnrichedLocation getLatestLocation(String vehicleId) {
        return store.get(vehicleId);
    }

    public List<EnrichedLocation> getLocationHistory(String vehicleId) {
        return history.getOrDefault(vehicleId, Collections.emptyList());
    }

    public List<EnrichedLocation> getAllLocations() {
        return new ArrayList<>(store.values());
    }



}
