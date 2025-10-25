package com.codecode.postgis;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geoapp")
public class GeoAppController {

    @Autowired
    private GeoAppRepository geoAppRepository;
    @Autowired
    private LocationService locationService;


    @GetMapping("/nearby")
    public List<GeoApp> getNearByPlaces(@RequestParam double lat,
                                        @RequestParam double lng,
                                        @RequestParam(defaultValue = "10000") double radius) {
        System.out.println("lat " + lat + "lng" + lng + "radius" + radius);
        return geoAppRepository.findAllPlaceWithin(lat, lat, radius);
    }

    @GetMapping("/places")
    public List<GeoApp> getAllPlaces() {
        return geoAppRepository.findAll();
    }


    @PostMapping("/places")
    public GeoApp addAPlace(
            @RequestBody GeoAppDto dto
    ) {


        GeometryFactory gf = new GeometryFactory();

        Point location = gf.createPoint((new Coordinate(dto.getLng(), dto.getLat())));
        GeoApp app = new GeoApp();
        app.setName(dto.getName());
        app.setLocation(location);
        return geoAppRepository.save(app);
    }


    @PostMapping("/location")
    public ResponseEntity<Void> updateLocation(@RequestBody LocationUpdateRequest req) {
        locationService.processLocation(req);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/location/{vehicleId}")
    public ResponseEntity<EnrichedLocation> getLocation(@PathVariable String vehicleId) throws NoSuchFieldException {
        EnrichedLocation location = locationService.getLatestLocation(vehicleId);
        if (location == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(location);
    }

    @GetMapping("/route/{vehicleId}")
    public ResponseEntity<List<EnrichedLocation>> getRoute(@PathVariable String vehicleId) {
        List<EnrichedLocation> history = locationService.getRouteHistory(vehicleId);
        if (history.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(history);
    }

    @GetMapping("/nearbyVehicle")
    public ResponseEntity<List<EnrichedLocation>> getNearbyVehicles(
            @RequestParam double lat,
            @RequestParam double lng,
            @RequestParam(defaultValue = "9") int resolution) {
        List<EnrichedLocation> nearby = locationService.getNearbyVehicles(lat, lng, resolution);
        return ResponseEntity.ok(nearby);
    }
}
