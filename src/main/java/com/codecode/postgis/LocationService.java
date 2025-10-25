package com.codecode.postgis;

import ch.qos.logback.core.util.StringUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    @Autowired
    private H3IndexService h3Service;
    @Autowired
    private GNITRoutingService gnitService;
    @Autowired
    private GeofenceService geofenceService;
    @Autowired
    private VehicleRepository vehicleRepo;



    public void processLocation(LocationUpdateRequest req) {
        String h3 = h3Service.getH3Index(req.getLatitude(), req.getLongitude());
        String roadId = gnitService.resolveSegment(req.getLatitude(), req.getLongitude());
        List<String> zones = geofenceService.queryGeofences(req.getLatitude(), req.getLongitude());

        EnrichedLocation enriched = new EnrichedLocation();
        enriched.setVehicleId(req.getVehicleId());
        enriched.setLatitude(req.getLatitude());
        enriched.setLongitude(req.getLongitude());
        enriched.setTimestamp(req.getTimestamp());
        enriched.setH3Index(h3);
        enriched.setRoadSegmentId(roadId);
        enriched.setGeofences(zones);

        vehicleRepo.saveLatestLocation(enriched);
    }


    public EnrichedLocation getLatestLocation(String vehicleId) throws NoSuchFieldException {

        EnrichedLocation latestLocation = vehicleRepo.getLatestLocation(vehicleId);
        System.out.println(latestLocation);
        return latestLocation;
    }

    public List<EnrichedLocation> getRouteHistory(String vehicleId) {
        return vehicleRepo.getLocationHistory(vehicleId);
    }

    public List<EnrichedLocation> getNearbyVehicles(double lat, double lng, int resolution) {
        String centerHex = h3Service.getH3Index(lat, lng);
        List<String> neighbors = h3Service.getKRing(centerHex, 1); // radius of 1 = immediate hex neighbors
        return vehicleRepo.getAllLocations().stream()
                .filter(loc -> neighbors.contains(loc.getH3Index()))
                .collect(Collectors.toList());
    }

    @PostConstruct
    public void seedData() {
        List<LocationUpdateRequest> samples = List.of(
                new LocationUpdateRequest("V101", 17.3850, 78.4867, 42.5, 90.0, Instant.now().minusSeconds(300)),
                new LocationUpdateRequest("V102", 17.3875, 78.4878, 38.2, 120.0, Instant.now().minusSeconds(240)),
                new LocationUpdateRequest("V103", 17.3891, 78.4882, 41.7, 100.0, Instant.now().minusSeconds(180)),
                new LocationUpdateRequest("V104", 17.3915, 78.4899, 37.0, 75.0, Instant.now().minusSeconds(120)),
                new LocationUpdateRequest("V105", 17.3930, 78.4911, 39.0, 60.0, Instant.now().minusSeconds(60))
        );

        for (LocationUpdateRequest req : samples) {
            processLocation(req);
        }
    }
}
